package br.com.felipe.pactconsumer.adapter.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipe.pactconsumer.service.ConsumerService;

@RestController
@RequestMapping("/v1/consumer")
public class ConsumerAPI {
	
	private ConsumerService service;

	@Autowired
	public ConsumerAPI(ConsumerService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<String>> findAll() {
		List<String> result = service.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{value}")
	public ResponseEntity<String> find(@PathVariable String value) {
		String result = service.find(value);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody String value) {
		String result = service.insert(value);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable String id, @RequestBody String value) {
		service.update(id, value);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{value}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
