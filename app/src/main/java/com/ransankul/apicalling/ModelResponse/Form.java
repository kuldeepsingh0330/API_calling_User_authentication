package com.ransankul.apicalling.ModelResponse;

public class Form {

    int formnumber ;
    String stdname;

    public Form(int formnumber) {
        this.formnumber = formnumber;
    }

    public Form(String stdname) {
        this.stdname = stdname;
    }

    public int getFormnumber() {
        return formnumber;
    }

    public void setFormnumber(int formnumber) {
        this.formnumber = formnumber;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }
}
