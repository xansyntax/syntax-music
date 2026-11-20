package androidx.media3.common;

import android.os.Build;
import android.os.Bundle;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributes {
    public static final AudioAttributes DEFAULT = new AudioAttributes(0, 0, 1, 1, 0, false, true);
    public static final String FIELD_ALLOWED_CAPTURE_POLICY;
    public static final String FIELD_CONTENT_TYPE;
    public static final String FIELD_FLAGS;
    public static final String FIELD_HAPTIC_CHANNELS_MUTED;
    public static final String FIELD_IS_CONTENT_SPATIALIZED;
    public static final String FIELD_SPATIALIZATION_BEHAVIOR;
    public static final String FIELD_USAGE;
    public final int allowedCapturePolicy;
    public final int contentType;
    public final int flags;
    public final boolean hapticChannelsMuted;
    public final boolean isContentSpatialized;
    public android.media.AudioAttributes platformAudioAttributes;
    public final int spatializationBehavior;
    public final int usage;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api29 {
        public static void setAllowedCapturePolicy(android.media.AudioAttributes.Builder builder, int i) {
            builder.setAllowedCapturePolicy(i);
        }

        public static void setHapticChannelsMuted(android.media.AudioAttributes.Builder builder, boolean z) {
            builder.setHapticChannelsMuted(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api32 {
        public static void setIsContentSpatialized(android.media.AudioAttributes.Builder builder, boolean z) {
            builder.setIsContentSpatialized(z);
        }

        public static void setSpatializationBehavior(android.media.AudioAttributes.Builder builder, int i) {
            builder.setSpatializationBehavior(i);
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_CONTENT_TYPE = Integer.toString(0, 36);
        FIELD_FLAGS = Integer.toString(1, 36);
        FIELD_USAGE = Integer.toString(2, 36);
        FIELD_ALLOWED_CAPTURE_POLICY = Integer.toString(3, 36);
        FIELD_SPATIALIZATION_BEHAVIOR = Integer.toString(4, 36);
        FIELD_IS_CONTENT_SPATIALIZED = Integer.toString(5, 36);
        FIELD_HAPTIC_CHANNELS_MUTED = Integer.toString(6, 36);
    }

    public AudioAttributes(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        this.contentType = i;
        this.flags = i2;
        this.usage = i3;
        this.allowedCapturePolicy = i4;
        this.spatializationBehavior = i5;
        this.isContentSpatialized = z;
        this.hapticChannelsMuted = z2;
    }

    public static AudioAttributes fromBundle(Bundle bundle) {
        String str = FIELD_CONTENT_TYPE;
        int i = bundle.containsKey(str) ? bundle.getInt(str) : 0;
        String str2 = FIELD_FLAGS;
        int i2 = bundle.containsKey(str2) ? bundle.getInt(str2) : 0;
        String str3 = FIELD_USAGE;
        int i3 = bundle.containsKey(str3) ? bundle.getInt(str3) : 1;
        String str4 = FIELD_ALLOWED_CAPTURE_POLICY;
        int i4 = bundle.containsKey(str4) ? bundle.getInt(str4) : 1;
        String str5 = FIELD_SPATIALIZATION_BEHAVIOR;
        int i5 = bundle.containsKey(str5) ? bundle.getInt(str5) : 0;
        String str6 = FIELD_IS_CONTENT_SPATIALIZED;
        boolean z = bundle.containsKey(str6) ? bundle.getBoolean(str6) : false;
        String str7 = FIELD_HAPTIC_CHANNELS_MUTED;
        return new AudioAttributes(i, i2, i3, i4, i5, z, bundle.containsKey(str7) ? bundle.getBoolean(str7) : true);
    }

    public static AudioAttributes fromPlatformAudioAttributes(android.media.AudioAttributes audioAttributes) {
        int allowedCapturePolicy;
        boolean zAreHapticChannelsMuted;
        int i;
        boolean zIsContentSpatialized;
        int contentType = audioAttributes.getContentType();
        int flags = audioAttributes.getFlags();
        int usage = audioAttributes.getUsage();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            allowedCapturePolicy = audioAttributes.getAllowedCapturePolicy();
            zAreHapticChannelsMuted = audioAttributes.areHapticChannelsMuted();
        } else {
            allowedCapturePolicy = 1;
            zAreHapticChannelsMuted = true;
        }
        if (i2 >= 32) {
            int spatializationBehavior = audioAttributes.getSpatializationBehavior();
            zIsContentSpatialized = audioAttributes.isContentSpatialized();
            i = spatializationBehavior;
        } else {
            i = 0;
            zIsContentSpatialized = false;
        }
        return new AudioAttributes(contentType, flags, usage, allowedCapturePolicy, i, zIsContentSpatialized, zAreHapticChannelsMuted);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AudioAttributes.class == obj.getClass()) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage && this.allowedCapturePolicy == audioAttributes.allowedCapturePolicy && this.spatializationBehavior == audioAttributes.spatializationBehavior && this.isContentSpatialized == audioAttributes.isContentSpatialized && this.hapticChannelsMuted == audioAttributes.hapticChannelsMuted) {
                return true;
            }
        }
        return false;
    }

    public final android.media.AudioAttributes getPlatformAudioAttributes() {
        android.media.AudioAttributes audioAttributes = this.platformAudioAttributes;
        if (audioAttributes != null) {
            return audioAttributes;
        }
        android.media.AudioAttributes.Builder usage = new android.media.AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage);
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Api29.setAllowedCapturePolicy(usage, this.allowedCapturePolicy);
            Api29.setHapticChannelsMuted(usage, this.hapticChannelsMuted);
        }
        if (i >= 32) {
            Api32.setSpatializationBehavior(usage, this.spatializationBehavior);
            Api32.setIsContentSpatialized(usage, this.isContentSpatialized);
        }
        android.media.AudioAttributes audioAttributesBuild = usage.build();
        this.platformAudioAttributes = audioAttributesBuild;
        return audioAttributesBuild;
    }

    public final int hashCode() {
        return ((((((((((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage) * 31) + this.allowedCapturePolicy) * 31) + this.spatializationBehavior) * 31) + (this.isContentSpatialized ? 1 : 0)) * 31) + (this.hapticChannelsMuted ? 1 : 0);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        int i = this.contentType;
        if (i != 0) {
            bundle.putInt(FIELD_CONTENT_TYPE, i);
        }
        int i2 = this.flags;
        if (i2 != 0) {
            bundle.putInt(FIELD_FLAGS, i2);
        }
        int i3 = this.usage;
        if (i3 != 1) {
            bundle.putInt(FIELD_USAGE, i3);
        }
        int i4 = this.allowedCapturePolicy;
        if (i4 != 1) {
            bundle.putInt(FIELD_ALLOWED_CAPTURE_POLICY, i4);
        }
        int i5 = this.spatializationBehavior;
        if (i5 != 0) {
            bundle.putInt(FIELD_SPATIALIZATION_BEHAVIOR, i5);
        }
        boolean z = this.isContentSpatialized;
        if (z) {
            bundle.putBoolean(FIELD_IS_CONTENT_SPATIALIZED, z);
        }
        boolean z2 = this.hapticChannelsMuted;
        if (!z2) {
            bundle.putBoolean(FIELD_HAPTIC_CHANNELS_MUTED, z2);
        }
        return bundle;
    }
}
