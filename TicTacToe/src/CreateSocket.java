
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import tictactoe.utils.Constants;
import tictactoe.view.login.Login;
import tictactoe.view.register.Register;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohammed
 */
public class CreateSocket {
    Socket mySocket;
    DataInputStream dataInputStream;
    PrintStream printStream;
      CreateSocket(){
        try {
            mySocket = new  Socket(Constants.HOST, Constants.PORT);
            dataInputStream = new DataInputStream(mySocket.getInputStream());
            printStream = new PrintStream(mySocket.getOutputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error");
            }
        }
}
