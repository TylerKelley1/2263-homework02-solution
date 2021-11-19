package edu.isu.cs.cs2263.hw02.data;

import lombok.*;
import lombok.extern.log4j.Log4j2;

/**
 * Use no args constructor in lombok to get rid of the non used constructor
 * Use ToString in lombok to get rid of the to string method created earlier (this will exclude CODES and DEPTS
 * but will take all of the variables and turn them into a string
 * Log4j2 added from lombok to make logging available
 */
@Log4j2
@NoArgsConstructor @ToString
public class Course {

    public static final String[] CODES = { "CS", "CHEM", "PHYS", "MATH", "BTNY", "ZOO" };
    public static final String[] DEPTS = { "Computer Science", "Chemistry", "Physics", "Mathematics", "Botany", "Zoology" };
    /**
     * Added @Getter and @Setter so we can get rid of the getter and setter methods
     */
    private @Getter @Setter int number;
    private @Getter @Setter String name;
    private @Getter @Setter int credits;
    private @Getter @Setter String code;

    public Course(String name, String code, int number, int credits) {
        this.name = name;
        this.code = code;
        this.number = number;
        this.credits = credits;
    }
}
