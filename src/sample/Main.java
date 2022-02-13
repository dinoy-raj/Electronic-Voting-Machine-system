package sample;

import database.MySQL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.SubScene;
import javafx.scene.image.ImageView;

import java.io.File;


public class Main extends Application {

    public static void main(String[] args) {
        MySQL db = new MySQL();
        db.connectJDBC();
        db.insertIntoElection(1, "test");
        db.retrieveData("election");
        launch(args);
    }

    Group group = new Group();
    Group groupE = new Group();
    Group groupV = new Group();
    Group groupR = new Group();


    //function switch sub scene(tabs) on selecting
    public void switchScene(SubScene rect1, SubScene rect2, SubScene rect3) {
        rect2.setVisible(false);
        rect3.setVisible(false);
        rect1.setVisible(true);
    }

    //function switch tab focus rectangle colour on selecting
    public void switchtab(Rectangle rect1, Rectangle rect2, Rectangle rect3) {
        rect1.setFill(Color.BLACK);
        rect2.setFill(Color.WHITE);
        rect3.setFill(Color.WHITE);
    }

    //function switch tab text colour on selecting
    public void switchtabtc(Button bt1, Button bt2, Button bt3, Font font1, Font font2) {
        bt1.setTextFill(Color.WHITE);
        bt1.setFont(font1);
        bt2.setTextFill(Color.BLACK);
        bt2.setFont(font2);
        bt3.setTextFill(Color.BLACK);
        bt3.setFont(font2);
    }

    @Override
    public void start(Stage primaryStage) {


        Scene scene = new Scene(group, 1000, 650);

        //Sub scene for each tab
        SubScene sceneE = new SubScene(groupE, 1000, 600);
        SubScene sceneV = new SubScene(groupV, 1000, 600);
        SubScene sceneR = new SubScene(groupR, 1000, 600);

        //Bottom navbar white rounded rectangle
        Rectangle rect = new Rectangle();
        rect.setHeight(60);
        rect.setWidth(800);
        rect.setX(100);
        rect.setY(550);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.WHITE);

        //shadow effect to bottom navbar
        DropShadow ds = new DropShadow();
        ds.setColor(Color.rgb(230, 230, 230));
        ds.setBlurType(BlurType.GAUSSIAN);
        ds.setRadius(200);
        ds.setSpread(.03);

        rect.setEffect(ds);

        DropShadow sd = new DropShadow();
        sd.setColor(Color.WHITE);
        sd.setBlurType(BlurType.GAUSSIAN);
        sd.setRadius(200);
        sd.setSpread(.03);




        //tabs
        Button btn2 = new Button("Result");
        Button btn1 = new Button("Vote");
        Button btn = new Button("Election");

        //TAB TEXT FONTS
        Font font1 = Font.font("Helvetica", FontWeight.BOLD, 14);
        Font font2 = Font.font("Helvetica", 14);
       // Font fontE1 = Font.font("Roboto", FontWeight.SEMI_BOLD, 13);


        //Focus Rectangle for tabs
        Rectangle recti1 = new Rectangle();
        recti1.setHeight(40);
        recti1.setWidth(200);
        recti1.setX(120);
        recti1.setY(560);
        recti1.setArcWidth(20);
        recti1.setArcHeight(20);
        recti1.setFill(Color.BLACK);

        Rectangle recti2 = new Rectangle();
        recti2.setHeight(40);
        recti2.setWidth(200);
        recti2.setX(390);
        recti2.setY(560);
        recti2.setArcWidth(20);
        recti2.setArcHeight(20);
        recti2.setFill(Color.WHITE);

        Rectangle recti3 = new Rectangle();
        recti3.setHeight(40);
        recti3.setWidth(200);
        recti3.setX(670);
        recti3.setY(560);
        recti3.setArcWidth(20);
        recti3.setArcHeight(20);
        recti3.setFill(Color.WHITE);


        //Button for election tab
        btn.setPrefSize(200, 60);
        btn.setBorder(Border.EMPTY);
        btn.setTextFill(Color.WHITE);
        btn.setStyle("-fx-background-color: transparent; focused:-fx-background-color: #000000 ;"
        );
        btn.setLayoutX(120);
        btn.setLayoutY(550);
        btn.setOnAction((MouseClickEvent) -> {
            switchScene(sceneE, sceneV, sceneR);
            switchtab(recti1, recti2, recti3);
            switchtabtc(btn, btn1, btn2, font1, font2);
        });

