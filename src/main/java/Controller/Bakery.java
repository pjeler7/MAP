package Controller;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Filter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.*;
import repository.*;

public class Bakery implements Initializable {

    private CakeRepositoryFile cakeRepo;
    private OrderRepositoryFile orderRepo;

    private ObservableList<Cake> list;
    private ObservableList<Order> listOrder;
    private ObservableList<Order> unfinishedOrders;
    private ObservableList<Cake> reportsCake;

    @FXML
    private TextField flavour_tf;
    @FXML
    private TextField price_tf;
    @FXML
    private TextField weight_tf;
    @FXML
    private Label label1;
    @FXML
    private Label label4;
    @FXML
    private Label nFlavour;
    @FXML
    private Label nPrice;
    @FXML
    private Label nWeight;
    @FXML
    private Label nStatus;
    @FXML
    private Label nTP;
    @FXML
    private Label newDate;
    @FXML
    private TextField newFlavour_tf;
    @FXML
    private TextField newWeight_tf;
    @FXML
    private TextField newTP_tf;
    @FXML
    private DatePicker newDate1;


    @FXML
    private Button addCakeBtn;
    @FXML
    private Button clearFieldsBtn;
    @FXML
    private Button clearOrderFieldsBtn;
    @FXML
    private Button deleteCakeBtn;
    @FXML
    private Button deleteOrderBtn;
    @FXML
    private Button updateOrderBtn;
    @FXML
    private Button updateCake;
    @FXML
    private Button addOrderBtn;
    @FXML
    private Button unfinishedOrdersBtn;
    @FXML
    private Button finishedOrdersBtn;
    @FXML
    private Button clearReportsButton;
    @FXML
    private Button givenDate;

    @FXML
    private TextField request_tf;
    @FXML
    private TextField totalPrice_tf;
    @FXML
    private TextField status_tf;
    @FXML
    private DatePicker datepicker2;
    @FXML
    private TextField request1_tf;
    @FXML
    private Label label2;
    @FXML
    private TextField newStatus_tf;
    @FXML
    private TextField newPrice_tf;
    @FXML
    private TextField reportDate_tf;
    @FXML
    private Label label3;

    @FXML
    private TableView<Cake> requestTableView;
    @FXML
    private TableView<Cake> requestTableView1;
    @FXML
    private TableView<Order> requestTableViewOrder;
    @FXML
    private TableView<Order> UnfinishedOrders;
    @FXML
    private TableColumn<Cake, Integer> requestIDCol;
    @FXML
    private TableColumn<Cake, String> flavourCol;
    @FXML
    private TableColumn<Cake, Float> priceCol;
    @FXML
    private TableColumn<Cake, Integer> weightCol;
    @FXML
    private TableColumn<Cake, Integer> requestIDCol1;
    @FXML
    private TableColumn<Cake, String> flavourCol1;
    @FXML
    private TableColumn<Cake, Float> priceCol1;
    @FXML
    private TableColumn<Cake, Integer> weightCol1;
    @FXML
    private TableColumn<Order, Integer> IDCol;
    @FXML
    private TableColumn<Cake, Integer> cakeCol;
    @FXML
    private TableColumn<Order, Float> totalPriceCol;
    @FXML
    private TableColumn<Order, LocalDate> dateCol;
    @FXML
    private TableColumn<Order, String> statusCol;
    @FXML
    private TableColumn<Order, Integer> ReportsID;
    @FXML
    private TableColumn<Cake, Integer> ReportsCake;
    @FXML
    private TableColumn<Order, Float> ReportsPrice;
    @FXML
    private TableColumn<Order, LocalDate> ReportsDate;
    @FXML
    private TableColumn<Order, String> ReportsStatus;


    public Bakery() {
        this.cakeRepo = new CakeRepositoryFile("C:\\Users\\paulj\\eclipse-workspace\\Assigment\\cakeRepoFile.txt");
        this.orderRepo = new OrderRepositoryFile("C:\\Users\\paulj\\eclipse-workspace\\Assigment\\orderRepoFile.txt", cakeRepo);
        this.list = FXCollections.observableArrayList();
        this.listOrder = FXCollections.observableArrayList();
        this.unfinishedOrders = FXCollections.observableArrayList();
        this.reportsCake = FXCollections.observableArrayList();
    }

    public void updateRequestCakeTable() {
        requestIDCol.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("ID"));
        flavourCol.setCellValueFactory(new PropertyValueFactory<Cake, String>("flavour"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Cake, Float>("price"));
        weightCol.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("weight"));

