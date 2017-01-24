package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	//End points
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteCadastrado = this.clienteService.cadastrar(cliente);
		
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarClientes(){
		
		Collection<Cliente> todosClientes = this.clienteService.buscarTodos();
		
		return new ResponseEntity<>(todosClientes, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
		
		Cliente clienteEncontrado = this.clienteService.buscarPorId(id);
		
		if(clienteEncontrado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		this.clienteService.excluir(clienteEncontrado);
		
		return new ResponseEntity<>(HttpStatus.OK);
				
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteAlterado =this.clienteService.alterar(cliente);
		
		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
		
	}

	
}
