/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblems;
import java.util.ArrayList;

/**
 *
 * @author colin
 */
public class EulerProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Euler7());
    }
    
    public static ArrayList pSeive(int n){ // This method returns an ArrayList containing all prime numbers less than n
        
        ArrayList pList = new ArrayList();
        for(int i = 2; i < n; i++){ // populate the list with all integers less than n
            pList.add(i);
        }
        int i = 0; // index for below while loop
        int p; // prime number to remove multiples of from list
        while(i < pList.size()){ // run through pList
            p = (int)pList.get(i); 
            // System.out.println(p);
            for(int j = i+1; j<pList.size(); j++){
                if((int)pList.get(j)%p == 0){pList.remove(j);} // removes all multiples of p from the list
            }
            i++;
        }
     
        return pList;
    }
    
    public static int Euler7(){
        ArrayList testSeive;
        testSeive = pSeive(300000);
        return (int)testSeive.get(10000);
    }
}
