package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AlertController;
import androidx.core.view.DisplayCompat;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.mp4.Sniffer;
import coil3.util.UtilsKt;
import com.metrolist.music.playback.StreamUrlCache;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm {
    public static final FrameworkMediaDrm$$ExternalSyntheticLambda0 DEFAULT_PROVIDER = new FrameworkMediaDrm$$ExternalSyntheticLambda0(0);
    public final MediaDrm mediaDrm;
    public int referenceCount;
    public final UUID uuid;

    public FrameworkMediaDrm(UUID uuid) {
        uuid.getClass();
        UUID uuid2 = C.COMMON_PSSH_UUID;
        UtilsKt.checkArgument("Use C.CLEARKEY_UUID instead", !uuid2.equals(uuid));
        this.uuid = uuid;
        MediaDrm mediaDrm = new MediaDrm((Build.VERSION.SDK_INT >= 27 || !uuid.equals(C.CLEARKEY_UUID)) ? uuid : uuid2);
        this.mediaDrm = mediaDrm;
        this.referenceCount = 1;
        if (C.WIDEVINE_UUID.equals(uuid) && "ASUS_Z00AD".equals(Build.MODEL)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void closeSession(byte[] bArr) {
        this.mediaDrm.closeSession(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final FrameworkCryptoConfig createCryptoConfig(byte[] bArr) {
        int i = Build.VERSION.SDK_INT;
        UUID uuid = this.uuid;
        if (i < 27 && Objects.equals(uuid, C.CLEARKEY_UUID)) {
            uuid = C.COMMON_PSSH_UUID;
        }
        return new FrameworkCryptoConfig(uuid, bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final int getCryptoType() {
        return 2;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0092  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ab A[LOOP:2: B:27:0x008c->B:35:0x00ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f7  */
    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, List list, int i, HashMap map) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        int i2;
        DrmInitData.SchemeData schemeData;
        DrmInitData.SchemeData schemeData2;
        StreamUrlCache psshAtom;
        short s;
        byte[] bArr3;
        byte[] schemeSpecificData;
        StreamUrlCache psshAtom2;
        UUID uuid = this.uuid;
        DrmInitData.SchemeData schemeData3 = null;
        if (list != null) {
            if (!C.WIDEVINE_UUID.equals(uuid)) {
                schemeData = (DrmInitData.SchemeData) list.get(0);
            } else if (Build.VERSION.SDK_INT < 28 || list.size() <= 1) {
                i2 = 0;
                while (true) {
                    if (i2 < list.size()) {
                        schemeData = (DrmInitData.SchemeData) list.get(0);
                        break;
                    }
                    schemeData2 = (DrmInitData.SchemeData) list.get(i2);
                    byte[] bArr4 = schemeData2.data;
                    bArr4.getClass();
                    psshAtom = Sniffer.parsePsshAtom(bArr4);
                    if (psshAtom == null) {
                        s = -1;
                    } else {
                        s = psshAtom.maxEntries;
                    }
                    if (s == 1) {
                        schemeData = schemeData2;
                        break;
                    }
                    i2++;
                }
            } else {
                DrmInitData.SchemeData schemeData4 = (DrmInitData.SchemeData) list.get(0);
                int i3 = 0;
                int length = 0;
                while (true) {
                    if (i3 < list.size()) {
                        DrmInitData.SchemeData schemeData5 = (DrmInitData.SchemeData) list.get(i3);
                        byte[] bArr5 = schemeData5.data;
                        bArr5.getClass();
                        if (Objects.equals(schemeData5.mimeType, schemeData4.mimeType) && Objects.equals(schemeData5.licenseServerUrl, schemeData4.licenseServerUrl) && Sniffer.parsePsshAtom(bArr5) != null) {
                            length += bArr5.length;
                            i3++;
                        } else {
                            i2 = 0;
                            while (true) {
                                if (i2 < list.size()) {
                                    schemeData = (DrmInitData.SchemeData) list.get(0);
                                    break;
                                }
                                schemeData2 = (DrmInitData.SchemeData) list.get(i2);
                                byte[] bArr6 = schemeData2.data;
                                bArr6.getClass();
                                psshAtom = Sniffer.parsePsshAtom(bArr6);
                                if (psshAtom == null) {
                                    s = -1;
                                } else {
                                    s = psshAtom.maxEntries;
                                }
                                if (s == 1) {
                                    schemeData = schemeData2;
                                    break;
                                }
                                i2++;
                            }
                        }
                    } else {
                        byte[] bArr7 = new byte[length];
                        int i4 = 0;
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            byte[] bArr8 = ((DrmInitData.SchemeData) list.get(i5)).data;
                            bArr8.getClass();
                            int length2 = bArr8.length;
                            System.arraycopy(bArr8, 0, bArr7, i4, length2);
                            i4 += length2;
                        }
                        schemeData = new DrmInitData.SchemeData(schemeData4.uuid, schemeData4.licenseServerUrl, schemeData4.mimeType, bArr7);
                    }
                }
            }
            byte[] bArrBuildPsshAtom = schemeData.data;
            bArrBuildPsshAtom.getClass();
            UUID uuid2 = C.PLAYREADY_UUID;
            if (uuid2.equals(uuid)) {
                byte[] schemeSpecificData2 = Sniffer.parseSchemeSpecificData(uuid, bArrBuildPsshAtom);
                if (schemeSpecificData2 != null) {
                    bArrBuildPsshAtom = schemeSpecificData2;
                }
                ParsableByteArray parsableByteArray = new ParsableByteArray(bArrBuildPsshAtom);
                int littleEndianInt = parsableByteArray.readLittleEndianInt();
                short littleEndianShort = parsableByteArray.readLittleEndianShort();
                short littleEndianShort2 = parsableByteArray.readLittleEndianShort();
                if (littleEndianShort == 1 && littleEndianShort2 == 1) {
                    short littleEndianShort3 = parsableByteArray.readLittleEndianShort();
                    Charset charset = StandardCharsets.UTF_16LE;
                    String string = parsableByteArray.readString(littleEndianShort3, charset);
                    if (!string.contains("<LA_URL>")) {
                        int iIndexOf = string.indexOf("</DATA>");
                        if (iIndexOf == -1) {
                            Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                        }
                        String str2 = string.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + string.substring(iIndexOf);
                        int i6 = littleEndianInt + 52;
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i6);
                        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                        byteBufferAllocate.putInt(i6);
                        byteBufferAllocate.putShort(littleEndianShort);
                        byteBufferAllocate.putShort(littleEndianShort2);
                        byteBufferAllocate.putShort((short) (str2.length() * 2));
                        byteBufferAllocate.put(str2.getBytes(charset));
                        bArrBuildPsshAtom = byteBufferAllocate.array();
                    }
                } else {
                    Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                }
                bArrBuildPsshAtom = Sniffer.buildPsshAtom(uuid2, null, bArrBuildPsshAtom);
            }
            if (Build.VERSION.SDK_INT < 27 && Objects.equals(uuid, C.CLEARKEY_UUID) && (psshAtom2 = Sniffer.parsePsshAtom(bArrBuildPsshAtom)) != null) {
                bArrBuildPsshAtom = Sniffer.buildPsshAtom(C.COMMON_PSSH_UUID, (UUID[]) psshAtom2.generations, (byte[]) psshAtom2.entries);
            }
            if (uuid2.equals(uuid) && "Amazon".equals(Build.MANUFACTURER)) {
                String str3 = Build.MODEL;
                if (("AFTB".equals(str3) || "AFTS".equals(str3) || "AFTM".equals(str3) || "AFTT".equals(str3)) && (schemeSpecificData = Sniffer.parseSchemeSpecificData(uuid, bArrBuildPsshAtom)) != null) {
                    bArr3 = schemeSpecificData;
                } else {
                    bArr3 = bArrBuildPsshAtom;
                }
            } else {
                bArr3 = bArrBuildPsshAtom;
            }
            str = schemeData.mimeType;
            bArr2 = bArr3;
            schemeData3 = schemeData;
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm mediaDrm = this.mediaDrm;
        MediaDrm.KeyRequest keyRequest = mediaDrm.getKeyRequest(bArr, bArr2, str, i, map);
        byte[] data = keyRequest.getData();
        if (C.CLEARKEY_UUID.equals(uuid) && Build.VERSION.SDK_INT < 27) {
            data = Util.fromUtf8Bytes(data).replace('+', '-').replace('/', '_').getBytes(StandardCharsets.UTF_8);
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("<LA_URL>https://x</LA_URL>".equals(defaultUrl)) {
            defaultUrl = "";
        } else if (Build.VERSION.SDK_INT >= 33 && "https://default.url".equals(defaultUrl)) {
            String propertyString = mediaDrm.getPropertyString("version");
            if (Objects.equals(propertyString, "1.2") || Objects.equals(propertyString, "aidl-1")) {
                defaultUrl = "";
            }
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData3 != null) {
            String str4 = schemeData3.licenseServerUrl;
            if (!TextUtils.isEmpty(str4)) {
                defaultUrl = str4;
            }
        }
        keyRequest.getRequestType();
        return new ExoMediaDrm.KeyRequest(defaultUrl, data);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final byte[] openSession() {
        return this.mediaDrm.openSession();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        if (C.CLEARKEY_UUID.equals(this.uuid) && Build.VERSION.SDK_INT < 27) {
            try {
                JSONObject jSONObject = new JSONObject(Util.fromUtf8Bytes(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = sb.toString().getBytes(StandardCharsets.UTF_8);
            } catch (JSONException e) {
                Log.e("ClearKeyUtil", "Failed to adjust response data: ".concat(Util.fromUtf8Bytes(bArr2)), e);
            }
        }
        return this.mediaDrm.provideKeyResponse(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.mediaDrm.provideProvisionResponse(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final Map queryKeyStatus(byte[] bArr) {
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final synchronized void release() {
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        if (i == 0) {
            this.mediaDrm.release();
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final boolean requiresSecureDecoder(String str, byte[] bArr) throws Throwable {
        boolean zEquals;
        int i = Build.VERSION.SDK_INT;
        UUID uuid = this.uuid;
        if (i >= 31) {
            boolean zEquals2 = uuid.equals(C.WIDEVINE_UUID);
            MediaDrm mediaDrm = this.mediaDrm;
            if (zEquals2) {
                String propertyString = mediaDrm.getPropertyString("version");
                zEquals = (propertyString.startsWith("v5.") || propertyString.startsWith("14.") || propertyString.startsWith("15.") || propertyString.startsWith("16.0")) ? false : true;
            } else {
                zEquals = uuid.equals(C.CLEARKEY_UUID);
            }
            if (zEquals) {
                return DisplayCompat.requiresSecureDecoder(mediaDrm, str, mediaDrm.getSecurityLevel(bArr));
            }
        }
        MediaCrypto mediaCrypto = null;
        try {
            try {
                MediaCrypto mediaCrypto2 = new MediaCrypto((i >= 27 || !Objects.equals(uuid, C.CLEARKEY_UUID)) ? uuid : C.COMMON_PSSH_UUID, bArr);
                try {
                    boolean zRequiresSecureDecoderComponent = mediaCrypto2.requiresSecureDecoderComponent(str);
                    mediaCrypto2.release();
                    return zRequiresSecureDecoderComponent;
                } catch (MediaCryptoException unused) {
                    mediaCrypto = mediaCrypto2;
                    boolean z = !uuid.equals(C.CLEARKEY_UUID);
                    if (mediaCrypto != null) {
                        mediaCrypto.release();
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    mediaCrypto = mediaCrypto2;
                    if (mediaCrypto != null) {
                        mediaCrypto.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (MediaCryptoException unused2) {
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.mediaDrm.restoreKeys(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void setOnEventListener(final DefaultDrmSessionManager.MediaDrmEventListener mediaDrmEventListener) {
        this.mediaDrm.setOnEventListener(new MediaDrm.OnEventListener(this) { // from class: androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda1
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                AlertController.ButtonHandler buttonHandler = DefaultDrmSessionManager.this.mediaDrmHandler;
                buttonHandler.getClass();
                buttonHandler.obtainMessage(i, bArr).sendToTarget();
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public final void setPlayerIdForSession(byte[] bArr, PlayerId playerId) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                DisplayCompat.setLogSessionIdOnMediaDrmSession(this.mediaDrm, bArr, playerId);
            } catch (UnsupportedOperationException unused) {
                Log.w("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }
}
