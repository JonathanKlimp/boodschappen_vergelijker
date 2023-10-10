package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Supermarkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String naam;
    String url;
    @JsonProperty("merk_naam")
    String merkNaam;
    @JsonProperty("logo_url")
    String logoUrl;

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMerkNaam() {
        return merkNaam;
    }

    public void setMerkNaam(String merkNaam) {
        this.merkNaam = merkNaam;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
