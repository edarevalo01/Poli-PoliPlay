package co.edu.poli.gamification.poliplay;

public class Api {

    public static final String ROOT_URL = "http://192.168.0.3/PoliPlayApi/v1/Api.php?apicall=";

    public static final String URL_CREATE_USER = ROOT_URL + "createusuario";
    public static final String URL_READ_USERS = ROOT_URL + "getusuarios";
    public static final String URL_UPDATE_USER = ROOT_URL + "updateusuario";
    public static final String URL_DELETE_USER = ROOT_URL + "deleteusuario&codigo=";

}
