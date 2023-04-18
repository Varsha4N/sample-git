import java.util.Random;
public class Main {

    //Method used to merging two sub-arrays of an array.
    //Input taken : Array , sub-array boundaries.
    public static void mergeArray ( int array[] , int low , int mid , int high){

        //Create two temporary arrays to store the two sub-arrays.

        //Declaring and initializing temporary-array-1.

        //Calculating the Size of sub-array-1.
        int arraySize1 = mid - low + 1;

        //Declaring temporary-array-1 to store sub-array-1.
        int array1[] = new int[arraySize1];

        //Initializing the new array with the sub-array-1 elements.
        for(int i=0 ; i< arraySize1 ; i++){

            //Assigning each sub-array-1 values to new array.
            array1[i]=array[low+i];

        }

        //Declaring and initializing temporary-array-2.

        //Calculating the Size of sub-array-2.
        int arraySize2 = high - mid ;

        //Declaring temporary-array-1 to store sub-array-2.
        int array2[] = new int[arraySize2];

        //Initializing the new array with the sub-array-2 elements.
        for(int i=0 ; i< arraySize2 ; i++){

            //Assigning each sub-array-2 values to new array.
            array2[i]=array[mid+i+1];
        }

        //Declaring and initializing 2 integer pointers to point the two newly created arrays.
        //Both are initialized with 0, indicating the starting point of the arrays.
        int index1 = 0 , index2=0;

        //Declaring and initializing a pointer to point the array which need to be merged.
        //It is initialized with the starting point of the array , that is, low.
        int subPointer = low ;


        //Merging the sub-arrays and storing in the main array.
        //Checking if both the pointers are in the range.
        while ( index1 < arraySize1 && index2 < arraySize2) {

            //If the value at array1 is less than array2.
            if( array1[index1] <= array2[index2]){

                //sorting and assigning the value.
                array[subPointer] = array1[index1];

                //incrementing the pointer value by 1.
                index1++;

            }

            //If the value at array2 is less than array1.
            else{

                //sorting and assigning the value.
                array[subPointer]= array2[index2];

                //incrementing the pointer value by 1.
                index2++;

            }

            //incrementing the pointer value by 1.
            subPointer++;
        }


        //When the above condition is unsatisfied then sometimes few elements are left in the temporary arrays.
        //Assigning all the remaining elements to the Array.

        //Condition to check if any elements are left in array1.
        while ( index1 < arraySize1 ){

            //Assigning array1 value to Array.
            array[subPointer] = array1[index1];

            //incrementing the pointer values by 1.
            index1++;
            subPointer++;
        }
        //Condition to check if any elements are left in array2.
        while ( index2 < arraySize2 ){

            //Assigning array2 value to Array.
            array[subPointer] = array2[index2];

            //incrementing the pointer values by 1.
            index2++;
            subPointer++;
        }

    }

    //MergeSort Method.
    //Input elements : array and boundaries.
    //Performs Divide and Conquer.
    public static void mergeSort ( int array[] , int low , int high){

        //Condition to check, if an element is present in the given boundary.
        if( low < high){

            //Finding the mid value of the given boundary.
            int mid = ( low + high ) / 2 ;

            //Dividing the array into two using the mid value.
            mergeSort( array , low , mid);
            mergeSort( array , mid+1 , high);

            //Merging all the divided elements in a sorted order.
            mergeArray ( array , low , mid , high);


        }

    }

    //InsertionSort Method.
    //Input: Array and its size.
    //Sorts the array in the increasing order.

    public static void insertionSort ( int array[] , int len){


        //Loop to traverse around the array.
        //declaration of temp element.
        for ( int i=1, temp ,j ; i < len ; i++){

            //Assigning the value at index i to the temp node.
            temp = array[i];

            //initializing j value.
            j= i -1 ;

            //Inner Loop to traverse the array based on the condition.
            while ( j >=0 && array[j] > temp){

                //Assigning the values and swapping.
                array[j+1]= array[j];
                j=j-1;
            }

            //Assigning the temp value
            array[j+1] = temp;

        }

    }

    //Main method
    public static void main(String[] args) {

        //Size of the array
        //N values [5, 10, 50, 90, 95, 100]
        int N;

        //Integer arrays to store up to 100 integers
        //Used to store N integers
        int arr1[]=new int[100];
        int arr2[]=new int[100];

        //Random object is created using Random Class, which is used for the random generation of numbers
        Random random= new Random();

        //Initializing the value of N
        N=100;

        //N elements in the array are initialized with random integers
        //Using for loop for initialization
        for(int i=0; i<N; i++){

            int temp;
            //By using nextInt() method in random class a random number is generated
            //the random number is bounded within 0 to 1000
            temp=random.nextInt(1000);

            //the generated values are stored in the arrays
            arr1[i]=temp;
            arr2[i]=temp;

        }

        //Printing the Randomly Generated array.

        System.out.println("Random Array of size " + N +" : ");
        for (int i=0 ; i< N ; i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();


        //Merge Sort Function Call.


        //Storing the initial Time.
        long start = System.nanoTime();

        //MergeSort Function call with parameters.
        mergeSort(arr1 , 0 , N-1);

        //Storing the time after the complete sorting.
        long end = System.nanoTime();

        //Printing the Sorted Array by Merge Sort.
        System.out.println("\nArray after Merge Sort : ");
        for (int i=0 ; i< N ; i++){
            System.out.print(arr1[i]+" ");
        }

        //Printing the time taken to sort.
        System.out.println("\nMerge Sort Time: "+ (end-start));


        //Insertion Sort Function Call.

        //Storing the initial Time.
        start = System.nanoTime();

        //Insertion Sort Function call with parameters.
        insertionSort(arr2 , N);

        //Storing the time after the complete sorting.
        end = System.nanoTime();

        //Printing the Sorted Array by Insertion Sort.
        System.out.println("\nArray after Insertion Sort : ");
        for (int i=0 ; i< N ; i++){
            System.out.print(arr2[i]+" ");
        }
        //Printing the time taken to sort.
        System.out.println("\nInsertion Sort Time: "+ (end-start));

    }
}