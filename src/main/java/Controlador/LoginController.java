/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Dao.EmpleadosDAO;
import Dao.PersonaDAO;
import Dto.EmpleadosDTO;
import Dto.PersonaDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author luciano
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnIniciarSesion;
    @FXML
    private TextField inputUsuario;
    @FXML
    private TextField inputClave;
    private static Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        String usuario = inputUsuario.getText();
        String password = inputClave.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            this.mostrarAlertWarning("Debe completar ambos campos");
        } else {
            EmpleadosDAO empleadoDAO = new EmpleadosDAO();

            int idPersona = empleadoDAO.validarUsuario(usuario, password);

            if (idPersona != 0) {
                PersonaDAO personaDAO = new PersonaDAO();
                PersonaDTO persona = personaDAO.read(idPersona);
                App.setRoot("home");
            } else {
                this.mostrarAlertWarning("No se encontro el usuario");
            }
        }
    }

    @FXML
    private void mostrarAlertWarning(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
