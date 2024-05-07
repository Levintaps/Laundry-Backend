package net.javawookies.laundryShop.mapper;

import net.javawookies.laundryShop.DataTransferObject.TransactionDto;
import net.javawookies.laundryShop.entity.Transaction;

public class TransactionMapper {
    public static TransactionDto maptoTransactionDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getFirstName(),
                transaction.getLastName(),
                transaction.getAddress(),
                transaction.getKgs(),
                transaction.getContactNumber(),
                transaction.getMode(),
                transaction.getStatus()
        );
    }

    public static Transaction maptoTransaction(TransactionDto transactionDto){
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getFirstName(),
                transactionDto.getLastName(),
                transactionDto.getAddress(),
                transactionDto.getKgs(),
                transactionDto.getContactNumber(),
                transactionDto.getMode(),
                transactionDto.getStatus()
        );
    }


}
