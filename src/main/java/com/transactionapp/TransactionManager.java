package com.transactionapp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TransactionManager {
    // 트랜잭션 저장 공간
    // 다른클래스에서의 접근을 막음 -> 별도 메서드를 통해서만 접근하게 만들어야함
    private List<Transaction> transactions = new ArrayList<>();

    // 트랜잭션 추가 메서드
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // 1. 특정 조건으로 필터링 (Predicate 활용) - 함수형 인터페이스 사용
    // Predicate 를 매게변수로 받아서 트랜잭션 리스트를 반환(List<Transaction>)하는 메서드
    public List<Transaction> filterTransactions(Predicate<Transaction> predicate) {
        List<Transaction> result = new ArrayList<>();

        for (Transaction t : transactions) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
//    // 1.1 함수형 인터페이스 -> Stream API 사용
//    public List<Transaction> filterTransactions(Predicate<Transaction> predicate) {
//        return transactions.stream()
//                .filter(predicate)
//                .collect(Collectors.toList());
//    }

    // 2. 금액 변환(할인율 적용 등)매핑 (Function 활용) - 함수형 인터페이스 사용
    // Function 을 매게변수로 받아서 금액을 변환 후 Double 타입 리스트(List<Double>)로 반환.
    public List<Double> mapAmounts(Function<Transaction, Double> function) {
        List<Double> result = new ArrayList<>();

        for (Transaction t : transactions) {
            result.add(function.apply(t));
        }
        return result;
    }

//    // 2.1 함수형 인터페이스 -> Stream API 사용
//    public List<Double> mapAmounts(Function<Transaction, Double> function) {
//        return transactions.stream()
//                .map(function)
//                .collect(Collectors.toList());
//    }


    // 3. 조건에 맞는 트랜잭션만 출력(Consumer 활용) - 함수형 인터페이스 사용
    public void processTransactions(Consumer<Transaction> consumer) {
        for (Transaction t : transactions) {
            consumer.accept(t);
        }
    }

//    // 3.1 함수형 인터페이스 -> Stream API 사용
//    public void processTransactions(Consumer<Transaction> consumer) {
//        transactions.forEach(consumer);
//    }


}
