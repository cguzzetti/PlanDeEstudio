package BackEnd;

public class Clase {
    private String dia;
    private String sede;
    private int horaInicio;
    private int horaFin;


    public String obtenerDia(){
        return dia;
    }

    public String obtenerSede(){
        return sede;
    }

    public int obtenerHoraInicio(){
        return horaInicio;
    }

    public int obtenerHoraFin(){
        return horaFin;
    }

    public Clase(String dia, String sede, int horaInicio, int horaFin){
        this.dia=dia;
        this.sede=sede;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }

    public boolean validaHorario(Clase clase){

        if((!dia.equals(clase.obtenerDia()) || horaInicio>clase.obtenerHoraFin() || horaFin<clase.obtenerHoraInicio() || (horaInicio==clase.obtenerHoraFin() || horaFin==clase.obtenerHoraInicio())) && sede.equals(clase.obtenerSede()))
            return true; 
        return false;
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
