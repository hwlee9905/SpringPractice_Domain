package com.example.practice;

public interface TransactionTransformer<T> {
    T transform(Transaction transaction);
}
