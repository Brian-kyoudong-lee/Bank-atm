/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javafx.stage.Popup;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author Brian
 */
public class User extends Bank
{
    StackPane root = new StackPane();
    Stage stage;
    Button deposit = new Button("Deposit");
    Button deposit1 = new Button("Deposit");
    Button withdraw = new Button("Withdraw");
    Button withdraw1 = new Button("Withdraw");
    Button purchase = new Button("Purchase");
    Button purchase1 = new Button("Purchase");
    Button balance = new Button("Balance");
    Button logout = new Button ("Logout");
    TextField value = new TextField();
    Popup popup = new Popup();
    public String temp;
    public int index;
    Bank b = new Bank();
    
    public void getbalance()
    {
        Label label = new Label("$" + customer.getBalance());
        popup.getContent().add(label);
        label.setMaxSize(300, 25);
        popup.show(stage);
    }
    public void deposit()
    {
        final Stage stage = new Stage();
        StackPane root = new StackPane();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Deposit");
        value.setMaxSize(300,25);
        value.setPromptText("Amount");
        value.setOnAction(e -> {
            temp = value.getText();
        });
        root.getChildren().add(value);
        root.getChildren().add(deposit1);
        value.setMaxSize(300, 25);
        deposit1.setMaxSize(100,25);
        deposit1.setTranslateY(50);
        deposit1.setTranslateX(0);
        deposit1.setOnAction(e -> {
            customer.setBalance((customer.getBalance()+parseDouble(temp)));
        });
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    public void withdraw()
    {
        final Stage stage = new Stage();
        StackPane root = new StackPane();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Withdraw");
        value.setMaxSize(300,25);
        value.setPromptText("Amount");
        value.setOnAction(e -> {
            temp = value.getText();
        });
        root.getChildren().add(value);
        root.getChildren().add(withdraw1);
        value.setMaxSize(300, 25);
        withdraw1.setMaxSize(100,25);
        withdraw1.setTranslateY(50);
        withdraw1.setTranslateX(0);
        withdraw1.setOnAction(e -> {
            customer.setBalance((customer.getBalance()-parseDouble(temp)));
        });
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    public void purchase()
    {
        final Stage stage = new Stage();
        StackPane root = new StackPane();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Purchase");
        value.setMaxSize(300,25);
        value.setPromptText("Cost of Product");
        value.setOnAction(e -> {
            temp = value.getText();
        });
        root.getChildren().add(value);
        root.getChildren().add(purchase1);
        value.setMaxSize(300, 25);
        purchase1.setMaxSize(100,25);
        purchase1.setTranslateY(50);
        purchase1.setTranslateX(0);
        purchase1.setOnAction(e -> {
            customer.setBalance((customer.getBalance()-(parseDouble(temp)+customer.getFee())));
        });
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    public void update()
    {
        try 
        {
            FileWriter myWriter = new FileWriter(b.file);
            myWriter.write(toString());
            myWriter.close();
        } 
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public User(Stage stage)
    {
        deposit.setMaxSize(100,25);
        deposit.setTranslateX(-60);
        deposit.setTranslateY(-25);
        deposit.setOnAction(e -> {
            deposit();
        });
        withdraw.setMaxSize(100,25);
        withdraw.setTranslateX(-60);
        withdraw.setTranslateY(25);
        withdraw.setOnAction(e -> {
            popup.show(stage);
            withdraw();
        });
        balance.setMaxSize(100,25);
        balance.setTranslateX(60);
        balance.setTranslateY(-25);
        balance.setOnAction(e -> {
            popup.show(stage);
            getbalance();
        });
        purchase.setMaxSize(100,25);
        purchase.setTranslateX(60);
        purchase.setTranslateY(25);
        purchase.setOnAction(e -> {
            popup.show(stage);
            purchase();
        });
        logout.setMaxSize(100,25);
        logout.setTranslateY(75);
        logout.setOnAction(e -> {
            System.out.println("Logout");
            System.exit(0);
        });
        root.getChildren().add(deposit);
        root.getChildren().add(withdraw);
        root.getChildren().add(balance);
        root.getChildren().add(purchase);
        root.getChildren().add(logout);
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.show();
    }
}

