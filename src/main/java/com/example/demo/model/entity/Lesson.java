package com.example.demo.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "lessons", 
        uniqueConstraints = { 
          @UniqueConstraint(columnNames = "name") 
        })
        @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    //@NotBlank
    private Long credit;

    //@NotBlank
    private Long time;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //farklı
    @JoinColumn(name = "category_id")
    private Category category;
}
