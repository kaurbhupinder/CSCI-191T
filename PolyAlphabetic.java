import java.util.Scanner;

public class PolyAlphabetic
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
 
    public static String encryption(String plainText, int key1,int key2)
    {
    	int keyVal;
    	char replaceVal;
        plainText = plainText.toLowerCase();
        String cipherText = "";
        int position = 0;
        char charAt;
        for (int i = 0; i < plainText.length(); i++)
        {
        	    charAt = plainText.charAt(i);
        		if(Character.isLetter(charAt))	
        		{
        			int charPosition = ALPHABET.indexOf(plainText.charAt(i));
                    if(position % 2 == 0)
                    {
               	    keyVal = (key1 + charPosition) % 26;
                    replaceVal = ALPHABET.charAt(keyVal);
                    cipherText += replaceVal;
                    position++;
                    }
                    else 
                    {
                   	 keyVal = (key2 + charPosition) % 26;
                   	 replaceVal = ALPHABET.charAt(keyVal);
                   	 cipherText += replaceVal;
                   	 position++;
        		    }
        		}
                   
        		else if(plainText.charAt(i)== ' ')
        	     {
        		cipherText += " ";
        		position = position -2;
        	     }
        		else
        		{
        			cipherText += charAt;
        			position = position-2;
        		}	
           }
        
           return cipherText;
    }
    
   
    
    public static String decryption(String cipherText, int key1,int key2)
    {
    	int keyVal;
    	int position =0;
    	char charAt;
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
        	charAt = cipherText.charAt(i);
        	if(Character.isLetter(charAt))
    		{
        		int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
                if(position % 2 == 0)
                {
                	keyVal = (charPosition - key1) % 26;
                	if (keyVal < 0)
                	{
                    keyVal = ALPHABET.length() + keyVal;
                	}
                	char replaceVal = ALPHABET.charAt(keyVal);
                	plainText += replaceVal;
                	position++;
                }
                else
                {
                	keyVal = (charPosition - key2) % 26;
                    if (keyVal < 0)
                    {
                        keyVal = ALPHABET.length() + keyVal;
                    }
                    char replaceVal = ALPHABET.charAt(keyVal);
                    plainText += replaceVal;
                    position++;        	
                }
    		}
        	else if(cipherText.charAt(i)== ' ')
        	{
        		plainText += " ";
        		position = position -2;
        	}
        	else
        	{
        		plainText += charAt;
        		position = position -2;
        	}
        }
        return plainText;
    }
 
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String str = new String();
        str = scanner.nextLine();
        System.out.println("Encrypted Message is : "+encryption(str, 5,19));
        System.out.println("Decrypted Message is : "+decryption(encryption(str, 5,19), 5,19));
        scanner.close();
    	
    
    }
}