/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package uicomponents1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author Lenovo
 */
public class UIComponents1 extends Application {
    
   @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        String imagePath= "C:\\Users\\Lenovo\\Desktop\\pic\\22.jpg";
        FileInputStream fis= new FileInputStream(imagePath);
        Image image= new Image(fis, 70, 70, true, true);
        ImageView imageView= new ImageView(image);
        
        Button btn = new Button("", imageView);
        btn.setPrefSize(150, 100);
        
        Button btn2 = new Button("My second button");
        btn2.setPrefSize(180, 100);
        
        btn.setDefaultButton(true);
        btn2.setCancelButton(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Button 1 clicked");
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Button 2 clicked");
            }
        });
        
        Label label= new Label("This is a label");
        label.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD ,32));
        label.setStyle("-fx-background-color: red;");
        label.setTextFill(Color.BLUE);
        label.setPrefWidth(400);
        label.setTextAlignment(TextAlignment.RIGHT);
        
        ToggleGroup toggleGroup= new ToggleGroup();
        
        ToggleButton toggle1= new ToggleButton("First toggle");
        ToggleButton toggle2= new ToggleButton("Second toggle");
        ToggleButton toggle3= new ToggleButton("Third toggle");
        
        toggle1.setPrefSize(100, 100);
        toggle2.setPrefSize(100, 100);
        toggle3.setPrefSize(100, 100);
        
        toggle1.setToggleGroup(toggleGroup);
        toggle2.setToggleGroup(toggleGroup);
        toggle3.setToggleGroup(toggleGroup);
        
        toggleGroup.selectedToggleProperty()
                .addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, 
                    Toggle oldValue, 
                    Toggle newValue) {
                
                ToggleButton oldToggle= (ToggleButton)oldValue;
                ToggleButton newToggle= (ToggleButton)newValue;
                
                btn.setDisable(toggle1.isSelected());
                btn2.setVisible(toggle2.isSelected() || toggle1.isSelected());
                
                
                String message= "you have switched from "+
                        oldToggle.getText()+
                        "to "+
                        newToggle.getText();
                
                JOptionPane.showMessageDialog(null, message);
                
            }
                
        });
        
        VBox togglesBox= new VBox(16, toggle1, toggle2, toggle3);
        
        BorderPane root = new BorderPane();
        root.setCenter(btn);
        root.setTop(btn2);
        root.setBottom(label);
        root.setRight(togglesBox);
        
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Controls screen");
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
