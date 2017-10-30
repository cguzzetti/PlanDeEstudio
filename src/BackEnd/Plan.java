

import java.util.*;
import java.util.Map.Entry;

public class Plan {
	
	private int creditos;
	//private String tipoDePlan;		HAY QUE HACER HIJOS DE PLAN O LOS TOMAMOS COMO VARIABLES?
	//private final String planAcademico="academico";
	//private final String planCorrelativo="correlativo";
	private ArrayList<Cuatrimestre> cuatrimestres;
	private Map<Materia, Boolean> materias = new HashMap<>();
	
	public Plan (int creditos, Set<Materia> materiasTotales, Set<Materia> materiasAprobadas) {
		this.materias = new HashMap<>();
		this.cuatrimestres = new ArrayList<>();
		this.creditos = creditos;
		
		for (Iterator<Materia> i = materiasTotales.iterator(); i.hasNext(); ) {
			Materia aux = i.next();
			materias.put(aux, materiasAprobadas.contains(aux));
		}
	}
	
	public Plan (ArrayList<Cuatrimestre> listaDeCuatrimestres) {
		this.cuatrimestres = listaDeCuatrimestres;
	}
	
	public int obtenerCreditos () {
		return creditos;
	}
	
	public ArrayList<Cuatrimestre> obtenerCuatrimestres(){
		return cuatrimestres;
	}
	
	public Map<Materia, Boolean> obtenerMaterias () {
		return materias;
	}
	
	public boolean hayCorrelativa (Materia m) {
		
		for (int i=0; i<cuatrimestres.size(); i++) {
			if ( cuatrimestres.get(i).hayCorrelativa(m) )
				return true;
		}
		return false;
	}
	
	public void agregarMaterias(TreeSet<Materia> set) {
		
		for (Iterator<Entry<Materia, Boolean>> i = materias.entrySet().iterator(); i.hasNext(); ) {
			Entry<Materia, Boolean> aux = i.next();
			if (! aux.getValue()) {		// si no esta aprobada la materia
				set.add(aux.getKey());
			}
		}
			
		for (Iterator<Materia> i = set.iterator(); i.hasNext(); ) {
			Materia m = i.next();
			if (cuatrimestres.size() == 0) {
				Cuatrimestre nuevoCuatri = new Cuatrimestre();
				nuevoCuatri.agregarMateria(m);
				cuatrimestres.add(nuevoCuatri);
			}
			else {
				if (!hayCorrelativa(m)) {
					Cuatrimestre aux = cuatrimestres.get(cuatrimestres.size()-1);
					if ((aux.obtenerCreditos() + m.obtenerCreditos()) < creditos) {
						aux.agregarMateria(m);
					}
					else {
						Cuatrimestre nuevoCuatri = new Cuatrimestre();
						nuevoCuatri.agregarMateria(m);
						cuatrimestres.add(nuevoCuatri);
					}
				}
				else {
					Cuatrimestre nuevoCuatri = new Cuatrimestre();
					nuevoCuatri.agregarMateria(m);
					cuatrimestres.add(nuevoCuatri);
				}
			}
				
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (int i=0; i<cuatrimestres.size(); i++) {
			result = prime * result + cuatrimestres.get(i).hashCode();
		}
		return result;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Plan: ").append("\n-----------------------------------------------------------------------");
		for (int i=0; i<cuatrimestres.size(); i++) {
			sb.append(cuatrimestres.get(i).toString());
			sb.append("\n-----------------------------------------------------------------------");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals (Object o) {
		if ( this == o)
			return true;
		if (!(o instanceof Plan))
			return false;
		
		Plan aux = (Plan) o;
		if (cuatrimestres.size() != aux.cuatrimestres.size())
			return false;
		for (int i=0; i<cuatrimestres.size(); i++) {
			if (! cuatrimestres.get(i).equals(aux.cuatrimestres.get(i)))
				return false;
		}
		return true;
	}
}
