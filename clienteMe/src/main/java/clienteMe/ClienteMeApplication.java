package clienteMe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Todos os pacotes dentro do pacote atual serao escaneados, ou seja, visiveis no contexto do Spring em Runtime, eh possivel alterar isso via annotation scanBasePackage
@SpringBootApplication
public class ClienteMeApplication {

//	Roda a aplicacao
	public static void main(String[] args) {
		SpringApplication.run(ClienteMeApplication.class, args);
	}
	
}
