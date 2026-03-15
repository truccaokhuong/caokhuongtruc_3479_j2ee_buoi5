package com.example.qlspjpa.config;

import com.example.qlspjpa.model.Category;
import com.example.qlspjpa.repository.CategoryRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DataInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() > 0) {
            return;
        }

        Category laptop = new Category();
        laptop.setName("Laptop");

        Category phone = new Category();
        phone.setName("Phone");

        Category accessory = new Category();
        accessory.setName("Accessory");

        categoryRepository.saveAll(List.of(laptop, phone, accessory));
    }
}
