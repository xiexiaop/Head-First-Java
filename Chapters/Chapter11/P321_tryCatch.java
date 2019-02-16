import javax.sound.midi.*;

class MusicTest1 {
    void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successfully get a sequencer");
        } catch (Exception e) {
            System.out.println("Bummer");
        }
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}