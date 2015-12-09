package com.haw.praktikum.model;

public class Personal {

    private String vorname;
    private String nachname;
    private Gehaltsstufe gehaltsstufe;

    public Personal(final String vorname, final String nachname, final Gehaltsstufe gehaltsstufe) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.gehaltsstufe = gehaltsstufe;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(final String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(final String vorname) {
        this.vorname = vorname;
    }

    public Gehaltsstufe getGehaltsstufe() {
        return gehaltsstufe;
    }

    public void setGehaltsstufe(final Gehaltsstufe gehaltsstufe) {
        this.gehaltsstufe = gehaltsstufe;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", getVorname(), getNachname(), getGehaltsstufe());
    }
}
