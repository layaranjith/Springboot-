package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccountDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int accountNumber;
    private String accountHolderName;
    private String iFSCCode;
    private String branch;
    private int phoneNumber;
    private String accountType;
    private Date dateOfIssue;
    
    public AccountDetails() {
    }
    public AccountDetails(int id, int accountNumber, String accountHolderName, String iFSCCode, String branch,
            int phoneNumber, String accountType, Date dateOfIssue) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.iFSCCode = iFSCCode;
        this.branch = branch;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.dateOfIssue = dateOfIssue;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public String getiFSCCode() {
        return iFSCCode;
    }
    public void setiFSCCode(String iFSCCode) {
        this.iFSCCode = iFSCCode;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public Date getDateOfIssue() {
        return dateOfIssue;
    }
    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    


}