package com.metrolist.innertubex.sabr;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.IllegalSeekPositionException;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.util.Locale;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SabrBootstrapFactoryKt {
    public static final byte[] decodeBase64Url(int i, String str, String str2) {
        CharSequence charSequenceSubSequence;
        Object failure;
        if (str.length() > ((i + 2) / 3) * 4) {
            throw new IllegalSeekPositionException(IntIntPair$$ExternalSyntheticOutline0.m("Player response ", str2, " exceeded the size limit"));
        }
        String strReplace = str.replace('-', '+');
        strReplace.getClass();
        String strReplace2 = strReplace.replace('_', '/');
        strReplace2.getClass();
        int length = ((4 - (strReplace2.length() % 4)) % 4) + strReplace2.length();
        if (length < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(length, "Desired length ", " is less than zero."));
            return null;
        }
        if (length <= strReplace2.length()) {
            charSequenceSubSequence = strReplace2.subSequence(0, strReplace2.length());
        } else {
            StringBuilder sb = new StringBuilder(length);
            sb.append((CharSequence) strReplace2);
            int length2 = length - strReplace2.length();
            int i2 = 1;
            if (1 <= length2) {
                while (true) {
                    sb.append('=');
                    if (i2 == length2) {
                        break;
                    }
                    i2++;
                }
            }
            charSequenceSubSequence = sb;
        }
        try {
            failure = Base64.decode$default(Base64.Default, charSequenceSubSequence.toString(), 0, 6);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            throw new IllegalSeekPositionException("Player response has an invalid ".concat(str2));
        }
        byte[] bArr = (byte[]) failure;
        if (bArr.length <= i) {
            return bArr;
        }
        throw new IllegalSeekPositionException(IntIntPair$$ExternalSyntheticOutline0.m("Player response ", str2, " exceeded the size limit"));
    }

    public static final void requireAllowedSabrUrl(String str) {
        Object failure;
        try {
            failure = URLUtilsKt.Url(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            throw new IllegalSeekPositionException("Invalid SABR streaming URL");
        }
        Url url = (Url) failure;
        String lowerCase = url.getHost().toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        if (!Intrinsics.areEqual(url.getProtocol(), URLProtocol.INSTANCE.getHTTPS()) || url.getPort() != 443 || ((!lowerCase.equals("googlevideo.com") && !StringsKt__StringsJVMKt.endsWith(lowerCase, ".googlevideo.com", false)) || !Intrinsics.areEqual(url.getEncodedPath(), "/videoplayback") || url.getUser() != null || url.getPassword() != null)) {
            throw new IllegalSeekPositionException("SABR streaming URL is not an HTTPS googlevideo endpoint");
        }
    }

    public static final String sabrRequestOrigin(String str) {
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode == -1391556002) {
            if (str.equals("WEB_REMIX")) {
                return "https://music.youtube.com";
            }
            return null;
        }
        if (iHashCode == 85812) {
            if (str.equals("WEB")) {
                return "https://www.youtube.com";
            }
            return null;
        }
        if (iHashCode == 2379719 && str.equals("MWEB")) {
            return "https://m.youtube.com";
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x017f  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final SabrBootstrap toSabrBootstrap(PlayerResponse playerResponse, int i, String str, PlayerResponse.StreamingData.Format format, String str2, String str3, String str4, String str5, PlayerResponse.StreamingData.Format format2) {
        String str6;
        Object next;
        String str7;
        Long longOrNull;
        long jLongValue;
        SabrBootstrap sabrBootstrap;
        SabrFormatId sabrFormatId;
        byte[] bArrDecodeBase64Url;
        String str8;
        Long longOrNull2;
        PlayerResponse.PlayerConfig.MediaCommonConfig mediaCommonConfig;
        PlayerResponse.PlayerConfig.MediaCommonConfig.MediaUstreamerRequestConfig mediaUstreamerRequestConfig;
        playerResponse.getClass();
        PlayerResponse.VideoDetails videoDetails = playerResponse.videoDetails;
        format.getClass();
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("SABR client ID must be positive");
            return null;
        }
        PlayerResponse.StreamingData streamingData = playerResponse.streamingData;
        if (streamingData == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Player response has no streamingData");
            return null;
        }
        if (str5 == null) {
            String str9 = streamingData.serverAbrStreamingUrl;
            if (str9 == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Player response has no serverAbrStreamingUrl");
                return null;
            }
            str6 = str9;
        } else {
            str6 = str5;
        }
        requireAllowedSabrUrl(str6);
        PlayerResponse.PlayerConfig playerConfig = playerResponse.playerConfig;
        String str10 = (playerConfig == null || (mediaCommonConfig = playerConfig.mediaCommonConfig) == null || (mediaUstreamerRequestConfig = mediaCommonConfig.mediaUstreamerRequestConfig) == null) ? null : mediaUstreamerRequestConfig.videoPlaybackUstreamerConfig;
        if (str10 == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Player response has no videoPlaybackUstreamerConfig");
            return null;
        }
        FilteringSequence filteringSequence = new FilteringSequence(new FilteringSequence(CollectionsKt.asSequence(streamingData.adaptiveFormats), false, SabrBootstrapFactoryKt$toSabrBootstrap$discardVideo$1.INSTANCE), true, new YouTube$$ExternalSyntheticLambda2((byte) 29));
        ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0 comparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0CompareBy = RegexKt.compareBy(new KuGouKt$$ExternalSyntheticLambda0((byte) 1), new KuGouKt$$ExternalSyntheticLambda0((byte) 2));
        FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1(filteringSequence);
        if (anonymousClass1.hasNext()) {
            next = anonymousClass1.next();
            while (anonymousClass1.hasNext()) {
                Object next2 = anonymousClass1.next();
                if (comparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0CompareBy.compare(next, next2) > 0) {
                    next = next2;
                }
            }
        } else {
            next = null;
        }
        PlayerResponse.StreamingData.Format format3 = (PlayerResponse.StreamingData.Format) next;
        if (format3 == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Player response has no SABR video format to discard");
            return null;
        }
        String str11 = format.approxDurationMs;
        if (str11 != null && (longOrNull2 = StringsKt__StringsJVMKt.toLongOrNull(10, str11)) != null) {
            jLongValue = longOrNull2.longValue();
        } else {
            if (videoDetails == null || (str7 = videoDetails.lengthSeconds) == null || (longOrNull = StringsKt__StringsJVMKt.toLongOrNull(10, str7)) == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Player response has no duration");
                return null;
            }
            jLongValue = longOrNull.longValue() * 1000;
        }
        long j = jLongValue;
        if (j <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Player response has an invalid duration");
            return null;
        }
        SabrFormatId sabrFormatId2 = toSabrFormatId(format);
        SabrFormatId sabrFormatId3 = toSabrFormatId(format3);
        if (format2 != null) {
            sabrBootstrap = null;
            sabrFormatId = toSabrFormatId(format2);
        } else {
            sabrBootstrap = null;
            sabrFormatId = null;
        }
        if (sabrFormatId2.lastModified <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("SABR audio format has no last-modified identity");
            return sabrBootstrap;
        }
        if (sabrFormatId3.lastModified <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("SABR video format has no last-modified identity");
            return sabrBootstrap;
        }
        if (sabrFormatId != null && sabrFormatId.lastModified <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Selected SABR video format has no last-modified identity");
            return sabrBootstrap;
        }
        Object obj = videoDetails != null ? videoDetails.videoId : sabrBootstrap;
        if (obj == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Player response has no video ID");
            return sabrBootstrap;
        }
        byte[] bArrDecodeBase64Url2 = decodeBase64Url(65536, str10, "videoPlaybackUstreamerConfig");
        Integer num = format3.height;
        int iIntValue = num != null ? num.intValue() : 144;
        Integer num2 = format2 != null ? format2.width : sabrBootstrap;
        Integer num3 = format2 != null ? format2.height : sabrBootstrap;
        Long l = format2 != null ? format2.contentLength : sabrBootstrap;
        String string = (format2 == null || (str8 = format2.mimeType) == null) ? sabrBootstrap : StringsKt.trim(StringsKt.substringBefore$default(str8, ';')).toString();
        Integer numValueOf = format2 != null ? Integer.valueOf(format2.bitrate) : sabrBootstrap;
        Long l2 = format.contentLength;
        String string2 = StringsKt.trim(StringsKt.substringBefore$default(format.mimeType, ';')).toString();
        PlayerResponse.StreamingData.Format.AudioTrack audioTrack = format.audioTrack;
        String str12 = audioTrack != null ? audioTrack.id : sabrBootstrap;
        boolean z = format.isDrc;
        if (str2 == null) {
            bArrDecodeBase64Url = sabrBootstrap;
        } else {
            String str13 = !StringsKt.isBlank(str2) ? str2 : sabrBootstrap;
            if (str13 != 0) {
                bArrDecodeBase64Url = decodeBase64Url(16384, str13, "poToken");
            } else {
                bArrDecodeBase64Url = sabrBootstrap;
            }
        }
        return new SabrBootstrap(obj, str6, bArrDecodeBase64Url2, i, str, sabrFormatId2, sabrFormatId3, iIntValue, sabrFormatId, num2, num3, l, string, numValueOf, j, l2, string2, str12, z, bArrDecodeBase64Url, str3, str4);
    }

    public static final SabrFormatId toSabrFormatId(PlayerResponse.StreamingData.Format format) {
        Long longOrNull;
        int i = format.itag;
        String str = format.lastModified;
        return new SabrFormatId(i, (str == null || (longOrNull = StringsKt__StringsJVMKt.toLongOrNull(10, str)) == null) ? 0L : longOrNull.longValue(), format.xtags);
    }
}
