/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controlsproj;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ControlsProj extends Application {
    
    Button centerButton;//global button
    
    @Override
    public void start(Stage primaryStage) {
        
        buildCenterButton();///call it
        
        BorderPane borderLayout = new BorderPane();
        
        borderLayout.setCenter(centerButton);// add button on center
        
        Node top= buildTopNode();// build the top button
        borderLayout.setTop(top);//add it to the Border Pane
        
        borderLayout.setBottom(buildBottomNode());
        
        Scene scene = new Scene(borderLayout, 600, 600);
        primaryStage.setTitle("Controls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buildCenterButton(){
        centerButton= new Button("center");
        centerButton.setPrefSize(150, 100);
        centerButton.setDefaultButton(true);// when click enter from keyboard
        
        centerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Center button clicked");
            }
        });
        
        String imagePath= "D:\\my files\\images\\image.jpg";
        try{
            FileInputStream fis= new FileInputStream(imagePath);
            Image image= new Image(fis,150,100,false, true);
            ImageView imageView= new ImageView(image);
            centerButton.setGraphic(imageView);
            
        }catch(Exception e){
            System.err.println("File not found");
        }
        
    }
    
    private Node buildTopNode(){
        
        Button topButton= new Button("Top Button");
        topButton.setPrefSize(80, 70);
        topButton.setCancelButton(true);// when click escape on keyboard
        topButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Top button clicked");//static method for the class
            }
        });
        HBox topBox= new HBox(topButton);
        topBox.setStyle("-fx-background-color: blue;");
        topBox.setPadding(new Insets(8,8,8,8));
        topBox.setAlignment(Pos.CENTER);
        
        return topBox;// return type button
    }
    
    private Node buildBottomNode(){
        Label bottomLabel= new Label("This is a label \n sec line");
        bottomLabel.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        bottomLabel.setTextFill(Color.BLUE);
        bottomLabel.setStyle("-fx-background-color: red;");
        bottomLabel.setPrefWidth(400);
        bottomLabel.setTextAlignment(TextAlignment.CENTER);
        return bottomLabel;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
