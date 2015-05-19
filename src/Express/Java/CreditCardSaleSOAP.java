package Express.Java;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CreditCardSale", namespace = "https://transaction.elementexpress.com")
public class CreditCardSaleSOAP {

	@XmlElement(name = "credentials")
	public Credentials Credentials;
	@XmlElement(name = "application")	
	public Application Application;
	@XmlElement(name = "terminal")
	public Terminal Terminal;
	@XmlElement(name = "card")
	public Card Card;
	@XmlElement(name = "transaction")
	public Transaction Transaction;	
	
	
	public static CreditCardSaleSOAP GetCreditCardSale(ConfigurationData configData)
	{
		CreditCardSaleSOAP creditCardSale = new CreditCardSaleSOAP();
		creditCardSale.Credentials = new Credentials();
		creditCardSale.Credentials.AccountID = configData.AccountID;
		creditCardSale.Credentials.AccountToken = configData.AccountToken;
		creditCardSale.Credentials.AcceptorID = configData.AcceptorID;
		creditCardSale.Application = new Application();
		creditCardSale.Application.ApplicationID = configData.ApplicationID;
		creditCardSale.Application.ApplicationVersion = configData.ApplicationVersion;
		creditCardSale.Application.ApplicationName = configData.ApplicationName;
		
		creditCardSale.Terminal = new Terminal();
		creditCardSale.Terminal.TerminalID = "01";
		creditCardSale.Terminal.CardholderPresentCode = "Present";
		creditCardSale.Terminal.CardInputCode = "ManualKeyed";
		creditCardSale.Terminal.TerminalCapabilityCode = "MagstripeReader";
		creditCardSale.Terminal.TerminalEnvironmentCode = "LocalAttended";
		creditCardSale.Terminal.CardPresentCode = "Present";
		creditCardSale.Terminal.MotoECICode = "NotUsed";
		creditCardSale.Terminal.CVVPresenceCode = "NotProvided";
		
		creditCardSale.Card = new Card();
		creditCardSale.Card.CardNumber = "5499990123456781";
		creditCardSale.Card.ExpirationMonth = "12";
		creditCardSale.Card.ExpirationYear = "19";
		
		creditCardSale.Transaction = new Transaction();
		creditCardSale.Transaction.TransactionAmount = "6.55";
		creditCardSale.Transaction.MarketCode = "Retail";			
		
		return creditCardSale;
	}
	
	public static String CreditCardSaleToXML(CreditCardSaleSOAP creditCardSale) {
		String xmlString = "";
		
		try {					
			JAXBContext jaxbContext = JAXBContext.newInstance(CreditCardSaleSOAP.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(creditCardSale, sw);
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
	
	public static String CreditCardSaleToSOAP(CreditCardSaleSOAP creditCardSale) {
		
		String soap = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
		soap += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n";
		soap += "<soap:Body>\n";
		soap += CreditCardSaleToXML(creditCardSale);
		soap += "\n";
		soap += "</soap:Body>\n";
		soap += "</soap:Envelope>\n";
		
		return soap;									
	}
	
	
}
