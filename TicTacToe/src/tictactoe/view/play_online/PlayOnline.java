package tictactoe.view.play_online;



import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class PlayOnline extends BorderPane {

    protected final Button button;
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Text text;
    protected final TextField textField;
    protected final ImageView imageView0;
    protected final Label label;
    protected final ImageView imageView1;
    protected final ScrollPane scrollPane;
    protected final HBox hBox;
    protected final AnchorPane anchorPane0;
    protected final Label label0;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final AnchorPane anchorPane1;
    protected final Label label1;
    protected final ImageView imageView4;
    protected final ImageView imageView5;
    protected final AnchorPane anchorPane2;
    protected final Label label2;
    protected final ImageView imageView6;
    protected final ImageView imageView7;
    protected final AnchorPane anchorPane3;
    protected final Label label3;
    protected final ImageView imageView8;
    protected final ImageView imageView9;
    protected final AnchorPane anchorPane4;
    protected final Label label4;
    protected final ImageView imageView10;
    protected final ImageView imageView11;

    public PlayOnline() {

        button = new Button();
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        text = new Text();
        textField = new TextField();
        imageView0 = new ImageView();
        label = new Label();
        imageView1 = new ImageView();
        scrollPane = new ScrollPane();
        hBox = new HBox();
        anchorPane0 = new AnchorPane();
        label0 = new Label();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        anchorPane1 = new AnchorPane();
        label1 = new Label();
        imageView4 = new ImageView();
        imageView5 = new ImageView();
        anchorPane2 = new AnchorPane();
        label2 = new Label();
        imageView6 = new ImageView();
        imageView7 = new ImageView();
        anchorPane3 = new AnchorPane();
        label3 = new Label();
        imageView8 = new ImageView();
        imageView9 = new ImageView();
        anchorPane4 = new AnchorPane();
        label4 = new Label();
        imageView10 = new ImageView();
        imageView11 = new ImageView();

        setMaxHeight(500.0);
        setMaxWidth(700.0);
        setMinHeight(447.0);
        setMinWidth(700.0);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #ffffff;");

        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setMnemonicParsing(false);
        button.setPrefHeight(45.0);
        button.setPrefWidth(348.0);
        button.setStyle("-fx-background-color: #1978ae; -fx-border-radius: 10px;");
        button.setText("Play Ramdom");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        BorderPane.setMargin(button, new Insets(0.0, 0.0, 20.0, 0.0));
        setBottom(button);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setMaxHeight(500.0);
        anchorPane.setMaxWidth(700.0);
        anchorPane.setMinHeight(187.0);
        anchorPane.setMinWidth(700.0);
        anchorPane.setPrefHeight(187.0);
        anchorPane.setPrefWidth(700.0);
        anchorPane.setStyle("-fx-background-color: #1978ae;");

        imageView.setFitHeight(45.0);
        imageView.setFitWidth(52.0);
        imageView.setLayoutX(21.0);
        imageView.setLayoutY(113.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/tictactoe/resources/person.png").toExternalForm()));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(86.0);
        text.setLayoutY(151.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("User Name");
        text.setWrappingWidth(115.8525390625);
        text.setFont(new Font(17.0));

        textField.setLayoutX(202.0);
        textField.setLayoutY(128.0);
        textField.setPrefHeight(34.0);
        textField.setPrefWidth(432.0);
        textField.setPromptText("Search");
        textField.setPadding(new Insets(0.0, 0.0, 0.0, 30.0));

        imageView0.setFitHeight(15.0);
        imageView0.setFitWidth(29.0);
        imageView0.setLayoutX(210.0);
        imageView0.setLayoutY(138.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/tictactoe/resources/search.png").toExternalForm()));

        label.setLayoutX(190.0);
        label.setLayoutY(45.0);
        label.setPrefHeight(50.0);
        label.setPrefWidth(403.0);
        label.setText("Are you ready ");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(41.0));

        imageView1.setFitHeight(45.0);
        imageView1.setFitWidth(87.0);
        imageView1.setLayoutX(495.0);
        imageView1.setLayoutY(48.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/tictactoe/resources/boxingGlovepng.png").toExternalForm()));
        anchorPane.setPadding(new Insets(0.0, 10.0, 20.0, 0.0));
        BorderPane.setMargin(anchorPane, new Insets(0.0));
        setTop(anchorPane);

        BorderPane.setAlignment(scrollPane, javafx.geometry.Pos.CENTER);
        scrollPane.setMaxHeight(223.0);
        scrollPane.setMinHeight(180.0);
        scrollPane.setPrefHeight(212.0);
        scrollPane.setPrefWidth(700.0);
        scrollPane.setStyle("-fx-background-color: #ffffff; -fx-hbar-policy: never; -fx-vbar-policy: never;");

        hBox.setPrefHeight(223.0);
        hBox.setPrefWidth(705.0);
        hBox.setStyle("-fx-background-color: #ffffff;");

        anchorPane0.setPrefHeight(238.0);
        anchorPane0.setPrefWidth(116.0);
        anchorPane0.setStyle("-fx-background-color: #ffffff;");

        label0.setLayoutX(6.0);
        label0.setLayoutY(82.0);
        label0.setPrefHeight(67.0);
        label0.setPrefWidth(132.0);
        label0.setText("User One ");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        label0.setFont(new Font(19.0));

        imageView2.setFitHeight(24.0);
        imageView2.setFitWidth(23.0);
        imageView2.setLayoutX(101.0);
        imageView2.setLayoutY(14.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/tictactoe/resources/status.png").toExternalForm()));

        imageView3.setFitHeight(109.0);
        imageView3.setFitWidth(105.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("/tictactoe/resources/onlinePerson.png").toExternalForm()));

        anchorPane1.setLayoutX(10.0);
        anchorPane1.setLayoutY(10.0);
        anchorPane1.setPrefHeight(229.0);
        anchorPane1.setPrefWidth(119.0);

        label1.setLayoutX(6.0);
        label1.setLayoutY(82.0);
        label1.setPrefHeight(67.0);
        label1.setPrefWidth(132.0);
        label1.setText("User One ");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        label1.setFont(new Font(19.0));

        imageView4.setFitHeight(24.0);
        imageView4.setFitWidth(23.0);
        imageView4.setLayoutX(101.0);
        imageView4.setLayoutY(14.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("/tictactoe/resources/status.png").toExternalForm()));

        imageView5.setFitHeight(109.0);
        imageView5.setFitWidth(105.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("/tictactoe/resources/onlinePerson.png").toExternalForm()));

        anchorPane2.setLayoutX(30.0);
        anchorPane2.setLayoutY(50.0);
        anchorPane2.setPrefHeight(238.0);
        anchorPane2.setPrefWidth(116.0);
        anchorPane2.setStyle("-fx-background-color: #ffffff;");

        label2.setLayoutX(6.0);
        label2.setLayoutY(82.0);
        label2.setPrefHeight(67.0);
        label2.setPrefWidth(132.0);
        label2.setText("User One ");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        label2.setFont(new Font(19.0));

        imageView6.setFitHeight(24.0);
        imageView6.setFitWidth(23.0);
        imageView6.setLayoutX(101.0);
        imageView6.setLayoutY(14.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("/tictactoe/resources/status.png").toExternalForm()));

        imageView7.setFitHeight(109.0);
        imageView7.setFitWidth(105.0);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        imageView7.setImage(new Image(getClass().getResource("/tictactoe/resources/onlinePerson.png").toExternalForm()));

        anchorPane3.setLayoutX(444.0);
        anchorPane3.setLayoutY(50.0);
        anchorPane3.setPrefHeight(199.0);
        anchorPane3.setPrefWidth(140.0);
        anchorPane3.setStyle("-fx-background-color: #ffffff;");

        label3.setLayoutX(6.0);
        label3.setLayoutY(82.0);
        label3.setPrefHeight(67.0);
        label3.setPrefWidth(132.0);
        label3.setText("User One ");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        label3.setFont(new Font(19.0));

        imageView8.setFitHeight(24.0);
        imageView8.setFitWidth(23.0);
        imageView8.setLayoutX(101.0);
        imageView8.setLayoutY(14.0);
        imageView8.setPickOnBounds(true);
        imageView8.setPreserveRatio(true);
        imageView8.setImage(new Image(getClass().getResource("/tictactoe/resources/status.png").toExternalForm()));

        imageView9.setFitHeight(109.0);
        imageView9.setFitWidth(105.0);
        imageView9.setPickOnBounds(true);
        imageView9.setPreserveRatio(true);
        imageView9.setImage(new Image(getClass().getResource("/tictactoe/resources/onlinePerson.png").toExternalForm()));

        anchorPane4.setLayoutX(168.0);
        anchorPane4.setLayoutY(50.0);
        anchorPane4.setPrefHeight(229.0);
        anchorPane4.setPrefWidth(119.0);

        label4.setLayoutX(6.0);
        label4.setLayoutY(82.0);
        label4.setPrefHeight(67.0);
        label4.setPrefWidth(132.0);
        label4.setText("User One ");
        label4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#33cccc"));
        label4.setFont(new Font(19.0));

        imageView10.setFitHeight(24.0);
        imageView10.setFitWidth(23.0);
        imageView10.setLayoutX(101.0);
        imageView10.setLayoutY(14.0);
        imageView10.setPickOnBounds(true);
        imageView10.setPreserveRatio(true);
        imageView10.setImage(new Image(getClass().getResource("/tictactoe/resources/status.png").toExternalForm()));

        imageView11.setFitHeight(109.0);
        imageView11.setFitWidth(105.0);
        imageView11.setPickOnBounds(true);
        imageView11.setPreserveRatio(true);
        imageView11.setImage(new Image(getClass().getResource("/tictactoe/resources/onlinePerson.png").toExternalForm()));
        hBox.setPadding(new Insets(40.0, 0.0, 0.0, 20.0));
        scrollPane.setContent(hBox);
        BorderPane.setMargin(scrollPane, new Insets(0.0));
        setCenter(scrollPane);

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(textField);
        anchorPane.getChildren().add(imageView0);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(imageView1);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(imageView2);
        anchorPane0.getChildren().add(imageView3);
        hBox.getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(label1);
        anchorPane1.getChildren().add(imageView4);
        anchorPane1.getChildren().add(imageView5);
        hBox.getChildren().add(anchorPane1);
        anchorPane2.getChildren().add(label2);
        anchorPane2.getChildren().add(imageView6);
        anchorPane2.getChildren().add(imageView7);
        hBox.getChildren().add(anchorPane2);
        anchorPane3.getChildren().add(label3);
        anchorPane3.getChildren().add(imageView8);
        anchorPane3.getChildren().add(imageView9);
        hBox.getChildren().add(anchorPane3);
        anchorPane4.getChildren().add(label4);
        anchorPane4.getChildren().add(imageView10);
        anchorPane4.getChildren().add(imageView11);
        hBox.getChildren().add(anchorPane4);

    }
}

