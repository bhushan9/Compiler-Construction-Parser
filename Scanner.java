package scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is the main class for the Scanner
 */

/**
 * @author Danny Reinheimer
 *
 */
public class Scanner {
    
    
    public static  List<String> L = new ArrayList<String>();
    

	/**
	 * @param args The file name 
	 */
	public static void Scanner(String filename) throws IOException {
		// checks to see if we are given any arguments
	/*	if(args.length < 1) {
			System.err.println("Please provide an input file to process");
			System.exit(1);
		}
*/
		
		String fileName = filename;
		Scan scan = new Scan(fileName);
		Pair<TokenNames,String> tokenPair;
		
		try {
			// get the name of the file minus the dot 
			int pos = fileName.lastIndexOf(".");
			String newFileName = fileName.substring(0, pos) + "_gen.c";
			//PrintWriter writer = new PrintWriter(newFileName,"UTF-8");
                        FileWriter fw = new FileWriter(newFileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// keep getting the next token until we get a null
			while((tokenPair = scan.getNextToken()) != null) {
				// check to see if the token is an identifer but not main
				if(tokenPair.getKey() == TokenNames.Identifiers) {
                                    L.add("ID");
                                    
                                }
                               else  if(tokenPair.getKey() == TokenNames.Numbers)
                                    
                                {
                                 L.add("digit");
                             
                                }
                              else   if(tokenPair.getKey() == TokenNames.Symbol)
                                 {String s= getSubType(tokenPair.getValue());
                                   L.add(s);
					
				}
                               else  if(tokenPair.getKey()== TokenNames.ReserveWord)
                                 {
                                  L.add(tokenPair.getValue());
                                 }
                               else   if(tokenPair.getKey() == TokenNames.String)
                                    
                                {
                                 L.add("string");
                             
                                }
                                  
                           
				
                      
                        /*
                        System.out.println(Arrays.toString(L.toArray()));
                       for(int i=0;i<1000;i++)
                        System.out.println(tokenarray[i]);
                                */
                        }
                          L.add("EOF");
        // L.forEach(System.out::println);
        

                        
			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("Could not create output file");
			System.exit(1);
		} catch (UnsupportedEncodingException e) {
			System.err.println("Error encoding output file.  Not my fault though");
			System.exit(1);
		}
		
		
		

	}
        
        
         public static String getSubType(String c)
    {
        String type=null;
       switch(c)
       {
       
           case "(": type="left_parenthesis";  break;
           case ")": type="right_parenthesis"; break;
           case "{": type="left_brace";        break;
           case "}": type="right_brace";       break;
           case "[": type="left_bracket";      break;
           case "]": type="right_bracket";     break;
           case ",": type="comma";             break;
           case ";": type="semicolon";         break;
           case "+": type="plus_sign";         break;
           case "-": type="minus_sign";        break;
           case "*": type="star_sign";         break;
           case "/": type="forward_slash";     break;
           case ">": type=">";                 break;
           case "<": type="<";                 break;
           case "=": type="equal_sign";       break; 
           case "==":type="==";                break;
           case "!=": type="!=";               break;
           case ">=": type=">=";               break;
           case "<=": type="<=";               break;
           case "&&": type="double_and_sign";  break;
           case "||":  type="double_or_sign";  break;
           
           
         }
    
     return type;
    
    }

        }
