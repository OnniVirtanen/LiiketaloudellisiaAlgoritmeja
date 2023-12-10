package org.example.laina;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LainaLaskuriImpl implements LainaLaskuri {

    private static final int RAHAN_ESITYS_TARKKUUS_DES = 2;

    private static LainaLaskuriImpl single_instance = null;

    public static synchronized LainaLaskuriImpl getInstance() {
        if (single_instance == null)
            single_instance = new LainaLaskuriImpl();
        return single_instance;
    }

    // because class is singleton
    private LainaLaskuriImpl() {

    }

    @Override
    public LainanMaksuSuunnitelma teeLainanMaksuSuunnitelmaTasaLyhennyksella(BigDecimal alkuLainaPaaoma,
                                                                             VuosiKorko vuosiKorko,
                                                                             int lainanMaksuAikaKuukausina,
                                                                             int lainanMaksuValiKuukausina) {
        BigDecimal lainaPaaoma = alkuLainaPaaoma;
        BigDecimal kumulatiivinenKorko = BigDecimal.ZERO;
        List<LainanMaksuEra> erat = new ArrayList<>();
        int maksuerienMaara = lainanMaksuAikaKuukausina / lainanMaksuValiKuukausina;
        BigDecimal lainapaaomanLyhennys = lainaPaaoma.divide(new BigDecimal(maksuerienMaara), 4, BigDecimal.ROUND_HALF_UP);

        for (int i = 0; i < maksuerienMaara; i++) {
            BigDecimal korkoProsentti = vuosiKorko.getProsenttiKerroin(lainanMaksuValiKuukausina);
            BigDecimal korko = korkoProsentti.multiply(lainaPaaoma);
            kumulatiivinenKorko = kumulatiivinenKorko.add(korko);
            BigDecimal maksuera = lainapaaomanLyhennys.add(korko);
            int lyhennyksenLkm = i + 1;
            int kuukausi = (lainanMaksuAikaKuukausina / maksuerienMaara) * (i + 1);

            LainanMaksuEra era = new LainanMaksuEra(
                    UUID.randomUUID(),
                    kuukausi,
                    alkuLainaPaaoma.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    lainapaaomanLyhennys.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    korko.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    maksuera.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    lyhennyksenLkm
            );
            erat.add(era);
            lainaPaaoma = lainaPaaoma.subtract(lainapaaomanLyhennys);
        }
        LainanMaksuSuunnitelma suunnitelma = new LainanMaksuSuunnitelma(
                UUID.randomUUID(),
                erat,
                alkuLainaPaaoma.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                kumulatiivinenKorko.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                alkuLainaPaaoma.add(kumulatiivinenKorko.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP))
        );
        return suunnitelma;
    }

    @Override
    public LainanMaksuSuunnitelma teeLainanMaksuSuunnitelmaTasaEraLyhennyksella(BigDecimal alkuLainaPaaoma,
                                                                                VuosiKorko vuosiKorko,
                                                                                int lainanMaksuAikaKuukausina) {
        BigDecimal lainaPaaoma = alkuLainaPaaoma;
        BigDecimal kumulatiivinenKorko = BigDecimal.ZERO;
        List<LainanMaksuEra> erat = new ArrayList<>();
        BigDecimal tasaEra = laskeTasaEraKuukaudelle(alkuLainaPaaoma, vuosiKorko, lainanMaksuAikaKuukausina);

        for (int i = 0; i < lainanMaksuAikaKuukausina; i++) {
            BigDecimal korkoProsentti = vuosiKorko.getProsenttiKerroin();
            BigDecimal korko = korkoProsentti.multiply(lainaPaaoma);
            kumulatiivinenKorko = kumulatiivinenKorko.add(korko);
            BigDecimal lainapaaomanLyhennys = tasaEra.subtract(korko);

            LainanMaksuEra era = new LainanMaksuEra(
                    UUID.randomUUID(),
                    i + 1,
                    alkuLainaPaaoma.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    lainapaaomanLyhennys.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    korko.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    tasaEra.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                    i + 1
            );
            erat.add(era);
            lainaPaaoma = lainaPaaoma.subtract(lainapaaomanLyhennys);
        }
        LainanMaksuSuunnitelma suunnitelma = new LainanMaksuSuunnitelma(
                UUID.randomUUID(),
                erat,
                alkuLainaPaaoma.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                kumulatiivinenKorko.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP),
                alkuLainaPaaoma.add(kumulatiivinenKorko.setScale(RAHAN_ESITYS_TARKKUUS_DES, BigDecimal.ROUND_HALF_UP))
        );
        return suunnitelma;
    }

    private BigDecimal laskeTasaEraKuukaudelle(BigDecimal lainaPaaoma, VuosiKorko vuosiKorko, int maksuAikaKuukausina) {
        BigDecimal osoittaja = ( new BigDecimal(1)
                .add(vuosiKorko.getProsenttiKerroin(1))
                .pow(maksuAikaKuukausina)
                .multiply(vuosiKorko.getProsenttiKerroin(1))
        );
        BigDecimal nimittaja = ( new BigDecimal(1)
                .add(vuosiKorko.getProsenttiKerroin(1))
                .pow(maksuAikaKuukausina)
                .subtract(new BigDecimal(1))
        );
        return (osoittaja.divide(nimittaja, MathContext.DECIMAL64)).multiply(lainaPaaoma);
    }
}
