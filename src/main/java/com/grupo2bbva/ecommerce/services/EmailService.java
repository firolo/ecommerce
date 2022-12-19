package com.grupo2bbva.ecommerce.services;

public interface EmailService {
    void sendEmail(String toEmail, String subject, String body);
}