package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.TurmaAluno;
import br.senai.sc.repositories.TurmaAlunoRepository;

@Service
public class TurmaAlunoService {

	@Autowired
	private TurmaAlunoRepository repo;
	
	public TurmaAluno findById(Integer id) {
		Optional<TurmaAluno> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<TurmaAluno> findAll(){
		return repo.findAll();
	}
	
	public void insert(TurmaAluno obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(TurmaAluno obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}
