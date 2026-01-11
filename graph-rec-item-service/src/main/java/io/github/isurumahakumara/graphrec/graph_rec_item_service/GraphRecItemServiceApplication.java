package io.github.isurumahakumara.graphrec.graph_rec_item_service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@RestController
public class GraphRecItemServiceApplication {

	private final ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) {
		SpringApplication.run(GraphRecItemServiceApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable int id) throws IOException {
		List<Movie> movies = objectMapper.readValue(
				new ClassPathResource("movies.json").getInputStream(),
				new TypeReference<>() {}
		);
		return movies.stream()
				.filter(m -> m.id() == id)
				.findFirst()
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	public record Movie(int id, String title, String genre, double rating, int releaseYear) {}
}
