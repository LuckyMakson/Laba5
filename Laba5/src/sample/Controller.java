package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private ObservableList<Investor> investors = FXCollections.observableArrayList();

    @FXML
    private TableView<Investor> tableInvestors;

    @FXML
    private TableColumn<Investor, String> FIO;

    @FXML
    private TableColumn<Investor, String> ContractNumber;

    @FXML
    private TableColumn<Investor, String> Address;

    @FXML
    private TableColumn<Investor, Integer> Deposit;

    @FXML
    private TableColumn<Investor, Integer> Term;

    // инициализируем форму данными
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        FIO.setCellValueFactory(new PropertyValueFactory<Investor, String>("FIO"));
        ContractNumber.setCellValueFactory(new PropertyValueFactory<Investor, String>("Contract Number"));
        Address.setCellValueFactory(new PropertyValueFactory<Investor, String>("Address"));
        Deposit.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("Deposit"));
        Term.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("Term"));
        // заполняем таблицу данными
        tableInvestors.setItems(investors);
    }

    private void initData() {
        investors.add(new Investor("egergregre", "kergkle", "gkjejnger", 21, 1132));
        investors.add(new Investor("egergregre", "kergkle", "gkjejnger", 21, 1132));
        investors.add(new Investor("egergregre", "kergkle", "gkjejnger", 21, 1132));
        investors.add(new Investor("egergregre", "kergkle", "gkjejnger", 21, 1132));
        investors.add(new Investor("egergregre", "kergkle", "gkjejnger", 21, 1132));

    }

}
