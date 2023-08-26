package ar.unlam.pb2.ejercicio04;

public class Sistema {

	private String nombreDelSistema;
	private Usuario usuarios[];
	
	public Sistema(String nombreDelSistema, int cantidadMaximaDeUsuarios) {
		this.nombreDelSistema = nombreDelSistema;
		this.usuarios = new Usuario[cantidadMaximaDeUsuarios]; // Instanciación
	}
	
	public boolean ingresarUsuario(Usuario nuevo) {
		boolean resultado = false;
		Usuario existe = buscar(nuevo.getNombre());
		
		if(existe==null) {
			for(int i=0; i<usuarios.length; i++) {
				if(usuarios[i]==null) {
					usuarios[i] = nuevo;
					resultado = true;
					return resultado;
				}
			}
		}

		return resultado;
	}
	
	public Usuario buscar(String nombre) {
		Usuario buscado = null;
		for(int i=0; i<usuarios.length; i++) {
			if(usuarios[i]!=null && usuarios[i].getNombre().equals(nombre)) {
				buscado = usuarios[i];
				return buscado;
			}
		}
		return buscado;
	}
	
	public boolean login(String usuario, String password) {
		Usuario buscado = buscar(usuario);
		boolean resultado = false;
		if(buscado != null) {
			resultado = buscado.loguear(usuario, password);
		}
		return resultado;
	}
	
	public int getCantidadDeUsuarios() {
		int cantidadDeUsuarios = 0;
		for(int i=0; i<usuarios.length; i++) {
			if(usuarios[i]!=null) {
				cantidadDeUsuarios++;
			}
		}
		return cantidadDeUsuarios;
	}
	
	public int calcularLaCantidadDeUsuariosLogueados() {
		int cantidadDeUsuariosLogueados = 0;
		for(int i=0; i<usuarios.length; i++) {
			if(usuarios[i]!=null && usuarios[i].isLogueado()) {
				cantidadDeUsuariosLogueados++;
			}
		}
		return cantidadDeUsuariosLogueados;
	}
	
	public int calcularLaCantidadDeUsuariosBloqueados() {
		int cantidadDeUsuariosBloqueados = 0;
		for(int i=0; i<usuarios.length; i++) {
			if(usuarios[i]!=null && usuarios[i].isBloqueado()) {
				cantidadDeUsuariosBloqueados++;
			}
		}
		return cantidadDeUsuariosBloqueados;
	}
	
	public Double calcularLaEdadPromedio() {
		int sumatoriaDeEdad = 0, contadorUsuarios = 0;
		double promedioDeEdad = 0.0;
		for(int i=0; i<usuarios.length; i++) {
			if(usuarios[i]!=null) {
				sumatoriaDeEdad+=usuarios[i].getEdad();
				contadorUsuarios++;
			}
		}
		if(contadorUsuarios!=0) {
			promedioDeEdad = (double)sumatoriaDeEdad / contadorUsuarios;	
		}
		
		return promedioDeEdad;
	}
	
	public String getNombreDelSistema() {
		return nombreDelSistema;
	}

	public void setNombreDelSistema(String nombreDelSistema) {
		this.nombreDelSistema = nombreDelSistema;
	}
}
