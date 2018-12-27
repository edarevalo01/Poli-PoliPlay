package co.edu.poli.gamification.poliplay.Modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.edu.poli.gamification.poliplay.Secuencia.Login;

public class Utiles {

    public static String getFecha(){
        String res = "";
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);

        res += ano + "/" + mes + "/" + dia + "-" + hora + ":" + minuto;
        return res;
    }

    public static void terminarConexion(){
        Login.endCon = System.currentTimeMillis();
        long totaltime = (Login.endCon-Login.startCon)/1000;
        TiempoConexion tc = new TiempoConexion(Utiles.getFecha(), Login.user.getCode(), Login.user.getGroup(), ""+totaltime);
        tc.execute();
    }

}
