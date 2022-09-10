/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author luciano
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnMecanicos;
 
   
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarPantallaMecanicos(ActionEvent event) throws IOException {
        App.setRoot("mecanicos");
    }

    @FXML
    private void mostrarPantallaAgenda(ActionEvent event) throws IOException {
        App.setRoot("agenda");
    }
    @FXML
    private void mostrarClientes(ActionEvent event) throws IOException {
        App.setRoot("clientes");
    }
    @FXML
    private void mostrarPantallaInformes(ActionEvent event) throws IOException {
        App.setRoot("informes");
    }
}