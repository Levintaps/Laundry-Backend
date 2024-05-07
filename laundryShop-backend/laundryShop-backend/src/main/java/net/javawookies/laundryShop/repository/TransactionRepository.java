package net.javawookies.laundryShop.repository;

import net.javawookies.laundryShop.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
