import java.util.Scanner;
class Main{
    
    public static void reverse(char character[]){
        
        int i = 0;
        int j = character.length - 1;
        
        while(i < j){
            
            char ch = character[i];
            character[i] = character[j];
            character[j] = ch;
            
            i++;
            j--;
        }

    }
    
    public static void main(String []k){
        
        Scanner s1 = new Scanner(System.in);
        
        String s = s1.next();
        
        int n = s.length();
        
        char character[] = new char[n];
        int index = 0;
        
        
        
        for(int i = 0; i < n; i++){
            
            char ch = ' ';
            
            if(s.charAt(i) != ' '){
                ch = s.charAt(i);
                character[index] = ch;
                index++;
                ch = ' ';
                
            }
        }

        reverse(character);
        
        
        for(int i = 0; i < n; i++){
            System.out.print(character[i]);
        }
        
    }
}
