// COMP254-404 - Lab 3 - Nicholas Bonneville
// Lab 3 - Exercise 3

package exercise3;

// Import necessary packages.
import java.io.File;

public class RecursiveFinder {

    // Method to find files with a matching name provided by the user.
    public static int fileFinder(String filePath, String fileName) {

        // Instance variables.
        File path = new File(filePath);
        File[] files = path.listFiles();
        String currentFileName;
        String rawFileName;
        int fileCount = 0;

        // Checks to see if file path exists provided by the user. If it doesn't, it fails. Just returns as no files.
        if (!path.exists()) {
            return 0;
        }

        // If the directory exists, it proceeds and starts to run through each file.
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    currentFileName = file.getName();

                    // When checking, it removes the file type extension and then compares the file name with what was requested. If it matches, it counts up one.
                    int fileType = currentFileName.lastIndexOf('.');
                    rawFileName = (fileType == -1) ? currentFileName : currentFileName.substring(0, fileType);
                    if (rawFileName.equalsIgnoreCase(fileName)) {
                        System.out.println("Located file at: " + file.getAbsolutePath());
                        fileCount++;
                    }
                }

                // If it is a directory, it recurses in it.
                if (file.isDirectory()) {
                    fileCount += fileFinder(file.getAbsolutePath(), fileName);
                }
            }
        }

        // Returns how many files were located.
        return fileCount;
    }
}