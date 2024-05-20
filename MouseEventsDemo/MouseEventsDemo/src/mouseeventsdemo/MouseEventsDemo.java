/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package mouseeventsdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author ASU
 */
public class MouseEventsDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        
        Label centerLabel= new Label ("CENTER LABEL");
        centerLabel.setFont(Font.font("arial", FontWeight.BOLD, 28));
        centerLabel.setTextFill(Color.BROWN);
        
        Label statusLabel= new Label ();
        statusLabel.setFont(Font.font(24));
        
        root.setCenter(centerLabel);
        root.setBottom(statusLabel);
        
        centerLabel.setOnMouseEntered(e->{
            centerLabel.setFont(Font.font("serif", FontWeight.EXTRA_BOLD, 36));
            centerLabel.setTextFill(Color.BLUE);
        });
        
        centerLabel.setOnMouseExited(e->{
            centerLabel.setFont(Font.font("arial", FontWeight.BOLD, 28));
            centerLabel.setTextFill(Color.BROWN);
        });
        
        
        root.setOnMouseMoved(e->{
            String status= "Mouse moved: on "+ e.getX()+ ", "+ e.getY();
            statusLabel.setText(status);
        });
        root.setOnMousePressed(e->{
            String status= "Mouse pressed: on "+ e.getX()+ ", "+ e.getY();
            statusLabel.setText(status);
        });
        
        root.setOnMouseReleased(e->{
            String status= "Mouse released: on "+ e.getX()+ ", "+ e.getY();
            statusLabel.setText(status);
        });
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Mouse events");
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
