package androidx.media3.exoplayer.drm;

import android.os.Build;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkCryptoConfig {
    public static final boolean WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC;
    public final byte[] sessionId;
    public final UUID uuid;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z;
        if ("Amazon".equals(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = z;
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr) {
        this.uuid = uuid;
        this.sessionId = bArr;
    }
}
