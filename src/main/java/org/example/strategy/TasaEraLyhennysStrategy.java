package org.example.strategy;

import org.example.valueobject.LainanMaksuEra;
import org.example.valueobject.LainanMaksuSuunnitelma;
import org.example.valueobject.VuosiKorko;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TasaEraLyhennysStrategy implements LyhennysStrategy {

    // Lainan ja koron maksaminen tasaerin (pääoman lyhennys ja koron osuus tasaerästä muuttuvat ajan myötä)
    @Override
    public LainanMaksuSuunnitelma teeLainanMaksuSuunnitelma(final BigDecimal alkuLainapaaoma,
                                                            final VuosiKorko vuosikorko,
                                                            final int maksuaikaKuukausina,
                                                            final int maksuvaliKuukausina) {
        BigDecimal lainapaaoma = alkuLainapaaoma;
        BigDecimal kumulatiivinenKorko = BigDecimal.ZERO;
        List<LainanMaksuEra> erat = new ArrayList<>();
        int maksuerienMaara = maksuaikaKuukausina / maksuvaliKuukausina;



        return null; // muuta
    }

    public BigDecimal laskeTasaEraKuukaudelle(BigDecimal lainaPaaoma, VuosiKorko vuosiKorko, int maksuAikaKuukausina) {
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

        return (osoittaja.divide(nimittaja, 100, BigDecimal.ROUND_HALF_UP)).multiply(lainaPaaoma);
    }
}
