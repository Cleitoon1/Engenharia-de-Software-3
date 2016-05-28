package controller;


import java.util.Collections;
import java.util.List;

import model.EducacaoMOD;

public class CompEstadoDesc implements Comparacoes {
	public List<EducacaoMOD> comparar(List<EducacaoMOD> dados) {
		Collections.sort(dados, new EstadosComparatorDesc());
		return dados;
		}
}
