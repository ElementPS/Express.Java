package Express.Java;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class PopulateHealthCheckSOAPActionListener implements ActionListener{
	    private JTextArea txtRequest;
	    private ConfigurationData configData;

	    public PopulateHealthCheckSOAPActionListener(JTextArea txtRequest, ConfigurationData configData) {
	        super();
	        this.txtRequest = txtRequest;
	        this.configData = configData;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
			
			try { 
	            this.configData.SoapAction =  "\"https://transaction.elementexpress.com/HealthCheck\"";
	            
				this.txtRequest.setText(HealthCheckSOAP.HealthCheckToSOAP(HealthCheckSOAP.GetHealthCheck(this.configData)));
				
				} 
				catch (Exception ex) {  
					this.txtRequest.setText(ex.getMessage());
				}
	    }
}
