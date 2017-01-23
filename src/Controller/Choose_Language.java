package Controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gabriel
 */

public class Choose_Language {

    public static void Choose_Language(String language) throws IOException{
        
        switch(language){
          
            case "Portuguese":
                Select_language("Portuguese");
                break;
            case "English":
                Select_language("English");
                break;
            
        }
        
    }
    
    public static void Select_language(String language) throws IOException{
     
        InputStream is = null;
        BufferedReader br = null;
        
        try{
        
            if(language.equals("Portuguese")){
                is = new FileInputStream("C:\\Users\\Gabriel\\Desktop\\AirSystem\\src\\language\\portuguese.txt");
            }else if(language.equals("English")){
                is = new FileInputStream("C:\\Users\\Gabriel\\Desktop\\AirSystem\\src\\language\\english.txt");
            } 

            map_languages = new HashMap();
            
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String s = br.readLine(); // primeira linha

            while (s != null) {
                String palavras[] = s.split("=");
                map_languages.put(palavras[0], palavras[1]);
                s = br.readLine();
            }
        
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            br.close();
        }
    }

    public static Map<String, String> map_languages = new HashMap<>();
    
    public static Map<String, String> getMap_languages() {
        return map_languages;
    }

    public void setMap_languages(Map<String, String> map_languages) {
        this.map_languages = map_languages;
    }
     
}
