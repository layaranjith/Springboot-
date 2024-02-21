package com.example.demo.repository;
import java.util.*;
// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountDetails;

@Repository
public interface AccountRepo extends JpaRepository<AccountDetails,Integer> {

    @Query("select a from AccountDetails a where a.accountHolderName like ?1%")
    public List<AccountDetails> getByName(String name);


    @Query("select a from AccountDetails a order by a.accountHolderName asc")
    public List<AccountDetails>sortByName();
    
}
