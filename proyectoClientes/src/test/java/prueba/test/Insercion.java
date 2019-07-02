package prueba.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import prueba.modelo.ClienteVO;
import prueba.modelo.dao.IClienteDao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Insercion {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	IClienteDao dao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void cuandoAgregarEntoncesTrue() {
		ClienteVO cliente1=new ClienteVO("1111", "juan apablo", "figueroa", "figueroa@gmail.com", "654654");
		this.dao.save(cliente1);
		boolean respuesta=this.dao.existsById("1111");
		
		assertTrue("Si agregar entonces TRUE", respuesta);
		
	}
	
	@Test
	public void cuandoNOAgregarEntoncesFalse() {
		ClienteVO cliente1=new ClienteVO("1111", "juan apablo", "figueroa", "figueroa@gmail.com", "654654");
		this.dao.save(cliente1);
		boolean respuesta=this.dao.existsById("1111");
		
		assertFalse("Si no agregar entonces FALSE", !respuesta);
		
	}
	
	
	
	

}
