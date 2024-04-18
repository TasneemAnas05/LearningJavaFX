/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package exampleproj;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ExampleProj extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root= new BorderPane();  // main layout
        BorderPane topLayout= new BorderPane(); // Top layout
        BorderPane bottomLayout= new BorderPane(); // Bottom layout
        
        Button btn1= new Button("One");
        Button btn2= new Button("Two");
        Button btn3= new Button("Three");
        Button btn4= new Button("Four");
        Button btn5= new Button("Five");
        
        topLayout.setLeft(btn1);
        topLayout.setTop(btn2);
        topLayout.setRight(btn3);
        topLayout.setBottom(btn4);
        topLayout.setCenter(btn5);
        
        Label lb1= new Label("One");
        Label lb2= new Label("Two");
        Label lb3= new Label("Three");
        Label lb4= new Label("Four");
        Label lb5= new Label("Five");
        bottomLayout.setLeft(lb1);
        bottomLayout.setTop(lb2);
        bottomLayout.setRight(lb3);
        bottomLayout.setBottom(lb4);
        bottomLayout.setCenter(lb5);
        
        GridPane centerLayout= new GridPane();
        centerLayout.setAlignment(Pos.CENTER);
        TextField txt1= new TextField();
        TextField txt2= new TextField();
        TextField txt3= new TextField();
        TextField txt4= new TextField();
        txt1.setPrefSize(100, 30);
        txt2.setPrefSize(100, 30);
        txt3.setPrefSize(100, 30);
        txt4.setPrefSize(100, 30);
        
        centerLayout.add(txt1, 0, 0);
        centerLayout.add(txt2, 1, 0);
        centerLayout.add(txt3, 0, 1);
        centerLayout.add(txt4, 1, 1);
        
        
        root.setTop(topLayout);
        root.setBottom(bottomLayout);
        root.setCenter(centerLayout);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Layout example");
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
