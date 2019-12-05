package br.com.felipe.pactconsumer.port;

import java.util.List;

public interface ProviderPort {
	
	String getUrl();
	void setUrl(String url);
	List<String> findAll();
	String find(String id);
	String insert(String value);
	void update(String id, String value);
	void delete(String id);
}
