package BackEnd;

import java.util.*;

public class Usuario {

	private String nombreItba;
    private List<Cuatrimestre> carrera;

    public Usuario(String nombreItba, List<Cuatrimestre> carrera)
    {
        this.nombreItba=nombreItba;
        this.carrera=carrera;
    }

    public void setearCarrera(List<Cuatrimestre> carrera) {
        this.carrera = carrera;
    }

    public List<Cuatrimestre> obtenerCarrera() {
        return carrera;
    }

    public String obtenerNombreItba() {
        return nombreItba;
    }

    public void setearNombreItba(String nombreItba)
    {
        this.nombreItba=nombreItba;
    }

    @Override
    public String toString()
    {
        return nombreItba;
    }


    @Override
    public boolean equals(Object o)
    {
        if(this==o)
            return true;
        if(!(o instanceof Usuario))
            return false;
        Usuario aux=(Usuario) o;
        if(this.nombreItba.compareTo(aux.obtenerNombreItba())!=0)
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombreItba == null) ? 0 : nombreItba.hashCode());
        result = prime * result + ((carrera == null) ? 0 : carrera.hashCode());
        return result;
    }

}
