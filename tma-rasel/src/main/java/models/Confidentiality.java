package models;

public class Confidentiality extends BaseEntity {
    private String confidentlalityDescription;


    public String getConfidentialityDescription() {
        return confidentlalityDescription;
    }

    public void setConfidentialityDescription(String statusDescription) {
        this.confidentlalityDescription = statusDescription;
    }

}
