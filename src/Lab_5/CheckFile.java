package Lab_5;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class checks the ability of the file to write or read
 * @author Ann
 */
public class CheckFile {
    /**
     * Checks the ability of the file to read
     * @param file is the file (File)
     * @throws FileNotFoundException work with files (existing)
     * @throws FileNotRead work with files (reading)
     */
    public void checkFileRead(File file) throws FileNotFoundException, FileNotRead {
        if (!file.exists())
            throw new FileNotFoundException();

        if (!file.canRead())
            throw new FileNotRead();

    }

    /**
     * Checks the ability of the file to read
     * @param file is the file (File)
     * @throws FileNotFoundException work with files (existing)
     * @throws FileNotWrite work with files (writing)
     */
    public void checkFileWrite(File file) throws FileNotFoundException, FileNotWrite {
        if (!file.exists())
            throw new FileNotFoundException();

        if (!file.canWrite())
            throw new FileNotWrite();
    }
}
