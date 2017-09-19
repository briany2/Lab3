import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * This is the URL Reader. It takes in a URL's content and reads through it, printing number of
 * words, number of a specific word, and number of unique words.
 *
 * @author Brian Yu
 * @version 1.0
 */
public class URLreader {
    /**
     * Main Method.
     */
    public static void main(String[] args) {
        String url = "http://erdani.com/tdpl/hamlet.txt";
        String urlString = urlToString(url);
        int wordCount = 0;
        String wordCheck = "prince";
        char space = ' ';
        String strSpace = " ";
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(urlString.split(strSpace))); // New arraylist
        Set<String> uniqueWords = new HashSet<String>(words); // Cross checks arraylist to get unique words.
        // System.out.println(urlString);
        for (int i = 0; i < urlString.length(); i++) {
            if (urlString.charAt(i) == space) {
                wordCount++;
            }
        }
        int specificWord = urlString.toLowerCase().split(wordCheck).length - 1;
        System.out.println("Word Count = " + wordCount);
        System.out.println("Number of 'prince' = " + specificWord);
        System.out.println("Number of unique words = " + uniqueWords.size());
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
