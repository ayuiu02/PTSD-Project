package app.ayuisnaini.android.ptsdproject;

import java.util.ArrayList;

public class FuzzyTsukamoto {

    private static ArrayList<Integer> arrayFT = ScreeningActivity.returnDataFT();
    private static int aRendah, aTinggi, bRendah, bTinggi, cRendah, cTinggi, dRendah, dTinggi, eRendah, eTinggi;
    private static int  aPred1, aPred2,
                        aPred3, aPred4,
                        aPred5, aPred6,
                        aPred7, aPred8,
                        aPred9, aPred10,
                        aPred11, aPred12,
                        aPred13, aPred14,
                        aPred15, aPred16,
                        aPred17, aPred18,
                        aPred19, aPred20,
                        aPred21, aPred22,
                        aPred23, aPred24,
                        aPred25, aPred26,
                        aPred27, aPred28,
                        aPred29, aPred30,
                        aPred31, aPred32;
    private static int  z1, z2,
                        z3, z4,
                        z5, z6,
                        z7, z8,
                        z9, z10,
                        z11, z12,
                        z13, z14,
                        z15, z16,
                        z17, z18,
                        z19, z20,
                        z21, z22,
                        z23, z24,
                        z25, z26,
                        z27, z28,
                        z29, z30,
                        z31, z32;
    private static int hasilDefuzzifikasi;


    //Proses Fuzzifikasi menentukan derajat keanggotaan
    private static void fuzzifikasiA(int totalA) {
        if (totalA <= 0) {
            aRendah = 100;
            aTinggi = 0;
        } else {
            aRendah = 0;
            aTinggi = 100;
        }
    }

    private static void fuzzifikasiB(int totalB) {
        if (totalB <= 0) {
            bRendah = 100;
            bTinggi = 0;
        } else if (totalB >= 100) {
            bRendah = 0;
            bTinggi = 100;
        } else {
            bRendah = (100 - totalB) / 100;
            bTinggi = totalB / 100;
        }
    }

    private static void fuzzifikasiC(int totalC) {
        if (totalC <= 0) {
            cRendah = 100;
            cTinggi = 0;
        } else if (totalC >= 100) {
            cRendah = 0;
            cTinggi = 100;
        } else {
            cRendah = (100 - totalC) / 100;
            cTinggi = totalC / 100;
        }
    }

    private static void fuzzifikasiD(int totalD) {
        if (totalD <= 0) {
            dRendah = 100;
            dTinggi = 0;
        } else if (totalD >= 100) {
            dRendah = 0;
            dTinggi = 100;
        } else {
            dRendah = (100 - totalD) / 100;
            dTinggi = totalD / 100;
        }
    }

    private static void fuzzifikasiE(int totalE) {
        if (totalE <= 0) {
            eRendah = 100;
            eTinggi = 0;
        } else if (totalE >= 100) {
            eRendah = 0;
            eTinggi = 100;
        } else {
            eRendah = (100 - totalE) / 100;
            eTinggi = totalE / 100;
        }
    }

