package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LainanTakaisinMaksaja {

    // lainapääoman lyhentäminen tasaerin, koron määrä vaihtelee
    public static LainanMaksuSuunnitelma laskeEratTasalyhennyksessa(Double paaomaAlku, int vuosikorko, int maksuaika, int maksuvali) {
        Double paaoma = paaomaAlku;
        List<LainanMaksuEra> erat = new ArrayList<>();
        Double Korko_kum = 0.0;
        Double paaomanLyhennysEra = paaoma / (maksuaika / maksuvali);

        for (int i = 0; i < (maksuaika / maksuvali); i++) {
            // Lasketaan ensimmäisen erän korko
            Double Korko_mk = (vuosikorko / 12.0) * (paaoma) * (maksuvali / 100.0);
            Korko_kum = Korko_kum + Korko_mk;
            Double summa = paaomanLyhennysEra + Korko_mk;

            // muodostetaan LainanMaksuEra
            LainanMaksuEra era = new LainanMaksuEra();
            era.setKuukausi((i + 1)*maksuvali);
            era.setKoronOsuus(BigDecimal.valueOf(Korko_mk));
            era.setLainaPaaoma(BigDecimal.valueOf(paaoma));
            era.setLainaPaaomanLyhennysEra(BigDecimal.valueOf(paaomanLyhennysEra));
            era.setSumma(BigDecimal.valueOf(summa));
            era.setLyhennyksenLkm(i + 1);

            // vähennetään pääomasta pääomanlyhennyserä
            paaoma = paaoma - paaomanLyhennysEra;
            //
            erat.add(era);
        }

        LainanMaksuSuunnitelma suunnitelma = new LainanMaksuSuunnitelma();
        suunnitelma.setSumma(BigDecimal.valueOf(paaomaAlku + Korko_kum));
        suunnitelma.setLainaPaaoma(BigDecimal.valueOf(paaomaAlku));
        suunnitelma.setLainanMaksuErat(erat);
        suunnitelma.setKumulatiivinenKorko(BigDecimal.valueOf(Korko_kum));
        return suunnitelma;
    }
}
