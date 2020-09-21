package br.com.petz.exam;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.petz.exam.model.Cliente;
import br.com.petz.exam.repository.ClienteRepository;

@SpringBootTest
class ExamApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Disabled("testAddCliente is disabled")
	@Test
	public void testAddCliente() throws Exception {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Mauro");
		cliente.setSobrenome("Gualter");
		cliente.setCpf("06503917057");
		cliente.setEmail("mauro.gualter@gmail.com");
		cliente.setSenha("@Petz739");
		cliente.setCriado(LocalDateTime.now());
				
		cliente = this.clienteRepository.save(cliente);

		assertNotNull(cliente.getId());
	}

	@Disabled("testFindByIdCliente disabled")
	@Test
	public void testFindByIdCliente() throws Exception {
		
		Cliente cliente = new Cliente();
		
		cliente = this.clienteRepository.findById(1L).orElseThrow(() -> new Exception("Erro findbyId Cliente"));

		assertNotNull("Marcelo".equals(cliente.getNome()));
	}
	
	@Test
	public void testFindAllCliente() throws Exception {
		
		List<Cliente> clienteList = this.clienteRepository.findAll();
		
		assertTrue(clienteList.size() > 0);
	}
	

}
