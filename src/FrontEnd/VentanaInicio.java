package FrontEnd;

import BackEnd.EstadoDeAplicacion;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VentanaInicio{

    // Recive un primaryStage por entrada en el constructor y un String nombre sin contenido que despues va a ser rellenado con el nombre
    //no puede recibir un Usuario porque tendria que agregar el nombre al usuario desde la ventanaInicio

    public VentanaInicio(Stage primaryStage, EstadoDeAplicacion estadoAplicacion){
        primaryStage.setTitle("ITBA - Plan de Estudios");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text titulo = new Text("Bienvenido");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(titulo, 0, 0, 2, 1);

        Label usuario_campo = new Label("Usuario:");
        grid.add(usuario_campo, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("clave:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        Button btn = new Button("Ingresar");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (fieldsEmpty(usuario_campo, pwBox))
                    new Alert(Alert.AlertType.WARNING, "Por favor complete todos los campos.").show();
                else {
                    estadoAplicacion.crearUsuario(usuario_campo.getText());
                    EleccionDelPlan segundaVentana = new EleccionDelPlan(primaryStage, estadoAplicacion);
                }
            }
            private boolean fieldsEmpty(Label usuario_campo, PasswordField pwBox) {
                return usuario_campo.getText().isEmpty() || pwBox.getText().isEmpty();
            }

        });
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
    }
}
