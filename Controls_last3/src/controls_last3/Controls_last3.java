/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controls_last3;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author lab1g11
 */
public class Controls_last3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       

        Hyperlink link1 = new Hyperlink("wwww.google.com");
        Hyperlink link2 = new Hyperlink("wwww.facebook.com");
        link1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "google link clicked");
            }
        });
        DatePicker datePicker = new DatePicker( LocalDate.of(2021,7 , 18));
        Label testLable = new Label("Test Label");
        //missing style 

        datePicker.setEditable(false);
       // datePicker.showWeeksNumber(true);//by default it is false
         datePicker.setOnAction(new EventHandler<ActionEvent>() {//action on picker
            
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = datePicker.getValue();
                JOptionPane.showMessageDialog(null, date);
            }
        });
        
        Button btn1 = new Button("show date");
         btn1.setOnAction(new EventHandler<ActionEvent>() {//action on button
            
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = datePicker.getValue();
                testLable.setText(date.toString());
                //JOptionPane.showMessageDialog(null, date);
                
            }
        });
        datePicker.getValue();//return local date
        ColorPicker colorPicker = new ColorPicker(Color.BLUE);//by default it is white
          colorPicker.setOnAction(new EventHandler<ActionEvent>() {//action on button
            
            @Override
            public void handle(ActionEvent event) {
                Color  selectColor =colorPicker.getValue();
                JOptionPane.showMessageDialog(null, selectColor);
            }
        });
        VBox root = new VBox(16 , link1 , link2 , datePicker , btn1 , colorPicker ,testLable);
        
        
        Scene scene = new Scene(root, 500, 500);
        
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
