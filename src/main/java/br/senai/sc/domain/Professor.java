package br.senai.sc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Professor extends User implements Serializable{
	private static final long serialVersionUID = 1L;

	public Professor() {
		super();
	}

	public Professor(Integer id, String nome, String email, String senha, boolean ativo) {
		super(id, nome, email, senha, ativo);
	}
	
	

}
