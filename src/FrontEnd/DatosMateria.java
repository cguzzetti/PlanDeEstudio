package FrontEnd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import BackEnd.EstadoDeAplicacion;
import BackEnd.Materia;

public class DatosMateria {
    private Materia materia;
    private CheckBox checkbox;
    private ChoiceBox<Integer> puntaje;
    private TextField comentario;
    private ChoiceBox<String> choicebox;
    private Materia autoCorrelativa;
    private EstadoDeAplicacion estado;

    public DatosMateria (Materia materia, EstadoDeAplicacion estado) {
        this.materia = materia;
        checkbox = new CheckBox(estado.obtenerNombre(Materia));
        puntaje = new ChoiceBox<Integer>(FXCollections.observableArrayList(1,2,3,4,5));
        comentario = new TextField();
        autoCorrelativa = null;
        this.estado=estado;
    }

    public CheckBox getCheckBox() {
        return checkbox;
    }

    public ChoiceBox<Integer> obtenerPuntaje() {
        return puntaje;
    }

    public TextField getTextField() {
        return comentario;
    }

    public ChoiceBox<String> getChoiceBox() {
        return choicebox;
    }

    public Materia obtenerAutoCorrelativa() {
        return autoCorrelativa;
    }

    public void setChoiceBox(ChoiceBox<String> choicebox) {
        this.choicebox = choicebox;
    }

    public void setearAutoCorrelativa(Materia materia) {
         estado.setearAutoCorrelativa(this.materia, materia);
    }

    public void show() {
        System.out.println("\t" + estado.obtenerNombre(autoCorrelativa));
    }

    public void showDatos() {
        System.out.println(checkbox.isSelected() + "\n" + puntaje.getValue());
    }

    public Materia obtenerMateria(){
        return materia;
    }

}
