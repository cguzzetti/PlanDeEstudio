package BackEnd;

public enum Periodo {

    PRIMERO(1),SEGUNDO(2);

    private final int numero;

    Periodo(int numero)
    {
        this.numero=numero;
    }

    public int obtenerNumero()
    {
        return numero;
    }

    @Override
    public String toString()
    {
        return ""+numero;
    }
}
