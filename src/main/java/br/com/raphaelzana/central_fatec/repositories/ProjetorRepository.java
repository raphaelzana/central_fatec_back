package br.com.raphaelzana.central_fatec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.raphaelzana.central_fatec.domain.Projetor;

@Repository
public interface ProjetorRepository extends JpaRepository<Projetor, Integer>{

}
