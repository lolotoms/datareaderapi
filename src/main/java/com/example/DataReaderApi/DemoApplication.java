package com.example.DataReaderApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class DemoApplication {
	
	final static String serverUrl1 = "https://gist.githubusercontent.com/PhantomGrin/a1e8ad30915ecd9d2659400d496d1ed6/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_hash.json";
	final static String serverUrl2 = "https://gist.githubusercontent.com/PhantomGrin/a1e8ad30915ecd9d2659400d496d1ed6/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_titlecase.json";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public static String requestProcessedData(int urlib) {
		String serverUrl = null;
		if(urlib == 1) {
			serverUrl = serverUrl1;
		}
		else if (urlib == 2) {
			serverUrl = serverUrl2;
		}else {
			return "ERROR";
		}
		RestTemplate request = new RestTemplate();
		String result = request.getForObject(serverUrl, String.class);
		System.out.println(serverUrl);
		return (result);
	}
	
	@GetMapping("/")
	public static String Hello(){
		return "HELLO I AM A DATA READER";
	}

	@GetMapping("/readDataForCode")
	public static String requestCodeData() {
		return requestProcessedData(1);
	}
	
	@GetMapping("/readDataForState")
	public static String requestForState() {
		return requestProcessedData(2);
	}	
}
