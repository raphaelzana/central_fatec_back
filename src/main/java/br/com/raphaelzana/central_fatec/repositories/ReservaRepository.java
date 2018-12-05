package br.com.raphaelzana.central_fatec.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

	@Transactional(readOnly=true)
	List<Reserva> findByDataAndPeriodoAndAula(Date data, Integer periodo, Integer aula);
	
}
