package com.skillstorm.projects.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.skillstorm.projects.dtos.RoomTypeDto;
import lombok.*;

@Entity
@Table(name = "roomtype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @Size(max = 1000)
    @Column(name = "description")
    private String description;

    @NotNull
    @Positive
    @Column(name = "maxoccupancy")
    private Integer maxOccupancy;

   
    public RoomType(Long id, String name, String description, Integer maxOccupancy) {
    	this.id = id;
        this.name = name;
        this.description = description;
        this.maxOccupancy = maxOccupancy;
    }
    
    public RoomTypeDto toDto() {
    	return new RoomTypeDto(id, name, description, maxOccupancy);
    }
}

