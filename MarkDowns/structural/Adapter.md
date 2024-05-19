# Adapter

## Description

Adapter pattern allows objects with incompatible interfaces to collaborate. It works as a bridge between two incompatible interfaces, enabling them to work together. This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.

## Java Code Example

```java
interface MediaPlayer {
    void play(String audioType, String fileName);
}

class AudioPlayer implements MediaPlayer {
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);            
        }
    }
}

interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }
    public void playMp4(String fileName) { }
}

class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) { }
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;
    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();            
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }   
    }
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        MediaPlayer mediaAdapter = new MediaAdapter("mp4");
        mediaAdapter.play("mp4", "alone.mp4");
    }
}
```
