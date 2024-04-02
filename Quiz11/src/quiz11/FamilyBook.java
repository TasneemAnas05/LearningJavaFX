/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package quiz11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class FamilyBook extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         Scene scene2;
        Label NameLabel = new Label("Name");
        TextField Name = new TextField();
        
        Label WifeLabel = new Label("Wife Name");
        TextField WifeName = new TextField();
               
        Button btn1 = new Button("Go to Children Page");
         
        GridPane root = new GridPane();
       root.setAlignment(Pos.CENTER);
//       btn1.setFocusTraversable(true);////////////
       btn1.requestFocus();
       root.add(NameLabel, 0, 0);
       root.add(Name, 1, 0);
       root.add(WifeLabel, 0, 1);
       root.add(WifeName, 1, 1);
       root.add(btn1, 1, 2);
       
                
        Label firstChild = new Label("First child");
        TextField t1 = new TextField();
        Label firstbirth = new Label("birth year");
        TextField t2 = new TextField();
        
        Label secondChild = new Label("Second child");
        TextField t3 = new TextField();
        Label secondbirth = new Label("birth year");
        TextField t4 = new TextField();
        
        Button btn2 = new Button("Back to parents page");
        
        GridPane root2 = new GridPane();
        root2.setAlignment(Pos.CENTER);
        
        root2.add(firstChild , 0 , 0);
        root2.add(t1 , 1 , 0);
        root2.add(firstbirth , 2 , 0);
        root2.add(t2 , 3 , 0);
        
        root2.add(secondChild , 0 , 1);
        root2.add(t3 , 1 , 1);
        root2.add(secondbirth , 2 , 1);
        root2.add(t4 , 3 , 1);
        root2.add(btn2 , 1 , 2);
        
        
        scene2 = new Scene(root2 , 500 , 500);

         Scene scene = new Scene(root, 500, 500);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene2);
                primaryStage.setTitle("Children Page");
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene);
                primaryStage.setTitle("Parent Page");
            }
        });
        
        
        
        primaryStage.setTitle("Parent Page");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
