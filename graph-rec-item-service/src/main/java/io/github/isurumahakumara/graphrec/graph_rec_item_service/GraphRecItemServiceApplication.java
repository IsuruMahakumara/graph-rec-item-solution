package io.github.isurumahakumara.graphrec.graph_rec_item_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GraphRecItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphRecItemServiceApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}
}
