package edu.poly.shop.service.Impl;

import java.util.List;
import java.util.Optional;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Account;
import edu.poly.shop.repository.AccountRepository;
import edu.poly.shop.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Account login(String username, String password) {
		Optional<Account> optExist = findById(username);
		
		if(optExist.isPresent() && bCryptPasswordEncoder.matches(password, optExist.get().getPassword())) {
			optExist.get().setPassword("");
			return optExist.get();
		}
		return null;
	}
	
	@Override
	public <S extends Account> S save(S entity) {
		Optional<Account> optExist = findById(entity.getUsername());
		
		if(optExist.isPresent()) {
			// kiem tra truong dl pass neu ko cap nhap pass moi thif set laf pass cu ko thif ma hoa pass moi
			if(StringUtils.isEmpty(entity.getPassword())) {
				entity.setPassword(optExist.get().getPassword());
			}else {
				entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
			}
			//taoj moi
			entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		}
		
	
		return accountRepository.save(entity);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return accountRepository.findAll(sort);
	}

	@Override
	public Optional<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public void deleteById(String id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void delete(Account entity) {
		accountRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		accountRepository.deleteAll();
	}

	@Override
	public Account getById(String id) {
		return accountRepository.getById(id);
	}
	
	
}
