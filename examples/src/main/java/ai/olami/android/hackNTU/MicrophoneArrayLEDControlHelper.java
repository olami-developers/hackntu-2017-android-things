package ai.olami.android.hackNTU;

import ai.olami.android.uart.MicrophoneArrayControl;

public class MicrophoneArrayLEDControlHelper {

    private static MicrophoneArrayLEDControlHelper mMicrophoneArrayLEDStateHandle = null;
    private MicrophoneArrayControl mMicrophoneArrayControl = null;

    private MicrophoneArrayLEDState mMicrophoneArrayLEDState = null;

    private LEDControlRunnable LEDRunnable = null;

    public enum MicrophoneArrayLEDState {
        INITIALIZING,
        PROCESSING,
        WAITING,
        SPEAKING
    }

    private MicrophoneArrayLEDControlHelper(
            MicrophoneArrayControl microphoneArrayControl
    ) {
        mMicrophoneArrayControl = microphoneArrayControl;
    }

    static public MicrophoneArrayLEDControlHelper create(
            MicrophoneArrayControl microphoneArrayControl
    ) {
        if (mMicrophoneArrayLEDStateHandle == null) {
            mMicrophoneArrayLEDStateHandle = new MicrophoneArrayLEDControlHelper(microphoneArrayControl);
        }
        return mMicrophoneArrayLEDStateHandle;
    }

    public void changeMicrophoneArrayLEDState(MicrophoneArrayLEDState state) {
        mMicrophoneArrayLEDState = state;

        if (LEDRunnable != null) {
            LEDRunnable.terminate();
        }
        LEDRunnable = new LEDControlRunnable();
        new Thread(LEDRunnable).start();
    }

    private class LEDControlRunnable implements Runnable {
        private boolean mCancel = false;

        public void terminate() {
            mCancel = true;
        }

        public void run() {
            while(!mCancel) {
                if (mMicrophoneArrayLEDState == MicrophoneArrayLEDState.INITIALIZING) {
                    mMicrophoneArrayControl.AllLedFade(255, 165, 0, 3000, 50);
                } else if (mMicrophoneArrayLEDState == MicrophoneArrayLEDState.WAITING) {
                    mMicrophoneArrayControl.AllLedFade(160, 32, 240, 3000, 50);
                } else if (mMicrophoneArrayLEDState == MicrophoneArrayLEDState.PROCESSING) {
                    mMicrophoneArrayControl.ledRotate(
                            0, 255, 0, 1500, 50, mMicrophoneArrayControl.CLOCKWISE);
                } else if (mMicrophoneArrayLEDState == MicrophoneArrayLEDState.SPEAKING) {
                    mMicrophoneArrayControl.ledRotate(
                            0, 0, 255, 1500, 50, mMicrophoneArrayControl.COUNTERCLOCKWISE);
                }
            }
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


