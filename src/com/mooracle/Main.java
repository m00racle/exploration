package com.mooracle;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/** Entry 1:
 *
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
 *
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
 *
 * Entry 4: Lambda
 *
 * Creating an anonymous function is the heart that of function programming. But the anonymous function implementation
 * is not so neat. It still long and hard to remember if there was no auto input in the IDEA. Even the suggestion pop up
 * in the IDEA suggested us to use lambda instead.
 *
 * Before that we need to look back at entry 3 declarative code. It was a forEach method that fed another function as
 * parameter. This function is called consumer of a String to handle. In this case Consumer is a functional interface
 * which means it only has one abstract method that we override in the Entry 3. The method is called accept(Sting s).
 *
 * Side note: a method like forEach which accepts a function as parameter is also called higher order function.
 *
 * Rule on writing a Lambda:
 * - This is a long kind of lambda.
 * - specify what you're attempting to pass into the function with parenthesis in this case String and let's call it
 *      ingredient
 * - Then we add an arrow with dash and greater than sign.
 * - Followed by the body of the function wrapped inside a {} brace in this case the body is println.
 * This commonly known as Synthetic sugar
 *
 * -> Then since we know that ingredient is a String since it was passed into println we can omit the String in the
 * parameter declaration!
 *
 * -> Then the body is only one line code. We can just omit the {} brace and make it a one liner
 *
 * -> Then the ingredient is the only parameter passed. Thus we can omit the () parantesis and make it true one liner.
 *
 * As proof that this is an Anonymous function we can just create another Consumer functions and pass ingredient!
 * As Consumer class object has beed defined we can just use that newly created Consumer class to process the
 * ingredients list forEach method.
 *
 * Summary: Basically we just defining Consumer object (which is the only function expected by List.forEach method to
 * pass. Thus the lambda we write as only a one liner object will be treated as Consumer. Java will trust us to take
 * care the checking of the object passed into that lambda.
 *
 * Entry 5: Method Reference
 *
 * in this case we can just referring to the instance method (println) in the static out instance object of System.
 * Because the signature is the same as the lambda for example the System will know what exactly it wanted to do.
 *
 * To clear things out let's just create a new static method inside Main class. Note that yell method is static but
 * println is an instance method of the out static method from the System class. More on this static vs instance method
 * in the README.
 *
 * As long as a method or lambda function matches the expected signature, you can use it as an argument.
 * These signatures are called function shapes. In this case the forEach method is looking for a function that accepts
 * a string and returns nothing (see the @Override accept method from Entry 3). This is the signature of Consumer func
 * This time we just accept string and print it out. The signature of the println method is also the same as
 * Consumer function it accept string and returns nothing just print it out. Thus we can just use it to pass ingredients
 * into println method, which is called method reference than can replace the lambda from Entry 4!
 *
 * Entry 6: Function Shapes
 *
 * Once again we need to remind ourselves that the way these functional interfaces work is that they have a single
 * abstract method. AS long as our Lambda or method reference meet the signature of the expected functional interfaces
 * method we can use it. Please refer to Entry 5 for more info about signatures.
 *
 * This method signature is also known as function shape. So far we've only looked at one type of function shape (Consumer)
 * Out of the box there are a few of these function shapes that Java offers. Each of these function shapes have a pretty
 * specific use case. Most of the problem can be solved with the defaults provided in the java.util.function package.
 * (Link on this is in README Teacher's Notes).
 *
 * Let's take a look on the java.util.function documentation (Link in the README Teacher's Notes). As we can see the doc
 * is full of interfaces (since this is a package) that represents some kind of process and specify their input(s) and
 * result(s). In here we also will meet with our Consumer interface which represents an Operation that accepts a single
 * argument and return no result (void). This Consumer only has one Abstract Method which is the accept method (see
 * Entry 3).
 * NOTE: in the doc the accept(T t) means T is the type of the input to the operation (in our case it's String)
 *
 * In the use tab of the Consumer we can see other packages, classes, methods that use Consumer interface.
 *
 * Now we go to another interface in the java.util.function package called Supplier. It has only one Abstract Method
 * called get() which Gets a result. In this case Supplier will returns a type of result defined by T. This is a complete
 * opposite of Consumer which take something and returns void while Supplier takes nothing and return something. This is
 * useful if we want to create object but don't really care how it's created.
 *
 * In the Use tab for Supplier interface we can see there are many methods in java.util package that uses Supplier as
 * parameter. One of the most obvious is Object.requireNonNull(T obj, Supplier) which will create (Supply) a message if
 * the requireNonNull invokes NullPointerException. This method is introduced since Java 8 (1.8) Thus we can use it into
 * our code to ensure that the word coming into yell method is non null.
 *
 * Entry 7: [Function Shapes - Function and Predicate]
 *
 * Next we talk about function as the root of the java.util.function package which accepts one argument and produce a
 * result. This function Functional interface (a bit weird to say it) but please keep in mind this functional interface
 * named Function. Just like Map the Fucntion has < T, R > which means we need to specify the Type of the input (T) and
 * the type of the Result (R) inside the tag brace.
 *
 * The single abstract method in this interface is the apply(T t) method which resulted R. Thus this functional interface
 * is best used to transforming values and going between types. It can transform the Types of the variables in process.
 *
 * The next important note here is called Default Method which is new to Java 8 interfaces and they allow us to change
 * several functions together. Inside the Functional interface Function doc page (link in the README) we can see there
 * are several Default Methods which we can add to the code when implementing the Function interface. This default method
 * does not have to be implemented if we don't need to but if we do we can just add it. For instance the andThen DEfault
 * method which can make chain of Functions composition.
 *
 * Next is Predicate < T > functional interface which represents a predicate (boolean-valued function) of one argument.
 * it has one abstract method named test(T t) which returns boolean and input T type t argument. Just like Function
 * functional interface it also has Default methods which one of them kind of chain all Predicate together but in this
 * functional interface it's called as and(Predicate other) since it represent short-circuiting logical AND operator.
 * Also there ar or default method for OR operator and of course negate for NOT.
 *
 * As described above the predicate has test meaning most likely it will be used to filter values.
 *
 * Lastly, the java.uti.function package has some wonderful functional interfaces that useful as we dive deeper into
 * functional programming. These are 4 basic shapes:
 *
 *  - Consumer  -> void accept(T t)     -> useful when we need to process provided value but expect to return nothing
 *  - Supplier  -> T get()              -> useful when we need something to be initialized
 *  - Function  -> R apply(T t)         -> useful for transformation both values and types
 *  - Predicate -> Boolean test(T t)    -> useful for filtering values
 *
 * Other remaining functional interfaces in the java.util.function packages are either a typed version of those four or
 * a version that changes the number of parameters that the functions accepts. The amount of parameters that a function
 * accepts is referred to as parity. Example bi prefix means two and uni prefix denotes one.
 *
 * This completes the Intro to Functional Programming next we will learn more powerful tools called Stream.
 * */

