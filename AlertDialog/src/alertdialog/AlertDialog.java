/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package alertdialog;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lab1g11
 */
public class AlertDialog extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Close Alert");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               showAlert();
            }
        });
        TextArea textArea = new TextArea();
        textArea.setPrefWidth(300);
        
        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               showInputDialog(textArea);
            }
        });
        Button infoButton = new Button("Test");
       infoButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               
            }
        });
        FlowPane root = new FlowPane(Orientation.VERTICAL , 16 ,16);
        root.getChildren().addAll(btn ,textArea , searchBtn , infoButton );
        
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    void showAlert(){
//        Alert alert = new Alert( Alert.AlertType.INFORMATION,
//                "This is a content text" ,
//                ButtonType.OK , 
//                ButtonType.CANCEL
//        );
        ButtonType yesButton = new ButtonType("Yes , exit please");
        ButtonType noButton = new ButtonType("No , Wrong click");
        
//        Alert alert = new Alert( Alert.AlertType.CONFIRMATION,
//                "Are you sure?" ,
//                ButtonType.OK , 
//                ButtonType.CANCEL
//        );
        Alert alert = new Alert( Alert.AlertType.CONFIRMATION,
                "Are you sure?" ,
                yesButton , 
               noButton
        );
        alert.setHeaderText("Exit!!!");
        alert.setTitle("Exit confirmation");
       
        
//        alert.show();//immeditly show 
//       alert.showAndWait();//return type optional 
        Optional<ButtonType> userChoice = alert.showAndWait();
//        if(userChoice.get()==ButtonType.OK)
//        {
//            System.exit(0);//to close
//        }
//        else{
//            Alert alert2 = new Alert(Alert.AlertType.ERROR,
//                "Then why you clicked it ?" , 
//                ButtonType.CLOSE
//        );
//            alert2.show();
//        }
        if(userChoice.get()==yesButton)
        {
            System.exit(0);//to close
        }
        else{
            Alert alert2 = new Alert(Alert.AlertType.ERROR,
                "Then why you clicked it ?" , 
                ButtonType.CLOSE
        );
            alert2.show();
        }
        System.out.println("Alert passed");//after taking an action alert
    }
    void showInputDialog(TextArea area){
        TextInputDialog tid = new TextInputDialog("Test");
        
        tid.setHeaderText("Search whatever");
        tid.getEditor().getText();
//        Optional<String> userInputOptional = tid.showAndWait();
//        String userInput = userInputOptional.get();//maybe empty 
//        String textAreaInput = area.getText();
//        int index = textAreaInput.indexOf(userInput);
//        if(index>=0){
//            
//            int end=index+userInput.length();//-1 in select by default
//            area.selectRange(index, end);
//        }
//        else{
//            System.out.println("NOT FOUND");
//        }
        
//        System.err.println(userInput);
//        tid.show();
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
