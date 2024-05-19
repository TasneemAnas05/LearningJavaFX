/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package fullcontrolsproj;

import java.time.LocalDate;
import java.time.Month;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ASU
 */
public class FullControlsProj extends Application {
    
    FlowPane togglesPane, comboPane , colorPane;
    VBox radiosPane , checkBoxesPane;
    HBox listsPane;
    GridPane datePane;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        Hyperlink togglesBtn= new Hyperlink("Toggles");
        togglesBtn.setPrefSize(100, 30);
        togglesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(togglesPane);
            }
        });


        Button radiosBtn= new Button("Radios");
        radiosBtn.setPrefSize(100, 30);
        radiosBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(radiosPane);
            }
        });
        
        Button checkBoxesBtn= new Button("CheckBoxes");
        checkBoxesBtn.setPrefSize(100, 30);
        checkBoxesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(checkBoxesPane);
            }
        });
        
        Button comboBoxBtn= new Button("Combo");
        comboBoxBtn.setPrefSize(100, 30);
        comboBoxBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(comboPane);
            }
        });
        
        Button listsBtn= new Button("Lists");
        listsBtn.setPrefSize(100, 30);
        listsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(listsPane);
            }
        });
        
        
        Button datePickerBtn= new Button("Date");
        datePickerBtn.setPrefSize(100, 30);
        datePickerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(datePane);
            }
        });
        
        Button colorPickerBtn= new Button("Color");
        colorPickerBtn.setPrefSize(100, 30);
        colorPickerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setCenter(colorPane);
            }
        });
        
        VBox leftSide= new VBox(8, togglesBtn, radiosBtn,checkBoxesBtn,
                comboBoxBtn,listsBtn,datePickerBtn,
                colorPickerBtn);
        leftSide.setStyle("-fx-background-color:#458a10;");
        leftSide.setPadding(new Insets(16, 24, 16, 8));
       
        root.setLeft(leftSide);
        
        buildToggles();
        buildRadios();
        buildCheckBoxes();
        buildCombo();
        buildLists();
        buildDatePicker();
        buildColorPane();
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Controls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    void buildToggles(){
        
        ToggleButton toggle1= new ToggleButton("Toggle 1");
        ToggleButton toggle2= new ToggleButton("Toggle 2");
        ToggleButton toggle3= new ToggleButton("Toggle 3");
        
        ToggleGroup tg= new ToggleGroup();
        
        toggle1.setToggleGroup(tg);
        toggle2.setToggleGroup(tg);
        toggle3.setToggleGroup(tg);
        
        togglesPane= new FlowPane(16,0);
        togglesPane.getChildren().addAll(toggle1, toggle2, toggle3);
    }
    
    void buildRadios(){
        RadioButton redRadio= new RadioButton("RED");
        RadioButton greenRadio= new RadioButton("GREEN");
        RadioButton blueRadio= new RadioButton("BLUE");
        
        ToggleGroup tg= new ToggleGroup();//only one choice
        //setToggleGroup to all
        redRadio.setToggleGroup(tg);
        greenRadio.setToggleGroup(tg);
        blueRadio.setToggleGroup(tg);
        
        tg.selectToggle(redRadio);
        radiosPane= new VBox(16 , redRadio, greenRadio, blueRadio);
        
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(
                    ObservableValue<? extends Toggle> observable, 
                    Toggle oldValue, 
                    Toggle newValue
            ) {
                RadioButton oldRadio= (RadioButton) oldValue;
                RadioButton newRadio= (RadioButton) newValue;
                
                String message= "You have switched from " + oldRadio.getText()+ " to "+ newRadio.getText();
                
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
    
    void buildCheckBoxes(){
        CheckBox cb1= new CheckBox("Small");
        CheckBox cb2= new CheckBox("Medium");
        CheckBox cb3= new CheckBox("Large");
        CheckBox cb4= new CheckBox("X-Large");
        CheckBox cb5= new CheckBox("XX_Large");
        
        cb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String message;
                if(cb1.isSelected()){
                    message= "You are small";
                }else{
                    message= "You are NOT small";
                }
                JOptionPane.showMessageDialog(null, message);
            }
        });
        
        checkBoxesPane= new VBox(16, cb1, cb2, cb3, cb4, cb5);
        checkBoxesPane.setPadding(new Insets(32));
    }

    void buildCombo(){
        ComboBox<String> comboBox= new ComboBox<String>();
        comboBox.getItems().addAll("Amman","Zarqa","Aqaba","Irbid","Mafraq");
        comboBox.setVisibleRowCount(3);
        comboBox.setPromptText("Select City");
        
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String message= comboBox.getValue();
                JOptionPane.showMessageDialog(null, "You are from "+message);
            }
        });
        
        comboPane= new FlowPane(comboBox);
    }
    
    void buildLists(){
        ListView<String> firstList= new ListView<String>();
        firstList.getItems().addAll("Item 1","Item 2","Item 3","Item 4","Item 5");
        firstList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        ListView<String> secondList= new ListView<String>();
        
        Button printBtn= new Button("Print");
        Button clearBtn= new Button("Clear");
        Button moveBtn= new Button("Move");
        VBox buttonsBox= new VBox(8,printBtn, clearBtn, moveBtn);
        buttonsBox.setAlignment(Pos.CENTER);
         //print the last item selected

        printBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("selected item: "+ firstList.getSelectionModel().getSelectedItem());
                System.out.println("selected index: " + firstList.getSelectionModel().getSelectedIndex());
                System.out.println("selected items: "+ firstList.getSelectionModel().getSelectedItems());
                System.out.println("selected indecies: " + firstList.getSelectionModel().getSelectedIndices());
                System.out.println("Focused item: "+ firstList.getFocusModel().getFocusedItem());
                System.out.println("Focused index: "+ firstList.getFocusModel().getFocusedIndex());
            }
        });
        
        clearBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                firstList.getSelectionModel().clearSelection();//clear the selected item or items
            }
        });
        
        moveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selected= firstList.getSelectionModel().getSelectedItem();
                if(secondList.getItems().contains(selected)){
                    JOptionPane.showMessageDialog(null, selected+ " already exist");
                }else{
                    secondList.getItems().add(selected);
                    firstList.getItems().remove(selected);
                }
                
            }
        });
        
        listsPane= new HBox(8, firstList, buttonsBox, secondList);
    }
    
    void buildDatePicker(){
        DatePicker datePicker= new DatePicker(LocalDate.of(2002,7,14));//local date
        datePicker.setEditable(false);//the user can not write anything just chose
        datePicker.setShowWeekNumbers(true);
        
        Label label= new Label();
        label.setFont(Font.font("Arial",32));
        
        datePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate selectedDate= datePicker.getValue();
                label.setText(selectedDate.toString());//casting toString
            }
        });
        
        datePane= new GridPane(16, 16);
        datePane.add(datePicker, 0, 0);
        datePane.add(label, 0, 1);
        datePane.setAlignment(Pos.CENTER);
        
    }
    
    void buildColorPane(){
        ColorPicker colorPicker= new ColorPicker(Color.AQUA);
        
        Label testLabel= new Label("This is a label");
        testLabel.setFont(Font.font("Arial",32));
        
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Color selectedColor= colorPicker.getValue();
                testLabel.setTextFill(selectedColor);
            }
        });
        
        colorPane= new FlowPane(Orientation.VERTICAL, colorPicker, testLabel);
        colorPane.setAlignment(Pos.CENTER);
        
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
