package ua.khpi.oop.momot16.view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ua.khpi.oop.momot16.MainApp;
import ua.khpi.oop.momot16.model.Event;

public class EventOverviewController {
    @FXML private TableView<Event> 				EventTable;
    @FXML private TableColumn<Event, String> 	addressColumn;
    @FXML private TableColumn<Event, String> 	descriptionColumn;
    @FXML private TableColumn<Event, String> 	peopleColumn;
    @FXML private TableColumn<Event, Integer> 	durationColumn;
    @FXML private TableColumn<Event, LocalDate> startTimeColumn;
    
    private MainApp mainApp;

    public EventOverviewController() {}

    @FXML
    private void initialize() {
        addressColumn		.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        descriptionColumn	.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        peopleColumn		.setCellValueFactory(cellData -> cellData.getValue().peopleProperty());   
        startTimeColumn		.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());   
        durationColumn		.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asObject());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        EventTable.setItems(mainApp.getEventData());
    }
    
    @FXML
    private void handleDeleteBooking() {
        int selectedIndex = EventTable.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) {
        	EventTable.getItems().remove(selectedIndex);
        } 
        else {
            Alert alert = new Alert(AlertType.WARNING);
            
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No event selected");
            alert.setContentText("Please select an element in the table.");
            alert.showAndWait();
        }
    }
   
    @FXML
    private void handleNewPerson() {
        Event event = new Event();
        
        boolean okClicked = mainApp.showEventEditDialog(event);
        
        if (okClicked)
           mainApp.getEventData().add(event);
    }

    @FXML
    private void handleFindElement() {
    	Event event = new Event();
    	boolean result = false;
        boolean okClicked = mainApp.showEventEditDialog(event);
        
        if (okClicked) {
        	for (var element : mainApp.getEventData()) {
        		result = event.equals(element);
        		
        		if (result) {
        			break;
        		}
        	}
        }
        
        if (result) {
           Alert alert = new Alert(AlertType.INFORMATION);
           
           alert.initOwner(mainApp.getPrimaryStage());
           alert.setTitle("Result of search");
           alert.setHeaderText("This element is in the container");
           alert.showAndWait();
        } else {
        	 Alert alert = new Alert(AlertType.INFORMATION);
             
        	 alert.initOwner(mainApp.getPrimaryStage());
             alert.setTitle("Result of search");
             alert.setHeaderText("This element is not in the container");
             alert.showAndWait();
        }
    }
}