import java.util.ArrayList;

public class Carrera {

    private String nombre;

    private BackEnd.PlanAcademico plan;

    public Carrera(String nombre, BackEnd.PlanAcademico plan)
    {
        this.nombre=nombre;
        this.plan=plan;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
}
