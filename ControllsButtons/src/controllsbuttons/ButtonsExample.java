/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controllsbuttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class ButtonsExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("This is button 1");
        Button btn2 = new Button("This is button 2");
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               //btn1.setText("Text changed");
               // btn1.setDisable(true);
               btn1.setVisible(false);
            }
            
        });
        btn2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               //btn1.setText("Text changed");
               // btn1.setDisable(true);
               btn1.setVisible(true);//set visible button 1
            }
            
        });
        //btn1.setPrefSize(200, 80);//change the size 
        btn1.setTooltip(new Tooltip("This is tooltip"));
        btn1.setFont(Font.font("Arial ", 30));
        btn1.setWrapText(false);//to show the whole button (true)
        //btn1.setDisable(true);
        VBox root = new VBox();
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Controlls Example");
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
