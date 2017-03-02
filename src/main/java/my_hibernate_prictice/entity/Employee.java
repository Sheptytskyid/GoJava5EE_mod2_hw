package my_hibernate_prictice.entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Table(name = "emloyee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "salary")
    private Float salary;
}
