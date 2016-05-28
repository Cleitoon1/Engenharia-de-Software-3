package model;
import java.util.List;

import org.json.JSONException;

public interface Subject {
	public List<EducacaoMOD> getDados(String url, Boolean organizar, String campoOrganizavel, String ordem) throws JSONException;
	public List<EducacaoMOD> getDadosAno(String url,int ano) throws JSONException;
	public List<EducacaoMOD> getDadosEstado(String url,String estado) throws JSONException;
	public List<EducacaoMOD> getDadosEstadoAno(String url,String estado, int ano) throws JSONException;
}
