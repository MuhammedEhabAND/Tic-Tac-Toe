package tictactoe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import tictactoe.model.Record;

public class Files {
    
    public Record openFile() throws ClassNotFoundException {
        Record record = null;
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(createFolder());
        fc.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Tic Tac Toe Extension", ".tic"));
        File file = fc.showOpenDialog(null);
        
        if(file != null) {
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fis);
                record = (Record) objectIn.readObject();
                objectIn.close();
                fis.close();
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return record;
    }
    
    public void saveFile(Record record) {
        File file = createFile(record.getDate().replace(":", "-"));
        if(file != null) {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream objectOut = new ObjectOutputStream(fos);
                objectOut.writeObject(record);
                objectOut.close();
                fos.close();
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private File createFolder() {
        File folder = new File("records");
        if (!folder.exists()) folder.mkdir();
        return folder;
    }
    
    private File createFile(String fileName) {
        createFolder();
        
        // Create File
        File file = new File("records/" + fileName + ".tic");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return file;
    }
    
}
