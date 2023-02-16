package com.pavelhnelytcia.cake.repository;

import com.pavelhnelytcia.cake.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
