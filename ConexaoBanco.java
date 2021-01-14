
/**
 * João Tanaca CB3002276
 */
import java.sql.*;
import java.util.List;

public class ConexaoBanco {
    static List<Funcionario> func;

    public static void main(String args[]) {

    }

    public void insert(int id, String nome, double valor, int peso) {
        try {
            String url = "jdbc:sqlserver://187.60.29.29\\SQLEXPRESS;databaseName=AulaJava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connect;
            connect = DriverManager.getConnection(url);
            Statement statement = connect.createStatement();
            String insert = "Insert into tb_prods (cd_prod, ds´prod, vl_prod, qt_pesoprod) values(" + id + ", '" + nome
                    + "', " + valor + ", " + peso + ")";
            statement.executeUpdate(insert);
            connect.close();
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public List<Funcionario> select(String nome) {
        try {
            String url = "jdbc:sqlserver://187.60.29.29\\SQLEXPRESS;databaseName=aulajava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connect;
            connect = DriverManager.getConnection(url);
            Statement statement = connect.createStatement();
            ResultSet result;
            result = statement.executeQuery(
                    "Select cod_func, nome_func, sal_func, ds_cargo from tbfuncs INNER JOIN tbcargos ON tbfuncs.cod_cargo = tbcargos.cd_cargo where nome_func like '"
                            + nome + "'");
            mostraResult(result);
            connect.close();

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
        return func;
    }

    private static void mostraResult(ResultSet result) throws SQLException {
        while (result.next()) {
            func.add(new Funcionario(result.getInt(0), result.getString(1), result.getDouble(2), result.getString(3)));
        }
    }
}