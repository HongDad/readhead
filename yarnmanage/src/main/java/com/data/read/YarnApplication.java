package com.data.read;



public class YarnApplication {

    private String id;
    private String user;
    private String name;
    private String applicationType;
    private Long startedTime;
    /**
     * 
     */
   private String AllocatedCPUVCores;
   private String  AllocatedMemoryMB;


    public YarnApplication( ) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.applicationType = applicationType;
        this.startedTime = startedTime;
        this.AllocatedCPUVCores = AllocatedCPUVCores;
        this.AllocatedMemoryMB = AllocatedMemoryMB;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setStartedTime(Long startedTime) {
        this.startedTime = startedTime;
    }

    public Long getStartedTime() {
        return startedTime;
    }
}
