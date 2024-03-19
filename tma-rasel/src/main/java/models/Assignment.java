package models;

import java.time.LocalDate;

public class Assignment {
    private int id;
    private String fromPerson;
    private String fromEntity;
    private String toPerson;
    private String toEntity;
    private LocalDate date;
    private String processName;

    public Assignment() {
    	
    }
  


    public Assignment(String fromPerson, String fromEntity, String toPerson, String toEntity, LocalDate date,
			String processName) {
		super();
		this.fromPerson = fromPerson;
		this.fromEntity = fromEntity;
		this.toPerson = toPerson;
		this.toEntity = toEntity;
		this.date = date;
		this.processName = processName;
	}




	public String getFromPerson() {
		return fromPerson;
	}




	public void setFromPerson(String fromPerson) {
		this.fromPerson = fromPerson;
	}




	public String getFromEntity() {
		return fromEntity;
	}




	public void setFromEntity(String fromEntity) {
		this.fromEntity = fromEntity;
	}




	public String getToPerson() {
		return toPerson;
	}




	public void setToPerson(String toPerson) {
		this.toPerson = toPerson;
	}




	public String getToEntity() {
		return toEntity;
	}




	public void setToEntity(String toEntity) {
		this.toEntity = toEntity;
	}




	public LocalDate getDate() {
		return date;
	}




	public void setDate(LocalDate date) {
		this.date = date;
	}




	public String getProcessName() {
		return processName;
	}




	public void setProcessName(String processName) {
		this.processName = processName;
	}

	// toString method to represent object as a String
    @Override
    public String toString() {
        return "Assignment{" +
                "fromPerson='" + fromPerson + '\'' +
                ", oldStructure='" + fromEntity + '\'' +
                ", toPerson='" + toPerson + '\'' +
                ", governorateOffice='" + toEntity + '\'' +
                ", date='" + date + '\'' +
                ", processName='" + processName + '\'' +
                '}';
    }




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}

}
