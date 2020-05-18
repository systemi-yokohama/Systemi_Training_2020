package Java_Training.practice100.no213.no059;

import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.file.Path;

public class No059 {
	public static void main(String[] args) {}
		var client = HttpClient.newHttpClient();
		var req = HttpRequest.newBuilder().uri(URI.create("URL")
		.build());
		var res = client.send(req, HttpResponse<body("body.txt")>.BodyHandler.ofString());
		var res = client.send(req, HttpResponse<HttpHeaders headers("header.txt")>.BodyHandler.ofString());
		if(req == true) {
			return 1;
			break;
		} else {
			System.out.println(response.sendError( HttpServerResponse.SC_NOT_FOUND ));
		}
		

	}	
}