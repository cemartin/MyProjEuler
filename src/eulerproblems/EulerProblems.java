/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblems;
import java.util.ArrayList;
import java.math.*;

/**
 *
 * @author colin
 */
public class EulerProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println(Euler10());
    }
    
    public static ArrayList pSeive(int n) { // This method returns an ArrayList containing all prime numbers less than n using Seive of Eritosthenes

        ArrayList pList = new ArrayList();
        for (int i = 2; i < n; i++) { // populate the list with all integers less than n
            pList.add(i);
        }
        int i = 0; // index for below while loop
        int p; // prime number to remove multiples of from list
        while (i < pList.size()) { // run through pList
            p = (int) pList.get(i); // I wish I knew more about data structures that might be more appropriate
            System.out.println(p);
            for (int j = i + 1; j < pList.size(); j++) {
                if ((int) pList.get(j) % p == 0) {
                    pList.remove(j);
                } // removes all multiples of p from the list
            }
            i++;
        }
     
        return pList;
    }
    
    public static boolean isPrime(long n){ // checks for primality of long n
      
      
        if((n&1) == 0){return false;} // checks for divisibility by two
        
        for(int i = 3; i*i<=n; i+=2){
            //System.out.println(i);
            if(n%i == 0){return false;}
        }
        
        return true;
    }
    
    public static ArrayList factor(long n){ // returns ArrayList containing all factors of n
        ArrayList fList = new ArrayList();
        
        for(long i = 1; i < (long)(n*.5); i++){
            if(n%i == 0){fList.add(i); System.out.println(i);}
        }
        fList.add(n);
        return fList;
    }
    
    public static ArrayList pFactor(long n){ // returns ArrayList containing all prime factors of n
        ArrayList fList = new ArrayList();
        
        for(long i = 1; i*i < n; i++){
            if(n%i == 0 && isPrime(i)){fList.add(i);}
        }
        
        return fList;
    }
    
    public static int Euler7(){ 
        ArrayList testSeive;
        testSeive = pSeive(300000);
        return (int)testSeive.get(10000);
    }
    
    public static long Euler3(){
        long a = 600851475143L;
        
        ArrayList b = pFactor(a);
        int c = b.size();
        return((long)b.get(c-1));
    }
    
    public static long Euler10(){ //BROKEN!!!
        
        long result = 2;
        for (int i = 3; i <2000000; i++) {
            //System.out.println(i);
            if(isPrime(i)){System.out.println(i);result += i;}
        }
        return result;
    }
    
}

