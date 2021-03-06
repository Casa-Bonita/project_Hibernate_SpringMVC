package com.casabonita.spring.mvc_hibernate.service;

import com.casabonita.spring.mvc_hibernate.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getAllPayments();

    void savePayment(Payment payment, String accountNumber);

    Payment getPayment(Integer id);

    void deletePaymentById(Integer id);

    void deletePaymentByAccountId(Integer id);

}
