import BackEnd.Usuario;

public class EstadoDeAplicacion {

    private Usuario usuario;


    public EstadoDeAplicacion(Usuario usuario)
    {
        this.usuario=usuario;
    }

    public Usuario obtenerUsuario()
    {
        return this.usuario;
    }

    public void setearUsuario(Usuario usuario)
    {
        this.usuario=usuario;
    }


}
