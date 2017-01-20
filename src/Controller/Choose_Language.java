package Controller;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gabriel
 */

public class Choose_Language {

    public Choose_Language(String language){
        
        switch(language){
          
            case "Portuguese":
                Select_language("Portuguese");
                break;
            case "English":
                Select_language("English");
                break;
            
        }
        
    }
    
    private void Select_language(String language){
        
    }

    public static Map<String, String> map_languages = new HashMap<>();
    
    public static Map<String, String> getMap_languages() {
        return map_languages;
    }

    public void setMap_languages(Map<String, String> map_languages) {
        this.map_languages = map_languages;
    }
    
    
    
}
