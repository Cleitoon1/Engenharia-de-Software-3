package controller;

import java.util.Comparator;

import model.EducacaoMOD;

public class EstadosComparatorDesc implements Comparator<EducacaoMOD> {
	@Override
	public int compare(EducacaoMOD valor1, EducacaoMOD valor2) {
		// TODO Auto-generated method stub
		String estado1 = valor1.getEstado().toUpperCase();
		String estado2 = valor2.getEstado().toUpperCase();
		return estado1.compareTo(estado2);
	}	
}
