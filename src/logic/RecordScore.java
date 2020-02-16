package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RecordScore {
    private String s;

    public RecordScore(){
        try (FileInputStream fis = new FileInputStream("src/properties/record_score.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            s = prop.getProperty("record_score");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeScore(String score) throws IOException {
        try(FileOutputStream out = new FileOutputStream("src/properties/record_score.properties")) {
            Properties prop = new Properties();
            prop.setProperty("record_score", score);
            prop.store(out, null);
        }
    }

    public String getS() {
        return s;
    }
}
