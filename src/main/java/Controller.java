/*  Author:
 *  io.github.mikeh627
 *  9/19/2020 -- Production Project
 *  Controller application file, with methods for buttons, connection to database and initialization of program.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {

    @FXML
    private TextField manuName;

    @FXML
    private TextField prodName;

    @FXML
    private ChoiceBox<String> itemChoice;

    @FXML
    private ComboBox<String> quantityCombo;

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
        String type = itemChoice.getValue();
        String manufacturer = manuName.getText();
        String name = prodName.getText();

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

        connDB();
        System.out.println("Production has been recorded!");
    }

    // Initializes user interface
    public void initialize(){
        connDB();
        /*
         *   Adds items to the choice box in the Production Line tab on user interface
         */
        itemChoice.getItems().setAll(String.valueOf(ItemType.AUDIO), String.valueOf(ItemType.VISUAL),
                String.valueOf(ItemType.AUDIO_MOBILE), String.valueOf(ItemType.VISUAL_MOBILE));
        /*
         *   Adds a drop down list for up to ??? and allows users to enter and value they'd like
         */
        for (int count = 1 ; count <= 10; count ++) {
            quantityCombo.getItems().add(String.valueOf(count));
        }
        quantityCombo.setEditable(true);
        quantityCombo.getSelectionModel().selectFirst();
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
}
