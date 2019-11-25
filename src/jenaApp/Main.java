package jenaApp;

import java.io.File;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static String serviceEndPoint = "http://3.135.209.188:3030//serTriple1";
	public static String serviceEndPoint1 = "http://3.135.209.188:3030//newTriple1/query";
	
	
	public static void main(String args[]) {
		
		
		String queryString = "SELECT *"
		   		+ " WHERE {"
		   		+ " ?sub ?pred ?obj } "
		   		+ " LIMIT 25 ";
//		
		
		String queryString1 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"			 PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"			 PREFIX prefix1: <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23>\n" + 
				"			 PREFIX tr1: <http://127.0.0.1:3333/>\n" + 
				"			 SELECT ?subtopic\n" + 
				"			 WHERE{\n" + 
				"			   <http://127.0.0.1:3333/General+aspects> <http://www.semanticweb.org/sarvanshprasher/ontologies/2019/10/untitled-ontology-23#contains> ?subtopic\n" + 
				"			 }";
		
		 

		
		   
		
		loadTest(serviceEndPoint1,queryString1);
		
		
		
	}
	
	
	
	public static void loadTest(String serviceURI , String query) {
		
		 QueryExecution qexec = QueryExecutionFactory.sparqlService(serviceURI,query);	
		 
		 ResultSet results = qexec.execSelect();
		 ResultSetFormatter.out(System.out,results);
		 
		 while(results.hasNext()) {
			 System.out.println(results.next().toString());
		 }
		 
		 
	}
}
