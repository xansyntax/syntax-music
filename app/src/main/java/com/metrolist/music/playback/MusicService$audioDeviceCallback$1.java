package com.metrolist.music.playback;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.utils.UtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$audioDeviceCallback$1 extends AudioDeviceCallback {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ MusicService$audioDeviceCallback$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        byte b = this.$r8$classId;
        Object obj = this.this$0;
        switch (b) {
            case 0:
                MusicService musicService = (MusicService) obj;
                super.onAudioDevicesAdded(audioDeviceInfoArr);
                if (audioDeviceInfoArr != null) {
                    for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                        if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                            if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.ResumeOnBluetoothConnectKey, Boolean.FALSE)).booleanValue() && musicService.player.getPlaybackState() == 3 && !musicService.player.isPlaying()) {
                                musicService.player.setPlayWhenReady(true);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                ((AudioCapabilitiesReceiver) obj).updateCurrentAudioCapabilities();
                break;
        }
    }

    @Override // android.media.AudioDeviceCallback
    public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        switch (this.$r8$classId) {
            case 1:
                AudioCapabilitiesReceiver audioCapabilitiesReceiver = (AudioCapabilitiesReceiver) this.this$0;
                AudioDeviceInfo audioDeviceInfo = audioCapabilitiesReceiver.routedDevice;
                String str = Util.DEVICE_DEBUG_INFO;
                for (AudioDeviceInfo audioDeviceInfo2 : audioDeviceInfoArr) {
                    if (Objects.equals(audioDeviceInfo2, audioDeviceInfo)) {
                        audioCapabilitiesReceiver.routedDevice = null;
                        audioCapabilitiesReceiver.updateCurrentAudioCapabilities();
                    }
                    break;
                }
                audioCapabilitiesReceiver.updateCurrentAudioCapabilities();
                break;
            default:
                super.onAudioDevicesRemoved(audioDeviceInfoArr);
                break;
        }
    }
}
