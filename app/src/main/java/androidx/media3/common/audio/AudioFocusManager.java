package androidx.media3.common.audio;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.ExoPlayer$Builder$$ExternalSyntheticLambda2;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import com.google.common.base.Supplier;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.MusicService$$ExternalSyntheticLambda6;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioFocusManager {
    public AudioAttributes audioAttributes;
    public AudioFocusRequestCompat audioFocusRequest;
    public final Supplier audioManager;
    public final Handler eventHandler;
    public int focusGainToRequest;
    public ExoPlayerImplInternal playerControl;
    public float volumeMultiplier = 1.0f;
    public byte audioFocusState = 0;

    public AudioFocusManager(Context context, Looper looper, ExoPlayerImplInternal exoPlayerImplInternal) {
        this.audioManager = DatabaseDao_Impl.AnonymousClass17.memoize(new ExoPlayer$Builder$$ExternalSyntheticLambda2(context, (byte) 1));
        this.playerControl = exoPlayerImplInternal;
        this.eventHandler = new Handler(looper);
    }

    public final void abandonAudioFocusIfHeld() {
        byte b = this.audioFocusState;
        if (b == 1 || b == 0 || this.audioFocusRequest == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.audioManager.get();
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest.frameworkAudioFocusRequest;
        audioFocusRequest.getClass();
        audioManager.abandonAudioFocusRequest(audioFocusRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAudioFocusState(int i) {
        if (this.audioFocusState == i) {
            return;
        }
        this.audioFocusState = i;
        float f = i == 4 ? 0.2f : 1.0f;
        if (this.volumeMultiplier == f) {
            return;
        }
        this.volumeMultiplier = f;
        ExoPlayerImplInternal exoPlayerImplInternal = this.playerControl;
        if (exoPlayerImplInternal != null) {
            exoPlayerImplInternal.handler.sendEmptyMessage(34);
        }
    }

    public final int updateAudioFocus(int i, boolean z) {
        int i2;
        MimeTypes.Mp4aObjectType mp4aObjectType;
        if (i == 1 || (i2 = this.focusGainToRequest) != 1) {
            abandonAudioFocusIfHeld();
            setAudioFocusState(0);
            return 1;
        }
        byte b = this.audioFocusState;
        if (z) {
            if (b != 2) {
                AudioFocusRequestCompat audioFocusRequestCompat = this.audioFocusRequest;
                if (audioFocusRequestCompat == null) {
                    if (audioFocusRequestCompat == null) {
                        mp4aObjectType = new MimeTypes.Mp4aObjectType();
                        AudioAttributes audioAttributes = AudioAttributes.DEFAULT;
                        mp4aObjectType.audioObjectTypeIndication = i2;
                    } else {
                        MimeTypes.Mp4aObjectType mp4aObjectType2 = new MimeTypes.Mp4aObjectType();
                        mp4aObjectType2.audioObjectTypeIndication = audioFocusRequestCompat.focusGain;
                        mp4aObjectType = mp4aObjectType2;
                    }
                    AudioAttributes audioAttributes2 = this.audioAttributes;
                    boolean z2 = audioAttributes2 != null && audioAttributes2.contentType == 1;
                    audioAttributes2.getClass();
                    this.audioFocusRequest = new AudioFocusRequestCompat(mp4aObjectType.audioObjectTypeIndication, new MusicService$$ExternalSyntheticLambda6((byte) 1, this), this.eventHandler, audioAttributes2, z2, true);
                }
                AudioManager audioManager = (AudioManager) this.audioManager.get();
                AudioFocusRequest audioFocusRequest = this.audioFocusRequest.frameworkAudioFocusRequest;
                audioFocusRequest.getClass();
                int iRequestAudioFocus = audioManager.requestAudioFocus(audioFocusRequest);
                if (iRequestAudioFocus == 1 || iRequestAudioFocus == 2) {
                    setAudioFocusState(2);
                    return 1;
                }
                setAudioFocusState(1);
                return -1;
            }
        } else {
            if (b == 1) {
                return -1;
            }
            if (b == 3) {
                return 0;
            }
        }
        return 1;
    }
}
