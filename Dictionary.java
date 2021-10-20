import java.util.*;
import java.io.*;

public class Dictionary{
    LinkedList[] dictionary;
    Scanner txtFile;
    
    public Dictionary(int size, String fileName){
        dictionary = new LinkedList[size+1];
        try{
        txtFile = new Scanner(new FileReader(new File(fileName)));
        }catch(Exception e){
            System.out.println("File not found");
            System.exit(0);
        }
        load();
    }
    public boolean isWord(String word){
        int idx = hash(word);
        if (dictionary[idx] == null) return false;
        
        return dictionary[idx].search(word);
    }
    public void load(){
        //Iterate through the file for every word
        String current = txtFile.next();
        while(txtFile.hasNext()){
            
            int idx = hash(current);
            //index at array is not already occupied
            if (dictionary[idx] == null){
                dictionary[idx] = new LinkedList(current);
            }
            else{
                dictionary[idx].addTail(current);
            }
            current = txtFile.next();
        }
    }
    
    public int hash(String input){
    
        char in = input.charAt(0) ;
       // if (input.length() > 1) in += input.charAt(1);
        return in;
    }
    public void endSession(){
        txtFile.close();
    }
    

    
}