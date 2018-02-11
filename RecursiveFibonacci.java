package recursion;
public class RecursiveFibonacci
{


    /**
     * basic - The simple version of fibonacci.
     * 
     * @param  n   A positive integer. 
     * @return     The nth fibonacci number.
     */
    public long basic(long n)
    {
        long result = 1;
        
        if( n <= 0)
            result = 0;
        else if (n == 1)
            result = 1;
        else
            result = basic(n-1) + basic(n-2);
        
        return result;
    }
    
    
    /**
     * better - A better version of fibonacci. (Height Limited Double Recursion)
     * 
     * @param  n   A positive integer.
     * @return     The nth fibonacci number.
     */
    public long better(long n)
    {
        long result = 0;
        // IMPLEMENT THIS RECURSIVE METHOD
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  
        //negative fib just return -1
        if(n<0){
            result = -1;
        }
        //if its 0 returns 0: base case
        else if(n==0){
            result = 0;
        //another base case: if its 1 just return 1
        }else if(n==1){
            result = 1;
        //apply even formula
        }else if(n%2 == 0){
            result = (better(n/2)*(better(n/2))) + (2*better(n/2)*better(n/2-1));
        //apply odd formula
        }else if (n%2 ==1){
            result = 2*(better(n/2)*better(n/2))+(2*better(n/2)*better(n/2-1))+(better(n/2-1)*better(n/2-1));
        }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
        return result;
    }


    /**
     * tailRecursive - A tail recursive version of fibonacci. 
     *              (Height limited, Two problems per level)
     * 
     * @param  n   A positive integer. 
     * @return     The nth fibonacci number.
     */
    public long tailRecursive(long n)
    {
        // IMPLEMENT THIS METHOD USING A RECURSIVE HELPER FUNCTION
        // AND RETURN AN APPROPRIATE VALUE
//>>>>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
       //call helper function
       return helper(n,1,0);
        
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
    } 
    
     
    /**
     * helper - The tail recursive helper function.
     * 
     * @param  n   A positive integer. 
     * @param  fi  The partial result f(i).
     * @param  fi1   The partial result f(i-1).
     * @return      The nth fibonacci number.
     */

    public long helper(long n, long fi, long fi1)
    {  
        long result = 0;
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  
       //if its 1: base case: its equal to 
       if (n<0){
           result = 0;
       }
       else if(n==1) {
           result = fi;
       //0 or - just set to fi1
       }else if(n==0){
           result = fi1;
           
       }else{
           //if second MSB returns true (1) as MSB: run the odd function recursively
           if(secondMSB(n)){
              
               result = helper(reduceBy2ndMSB(n),2*fi*fi+2*fi*fi1+fi1*fi1,fi*fi+2*fi*fi1);
           //returns 0: run even function recursively 
           }else{
               result = helper(reduceBy2ndMSB(n),fi*fi+2*fi*fi1,fi*fi+fi1*fi1);
           }
           
           
       }

     
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
        return result;
    }
       

    /**
     * secondMSB - Determine the value of the second most significant bit.
     * 
     * @param  n   A positive integer 
     * @return     True if the second most significant bit is 1, false otherwise.
     */    
    public boolean secondMSB(long n)
    {
        // IMPLEMENT THIS METHOD AND RETURN AN APPROPRIATE VALUE
//>>>>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>      
        //finds the second MSB: constantly divides the number by 2 
        while(n>4){
            n = n/2;
        }
        //checks if its divisible by 2 and equal to a remainder of 1 (odd => TRUE | even => FALSE)
        return (n%2 == 1);
        
 
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
      
    }


    /**
     * reduceBy2ndMSB - Reduce the number by removing the second most significant bit
     * from the representation.
     * 
     * @param  n   A positive integer > 1
     * @return     The integer value equivalent to removing the 2nd most significant bit
     *              from n.
     */    
    public long reduceBy2ndMSB(long n)
    {
        long result = 1;
        // IMPLEMENT THIS METHOD
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    
        //changes to the decimal number that the binary becomes once you remove the 2nd MSB
        if(n>3){
            long least = n%2;
            //recursion 
            result = reduceBy2ndMSB(n/2);
            result = result *2 + least;
        }

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        
        return result;
    }
    
    
}
