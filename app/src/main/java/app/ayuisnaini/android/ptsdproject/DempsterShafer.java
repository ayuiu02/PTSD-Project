package app.ayuisnaini.android.ptsdproject;

import android.util.Log;

import java.util.ArrayList;

public class DempsterShafer {

    private static ArrayList<Double> arrayDS = ScreeningActivity.returnDataDS();

    private static double inferensiDS(double x, double y){
        return (x * y) + (x * (1 - y) + ((1 - x) * y));
    }

    public static double screeningDS(){
        Log.d("getDS", String.valueOf(arrayDS));
        double hasilDS;
        if (arrayDS.size() <= 1){
            hasilDS = 0;
            return hasilDS;
        } else {
            double temp = 0;
            temp = inferensiDS(arrayDS.get(0), arrayDS.get(1));
            for (int i = 2; i < arrayDS.size(); i++){
                temp = inferensiDS(temp, arrayDS.get(i));
            }

            hasilDS = temp * 100;
            return hasilDS;
        }

    }
}
