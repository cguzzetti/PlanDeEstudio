package BackEnd;

import java.util.*;
//import java.util.Map.Entry;

public class PlanAcademico extends Plan {
	
	public PlanAcademico (int creditos, Set<Materia> materiasTotales, Set<Materia> materiasAprobadas) {
		super(creditos, materiasTotales, materiasAprobadas);
	}
	
	public void agregarMaterias() {
		
		TreeSet<Materia> set = new TreeSet<Materia>( new Comparator<Materia>() {
			@Override
			public int compare (Materia m1, Materia m2) {
				return m1.obtenerCuatrimestre().obtenerNombre().compareTo(m2.obtenerCuatrimestre().obtenerNombre());
			}
		});
		
		super.agregarMaterias(set);
	}
}
