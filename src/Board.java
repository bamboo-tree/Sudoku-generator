public class Board {
 
    private Ceil[][] board = new Ceil[9][9];


    public Board(){
        initBoard();
    }



    private void initBoard(){
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j++){
                this.board[i][j] = new Ceil(false);
            }
        }
    }


    public void printBoard(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.printf("%2d", board[i][j].getValue());
                if(j == 2 || j == 5){
                    System.out.print(" |");
                }
            }
            System.out.println();
            if(i == 2 || i == 5){
                System.out.print("-------+-------+-------\n");
            }
        }
    }

    public void printArray(int[] array){
        for(int i : array){
            System.out.printf("%3d", i);
        }
        System.out.println();
    }





    private int[] checkVerticaly(int col){
        Ceil dummy = new Ceil(true);

        for(int i = 0; i < 9; i++){
            if(this.board[i][col].getValue() > 0)
                dummy.removeValue(this.board[i][col].getValue());
        }

        // System.out.println("w pionie :");
        // dummy.printPossibleValues();

        return dummy.getPossibleValues();
    }

    private int[] checkHorizontaly(int row){
        Ceil dummy = new Ceil(true);

        for(int i = 0; i < 9; i++){
            if(this.board[row][i].getValue() > 0)
                dummy.removeValue(this.board[row][i].getValue());
        }

        // System.out.println("w poziomie :");
        // dummy.printPossibleValues();

        return dummy.getPossibleValues();
    }

    private int[] checkSquare(int row, int col){
        Ceil dummy = new Ceil(true);

        for(int i = (row/3) * 3; i < (row/3) * 3 + 3; i++){
            for(int j = (col/3) * 3; j < (col/3) * 3 + 3; j++){
                if(this.board[i][j].getValue() > 0){
                    dummy.removeValue(this.board[i][j].getValue());
                }
            }
        }

        // System.out.println("w kwadracie :");
        // dummy.printPossibleValues();

        return dummy.getPossibleValues();
    }


    private int[] mix(int[] arr1, int[] arr2){

        int index = 0;
        int i = 0;
        int j = 0;
        int[] newArr = new int[0];


        while(i < arr1.length && j < arr2.length){
            while(arr2[j] > arr1[i] && i < arr1.length-1){
                i++;
            }
            while(arr2[j] < arr1[i] && j < arr2.length - 1){
                j++;
            }
            if(arr2[j] == arr1[i]){
                int[] temp = new int[newArr.length + 1];
                for(int k = 0; k < newArr.length; k++)
                    temp[k] = newArr[k];
                
                temp[index] = arr2[j];
                newArr = temp;
                index++;
                i++;
                j++;
            }
            else{
                return new int[0];
            }
        }

        return newArr;
    }
    

    public int[] refreshPossibeValues(int row, int col){
        int[] arrRow = checkVerticaly(col);
        int[] arrCol = checkHorizontaly(row);
        int[] arrSqr = checkSquare(row, col);


        int[] newArr = mix(arrRow, arrCol);
        int[] newArr2 = mix(newArr, arrSqr);
        
        // System.out.println("mozliwosci : ");
        // printArray(newArr2);

        return newArr2;
    }


    public Ceil[][] getBoard(){
        return this.board;
    }

}
