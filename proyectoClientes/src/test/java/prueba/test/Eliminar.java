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
public class Eliminar {

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
		public void cuandoEliminar1Entonces2Clientes() {
			this.dao.deleteById("1111");
			int largo=this.dao.findAll().size();
			assertTrue("Son " +  largo + "Pero deberia ser 2 ", largo==2);
			System.out.println("EL LARGO " + largo);
		
		}
	 
	 @Test
		public void cuandoEliminarTodosEntonces0Clientes() {
			this.dao.deleteAll();
			int largo=this.dao.findAll().size();
			assertTrue("Son " +  largo + "Pero deberia ser 0 ", largo==0);
			System.out.println("EL LARGO " + largo);
		
		}

}
