/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hello3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class Hello3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        VBox root = new VBox();
        Label firstNumberLabel = new Label("first number");
        Label secondNumberLabel = new Label("second number");
        TextField firstNumberField = new TextField();
        TextField secondNumberField = new TextField();
        
       
        
        Scene scene = new Scene(root, 600, 600);
        HBox buttonsBox = new HBox();
        Button add = new Button("+");//you can pass the title of Button as a parameter
//        add.setText("+");
        Button sub = new Button("-");
//        add.setText("-");

        Button mul = new Button("x");
//        add.setText("mul");

        Button div = new Button("/");
//        add.setText("/");
           Label resultLabel = new Label("result");

         add.setOnAction(new EventHandler(){
          

            @Override
            public void handle(Event event) {
                int firstNumber = Integer.parseInt(firstNumberField.getText());
                int secondNumber = Integer.parseInt(secondNumberField.getText());
                int result = firstNumber+secondNumber;
                resultLabel.setText(result+"");
            }
         });
         buttonsBox.getChildren().addAll(
                add ,
                sub ,
                mul ,
                div );
        
         root.getChildren().addAll(
                firstNumberLabel ,
                firstNumberField ,
                secondNumberLabel ,
                secondNumberField, 
                buttonsBox , 
                resultLabel);
//        root.getChildren().add(buttonsBox);
        primaryStage.setTitle("Simple Caculator!");
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
