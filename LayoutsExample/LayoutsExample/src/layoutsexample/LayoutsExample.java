
package layoutsexample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LayoutsExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        HBox hbox = addHBox();
        root.setTop(hbox);
        
        VBox vbox = addVBox();
        root.setLeft(vbox);
        
        FlowPane fPane = addFlowPane();
        root.setCenter(fPane);
        
        GridPane grid = addGridPane();
        root.setRight(grid);
        
        Scene scene = new Scene(root, 600, 250);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Layouts example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public FlowPane addFlowPane() {
        FlowPane flowPane = new FlowPane();

        Button goButton= new Button("Go");
        Button showButton= new Button("Show");
        Button hideButton= new Button("Hide");
        Button exitButton= new Button("Exit");
        
        goButton.setPrefSize(100, 50);
        showButton.setPrefSize(100, 50);
        hideButton.setPrefSize(100, 50);
        exitButton.setPrefSize(100, 50);
        
        exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        
        flowPane.setPadding(new Insets(20, 20, 20, 20));
        flowPane.setStyle("-fx-background-color: #224477;");
        
        flowPane.getChildren().add(goButton);
        flowPane.getChildren().add(showButton);
        flowPane.getChildren().add(hideButton);
        flowPane.getChildren().add(exitButton);
        
        return flowPane;

    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(12, 15, 12, 15));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        Button btnHome = new Button("Home");
        btnHome.setPrefSize(100, 20);
        Button btnAbout = new Button("About");
        btnAbout.setPrefSize(100, 20);
        hbox.getChildren().addAll(btnHome, btnAbout);
        return hbox;
    }

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        vbox.getChildren().add(title);
        
        Label googleLabel= new Label("Google");
        Label yahooLabel= new Label("YAHOO");
        Label asuLabel= new Label("ASU");
        Label codeLabel= new Label("Code Project");
        
        googleLabel.setTextFill(Color.BLUE);
        yahooLabel.setTextFill(Color.BLUE);
        asuLabel.setTextFill(Color.BLUE);
        codeLabel.setTextFill(Color.BLUE);
        
        vbox.getChildren().addAll(googleLabel, yahooLabel,asuLabel,codeLabel);
        
        return vbox;
    }

    public GridPane addGridPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setVgap(4);
        grid.setHgap(4);

        grid.setStyle("-fx-background-color: DAE6F3;");

        TextField txt1= new TextField("1");
        TextField txt2= new TextField("2");
        TextField txt3= new TextField("3");
        TextField txt4= new TextField("4");
        TextField txt5= new TextField("5");
        TextField txt6= new TextField("6");
        TextField txt7= new TextField("7");
        TextField txt8= new TextField("8");
        
        Button btnSum = new Button("Sum");
        btnSum.setPrefSize(100, 20);
        Button btnAvg = new Button("Avg");
        btnAvg.setPrefSize(100, 20);
        
        grid.add(txt1, 0, 0);
        grid.add(txt2, 1, 0);
        grid.add(txt3, 0, 1);
        grid.add(txt4, 1, 1);
        grid.add(txt5, 0, 2);
        grid.add(txt6, 1, 2);
        grid.add(txt7, 0, 3);
        grid.add(txt8, 1, 3);
        
        grid.add(btnSum, 0, 4);
        grid.add(btnAvg, 1, 4);
        
        TextField [] txtNumbers = {txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8};
    

        btnSum.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                
                double sum = 0;
                for (int i = 0; i < txtNumbers.length; i++) {
                    sum += Double.parseDouble(txtNumbers[i].getText());
                }
                JOptionPane.showMessageDialog(null, "Sum =" + sum);
            }
        });
        btnAvg.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                double sum = 0;
                for (int i = 0; i < txtNumbers.length; i++) {
                    sum += Double.parseDouble(txtNumbers[i].getText());
                }
                JOptionPane.showMessageDialog(null, "Avg =" + sum / txtNumbers.length);
            }
        });
        return grid;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
