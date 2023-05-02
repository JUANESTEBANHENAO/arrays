import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Procesos2 {
    ArrayList<String> nom;
    ArrayList<Integer> años;

    public void iniciar2() {
        String menu = "Menu\n";
        menu += "1. Nombre y edad de los estudiantes \n";
        menu += "2. ver promedio de las edades \n";
        menu += "3. ver los estudiantes con mayor y menor edad \n";
        menu += "4. ver estudiantes mayores de edad y menores de edad \n";
        menu += "5. ver estudiantes \n";
        menu += "6. Buscar Estudiantes\n";
        menu += "7. Salir \n";
        menu += "Seleccione alguna opción";
        int select;
        String nomEdad;
        do {
            select = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (select) {
                case 1:
                    Datos();
                    break;
                case 2:
                    if (examinar(nom)) {
                        double promedio = promedioaños(años);
                        System.out.println("El promedio de años es de " + promedio);
                    }
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
                        enseñar(nom, años);
                    break;
                case 6:
                    if (examinar(nom)) {
                        nomEdad = JOptionPane.showInputDialog("¿Desea buscar por nombre o por edad?");
                        if (nomEdad.equalsIgnoreCase("edad"))
                            edadBuscar(años, nom);
                        else if (nomEdad.equalsIgnoreCase("nombre"))
                            BxNombre(nom, años);
                        else
                            System.out.println("Ingrese algo válido");
                    }
                    break;
                case 7:
                    System.out.println("Gracias por usarme");
                    break;
                default:
                    System.out.println("Ingrese una opción de menú válida");
                    break;
            }
        } while (select != 7);
    }

    public void Datos() {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
        nom = new ArrayList<String>();
        años = new ArrayList<Integer>();
        for (int i = 0; i < cantidad; i++) {
            nom.add(JOptionPane.showInputDialog("Ingrese el nombre del estudiante número " + (i + 1)));
            años.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de " + nom.get(i))));
        }
    }

    public boolean examinar(ArrayList<String> a) {
        if (a == null) {
            System.out.println("Debe ingresar primero los estudiantes");
            return false;
        } else {
            return true;
        }
    }

    public void mayorEdad(ArrayList<String> a) {
        for (int i = 0; i < años.size(); i++) {
            if (años.get(i) >= 18)
                System.out.print(a.get(i) + " - ");
        }
        System.out.println("Son los estudiantes mayores de edad");
        for (int i = 0; i < años.size(); i++) {
            if (años.get(i) < 18)
                System.out.print(a.get(i) + " - ");
        }
        System.out.println("Son los estudiantes menores de edad");
    }


    public double promedioaños(ArrayList<Integer> a) {
        int sum = 0;
        for (int edad : a) {
            sum += edad;
        }
        return (double) sum / a.size();
    }

    public void enseñar(ArrayList<String> nom, ArrayList<Integer> años) {
        double edadProm = 0;
        for (int i = 0; i < nom.size(); i++) {
            System.out.print("(" + nom.get(i) + " | y su edad es " + años.get(i) + ") --- ");
            edadProm += años.get(i);
        }
        System.out.println();
    }

    public void edadBuscar(ArrayList<Integer> años, ArrayList<String> nom) {
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad por la cual desea buscar los estudiantes"));
        int contrario = 0;
        for (int i = 0; i < años.size(); i++) {
            if (años.get(i) == edad) {
                System.out.println("Encontré un estudiante con la edad de " + edad + " llamado " + nom.get(i) + " en la posición " + i);
                contrario++;
            }
        }
        if (contrario == 0)
            System.out.println("No había nadie con " + edad + " años");
        else {
            System.out.println("En total había " + contrario + " estudiantes con la edad de " + edad);
        }
    }

    public void BxNombre(ArrayList<String> nom, ArrayList<Integer> años) {
        String buscar = JOptionPane.showInputDialog("Ingrese el nombre a buscar");
        int contrario = -1;
        int tiempocontrario = 0;
        for (String nombre : nom) {
            contrario++;
            if (nombre.equalsIgnoreCase(buscar)) {
                tiempocontrario++;
                System.out.println("Encontré un " + buscar + " en la posición " + contrario + " - edad: " + años.get(contrario));
            }
        }
        if (tiempocontrario == 0)
            System.out.println("No había nadie llamado " + buscar);
        else {
            System.out.println("En total había " + tiempocontrario + " estudiantes llamados " + buscar);
        }
    }

    public void mayoresYmenores(ArrayList<Integer> años) {
        int smaller = años.get(0), elderly = años.get(0);
        ArrayList<String> smallerNames = new ArrayList<>();
        ArrayList<String> elderlyNames = new ArrayList<>();
        for (int edad : años) {
            if (edad > elderly) {
                elderly = edad;
            }
            if (edad < smaller) {
                smaller = edad;
            }
        }
        for (int i = 0; i < años.size(); i++) {
            if (años.get(i) == smaller) {
                smallerNames.add(nom.get(i));
            } else if (años.get(i) == elderly) {
                elderlyNames.add(nom.get(i));
            }
        }
        System.out.println("Los estudiantes mayores son " + elderlyNames + " y los menores son " + smallerNames);
    }
}
