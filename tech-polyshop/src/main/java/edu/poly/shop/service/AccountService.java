package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.poly.shop.domain.Account;

public interface AccountService {

	Account getById(String id);

	void deleteAll();

	void delete(Account entity);

	void deleteById(String id);

	Optional<Account> findById(String id);

	List<Account> findAll(Sort sort);

	Page<Account> findAll(Pageable pageable);

	List<Account> findAll();

	<S extends Account> S save(S entity);

	Account login(String username, String password);

}
