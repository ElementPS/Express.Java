package Express.Java;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CreditCardSale", namespace = "https://transaction.elementexpress.com")
public class CreditCardSaleXML {

	@XmlElement(name = "Credentials")
	public Credentials Credentials;
	@XmlElement(name = "Application")	
	public Application Application;
	@XmlElement(name = "Terminal")
	public Terminal Terminal;
	@XmlElement(name = "Card")
	public Card Card;
	@XmlElement(name = "Transaction")
	public Transaction Transaction;	
	
	
	public static CreditCardSaleXML GetCreditCardSale(ConfigurationData configData)
	{
		CreditCardSaleXML creditCardSale = new CreditCardSaleXML();
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
		creditCardSale.Terminal.CardholderPresentCode = "2";
		creditCardSale.Terminal.CardInputCode = "5";
		creditCardSale.Terminal.TerminalCapabilityCode = "3";
		creditCardSale.Terminal.TerminalEnvironmentCode = "2";
		creditCardSale.Terminal.CardPresentCode = "2";
		creditCardSale.Terminal.MotoECICode = "1";
		creditCardSale.Terminal.CVVPresenceCode = "1";
		
		creditCardSale.Card = new Card();
		creditCardSale.Card.CardNumber = "5499990123456781";
		creditCardSale.Card.ExpirationMonth = "12";
		creditCardSale.Card.ExpirationYear = "19";
		
		creditCardSale.Transaction = new Transaction();
		creditCardSale.Transaction.TransactionAmount = "6.55";
		creditCardSale.Transaction.MarketCode = "7";			
		
		return creditCardSale;
	}
	
	public static String CreditCardSaleToXML(CreditCardSaleXML creditCardSale) {
		String xmlString = "";
		
		try {					
			JAXBContext jaxbContext = JAXBContext.newInstance(CreditCardSaleXML.class);
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
	
	
}
