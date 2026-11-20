package androidx.media3.exoplayer.audio;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import androidx.tracing.TraceApi29Impl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioCapabilities {
    public static final ImmutableMap ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS;
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES;
    public static final RegularImmutableList DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS;
    public static final RegularImmutableList EXTERNAL_SURROUND_SOUND_ENCODINGS;
    public final SparseArray encodingToAudioProfile = new SparseArray();
    public final int maxChannelCount;
    public final ImmutableList spatializerChannelMasks;
    public final ImmutableList speakerLayoutChannelMasks;

    static {
        RegularImmutableList regularImmutableListOf = ImmutableList.of((Object) 12);
        DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS = regularImmutableListOf;
        DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(ImmutableList.of((Object) AudioProfile.DEFAULT_AUDIO_PROFILE), regularImmutableListOf, RegularImmutableList.EMPTY);
        Object[] objArr = {2, 5, 6};
        Maps.checkElementsNotNull(3, objArr);
        EXTERNAL_SURROUND_SOUND_ENCODINGS = ImmutableList.asImmutableList(3, objArr);
        StatusLine statusLine = new StatusLine(4);
        statusLine.put(5, 6);
        statusLine.put(17, 6);
        statusLine.put(7, 6);
        statusLine.put(30, 10);
        statusLine.put(18, 6);
        statusLine.put(6, 8);
        statusLine.put(8, 8);
        statusLine.put(14, 8);
        ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS = statusLine.build(true);
    }

    public AudioCapabilities(RegularImmutableList regularImmutableList, List list, List list2) {
        for (int i = 0; i < regularImmutableList.size; i++) {
            AudioProfile audioProfile = (AudioProfile) regularImmutableList.get(i);
            this.encodingToAudioProfile.put(audioProfile.encoding, audioProfile);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.encodingToAudioProfile.size(); i2++) {
            iMax = Math.max(iMax, ((AudioProfile) this.encodingToAudioProfile.valueAt(i2)).maxChannelCount);
        }
        this.maxChannelCount = iMax;
        this.speakerLayoutChannelMasks = ImmutableList.copyOf((Collection) list);
        this.spatializerChannelMasks = ImmutableList.copyOf((Collection) list2);
    }

    public static RegularImmutableList getAudioProfiles(int i, int[] iArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i2 : iArr) {
            builder.add((Object) new AudioProfile(i2, i));
        }
        return builder.build();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d2  */
    public static AudioCapabilities getCapabilitiesInternal(Context context, Intent intent, AudioAttributes audioAttributes, AudioDeviceInfo audioDeviceInfo, List list) {
        AudioManager audioManager = HandlerCompat$Api28Impl.getAudioManager(context);
        if (audioDeviceInfo == null) {
            audioDeviceInfo = Build.VERSION.SDK_INT >= 33 ? BundleCompat$Api33Impl.getDefaultRoutedDeviceForAttributes(audioManager, audioAttributes) : null;
        }
        ImmutableList loudspeakerLayoutChannelMasks = audioDeviceInfo != null ? SpeakerLayoutUtil.getLoudspeakerLayoutChannelMasks(audioDeviceInfo) : DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS;
        if (Build.VERSION.SDK_INT >= 33 && (Util.isTv(context) || context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"))) {
            return BundleCompat$Api33Impl.getCapabilitiesInternalForDirectPlayback(audioManager, audioAttributes, loudspeakerLayoutChannelMasks, list);
        }
        for (AudioDeviceInfo audioDeviceInfo2 : audioDeviceInfo == null ? audioManager.getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfo}) {
            if (IntMath.isBluetoothDevice(audioDeviceInfo2.getType())) {
                return new AudioCapabilities(ImmutableList.of((Object) AudioProfile.DEFAULT_AUDIO_PROFILE), loudspeakerLayoutChannelMasks, list);
            }
        }
        ImmutableSet.Builder builder = new ImmutableSet.Builder(4);
        builder.add((Object) 2);
        if (Build.VERSION.SDK_INT >= 29 && (Util.isTv(context) || context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"))) {
            RegularImmutableList directPlaybackSupportedEncodings = TraceApi29Impl.getDirectPlaybackSupportedEncodings(audioAttributes);
            directPlaybackSupportedEncodings.getClass();
            builder.addAll(directPlaybackSupportedEncodings);
            return new AudioCapabilities(getAudioProfiles(10, StringsKt__IndentKt.toArray(builder.build())), loudspeakerLayoutChannelMasks, list);
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if (!z) {
            String str = Build.MANUFACTURER;
            if (str.equals("Amazon") || str.equals("Xiaomi")) {
                if (Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
                    RegularImmutableList regularImmutableList = EXTERNAL_SURROUND_SOUND_ENCODINGS;
                    regularImmutableList.getClass();
                    builder.addAll(regularImmutableList);
                }
            }
        } else if (Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            RegularImmutableList regularImmutableList2 = EXTERNAL_SURROUND_SOUND_ENCODINGS;
            regularImmutableList2.getClass();
            builder.addAll(regularImmutableList2);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new AudioCapabilities(getAudioProfiles(10, StringsKt__IndentKt.toArray(builder.build())), loudspeakerLayoutChannelMasks, list);
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            List listAsList = StringsKt__IndentKt.asList(intArrayExtra);
            listAsList.getClass();
            builder.addAll(listAsList);
        }
        return new AudioCapabilities(getAudioProfiles(intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10), StringsKt__IndentKt.toArray(builder.build())), loudspeakerLayoutChannelMasks, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        return Util.contentEquals(this.encodingToAudioProfile, audioCapabilities.encodingToAudioProfile) && this.maxChannelCount == audioCapabilities.maxChannelCount && Objects.equals(this.speakerLayoutChannelMasks, audioCapabilities.speakerLayoutChannelMasks) && Objects.equals(this.spatializerChannelMasks, audioCapabilities.spatializerChannelMasks);
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00cd  */
    public final Pair getEncodingAndChannelConfigForPassthrough(AudioAttributes audioAttributes, Format format) {
        String str = format.sampleMimeType;
        str.getClass();
        int encoding = MimeTypes.getEncoding(str, format.codecs);
        Integer numValueOf = Integer.valueOf(encoding);
        ImmutableMap immutableMap = ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS;
        if (!immutableMap.containsKey(numValueOf)) {
            return null;
        }
        int i = 6;
        SparseArray sparseArray = this.encodingToAudioProfile;
        if (encoding == 18 && !Util.contains(sparseArray, 18)) {
            encoding = 6;
        } else if ((encoding == 8 && !Util.contains(sparseArray, 8)) || (encoding == 30 && !Util.contains(sparseArray, 30))) {
            encoding = 7;
        }
        if (!Util.contains(sparseArray, encoding)) {
            return null;
        }
        AudioProfile audioProfile = (AudioProfile) sparseArray.get(encoding);
        audioProfile.getClass();
        int iIntValue = audioProfile.maxChannelCount;
        ImmutableSet immutableSet = audioProfile.channelMasks;
        int i2 = format.channelCount;
        boolean zContains = false;
        if (i2 == -1 || encoding == 18) {
            int i3 = format.sampleRate;
            if (i3 == -1) {
                i3 = 48000;
            }
            int i4 = audioProfile.encoding;
            if (immutableSet == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    iIntValue = TraceApi29Impl.getMaxSupportedChannelCountForPassthrough(i4, i3, audioAttributes);
                } else {
                    Object obj = immutableMap.get(Integer.valueOf(i4));
                    iIntValue = ((Integer) (obj != null ? obj : 0)).intValue();
                }
            }
            i2 = iIntValue;
        } else if (!format.sampleMimeType.equals("audio/vnd.dts.uhd;profile=p2") || Build.VERSION.SDK_INT >= 33) {
            if (immutableSet != null) {
                int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i2);
                if (audioTrackChannelConfig != 0) {
                    zContains = immutableSet.contains(Integer.valueOf(audioTrackChannelConfig));
                }
            } else if (i2 <= iIntValue) {
                zContains = true;
            }
            if (!zContains) {
                return null;
            }
        } else if (i2 > 10) {
            return null;
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 28) {
            i = i2;
        } else if (i2 == 7) {
            i = 8;
        } else if (i2 != 3 && i2 != 4 && i2 != 5) {
            i = i2;
        }
        if (i5 <= 26 && "fugu".equals(Build.DEVICE) && i == 1) {
            i = 2;
        }
        int audioTrackChannelConfig2 = Util.getAudioTrackChannelConfig(i);
        if (audioTrackChannelConfig2 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(encoding), Integer.valueOf(audioTrackChannelConfig2));
    }

    public final int hashCode() {
        return Objects.hashCode(this.spatializerChannelMasks) + ((Objects.hashCode(this.speakerLayoutChannelMasks) + ((Util.contentHashCode(this.encodingToAudioProfile) + (this.maxChannelCount * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", audioProfiles=" + this.encodingToAudioProfile + ", speakerLayoutChannelMasks=" + this.speakerLayoutChannelMasks + ", spatializerChannelMasks=" + this.spatializerChannelMasks + "]";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AudioProfile {
        public static final AudioProfile DEFAULT_AUDIO_PROFILE;
        public final ImmutableSet channelMasks;
        public final int encoding;
        public final int maxChannelCount;

        static {
            AudioProfile audioProfile;
            if (Build.VERSION.SDK_INT >= 33) {
                ImmutableSet.Builder builder = new ImmutableSet.Builder(4);
                for (int i = 1; i <= 10; i++) {
                    builder.add((Object) Integer.valueOf(Util.getAudioTrackChannelConfig(i)));
                }
                audioProfile = new AudioProfile(builder.build(), 2);
            } else {
                audioProfile = new AudioProfile(2, 10);
            }
            DEFAULT_AUDIO_PROFILE = audioProfile;
        }

        public AudioProfile(Set set, int i) {
            this.encoding = i;
            ImmutableSet immutableSetCopyOf = ImmutableSet.copyOf((Collection) set);
            this.channelMasks = immutableSetCopyOf;
            UnmodifiableIterator it = immutableSetCopyOf.iterator();
            int iMax = 0;
            while (it.hasNext()) {
                iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
            }
            this.maxChannelCount = iMax;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioProfile)) {
                return false;
            }
            AudioProfile audioProfile = (AudioProfile) obj;
            return this.encoding == audioProfile.encoding && this.maxChannelCount == audioProfile.maxChannelCount && Objects.equals(this.channelMasks, audioProfile.channelMasks);
        }

        public final int hashCode() {
            int i = ((this.encoding * 31) + this.maxChannelCount) * 31;
            ImmutableSet immutableSet = this.channelMasks;
            return i + (immutableSet == null ? 0 : immutableSet.hashCode());
        }

        public final String toString() {
            return "AudioProfile[format=" + this.encoding + ", maxChannelCount=" + this.maxChannelCount + ", channelMasks=" + this.channelMasks + "]";
        }

        public AudioProfile(int i, int i2) {
            this.encoding = i;
            this.maxChannelCount = i2;
            this.channelMasks = null;
        }
    }
}
