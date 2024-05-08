package org.example.laina;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

class LainaLaskuriImplTest {

    @Test
    void teeLainanMaksuSuunnitelmaTasaEraLyhennyksella_normaaliTilanne_oikeatArvot() {
        BigDecimal paaoma = new BigDecimal(20000);
        VuosiKorko korko = new VuosiKorko(10);
        int maksuaika = 24;

        LainaLaskuri lainaLaskuri = LainaLaskuriImpl.getInstance();

        LainanMaksuSuunnitelma suunnitelma = lainaLaskuri.teeLainanMaksuSuunnitelmaTasaEraLyhennyksella(
                paaoma, korko, maksuaika);

        BigDecimal odotettuSumma = new BigDecimal("22149.56").setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal odotettuKumulatiivinenKorko = new BigDecimal("2149.56").setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal odotettuLainaPaaoma = new BigDecimal("20000").setScale(2, BigDecimal.ROUND_HALF_UP);
        List<BigDecimal> lainaPaaomanLyhennykset = suunnitelma.getLainanMaksuErat().stream()
                .map(LainanMaksuEra::getLainaPaaomanLyhennysEra).collect(Collectors.toList());
        boolean onEriSummiaLainaPaaomanLyhennyksissa = lainaPaaomanLyhennykset.stream().distinct().count() > 1;
        BigDecimal kokonaisLyhennys = lainaPaaomanLyhennykset.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        assertEquals(odotettuSumma, suunnitelma.getSumma());
        assertEquals(odotettuKumulatiivinenKorko, suunnitelma.getKumulatiivinenKorko());
        assertEquals(suunnitelma.getLainanMaksuErat().stream().count(), 24);
        assertEquals(odotettuLainaPaaoma, suunnitelma.getLainaPaaoma());
        assertEquals(onEriSummiaLainaPaaomanLyhennyksissa, true);
        BigDecimal virheMarginaali = new BigDecimal("0.10");
        assertEquals(kokonaisLyhennys.doubleValue(), odotettuLainaPaaoma.doubleValue(), virheMarginaali.doubleValue());
    }

    @Test
    void teeLainanMaksuSuunnitelmaTasaLyhennyksella_normaaliTilanne_oikeatArvot() {
        BigDecimal paaoma = new BigDecimal(20000);
        VuosiKorko korko = new VuosiKorko(10);
        int maksuaika = 24;
        int maksuvali = 1;

        LainaLaskuri lainaLaskuri = LainaLaskuriImpl.getInstance();

        LainanMaksuSuunnitelma suunnitelma = lainaLaskuri.teeLainanMaksuSuunnitelmaTasaLyhennyksella(
                paaoma, korko, maksuaika, maksuvali);

        BigDecimal odotettuSumma = new BigDecimal("22083.33").setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal odotettuKumulatiivinenKorko = new BigDecimal("2083.33").setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal odotettuLainaPaaoma = new BigDecimal(20000).setScale(2, BigDecimal.ROUND_HALF_UP);
        List<BigDecimal> lainaPaaomanLyhennykset = suunnitelma.getLainanMaksuErat().stream()
                .map(LainanMaksuEra::getLainaPaaomanLyhennysEra).collect(Collectors.toList());
        boolean onEriSummiaLainaPaaomanLyhennyksissa = lainaPaaomanLyhennykset.stream().distinct().count() > 1;
        BigDecimal kokonaisLyhennys = lainaPaaomanLyhennykset.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        assertEquals(odotettuSumma, suunnitelma.getSumma());
        assertEquals(odotettuKumulatiivinenKorko, suunnitelma.getKumulatiivinenKorko());
        assertEquals(suunnitelma.getLainanMaksuErat().stream().count(), 24);
        assertEquals(odotettuLainaPaaoma, suunnitelma.getLainaPaaoma());
        assertEquals(onEriSummiaLainaPaaomanLyhennyksissa, false);
        BigDecimal virheMarginaali = new BigDecimal("0.10");
        assertEquals(kokonaisLyhennys.doubleValue(), odotettuLainaPaaoma.doubleValue(), virheMarginaali.doubleValue());
    }

    @Test
    void breakBuild() {
        assertEquals(false, true);
    }
    
}
