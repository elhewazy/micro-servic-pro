package com.genspark.user.Entity;

public record Customer(Long id, Long phone, int bookid, String firstName,
                       String lastName, String email, String address, String jobTitle) {
}
