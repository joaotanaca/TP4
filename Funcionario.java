
/**
 * João Tanaca CB3002276
 */
public class Funcionario {
    protected int cod_func;
    protected String nome_func;
    protected double sal_func;
    protected String ds_cargo;

    Funcionario(int codFunc, String nomeFunc, double salFunc, String dsCargo) {
        cod_func = codFunc;
        nome_func = nomeFunc;
        sal_func = salFunc;
        ds_cargo = dsCargo;
    }

    public String getNome() {
        return nome_func;
    }

    public double getSal() {
        return sal_func;
    }

    public String getCargo() {
        return ds_cargo;
    }
}
