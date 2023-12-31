package org.example.laina;

import java.math.BigDecimal;

public interface LainaLaskuri {

    LainanMaksuSuunnitelma teeLainanMaksuSuunnitelmaTasaLyhennyksella(BigDecimal alkuLainaPaaoma,
                                                     VuosiKorko vuosiKorko,
                                                     int lainanMaksuAikaKuukausina,
                                                     int lainanMaksuValiKuukausina);


    LainanMaksuSuunnitelma teeLainanMaksuSuunnitelmaTasaEraLyhennyksella(BigDecimal alkuLainaPaaoma,
                                                                         VuosiKorko vuosiKorko,
                                                                         int lainanMaksuAikaKuukausina);

}
