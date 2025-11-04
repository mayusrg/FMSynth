import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;

public class AudioThread extends Thread{
    static final int BUFFER_SIZE = 512;
    static final int BUFFER_COUNT = 8;
    private final int[] buffers = new int[BUFFER_COUNT];
    private final long device = alcOpenDevice(alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER));
    private final long context = alcCreateContext(device, new int[1]);
    private final int source;
    private int bufferIndex;

    private int sampleRate = 441000;
    private short[] getBuffer() {
        return new short[BUFFER_SIZE];
    }
    AudioThread()
    {
        alcMakeContextCurrent(context);
        AL.createCapabilities(ALC.createCapabilities(device));
        source = alGenSources();
        for (int i = 0; i < BUFFER_COUNT; i++)
        {
            bufferSamples(new short[0]);
        }
        alSourcePlay(source);
        start();
        alSourcePlay(source);
    }
    private void bufferSamples(short[] samples)
    {
        int buf = buffers[bufferIndex++];
        alBufferData(buf,AL_FORMAT_STEREO16, samples, sampleRate);
        alSourceQueueBuffers(source, buf);
        bufferIndex %= BUFFER_COUNT;
    }
}
