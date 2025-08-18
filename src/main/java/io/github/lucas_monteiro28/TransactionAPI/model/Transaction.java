package io.github.lucas_monteiro28.TransactionAPI.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity(name = "Transactions")
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"sender", "receiver"})
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToOne()
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne()
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public Transaction(BigDecimal amount, String description, Instant date, User sender, User receiver) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }
}
