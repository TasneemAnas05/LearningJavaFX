/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package flowpaneproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class FlowPaneClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        //root.setAlignment(Pos.CENTER);// no set alignment for it
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        Button btn5 = new Button("Button 5");
        Button btn6 = new Button("Button 6");
        Button btn7 = new Button("Button 7");
        Button btn8 = new Button("Button 8");
        Button btn9 = new Button("Button 9");
        TextField text = new TextField();
        
//        BorderPane border = new BorderPane(btn2 , btn3 , btn4 , btn6 , btn5);// center Top Right Bottom Left

        root.setCenter(btn1);
        root.setLeft(btn5);
        root.setRight(btn9);
//        root.setTop(btn2);
        root.setTop(text);// take all the row
        root.setBottom(btn7);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
