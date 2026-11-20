package com.metrolist.music.discord;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.text.StringsKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordPresence {
    public static final DiscordPresence INSTANCE = new DiscordPresence();
    public static KeyStore keyStore;

    public static ActivityPayload buildActivity$default(String str, ActivityType activityType, String str2, String str3, String str4, String str5, String str6, String str7, Long l, Long l2, List list, int i) {
        String str8 = (i & 32) != 0 ? null : str4;
        String str9 = (i & 64) != 0 ? null : str5;
        String str10 = (i & 128) != 0 ? null : str6;
        String str11 = (i & 256) != 0 ? null : str7;
        activityType.getClass();
        list.getClass();
        ActivityPayload activityPayload = new ActivityPayload(str, activityType.code, str2, str3, str8, str9, str10, str11, l, l2, list);
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.d(str, Integer.valueOf(activityType.code), StringsKt.take(40, str2), StringsKt.take(40, str3), Integer.valueOf(list.size()), Boolean.valueOf(str8 != null), Boolean.valueOf(str10 != null));
        return activityPayload;
    }

    public static String buildPresenceUpdate$default(PresenceStatus presenceStatus, List list) throws JSONException {
        Object obj = presenceStatus.wire;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("since", 0L);
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ActivityPayload activityPayload = (ActivityPayload) it.next();
            JSONObject jSONObject2 = new JSONObject();
            Object obj2 = activityPayload.name;
            List<Pair> list2 = activityPayload.buttons;
            String str = activityPayload.smallImage;
            String str2 = activityPayload.largeImage;
            Long l = activityPayload.endMs;
            Long l2 = activityPayload.startMs;
            jSONObject2.put(ContentDisposition.Parameters.Name, obj2);
            jSONObject2.put(LinkHeader.Parameters.Type, activityPayload.type);
            jSONObject2.put("details", activityPayload.details);
            jSONObject2.put("state", activityPayload.state);
            if (l2 != null || l != null) {
                JSONObject jSONObject3 = new JSONObject();
                if (l2 != null) {
                    jSONObject3.put("start", l2.longValue());
                }
                if (l != null) {
                    jSONObject3.put("end", l.longValue());
                }
                jSONObject2.put("timestamps", jSONObject3);
            }
            if (str2 != null || str != null) {
                JSONObject jSONObject4 = new JSONObject();
                if (str2 != null) {
                    jSONObject4.put("large_image", str2);
                }
                String str3 = activityPayload.largeText;
                if (str3 != null) {
                    jSONObject4.put("large_text", str3);
                }
                if (str != null) {
                    jSONObject4.put("small_image", str);
                }
                String str4 = activityPayload.smallText;
                if (str4 != null) {
                    jSONObject4.put("small_text", str4);
                }
                jSONObject2.put("assets", jSONObject4);
            }
            if (!list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (Pair pair : list2) {
                    String str5 = (String) pair.first;
                    String str6 = (String) pair.second;
                    jSONArray2.put(str5);
                    if (str6.length() > 0) {
                        jSONArray3.put(str6);
                    }
                }
                jSONObject2.put("buttons", jSONArray2);
                if (jSONArray3.length() > 0) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("button_urls", jSONArray3);
                    jSONObject2.put("metadata", jSONObject5);
                }
            }
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("activities", jSONArray);
        jSONObject.put("status", obj);
        jSONObject.put("afk", false);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("op", 3);
        jSONObject6.put("d", jSONObject);
        String string = jSONObject6.toString();
        string.getClass();
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.v(Integer.valueOf(list.size()), obj);
        return string;
    }

    public String decrypt(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        str.getClass();
        byte[] bArrDecode = Base64.decode(str, 2);
        if (bArrDecode.length < 12) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Encrypted data too short");
            return null;
        }
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArrDecode, 0, 12);
        byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bArrDecode, 12, bArrDecode.length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, getOrCreateKey(), new GCMParameterSpec(128, bArrCopyOfRange));
        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
        bArrDoFinal.getClass();
        Charset charset = StandardCharsets.UTF_8;
        charset.getClass();
        return new String(bArrDoFinal, charset);
    }

    public String encrypt(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        str.getClass();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, getOrCreateKey());
        byte[] iv = cipher.getIV();
        if (iv.length != 12) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(iv.length, "Unexpected IV size: "));
            return null;
        }
        Charset charset = StandardCharsets.UTF_8;
        charset.getClass();
        byte[] bytes = str.getBytes(charset);
        bytes.getClass();
        byte[] bArrDoFinal = cipher.doFinal(bytes);
        byte[] bArr = new byte[bArrDoFinal.length + 12];
        ArraysKt.copyInto(0, 0, 12, iv, bArr);
        ArraysKt.copyInto$default(bArrDoFinal, bArr, 12, 0, 0, 12);
        String strEncodeToString = Base64.encodeToString(bArr, 2);
        strEncodeToString.getClass();
        return strEncodeToString;
    }

    public SecretKey getOrCreateKey() throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStore2;
        synchronized (this) {
            keyStore2 = keyStore;
            if (keyStore2 == null) {
                keyStore2 = KeyStore.getInstance("AndroidKeyStore");
                keyStore2.load(null);
                keyStore = keyStore2;
            }
        }
        Key key = keyStore2.getKey("metrolist_discord_token_key", null);
        if (key != null) {
            return (SecretKey) key;
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder("metrolist_discord_token_key", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).setRandomizedEncryptionRequired(true).build();
        keyGenParameterSpecBuild.getClass();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(keyGenParameterSpecBuild);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        secretKeyGenerateKey.getClass();
        return secretKeyGenerateKey;
    }
}
