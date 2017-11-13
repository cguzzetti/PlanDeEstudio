package FrontEnd;

import java.util.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import BackEnd.*;

public class EleccionDelPlan {
    private Stage stage;
    private EstadoDeAplicacion estado;

    public EleccionDelPlan(Stage stage, EstadoDeAplicacion estado) {
        this.stage = stage;
        this.estado = estado;
    }

    public void setStage() {
        stage.setScene(new Scene(new Pane()));
        stage.show();
    }

    private class Pane extends VBox {

        private static final String CREDITOS_LABEL = "Cantidad maxima\nde creditos";
        private static final String ACADEMICO_TEXT = "Plan Academico";
        private static final String CORRELATIVO_TEXT = "Plan Correlativo";
        private static final String NINGUNA = "Ninguna";

        private TextField creditos = new TextField();

        Pane() {
            GridPane gridPane = new GridPane();
            gridPane.setHgap(5);
            gridPane.setVgap(5);
            gridPane.setPadding(new Insets(5, 5, 5, 5));

            Label nameLabel = new Label(CREDITOS_LABEL);
            Button planAcademico = new Button(ACADEMICO_TEXT);
            Button planCorrelativo = new Button(CORRELATIVO_TEXT);
            planAcademico.setTooltip(new Tooltip("Se seguira el Plan\nsegun el ITBA."));
            planCorrelativo.setTooltip(new Tooltip("Se prioritizaran las materias\nque tienen Correlatividades."));

            planAcademico.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(!isEmpty()) {
                        try {
                            if(!fueraDeRango()) {
                                PlanAcademico plan = estado.crearPlanAcademico(Integer.parseInt(creditos.getText()), materiasNoCursadas());
                                ImprimePlan imprime = new ImprimePlan(stage, plan, estado);
                                imprime.setStage();
                            }
                        } catch(NumberFormatException ex) {
                            new Alert(Alert.AlertType.WARNING, "La cantidad maxima de creditos\ntiene que ser un numero.").show();
                        }
                    }
                }
            });

            planCorrelativo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if(!isEmpty()) {
                        try {
                            if(!fueraDeRango()) {
                                PlanCorrelativo planCorrelativo = estado.crearPlanCorrelativo(Integer.parseInt(creditos.getText()), materiasNoCursadas());
                                ImprimePlan imprime = new ImprimePlan(stage, planCorrelativo, estado);
                                imprime.setStage();
                            }
                        } catch(NumberFormatException ex) {
                            new Alert(Alert.AlertType.WARNING, "La cantidad maxima de creditos\ntiene que ser un numero.").show();
                        }
                    }
                }
            });

            gridPane.add(nameLabel, 0, 1);
            gridPane.add(creditos, 1, 1);
            gridPane.setAlignment(Pos.CENTER);

            HBox buttonBox = new HBox(10);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.setPadding(new Insets(5, 5, 5, 5));
            buttonBox.getChildren().addAll(planAcademico, planCorrelativo);

            getChildren().addAll(gridPane, buttonBox);
        }

        private boolean isEmpty() {
            if (creditos.getText().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Por favor ingrese la cantidad\nmaxima de creditos por cuatrimestre.").show();
                return true;
            }
            return false;
        }

        private boolean fueraDeRango() throws NumberFormatException {
            if(Integer.parseInt(creditos.getText()) < 10 || Integer.parseInt(creditos.getText()) > 30) {
                new Alert(Alert.AlertType.WARNING, "Por favor ingrese una cantidad entre 10 y 30.").show();
                return true;
            }
            return false;
        }

        private Set<Materia> materiasNoCursadas() {
            Set<Materia> materiasNoCursadas = new HashSet<Materia>();
            ListadoDeMaterias listado = new ListadoDeMaterias(stage, estado);
            for(DatosMateria datos: listado.obtenerDatos()) {
                System.out.println("Materia: " + datos.obtenerMateria().obtenerNombre() + " fue seleccionada? " + datos.getCheckBox().isSelected());
                if(!datos.getCheckBox().isSelected()) {
                    //autoCorrelativa(datos,datos.getChoiceBox(), listado.obtenerDatos());
                    materiasNoCursadas.add(datos.obtenerMateria());
                }
            }
            return materiasNoCursadas;
        }

        private void autoCorrelativa(DatosMateria datos,ChoiceBox<String> eleccionCorrelativas, List<DatosMateria> datosMaterias) { //las agrega pero es local, no se ve el cambio en la general
            if(eleccionCorrelativas.getValue().equals(NINGUNA)) {
                return;
            }
            for(DatosMateria d: datosMaterias) {
                if(d.obtenerMateria().obtenerNombre().equals(eleccionCorrelativas.getValue())) {
                    datos.setearAutoCorrelativa(d.obtenerMateria());
                    return;
                }
            }
        }
    }
}