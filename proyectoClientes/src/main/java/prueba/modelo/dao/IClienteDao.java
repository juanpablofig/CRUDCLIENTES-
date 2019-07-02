package prueba.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prueba.modelo.ClienteVO;


@Repository
public interface IClienteDao extends JpaRepository<ClienteVO, String>{

	
	public ClienteVO findByNombres(String nombres);
}
