package BackEnd;

import java.util.*;

public class Plan {

	private int creditos;
	private List<Cuatrimestre> cuatrimestres;
	private List<Cuatrimestre> carrera;
	private Set<Materia> materiasPorAprobar;
	private int creditosTotales;

	public Plan (int creditos, List<Cuatrimestre> carrera, Set<Materia> materiasPorAprobar) {
		this.cuatrimestres = new ArrayList<>();
		this.creditos = creditos;
		this.carrera=new ArrayList<>(carrera);
		this.materiasPorAprobar = materiasPorAprobar;
		this.creditosTotales=0;
	}

	public List<Cuatrimestre> obtenerCuatrimestres(){
		return cuatrimestres;
	}
	
	public Set<Materia> obtenerMaterias(){
		Set<Materia> materias = new HashSet<>();
		for ( Cuatrimestre c : carrera) {
			materias.addAll(c.obtenerMaterias());
		}
		return materias;
		
	}

	public void construirPlan(TreeSet<Materia> set) throws NoTimeException {
		
		set.addAll(materiasPorAprobar);
		
		Cuatrimestre nuevoCuatri = new Cuatrimestre("Cuatrimestre 1",Periodo.PRIMERO);//aca arranca a armar como si estuviese en un primer cuatrimestre pero es indistinto
		nuevoCuatri.agregarMateria(set.first());
		cuatrimestres.add(nuevoCuatri);
		System.out.println(set.first().obtenerNombre());
		set.remove(set.first());
		
		for (Materia  m : set) {
			System.out.println("\n>>Entra al for");
			System.out.println(">>>MATERIA: "+m.obtenerNombre());
			int cantidadDeCuatrimestres = cuatrimestres.size();
			boolean flag = false;
			Iterator<Cuatrimestre> i = cuatrimestres.iterator();
			if (hayCreditosRequeridos(m)) {
				while (!flag && i.hasNext()) {        // itero todos los cuatrimestres para ver donde agrego
					flag = agregarMateria(m, i.next());
				}
			}
			if (!flag) {
				System.out.println(">>>>nuevo cuatri");
				StringBuilder formato = new StringBuilder();
				formato.append("Cuatrimestre ").append(cantidadDeCuatrimestres + 1);
				Cuatrimestre nuevoCuatrimestre = new Cuatrimestre(formato.toString(),(cuatrimestres.get(cuatrimestres.size()-1).obtenerPeriodo().obtenerNumero()==1)?Periodo.SEGUNDO:Periodo.PRIMERO);
				if (!nuevoCuatrimestre.periodoDisponible(m)){
					System.out.println(">>>>nuevo cuatri");
					StringBuilder otroFormato = new StringBuilder();
					otroFormato.append("Cuatrimestre ").append(cantidadDeCuatrimestres + 2);
					Cuatrimestre otroNuevoCuatrimestre = new Cuatrimestre(otroFormato.toString(), ((nuevoCuatrimestre.obtenerPeriodo().obtenerNumero() == 1)?Periodo.SEGUNDO:Periodo.PRIMERO));
					otroNuevoCuatrimestre.agregarMateria(m);
					cuatrimestres.add(nuevoCuatrimestre);
					cuatrimestres.add(otroNuevoCuatrimestre);
				}
				else {
					nuevoCuatrimestre.agregarMateria(m);
					cuatrimestres.add(nuevoCuatrimestre);
				}
			}
		}
	}

	private boolean agregarMateria(Materia m, Cuatrimestre c) throws NoTimeException{

		System.out.println(c.obtenerNombre());

		if (c.hayCreditos(m, creditos) && c.validaHorarios(m) && c.periodoDisponible(m) && correlativasCursadas(m, c) && !c.hayAutoCorrelativas(m)) {
			System.out.println("-> agrega materia");
			c.agregarMateria(m);
			creditosTotales += m.obtenerCreditos();
			return true;
		}
		
		if (c.hayAutoCorrelativas(m))
			System.out.println("-> Hay autocorrelativas");
		
		if (!c.hayCreditos(m, creditos))
			System.out.println("-> No hay creditos");
		
		if (!c.validaHorarios(m))
			System.out.println("-> No valida horarios");
		
		return false;
	}

	private boolean correlativasCursadas(Materia m, Cuatrimestre c) {		// metodo que verifica que las materias correlativas ya esten en el plan para ser cursadas

		Set<Materia> materiasDelPlan = new HashSet<>();
		Set<Materia> materiasCorrelativas = m.obtenerCorrelativas();
		
		for (int i=0; i<cuatrimestres.indexOf(c); i++) {
			materiasDelPlan.addAll(cuatrimestres.get(i).obtenerMaterias());
		}

		for (Materia materia : materiasCorrelativas) {
			if (!materiasDelPlan.contains(materia) && materiasPorAprobar.contains(materia)) {	// si la materia no esta en el plan ni esta aprobada
				System.out.println(">>>>Correlativas NO cursadas");
				return false;
			}
		}
		
		System.out.println(">>>>Correlativas cursadas");
		return true;

	}

	private boolean hayCreditosRequeridos(Materia m){
		return creditosTotales >= m.obtenerCreditosRequeridos();
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
