package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccountDetails;
import com.example.demo.service.AccountService;







@RestController
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService)
    {
        this.accountService=accountService;
    }

    @PostMapping("/accountdetails")
    public ResponseEntity<AccountDetails> pushNewDetails(@RequestBody AccountDetails accountDetails)
    {
        if(accountService.saveDetails(accountDetails))
        {
            return new ResponseEntity<>(accountDetails,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getalldetails")
    public ResponseEntity<List> getAllDetails(){

        List<AccountDetails>all=accountService.getAllvalue();
        if(all.size()==0){
           return new ResponseEntity<>(all,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
    }
    


    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDetails> getById(@PathVariable int id){

        AccountDetails details=accountService.getaccountById(id);
        if(details==null){
            return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(details,HttpStatus.OK);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDetails> updateAccountDetails(@PathVariable int id,@RequestBody AccountDetails accountDetails){
         if(accountService.updateDetails(id, accountDetails))
         {
            return new ResponseEntity<>(accountDetails,HttpStatus.OK);
         }
         else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }


    @DeleteMapping("/deletedetails/{id}")
    public ResponseEntity<AccountDetails> deleteById(@PathVariable int id){
        if(accountService.deletedetails(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getbyname/{name}")
    public ResponseEntity<List> getByName(@PathVariable String name){

        List<AccountDetails> details=accountService.getByName(name);
        if(details.size()==0){
            return new ResponseEntity<>(details,HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(details,HttpStatus.OK);
        }
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List> sortName(){
        List<AccountDetails> detailsByName=accountService.getSortName();
        if(detailsByName.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(detailsByName,HttpStatus.OK);
        }
    }
    
    
    
    
    
    
    
    
}
