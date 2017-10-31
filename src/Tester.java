import BackEnd.*;

import java.util.*;

public class Tester {
  public static void main(String[] args) throws NoTimeException
  {
    List<Cuatrimestre> cuatrimestresInformatica=new ArrayList<>();

    final String MADERO="Madero";
    final String SDT="Distrito Tecnológico";

    Cuatrimestre c1=new Cuatrimestre("C1");
    Cuatrimestre c2=new Cuatrimestre("C2");
        /*Cuatrimestre c3=new Cuatrimestre("C3");
        Cuatrimestre c4=new Cuatrimestre("C4");
        Cuatrimestre c5=new Cuatrimestre("C5");
        Cuatrimestre c6=new Cuatrimestre("C6");*/
    //todas las materias son en madero menos dos que indican que son en PP. Hay qeu fijarse bien por clase igual.
    Materia algebra=new Materia("Álgebra",9,c1);
          algebra.agregarClase(new Clase("Martes",MADERO,9,13));
          algebra.agregarClase(new Clase("Jueves",MADERO,9,14));
    Materia analisis1=new Materia("Análisis Matemático I",6,c1);
          analisis1.agregarClase(new Clase("Miercoles",MADERO,8,11));
          analisis1.agregarClase(new Clase("Viernes",MADERO,8,11));
    Materia introInfo=new Materia("Introducción a la Informática",3,c1);
          introInfo.agregarClase(new Clase("Lunes",MADERO,8,11));
    Materia metodologia=new Materia("Metodología del Aprendizaje",3,c1);
          metodologia.agregarClase(new Clase("Lunes",MADERO,14,17));
    Materia sistemasDeRep=new Materia("Sistemas de Representación",3,c1);
          sistemasDeRep.agregarClase(new Clase("Miércoles",MADERO,14,17));
    Materia analisis2=new Materia("Análisis Matemático II",6,c2);
          analisis1.agregarClase(new Clase("Lunes",MADERO,12,14));
          analisis1.agregarClase(new Clase("Martes",MADERO,11,13));
          analisis1.agregarClase(new Clase("Jueves",MADERO,13,15));
    Materia fisica1=new Materia("Física I",6,c2);
          fisica1.agregarClase(new Clase("Martes",MADERO,8,10));
          fisica1.agregarClase(new Clase("Jueves",MADERO,11,13));
          fisica1.agregarClase(new Clase("Viernes",MADERO,8,10));
    Materia mateDiscreta=new Materia("Matemática Discreta",6,c2);
          mateDiscreta.agregarClase(new Clase("Lunes",MADERO,8,11));
          mateDiscreta.agregarClase(new Clase("Jueves",MADERO,8,11));
    Materia pi=new Materia("Programación Imperativa",9,c2);
          pi.agregarClase(new Clase("Martes",MADERO,13,17));
          pi.agregarClase(new Clase("Miércoles",MADERO,10,13));
          pi.agregarClase(new Clase("Viernes",MADERO,10,12));
        /*Materia xml=new Materia("Diseño y Porcesamiento de Documentos XML",3,c3);//
        Materia fisica2=new Materia("Física II",6,c3);//Lunes 13:00 - 15:00, Martes 17:00 - 19:00, Miércoles 13:00 - 15:00
        Materia poo=new Materia("Programación Orientada a Objetos",6,c3);//Lunes 16:00 - 18:00, Viernes 16:00 - 20:00
        Materia logica=new Materia("Lógica Computacional",6,c3);//Lunes 11:00 - 13:00, Martes 09:00 - 11:00, Martes 14:00 - 16:00
        Materia quimica=new Materia("Química",3,c3);// Viernes 08:00 - 11:00
        Materia arqui=new Materia("Arquitectura de Computadoras",6,c4);//Lunes 16:00 - 19:00 , Miércoles 16:00 - 19:00
        Materia eda=new Materia("Estructura de Datos y Algoritmos",6,c4);//Lunes 14:00 - 16:00, Martes 17:00 - 21:00
        Materia fisica3=new Materia("Física III",6,c4);//Jueves 14:00 - 18:00, Viernes 14:00 - 16:00
        Materia proba=new Materia("Probabilidad y Estadística",6,c4);// Lunes 11:00 - 13:00, Martes 11:00 - 13:00, Jueves 11:00 - 13:00
        Materia baseDeDatos1=new Materia("Base de Datos I",6,c5);//Martes 14:00 - 17:00, Jueves 10:00 - 13:00
        Materia ingeSoft1=new Materia("Ingenieríe de Software I",6,c5);//Martes 11:00 - 14:00, Jueves 14:00 - 17:00
        Materia hci=new Materia("Interaccion Hombre-computadora",6,c5);// Lunes 19:00 - 22:00, Jueves 18:00 - 21:00
        Materia sistemasOperativos=new Materia("Sistemas Operativos",4,c5);//Martes 19:00 - 22:00, Miércoles 18:00 - 21:00
        Materia automatas=new Materia("Autómatas, Teoría de Lenguajes y Compiladores",6,c6);//Jueves 15:00 - 18:00, Viernes 15:00 - 18:00, distrito tec
        Materia formacionGral1=new Materia("Formación General I",3,c6);//Lunes 14:00 - 17:00
        Materia metodosNumericos=new Materia("Métodos Numéricos",3,c6);//Lunes 08:00 - 11:00
        Materia protos=new Materia("Protocolos de Comunicación",6,c6);//Martes 15:00 - 18:00 , Miércoles 15:00 - 18:00, distrito tec
        Materia paw=new Materia("Proyecto de Aplicaciones Web",6,c6);// Lunes 19:00 - 22:00, Miércoles 19:00 - 22:00  */

    pi.agregarCorrelativa(introInfo);
    pi.agregarCorrelativa(algebra);
    mateDiscreta.agregarCorrelativa(algebra);
    analisis2.agregarCorrelativa(algebra);
    analisis2.agregarCorrelativa(analisis1);
    fisica1.agregarCorrelativa(analisis1);
        /*xml.agregarCorrelativa(pi);
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
        metodosNumericos.agregarCorrelativa(analisis2);*/
/*
    c1.agregarMateria(analisis1);
    c1.agregarMateria(algebra);
    c1.agregarMateria(sistemasDeRep);
    c1.agregarMateria(metodologia);
    c1.agregarMateria(introInfo);
    c2.agregarMateria(analisis2);
    c2.agregarMateria(pi);
    c2.agregarMateria(fisica1);
    c2.agregarMateria(mateDiscreta);
*/
    cuatrimestresInformatica.add(c1);
    cuatrimestresInformatica.add(c2);
        /*cuatrimestresInformatica.add(c3);
        cuatrimestresInformatica.add(c4);
        cuatrimestresInformatica.add(c5);
        cuatrimestresInformatica.add(c6);*/

    Set<Materia> materiasAprobadas = new HashSet<>();
    materiasAprobadas.add(analisis1);
    materiasAprobadas.add(metodologia);
    materiasAprobadas.add(introInfo);
    materiasAprobadas.add(sistemasDeRep);

    PlanAcademico planAcademico = new PlanAcademico(27,cuatrimestresInformatica, materiasAprobadas);
    planAcademico.construirPlan();
    PlanCorrelativo planCorrelativo = new PlanCorrelativo(27, cuatrimestresInformatica, materiasAprobadas);
    planCorrelativo.construirPlan();

    System.out.println("Plan Academico: " + planAcademico + "\n\n");
    System.out.println("Plan Correlativo: " + planCorrelativo + "\n\n");

  }
}
