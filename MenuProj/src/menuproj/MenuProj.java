/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package menuproj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author lab1g11
 */
public class MenuProj extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        MenuBar menuBar = buildMenu();
        root.setTop(menuBar);
        Button btn = new Button("_dialog");
        btn.setMnemonicParsing(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Test message");
            }
        });
        root.setCenter(btn);
        btn.setContextMenu(buildContextMenu());
       
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar buildMenu() {
        MenuItem newProjItem = new MenuItem("New Project");
        MenuItem exitItem = new MenuItem("_Exit");
        exitItem.setMnemonicParsing(true);//getback in here
        
        Menu fileMenu = new Menu("_File", null, newProjItem, exitItem);//add items to it 
        fileMenu.setMnemonicParsing(true);
        MenuItem undoItem = new MenuItem("Undo");
        MenuItem redoItem = new MenuItem("Redo");
        
        Menu editMenu = new Menu("Edit");//or add them using a method 
        editMenu.getItems().addAll(undoItem , redoItem);

        MenuBar menuBar = new MenuBar(fileMenu);
        menuBar.getMenus().add(editMenu);
        
        exitItem.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);//to exit the application 
            }
        });
        fileMenu.setOnShowing(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("file menu showing");
                
            }
        });
        fileMenu.setOnShown(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("file menu shown");
            }
        });
        fileMenu.setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.err.println("file menu hiding");
            }
        });
        fileMenu.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.err.println("file menu hidden");
            }
        });
        return menuBar;
    }
   private ContextMenu buildContextMenu(){
       MenuItem copyItem=new MenuItem("Copy");
       MenuItem cutItem=new MenuItem("Cut");
       MenuItem pasteItem=new MenuItem("Paste");
       cutItem.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Cut item clicked");
            }
        });
       ContextMenu ctxMenu=new ContextMenu(copyItem , cutItem , pasteItem);
       return ctxMenu;
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
