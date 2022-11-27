package org.hcltraining.bankapplication.repository;

import org.hcltraining.bankapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findAccountByAccountNumber(long accountNumber);

	
}
