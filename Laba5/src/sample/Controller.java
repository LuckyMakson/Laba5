package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Classes.Investor;
import sample.Classes.Investors;
import sample.Classes.Realization;

public class Controller {
    private ObservableList<Investor> list = FXCollections.observableArrayList();
    Realization realization = new Realization("Investors.txt");
    private static Investors investors;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSearch;

    @FXML
    private MenuButton btnMenuSearchBy;

    @FXML
    private MenuItem findByDeposit;

    @FXML
    private MenuItem findByFullname;

    @FXML
    private MenuItem findByFullTerm;

    @FXML
    private MenuItem viewInv;

    @FXML
    private TextField txtFIOAdd;

    @FXML
    private TextField txtContractNumberAdd;

    @FXML
    private TextField txtAdressAdd;

    @FXML
    private Button btnAddInvestor;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtDepositAdd;

    @FXML
    private TextField txtTermAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtDelete;

    @FXML
    private TableView<Investor> tableInvestors;

    @FXML
    private TableColumn<Investor, String> FullnameColumn;

    @FXML
    private TableColumn<Investor, String> contractNumberColumn;

    @FXML
    private TableColumn<Investor, String> adressColumn;

    @FXML
    private TableColumn<Investor, Integer> depositColumn;

    @FXML
    private TableColumn<Investor, Integer> termColumn;


    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void openFile(ActionEvent event) {

    }

    @FXML
    void printList(ActionEvent event) {

    }

    @FXML
    void onChangeSearch(MouseEvent event) {

    }

    @FXML
    void onEnteredAdress(MouseEvent event) {

    }

    @FXML
    void onEnteredFullname(MouseEvent event) {

    }

    @FXML
    void onEnteredNumberAdd(MouseEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {
        try {
            realization.New(investors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setItemMenuFind(MouseEvent event) {
        findByDeposit.setOnAction((e) -> btnMenuSearchBy.setText("По депозиту"));
        findByFullname.setOnAction((e) -> btnMenuSearchBy.setText("По Ф.И.О."));
        findByFullTerm.setOnAction((e) -> btnMenuSearchBy.setText("По сроку"));
        viewInv.setOnAction((e) -> btnMenuSearchBy.setText("Список инвесторов"));
    }

    @FXML
    void initialize() {
        investors = new Investors();

        FullnameColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("FIO"));
        contractNumberColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("contractNumber"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("address"));
        depositColumn.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("deposit"));
        termColumn.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("contractTerm"));

        addToTable();
    }

    private void addToTable() {
        list.clear();
        tableInvestors.getItems().clear();

        list.addAll(investors.getList());
        tableInvestors.setItems(list);
    }

    @FXML
    void addToListByForm(ActionEvent event) {
        try {
            if (Investor.CheckCorrectFIO(txtFIOAdd.getText()) && Investor.CheckCorrectNumber(txtDepositAdd.getText()) &&
                    Investor.CheckCorrectNumber(txtTermAdd.getText())) {
                investors.addToList(new Investor(txtFIOAdd.getText(), txtContractNumberAdd.getText(), txtAdressAdd.getText(), Integer.parseInt(txtDepositAdd.getText()), Integer.parseInt(txtTermAdd.getText())));
                addToTable();
            } else {
                AlertInformation("Добавление инвестора в список", "Некорректный ввод", "Поля заполнены неверно", Alert.AlertType.INFORMATION);

            }
        } catch (Exception ex) {
        }
        ;
    }

    @FXML
    void deleteFromList(ActionEvent event) {
        ArrayList<Investor> sublist=new ArrayList<Investor>();

        sublist = investors.deleteWithFIO(txtDelete.getText());
        investors.clear();
        investors= (Investors) sublist;
        addToTable();
    }

    @FXML
    void findByDep(ActionEvent event) {
    }

    @FXML
    void findByFIO(ActionEvent event) {
    }

    @FXML
    void findByTerm(ActionEvent event) {
    }

    @FXML
    void viewInvestors(ActionEvent event) {
    }

    @FXML
    void btnSearch(ActionEvent event) {
        ObservableList<Investor> sublist = FXCollections.observableArrayList();
        sublist.clear();

        if (btnMenuSearchBy.getText().equals("По Ф.И.О.")) {

            if (Investor.CheckCorrectFIO(txtSearch.getText())) {
                sublist.addAll((investors.getWithFIO(txtSearch.getText())).getList());
                tableInvestors.getItems().clear();
                tableInvestors.setItems(sublist);
            } else {
                AlertInformation("Поиск инвесторов в списке по фамилии ", "Некорректный ввод", "Поле заполнено неверно", Alert.AlertType.INFORMATION);
            }
        }

        if (btnMenuSearchBy.getText().equals("По депозиту")) {

            if (Investor.CheckCorrectNumber(txtSearch.getText())) {
                sublist.addAll((investors.getWithGraterDeposit(Double.parseDouble(txtSearch.getText()))).getList());
                tableInvestors.getItems().clear();
                tableInvestors.setItems(sublist);
            } else {
                AlertInformation("Поиск инвесторов в списке по депозиту", "Некорректный ввод", "Поле заполнено неверно", Alert.AlertType.INFORMATION);
            }
        }

        if (btnMenuSearchBy.getText().equals("По сроку")) {

            if (Investor.CheckCorrectNumber(txtSearch.getText())) {
                sublist.addAll((investors.getWithGraterTempDeposit(Double.parseDouble(txtSearch.getText()))).getList());
                tableInvestors.getItems().clear();
                tableInvestors.setItems(sublist);
            } else {
                AlertInformation("Поиск инвесторов в списке по сроку", "Некорректный ввод", "Поле заполнено неверно", Alert.AlertType.INFORMATION);
            }
        }

        if (btnMenuSearchBy.getText().equals("Список инвесторов"))
            addToTable();
    }

    private void AlertInformation(String title, String header, String content, Alert.AlertType typeAlert) {
        Alert alert = new Alert(typeAlert);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
