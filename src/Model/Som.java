
package Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
/**
*
* @author Emanuel Mazzer & Leonardo Baiser 
* @version 1.0
* @since 19/10/2015
*/
public class Som {

    public void music(String s) {
        AudioPlayer MGP = AudioPlayer.player; 
        AudioStream BGM = null;
        try {
            BGM = new AudioStream(new FileInputStream("src/som/"+s+".wav"));  
        } catch (IOException ex) {
            System.out.println("Erro: "+ ex.getMessage());
        }
 
        MGP.start(BGM);
    }

}
