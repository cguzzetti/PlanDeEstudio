package BackEnd;

import java.util.Comparator;
//import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PlanCorrelativo extends Plan {
	
	public PlanCorrelativo (int creditos, Set<Materia> materiasTotales, Set<Materia> materiasAprobadas) {
		super(creditos, materiasTotales, materiasAprobadas);
	}

	public void agregarMaterias() {
		
		TreeSet<Materia> set = new TreeSet<Materia>( new Comparator<Materia>() {
			@Override
			public int compare (Materia m1, Materia m2) {
				return m1.obtenerPuntaje() - m2.obtenerPuntaje();
			}
		});
		
		super.agregarMaterias(set);
		
	}
}
