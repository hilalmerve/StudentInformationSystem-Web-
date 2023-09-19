package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.LessonDto;
import com.example.demo.model.vm.LessonVm;
import com.example.demo.service.CategoryService;
import com.example.demo.service.LessonService;

@RestController
@RequestMapping("/auth/lessons")
public class LessonController {
    @Autowired
    LessonService lessonService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addLesson(@RequestBody LessonDto lessonDto) {
        String lesson = lessonService.addLesson(lessonDto);
        return ResponseEntity.ok(lesson);
    }

    @GetMapping
    public ResponseEntity<List<LessonVm>> getAllProduct(){
        List<LessonVm> allLessons = lessonService.getAllLessons();
        return ResponseEntity.ok(allLessons);
    }
}
