package co.edu.poli.gamification.poliplay;

public class Api {

    /** La URL de este parámetro se modifica cada vez que sea necesario o cada que se cambie de "servidor"*/
    private static final String SERVER_URL = "192.168.0.5";
    public static final String ROOT_URL = "http://"+SERVER_URL+"/PoliPlayApi/Api.php?apicall=";

    public static final String URL_REGISTER_USER = ROOT_URL + "registrousuario";
    public static final String URL_LOGIN_USER = ROOT_URL + "loginusuario";

}
