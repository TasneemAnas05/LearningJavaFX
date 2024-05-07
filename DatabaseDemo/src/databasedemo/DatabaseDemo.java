/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package databasedemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author lab1g11
 */
public class DatabaseDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label userNameLabel = new Label("User name");
        Label passwordLabel = new Label("Password");

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("register");

        TextField userNameField = new TextField();
        PasswordField passwordField = new PasswordField();
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(16);
        root.setHgap(16);
        root.add(userNameLabel , 0 , 0);
        root.add(userNameField , 1 , 0);
        root.add(passwordLabel , 0 , 1);
        root.add(passwordField , 1 , 1);
        root.add(loginBtn , 0 , 2);
        root.add(registerBtn , 1 , 2);

        loginBtn.setOnAction((e)->{
            String userName = userNameField.getText();
            String password = passwordField.getText();
            boolean loginResult=login(userName , password);
            if(loginResult){
                JOptionPane.showMessageDialog(null, "Login Success");
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");

            }
        });
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private boolean login(String userName , String password){
        String dbUrl = "jdbc:mysql://localhost:3306/users1";//!!(database name)
          boolean isUserExist = true;

        try{
          Connection connection = DriverManager.getConnection(dbUrl , "root" , "");
          Statement statement = connection.createStatement();
          String sqlQuery = "select * from users where user_name = '"+userName+"' and password = '"+password+"'";///write the Query !!(table name)
           System.out.println(sqlQuery);// to see if the query is right or not
          ResultSet result=statement.executeQuery(sqlQuery);//return result set deal with cursor(before the first item)
          
          while(result.next()){
              System.out.println(result.getInt("ID"));
              System.out.println(result.getString("user_name"));
              System.out.println(result.getString("password"));
              System.out.println("-------------");
          }

        }
        catch(Exception e){
            e.printStackTrace();// to show the error      
        }
        return isUserExist;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
