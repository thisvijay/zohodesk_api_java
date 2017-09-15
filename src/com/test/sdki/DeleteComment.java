//$Id$
package com.test.sdki;
import java.io.*;

import javax.xml.ws.Response;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;

public class DeleteComment {
	public static void main(String[] args) throws ClientProtocolException,IOException{
		String auth_token="59550a0e2b1a864a31bef962363e029f";
		String departmentId="652853630";
		String ticketId="215666000000084069";
		String commentId="215666000000107097";
		
		String apiRequestUrl="https://desk.zoho.com/api/v1/tickets/"+ticketId+"/comments/"+commentId;
		
		HttpClient httpClient=new DefaultHttpClient();
		HttpDelete request=new HttpDelete(apiRequestUrl);
		request.addHeader("Authorization",auth_token);
		request.addHeader("orgId",departmentId);
		HttpResponse response=httpClient.execute(request);
		BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line="";
		System.out.println("Response Code : "+response.getStatusLine().getStatusCode());
		if(response.getStatusLine().getStatusCode()==200){
			System.out.println("Comment "+commentId+" Deleted Successfully");
		}
		while ((line=reader.readLine())!=null) {
			System.out.println("JSON Response : "+line);
		}
	}
}
