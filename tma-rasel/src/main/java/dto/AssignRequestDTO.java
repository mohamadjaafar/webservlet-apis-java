package dto;

public class AssignRequestDTO {
    private Long transId;
    private int fromEntityId;
    private int toEntityId;
    private int fromPersonId;
    private int toPersonId;
    private int processId;
    private int confidId;
    private int priorityNo;
//    private List<Copy> copies;
    private boolean followTrans;
//    private FollowTransData followTransData;

    public AssignRequestDTO() {
    	
    }
    // Constructor
    public AssignRequestDTO(Long transId, int fromEntityId, int toEntityId, int fromPersonId, int toPersonId, int processId, int confidId, int priorityNo, boolean followTrans) {
        this.transId = transId;
        this.fromEntityId = fromEntityId;
        this.toEntityId = toEntityId;
        this.fromPersonId = fromPersonId;
        this.toPersonId = toPersonId;
        this.processId = processId;
        this.confidId = confidId;
        this.priorityNo = priorityNo;
//        this.copies = copies;
        this.followTrans = followTrans;
//        this.followTransData = followTransData;
    }

    // Getters and Setters
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public int getFromEntityId() {
        return fromEntityId;
    }

    public void setFromEntityId(int fromEntityId) {
        this.fromEntityId = fromEntityId;
    }

    public int getToEntityId() {
        return toEntityId;
    }

    public void setToEntityId(int toEntityId) {
        this.toEntityId = toEntityId;
    }

    public int getFromPersonId() {
        return fromPersonId;
    }

    public void setFromPersonId(int fromPersonId) {
        this.fromPersonId = fromPersonId;
    }

    public int getToPersonId() {
        return toPersonId;
    }

    public void setToPersonId(int toPersonId) {
        this.toPersonId = toPersonId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getConfidId() {
        return confidId;
    }

    public void setConfidId(int confidId) {
        this.confidId = confidId;
    }

    public int getPriorityNo() {
        return priorityNo;
    }

    public void setPriorityNo(int priorityNo) {
        this.priorityNo = priorityNo;
    }

    public boolean isFollowTrans() {
        return followTrans;
    }

    public void setFollowTrans(boolean followTrans) {
        this.followTrans = followTrans;
    }
    
//    public List<Copy> getCopies() {
//        return copies;
//    }
//
//    public void setCopies(List<Copy> copies) {
//        this.copies = copies;
//    }


//    public FollowTransData getFollowTransData() {
//        return followTransData;
//    }
//
//    public void setFollowTransData(FollowTransData followTransData) {
//        this.followTransData = followTransData;
//    }
}
