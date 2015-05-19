package Express.Java;

import javax.xml.bind.annotation.XmlElement;

public class Card {
	@XmlElement(name = "CardNumber")
	public String CardNumber;
	@XmlElement(name = "ExpirationMonth")
	public String ExpirationMonth;
	@XmlElement(name = "ExpirationYear")
	public String ExpirationYear;
}
