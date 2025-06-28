package com.nickblogsite.springboot_backend.controller;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class OpenLibraryController {

	@GetMapping("/booksWithSearchTerm/{searchTerm}")
	public String getBookData(@PathVariable final String searchTerm) {
		try {

			// UNCOMMENT fOR REAL RESULTS

			// final String searchTermParsed = searchTerm.replaceAll(" ", "+");
			// HttpRequest request = HttpRequest.newBuilder()
			// .uri(new URI("https://openlibrary.org/search.json?q=" + searchTermParsed))
			// .header("User-Agent", "CanBookStore/1.0 (ngermanos97@gmail.com)")
			// .GET()
			// .build();

			// HttpResponse<String> response = HttpClient.newBuilder()
			// .build()
			// .send(request, BodyHandlers.ofString());

			return testData();
		} catch (Exception e) {
			System.out.println("Something went wrong");
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
}
