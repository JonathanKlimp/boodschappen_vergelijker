package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Supermarkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String n;
    String u;
    String c;
    String i;
    @OneToMany(mappedBy = "supermarkt", cascade = CascadeType.ALL)
    List<Product> d;

    public String getN() {
        return n;
    }

    @Override
    public String toString() {
        return "Supermarkt{" +
                "id=" + id +
                ", n='" + n + '\'' +
                ", u='" + u + '\'' +
                ", c='" + c + '\'' +
                ", i='" + i + '\'' +
                '}';
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public List<Product> getD() {
        return d;
    }

    public void setD(List<Product> d) {
        this.d = d;
    }
}
