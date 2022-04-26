package ru.itis.chat.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @NotBlank(message = "BLANK_FIRST_NAME")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "BLANK_LAST_NAME")
    @Column(name = "last_name")
    private String lastName;

    private String password;

    @NotBlank(message = "BLANK_EMAIL")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "participants")
    @ToString.Exclude
    private Set<Dialog> chats;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    @ToString.Exclude
    private List<Msg> msgs;

}
