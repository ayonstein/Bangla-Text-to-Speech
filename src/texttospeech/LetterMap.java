package texttospeech;

import java.util.*;

public class LetterMap {
    public final Map<Character, String> independentMap = new HashMap<Character, String>();
    public final Map<Character, String> dependentMap = new HashMap<Character, String>();
    public LetterMap() {
        independentMap.put('ক', "ka");
        independentMap.put('খ', "kha");
        independentMap.put('গ', "ga");
        independentMap.put('ঘ', "gha");
        independentMap.put('ঙ', "ka"); //fix
        independentMap.put('চ', "cha");
        independentMap.put('ছ', "chha");
        independentMap.put('জ', "ja"); //fix
        independentMap.put('ঝ', "jha");
        independentMap.put('ঞ', "ka"); //fix
        independentMap.put('ট', "Ta");
        independentMap.put('ঠ', "Tha");
        independentMap.put('ড', "Da");
        independentMap.put('ঢ', "Dha");
        independentMap.put('ণ', "Na");
        independentMap.put('ত', "ta");
        independentMap.put('থ', "tha");
        independentMap.put('দ', "da");
        independentMap.put('ধ', "dha");
        independentMap.put('ন', "na");
        independentMap.put('প', "pa");
        independentMap.put('ফ', "pha");
        independentMap.put('ব', "ba");
        independentMap.put('ভ', "bha");
        independentMap.put('ম', "ma");
        independentMap.put('য়', "yo"); //fix
        independentMap.put('ড়', "Ra"); //fix
        independentMap.put('ঢ়', "RA");
        independentMap.put('য', "ja"); //fix
        independentMap.put('র', "ra");
        independentMap.put('ল', "la");
        independentMap.put('হ', "ha");
        independentMap.put('শ', "sha");
        independentMap.put('ষ', "Sha");
        independentMap.put('স', "sa");
        independentMap.put('অ', "a");
        independentMap.put('আ', "aa");
        independentMap.put('ই', "i");
        independentMap.put('ঈ', "ii");
        independentMap.put('উ', "u");
        independentMap.put('ঊ', "uu");
        independentMap.put('এ', "e");
        independentMap.put('ঐ', "ou");
        independentMap.put('ও', "o");
        independentMap.put('ঔ', "ou");
        
        dependentMap.put('া', "aa");
        dependentMap.put('ি', "i");
        dependentMap.put('ী', "ii");
        dependentMap.put('ু', "u");
        dependentMap.put('ূ', "uu");
        dependentMap.put('ে', "e");
        dependentMap.put('ৈ', "oi");
        dependentMap.put('ো', "o");
        dependentMap.put('ৌ', "ou");
    }
    
    public String getDependent(Character ch) {
        return null;
    }
    
    public String getIndependent(Character ch) {
        return null;
    }
    
}
