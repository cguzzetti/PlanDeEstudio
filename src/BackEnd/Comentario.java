package BackEnd;

import java.util.*;

public class Comentario {

    private Usuario autor;
    private String comentario;
    private int puntaje;

    public Comentario (Usuario u, String c, int p){
        autor=u;
        comentario=c;
        puntaje=p;
    }

    public int obtenerPuntaje(){
        return puntaje;
    }

    public String obtenerComentario(){
        return comentario;
    }

    public Usuario obtenerUsuario(){
        return autor;
    }

    @Override
    public String toString(){

        return "Usuario: " + autor.toString() + "\n\tComentario: " + comentario + "\n\t\tPuntaje: " + puntaje;
    }

    @Override
    public int hashCode(){
        int prime = 17;
        int result=1;
        result= result*prime + comentario.hashCode();
        result= result*prime + autor.hashCode();
        result= result*prime + puntaje;
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Comentario))
            return false;

        Comentario aux = (Comentario)o;
        return aux.autor.equals(autor) && aux.puntaje==puntaje && aux.comentario.equals(comentario);
    }

}
