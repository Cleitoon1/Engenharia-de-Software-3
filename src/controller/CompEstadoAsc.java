package controller;


import java.util.Collections;
import java.util.List;

import model.EducacaoMOD;

public class CompEstadoAsc implements Comparacoes {
 @Override
public List<EducacaoMOD> comparar(List<EducacaoMOD> dados) {
			Collections.sort(dados, new EstadoComparatorAsc());
			return dados;
 		}
}
