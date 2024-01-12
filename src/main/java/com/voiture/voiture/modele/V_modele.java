package com.voiture.voiture.modele;

public class V_modele {
    int idmodele;
    String modele;
    int idmarque;
    String marque;
    public V_modele(String modele, int idmodele, int idmarque, String marque) {
        this.modele = modele;
        this.idmodele = idmodele;
        this.idmarque = idmarque;
        this.marque = marque;
    }
    public V_modele() {
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public int getIdmodele() {
        return idmodele;
    }
    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }
    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
}
