import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * Name: Bhaswati Das Gupta
 * Date: 3/28/2021
 * Period: 3
 * Time: 11 hours
 * Reflection: This lab was really fun even though it was frustrating at times. I
 * was really lost in the beginning but it really helped me understand how JavaFX
 * and other applications work. I decided to make a weekly planner in which you can
 * change the theme and add assignments/events. I struggled with the layouts and event
 * handling for adding the actual assignment but it became a lot easier using checkboxes. 
 *
 */
public class P3_DasGupta_Bhaswati_GUI_3 extends Application{
	private ChoiceBox<String> cb;
	private Button Sunday;
	private Button Monday;
	private Button Tuesday;
	private Button Wednesday;
	private Button Thursday;
	private Button Friday;
	private Button Saturday;
	private Label calLabel;
	private Button addButton;
	private ChoiceBox<String> dayPicker;
	private ListView<String> addOptions;
	private TextField text;
	private VBox mondayList;
	private VBox tuesdayList;
	private VBox wednesdayList;
	private VBox thursdayList;
	private VBox fridayList;
	private VBox saturdayList;
	private VBox sundayList;
	

	public static void main (String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		final int SCENE_WIDTH = 1500;
		final int SCENE_HEIGHT = 900;
		stage.setTitle("Personal Weekly Planner");
		VBox vbox = new VBox(SCENE_WIDTH / 50);
		Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);



		//Calendar Label 
		calLabel = new Label("Weekly Planner");
		calLabel.setContentDisplay(ContentDisplay.CENTER);
		calLabel.setFont(Font.font("Brush Script MT", FontWeight.BOLD, SCENE_WIDTH / 15));
		calLabel.setTextFill(Color.CRIMSON);
		calLabel.setMaxWidth(Double.MAX_VALUE);
		AnchorPane.setLeftAnchor(calLabel, 0.0);
		AnchorPane.setRightAnchor(calLabel, 0.0);

		calLabel.setAlignment(Pos.CENTER);


		//Month Picker **Question: How to center Box
		Label themeLabel = new Label("Theme: ");

		cb = new ChoiceBox<String>();
		cb.getItems().addAll("Crimson", "Aquamarine", "Blueviolet", "Coral", "Sea Green", "Golden Rod");
		cb.getSelectionModel().selectFirst();
		AnchorPane.setLeftAnchor(cb, 0.0);
		AnchorPane.setRightAnchor(cb, 0.0);
		//		ChoiceBoxHandler themeHandler = new ChoiceBoxHandler();
		MyChangeListener themeHandler = new MyChangeListener();
		cb.valueProperty().addListener(themeHandler);
		//		cb.setOnAction(themeHandler);


		//Days of Week
		HBox hbox2 = new HBox();
		hbox2.setSpacing(SCENE_WIDTH / 200);
		Sunday = new Button("Sunday");
		Sunday.setPrefSize(SCENE_WIDTH / 7,45);
		Monday = new Button("Monday");
		Monday.setPrefSize(SCENE_WIDTH / 7,45);
		Tuesday = new Button("Tuesday");
		Tuesday.setPrefSize(SCENE_WIDTH / 7,45);
		Wednesday = new Button("Wednesday");
		Wednesday.setPrefSize(SCENE_WIDTH / 7,45);
		Thursday = new Button("Thursday");
		Thursday.setPrefSize(SCENE_WIDTH / 7,45);
		Friday = new Button("Friday");
		Friday.setPrefSize(SCENE_WIDTH / 7,45);
		Saturday = new Button("Saturday");
		Saturday.setPrefSize(SCENE_WIDTH / 7,45);
		Sunday.setTextFill(Color.ALICEBLUE);
		Sunday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
		Monday.setTextFill(Color.ALICEBLUE);
		Monday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
		Tuesday.setTextFill(Color.ALICEBLUE);
		Tuesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
		Wednesday.setTextFill(Color.ALICEBLUE);
		Wednesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
		Thursday.setTextFill(Color.ALICEBLUE);
		Thursday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
		Friday.setTextFill(Color.ALICEBLUE);
		Friday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
		Saturday.setTextFill(Color.ALICEBLUE);
		Saturday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");

		mondayList = new VBox();
		mondayList.setMaxWidth(SCENE_WIDTH / 7);
		tuesdayList = new VBox();
		tuesdayList.setMaxWidth(SCENE_WIDTH / 7);
		wednesdayList = new VBox();
		wednesdayList.setMaxWidth(SCENE_WIDTH / 7);
		thursdayList = new VBox();
		thursdayList.setMaxWidth(SCENE_WIDTH / 7);
		fridayList = new VBox();
		fridayList.setMaxWidth(SCENE_WIDTH / 7);
		saturdayList = new VBox();
		saturdayList.setMaxWidth(SCENE_WIDTH / 7);
		sundayList = new VBox();
		sundayList.setMaxWidth(SCENE_WIDTH / 7);
		
