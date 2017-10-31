import java.util.*;

public class Cuatrimestre {

	private String nombre;
	private int creditos;
	private Set<Materia> materias;

	public Cuatrimestre(String nombre){
		this.creditos=0;
		this.materias= new HashSet<>();
		this.nombre=nombre;
	}

	public void agregarMateria(Materia m) throws NoTimeException {
		for (Materia thisMateria : materias){
			if (!thisMateria.validaHorarios(m))
				throw new NoTimeException();
		}
		materias.add(m);
		creditos += m.obtenerCreditos();
	}

	public boolean validaHorarios (Materia m) {

		for (Iterator<Materia> i = materias.iterator(); i.hasNext(); ) {
			if (!i.next().validaHorarios(m)) {
				return false;
			}
		}
		return true;
	}

	public String obtenerNombre(){
		return nombre;
	}

	public Set<Materia> obtenerMaterias(){
		return materias;
	}

	/*public boolean hayCorrelativa(Materia m){
		Iterator<Materia> i = materias.iterator();
		while(i.hasNext()){
			Materia aux = i.next();
			if(m.sonCorrelativas(aux)){
				return true;
			}
		}
		return false;
	}*/

	public boolean hayCreditos(Materia m, int creditosPorCuatrimestre) {
		return (m.obtenerCreditos() + creditos) <= creditosPorCuatrimestre;
	}

	@Override
	public boolean equals (Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Cuatrimestre))
			return false;

		Cuatrimestre aux = (Cuatrimestre) o;

		if (aux.obtenerMaterias().size() != materias.size())
			return false;

		return aux.obtenerMaterias().containsAll(materias);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		for ( Materia m : materias) {
			sb.append(m);
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		for (Iterator<Materia> i= materias.iterator(); i.hasNext(); ) {
			result = prime * result + i.next().hashCode();
		}
		return result;
	}
}
