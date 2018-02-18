package recursion;

public class RecursiveFactorial
{

    /**
     * The basic recursive factorial. 
     * 
     * @param  n   The number to compute factorial of.
     * @return     n factorial.
     */
    public long basic(long n)
    {
        long result = 1;
        // IMPLEMENT THIS METHOD 
        // AND RETURN SOMETHING APPROPRIATE
//>>>>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //negatives just return -1
       if(n<0){
           return -1;
       } 
       
       //base case return 1 
       else if (n==0 || n==1){
           return 1;
       //continuously call back function with n-1 multiplied by n 
       }else{
           result = basic(n-1) *n;
       }
       return result;
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
    }
    
    
    
    /**
     * The tail recursive version of factorial.
     * 
     * @param  n   The number to compute factorial of.
     * @return     n factorial.
     */
    public long tailRecursive(long n)
    {
        // IMPLEMENT THIS METHOD USING THE RECURSIVE HELPER FUNCTION
        // AND RETURN SOMETHING APPROPRIATE
//>>>>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    
        
        //call helper 
        return helper(n,1);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
    }

    /**
     * The tail recursive helper function for factorial. 
     * 
     * @param  n   The number to compute factorial of.
     * @param  partial   The partial result that is being built up.
     * @return     n factorial.
     */

    private long helper(long n, long partial)
    {
        long result = 0;
        // IMPLEMENT THIS TAIL RECURSIVE METHOD
//>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        //negative return something (just make partial positive)
        if(n<0) return partial *-1;
        
        //result = partial if n=0 :base 
        else if(n==0) {
            result = partial;
        }else{
            //recursive call (n-1)
            result = helper(n-1, n*partial);
        }
        return result;
    }

}
