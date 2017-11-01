import java.util.*;

import java.util.Map.Entry;

public class Plan {

	private int creditos;
	private List<Cuatrimestre> cuatrimestres;
	private List<Cuatrimestre> carrera;
	private Map<Materia, Boolean> materias;

	public Plan (int creditos, List<Cuatrimestre> carrera, Set<Materia> materiasAprobadas) {		//VER FUNCION DE MATERIASAPROBADAS
		this.materias = new HashMap<>();
		this.cuatrimestres = new ArrayList<>();
		this.creditos = creditos;
		this.carrera=new ArrayList<>(carrera);

		Set<Materia> set = new HashSet<Materia>();
		for (Iterator<Cuatrimestre> i = carrera.iterator(); i.hasNext(); ) {
			Cuatrimestre aux = i.next();
			set.addAll(aux.obtenerMaterias());
		}
		
		for (Materia aux : set ) {
			materias.put(aux, materiasAprobadas.contains(aux));
		}
		
		//EL CONSTRUCTOR ANDA
	}

	public int obtenerCreditos () {
		return creditos;
	}

	public List<Cuatrimestre> obtenerCuatrimestres(){
		return cuatrimestres;
	}

	public Map<Materia, Boolean> obtenerMaterias () {
		return materias;
	}

	public void construirPlan(TreeSet<Materia> set) throws NoTimeException {
		
		for (Materia materia : materias.keySet()) {
			if (! materias.get(materia)) {		// si no esta aprobada la materia
				set.add(materia);
			}
		}
		
		Set<Materia> materiasPorCursar = new HashSet<>();
		for (Materia  m : set) {
			System.out.println(m.obtenerNombre());
			if (cuatrimestres.size() == 0) {
				Cuatrimestre nuevoCuatri = new Cuatrimestre("Cuatrimestre 1");
				nuevoCuatri.agregarMateria(m);
				cuatrimestres.add(nuevoCuatri);
            }
			else {
				int cantidadDeCuatrimestres = cuatrimestres.size();
				if (! agregarMateria(m, cuatrimestres.get(cantidadDeCuatrimestres-1), cantidadDeCuatrimestres)){
					System.out.println(materiasPorCursar.add(m));
				}
				System.out.println(materiasPorCursar.size());
				cantidadDeCuatrimestres = cuatrimestres.size();
				Set<Materia> materiasARemover = new HashSet<>();
				for (Materia materia : materiasPorCursar) {		// me fijo en las materias que me tuve que saltear porque no estaban sus correlativas o se pisaban los horarios
					if (agregarMateria(materia, cuatrimestres.get(cantidadDeCuatrimestres-1), cuatrimestres.size())) {
						materiasARemover.add(materia);
					}
				}
				materiasPorCursar.removeAll(materiasARemover);
			}
		}
	}

	private boolean agregarMateria(Materia m, Cuatrimestre c, int dim) throws NoTimeException{
		
		if (hayCorrelativas(m)) {
			if (c.hayCreditos(m, creditos) && c.validaHorarios(m)) {
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
		sb.append("\n-----------------------------------------------------------------------\n");
		//System.out.println(cuatrimestres.size());
		for (int i=0; i<cuatrimestres.size(); i++) {
			sb.append(cuatrimestres.get(i).toString());
			sb.append("\n-----------------------------------------------------------------------\n");
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