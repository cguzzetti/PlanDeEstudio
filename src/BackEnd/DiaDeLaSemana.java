package BackEnd;

public enum DiaDeLaSemana {

    LUNES("Lunes"), MARTES("Martes"), MIERCOLES("Miércoles"), JUEVES("Jueves"), VIERNES("Viernes");

    private final String dia;

    DiaDeLaSemana(String dia){
        this.dia=dia;
    }

    @Override
    public String toString(){
        return dia;
    }

}
