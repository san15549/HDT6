
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Carlo David Sanchinelli, Juan Pablo Zea
 * @version 04.09.16
 */
public class HDT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("BIENVENIDO AL ANALIZADOR DE DESARROLLADORES");
        System.out.println("Ingrese el NUMERO del tipo de Implementacion de Set que desea utilizar:\n1. HashSet\n2. TreeSet\n3. LinkedHashSet");
        String comando = teclado.nextLine();
        Factory FactorySET = new Factory();
        Set SetJava = FactorySET.seleccionar(comando);
        Set SetWeb = FactorySET.seleccionar(comando);
        Set SetCell = FactorySET.seleccionar(comando);
        boolean salidaAgregar = true; 
        while(salidaAgregar == true){
            salidaAgregar = false;
            System.out.println("AGREGAR DESARROLLADOR");
            System.out.println("Ingrese el nombre del desarrollador:");
            String nombre = teclado.nextLine();
            System.out.println("Ingrese el tipo de desarrollador de " + nombre+ ":");
            String tipo = teclado.nextLine();
            switch (tipo){
                case "java":
                    SetJava.add(nombre);
                    System.out.println("Desarrollador de Java agregado correctamente.");
                    break;
                case "web":
                    SetWeb.add(nombre);
                    System.out.println("Desarrollador de Web agregado correctamente.");
                    break;
                case "celular":
                    SetCell.add(nombre);
                    System.out.println("Desarrollador de Celular agregado correctamente.");
                    break;
                default:
                    System.out.println("OJO: Ese tipo de desarrollador no existe.\n");
                    salidaAgregar = true;
                    break;
            }
            if(salidaAgregar==false){
                System.out.println("\nDesea ver las estadisticas:");
                String salida = teclado.nextLine();
                switch (salida) {
                    case "si":
                        salidaAgregar = false;
                        break;
                    case "no":
                        salidaAgregar = true;
                        System.out.println("");
                        break;
                    default:
                        System.out.println("OJO: Instruccion no reconocida.");
                        salidaAgregar = true;
                        break;
                }
            }
        }
        /*Variables de Estadisticas*/
        ArrayList All = new ArrayList();
        ArrayList JavaNoWeb = new ArrayList();
        ArrayList WebyCell = new ArrayList();
        ArrayList WeboCell = new ArrayList();
        
        /*Pruebas Estadisticas*/
        Iterator itrjava = SetJava.iterator();
        while(itrjava.hasNext()){
            Object elementjava = itrjava.next();
            boolean testJavaNoWeb = SetWeb.contains(elementjava);
            if(testJavaNoWeb==false){
                JavaNoWeb.add(elementjava);
            }
            //SE PROCEDE A ENTRAR AL SET DE WEB.
            Iterator itrweb = SetWeb.iterator();
            while(itrweb.hasNext()){
                Object elementweb = itrweb.next();
                boolean testJavaNoWeb2 = SetJava.contains(elementweb);
                if(testJavaNoWeb2==false){
                   boolean testWebyCell = SetCell.contains(elementweb);
                   boolean testWebCell = WebyCell.contains(elementweb);
                   if(testWebyCell==true && testWebCell==false){
                       WebyCell.add(elementweb);
                       WeboCell.add(elementweb);
                   }
                }
                //SE ANALIZA SI EL ELEMENTO WEB ES IGUAL AL ELEMENTO JAVA.
                if(elementweb.equals(elementjava)){
                    //SE PROCEDE A ENTRAR AL SET DE CELULAR.
                    Iterator itrcell = SetCell.iterator();
                    while(itrcell.hasNext()){
                        Object elementcell = itrcell.next();
                        if(elementcell.equals(elementweb)){
                            All.add(elementcell);
                        }
                    }
                }
                else{
                    //SE PROCEDE A ENTRAR AL SET DE CELULAR.
                    Iterator itrcell = SetCell.iterator();
                    while(itrcell.hasNext()){
                        Object elementcell = itrcell.next();
                        boolean testJavaSinCell = SetJava.contains(elementcell);
                        boolean testWeboCell = SetWeb.contains(elementcell);
                        boolean testWeboCell2 = WeboCell.contains(elementcell);
                        if(testWeboCell==false && testWeboCell2==false){
                            if(testJavaSinCell==false){
                                WeboCell.add(elementcell);
                            }
                        }
                        boolean testWeboCell3 = WeboCell.contains(elementweb);
                        boolean testJavaSinWeb = SetJava.contains(elementweb);
                        if(testWeboCell3==false){
                            if(testJavaSinWeb==false){
                                WeboCell.add(elementweb);
                            }
                        }
                    }
                }
            }
        }
    }
}
