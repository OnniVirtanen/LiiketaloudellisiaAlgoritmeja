package org.example;

import org.example.strategy.LyhennysStrategy;
import org.example.strategy.TasaEraLyhennysStrategy;
import org.example.strategy.TasaLyhennysStrategy;
import org.example.valueobject.LainanMaksuEra;
import org.example.valueobject.LainanMaksuSuunnitelma;
import org.example.valueobject.VuosiKorko;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal paaoma = new BigDecimal(20000);
        VuosiKorko korko = new VuosiKorko(10);
        int maksuaika = 24;
        int maksuvali = 1;
        /*
        TasaLyhennysStrategy tasaLyhennys = new TasaLyhennysStrategy();

        LainanMaksuSuunnitelma suunnitelma = teeLainanMaksuSuunnitelma(tasaLyhennys, paaoma, korko, maksuaika, maksuvali);

        for (LainanMaksuEra era : suunnitelma.getLainanMaksuErat()) {
            System.out.println(era);
        }

        System.out.println("lainapaaoma: " + suunnitelma.getLainaPaaoma());
        System.out.println("summa: " + suunnitelma.getSumma());
        System.out.println("kumulatiivinen korko: " + suunnitelma.getKumulatiivinenKorko());
        */
        TasaEraLyhennysStrategy strategy = new TasaEraLyhennysStrategy();

        System.out.println(strategy.laskeTasaEraKuukaudelle(
                new BigDecimal(109800),
                new VuosiKorko(4.9),
                180
        ));
    }

    public static LainanMaksuSuunnitelma teeLainanMaksuSuunnitelma(LyhennysStrategy lyhennysStrategy,
                                                            BigDecimal paaoma,
                                                            VuosiKorko korko,
                                                            int maksuaika,
                                                            int maksuvali) {
        return lyhennysStrategy.teeLainanMaksuSuunnitelma(paaoma, korko, maksuaika, maksuvali);
    }
}