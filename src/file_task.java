import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileTask{
    public static void main(String args[]) throws FileNotFoundException {
        String inputFileName;         //to store the file name input
        if(args.length>1){            // if more than one arguments supplied in command line, then it is invalid
            System.out.print("More than one file given");
            return;
        }
        if(args.length==0){              // if nothing is supplied from command line, then taking input from user
            Scanner sc = new Scanner(System.in);        //Scanner object to read the input
            System.out.print("Enter the filename\n");
            inputFileName = sc.nextLine();       // assigning input to inputFilename
        }
        else{
            inputFileName = args[0];    // if a file name is supplied as command line argument
        }

        File file = new File(inputFileName);    // creating a file object, from the path of file

        if(!file.exists()){               // if file does not exist
            System.out.println("The File does not exist");
        }
        Scanner sc = new Scanner(file);    //Scanner object to read the file line by line
        int noOfLines = 0;             // initialising no. of lines,characters and words
        int noOfWords = 0;
        int noOfChars = 0;

        while (sc.hasNext()){      // if the file pointer has next line
            String currLine = sc.nextLine();
            noOfChars+=currLine.length();
            noOfWords+=currLine.split(" ").length;   // splitting the string into array of words
            noOfLines++;
        }


        System.out.println("Total number of lines " + Integer.toString(noOfLines));
        System.out.println("Total number of characters " + Integer.toString(noOfChars));
        System.out.println("Total number of words " + Integer.toString(noOfWords));
        if(noOfLines == 0){
            return;
        }

        System.out.println("avg number of characters per line " + Integer.toString(noOfChars/noOfLines));
        System.out.println("avg number of words per line " + Double.toString(noOfWords/noOfLines));


    }
}