        btn.setOnMouseEntered(mouseEvent -> {
            scene.setCursor(Cursor.HAND); //Change cursor to hand
        });

        btn.setOnMouseExited(mouseEvent -> {
            scene.setCursor(Cursor.DEFAULT); //Change cursor to hand
        });

        btn.setFont(font1);


        //button for vote tab
        btn1.setPrefSize(200, 60);
        btn1.setBorder(Border.EMPTY);
        btn1.setStyle("-fx-background-color: transparent; focused:-fx-background-color: #000000 ;"
        );
        btn1.setLayoutX(390);
        btn1.setLayoutY(550);
        btn1.setTextFill(Color.BLACK);
        btn1.setOnAction((MouseClickEvent) -> {

            switchScene(sceneV, sceneE, sceneR);
            switchtab(recti2, recti1, recti3);
            switchtabtc(btn1, btn, btn2, font1, font2);

        });

        btn1.setOnMouseEntered(mouseEvent -> {
            scene.setCursor(Cursor.HAND); //Change cursor to hand
        });

        btn1.setOnMouseExited(mouseEvent -> {
            scene.setCursor(Cursor.DEFAULT); //Change cursor to hand
        });


        btn1.setFont(font2);


        //button for election tab
        btn2.setPrefSize(200, 60);
        btn2.setBorder(Border.EMPTY);
        btn2.setStyle("-fx-background-color: transparent; focused:-fx-background-color: #000000 ;"
        );
        btn2.setLayoutX(670);
        btn2.setLayoutY(550);
        btn2.setTextFill(Color.BLACK);
        btn2.setOnAction((MouseClickEvent) -> {
            switchScene(sceneR, sceneV, sceneE);
            switchtab(recti3, recti2, recti1);
            switchtabtc(btn2, btn, btn1, font1, font2);
        });
        btn2.setOnMouseEntered(mouseEvent -> {
            scene.setCursor(Cursor.HAND); //Change cursor to hand
        });

        btn2.setOnMouseExited(mouseEvent -> {
            scene.setCursor(Cursor.DEFAULT); //Change cursor to hand
        });

        btn2.setFont(font2);


        //ELECTION TAB CONTENTS
        Rectangle rectE1 = new Rectangle();
        rectE1.setHeight(500);
        rectE1.setWidth(940);
        rectE1.setX(30);
        rectE1.setY(30);
        rectE1.setFill(Color.rgb(246, 246, 246));
        rectE1.setArcWidth(20);
        rectE1.setArcHeight(20);

        Rectangle rectE2 = new Rectangle();
        rectE2.setHeight(450);
        rectE2.setWidth(400);
        rectE2.setX(60);
        rectE2.setY(55);
        rectE2.setFill(Color.BLACK);
        rectE2.setArcWidth(20);
        rectE2.setArcHeight(20);

        Text textE1 = new Text("Election Name  : ");
        textE1.setX(520);
        textE1.setY(180);
        textE1.setFill(Color.rgb(108,108,108));
        textE1.setFont(font1);

        Text textE2 = new Text("Number Of Candidates  : ");
        textE2.setX(520);
        textE2.setY(310);
        textE2.setFill(Color.rgb(108,108,108));
        textE2.setFont(font1);




