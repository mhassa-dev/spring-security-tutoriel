package mh.com.project.models;

import lombok.Builder;
import lombok.Data;

/**
 * Created by mh on 19/08/2020.
 * <p>
 * The Student Model
 */
@Data
@Builder
public class Student {

    /**
     * id of the student
     */
    private Long id;

    /**
     * The student name
     */
    private String name;
}
