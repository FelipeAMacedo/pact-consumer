package br.com.felipe.pactconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import br.com.felipe.pactconsumer.config.BeanConfiguration;

@SpringBootApplication
@Import(BeanConfiguration.class)
@ComponentScan("br.com.felipe.pactconsumer")
public class PactConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PactConsumerApplication.class, args);
	}

}
