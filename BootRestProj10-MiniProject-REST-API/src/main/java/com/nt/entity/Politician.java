package com.nt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="politician_info")
@Data
@AllArgsConstructor
@NoArgsConstructor // ✅ Required for JPA
@RequiredArgsConstructor
public class Politician {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "politician_seq")
    @SequenceGenerator(name = "politician_seq", sequenceName = "politician_info_seq", allocationSize = 1)
    private Integer pid;

    @NonNull
    @Column(length = 30)
    private String pname;

    @NonNull
    @Column(length = 30)
    private String padd;

    @NonNull
    @Column(length = 30)
    private String party;

    @NonNull
    @Column(name = "dob")  // ✅ Ensures correct mapping
    private LocalDate dob;  // ✅ Better than String for date handling
}
