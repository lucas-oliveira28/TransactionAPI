package io.github.lucas_monteiro28.TransactionAPI.model;

import io.github.lucas_monteiro28.TransactionAPI.model.enums.Role;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Double balance;

    @OneToMany(mappedBy = "sender")
    private Set<Transaction> transactionsSend;

    @OneToMany(mappedBy = "receiver")
    private Set<Transaction> transactionsReceived;

    public User(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = 0.0;
    }
}
