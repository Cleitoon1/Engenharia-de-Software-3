package controller;
import model.EducacaoMOD;
import java.util.Collections;
import java.util.List;



public class CompAnoAsc implements Comparacoes{
	public List<EducacaoMOD> comparar(List<EducacaoMOD> dados) {
		Collections.sort(dados, new AnoComparatorAsc());
		return dados;
		}
}
