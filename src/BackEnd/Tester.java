package BackEnd;

import java.util.*;

public class Tester {
  public static void main(String[] args) throws NoTimeException
  {
    List<Cuatrimestre> cuatrimestresInformatica=new ArrayList<>();

    // comment para pushear

    final String MADERO="Madero";
    final String SDT="Distrito Tecnológico";

    Cuatrimestre c1=new Cuatrimestre("C1",Periodo.PRIMERO);//ARRANCAMOS EN PRIMEOR PERO ES INDISTINTO
    Cuatrimestre c2=new Cuatrimestre("C2",Periodo.SEGUNDO);
    Cuatrimestre c3=new Cuatrimestre("C3",Periodo.PRIMERO);
    Cuatrimestre c4=new Cuatrimestre("C4",Periodo.SEGUNDO);
    Cuatrimestre c5=new Cuatrimestre("C5",Periodo.PRIMERO);
    Cuatrimestre c6=new Cuatrimestre("C6",Periodo.SEGUNDO);
    Cuatrimestre c7=new Cuatrimestre("C7",Periodo.PRIMERO);
    Cuatrimestre c8=new Cuatrimestre("C8",Periodo.SEGUNDO);
    Cuatrimestre c9=new Cuatrimestre("C9",Periodo.PRIMERO);
    Cuatrimestre c10=new Cuatrimestre("C10",Periodo.SEGUNDO);


    //todas las materias son en madero menos dos que indican que son en PP. Hay qeu fijarse bien por clase igual.
        Materia algebra=new Materia("Álgebra",9,c1, 0);
          algebra.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,9,13));
          algebra.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,9,14));
        Materia analisis1=new Materia("Análisis Matemático I",6,c1, 0);
          analisis1.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,8,11));
          analisis1.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,8,11));
        Materia introInfo=new Materia("Introducción a la Informática",3,c1, 0);
          introInfo.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,8,11));
        Materia metodologia=new Materia("Metodología del Aprendizaje",3,c1, 0);
          metodologia.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,14,17));
        Materia sistemasDeRep=new Materia("Sistemas de Representación",3,c1, 0);
          sistemasDeRep.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,14,17));
        Materia analisis2=new Materia("Análisis Matemático II",6,c2, 0);
          analisis2.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,12,14));
          analisis2.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,11,13));
          analisis2.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,13,15));
        Materia fisica1=new Materia("Física I",6,c2, 0);
          fisica1.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,8,10));
          fisica1.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,11,13));
          fisica1.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,8,10));
        Materia mateDiscreta=new Materia("Matemática Discreta",6,c2, 0);
          mateDiscreta.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,8,11));
          mateDiscreta.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,8,11));
        Materia pi=new Materia("Programación Imperativa",9,c2, 0);
          pi.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,13,17));
          pi.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,10,13));
          pi.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,10,12));
        Materia xml=new Materia("Diseño y Porcesamiento de Documentos XML",3,c3, 0);
           	xml.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, MADERO,9,12));
        Materia fisica2=new Materia("Física II",6,c3, 0);
            fisica2.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,13,15));
            fisica2.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,17,19));
            fisica2.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,13,15));
        Materia poo=new Materia("Programación Orientada a Objetos",6,c3, 0);
            poo.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,16,18));
            poo.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,16,20));
        Materia logica=new Materia("Lógica Computacional",6,c3, 0);
            logica.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,11,13));
            logica.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,9,11));
            logica.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,14,16));
        Materia quimica=new Materia("Química",3,c3, 0);
            quimica.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,8,11));
        Materia arqui=new Materia("Arquitectura de Computadoras",6,c4, 0);
            arqui.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,16,19));
            arqui.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,16,19));
        Materia eda=new Materia("Estructura de Datos y Algoritmos",6,c4, 0);
            eda.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,14,16));
            eda.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,17,21));
        Materia fisica3=new Materia("Física III",6,c4, 0);
            fisica3.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,14,18));
            fisica3.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,14,16));
        Materia proba=new Materia("Probabilidad y Estadística",6,c4, 0);
            proba.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,11,13));
            proba.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,11,13));
            proba.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,11,13));
        Materia baseDeDatos1=new Materia("Base de Datos I",6,c5, 0);
            baseDeDatos1.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,14,17));
            baseDeDatos1.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,10,13));
        Materia ingeSoft1=new Materia("Ingeniería de Software I",6,c5, 0);
            ingeSoft1.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,11,14));
            ingeSoft1.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,14,17));
        Materia hci=new Materia("Interaccion Hombre-computadora",6,c5, 0);
            hci.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,19,22));
            hci.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,18,21));
        Materia sistemasOperativos=new Materia("Sistemas Operativos",4,c5, 0);
            sistemasOperativos.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,19,22));
            sistemasOperativos.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,18,21));
        Materia automatas=new Materia("Autómatas, Teoría de Lenguajes y Compiladores",6,c6, 0);
            automatas.agregarClase(new Clase(DiaDeLaSemana.JUEVES,SDT,15,18));
            automatas.agregarClase(new Clase(DiaDeLaSemana.VIERNES,SDT,15,18));
        Materia formacionGral1=new Materia("Formación General I",3,c6, 0);
            formacionGral1.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,14,17));
        Materia metodosNumericos=new Materia("Métodos Numéricos",3,c6, 0);
            metodosNumericos.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,8,11));
        Materia protos=new Materia("Protocolos de Comunicación",6,c6, 0);
            protos.agregarClase(new Clase(DiaDeLaSemana.MARTES,SDT,15,18));
            protos.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,15,18));
        Materia paw=new Materia("Proyecto de Aplicaciones Web",6,c6, 0);
            paw.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,19,22));
            paw.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,19,22));
        Materia economia = new Materia ("Economía para Ingenieros", 3, c7, 0);
            economia.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 11, 14));
        Materia derecho = new Materia ("Derecho para Ingenieros", 3, c8, 144);
            derecho.agregarClase(new Clase(DiaDeLaSemana.MARTES, MADERO, 12, 15));
        Materia ingeSoft2 = new Materia ("Ingeniería de Software II", 3, c7, 0);
            ingeSoft2.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 19, 21));
        Materia baseDeDatos2 = new Materia ("Base De Datos II", 6, c7, 0);
            baseDeDatos2.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 14, 17));
            baseDeDatos2.agregarClase(new Clase(DiaDeLaSemana.MARTES, SDT, 19, 22));
        Materia progObjDist = new Materia ("Programación de Objetos Distribuidos", 3, c8, Periodo.SEGUNDO, 0);
            progObjDist.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 18, 21));
        Materia metodosNumAvanzados = new Materia ("Métodos Numéricos Avanzados", 6, c8, Periodo.SEGUNDO, 0);
            metodosNumAvanzados.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 14, 17));
            metodosNumAvanzados.agregarClase(new Clase(DiaDeLaSemana.VIERNES, MADERO, 12, 15));
        Materia simulacion = new Materia ("Simulación de Sistemas", 6, c8, 0);
            simulacion.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 10, 13));
            simulacion.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 10, 13));
        Materia sistInteligencia = new Materia ("Sistemas de Inteligencia Artificial", 6, c7, Periodo.PRIMERO, 0);
            sistInteligencia.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 12, 15));
            sistInteligencia.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 15, 18));
        Materia gestion = new Materia ("Gestión de Proyectos Informáticos", 3, c8, 0);
            gestion.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 15, 18));
        Materia cripto = new Materia ("Criptografía y Seguridad", 6, c7, Periodo.PRIMERO, 0);
            cripto.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 15, 18));
            cripto.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 16, 19));
        Materia redes = new Materia ("Redes de Información", 6, c9, Periodo.PRIMERO, 0);
            redes.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 19, 22));
            redes.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 19, 22));
        Materia proyecto1 = new Materia ("Proyecto Final", 6, c9, Periodo.PRIMERO, 160);
        Materia proyecto2 = new Materia ("Proyecto Final", 6, c10, Periodo.SEGUNDO, 160);
        Materia practicaLaboral = new Materia ("Práctica Laboral", 0, c9, 192);
        Materia seguridad = new Materia ("Seguridad Ocupacional", 3, c10,140);
            seguridad.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 18, 21));


        pi.agregarCorrelativa(introInfo);
        pi.agregarCorrelativa(algebra);
        mateDiscreta.agregarCorrelativa(algebra);
        analisis2.agregarCorrelativa(algebra);
        analisis2.agregarCorrelativa(analisis1);
        fisica1.agregarCorrelativa(analisis1);
        xml.agregarCorrelativa(pi);
        poo.agregarCorrelativa(pi);
        arqui.agregarCorrelativa(pi);
        logica.agregarCorrelativa(algebra);
        fisica2.agregarCorrelativa(analisis2);
        eda.agregarCorrelativa(mateDiscreta);
        eda.agregarCorrelativa(poo);
        proba.agregarCorrelativa(analisis2);
        fisica3.agregarCorrelativa(analisis2);
        fisica3.agregarCorrelativa(fisica1);
        hci.agregarCorrelativa(xml);
        hci.agregarCorrelativa(poo);
        ingeSoft1.agregarCorrelativa(poo);
        baseDeDatos1.agregarCorrelativa(xml);
        baseDeDatos1.agregarCorrelativa(eda);
        baseDeDatos1.agregarCorrelativa(logica);
        sistemasOperativos.agregarCorrelativa(arqui);
        sistemasOperativos.agregarCorrelativa(eda);
        paw.agregarCorrelativa(hci);
        paw.agregarCorrelativa(ingeSoft1);
        paw.agregarCorrelativa(baseDeDatos1);
        paw.agregarCorrelativa(sistemasOperativos);
        automatas.agregarCorrelativa(eda);
        protos.agregarCorrelativa(sistemasOperativos);
        metodosNumericos.agregarCorrelativa(analisis2);
        economia.agregarCorrelativa(proba);
        ingeSoft2.agregarCorrelativa(sistemasOperativos);
        ingeSoft2.agregarCorrelativa(ingeSoft1);
        baseDeDatos2.agregarCorrelativa(sistemasOperativos);
        baseDeDatos2.agregarCorrelativa(baseDeDatos1);
        progObjDist.agregarCorrelativa(protos);
        progObjDist.agregarCorrelativa(paw);
        metodosNumAvanzados.agregarCorrelativa(metodosNumericos);
        simulacion.agregarCorrelativa(metodosNumericos);
        simulacion.agregarCorrelativa(paw);
        sistInteligencia.agregarCorrelativa(proba);
        sistInteligencia.agregarCorrelativa(eda);
        gestion.agregarCorrelativa(ingeSoft2);
        gestion.agregarCorrelativa(economia);
        cripto.agregarCorrelativa(paw);
        cripto.agregarCorrelativa(protos);
        proyecto2.agregarCorrelativa(proyecto1);
        redes.agregarCorrelativa(protos);
        proyecto1.agregarCorrelativa(gestion);
        proyecto2.agregarCorrelativa(gestion);

    int creditos1, creditos2, creditos3, creditos4, creditosDelPlan=27, creditosElectivas=30; // se obtienen del usuario
    creditos1 = creditosDelPlan - c7.obtenerCreditos();
    creditos2= creditosDelPlan - c8.obtenerCreditos();
    creditos3= creditosDelPlan - c9.obtenerCreditos();
    creditos4 = creditosDelPlan - c10.obtenerCreditos();

    if (creditos1 > creditosElectivas){
        creditos1=creditosElectivas;
        creditos2 = creditos3 = creditos4 = 0;
    }

    if (creditos1 + creditos2 > creditosElectivas){
        creditos2 = creditosElectivas - creditos1;
        creditos3 = creditos4 = 0;
    }

    if (creditos1 + creditos2 + creditos3 > creditosElectivas){
        creditos3 = creditosElectivas - creditos1 - creditos2;
        creditos4 = 0;
    }

    if (creditos1 + creditos2 + creditos3 + creditos4 > creditosElectivas){
        creditos4 = 0;
    }

    Materia Electivas1 = new Materia("Electivas", creditos1, c7, 0);
    Materia Electivas2 = new Materia("Electivas", creditos2, c8, 0);
    Materia Electivas3 = new Materia("Electivas", creditos3, c9, 0);
    Materia Electivas4 = new Materia("Electivas", creditos4, c10, 0);

    cuatrimestresInformatica.add(c1);
    cuatrimestresInformatica.add(c2);
    cuatrimestresInformatica.add(c3);
    cuatrimestresInformatica.add(c4);
    cuatrimestresInformatica.add(c5);
    cuatrimestresInformatica.add(c6);
    cuatrimestresInformatica.add(c7);
    cuatrimestresInformatica.add(c8);
    cuatrimestresInformatica.add(c9);
    cuatrimestresInformatica.add(c10);
    
    Set<Materia> autocorrelativasFisicaIII = new HashSet<>();
    autocorrelativasFisicaIII.add(fisica2);
    fisica3.setearAutoCorrelativas(autocorrelativasFisicaIII);

    Set<Materia> materiasDesaprobadas = new HashSet<>();

    materiasDesaprobadas.add(pi);
    materiasDesaprobadas.addAll(c3.obtenerMaterias());
    materiasDesaprobadas.addAll(c4.obtenerMaterias());
    materiasDesaprobadas.addAll(c5.obtenerMaterias());
    materiasDesaprobadas.addAll(c6.obtenerMaterias());
    materiasDesaprobadas.addAll(c7.obtenerMaterias());
    materiasDesaprobadas.addAll(c8.obtenerMaterias());
    materiasDesaprobadas.addAll(c9.obtenerMaterias());
    materiasDesaprobadas.addAll(c10.obtenerMaterias());

    PlanAcademico planAcademico = new PlanAcademico(creditosDelPlan, cuatrimestresInformatica, materiasDesaprobadas);
    planAcademico.construirPlan();
    PlanCorrelativo planCorrelativo = new PlanCorrelativo(creditosDelPlan, cuatrimestresInformatica, materiasDesaprobadas);
    planCorrelativo.construirPlan();

    System.out.println("Plan Academico: " + planAcademico + "\n\n");
    System.out.println("Plan Correlativo: " + planCorrelativo + "\n\n");

  }
}
