package app.ayuisnaini.android.ptsdproject;

import java.util.ArrayList;

public class DempsterShafer {

    private static ArrayList<Integer> arrayDS = ScreeningActivity.returnDataDS();

    private static Integer inferensiDS(int x, int y){
        return (x * y) + (x * (100 - y) + ((100 - x) * y));
    }

    public static int screeningDS(){
        int temp = 0;
        temp = inferensiDS(arrayDS.get(0), arrayDS.get(1));
        for (int i = 2; i < arrayDS.size(); i++){
            temp = inferensiDS(temp, arrayDS.get(i));
        }

        int hasilDS = temp * 100;
        return hasilDS;
    }
}
