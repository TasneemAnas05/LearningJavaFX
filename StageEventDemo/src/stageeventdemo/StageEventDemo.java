/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package stageeventdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author lab1g11
 */
public class StageEventDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setOnShowing(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                JOptionPane.showMessageDialog(null, "showing ...");
            }
        
    });
        primaryStage.setOnShown(e-> {JOptionPane.showMessageDialog(null, "shown");});
        primaryStage.setOnCloseRequest(e-> {JOptionPane.showMessageDialog(null, "close request");});
        primaryStage.setOnHiding(e-> {JOptionPane.showMessageDialog(null, "Hiding ....");});
        primaryStage.setOnHidden(e-> {JOptionPane.showMessageDialog(null, "hidden");});
        
        
        
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
