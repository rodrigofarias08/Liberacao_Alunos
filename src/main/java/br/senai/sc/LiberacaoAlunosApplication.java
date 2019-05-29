package br.senai.sc;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import br.senai.sc.domain.Administrador;
import br.senai.sc.domain.Aluno;
import br.senai.sc.domain.Guarda;
import br.senai.sc.domain.Professor;
import br.senai.sc.domain.RegistroEntrada;
import br.senai.sc.domain.RegistroSaida;
import br.senai.sc.domain.Responsavel;
import br.senai.sc.domain.Turma;
import br.senai.sc.domain.enums.Periodo;
import br.senai.sc.repositories.AdministradorRepository;
import br.senai.sc.repositories.AlunoRepository;
import br.senai.sc.repositories.GuardaRepository;
import br.senai.sc.repositories.ProfessorRepository;
import br.senai.sc.repositories.RegistroEntradaRepository;
import br.senai.sc.repositories.RegistroSaidaRepository;
import br.senai.sc.repositories.ResponsavelRepository;
import br.senai.sc.repositories.TurmaRepository;
import br.senai.sc.repositories.UserRepository;

@SpringBootApplication
public class LiberacaoAlunosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiberacaoAlunosApplication.class, args);
	}

	@Autowired
	private UserRepository userR;
	
	@Autowired
	private ProfessorRepository profR;
	
	@Autowired
	private AdministradorRepository adminR;
	
	@Autowired
	private GuardaRepository guardaR;
	
	@Autowired
	private RegistroSaidaRepository regSaidaR;

	@Autowired
	private AlunoRepository alunoR;

	@Autowired
	private RegistroEntradaRepository regEntradaR;

	@Autowired
	private TurmaRepository turmaR;
	
	@Autowired
	private ResponsavelRepository responsavelR;

	@Override
	public void run(String... args) throws Exception {

		ClassPathResource zed = new ClassPathResource("image/zed-classic.png");// transformando a imagem em uma variável
		byte[] arrayPic = new byte[(int) zed.contentLength()];// Não tenho certeza o porque disso tudo
		zed.getInputStream().read(arrayPic);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// date format para data e hora.
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm");// date format para data e hora.

		Administrador admin1 = new Administrador(null, "Admin João da Silva", "joao@gmail.com", "12345", true);
		Administrador admin2 = new Administrador(null, "Admin Manoel Heleno", "manuel@gmail.com", "12345", true);
		Administrador admin3 = new Administrador(null, "Admin Helena Filha", "helena@gmail.com", "12345", false);

		admin1.getTelefones().add("(48)999887766");

		Guarda guarda1 = new Guarda(null, "Guarda João da Silva", "joao@gmail.com", "12345", true);
		Guarda guarda2 = new Guarda(null, "Guarda Manoel Heleno", "manuel@gmail.com", "12345", true);
		Guarda guarda3 = new Guarda(null, "Guarda Helena Filha", "helena@gmail.com", "12345", false);

		Professor prof1 = new Professor(null, "Professor João da Silva", "joao@gmail.com", "12345", true);
		Professor prof2 = new Professor(null, "Professor Manoel Heleno", "manuel@gmail.com", "12345", true);
		Professor prof3 = new Professor(null, "Professor Helena Filha", "helena@gmail.com", "12345", false);
		
		
		Turma turma1 = new Turma(null, "Desenvolvimento de Sistemas","3o","2019/01",Periodo.MATUTINO);
		Turma dependencia = new Turma(null, "Lógica","2o","2019/01",Periodo.VESPERTINO);
				
		
		Aluno aluno = new Aluno(null, "Marcio", "11112520909", null);
		aluno.getTelefones().add("888776655");

		turma1.getAlunos().add(aluno);
		aluno.getTurmas().add(turma1);
		aluno.getTurmas().add(dependencia);
		
		RegistroSaida regs1 = new RegistroSaida(null, "Obs", stf.parse("19:26"), sdf.parse("25/04/2019"), false, true,
				false, false, false, false, true, true, admin1, aluno);
		admin1.getRegistros_saidas().add(regs1);
		aluno.getRegistros_saidas().add(regs1);
		regs1.getProfessores().add(prof1);
		prof1.getRegistros_saidas().add(regs1);

		RegistroEntrada regE1 = new RegistroEntrada(null, "obs", stf.parse("20:44"), sdf.parse("25/04/2019"), false,
				true, false, false, false, false, true, true, admin1, aluno);
		admin1.getRegistros_entradas().add(regE1);
		aluno.getRegistros_entradas().add(regE1);
		prof1.getRegistros_entradas().add(regE1);
		regE1.getProfessores().add(prof1);
		
		Responsavel respon1 = new Responsavel(null, "pai", "pai@hotmail.com", aluno);
		respon1.getTelefones().add("999999999");
		aluno.getResponsaveis().add(respon1);

		adminR.save(admin1);
		adminR.save(admin2);
		adminR.save(admin3);

		guardaR.save(guarda1);
		guardaR.save(guarda2);
		guardaR.save(guarda3);

		profR.save(prof1);
		profR.save(prof2);
		profR.save(prof3);

		alunoR.save(aluno);
		turmaR.save(turma1);
		turmaR.save(dependencia);

		regEntradaR.save(regE1);
		regSaidaR.save(regs1);
		
		responsavelR.save(respon1);
	}

}
