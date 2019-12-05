package br.com.felipe.pactconsumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.felipe.pactconsumer.port.ProviderPort;

public class ConsumerService {

	private ProviderPort providerPort;

	@Autowired
	public ConsumerService(ProviderPort providerPort) {
		this.providerPort = providerPort;
	}
	
	public List<String> findAll() {
		return providerPort.findAll();
	}
	
	public String find(String value) {
		return providerPort.find(value);
	}
	
	public String insert(String value) {
		return providerPort.insert(value);
	}

	public void update(String id, String value) {
		providerPort.update(id, value);
	}

	public void delete(String value) {
		providerPort.delete(value);
	}
	
}
