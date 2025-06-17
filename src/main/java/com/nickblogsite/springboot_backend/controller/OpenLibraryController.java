package com.nickblogsite.springboot_backend.controller;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.web.bind.annotation.*;
import lombok.*;
import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class OpenLibraryController {

	@GetMapping("/booksWithSearchTerm/{searchTerm}")
	public String getBookData(@PathVariable final String searchTerm) {
		try {

			final String searchTermParsed = searchTerm.replaceAll(" ", "+");
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("https://openlibrary.org/search.json?q=" + searchTermParsed))
					.header("User-Agent", "CanBookStore/1.0 (ngermanos97@gmail.com)")
					.GET()
					.build();

			HttpResponse<String> response = HttpClient.newBuilder()
					.build()
					.send(request, BodyHandlers.ofString());

			return response.body();

		} catch (Exception e) {
			// Do nothing
		}

		return "";

	}

}