    //Inferensi Fuzzy Tsukamoto
    private static void inferensiTsukamoto(){
        {
            //[R1] IF A T AND B T AND C T AND D T AND E T THEN Result B
            aPred1 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z1 = aPred1 * 500;

            //[R2] IF A T AND B T AND C T AND D T AND E R THEN Result K
            aPred2 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z2 = 500 - aPred2 * 500;

            //[R3] IF A T AND B T AND C T AND D R AND E T THEN Result K
            aPred3 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z3 = 500 - aPred3 * 500;

            //[R4] IF A T AND B T AND C R AND D T AND E T THEN Result K
            aPred4 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z4 = 500 - aPred4 * 500;

            //[R5] IF A T AND B R AND C T AND D T AND E T THEN Result K
            aPred5 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z5 = 500 - aPred5 * 500;

            //[R6] IF A R AND B T AND C T AND D T AND E T THEN Result K
            aPred6 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z6 = 500 - aPred6 * 500;

            //[R7] IF A T AND B T AND C T AND D R AND E R THEN Result K
            aPred7 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z7 = 500 - aPred7 * 500;

            //[R8] IF A T AND B T AND C R AND D R AND E R THEN Result K
            aPred8 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z8 = 500 - aPred8 * 500;

            //[R9] IF A T AND B R AND C R AND D R AND E R THEN Result K
            aPred9 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z9 = 500 - aPred9 * 500;

            //[R10] IF A R AND B R AND C R AND D R AND E R THEN Result K
            aPred10 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z10 = 500 - aPred10 * 500;

            //[R11] IF A R AND B R AND C R AND D R AND E T THEN Result K
            aPred11 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z11 = 500 - aPred11 * 500;

            //[R12] IF A R AND B R AND C R AND D T AND E R THEN Result K
            aPred12 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z12 = 500 - aPred12 * 500;

            //[R13] IF A R AND B R AND C T AND D R AND E R THEN Result K
            aPred13 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z13 = 500 - aPred13 * 500;

            //[R14] IF A R AND B T AND C R AND D R AND E R THEN Result K
            aPred14 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z14 = 500 - aPred14 * 500;

            //[R15] IF A R AND B R AND C R AND D T AND E T THEN Result K
            aPred15 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z15 = 500 - aPred15 * 500;

            //[R16] IF A R AND B R AND C T AND D T AND E T THEN Result K
            aPred16 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z16 = 500 - aPred16 * 500;

            //[R17] IF A T AND B R AND C R AND D T AND E T THEN Result K
            aPred17 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z17 = 500 - aPred17 * 500;

            //[R18] IF A T AND B T AND C R AND D R AND E T THEN Result K
            aPred18 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z18 = 500 - aPred18 * 500;

            //[R19] IF A T AND B R AND C R AND D R AND E T THEN Result K
            aPred19 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z19 = 500 - aPred19 * 500;

            //[R20] IF A R AND B T AND C T AND D R AND E R THEN Result K
            aPred20 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z20 = 500 - aPred20 * 500;

            //[R21] IF A R AND B T AND C T AND D T AND E R THEN Result K
            aPred21 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z21 = 500 - aPred21 * 500;

            //[R22] IF A R AND B R AND C T AND D T AND E R THEN Result K
            aPred22 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z22 = 500 - aPred22 * 500;

            //[R23] IF A T AND B R AND C T AND D R AND E T THEN Result K
            aPred23 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z23 = 500 - aPred23 * 500;

            //[R24] IF A R AND B T AND C R AND D T AND E R THEN Result K
            aPred24 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z24 = 500 - aPred24 * 500;

            //[R25] IF A T AND B R AND C T AND D R AND E R THEN Result K
            aPred25 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z25 = 500 - aPred25 * 500;

            //[R26] IF A R AND B T AND C R AND D T AND E T THEN Result K
            aPred26 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z26 = 500 - aPred26 * 500;

            //[R27] IF A R AND B R AND C T AND D R AND E T THEN Result K
            aPred27 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z27 = 500 - aPred27 * 500;

            //[R28] IF A T AND B T AND C R AND D T AND E R THEN Result K
            aPred28 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z28 = 500 - aPred28 * 500;

            //[R29] IF A R AND B T AND C R AND D R AND E T THEN Result K
            aPred29 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z29 = 500 - aPred29 * 500;

            //[R30] IF A T AND B R AND C T AND D T AND E R THEN Result K
            aPred30 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z30 = 500 - aPred30 * 500;

            //[R31] IF A R AND B T AND C T AND D R AND E T THEN Result K
            aPred31 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z31 = 500 - aPred31 * 500;

            //[R32] IF A T AND B R AND C R AND D T AND E R THEN Result K
            aPred32 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z32 = 500 - aPred32 * 500;
        }
    }

    //Proses defuzzifikasi
    private static void defuzzifikasi(){
        int azTotal =   (aPred1 * z1) + (aPred2 * z2) + (aPred3 * z3) + (aPred4 * z4) + (aPred5 * z5) + (aPred6 * z6) + (aPred7 * z7) + (aPred8 * z8) + (aPred9 * z9) + (aPred10 * z10)
                        + (aPred11 * z11) + (aPred12 * z12) + (aPred13 * z13) + (aPred14 * z14) + (aPred15 * z15) + (aPred16 * z16) + (aPred17 * z17) + (aPred18 * z18) + (aPred19 * z19) + (aPred20 * z20)
                        + (aPred21 * z21) + (aPred22 * z22) + (aPred23 * z23) + (aPred24 * z24) + (aPred25 * z25) + (aPred26 * z26) + (aPred27 * z27) + (aPred28 * z28) + (aPred29 * z29) + (aPred30 * z30)
                        + (aPred31 * z31) + (aPred32 * z32);

        int aPredTotal =    aPred1 + aPred2 + aPred3 + aPred4 + aPred5 + aPred6 + aPred7 + aPred8 + aPred9 + aPred10
                            + aPred11 + aPred12 + aPred13 + aPred14 + aPred15 + aPred16 + aPred17 + aPred18 + aPred19 + aPred20
                            + aPred21 + aPred22 + aPred23 + aPred24 + aPred25 + aPred26 + aPred27 + aPred28 + aPred29 + aPred30
                            + aPred31 + aPred32;

        hasilDefuzzifikasi = azTotal / aPredTotal;
    }

    public static int screeningFT(){
        //Pengambilan nilai untuk masing-masing group
        int totalA = arrayFT.get(0);
        int totalB = arrayFT.get(1) + arrayFT.get(2) + arrayFT.get(3);
        int totalC = arrayFT.get(4) + arrayFT.get(5);
        int totalD = arrayFT.get(6) + arrayFT.get(7) + arrayFT.get(8) + arrayFT.get(9) + arrayFT.get(10);
        int totalE = arrayFT.get(11) + arrayFT.get(12) + arrayFT.get(13) + arrayFT.get(14) + arrayFT.get(15) + arrayFT.get(16);

        fuzzifikasiA(totalA);
        fuzzifikasiB(totalB);
        fuzzifikasiC(totalC);
        fuzzifikasiD(totalD);
        fuzzifikasiE(totalE);

        inferensiTsukamoto();
        defuzzifikasi();

        int hasilFT = (hasilDefuzzifikasi / 500) * 100;
        return hasilFT;
    }



}
