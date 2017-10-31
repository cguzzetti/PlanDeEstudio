package BackEnd;

import java.util.*;

public class PlanAcademico extends Plan {

	public PlanAcademico (int creditos, List<Cuatrimestre> carrera, Set<Materia> materiasAprobadas) {
		super(creditos, carrera, materiasAprobadas);
	}

	public void construirPlan () throws NoTimeException{

		TreeSet<Materia> set = new TreeSet<Materia>( new Comparator<Materia>() {
			@Override
			public int compare (Materia m1, Materia m2) {

				int prioridad = m1.obtenerCuatrimestre().obtenerNombre().compareTo(m2.obtenerCuatrimestre().obtenerNombre());

				if (prioridad == 0)
					return m1.obtenerPrioridad()- m2.obtenerPrioridad();

				return prioridad;
			}
		});

		super.construirPlan(set);
	}
}