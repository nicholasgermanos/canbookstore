package com.nickblogsite.springboot_backend.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class OpenLibraryController {

	@GetMapping("/booksWithSearchTerm/{searchTerm}")
	public String getBookData(@PathVariable final String searchTerm) {
		try {
			String queryold = "{ \"query\": \"query { me { id } }\"}";
			String query = getQuery("search", searchTerm);
			WebClient wc = WebClient.builder()
					.baseUrl("https://api.hardcover.app/v1/graphql")
					.defaultHeaders(headers -> {
						headers.put("content-type", Collections.singletonList("application/json"));

						// Do not commit below
						headers.put("authorization", Collections.singletonList(
								"Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJIYXJkY292ZXIiLCJ2ZXJzaW9uIjoiOCIsImp0aSI6IjgzYjYzNDM2LWJkMTAtNDYxMC1iZDUzLWVhMWJkMzQ3YTRlNyIsImFwcGxpY2F0aW9uSWQiOjIsInN1YiI6IjM5MzM2IiwiYXVkIjoiMSIsImlkIjoiMzkzMzYiLCJsb2dnZWRJbiI6dHJ1ZSwiaWF0IjoxNzUyMzE2OTQzLCJleHAiOjE3ODM4NTI5NDMsImh0dHBzOi8vaGFzdXJhLmlvL2p3dC9jbGFpbXMiOnsieC1oYXN1cmEtYWxsb3dlZC1yb2xlcyI6WyJ1c2VyIl0sIngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1yb2xlIjoidXNlciIsIlgtaGFzdXJhLXVzZXItaWQiOiIzOTMzNiJ9LCJ1c2VyIjp7ImlkIjozOTMzNn19.tM-Xi2xdvjiaVFg-_zDUPv8kidR3srD9QnfYEWTirjQ"));
					})
					.build();

			// UNCOMMENT fOR REAL RESULTS

			// final String jsonResponse =
			// wc.post().bodyValue(query).retrieve().bodyToMono(String.class)
			// .block();

			return testData();

			// return testData();
		} catch (Exception e) {
			System.out.println("Something went wrong" + e);
		}
		System.out.println("Something went wrong 2");

		return "";

	}

	private String testData() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream is = classLoader.getResourceAsStream("test_hunger_games.json");
		final InputStreamReader isr = new InputStreamReader(is);
		final BufferedReader br = new BufferedReader(isr);
		String text = br
				.lines()
				.collect(Collectors.joining("\n"));

		return text;
	}

	private String getQuery(final String queryName, final String replaceMe) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream is = classLoader.getResourceAsStream("graphql_queries/" + queryName + ".json");
		final InputStreamReader isr = new InputStreamReader(is);
		final BufferedReader br = new BufferedReader(isr);
		String text = br
				.lines()
				.collect(Collectors.joining("\n"));

		return text.replace("{{replaceme}}", replaceMe);
	}

	private void writeToFile(String filename, String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.write(content);

			writer.close();
		} catch (IOException e) {
			System.out.println("bad write operation occurred");
		}
	}

}
