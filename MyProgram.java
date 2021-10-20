import java.util.*;
import java.io.*;


public class MyProgram
{
    public static void main(String[] args)
    {
        
       try{
           Scanner txt = new Scanner( new FileReader(new File("sampleText.txt")) );
            int[] data = analyze(txt);
            System.out.println("Errors: "+ data[0]);
            System.out.println("Words: "+ data[1]);
            System.out.println("Mispelled %: "+ ((double)data[0]/data[1] ) * 100 );
    
       }
    catch(Exception e){
        System.out.println("Error\n" + e);
        System.exit(0);
    }
       
     // Dictionary merriam_webster = new Dictionary(634, "SmallDictionary.txt");
      //System.out.print(merriam_webster.isWord(""));
    
        
    }
    
    public static int[] analyze(Scanner input)  {
        
        Dictionary merriam_webster = new Dictionary(634, "SmallDictionary.txt");
        int[] data = new int[2];       
        String curr = input.next(); 
        int eCount = 0;
        int wCount = 0;
        boolean check ;
        try{
        while ( curr != null ){
            check = merriam_webster.isWord(curr.toLowerCase());
            if(check ==  false) eCount++;
            wCount++;
            
            curr = input.next();
            
        }
        }catch(Exception e){}
        merriam_webster.endSession();
        data[0] = eCount; data[1] = wCount; 
        return data;
        
    }
    
}
