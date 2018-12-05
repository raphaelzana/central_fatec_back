package br.com.raphaelzana.central_fatec.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.raphaelzana.central_fatec.domain.Reserva;
import br.com.raphaelzana.central_fatec.domain.enums.PeriodoCurso;
import br.com.raphaelzana.central_fatec.repositories.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository repo;
	
	public Reserva find(Integer id) {
		Optional<Reserva> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Reserva> findList(Date data, PeriodoCurso periodo, Integer aula) {
		return repo.findByDataAndPeriodoAndAula(data, periodo.getId(), aula);
	}
	
	public List<Reserva> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Reserva insert(Reserva obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	/*public Reserva update(Reserva obj) {
		Reserva newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}*/
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	/*private void updateData(Reserva newObj, Reserva obj) {
		
	}*/
	
}
