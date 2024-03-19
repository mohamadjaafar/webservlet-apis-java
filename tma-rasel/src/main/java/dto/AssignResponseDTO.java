package dto;

public class AssignResponseDTO {
    private int userId;
    private int defaultEntityId;
    private String userName;
    private String userFullName;
    private String defaultEntityName;
    private String userEntity;
    private String code;
    private String description;

    // Constructor
    public AssignResponseDTO() {
        // Default constructor
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDefaultEntityId() {
        return defaultEntityId;
    }

    public void setDefaultEntityId(int defaultEntityId) {
        this.defaultEntityId = defaultEntityId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getDefaultEntityName() {
        return defaultEntityName;
    }

    public void setDefaultEntityName(String defaultEntityName) {
        this.defaultEntityName = defaultEntityName;
    }

    public String getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(String userEntity) {
        this.userEntity = userEntity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
