package Express.Java;
import javax.xml.bind.annotation.XmlElement;

public class Application {
	@XmlElement(name = "ApplicationID")
	public String ApplicationID;
	@XmlElement(name = "ApplicationVersion")
	public String ApplicationVersion;
	@XmlElement(name = "ApplicationName")
	public String ApplicationName;
}
