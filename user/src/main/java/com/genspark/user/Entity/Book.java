package com.genspark.user.Entity;

import java.util.List;

public record Book(Long id, String title, String author, List<Long> catalogIds, Long customerId) {
}
