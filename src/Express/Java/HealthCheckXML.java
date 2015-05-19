package Express.Java;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HealthCheck", namespace = "https://transaction.elementexpress.com")
public class HealthCheckXML {
	@XmlElement(name = "Credentials")
	public Credentials Credentials;
	@XmlElement(name = "Application")
	public Application Application;
	
	public static HealthCheckXML GetHealthCheck(ConfigurationData configData)
	{
		HealthCheckXML healthCheck = new HealthCheckXML();
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
	
	public static String HealthCheckToXML(HealthCheckXML healthCheck) {
		String xmlString = "";
		
		try {					
			JAXBContext jaxbContext = JAXBContext.newInstance(HealthCheckXML.class);
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
}
