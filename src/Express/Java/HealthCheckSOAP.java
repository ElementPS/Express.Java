package Express.Java;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HealthCheck", namespace = "https://transaction.elementexpress.com")
public class HealthCheckSOAP {
	@XmlElement(name = "credentials")
	public Credentials Credentials;
	@XmlElement(name = "application")
	public Application Application;
	
	public static HealthCheckSOAP GetHealthCheck(ConfigurationData configData)
	{
		HealthCheckSOAP healthCheck = new HealthCheckSOAP();
		healthCheck.Credentials = new Credentials();
		healthCheck.Credentials.AccountID = configData.AccountID;
		healthCheck.Credentials.AccountToken = configData.AccountToken;
		healthCheck.Credentials.AcceptorID = configData.AcceptorID;
		healthCheck.Application = new Application();
		healthCheck.Application.ApplicationID = configData.ApplicationID;
		healthCheck.Application.ApplicationVersion = configData.ApplicationVersion;
		healthCheck.Application.ApplicationName = configData.ApplicationName;
		
		return healthCheck;
	}
	
	public static String HealthCheckToXML(HealthCheckSOAP healthCheck) {
		String xmlString = "";
		
		try {					
			JAXBContext jaxbContext = JAXBContext.newInstance(HealthCheckSOAP.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(healthCheck, sw);
			xmlString = sw.toString();
		}
		catch (Exception ex)
		{
		     final StringWriter sw = new StringWriter();
		     final PrintWriter pw = new PrintWriter(sw, true);
		     ex.printStackTrace(pw);
		     xmlString = sw.getBuffer().toString();		   
		}
		
        return xmlString;
	}	
	
	public static String HealthCheckToSOAP(HealthCheckSOAP healthCheck) {
		
		String soap = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
		soap += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n";
		soap += "<soap:Body>\n";
		soap += HealthCheckToXML(healthCheck);
		soap += "\n";
		soap += "</soap:Body>\n";
		soap += "</soap:Envelope>\n";
		
		return soap;									
	}
}
