import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Quiz class stores Questions, and it can administer those Questions
 * to a user.
 *
 * @author Adrian Ossi
 *
 * Created by adrian on 5/7/15.
 */
public class Quiz {
    private Question[] questions;

    /**
     *  Basic Quiz constructor, passing in pre-existing Questions.
     *
     * @param questions An array of Question instances.
     */
    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    /**
     *  On-the-fly constructor that requires input from a user.
     */
    public Quiz() {
        // set the number of questions
        System.out.println("Making a new quiz.");
        Scanner userInput = new Scanner(System.in);
        int numQuestions = 0;

        do {
            System.out.println("How many questions?");
            System.out.println("Enter a positive number.");
            try {
                numQuestions = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            }
            userInput.nextLine();
        } while (numQuestions < 1);

        // make an array to store the questions
        this.questions = new Question[numQuestions];

        // loop over the questions, setting parameters for each one in turn
        for (int i = 0; i < numQuestions; i++) {

            // choose question type
            System.out.println("What type is Question " + (i + 1) + "?");
            System.out.println("1 = fill-in-the-blank");
            System.out.println("2 = numerical");
            System.out.println("3 = multiple choice, one answer only");
            System.out.println("4 = multiple choice, multiple answers required");

            int type = 0;
            do {
                System.out.println("Enter a number between 1 and 4: ");
                try {
                    type = userInput.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                }
                userInput.nextLine();
            } while (!(type == 1 || type == 2 || type == 3 || type == 4));

            // set parameters appropriate for the different question types
            switch(type) {

                // fill-in-the-blank question
                case 1 : {
                    System.out.println("What's the question?");
                    String question = userInput.nextLine();
                    System.out.println("What's the answer?");
                    String answer = userInput.nextLine().toLowerCase();
                    questions[i] = new Question(question, answer);
                    break;
                }

                // numerical question
                case 2 : {
                    System.out.println("What's the question?");
                    String question = userInput.nextLine();
                    System.out.println("What's the answer?");
                    String answer = userInput.nextLine();
                    questions[i] = new Question(question, answer);
                    break;
                }

                // multiple choice question with a single answer
                case 3 : {
                    System.out.println("What's the question?");
                    String question = userInput.nextLine();
                    System.out.println("How many choices will be provided?");
                    int numChoices = userInput.nextInt();
                    userInput.nextLine();

                    // valudate user input
                    while (numChoices < 1) {
                        System.out.println("Invalid input. Number must be positive. Try again:");
                        numChoices = userInput.nextInt();
                        userInput.nextLine();
                    }

                    String[] choices = new String[numChoices];
                    char choiceSlot = 'A';
                    for (int j = 0; j < numChoices; j++) {
                        System.out.println("Choice " + choiceSlot + " is: ");
                        choices[j] = userInput.nextLine();
                        choiceSlot++;
                    }
                    System.out.println("Among these options, what's the correct choice?");
                    choiceSlot = 'A';
                    for (int j = 0; j < numChoices; j++) {
                        System.out.println("" + choiceSlot + ". " + choices[j]);
                        choiceSlot++;
                    }
                    int correctChoice = ((int)((userInput.next().toUpperCase()).charAt(0))) - 65;
                    questions[i] = new QuestionMult(question, choices, correctChoice);
                    break;
                }

                // multiple choice question with several answers
                case 4: {
                    System.out.println("What's the question?");
                    String question = userInput.nextLine();
                    System.out.println("How many choices will be provided?");
                    int numChoices = userInput.nextInt();
                    userInput.nextLine();

                    // validate user input
                    while (numChoices < 1) {
                        System.out.println("Invalid input. Number must be positive. Try again:");
                        numChoices = userInput.nextInt();
                        userInput.nextLine();
                    }

                    String[] choices = new String[numChoices];
                    char choiceSlot = 'A';
                    for (int j = 0; j < numChoices; j++) {
                        System.out.println("Choice " + choiceSlot + " is: ");
                        choices[j] = userInput.nextLine();
                        choiceSlot++;
                    }
                    System.out.println("Among these options, what are the correct choices?");
                    choiceSlot = 'A';
                    for (int j = 0; j < numChoices; j++) {
                        System.out.println("" + choiceSlot + ". " + choices[j]);
                        choiceSlot++;
                    }
                    System.out.print("Enter letters on one line, in alphabetical order: ");
                    String answer = userInput.nextLine().toLowerCase();
                    questions[i] = new QuestionPoly(question, answer, choices);
                }
            }
        }
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    /**
     * This method simply prints a message to System.out.
     * @param msg A String to print for the user's benefit.
     */
    public void report(String msg) {

        System.out.println(msg);
    }

    /**
     * This method is the primary function of the Quiz class. It takes the series
     * of questions stored in the Quiz instance and, using methods of ask() and
     * check() built into Question, administers the quiz to a user, tallying
     * the score as it goes and reporting the final score at the end.
     */
    public void administer() {
        int score = 0;

        // iterate through questions: ask, check, report, tally score
        for (int i = 0; i < questions.length; i++) {
            if (getQuestions()[i].check(getQuestions()[i].ask())) {
                report("Correct!");
                score++;
            } else {
                report("Wrong.");
            }
        }

        // report final score
        this.report("You got " + score + " out of " + questions.length + ".");
    }

    /**
     * Main method to test functionality of Quiz and Question
     * classes and subclasses.
     * @param args Default main arguments.
     */
    public static void main(String[] args) {

/*
        // simple quiz to test class functionality
        String qtext = "What color is the sky?";
        Question q1 = new Question(qtext, "blue");

        String[] aq2 = {"red", "yellow", "blue", "green"};
        QuestionMult q2 = new QuestionMult(qtext, aq2, 2);

        String[] choicesq3 = {"red", "azure", "garnet", "blue"};
        QuestionPoly q3 = new QuestionPoly(qtext, "bd", choicesq3);

        Question[] quizQuestions = {q1, q2, q3};
        Quiz myQuiz = new Quiz(quizQuestions);
        myQuiz.administer();
*/

        // build a new quiz on the fly, then administer it
        Quiz onTheFlyQuiz = new Quiz();
        onTheFlyQuiz.administer();


    }


}
