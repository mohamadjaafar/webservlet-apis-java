package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AssignTrack {
    private int id;
    private String physicalEntity;
    private String elcEntity;
    private LocalDate physicalDate;
    private LocalDate elcDate;
    private List<Assignment> assignments = new ArrayList<Assignment>();

    // Constructor
    public AssignTrack(String physicalEntity, String elcEntity, LocalDate physicalDate, LocalDate elcDate, List<Assignment> assignments) {
        this.physicalEntity = physicalEntity;
        this.elcEntity = elcEntity;
        this.physicalDate = physicalDate;
        this.elcDate = elcDate;
        this.assignments = assignments;
    }

    public AssignTrack() {
	}

	// Getters and Setters
    public String getPhysicalEntity() {
        return physicalEntity;
    }

    public void setPhysicalEntity(String physicalEntity) {
        this.physicalEntity = physicalEntity;
    }

    public String getElcEntity() {
        return elcEntity;
    }

    public void setElcEntity(String elcEntity) {
        this.elcEntity = elcEntity;
    }

    public LocalDate getPhysicalDate() {
        return physicalDate;
    }

    public void setPhysicalDate(LocalDate physicalDate) {
        this.physicalDate = physicalDate;
    }

    public LocalDate getElcDate() {
        return elcDate;
    }

    public void setElcDate(LocalDate elcDate) {
        this.elcDate = elcDate;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    public void removeAssignment(Assignment assignment) {
        this.assignments.remove(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
