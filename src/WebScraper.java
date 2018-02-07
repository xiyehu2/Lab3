import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScraper {
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

    /***
     *
     * @param url
     * @return number of words in the text file
     */
    public static int totalWordCount(final String url) {
        String text = urlToString(url);
        String[] wordArray = text.split("\\s+");
        int totalWords = wordArray.length;
        return totalWords;
    }

    /***
     * @param word specified  word
     * @param url website searching from
     * @return the occurrence of a specific word in a text file.
     */
    public static int wordOccurrence(final String word, final String url) {
        String text = urlToString(url);
        String[] wordArray = text.split("\\s+");
        int count = 0;
        String wordUpper = word.toUpperCase();
        for (String w : wordArray) {
            w = w.toUpperCase();
            if (w.equals(wordUpper)) {
                count++;
            }
        }
        return count;
    }

    public static void main (String[] unused) {
        System.out.println(wordOccurrence("prince","http://erdani.com/tdpl/hamlet.txt"));
    }
}
