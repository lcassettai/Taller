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
public class TurnosController implements Initializable {

    @FXML
    private Button btnVolver;
    @FXML
    private Button btnVolver2;
    @FXML
    private Button btnVolver11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void volverAtras(ActionEvent event) throws IOException {
        App.setRoot("home");
    }

    private void mostrarPantallaAgenda(ActionEvent event) throws IOException {
        App.setRoot("agenda");
    }

    @FXML
    private void mostrarPantallafichaMecanica(ActionEvent event) throws IOException {
         App.setRoot("fichaMecanica");
    }
    
}
