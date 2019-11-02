import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter
{
    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
    private String currentWord;
    private FileInputStream inFile = null;
    private Scanner readInFile = null;
    private PrintWriter outFile = null;

    public void count(String iFile) throws IOException {
        inFile = new FileInputStream(iFile);
        readInFile = new Scanner(inFile);

        while(readInFile.hasNext())
        {
            currentWord = readInFile.next();

            if(wordCounter.containsKey(currentWord))
            {
                wordCounter.put(currentWord, (wordCounter.get(currentWord)+1));
            }
            else
            {
                wordCounter.put(currentWord, 1);
            }
        }
        inFile.close();
    }

    public void write(String outputFile) throws IOException {
        outFile = new PrintWriter(outputFile);

        for(Map.Entry<String, Integer> entry: wordCounter.entrySet())
        {
             outFile.println(entry.getKey() + " is listed in the text file " + entry.getValue() + " time(s).");
        }
        outFile.flush();
    }

}
