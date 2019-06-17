//$Id$
package com.yesiamvj.zohodesk.sdk.tickets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *  ::::::::   Libraries used  :::::::::
 * 
 * https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime/4.3.1
 * 
 * https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore/4.4.1
 * 
 * https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.5.9
 * 
 * http://repo1.maven.org/maven2/commons-logging/commons-logging/1.1.2/commons-logging-1.1.2.jar
 *
 */

public class TicketAttachment {
	
	public static void main(String args[]) throws ClientProtocolException, IOException {
		
		String auth_token="SKJDBVDBVOIEW9WEOVINOSDNV";	//YOUR_AUTH_TOKEN
		String orgId="8279489";						    //YOUR_ORG_ID
		String ticketId="3928738972984";		
		
		String apiRequestUrl="https://desk.zoho.com/api/v1/tickets/"+ticketId+"/attachments";
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    builder.addBinaryBody("file", new File("/Users/vijaykumar/Desktop/vijay.txt"), ContentType.TEXT_PLAIN, "file.txt");
	    
		CloseableHttpClient client = HttpClients.createDefault();
		HttpUriRequest request = RequestBuilder.post()
				  .setUri(apiRequestUrl)
				  .setEntity(builder.build())
				  .setHeader("Authorization",auth_token)
				  .setHeader("orgId", orgId)
				  .build();
		
		
	    
		HttpResponse response = client.execute(request);
		BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line="";
		System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
		while ((line=reader.readLine())!=null) {
			System.out.println("JSON Response : "+line);
		}
	}
	
}
