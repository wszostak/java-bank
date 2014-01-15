package pl.training.bank.service.repository;

import org.springframework.stereotype.Repository;
import pl.training.bank.entity.Account;

@Repository
public interface AccountRepository {

    Account add(Account account);

    Account get(Long id);

}
