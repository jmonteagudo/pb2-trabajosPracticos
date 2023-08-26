package ar.unlam.pb2.ejercicio04;

public class Usuario {

	private String nombre;
	private String password;
	private int edad;
	private boolean logueado;
	//private boolean bloqueado;
	private int cantidadDeIntentosFallidos;
	private final int CANTIDAD_DE_INTENTOS_DE_LOGIN_MAXIMOS_PERMITIDOS;
	
	public Usuario(String nombre, String password, int edad) {
		this.nombre = nombre;
		this.password = password;
		this.edad = edad;
		this.logueado = false;
		this.cantidadDeIntentosFallidos = 0;
		CANTIDAD_DE_INTENTOS_DE_LOGIN_MAXIMOS_PERMITIDOS = 3;
	}
	
	public boolean loguear(String nombre, String password){
				
		if(this.nombre.equals(nombre) && this.password.equals(password)) {
			logueado = true;
		}
		else {
			cantidadDeIntentosFallidos++;
		}
		return logueado;
	}
	
	public boolean isBloqueado() {
		if(cantidadDeIntentosFallidos>CANTIDAD_DE_INTENTOS_DE_LOGIN_MAXIMOS_PERMITIDOS) {
			return true;
		}
		return false;
	}
	
	public void desloguear() {
		this.logueado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}
}
