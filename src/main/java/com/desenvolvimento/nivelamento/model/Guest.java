package com.desenvolvimento.nivelamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @ManyToMany @JoinTable(name = "id_event",
            joinColumns = {@JoinColumn(name ="id_guest")},
            inverseJoinColumns = {@JoinColumn(name = "id_event")})
    @JsonIgnore
    private List<Event> events;
}
