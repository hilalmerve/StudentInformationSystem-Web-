package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.category.CategoryNotFoundException;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.LessonDto;
import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Lesson;
import com.example.demo.model.vm.CategoryVm;
import com.example.demo.model.vm.LessonVm;
import com.example.demo.repository.LessonRepository;

@Service
public class LessonService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    ModelMapper modelMapper;

    public String addLesson(LessonDto lessonDto) {
        // Lesson lesson = modelMapper.map(lessonDto, Lesson.class);
        // String nameDto = lessonDto.getName();
        // lesson.setName(nameDto);
        // lesson = lessonRepository.save(lesson);
        // LessonVm lessonVm = modelMapper.map(lesson, LessonVm.class);
        // return lessonVm.getName();
        Lesson lesson = getLessons(lessonDto);
        Lesson lessonVm = lessonRepository.save(lesson);
        return lessonVm.getName();
        
    } 

    public Lesson getLessons(LessonDto lessonDto) {
        Long id = lessonDto.getCategoryId();
        Category category = categoryService.getCategory(id);
        if (category == null) {
            throw new CategoryNotFoundException("null");
        }
        //LessonVm lessonVm = modelMapper.map()
        Lesson lesson = modelMapper.map(lessonDto, Lesson.class);
        lesson.setCategory(category);
        return lesson;

        // if (category != null) {
        //     Lesson lesson = modelMapper.map(lessonDto, Lesson.class);
        //     lesson.setCategory(category);
        //     return lesson;

        // } else {
        //     throw new CategoryNotFoundException("null");
        // }
    }

    public List<LessonVm> getAllLessons() {
        return lessonRepository.findAll()
        .stream()
        .map(this::getLessonVm)
        .toList();
    }

    public LessonVm getLessonVm(Lesson lesson) {
        // LessonVm lessonVm;
        // Long categoryId = lessonVm.getCategoryId();
        //  categoryId = lesson.getCategory().getId();
        
        return modelMapper.map(lesson, LessonVm.class);
    }
}
