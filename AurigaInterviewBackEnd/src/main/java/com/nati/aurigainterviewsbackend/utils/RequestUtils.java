package com.nati.aurigainterviewsbackend.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestUtils {
	
	// Function that return Json in String from URL that provide Json.
	public static String GetGETRequestResult(String GETRequestUrl) throws IOException {
	    URL urlForGetRequest = new URL(GETRequestUrl);
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    // We get the 'status\response code to see if we got the answer we want from the server  
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader (new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in.readLine()) != null) {
	            response.append(readLine);
	        } 
	        in .close();
	        // Return result in string
	        return response.toString();
	    }
	    // If we got a problem
	    else {
	      return "GET NOT WORKED";
	    }
	}

}
