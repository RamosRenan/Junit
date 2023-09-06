package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.utfpr.Craps;
import com.utfpr.Dado;

public class TestCraps 
{
	@Test
	public void testeRolarDados_1()
	{
		Dado dado  = Mockito.mock(Dado.class);
		
		Mockito.when(dado.rolar()).thenReturn(1);
		
		Craps craps =  new Craps();
		
		craps.setDado(dado);
		
		craps.rolarDados();
		
		assertTrue(craps.isFimDeJogo());
		
		assertEquals(2, craps.getVencedor());
	}
	
	@Test
	public void testRolarDados_2()
	{
		Dado dadoMock = Mockito.mock(Dado.class);
		
		Mockito.when(dadoMock.rolar()).thenReturn(5, 2);
		
		Craps craps = new Craps();
		
		craps.setDado(dadoMock);
		
		craps.rolarDados();
		
		assertTrue(craps.isFimDeJogo());
		
		assertEquals(1, craps.getVencedor());
	}
	
	@Test
	public void testRolarDados_3(){
		Dado dadoMock = Mockito.mock(Dado.class);
		
		Craps craps = new Craps();
		
		craps.setDado(dadoMock);
		
		Mockito.when(dadoMock.rolar()).thenReturn(3, 5);
		
		craps.rolarDados();
		
		assertFalse(craps.isFimDeJogo());
		
		Mockito.when(dadoMock.rolar()).thenReturn(6, 5);
		
		craps.rolarDados();
		assertFalse(craps.isFimDeJogo());
		
		Mockito.when(dadoMock.rolar()).thenReturn(5, 2);
		
		craps.rolarDados();
		
		assertTrue(craps.isFimDeJogo());
		
		assertEquals(2, craps.getVencedor());
	}
	
	@Test
	public void testRolarDados_4(){
		Dado dadoMock = Mockito.mock(Dado.class);
		
		Craps craps = new Craps();
		
		craps.setDado(dadoMock);
		
		Mockito.when(dadoMock.rolar()).thenReturn(1, 3);
		
		craps.rolarDados();
		
		assertFalse(craps.isFimDeJogo());
		
		Mockito.when(dadoMock.rolar()).thenReturn(2, 2);
		
		craps.rolarDados();
		
		assertTrue(craps.isFimDeJogo());
		
		assertEquals(1, craps.getVencedor());
	}
}
