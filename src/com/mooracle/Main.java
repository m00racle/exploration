package com.mooracle;

import java.util.Arrays;
import java.util.List;
/** Entry 1:
 * We start with giving exmple on the difference between declarative and imperative programing style.
 *
 * Here we want to test whether inside a List of ingridients there are "eggs" in it.
 *
 * If there is egg just stop iteration and spread the bad news!
 *
 * If we use imperative code stytle it has longer steps. First we List all ingridients, then we iterate all ingridient
 * in ingrtidients list. Then if we found eggs in it we break out of the loop and tells the bad news. Watch how many
 * variables needed to store the STATE of the variables.
 *
 * In a more declarative manner we can modify the codes using List method contains and ask it in if statement whether it
 * is true or false if the ingrdients indeed contains eggs.
 *
 * Contains method in the List object is already being around in the collectible classes. However, this process approach
 * is more declarative. We just declare what we want and the detail of the process has been encapsulated in the back.
 * This can be optimized further for it. The main advantage of a declarative coding style is it was more straightforward
 * thus easier to understand by other people who read the code.
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

//        boolean hasEggs = false;
//
//        for(String ingridient:ingridieants){
//
//            if(ingridient.equals("eggs")){
//                hasEggs=true;
//                break;
//            }
//
//        }

        if(ingridieants.contains("eggs")){
            System.out.println("Sorry, eggs!");
        }
    }
}
