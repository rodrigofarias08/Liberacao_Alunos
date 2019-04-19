package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
