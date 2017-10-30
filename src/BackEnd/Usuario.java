package BackEnd;

public class Usuario {

    private String nombreItba;
    private Map<String,List<Cuatrimestre>> carrera;

    public Usuario(String nombreItba,Map<String,List<Cuatrimestre>> carrera)
    {
        this.nombreItba=nombreItba;
        this.carrera=carrera;
    }

    public void setearCarrera(Map<String,List<Cuatrimestre>> carrera) {
        this.carrera = carrera;
    }

    public Map<String,List<Cuatrimestre>> obtenerCarrera() {
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
        if(this.nombreItba.compareTo(aux.getNombreItba())!=0)
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
