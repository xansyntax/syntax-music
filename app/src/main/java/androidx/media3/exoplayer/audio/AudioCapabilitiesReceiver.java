package androidx.media3.exoplayer.audio;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.util.SpatializerWrapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.metrolist.music.playback.MusicService$audioDeviceCallback$1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioCapabilitiesReceiver {
    public AudioAttributes audioAttributes;
    public AudioCapabilities audioCapabilities;
    public final MusicService$audioDeviceCallback$1 audioDeviceCallback;
    public final Context context;
    public final ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver;
    public final Handler handler;
    public final NetworkTypeObserver.Receiver hdmiAudioPlugBroadcastReceiver;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 listener;
    public boolean registered;
    public AudioDeviceInfo routedDevice;
    public SpatializerWrapper spatializer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExternalSurroundSoundSettingObserver extends ContentObserver {
        public final ContentResolver resolver;
        public final Uri settingUri;

        public ExternalSurroundSoundSettingObserver(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.resolver = contentResolver;
            this.settingUri = uri;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            AudioCapabilitiesReceiver.this.updateCurrentAudioCapabilities();
        }
    }

    public AudioCapabilitiesReceiver(Context context, OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0, AudioAttributes audioAttributes, AudioDeviceInfo audioDeviceInfo) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.listener = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        this.audioAttributes = audioAttributes;
        this.routedDevice = audioDeviceInfo;
        Handler handlerCreateHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper(null);
        this.handler = handlerCreateHandlerForCurrentOrMainLooper;
        this.audioDeviceCallback = new MusicService$audioDeviceCallback$1((byte) 1, this);
        this.hdmiAudioPlugBroadcastReceiver = new NetworkTypeObserver.Receiver((byte) 3, this);
        RegularImmutableList regularImmutableList = AudioCapabilities.DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS;
        String str = Build.MANUFACTURER;
        Uri uriFor = (str.equals("Amazon") || str.equals("Xiaomi")) ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        this.externalSurroundSoundSettingObserver = uriFor != null ? new ExternalSurroundSoundSettingObserver(handlerCreateHandlerForCurrentOrMainLooper, applicationContext.getContentResolver(), uriFor) : null;
    }

    public final List getSpatializerChannelMasks() {
        SpatializerWrapper spatializerWrapper;
        if (Build.VERSION.SDK_INT >= 32 && (spatializerWrapper = this.spatializer) != null) {
            return spatializerWrapper.getSpatializedChannelMasks();
        }
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        return RegularImmutableList.EMPTY;
    }

    public final void onNewAudioCapabilities(AudioCapabilities audioCapabilities) {
        if (!this.registered || audioCapabilities.equals(this.audioCapabilities)) {
            return;
        }
        this.audioCapabilities = audioCapabilities;
        AudioTrackAudioOutputProvider audioTrackAudioOutputProvider = (AudioTrackAudioOutputProvider) this.listener.f$0;
        audioTrackAudioOutputProvider.verifySinglePlaybackLooper();
        AudioCapabilities audioCapabilities2 = audioTrackAudioOutputProvider.audioCapabilities;
        if (audioCapabilities2 == null || audioCapabilities.equals(audioCapabilities2)) {
            return;
        }
        audioTrackAudioOutputProvider.audioCapabilities = audioCapabilities;
        ListenerSet listenerSet = audioTrackAudioOutputProvider.listeners;
        if (listenerSet != null) {
            listenerSet.sendEvent(-1, new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 6));
        }
    }

    public final void updateCurrentAudioCapabilities() {
        List spatializerChannelMasks = getSpatializerChannelMasks();
        AudioAttributes audioAttributes = this.audioAttributes;
        AudioDeviceInfo audioDeviceInfo = this.routedDevice;
        RegularImmutableList regularImmutableList = AudioCapabilities.DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS;
        IntentFilter intentFilter = new IntentFilter("android.media.action.HDMI_AUDIO_PLUG");
        Context context = this.context;
        onNewAudioCapabilities(AudioCapabilities.getCapabilitiesInternal(context, context.registerReceiver(null, intentFilter), audioAttributes, audioDeviceInfo, spatializerChannelMasks));
    }
}
