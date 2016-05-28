package controller;


import java.util.Collections;
import java.util.List;

import model.EducacaoMOD;

public class CompValorDesc implements Comparacoes {
	public List<EducacaoMOD> comparar(List<EducacaoMOD> dados) {
		Collections.sort(dados, new ValorComparatorDesc());
		return dados;
		}
}
