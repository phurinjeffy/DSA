package code;

public class MyArray_651463 extends MyArrayBasic {
    public MyArray_651463() {
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }

    public MyArray_651463(int max) {
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }

    public boolean isFull(){
        return size==MAX_SIZE;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int [] expandByK(int k){
        MAX_SIZE = k * MAX_SIZE;
        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data,0,newData,0,size); 
        data = newData;

        return data;
    }

    public int [] expand(){
        MAX_SIZE = 2 * MAX_SIZE;
        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data,0,newData,0,size); 
        data = newData;
        return data;
    }

    @Override
    public void add(int d){
        if (isFull())
            expand();
        data[size++] = d;
    }

    @Override
    public void delete(int index){
        if (!isEmpty()){
            for (int i = index; i < size-1; i++){
                data[i] = data[i + 1];
            }
            size--;
        }
    }
}
