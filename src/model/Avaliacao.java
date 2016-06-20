package model;

public class Avaliacao {
	public String avaliarIDEBPrivado(EducacaoMOD nota)
	{
		if(nota.getValor() >= 7)
			return "Estado com nota aprovada";
		else
			return "Estado com média abaixo";
	}
	
	public String avaliarIDEBPublico(EducacaoMOD nota)
	{
		if(nota.getValor() >= 5)
			return "Estado com nota aprovada";
		else
			return "Estado com média abaixo";
	}
}
