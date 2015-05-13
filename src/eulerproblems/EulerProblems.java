/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblems;
import java.math.BigInteger;
import java.util.ArrayList;
//import java.math.*;

/**
 *
 * @author colin
 */
public class EulerProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ArrayList pList = pSeive(200);
        System.out.println(pList.toString());
        
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
    
    public static boolean isSquare(long n){
        long sqrt = (long)Math.sqrt((double)n);
        return (sqrt*sqrt) == n;
    }
    
    public static long factorCount(long n){ // returns # of factors in 
        long factorcount = 0;
        for(int i = 1; i*i<n; i++){
            factorcount += (n%i == 0 ? 2 : 0);
        }
        
        return factorcount;
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
    
    public static long Euler10(){ 
        

        long result = 2;


        for (int i = 3; i <2000000; i++) {
            //System.out.println(i);
            if(isPrime(i)){System.out.println(i);result += i;}
        }
        return result;
    }
    
    
    public static long Euler12(){
        
        long trinum = 1; //triangular number
        long i = 1; // index of triangular number
        long fcard; // number of factors of trinum
        while(true){
            fcard = 0;
            for(long j = 1; j<=trinum; j++){
                fcard = (trinum%j == 0) ? fcard+1 : fcard;
            } 
            System.out.println(fcard);
            if(fcard > 500){break;}
            ++i;
            trinum += i;
            
        }
        return trinum;
        
    }
    
    public static long Euler29() { // 5.13.15 - RETURNS INCORRECT ANSWER
        
        ArrayList disPow = new ArrayList();
        BigInteger n;
        for ( int a = 2; a <= 200; a++){
            for (int b = 2; b <= 200; b++){
                //n = (long) Math.pow(a, b);
                
                n = new BigInteger(Integer.toString(a)).pow(b);
                //System.out.println(n.toString());
                if(!disPow.contains(n)){
                    disPow.add(n);
                }
            }
        }
        System.out.print(disPow);
        return(disPow.size());
    }
        
        
}
    
    


