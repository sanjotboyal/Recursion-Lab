package recursion;
public class RecursiveStringReplace
{

    /**
     * replace - Replace all instances of one character by another.
     * 
     * @param  s   The string to do the replacement on.
     * @param  from   The character to be replaced.
     * @param  to   the character to change to.
     * @return     A new string with the appropriate characters replaced.
     */
    public String replace(String s, char from, char to)
    {
        String result = null;
        
        //if the string is of length 0: just empty string
        if(s.length() == 0){
            result = "";
            
        //if the string is of length 1: base case 
        }else if(s.length()==1){
            //if the string is equal to the from value: replace it with the 'to' char value
            if(s.equals(String.valueOf(from))){
                result = String.valueOf(to);
            }else{
                //else result is just that unchanged char
                result = s;
            }
        }else{
            //first letter before recursion checked and replaced if needed
            String holdFirst = first(s);
            //replaces if its equal to the from value
             if(holdFirst.equals(String.valueOf(from))){
                holdFirst = String.valueOf(to);
            }
            
            //runs recursion to replace by checking each letter 
            String rest = replace(rest(s),from,to);
            
            //calls prepend function to join it together (adds it to orignal string)
            result = Prepend(holdFirst,rest);
        }
        
        return result;
    }
    
    public String first(String x){
        return x.substring(0,1);
    }
    
    public String rest(String x){
        return x.substring(1,x.length());
    }
    
    public String Prepend(String add, String original){
        String combined  = add + original;
        return combined;
    }

}
