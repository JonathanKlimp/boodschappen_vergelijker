package jonathan.jaron.boodschappenVergelijkerBackend.model;

import jakarta.persistence.*;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String n;
    String l;
    double p;
    String s;
    @ManyToOne
    Supermarkt supermarkt;

    public Supermarkt getSupermarkt() {
        return supermarkt;
    }

    public void setSupermarkt(Supermarkt supermarkt) {
        this.supermarkt = supermarkt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", n='" + n + '\'' +
                ", l='" + l + '\'' +
                ", p=" + p +
                ", s='" + s + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
