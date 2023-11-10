package tz.ac.udsm.chatBot.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String make;

    private String numberPlate;

}
