package HomeWorkSpring.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="purchase")
public class Purchase {
    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name="id_buyer")
    private Buyer buyer;

    @Column(name="date")
    private String date;

    @Column(name="cost")
    private Integer cost;

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", product=" + product +
                ", buyer=" + buyer +
                ", date='" + date + '\'' +
                ", cost=" + cost +
                '}';
    }
}
