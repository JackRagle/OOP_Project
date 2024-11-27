package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Format {

	@FXML private HBox results;
	@FXML private Label startnum;
	@FXML private Label startunit;
	@FXML private Label endnum;
	@FXML private Label endunit;
	@FXML private TextField numunits;
	double amount;
	
    public void handleMITOKMButtonAction(ActionEvent event) {
        amount = Integer.parseInt(numunits.getText());
        amount = amount * 1.609344;
        startnum.setText(numunits.getText());
        startunit.setText("Miles");
        endnum.setText(Double.toString(amount));
        endunit.setText("Kilometers");
        results.setOpacity(100);
    }
    @FXML protected void handleKMTOMIButtonAction(ActionEvent event) {
    	amount = Integer.parseInt(numunits.getText());
    }
    @FXML protected void handleLBTOKGButtonAction(ActionEvent event) {
    	amount = Integer.parseInt(numunits.getText());
    }
    @FXML protected void handleKGTOLBButtonAction(ActionEvent event) {
    	amount = Integer.parseInt(numunits.getText());
    }
	@FXML protected void handleINTOCMButtonAction(ActionEvent event) {
		amount = Integer.parseInt(numunits.getText());
	}
	@FXML protected void handleCMTOINButtonAction(ActionEvent event) {
		amount = Integer.parseInt(numunits.getText());
	}
	@FXML protected void handleOZTOMLButtonAction(ActionEvent event) {
		amount = Integer.parseInt(numunits.getText());
	}
	@FXML protected void handleMLTOOZButtonAction(ActionEvent event) {
		amount = Integer.parseInt(numunits.getText());
	}
}
