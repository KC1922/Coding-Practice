//this code demonstrates how to swap the values of two variables without using a third variable or directly assigning the values to each other.
//it is useful for sorting algorithms, such as bubble sort, where you need to swap the values of two variables.
//arithmatic operations and bitwise operations are used to swap the values of the variables.
public class swapping_values {
    public static void main(String[] args){
        int a = 3;
        int b = 5;
        System.out.println("a = " + a + ", b = " + b);
        //swap the values of a and b using arithmatic operations
        a = a + b; 
        b = a - b; 
        a = a - b; 

        System.out.println("After swapping: a = " + a + ", b = " + b);

        int c = 4;
        int d = 6;
        System.out.println("c = " + c + ", d = " + d);
        //swap the values of c and d using bitwise operations
        c = c ^ d; //c = 2
        d = c ^ d; //d = 4
        c = c ^ d; //c = 6
        
        System.out.println("After swapping: c = " + c + ", d = " + d);
    }
}
