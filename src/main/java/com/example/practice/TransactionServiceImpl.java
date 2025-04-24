package com.example.practice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    public <T> List<T> transformTransactions(
            List<Transaction> transactions,
            TransactionTransformer<T> transformer
    ){
        return transactions.stream()
                .map(transformer::transform)
                .collect(Collectors.toList());
    }
    public List<String> convertToIdPrice(List<Transaction> transactionList){
        return transformTransactions(transactionList,
                transaction -> transaction.getTransactionId() + transaction.getAmount().toString()
        );
    }
}
