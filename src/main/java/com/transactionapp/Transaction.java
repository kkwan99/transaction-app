package com.transactionapp;

public class Transaction {
    private int id;  // 트랜잭션 ID
    private String type;  // 트랜잭션 유형 - PAYMENT, REFUND 등
    private double amount;  // 금액

    public Transaction(int id, String type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
