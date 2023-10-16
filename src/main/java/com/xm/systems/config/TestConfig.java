package com.xm.systems.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.xm.systems.entities.RegistroEntity;
import com.xm.systems.repositories.RegistroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private RegistroRepository registroRepository;

	@Override
	public void run(String... args) throws Exception {
		
		RegistroEntity r1 = new RegistroEntity(null, "Pagamento", Instant.parse("2023-10-01T00:00:00Z"), "ENTRADA", 4200.00, "PAGO");
		RegistroEntity r2 = new RegistroEntity(null, "Aluguel", Instant.parse("2023-10-01T00:00:00Z"), "SAÍDA", 918.00, "PAGO");
		RegistroEntity r3 = new RegistroEntity(null, "Luz", Instant.parse("2023-10-01T00:00:00Z"), "SAÍDA", 120.00, "PAGO");
		
		registroRepository.saveAll(Arrays.asList(r1, r2, r3));
		
	}

}
