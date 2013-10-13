package com.orucs.smarta.model;

import java.util.Date;

public class Client {
    private String strataNumber;
    private Address address;
    private Company managedBy;
    private Date expires;
    private Plan plan;
    private Date lastInspected;

    public String getStrataNumber() {
        return strataNumber;
    }

    public void setStrataNumber(String strataNumber) {
        this.strataNumber = strataNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Company managedBy) {
        this.managedBy = managedBy;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Date getLastInspected() {
        return lastInspected;
    }

    public void setLastInspected(Date lastInspected) {
        this.lastInspected = lastInspected;
    }
}