		mondayList.getChildren().addAll(Monday);
		tuesdayList.getChildren().addAll(Tuesday);
		wednesdayList.getChildren().addAll(Wednesday);
		thursdayList.getChildren().addAll(Thursday);
		fridayList.getChildren().addAll(Friday);
		saturdayList.getChildren().addAll(Saturday);
		sundayList.getChildren().addAll(Sunday);
		

		hbox2.getChildren().addAll(sundayList, mondayList, tuesdayList, wednesdayList, thursdayList, fridayList, saturdayList);
		hbox2.setPrefSize(700, 45);
		hbox2.setAlignment(Pos.CENTER);



		//Adding Menu
		String[] add = { "Assignment", "Test", "Event", "Class", "Appointment/Meeting" };


		GridPane grid = new GridPane();
		grid.setPadding(new Insets(0, 0, SCENE_WIDTH / 100, SCENE_WIDTH / 100));


		Label label2 = new Label("Add: ");
		GridPane.setConstraints(label2, SCENE_WIDTH / 500, 0);

		addOptions = new ListView<>(FXCollections.observableArrayList(add));
		addOptions.setPrefWidth(SCENE_WIDTH / 5);
		addOptions.setPrefHeight(SCENE_WIDTH / 25);
		addOptions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		GridPane.setConstraints(addOptions, SCENE_WIDTH / 100, 0);

		//Add Text Box
		Label textLabel = new Label("Enter the name of what you would like to add: ");
		text = new TextField("Enter Name");
		text.setMaxSize(SCENE_WIDTH / 5, TextField.USE_COMPUTED_SIZE);

		//Day Picker
		Label dayPickerLabel = new Label("Day: ");

