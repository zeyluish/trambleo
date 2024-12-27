package org.example.trambleo;

import java.util.UUID;

public class sousTache {
    UUID idSousTache;
    String nomSousTache;
    String descriptionSousTache;
    boolean isChecked;

    public sousTache(UUID idSousTache, String nomSousTache, String descriptionSousTache, boolean isChecked) {
        this.idSousTache = idSousTache;
        this.nomSousTache = nomSousTache;
        this.descriptionSousTache = descriptionSousTache;
        this.isChecked = isChecked;
    }

    public String toString(){
        return "identifiant : " + idSousTache + ", nom :" + nomSousTache + ", description :" + descriptionSousTache + ", est completé ?  :" + isChecked;
    }

    // <editor-fold desc="Getter and setter">
    public UUID getIdSousTache() {
        return idSousTache;
    }

    public void setIdSousTache(UUID idSousTache) {
        this.idSousTache = idSousTache;
    }

    public String getNomSousTache() {
        return nomSousTache;
    }

    public void setNomSousTache(String nomSousTache) {
        this.nomSousTache = nomSousTache;
    }

    public String getDescriptionSousTache() {
        return descriptionSousTache;
    }

    public void setDescriptionSousTache(String descriptionSousTache) {
        this.descriptionSousTache = descriptionSousTache;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    // </editor-fold>
}
