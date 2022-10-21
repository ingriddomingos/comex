package br.com.comex.main;

import java.sql.SQLException;

import javax.xml.ws.Endpoint;

import br.com.comex.ws.ComexWS;


public class MainComexWS {

	public static void main(String[] args) throws SQLException {
		ComexWS comexWS = new ComexWS();
		String url = "http://localhost:8080/ComexWS";
		
		System.out.println("Rodando na url: " + url);
		Endpoint.publish(url, comexWS);
	}

}
