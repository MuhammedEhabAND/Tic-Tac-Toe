package tictactoe.view.play_online;



import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.model.User;
import tictactoe.presenter.OnClickItemListener;
import tictactoe.presenter.auth_server.NetworkListener;
import tictactoe.presenter.auth_server.NetworkResponse;
import tictactoe.presenter.auth_validation.AuthInputValidator;
import tictactoe.presenter.auth_validation.AuthInputValidatorImpl;
import tictactoe.presenter.auth_validation.Authentication;
import tictactoe.presenter.auth_validation.AuthenticationImpl;
import tictactoe.presenter.play_with_other.PlayWithOthers;
import tictactoe.presenter.retrieve_online_users.OnlineUsersGetter;
import tictactoe.presenter.retrieve_online_users.ServerResponse;
import tictactoe.utils.Constants;
import tictactoe.utils.Validation;


public  class PlayOnline extends BorderPane implements OnClickItemListener {
    DataInputStream dataInputStream;
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

    private Stage stage;
    private final User user;
    private final PrintStream printStream;
     ArrayList<String> onlineUsersList ;
    protected final ListView <ItemOnlineUser>list_of_Online_users;

        


    public PlayOnline(Stage stage , User user ,PrintStream printStream ,DataInputStream dataInputStream)  {
           new Scene(this);
        this.stage = stage;
        this.user = user;
        this.printStream = printStream;
        this.dataInputStream = dataInputStream;
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
        list_of_Online_users = new ListView();
        onlineUsersList = new ArrayList<>() ;

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
        text.setText(user.getUserName());
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
        scrollPane.setPrefHeight(223.0);
        scrollPane.setPrefWidth(669.0);
          scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background-color: #ffffff; -fx-hbar-policy: never; -fx-vbar-policy: never;");

        hBox.setStyle("-fx-background-color: #ffffff;");
        list_of_Online_users.setPrefHeight(220.0);
        list_of_Online_users.setPrefWidth(698.0);
                list_of_Online_users.setOrientation(javafx.geometry.Orientation.HORIZONTAL);

        HBox.setMargin(list_of_Online_users, new Insets(0.0));
        scrollPane.setContent(hBox);
        BorderPane.setMargin(scrollPane, new Insets(0.0));
        setCenter(scrollPane);

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(textField);
        anchorPane.getChildren().add(imageView0);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(imageView1);
        hBox.getChildren().add(list_of_Online_users);
    retrieveOnlineUsers();
       
      

         
    }
    void retrieveOnlineUsers() {
       
            new Thread(
                    new OnlineUsersGetter(
                            true,
                            dataInputStream,
                            user,
                            Constants.GET_USERS,
                            printStream,
                            new ServerResponse() {
                @Override
                public void onSuccess() {
                    addOnlineUsersToListView();
                }

                @Override
                public void onError(String errorMessage) {               
                }
            },onlineUsersList

                    )
            ) .start();
       
    }
    void playWithOtherUser(String opUserName){
            new Thread(
                    new PlayWithOthers(
                            dataInputStream,
                            user.getUserName(),
                            Constants.SEBD_REQUEST_TO_PLAY,
                            printStream,
                            new ServerResponse() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError(String errorMessage) {
                }
            }, opUserName)
            ) .start();
    
    }
        public void addOnlineUsersToListView() {
             List<ItemOnlineUser> items = new ArrayList<>();
            for (String userName : onlineUsersList) {
                if(!userName.equals(user.getUserName())){
                items.add(    new ItemOnlineUser(this ,userName));
                           }
            }
           list_of_Online_users.getItems().addAll(items);
        
          

      
    }

    @Override
    public void onClick(String opponentUserName) {
       playWithOtherUser(opponentUserName);//To change body of generated methods, choose Tools | Templates.
    }
}





