package model;

import java.util.List;

import org.json.JSONException;

import com.db4o.ObjectSet;

public interface Subject {
	public ObjectSet<EducacaoMOD> getData(String link) throws JSONException;
	public List<EducacaoMOD> exibirDados(String link, Boolean organizar, String campo, String ordem) throws JSONException;

}
