package Task_1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class Main{

	@Test
	private void readBreedName() {

		// Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "https://dog.ceo/api/";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		 Response response = httpRequest.request(Method.GET,"breeds/list/all");
		 
		 // Retrieve the body of the Response
		 ResponseBody body = response.getBody();
		 
		 //Prints out the body with the list of breed names
		 System.out.println(body.asString());
}
	@Test
	public void verifyBreed()
	{
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://dog.ceo/api/";
	 
	 // Get the RequestSpecification of the request that you want to sent
	 // to the server. The server is specified by the BaseURI that we have
	 // specified in the above step.
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 // Make a request to the server by specifying the method Type and the method URL.
	 // This will return the Response from the server. Store the response in a variable.
	 Response response = httpRequest.request(Method.GET,"https://dog.ceo/api/breeds/list/all");
	 
	 // Retrieve the body of the Response
	 ResponseBody <?> body = response.getBody();
	 
	 // To check for sub string presence get the Response body as a String.
	 // Do a String.contains
	 String bodyAsString = body.asString();
	 

	 // Convert the body into lower case and then do a comparison
	 Assert.assertEquals(bodyAsString.contains("retriever"), true, "Verify - retriever is within list");

	}
	
	@Test
	private void readSubBreed() {

        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL("https://dog.ceo/api/breed/retriever/list");
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {

            	//Prints out the sub breed
            	System.out.println(line);
                
            }
            
            //Closes the reader
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }	
    }
	
	@Test
	private void randomImagel() {

        List<String> reponses = new ArrayList<>();

            StringBuilder content = new StringBuilder();
            try {
                // create a url object
                URL url = new URL("https://dog.ceo/api/breed/retriever/golden/images/random");
                // create a urlconnection object
                URLConnection urlConnection = url.openConnection();
                // wrap the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null) {
                   //Appends the contents in the reader
                	content.append(line + "\n");
                  //Prints out the image link
                    System.out.println(line);
                }
                
                //Closes the reader
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            reponses.add(content.toString());      

    }
}
