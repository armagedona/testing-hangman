import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
/**
 * Write a description of class Dic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dic
{

    private ArrayList<String> word;
    private String theWord;
    private Random rand;

    /**
     * Constructor for objects of class Dic
     */
    public Dic()
    {

        word = new ArrayList<>();
        //words();
        readFileViaStream();
        loadWord();
    }

    /**
     * reads a dictionary file and loads the words from there.
     */

    void readFileViaStream() {
        try (
        //uses the class loader search mechanism:
        InputStream input = this.getClass().getResourceAsStream("Diction.txt");
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        ){
            String line = null;
            while ((line = reader.readLine()) != null) {
                //process the line in some way
                word.add(line);
            }      
        }
        catch (IOException e) {

        }
    }

    /**
     * makes a "hidden" representation of the word that is going to be guessed.
     */
    public String hidden()
    {

        int l = theWord.length();
        String star ="";

        for(int i = 0; i<l; i++)
        {
            star += "*";
        }
        return star;
    }

    /**
     * Add words manually to the game dictionary.
     */
    private void words()
    {
        word.add("apple");
        word.add("orange");
        word.add("pencil");
        word.add("pizza");
        word.add("laptop");
        word.add("vendeta");
        word.add("window");
        word.add("rainbow");
        word.add("car");
        word.add("pen");
        word.add("horse");
        word.add("radio");
        word.add("internet");
        word.add("water");
        word.add("beer");
        word.add("deer");
        word.add("clock");
    }

    /**
     * chooses the word to be guessed.
     */
    public void loadWord()
    {
        rand = new Random();
        theWord = word.get(rand.nextInt(word.size()));
    }
    
    public String getWord()
    {
        return theWord;
    }
}