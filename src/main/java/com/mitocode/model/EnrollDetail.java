package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnrollDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    public Integer idEnrollDetail;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_enroll", foreignKey = @ForeignKey(name = "FK_DETAIL_ENROLL"))
    private Enroll enroll;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_course", foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    private Course course;

    @Column(nullable = false, length = 30)
    public String classroom;
}
