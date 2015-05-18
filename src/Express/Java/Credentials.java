package Express.Java;
import javax.xml.bind.annotation.XmlElement;


public class Credentials {
	@XmlElement(name = "AccountID")
	public String AccountID;
	@XmlElement(name = "AccountToken")
	public String AccountToken;
	@XmlElement(name = "AcceptorID")
	public String AcceptorID;
}
