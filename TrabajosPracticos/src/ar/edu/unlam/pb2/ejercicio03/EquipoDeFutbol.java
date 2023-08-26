package ar.edu.unlam.pb2.ejercicio03;

import java.util.Arrays;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadores[];
	private final Integer CANTIDAD_MAXIMA_DE_JUGADORES = 5;
	
	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		jugadores = new Jugador[CANTIDAD_MAXIMA_DE_JUGADORES];
	}

	/*
	 * La capacidad máxima de un equipo es 5. No se permiten jugadores repetidos (ya sea el número o nombre del jugador)
	 * Se retorna el resultado de la operación
	 */
	public boolean agregarJugador(Jugador nuevo) {
		Jugador buscadoPorNumero = buscar(nuevo.getNumero());
		Jugador buscadoPorNombre = buscar(nuevo.getNombre());
		
		if(buscadoPorNumero!=null || buscadoPorNombre!=null) {
			return false;
		}
		
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] == null) {
				jugadores[i] = nuevo;
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		Jugador buscado = null;
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null && jugadores[i].getNumero()==numero) {
				buscado = jugadores[i];
				return buscado;
			}
		}
		return buscado;
	}
	
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		Jugador buscado = null;
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null && jugadores[i].getNombre().equals(nombre)) {
				buscado = jugadores[i];
				return buscado;
			}
		}
		return buscado;
	}
	
	public Jugador buscar(Jugador aBuscar) {
		Jugador buscado = null;
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null && jugadores[i] == aBuscar) {
				buscado = jugadores[i];
				return buscado;
			}
		}
		return buscado;
	}
	
	/*
	 * Calcula la edad promedio. 
	 * 
	 */
	public Double calcularLaEdadPromedioDelEquipo() {
		int sumatoriaEdad = 0, cantidadDeJugadores = 0;
		double promedioDeEdad = 0.0;
		
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null ) {
				sumatoriaEdad+=jugadores[i].getEdad();
				cantidadDeJugadores++;
			}
		}
		promedioDeEdad = (double)sumatoriaEdad/cantidadDeJugadores;
		return promedioDeEdad;
	}
	
	/*
	 * Calcula el valor del equipo
	 * 
	 */
	public double calcularElValorDelEquipo() {
		double elValorDelEquipo = 0.0;
		
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null ) {
				elValorDelEquipo+=jugadores[i].getPrecio();
			}
		}
		
		return elValorDelEquipo;
	}

	@Override
	public String toString() {
		return "EquipoDeFutbol [nombre=" + nombre + ", jugadores=" + Arrays.toString(jugadores) + "]";
	}
	
}
