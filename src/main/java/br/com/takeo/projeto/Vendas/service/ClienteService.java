package br.com.takeo.projeto.Vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.takeo.projeto.Vendas.model.Cliente;
import br.com.takeo.projeto.Vendas.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		clienteRepository.persistir(cliente);
	}

	private void validarCliente(Cliente cliente) {
		//valida Cliente
	}
	
}
