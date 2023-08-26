package ar.unlam.pb2.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaSistema {

	@Test
	public void queSePuedaCrearUnSistema() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2";
		int cantidadMaximaDeUsuarios = 75;
		
		// Ejecución
		Sistema nuevo = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
				
		// Validación (Resultado)
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaAgregarUnUsuario() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosEsperada = 1;
		boolean resultadoDeEjecucion;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario nuevo = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(nuevo);
						
		// Validación (Resultado)
		assertTrue(resultadoDeEjecucion);
	}
	
	@Test
	public void queNoSePuedaAgregarUnUsuarioExistente() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "mPerrone", passwordDeUsuario2 = "mPerrone1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21;
		boolean resultadoDeEjecucion;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
						
		// Validación (Resultado)
		assertFalse(resultadoDeEjecucion);
	}
	
	@Test
	public void queNoSePuedaAgregarMasUsuariosQueLaCapacidadMaximaDeUsuarios() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone1", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "mPerrone2", passwordDeUsuario2 = "mPerrone2", nombreDeUsuario3 = "mPerrone3", passwordDeUsuario3 = "mPerrone3";
		int cantidadMaximaDeUsuarios = 2, edadUsuario1 = 21;
		boolean resultadoDeEjecucion;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
		Usuario usuario3 = new Usuario(nombreDeUsuario3, passwordDeUsuario3, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario3);
		
		// Validación (Resultado)
		assertFalse(resultadoDeEjecucion);
	}
	
	@Test
	public void queSePuedanAgregarDosUsuarios() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "jCaldas", passwordDeUsuario2 = "jCaldas";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, edadUsuario2 = 20, cantidadDeUsuariosEsperada = 2;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario2);
		boolean resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
						
		// Validación (Resultado)
		assertTrue(resultadoDeEjecucion);
		assertEquals(cantidadDeUsuariosEsperada, actual.getCantidadDeUsuarios());
		assertNotNull(actual.buscar(nombreDeUsuario1));
		assertNotNull(actual.buscar(nombreDeUsuario2));
	}
	
	@Test
	public void queSePuedaBuscarUnUsuario() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone", passwordDeUsuario1 = "mPerrone1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosEsperada = 1;
		boolean resultadoDeEjecucion;
		Usuario buscado = null;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario nuevo = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(nuevo);
		buscado = actual.buscar(nombreDeUsuario1);
		
		// Validación (Resultado)
		assertNotNull(buscado);
	}
	
	@Test
	public void queUnUsuarioSePuedaLoguearCorrectamente() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21;
		boolean resultadoDelLogin = false;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordDeUsuario1); 
						
		// Validación (Resultado)
		assertTrue(resultadoDelLogin);
	}
	
	@Test
	public void queUnUsuarioNoSePuedaLoguearConUnPasswordInvalido() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCabrera", passwordDeUsuario1 = "mCabrera1", passwordIngresadaEnElLogin = "mCabrera2";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21;
		boolean resultadoDelLogin = false;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordIngresadaEnElLogin); 
						
		// Validación (Resultado)
		assertFalse(resultadoDelLogin);
	}
	
	@Test
	public void queLaCantidadDeUsuariosLogueadosSea1() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosLogueadosEsperados = 1;
		boolean resultadoDelLogin = false;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordDeUsuario1); 
						
		// Validación (Resultado)
		assertEquals(cantidadDeUsuariosLogueadosEsperados, actual.calcularLaCantidadDeUsuariosLogueados());
	}
	
	@Test
	public void queUnUsuarioSePuedaDesloguear() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosLogueadosEsperados = 0;
		boolean resultadoDelLogin = false;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordDeUsuario1); 
		usuario1.desloguear();
						
		// Validación (Resultado)
		assertEquals(cantidadDeUsuariosLogueadosEsperados, actual.calcularLaCantidadDeUsuariosLogueados());
		assertFalse(usuario1.isLogueado());
	}
	
	@Test
	public void queUnUsuarioSeBloqueeAlIngresar4VecesMalSuPassword() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mCastelli", passwordDeUsuario1 = "mCastelli1", passwordInvalido = "bocacaca";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 21, cantidadDeUsuariosLogueadosEsperados = 0;
		boolean resultadoDelLogin = false;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		actual.ingresarUsuario(usuario1);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
		resultadoDelLogin = actual.login(nombreDeUsuario1, passwordInvalido);
						
		// Validación (Resultado)
		assertTrue(usuario1.isBloqueado());
	}
	
	@Test
	public void queSeCalculeCorrectamenteLaEdadPromedioDeLosUsuarios() {
		// Preparación (Datos de entrada)
		String nombreDelSistema = "Sistema de PB2", nombreDeUsuario1 = "mPerrone1", passwordDeUsuario1 = "mPerrone1", nombreDeUsuario2 = "mPerrone2", passwordDeUsuario2 = "mPerrone2", nombreDeUsuario3 = "mPerrone3", passwordDeUsuario3 = "mPerrone3";
		int cantidadMaximaDeUsuarios = 75, edadUsuario1 = 20, edadUsuario2 = 21, edadUsuario3 = 20;
		boolean resultadoDeEjecucion;
		Double edadPromedioEsperada = 20.33;
				
		// Ejecución
		Sistema actual = new Sistema(nombreDelSistema, cantidadMaximaDeUsuarios);
		Usuario usuario1 = new Usuario(nombreDeUsuario1, passwordDeUsuario1, edadUsuario1);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario1);
		Usuario usuario2 = new Usuario(nombreDeUsuario2, passwordDeUsuario2, edadUsuario2);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario2);
		Usuario usuario3 = new Usuario(nombreDeUsuario3, passwordDeUsuario3, edadUsuario3);
		resultadoDeEjecucion = actual.ingresarUsuario(usuario3);
		
		// Validación (Resultado)
		assertEquals(edadPromedioEsperada, actual.calcularLaEdadPromedio(), 0.01);
	}

}
