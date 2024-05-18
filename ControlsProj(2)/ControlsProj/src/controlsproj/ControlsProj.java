/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controlsproj;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ControlsProj extends Application {
    
    Button centerButton;
    VBox centerBox;
    
    @Override
    public void start(Stage primaryStage) {
        
        buildCenterButton();
        
        BorderPane borderLayout = new BorderPane();
        
        borderLayout.setCenter(centerBox);
        
        Node top= buildTopNode();
        borderLayout.setTop(top);
        
        borderLayout.setBottom(buildBottomNode());
        borderLayout.setRight(buildRightNode());
        borderLayout.setLeft(buildLeftNode());
        
        Scene scene = new Scene(borderLayout, 600, 600);
        primaryStage.setTitle("Controls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buildCenterButton(){
        centerButton= new Button();
        centerButton.setPrefSize(150, 100);
        centerButton.setDefaultButton(true);
        
        centerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Center button clicked");
            }
        });
        
        String imagePath= "C:\\Users\\Lenovo\\Desktop\\pic\\22.jpg";
        try{
            FileInputStream fis= new FileInputStream(imagePath);
            Image image= new Image(fis,150,100,true, true);
            ImageView imageView= new ImageView(image);
            centerButton.setGraphic(imageView);
            
        }catch(Exception e){
            System.err.println("File not found");
        }
        
        ComboBox<String> combo= new ComboBox<String>();
        combo.getItems().addAll("item 1", "item 2", "item 3", "item 4", "item 5");
        combo.setPromptText("Select item");
        combo.setVisibleRowCount(3);
        
        combo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedItem= combo.getValue();
                JOptionPane.showMessageDialog(null, "You selected: "+selectedItem);
            }
        });
        
        centerBox= new VBox(8, centerButton, combo);
        centerBox.setAlignment(Pos.CENTER);
    }
    
    private Node buildTopNode(){
        
        Button topButton= new Button("Top Button");
        topButton.setPrefSize(80, 70);
        topButton.setCancelButton(true);
        topButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Top button clicked");
            }
        });
        HBox topBox= new HBox(topButton);
        topBox.setStyle("-fx-background-color: blue;");
        topBox.setPadding(new Insets(8,8,8,8));
        topBox.setAlignment(Pos.CENTER);
        
        return topBox;
    }
    
    private Node buildBottomNode(){
        Label bottomLabel= new Label("This is a label \n sec line");
        bottomLabel.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        bottomLabel.setTextFill(Color.BLUE);
        bottomLabel.setStyle("-fx-background-color: red;");
        bottomLabel.setPrefWidth(400);
        bottomLabel.setTextAlignment(TextAlignment.CENTER);
        return bottomLabel;
    }
    
    private Node buildRightNode(){
        ToggleButton toggle1= new ToggleButton("Toggle 1");
        ToggleButton toggle2= new ToggleButton("Toggle 2");
        ToggleButton toggle3= new ToggleButton("Toggle 3");
        
        toggle1.setPrefSize(120, 60);
        toggle2.setPrefSize(120, 60);
        toggle3.setPrefSize(120, 60);
        
        ToggleGroup group= new ToggleGroup();
        
        toggle1.setToggleGroup(group);
        toggle2.setToggleGroup(group);
        toggle3.setToggleGroup(group);
        
        group.selectedToggleProperty().addListener(
                new ChangeListener<Toggle>() {
            @Override
            public void changed(
                    ObservableValue<? extends Toggle> observable, 
                    Toggle oldValue, 
                    Toggle newValue
            ) {
                ToggleButton oldToggle= (ToggleButton)oldValue;
                ToggleButton newToggle= (ToggleButton)newValue;
                
                String message= "You have switched from "+
                        oldToggle.getText()+
                        " to "+
                        newToggle.getText();
                JOptionPane.showMessageDialog(null, message);
                
                centerButton.setVisible(toggle1.isSelected() || toggle2.isSelected());
            }
          } 
        );
        
        VBox togglesBox= new VBox(8, toggle1, toggle2, toggle3);
        
        return togglesBox;
    }
    
    private Node buildLeftNode(){
        RadioButton rb1= new RadioButton("First Option");
        RadioButton rb2= new RadioButton("Second Option");
        RadioButton rb3= new RadioButton("Third Option");
        
        ToggleGroup radiosGroup= new ToggleGroup();
        rb1.setToggleGroup(radiosGroup);
        rb2.setToggleGroup(radiosGroup);
        rb3.setToggleGroup(radiosGroup);
        
        radiosGroup.selectToggle(rb1);
        
        
        CheckBox cb1= new CheckBox("check box 1");
        CheckBox cb2= new CheckBox("check box 2");
        CheckBox cb3= new CheckBox("check box 3");
        cb3.setAllowIndeterminate(true);
        
        cb3.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(
                    ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, 
                    Boolean newValue
            ) {
                System.out.println("selected from selectedProperty: "+cb3.isSelected());
                System.out.println("indeterminate from selectedProperty: "+cb3.isIndeterminate());
            }
        });
        
        cb3.indeterminateProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(
                    ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, 
                    Boolean newValue
            ) {
                System.out.println("selected from indeterminateProperty: "+cb3.isSelected());
                System.out.println("indeterminate from indeterminateProperty: "+cb3.isIndeterminate());
            }
        });
        
        VBox radiosBox= new VBox(16, rb1, rb2, rb3, cb1 , cb2, cb3);
        radiosBox.setAlignment(Pos.CENTER_LEFT);
        
        return radiosBox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
