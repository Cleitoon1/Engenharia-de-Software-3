package model;

import org.json.JSONException;

import com.db4o.ObjectSet;

public interface Subject {
	public ObjectSet<EducacaoMOD> getData(String link) throws JSONException;

}
