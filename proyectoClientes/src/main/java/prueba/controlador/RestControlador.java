package prueba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import prueba.modelo.ClienteVO;
import prueba.modelo.dao.IClienteDao;

@RestController
public class RestControlador {

	@Autowired
	IClienteDao daocliente;

	@GetMapping("/clientes/")
	public List<ClienteVO> getClientes() {
		List<ClienteVO> listaclientes = daocliente.findAll();
		return listaclientes;
	}

	@GetMapping("/clientes/{rut}")
	public ClienteVO getClienteId(@PathVariable String rut) {
		ClienteVO cliente = daocliente.findById(rut).get();
		return cliente;
	}
	
	@GetMapping("/clientes/buscar/{nombre}")
	public ClienteVO getClienteNombres(@PathVariable String nombre) {
		ClienteVO cliente = daocliente.findByNombres(nombre);
		return cliente;
	}
	
	
	
	//--------------------------AGREGAR----------------

	@PostMapping("/clientes/")
	public boolean agregarCliente(@RequestBody ClienteVO cliente) {

		boolean respuesta = false;
		boolean existe = daocliente.existsById(cliente.getRut());
	

		if (!existe) {
			this.daocliente.save(cliente);
			respuesta = true;
		}
		return respuesta;
	}
	
	//--------------------------EDITAR-------------------------

	@PutMapping("/clientes/")
	public boolean editarCliente(@RequestBody ClienteVO cliente) {
		boolean respuesta = false;
		boolean existe = daocliente.existsById(cliente.getRut());

		if (existe) {
			this.daocliente.save(cliente);
			respuesta = true;
		}
		return respuesta;
	}

	//-----------------------ELIMINAR----------------------------

	@DeleteMapping("/clientes/{rut}")
	public boolean eliminarCliente(@PathVariable String rut) {
		
		boolean existe=daocliente.existsById(rut);
		if(existe) {
			daocliente.deleteById(rut);
			return true;
		}
		return false;
	}

}
