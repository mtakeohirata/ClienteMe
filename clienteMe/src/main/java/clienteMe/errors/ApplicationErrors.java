package clienteMe.errors;

import java.util.Arrays;
import java.util.List;

public class ApplicationErrors {
	
	private List<String> mensagens;
	private String codigoErro;

	public ApplicationErrors(List<String> mensagens, String codigoErro) {
		this.mensagens = mensagens;
		this.codigoErro = codigoErro;
	}
	
	public ApplicationErrors(String mensagem, String codigoErro) {
		this.mensagens = Arrays.asList(mensagem);
		this.codigoErro = codigoErro;
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagem) {
		this.mensagens = mensagem;
	}

	public String getCodigoErro() {
		return codigoErro;
	}

	public void setCodigoErro(String codigoErro) {
		this.codigoErro = codigoErro;
	}
	
}
