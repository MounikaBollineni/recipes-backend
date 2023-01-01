package com.projects.recipesservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="recipe")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String ingredients;

    @Column
    private String steps;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_images",joinColumns={
            @JoinColumn(name = "recipe_id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "image_id")
            }
    )
    private Set<Image> images;
}
