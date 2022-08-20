package tira.regextonfa;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Test your string");   

        GridPane rootNode= new GridPane();
        rootNode.setPadding( new Insets( 15 ) );
        rootNode.setHgap( 5 );
        rootNode.setVgap( 5 );
        rootNode.setAlignment( Pos.CENTER );

        Scene myScene = new Scene(rootNode, 600, 500 );

        rootNode.add( new Label("Enter regular expression:"), 0,0); 
        TextField regex = new TextField();
        rootNode.add(regex, 1, 0);
        rootNode.add(new Label ("Enter string you want to test:"), 0, 1); 
        TextField stringToTest = new TextField();
        rootNode.add(stringToTest, 1, 1);       
                 
        Button aButton = new Button("Check"); rootNode.add(aButton, 0, 2);
        rootNode.setAlignment(Pos.BASELINE_CENTER);
        aButton.setOnAction(e -> {
            String value1 = String.valueOf(regex.getText());
            String value2 = String.valueOf(stringToTest.getText());
            System.out.println(value1+ ", " +value2); 
        });
        myStage.setScene( myScene);
        myStage.show();   
    }    

    public static void main(String[] args) {
        launch(args);
    }
}