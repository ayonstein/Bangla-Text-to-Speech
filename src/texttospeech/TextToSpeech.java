package texttospeech;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class TextToSpeech {

    public static void main(String[] args) {
        TextToSpeech tts = new TextToSpeech();
        tts.readTextFile("Text", "out");
        
        tts.playAudio();
    }
    
    private void playAudio() {
        try {
            
            SoundBank sb = new SoundBank("sounds");
            List<AudioInputStream> line = new ArrayList();
            
            line.add(sb.getSound("va"));
            line.add(sb.getSound("aar"));
            line.add(sb.getSound("chi"));
            line.add(sb.getSound("Ti"));
            line.add(sb.getSound("ir"));
            
            line.add(sb.getSound("250ms"));
            
            line.add(sb.getSound("thi"));
            line.add(sb.getSound("chi"));
            line.add(sb.getSound("chhe"));
            line.add(sb.getSound("er"));
            
            line.add(sb.getSound("250ms"));
           
            line.add(sb.getSound("jo"));
            line.add(sb.getSound("n-hs"));
            line.add(sb.getSound("no"));
            
            line.add(sb.getSound("250ms"));
            
            line.add(sb.getSound("o"));
            line.add(sb.getSound("yo"));
            line.add(sb.getSound("n-hs"));
            
            line.add(sb.getSound("250ms"));
            
            line.add(sb.getSound("ba"));
            line.add(sb.getSound("ng"));
            line.add(sb.getSound("la"));
            
            line.add(sb.getSound("250ms"));
            
            line.add(sb.getSound("bya"));
            line.add(sb.getSound("ko"));
            line.add(sb.getSound("ro"));
            line.add(sb.getSound("n-hs"));
            
            line.add(sb.getSound("250ms"));
            
            line.add(sb.getSound("gha"));
            line.add(sb.getSound("at"));
            line.add(sb.getSound("chhe"));
            
            line.add(sb.getSound("1sec"));
      
            concatenateFiles(line, "output");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void readTextFile(String readFileName, String writeFileName) {
        Path readPath = Paths.get(readFileName);
        Path writePath = Paths.get(writeFileName);
        try {
            Scanner scanner = new Scanner(readPath, "UTF-8");
            BufferedWriter writer = Files.newBufferedWriter(writePath);
            String output = "";
            LetterMap lm = new LetterMap();
            boolean lastWasIndependent = false;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.newLine();
                for(int i = 0; i < line.length(); i++) {
                    writer.write(line.charAt(i) + " ");
                    
                    String independent = lm.independentMap.get(line.charAt(i)), dependent = lm.dependentMap.get(line.charAt(i));
                    if(line.charAt(i) == '্') {
                        output += "/hs ";
                        lastWasIndependent = false;
                    }
                    else if(independent != null) {
                        if(lastWasIndependent) output += " ";
                        output += independent;
                        lastWasIndependent = true;
                    }
                    else if(dependent != null) {
                        output += "/" + dependent + " ";
                        lastWasIndependent = false;
                    }
                }
            }
            writer.write("\n");
            writer.write(output);
            writer.flush();
            writer.close();
            scanner.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public Boolean concatenateFiles(List<AudioInputStream> audioInputStreamList, String destinationFileName) {
        Boolean result = false;

        AudioFormat audioFormat = null;
        Long frameLength = null;

        try {
            for (AudioInputStream audioInputStream : audioInputStreamList) {
                if (audioFormat == null) {
                    audioFormat = audioInputStream.getFormat();
                }
                if(frameLength == null) {
                    frameLength = audioInputStream.getFrameLength();
                }
                else {
                    frameLength += audioInputStream.getFrameLength();
                }
            }
            AudioInputStream out = new AudioInputStream(new SequenceInputStream(Collections.enumeration(audioInputStreamList)), audioFormat, frameLength);

            AudioSystem.write(out, Type.WAVE, new File(destinationFileName));

            result = true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (audioInputStreamList != null) {
                    audioInputStreamList = null;
            }
        }
        return result;
    }
}

