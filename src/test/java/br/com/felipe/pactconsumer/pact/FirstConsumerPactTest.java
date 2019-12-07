package br.com.felipe.pactconsumer.pact;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import br.com.felipe.pactconsumer.adapter.driven.ProviderAdapter;
import br.com.felipe.pactconsumer.port.ProviderPort;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "api_provider")
public class FirstConsumerPactTest {
    Map<String, String> headers = MapUtils.putAll(new HashMap<String, String>(),
        new String[]{"Content-Type", "application/json"});
    
//    @Pact(provider = "api_provider", consumer = "test_consumer")
//    public RequestResponsePact findAllPact(PactDslWithProvider builder) {
//    	PactDslJsonBody findAllResponseBody = new PactDslJsonBody()
//    		.stringType("result", "from")
//    		.stringType("provider", "yes")
//    		.asBody();
//    	
//    	return builder
//            .given("Pact for find all")
//            .uponReceiving("retrieving article data")
//            	.path("/v1/provider")
//            	.method("GET")
//            .willRespondWith()
//        		.headers(headers)
//        		.status(200)
//        		.body(findAllResponseBody)
//            .toPact();
//    }

    @Pact(provider = "api_provider", consumer = "test_consumer")
    public RequestResponsePact findPact(PactDslWithProvider builder) {
    	PactDslJsonBody findResponseBody = new PactDslJsonBody()
        		.stringType("result", "from")
        		.stringType("provider", "yes")
        		.asBody();
    	
    	return builder
			.given("Pact for find")
            .uponReceiving("retrieving article data")
        	.path("/v1/provider/id")
        	.method("GET")
        .willRespondWith()
    		.headers(headers)
    		.status(200)
    		.body(findResponseBody)
		.toPact();
    }
    
    @Pact(provider = "api_provider", consumer = "test_consumer")
    public RequestResponsePact insertPact(PactDslWithProvider builder) {
    	PactDslJsonBody insertBody = new PactDslJsonBody()
        		.stringType("data", "insert")
        		.asBody();
    	
    	return builder
	    	.given("Pact for insert")
	        .uponReceiving("retrieving article data")
	    	.path("/v1/provider")
	    	.method("POST")
	    	.headers(headers)
	    	.body(insertBody)
	    .willRespondWith()
			.status(200)
		.toPact();
    }
    
    @Pact(provider = "api_provider", consumer = "test_consumer")
    public RequestResponsePact updatePact(PactDslWithProvider builder) {
    	PactDslJsonBody updateBody = new PactDslJsonBody()
        		.stringType("data", "update")
        		.asBody();
    	
    	return builder
			.given("Pact for update")
            .uponReceiving("retrieving article data")
        	.path("/v1/provider/id")
        	.method("PUT")
        	.headers(headers)
        	.body(updateBody)
        .willRespondWith()
    		.status(200)
		.toPact();
    }

    @Pact(provider = "api_provider", consumer = "test_consumer")
    public RequestResponsePact deletePact(PactDslWithProvider builder) {
    	return builder
			.given("Pact for delete")
            .uponReceiving("retrieving article data")
        	.path("/v1/provider/id")
        	.method("DELETE")
        .willRespondWith()
    		.status(200)
		.toPact();
    }
    
//    @Test
//    @PactTestFor(pactMethod = "findAllPact")
//    public void testForFindAll(MockServer mockServer) throws IOException {
//    	ProviderPort providerAdapter = new ProviderAdapter();
//    	providerAdapter.setUrl(mockServer.getUrl() + "/v1/provider");
//    	
//    	providerAdapter.findAll();
//        assertEquals(true, true);
//    }
    
    @Test
    @PactTestFor(pactMethod = "findPact")
    public void testForFind(MockServer mockServer) throws IOException {
    	ProviderPort providerAdapter = new ProviderAdapter();
    	providerAdapter.setUrl(mockServer.getUrl() + "/v1/provider/id");
    	providerAdapter.find("id");
        assertEquals(true, true);
    }
    
    @Test
    @PactTestFor(pactMethod = "insertPact")
    public void testForInsert(MockServer mockServer) throws IOException {
    	ProviderPort providerAdapter = new ProviderAdapter();
    	providerAdapter.setUrl(mockServer.getUrl() + "/v1/provider");
    	providerAdapter.insert("insert");
        assertEquals(true, true);
    }
    
    @Test
    @PactTestFor(pactMethod = "updatePact")
    public void testForUpdate(MockServer mockServer) throws IOException {
    	ProviderPort providerAdapter = new ProviderAdapter();
    	providerAdapter.setUrl(mockServer.getUrl() + "/v1/provider/id");
    	providerAdapter.update("id", "update");
        assertEquals(true, true);
    }
    
    @Test
    @PactTestFor(pactMethod = "deletePact")
    public void testForDelete(MockServer mockServer) throws IOException {
    	ProviderPort providerAdapter = new ProviderAdapter();
    	providerAdapter.setUrl(mockServer.getUrl() + "/v1/provider/id");
    	providerAdapter.delete("id");
        assertEquals(true, true);
    }
}
