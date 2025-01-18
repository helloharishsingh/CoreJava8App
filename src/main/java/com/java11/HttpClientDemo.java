package com.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientDemo {

	public static void main(String[] args) {
		HttpClient client=HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		try {
			HttpRequest request=HttpRequest.newBuilder()
					.GET()
					.uri(URI.create("https://www.google.com"))
					.build();
			HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			System.out.println(response.statusCode());
		} catch (Exception e) {
			
		}

	}

}
