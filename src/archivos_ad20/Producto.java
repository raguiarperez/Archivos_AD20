
package archivos_ad20;

import java.sql.*;

/**
 *
 * @author dam2
*/

public class Producto {
       Connection conn;

    public void conectar() throws SQLException {

        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain"; 
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;

        conn = DriverManager.getConnection(url);

    }

    public void cerrar() throws SQLException {

        conn.close();

    }

    //Método que usamos el año pasado en el proyecto de Nina
    public void insertarFila(String cod, String desc, int prezo) {

        try {
            PreparedStatement pst = conn.prepareStatement("insert into produtos values(?,?,?)");

            pst.setString(1, cod);
            pst.setString(2, desc);
            pst.setInt(3, prezo);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("No se pudo insertar");
        }

    }

    public void actualizarFila(String codigo, int prezo) {

        try {
            PreparedStatement pst = conn.prepareStatement("update produtos set prezo = ? where codigo = ?");

            pst.setInt(1, prezo);
            pst.setString(2, codigo);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("No se pudo actualizar la fila");
        }

    }

 
    public void verLista() {

        try {
            PreparedStatement pst = conn.prepareStatement("select produtos.* from produtos");
            ResultSet rs = pst.executeQuery();
            System.out.println("Codigo\tDesc\tPrezo");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "      " + rs.getString(2) + "   " + rs.getInt(3));
            }

        } catch (SQLException ex) {
            System.out.println("No se puede ver la lista");
}
    }
} 

