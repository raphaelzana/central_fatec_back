package br.com.raphaelzana.central_fatec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.raphaelzana.central_fatec.domain.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{

}
