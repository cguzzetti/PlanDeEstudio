package FrontEnd;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

import BackEnd.*;

public class ImprimePlan {

    private Stage stage;
    private Plan plan;
    private EstadoDeAplicacion estado;

    public ImprimePlan(Stage stage, Plan plan, EstadoDeAplicacion estado) {
        this.stage = stage;
        this.plan = plan;
        this.estado=estado;
    }

    public Scene scene() {
        GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        int numeroCuatri = 0;
        int gridfila = 0;
        for(Cuatrimestre cuatrimestre: plan.obtenerCuatrimestres()) {
            grid.add(new Label("Cuatrimestre " + (++numeroCuatri)),0,gridfila);
            for(Materia materia: cuatrimestre.obtenerMaterias()) {
                grid.add(new Label(materia.obtenerNombre()),1,(gridfila++));
            }
            gridfila++;
        }

        ScrollPane scroll = new ScrollPane();
        scroll.setContent(grid);

        return new Scene(scroll,300,500);
    }

    public void setStage() {
        stage.setScene(scene());
        //stage.setTitle(plan());
        stage.show();
    }

    /*private String plan() {
        estado.obtenerNombre(plan);
    }*/
}