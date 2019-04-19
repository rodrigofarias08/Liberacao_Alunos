package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.model.Guarda;

@Repository
public interface GuardaRepository extends JpaRepository<Guarda, Integer>{

}
