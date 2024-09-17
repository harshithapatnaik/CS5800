package q4composition;

/**
 *
 * @author harshitha
 */
import java.util.ArrayList;

class Folder {
    private String folderName;
    private ArrayList<File> files;
    private ArrayList<Folder> subFolders;

    // Constructor
    public Folder(String folderName) {
        this.folderName = folderName;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

    // Add a File to the Folder
    public void addFile(File file) {
        files.add(file);
    }

    // Add a Sub-Folder to the Folder
    public void addSubFolder(Folder folder) {
        subFolders.add(folder);
    }

    // Print the Folder structure (recursive)
    public void print(String indent) {
        System.out.println(indent + "Folder: " + folderName);        
        for (File file : files) { // Print files
            System.out.print(indent);
            file.print();
        }        
        for (Folder subFolder : subFolders) { // Print subfolders
            subFolder.print(indent + "  ");
        }
    }

    // Delete the folder (and all its contents)
    public void deleteFolder(String folderName) {
        subFolders.removeIf(subFolder -> {
            if (subFolder.folderName.equals(folderName)) {
                System.out.println("Deleting folder: " + folderName);
                return true;
            }
            return false;
        });
    }
}
