package models;

public class ArchiveRecord {
    private int status;
    private int attachRecordId;
    private int transId;
    private int method;
    private int type;
    private int docId;
    private int securityLevel;
    private String securityLevelDesc;
    private String title;
    private String user;
    private String date;
    private int userId;
    private String fileName;
    private String mimeContent;
    private int rowStatus;
    private Object docData;
    private String lastModifiedOn;

    // Constructor
    public ArchiveRecord() {
        // Default constructor
    }

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAttachRecordId() {
        return attachRecordId;
    }

    public void setAttachRecordId(int attachRecordId) {
        this.attachRecordId = attachRecordId;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getSecurityLevelDesc() {
        return securityLevelDesc;
    }

    public void setSecurityLevelDesc(String securityLevelDesc) {
        this.securityLevelDesc = securityLevelDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeContent() {
        return mimeContent;
    }

    public void setMimeContent(String mimeContent) {
        this.mimeContent = mimeContent;
    }

    public int getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(int rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Object getDocData() {
        return docData;
    }

    public void setDocData(Object docData) {
        this.docData = docData;
    }

    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
}
