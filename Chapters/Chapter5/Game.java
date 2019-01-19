// 最终版本
import java.io.*;

class SimpleDocComTestDrive{
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimpleDocCom theDocCom = new SimpleDocCom();
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum+1, randomNum+2};
        theDocCom.setLocationCells(locations);

        boolean isAlive = true;
        while(isAlive == true){
            String guess = helper.getUserInput("Enter a number");
            String result = theDocCom.checkYourself(guess);
            numOfGuesses++;

            if(result == "kill"){
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}

class GameHelper{
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
          BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
          inputLine = is.readLine();
          if (inputLine.length() == 0 ){
            return null;
          }; 
        } catch (IOException e) {
          System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
     }
}

class SimpleDocCom{
    int[] locationCells;
    int numOfHits = 0;
    
    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        for(int cell:locationCells){
            if(guess == cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if(numOfHits == locationCells.length){
            result = "kill";
        }

        System.out.println(result);
        return result;
    }
}


// 简单版本
// class SimpleDocComTestDrive{
//     public static void main(String[] args) {
//         SimpleDocCom dot = new SimpleDocCom();
//         int[] locations = {2,3,4};
//         dot.setLocationCells(locations);
//         String userGuess = "2";
//         dot.checkYourself(userGuess);
//     }
// }

// class SimpleDocCom{
//     int[] locationCells;
//     int numOfHits = 0;
    
//     public void setLocationCells(int[] locs){
//         locationCells = locs;
//     }

//     public String checkYourself(String stringGuess){
//         int guess = Integer.parseInt(stringGuess);
//         String result = "miss";

//         for(int cell:locationCells){
//             if(guess == cell){
//                 result = "hit";
//                 numOfHits++;
//                 break;
//             }
//         }

//         if(numOfHits == locationCells.length){
//             result = "kill";
//         }

//         System.out.println(result);
//         return result;
//     }
// }