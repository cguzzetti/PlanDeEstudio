import java.util.*;

public class PlanCorrelativo extends Plan {

	public PlanCorrelativo (int creditos, List<Cuatrimestre> carrera, Set<Materia> materiasAprobadas) {
		super(creditos, carrera, materiasAprobadas);
	}

	public void construirPlan() throws  NoTimeException{

		TreeSet<Materia> set = new TreeSet<>( new Comparator<Materia>() {
			@Override
			public int compare (Materia m1, Materia m2) {

				int prioridad = m2.obtenerPrioridad() - m1.obtenerPrioridad();
				if (prioridad == 0) {
					if (m1.sonCorrelativas(m2))
						return 1;	// quiero que m2 este antes que m1
					return -1; 	// quiero que m1 este antes que m2
				}
				return prioridad;
			}
		});

		super.construirPlan(set);

	}
}
