/*  Author:
 *  io.github.mikeh627
 *  9/19/2020 -- Production Project
 *  Controller application file, with methods for buttons, connection to database and initialization of program.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {

    ObservableList<Product> productLine = FXCollections.observableArrayList();

    @FXML
    private TextField manuName;

    @FXML
    private TextField prodName;

    @FXML
    private ChoiceBox<ItemType> itemChoice;

    @FXML
    private ComboBox<String> quantityCombo;

    @FXML
    private TextArea prodLog;

    @FXML
    private TableView<Product> prodTable;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> manuColumn;

    @FXML
    private TableColumn<?, ?> iTypeColumn;

    @FXML
    private ListView<Product> listTable;

    @FXML
    private Button btnAddProduct;

    @FXML
    private Button btnRecordProduction;

    // Global variables
    final String USER = "";
    final String PASS = "";
    Connection conn = null;

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionDB";

    @FXML
    void addProduct(ActionEvent event) {
        String type = itemChoice.getValue().code;
        String manufacturer = manuName.getText();
        String name = prodName.getText();

        ProductionRecord product = new ProductionRecord(0);
        String x = product.toString();
        prodLog.setText(x);
        populateList();

        try {
            String insSql = "INSERT INTO PRODUCT(type, manufacturer, name) "
                    + "VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insSql);

            stmt.setString(1, type);
            stmt.setString(2, manufacturer);
            stmt.setString(3, name);

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Product added!");
    }

    @FXML
    void recordProduction(ActionEvent event) {
        ProductionRecord  productionRecord = new ProductionRecord(listTable.getSelectionModel().getSelectedItem(),
                Integer.parseInt(quantityCombo.getSelectionModel().getSelectedItem()));
        String text = prodLog.getText() + productionRecord.toString() + "\n";
        prodLog.setText(text);
        connDB();
        System.out.println("Production has been recorded!");
    }

    // Initializes user interface
    public void initialize(){
        connDB();
        /*
         *   Adds items to the choice box in the Production Line tab on user interface
         */
        itemChoice.getItems().setAll(ItemType.values());
        /*
         *   Adds a drop down list for up to ??? and allows users to enter and value they'd like
         */
        for (int count = 1 ; count <= 10; count ++) {
            quantityCombo.getItems().add(String.valueOf(count));
        }
        quantityCombo.setEditable(true);
        quantityCombo.getSelectionModel().selectFirst();

        setTable();
        listTable.setItems(productLine);
    }

    public void connDB() {
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            /*String queSql = "SELECT * FROM PRODUCT ";

            ResultSet rs = stmt.executeQuery(queSql);
            rs.next();
            System.out.println(rs.getString(1));
            */
            // STEP 4: Clean-up environment
            /*stmt.close();
            conn.close();*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory("Name"));
        manuColumn.setCellValueFactory(new PropertyValueFactory("Manufacturer"));
        iTypeColumn.setCellValueFactory(new PropertyValueFactory("Type"));
        prodTable.setItems(productLine);
    }

    public void populateList() {
        Product populate = new Widget(prodName.getText(), manuName.getText(), itemChoice.getValue());
        productLine.add(populate);
    }

}
