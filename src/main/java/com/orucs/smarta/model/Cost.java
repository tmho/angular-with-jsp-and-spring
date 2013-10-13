package com.orucs.smarta.model;

public class Cost {
    private double exclusive;
    private double gst;
    private double consultantTake;

    public double getExclusive() {
        return exclusive;
    }

    public void setExclusive(double exclusive) {
        this.exclusive = exclusive;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getConsultantTake() {
        return consultantTake;
    }

    public void setConsultantTake(double consultantTake) {
        this.consultantTake = consultantTake;
    }
}
