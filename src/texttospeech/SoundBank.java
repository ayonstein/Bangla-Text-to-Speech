package texttospeech;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;

class SoundBank {
    private Map<String, Phoneme> sounds;
    
    public SoundBank(String soundDirectory) {
        this.sounds = new HashMap();
        
        try{
            Files.walk(Paths.get(soundDirectory)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    Phoneme p = new Phoneme(filePath.toFile());
                    this.sounds.put(p.getPhoneme(), p);
                }
            });
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("SoundBank: Created " + sounds.size() + " phonemes objects");
    }
    
    public AudioInputStream getSound(String phoneme) throws Exception{
        if(this.sounds.containsKey(phoneme)) return this.sounds.get(phoneme).getAudio();
        //throw new Exception();
        return null;
    }
}
