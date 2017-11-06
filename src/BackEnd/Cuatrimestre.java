package BackEnd;

import java.util.*;

public class Cuatrimestre implements Comparable<Cuatrimestre>{

	private String nombre;
	private int creditos;
	private Set<Materia> materias;
	private Periodo periodo;

	public Cuatrimestre(String nombre, Periodo periodo){
		this.creditos=0;
		this.materias= new HashSet<>();
		this.nombre=nombre;
		this.periodo=periodo;
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

	public boolean hayCreditos(Materia m, int creditosPorCuatrimestre) {
		return (m.obtenerCreditos() + creditos) <= creditosPorCuatrimestre;
	}
	
	public boolean hayAutoCorrelativas (Materia materia) {
		Set<Materia> autocorrelativas = materia.obtenerAutoCorrelativas();
		for (Materia m : autocorrelativas ) {
			if(materias.contains(m))
				return true;
		}
		return false;
	}

	public Periodo obtenerPeriodo()
	{
		return periodo;
	}
	
	@Override
	public int compareTo(Cuatrimestre c) {
		return nombre.compareTo(c.obtenerNombre());
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
		sb.append(nombre).append("\n");
		for ( Materia m : materias) {
			sb.append(m).append("\n");
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
