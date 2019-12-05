package br.com.felipe.pactconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.felipe.pactconsumer.adapter.driven.ProviderAdapter;
import br.com.felipe.pactconsumer.port.ProviderPort;
import br.com.felipe.pactconsumer.service.ConsumerService;

@Configuration
public class BeanConfiguration {

	@Bean
	public ProviderPort providerPort() {
		return new ProviderAdapter();
	}
	
	@Bean
	public ConsumerService consumerService() {
		return new ConsumerService(providerPort());
	}
	
}
