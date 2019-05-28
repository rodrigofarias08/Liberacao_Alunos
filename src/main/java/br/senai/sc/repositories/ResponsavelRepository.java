package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer>{

}
