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
public static HashMap<String, String> Idioma_Escolhido(String idioma) throws IOException{
        HashMap<String, String> map_idioma = new HashMap();
        InputStream is = null;
        BufferedReader br = null;
        
        try{
        
            if(idioma.equals("Portugues")){
                is = new FileInputStream("C:\\Users\\User\\Desktop\\JavaFX_Multi_Idiomas\\src\\javafx_multi_idiomas\\portugues.txt");
            }if(idioma.equals("Ingles")){
                is = new FileInputStream("C:\\Users\\User\\Desktop\\JavaFX_Multi_Idiomas\\src\\javafx_multi_idiomas\\ingles.txt");
            } 

            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String s = br.readLine(); // primeira linha

            while (s != null) {
                String palavras[] = s.split("=");
                map_idioma.put(palavras[0], palavras[1]);
                s = br.readLine();
            }
        
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            br.close();
        }
        
        return map_idioma;
    }
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
