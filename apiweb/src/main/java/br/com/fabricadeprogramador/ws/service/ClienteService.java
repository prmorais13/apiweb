package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	// Negocio
	public Cliente cadastrar(Cliente cliente) {
		
		return this.clienteRepository.save(cliente);
	}

	public Collection<Cliente> buscarTodos() {
		return this.clienteRepository.findAll();
	}

	public void excluir(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	public Cliente buscarPorId(Integer id) {
		return this.clienteRepository.findOne(id);
	}

	public Cliente alterar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
}
