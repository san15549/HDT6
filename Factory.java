import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Carlo David Sanchinelli, Juan Pablo Zea
 * @version 04.09.16
 */
public class Factory {
    //Factory para establecer el tipo de Set segun el comando del usuario.
    public Set seleccionar(String comando){
        switch (comando){
            case "1":
                return new HashSet();
            case "2":
                return new TreeSet();
            case "3":
                return new LinkedHashSet();
            default:
                System.out.println("OJO: Ese tipo de Set no existe.\nConfigurando un Set HashSet...");
                return new HashSet();
        }
    }
}
