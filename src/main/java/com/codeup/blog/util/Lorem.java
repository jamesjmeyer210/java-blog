package com.codeup.blog.util;

import java.util.List;

public class Lorem {

    private static final String[] words = {
            "lorem","ipsum","dolor", "sit", "amet",
            "consectetur", "adipiscing", "elit",
            "Duis", "pellentesque", "facilisis", "elit",
            "vel", "egestas", "Nunc", "quis",
            "risus", "leo", "Quisque", "aliquet",
            "feugiat", "mauris,", "vitae", "faucibus",
            "tellus", "viverra", "ut", "Nunc",
            "eget", "suscipit", "tellus", "fringilla",
            "eleifend", "tortor", "Aliquam", "vulputate",
            "et", "ullamcorper", "In", "rutrum",
            "dolor", "tortor", "vitae", "pellentesque",
            "nisl", "facilisis", "non", "Quisque",
            "mollis", "a", "arcu", "et", "vel",
            "ornare", "Nunc", "nec", "ipsum",
            "vel", "erat", "pellentesque", "venenatis",
            "vel", "sit", "amet", "erat",
            "Quisque", "tempor", "elit", "tortor",
            "ac","hendrerit", "tristique",
            "mi","elit", "sollicitudin", "leo",
            "a", "ultrices", "orci", "odio", "ut",
            "dui", "Donec", "et", "ante",
            "tempor", "ex,", "at", "bibendum", "ligula",
            "Curabitur", "accumsan", "leo", "eget",
            "egestas", "accumsan", "Proin",
            "condimentum", "gravida", "metus"
    };

    public static String ipsum(int wordc){
        if(wordc <= 0){
            return null;
        }

        int rand = -1;
        String text = "";
        for(int i = 0; i < wordc; i++){
            rand = (int)(Math.floor(Math.random() * 1000) % words.length);
            if (i < wordc - 1){
                text += words[rand] + " ";
            }else{
                text += words[rand];
            }
        }
        return text;
    }

}
