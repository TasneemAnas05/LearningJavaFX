/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controllerapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author lab1g11
 */
public class ControllerApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        
        GridPane root2 = new GridPane();
        root2.setAlignment(Pos.CENTER);
        Scene scene2 = new Scene(root2 , 500 ,500);
        Button secondScreenButton = new Button("Second Screen");
        root2.add(secondScreenButton , 0 , 0);
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);//the grid centered
        Label titleLabel = new Label("Title");
        Label opacityLabel = new Label("Opacity");
        Label focusLabel = new Label("Focus");
        Label cursorLabel = new Label("Cursor");
        
        TextField titleField = new TextField();
        TextField opacityField = new TextField();
        TextField focusField = new TextField();
        TextField cursorField = new TextField();
        
        Button titleBtn = new Button("set title");
        Button opacityBtn = new Button("set opacity");
        Button focusBtn = new Button("set focus");
        Button cursorBtn = new Button("set cursor");
        Button navigateBtn = new Button("Navigate");
        
        root.add(titleLabel , 0 , 0);
        root.add(titleField ,1  , 0);
        root.add(titleBtn ,2 , 0);
        
        root.add(opacityLabel , 0 , 1);
        root.add(opacityField ,1  , 1);
        root.add(opacityBtn ,2 , 1);
        
        root.add(focusLabel , 0 , 2);
        root.add(focusField ,1  , 2);
        root.add(focusBtn ,2 , 2);
        
        root.add(cursorLabel , 0 , 3);
        root.add(cursorField ,1  , 3);
        root.add(cursorBtn ,2 , 3);
        
        root.add(navigateBtn , 1, 4);
       
       titleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userInput=titleField.getText();
               primaryStage.setTitle(userInput);
            }
       });
       opacityBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String userInput=opacityField.getText();
               double op=Double.parseDouble(userInput);
               if(op>= 0 && op<=1){
                  primaryStage.setOpacity(op);

               }
               else{
                  // JOptionPane.showConfirmDialog(parentComponent, event, userInput, 0, 0, icon)
               }
            }
       });
       focusBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String userInput=focusField.getText();
               int focusInt=Integer.parseInt(userInput);
               switch(focusInt){
                   case 1: titleField.requestFocus();
                           break;
                   case 2:opacityField.requestFocus();
                           break;
                   case 3:opacityBtn.requestFocus();
                           break;
               }
            }
       });
        
        Scene scene = new Scene(root, 300, 250);
        
       cursorBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String userInput=cursorField.getText();
               int cursorInt=Integer.parseInt(userInput);
               switch(cursorInt){
                   case 1: scene.setCursor(Cursor.WAIT);
                           break;
                   case 2:scene.setCursor(Cursor.HAND);
                           break;
                   case 3:scene.setCursor(Cursor.TEXT);
                           break;
               }
            }
       });
       navigateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               primaryStage.setScene(scene2);
            }
       });
       secondScreenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               primaryStage.setScene(scene);
            }
       });
        primaryStage.setTitle("Controller App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
