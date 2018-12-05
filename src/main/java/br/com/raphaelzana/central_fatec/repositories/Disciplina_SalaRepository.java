package br.com.raphaelzana.central_fatec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Curso;
import br.com.raphaelzana.central_fatec.domain.Disciplina_Sala;
import br.com.raphaelzana.central_fatec.domain.Disciplina_SalaPK;

@Repository
public interface Disciplina_SalaRepository extends JpaRepository<Disciplina_Sala, Integer>{
	
	@Transactional(readOnly=true)
	Disciplina_Sala findById(Disciplina_SalaPK dspk);
	
	@Transactional(readOnly=true)
	Disciplina_Sala deleteById(Disciplina_SalaPK dspk);
	
	@Transactional(readOnly=true)
	List<Disciplina_Sala> findById_CursoAndSemestre(Curso curso, Integer semestre);

}
