package Models;

public class School {
    private String  name;
    private String region;
    private String email;
    private int id;

    private static School instance  = null;

    private School(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public int getId() {
        return id;
    }

    public static School getInstance(){
        if( instance == null ){
            instance = new School();
        }
        return instance;
    }

}
