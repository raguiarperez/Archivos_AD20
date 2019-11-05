
package archivos_ad20;

import java.sql.SQLException;

/**
 *
 * @author dam2
 */
public class Archivos_AD20 {


    public static void main(String[] args) throws SQLException {
        
        Producto pr= new Producto();
        pr.conectar();
        pr.verLista();
        
    }
    
}