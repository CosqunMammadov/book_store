package com.example.book_store.repository;

import com.example.book_store.model.entity.Account;
import com.example.book_store.model.entity.Role;
import com.example.book_store.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    boolean existsByUsername(String username);

    @Query(value = "SELECT a FROM Account a WHERE a.username =:username")
    Account findByUsername(@Param(value = "username") String username);

    List<Account> findAccountsByRoles(Role role);
}
