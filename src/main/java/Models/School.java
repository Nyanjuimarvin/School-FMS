package Models;

public class School {
    String name;
    String region;
    String email;

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

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public static School getInstance(){
        if( instance == null ){
            instance = new School();
        }
        return instance;
    }

}
