package BackEnd;

public class Clase {
    private DiaDeLaSemana dia;
    private Sede sede;
    private int horaInicio;
    private int horaFin;


    public DiaDeLaSemana obtenerDia(){
        return dia;
    }

    public Sede obtenerSede(){
        return sede;
    }

    public int obtenerHoraInicio(){
        return horaInicio;
    }

    public int obtenerHoraFin(){
        return horaFin;
    }

    public Clase(DiaDeLaSemana dia, Sede sede, int horaInicio, int horaFin){
        this.dia=dia;
        this.sede=sede;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }

    public boolean validaHorario(Clase clase){


        if(!dia.equals(clase.obtenerDia()))
            return true;
        else if (sede.equals(clase.obtenerSede()))
        {
            return horaInicio>=clase.obtenerHoraFin() || horaFin<=clase.obtenerHoraInicio();
        }

        return horaInicio>clase.obtenerHoraFin() || horaFin<clase.obtenerHoraInicio();

    }



    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(!(o instanceof Clase))
            return false;
        Clase aux = (Clase)o;
        if (dia.equals(aux.obtenerDia()) && sede.equals(aux.obtenerSede()) && horaInicio==(aux.obtenerHoraInicio()) && horaFin==(aux.obtenerHoraFin()))
            return false;
        return false;
    }

    @Override
    public int hashCode(){
        int resultado=17;
        resultado= 31*resultado+horaInicio;
        resultado=31*resultado+horaFin;
        return resultado;
    }

    @Override
    public String toString(){
        return  dia+ " de " +horaInicio+ " a " +horaFin+ " hs. en la sede " +sede;

    }
}
