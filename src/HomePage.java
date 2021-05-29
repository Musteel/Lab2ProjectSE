import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;

//homePage controller
public class HomePage extends Component {
    public TextField userField;
    public TextField passwordField;
    Database database = new Database();
    Alert alert;

    //This method is run when login button in pressed
    @FXML
    public void loginButtonPressed(ActionEvent event) throws Exception {

        String userString = userField.getText();
        String passwordString = passwordField.getText();

        if(database.isLogin(userString,passwordString).equals("Done")) {
            SceneChange(event);
        }
    }

    //change scene method
    public void SceneChange(ActionEvent event) {
        try {
            Parent homePageParent = FXMLLoader.load(getClass().getResource("FXML/accountpage.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(homePageScene);
            appStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
