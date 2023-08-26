package ar.unlam.pb2.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaSistema {

	@Test
	public void queSePuedaCrearUnSistema() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2";
		int cantidadMaximaDeUsuarios = 75;
		
		// Ejecuci�n
		Sistema nuevo = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
				
		// Validaci�n (Resultado)
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaAgregarUnUsuario() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosEsperada = 1;
		boolean resultadoDeEjecucion;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario nuevo = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(nuevo);
						
		// Validaci�n (Resultado)
		assertTrue(resultadoDeEjecucion);
	}
	
	@Test
	public void queNoSePuedaAgregarUnUsuarioExistente() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "mPerrone", passwordDeUsuario2 = "mPerrone1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21;
		boolean resultadoDeEjecucion;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
						
		// Validaci�n (Resultado)
		assertFalse(resultadoDeEjecucion);
	}
	
	@Test
	public void queNoSePuedaAgregarMasUsuariosQueLaCapacidadMaximaDeUsuarios() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone1", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "mPerrone2", passwordDeUsuario2 = "mPerrone2", nombreDeUsuario3 = "mPerrone3", passwordDeUsuario3 = "mPerrone3";
		int cantidadMaximaDeUsuarios = 2, edadUsuario1 = 21;
		boolean resultadoDeEjecucion;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
		Usuario usuario3 = new Usuario(nombreDeUsuario3, passwordDeUsuario3, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario3);
		
		// Validaci�n (Resultado)
		assertFalse(resultadoDeEjecucion);
	}
	
	@Test
	public void queSePuedanAgregarDosUsuarios() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "jCaldas", passwordDeUsuario2 = "jCaldas";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, edadUsuario2 = 20, cantidadDeUsuariosEsperada = 2;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario2);
		boolean resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
						
		// Validaci�n (Resultado)
		assertTrue(resultadoDeEjecucion);
		assertEquals(cantidadDeUsuariosEsperada, actual.getCantidadDeUsuarios());
		assertNotNull(actual.buscar(nombreDeUsuario1));
		assertNotNull(actual.buscar(nombreDeUsuario2));
	}
	
	@Test
	public void queSePuedaBuscarUnUsuario() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosEsperada = 1;
		boolean resultadoDeEjecucion;
		Usuario buscado = null;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario nuevo = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(nuevo);
		buscado = actual.buscar(nombreDeUsuario1);
		
		// Validaci�n (Resultado)
		assertNotNull(buscado);
	}
	
	@Test
	public void queUnUsuarioSePuedaLoguearCorrectamente() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21;
		boolean resultadoDelLogin = false;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordDeUsuario1); 
						
		// Validaci�n (Resultado)
		assertTrue(resultadoDelLogin);
	}
	
	@Test
	public void queUnUsuarioNoSePuedaLoguearConUnPasswordInvalido() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCabrera", passwordDeUsuario1 = "mCabrera1", passwordIngresadaEnElLogin = "mCabrera2";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21;
		boolean resultadoDelLogin = false;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordIngresadaEnElLogin); 
						
		// Validaci�n (Resultado)
		assertFalse(resultadoDelLogin);
	}
	
	@Test
	public void queLaCantidadDeUsuariosLogueadosSea1() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosLogueadosEsperados = 1;
		boolean resultadoDelLogin = false;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordDeUsuario1); 
						
		// Validaci�n (Resultado)
		assertEquals(cantidadDeUsuariosLogueadosEsperados, actual.calcularLaCantidadDeUsuariosLogueados());
	}
	
	@Test
	public void queUnUsuarioSePuedaDesloguear() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosLogueadosEsperados = 0;
		boolean resultadoDelLogin = false;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordDeUsuario1); 
		usuario1.desloguear();
						
		// Validaci�n (Resultado)
		assertEquals(cantidadDeUsuariosLogueadosEsperados, actual.calcularLaCantidadDeUsuariosLogueados());
		assertFalse(usuario1.isLogueado());
	}
	
	@Test
	public void queUnUsuarioSeBloqueeAlIngresar4VecesMalSuPassword() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1", passwordInvalido = "bocacaca";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosLogueadosEsperados = 0;
		boolean resultadoDelLogin = false;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
						
		// Validaci�n (Resultado)
		assertTrue(usuario1.isBloqueado());
	}
	
	@Test
	public void queSeCalculeCorrectamenteLaEdadPromedioDeLosUsuarios() {
		// Preparaci�n (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone1", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "mPerrone2", passwordDeUsuario2 = "mPerrone2", nombreDeUsuario3 = "mPerrone3", passwordDeUsuario3 = "mPerrone3";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 20, edadUsuario2 = 21, edadUsuario3 = 20;
		boolean resultadoDeEjecucion;
		Double edadPromedioEsperada = 20.33;
				
		// Ejecuci�n
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario2);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
		Usuario usuario3 = new Usuario(nombreDeUsuario3, passwordDeUsuario3, edadUsuario3);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario3);
		
		// Validaci�n (Resultado)
		assertEquals(edadPromedioEsperada, actual.calcularLaEdadPromedio(), 0.01);
	}

}
