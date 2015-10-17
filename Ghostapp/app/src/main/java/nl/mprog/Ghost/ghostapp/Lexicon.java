package nl.mprog.Ghost.ghostapp;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


//Jochem van Dooren (10572929
public class Lexicon {

    List<String>  currentfilter = new ArrayList();
    final HashSet<String> wordlist = new HashSet<String>();

    public Lexicon(Context context, String sourcePath) {
        // open file and read into local data structure
        Scanner wordfile;

        //adds words from file to arraylist
        try {
            wordfile = new Scanner(context.getAssets().open(sourcePath));
            while (wordfile.hasNext()) {
                word = wordfile.next();
                currentfilter.add(word);
            }
            wordfile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String word;
    Boolean correct;

    //filters words out of the wordlist
    public List filter(String inputletters, List<String> currentfilter) {
        List filtered = new ArrayList();
        Iterator<String> iterator = currentfilter.iterator();

        while (iterator.hasNext()) {
            correct = true;
            word = iterator.next();
            if (word.length() >= inputletters.length()){
                for (int i = 0; i < inputletters.length(); i++) {
                    char wordchar = word.charAt(i);
                    char inputletterschar = inputletters.charAt(i);

                    if (wordchar != inputletterschar) {
                        correct = false;
                    }
                }
                if (correct) {
                    filtered.add(word);
                }
            }
        }
        return filtered;
    }

    //counts the number of words in the wordlist
    public int count(List filtered){
        int count = filtered.size();
        return count;
    }

    //returns remaining word or currentword
    public String result(int count, List filtered, String currentword){
        String result = "";
        if (count == 1){
            result = (String) filtered.get(0);
        }
        else if (filtered.contains(currentword)){
            result = currentword;
        }
        return result;

    }


}