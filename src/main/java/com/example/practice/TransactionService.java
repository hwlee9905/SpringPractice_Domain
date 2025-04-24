package com.example.practice;

import java.util.List;

public interface TransactionService {
    <T> List<T> transformTransactions(List<Transaction> transactions, TransactionTransformer<T> transformer);
}
