import java.util.Random;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean startGame = true;
        boolean showCordinates = false;
        String[][] battleField = new String[8][8];
        int shipsLocation[][] = new int[9][9];
        System.out.print("Write your user name... ");
        String userName = scanner.nextLine();
        boolean startTheGameAgain = true;
        while(startTheGameAgain){
           
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    battleField[i][j] = " #";
                }
            }
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    shipsLocation[i][j] = 0;
                }
            }
            battleField[0][0] = " +";
            battleField[1][0] = " 1";
            battleField[2][0] = " 2";
            battleField[3][0] = " 3";
            battleField[4][0] = " 4";
            battleField[5][0] = " 5";
            battleField[6][0] = " 6";
            battleField[7][0] = " 7";
            battleField[0][1] = " 1";
            battleField[0][2] = " 2";
            battleField[0][3] = " 3";
            battleField[0][4] = " 4";
            battleField[0][5] = " 5";
            battleField[0][6] = " 6";
            battleField[0][7] = " 7";
            int randomTripleX = 0;                              //generating triple ship
            int randomTripleY = 0;
            int verticalOrHorizontal = (random.nextInt(2));
            int randomDoubleX1 = (2 + random.nextInt(4));                //generating first double ship
            int randomDoubleY1 = (2 + random.nextInt(5));
            int randomDoubleX2 = (2 + random.nextInt(5));                 //generating second double ship
            int randomDoubleY2 = (2 + random.nextInt(6));
            int howManyshipsLocationOnField = 0;                               //using for to check that, if all shipsLocation are in battlefild
            while(howManyshipsLocationOnField < 11){
                int infinityLoopFixer = 0; //counting for to stop an infinity looping, random is baged and randoming more than 10 times it BREAKs the loop and generating another battleField
                randomTripleX = (2 + random.nextInt(5)); //generating triple ship
                randomTripleY = (2 + random.nextInt(5));
                if(verticalOrHorizontal == 1){
                    shipsLocation[randomTripleX][randomTripleY] = 1;
                    shipsLocation[randomTripleX + 1][randomTripleY] = 1;
                    shipsLocation[randomTripleX - 1][randomTripleY] = 1;
                }
                else{
                    shipsLocation[randomTripleX][randomTripleY] = 1;
                    shipsLocation[randomTripleX][randomTripleY + 1] = 1;
                    shipsLocation[randomTripleX][randomTripleY - 1] = 1;
                }
                randomDoubleX1 = (2 + random.nextInt(4)); //generating first double ship
                randomDoubleY1 = (2 + random.nextInt(5));
                while(shipsLocation[randomDoubleX1][randomDoubleY1] == 1 || shipsLocation[randomDoubleX1 + 1][randomDoubleY1] == 1 || shipsLocation[randomDoubleX1 + 2][randomDoubleY1] == 1 || shipsLocation[randomDoubleX1 + 3][randomDoubleY1] == 1 || shipsLocation[randomDoubleX1 - 1][randomDoubleY1] == 1 || shipsLocation[randomDoubleX1 + 2][randomDoubleY1] == 1 || shipsLocation[randomDoubleX1 + 2][randomDoubleY1 - 1] == 1 || shipsLocation[randomDoubleX1 + 2][randomDoubleY1 + 1] == 1 || shipsLocation[randomDoubleX1 + 1][randomDoubleY1 + 1] == 1 || shipsLocation[randomDoubleX1 + 1][randomDoubleY1 - 1] == 1 || shipsLocation[randomDoubleX1][randomDoubleY1 - 1] == 1 || shipsLocation[randomDoubleX1][randomDoubleY1 + 1] == 1 || shipsLocation[randomDoubleX1 - 1][randomDoubleY1 - 1] == 1 || shipsLocation[randomDoubleX1 - 1][randomDoubleY1 + 1] == 1){
                    randomDoubleX1 = (2 + random.nextInt(4));
                    randomDoubleY1 = (2 + random.nextInt(5));
                    infinityLoopFixer++;
                    if(infinityLoopFixer > 10){
                        break;
                    }
                }
                infinityLoopFixer = 0;
                shipsLocation[randomDoubleX1][randomDoubleY1] = 1;
                shipsLocation[randomDoubleX1 + 1][randomDoubleY1] = 1;
                randomDoubleX2 = (2 + random.nextInt(5)); //generating second double ship
                randomDoubleY2 = (2 + random.nextInt(6));
                while(shipsLocation[randomDoubleX2][randomDoubleY2] == 1 || shipsLocation[randomDoubleX2][randomDoubleY2 + 1] == 1 || shipsLocation[randomDoubleX2][randomDoubleY2 - 1] == 1 || shipsLocation[randomDoubleX2][randomDoubleY2 - 2] == 1 || shipsLocation[randomDoubleX2 - 1][randomDoubleY2] == 1 || shipsLocation[randomDoubleX2 - 1][randomDoubleY2 + 1] == 1 || shipsLocation[randomDoubleX2 - 1][randomDoubleY2 - 1] == 1 || shipsLocation[randomDoubleX2 - 1][randomDoubleY2 - 2] == 1 || shipsLocation[randomDoubleX2 + 1][randomDoubleY2] == 1 || shipsLocation[randomDoubleX2 + 1][randomDoubleY2 + 1] == 1 || shipsLocation[randomDoubleX2 + 1][randomDoubleY2 - 1] == 1 || shipsLocation[randomDoubleX2 + 1][randomDoubleY2 - 2] == 1){
                    randomDoubleX2 = (2 + random.nextInt(5));
                    randomDoubleY2 = (2 + random.nextInt(6));
                    infinityLoopFixer++;
                    if(infinityLoopFixer > 10){
                        break;
                    }
                }
                infinityLoopFixer = 0;
                shipsLocation[randomDoubleX2][randomDoubleY2] = 1;
                shipsLocation[randomDoubleX2][randomDoubleY2 - 1] = 1;
                for(int i = 0; i < 4; i++){ //generating single shipsLocation 4 times
                    int randomX = (1 + random.nextInt(7));
                    int randomY = (1 + random.nextInt(7));
                    while(shipsLocation[randomX][randomY] == 1 || shipsLocation[randomX][randomY - 1] == 1 || shipsLocation[randomX][randomY + 1] == 1 || shipsLocation[randomX - 1][randomY] == 1 || shipsLocation[randomX - 1][randomY - 1] == 1 || shipsLocation[randomX - 1][randomY + 1] == 1 || shipsLocation[randomX + 1][randomY] == 1 || shipsLocation[randomX + 1][randomY - 1] == 1 || shipsLocation[randomX + 1][randomY + 1] == 1){
                        randomX = (1 + random.nextInt(7));
                        randomY = (1 + random.nextInt(7));
                    }
                    shipsLocation[randomX][randomY] = 1;
                    infinityLoopFixer = 0;
                }
                for(int i = 0; i < 9; i++){ //cheking for does all shipsLocation are generated?
                    for(int j = 0; j < 9; j++){
                        if(shipsLocation[i][j] == 1){
                            howManyshipsLocationOnField++;
                        }
                    }
                }
            }
            int shipsLocationShooted = 0;
            int shootsCounter = 0;
            while(startGame){ //starting the game
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        System.out.print(battleField[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("Write cordinates(first vertical!)... ");
                int usersShootXcordinate = scanner.nextInt();
                int usersShootYcordinate = scanner.nextInt();
                if(usersShootXcordinate > 7 || usersShootXcordinate < 1 || usersShootYcordinate > 7 || usersShootYcordinate < 1){
                    clearConsole();
                    System.out.println("Write a valid cordinate!");
                }
                else if(shipsLocation[usersShootXcordinate][usersShootYcordinate] == 1 && battleField[usersShootXcordinate][usersShootYcordinate].equals(" #")){
                    battleField[usersShootXcordinate][usersShootYcordinate] = " X";
                    shipsLocation[usersShootXcordinate][usersShootYcordinate] = 9;
                    shipsLocationShooted++;
                    if(verticalOrHorizontal != 1 && (battleField[randomTripleX][randomTripleY].equals(" X") && battleField[randomTripleX][randomTripleY + 1].equals(" #") && battleField[randomTripleX][randomTripleY - 1].equals(" #") || battleField[randomTripleX][randomTripleY].equals(" X") && battleField[randomTripleX][randomTripleY + 1].equals(" X") && battleField[randomTripleX][randomTripleY - 1].equals(" #") || battleField[randomTripleX][randomTripleY].equals(" #") && battleField[randomTripleX][randomTripleY + 1].equals(" X") && battleField[randomTripleX][randomTripleY - 1].equals(" X") || battleField[randomTripleX][randomTripleY].equals(" #") && battleField[randomTripleX][randomTripleY + 1].equals(" #") && battleField[randomTripleX][randomTripleY - 1].equals(" X") || battleField[randomTripleX][randomTripleY].equals(" X") && battleField[randomTripleX][randomTripleY + 1].equals(" #") && battleField[randomTripleX][randomTripleY - 1].equals(" X") || battleField[randomTripleX][randomTripleY].equals(" #") && battleField[randomTripleX][randomTripleY + 1].equals(" X") && battleField[randomTripleX][randomTripleY - 1].equals(" #"))){
                        clearConsole();
                        shootsCounter++;
                        System.out.println(">>>>[ H I T ]<<<<");
                    }
                    else if (verticalOrHorizontal == 1 && (battleField[randomTripleX][randomTripleY].equals(" X") && battleField[randomTripleX + 1][randomTripleY].equals(" #") && battleField[randomTripleX - 1][randomTripleY].equals(" #") || battleField[randomTripleX][randomTripleY].equals(" X") && battleField[randomTripleX + 1][randomTripleY].equals(" X") && battleField[randomTripleX - 1][randomTripleY].equals(" #") || battleField[randomTripleX][randomTripleY].equals(" #") && battleField[randomTripleX + 1][randomTripleY].equals(" X") && battleField[randomTripleX - 1][randomTripleY].equals(" X") || battleField[randomTripleX][randomTripleY].equals(" #") && battleField[randomTripleX + 1][randomTripleY].equals(" #") && battleField[randomTripleX - 1][randomTripleY].equals(" X") ||  battleField[randomTripleX][randomTripleY].equals(" #") && battleField[randomTripleX + 1][randomTripleY].equals(" X") && battleField[randomTripleX - 1][randomTripleY].equals(" #") || battleField[randomTripleX][randomTripleY].equals(" X") && battleField[randomTripleX + 1][randomTripleY].equals(" #") && battleField[randomTripleX - 1][randomTripleY].equals(" X"))){
                        clearConsole();
                        shootsCounter++;
                        System.out.println(">>>>[ H I T ]<<<<");
                    }
                    else if(battleField[randomDoubleX1][randomDoubleY1].equals(" X") && battleField[randomDoubleX1 + 1][randomDoubleY1].equals(" #") || battleField[randomDoubleX1][randomDoubleY1].equals(" #") && battleField[randomDoubleX1 + 1][randomDoubleY1].equals(" X")){
                        clearConsole();
                        shootsCounter++;
                        System.out.println(">>>>[ H I T ]<<<<");
                    }
                    else if(battleField[randomDoubleX2][randomDoubleY2].equals(" X") && battleField[randomDoubleX2][randomDoubleY2 - 1].equals(" #") || battleField[randomDoubleX2][randomDoubleY2].equals(" #") && battleField[randomDoubleX2][randomDoubleY2 - 1].equals(" X")){
                        clearConsole();
                        shootsCounter++;
                        System.out.println(">>>>[ H I T ]<<<<");
                    }
                    else{
                        clearConsole();
                        shootsCounter++;
                        System.out.println(">>>>[ K I L L ]<<<<");
                        for(int i = 0; i < 8; i++){
                            for(int j = 0; j < 8; j++){
                                if(battleField[i][j].equals(" X")){
                                    battleField[i][j] = " !";
                                }
                            }
                        }
                    }
                }
                else if(shipsLocation[usersShootXcordinate][usersShootYcordinate] == 9 || battleField[usersShootXcordinate][usersShootYcordinate].equals(" *")){
                    clearConsole();
                    System.out.println("You have already shooted that cordinate!");
                }
                else{
                    battleField[usersShootXcordinate][usersShootYcordinate] = " *";
                    shootsCounter++;
                    clearConsole();
                    System.out.println(">>>>>> Miss! <<<<<<");
                }
                if(shipsLocationShooted > 10){
                    int wannaPlay = 2;
                    startGame = false;
                    clearConsole();
                    System.out.println("Do you wanna play again? (1. - yes || 0. - no)");
                    wannaPlay = scanner.nextInt();
                    if(wannaPlay == 0){
                        clearConsole();
                        startTheGameAgain = false;
                        startGame = false;
                    }
                    else{
                        clearConsole();
                        startGame = true;
                        startTheGameAgain = true;
                    }
                    break;
                }
                if(shipsLocationShooted > 10 && startGame == true){
                    break;
                }
            }
        }
        System.out.println("Thanks for your playing");
    }
    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}
