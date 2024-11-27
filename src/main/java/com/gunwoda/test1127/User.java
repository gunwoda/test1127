package com.gunwoda.test1127;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Builder
@Getter
@Setter
public class User {
    @GeneratedValue
    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String phonenumber;
}
