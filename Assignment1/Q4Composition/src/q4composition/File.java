package q4composition;

/**
 *
 * @author harshitha
 */
class File {
    private String fileName;

    // Constructor
    public File(String fileName) {
        this.fileName = fileName;
    }

    // Getter
    public String getFileName() {
        return fileName;
    }

    // Print method to display file name
    public void print() {
        System.out.println("  File: " + fileName);
    }
}

