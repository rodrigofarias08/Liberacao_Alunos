package br.senai.sc.model;

import javax.persistence.Entity;

@Entity
public class Professor extends User {
	private static final long serialVersionUID = 1L;

	public Professor() {
		super();
	}

	public Professor(Integer id, String nome, String email, String senha, boolean ativo) {
		super(id, nome, email, senha, ativo);
	}

}