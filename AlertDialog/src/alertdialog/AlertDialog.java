/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package alertproj;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ASU
 */
public class AlertProj extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Close application");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                showAlert();
            }
        });
        
        TextArea textArea= new TextArea();
        textArea.setPrefWidth(300);
        textArea.setWrapText(true);
        
        textArea.setStyle(
                "-fx-font: normal bold 30px 'serif';"+
                        "-fx-background-color: red;"+
                        "-fx-text-fill: blue;"+
                        "-fx-control-inner-background: #FFFFFF;");
        
        Button searchBtn= new Button("Search");
        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShowInputDialog(textArea);
            }
        });
        
        Button infoBtn= new Button("Test");
        infoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.err.println(textArea.getSelectedText());
                textArea.setText("BBBBBBBBBBBB");
            }
        });
        
        Button homeButton= new Button("Home");
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectHome();
            }
        });
        Button forwardButton= new Button("Forward");
        forwardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectForward();
            }
        });
        Button backwardButton= new Button("Backward");
        backwardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectBackward();
            }
        });
        Button nextButton= new Button("Next");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectNextWord();
            }
        });
        Button prevButton= new Button("Previous");
        prevButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectPreviousWord();
            }
        });
        
        Button clearButton= new Button("Clear");
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Same result using clear or selectRange(0 , 0)
                //textArea.clear();
                textArea.selectRange(0, 0);
            }
        });
        
        Button allButton= new Button("All");
        allButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });
        
        HBox buttons= new HBox(8, homeButton, backwardButton, forwardButton, nextButton, 
                prevButton, allButton, clearButton);
        FlowPane root = new FlowPane(Orientation.VERTICAL, 16, 16);
        root.getChildren().addAll(btn, textArea, searchBtn, infoBtn, buttons);
        
        
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    void showAlert(){
        ButtonType yesButton= new ButtonType("Yes , exit please");
        ButtonType noButton= new ButtonType("No , Wrong click");
        
        Alert alert= new Alert(
                Alert.AlertType.CONFIRMATION, 
                "Are you sure?",
                yesButton, noButton
        );
        
        alert.setHeaderText("Exit!!!");
        alert.setTitle("Exit confirmation");
        
        
        //alert.show() // directly show
        //any choice does not matter 
        Optional <ButtonType> userChoice= alert.showAndWait();//stop till the user take action
        if(userChoice.get() == yesButton){
            System.exit(0);//exit the program
        }else{
            
            Alert alert2= new Alert(
                    Alert.AlertType.ERROR, //HeaderText
                    "ليش بتكبس إذا مش متأكد؟",//title
                    ButtonType.CLOSE//Button
            );
            alert2.show();
        }
        
    }

    void ShowInputDialog(TextArea area){
        TextInputDialog tid= new TextInputDialog("Test");//Test is the initial text
        tid.setHeaderText("Search whatever");
        tid.setContentText("Search content text");
        
        tid.setGraphic(null);  // to remove the icon
        

        // First way to get user input
        //Optional<String> userInputOptional = tid.showAndWait();
        //String userInput= userInputOptional.get();
        
        // Another way to get user input
        tid.showAndWait();//to wait for the user to write
        String userInput= tid.getEditor().getText();
        
        String textAreaInput= area.getText();
        
        int index= textAreaInput.indexOf(userInput);//indexOf=-1(notFound) 
        if(index >=0){
            int end= index+ userInput.length();
            area.selectRange(index, end);//select from endex till end-1
        }else{
            System.out.println("NOT FOUND");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
