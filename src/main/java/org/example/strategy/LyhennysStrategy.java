package org.example.strategy;

import org.example.valueobject.LainanMaksuSuunnitelma;
import org.example.valueobject.VuosiKorko;

import java.math.BigDecimal;

public interface LyhennysStrategy {

    LainanMaksuSuunnitelma teeLainanMaksuSuunnitelma(BigDecimal alkuLainapaaoma,
                                                     VuosiKorko korko,
                                                     int lainanMaksuAikaKuukausina,
                                                     int lainanMaksuValiKuukausina);
}
