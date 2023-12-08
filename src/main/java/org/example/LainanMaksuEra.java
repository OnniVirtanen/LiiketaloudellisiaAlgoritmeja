package org.example;

import java.math.BigDecimal;

public class LainanMaksuEra {

    private int kuukausi;
    private BigDecimal lainaPaaoma;
    private BigDecimal lainaPaaomanLyhennysEra;
    private BigDecimal koronOsuus;
    private BigDecimal summa;
    private Integer lyhennyksenLkm;

    public LainanMaksuEra() {
    }

    public LainanMaksuEra(int kuukausi, BigDecimal lainaPaaoma, BigDecimal lainaPaaomanLyhennysEra,
                          BigDecimal koronOsuus, BigDecimal summa, Integer lyhennyksenLkm) {
        this.kuukausi = kuukausi;
        this.lainaPaaoma = lainaPaaoma;
        this.lainaPaaomanLyhennysEra = lainaPaaomanLyhennysEra;
        this.koronOsuus = koronOsuus;
        this.summa = summa;
        this.lyhennyksenLkm = lyhennyksenLkm;
    }

    public int getKuukausi() {
        return kuukausi;
    }

    public void setKuukausi(int kuukausi) {
        this.kuukausi = kuukausi;
    }

    public BigDecimal getLainaPaaoma() {
        return lainaPaaoma;
    }

    public void setLainaPaaoma(BigDecimal lainaPaaoma) {
        this.lainaPaaoma = lainaPaaoma;
    }

    public BigDecimal getLainaPaaomanLyhennysEra() {
        return lainaPaaomanLyhennysEra;
    }

    public void setLainaPaaomanLyhennysEra(BigDecimal lainaPaaomanLyhennysEra) {
        this.lainaPaaomanLyhennysEra = lainaPaaomanLyhennysEra;
    }

    public BigDecimal getKoronOsuus() {
        return koronOsuus;
    }

    public void setKoronOsuus(BigDecimal koronOsuus) {
        this.koronOsuus = koronOsuus;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public Integer getLyhennyksenLkm() {
        return lyhennyksenLkm;
    }

    public void setLyhennyksenLkm(Integer lyhennyksenLkm) {
        this.lyhennyksenLkm = lyhennyksenLkm;
    }

    @Override
    public String toString() {
        return "LainanMaksuEra{" +
                "kuukausi=" + kuukausi +
                ", lainaPaaoma=" + lainaPaaoma +
                ", lainaPaaomanLyhennysEra=" + lainaPaaomanLyhennysEra +
                ", koronOsuus=" + koronOsuus +
                ", summa=" + summa +
                ", lyhennyksenLkm=" + lyhennyksenLkm +
                '}';
    }
}
