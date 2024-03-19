package models;


public class BaseEntity {
    private int id;
    
    private int transCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransCategory() {
        return transCategory;
    }

    public void setTransCategory(int transCategory) {
        this.transCategory = transCategory;
    }
}
