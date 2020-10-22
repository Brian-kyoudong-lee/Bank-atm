/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author Brian
 */
public class Manager
{
    StackPane root = new StackPane();
    Stage stage;
    Button add = new Button("Add Customer");
    Button del = new Button("Delete Customer");
    Button logout = new Button("Logout");
    Label label1 = new Label("Username");
    Label label2 = new Label("Password");
    TextField name = new TextField();
    TextField pw = new TextField();
    Button add1 = new Button("add");
    public String text1,text2;
    Button delete = new Button("delete");
    public String text;
    Bank b;
    
    public void add()
    {
        final Stage stage = new Stage();
        StackPane root = new StackPane();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add customer");
        label1.setMaxSize(300,25);
        label1.setTranslateY(-25);
        label2.setMaxSize(300,25);
        label2.setTranslateY(25);
        name.setMaxSize(300,25);
        name.setPromptText("Username");
        name.setOnAction(e -> {
            text1 = name.getText();
        });
        pw.setMaxSize(300,25);
        pw.setTranslateY(50);
        pw.setPromptText("Password");
        pw.setOnAction(e -> {
            text2 = name.getText();
        });
        add1.setMaxSize(50,25);
        add1.setTranslateY(100);
        add1.setOnAction(e -> {
            try 
            {
                File myObj = new File(text1 + ".txt");
                if (myObj.createNewFile())
                {
                    System.out.println("File created: " + myObj.getName());
                    try 
                    {
                        FileWriter myWriter = new FileWriter(text1 +".txt");
                        myWriter.write("Username: " + text1 + "\n Password: " + text2 + "\nBalance: 0"
                                        + "\nlevel: s");
                        myWriter.close();
                    }
                    catch (IOException f)
                    {
                        System.out.println("An error occurred.");
                        f.printStackTrace();
                    }
                }
                else 
                    System.out.println("User already exists");
            } 
            catch (IOException g)
            {
                System.out.println("An error occurred.");
                g.printStackTrace();
            }
        });
        root.getChildren().add(name);
        root.getChildren().add(pw);
        root.getChildren().add(add1);
        root.getChildren().add(label1);
        root.getChildren().add(label2);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    public void delete()
    {
        final Stage stage = new Stage();
        StackPane root = new StackPane();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Delete customer");
        name.setMaxSize(300,25);
        name.setPromptText("Username");
        label1.setMaxSize(300,25);
        label1.setTranslateY(-25);
        name.setOnAction(e -> {
            text = name.getText();
        });
        delete.setMaxSize(50,25);
        delete.setTranslateY(50);
        delete.setOnAction(e -> {
            b.file.delete();
            Manager m = new Manager(stage);
        });
        root.getChildren().add(name);
        root.getChildren().add(delete);
        root.getChildren().add(label1);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    public Manager(Stage stage)
    {
        add.setMaxSize(150,25);
        add.setTranslateX(-85);
        add.setTranslateY(-25);
        add.setOnAction(e -> {
            add();
        });
        del.setMaxSize(150,25);
        del.setTranslateX(85);
        del.setTranslateY(-25);
        del.setOnAction(e -> {
            delete();
        });
        logout.setMaxSize(100,25);
        logout.setTranslateY(25);
        logout.setOnAction(e -> {
            System.out.println("Logout");
            System.exit(0);
        });
        root.getChildren().add(add);
        root.getChildren().add(del);
        root.getChildren().add(logout);
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.show();
    }
}
