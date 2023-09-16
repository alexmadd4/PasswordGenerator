package com.passgen.strongpasswordgenerator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class PassGen extends Application {
    private final int WIDTH = 550;
    private final int HEIGHT = 630;
    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*_-+=?:;,./~(){}[]<>".toCharArray();
    private final Random random = new Random();

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        VBox vBox = new VBox(20);
        pane.setStyle("-fx-background-color: #ffffff;-fx-border-width: 10");

        Label label = new Label(" Password Generator ");
        Label label1 = new Label();

        label1.setText("*Please click GENERATE to generate your password*");
        label1.setOpacity(0.6);
        Font font1 = new Font(15);
        label1.setFont(font1);

        Label label2 = new Label();
        label2.setText("*Click on the TextArea to copy your PASSWORD to clipboard*");
        label2.setOpacity(0.6);
        Font font2 = new Font(15);
        label2.setFont(font2);

        Font font = Font.font("Book Antiqua", 50);
        label.setFont(font);
        label.setStyle("-fx-text-fill:#333333 ");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        Font font3 = new Font(26);
        textArea.setFont(font3);

        Image image = new Image("padlock.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setX(200);
        imageView.setY(120);
        Button genButton = new Button("GENERATE");

        genButton.setOnAction(event -> {
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < 16; i++) {
                int randomIndex = random.nextInt(alphabet.length);
                password.append(alphabet[randomIndex]);
            }
            textArea.setText(password.toString());

            textArea.setOnMouseClicked(event1 -> {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();

                String str = password.toString();
                content.putString(str);
                clipboard.setContent(content);
            });

            System.out.println(password);
        });

        genButton.setPrefSize(200,100);
        genButton.setStyle("-fx-font-size: 20 ; -fx-background-color: #f39c12");

        genButton.setLayoutX(12);
        textArea.setLayoutX(12);
        textArea.setPrefSize(280,30);
       textArea.setLayoutX(125);
       textArea.setLayoutY(300);
       textArea.setWrapText(true);

       VBox vBox1 = new VBox(30);
       vBox1.getChildren().addAll(textArea,genButton,label2);
       vBox1.setAlignment(Pos.BASELINE_CENTER);
       vBox1.setLayoutX(70);
       vBox1.setLayoutY(300);

        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setLayoutX(40);
        vBox.getChildren().addAll(label, label1);

        pane.getChildren().addAll(vBox,vBox1,imageView);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setTitle("Password Generator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
