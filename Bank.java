/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.*;
import java.util.ArrayList;
import javafx.stage.Stage;
/**
 *
 * @author Brian
 */

public class Bank extends Application
{
    Stage primaryStage;
    StackPane root = new StackPane();
    Button lgn = new Button("Login");
    Button exit = new Button("Exit");
    TextField u = new TextField();
    TextField p = new TextField();
    Label label1 = new Label("Username");
    Label label2 = new Label("Password");
    public String Username;
    public String Password;
    Scene scene;
    File file;
    Customer customer;
    
    public Bank()
    {
        label1.setMaxSize(300,25);
        label1.setTranslateY(-35);
        label2.setMaxSize(300,25);
        label2.setTranslateY(15);
        u.setMaxSize(300,25);
        u.setTranslateY(-10);
        u.setPromptText("Username");
        p.setMaxSize(300, 25);
        p.setTranslateY(40);
        p.setPromptText("Password");
        lgn.setMaxSize(50,25);
        lgn.setTranslateX(-40);
        lgn.setTranslateY(75);
        lgn.setOnAction((e) ->
        {
            Username = u.getText();
            Password = p.getText();
            if(Username.equals("admin") && Password.equals("admin"))
            {
                Manager m = new Manager(primaryStage);
            }
            else
            {
                newUser(Username, Password); 
                User u = new User(primaryStage);
            }
        });
        
        exit.setMaxSize(50,25);
        exit.setTranslateX(35);
        exit.setTranslateY(75);
        exit.setOnAction(e -> {
            System.out.println("Exit");
            System.exit(0);
        });
    }
    @Override
    public void start(Stage primaryStage)
    {
        try {
            this.primaryStage = primaryStage;
            root.getChildren().add(lgn);
            root.getChildren().add(exit);
            root.getChildren().add(u);
            root.getChildren().add(p);
            root.getChildren().add(label1);
            root.getChildren().add(label2);
            scene = initStage();
            primaryStage.setTitle("Bank Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private Scene initStage()
    {
        return new Scene(root,350,350);
    }
    public void newUser(String user, String pw)
    {
        try 
        {
            file = new File(user + ".txt");
            if (file.createNewFile())
            {
                System.out.println("File created: " + file.getName());
                try 
                {
                    FileWriter myWriter = new FileWriter(user +".txt");
                    myWriter.write("Username: " + user + "\n Password: " + pw + "\nBalance: 0"
                                    + "\nlevel: silver");
                    this.customer = new Customer(user, pw, "silver", 0);
                    myWriter.close();
                }
                catch (IOException e)
                {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
            else 
                System.out.println("Welcome back " + user);
        } 
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String [] args)
    {
        launch(args);
    }
}
