public class Ceil {
    
    private int[] possibleValues = new int[9];
    private int value;
    public boolean skip = false;




    public Ceil(boolean dummy){
        if(dummy)
            initArray();
        this.value = -1;
    }
    

    public void initArray(){
        this.possibleValues = new int[9];
        for(int i = 0; i < 9; i++)
            this.possibleValues[i] = i+1;
    }



    public void removeValue(int value){
        if(value <= 9 && value >= 1){

            int[] temp = new int[possibleValues.length - 1];

            for(int i = 0; i < this.possibleValues.length; i++){
                if(this.possibleValues[i] != value)
                    temp[i] = this.possibleValues[i];
                else{
                    for(int j = i; j < this.possibleValues.length-1; j++)
                        temp[j] = this.possibleValues[j+1];
                    break;
                }
            }
            this.possibleValues = temp;
        }
        else
            System.out.println("Wartosc spoza zakresu");
    }



    public void printPossibleValues(){
        for(int i : this.possibleValues)
            System.out.printf("%3d", i);
        
        System.out.println();
    }








    public int getValue(){
        return this.value;
    }
    public void setValue(int val){
        this.value = val;
    }

    public void setPossibleValues(int[] possibleValues){
        this.possibleValues = possibleValues;
    }

    public int[] getPossibleValues(){
        return possibleValues;
    }

}