public class Main {

    // entry 5: make a new static method:

    public static void yell(String words){

        //Entry 6: we make sure if it's null we'll open up an issue in a bug tracking system.

        Objects.requireNonNull(words, () -> "Created issue: " + Main.createIssue());
        /*Notes
         * Here we use lambda to define the Supplier interface used as parameter in the requireNonNull method.
         * The lambda for Supplier takes no arguments thus we can just use () empty parentheses as we use in a method
         * that does not require any arguments. Than business as usual we just specify what to return. We don't have to
         * declare it will return String coz the Lambda will do that for us. No process here just return that String
         *
         * This Object.requireNonNull is a lazy method. It will only call the Suppler lambda as parameter if indeed
         * there is a case when Null Pointer Exception is invoked.*/


        System.out.printf("%s!!!!!! %n", words.toUpperCase());
    }

    /**Notes Entry 6:
     * This method is created because we use Objects.requireNonNull method above. In the Supplier lambda section it has
     * code that refer to this Main.createIssue() method.
     *
     * This method will just print message explaining a call to a bug tracker and a String to return in this case the
     * ticket code for the bug.
     * */
    private static String createIssue() {

        System.out.println("Some external API call to a bug tracker");
        return "#ABD111";
    }

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

        /*ingredients.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);// <- accept each String from ingredients list and print it
            }
        });//<- link on the README or CTRL - Q after highlighting the code forEach*/

        //entry 4: long type lambda

        /*ingredients.forEach((String ingredient) -> {
            System.out.println(ingredient);
        });*/

        // entry 4: lambda omit the String parameter declaration since it knows while putting into println

       /* ingredients.forEach((ingredient) -> {
            System.out.println(ingredient);
        });*/

       // entry 4: just omit {} and () in the ingredient left hand side to create one liner:

        /* ingredients.forEach(ingredient -> System.out.println(ingredient));*/

        // entry 4: proof of Anonymous function
        /*Consumer<String> printer = resep -> System.out.println(resep);
        ingredients.forEach(printer);*/

        // entry 5: using method reference:

        /*ingredients.forEach(System.out::println);*/

        // entry 5: test the static method yell in the main class:

        /*Main.yell("yahoo");*/

        // entry 5: try out the static method yell into yelling the ingredients using method reference:

        ingredients.forEach(Main::yell);

        //Entry 6: testing the Object.requireNonNull method:

        Main.yell(null);
    }
}
