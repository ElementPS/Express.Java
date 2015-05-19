package Express.Java;

import javax.xml.bind.annotation.XmlElement;

public class Transaction {
	@XmlElement(name = "TransactionAmount")
	public String TransactionAmount;
	@XmlElement(name = "MarketCode")
	public String MarketCode;
}
