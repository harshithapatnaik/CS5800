package q4composition;

/**
 *
 * @author harshitha
 */
public class Q4Composition {

    public static void main(String[] args) {        
        // root folder 'php_demo1'
        Folder phpDemo = new Folder("php_demo1");

        // 'Source Files' sub-folder
        Folder sourceFiles = new Folder("Source Files");
        Folder phalcon = new Folder(".phalcon");

        // 'app' sub-folder with further subfolders
        Folder app = new Folder("app");
        app.addSubFolder(new Folder("config"));
        app.addSubFolder(new Folder("controllers"));
        app.addSubFolder(new Folder("library"));
        app.addSubFolder(new Folder("migrations"));
        app.addSubFolder(new Folder("models"));
        app.addSubFolder(new Folder("views"));

        // 'cache' folder
        Folder cache = new Folder("cache");

        // 'public' folder and add files to it
        Folder publicFolder = new Folder("public");
        publicFolder.addFile(new File(".htaccess"));
        publicFolder.addFile(new File("htrouter.php"));
        publicFolder.addFile(new File("index.html"));

        // Add the subfolders to 'Source Files'
        sourceFiles.addSubFolder(phalcon);
        sourceFiles.addSubFolder(app);
        sourceFiles.addSubFolder(cache);
        sourceFiles.addSubFolder(publicFolder);

        // Add 'Source Files' to the root folder
        phpDemo.addSubFolder(sourceFiles);

        // Add other folders like 'Include Path' and 'Remote Files'
        phpDemo.addSubFolder(new Folder("Include Path"));
        phpDemo.addSubFolder(new Folder("Remote Files"));

        // Print the initial folder structure
        System.out.println("Initial folder structure:");
        phpDemo.print("");

        // Delete the 'app' folder
        System.out.println("\nAfter deleting the 'app' folder:");
        sourceFiles.deleteFolder("app");
        phpDemo.print("");

        // Delete the 'public' folder
        System.out.println("\nAfter deleting the 'public' folder:");
        sourceFiles.deleteFolder("public");
        phpDemo.print("");
    }
}
