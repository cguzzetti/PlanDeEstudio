package FrontEnd;

import java.util.HashSet;
import java.util.Set;

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

import BackEnd.EstadoDeAplicacion;

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
                                PlanAcademico planAcademico = new PlanAcademico(Integer.parseInt(creditos.getText()),estado.obtenerCarrera(), materiasNoCursadas());
                                planAcademico.construirPlan();
                                ImprimePlan imprime = new ImprimePlan(stage,planAcademico);
                                imprime.setStage();
                            }
                        } catch(NumberFormatException ex) {
                            new Alert(Alert.AlertType.WARNING, "La cantidad maxima de creditos\ntiene que ser un numero.").show();
                        } catch (NoTimeException ex) {}
                    }
                }
            });

            planCorrelativo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if(!isEmpty()) {
                        try {
                            if(!fueraDeRango()) {
                                PlanCorrelativo planCorrelativo = new PlanCorrelativo(Integer.parseInt(creditos.getText()),estado.obtenerCarrera(), materiasNoCursadas());
                                planCorrelativo.construirPlan();
                                ImprimePlan imprime = new ImprimePlan(stage,planCorrelativo);
                                imprime.setStage();
                            }
                        } catch(NumberFormatException ex) {
                            new Alert(Alert.AlertType.WARNING, "La cantidad maxima de creditos\ntiene que ser un numero.").show();
                        } catch (NoTimeException ex) {}
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
            Set<Materia> mnc = new HashSet<Materia>();
            for(Materia m: estado.obtenerMaterias()) {
                if(!estado.obtenerDatosMateria(m).getCheckBox().isSelected()) {
                    autoCorrelativa(m,estado.obtenerDatosMateria(m).getChoiceBox());
                    mnc.add(m);
                }
            }
			/*for(Materia m: mnc) {
				for(Materia materia: m.obtenerAutoCorrelativas()) {
					System.out.println(materia.obtenerNombre());
				}
			}*/
            return mnc;
        }

        private void autoCorrelativa(Materia materia,ChoiceBox<String> choiceCorrelativas) { //las agrega pero es local, no se ve el cambio en la general
            if(choiceCorrelativas.getValue().equals(NINGUNA)) {
                return;
            }
            for(Materia m: estado.obtenerMaterias()) {
                if(m.obtenerNombre().equals(choiceCorrelativas.getValue())) {
                    estado.obtenerDatosMateria(materia).addAutoCorrelativa(m);
                    estado.obtenerDatosMateria(m).addAutoCorrelativa(materia);
                    return;
                }
            }
        }
    }
}