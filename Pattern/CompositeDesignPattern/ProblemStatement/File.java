package Pattern.CompositeDesignPattern.ProblemStatement;

public class File {
    String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public void printContents() {
        System.out.println("File name: " + fileName);
    }
    
}
