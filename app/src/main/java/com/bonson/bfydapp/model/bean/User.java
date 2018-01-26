package com.bonson.bfydapp.model.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity
public class User {
    public static User user;
    @PrimaryKey
    @NonNull
    private String fid;
    private String faccount;
    private String faddress;
    private String faname;
    private String farea;
    private String fareaname;
    private String fbirth;
    private String fbirthday;
    private String fblood;
    private String fcity;
    private String fcname;
    private String fcode;
    private String fctime;
    private String feid;
    private String fequis;
    private String fhealth;
    private String fheight;
    private String fimg;
    private String flag;
    private String fmobile;
    private String fmsg;
    private String fname;
    private String fnickname;
    private String fnoRead;
    private String fpassword;
    private String fpic;
    private String fpname;
    private String fprovince;
    private String fresult;
    private String fsex;
    private String fsid;
    private String fsignature;
    private String fstate;
    private String fstepsNumber;
    private String ftag;
    private String futime;
    private String fweight;
    private String htmdynamic;
    private String isjoin;
    @Ignore
    private List<Menu> menu;
    private String mthdynamic;
    private String submobile;
    private String token;
    private String type;

    public String getFaccount() {
        return faccount;
    }

    public void setFaccount(String faccount) {
        this.faccount = faccount;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public String getFaname() {
        return faname;
    }

    public void setFaname(String faname) {
        this.faname = faname;
    }

    public String getFarea() {
        return farea;
    }

    public void setFarea(String farea) {
        this.farea = farea;
    }

    public String getFareaname() {
        return fareaname;
    }

    public void setFareaname(String fareaname) {
        this.fareaname = fareaname;
    }

    public String getFbirth() {
        return fbirth;
    }

    public void setFbirth(String fbirth) {
        this.fbirth = fbirth;
    }

    public String getFbirthday() {
        return fbirthday;
    }

    public void setFbirthday(String fbirthday) {
        this.fbirthday = fbirthday;
    }

    public String getFblood() {
        return fblood;
    }

    public void setFblood(String fblood) {
        this.fblood = fblood;
    }

    public String getFcity() {
        return fcity;
    }

    public void setFcity(String fcity) {
        this.fcity = fcity;
    }

    public String getFcname() {
        return fcname;
    }

    public void setFcname(String fcname) {
        this.fcname = fcname;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getFctime() {
        return fctime;
    }

    public void setFctime(String fctime) {
        this.fctime = fctime;
    }

    public String getFeid() {
        return feid;
    }

    public void setFeid(String feid) {
        this.feid = feid;
    }

    public String getFequis() {
        return fequis;
    }

    public void setFequis(String fequis) {
        this.fequis = fequis;
    }

    public String getFhealth() {
        return fhealth;
    }

    public void setFhealth(String fhealth) {
        this.fhealth = fhealth;
    }

    public String getFheight() {
        return fheight;
    }

    public void setFheight(String fheight) {
        this.fheight = fheight;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFimg() {
        return fimg;
    }

    public void setFimg(String fimg) {
        this.fimg = fimg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFmobile() {
        return fmobile;
    }

    public void setFmobile(String fmobile) {
        this.fmobile = fmobile;
    }

    public String getFmsg() {
        return fmsg;
    }

    public void setFmsg(String fmsg) {
        this.fmsg = fmsg;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFnickname() {
        return fnickname;
    }

    public void setFnickname(String fnickname) {
        this.fnickname = fnickname;
    }

    public String getFnoRead() {
        return fnoRead;
    }

    public void setFnoRead(String fnoRead) {
        this.fnoRead = fnoRead;
    }

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword;
    }

    public String getFpic() {
        return fpic;
    }

    public void setFpic(String fpic) {
        this.fpic = fpic;
    }

    public String getFpname() {
        return fpname;
    }

    public void setFpname(String fpname) {
        this.fpname = fpname;
    }

    public String getFprovince() {
        return fprovince;
    }

    public void setFprovince(String fprovince) {
        this.fprovince = fprovince;
    }

    public String getFresult() {
        return fresult;
    }

    public void setFresult(String fresult) {
        this.fresult = fresult;
    }

    public String getFsex() {
        return fsex;
    }

    public void setFsex(String fsex) {
        this.fsex = fsex;
    }

    public String getFsid() {
        return fsid;
    }

    public void setFsid(String fsid) {
        this.fsid = fsid;
    }

    public String getFsignature() {
        return fsignature;
    }

    public void setFsignature(String fsignature) {
        this.fsignature = fsignature;
    }

    public String getFstate() {
        return fstate;
    }

    public void setFstate(String fstate) {
        this.fstate = fstate;
    }

    public String getFstepsNumber() {
        return fstepsNumber;
    }

    public void setFstepsNumber(String fstepsNumber) {
        this.fstepsNumber = fstepsNumber;
    }

    public String getFtag() {
        return ftag;
    }

    public void setFtag(String ftag) {
        this.ftag = ftag;
    }

    public String getFutime() {
        return futime;
    }

    public void setFutime(String futime) {
        this.futime = futime;
    }

    public String getFweight() {
        return fweight;
    }

    public void setFweight(String fweight) {
        this.fweight = fweight;
    }

    public String getHtmdynamic() {
        return htmdynamic;
    }

    public void setHtmdynamic(String htmdynamic) {
        this.htmdynamic = htmdynamic;
    }

    public String getIsjoin() {
        return isjoin;
    }

    public void setIsjoin(String isjoin) {
        this.isjoin = isjoin;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public String getMthdynamic() {
        return mthdynamic;
    }

    public void setMthdynamic(String mthdynamic) {
        this.mthdynamic = mthdynamic;
    }

    public String getSubmobile() {
        return submobile;
    }

    public void setSubmobile(String submobile) {
        this.submobile = submobile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
