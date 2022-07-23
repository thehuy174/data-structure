
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
// class DoublePrintStream thừa kế từ PrintStream
public class DoublePrintStream extends PrintStream {
    private final OutputStream fos;
        
    // Constructor
    public DoublePrintStream(OutputStream out, String filename){
        super(out);

        try {
            fos = new FileOutputStream(new File(filename));
        } catch (FileNotFoundException e) {
            throw new AssertionError("cant create file", e);
        }
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);

        try {
            fos.write(buf, off, len);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            super.close();
        }
    }
}
