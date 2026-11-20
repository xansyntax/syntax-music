package androidx.media3.common.audio;

import android.media.AudioFocusRequest;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import com.metrolist.music.playback.MusicService$$ExternalSyntheticLambda6;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioFocusRequestCompat {
    public final AudioAttributes audioAttributes;
    public final Handler focusChangeHandler;
    public final int focusGain;
    public final AudioFocusRequest frameworkAudioFocusRequest;
    public final MusicService$$ExternalSyntheticLambda6 onAudioFocusChangeListener;
    public final boolean pauseOnDuck;

    public AudioFocusRequestCompat(int i, MusicService$$ExternalSyntheticLambda6 musicService$$ExternalSyntheticLambda6, Handler handler, AudioAttributes audioAttributes, boolean z, boolean z2) {
        this.focusGain = i;
        this.focusChangeHandler = handler;
        this.audioAttributes = audioAttributes;
        this.pauseOnDuck = z;
        this.onAudioFocusChangeListener = musicService$$ExternalSyntheticLambda6;
        this.frameworkAudioFocusRequest = new AudioFocusRequest.Builder(i).setAudioAttributes(audioAttributes.getPlatformAudioAttributes()).setWillPauseWhenDucked(z).setOnAudioFocusChangeListener(musicService$$ExternalSyntheticLambda6, handler).setAcceptsDelayedFocusGain(z2).build();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AudioFocusRequestCompat) {
            AudioFocusRequestCompat audioFocusRequestCompat = (AudioFocusRequestCompat) obj;
            if (this.focusGain == audioFocusRequestCompat.focusGain && this.pauseOnDuck == audioFocusRequestCompat.pauseOnDuck && this.onAudioFocusChangeListener == audioFocusRequestCompat.onAudioFocusChangeListener && this.focusChangeHandler.equals(audioFocusRequestCompat.focusChangeHandler) && Objects.equals(this.audioAttributes, audioFocusRequestCompat.audioAttributes)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.focusGain), this.onAudioFocusChangeListener, this.focusChangeHandler, this.audioAttributes, Boolean.valueOf(this.pauseOnDuck));
    }
}
