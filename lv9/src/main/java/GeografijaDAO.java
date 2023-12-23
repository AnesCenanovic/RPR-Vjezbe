import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.sql.*;
import java.util.Scanner;

public class GeografijaDAO {

    private static GeografijaDAO instance;
    private Connection conn;
    private PreparedStatement glavniGradUpit;
    public static GeografijaDAO getInstance(){
        if(instance==null) instance= new GeografijaDAO();
        return instance;
    }
    private GeografijaDAO(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            glavniGradUpit = conn.prepareStatement("SELECT * FROM grad, drzava WHERE grad.drzava=drzava AND drzava.glavni_grad=?");
        } catch (SQLException e) {
            regenerisiBazu();
            try {
                glavniGradUpit = conn.prepareStatement("SELECT * FROM grad, drzava WHERE grad.drzava=drzava AND drzava.glavni_grad=?");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit = "";
            while(ulaz.hasNext()){
                String line = ulaz.nextLine();
                sqlUpit +=ulaz.nextLine();
                if(sqlUpit.charAt( sqlUpit.length()-1 ) == ';'){
                    try {
                        Statement statement = conn.createStatement();
                        statement.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
