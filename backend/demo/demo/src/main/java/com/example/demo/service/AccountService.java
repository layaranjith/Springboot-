package com.example.demo.service;

import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccountDetails;
import com.example.demo.repository.AccountRepo;

@Service
public class AccountService {

    private AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo)
    {
        this.accountRepo=accountRepo;
    }

    public boolean saveDetails(AccountDetails accountDetails)
    {
       try{
        accountRepo.save(accountDetails);
        return true;
       }
       catch(Exception e){
        return false;
       }
    }



    public List<AccountDetails> getAllvalue()
    {
        return accountRepo.findAll();
    }



    public AccountDetails getaccountById(int id){
        return accountRepo.findById(id).orElse(null);
    }
    


    public boolean updateDetails(int id,AccountDetails accountDetails){
       try{
        if(getaccountById(id)!=null)
        {
            accountRepo.save(accountDetails);
            return true;
        }
        return false;
       }
       catch(Exception e){
        return false;
       }
    }



    public boolean deletedetails(int id){
        try{
            if(getaccountById(id)!=null)
            {
                accountRepo.deleteById(id);
                return true;
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }


    public List<AccountDetails> getByName(String name){
        return accountRepo.getByName(name);
    }

    public List<AccountDetails> getSortName()
    {
        return accountRepo.sortByName();
    }
    


    // public AccountDetails veiwpassbook()
    // {
        
    // }
    // public AccountDetails veiwATMcard()
    // {

    // }
    // public AccountDetails checkBalance()
    // {

    // }
    // public AccountDetails veiwTransaction()
    // {

    // }
}
