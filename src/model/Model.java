package model;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.stream.Collectors;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
/*
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;*/
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import controller.Comparacoes;
public class Model implements Subject{
//	private List<EducacaoMOD> bd;
	public List<EducacaoMOD> l = new ArrayList<EducacaoMOD>();
	private Comparacoes c;
	ObjectContainer mediasIDEB = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "mediasIDEB2.db4o");	
	private static Model uniqueInstance;
	
	public static Model getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Model();
		}
		return uniqueInstance;
	}
	@Override
	public ObjectSet<EducacaoMOD> getData(String link) throws JSONException{
		final StringBuilder result = new StringBuilder();
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) new URL(link).openConnection();
            InputStream in = urlConnection.getInputStream();        
            InputStreamReader isw = new InputStreamReader(in);
            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                result.append(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
      //Chamar o metodo que ira mapear o Json para o controller
      return gerarBanco(new JSONObject(result.toString()));
	}
	
	public ObjectSet<EducacaoMOD> gerarBanco(JSONObject json) throws JSONException{
		JSONArray lstNotas = json.getJSONArray("valores");
		Query query = mediasIDEB.query();
		try {
            for (int i = 0; i < lstNotas.length(); i++) {
                JSONObject obj = lstNotas.getJSONObject(i);                
                mediasIDEB.store(new EducacaoMOD(EstadosEnum.getEstadoByNum(obj.getInt("estado_ibge")), obj.getInt("ano"), obj.getDouble("valor")));
            }        
    		query.constrain(EducacaoMOD.class);
    		ObjectSet<EducacaoMOD> medias = query.execute();		
    		return medias;
        } catch (JSONException e) {
        	throw e;
        }
	}
	
	public void setOrdenacao(Comparacoes c){
		this.c = c;
	}
	
	public void fazerOrdenacao(){
		c.comparar(l);
	}	
}
