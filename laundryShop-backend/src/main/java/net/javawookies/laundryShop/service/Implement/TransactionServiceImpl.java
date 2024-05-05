package net.javawookies.laundryShop.service.Implement;

import lombok.AllArgsConstructor;
import net.javawookies.laundryShop.DataTransferObject.TransactionDto;
import net.javawookies.laundryShop.entity.Transaction;
import net.javawookies.laundryShop.exception.ResourceNotFoundException;
import net.javawookies.laundryShop.mapper.TransactionMapper;
import net.javawookies.laundryShop.repository.TransactionRepository;
import net.javawookies.laundryShop.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.maptoTransaction(transactionDto);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return TransactionMapper.maptoTransactionDto(savedTransaction);
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with given id: " + transactionId));
        return TransactionMapper.maptoTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(TransactionMapper::maptoTransactionDto).collect(Collectors.toList());
    }

    @Override
    public TransactionDto updateTransaction(Long transactionId, TransactionDto updatedTransaction) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() ->
                new ResourceNotFoundException("Transaction not found with given id: " + transactionId));

        transaction.setFirstName(updatedTransaction.getFirstName());
        transaction.setLastName(updatedTransaction.getLastName());
        transaction.setKgs(updatedTransaction.getKgs());
        transaction.setMode(updatedTransaction.getMode());
        transaction.setStatus(updatedTransaction.getStatus());

        Transaction updatedTransactionObj =transactionRepository.save(transaction);

        return TransactionMapper.maptoTransactionDto(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() ->
                new ResourceNotFoundException("Transaction not found with given id: " + transactionId));
        transactionRepository.deleteById(transactionId);
    }
}
