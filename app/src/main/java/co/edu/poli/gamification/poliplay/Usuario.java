package co.edu.poli.gamification.poliplay;

public class Usuario {

    private String code;
    private String email;
    private String username;
    private String password;
    private String signature;
    private String role;
    private String transport;

    public Usuario(){
        this.code = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.signature = "";
        this.role = "";
        this.transport = "";
    }

    /** Register user create */
    public Usuario(String code, String email, String username, String password){
        this.code = code;
        this.email = email;
        this.username = username;
        this.password = password;
        signature = "";
        role = "";
        transport = "";
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getSignature() { return signature; }

    public void setSignature(String signature) { this.signature = signature; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getTransport() { return transport; }

    public void setTransport(String transport) { this.transport = transport; }

}