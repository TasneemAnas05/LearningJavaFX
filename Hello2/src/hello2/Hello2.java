/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hello2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class Hello2 extends Application {
    public Hello2(){
        System.out.println("Constructor called");
   }
    //called by sys
    public void init(){
        System.out.println("init called");
//        Stage s = new Stage();
//        s.show();
    }
    
    @Override
    public void start(Stage primaryStage) {
        System.out.println("start called");
        Button b = new Button();
        b.setText("button");
        VBox root = new VBox();
        root.getChildren().add(b);
        Scene scene = new Scene(root , 400 , 400);
        Button b2 = new Button();
        b2.setText("button 2");
        HBox root2 = new HBox();
        root2.getChildren().add(b2);
        scene.setRoot(root2);
        //------------------------------
//        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(300);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setMaxWidth(800);
        primaryStage.setMaxHeight(800);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Hello world!");
        primaryStage.setOpacity(0.9);
        primaryStage.setX(200);
        primaryStage.setY(200);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Stage stage2=new Stage();
        stage2.setTitle("Stage 2");
        stage2.show();
        
//         Stage s = new Stage();
//        s.show();
    }
    public void close(){
        System.out.println("close called");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}