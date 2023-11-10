package tz.ac.udsm.chatBot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String body;

    private LocalDate date;

    private String subject;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;

}
