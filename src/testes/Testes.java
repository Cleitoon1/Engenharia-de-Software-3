package testes;
import org.junit.Assert;
import org.junit.Test;

import model.Avaliacao;
import model.EducacaoMOD;

import static org.mockito.Mockito.*;
public class Testes {

	@Test
	public void mockitoIDEBPrivado() {
		Avaliacao avaliacao = new Avaliacao();
		
		model.EducacaoMOD educacaoMOD = mock(EducacaoMOD.class);
		when(educacaoMOD.getValor()).thenReturn(7.0);		
		Assert.assertEquals("Estado com nota aprovada", avaliacao.avaliarIDEBPrivado(educacaoMOD));
		//Não passa
		//Assert.assertEquals("Estado com média abaixo", avaliacao.avaliarIDEBPrivado(educacaoMOD));
		
		//Não passa
		when(educacaoMOD.getValor()).thenReturn(5.0);		
		//Assert.assertEquals("Estado com nota aprovada", avaliacao.avaliarIDEBPrivado(educacaoMOD));
		Assert.assertEquals("Estado com média abaixo", avaliacao.avaliarIDEBPrivado(educacaoMOD));
	}
	
	@Test
	public void mockitoIDEBPublico() {
		Avaliacao avaliacao = new Avaliacao();
		
		model.EducacaoMOD educacaoMOD = mock(EducacaoMOD.class);
		when(educacaoMOD.getValor()).thenReturn(5.0);		
		Assert.assertEquals("Estado com nota aprovada", avaliacao.avaliarIDEBPrivado(educacaoMOD));
		//Não passa
		//Assert.assertEquals("Estado com média abaixo", avaliacao.avaliarIDEBPrivado(educacaoMOD));
		
		//Não passa
		when(educacaoMOD.getValor()).thenReturn(2.0);		
		//Assert.assertEquals("Estado com nota aprovada", avaliacao.avaliarIDEBPrivado(educacaoMOD));
		Assert.assertEquals("Estado com média abaixo", avaliacao.avaliarIDEBPrivado(educacaoMOD));
	}
}
