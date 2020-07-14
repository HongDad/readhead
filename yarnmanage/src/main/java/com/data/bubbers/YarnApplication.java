package com.data.bubbers;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class YarnApplication {

    private String id;
    private String user;
    private String name;
    private String applicationType;
    private String startedTime;
    private String status;
   private String AllocatedCPUVCores;
   private String  AllocatedMemoryMB;

    public YarnApplication() {
    }

    public YarnApplication(String id, String user, String name, String applicationType, String startedTime, String status, String allocatedCPUVCores, String allocatedMemoryMB) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.applicationType = applicationType;
        this.startedTime = startedTime;
        this.status = status;
        AllocatedCPUVCores = allocatedCPUVCores;
        AllocatedMemoryMB = allocatedMemoryMB;
    }







}
