package BackEnd;

public enum Sede {

    MADERO("Madero"), SDT("Distrito Tecnológico");

    private final String sede;

    Sede(String sede)
    {
        this.sede=sede;
    }

    @Override
    public String toString()
    {
        return sede;
    }
}
