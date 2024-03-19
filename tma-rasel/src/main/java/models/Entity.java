package models;
import java.util.List;

public class Entity{
    private int id;
    private boolean isCabinet;
    private boolean externalSend;
    private boolean externalReceive;
    private int importantParent;
    private Integer parentId;
    private String lineage;
    private boolean active;
    private String description;
    private String userDefinedId;
    private int cabinetId;
    private String name;
    private boolean actionTrace;
    private int replaceByChild;
    private String barCodeSymbol;
    private List<String> persons;
    private List<String> childs;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCabinet() {
        return isCabinet;
    }

    public void setCabinet(boolean cabinet) {
        isCabinet = cabinet;
    }

    public boolean isExternalSend() {
        return externalSend;
    }

    public void setExternalSend(boolean externalSend) {
        this.externalSend = externalSend;
    }

    public boolean isExternalReceive() {
        return externalReceive;
    }

    public void setExternalReceive(boolean externalReceive) {
        this.externalReceive = externalReceive;
    }

    public int getImportantParent() {
        return importantParent;
    }

    public void setImportantParent(int importantParent) {
        this.importantParent = importantParent;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLineage() {
        return lineage;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserDefinedId() {
        return userDefinedId;
    }

    public void setUserDefinedId(String userDefinedId) {
        this.userDefinedId = userDefinedId;
    }

    public int getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(int cabinetId) {
        this.cabinetId = cabinetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActionTrace() {
        return actionTrace;
    }

    public void setActionTrace(boolean actionTrace) {
        this.actionTrace = actionTrace;
    }

    public int getReplaceByChild() {
        return replaceByChild;
    }

    public void setReplaceByChild(int replaceByChild) {
        this.replaceByChild = replaceByChild;
    }

    public String getBarCodeSymbol() {
        return barCodeSymbol;
    }

    public void setBarCodeSymbol(String barCodeSymbol) {
        this.barCodeSymbol = barCodeSymbol;
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    public List<String> getChilds() {
        return childs;
    }

    public void setChilds(List<String> childs) {
        this.childs = childs;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", isCabinet=" + isCabinet +
                ", externalSend=" + externalSend +
                ", externalReceive=" + externalReceive +
                ", importantParent=" + importantParent +
                ", parentId=" + parentId +
                ", lineage='" + lineage + '\'' +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", userDefinedId='" + userDefinedId + '\'' +
                ", cabinetId=" + cabinetId +
                ", name='" + name + '\'' +
                ", actionTrace=" + actionTrace +
                ", replaceByChild=" + replaceByChild +
                ", barCodeSymbol='" + barCodeSymbol + '\'' +
                ", persons=" + persons +
                ", childs=" + childs +
                '}';
    }
}
