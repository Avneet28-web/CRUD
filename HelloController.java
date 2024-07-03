package com.example.test2b_csd214;

import com.mysql.cj.log.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<Employee_Info> employee_infoTable;
    public TableColumn<Employee_Info,Integer> EmpID;
    public TableColumn <Employee_Info,String> EmpName;
    public TableColumn <Employee_Info,String> EmpSalary;
    public TableColumn <Employee_Info,String> EmpDepartment;
    public TextField eid;
    public TextField ename;
    public TextField esalary;
    public TextField edepartment;
    @FXML
    private Label welcomeText;

    ObservableList<Employee_Info> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fetchdata();
    }

    private void fetchdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/ test2b_avneet";
        String dbEmployee_Info = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbEmployee_Info,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM employee_info";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int EmpID = resultSet.getInt("EmpID");
                String EmpName = resultSet.getString("EmpName");
                String EmpSalary = resultSet.getString("EmpSalary");
                String EmpDepartment = resultSet.getString("EmpDepartment");
                employee_infoTable.getItems().add(new Employee_Info(EmpID, EmpName, EmpSalary, EmpDepartment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        EmpID.setCellValueFactory(new PropertyValueFactory<Employee_Info,Integer>("EmpID"));
        EmpName.setCellValueFactory(new PropertyValueFactory<Employee_Info,String>("EmpName"));
        EmpSalary.setCellValueFactory(new PropertyValueFactory<Employee_Info,String>("EmpSalary"));
        EmpDepartment.setCellValueFactory(new PropertyValueFactory<Employee_Info,String>("EmpDepartment"));
        employee_infoTable.setItems(list);


    }

    public void InsertData(ActionEvent actionEvent) {



        String EmpName = ename.getText();
        String EmpSalary = esalary.getText();
        String EmpDepartment = edepartment.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/ test2b_avneet";
        String dbEmployee_Info = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbEmployee_Info,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `employee_info`( `EmpName`, `EmpSalary`, `EmpDepartment`) VALUES ('"+EmpName+"','"+EmpSalary+"','"+EmpDepartment+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void UpdateData(ActionEvent actionEvent) {
        String EmpID = eid.getText();
        String EmpName = ename.getText();
        String EmpSalary = esalary.getText();
        String EmpDepartment = edepartment.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/test2b_avneet";
        String dbEmployee_Info = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbEmployee_Info,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `employee_info` SET `EmpName`='"+EmpName+"',`EmpSalary`='"+EmpSalary+"',`EmpDepartment`='"+EmpDepartment+"' WHERE EmpID='"+EmpID+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {

        String EmpID = eid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/test2b_avneet";
        String dbEmployee_Info = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbEmployee_Info,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `employee_info` WHERE EmpID='"+EmpID+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String EmpID = eid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/ test2b_avneet";
        String dbEmployee_Info = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbEmployee_Info,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM employee_info WHERE EmpID='"+EmpID+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String EmpName = resultSet.getString("EmpName");
                String EmpSalary = resultSet.getString("EmpSalary");
                String EmpDepartment = resultSet.getString("EmpDepartment");

                ename.setText(EmpName);
                esalary.setText(EmpSalary);
                edepartment.setText(EmpDepartment);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}