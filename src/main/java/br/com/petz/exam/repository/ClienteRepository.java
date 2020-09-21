package br.com.petz.exam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.exam.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByCpf(String cpf);
	
	Optional<Cliente> findByCnpj(String cnpj);

	Optional<Cliente> findByEmail(String email);
	
	Long countByEmail(String email);
	
}

