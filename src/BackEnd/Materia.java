package BackEnd;

import java.util.Set;

public class Materia {
    private String nombre;
    private Cuatrimestre cuatrimestre;
    private int creditos;
    private Set<Clase> clases;
    private Set<Materia> correlativas;
    private int prioridadCorrelativas;

    public Materia(String nombre, int creditos, Cuatrimestre cuatrimestre){
        this.nombre=nombre;
        this.creditos=creditos;
        this.cuatrimestre=cuatrimestre;
    }

    public void agregarClase(Clase clase){
        clases.add(clase);
    }

    public Cuatrimestre obtenerCuatrimestre(){
        return cuatrimestre;
    }

    public String obtenerNombre(){
        return nombre;
    }

    public int obtenerCreditos(){
        return creditos;
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
                if(!(thisClase.equals(thatClase)))
                    return false;
            }
        }
        return true;
    }

    public void agregarCorrelativa (Materia materia){
    correlativas.add(materia);
    materia.incrementarPuntaje();
    }

    private void incrementarPuntaje(){       //aunque la materia no tenga correlativas hay que llamar a este medtodo para que la prioridad se setee en 1
        for(Materia materia:correlativas){
            materia.incrementarPuntaje();
        }
        prioridadCorrelativas++;
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

