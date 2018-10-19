package com.app;

public class Attendance {
    public String subname;
    public String rno;
    public String name;
    public int pdays;
    public int adays;
    public int totdays;

    public Attendance(){

    }

    public Attendance(String rno){
        this.rno=rno;
    }

    public Attendance(String rno,String subname,String name,int pdays,int adays,int totdays){
        this.rno=rno;
        this.subname=subname;
        this.name=name;
        this.pdays=pdays;
        this.adays=adays;
        this.totdays=totdays;
    }

    public Attendance(int pdays,int  adays,String rno){
        this.rno=rno;
        this.pdays=pdays;
        this.adays=adays;
    }

    public int getPdays(){
        return pdays;
    }
    public void setPdays(int pdays){
        this.pdays=pdays;
    }
    public int getAdays(){
        return adays;
    }
    public void setAdays(int adays){
        this.adays=adays;
    }
    public int getTotdays(){
        return totdays;
    }
    public void setTotdays(int totdays){
        this.totdays=totdays;
    }

    public String getSubname(){
        return subname;
    }
    public void setSubname(String subname){
        this.subname=subname;
    }
    public String getRno(){
        return rno;
    }
    public void setRno(String rno){
        this.rno=rno;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }



}
