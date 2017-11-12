package BackEnd;

import java.util.*;

public class Usuario {

	private String nombreItba;

    public Usuario(String nombreItba)
    {
        this.nombreItba=nombreItba;
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
        return result;
    }

}
