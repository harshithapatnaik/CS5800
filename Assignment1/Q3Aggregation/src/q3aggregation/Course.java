package q3aggregation;

/**
 *
 * @author harshitha
 */
class Course {
    private String courseName;
    private Instructor[] instructors;
    private Textbook[] textbooks;

    // Constructor (with two instructors and two textbooks)
    public Course(String courseName, Instructor[] instructors, Textbook[] textbooks) {
        this.courseName = courseName;
        this.instructors = instructors;
        this.textbooks = textbooks;
    }

    // Getters
    public String getCourseName() { return courseName; }
    public Instructor[] getInstructors() { return instructors; }
    public Textbook[] getTextbooks() { return textbooks; }
    // Setters
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setInstructors(Instructor[] instructors) { this.instructors = instructors; }
    public void setTextbooks(Textbook[] textbooks) { this.textbooks = textbooks; }
    
    // Print Course details with multiple instructors & textbooks
    public void print() {
        System.out.println("Course: " + courseName);
        // Print all instructors        
        System.out.println("Instructors:");
        for (Instructor instructor : instructors) {
            instructor.print();
        }
        // Print all textbooks        
        System.out.println("Textbooks:");
        for (Textbook textbook : textbooks) {
            textbook.print();
        }
    }
}

