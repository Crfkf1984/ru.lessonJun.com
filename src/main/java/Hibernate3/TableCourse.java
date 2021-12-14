package Hibernate3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Courses")
public class TableCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer duration;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private Type type;
    private String description;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "students_count")
    private Integer studentsCount;
    private Integer price;
    @Column(name = "price_per_hour")
    private Double pricePerHour;

}
