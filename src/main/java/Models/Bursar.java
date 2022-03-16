package Models;

public class Bursar extends Financier{

    public static final String FINANCIER_TYPE = "bursar";

    public Bursar(String name, String email, int nationalId, String contact,String password) {
        super(name, email, nationalId, contact,password);
        type = FINANCIER_TYPE;
    }
}
