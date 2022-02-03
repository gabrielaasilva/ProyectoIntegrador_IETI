package co.escuelaing.labtasks.dto;

public class TaskDto {
    private String id;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;

    public TaskDto(){
    }

    public TaskDto(String id, String description,Status status, String assignedTo, String dueDate){
        this.assignedTo = assignedTo;
        this.id = id;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

  



    
}
