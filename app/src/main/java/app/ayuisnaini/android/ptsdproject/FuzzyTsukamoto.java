package app.ayuisnaini.android.ptsdproject;

import java.util.ArrayList;

public class FuzzyTsukamoto {

    private static ArrayList<Double> arrayFT = ScreeningActivity.returnDataFT();
    private static double aRendah, aTinggi, bRendah, bTinggi, cRendah, cTinggi, dRendah, dTinggi, eRendah, eTinggi;
    private static double   aPred1, aPred2,
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
    private static double   z1, z2,
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
    private static double hasilDefuzzifikasi;

    public static double screeningFT(){
        //Pengambilan nilai untuk masing-masing group
        double totalA = arrayFT.get(0);
        double totalB = arrayFT.get(1) + arrayFT.get(2) + arrayFT.get(3);
        double totalC = arrayFT.get(4) + arrayFT.get(5);
        double totalD = arrayFT.get(6) + arrayFT.get(7) + arrayFT.get(8) + arrayFT.get(9) + arrayFT.get(10);
        double totalE = arrayFT.get(11) + arrayFT.get(12) + arrayFT.get(13) + arrayFT.get(14) + arrayFT.get(15) + arrayFT.get(16);

        fuzzifikasiA(totalA);
        fuzzifikasiB(totalB);
        fuzzifikasiC(totalC);
        fuzzifikasiD(totalD);
        fuzzifikasiE(totalE);

        inferensiTsukamoto();
        defuzzifikasi();

        double hasilFT = (hasilDefuzzifikasi / 5) * 100;
        return hasilFT;
    }

    //Proses Fuzzifikasi menentukan derajat keanggotaan
    private static void fuzzifikasiA(double totalA) {
        if (totalA <= 0) {
            aRendah = 1;
            aTinggi = 0;
        } else {
            aRendah = 0;
            aTinggi = 1;
        }
    }

    private static void fuzzifikasiB(double totalB) {
        if (totalB <= 0) {
            bRendah = 1;
            bTinggi = 0;
        } else if (totalB >= 1) {
            bRendah = 0;
            bTinggi = 1;
        } else {
            bRendah = (1 - totalB);
            bTinggi = totalB;
        }
    }

    private static void fuzzifikasiC(double totalC) {
        if (totalC <= 0) {
            cRendah = 1;
            cTinggi = 0;
        } else if (totalC >= 1) {
            cRendah = 0;
            cTinggi = 1;
        } else {
            cRendah = (1 - totalC);
            cTinggi = totalC;
        }
    }

    private static void fuzzifikasiD(double totalD) {
        if (totalD <= 0) {
            dRendah = 1;
            dTinggi = 0;
        } else if (totalD >= 1) {
            dRendah = 0;
            dTinggi = 1;
        } else {
            dRendah = (1 - totalD);
            dTinggi = totalD;
        }
    }

    private static void fuzzifikasiE(double totalE) {
        if (totalE <= 0) {
            eRendah = 1;
            eTinggi = 0;
        } else if (totalE >= 1) {
            eRendah = 0;
            eTinggi = 1;
        } else {
            eRendah = (1 - totalE);
            eTinggi = totalE;
        }
    }

