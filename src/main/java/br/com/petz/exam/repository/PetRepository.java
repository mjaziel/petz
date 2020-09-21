package br.com.petz.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.exam.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
	Long countByRga(String rga);

}
