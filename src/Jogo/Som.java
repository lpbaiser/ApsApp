/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

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
 * @author emanuel
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
