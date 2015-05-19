package Express.Java;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HttpSender {

    public static String SendData(String urlToSend, String soapAction, String data) {

    	String response = "";
    	StringBuilder sb = new StringBuilder();
    	String line = "";
    	
		try { 		
			URL url = new URL(urlToSend);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST"); 
			
			conn.setRequestProperty("content-type", "text/xml;charset=\"utf-8\"");
			conn.setRequestProperty("accept", "text/xml");
			
			if (soapAction != null) {
				conn.setRequestProperty("SOAPAction", soapAction);
			}
						
			conn.setRequestProperty("Content-Length", Integer.toString(data.getBytes().length)); 
			conn.setConnectTimeout(10000); 
			conn.setReadTimeout(30000); 
			conn.setDoInput(true); 
			conn.setDoOutput(true); 
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream()); 
			writer.write(data); 
			writer.close(); 
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) { 
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); 
				while ((line = rd.readLine()) != null) { 
					sb.append(line); 
				} 
				rd.close();	
				
		        Source xmlInput = new StreamSource(new StringReader(sb.toString()));
		        StringWriter stringWriter = new StringWriter();
		        StreamResult xmlOutput = new StreamResult(stringWriter);
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        transformerFactory.setAttribute("indent-number", 2);
		        Transformer transformer = transformerFactory.newTransformer(); 
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        transformer.transform(xmlInput, xmlOutput);
		        response = xmlOutput.getWriter().toString();				
			} 
			else { 
				response = "Error: " + conn.getResponseCode() + " " + conn.getResponseMessage(); 
			} 
			conn.disconnect(); 
		} 
		catch (Exception ex) { 
			response = "Exception: " + ex.getMessage(); 
		}
		
		return response;
    }

}
