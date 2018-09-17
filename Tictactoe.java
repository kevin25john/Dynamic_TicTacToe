
import java.util.*;
import java.lang.*;


public class Tictactoe{

    private String[] playerChar = {"X","O","A","B","C","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","Y","Z"};
    private int[] playerInt = {-1,1,-2,2,-3,3,-4,4,-5,5,-6,6,-7,7,-8,8,-9,9,-10,10,-11,11,-12,12,-13,13};
    private int playerTurn =0;

    //HashMap<Integer, String> playerMatrixMap1 = new HashMap<>();
    //playerMatrixMap1.put(-1, "X");
    String winnerPlayer ="";

 
    public static void main(String[] args)
    {
        Tictactoe a = new Tictactoe();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the grid: ");
        int size = scan.nextInt();
        System.out.print("Enter the number of players: ");
        int players = scan.nextInt();
        Map<Integer, String> playerMatrixMap = new HashMap<>();
        playerMatrixMap.put(-1, "X");
        playerMatrixMap.put(1, "O");
        playerMatrixMap.put(-2, "A");
        playerMatrixMap.put(2, "B");
        playerMatrixMap.put(-3, "C");
        playerMatrixMap.put(3, "D");
        playerMatrixMap.put(-4, "E");
        playerMatrixMap.put(4, "F");
        playerMatrixMap.put(-5, "G");
        playerMatrixMap.put(5, "H");
        playerMatrixMap.put(-6, "I");
        playerMatrixMap.put(6, "J");
        playerMatrixMap.put(-7, "K");
        playerMatrixMap.put(7, "L");
        playerMatrixMap.put(-8, "M");
        playerMatrixMap.put(8, "N");
        playerMatrixMap.put(-9, "P");
        playerMatrixMap.put(9, "Q");
        playerMatrixMap.put(-10, "R");
        playerMatrixMap.put(10, "S");
        playerMatrixMap.put(-11, "T");
        playerMatrixMap.put(11, "U");
        playerMatrixMap.put(-12, "V");
        playerMatrixMap.put(12, "W");
        playerMatrixMap.put(-13, "Y");
        playerMatrixMap.put(13, "Z");
        

        System.out.print("Please Enter the Win Sequence: ");
        int winSeq = scan.nextInt();







    int[][] matrixValues = new int[size][size];
    for (int i=0; i<size; i++){
        for(int j=0;j<size;j++){
            matrixValues[i][j]=0;
        }
    }
    
    a.createGrid(size,matrixValues,playerMatrixMap);
    System.out.println();

    //to be removed later on
    for (int i=0; i<size; i++){
        for(int j=0;j<size;j++){
            
            System.out.print(matrixValues[i][j] + "\t");
        }
        System.out.println();
    }
    //to be removed later on




    a.runGame(size, matrixValues,players,playerMatrixMap,winSeq);
    
    }



public void runGame(int size, int[][] matrixValues,int players, Map<Integer, String> playerMatrixMap,int winSeq){

        int MatrixSize =size;
        Boolean checkWinCondition = false;
        while(checkWinCondition==false){
        takeInput(matrixValues);
        createGrid(size,matrixValues,playerMatrixMap);
        incrementPlayerTurn(players);
        //to be removed later on
        for (int i=0; i<size; i++){
            for(int j=0;j<size;j++){
        
            System.out.print(matrixValues[i][j] + "\t");
            }
            System.out.println();
        }
        //to be removed later on

        checkWinCondition=checkWin(winSeq, matrixValues, MatrixSize,playerMatrixMap);
        }
        if (checkWinCondition==true)
        {
            System.out.println("Player " + winnerPlayer + " has won. Congrats!");

        }
        else 
        {
            System.out.println("Sadly no one won. Its a Tie!");
            System.exit(0);
        }


}

public void takeInput(int[][] matrixValues){

    Scanner sc = new Scanner(System.in);
    String tempPlayerChar = getPlayerChar(getPlayerTurn());
    System.out.print("Player (" + tempPlayerChar + ") enter the position of play(row and column number) seperated by a space: ");
    int row = Integer.parseInt(sc.next())-1;
    int column = Integer.parseInt(sc.next())-1;
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
        }
        
    }
    
    
   return false;

}

public Boolean vertical(int MatrixSize, int[][] matrixValues,int winSeq, Map<Integer, String> playerMatrixMap)
{
    int counterForWinCheckVertical = 0;
    //String winnerPlayer ="";
    System.out.println("in vertical");
    for (int i=0;i<MatrixSize;i++)
    {
        for (int j=0;j<MatrixSize;j++)
        {
            
            if(j!=MatrixSize-1)
            {
                if (matrixValues[j][i]==matrixValues[j+1][i] && matrixValues[j][i]!=0 /* && matrixValues[j][i+1]!=0 */)
                {
                    counterForWinCheckVertical++;
                    if (counterForWinCheckVertical==(winSeq-1))
                    {
                        winnerPlayer=playerMatrixMap.get(matrixValues[j][i]);
                        System.out.print(winnerPlayer); //to be deleted later
                        System.out.print(counterForWinCheckVertical); //to be deleted later
                        return true;
                    }
                

                }
            }
            
        }
        counterForWinCheckVertical =0;
    }
    System.out.println(counterForWinCheckVertical);
    return false;

}

public Boolean horizontal(int MatrixSize, int[][] matrixValues,int winSeq, Map<Integer, String> playerMatrixMap)
{
    int counterForWinCheck = 0;
    //String winnerPlayer ="";
    System.out.println("in horizontal");
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
                        System.out.print(winnerPlayer);
                        return true;
                    }
                

                }
            }
            

        }
        counterForWinCheck =0;
    }
    System.out.print(counterForWinCheck);
    return false;
    
}

public Boolean diagonalright(int MatrixSize, int[][] matrixValues,int winSeq, Map<Integer, String> playerMatrixMap)
{
    int counterForWinCheckForDiagonal = 0;
    //String winnerPlayer ="";
    System.out.println("in Diagonal top to bottom");

    for (int i=MatrixSize-2;i>=0;i--)
    {
        int row=i;
        int column=0;
        for(row = i; row<=MatrixSize-1 ;row++){

            System.out.println(row + " " + column);
            if(row!=MatrixSize-1){
                if (matrixValues[row][column]==matrixValues[row+1][column+1] && matrixValues[row][column]!=0 /* && matrixValues[j][i+1]!=0 */)
                    {
                        counterForWinCheckForDiagonal++;
                        if (counterForWinCheckForDiagonal==(winSeq-1))
                        {
                            winnerPlayer=playerMatrixMap.get(matrixValues[row][column]);
                            System.out.print(winnerPlayer);
                            return true;
                        }
                

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

            System.out.println(row + " " + column);
            if(column!=MatrixSize-1){
                if (matrixValues[row][column]==matrixValues[row+1][column+1] && matrixValues[row][column]!=0 /* && matrixValues[j][i+1]!=0 */)
                    {
                        counterForWinCheckForDiagonal++;
                        if (counterForWinCheckForDiagonal==(winSeq-1))
                        {
                            winnerPlayer=playerMatrixMap.get(matrixValues[row][column]);
                            System.out.print(winnerPlayer);
                            return true;
                        }
                

                    }
                row ++;
            }
        }
        counterForWinCheckForDiagonal =0;
    }
    


    System.out.print(counterForWinCheckForDiagonal);
    return false;
}

}






