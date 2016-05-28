package facade;
import java.util.List;

import org.json.JSONException;
import com.db4o.ObjectSet;
import controller.CompAnoAsc;
import controller.CompAnoDesc;
import controller.CompEstadoAsc;
import controller.CompEstadoDesc;
import controller.CompValorAsc;
import controller.CompValorDesc;
import model.EducacaoMOD;
import model.Model;


public class Facade {

    static Model mod = new Model();
    
    public static List<EducacaoMOD> exibirDados(String link, Boolean organizar, String campo, String ordem) throws JSONException
    {
    	mod = mod.getInstance();
    	//System.out.println(organizar + " " + link + " " + campo +" "+ ordem);
    	ObjectSet<EducacaoMOD> retorno = mod.getData(link);
        for(EducacaoMOD e : retorno)
        	mod.l.add(e);
		if(organizar.equals(true))
		{
			if(ordem == "Asc")
			{
				if(campo == "Ano")
				{
			        mod.setOrdenacao(new CompAnoAsc());
			        mod.fazerOrdenacao();	
				}
					
				
				if(campo == "Estado")
				{
			        mod.setOrdenacao(new CompEstadoAsc());
			        mod.fazerOrdenacao();
				}
				else
				{
			        mod.setOrdenacao(new CompValorAsc());
			        mod.fazerOrdenacao();
				}
			}
			else
			{
				if(campo == "Ano")
				{
					mod.setOrdenacao(new CompAnoDesc());
					mod.fazerOrdenacao();
				}
				if(campo == "Estado")
				{
					mod.setOrdenacao(new CompEstadoDesc());
					mod.fazerOrdenacao();
				}
				else
				{
					mod.setOrdenacao(new CompValorDesc());
					mod.fazerOrdenacao();
				}
			}  
			//exibirLista(mod.l);
			return mod.l;
		}
		else
		{
			//exibirLista(mod.l);
			return mod.l;
		}	
    }
}
