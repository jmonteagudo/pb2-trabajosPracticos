package ar.edu.unlam.pb2.ejercicio03;

import java.util.Arrays;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amonestados[];
	private Evento expulsados[];
	private int golesDelLocal;
	private int golesDelVisitante;
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		this.goles = new Evento[100];
		this.amonestados = new Evento[20];
		this.expulsados = new Evento[10];
		this.golesDelLocal = 0;
		this.golesDelVisitante = 0;
	}
	
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (según al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabrá a quien contabilizarlo
	 */
	public void marcar(Evento gol) {
		Jugador elJugadorDelEquipoLocal = local.buscar(gol.getAutor());
		
		if(elJugadorDelEquipoLocal!=null && gol.getTipo() == TipoDeEvento.GOL_A_FAVOR) {
			golesDelLocal++;
		}
		else if(elJugadorDelEquipoLocal!=null && gol.getTipo() == TipoDeEvento.GOL_EN_CONTRA) {
			golesDelVisitante++;
		}
		else if(elJugadorDelEquipoLocal==null && gol.getTipo() == TipoDeEvento.GOL_A_FAVOR) {
			golesDelVisitante++;
		}
		else {
			golesDelLocal++;
		}
		
		for(int i=0; i<goles.length; i++) {
			if(goles[i] == null) {
				goles[i] = gol;
			}
		}
	}
	
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya poseía una amonestación previa, se lo debe expulsar. 
	 * El método devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no tenía amonestación previa o 
	 * 2 - Si ya poseía una amonestación previa y termina siendo expulsado
	 * 
	 */
	public int amonestar(Evento amonestado) {
		int cantidadDeAmonestaciones = 0;
		for(int i=0; i<amonestados.length; i++) {
			if(amonestados[i] == null) {
				amonestados[i] = amonestado;
			}
		}
		
		cantidadDeAmonestaciones = calcularLaCantidadDeAmonestaciones(amonestado.getAutor());
		if(cantidadDeAmonestaciones==2) {
			Evento expulsion = new Evento(amonestado.getMinuto(), amonestado.getAutor(), TipoDeEvento.EXPULSION);
			expulsar(expulsion);
		}
		
		return cantidadDeAmonestaciones;
	}
	
	public int calcularLaCantidadDeAmonestaciones(Jugador buscado) {
		int cantidadDeAmonestaciones = 0;
		for(int i=0; i<amonestados.length; i++) {
			if(amonestados[i] != null && amonestados[i].getAutor() == buscado) {
				cantidadDeAmonestaciones++;
			}
		}
		return cantidadDeAmonestaciones;
	}
	
	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {
		for(int i=0; i<expulsados.length; i++) {
			if(expulsados[i] == null) {
				expulsados[i] = expulsado;
			}
		}
	}
	
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol resultó a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		if(golesDelLocal>golesDelVisitante) {
			return local;
		}
		else if(golesDelVisitante>golesDelLocal){
			return visitante;
		}
		else {
			return null;
		}
	}
	
	public EquipoDeFutbol getLocal() {
		return local;
	}

	/*
	 * El método toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
	@Override
	public String toString() {
		return "PartidoDeFutbol [local=" + local + ", visitante=" + visitante + ", goles=" + Arrays.toString(goles)
				+ ", amonestados=" + Arrays.toString(amonestados) + ", expulsados=" + Arrays.toString(expulsados)
				+ ", golesDelLocal=" + golesDelLocal + ", golesDelVisitante=" + golesDelVisitante + "]";
	}

	public EquipoDeFutbol getVisitante() {
		return visitante;
	}

}
