package BackEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EstadoDeAplicacion {

    private List<Cuatrimestre> cuatrimestresInformatica;
    private static final int CREDITOS_TOTALES_INFORMATICA=243;
    private Usuario usuario;

    public EstadoDeAplicacion()
    {
        try{
            this.cuatrimestresInformatica=new ArrayList<>(DatosInformatica.inicializarData());
        }catch(NoTimeException e){
            e.printStackTrace();
        }
    }


    public String obtenerNombre(Materia materia)
    {
        return materia.obtenerNombre();
    }

    public List<Materia> obtenerMaterias() {
        List<Materia> materias = new ArrayList<Materia>();
        for(Cuatrimestre cuatrimestre: cuatrimestresInformatica) {
            materias.addAll(cuatrimestre.obtenerMaterias());
        }
        return materias;
    }


    public void crearUsuario(String nombre)
    {
        this.usuario=new Usuario(nombre);
    }


    public Usuario obtenerUsuario() {
        return usuario;
    }


    public PlanAcademico crearPlanAcademico(int creditosMaximos, Set<Materia> materiasPorAprobar)
    {
        int creditosPorAprobar=0;

        for(Materia m:materiasPorAprobar)
        {
            creditosPorAprobar+=m.obtenerCreditos();
        }

        PlanAcademico planAcademico = new PlanAcademico(27, cuatrimestresInformatica, materiasPorAprobar, CREDITOS_TOTALES_INFORMATICA-creditosPorAprobar);
        try{
            planAcademico.construirPlan();
        }catch(NoTimeException e)
        {
            e.printStackTrace();
        }


        return planAcademico;

    }


    public PlanCorrelativo crearPlanCorrelativo(int creditosMaximos, Set<Materia> materiasPorAprobar)
    {

        int creditosPorAprobar=0;

        for(Materia m:materiasPorAprobar)
        {
            creditosPorAprobar+=m.obtenerCreditos();
        }

        PlanCorrelativo planCorrelativo = new PlanCorrelativo(27, cuatrimestresInformatica, materiasPorAprobar, CREDITOS_TOTALES_INFORMATICA-creditosPorAprobar);
        try{
            planCorrelativo.construirPlan();
        }catch(NoTimeException e)
        {
            e.printStackTrace();
        }


        return planCorrelativo;

    }


    public void setearAutoCorrelativa(Materia materia1,Materia materia2)
    {
        materia1.setearAutoCorrelativa(materia2);
        materia2.setearAutoCorrelativa(materia1);
    }

    public List<Cuatrimestre> obtenerCarrera() {
        return cuatrimestresInformatica;
    }

}
