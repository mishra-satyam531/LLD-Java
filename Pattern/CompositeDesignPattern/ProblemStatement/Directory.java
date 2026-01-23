package Pattern.CompositeDesignPattern.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<Object> objectList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.objectList = new ArrayList<>();
    }

    public void add(Object object) {
        objectList.add(object);
    }

    public void remove(Object object) {
        objectList.remove(object);
    }

    public void printContents() {
        System.out.println("Directory Name: " + directoryName);
        for (Object obj : objectList) {
            if(obj instanceof File) {
                ((File) obj).printContents();
            } else if(obj instanceof Directory) {
                ((Directory) obj).printContents();
            }
        }
    }
    
}
