package com.ps23244.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ps23244.entity.Order;



public interface OrderDAO extends JpaRepository<Order, Long>{
	
	@Query("SELECT o FROM Order o WHERE o.account.username = ?1")
	List<Order> findOrderByAccount(String username);
	
	@Query("SELECT o FROM Order o WHERE o.id = ?1")
	List<Order> findID(Long id);
	
	@Query("Select o from Order o where o.createDate between ?1 and ?2")
	List<Order> findOrderByDate(Date firstDate, Date lastDate);
	
	
}
