package model.ListOfToys.FileMethods;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    boolean saveAllInFile(String filePath, String text);
    Object read(String filePath);

}
