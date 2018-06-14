package com.mooracle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
 *
 * Entry 3: A More Functional Loop:
 * we now want to print out each ingridients in the (Collection) List ingridients. We can use the old code this is how
 * we do it imperatively first.
 *
 * Now for all iterable object there is a new method called for each. Thus ingridients also has one since ingridients is
 * also iterable as it is a List. But this method is a new method available only in  1.8 forward
 *
 * Basically the forEach method use what is called Consumer which is a functional interface (can be used as the target
 * for a lambda). Consumer represent an operation that accepts a single input argment and return no result. It just do
 * what in the middle of the @Override code ask it to do.
 *
 * Yes the code is still long and still has the long similar to manual for loop and print each loop String.
 * */

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> ingredients = Arrays.asList(
                "flour",
                "salt",
                "baking powder",
                "butter",
                "eggs",
                "milk"
        );

        // entry 3: we will reuse modified version of the old code (imperative)

//        for(String ingridient:ingredients){
//
//            // entry 3: print it all imperatively!!
//
//            System.out.println(ingridient);
//
//        }

        // entry 3; using forEach method (declarative):

        ingredients.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);// <- accept each String from ingredients list and print it
            }
        });//<- link on the README or CTRL - Q after highlighting the code forEach
    }
}
