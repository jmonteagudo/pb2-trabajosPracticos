package ar.edu.unlam.pb2.ejercicio03;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEquipoDeFutbol {

	@Test
	public void queSePuedaAgregarUnJugador() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador = "Enzo";
		int numeroDelJugador = 1, edadDelJugador = 33;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		Jugador nuevoJugador = new Jugador(numeroDelJugador, nombreJugador, edadDelJugador, precio);
		resultado = nuevoEquipo.agregarJugador(nuevoJugador);
		
		// Validaci�n (Resultado)
		assertTrue(resultado);
	}
	
	@Test
	public void queNoSePuedaAgregarUnJugadorSiElNumeroYaExiste() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Armani";
		int numeroDelJugador1 = 1, numeroJugador2 = 1, edadDelJugador1 = 33, edadDelJugador2 = 33;
		double precio1 = 1000.0, precio2 = 100.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		Jugador nuevoJugador = new Jugador(numeroDelJugador1, nombreJugador1, edadDelJugador1, precio1);
		resultado = nuevoEquipo.agregarJugador(nuevoJugador);
		nuevoJugador = new Jugador(numeroJugador2, nombreJugador2, edadDelJugador2, precio2);
		resultado = nuevoEquipo.agregarJugador(nuevoJugador);
		
		// Validaci�n (Resultado)
		assertFalse(resultado);
	}
	
	@Test
	public void queNoSePuedaAgregarUnJugadorSiElNombreYaExiste() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Enzo";
		int numeroDelJugador1 = 1, numeroJugador2 = 3, edadDelJugador1 = 33, edadDelJugador2 = 33;
		double precio1 = 1000.0, precio2 = 100.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		Jugador nuevoJugador = new Jugador(numeroDelJugador1, nombreJugador1, edadDelJugador1, precio1);
		resultado = nuevoEquipo.agregarJugador(nuevoJugador);
		nuevoJugador = new Jugador(numeroJugador2, nombreJugador2, edadDelJugador2, precio2);
		resultado = nuevoEquipo.agregarJugador(nuevoJugador);
		
		// Validaci�n (Resultado)
		assertFalse(resultado);
	}
	
	@Test
	public void queNoSePuedaAgregarUnJugadorSiElEquipoEstaCompleto() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Maidana", nombreJugador3 = "Milton", nombreJugador4 = "Barco", nombreJugador5 = "Ponzio", nombreJugador6 = "Monteagudo";
		int numeroDelJugador1 = 1, numeroDelJugador2 = 2, numeroDelJugador3 = 3, numeroDelJugador4 = 4, numeroDelJugador5 = 5, numeroDelJugador6 = 6, edad = 33;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador1, nombreJugador1, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador2, nombreJugador2, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador3, nombreJugador3, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador4, nombreJugador4, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador5, nombreJugador5, edad, precio));
		
		resultado = nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador6, nombreJugador6, edad, precio));
		
		// Validaci�n (Resultado)
		assertFalse(resultado);
	}
	
	@Test
	public void queSeEncuentreUnJugadorPorSuNumero() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Maidana", nombreJugador3 = "Milton", nombreJugador4 = "Barco", nombreJugador5 = "Ponzio";
		int numeroDelJugador1 = 1, numeroDelJugador2 = 2, numeroDelJugador3 = 3, numeroDelJugador4 = 4, numeroDelJugador5 = 5, edad = 33, numeroBuscado = 3;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador1, nombreJugador1, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador2, nombreJugador2, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador3, nombreJugador3, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador4, nombreJugador4, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador5, nombreJugador5, edad, precio));
		
		Jugador jugadorEsperado = nuevoEquipo.buscar(numeroBuscado);
		
		// Validaci�n (Resultado)
		assertNotNull(jugadorEsperado);
	}
	
	@Test
	public void queNoSeEncuentreUnJugadorSiElNumeroNoEstaEnElEquipo() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Maidana", nombreJugador3 = "Milton", nombreJugador4 = "Barco", nombreJugador5 = "Ponzio";
		int numeroDelJugador1 = 1, numeroDelJugador2 = 2, numeroDelJugador3 = 3, numeroDelJugador4 = 4, numeroDelJugador5 = 5, edad = 33, numeroBuscado = 6;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador1, nombreJugador1, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador2, nombreJugador2, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador3, nombreJugador3, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador4, nombreJugador4, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador5, nombreJugador5, edad, precio));
		
		Jugador jugadorEsperado = nuevoEquipo.buscar(numeroBuscado);
		
		// Validaci�n (Resultado)
		assertNull(jugadorEsperado);
	}
	
	@Test
	public void queSeEncuentreUnJugadorPorSuNombre() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Maidana", nombreJugador3 = "Milton", nombreJugador4 = "Barco", nombreJugador5 = "Ponzio", nombreBuscado = "Milton";
		int numeroDelJugador1 = 1, numeroDelJugador2 = 2, numeroDelJugador3 = 3, numeroDelJugador4 = 4, numeroDelJugador5 = 5, edad = 33;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador1, nombreJugador1, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador2, nombreJugador2, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador3, nombreJugador3, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador4, nombreJugador4, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador5, nombreJugador5, edad, precio));
		
		Jugador jugadorEsperado = nuevoEquipo.buscar(nombreBuscado);
		
		// Validaci�n (Resultado)
		assertNotNull(jugadorEsperado);
	}
	
	@Test
	public void queNoSeEncuentreUnJugadorSiElNombreNoEstaEnElEquipo() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Maidana", nombreJugador3 = "Milton", nombreJugador4 = "Barco", nombreJugador5 = "Ponzio", nombreBuscado = "Monteagudo";
		int numeroDelJugador1 = 1, numeroDelJugador2 = 2, numeroDelJugador3 = 3, numeroDelJugador4 = 4, numeroDelJugador5 = 5, edad = 33;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador1, nombreJugador1, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador2, nombreJugador2, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador3, nombreJugador3, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador4, nombreJugador4, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador5, nombreJugador5, edad, precio));
		
		Jugador jugadorEsperado = nuevoEquipo.buscar(nombreBuscado);
		
		// Validaci�n (Resultado)
		assertNull(jugadorEsperado);
	}
	
	@Test
	public void queSeEncuentreUnJugadorPorSuObjeto() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Maidana", nombreJugador3 = "Milton", nombreJugador4 = "Barco", nombreJugador5 = "Ponzio", nombreBuscado = "Milton";
		int numeroDelJugador1 = 1, numeroDelJugador2 = 2, numeroDelJugador3 = 3, numeroDelJugador4 = 4, numeroDelJugador5 = 5, edad = 33;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		Jugador jugadorEsperado = new Jugador(numeroDelJugador1, nombreJugador1, edad, precio);
		nuevoEquipo.agregarJugador(jugadorEsperado);
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador2, nombreJugador2, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador3, nombreJugador3, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador4, nombreJugador4, edad, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador5, nombreJugador5, edad, precio));
		
		Jugador jugadorEncontrado = nuevoEquipo.buscar(jugadorEsperado);
		
		// Validaci�n (Resultado)
		assertEquals(jugadorEsperado, jugadorEncontrado);
	}
	
	@Test
	public void queSeCalculeCorrectamenteLaEdadPromedioDelEquipo() {
		// Preparaci�n (Datos de entrada)
		String nombreDelEquipo = "River", nombreJugador1 = "Enzo", nombreJugador2 = "Maidana", nombreJugador3 = "Milton";
		int numeroDelJugador1 = 1, numeroDelJugador2 = 2, numeroDelJugador3 = 3, edad1 = 34, edad2 = 38, edad3 = 22;
		Double edadPromedioEsperada = 31.33;
		double precio = 1000.0;
		boolean resultado = false;
		
		// Ejecuci�n 
		EquipoDeFutbol nuevoEquipo = new EquipoDeFutbol(nombreDelEquipo);
		
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador1, nombreJugador1, edad1, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador2, nombreJugador2, edad2, precio));
		nuevoEquipo.agregarJugador(new Jugador(numeroDelJugador3, nombreJugador3, edad3, precio));
		
		Double edadPromedioCalculada = nuevoEquipo.calcularLaEdadPromedioDelEquipo();
		
		// Validaci�n (Resultado)
		assertEquals(edadPromedioEsperada, edadPromedioCalculada, 0.01);
	}

}
