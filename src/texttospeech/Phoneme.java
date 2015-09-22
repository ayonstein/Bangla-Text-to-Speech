package texttospeech;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

class Phoneme {
    private String phoneme;
    private AudioInputStream audio;
    public Phoneme(File file) {
        try {
            
            this.phoneme = file.getName().substring(0, file.getName().lastIndexOf("."));
            this.audio = AudioSystem.getAudioInputStream(file);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getPhoneme() {
        return this.phoneme;
    }

    public AudioInputStream getAudio() {
        return this.audio;
    }

    @Override
    public String toString() {
        return this.phoneme;
    }
}