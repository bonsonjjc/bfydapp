package com.bonson.bfydapp.model.bean;

public class Motion {
    private String id = "";
    private String feid = "";
    private String fdistance = "";
    private String fstepsNumber = "";
    private String fconsume = "";
    private String fwalkingDistance = "";
    private String fwalkingTimeLong = "";
    private String fwalkingConsume = "";
    private String frunDistance = "";
    private String frunTimeLong = "";
    private String frunConsume = "";
    private String fplanStepNumber = "";
    private String fdate = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeid() {
        return feid;
    }

    public void setFeid(String feid) {
        this.feid = feid;
    }

    public String getFdistance() {
        return fdistance;
    }

    public void setFdistance(String fdistance) {
        this.fdistance = fdistance;
    }

    public String getFstepsNumber() {
        return fstepsNumber;
    }

    public void setFstepsNumber(String fstepsNumber) {
        this.fstepsNumber = fstepsNumber;
    }

    public String getFconsume() {
        return fconsume;
    }

    public void setFconsume(String fconsume) {
        this.fconsume = fconsume;
    }

    public String getFwalkingDistance() {
        return fwalkingDistance;
    }

    public void setFwalkingDistance(String fwalkingDistance) {
        this.fwalkingDistance = fwalkingDistance;
    }

    public String getFwalkingTimeLong() {
        return fwalkingTimeLong;
    }

    public void setFwalkingTimeLong(String fwalkingTimeLong) {
        this.fwalkingTimeLong = fwalkingTimeLong;
    }

    public String getFwalkingConsume() {
        return fwalkingConsume;
    }

    public void setFwalkingConsume(String fwalkingConsume) {
        this.fwalkingConsume = fwalkingConsume;
    }

    public String getFrunDistance() {
        return frunDistance;
    }

    public void setFrunDistance(String frunDistance) {
        this.frunDistance = frunDistance;
    }

    public String getFrunTimeLong() {
        return frunTimeLong;
    }

    public void setFrunTimeLong(String frunTimeLong) {
        this.frunTimeLong = frunTimeLong;
    }

    public String getFrunConsume() {
        return frunConsume;
    }

    public void setFrunConsume(String frunConsume) {
        this.frunConsume = frunConsume;
    }

    public String getFplanStepNumber() {
        return fplanStepNumber;
    }

    public void setFplanStepNumber(String fplanStepNumber) {
        this.fplanStepNumber = fplanStepNumber;
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate;
    }

    @Override
    public String toString() {
        return "Motion{" +
                "id='" + id + '\'' +
                ", feid='" + feid + '\'' +
                ", fdistance='" + fdistance + '\'' +
                ", fstepsNumber='" + fstepsNumber + '\'' +
                ", fconsume='" + fconsume + '\'' +
                ", fwalkingDistance='" + fwalkingDistance + '\'' +
                ", fwalkingTimeLong='" + fwalkingTimeLong + '\'' +
                ", fwalkingConsume='" + fwalkingConsume + '\'' +
                ", frunDistance='" + frunDistance + '\'' +
                ", frunTimeLong='" + frunTimeLong + '\'' +
                ", frunConsume='" + frunConsume + '\'' +
                ", fplanStepNumber='" + fplanStepNumber + '\'' +
                ", fdate='" + fdate + '\'' +
                '}';
    }
}
