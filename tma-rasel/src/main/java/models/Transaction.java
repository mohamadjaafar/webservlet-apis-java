package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
	private long transVwTransId;
    private int transVwTransNo;
    private Entity entity;
    private Status status;
    private Priority priority;
    private Confidentiality confidentiality;
    private SourceType sourceType;
    private ExternalPraty externalParty;
    private Timestamp transVwTransDate;
    private String transVwPersonDesc;
    private String transVwConfidentialConfidDesc;
    private String transVwPriorityDesc;
    private String transVwStatusDesc;
    private String transVwSubject;
    private String transVwSourceDesc;
    private String transVwInOutDest;
    private String fullTransNo;
    private boolean isFlaged;
    private boolean canView;
    private int assignToEntityId;
    private int createdByEntityId;
    private int createdByPersonId;
    private Timestamp remindDate;
    private String description;
    private int processId;
	private int transVwTransSourceId;
    private long transVwTransDateHj;
    private int transVwConcernedEntityId;
    private String transVwEntityDesc;
    private int transVwConfidId;
    private int priorityNo;
    private String transVwLinkTypeDesc;
    private String transVwAbbrAr;
    private int transVwTransCategory;
    private String transVwRemarksAr;
    private String transVwCityName;
    private String inquiryStatus;
    private String tabId;
    private String extTransNo;
    private String subjectType;
    private String dateDifference;
    private int typeId;
    private String groupId;
    private int archived;
    private String creatingCabinetUserDefined;
    private int includedItemsNumber;
    private String assignToEntityName;
    private int isOwner;
    private String oldSysTransNo;
    private int needEncrypt;
    private boolean isInternalOutbound;
    private boolean isParticular;
    private long remindDateHj;
    private AssignTrack assignTrack;
    /////////////////////////////////
    private boolean outboundDraft;
    private int initialAssignToPersonId;
    private String initialAssignToPersonName;
    private int mainPartyId;
    private String mainPartyDesc;
    private int concernedEntityId;
    private String concernedEntityDesc;
    private int userId;
    private String creatorUserName; 
    private String creatingEntityName;
    private int barcodeRand;
    private int prevElcEntityId;
    private String prevElcEntityName;
    private int prevElcPersonId;
    private String prevElcPersonname;
    private int mainSubjectId;
    private int mainSubjectText;
    private String assignEntity;
    private List<Copy> transCopies = new ArrayList<Copy>();
    private List<ArchiveRecord> archiveRecords = new ArrayList<ArchiveRecord>();
    private List<PredefinedAssignee> predefinedAssignees = new ArrayList<PredefinedAssignee>();
    

    public boolean isOutboundDraft() {
		return outboundDraft;
	}
	public void setOutboundDraft(boolean outboundDraft) {
		this.outboundDraft = outboundDraft;
	}
	public int getInitialAssignToPersonId() {
		return initialAssignToPersonId;
	}
	public void setInitialAssignToPersonId(int initialAssignToPersonId) {
		this.initialAssignToPersonId = initialAssignToPersonId;
	}
	public String getInitialAssignToPersonName() {
		return initialAssignToPersonName;
	}
	public void setInitialAssignToPersonName(String initialAssignToPersonName) {
		this.initialAssignToPersonName = initialAssignToPersonName;
	}
	public int getMainPartyId() {
		return mainPartyId;
	}
	public void setMainPartyId(int mainPartyId) {
		this.mainPartyId = mainPartyId;
	}
	public String getMainPartyDesc() {
		return mainPartyDesc;
	}
	public void setMainPartyDesc(String mainPartyDesc) {
		this.mainPartyDesc = mainPartyDesc;
	}
	public int getConcernedEntityId() {
		return concernedEntityId;
	}
	public void setConcernedEntityId(int concernedEntityId) {
		this.concernedEntityId = concernedEntityId;
	}
	public String getConcernedEntityDesc() {
		return concernedEntityDesc;
	}
	public void setConcernedEntityDesc(String concernedEntityDesc) {
		this.concernedEntityDesc = concernedEntityDesc;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCreatorUserName() {
		return creatorUserName;
	}
	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}
	public String getCreatingEntityName() {
		return creatingEntityName;
	}
	public void setCreatingEntityName(String creatingEntityName) {
		this.creatingEntityName = creatingEntityName;
	}
	public int getBarcodeRand() {
		return barcodeRand;
	}
	public void setBarcodeRand(int barcodeRand) {
		this.barcodeRand = barcodeRand;
	}
	public int getPrevElcEntityId() {
		return prevElcEntityId;
	}
	public void setPrevElcEntityId(int prevElcEntityId) {
		this.prevElcEntityId = prevElcEntityId;
	}
	public String getPrevElcEntityName() {
		return prevElcEntityName;
	}
	public void setPrevElcEntityName(String prevElcEntityName) {
		this.prevElcEntityName = prevElcEntityName;
	}
	public int getPrevElcPersonId() {
		return prevElcPersonId;
	}
	public void setPrevElcPersonId(int prevElcPersonId) {
		this.prevElcPersonId = prevElcPersonId;
	}
	public String getPrevElcPersonname() {
		return prevElcPersonname;
	}
	public void setPrevElcPersonname(String prevElcPersonname) {
		this.prevElcPersonname = prevElcPersonname;
	}
	public int getMainSubjectId() {
		return mainSubjectId;
	}
	public void setMainSubjectId(int mainSubjectId) {
		this.mainSubjectId = mainSubjectId;
	}
	public int getMainSubjectText() {
		return mainSubjectText;
	}
	public void setMainSubjectText(int mainSubjectText) {
		this.mainSubjectText = mainSubjectText;
	}
	public String getAssignEntity() {
		return assignEntity;
	}
	public void setAssignEntity(String assignEntity) {
		this.assignEntity = assignEntity;
	}
	public List<Copy> getTransCopies() {
		return transCopies;
	}
	public void setTransCopies(List<Copy> transCopies) {
		this.transCopies = transCopies;
	}
	public List<ArchiveRecord> getArchiveRecords() {
		return archiveRecords;
	}
	public void setArchiveRecords(List<ArchiveRecord> archiveRecords) {
		this.archiveRecords = archiveRecords;
	}
	public List<PredefinedAssignee> getPredefinedAssignees() {
		return predefinedAssignees;
	}
	public void setPredefinedAssignees(List<PredefinedAssignee> predefinedAssignees) {
		this.predefinedAssignees = predefinedAssignees;
	}
	public int getTransVwTransSourceId() {
		return transVwTransSourceId;
	}
	public void setTransVwTransSourceId(int transVwTransSourceId) {
		this.transVwTransSourceId = transVwTransSourceId;
	}
	public long getTransVwTransDateHj() {
		return transVwTransDateHj;
	}
	public void setTransVwTransDateHj(long transVwTransDateHj) {
		this.transVwTransDateHj = transVwTransDateHj;
	}
	public int getTransVwConcernedEntityId() {
		return transVwConcernedEntityId;
	}
	public void setTransVwConcernedEntityId(int transVwConcernedEntityId) {
		this.transVwConcernedEntityId = transVwConcernedEntityId;
	}
	public String getTransVwEntityDesc() {
		return transVwEntityDesc;
	}
	public void setTransVwEntityDesc(String transVwEntityDesc) {
		this.transVwEntityDesc = transVwEntityDesc;
	}
	public int getTransVwConfidId() {
		return transVwConfidId;
	}
	public void setTransVwConfidId(int transVwConfidId) {
		this.transVwConfidId = transVwConfidId;
	}
	public int getPriorityNo() {
		return priorityNo;
	}
	public void setPriorityNo(int priorityNo) {
		this.priorityNo = priorityNo;
	}
	public String getTransVwLinkTypeDesc() {
		return transVwLinkTypeDesc;
	}
	public void setTransVwLinkTypeDesc(String transVwLinkTypeDesc) {
		this.transVwLinkTypeDesc = transVwLinkTypeDesc;
	}
	public String getTransVwAbbrAr() {
		return transVwAbbrAr;
	}
	public void setTransVwAbbrAr(String transVwAbbrAr) {
		this.transVwAbbrAr = transVwAbbrAr;
	}
	public int getTransVwTransCategory() {
		return transVwTransCategory;
	}
	public void setTransVwTransCategory(int transVwTransCategory) {
		this.transVwTransCategory = transVwTransCategory;
	}
	public String getTransVwRemarksAr() {
		return transVwRemarksAr;
	}
	public void setTransVwRemarksAr(String transVwRemarksAr) {
		this.transVwRemarksAr = transVwRemarksAr;
	}
	public String getTransVwCityName() {
		return transVwCityName;
	}
	public void setTransVwCityName(String transVwCityName) {
		this.transVwCityName = transVwCityName;
	}
	public String getInquiryStatus() {
		return inquiryStatus;
	}
	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}
	public String getTabId() {
		return tabId;
	}
	public void setTabId(String tabId) {
		this.tabId = tabId;
	}
	public String getExtTransNo() {
		return extTransNo;
	}
	public void setExtTransNo(String extTransNo) {
		this.extTransNo = extTransNo;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	public String getDateDifference() {
		return dateDifference;
	}
	public void setDateDifference(String dateDifference) {
		this.dateDifference = dateDifference;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public int getArchived() {
		return archived;
	}
	public void setArchived(int archived) {
		this.archived = archived;
	}
	public String getCreatingCabinetUserDefined() {
		return creatingCabinetUserDefined;
	}
	public void setCreatingCabinetUserDefined(String creatingCabinetUserDefined) {
		this.creatingCabinetUserDefined = creatingCabinetUserDefined;
	}
	public int getIncludedItemsNumber() {
		return includedItemsNumber;
	}
	public void setIncludedItemsNumber(int includedItemsNumber) {
		this.includedItemsNumber = includedItemsNumber;
	}
	public String getAssignToEntityName() {
		return assignToEntityName;
	}
	public void setAssignToEntityName(String assignToEntityName) {
		this.assignToEntityName = assignToEntityName;
	}
	public int getIsOwner() {
		return isOwner;
	}
	public void setIsOwner(int isOwner) {
		this.isOwner = isOwner;
	}
	public String getOldSysTransNo() {
		return oldSysTransNo;
	}
	public void setOldSysTransNo(String oldSysTransNo) {
		this.oldSysTransNo = oldSysTransNo;
	}
	public int getNeedEncrypt() {
		return needEncrypt;
	}
	public void setNeedEncrypt(int needEncrypt) {
		this.needEncrypt = needEncrypt;
	}
	public boolean isInternalOutbound() {
		return isInternalOutbound;
	}
	public void setInternalOutbound(boolean isInternalOutbound) {
		this.isInternalOutbound = isInternalOutbound;
	}
	public boolean isParticular() {
		return isParticular;
	}
	public void setParticular(boolean isParticular) {
		this.isParticular = isParticular;
	}
	public long getRemindDateHj() {
		return remindDateHj;
	}
	public void setRemindDateHj(long remindDateHj) {
		this.remindDateHj = remindDateHj;
	}
    
    public long getTransVwTransId() {
		return transVwTransId;
	}
	public void setTransVwTransId(long transVwTransId) {
		this.transVwTransId = transVwTransId;
	}
	public int getTransVwTransNo() {
		return transVwTransNo;
	}
	public void setTransVwTransNo(int transVwTransNo) {
		this.transVwTransNo = transVwTransNo;
	}
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Confidentiality getConfidentiality() {
		return confidentiality;
	}
	public void setConfidentiality(Confidentiality confidentiality) {
		this.confidentiality = confidentiality;
	}
	public SourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}
	public ExternalPraty getExternalParty() {
		return externalParty;
	}
	public void setExternalParty(ExternalPraty externalParty) {
		this.externalParty = externalParty;
	}
	public Timestamp getTransVwTransDate() {
		return transVwTransDate;
	}
	public void setTransVwTransDate(Timestamp transVwTransDate) {
		this.transVwTransDate = transVwTransDate;
	}
	public String getTransVwPersonDesc() {
		return transVwPersonDesc;
	}
	public void setTransVwPersonDesc(String transVwPersonDesc) {
		this.transVwPersonDesc = transVwPersonDesc;
	}
	public String getTransVwConfidentialConfidDesc() {
		return transVwConfidentialConfidDesc;
	}
	public void setTransVwConfidentialConfidDesc(String transVwConfidentialConfidDesc) {
		this.transVwConfidentialConfidDesc = transVwConfidentialConfidDesc;
	}
	public String getTransVwPriorityDesc() {
		return transVwPriorityDesc;
	}
	public void setTransVwPriorityDesc(String transVwPriorityDesc) {
		this.transVwPriorityDesc = transVwPriorityDesc;
	}
	public String getTransVwStatusDesc() {
		return transVwStatusDesc;
	}
	public void setTransVwStatusDesc(String transVwStatusDesc) {
		this.transVwStatusDesc = transVwStatusDesc;
	}
	public String getTransVwSubject() {
		return transVwSubject;
	}
	public void setTransVwSubject(String transVwSubject) {
		this.transVwSubject = transVwSubject;
	}
	public String getTransVwSourceDesc() {
		return transVwSourceDesc;
	}
	public void setTransVwSourceDesc(String transVwSourceDesc) {
		this.transVwSourceDesc = transVwSourceDesc;
	}
	public String getTransVwInOutDest() {
		return transVwInOutDest;
	}
	public void setTransVwInOutDest(String transVwInOutDest) {
		this.transVwInOutDest = transVwInOutDest;
	}
	public String getFullTransNo() {
		return fullTransNo;
	}
	public void setFullTransNo(String fullTransNo) {
		this.fullTransNo = fullTransNo;
	}
	public boolean isFlaged() {
		return isFlaged;
	}
	public void setFlaged(boolean isFlaged) {
		this.isFlaged = isFlaged;
	}
	public boolean isCanView() {
		return canView;
	}
	public void setCanView(boolean canView) {
		this.canView = canView;
	}
	public int getAssignToEntityId() {
		return assignToEntityId;
	}
	public void setAssignToEntityId(int assignToEntityId) {
		this.assignToEntityId = assignToEntityId;
	}
	public int getCreatedByEntityId() {
		return createdByEntityId;
	}
	public void setCreatedByEntityId(int createdByEntityId) {
		this.createdByEntityId = createdByEntityId;
	}
	public int getCreatedByPersonId() {
		return createdByPersonId;
	}
	public void setCreatedByPersonId(int createdByPersonId) {
		this.createdByPersonId = createdByPersonId;
	}
	public Timestamp getRemindDate() {
		return remindDate;
	}
	public void setRemindDate(Timestamp remindDate) {
		this.remindDate = remindDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
    // Getter and Setter
    public AssignTrack getAssignTrack() {
        return assignTrack;
    }

    public void setAssignTrack(AssignTrack assignTrack) {
        this.assignTrack = assignTrack;
    }
    
}

