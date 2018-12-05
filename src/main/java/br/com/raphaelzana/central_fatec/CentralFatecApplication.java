package br.com.raphaelzana.central_fatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.raphaelzana.central_fatec.domain.Curso;
import br.com.raphaelzana.central_fatec.domain.Disciplina;
import br.com.raphaelzana.central_fatec.domain.Disciplina_Sala;
import br.com.raphaelzana.central_fatec.domain.Sala;
import br.com.raphaelzana.central_fatec.domain.Usuario;
import br.com.raphaelzana.central_fatec.domain.enums.Perfil;
import br.com.raphaelzana.central_fatec.domain.enums.PeriodoCurso;
import br.com.raphaelzana.central_fatec.repositories.CursoRepository;
import br.com.raphaelzana.central_fatec.repositories.DisciplinaRepository;
import br.com.raphaelzana.central_fatec.repositories.Disciplina_SalaRepository;
import br.com.raphaelzana.central_fatec.repositories.SalaRepository;
import br.com.raphaelzana.central_fatec.repositories.UsuarioRepository;


@SpringBootApplication
public class CentralFatecApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private Disciplina_SalaRepository disciplina_salaRepository;
	
	/*@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private ProjetorRepository projetorRepository;
	*/
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public static void main(String[] args) {
		SpringApplication.run(CentralFatecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario adm = new Usuario(null, "admin", pe.encode("admin"));
		adm.addPerfil(Perfil.ADMIN);
		usuarioRepository.save(adm);
		
		Usuario aluno= new Usuario(null, "aluno", pe.encode("aluno"));
		aluno.addPerfil(Perfil.ALUNO);
		usuarioRepository.save(aluno);
		
		Usuario prof = new Usuario(null, "professor", pe.encode("professor"));
		prof.addPerfil(Perfil.PROFESSOR);
		usuarioRepository.save(prof);
		
		Curso adsN = new Curso(null, "Análise e Desenvolvimento de Sistemas", PeriodoCurso.NOITE, 8);
		cursoRepository.save(adsN);
		Curso adsT = new Curso(null, "Análise e Desenvolvimento de Sistemas", PeriodoCurso.TARDE, 6);
		cursoRepository.save(adsT);
		Curso piN = new Curso(null, "Produção Industrial", PeriodoCurso.NOITE, 6);
		cursoRepository.save(piN);
		Curso piM = new Curso(null, "Produção Industrial", PeriodoCurso.MANHA, 6);
		cursoRepository.save(piM);
		Curso agroN = new Curso(null, "Agronegócio", PeriodoCurso.NOITE, 6);
		cursoRepository.save(agroN);
		Curso agroT = new Curso(null, "Agronegócio", PeriodoCurso.TARDE, 6);
		cursoRepository.save(agroT);
		Curso siM = new Curso(null, "Sistemas para Internet", PeriodoCurso.MANHA, 6);
		cursoRepository.save(siM);
		Curso ge = new Curso(null, "Gestão Empresarial", PeriodoCurso.NOITE, 4);
		cursoRepository.save(ge);
		
		Disciplina les = new Disciplina(null, "Laboratório de Engenharia de Software");
		disciplinaRepository.save(les);
		
		Disciplina pla = new Disciplina(null, "Programação Linear e Aplicações");
		disciplinaRepository.save(pla);
		
		Disciplina ingles1 = new Disciplina(null, "Inglês I");
		disciplinaRepository.save(ingles1);
		
		Disciplina ingles2 = new Disciplina(null, "Inglês II");
		disciplinaRepository.save(ingles2);
		
		Disciplina ingles3 = new Disciplina(null, "Inglês III");
		disciplinaRepository.save(ingles3);
		
		Disciplina ingles4 = new Disciplina(null, "Inglês IV");
		disciplinaRepository.save(ingles4);
		
		Disciplina ingles5 = new Disciplina(null, "Inglês V");
		disciplinaRepository.save(ingles5);
		
		Disciplina ingles6 = new Disciplina(null, "Inglês VI");
		disciplinaRepository.save(ingles6);
		
		Disciplina si = new Disciplina(null, "Sistemas de Informação");
		disciplinaRepository.save(si);
		
		Disciplina admi = new Disciplina(null, "Administração Geral");
		disciplinaRepository.save(admi);
		
		Disciplina alp = new Disciplina(null, "Algoritmos e Lógica de Programação");
		disciplinaRepository.save(alp);
		
		Disciplina aoc = new Disciplina(null, "Arquitetura e Organização de Computadores");
		disciplinaRepository.save(aoc);
		
		Disciplina ce = new Disciplina(null, "Comunicação e Expressão");
		disciplinaRepository.save(ce);
		
		Disciplina md = new Disciplina(null, "Matemática Discreta");
		disciplinaRepository.save(md);
		
		Disciplina pmi = new Disciplina(null, "Programação em Microinformática");
		disciplinaRepository.save(pmi);
		
		Disciplina calc = new Disciplina(null, "Cálculo");
		disciplinaRepository.save(calc);
		
		Disciplina cont = new Disciplina(null, "Contabilidade");
		disciplinaRepository.save(cont);
		
		Disciplina es = new Disciplina(null, "Engenharia de Software I");
		disciplinaRepository.save(es);
		
		Disciplina ea = new Disciplina(null, "Estatística Aplicada");
		disciplinaRepository.save(ea);
		
		Disciplina lh = new Disciplina(null, "Laboratório de Hardware");
		disciplinaRepository.save(lh);
		
		Disciplina lp = new Disciplina(null, "Linguagem de Programação");
		disciplinaRepository.save(lp);
		
		Disciplina ps = new Disciplina(null, "Programação de Scripts");
		disciplinaRepository.save(ps);
		
		Disciplina so = new Disciplina(null, "Sistemas Operacionais I");
		disciplinaRepository.save(so);
		
		Disciplina bd = new Disciplina(null, "Banco de Dados");
		disciplinaRepository.save(bd);
		
		Disciplina ef = new Disciplina(null, "Economia e Finanças");
		disciplinaRepository.save(ef);
		
		Disciplina es2 = new Disciplina(null, "Engenharia de Software II");
		disciplinaRepository.save(es2);
		
		Disciplina ed = new Disciplina(null, "Estruturas de Dados");
		disciplinaRepository.save(ed);
		
		Disciplina ihc = new Disciplina(null, "Interação Humano Computador");
		disciplinaRepository.save(ihc);
		
		Disciplina pw = new Disciplina(null, "Programação Web");
		disciplinaRepository.save(pw);
		
		Disciplina so2 = new Disciplina(null, "Sistemas Operacionais II");
		disciplinaRepository.save(so2);
		
		Disciplina es3 = new Disciplina(null, "Engenharia de Software III");
		disciplinaRepository.save(es3);
		
		Disciplina gp = new Disciplina(null, "Gerência de Projetos");
		disciplinaRepository.save(gp);
		
		Disciplina lbd = new Disciplina(null, "Laboratório de Banco de Dados");
		disciplinaRepository.save(lbd);
		
		Disciplina poo = new Disciplina(null, "Programação Orientada a Objetos");
		disciplinaRepository.save(poo);
		
		Disciplina pbd = new Disciplina(null, "Programação para Banco de Dados");
		disciplinaRepository.save(pbd);
		
		Disciplina rc = new Disciplina(null, "Redes de Computadores");
		disciplinaRepository.save(rc);
		
		Disciplina segi = new Disciplina(null, "Segurança da Informação");
		disciplinaRepository.save(segi);
		
		Disciplina st = new Disciplina(null, "Sociedade e Tecnologia");
		disciplinaRepository.save(st);

		Disciplina ee = new Disciplina(null, "Empreendedorismo");
		disciplinaRepository.save(ee);
		
		Disciplina geq = new Disciplina(null, "Gestão de Equipes");
		disciplinaRepository.save(geq);
		
		Disciplina mp = new Disciplina(null, "Metodologia da Pesquisa Científico-Tecnológica");
		disciplinaRepository.save(mp);
		
		Disciplina tei = new Disciplina(null, "Tópicos Especiais em Informática");
		disciplinaRepository.save(tei);
		
		Disciplina as = new Disciplina(null, "Auditoria de Sistemas");
		disciplinaRepository.save(as);
		
		Disciplina erp = new Disciplina(null, "Ética e Responsabilidade Profissional");
		disciplinaRepository.save(erp);
		
		Disciplina gti = new Disciplina(null, "Gestão e Governança de Tecnologia da Informação");
		disciplinaRepository.save(gti);

		Sala lab1 = new Sala(null, "Laboratório de Informática 1", "A1");
		salaRepository.save(lab1);
		Sala lab2 = new Sala(null, "Laboratório de Informática 2", "A1");
		salaRepository.save(lab2);
		Sala lab3 = new Sala(null, "Laboratório de Informática 3", "A1");
		salaRepository.save(lab3);
		Sala lab4 = new Sala(null, "Laboratório de Informática 4", "A1");
		salaRepository.save(lab4);
		Sala sala1 = new Sala(null, "Sala 1", "A1");
		salaRepository.save(sala1);
		Sala sala2 = new Sala(null, "Sala 2", "A1");
		salaRepository.save(sala2);
		Sala sala3 = new Sala(null, "Sala 3", "A1");
		salaRepository.save(sala3);
		Sala sala4 = new Sala(null, "Sala 4", "A1");
		salaRepository.save(sala4);
		Sala sala5 = new Sala(null, "Sala 5", "A1");
		salaRepository.save(sala5);
		Sala sala6 = new Sala(null, "Sala 6", "A1");
		salaRepository.save(sala6);
		Sala sala7 = new Sala(null, "Sala 7", "A1");
		salaRepository.save(sala7);
		Sala sala8 = new Sala(null, "Sala 8", "A1");
		salaRepository.save(sala8);
//		
		
		Disciplina_Sala ds1 = new Disciplina_Sala(pla, piN, sala1, "Terça-Feira", 2, 4);
		disciplina_salaRepository.save(ds1);
		
		Disciplina_Sala ds2 = new Disciplina_Sala(admi, adsN, sala3, "Segunda-Feira", 3, 2);
		disciplina_salaRepository.save(ds2);
		
		Disciplina_Sala ds3 = new Disciplina_Sala(alp, adsN, sala8, "Terça-Feira", 1, 1);
		disciplina_salaRepository.save(ds3);
		
		Disciplina_Sala ds4 = new Disciplina_Sala(aoc, adsN, sala7, "Terça-Feira", 2, 1);
		disciplina_salaRepository.save(ds4);
		
		Disciplina_Sala ds5 = new Disciplina_Sala(ce, adsN, sala4, "Quarta-Feira", 3, 2);
		disciplina_salaRepository.save(ds5);
		
		Disciplina_Sala ds6 = new Disciplina_Sala(ingles1, adsN, sala5, "Quinta-Feira", 1, 3);
		disciplina_salaRepository.save(ds6);
		
		Disciplina_Sala ds7 = new Disciplina_Sala(md, adsN, sala4, "Quinta-Feira", 2, 1);
		disciplina_salaRepository.save(ds7);
		
		Disciplina_Sala ds8 = new Disciplina_Sala(pmi, adsN, lab3, "Sexta-Feira", 1, 1);
		disciplina_salaRepository.save(ds8);
		
		Disciplina_Sala ds9 = new Disciplina_Sala(si, adsN, sala6, "Sexta-Feira", 2, 1);
		disciplina_salaRepository.save(ds9);
		
		Disciplina_Sala ds10 = new Disciplina_Sala(calc, adsN, sala1, "Segunda-Feira", 3, 2);
		disciplina_salaRepository.save(ds10);
		
		Disciplina_Sala ds11 = new Disciplina_Sala(cont, adsN, sala2, "Terça-Feira", 1, 3);
		disciplina_salaRepository.save(ds11);
		
		Disciplina_Sala ds12 = new Disciplina_Sala(es, adsN, lab2, "Terça-Feira", 2, 4);
		disciplina_salaRepository.save(ds12);
		
		Disciplina_Sala ds13 = new Disciplina_Sala(ea, adsN, lab3, "Quarta-Feira", 1, 5);
		disciplina_salaRepository.save(ds13);
		
		Disciplina_Sala ds14 = new Disciplina_Sala(ingles2, adsN, sala6, "Quarta-Feira", 2, 4);
		disciplina_salaRepository.save(ds14);
		
		Disciplina_Sala ds15 = new Disciplina_Sala(lh, adsN, lab4, "Quinta-Feira", 1, 3);
		disciplina_salaRepository.save(ds15);
//		
		Disciplina_Sala ds16 = new Disciplina_Sala(lp, adsN, sala6, "Quinta-Feira", 2, 2);
		disciplina_salaRepository.save(ds16);
		
		Disciplina_Sala ds17 = new Disciplina_Sala(ps, adsN, lab1, "Sexta-Feira", 1, 2);
		disciplina_salaRepository.save(ds17);
		
		Disciplina_Sala ds18 = new Disciplina_Sala(so, adsN, lab2, "Sexta-Feira", 2, 3);
		disciplina_salaRepository.save(ds18);
		
		Disciplina_Sala ds19 = new Disciplina_Sala(bd, adsN, lab4, "Segunda-Feira", 1, 4);
		disciplina_salaRepository.save(ds19);
		
		Disciplina_Sala ds20 = new Disciplina_Sala(ef, adsN, lab4, "Segunda-Feira", 2, 4);
		disciplina_salaRepository.save(ds20);
		
		Disciplina_Sala ds21 = new Disciplina_Sala(es2, adsN, sala3, "Terça-Feira", 1, 5);
		disciplina_salaRepository.save(ds21);
		
		Disciplina_Sala ds22 = new Disciplina_Sala(ed, adsN, sala7, "Quarta-Feira", 1, 3);
		disciplina_salaRepository.save(ds22);
		
		Disciplina_Sala ds27 = new Disciplina_Sala(so2, adsN, lab3, "Quarta-Feira", 2, 4);
		disciplina_salaRepository.save(ds27);
		
		Disciplina_Sala ds23 = new Disciplina_Sala(ingles3, adsN, sala2, "Quinta-Feira", 1, 5);
		disciplina_salaRepository.save(ds23);
		
		Disciplina_Sala ds24 = new Disciplina_Sala(ihc, adsN, lab4, "Quinta-Feira", 2, 3);
		disciplina_salaRepository.save(ds24);
		
		Disciplina_Sala ds25 = new Disciplina_Sala(pla, adsN, sala5, "Sexta-Feira", 1, 6);
		disciplina_salaRepository.save(ds25);
		
		Disciplina_Sala ds26 = new Disciplina_Sala(les, adsN, lab4, "Quinta-Feira", 3, 7);
		disciplina_salaRepository.save(ds26);
		
		Disciplina_Sala ds28 = new Disciplina_Sala(es3, adsN, sala5, "Segunda-Feira", 1, 6);
		disciplina_salaRepository.save(ds28);
		
		Disciplina_Sala ds = new Disciplina_Sala(gti, adsN, sala4, "Terça-Feira", 3, 8);
		disciplina_salaRepository.save(ds);
				
		Disciplina_Sala ds29 = new Disciplina_Sala(erp, adsN, sala6, "Segunda-Feira", 3, 8);
		disciplina_salaRepository.save(ds29);	
		
		Disciplina_Sala ds30 = new Disciplina_Sala(as, adsN, lab1, "Quarta-Feira", 3, 8);
		disciplina_salaRepository.save(ds30);
		
		Disciplina_Sala ds31 = new Disciplina_Sala(ingles6, adsN, lab3, "Quinta-Feira", 3, 8);
		disciplina_salaRepository.save(ds31);
		
		Disciplina_Sala ds32 = new Disciplina_Sala(ee, adsN, sala5, "Terça-Feira", 1, 7);
		disciplina_salaRepository.save(ds32);
		
		Disciplina_Sala ds33 = new Disciplina_Sala(geq, adsN, sala2, "Terça-Feira", 2, 7);
		disciplina_salaRepository.save(ds33);
		
		Disciplina_Sala ds34 = new Disciplina_Sala(mp, adsN, sala1, "Segunda-Feira", 3, 7);
		disciplina_salaRepository.save(ds34);
		
		Disciplina_Sala ds35 = new Disciplina_Sala(tei, adsN, lab4, "Terça-Feira", 3, 7);
		disciplina_salaRepository.save(ds35);
		
		Disciplina_Sala ds36 = new Disciplina_Sala(ingles5, adsN, sala5, "Quarta-Feira", 1, 7);
		disciplina_salaRepository.save(ds36);
		
		Disciplina_Sala ds37 = new Disciplina_Sala(rc, adsN, sala4, "Segunda-Feira", 3, 6);
		disciplina_salaRepository.save(ds37);
		
		Disciplina_Sala ds38 = new Disciplina_Sala(gp, adsN, sala3, "Terça-Feira", 3, 6);
		disciplina_salaRepository.save(ds38);
		
		Disciplina_Sala ds39 = new Disciplina_Sala(ingles4, adsN, lab1, "Quarta-Feira", 1, 6);
		disciplina_salaRepository.save(ds39);
		
		Disciplina_Sala ds40 = new Disciplina_Sala(lbd, adsN, lab3, "Terça-Feira", 3, 5);
		disciplina_salaRepository.save(ds40);
		
		Disciplina_Sala ds41 = new Disciplina_Sala(pbd, adsN, lab4, "Quinta-Feira", 3, 5);
		disciplina_salaRepository.save(ds41);
		
		Disciplina_Sala ds42 = new Disciplina_Sala(st, adsN, sala3, "Segunda-Feira", 3, 5);
		disciplina_salaRepository.save(ds42);
		
		
//		Disciplina_SalaPK dspk = new Disciplina_SalaPK();
//		dspk.setCurso(adsN);
//		dspk.setDisciplina(les);
//		
//		System.out.println(disciplina_salaRepository.findById(dspk).equals(ds));
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		Projetor p1 = new Projetor(null, true, "a");
		projetorRepository.save(p1);
		Reserva res = new Reserva(null, p1, prof, sdf.parse("01-01-2000"), 1, "oi", PeriodoCurso.NOITE);
		
		reservaRepository.save(res);
		
		System.out.println(reservaRepository.findByDataAndPeriodoAndAula(sdf.parse("01-01-2000"), 1, 1).contains(res));
		*/
		
	}
	
}
