//$Id$
package com.test.sdki;
import java.io.*;

import javax.xml.ws.Response;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;


public class UpdateTicket {
	public static void main(String[] args) throws ClientProtocolException,IOException{
		String auth_token="59550a0e2b1a864a31bef962363e029f";
		String departmentId="652853630";
		String ticketId="215666000000084069";
		
		String apiRequestUrl="https://desk.zoho.com/api/v1/tickets/"+ticketId;
		String ticket_data_to_update="{\"subCategory\" : \"Sub General\", \"productId\" : \"\", \"contactId\" : \"215666000000074112\", \"subject\" : \"Welcome to Updated JAVA Zoho Support. Youve got a Java Request!\", \"customFields\" : { \"MyDateTime\" : \"\", \"datetime\" : \"\", \"MyInteger\" : \"\", \"MyPickList\" : \"asdadada\", \"Date\" : \"\", \"qqweq\" : \"false\" }, \"dueDate\" : \"2016-06-21T16:16:16.000Z\", \"departmentId\" : \"215666000000006907\", \"channel\" : \"Email\", \"description\" : \"Hai This is Description\", \"priority\" : \"High\", \"classification\" : \"\", \"assigneeId\" : null, \"phone\" : \"1 888 900 9646\", \"category\" : \"manoj\", \"email\" : \"example@example.com\", \"status\" : \"Open\"}";
		StringEntity stringEntity=new StringEntity(ticket_data_to_update);
		HttpClient httpClient=new DefaultHttpClient();
		HttpPatch request=new HttpPatch(apiRequestUrl);
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
