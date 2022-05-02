
import java.time.LocalDate;
import java.util.*;

public class passwd {
    public static void main(String[] args) {

        // variable de salida
        String password = "";
        LocalDate fecha = LocalDate.now();


        // variablles auxiliares
        String letrasMayMin = "abcdefghijklmnopqrstuvwxyz0123456789";
        String simbolos = "!@#$%^&*()_+-=[]{}|;':,./<>?";
        boolean aceptada = true;
        String descripcion = "";
        String ruta = System.getProperty("user.dir") + "\\src\\passwd.txt";


        // variables de entrada
        int longitud = 0;
        String complex = "";
        Scanner input = new Scanner(System.in);



        System.out.print("Introduce la longitud de la password: ");
        longitud = input.nextInt();


        System.out.println("Introduce la complejidad de la password\n   " +
                "1. Simple (Letras y numeros)\n   " +
                "2. Compleja (Letras, numeros y simbolos): ");
        complex = input.next();


        // creacion de la password
        do{

            if (complex.equals("1")) {
                for(int i = 0; i < longitud; i++){
                    int rand = (int) (Math.random() * letrasMayMin.length());
                    password += letrasMayMin.charAt(rand);
                }
            } else if (complex.equals("2")) {
                for(int i = 0; i < longitud; i++){
                    String comb = letrasMayMin + simbolos;
                    int rand = (int) (Math.random() * comb.length());
                    password += comb.charAt(rand);
                }
            }
            System.out.println("La password generada es: " + password);
            System.out.println("¿Es correcta? (S/N)");
            String respuesta = input.next();
            if (respuesta.equals("S") || respuesta.equals("s")) {
                aceptada = true;
                System.out.println("Introduce una descripcion de la password(Cada palabra separada por _ ): ");
                descripcion = input.next();
            } else if (respuesta.equals("N") || respuesta.equals("n")) {
                aceptada = false;
                password = "";
            }
        }while(!aceptada);


        // creacion de escritura en el fichero
        String fichero = password + " -> " + descripcion + " -> " + fecha.toString() + "\n";
        fichero += "--------------------------------------------------\n";

        System.out.println("Programa finalizado");

    }
}
