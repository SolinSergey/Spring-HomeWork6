package HomeWorkSpring.dao;

public class SimplePurchase {
    private String name;
    private String title;
    private int cost;

    public SimplePurchase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "SimplePurchase{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
