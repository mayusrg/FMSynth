import java.util.concurrent.atomic.AtomicReference;

public class Voice {
    private final double freq;
    private final double velocity;
    private final Params params;

    private final eCarrier carrier;
    private final eModulator modulator;

    private double phaseCarrier = 0.0;
    private double phaseModulator = 0.0;

    private boolean released = false;
    private boolean finished = false;

    public Voice(double f, double v, AtomicReference<Params> p) {
        freq = f;
        velocity = v;
        params = p.get();
        
        carrier = new eCarrier(params.attack, params.decay, params.sustain, params.release, p);
        modulator = new eModulator(params.attack * .5, params.decay * .6, params.sustain, params.release * .5, p);
    }

    public double getFreq() {
        return freq;
    }
}
