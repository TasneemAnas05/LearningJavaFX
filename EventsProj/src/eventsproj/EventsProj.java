/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package eventsproj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class EventsProj extends Application implements EventHandler<ActionEvent> {
    Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
        FlowPane root = new FlowPane();
        btn1 =new Button("Button 1");
        btn2 =new Button("Button 2");
        btn3 =new Button("Button 3");
        btn4 =new Button("Button 4");
        btn5 =new Button("Button 5");
        btn6 =new Button("Button 6");
        btn7 =new Button("Button 7");
        btn8 =new Button("Button 8");
         root.getChildren().addAll(btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Anonymous class event handler ");
            }
        });
        btn2.setOnAction(e->{
            System.err.println("Lambda expression event handler ");//method body
        });
        
//        btn3.setOnAction(e->{printMessage();}); // implement and inside call method
        btn3.setOnAction(e->printMessage());
        MyHandler myHandler = new MyHandler();//for any button you wish
        btn4.setOnAction(myHandler);
        btn5.setOnAction(myHandler);
        btn6.setOnAction(this);//the class in which you are in it
        btn7.addEventHandler(MouseEvent.MOUSE_CLICKED, 
                 e->{
                     System.out.println("ADD EVENT HANDLER");
                 }
                );
//        btn8.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
//            System.out.println("btn8 event handler");
//        });
        btn8.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{
            System.out.println("btn8 event filter");
        });
        btn7.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{
            System.out.println("btn7 event filter");
        });
        root.addEventFilter(MouseEvent.MOUSE_CLICKED,
                e->{
            System.out.println("Root event filter");
//            e.consume();//stop and do not pass it to children
            
        });
        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{
            System.out.println("Stage event filter");
        });
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Action World!");
//            }
//        });
//        btn.addEventHandler(MouseEvent.MOUSE_CLICKED ,
//                new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("Mouse Event");
//            }}
//                );
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    void printMessage(){
        System.out.println("Lambda expression method call");
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("applcation class evnt handler");    }
    
    class MyHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           if( event.getSource()==btn4){
            System.out.println("inner class event handler from btn4");
           }
           else
           {
                 System.out.println("inner class event handler from btn5");

           }
        }
        
    }
}