        requestIDCol1.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("ID"));
        flavourCol1.setCellValueFactory(new PropertyValueFactory<Cake, String>("flavour"));
        priceCol1.setCellValueFactory(new PropertyValueFactory<Cake, Float>("price"));
        weightCol1.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("weight"));

        for (Cake elem : cakeRepo.findAll()) {
            list.add(elem);
            System.out.println(elem.getID());
            System.out.println(elem.getFlavour());
            System.out.println(elem.getPrice());
            System.out.println(elem.getWeight());
        }

        requestTableView.setItems(list);
        requestTableView1.setItems(list);

    }


    public void updateRequestOrderTable() {
        IDCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("ID"));
        cakeCol.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("Cake"));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<Order, Float>("totalPrice"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));

        for (Order elem : orderRepo.findAll()) {
            listOrder.add(elem);
        }
        requestTableViewOrder.setItems(listOrder);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        updateRequestCakeTable();
        updateRequestOrderTable();
    }

    @FXML
    public void clearFields(ActionEvent event) throws IOException {
        flavour_tf.setText("");
        price_tf.setText("");
        weight_tf.setText("");
    }

    public void clearFieldsOrder(ActionEvent event) throws IOException {
        totalPrice_tf.setText("");
        datepicker2.setValue(null);
        status_tf.setText("");
    }

    @FXML
    public void addCake(ActionEvent event) throws IOException {
        String flavour = flavour_tf.getText();
        if (flavour.equals("")) {
            flavour_tf.setStyle("-fx-border-color: red;");
            return;
        } else {
            flavour_tf.setStyle("-fx-border-color: none;");
        }

        String price = price_tf.getText();
        if (price.equals("")) {
            price_tf.setStyle("-fx-border-color: red;");
            return;
        }

        String weight = weight_tf.getText();
        if (weight.equals("")) {
            weight_tf.setStyle("-fx-border-color: red;");
            return;
        }

        int ID = 0;
        boolean g = false;

        for (Cake elem : cakeRepo.findAll()) {
            if (elem.getID() - 2 == ID) {
                ID = elem.getID() - 1;
                g = true;
                break;
            } else if (elem.getID() > ID) {
                ID = elem.getID();
            }
        }
        int p = Integer.parseInt(price);
        int w = Integer.parseInt(weight);

        if (!g) {
            Cake req = new Cake(ID + 1, flavour, p, w);
            this.cakeRepo.add(req);
            this.list.add(req);
            label1.setText("Added!");
        } else {
            Cake req = new Cake(ID, flavour, p, w);
            this.cakeRepo.add(req);
            this.list.add(req);
            label1.setText("Added!");
        }

        /*System.out.println(this.cakeRepo.findAll().toString());*/
        this.clearFields(event);
    }

    @FXML
    public void searchCake(ActionEvent event) throws IOException {
        FilteredList<Cake> filteredList = new FilteredList<>(list, b -> true);

        request_tf.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(cake -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if (cake.getID().toString().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (cake.getFlavour().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (cake.getPrice() > -1) {
                    return true;
                } else if (cake.getWeight() > -1) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<Cake> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(requestTableView1.comparatorProperty());
        requestTableView1.setItems(sortedList);
    }


    @FXML
    public void searchOrder(ActionEvent event) throws IOException {
        FilteredList<Order> filteredList = new FilteredList<>(listOrder, b -> true);

        request1_tf.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(order -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if (order.getID().toString().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                }
                if (String.valueOf(order.getTotalPrice()).toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (order.getStatus().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (order.getDate().toString().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else
                    return false;


            });
        });
        SortedList<Order> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(requestTableViewOrder.comparatorProperty());
        requestTableViewOrder.setItems(sortedList);
    }

    @FXML
    public void addOrder(ActionEvent event) throws IOException {

        Cake cake = requestTableView.getSelectionModel().getSelectedItem();

        String totalPrice = totalPrice_tf.getText();
        if (totalPrice.equals("")) {
            totalPrice_tf.setStyle("-fx-border-color: red;");
            return;
        }

        LocalDate date = datepicker2.getValue();
        if (date.equals("")) {
            datepicker2.setStyle("-fx-border-color: red;");
            return;
        }

        String status = status_tf.getText();
        if (status.equals("")) {
            status_tf.setStyle("-fx-border-color: red;");
            return;
        } else {
            flavour_tf.setStyle("-fx-border-color: none;");
        }

        int ID = 0;
        boolean g = false;

        for (Order elem : orderRepo.findAll()) {
            if (elem.getID() - 2 == ID) {
                ID = elem.getID() - 1;
                g = true;
                break;
            } else if (elem.getID() > ID) {
                ID = elem.getID();
            }
        }
        float tp = Float.parseFloat(totalPrice);
        if(!g) {
            if (tp == cake.getPrice()) {
                Order ord = new Order(ID + 1, cake.getID(), tp, date, status);
                this.orderRepo.add(ord);
                this.listOrder.add(ord);
                this.clearFieldsOrder(event);
                label2.setText("Added!");
            } else
                label2.setText("Invalid parameters!");
        }else {
            if (tp == cake.getPrice()) {
                Order ord = new Order(ID, cake.getID(), tp, date, status);
                this.orderRepo.add(ord);
                this.listOrder.add(ord);
                this.clearFieldsOrder(event);
                label2.setText("Added!");
            } else
                label2.setText("Invalid parameters!");
        }
    }

    @FXML
    public void deleteCake(ActionEvent event) {
        Cake cake = requestTableView1.getSelectionModel().getSelectedItem();
        requestTableView1.getItems().removeAll(cake);
        cakeRepo.cancel(cake);
    }

    @FXML
    public void deleteOrder(ActionEvent event) {
        Order order = requestTableViewOrder.getSelectionModel().getSelectedItem();
        requestTableViewOrder.getItems().removeAll(order);
        orderRepo.cancel(order);
    }

    @FXML
    public void UpdateCake(ActionEvent event){
        Cake cake = requestTableView1.getSelectionModel().getSelectedItem();
        String flavour = newFlavour_tf.getText();
        float price = Float.parseFloat(newPrice_tf.getText());
        int weight = Integer.parseInt(newWeight_tf.getText());

        cake.setPrice(price);
        cake.setFlavour(flavour);
        cake.setWeight(weight);

        newPrice_tf.setText("");
        newFlavour_tf.setText("");
        newWeight_tf.setText("");

        cakeRepo.update(cake,cake.getID());
        requestTableView.getItems().clear();
        updateRequestCakeTable();
    }



    @FXML
    public void updateOrder(ActionEvent event) {
        Order selected = requestTableViewOrder.getSelectionModel().getSelectedItem();
        String status = newStatus_tf.getText();
        int cake = Integer.parseInt(newTP_tf.getText());
        LocalDate date = newDate1.getValue();

        int poz = -1;
        for(Cake c : cakeRepo.findAll()){
            if(c.getID() == cake){
                poz = c.getID();
            }
        }

        if(poz!=-1) {
            selected.setCake(cake);
            selected.setTotalPrice(cakeRepo.findById(cake).getPrice());
            selected.setStatus(status);
            selected.setDate(date);

            newStatus_tf.setText("");
            newTP_tf.setText("");
            newDate1.setValue(null);
            label4.setText("");

            orderRepo.update(selected, selected.getID());
            requestTableViewOrder.getItems().clear();
            updateRequestOrderTable();
        }
        else{
            label4.setText("New CakeID is invalid");
        }
    }

    @FXML
    public void clearReportsFields(ActionEvent event) {
        UnfinishedOrders.getItems().clear();
    }

    @FXML
    public void getUnfinishedOrders(ActionEvent event) {
        UnfinishedOrders.getItems().clear();
        ReportsID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("ID"));
        ReportsCake.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("Cake"));
        ReportsPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("totalPrice"));
        ReportsDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("date"));
        ReportsStatus.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));


        for (Order o : listOrder) {
            if (o.getStatus().equals("Not finished") || o.getStatus().equals("In progress")) {
                unfinishedOrders.add(o);
            }
        }

        UnfinishedOrders.setItems(unfinishedOrders);
    }

    @FXML
    public void getFinishedOrders(ActionEvent event) {
        UnfinishedOrders.getItems().clear();
        ReportsID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("ID"));
        ReportsCake.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("Cake"));
        ReportsPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("totalPrice"));
        ReportsDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("date"));
        ReportsStatus.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));


        for (Order o : listOrder) {
            if (o.getStatus().equals("Finished")) {
                unfinishedOrders.add(o);
            }
        }

        UnfinishedOrders.setItems(unfinishedOrders);
    }

    @FXML
    public void givenDateOrder(ActionEvent event) {
        UnfinishedOrders.getItems().clear();
        ReportsID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("ID"));
        ReportsCake.setCellValueFactory(new PropertyValueFactory<Cake, Integer>("Cake"));
        ReportsPrice.setCellValueFactory(new PropertyValueFactory<Order, Float>("totalPrice"));
        ReportsDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("date"));
        ReportsStatus.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));

        String date = reportDate_tf.getText();
        LocalDate d = LocalDate.parse(date);
        for (Order o : listOrder) {
            if (o.getDate().equals(d)) {
                unfinishedOrders.add(o);
            }
        }
        reportDate_tf.setText("");
        UnfinishedOrders.setItems(unfinishedOrders);
    }


}

