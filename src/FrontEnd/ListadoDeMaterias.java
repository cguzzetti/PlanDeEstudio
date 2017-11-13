package FrontEnd;

import java.util.*;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import BackEnd.*;

public class ListadoDeMaterias {

    private List<DatosMateria> datosMaterias;
    private Stage stage;
    private EstadoDeAplicacion estado;

    public ListadoDeMaterias(Stage stage,EstadoDeAplicacion estado) {
        this.stage = stage;
        this.estado = estado;
        if(estado.obtenerDatosMaterias() == null) {
            this.datosMaterias = new ArrayList<DatosMateria>();
            crearDatos(datosMaterias);
        } else {
            this.datosMaterias = estado.obtenerDatosMaterias();
        }
    }

    public void setStage() {
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(new InputPane());
        stage.setScene(new Scene(scroll,600,500));
        stage.setTitle("Plan Academico");
        stage.show();
    }



    private class InputPane extends GridPane {

        private static final String NINGUNA = "Ninguna";

        private Label information = new Label("Seleccione las materias ya aprobadas");

        InputPane() {
            setHgap(50);
            setVgap(10);
            setPadding(new Insets(5, 5, 5, 5));
            int gridfila = 0;

            add(information, 0, 0);

            for(DatosMateria datos: datosMaterias) {

                datos.obtenerPuntaje().setValue(3);
                datos.obtenerPuntaje().setTooltip(new Tooltip("Dificultad de la materia"));

                datos.getTextField().setPromptText("Comentario");

                ArrayList<String> nombreMaterias = new ArrayList<String>();
                nombreMaterias.add(NINGUNA);
                for(Materia materia: estado.obtenerMaterias()) {
                    if(!datos.obtenerMateria().equals(materia) && !datos.obtenerMateria().sonCorrelativas(materia)) {
                        nombreMaterias.add(materia.obtenerNombre());
                    }
                }
                datos.setChoiceBox(new ChoiceBox<String>(FXCollections.observableArrayList(nombreMaterias)));
                datos.getChoiceBox().setTooltip(new Tooltip("Eliga la materia que no\nquiera cursar al mismo\ntiempo que la seleccionada."));
                datos.getChoiceBox().setValue(NINGUNA);

                BooleanBinding bind = new BooleanBinding() {
                    {
                        super.bind(datos.getCheckBox().selectedProperty());
                    }
                    @Override
                    protected boolean computeValue() {
                        return (!datos.getCheckBox().isSelected());
                    }
                };
                datos.obtenerPuntaje().disableProperty().bind(bind);
                datos.getTextField().disableProperty().bind(bind);

                BooleanBinding bb = new BooleanBinding() {
                    {
                        super.bind(datos.getCheckBox().selectedProperty());
                    }
                    @Override
                    protected boolean computeValue() {
                        return (datos.getCheckBox().isSelected());
                    }
                };
                datos.getChoiceBox().disableProperty().bind(bb);

                datos.getCheckBox().setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        datos.obtenerPuntaje().setValue(3);
                        datos.getTextField().clear();
                        datos.getChoiceBox().setValue(NINGUNA);
                    }
                });

                add(datos.getCheckBox(),0,++gridfila);
                add(datos.obtenerPuntaje(),1,gridfila);
                add(datos.getTextField(),2,gridfila);
                add(datos.getChoiceBox(), 1, ++gridfila);

                Button botonReseñas = new Button("Reseñas");
                botonReseñas.setTooltip(new Tooltip("Reseñas\nde otros usuarios."));
                botonReseñas.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(datos.obtenerMateria().hayReseñas()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Comentarios");
                            alert.setHeaderText("");
                            alert.setContentText(imprimeComentarios(datos.obtenerMateria().obtenerReseñas()));
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Reseñas");
                            alert.setHeaderText("");
                            alert.setContentText("No hay reseñas para esta materia");
                            alert.showAndWait();
                        }
                    }
                });

                add(botonReseñas, 2,gridfila);
                setAlignment(Pos.CENTER);
            }

            Button next = new Button("Obtener plan");
            add(next,2,(++gridfila + 1));

            next.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Plan Academico");
                    alert.setHeaderText("");
                    alert.setContentText("Una vez que aprete aceptar, no va a poder hacer cambios.\nEsta seguro que quiere seguir?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.isPresent()) {
                        if(result.get() == ButtonType.OK) {
                            estado.setearDatosMaterias(datosMaterias);
                            EleccionDelPlan plan = new EleccionDelPlan(stage,estado);
                            plan.setStage();
                        }
                    }
                }
            });
        }

        private String imprimeComentarios(Set<Reseña> reseñas) {
            StringBuilder s = new StringBuilder();
            for(Reseña reseña: reseñas) {
                s.append(reseña);
            }
            return s.toString();
        }
    }

    public List<DatosMateria> obtenerDatos(){
        return datosMaterias;
    }

    private void crearDatos(List<DatosMateria> datosMaterias) {
        for(Materia materia: estado.obtenerMaterias()) {
            datosMaterias.add(new DatosMateria(materia, estado));
        }
    }
}
