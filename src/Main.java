import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        


        Board sudoku = new Board();
        Random random = new Random();
        int index = 0;
        int steps = 0;
        long start = System.currentTimeMillis();

        
        while(index < 81){
            if(sudoku.getBoard()[index/9][index%9].getValue() < 0){
                sudoku.getBoard()[index/9][index%9].setPossibleValues(sudoku.refreshPossibeValues(index/9, index%9));
            }

            if(sudoku.getBoard()[index/9][index%9].getPossibleValues().length > 0){
                sudoku.getBoard()[index/9][index%9].setValue(sudoku.getBoard()[index/9][index%9].getPossibleValues()[random.nextInt(sudoku.getBoard()[index/9][index%9].getPossibleValues().length)]);
                sudoku.getBoard()[index/9][index%9].removeValue(sudoku.getBoard()[index/9][index%9].getValue());
                index++;
            }
            else{
                sudoku.getBoard()[index/9][index%9].setValue(-2);
                index--;
            }

            steps +=1;

                  
        }


        System.out.printf("WYGENEROWANO!\nczas : %d\nilosc operacji : %d\n\n", System.currentTimeMillis() - start, steps);
        sudoku.printBoard();



    }
}
