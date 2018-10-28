import java.util.Scanner;
import java.io.File;

public class MovieGuess {
    public static void main(String args[]){
        try {File file = new File("movies.txt");
            Scanner scanner = new Scanner(file);
            String movie="";
            int random = (int)(Math.random()*25)+1;
            int count=1;
            while (scanner.hasNext()){
                String title = scanner.nextLine();
                //System.out.println(title);
                if(count==random) {
                    movie=title;
                    break;
                } else{
                    count += 1;
                }
            }
            int length = movie.length();
            String movieguess="";
            for(int i =0; i<length; i++){
                if(movie.charAt(i)==' '){
                    movieguess+=" ";
                } else {
                    movieguess += "_";
                }
            }
            System.out.println(movieguess);
            String wrongLetters="";
            for(int i =10; i>0; i--){
                System.out.println("You have "+i+" guesses left. Wrong letters: "+wrongLetters);
                Scanner inputScanner = new Scanner(System.in);
                String letter= inputScanner.nextLine();
                int index = movie.indexOf(letter);
                if(index==-1){
                    wrongLetters+=letter+" ";
                } else{
                    i++;
                }
                while(index!=-1){
                    String newString = "";
                    newString = movieguess.substring(0, index) + letter + movieguess.substring(index + 1, length);
                    movieguess = newString;
                    index = movie.indexOf(letter, index+1);
                }
                System.out.println(movieguess);
                if (movieguess.equals(movie)){
                    System.out.println("CONGRATS");
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println("smth went wrong");
        }
    }
}
