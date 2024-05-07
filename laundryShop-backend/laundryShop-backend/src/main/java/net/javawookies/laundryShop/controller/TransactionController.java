package net.javawookies.laundryShop.controller;


import lombok.AllArgsConstructor;
import net.javawookies.laundryShop.DataTransferObject.TransactionDto;
import net.javawookies.laundryShop.entity.Transaction;
import net.javawookies.laundryShop.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    // Build Create REST API
    @PostMapping("/create")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
        TransactionDto savedTransaction = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<TransactionDto>(savedTransaction, HttpStatus.CREATED);
    }

    // Build Get Transaction REST API
    @GetMapping("/get/{id}")
    public  ResponseEntity<TransactionDto> getTransactionById(@PathVariable("id") Long transactionId) {
        TransactionDto transactionDto = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transactionDto);
    }

    // Build Get All Transaction REST API
    @GetMapping("/get/all")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    // Build Update Transaction REST API
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTransaction(@PathVariable("id") Long transactionId,
                                                            @RequestBody TransactionDto updatedTransaction){
        transactionService.updateTransaction(transactionId, updatedTransaction);
        return ResponseEntity.ok("Updated Successfully");
    }

    //Build Delete Transaction REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transactionId){
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
