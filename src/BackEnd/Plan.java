import java.util.*;

import java.util.Map.Entry;

public class Plan {
	
	private int creditos;
	private ArrayList<Cuatrimestre> cuatrimestres;
	private ArrayList<Cuatrimestre> carrera;
	private Map<Materia, Boolean> materias = new HashMap<>();
	
	public Plan (int creditos, ArrayList<Cuatrimestre> carrera, Set<Materia> materiasAprobadas) {
		this.materias = new HashMap<>();
		this.cuatrimestres = new ArrayList<>();
		this.creditos = creditos;
		this.carrera=carrera;
		
		Set<Materia> set = new HashSet<Materia>();
		for (Iterator<Cuatrimestre> i = carrera.iterator(); i.hasNext(); ) {
			Cuatrimestre aux = i.next();
			set.addAll(aux.obtenerMaterias());
		}
		
		for (Iterator<Materia> i = set.iterator(); i.hasNext(); ) {
			Materia aux = i.next();
			materias.put(aux, set.contains(aux));
		}
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
	
	public void construirPlan(TreeSet<Materia> set) {
		
		for (Iterator<Entry<Materia, Boolean>> i = materias.entrySet().iterator(); i.hasNext(); ) {
			Entry<Materia, Boolean> aux = i.next();
			if (! aux.getValue()) {		// si no esta aprobada la materia
				set.add(aux.getKey());
			}
		}
			
		for (Iterator<Materia> i = set.iterator(); i.hasNext(); ) {
			Materia m = i.next();
			ArrayList<Materia> materiasPorCursar = new ArrayList<>();
			if (cuatrimestres.size() == 0) {
				Cuatrimestre nuevoCuatri = new Cuatrimestre("Cuatrimestre 1");
				nuevoCuatri.agregarMateria(m);
				cuatrimestres.add(nuevoCuatri);
			}
			else {
				int cantidadDeCuatrimestres = cuatrimestres.size();
				Cuatrimestre ultimoCuatrimestre = cuatrimestres.get(cantidadDeCuatrimestres-1);
				if (!agregarMateria(m, ultimoCuatrimestre, cantidadDeCuatrimestres)){
					materiasPorCursar.add(m);
				}
				for (int j=0; j<materiasPorCursar.size(); j++) {		// me fijo en las materias que me tuve que saltear porque no estaban sus correlativas o se pisaban los horarios
					if (agregarMateria(materiasPorCursar.get(j), ultimoCuatrimestre, cuatrimestres.size())) {
						materiasPorCursar.remove(j);
					}
				}
			}
		}
	}
	
	private boolean agregarMateria(Materia m, Cuatrimestre c, int dim) {
		
		if (hayCorrelativas(m) && c.validaHorarios(m)) {
			if (c.hayCreditos(m, creditos)) {
				c.agregarMateria(m);
				return true;
			}
			else {
				StringBuilder formato = new StringBuilder();
				formato.append("Cuatrimestre ").append(dim + 1);
				Cuatrimestre nuevoCuatri = new Cuatrimestre(formato.toString());
				nuevoCuatri.agregarMateria(m);
				cuatrimestres.add(nuevoCuatri);
				return true;
			}
		}
		
		return false;
	}
	
	private boolean hayCorrelativas(Materia m) {		// metodo que verifica que las materias correlativas ya esten en el plan para ser cursadas
		
		Set<Materia> materiasDelPlan = new HashSet<>();
		Set<Materia> materiasCorrelativas = m.obtenerCorrelativas();
		
		int size;
		
		if (cuatrimestres.get(cuatrimestres.size()-1).hayCreditos(m, creditos)) {	// si hay lugar en el ultimo cuatrimestre para la materia
			size = cuatrimestres.size()-1;
		}
		else {
			size = cuatrimestres.size();
		}
		
		for (int i=0; i<size; i++) { 
			materiasDelPlan.addAll(cuatrimestres.get(i).obtenerMaterias());
		}
		
		for (Iterator<Materia> i = materiasCorrelativas.iterator(); i.hasNext(); ) {
			Materia aux = i.next();
			if (!materiasDelPlan.contains(aux) && !materias.get(aux)) // si la materia no esta en el plan ni esta aprobada
				return false;
		}
		
		return true;
		
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
