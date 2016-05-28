package model;
public class EducacaoMOD {
	private String estado; 
	private int ano;
	private double valor;
	public EducacaoMOD(String estado, int ano, double valor) {
		this.estado = estado;
		this.ano = ano; 
		this.valor = valor;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}			
}
