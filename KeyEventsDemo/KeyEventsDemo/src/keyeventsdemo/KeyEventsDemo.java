/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package keyeventsdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class KeyEventsDemo extends Application implements EventHandler<KeyEvent>{
    
    Label statusLabel;
    TextField field;
    
    @Override
    public void start(Stage primaryStage) {
        statusLabel= new Label();
        statusLabel.setFont(Font.font("arial",22));
        field= new TextField();
        
        field.setOnKeyPressed(this);
        field.setOnKeyReleased(this);
        field.setOnKeyTyped(this);
        
        BorderPane root = new BorderPane();
        root.setTop(field);
        root.setBottom(statusLabel);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Key events");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event) {
        
        EventType type = event.getEventType();
        if(type == KeyEvent.KEY_PRESSED){
            statusLabel.setText("Pressed , code: "+event.getCode() + " ,, text: "+ event.getText());
        }else if(type == KeyEvent.KEY_RELEASED){
            switch(event.getCode()){
                case ENTER:
                    JOptionPane.showMessageDialog(null, "Enter key released..");
                    break;
                    
                case ESCAPE:
                    System.exit(0);
                    break;
                    
                default:
                    statusLabel.setText("Released , code: "+event.getCode() + 
                            " ,, text: "+ event.getText());
            }
        }else if(type == KeyEvent.KEY_TYPED){  // unnecessary check
            String extraButton= "";
            if(event.isShiftDown()){
                extraButton+= " shift down ";
            }
            if(event.isControlDown()){
                extraButton+= " control down";
            }
            
            statusLabel.setText("TYPED , code: "+event.getCode() + 
                            " ,, char: "+ event.getCharacter()+ 
                            "  ,, extra: "+extraButton);
        }
    }
    
    
    
}
