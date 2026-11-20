package kotlin.text;

import android.os.Build;
import android.util.Base64;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.materialkolor.utils.MathUtils;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.discord.DiscordTokenStore;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.FilePathComponents;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import okhttp3.CacheControl;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal._ZlibJvmKt;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HexFormatKt {
    public static volatile String _base64;
    public static volatile JSONObject _superProperties;
    public static Thread mainThread;

    public static final HashMapSerializer MapSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        kSerializer.getClass();
        kSerializer2.getClass();
        return new HashMapSerializer(kSerializer, kSerializer2, (byte) 1);
    }

    public static final boolean arrayRangeEquals(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        bArr.getClass();
        bArr2.getClass();
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "size=", " offset=");
            sbM.append(j2);
            sbM.append(" byteCount=");
            sbM.append(j3);
            throw new ArrayIndexOutOfBoundsException(sbM.toString());
        }
    }

    public static double darker(double d, double d2) {
        if (d < 0.0d || d > 100.0d) {
            return -1.0d;
        }
        double dYFromLstar = MathUtils.yFromLstar(d);
        double d3 = ((dYFromLstar + 5.0d) / d2) - 5.0d;
        if (d3 < 0.0d || d3 > 100.0d) {
            return -1.0d;
        }
        double dRatioOfYs = ratioOfYs(dYFromLstar, d3);
        double dAbs = Math.abs(dRatioOfYs - d2);
        if (dRatioOfYs < d2 && dAbs > 0.04d) {
            return -1.0d;
        }
        double dLabF = ((MathUtils.labF(d3 / 100.0d) * 116.0d) - 16.0d) - 0.4d;
        if (dLabF < 0.0d || dLabF > 100.0d) {
            return -1.0d;
        }
        return dLabF;
    }

    public static final List filterExplicit(List list, boolean z) {
        list.getClass();
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((YTItem) obj).getExplicit()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List filterVideoSongs(List list, boolean z) {
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            YTItem yTItem = (YTItem) obj;
            if (!(yTItem instanceof SongItem) || !((SongItem) yTItem).isVideoSong()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List filterYoutubeShorts(List list, boolean z) {
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            YTItem yTItem = (YTItem) obj;
            if (!(yTItem instanceof PlaylistItem) || !StringsKt__StringsJVMKt.startsWith(((PlaylistItem) yTItem).id, "SS", false)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: getAxis-3MmeM6k, reason: not valid java name */
    public static final float m1881getAxis3MmeM6k(long j, Orientation orientation) {
        orientation.getClass();
        int iOrdinal = orientation.ordinal();
        if (iOrdinal == 0) {
            return Offset.m437getYimpl(j);
        }
        if (iOrdinal == 1) {
            return Offset.m436getXimpl(j);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public static String getBase64() throws JSONException {
        if (_base64 == null) {
            if (_superProperties == null) {
                DiscordTokenStore discordTokenStore = DiscordTokenStore.INSTANCE;
                String orCreateId = discordTokenStore.getOrCreateId("device_vendor_id", "device_vendor_id");
                if (orCreateId == null) {
                    orCreateId = UUID.randomUUID().toString();
                    orCreateId.getClass();
                }
                String orCreateId2 = discordTokenStore.getOrCreateId("client_uuid", "client_uuid");
                if (orCreateId2 == null) {
                    orCreateId2 = UUID.randomUUID().toString();
                    orCreateId2.getClass();
                }
                Timber.Forest.tag("DiscordSvc");
                String str = Build.DEVICE;
                String str2 = Build.VERSION.RELEASE;
                int i = Build.VERSION.SDK_INT;
                ConnectionPool.d(str, str2, Integer.valueOf(i), StringsKt.take(8, orCreateId));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("os", "Android");
                jSONObject.put("browser", "Discord Android");
                jSONObject.put("device", str);
                jSONObject.put("system_locale", Locale.getDefault().toString());
                jSONObject.put("client_version", "314.13 - Stable");
                jSONObject.put("release_channel", "googleRelease");
                jSONObject.put("device_vendor_id", orCreateId);
                jSONObject.put("client_uuid", orCreateId2);
                jSONObject.put("client_launch_id", UUID.randomUUID().toString());
                jSONObject.put("os_version", str2);
                jSONObject.put("os_sdk_version", String.valueOf(i));
                jSONObject.put("client_build_number", 314013);
                jSONObject.put("client_event_source", JSONObject.NULL);
                jSONObject.put("design_id", 0);
                _superProperties = jSONObject;
            }
            JSONObject jSONObject2 = _superProperties;
            jSONObject2.getClass();
            String string = jSONObject2.toString();
            string.getClass();
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            bytes.getClass();
            _base64 = Base64.encodeToString(bytes, 2);
            Timber.Forest.tag("DiscordSvc");
            String str3 = _base64;
            str3.getClass();
            ConnectionPool.d(Integer.valueOf(str3.length()));
        }
        String str4 = _base64;
        str4.getClass();
        return str4;
    }

    public static final KSerializer getNullable(KSerializer kSerializer) {
        kSerializer.getClass();
        return kSerializer.getDescriptor().isNullable() ? kSerializer : new NullableSerializer(kSerializer);
    }

    public static final int getRootLength$FilesKt__FilePathComponentsKt(String str) {
        int iIndexOf$default;
        char c = File.separatorChar;
        int iIndexOf$default2 = StringsKt.indexOf$default(str, c, 0, 4);
        if (iIndexOf$default2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c || (iIndexOf$default = StringsKt.indexOf$default(str, c, 2, 4)) < 0) {
                return 1;
            }
            int iIndexOf$default3 = StringsKt.indexOf$default(str, c, iIndexOf$default + 1, 4);
            return iIndexOf$default3 >= 0 ? iIndexOf$default3 + 1 : str.length();
        }
        if (iIndexOf$default2 > 0 && str.charAt(iIndexOf$default2 - 1) == ':') {
            return iIndexOf$default2 + 1;
        }
        if (iIndexOf$default2 == -1 && StringsKt.endsWith$default((CharSequence) str, ':')) {
            return str.length();
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0031  */
    public static boolean isCacheable(Response response, Request request) {
        request.getClass();
        int i = response.code;
        if (i != 200 && i != 410 && i != 414 && i != 501 && i != 203 && i != 204) {
            if (i == 307) {
                if (Response.header$default(HttpHeaders.Expires, response) == null && response.cacheControl().maxAgeSeconds == -1 && !response.cacheControl().isPublic && !response.cacheControl().isPrivate) {
                    return false;
                }
            } else if (i != 308 && i != 404 && i != 405) {
                switch (i) {
                    case 300:
                    case 301:
                        break;
                    case 302:
                        if (Response.header$default(HttpHeaders.Expires, response) == null) {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        if (response.cacheControl().noStore) {
            return false;
        }
        CacheControl cacheControl = request.lazyCacheControl;
        if (cacheControl == null) {
            int i2 = CacheControl.$r8$clinit;
            cacheControl = parse(request.headers);
            request.lazyCacheControl = cacheControl;
        }
        return !cacheControl.noStore;
    }

    public static final boolean isCaseSensitive(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 128 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public static double lighter(double d, double d2) {
        if (d < 0.0d || d > 100.0d) {
            return -1.0d;
        }
        double dYFromLstar = MathUtils.yFromLstar(d);
        double d3 = ((dYFromLstar + 5.0d) * d2) - 5.0d;
        if (d3 < 0.0d || d3 > 100.0d) {
            return -1.0d;
        }
        double dRatioOfYs = ratioOfYs(d3, dYFromLstar);
        double dAbs = Math.abs(dRatioOfYs - d2);
        if (dRatioOfYs < d2 && dAbs > 0.04d) {
            return -1.0d;
        }
        double dLabF = ((MathUtils.labF(d3 / 100.0d) * 116.0d) - 16.0d) + 0.4d;
        if (dLabF < 0.0d || dLabF > 100.0d) {
            return -1.0d;
        }
        return dLabF;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0067 A[EDGE_INSN: B:109:0x0067->B:22:0x0067 BREAK  A[LOOP:2: B:16:0x0049->B:20:0x005a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0044  */
    /* JADX WARN: Code duplicated, block: B:17:0x004b  */
    /* JADX WARN: Code duplicated, block: B:20:0x005a A[LOOP:2: B:16:0x0049->B:20:0x005a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x0102  */
    /* JADX WARN: Code duplicated, block: B:56:0x010b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0113  */
    /* JADX WARN: Code duplicated, block: B:59:0x0119  */
    /* JADX WARN: Code duplicated, block: B:61:0x0121  */
    /* JADX WARN: Code duplicated, block: B:63:0x012a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0133  */
    /* JADX WARN: Code duplicated, block: B:66:0x0138  */
    /* JADX WARN: Code duplicated, block: B:68:0x0140  */
    /* JADX WARN: Code duplicated, block: B:69:0x0146  */
    /* JADX WARN: Code duplicated, block: B:71:0x014e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0154  */
    /* JADX WARN: Code duplicated, block: B:74:0x015c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0162  */
    /* JADX WARN: Code duplicated, block: B:77:0x016a  */
    /* JADX WARN: Code duplicated, block: B:78:0x0172  */
    /* JADX WARN: Code duplicated, block: B:80:0x017a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0180  */
    /* JADX WARN: Code duplicated, block: B:83:0x0189  */
    /* JADX WARN: Code duplicated, block: B:84:0x0190  */
    /* JADX WARN: Code duplicated, block: B:86:0x0198  */
    /* JADX WARN: Code duplicated, block: B:87:0x019f  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a7  */
    public static CacheControl parse(Headers headers) {
        int i;
        int length;
        int length2;
        int i2;
        String string;
        String string2;
        Headers headers2 = headers;
        int size = headers2.size();
        int i3 = 0;
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int nonNegativeInt = -1;
        int nonNegativeInt2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int nonNegativeInt3 = -1;
        int nonNegativeInt4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i3 < size) {
            String strCommonName = EntryPoints.commonName(headers2, i3);
            String strCommonValue = EntryPoints.commonValue(headers2, i3);
            if (strCommonName.equalsIgnoreCase(HttpHeaders.CacheControl)) {
                if (str == null) {
                    str = strCommonValue;
                }
                i = 0;
                while (i < strCommonValue.length()) {
                    length = strCommonValue.length();
                    length2 = i;
                    while (true) {
                        if (length2 < length) {
                            i2 = size;
                            length2 = strCommonValue.length();
                            break;
                        }
                        i2 = size;
                        if (StringsKt.contains$default("=,;", strCommonValue.charAt(length2))) {
                            break;
                        }
                        length2++;
                        size = i2;
                    }
                    string = StringsKt.trim(strCommonValue.substring(i, length2)).toString();
                    if (length2 != strCommonValue.length() || strCommonValue.charAt(length2) == ',' || strCommonValue.charAt(length2) == ';') {
                        i = length2 + 1;
                        string2 = null;
                    } else {
                        int length3 = length2 + 1;
                        byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                        int length4 = strCommonValue.length();
                        while (true) {
                            if (length3 < length4) {
                                char cCharAt = strCommonValue.charAt(length3);
                                if (cCharAt != ' ' && cCharAt != '\t') {
                                    break;
                                }
                                length3++;
                            } else {
                                length3 = strCommonValue.length();
                                break;
                            }
                        }
                        if (length3 >= strCommonValue.length() || strCommonValue.charAt(length3) != '\"') {
                            int length5 = strCommonValue.length();
                            int length6 = length3;
                            while (true) {
                                if (length6 >= length5) {
                                    length6 = strCommonValue.length();
                                    break;
                                }
                                int i4 = length5;
                                if (StringsKt.contains$default(",;", strCommonValue.charAt(length6))) {
                                    break;
                                }
                                length6++;
                                length5 = i4;
                            }
                            int i5 = length6;
                            string2 = StringsKt.trim(strCommonValue.substring(length3, length6)).toString();
                            i = i5;
                        } else {
                            int i6 = length3 + 1;
                            int iIndexOf$default = StringsKt.indexOf$default(strCommonValue, '\"', i6, 4);
                            string2 = strCommonValue.substring(i6, iIndexOf$default);
                            i = iIndexOf$default + 1;
                        }
                    }
                    if (io.ktor.client.utils.CacheControl.NO_CACHE.equalsIgnoreCase(string)) {
                        z2 = true;
                    } else if (io.ktor.client.utils.CacheControl.NO_STORE.equalsIgnoreCase(string)) {
                        z3 = true;
                    } else if (io.ktor.client.utils.CacheControl.MAX_AGE.equalsIgnoreCase(string)) {
                        nonNegativeInt = _UtilCommonKt.toNonNegativeInt(-1, string2);
                    } else if (io.ktor.client.utils.CacheControl.S_MAX_AGE.equalsIgnoreCase(string)) {
                        nonNegativeInt2 = _UtilCommonKt.toNonNegativeInt(-1, string2);
                    } else if (io.ktor.client.utils.CacheControl.PRIVATE.equalsIgnoreCase(string)) {
                        z4 = true;
                    } else if (io.ktor.client.utils.CacheControl.PUBLIC.equalsIgnoreCase(string)) {
                        z5 = true;
                    } else if (io.ktor.client.utils.CacheControl.MUST_REVALIDATE.equalsIgnoreCase(string)) {
                        z6 = true;
                    } else if (io.ktor.client.utils.CacheControl.MAX_STALE.equalsIgnoreCase(string)) {
                        nonNegativeInt3 = _UtilCommonKt.toNonNegativeInt(Integer.MAX_VALUE, string2);
                    } else if (io.ktor.client.utils.CacheControl.MIN_FRESH.equalsIgnoreCase(string)) {
                        nonNegativeInt4 = _UtilCommonKt.toNonNegativeInt(-1, string2);
                    } else if (io.ktor.client.utils.CacheControl.ONLY_IF_CACHED.equalsIgnoreCase(string)) {
                        z7 = true;
                    } else if (io.ktor.client.utils.CacheControl.NO_TRANSFORM.equalsIgnoreCase(string)) {
                        z8 = true;
                    } else if ("immutable".equalsIgnoreCase(string)) {
                        z9 = true;
                    }
                    size = i2;
                }
                i3++;
                headers2 = headers;
                size = size;
            } else {
                if (strCommonName.equalsIgnoreCase(HttpHeaders.Pragma)) {
                }
                i3++;
                headers2 = headers;
                size = size;
            }
            z = false;
            i = 0;
            while (i < strCommonValue.length()) {
                length = strCommonValue.length();
                length2 = i;
                while (true) {
                    if (length2 < length) {
                        i2 = size;
                        length2 = strCommonValue.length();
                        break;
                    }
                    i2 = size;
                    if (StringsKt.contains$default("=,;", strCommonValue.charAt(length2))) {
                        break;
                        break;
                    }
                    length2++;
                    size = i2;
                }
                string = StringsKt.trim(strCommonValue.substring(i, length2)).toString();
                if (length2 != strCommonValue.length()) {
                    i = length2 + 1;
                    string2 = null;
                } else {
                    i = length2 + 1;
                    string2 = null;
                }
                if (io.ktor.client.utils.CacheControl.NO_CACHE.equalsIgnoreCase(string)) {
                    z2 = true;
                } else if (io.ktor.client.utils.CacheControl.NO_STORE.equalsIgnoreCase(string)) {
                    z3 = true;
                } else if (io.ktor.client.utils.CacheControl.MAX_AGE.equalsIgnoreCase(string)) {
                    nonNegativeInt = _UtilCommonKt.toNonNegativeInt(-1, string2);
                } else if (io.ktor.client.utils.CacheControl.S_MAX_AGE.equalsIgnoreCase(string)) {
                    nonNegativeInt2 = _UtilCommonKt.toNonNegativeInt(-1, string2);
                } else if (io.ktor.client.utils.CacheControl.PRIVATE.equalsIgnoreCase(string)) {
                    z4 = true;
                } else if (io.ktor.client.utils.CacheControl.PUBLIC.equalsIgnoreCase(string)) {
                    z5 = true;
                } else if (io.ktor.client.utils.CacheControl.MUST_REVALIDATE.equalsIgnoreCase(string)) {
                    z6 = true;
                } else if (io.ktor.client.utils.CacheControl.MAX_STALE.equalsIgnoreCase(string)) {
                    nonNegativeInt3 = _UtilCommonKt.toNonNegativeInt(Integer.MAX_VALUE, string2);
                } else if (io.ktor.client.utils.CacheControl.MIN_FRESH.equalsIgnoreCase(string)) {
                    nonNegativeInt4 = _UtilCommonKt.toNonNegativeInt(-1, string2);
                } else if (io.ktor.client.utils.CacheControl.ONLY_IF_CACHED.equalsIgnoreCase(string)) {
                    z7 = true;
                } else if (io.ktor.client.utils.CacheControl.NO_TRANSFORM.equalsIgnoreCase(string)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(string)) {
                    z9 = true;
                }
                size = i2;
            }
            i3++;
            headers2 = headers;
            size = size;
        }
        return new CacheControl(z2, z3, nonNegativeInt, nonNegativeInt2, z4, z5, z6, nonNegativeInt3, nonNegativeInt4, z7, z8, z9, !z ? null : str);
    }

    public static ProducerCoroutine produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(AwaitKt.newCoroutineContext(coroutineScope, coroutineContext), EntryPoints.Channel$default(0, 4, BufferOverflow.SUSPEND));
        producerCoroutine.start(CoroutineStart.DEFAULT, producerCoroutine, function2);
        return producerCoroutine;
    }

    public static double ratioOfTones(double d, double d2) {
        return ratioOfYs(MathUtils.yFromLstar(d), MathUtils.yFromLstar(d2));
    }

    public static double ratioOfYs(double d, double d2) {
        double dMax = Math.max(d, d2);
        if (dMax != d2) {
            d = d2;
        }
        return (dMax + 5.0d) / (d + 5.0d);
    }

    public static final void resetRange(Object[] objArr, int i, int i2) {
        objArr.getClass();
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }

    public static final String sanitizeCookieString(String str) throws IOException {
        str.getClass();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\r' && cCharAt != '\n' && cCharAt != '\t') {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        for (int i2 = 0; i2 < string.length(); i2++) {
            if (Character.isISOControl(string.charAt(i2))) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cookie must not contain control characters");
                return null;
            }
        }
        String string2 = StringsKt.trim(string).toString();
        if (StringsKt__StringsJVMKt.startsWith(string2, "Cookie:", true)) {
            string2 = string2.substring(7);
        }
        return StringsKt.trim(string2).toString();
    }

    public static final String sanitizeVisitorData(String str) throws IOException {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!CharsKt.isWhitespace(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            if (string.length() > 0) {
                for (int i2 = 0; i2 < string.length(); i2++) {
                    char cCharAt2 = string.charAt(i2);
                    if ('!' <= cCharAt2 && cCharAt2 < 127) {
                    }
                }
                return string;
            }
        }
        return null;
    }

    public static final String subarrayContentToString(Object[] objArr, int i, int i2, AbstractMutableList abstractMutableList) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i3];
            if (obj == abstractMutableList) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static final FilePathComponents toComponents(File file) {
        List list;
        String path = file.getPath();
        path.getClass();
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path);
        String strSubstring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
        String strSubstring2 = path.substring(rootLength$FilesKt__FilePathComponentsKt);
        if (strSubstring2.length() == 0) {
            list = EmptyList.INSTANCE;
        } else {
            List listSplit$default = StringsKt.split$default(strSubstring2, new char[]{File.separatorChar});
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(strSubstring), list);
    }

    public static final String toHexString(int i) {
        if (i == 0) {
            return "0";
        }
        char[] cArr = _ZlibJvmKt.HEX_DIGIT_CHARS;
        int i2 = 0;
        char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
        while (i2 < 8 && cArr2[i2] == '0') {
            i2++;
        }
        return StringsKt__StringsJVMKt.concatToString(cArr2, i2, 8);
    }

    public static final MediaMetadata toMediaMetadata(Song song) {
        MediaMetadata.Album album;
        song.getClass();
        SongEntity songEntity = song.song;
        String str = songEntity.id;
        String str2 = songEntity.title;
        List<ArtistEntity> orderedArtists = song.getOrderedArtists();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(orderedArtists, 10));
        for (ArtistEntity artistEntity : orderedArtists) {
            String str3 = artistEntity.id;
            ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
            arrayList.add(new MediaMetadata.Artist(str3, ArtistNameAliases.resolve(str3, artistEntity.name)));
        }
        int i = songEntity.duration;
        String str4 = songEntity.thumbnailUrl;
        AlbumEntity albumEntity = song.album;
        if (albumEntity != null) {
            album = new MediaMetadata.Album(albumEntity.id, albumEntity.title);
        } else {
            String str5 = songEntity.albumId;
            if (str5 != null) {
                String str6 = songEntity.albumName;
                if (str6 == null) {
                    str6 = "";
                }
                album = new MediaMetadata.Album(str5, str6);
            } else {
                album = null;
            }
        }
        return new MediaMetadata(str, str2, arrayList, i, str4, album, null, songEntity.isVideo ? "MUSIC_VIDEO_TYPE_OMV" : null, songEntity.explicit, null, null, null, songEntity.isEpisode, null, 81472);
    }

    public static final String toHexString(byte b) {
        char[] cArr = _ZlibJvmKt.HEX_DIGIT_CHARS;
        return new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]});
    }

    public static final MediaMetadata toMediaMetadata(SongItem songItem) {
        songItem.getClass();
        String str = songItem.id;
        String str2 = songItem.title;
        List<Artist> list = songItem.artists;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Artist artist : list) {
            String str3 = artist.id;
            ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
            arrayList.add(new MediaMetadata.Artist(str3, ArtistNameAliases.resolve(str3, artist.name)));
        }
        Integer num = songItem.duration;
        int iIntValue = num != null ? num.intValue() : -1;
        String strResize = YouTubeUtilsKt.resize(songItem.thumbnail, 1080, 1080);
        Album album = songItem.album;
        return new MediaMetadata(str, str2, arrayList, iIntValue, strResize, album != null ? new MediaMetadata.Album(album.id, album.name) : null, songItem.setVideoId, songItem.musicVideoType, songItem.explicit, songItem.libraryAddToken, songItem.libraryRemoveToken, null, songItem.isEpisode, songItem.uploadEntityId, 3584);
    }

    public static final MediaMetadata toMediaMetadata(EpisodeItem episodeItem) {
        episodeItem.getClass();
        String str = episodeItem.id;
        String str2 = episodeItem.title;
        List<Artist> listListOfNotNull = CollectionsKt__IterablesKt.listOfNotNull(episodeItem.author);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOfNotNull, 10));
        for (Artist artist : listListOfNotNull) {
            String str3 = artist.id;
            ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
            arrayList.add(new MediaMetadata.Artist(str3, ArtistNameAliases.resolve(str3, artist.name)));
        }
        Integer num = episodeItem.duration;
        int iIntValue = num != null ? num.intValue() : -1;
        String strResize = YouTubeUtilsKt.resize(episodeItem.thumbnail, 1080, 1080);
        Album album = episodeItem.podcast;
        return new MediaMetadata(str, str2, arrayList, iIntValue, strResize, album != null ? new MediaMetadata.Album(album.id, album.name) : null, null, null, episodeItem.explicit, episodeItem.libraryAddToken, episodeItem.libraryRemoveToken, null, true, null, 69312);
    }
}
