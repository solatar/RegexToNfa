package regextonfa.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegexToNfa extends Application {

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Test your string");   
        ShuntingYard shunting = new ShuntingYard();
        GridPane window = new GridPane();
        window.setPadding(new Insets(15));
        window.setHgap(5);
        window.setVgap(5);
        window.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(window, 1000, 500 );
        window.add( new Label("Enter regular expression:"), 0, 0); 
        TextField regex = new TextField();
        window.add(regex, 1, 0);
        window.add(new Label ("Enter string you want to test:"), 0, 1); 
        TextField stringToTest = new TextField();
        window.add(stringToTest,1,1);                       
        Button button = new Button("Check"); window.add(button, 1, 2);
        window.setAlignment(Pos.BASELINE_CENTER);
        TextField postfix = new TextField();
        window.add(new Label("Postfix notation:"),0, 3); 
        window.add(postfix, 1, 3);
        window.add(new Label("Warnings:"), 0, 4); 
        TextField warning = new TextField();
        warning.setMinWidth(400);
        window.add(warning, 1, 4);
        TextField result = new TextField();
        window.add(new Label("This string belongs to language :"), 0, 5); 
        window.add(result, 1, 5);
        button.setOnAction(e -> {
            warning.clear();
            result.clear();
            String newRegex = String.valueOf(regex.getText()).trim();
            String newString = String.valueOf(stringToTest.getText());
            if (newRegex.isBlank() || newString.isBlank()) {
                warning.setText("Values cannot be empty");
            } else {
                newRegex = newRegex.replaceAll("\\s+","");
                shunting.setRegex(newRegex);
                shunting.addConcatSymbols();
                String newPostfix = shunting.infixToPostfix();
                postfix.setText(newPostfix);
                Nfa nfa = new Nfa(newPostfix);
                nfa.constructNfa();
                if (!nfa.getStack().isEmpty()) {
                    warning.setText("Check for missing concatenation symbols in your regex");
                } else {
                    Boolean test = nfa.simulate(newString);
                    result.setText(Boolean.toString(test));                  
                }
            }    
        });  
        myStage.setScene(myScene);
        myStage.show();   
    }       

    public static void main(String[] args) {
        launch(args);
    }
}