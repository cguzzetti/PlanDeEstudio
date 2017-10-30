import BackEnd.Usuario;

public class EstadoDeAplicacion {

    private Usuario usuario;


    public EstadoDeAplicacion(Usuario usuario)
    {
        this.usuario=usuario;
    }

    public Usuario getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario=usuario;
    }


}
