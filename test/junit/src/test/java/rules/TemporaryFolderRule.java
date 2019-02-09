package rules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ua.bryzhatov.junit.MyFileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TemporaryFolderRule {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder(new File("src/test/java/rules/"));
    private MyFileUtil myFileUtil;
    private File createdFile;

    @Before
    public void setUp() throws Exception {
        myFileUtil = new MyFileUtil();
        createdFile = temporaryFolder.newFile("hello.txt");
    }

    @Test
    public void checkOnSave() throws IOException {
        String text = "test text";
        myFileUtil.saveInFile(text, createdFile);
        Assert.assertTrue(Files.readAllLines(createdFile.toPath()).contains(text));
    }
}
