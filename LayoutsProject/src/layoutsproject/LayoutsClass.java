/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package layoutsproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class LayoutsClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();//col row
        root.setAlignment(Pos.CENTER);
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        Button btn5 = new Button("Button 5");
        Button btn6 = new Button("Button 6");
        Button btn7 = new Button("Button 7");
        Button btn8 = new Button("Button 8");
        Button btn9 = new Button("Button 9");
        
        root.add(btn1 , 0 , 0);
        root.add(btn2 , 0 , 1);
        root.add(btn3 , 0 , 2);
        root.add(btn4 , 1 , 0);
        root.add(btn5 , 1 , 1);
        root.add(btn6 , 1 , 2);
        root.add(btn7 , 2 , 0);
        root.add(btn8 , 2 , 1);
        root.add(btn9 , 2 , 2);
        
        for (int i = 0; i < root.getRowCount(); i++) { // return the number of rows
            
              root.getRowConstraints().add(new RowConstraints(80));

        }
        for (int i = 0; i < root.getColumnCount(); i++) { // return the number of cols 
            root.getColumnConstraints().add(new ColumnConstraints(120));

        }
        
        
//       root.getRowConstraints().add(new RowConstraints(80));//for the first row
//       root.getRowConstraints().add(new RowConstraints(50));//for the second row
//       root.getColumnConstraints().add(new ColumnConstraints(120));//for the first col
       
//        root.setHgap(15);
//        root.setVgap(25);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Layouts");
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