        Image img = new Image("sample/right.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(20);
        view.setPreserveRatio(true);


        //PROCEED button
        Button buttonE1 = new Button();
        buttonE1.setGraphic(view);
        buttonE1.setGraphicTextGap(10);
        buttonE1.setFont(font1);
        buttonE1.setText("Proceed");
        buttonE1.setTextFill(Color.WHITE);
        buttonE1.setLayoutX(520);
        buttonE1.setLayoutY(450);
        buttonE1.setPrefSize(390,40);
        buttonE1.setStyle(
                "-fx-background-color: #000000; focused:-fx-background-color: #FFFFFF ;"
        );

        DropShadow dsB = new DropShadow();
        dsB.setColor(Color.rgb(134,134,134));
        dsB.setBlurType(BlurType.GAUSSIAN);
        dsB.setRadius(20);
        dsB.setSpread(.01);

        //TextField 1
        TextField eName1 = new TextField();
        eName1.setPromptText("Ex  :  Union  election 2021");
        eName1.setPrefSize(400,40);
        eName1.setLayoutX(520);
        eName1.setPadding(new Insets(10, 10, 10, 25));
        eName1.setLayoutY(200);
        eName1.setStyle("-fx-focus-color: transparent;-fx-background-color: -fx-control-inner-background;");
        eName1.setEffect(ds);

        //TextField2
        TextField eName2 = new TextField();
        eName2.setPromptText("Ex  :  10 or 15...");
        eName2.setPrefSize(400,40);
        eName2.setLayoutX(520);
        eName2.setLayoutY(330);
        eName2.setPadding(new Insets(10, 10, 10, 25));
        eName2.setStyle("-fx-focus-color:transparent;-fx-background-color: -fx-control-inner-background;");
        eName1.setEffect(ds);





        DropShadow dsE = new DropShadow();
        dsE.setColor(Color.rgb(134,134,134));
        dsE.setBlurType(BlurType.GAUSSIAN);
        dsE.setRadius(20);
        dsE.setSpread(.01);

        rect.setEffect(ds);

        EventHandler<MouseEvent> mouseEntered = e1 -> {
        sceneE.setCursor(Cursor.HAND);
            buttonE1.setPrefSize(389,40);
            buttonE1.setLayoutX(520);
            buttonE1.setLayoutY(451);
            buttonE1.setGraphicTextGap(15);
            buttonE1.setStyle("-fx-background-color: #131313; focused:-fx-background-color: #000000 ;");
        };

        buttonE1.setOnMouseEntered(mouseEntered);

        EventHandler<MouseEvent> mouseExited = e2 -> {
        sceneE.setCursor(Cursor.DEFAULT);
            buttonE1.setLayoutX(520);
            buttonE1.setLayoutY(450);
            buttonE1.setPrefSize(390,40);
            buttonE1.setGraphicTextGap(10);
            buttonE1.setStyle(
                    "-fx-background-color: #000000; focused:-fx-background-color: #FFFFFF ;"
            );
        };

        buttonE1.setOnMouseExited(mouseExited);





        groupE.getChildren().add(rectE1);
        groupE.getChildren().add(rectE2);
        groupE.getChildren().add(textE1);
        groupE.getChildren().add(textE2);
        groupE.getChildren().add(buttonE1);
        groupE.getChildren().add(eName1);
        groupE.getChildren().add(eName2);



        //VOTE TAB CONTENTS
        Rectangle rectV1 = new Rectangle();
        rectV1.setHeight(500);
        rectV1.setWidth(940);
        rectV1.setX(30);
        rectV1.setY(30);
        rectV1.setFill(Color.rgb(246, 246, 246));
        rectV1.setArcWidth(20);
        rectV1.setArcHeight(20);

        Rectangle rectV2 = new Rectangle();
        rectV2.setHeight(450);
        rectV2.setWidth(450);
        rectV2.setX(480);
        rectV2.setY(55);
        rectV2.setFill(Color.WHITE);
        rectV2.setArcWidth(20);
        rectV2.setArcHeight(20);

        rectV2.setEffect(ds);

        Image i = new Image(new File("sample/vot.gif").toURI().toString());
        ImageView imageViewV1 = new ImageView(i);

        imageViewV1.setX(300);
        imageViewV1.setX(100);
        imageViewV1.setPreserveRatio(true);
        imageViewV1.setCache(true);
        imageViewV1.setFitWidth(300);

        Text textV1 = new Text("College Id ");
        textV1.setX(520);
        textV1.setY(140);
        textV1.setFill(Color.rgb(0,0,0));
        textV1.setFont(font1);

        Text textV2 = new Text("Password ");
        textV2.setX(520);
        textV2.setY(280);
        textV2.setFill(Color.rgb(0,0,0));
        textV2.setFont(font1);


        Image img1 = new Image("sample/right.png");
        ImageView viewl = new ImageView(img1);
        view.setFitHeight(20);
        view.setPreserveRatio(true);

        //PROCEED button
        Button buttonV1 = new Button();
        buttonV1.setGraphic(viewl);
        buttonV1.setGraphicTextGap(10);
        buttonV1.setFont(font1);
        buttonV1.setText("Login");
        buttonV1.setTextFill(Color.WHITE);
        buttonV1.setLayoutX(545);
        buttonV1.setLayoutY(410);
        buttonV1.setPrefSize(320,40);
        buttonV1.setStyle(
                "-fx-background-color: #000000; focused:-fx-background-color: #FFFFFF ;"
        );


        //TextField 1
        TextField vName1 = new TextField();
        vName1.setPrefSize(370,40);
        vName1.setLayoutX(520);
        vName1.setPadding(new Insets(10, 10, 10, 25));
        vName1.setLayoutY(170);
        vName1.setStyle("-fx-focus-color: transparent;-fx-background-color: #EEEEEE;");
        vName1.setEffect(ds);

        //TextField2
        TextField vName2 = new TextField();
        vName2.setPrefSize(370,40);
        vName2.setLayoutX(520);
        vName2.setLayoutY(310);
        vName2.setPadding(new Insets(10, 10, 10, 25));
        vName2.setStyle("-fx-focus-color:transparent;-fx-background-color: #EEEEEE;");
        vName2.setEffect(ds);



        rect.setEffect(ds);

        EventHandler<MouseEvent> mouseVEntered = e1 -> {
            sceneV.setCursor(Cursor.HAND);
            buttonV1.setPrefSize(320,40);
            buttonV1.setLayoutX(545);
            buttonV1.setLayoutY(410);
            buttonV1.setGraphicTextGap(15);
            buttonV1.setStyle("-fx-background-color: #131313; focused:-fx-background-color: #000000 ;");
        };

        buttonV1.setOnMouseEntered(mouseVEntered);

        EventHandler<MouseEvent> mouseVExited = e2 -> {
            sceneV.setCursor(Cursor.DEFAULT);
            buttonV1.setLayoutX(545);
            buttonV1.setLayoutY(410);
            buttonV1.setPrefSize(320,40);
            buttonV1.setGraphicTextGap(10);
            buttonV1.setStyle(
                    "-fx-background-color: #000000; focused:-fx-background-color: #FFFFFF ;"
            );
        };

        buttonV1.setOnMouseExited(mouseVExited);




        groupV.getChildren().add(rectV1);
        groupV.getChildren().add(rectV2);
        groupV.getChildren().add(textV1);
        groupV.getChildren().add(textV2);
        groupV.getChildren().add(vName1);
        groupV.getChildren().add(vName2);
        groupV.getChildren().add(buttonV1);

        groupV.getChildren().add(imageViewV1);


        //RESULT TAB CONTENTS
        Rectangle rectR1 = new Rectangle();
        rectR1.setHeight(500);
        rectR1.setWidth(940);
        rectR1.setX(30);
        rectR1.setY(30);
        rectR1.setFill(Color.rgb(246, 246, 246));
        rectR1.setArcWidth(20);
        rectR1.setArcHeight(20);

        Rectangle rectR2 = new Rectangle();
        rectR2.setHeight(100);
        rectR2.setWidth(870);
        rectR2.setX(60);
        rectR2.setY(55);
        rectR2.setFill(Color.WHITE);
        rectR2.setArcWidth(20);
        rectR2.setArcHeight(20);
        rectR2.setEffect(ds);

        Rectangle rectR3 = new Rectangle();
        rectR3.setHeight(300);
        rectR3.setWidth(870);
        rectR3.setX(60);
        rectR3.setY(200);
        rectR3.setFill(Color.WHITE);
        rectR3.setArcWidth(20);
        rectR3.setArcHeight(20);


        groupR.getChildren().add(rectR1);
        groupR.getChildren().add(rectR2);
        groupR.getChildren().add(rectR3);


        //Children added to main scene (bottom navbar)
        group.getChildren().add(rect);
        group.getChildren().add(recti1);
        group.getChildren().add(recti2);
        group.getChildren().add(recti3);
        group.getChildren().add(btn);
        group.getChildren().add(btn1);
        group.getChildren().add(btn2);

        //sub scene added to main scene
        group.getChildren().add(sceneR);
        group.getChildren().add(sceneV);
        group.getChildren().add(sceneE);


        //App icon,name and staged the main scene
        primaryStage.getIcons().add(new Image("sample/a.png"));
        primaryStage.setTitle("VotR");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}