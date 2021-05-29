import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//accountPage control
public class AccountPage {
    Database db = new Database();
    @FXML
    TextArea balance = new TextArea("balance");
    @FXML
    TextField amount = new TextField("amount");
    Account account = new Account();


    @FXML
    public void initialize(){
        //Collect data from database
        //account.setTotal(db.dbConnection());
        balance.setText(Double.toString(account.getTotal()));
    }

    @FXML
    public void deposit(){

        double toDeposit = Double.parseDouble(amount.getText());

        double total = account.getTotal();

        total = total + toDeposit;

        //set total in db

        account.setTotal(total);

        balance.setText(Double.toString(account.getTotal()));


    }

    @FXML
    public void withdraw(){

        double toWithdraw = Double.parseDouble((amount.getText()));

        double total = account.getTotal();

        total = total - toWithdraw;

        //set total to db

        account.setTotal(total);

        balance.setText(Double.toString(account.getTotal()));

    }
}
