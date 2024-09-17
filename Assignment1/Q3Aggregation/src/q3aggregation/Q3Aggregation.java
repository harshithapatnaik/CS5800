package q3aggregation;

/**
 *
 * @author harshitha
 */
public class Q3Aggregation {

    public static void main(String[] args) {
        
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");
        Instructor instructor2 = new Instructor("Amin", "Hanapravad", "3-2637");

        Textbook textbook1 = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Textbook textbook2 = new Textbook("Design Patterns", "Erich Gamma", "Addison-Wesley");

        // Create arrays of instructors and textbooks
        Instructor[] instructors = { instructor1, instructor2 };
        Textbook[] textbooks = { textbook1, textbook2 };

        // Create and print Course
        Course course = new Course("CS5800 - Software Engineering", instructors, textbooks);        
        course.print();
    }
}
