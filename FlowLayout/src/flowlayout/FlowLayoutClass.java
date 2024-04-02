/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package flowlayout;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class FlowLayoutClass extends Application {
    Scene scene2 ;//global for  class
    @Override
    public void start(Stage primaryStage) {
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
        
//        FlowPane root = new FlowPane();
//        FlowPane root = new FlowPane(Orientation.VERTICAL);
//        FlowPane root = new FlowPane(Orientation.VERTICAL , 10 , 20);
        FlowPane root = new FlowPane(Orientation.HORIZONTAL , 10 , 20);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        root.getChildren().add(btn7);
        root.getChildren().add(btn8);
        root.getChildren().add(btn9);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                buildScene2();
                primaryStage.setScene(scene2);
        }
                });
    }

    /**
     * @param args the command line arguments
     */
    public void buildScene2(){
//        HBox hbox = new HBox();//without add
        Button btn1  = new Button("first");
        Button btn2  = new Button("second");
        Button btn3  = new Button("third");
        Button btn4  = new Button("fourth");
        Button btn5  = new Button("fifth");
        HBox hbox = new HBox(btn1 , btn2 , btn3 , btn4 , btn5);
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(50 , 20 , 10 ,5));

        scene2= new Scene(hbox , 500 , 500);
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
