package androidx.media3.exoplayer.audio;

import android.os.Build;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IamfUtil {
    public static final ImmutableSet IAMF_SUPPORTED_CHANNEL_MASKS;

    static {
        IAMF_SUPPORTED_CHANNEL_MASKS = Build.VERSION.SDK_INT < 32 ? ImmutableSet.construct(4, 12, 252, 6396, 4) : ImmutableSet.of((Object) 12, (Object) 252, (Object) 6396, (Object) 4, (Object) 3145980, (Object) 82172, (Object[]) new Integer[]{737532, 9126140, 33904892, 202070268, 744444, 67108860, 743676, 3152124, 88316, 81980, 205215996, 3890172});
    }
}
