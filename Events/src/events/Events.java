/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class Events extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.err.println("Hello World!");
//            }
//        });
        //lambda expression 
//        btn.setOnAction(e->{}new ButtonEventHandler());
//        btn.setOnAction((ActionEvent event) -> {
//            System.err.println("hello!");
//
//        });
//        btn.setOnAction((ActionEvent event) -> {
//            System.err.println("hello2");
//
//        });//this is the action 

        //to add more than one action at a time 
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.err.println("Action 1");
            }

        });
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.err.println("Action 2");
            }

        });

//        btn.setOnAction(e -> {
//            System.err.println("hello!");
//        });//could write it like this 
        StackPane root = new StackPane();
        root.getChildren().add(btn);

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

class ButtonEventHandler implements EventHandler<Event> {

    @Override
    public void handle(Event event) {
        System.err.println("hello");
    }

}
