# Adapter

## Description

Adapter pattern allows objects with incompatible interfaces to collaborate. It works as a bridge between two incompatible interfaces, enabling them to work together. This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.

## Java Code Example

```java
// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee class
class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

// Concrete class implementing MediaPlayer
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// Main class to test the Adapter pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
```
In this example:

* `MediaPlayer` is the target interface with a method `play` that clients use.
* `AdvancedMediaPlayer` is the adaptee class with specific methods to play `vlc` and `mp4` files.
* `MediaAdapter` is the adapter class that implements `MediaPlayer` and adapts the interface of `AdvancedMediaPlayer` to the `MediaPlayer` interface.
* `AudioPlayer` is a concrete class that implements `MediaPlayer` and uses `MediaAdapter` to play other formats.

When you run the `AdapterPatternDemo` class, it will use the `AudioPlayer` to play various formats (`mp3`, `mp4`, `vlc`) and show how the adapter pattern works by adapting the `AdvancedMediaPlayer` to the `MediaPlayer` interface.

