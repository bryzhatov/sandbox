package ua.bryzhatov.junit;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class MyFileUtil {
    public void saveInFile(String text, java.io.File file) throws IOException {
        Files.write(file.toPath(), text.getBytes(Charset.forName("UTF-8")));
    }
}
