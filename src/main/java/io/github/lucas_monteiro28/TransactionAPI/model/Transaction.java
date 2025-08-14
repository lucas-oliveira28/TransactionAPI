package io.github.lucas_monteiro28.TransactionAPI.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "Transactions")
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue
    @org.hibernate.annotations.UuidGenerator
    private UUID id;
    private Double amount;
    private String description;
    private Instant date;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private User sender;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private User receiver;

    public Transaction(Double amount, String description, Instant date, User sender, User receiver) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }
}
