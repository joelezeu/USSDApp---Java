package com.ussd.dao;

/**
 *
 * @author joel.eze
 */
public class USSDSession {
    public String sessionID;
    public String firstname;
    public String lastname;
    public String sessionType;
    public String message;

    public USSDSession() {
    }
    
    

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "USSDSession{" + "sessionID=" + sessionID + ", firstname=" + firstname + ", lastname=" + lastname + ", sessionType=" + sessionType + ", message=" + message + '}';
    }
    
    
}
