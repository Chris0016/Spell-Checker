public class LinkedList
{
    /*
    Since this linked list will be used for the implemention of a hash table 
    it doesn't need to have elaborate methods.
    
    essentail functions:
    search(string word);
    addTail();
    removeNode(String input);
    
    */
    Node head;
    Node curr;
    Node tail;
    
    class Node{
        String word;
        Node next;
        
        public Node(String word){
            this.word = word;
            next = null; 
        }
    }

    public LinkedList(String input){
        Node node1 = new Node(input);
        head = node1;
        tail = node1;
    }
    
    boolean search(String word){
        curr = head;
        
        while (curr != null){
            if (curr.word.equals(word)) return true;
            curr = curr.next;
        }
        return false;
    }
    void addTail(String word){
        Node input = new Node(word);
        
        //No elements
        if (isEmpty()){
            head = input;
            tail = input;
        }
        //One or more elements
        else{
            tail.next = input;
            tail = input;
        }
    }
    void removeNode(String input){
        if (head == null){
            
        }
        else{
            curr = head;
    
            if (curr.word.equals(input)){ 
                //Remove Head
                curr = head.next;
                head.next  = null;
                head = curr;
                return;
            }
            //Find element before it 
           
            
            for( ;curr.next != null; curr = curr.next){
                if (curr.next.word.equals(input))
                {
                    //Curr has a pointer to the Node before the desired Node
                    //Eliminate all links, to be removed by garbage collector
                    curr.next = curr.next.next;
                    if (curr.next == null ) 
                        tail = curr;//Reassign tail bc the last val is going to be deleted
                    
                    curr = curr.next; //Go to desired node
                    
                    if (curr != null ) //Curr is null if the desired was the last element since curr has now be shifted to the right
                     curr.next = null;
                        
                    break;
                }
            }
           
            
        }
    }
    void removeTail(){
        //Zero or one element
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            curr = head;
            while(curr.next.next != null){ // Check if element ahead is last
                curr = curr.next;
            }
            // curr is second to last element
            tail = curr;
            curr.next = null;
        }
    }
    
    boolean isEmpty(){
        return head == null;
    }
    void printList(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.word + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
