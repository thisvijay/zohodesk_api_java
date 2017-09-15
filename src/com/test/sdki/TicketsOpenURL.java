package com.test.sdki;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.text.SimpleDateFormat;
public class TicketsOpenURL {
	
	private static String auth_token="59550a0e2b1a864a31bef962363e029f";
	private static String departmentId="652853630";
	
	public static void main(String[] args) throws Exception{
		String include_fields="contacts,products";
		
		String apiRequestUrl="https://desk.zoho.com/api/v1/tickets?include="+include_fields;
		
		URL url=new URL(apiRequestUrl);
		
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Authorization", auth_token);
		connection.setRequestProperty("orgId", departmentId);
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line="";
		System.out.println("Response Code : "+connection.getResponseCode());
		while ((line=reader.readLine())!=null) {
			System.out.println("JSON Response : "+line);
		}
		//createComment();
	}
	private static void createComment() throws Exception{
		String ticketId="215666000000084069";
		
		String apiRequestUrl="https://desk.zoho.com/api/v1/tickets/"+ticketId+"/comments";
		String ticket_data_to_update="{\"isPublic\" :\"true\",  \"content\" : \"zsu[@user:11550965]zsu Wrote On "+(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()))+" Some ehat hai mail sending is not working !!!!\"}";
		
		URL url=new URL(apiRequestUrl);
		
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", auth_token);
		connection.setRequestProperty("orgId", departmentId);
		connection.setDoOutput(true);
		
	}
}
