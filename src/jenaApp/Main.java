package jenaApp;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

public class Main {

	public static String serviceEndPoint = "http://3.135.209.188:3030//serTriple1/query";
	
	public static void main(String args[]) {
		
//		test();
		
		Main main = new Main();
		
	   String queryString = "SELECT *"
	   		+ " WHERE {"
	   		+ " ?sub ?pred ?obj } "
	   		+ " LIMIT 25 ";
		
		main.loadTest(serviceEndPoint,queryString);
		
	}
	
	
	
	public static void loadTest(String serviceURI , String query) {
		
		 QueryExecution qexec = QueryExecutionFactory.sparqlService(serviceURI,query);	
		 
		 ResultSet results = qexec.execSelect();
		 
		 ResultSetFormatter.out(System.out,results);
	}
}
