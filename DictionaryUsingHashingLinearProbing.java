enum STATUS {
    OCCUPIED,
    AVAILABLE,
    EMPTY //null
}
class PairWithStatus{
    Pair aPair;
    STATUS status;
    public  PairWithStatus(){
        aPair = new Pair();
        status = STATUS.EMPTY;
    }

    public PairWithStatus(Pair aPair, STATUS status) {
        this.aPair = aPair;
        this.status = status;
    }

}

public class DictionaryUsingHashingLinearProbing {
    final int HASHTABLE_SIZE = 23;
    PairWithStatus arr [] ;
    int size = 0;

    public DictionaryUsingHashingLinearProbing(){
        arr = new PairWithStatus[HASHTABLE_SIZE];

        for(int i = 0; i < arr.length ; i++){
            arr[i] = new PairWithStatus();
        }

        arr[6] = new PairWithStatus();
        arr[6].aPair.key = 29;
        arr[6].status= STATUS.OCCUPIED;

        arr [9]  = new PairWithStatus();
        arr[9].aPair.key = 32;
        arr[9].status= STATUS.OCCUPIED;

        arr [12]  =new PairWithStatus();
        arr[12].aPair.key = 58 ;
        arr[12].status= STATUS.OCCUPIED;

        arr [21]  = new PairWithStatus();
        arr[21].aPair.key = 21;
        arr[21].status= STATUS.OCCUPIED;


    }
    int hashCode_(int a){
        return a % HASHTABLE_SIZE;
    }
    int getHashIndex(int a){
        int hashIndex = hashCode_(a);

        return hashIndex;

    }
    //
    int probe(int index, int key) {
        boolean found = false;
        int availableStateIndex = -1;
        while (!found && arr[index].status != STATUS.EMPTY) {
            if (arr[index].status != STATUS.AVAILABLE) {
                if (arr[index].aPair.key ==  key)
                    found = true;
                else
                    index = (index + 1) % HASHTABLE_SIZE;


            } else
            {
                if ( availableStateIndex == -1)
                    availableStateIndex = index;
                index = (index + 1) % HASHTABLE_SIZE;
            }
        }

        if (found || availableStateIndex == -1 )
            return index;
        else
            return availableStateIndex;
    }
    void insert(int key, String value){
//        if(!this.contains(key)){
        //insertion
        Pair newPair = new Pair(key, value);
        PairWithStatus newPairWithStatus = new PairWithStatus(newPair, STATUS.OCCUPIED);
        arr[probe(hashCode_(key), key)] = newPairWithStatus;

//            arr[size] = newPair;
        size++;
//        }
    }

    void remove(int key){
//        if(this.contains(key)){
        arr[probe(hashCode_(key), key)].status = STATUS.AVAILABLE;
//            for(int i = 0; i < size ; i++) {
//            if (arr[i].key == key)
//                arr[i] = arr[size - 1];
//            }
        size--;
//        }
        // else, nothing
    }

//    void modify(int key, String value){
//        for(int i = 0; i < size ; i++) {
//            if (arr[i].key == key)
//                arr[i].value = value;
//            //modify
//        }
//    }

    //    String lookup(int key){
//        for(int i = 0; i < size ; i++) {
//            if (arr[i].key == key){
//                return arr[i].value;
//            }
//            //modify
//        }
//        return "";
//    }
//    boolean contains(int key){
////        for(int i = 0; i < size ; i++){
//        if(arr[probe(key)].key == key)
//            return true;
////        }
//        return false;
//    }
    public static void main(String[] args) {

        DictionaryUsingHashingLinearProbing aDictionary = new DictionaryUsingHashingLinearProbing();
        aDictionary.insert(81, "any value");

        aDictionary.insert(35, "any value");
        aDictionary.insert(60, "any value");
        aDictionary.insert(12, "any value");
        aDictionary.remove(60);
        aDictionary.insert(15, "any value");
    }
}