		dayPicker = new ChoiceBox<String>();
		dayPicker.getItems().addAll("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
		dayPicker.getSelectionModel().selectFirst();
		AnchorPane.setLeftAnchor(dayPicker, 0.0);
		AnchorPane.setRightAnchor(dayPicker, 0.0);

		//Add Button 

		addButton = new Button("Add");
		addButton.setPrefSize(SCENE_WIDTH / 10,45);
		MyEventHandler addHandler = new MyEventHandler();
		addButton.setOnMouseClicked(addHandler);
		


		grid.getChildren().addAll(label2, addOptions);

		HBox menu = new HBox();
		menu.setSpacing(20);

		menu.getChildren().addAll(themeLabel, cb, grid, textLabel, text, dayPickerLabel, dayPicker, addButton);

		vbox.getChildren().addAll(calLabel, menu, hbox2);


		stage.setScene(scene);
		stage.show();
	}
	private class MyEventHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() == addButton) {
				String day = dayPicker.getValue();
				String addOption = addOptions.getSelectionModel().getSelectedItem();
				String name = text.getText();
				CheckBox add = new CheckBox(addOption + ": " + name);
				add.setWrapText(true);
				if (day == "Monday") {
					mondayList.getChildren().add(add);
				}else if(day == "Tuesday") {
					tuesdayList.getChildren().add(add);
				}else if(day == "Wednesday") {
					wednesdayList.getChildren().add(add);
				}else if(day == "Thursday") {
					thursdayList.getChildren().add(add);
				}else if(day == "Friday") {
					fridayList.getChildren().add(add);
				}else if(day == "Saturday") {
					saturdayList.getChildren().add(add);
				}else if(day == "Sunday") {
					sundayList.getChildren().add(add);
				}
				
			}
		}
	}

	private class MyChangeListener implements ChangeListener<String>{

		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			if (newValue == "Aquamarine") {
				Sunday.setTextFill(Color.BLUE); 
				Sunday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #7FFFD4; -fx-border-width: 2");
				Monday.setTextFill(Color.BLUE);
				Monday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #7FFFD4; -fx-border-width: 2");
				Tuesday.setTextFill(Color.BLUE);
				Tuesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #7FFFD4; -fx-border-width: 2");
				Wednesday.setTextFill(Color.BLUE);
				Wednesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #7FFFD4; -fx-border-width: 2");
				Thursday.setTextFill(Color.BLUE);
				Thursday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #7FFFD4; -fx-border-width: 2");
				Friday.setTextFill(Color.BLUE);
				Friday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #7FFFD4; -fx-border-width: 2");
				Saturday.setTextFill(Color.BLUE);
				Saturday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #7FFFD4; -fx-border-width: 2");
				calLabel.setTextFill(Color.AQUAMARINE);
			}else if (newValue == "Crimson") {
				Sunday.setTextFill(Color.ALICEBLUE);
				Sunday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
				Monday.setTextFill(Color.ALICEBLUE);
				Monday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
				Tuesday.setTextFill(Color.ALICEBLUE);
				Tuesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
				Wednesday.setTextFill(Color.ALICEBLUE);
				Wednesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
				Thursday.setTextFill(Color.ALICEBLUE);
				Thursday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
				Friday.setTextFill(Color.ALICEBLUE);
				Friday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
				Saturday.setTextFill(Color.ALICEBLUE);
				Saturday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DC143C; -fx-border-width: 2");
				calLabel.setTextFill(Color.CRIMSON);
			}else if(newValue == "Blueviolet") {
				Sunday.setTextFill(Color.ALICEBLUE);
				Sunday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #8A2BE2; -fx-border-width: 2");
				Monday.setTextFill(Color.ALICEBLUE);
				Monday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #8A2BE2; -fx-border-width: 2");
				Tuesday.setTextFill(Color.ALICEBLUE);
				Tuesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #8A2BE2; -fx-border-width: 2");
				Wednesday.setTextFill(Color.ALICEBLUE);
				Wednesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #8A2BE2; -fx-border-width: 2");
				Thursday.setTextFill(Color.ALICEBLUE);
				Thursday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #8A2BE2; -fx-border-width: 2");
				Friday.setTextFill(Color.ALICEBLUE);
				Friday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #8A2BE2; -fx-border-width: 2");
				Saturday.setTextFill(Color.ALICEBLUE);
				Saturday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #8A2BE2; -fx-border-width: 2");
				calLabel.setTextFill(Color.BLUEVIOLET);
			}else if(newValue == "Coral") {
				Sunday.setTextFill(Color.PURPLE);
				Sunday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #FF7F50; -fx-border-width: 2");
				Monday.setTextFill(Color.PURPLE);
				Monday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #FF7F50; -fx-border-width: 2");
				Tuesday.setTextFill(Color.PURPLE);
				Tuesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #FF7F50; -fx-border-width: 2");
				Wednesday.setTextFill(Color.PURPLE);
				Wednesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #FF7F50; -fx-border-width: 2");
				Thursday.setTextFill(Color.PURPLE);
				Thursday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #FF7F50; -fx-border-width: 2");
				Friday.setTextFill(Color.PURPLE);
				Friday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #FF7F50; -fx-border-width: 2");
				Saturday.setTextFill(Color.PURPLE);
				Saturday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #FF7F50; -fx-border-width: 2");
				calLabel.setTextFill(Color.CORAL);
			}else if(newValue == "Sea Green") {
				Sunday.setTextFill(Color.WHITE);
				Sunday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #2E8B57; -fx-border-width: 2");
				Monday.setTextFill(Color.WHITE);
				Monday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #2E8B57; -fx-border-width: 2");
				Tuesday.setTextFill(Color.WHITE);
				Tuesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #2E8B57; -fx-border-width: 2");
				Wednesday.setTextFill(Color.WHITE);
				Wednesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #2E8B57; -fx-border-width: 2");
				Thursday.setTextFill(Color.WHITE);
				Thursday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #2E8B57; -fx-border-width: 2");
				Friday.setTextFill(Color.WHITE);
				Friday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #2E8B57; -fx-border-width: 2");
				Saturday.setTextFill(Color.WHITE);
				Saturday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #2E8B57; -fx-border-width: 2");
				calLabel.setTextFill(Color.SEAGREEN);
			}else if(newValue == "Golden Rod") {
				Sunday.setTextFill(Color.BROWN);
				Sunday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DAA520; -fx-border-width: 2");
				Monday.setTextFill(Color.BROWN);
				Monday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DAA520; -fx-border-width: 2");
				Tuesday.setTextFill(Color.BROWN);
				Tuesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DAA520; -fx-border-width: 2");
				Wednesday.setTextFill(Color.BROWN);
				Wednesday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DAA520; -fx-border-width: 2");
				Thursday.setTextFill(Color.BROWN);
				Thursday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DAA520; -fx-border-width: 2");
				Friday.setTextFill(Color.BROWN);
				Friday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DAA520; -fx-border-width: 2");
				Saturday.setTextFill(Color.BROWN);
				Saturday.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-background-color: #DAA520; -fx-border-width: 2");
				calLabel.setTextFill(Color.GOLDENROD);
			}
		}


	}

}








