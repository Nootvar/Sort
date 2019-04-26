package model;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

public class SortListener implements ISortListener {

    private int size;

    public SortListener(int size) {
        this.size = size;
    }

    @Override
    public void onValueAccessed(int value) {
        //playSound("beep.wav", value/(float)size + 1);
    }

    @Override
    public void onValueDisplaced(int value) {
        //playSound("beep.wav", value/(float)size + 1);
    }

    @Override
    public void onValuesDisplaced(int fromValue, int toValue) {

    }

    @Override
    public void onValuesCompared(int fromValue, int tValue) {

    }

    private static synchronized void playSound(final String url, float rate) {
        try {
            Clip clip = AudioSystem.getClip();
            InputStream stream = new FileInputStream("c:/temp/" + url);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(stream));
            //AudioInputStream ratedAudioStream  = AudioSystem.getAudioInputStream(getOutFormat(audioStream.getFormat(), rate), audioStream);
            Sonic sonic = new Sonic(1, audioStream.getFormat().getChannels());
            sonic.setPitch(rate);
            clip.open(audioStream);
            clip.start();
            //ratedAudioStream.close();
            audioStream.close();
            stream.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

//    private static AudioFormat getOutFormat(AudioFormat inFormat, float rate) {
//        return new AudioFormat(
//                inFormat.getEncoding(),
//                11025,
//                inFormat.getSampleSizeInBits(),
//                inFormat.getChannels(),
//                inFormat.getFrameSize(),
//                rate,
//                inFormat.isBigEndian()
//        );
//    }
}
