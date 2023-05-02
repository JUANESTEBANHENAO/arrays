import javax.swing.JOptionPane;

public class Procesos {
	String nom[];
	int años[];
	public void iniciar() {
		String menu = "Menu\n";
		menu+="1. Nombre y edad de los estudiantes \n";
		menu+="2. ver promedio de las edades \n";
		menu+="3. ver los estudiantes con mayor y menor edad \n";
		menu+="4. ver estudiantes mayores de edad y menores de edad \n";
		menu+="5. ver estudiantes \n";
		menu+="6. Buscar Estudiantes\n";
		menu+="7. Salir \n";
		menu+="seleccione alguna opcion";
		int select;
		String nomEdad;
		do {
			select = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (select) {
			case 1:
			
				Datos();
				break;
			case 2:

				if (examinar(nom))
					promedioaños();
				break;
			case 3:

				if (examinar(nom))
					
					mayoresYmenores(años);
				break;
			case 4:

				if (examinar(nom))
				mayorEdad(nom);
				break;
			case 5:

				if (examinar(nom))
				enseñar(nom);
				break;
			
			case 6:
				if (examinar(nom)) {
					nomEdad = JOptionPane.showInputDialog("¿desea buscar por nombre o por edad?");


							if (nomEdad.equalsIgnoreCase("edad")) 
								EdadBuscar(nom);

							else if (nomEdad.equalsIgnoreCase("nombre"))						
								BxNombre(nom);

							else 
								System.out.println("ingrese un valor valido");
					}
				break;
			case 7: 
				System.out.println("adios");
				break;
			default:

				System.out.println("ingrese una opcion valida");
				break;
			}
		} while (select!=7);
		
	}
	
	
	

	public void Datos () {
		int cant = Integer.parseInt(JOptionPane.showInputDialog(
				"ingrese el numero de estudiantes"
				));
		nom = new String[cant];
		años = new int[cant];
		for (int i = 0; i < nom.length; i++) {
			nom[i] = JOptionPane.showInputDialog(
					"ingrese el nombre del estudiante  "+(i+1)

					);
			años[i] = Integer.parseInt(JOptionPane.showInputDialog(
					"ingrese la edad de " + nom[i])
					);
		}
	}

	public boolean examinar (String[] a) {
		
		if (a==null) {
			System.out.println("debe ingresar los estudiantes");
			return false;
			
		} else {
			return true;
		}
	}

	
	public void mayorEdad (String[] a) {
		for(int i = 0; i<años.length; i++) {
			if(años[i] >= 18)
			System.out.print(a[i] + " - ");
		}
		System.out.println("son mayores de edad");
		for(int i = 0; i<años.length; i++) {
			if(años[i] < 18)

			System.out.print(a[i] + " - ");
		}
		System.out.println("son menores de edad");
	}

	public void promedioaños () {
		int sum = 0;

		for(int obj: años) {
			sum+=obj;
		}
		System.out.println("el promedio de las edades es " + sum/años.length);
	}








	public void enseñar (String[] a) {
		double edadProm = 0;

		for (int i = 0; i < a.length; i++) {
			System.out.print('('+a[i] + " | y su edad es " +años[i] + ") --- ");
			edadProm+=años[i];
		}
		System.out.println();
	}
	






	public void EdadBuscar (String[] a) {
		int edad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad del estudiante"));
		int contrario = 0;
		for (int i = 0; i < a.length; i++) {
			if(años[i] == edad) {
				System.out.println("encontre un estudiante con la edad de " + edad + " llamado " + a[i] + " en la posicion " + i);
				contrario++;
			}
		}
			if (contrario == 0)
				System.out.println("no habia nadie con " + edad + " años");
			else {
				System.out.println("en total habian " + contrario + " estudiantes con la edad de " + edad);
			}
	}
	
	public void BxNombre (String[] a) {
		String buscar = JOptionPane.showInputDialog("ingrese el nombre a buscar");
		int contrario = -1;

		int tiempoContrario = 0;
		for (String string : a) {
			contrario++;
			if (string.equalsIgnoreCase(buscar)) {
				tiempoContrario++;
				System.out.print("encontre un " + buscar + " en la posicion " + contrario + 
						" - edad: " + años[contrario]);
				System.out.println();
			}
		}

		if (tiempoContrario == 0)
		System.out.println("no habia nadie llamado " + buscar);
		else {
			System.out.println("en total habian " + tiempoContrario + " estudiantes llamados " + buscar);
		}
	}

	public void mayoresYmenores(int[] a) {
		int smaller = a[0],elderly = a[0];

		String smallerNames = "",elderlyNames = "";
		for(int el: a) {
			if(el>elderly) {
				elderly=el;
			}
			if (el<smaller) {
				smaller=el;
			}
		}
		for(int el = 0; el<a.length; el++) {
			if (a[el] == smaller) {
				smallerNames += nom[el] + " ";
			} else if (a[el] == elderly) {
				elderlyNames += nom[el] + " ";
			}
		}
	System.out.println("los estudiantes mayores son " + elderlyNames + " y los menores son " + smallerNames);
	}

}