package Express.Java;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class PopulateHealthCheckXMLActionListener implements ActionListener{
	    private JTextArea txtRequest;
	    private ConfigurationData configData;

	    public PopulateHealthCheckXMLActionListener(JTextArea txtRequest, ConfigurationData configData) {
	        super();
	        this.txtRequest = txtRequest;
	        this.configData = configData;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
			
			try { 

				this.txtRequest.setText(HealthCheck.HealthCheckToXML(HealthCheck.GetHealthCheck(this.configData)));
				
				} 
				catch (Exception ex) {  
					this.txtRequest.setText(ex.getMessage());
				}
	    }
}
