import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover
{
    private String currentWord;
    private HashSet<String> uniqueWords = new HashSet<String>();
    private FileInputStream inFile = null;
    private Scanner readInFile = null;
    private PrintWriter writeOutFile = null;

    private void openInputFile(String inputFile) throws IOException
    {
        System.out.print("Opening input file: ");
        inFile = new FileInputStream(inputFile);
        System.out.println("Success");
    }

    private void closeInputFile() throws IOException
    {
        System.out.print("Closing input file: ");
        inFile.close();
        System.out.println("Success");
    }


    public void write(String outputFile) throws IOException
    { ;
        writeOutFile = new PrintWriter(outputFile);

        for(String word : uniqueWords)
        {
            writeOutFile.println(word);
            System.out.println(word);
        }
        writeOutFile.flush();
    }

    public void remove(String dataFile) throws IOException
    {
        openInputFile(dataFile);
        readInFile = new Scanner(inFile);

        while(readInFile.hasNext())
        {
            currentWord = readInFile.next();

            if(uniqueWords.contains(currentWord) == false)
            {
                uniqueWords.add(currentWord);
            }
        }
        closeInputFile();
    }

}