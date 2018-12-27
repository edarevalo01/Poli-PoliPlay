package co.edu.poli.gamification.poliplay.Servicios;

public class Api {

    /** La URL de este parámetro se modifica cada vez que sea necesario o cada que se cambie de "servidor"*/
    private static final String SERVER_URL = "192.168.0.5";
    public static final String ROOT_URL = "http://"+SERVER_URL+"/PoliPlayApi/Api.php?apicall=";

    public static final String URL_REGISTER_USER = ROOT_URL + "registrousuario";
    public static final String URL_LOGIN_USER = ROOT_URL + "loginusuario";

    public static final String URL_ADD_SIGNATURE = ROOT_URL + "agregarmateria";
    public static final String URL_ADD_ROLE = ROOT_URL + "agregarrol";
    public static final String URL_ADD_TRANSPORT = ROOT_URL + "agregartransporte";

    public static final String URL_ADD_GAME_TIME = ROOT_URL + "agregartiempojuego";
    public static final String URL_ADD_CONN_TIME = ROOT_URL + "agregartiempoconexion";

}
