package Express.Java;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JTextArea;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class SendTransactionActionListener implements ActionListener{

    private ConfigurationData configData;
    private JTextArea txtRequest;
    private JTextArea txtResponse;

    public SendTransactionActionListener(ConfigurationData configData, JTextArea txtRequest, JTextArea txtResponse) {
        super();
        this.configData = configData;
        this.txtResponse = txtResponse;
        this.txtRequest = txtRequest;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	String response = "";
    	
		try {
			response = HttpSender.SendData(configData.ExpressXMLEndpoint, null, this.txtRequest.getText());
		} 
		catch (Exception ex) { 
			response = "Exception: " + ex.getMessage(); 
		}
		
		this.txtResponse.setText(response);
    }

}
