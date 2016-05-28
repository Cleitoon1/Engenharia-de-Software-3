package controller;

import java.util.Comparator;

import model.EducacaoMOD;

public class AnoComparatorAsc implements Comparator<EducacaoMOD> {
	@Override
	public int compare(EducacaoMOD valor1, EducacaoMOD valor2) {
		// TODO Auto-generated method stub
		int ano1 = valor1.getAno();
		int ano2 = valor2.getAno();
		return ano2 - ano1;
	}
}
