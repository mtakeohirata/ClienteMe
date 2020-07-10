package br.com.takeo.projeto.Vendas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class VendasApplication {
	
	@Value("${application.name}")
	private String nomeAplicacao;
	
	@GetMapping("/hello")
	public String primeiraPaginaTests() {
		return nomeAplicacao;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
