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
public class ListarTodos {

	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	IClienteDao dao;
	
	@Before
	public void setUp() throws Exception {
		ClienteVO cliente1=new ClienteVO("1111", "juan apablo", "figueroa", "figueroa@gmail.com", "654654");
		ClienteVO cliente2=new ClienteVO("2222", "Matias", "Alvares", "matias@gmail.com", "654656");
		ClienteVO cliente3=new ClienteVO("3333", "Jaime", "Rodriguez", "jaime@gmail.com", "987654");
		this.entityManager.persist(cliente1);
		this.entityManager.persist(cliente2);
		this.entityManager.persist(cliente3);
		
	}
	

	@Test
	public void cuandoFindAllEntonces3() {
		int cuantos=this.dao.findAll().size();
		assertTrue("DEBERIAN SER 3 PERO SON : " + cuantos, cuantos==3);
		
	
	}

	

}
