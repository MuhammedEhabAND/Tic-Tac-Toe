package tictactoe.view.play_online;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public  class ItemOnlineUser extends AnchorPane {

    protected final Label user_name;
    protected final ImageView imageView;
    protected final ImageView imageView0;

    public ItemOnlineUser(String username) {

        user_name = new Label();
        imageView = new ImageView();
        imageView0 = new ImageView();
        setId("AnchorPane");
        setPrefHeight(190.0);
        setPrefWidth(116.0);
        setStyle("-fx-background-color: #ffffff;");

        user_name.setLayoutX(14.0);
        user_name.setLayoutY(105.0);
        user_name.setPrefHeight(50.0);
        user_name.setPrefWidth(125.0);
        user_name.setText(username);
        user_name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        user_name.setTextFill(javafx.scene.paint.Color.valueOf("#000000"));
        user_name.setFont(new Font(19.0));

        imageView.setFitHeight(24.0);
        imageView.setFitWidth(23.0);
        imageView.setLayoutX(101.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/tictactoe/resources/status.png").toExternalForm()));

        imageView0.setFitHeight(109.0);
        imageView0.setFitWidth(105.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/tictactoe/resources/onlinePerson.png").toExternalForm()));

        getChildren().add(user_name);
        getChildren().add(imageView);
        getChildren().add(imageView0);

    }
}
