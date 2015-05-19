package Express.Java;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class ClearDataActionListener implements ActionListener{
	    private JTextArea txtRequest;
	    private JTextArea txtResponse;

	    public ClearDataActionListener(JTextArea txtRequest, JTextArea txtResponse) {
	        super();
	        this.txtRequest = txtRequest;
	        this.txtResponse = txtResponse;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
			
			try { 
	            this.txtRequest.setText("");
	            this.txtResponse.setText("");
				
				} 
				catch (Exception ex) {  
					this.txtRequest.setText(ex.getMessage());
				}
	    }
}
