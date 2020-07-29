package clienteMe.advices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import clienteMe.errors.ApplicationErrors;
// ControllerAdvice faz com que a classe receba receba requisicoes ao determinada classe lancar excecoes, e a partir dali tomar certo comportamento...as excecoes que serao capturada sao passadas nos metodos
@RestControllerAdvice
public class ControllerAdvice {
	
//	Ao ser capturado essa excecao ele transforma em JSON e devolve pro usuario
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApplicationErrors handleValidationException(MethodArgumentNotValidException e) {
//		Transformo e uma stream para poder usar o map e retirar so as mensagens de erro e logo apos transformo em  uma lista de String
//		Poderia ser feito via iteracao forEach manual, entretando foi aplicado recursos do java 8, tais como a API Stream do mesmo
		List<String> mensagensErro = e.getBindingResult().getAllErrors()
									.stream()
									.map(erro -> erro.getDefaultMessage())
									.collect(Collectors.toList());
		
		return new ApplicationErrors(mensagensErro, HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleGeneralException(ResponseStatusException e) {
		return new ResponseEntity(new ApplicationErrors(e.getMessage(), e.getStatus().toString()), e.getStatus() );
	}

}
