package com.mooracle;

import java.util.Arrays;
import java.util.List;
/** Entry 1:
 * We start with giving exmple on the difference between declarative and imperative programing style.
 *
 * Here we want to test whether inside a List of ingridients there are "eggs" in it.
 *
 * If there is egg just stop iteration and spread the bad news!
 * */

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> ingridieants = Arrays.asList(
                "flour",
                "salt",
                "baking powder",
                "butter",
                "eggs",
                "milk"
        );

        boolean hasEggs = false;

        for(String ingridient:ingridieants){

            if(ingridient.equals("eggs")){
                hasEggs=true;
                break;
            }

        }

        if(hasEggs){
            System.out.println("Sorry, eggs!");
        }
    }
}
