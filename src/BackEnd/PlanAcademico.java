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
				
				if (m1.equals(m2))
					return 0;

				int difCuatrimestres = m1.obtenerCuatrimestre().compareTo(m2.obtenerCuatrimestre());

				if (difCuatrimestres == 0) {
					int difPrioridad = m2.obtenerPrioridad() - m1.obtenerPrioridad();
					if ( difPrioridad == 0) {
						List<Materia> array = new ArrayList<>();
						array.add(m1);
						array.add(m2);
						Collections.shuffle(array);
						if (array.remove(0).equals(m1)) {
							return -1;
						}
						return 1;
					}
					return difPrioridad;
				}

				return difCuatrimestres;
			}
		});
		
		super.construirPlan(set);
	}
}