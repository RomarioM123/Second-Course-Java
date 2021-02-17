package ua.khpi.oop.momot16.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ua.khpi.oop.momot16.model.Event;
import ua.khpi.oop.momot16.util.DateUtil;


public class EventEditDialogController {
	@FXML private TextField addressField;
	@FXML private TextField descriptionField;
	@FXML private TextField peopleField;
	@FXML private TextField durationField;
	@FXML private TextField startTimeField;
	
    private Stage dialogStage;
    private Event event;
    private boolean okClicked = false;

    @FXML
    private void initialize() {}

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the hotel room to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Event event) {
        this.event = event;
        addressField.setText(event.getAddress());
        descriptionField.setText(event.getDescription());
        peopleField.setText(event.getPeople());
        startTimeField.setText(DateUtil.format(event.getStartTime()));
        startTimeField.setPromptText("dd.mm.yyyy");
        durationField.setText(Integer.toString(event.getDuration()));
    }
	
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	event.setAddress(addressField.getText());
        	event.setDescription(descriptionField.getText());
        	event.setPeople(peopleField.getText());
        	event.setDuration(Integer.parseInt(durationField.getText()));
        	event.setStartTime(DateUtil.parse(startTimeField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";
        Pattern pattern = Pattern.compile("(A-Za-z0-9'\\.\\-\\s\\,)");
        
        Matcher matcher = pattern.matcher(addressField.getText());
        if (!matcher.matches()) {
            errorMessage += "No valid address!\n"; 
        }
       
        matcher = pattern.matcher(descriptionField.getText());
        if (!matcher.matches()) {
            errorMessage += "No valid description!\n"; 
        }
        
        pattern = Pattern.compile("(([A-Z][a-z]+)|([A-Z][a-z]*)([\\s][A-Z][a-z]*))(,\\s|\\s|$){1,}");
        matcher = pattern.matcher(peopleField.getText());
        if (!matcher.matches()) {
            errorMessage += "No valid people!\n"; 
        }
        
        pattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(19|20)\\d{2}");
        matcher = pattern.matcher(startTimeField.getText());
        if (!matcher.matches()) {
            errorMessage += "No valid start time!\n"; 
        }
        
        pattern = Pattern.compile("([1-9]\\d*)");
        matcher = pattern.matcher(durationField.getText());
        if (!matcher.matches()) {
            errorMessage += "No valid duration!\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } 
        else {
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}