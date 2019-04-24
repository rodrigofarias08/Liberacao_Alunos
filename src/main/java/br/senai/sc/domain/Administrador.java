package br.senai.sc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Administrador extends User implements Serializable{
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}

	public Administrador(Integer id, String nome, String email, String senha, boolean ativo) {
		super(id, nome, email, senha, ativo);
	}
	
}
