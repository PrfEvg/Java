package Lesson6.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField msgField;
    @FXML
    TextArea msgArea;
    private DataInputStream in;
    private  DataOutputStream out;

    public void initialize(URL url, ResourceBundle resourceBundle) {
try {
    Socket socket = new Socket("localhost", 8191);
    in = new DataInputStream(socket.getInputStream());
    out = new DataOutputStream(socket.getOutputStream());

    Thread dataThread = new Thread(() -> {
        try {
            while (true){
               String msg = in.readUTF();
               msgArea.appendText(msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    dataThread.start();
} catch (IOException e) {
    throw new RuntimeException("Unable to connect to server [localhost: 8191]");
}
    }
    public void sendMsg(ActionEvent actionEvent) {
        String msg = msgField.getText() + '\n';
        try {
             out.writeUTF(msg);
             msgField.clear();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Невозможно отправить сообщение", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
