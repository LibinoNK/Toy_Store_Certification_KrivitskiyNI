package model.ListOfToys.FileMethods;



import model.ListOfToys.ToysList;

import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;

public class FileMethods extends ToysList implements Writable, Serializable {

//    @Override
//    public boolean saveAllInFile(Serializable serializable, String filePath) {
//        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));){
//           objectOutputStream.writeObject(serializable);
//           return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    @Override
    public boolean saveAllInFile(String filePath, String text) {
//        try (FileWriter writer = new FileWriter (filePath);){
//            writer.append(LocalDateTime.now().toString());
//            writer.append(": ");
//            writer.append(text);
//            writer.append(";\n");
//            writer.close();
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }

        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            writer.append(LocalDateTime.now().toString());
            bufferWriter.append(": ");
            bufferWriter.append(text);
            bufferWriter.append(";\n");
            bufferWriter.close();
            return true;
        }
        catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }


    @Override
    public Object read(String filePath) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
