package BackEnd;

import java.util.*;

public class Materia {
    private String nombre;
    private Cuatrimestre cuatrimestre;
    private int creditos;
    private Set<Clase> clases;
    private Set<Materia> correlativas;
    private int prioridadCorrelativas;
    private Materia materiaAutoCorrelativa;
    private Periodo periodo;
    private int creditosRequeridos;
    private Set<Reseña> reseñas = new HashSet<>();


    public Materia(String nombre, int creditos, Cuatrimestre cuatrimestre, Periodo periodo, int creditosRequeridos){
        this.nombre=nombre;
        this.creditos=creditos;
        this.cuatrimestre=cuatrimestre;
        this.prioridadCorrelativas=0;
        this.correlativas = new HashSet<>();
        this.clases = new HashSet<>();
        this.periodo = periodo;
        this.creditosRequeridos=creditosRequeridos;

        try {
            cuatrimestre.agregarMateria(this);
        } catch (NoTimeException e) {
            e.printStackTrace();
        }
    }

    public Materia(String nombre, int creditos, Cuatrimestre cuatrimestre, int creditosRequeridos){
        this.nombre=nombre;
        this.creditos=creditos;
        this.cuatrimestre=cuatrimestre;
        this.prioridadCorrelativas=0;
        this.correlativas = new HashSet<>();
        this.clases = new HashSet<>();
        this.periodo = null;
        this.creditosRequeridos=creditosRequeridos;


        try {
            cuatrimestre.agregarMateria(this);
        } catch (NoTimeException e) {
            e.printStackTrace();
        }
    }

    public Materia(String nombre, int creditos, Cuatrimestre cuatrimestre){
        this.nombre=nombre;
        this.creditos=creditos;
        this.cuatrimestre=cuatrimestre;
        this.prioridadCorrelativas=0;
        this.correlativas = new HashSet<>();
        this.clases = new HashSet<>();
        this.periodo = null;
        this.creditosRequeridos=0;


        try {
            cuatrimestre.agregarMateria(this);
        } catch (NoTimeException e) {
            e.printStackTrace();
        }
    }

    public void agregarClase(Clase clase) throws NoTimeException {
        for (Clase thisClase: clases){
            if (! thisClase.validaHorario(clase))
                throw new NoTimeException();
        }
        clases.add(clase);
    }
    


    public void setearAutoCorrelativa(Materia m){
        materiaAutoCorrelativa=m;
    }
    
    public Materia obtenerAutoCorrelativa (){
    		return materiaAutoCorrelativa;
    }

    public Cuatrimestre obtenerCuatrimestre(){
        return cuatrimestre;
    }

    public String obtenerNombre(){
        return nombre;
    }

    public int obtenerCreditosRequeridos(){
        return creditosRequeridos;
    }

    public int obtenerCreditos(){
        return creditos;
    }

    public Periodo obtenerPeriodo(){
        return periodo;
    }

    public Set<Clase> obtenerClases(){      //agregar este metodo a la planilla de drive
        return clases;
    }

    public int obtenerPrioridad(){
        return prioridadCorrelativas;
    }

    public Set<Materia> obtenerCorrelativas(){
        return correlativas;
    }

    public boolean validaHorarios(Materia materia){
        //supongo que la validacion de si la materia que se pasa o no es externa. Sino la puedo poner aca
        for(Clase thisClase : clases){
            for(Clase thatClase : materia.obtenerClases()){
                if(!(thisClase.validaHorario(thatClase)))
                    return false;
            }
        }
        return true;
    }

    public void agregarCorrelativa (Materia materia){
        correlativas.add(materia);
        materia.incrementarPrioridad(prioridadCorrelativas);
    }

    public void incrementarPrioridad(int prioridad){       //aunque la materia no tenga correlativas hay que llamar a este medtodo para que la prioridad se setee en 1
        prioridadCorrelativas += (prioridad + 1);
        for (Materia thisMateria: correlativas) {
            thisMateria.incrementarPrioridad(prioridad);
        }
    }

    public boolean sonCorrelativas (Materia m){
        return correlativas.contains(m);
    }


    public boolean hayReseñas()
    {
        return !reseñas.isEmpty();
    }

    public Set<Reseña> obtenerReseñas()
    {
        return reseñas;
    }

    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(!(o instanceof Materia))
            return false;
        Materia aux= (Materia) o;
        return nombre.equals(aux.obtenerNombre()) && creditos == aux.obtenerCreditos() && clases == aux.obtenerClases() && correlativas == aux.obtenerCorrelativas() && prioridadCorrelativas == aux.obtenerPrioridad();
    }

    @Override
    public int hashCode(){
        int resultado=17;
        resultado= 31*resultado+creditos;
        resultado=31*resultado+clases.size();
        resultado=31*resultado+correlativas.size();
        resultado=31*resultado+prioridadCorrelativas;
        return resultado;
    }

    @Override
    public String toString(){
        String mensaje="Materia: " +nombre+ "\n Creditos: " +creditos;
        for(Clase clase:clases){
            mensaje= mensaje +"\n\t" +clase.toString();
        }
        return mensaje;
    }
}

