package Models;

public class Accountant extends Financier{
    public static final String FINANCIER_TYPE = "accountant";

    public Accountant(String name, String email, int nationalId, String contact, String password) {
        super(name, email, nationalId, contact, password);
        type=FINANCIER_TYPE;
    }


}
