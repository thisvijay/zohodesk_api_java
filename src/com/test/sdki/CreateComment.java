//$Id$
package com.test.sdki;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.xml.ws.Response;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;

public class CreateComment {
	public static void main(String[] args) throws ClientProtocolException,IOException{
		String auth_token="59550a0e2b1a864a31bef962363e029f";
		String departmentId="652853630";
		String ticketId="215666000000084069";
		
		String apiRequestUrl="https://desk.zoho.com/api/v1/tickets/"+ticketId+"/comments";
		
		String ticket_data_to_update="{\"isPublic\" :\"true\",  \"content\" : \"zsu[@user:11550965]zsu Wrote On "+(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()))+" Some ehat hai mail sending is not working !!!!\"}";
		
		StringEntity stringEntity=new StringEntity(ticket_data_to_update);
		HttpClient httpClient=new DefaultHttpClient();
		HttpPost request=new HttpPost(apiRequestUrl);
		request.addHeader("Authorization",auth_token);
		request.addHeader("orgId",departmentId);
		request.setHeader("Content-type", "application/json");
		request.setEntity(stringEntity);
		HttpResponse response=httpClient.execute(request);
		BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line="";
		System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
		while ((line=reader.readLine())!=null) {
			System.out.println("JSON Response : "+line);
		}
	}
}
