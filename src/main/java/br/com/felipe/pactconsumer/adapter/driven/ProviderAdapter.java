package br.com.felipe.pactconsumer.adapter.driven;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import br.com.felipe.pactconsumer.port.ProviderPort;

public class ProviderAdapter implements ProviderPort {
	
	private RestTemplate restTemplate;
	private String url;
	
	public ProviderAdapter() {
		this.url = "http://localhost:8090/v1/provider";		
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public List<String> findAll() {
		restTemplate = new RestTemplate();
		String[] response = restTemplate.getForObject(url, String[].class);
		
		List<String> list = Arrays.asList(response);
		return list;
	}
	
	@Override
	public String find(String id) {
		restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, String.class, id);
	}

	@Override
	public String insert(String value) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json = "{\"data\": \"" + value +"\"}";
		HttpEntity<String> entity = new HttpEntity<>(json, headers);
		
		restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, entity, String.class);
	}

	@Override
	public void update(String id, String value) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String json = "{\"data\": \"" + value +"\"}";
		HttpEntity<String> entity = new HttpEntity<>(json, headers);
		
		restTemplate = new RestTemplate();
		restTemplate.put(url, entity, id);
	}

	@Override
	public void delete(String id) {
		restTemplate = new RestTemplate();
		restTemplate.delete(url, id);
	}

}
