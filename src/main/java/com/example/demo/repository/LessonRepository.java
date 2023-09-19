package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Lesson;
import com.example.demo.model.entity.Category;


@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long>{
    Boolean existsByCategory(Category category);
}
