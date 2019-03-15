/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class NewFXMain extends Application {
    LoginAuthentication authentication;
    Transactions transactions;
    Stage loginwindow;
    Scene scene1, scene2, scene3, scene4;
 
    
    
    public static void  main(String[] args) {
        
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
     loginwindow = primaryStage;
     
     authentication = new LoginAuthentication();
     
     transactions = new Transactions();
     
     loginwindow.setTitle("ATM");
     
     Label usernameLabel = new Label("Card Number");
     TextField usernameField = new TextField();
     Button submit = new Button("Submit");
     Label validationLabel = new Label();
     GridPane grid1 = new GridPane();
     grid1.add(usernameLabel, 0, 0);
     grid1.add(usernameField, 1, 0);
     grid1.add(submit, 0, 2);
     grid1.add(validationLabel, 1, 3);
     
     submit.setOnAction((ActionEvent event) -> {
         
         String username = usernameField.getText();
         boolean valid =  authentication.validate(username);
         if(valid){
             loginwindow.setScene(scene2);
         }
         else{
             validationLabel.setText("Wrong Number");
         }
         }
         );
             
             
             
     
     scene1 = new Scene(grid1,600,400);
     Button back = new Button("log out");
     back.setOnAction(e->loginwindow.setScene(scene1));
     Button deposit = new Button("deposit");
     deposit.setOnAction(e->loginwindow.setScene(scene3));
     Button withdraw = new Button("withdraw");
     withdraw.setOnAction(e->loginwindow.setScene(scene4));
     Label label5 = new Label();
     Button balance = new Button("balance Inquiry");
     Button previous = new Button("previous");
     Button next = new Button("next");
     balance.setOnAction(e->{
      double balance2 = Transactions.balance1;
         label5.setText(""+balance2);
     }
     );
     GridPane grid2 = new GridPane();
     grid2.add(withdraw, 0, 1);
     grid2.add(deposit, 0, 2);
     grid2.add(balance, 0, 3);
     grid2.add(back, 0, 4);
     grid2.add(label5, 2, 3);
     grid2.add(previous, 0, 5);
     grid2.add(next, 1, 5);
     scene2 = new Scene(grid2,600,300);
     Button back2 = new Button("return");
     back2.setOnAction(e->loginwindow.setScene(scene2));
     Label label3 = new Label("enter amount");
     TextField textfield3 = new TextField();
     Button submit3 = new Button("Submit");
     submit3.setOnAction(e->{
        
        String amount = textfield3.getText();
        transactions.deposit(amount);
        loginwindow.setScene(scene2);
        label5.setText("");
    }
     );
     previous.setOnAction(e->{
     if(transactions.i==0){
         label5.setText("No previous transactions");
         transactions.i--;
     }else{
         label5.setText(transactions.history[transactions.i-1]);
         transactions.i--;
     }
     
     } 
     );
     next.setOnAction(e->{
     if(transactions.history[transactions.i+1]!=null){
         label5.setText(transactions.history[transactions.i+1]);
         transactions.i++;
     }else{
         label5.setText("NO more Transactions");
         transactions.i++;
     }
     
     }
     );
     Label validationLabel3 = new Label();
     GridPane grid3 = new GridPane();
     grid3.add(label3, 0, 0);
     grid3.add(textfield3, 0, 1);
     grid3.add(submit3, 0, 2);
     grid3.add(validationLabel3, 1, 3);
     grid3.add(back2, 0, 3);
     scene3 = new Scene(grid3,600,300);
     
     Button back3 = new Button("return");
     back3.setOnAction(e->loginwindow.setScene(scene2));
     Label label4 = new Label("enter amount");
     TextField textfield4 = new TextField();
     Label validationLabel4 = new Label();
     Button submit4 = new Button("Submit");
     submit4.setOnAction((ActionEvent event) -> {
          
         String amount2 = textfield4.getText();
         boolean valid1 =  transactions.vwithdraw(amount2);
         if(valid1){
             validationLabel4.setText("Done");
             loginwindow.setScene(scene2);
             label5.setText("");
             
         }
         else{
             validationLabel4.setText("invalid Number");
         }
         
         
     }
     );       
     
     GridPane grid4 = new GridPane();
     grid4.add(label4, 0, 0);
     grid4.add(textfield4, 0, 1);
     grid4.add(submit4, 0, 2);
     grid4.add(validationLabel4, 1, 3);
     grid4.add(back3, 0, 3);
     scene4 = new Scene(grid4,600,300);
     
     
             
     
     
     
     loginwindow.setScene(scene1);
     loginwindow.show();
     

     
    }
}