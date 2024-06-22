package com.genspark.user.Entity;

import java.util.ArrayList;
import java.util.List;

public record Catalog(Long id, String category, List<Book> books) {
}
