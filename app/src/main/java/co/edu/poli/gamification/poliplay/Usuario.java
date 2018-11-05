package co.edu.poli.gamification.poliplay;

public class Usuario {

    private String name;
    private String lastName;
    private String username;
    private String password;
    private String career;
    private String code;
    private String signature;
    private String role;
    private String transport;

    public Usuario(){
        this.name = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.career = "";
        this.code = "";
        this.signature = "";
        this.role = "";
        this.transport = "";
    }

    /** Name, email, password */
    public Usuario(String name, String lastName, String username, String password){
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.career = "";
        this.code = "";
    }

    /** All items */
    public Usuario(String name, String lastName, String username, String password, String career, String code){
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.career = career;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUmail(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSignature() { return signature; }

    public void setSignature(String signature) { this.signature = signature; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getTransport() { return transport; }

    public void setTransport(String transport) { this.transport = transport; }
}
