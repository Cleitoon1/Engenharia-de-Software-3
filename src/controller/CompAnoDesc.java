package controller;


import java.util.Collections;
import java.util.List;

import model.EducacaoMOD;

public class CompAnoDesc implements Comparacoes {
	public List<EducacaoMOD> comparar(List<EducacaoMOD> dados) {
		Collections.sort(dados, new AnoComparatorDesc());
		return dados;
		}
}