    //Inferensi Fuzzy Tsukamoto
    private static void inferensiTsukamoto(){
        {
            //[R1] IF A T AND B T AND C T AND D T AND E T THEN Result B
            aPred1 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z1 = aPred1 * 5;

            //[R2] IF A T AND B T AND C T AND D T AND E R THEN Result K
            aPred2 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z2 = 5 - aPred2 * 5;

            //[R3] IF A T AND B T AND C T AND D R AND E T THEN Result K
            aPred3 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z3 = 5 - aPred3 * 5;

            //[R4] IF A T AND B T AND C R AND D T AND E T THEN Result K
            aPred4 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z4 = 5 - aPred4 * 5;

            //[R5] IF A T AND B R AND C T AND D T AND E T THEN Result K
            aPred5 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z5 = 5 - aPred5 * 5;

            //[R6] IF A R AND B T AND C T AND D T AND E T THEN Result K
            aPred6 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z6 = 5 - aPred6 * 5;

            //[R7] IF A T AND B T AND C T AND D R AND E R THEN Result K
            aPred7 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z7 = 5 - aPred7 * 5;

            //[R8] IF A T AND B T AND C R AND D R AND E R THEN Result K
            aPred8 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z8 = 5 - aPred8 * 5;

            //[R9] IF A T AND B R AND C R AND D R AND E R THEN Result K
            aPred9 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z9 = 5 - aPred9 * 5;

            //[R10] IF A R AND B R AND C R AND D R AND E R THEN Result K
            aPred10 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z10 = 5 - aPred10 * 5;

            //[R11] IF A R AND B R AND C R AND D R AND E T THEN Result K
            aPred11 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z11 = 5 - aPred11 * 5;

            //[R12] IF A R AND B R AND C R AND D T AND E R THEN Result K
            aPred12 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z12 = 5 - aPred12 * 5;

            //[R13] IF A R AND B R AND C T AND D R AND E R THEN Result K
            aPred13 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z13 = 5 - aPred13 * 5;

            //[R14] IF A R AND B T AND C R AND D R AND E R THEN Result K
            aPred14 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eRendah))));
            z14 = 5 - aPred14 * 5;

            //[R15] IF A R AND B R AND C R AND D T AND E T THEN Result K
            aPred15 = Math.min(aRendah, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z15 = 5 - aPred15 * 5;

            //[R16] IF A R AND B R AND C T AND D T AND E T THEN Result K
            aPred16 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eTinggi))));
            z16 = 5 - aPred16 * 5;

            //[R17] IF A T AND B R AND C R AND D T AND E T THEN Result K
            aPred17 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z17 = 5 - aPred17 * 5;

            //[R18] IF A T AND B T AND C R AND D R AND E T THEN Result K
            aPred18 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z18 = 5 - aPred18 * 5;

            //[R19] IF A T AND B R AND C R AND D R AND E T THEN Result K
            aPred19 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z19 = 5 - aPred19 * 5;

            //[R20] IF A R AND B T AND C T AND D R AND E R THEN Result K
            aPred20 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z20 = 5 - aPred20 * 5;

            //[R21] IF A R AND B T AND C T AND D T AND E R THEN Result K
            aPred21 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z21 = 5 - aPred21 * 5;

            //[R22] IF A R AND B R AND C T AND D T AND E R THEN Result K
            aPred22 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z22 = 5 - aPred22 * 5;

            //[R23] IF A T AND B R AND C T AND D R AND E T THEN Result K
            aPred23 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z23 = 5 - aPred23 * 5;

            //[R24] IF A R AND B T AND C R AND D T AND E R THEN Result K
            aPred24 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z24 = 5 - aPred24 * 5;

            //[R25] IF A T AND B R AND C T AND D R AND E R THEN Result K
            aPred25 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eRendah))));
            z25 = 5 - aPred25 * 5;

            //[R26] IF A R AND B T AND C R AND D T AND E T THEN Result K
            aPred26 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eTinggi))));
            z26 = 5 - aPred26 * 5;

            //[R27] IF A R AND B R AND C T AND D R AND E T THEN Result K
            aPred27 = Math.min(aRendah, Math.min(bRendah, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z27 = 5 - aPred27 * 5;

            //[R28] IF A T AND B T AND C R AND D T AND E R THEN Result K
            aPred28 = Math.min(aTinggi, Math.min(bTinggi, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z28 = 5 - aPred28 * 5;

            //[R29] IF A R AND B T AND C R AND D R AND E T THEN Result K
            aPred29 = Math.min(aRendah, Math.min(bTinggi, Math.min(cRendah, Math.min(dRendah, eTinggi))));
            z29 = 5 - aPred29 * 5;

            //[R30] IF A T AND B R AND C T AND D T AND E R THEN Result K
            aPred30 = Math.min(aTinggi, Math.min(bRendah, Math.min(cTinggi, Math.min(dTinggi, eRendah))));
            z30 = 5 - aPred30 * 5;

            //[R31] IF A R AND B T AND C T AND D R AND E T THEN Result K
            aPred31 = Math.min(aRendah, Math.min(bTinggi, Math.min(cTinggi, Math.min(dRendah, eTinggi))));
            z31 = 5 - aPred31 * 5;

            //[R32] IF A T AND B R AND C R AND D T AND E R THEN Result K
            aPred32 = Math.min(aTinggi, Math.min(bRendah, Math.min(cRendah, Math.min(dTinggi, eRendah))));
            z32 = 5 - aPred32 * 5;
        }
    }

    //Proses defuzzifikasi
    private static void defuzzifikasi(){
        double azTotal =   (aPred1 * z1) + (aPred2 * z2) + (aPred3 * z3) + (aPred4 * z4) + (aPred5 * z5) + (aPred6 * z6) + (aPred7 * z7) + (aPred8 * z8) + (aPred9 * z9) + (aPred10 * z10)
                        + (aPred11 * z11) + (aPred12 * z12) + (aPred13 * z13) + (aPred14 * z14) + (aPred15 * z15) + (aPred16 * z16) + (aPred17 * z17) + (aPred18 * z18) + (aPred19 * z19) + (aPred20 * z20)
                        + (aPred21 * z21) + (aPred22 * z22) + (aPred23 * z23) + (aPred24 * z24) + (aPred25 * z25) + (aPred26 * z26) + (aPred27 * z27) + (aPred28 * z28) + (aPred29 * z29) + (aPred30 * z30)
                        + (aPred31 * z31) + (aPred32 * z32);

        double aPredTotal =    aPred1 + aPred2 + aPred3 + aPred4 + aPred5 + aPred6 + aPred7 + aPred8 + aPred9 + aPred10
                            + aPred11 + aPred12 + aPred13 + aPred14 + aPred15 + aPred16 + aPred17 + aPred18 + aPred19 + aPred20
                            + aPred21 + aPred22 + aPred23 + aPred24 + aPred25 + aPred26 + aPred27 + aPred28 + aPred29 + aPred30
                            + aPred31 + aPred32;

        hasilDefuzzifikasi = azTotal / aPredTotal;
    }

}
