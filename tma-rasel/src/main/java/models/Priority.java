package models;

public class Priority extends BaseEntity {
    private String priorityDescription;

    public String getPriorityDescription() {
        return priorityDescription;
    }

    public void setPriorityDescription(String statusDescription) {
        this.priorityDescription = statusDescription;
    }

}
