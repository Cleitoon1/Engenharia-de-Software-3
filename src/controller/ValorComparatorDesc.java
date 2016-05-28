package controller;

import java.util.Comparator;

import model.EducacaoMOD;
public class ValorComparatorDesc implements Comparator<EducacaoMOD> {
	@Override
	public int compare(EducacaoMOD valor1, EducacaoMOD valor2) {
		// TODO Auto-generated method stub
		double ano1 = valor1.getValor();
		double ano2 = valor2.getValor();
		return Double.compare(ano1, ano2);
	}
}
