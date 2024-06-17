#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {
    public String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String readResourcesFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src${symbol_escape}${symbol_escape}main${symbol_escape}${symbol_escape}resources${symbol_escape}${symbol_escape}text.txt")));
    }
}
