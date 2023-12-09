package org.example.laina.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;

public class LainanMaksuEra implements Serializable {

    private static final long serialVersionUID = 1L;

    private int kuukausi;
    private BigDecimal lainaPaaoma;
    private BigDecimal lainaPaaomanLyhennysEra;
    private BigDecimal koronOsuus;
    private BigDecimal summa;
    private Integer lyhennyksenLkm;

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

    public BigDecimal getLainaPaaoma() {
        return lainaPaaoma;
    }

    public BigDecimal getLainaPaaomanLyhennysEra() {
        return lainaPaaomanLyhennysEra;
    }

    public BigDecimal getKoronOsuus() {
        return koronOsuus;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public Integer getLyhennyksenLkm() {
        return lyhennyksenLkm;
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
