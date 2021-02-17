package ua.khpi.oop.momot16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ua.khpi.oop.momot16.model.Event;
import ua.khpi.oop.momot16.model.EventArrayListWrapper;
import ua.khpi.oop.momot16.model.EventListWrapper;
import ua.khpi.oop.momot16.view.EventEditDialogController;
import ua.khpi.oop.momot16.view.EventOverviewController;
import ua.khpi.oop.momot16.view.RootLayoutController;

public class MainApp extends Application {
 	private ObservableList<Event> eventData = FXCollections.observableArrayList();
    private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Momot Roman. Lab 16");
        this.primaryStage.getIcons().add(new Image("file:C:\\Users\\romar\\git\\Second-Course-Java\\momot-roman\\src\\ua\\khpi\\oop\\momot16\\superthumb.jpg"));
       
        initRootLayout();
        showPersonOverview();
    }

 	public MainApp() {
		eventData.add(new Event(LocalDate.of(2005,12,15), 30, "Kharkiv, Traktorostroiteley prospect 67","Very interesting event" , "Ivanov, Petrov, Sidorov"));
		eventData.add(new Event(LocalDate.of(2021,2,17), 100, "Kiev, Central Square", "Volan De Mort, Luke Skywalker", "So Boring"));
		eventData.add(new Event(LocalDate.of(1998,10,4), 20, "Kharkiv, Sumska street 15/6", "Momot Roman, Dmytro Yampolskiy", "A lot of people"));
		eventData.add(new Event(LocalDate.of(2007,7,7), 120, "Kharkiv, Pushkinska metro station", "Balabanov, Olegov, Siromyatnikov", "Dancing all night"));
		eventData.add(new Event(LocalDate.of(2005,12,15), 5, "Харьков, Moscov prospect", "Sokol, Glavchev", "Playing games"));
 	}
   
 	/**
 	 * Returns the data as an observable list of hotel rooms. 
 	 * @return
 	 */
 	public ObservableList<Event> getEventData() {
 		return eventData;
 	}
    
 	public void initRootLayout() {
 	    try {   
 	        FXMLLoader loader = new FXMLLoader();
 	        
 	        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
 	        rootLayout = (BorderPane) loader.load();

 	        Scene scene = new Scene(rootLayout);
 	        
 	        primaryStage.setScene(scene);

 	        RootLayoutController controller = loader.getController();
 	        
 	        controller.setMainApp(this);
 	        primaryStage.show();
 	        
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }
 	}

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EventOverview.fxml"));
            
            AnchorPane hotelRoomOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(hotelRoomOverview);

            EventOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showEventEditDialog(Event event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EventEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enter data");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EventEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(event);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    /**
     * Loads hotel room data from the specified file. The current hotel room data will
     * be replaced.
     * 
     * @param file
     */
    public void loadEventsFromXMLFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(EventListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            EventListWrapper wrapper = (EventListWrapper) unmarshaller.unmarshal(file);

            eventData.clear();
            eventData.addAll(wrapper.getEvents());

        } 
        catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            alert.showAndWait();
        }
    }
    
    public void loadEventsFromSerFile(File file) {
    	try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
    		EventArrayListWrapper wrapper = (EventArrayListWrapper) ois.readObject();
    		
    		eventData.clear();
    		eventData.addAll(wrapper.getEvents());
    		
        } 
    	catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            alert.showAndWait();
        }
    }
      
    /**
     * Saves the current person data to the specified file.
     * 
     * @param file
     */
    public void saveEventsToXMLFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(EventListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            EventListWrapper wrapper = new EventListWrapper();
           
            wrapper.setEvents(eventData);
            marshaller.marshal(wrapper, file);

        } 
        catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());
            alert.showAndWait();
        }
    }
    
    public void saveEventsToSerFile(File file) {
    	try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
    		EventArrayListWrapper wrapper = new EventArrayListWrapper();
            
    		wrapper.setEvents(eventData);
            oos.writeObject(wrapper);
            oos.flush();
			
            System.out.println("Standart serialization successful\n");
		} 
    	catch (Exception e) {
			e.printStackTrace();
            
			Alert alert = new Alert(AlertType.ERROR);
            
			alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());
            alert.showAndWait();
        }
    }
}