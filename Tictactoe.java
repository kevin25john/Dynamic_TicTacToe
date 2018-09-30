
import java.util.*;
import java.lang.*;
import java.io.*;

public class Tictactoe{

    private String[] playerChar = {"X","O","A","B","C","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","Y","Z"};
    private int[] playerInt = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
    private int playerTurn =0;

    //HashMap<Integer, String> playerMatrixMap1 = new HashMap<>();
    //playerMatrixMap1.put(-1, "X");
    String winnerPlayer ="";

 
    public static void main(String[] args) throws Exception
    {
        Tictactoe a = new Tictactoe();
        Scanner scan = new Scanner(System.in);
        int size = 0;
        int players = 0;
        int winSeq = 0;
        Map<Integer, String> playerMatrixMap = new HashMap<>(); //https://www.geeksforgeeks.org/java-util-hashmap-in-java/
        playerMatrixMap.put(1, "X");
        playerMatrixMap.put(2, "O");
        playerMatrixMap.put(3, "A");
        playerMatrixMap.put(4, "B");
        playerMatrixMap.put(5, "C");
        playerMatrixMap.put(6, "D");
        playerMatrixMap.put(7, "E");
        playerMatrixMap.put(8, "F");
        playerMatrixMap.put(9, "G");
        playerMatrixMap.put(10, "H");
        playerMatrixMap.put(11, "I");
        playerMatrixMap.put(12, "J");
        playerMatrixMap.put(13, "K");
        playerMatrixMap.put(14, "L");
        playerMatrixMap.put(15, "M");
        playerMatrixMap.put(16, "N");
        playerMatrixMap.put(17, "P");
        playerMatrixMap.put(18, "Q");
        playerMatrixMap.put(19, "R");
        playerMatrixMap.put(20, "S");
        playerMatrixMap.put(21, "T");
        playerMatrixMap.put(22, "U");
        playerMatrixMap.put(23, "V");
        playerMatrixMap.put(24, "W");
        playerMatrixMap.put(25, "Y");
        playerMatrixMap.put(26, "Z");
        
        //int[][] matrixValues;



        System.out.print("Do you want to resume a saved game ? (Y/N) ");
        while(!scan.hasNext()){
            scan.next();
            System.out.print("Do you want to resume a saved game ? (Y/N) ");
        }
        

        while(scan.hasNext()){
            if(scan.hasNext("Y") || scan.hasNext("y"))
            {
                a.resumeGame(size, players, winSeq, playerMatrixMap);
                //save(size, winSeq, players, matrixValues);
                System.exit(0);
            
            }
            else if( scan.hasNext("N") || scan.hasNext("n"))
            {
                a.newGame(size, winSeq, players, playerMatrixMap);

                
            }
            else
            {
                scan.next();
                System.out.print("Do you want to resume a saved the game ? (Y/N) ");
            }
        }
        System.out.println();

        
        
        
        

        // //to be removed later on
        // for (int i=0; i<size; i++){
        //     for(int j=0;j<size;j++){
            
        //         System.out.print(matrixValues[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
        // //to be removed later on
        
    }



public void runGame(int size, int[][] matrixValues,int players, Map<Integer, String> playerMatrixMap,int winSeq) throws Exception{

        int MatrixSize =size;
        Boolean checkWinCondition = false;
        while(checkWinCondition==false){
        takeInput(matrixValues, size, winSeq, players, playerMatrixMap);
        createGrid(size,matrixValues,playerMatrixMap);
        incrementPlayerTurn(players);
        // //to be removed later on
        // for (int i=0; i<size; i++){
        //     for(int j=0;j<size;j++){
        
        //     System.out.print(matrixValues[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
        // //to be removed later on

        checkWinCondition=checkWin(winSeq, matrixValues, MatrixSize,playerMatrixMap);
        }
        if (checkWinCondition==true)
        {
            System.out.println();
            System.out.println("Player " + winnerPlayer + " has won. Congrats!");
            System.out.println();
            System.exit(0);

        }
        else
        {
            System.out.println("Sadly no one won. Its a Tie!");
            System.exit(0);
        }


}

public void takeInput(int[][] matrixValues , int size, int winSeq, int players, Map<Integer, String> playerMatrixMap) throws Exception{

    Scanner sc = new Scanner(System.in);
    String tempPlayerChar = getPlayerChar(getPlayerTurn());
    System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
    
    while(!sc.hasNextInt()){
        if(sc.hasNext("q") || sc.hasNext("Q")) {
            quit(size, winSeq, players, matrixValues);
            //System.out.print("bye");
            //System.exit(0);
            
            // sc.next();
            // System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space: ");
        }

        // sc.next();
        // System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
        //takeInput(matrixValues, size, winSeq, players);
        runGame(size, matrixValues,players,playerMatrixMap,winSeq);
    }
    // if (quitCheck(size, winSeq, players, matrixValues, tempPlayerChar) ==true){
    //     quit(size, winSeq, players, matrixValues);
    //     }
    // while(!sc.hasNextInt()){
    //     if (quitCheck(size, winSeq, players, matrixValues, tempPlayerChar) ==true){
    //         quit(size, winSeq, players, matrixValues);
    //     }
    //     else{
    //         sc.next();
    //         System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
    //     }
        
    // }
    

    // while(!sc.hasNextInt() || !sc.hasNextInt()){
    //     runGame(size, matrixValues,players,playerMatrixMap,winSeq);
    // }
    int row =0;//Integer.parseInt(sc.next())-1;
    int column =0;// Integer.parseInt(sc.next())-1;
    
    try{
        row =Integer.parseInt(sc.next())-1;
        column = Integer.parseInt(sc.next())-1;
    }
    catch(NumberFormatException e){
        runGame(size, matrixValues,players,playerMatrixMap,winSeq);
    }
    
    // row =Integer.parseInt(sc.next())-1;
    // column = Integer.parseInt(sc.next())-1;
    // while (sc.hasNextInt()){
    //     row = Integer.parseInt(sc.next())-1;
    // }
    // while(sc.hasNextInt()){
    //     column = Integer.parseInt(sc.next())-1;

    // }
    

    while(row+1 > size || column+1 > size || row<0 || column<0){
        runGame(size, matrixValues,players,playerMatrixMap,winSeq);
        // System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
        // row = Integer.parseInt(sc.next())-1;
        // column = Integer.parseInt(sc.next())-1;
    }
    // while(!sc.hasNextInt()){
    //     if (quitCheck(size, winSeq, players, matrixValues, tempPlayerChar) ==true){
    //         quit(size, winSeq, players, matrixValues);
    //     }
    //     else{
    //         sc.next();
    //         System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
    //     }
        
    // }
    //quitCheck(size, winSeq, players, matrixValues, tempPlayerChar);
    while(matrixValues[row][column]!=0 || matrixValues[row][column]>0)
    {
        runGame(size, matrixValues,players,playerMatrixMap,winSeq);
        // System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
        // row = Integer.parseInt(sc.next())-1;
        // column = Integer.parseInt(sc.next())-1;
    }
    // while(!sc.hasNextInt()){
    //     if (quitCheck(size, winSeq, players, matrixValues, tempPlayerChar) ==true){
    //         quit(size, winSeq, players, matrixValues);
    //     }
    //     else{
    //         sc.next();
    //         System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
    //     }
        
    // }
    //quitCheck(size, winSeq, players, matrixValues, tempPlayerChar);
    matrixValues[row][column]=getPlayerInt(getPlayerTurn());
    System.out.print("\033\143");
    
        
}


public void createGrid (int MatrixSize, int[][] matrixValues,Map<Integer,String> playerMatrixMap){

    int row = MatrixSize;
    //System.out.print(" ");
    if (MatrixSize>=10 && MatrixSize<100){
        System.out.print(" ");

    }
    else if (MatrixSize>=100 && MatrixSize<1000){
        System.out.print("  ");
    }

    for (int i = 0; i < row; i++){
        
        
        if(i<9){
            for (int j=0; j<=2;j++){
            System.out.print(" ");
                 if(j==2){
                     System.out.print(i+1);
                  }            
          }
          
        }
        else if (i>=9 && i <100){
            for (int j=0; j<=1;j++){
                System.out.print(" ");   
                     if(j==1){
                         System.out.print(i+1);
                      }            
              }

        }
        else if (i>=100 && i<999){
            System.out.print(" "); 
            System.out.print(i+1);
           
        }

        if(i==row-1){
            System.out.print("   \n");
         }

    }
    int l =0;
    for(l=0; l<MatrixSize; l++ ){                           // l is the column number for each draw.
        System.out.print(l+1);
        createRow(MatrixSize,l,matrixValues, playerMatrixMap);
        if(l<MatrixSize-1){
        createRowBar(MatrixSize);
        }

    }
}

public void createRow(int MatrixSize, int l, int[][] matrixValues, Map<Integer,String> playerMatrixMap)
{
    int row = MatrixSize;
    int i;

    if (l<9){
        if(MatrixSize<10){
            System.out.print(" ");    
        }
        else if (MatrixSize>=10 && MatrixSize<100){
            System.out.print("  ");
        }
        else if (MatrixSize>=100 && MatrixSize<1000){
            System.out.print("   ");
        }
    
    }
    else if (l>=9 && l<99){
        System.out.print(" ");
        if (MatrixSize>99){
            System.out.print(" ");
        }
        
    }
    else if (l>=99 && l<999){
        System.out.print(" ");
           
    }

    for( i =0; i<row;i++)
        {    
            for (int j = 0; j<3 ; j++)
            {
                
                if (j==1 && matrixValues[l][i] !=0){

                    //System.out.print(matrixValues[l][i]);
                    //if (matrixValues[l][i]==){}
                    //System.out.print(getPlayerChar(getPlayerTurn()));
                    //String[][] matrixChar = new String[MatrixSize][MatrixSize];
                    //matrixChar[l][i]= getPlayerChar(getPlayerTurn());
                    //System.out.print(matrixChar[l][i]);
                    String a = playerMatrixMap.get(matrixValues[l][i]);
                    System.out.print(a);

                }
                else{
                    System.out.print(" ");
                }
                

                if (j==2 ){
                    if(i!=row-1){
                    System.out.print("|");}
                }
            }
        if(i==row-1){
            System.out.print("   \n");
        }
        }    
}

public void createRowBar(int MatrixSize)
{

    int row = MatrixSize;
    //System.out.print("  ");
    if (MatrixSize<10){
        System.out.print("  ");
    }
    else if (MatrixSize>=10 && MatrixSize<100){
        System.out.print("   ");

    }
    else if (MatrixSize>=100 && MatrixSize<1000){
        System.out.print("    ");
    }
    int i;
    for( i =0; i<row;i++)
    {    
        for (int j = 0; j<3 ; j++)
        {
            System.out.print("-");
            if (j==2 ){
                if(i!=row-1){
                System.out.print("+");}
            }
        }
        if(i==row-1){
            System.out.print("   \n");
        }

    }





}

public String getPlayerChar(int playerTurn){
    return playerChar[playerTurn];
}

public int getPlayerInt(int playerTurn){
    return playerInt[playerTurn];
}

public int getPlayerTurn(){
    return playerTurn;
}


public void incrementPlayerTurn(int players)
{
    playerTurn++;
    if (playerTurn == players){
        playerTurn=0;
    }
}

public Boolean checkWin(int winSeq,int[][] matrixValues, int MatrixSize,Map<Integer, String> playerMatrixMap)
{

    Boolean verticalReturn = vertical(MatrixSize, matrixValues, winSeq, playerMatrixMap);

    if(verticalReturn==true)
    {
        return true;
    }
   // Boolean horizontalReturn = horizontal(MatrixSize, matrixValues, winSeq, playerMatrixMap);

    else if (verticalReturn==false)
    {
        Boolean horizontalReturn = horizontal(MatrixSize, matrixValues, winSeq, playerMatrixMap);
        if(horizontalReturn==true)
        {
            return true;
        }
        else if(horizontalReturn==false){
            Boolean diagonalRightReturn = diagonalright(MatrixSize, matrixValues, winSeq, playerMatrixMap);
            if (diagonalRightReturn==true)
            {  
                return true;
            }
            else if(diagonalRightReturn==false){
                Boolean diagonalLeftReturn = diagonalLeft(MatrixSize, matrixValues, winSeq, playerMatrixMap);
                if(diagonalLeftReturn==true)
                {
                    return true;
                }
            }
        }
        
    }

    int counterFill =0;
    for(int i=0;i<MatrixSize;i++){
        for (int j=0;j<MatrixSize;j++){
            if (matrixValues[i][j]!=0){
                counterFill++;
            }
        }
    }
    if (counterFill==MatrixSize*MatrixSize){
        System.out.println();
        System.out.println("Sadly no one won. Its a Tie!");
        System.out.println();
        System.exit(0);
        return false;
    }
    
   return false;

}

public Boolean vertical(int MatrixSize, int[][] matrixValues,int winSeq, Map<Integer, String> playerMatrixMap)
{
    int counterForWinCheckVertical = 0;
    //String winnerPlayer ="";
    //System.out.println("in vertical");
    for (int i=0;i<MatrixSize;i++)
    {
        for (int j=0;j<MatrixSize;j++)
        {
            
            if(j!=MatrixSize-1)
            {
                if (matrixValues[j][i]==matrixValues[j+1][i] && matrixValues[j][i]!=0 /* && matrixValues[j][i+1]!=0 */)
                {
                    counterForWinCheckVertical++;
                    //System.out.println(j+" "+i);
                    //int column=j+1;
                    //System.out.println(column +" "+ i);
                    if (counterForWinCheckVertical==(winSeq-1))
                    {
                        winnerPlayer=playerMatrixMap.get(matrixValues[j][i]);
                        //System.out.print(winnerPlayer); //to be deleted later
                        //System.out.print(counterForWinCheckVertical); //to be deleted later
                        return true;
                    }
                

                }
                else
                {
                    counterForWinCheckVertical = 0;
                }
            }
            
        }
        counterForWinCheckVertical =0;
    }
    //System.out.println(counterForWinCheckVertical);
    return false;

}

public Boolean horizontal(int MatrixSize, int[][] matrixValues,int winSeq, Map<Integer, String> playerMatrixMap)
{
    int counterForWinCheck = 0;
    //String winnerPlayer ="";
    //System.out.println("in horizontal");
    for (int i=0;i<MatrixSize;i++)
    {
        for (int j=0;j<MatrixSize;j++)
        {

            if (j!=MatrixSize-1)
            {
                if (matrixValues[i][j]==matrixValues[i][j+1] && matrixValues[i][j]!=0 /* && matrixValues[j][i+1]!=0 */)
                {
                    counterForWinCheck++;
                    if (counterForWinCheck==(winSeq-1))
                    {
                        winnerPlayer=playerMatrixMap.get(matrixValues[i][j]);
                        //System.out.print(winnerPlayer);
                        return true;
                    }
                

                }
                else
                {
                    counterForWinCheck = 0;
                }
            }     

        }
        counterForWinCheck =0;
    }
    //System.out.print(counterForWinCheck);
    return false;
    
}

public Boolean diagonalright(int MatrixSize, int[][] matrixValues,int winSeq, Map<Integer, String> playerMatrixMap)
{
    int counterForWinCheckForDiagonal = 0;
    //String winnerPlayer ="";
    //System.out.println("in Diagonal top to bottom");

    for (int i=MatrixSize-2;i>=0;i--)
    {
        int row=i;
        int column=0;
        for(row = i; row<=MatrixSize-1 ;row++){

            //System.out.println(row + " " + column);
            if(row!=MatrixSize-1){
                if (matrixValues[row][column]==matrixValues[row+1][column+1] && matrixValues[row][column]!=0 /* && matrixValues[j][i+1]!=0 */)
                    {
                        counterForWinCheckForDiagonal++;
                        //System.out.print(matrixValues[row][column] + "    " + matrixValues[row+1][column+1]);
                        if (counterForWinCheckForDiagonal==(winSeq-1))
                        {
                            winnerPlayer=playerMatrixMap.get(matrixValues[row][column]);
                            //System.out.print(winnerPlayer);
                            //System.out.println(counterForWinCheckForDiagonal);
                            return true;
                        }
                

                    }
                    else{
                        counterForWinCheckForDiagonal = 0;
                    }
                column ++;
            }
        }
        counterForWinCheckForDiagonal =0;
    }
    //----------------<-------------------------------------------------------------------------------------
    for (int i=1;i<MatrixSize-1;i++)
    {
        int row=0;
        int column=i;
        for(column = i; column<=MatrixSize-1 ;column++){

            //System.out.println(row + " " + column);
            if(column!=MatrixSize-1){
                if (matrixValues[row][column]==matrixValues[row+1][column+1] && matrixValues[row][column]!=0 /* && matrixValues[j][i+1]!=0 */)
                    {
                        counterForWinCheckForDiagonal++;
                        if (counterForWinCheckForDiagonal==(winSeq-1))
                        {
                            winnerPlayer=playerMatrixMap.get(matrixValues[row][column]);
                            //System.out.print(winnerPlayer);
                            return true;
                        }
                

                    }
                    else{
                        counterForWinCheckForDiagonal = 0;
                    }
                row ++;
            }
        }
        counterForWinCheckForDiagonal =0;
    }
    


    //System.out.print(counterForWinCheckForDiagonal);
    return false;
}

public Boolean diagonalLeft(int MatrixSize, int[][] matrixValues, int winSeq, Map<Integer, String> playerMatrixMap)
{  
    int counterForWinCheckForDiagonalLeft = 0;
    //String winnerPlayer ="";
    //System.out.println("in Diagonal bottom to top");
    

    for (int i=MatrixSize-1;i>=0;i--)
    {
        int row=0;
        int column=i;
        for(row = 0; row<MatrixSize-1 ;row++){

            //System.out.println(row + " " + column);
            if(row!=MatrixSize-1 && column!=0){
                if (matrixValues[row][column]==matrixValues[row+1][column-1] && matrixValues[row][column]!=0 /* && matrixValues[j][i+1]!=0 */)
                    {
                        counterForWinCheckForDiagonalLeft++;
                        if (counterForWinCheckForDiagonalLeft==(winSeq-1))
                        {
                            winnerPlayer=playerMatrixMap.get(matrixValues[row][column]);
                            //System.out.print(winnerPlayer);
                            return true;
                        }
                

                    }
                    else{
                        counterForWinCheckForDiagonalLeft = 0;
                    }
                column--;
            }
        }
        counterForWinCheckForDiagonalLeft =0;
    }

    //-------------------------------------------------------------------------------------------------

    for (int i=1;i<MatrixSize-1;i++)
    {
        int row=i;
        int column=0;
        for(column = MatrixSize-1; column>=1 ;column--){

            //System.out.println(row + " " + column);
            if(row!=MatrixSize-1){
                //System.out.println(row + " " + column);
                if (matrixValues[row][column]==matrixValues[row+1][column-1] && matrixValues[row][column]!=0 /* && matrixValues[j][i+1]!=0 */)
                    {
                        counterForWinCheckForDiagonalLeft++;
                        if (counterForWinCheckForDiagonalLeft==(winSeq-1))
                        {
                            winnerPlayer=playerMatrixMap.get(matrixValues[row][column]);
                            //System.out.print(winnerPlayer);
                            return true;
                        }
                

                    }
                    else{
                        counterForWinCheckForDiagonalLeft = 0;
                    }
                row++;
            }
        }
        counterForWinCheckForDiagonalLeft =0;
    }



    


    //System.out.print(counterForWinCheckForDiagonalLeft);
    return false;
    
}

public void quit(int size, int winSeq, int players , int[][] matrixValues) throws Exception{


    System.out.print("Do you want to save the Game ? (Y/N) ");
    Scanner quitScan = new Scanner(System.in);
    while(!quitScan.hasNext()){
        quitScan.next();
        System.out.print("Do you want to save the Game ? (Y/N) ");
    }
    while(quitScan.hasNext())
    {
        if(quitScan.hasNext("Y") || quitScan.hasNext("y"))
        {
            save(size, winSeq, players, matrixValues);
            System.exit(0);
            
        }
        else if( quitScan.hasNext("N") || quitScan.hasNext("n"))
        {
            System.exit(0);
        }
        else
        {
            quitScan.next();
            System.out.print("Do you want to save the Game ? (Y/N) ");
        }
    }
    



    
}

public void save(int size, int winSeq, int players , int[][] matrixValues) throws Exception{ //https://stackoverflow.com/questions/34958829/how-to-save-a-2d-array-into-a-text-file-with-bufferedwriter
    System.out.print("enter name of file: ");
    Scanner sc = new Scanner(System.in);
    String file = sc.nextLine();
        //FileWriter fw = new FileWriter(file + ".txt");
        //String strs[] = { "com", "exe", "doc" };
    StringBuilder builder = new StringBuilder();

    builder.append(size +"");
    //builder.append(":");
    builder.append("\n");
    builder.append(winSeq +"");
    builder.append("\n");
    builder.append(players +"");
    builder.append("\n");


    for (int i = 0; i < size; i++) {
        for(int j=0;j<size;j++){
            builder.append(matrixValues[i][j]+"");
            if(j < size - 1){
                builder.append(",");
            }
                //fw.write(matrixValues[i][j]+",");
                    
                //matrixValues[i][j]=0;
        }
            //fw.write("\n");
        builder.append("\n");
    }
    
    Scanner scan = new Scanner(System.in);

    while(new File(file+".txt").exists()){

        System.out.print("Do You want to overWrite the file?: ");
        //String ovr = sc.nextLine();

        if(sc.hasNext("Y") || sc.hasNext("y") ){
            //file = sc.nextLine();
            sc.next();
            break;
        }
        else if(sc.hasNext("N") || sc.hasNext("n") ){
            sc.next();
            System.out.print("Please Re-enter the file name: ");
            file = scan.nextLine();
            // if(new File(file+".txt").exists()){
            //     continue;
            // }
            // else{break;}
        }
        // else{
        //     continue;
        // }

        // System.out.print("File already Exists, Please reenter name of file: ");
        // file = sc.nextLine();
    }
    //System.out.print("done");
    BufferedWriter writer = new BufferedWriter(new FileWriter(file+ ".txt"));
    writer.write(builder.toString());
    writer.close();
}
public static boolean between(int i, int minValueInclusive, int maxValueInclusive) { //Reference : https://alvinalexander.com/java/java-method-integer-is-between-a-range
    if (i >= minValueInclusive && i <= maxValueInclusive)
        return true;
    else
        return false;
}

public void newGame(int size, int winSeq, int players, Map<Integer, String> playerMatrixMap)throws Exception{

    Scanner scan = new Scanner(System.in);
    Boolean flag = false;
    System.out.print("Enter the size of the grid in single numeric entry: ");
    while((flag =!scan.hasNextInt()) || !between(size = scan.nextInt(),2,999)) {
        
        if(flag){
            scan.next();
            flag = false;
        }
        //scan.next();
        System.out.print("Please re-enter the correct Size of grid in single numeric entry: " );
    }
    //size = scan.nextInt();
    // while(size<=0 || size >999){
    //     System.out.print("Please Enter the Size of grid in number: " );
    //     size = scan.nextInt();
    // }
    System.out.println();

    System.out.print("Enter the number of players: ");
    while((flag =!scan.hasNextInt()) || !between(players = scan.nextInt(),1,26)) {
        if(flag){
            scan.next();
            flag = false;
        }
        //scan.next();
        System.out.print("Please Re-enter the correct number of players: " );
    }
    //players = scan.nextInt();
    // while(players<1 || players >26){
    //     scan.next();
    //     System.out.print("Please Enter the number of players in number: " );
    //     players = scan.nextInt();
    // }
    System.out.println();

    System.out.print("Please Enter the Win Sequence: ");
    while((flag =!scan.hasNextInt()) || !between(winSeq = scan.nextInt(),2,size)) {
        if(flag){
            scan.next();
            flag = false;
        }
        //scan.next();
        System.out.print("Please Re-enter the correct Win Sequence: " );
    }
    //winSeq = scan.nextInt();
    // while(winSeq>size || winSeq <=0 ){
    //     System.out.print("Please Enter the correct Win Sequence: " );
    //     winSeq = scan.nextInt();
    // }

    System.out.println();
    int[][] matrixValues = new int[size][size];
                
    for (int i=0; i<size; i++){
        for(int j=0;j<size;j++){
            matrixValues[i][j]=0;
        }
    }

    createGrid(size,matrixValues,playerMatrixMap);
    System.out.println();
    runGame(size, matrixValues,players,playerMatrixMap,winSeq);



}


public void resumeGame(int size, int players, int winSeq, Map<Integer, String> playerMatrixMap) throws Exception{ //https://stackoverflow.com/questions/34958829/how-to-save-a-2d-array-into-a-text-file-with-bufferedwriter


    System.out.print("enter name of file: ");
    Scanner sc = new Scanner(System.in);
    
    String file1 = sc.nextLine();
        //String savedGameFile = /*...*/;
            //int[][] board = new int[9][9];
    BufferedReader reader = null;
    FileReader fr = null;
    //fr = new FileReader(file1 + ".txt");
    while(!new File(file1+".txt").exists()){
    System.out.print("File does not exist. Please re-enter name of file: ");
    file1 = sc.nextLine();
    //fr = new FileReader(file1+".txt");
    }
    fr = new FileReader(file1+".txt");
    reader = new BufferedReader(fr);
    try{
        String line = "";
        int row = 0;
        //int sizeNew=0;
        //int newWinSeq=0;
        //int newPlayer=0;
        size = Integer.parseInt(reader.readLine());
        winSeq = Integer.parseInt(reader.readLine());
        players = Integer.parseInt(reader.readLine());
        int[][] matrixValues = new int[size][size];
        while((line = reader.readLine()) != null)
        {   
            //String[] cola = line.split("");
            //int col1=0;
            //int row1=0;
            // for(String b : cola){
            //     sizeNew = Integer.parseInt(b);
            // }

            String[] cols = line.split(","); //note that if you have used space as separator you have to split on " "
            int col = 0;
            
            for(String  c : cols)   
            {
                matrixValues[row][col] = Integer.parseInt(c);
                col++;
            }
            row++;
        }
        reader.close();

        createGrid(size,matrixValues,playerMatrixMap);
        System.out.println();
        runGame(size, matrixValues,players,playerMatrixMap,winSeq);
    }
    catch(NumberFormatException e){
        resumeGame(size,players,winSeq, playerMatrixMap);
    }
    
}

public Boolean quitCheck(int size, int winSeq, int players, int[][] matrixValues, String tempPlayerChar) throws Exception{
    Scanner sc = new Scanner(System.in);
    //while(!sc.hasNextInt()){
        if(sc.hasNext("q") || sc.hasNext("Q")) {
            //quit(size, winSeq, players, matrixValues);
            return true;
            //System.out.print("bye");
            //System.exit(0);
            
            // sc.next();
            // System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space: ");
        }
        else{
            return false;
        }
            //return false;

        //sc.next();
        //System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space or Q to quit: ");
        
    //}
    //return false;
}

}

/*
System.out.print("Do you want to overwrite the Existing File?(Y/N) ");
        while(!sc.hasNext()){
            System.out.print("Do you want to overwrite the Existing File?(Y/N) ");
            sc.next();
        }
         while(sc.hasNext())
        {
            if(sc.hasNext("Y") || sc.hasNext("y"))
            {
                break;
            
            }
            else if( sc.hasNext("N") || sc.hasNext("n"))
            {
                System.out.print("Please reenter name of file: ");
                //sc.next();
                file = sc.nextLine();
            }
            else
            {
                System.out.print("Please reenter name of file: ");
                //sc.next();
                file = sc.nextLine();
            }
        }*/





