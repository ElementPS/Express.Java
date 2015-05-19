package Express.Java;

import javax.xml.bind.annotation.XmlElement;

public class Terminal {
	@XmlElement(name = "TerminalID")
	public String TerminalID;
	@XmlElement(name = "CardholderPresentCode")
	public String CardholderPresentCode;
	@XmlElement(name = "CardInputCode")
	public String CardInputCode;
	@XmlElement(name = "TerminalCapabilityCode")
	public String TerminalCapabilityCode;
	@XmlElement(name = "TerminalEnvironmentCode")
	public String TerminalEnvironmentCode;
	@XmlElement(name = "CardPresentCode")
	public String CardPresentCode;
	@XmlElement(name = "MotoECICode")
	public String MotoECICode;
	@XmlElement(name = "CVVPresenceCode")
	public String CVVPresenceCode;

}
