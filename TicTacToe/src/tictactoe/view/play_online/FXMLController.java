/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.view.play_online;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import tictactoe.model.OnlineUser;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class FXMLController implements Initializable {
OnlineUser item;

    @FXML
    private Label user_name;
           
      public    void   init(OnlineUser item){
                      user_name.setText("asdasdasdasdsa");
     System.out.println("gggg");

          this.item=item;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            user_name.setText("asdasdasdasdsa");
     System.out.println("tttttt");

 if (item != null) {
            //userName.setText(item.getUserName());
            user_name.setText("asdasdasdasdsa");
     
        }else{
     System.out.println("nulllllllllllllllllllllllllllllllll");
 }
        System.out.println(user_name.getText());    }    
    
}
