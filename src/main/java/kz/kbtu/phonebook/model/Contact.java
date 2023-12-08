package kz.kbtu.phonebook.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long contactId;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
