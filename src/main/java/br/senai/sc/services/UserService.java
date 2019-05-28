package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.User;
import br.senai.sc.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User findById(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public void insert(User obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(User obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}
