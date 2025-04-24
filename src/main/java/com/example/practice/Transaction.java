package com.example.practice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Transaction {
    String transactionId;
    LocalDateTime timestamp;
    String type;
    BigDecimal amount;

    public Transaction(String transactionId, BigDecimal amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static BigDecimal totalCredit(List<Transaction> transactions){
        return transactions.stream()
                .filter(tx -> "CREDIT".equals(tx.getType()))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
