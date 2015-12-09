package com.haw.praktikum.model;

public class Gehalt {

    private Gehaltsstufe gehaltsstufe;
    private Integer betrag;

    public Gehaltsstufe getGehaltsstufe() {
        return this.gehaltsstufe;
    }

    public void setGehaltsstufe(final Gehaltsstufe gehaltsstufe) {
        this.gehaltsstufe = gehaltsstufe;
    }

    public Integer getBetrag() {
        return this.betrag;
    }

    public void setBetrag(final Integer betrag) {
        this.betrag = betrag;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", getGehaltsstufe(), getBetrag());
    }
}
