package br.com.petz.exam.service;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenAuthenticationService {
	
	public static void main(String[] args) throws Exception {
		
/*		
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		KeyPair kp = kpg.generateKeyPair();
		
		Key pub = kp.getPublic();
		Key pvt = kp.getPrivate();
*/		
		String pathPrivate = "c:/install/private.key";
/*	
		FileOutputStream out = new FileOutputStream(pathPrivate);
		out.write(pvt.getEncoded());
		out.close();
*/
		String pathPublic = "c:/install/public.pub";
/*
		out = new FileOutputStream(pathPublic);
		out.write(pub.getEncoded());
		out.close();
		
		System.err.println("Private key format: " + pvt.getFormat());
		// prints "Private key format: PKCS#8" on my machine

		System.err.println("Public key format: " + pub.getFormat());
		
*/		
		KeyFactory kf = KeyFactory.getInstance("RSA");
		
		Path path = Paths.get(pathPrivate);
		byte[] encodedPv = Files.readAllBytes(path);
		PKCS8EncodedKeySpec keySpecPv = new PKCS8EncodedKeySpec(encodedPv);
		RSAPrivateKey privateKey = (RSAPrivateKey)kf.generatePrivate(keySpecPv);
		
		path = Paths.get(pathPublic);
		byte[] encodedPb = Files.readAllBytes(path);
		X509EncodedKeySpec keySpecPb = new X509EncodedKeySpec(encodedPb);
		RSAPublicKey publicKey = (RSAPublicKey)kf.generatePublic(keySpecPb);
		
		Algorithm algorithm = Algorithm.RSA256(null, privateKey);
		
		String token = JWT.create()
				.withIssuer("Certisign")
				.withSubject("Login Checkout")
				.withIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
				.withClaim("name", "Thiago")
				.withClaim("contatoNome", "Thiago Costa")
				.withClaim("contatoEmail", "thiago.costa@certisign.com.br")
				.withClaim("contatoCpf", "34448503879")
				.sign(algorithm);
		System.out.println(token);
		
		token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJMb2dpbiBDaGVja291dCIsImFyIjoiQ1JTTlQiLCJwcm9kdXRvIjoiU1JGQTFQRkhWMiIsImlzcyI6IlRlc3RlcyIsImdydXBvIjoiUFVCTEkiLCJvcmlnZW0iOjcsInNraW4iOiJjZXJ0aXNpZ24iLCJpYXQiOjE1NTIzMjQzMDYsInF1YW50aWRhZGUiOjF9.DSrC9UzIea9FMU6MPZVf3pv_tC1XwStkUvSSM4avfbNzlRG6EB1fW2FaWBuo56AU9TMWG9bAms-znci8tcLFB9F26O8XccK6Y3WbmkvVUZnKv8-YI_eaVO2FUWwrniBNh_ke7-2c4bdMjNV8fyXwxk0rXGj_2VzOCOjHvGTjqWqpBbb5OYYkbxQ2rJJB36LdwFhTvtKfOXMLGHHVhDbeVeswzQ7eu3eP7vv6h3OE1vXexOU9riM1ZvlMYRVZX4PHHGFOo7pdxzmvR-IRiIdBR2lwKxYAUSEOA7GR74NPsOe1TwCzOTatMD_7L3H-ui5pX1i1XrJvxZyH6l7YjxLq_A";
		
		algorithm = Algorithm.RSA256(publicKey, null);
		JWT.require(algorithm).build().verify(token);
		
	}


}
