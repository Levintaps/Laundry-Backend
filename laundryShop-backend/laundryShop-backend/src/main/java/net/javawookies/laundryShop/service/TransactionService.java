package net.javawookies.laundryShop.service;

import net.javawookies.laundryShop.DataTransferObject.TransactionDto;
import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);

    TransactionDto getTransactionById(Long transactionId);

    List<TransactionDto> getAllTransactions();

    TransactionDto updateTransaction(Long transactionId, TransactionDto updatedTransaction);

    void deleteTransaction(Long transactionId);
}
