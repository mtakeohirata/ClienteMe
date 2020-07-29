package clienteMe.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import clienteMe.model.entity.ClienteEntity;
import clienteMe.model.repository.ClienteRepository;

//RestController annotation determina que sera essa classe que recebera requisicoes REST. Poderiamos usar a annotation @Controller, entretando eu teria que adicionar a annotation @Responsebody a todo metodo, definindo que o mesmo seria o responseBody
//RequestMapping annotation que determina a URL base para as requisicoes desse Controller 
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	private final ClienteRepository clienteRepository;
	
//	Foi injetada a dependencia ClienteRepository atraves da annotation @AutoWired
	public ClienteController(@Autowired ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
//	PostMapping denota que o metodo realiza acoes POST
//	ResponseStatus por padrao o code default eh 200, caso queira modificar, como agora, eh soh inserir a annotation com o code desejado
//	RequestBody mostrando que o objeto vira em JSON
//	Valid define que o Spring valide antes de chegar na camada de persistencia
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClienteEntity salvar(@RequestBody @Valid ClienteEntity clienteEntity) {
		return clienteRepository.save(clienteEntity);
	}
	
//	Requisicoes GET, passando o o caminho da URL, valor do RequestMapping + o parametro
//	PathVariable pra mostrar que eh correspondente ao valor que vier na URL. Por default ele busca pelo nome escrito no GetMapping, mas caso voce queria passar um nome diferente no parametro do metodo, eh soh adicionar um paramentro na annotation PathVariable passando o nome correspondente do GetMapping
	@GetMapping("{id}")
	public ClienteEntity consultarPorId(@PathVariable Integer id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public List<ClienteEntity> consultarTodos() {
		return clienteRepository.findAll();
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable("id") Integer codigo) {
		clienteRepository.findById(codigo)
		.map(clienteTeste -> {
			clienteRepository.deleteById(codigo);
			return clienteTeste;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id, @RequestBody ClienteEntity clienteAtualizado) {
		clienteRepository.findById(id)
		.map(clienteConsultado -> {
			clienteAtualizado.setId(clienteConsultado.getId());
			return clienteRepository.save(clienteAtualizado);
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
}
