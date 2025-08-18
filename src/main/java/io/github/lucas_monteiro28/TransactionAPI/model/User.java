package io.github.lucas_monteiro28.TransactionAPI.model;

import io.github.lucas_monteiro28.TransactionAPI.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "Users")
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"transactionsSend", "transactionsReceived"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "sender")
    private Set<Transaction> transactionsSend;

    @OneToMany(mappedBy = "receiver")
    private Set<Transaction> transactionsReceived;

    public User(String name, String email, String password, Role role, Double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = BigDecimal.valueOf(balance);
    }
}
