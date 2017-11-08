package BackEnd;

import java.util.*;

public class PlanCorrelativo extends Plan {

	public PlanCorrelativo (int creditosMax, List<Cuatrimestre> carrera, Set<Materia> materiasPorAprobar, int creditosAprobados) {
		super(creditosMax, carrera, materiasPorAprobar, creditosAprobados);
	}

	public void construirPlan() throws  NoTimeException{

		System.out.println("____________________PLAN CORRELATIVO___________________");


		TreeSet<Materia> set = new TreeSet<>( new Comparator<Materia>() {
			@Override
			public int compare (Materia m1, Materia m2) {
				
				if (m1.equals(m2))
					return 0;

				int difCreditosRequeridos = m1.obtenerCreditosRequeridos() - m2.obtenerCreditosRequeridos();

				if (difCreditosRequeridos == 0){
					int prioridad = m2.obtenerPrioridad() - m1.obtenerPrioridad();
					if (prioridad == 0) {
						if (m1.sonCorrelativas(m2))
							return 1;	// quiero que m2 este antes que m1
						return -1; 	// quiero que m1 este antes que m2
					}
					return prioridad;
				}

				return difCreditosRequeridos;
			}
		});

		super.construirPlan(set);

	}
}
