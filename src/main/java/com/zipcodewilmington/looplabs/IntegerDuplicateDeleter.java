package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray){
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        int indexNumToDelete = 0;
        Integer[] numOfDupes = countRepeats();
        for(int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] >= maxNumberOfDuplications){
                indexNumToDelete++;
            }
        }
        Integer[] answer = new Integer[array.length - indexNumToDelete];
        if (answer.length == 0) return answer;
        int k=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] < maxNumberOfDuplications){
                answer[k] = array[i];
                k++;
            }
        }
        return answer;

    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int indexNumToDelete = 0;
        Integer[] numOfDupes = countRepeats();
        for (int i=0; i< numOfDupes.length; i++){
            if (numOfDupes[i] == exactNumberOfDuplications){
                indexNumToDelete++;
            }

        }
        Integer[] answer = new Integer[array.length-indexNumToDelete];
        int k=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] != exactNumberOfDuplications){
                answer[k] =array[i];
                k++;
            }
        }
        return answer;
    }

    public Integer[] countRepeats(){
        Integer[] numOfDupes = new Integer[array.length];
        for (int i=0; i<array.length; i++){
            int counter =1;
            for (int j=0; j<array.length; j++){
                if(i != j){
                    if (array[i] == array[j]){
                        counter++;
                    }
                }
            }
            numOfDupes[i] = counter;
        }
        return numOfDupes;
    }
}
