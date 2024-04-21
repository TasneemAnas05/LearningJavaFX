/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package fullcontrolsproj;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author lab1g11
 */
public class FullControlsProj extends Application {

    FlowPane togglesPane , comboPane;
    VBox radiosPane , checBoxesPane;
    

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Button togglesBtn = new Button("Toggles");
        togglesBtn.setPrefSize(100, 30);
        togglesBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                root.setCenter(togglesPane);
            }
        });
        Button radiosBtn = new Button("Radios");
        radiosBtn.setPrefSize(100, 30);
        radiosBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                root.setCenter(radiosPane);
            }
        });
        Button checkBoxBtn = new Button("Checkbox");
        checkBoxBtn.setPrefSize(100, 30);
        checkBoxBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                root.setCenter(checBoxesPane);
            }
        });
        Button combosBtn = new Button("Combo");
        combosBtn.setPrefSize(100, 30);
        combosBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                root.setCenter(comboPane);
            }
        });
        Button listsBtn = new Button("List");
        listsBtn.setPrefSize(100, 30);
        Button datePickerBtn = new Button("Date Picker");
        datePickerBtn.setPrefSize(100, 30);
        Button colorPickerBtn = new Button("Color Picker");
        colorPickerBtn.setPrefSize(100, 30);

        VBox leftSide = new VBox(8, togglesBtn, radiosBtn,checkBoxBtn ,combosBtn,  listsBtn, datePickerBtn, colorPickerBtn);
        leftSide.setStyle("-fx-background-color:blue;");
        leftSide.setPadding(new Insets(16, 24, 16, 8));

        root.setLeft(leftSide);
        buildToggles();
        buildRadios();
        buildCheckBoxes();
        buildComb();
        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    void buildToggles() {
        ToggleButton toggle1 = new ToggleButton("toggle 1");
        ToggleButton toggle2 = new ToggleButton("toggle 2");
        ToggleButton toggle3 = new ToggleButton("toggle 3");

        ToggleGroup tq = new ToggleGroup();

        toggle1.setToggleGroup(tq);
        toggle2.setToggleGroup(tq);
        toggle3.setToggleGroup(tq);

        togglesPane = new FlowPane(16, 0);
        togglesPane.getChildren().addAll(toggle1, toggle2, toggle3);
    }

    void buildRadios() {
        radiosPane = new VBox();
        RadioButton redRadio = new RadioButton("Red");
        RadioButton greenRadio = new RadioButton("Green");
        RadioButton blueRadio = new RadioButton("Blue");
        ToggleGroup tq = new ToggleGroup();//you have to add them to a group
        redRadio.setToggleGroup(tq);
        greenRadio.setToggleGroup(tq);
        blueRadio.setToggleGroup(tq);
        tq.selectToggle(redRadio);//set the red radio selected

        radiosPane = new VBox(16, redRadio, greenRadio, blueRadio);
        tq.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton oldRadio = (RadioButton) oldValue;
                RadioButton newRadio = (RadioButton) newValue;
                String message = "You have switched from " + oldRadio.getText() + " to " + newRadio.getText();
                JOptionPane.showMessageDialog(null, message);
            }

        });

    }
    void buildCheckBoxes(){
        CheckBox cb1 = new CheckBox("Small");
        CheckBox cb2 = new CheckBox("Medium");
        CheckBox cb3 = new CheckBox("Large");
        CheckBox cb4 = new CheckBox("X-Large");
        CheckBox cb5 = new CheckBox("XX-Large");
         cb1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String message;
                if(cb1.isSelected()){
                    message="You are small";
                }
                else{
                    message="You are not small";

                }
                JOptionPane.showMessageDialog(null, message);
            }
        });
        checBoxesPane = new VBox(16 ,cb1 ,cb2 , cb3 , cb4 ,cb5);
        checBoxesPane.setPadding(new Insets(32));
    }
    void buildComb(){
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().addAll("Amman" , "Zarqa" , "Aqaba" , "Irbid" , "Mafraq");
        comboBox.setVisibleRowCount(3);
        comboBox.setPromptText("Select City");
         comboBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String message = comboBox.getValue();
                
                JOptionPane.showMessageDialog(null,"You are from"+ message);
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
