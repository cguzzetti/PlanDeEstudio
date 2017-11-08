package BackEnd;

import java.util.*;

public class Tester {
  public static void main(String[] args) throws NoTimeException
  {
    List<Cuatrimestre> cuatrimestresInformatica=new ArrayList<>();

    final String MADERO="Madero";
    final String SDT="Distrito Tecnológico";
    int creditosTotalesInformatica=243;

    Cuatrimestre c1=new Cuatrimestre("1C1",Periodo.PRIMERO);//ARRANCAMOS EN PRIMERO PERO ES INDISTINTO
    Cuatrimestre c2=new Cuatrimestre("1C2",Periodo.SEGUNDO);
    Cuatrimestre c3=new Cuatrimestre("2C1",Periodo.PRIMERO);
    Cuatrimestre c4=new Cuatrimestre("2C2",Periodo.SEGUNDO);
    Cuatrimestre c5=new Cuatrimestre("3C1",Periodo.PRIMERO);
    Cuatrimestre c6=new Cuatrimestre("3C2",Periodo.SEGUNDO);
    Cuatrimestre c7=new Cuatrimestre("4C1",Periodo.PRIMERO);
    Cuatrimestre c8=new Cuatrimestre("4C2",Periodo.SEGUNDO);
    Cuatrimestre c9=new Cuatrimestre("5C1",Periodo.PRIMERO);
    Cuatrimestre c10=new Cuatrimestre("5C2",Periodo.SEGUNDO);


    //todas las materias son en madero menos dos que indican que son en PP. Hay qeu fijarse bien por clase igual.
        Materia algebra=new Materia("Álgebra",9,c1);
          algebra.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,9,13));
          algebra.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,9,14));
        Materia analisis1=new Materia("Análisis Matemático I",6,c1);
          analisis1.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,8,11));
          analisis1.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,8,11));
        Materia introInfo=new Materia("Introducción a la Informática",3,c1);
          introInfo.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,8,11));
        Materia metodologia=new Materia("Metodología del Aprendizaje",3,c1);
          metodologia.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,14,17));
        Materia sistemasDeRep=new Materia("Sistemas de Representación",3,c1);
          sistemasDeRep.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,14,17));
        Materia analisis2=new Materia("Análisis Matemático II",6,c2);
          analisis2.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,12,14));
          analisis2.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,11,13));
          analisis2.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,13,15));
        Materia fisica1=new Materia("Física I",6,c2);
          fisica1.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,8,10));
          fisica1.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,11,13));
          fisica1.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,8,10));
        Materia mateDiscreta=new Materia("Matemática Discreta",6,c2);
          mateDiscreta.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,8,11));
          mateDiscreta.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,8,11));
        Materia pi=new Materia("Programación Imperativa",9,c2);
          pi.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,13,17));
          pi.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,10,13));
          pi.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,10,12));
        Materia xml=new Materia("Diseño y Porcesamiento de Documentos XML",3,c3);
           	xml.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, MADERO,9,12));
        Materia fisica2=new Materia("Física II",6,c3);
            fisica2.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,13,15));
            fisica2.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,17,19));
            fisica2.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,13,15));
        Materia poo=new Materia("Programación Orientada a Objetos",6,c3);
            poo.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,16,18));
            poo.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,16,20));
        Materia logica=new Materia("Lógica Computacional",6,c3);
            logica.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,11,13));
            logica.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,9,11));
            logica.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,14,16));
        Materia quimica=new Materia("Química",3,c3);
            quimica.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,8,11));
        Materia arqui=new Materia("Arquitectura de Computadoras",6,c4);
            arqui.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,16,19));
            arqui.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,16,19));
        Materia eda=new Materia("Estructura de Datos y Algoritmos",6,c4);
            eda.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,14,16));
            eda.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,17,21));
        Materia fisica3=new Materia("Física III",6,c4);
            fisica3.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,14,18));
            fisica3.agregarClase(new Clase(DiaDeLaSemana.VIERNES,MADERO,14,16));
        Materia proba=new Materia("Probabilidad y Estadística",6,c4);
            proba.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,11,13));
            proba.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,11,13));
            proba.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,11,13));
        Materia baseDeDatos1=new Materia("Base de Datos I",6,c5);
            baseDeDatos1.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,14,17));
            baseDeDatos1.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,10,13));
        Materia ingeSoft1=new Materia("Ingeniería de Software I",6,c5);
            ingeSoft1.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,11,14));
            ingeSoft1.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,14,17));
        Materia hci=new Materia("Interaccion Hombre-computadora",6,c5);
            hci.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,19,22));
            hci.agregarClase(new Clase(DiaDeLaSemana.JUEVES,MADERO,18,21));
        Materia sistemasOperativos=new Materia("Sistemas Operativos",6,c5);
            sistemasOperativos.agregarClase(new Clase(DiaDeLaSemana.MARTES,MADERO,19,22));
            sistemasOperativos.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,18,21));
        Materia automatas=new Materia("Autómatas, Teoría de Lenguajes y Compiladores",6,c6);
            automatas.agregarClase(new Clase(DiaDeLaSemana.JUEVES,SDT,15,18));
            automatas.agregarClase(new Clase(DiaDeLaSemana.VIERNES,SDT,15,18));
        Materia formacionGral1=new Materia("Formación General I",3,c6);
            formacionGral1.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,14,17));
        Materia metodosNumericos=new Materia("Métodos Numéricos",3,c6);
            metodosNumericos.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,8,11));
        Materia protos=new Materia("Protocolos de Comunicación",6,c6);
            protos.agregarClase(new Clase(DiaDeLaSemana.MARTES,SDT,15,18));
            protos.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,15,18));
        Materia paw=new Materia("Proyecto de Aplicaciones Web",6,c6);
            paw.agregarClase(new Clase(DiaDeLaSemana.LUNES,MADERO,19,22));
            paw.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES,MADERO,19,22));
        Materia economia = new Materia ("Economía para Ingenieros", 3, c7, 147);
            economia.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 11, 14));
        Materia derecho = new Materia ("Derecho para Ingenieros", 3, c8, 144);
            derecho.agregarClase(new Clase(DiaDeLaSemana.MARTES, MADERO, 12, 15));
        Materia ingeSoft2 = new Materia ("Ingeniería de Software II", 3, c7, 147);
            ingeSoft2.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 19, 21));
        Materia baseDeDatos2 = new Materia ("Base De Datos II", 6, c7, 147);
            baseDeDatos2.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 14, 17));
            baseDeDatos2.agregarClase(new Clase(DiaDeLaSemana.MARTES, SDT, 19, 22));
        Materia progObjDist = new Materia ("Programación de Objetos Distribuidos", 3, c8, Periodo.SEGUNDO, 147);
            progObjDist.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 18, 21));
        Materia metodosNumAvanzados = new Materia ("Métodos Numéricos Avanzados", 6, c8, Periodo.SEGUNDO, 147);
            metodosNumAvanzados.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 14, 17));
            metodosNumAvanzados.agregarClase(new Clase(DiaDeLaSemana.VIERNES, MADERO, 12, 15));
        Materia simulacion = new Materia ("Simulación de Sistemas", 6, c8, 147);
            simulacion.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 10, 13));
            simulacion.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 10, 13));
        Materia sistInteligencia = new Materia ("Sistemas de Inteligencia Artificial", 6, c7, Periodo.PRIMERO, 147);
            sistInteligencia.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 12, 15));
            sistInteligencia.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 15, 18));
        Materia gestion = new Materia ("Gestión de Proyectos Informáticos", 3, c8, 147);
            gestion.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 15, 18));
        Materia cripto = new Materia ("Criptografía y Seguridad", 6, c7, Periodo.PRIMERO, 147);
            cripto.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 15, 18));
            cripto.agregarClase(new Clase(DiaDeLaSemana.JUEVES, MADERO, 16, 19));
        Materia redes = new Materia ("Redes de Información", 6, c9, Periodo.PRIMERO, 147);
            redes.agregarClase(new Clase(DiaDeLaSemana.LUNES, SDT, 19, 22));
            redes.agregarClase(new Clase(DiaDeLaSemana.MIERCOLES, SDT, 19, 22));
        Materia proyecto1 = new Materia ("Proyecto Final 1c", 6, c9, 160);
        Materia proyecto2 = new Materia ("Proyecto Final 2c", 6, c10, 160);
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
        proyecto2.agregarCorrelativa(proyecto1);

    /*, creditos1, creditos2, creditos3, creditos4, creditosElectivas=30; // se obtienen del usuario
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

    Materia Electivas1 = new Materia("Electivas", 6, c7, 0);*/
    Materia Electivas1 = new Materia("Electivas 1", 3, c8, 147);
    Materia Electivas2 = new Materia("Electivas 2", 6, c9, 147);
    Materia Electivas3 = new Materia("Electivas 3", 21, c10, 147);

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

    Set<Materia> materiasPorAprobar = new HashSet<>();

    materiasPorAprobar.add(algebra);
    materiasPorAprobar.addAll(c2.obtenerMaterias());
    materiasPorAprobar.addAll(c3.obtenerMaterias());
    materiasPorAprobar.addAll(c4.obtenerMaterias());
    materiasPorAprobar.addAll(c5.obtenerMaterias());
    materiasPorAprobar.addAll(c6.obtenerMaterias());
    materiasPorAprobar.addAll(c7.obtenerMaterias());
    materiasPorAprobar.addAll(c8.obtenerMaterias());
    materiasPorAprobar.addAll(c9.obtenerMaterias());
    materiasPorAprobar.addAll(c10.obtenerMaterias());

    int creditosPorAprobar=0;


        for(Materia m:materiasPorAprobar)
        {
            creditosPorAprobar+=m.obtenerCreditos();
        }

      System.out.println("creditosPorAprobar====" + creditosPorAprobar);

    int creditosaprobados=creditosTotalesInformatica-creditosPorAprobar;
      System.out.println("creditos aprobados====" +creditosaprobados);

    PlanAcademico planAcademico = new PlanAcademico(27, cuatrimestresInformatica, materiasPorAprobar, creditosTotalesInformatica-creditosPorAprobar);
    planAcademico.construirPlan();

    System.out.println("Plan Academico: " + planAcademico + "\n\n");

    PlanCorrelativo planCorrelativo = new PlanCorrelativo(27, cuatrimestresInformatica, materiasPorAprobar,creditosTotalesInformatica-creditosPorAprobar);
    planCorrelativo.construirPlan();

    System.out.println("Plan Correlativo: " + planCorrelativo + "\n\n");

  }
}
