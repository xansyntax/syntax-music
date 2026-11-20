package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.analytics.PlayerId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ExoMediaDrm {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeyRequest {
        public final byte[] data;
        public final String licenseServerUrl;

        public KeyRequest(String str, byte[] bArr) {
            this.data = bArr;
            this.licenseServerUrl = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ProvisionRequest {
        public final byte[] data;
        public final String defaultUrl;

        public ProvisionRequest(String str, byte[] bArr) {
            this.data = bArr;
            this.defaultUrl = str;
        }
    }

    void closeSession(byte[] bArr);

    FrameworkCryptoConfig createCryptoConfig(byte[] bArr);

    int getCryptoType();

    KeyRequest getKeyRequest(byte[] bArr, List list, int i, HashMap map);

    ProvisionRequest getProvisionRequest();

    byte[] openSession();

    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2);

    void provideProvisionResponse(byte[] bArr);

    Map queryKeyStatus(byte[] bArr);

    void release();

    boolean requiresSecureDecoder(String str, byte[] bArr);

    void restoreKeys(byte[] bArr, byte[] bArr2);

    void setOnEventListener(DefaultDrmSessionManager.MediaDrmEventListener mediaDrmEventListener);

    default void setPlayerIdForSession(byte[] bArr, PlayerId playerId) {
    }
}
