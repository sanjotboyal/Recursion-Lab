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
        
        
        if(s.length() == 0){
            result = "";
        }else if(s.length()==1){
            if(s.equals(String.valueOf(from))){
                result = String.valueOf(to);
            }else{
                result = s;
            }
        }else{
            String holdFirst = first(s);
             if(holdFirst.equals(String.valueOf(from))){
                holdFirst = String.valueOf(to);
            }
            
             
            String rest = replace(rest(s),from,to);
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
