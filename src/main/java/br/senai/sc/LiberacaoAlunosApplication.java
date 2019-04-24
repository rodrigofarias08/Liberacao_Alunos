package br.senai.sc;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import br.senai.sc.domain.Administrador;
import br.senai.sc.domain.Guarda;
import br.senai.sc.domain.Professor;
import br.senai.sc.repositories.UserRepository;

@SpringBootApplication
public class LiberacaoAlunosApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LiberacaoAlunosApplication.class, args);
	}
	
	@Autowired
	private UserRepository userR;

	@Override
	public void run(String... args) throws Exception {
		
		ClassPathResource zed = new ClassPathResource("image/zed-classic.png");//transformando a imagem em uma variável
		byte[] arrayPic = new byte[(int)zed.contentLength()];//Não tenho certeza o porque disso tudo
		zed.getInputStream().read(arrayPic);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");//date format para data e hora.

		Administrador admin1 = new Administrador(null, "Admin João da Silva", "joao@gmail.com", "12345", true);
		Administrador admin2 = new Administrador(null, "Admin Manoel Heleno", "manuel@gmail.com", "12345", true);
		Administrador admin3 = new Administrador(null, "Admin Helena Filha", "helena@gmail.com", "12345", false);
		
		admin1.getTelefones().add("(48)999887766");
		

		Guarda guarda1 = new Guarda(null, "Guarda João da Silva", "joao@gmail.com", "12345", true);
		Guarda guarda2 = new Guarda(null, "Guarda Manoel Heleno", "manuel@gmail.com", "12345", true);
		Guarda guarda3 = new Guarda(null, "Guarda Helena Filha", "helena@gmail.com", "12345", false);

		Professor prof1 = new Professor(null, "Professor Guarda João da Silva", "joao@gmail.com", "12345", true);
		Professor prof2 = new Professor(null, "Professor Guarda Manoel Heleno", "manuel@gmail.com", "12345", true);
		Professor prof3 = new Professor(null, "Professor Guarda Helena Filha", "helena@gmail.com", "12345", false);

		userR.save(admin1);
		userR.save(admin2);
		userR.save(admin3);
		
		userR.save(guarda1);
		userR.save(guarda2);
		userR.save(guarda3);
		
		userR.save(prof1);
		userR.save(prof2);
		userR.save(prof3);
		
	}

}
