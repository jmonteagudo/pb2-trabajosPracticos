package ar.unlam.pb2.ejercicio04;

import java.util.Scanner;

public class MainSistema {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcionIngresada = 0;
		Sistema actual = new Sistema ("Sistema de alumnos de PB2", 75);
		
		do {
			System.out.println("1 - Ingresar usuario");
			System.out.println("2 - Loguear usuario");
			System.out.println("3 - Desloguear usuario");
			System.out.println("4 - Ver la cantidad de usuarios logueados");
			System.out.println("5 - Ver la cantidad de usuarios bloqueados");
			System.out.println("6 - Ver el promedio de edad");
			System.out.println("9 - Salir");
			opcionIngresada = teclado.nextInt();
			switch(opcionIngresada) {
			case 1:
				ingresarUsuario(teclado, actual);
				break;
			case 2:
				login(teclado, actual);
				break;
			case 3:
				desloguear(teclado, actual);
				break;
			case 4:
				System.out.println("La cantidad de usuarios logueados es:");
				System.out.println(actual.calcularLaCantidadDeUsuariosLogueados());
				break;
			case 5:
				System.out.println("La cantidad de usuarios bloqueados es:");
				System.out.println(actual.calcularLaCantidadDeUsuariosBloqueados());
				break;
			case 6:
				System.out.println("El promedio de edad es:");
				System.out.println(actual.calcularLaEdadPromedio());
				break;
			case 9:
				break;
			default: 
				System.out.println("Opción inválida");
			}
				
		} while(opcionIngresada!=9);

	}

	private static void desloguear(Scanner teclado, Sistema actual) {
		System.out.println("Ingrese el usuario");
		String nombre = teclado.next();
		Usuario buscado = actual.buscar(nombre);
		if(buscado!=null) {
			buscado.desloguear();	
		}
	}

	private static void login(Scanner teclado, Sistema actual) {
		String nombre, password;
		System.out.println("Ingrese el nombre");
		nombre = teclado.next();
		System.out.println("Ingrese el password");
		password = teclado.next();
		if(actual.login(nombre, password)) {
			System.out.println("Se logueo correctamente");
		}
		else {
			System.out.println("Usuario o password invalida");
		}
	}

	private static void ingresarUsuario(Scanner teclado, Sistema actual) {
		Usuario nuevo;
		String nombre, password;
		int edad;
		System.out.println("Ingrese el nombre");
		nombre = teclado.next();
		System.out.println("Ingrese el password");
		password = teclado.next();
		System.out.println("Ingrese la edad");
		edad = teclado.nextInt();
		nuevo = new Usuario(nombre, password, edad);
		actual.ingresarUsuario(nuevo);
	}

}
