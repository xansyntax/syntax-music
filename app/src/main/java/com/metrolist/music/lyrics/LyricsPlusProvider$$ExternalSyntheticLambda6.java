package com.metrolist.music.lyrics;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.models.MediaMetadata;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ReversedListReadOnly;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricsPlusProvider$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LyricsPlusProvider$$ExternalSyntheticLambda6(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                LyricWord lyricWord = (LyricWord) obj;
                lyricWord.getClass();
                return lyricWord.text;
            case 1:
                ZemerLyricsProvider.Source source = (ZemerLyricsProvider.Source) obj;
                source.getClass();
                return Boolean.valueOf(!source.synced);
            case 2:
                ZemerLyricsProvider.FeedLine feedLine = (ZemerLyricsProvider.FeedLine) obj;
                feedLine.getClass();
                Double d = feedLine.start;
                d.getClass();
                double dDoubleValue = d.doubleValue();
                int i = (int) (dDoubleValue / 60.0d);
                String str = String.format(Locale.US, "%02d:%05.2f", Arrays.copyOf(new Object[]{Integer.valueOf(i), Double.valueOf(dDoubleValue - ((double) (i * 60)))}, 2));
                String str2 = feedLine.text;
                str2.getClass();
                return "[" + str + "]" + StringsKt.trim(str2).toString();
            case 3:
                return ((MediaMetadata.Artist) obj).name;
            case 4:
                return ((LyricsProvider) obj).getName();
            case 5:
                return ((MediaMetadata.Artist) obj).name;
            case 6:
                HttpClientConfig httpClientConfig = (HttpClientConfig) obj;
                httpClientConfig.getClass();
                httpClientConfig.install(ContentNegotiationKt.getContentNegotiation(), new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 7));
                httpClientConfig.install(HttpTimeoutKt.getHttpTimeout(), new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 8));
                httpClientConfig.setExpectSuccess(false);
                return unit;
            case 7:
                ContentNegotiationConfig contentNegotiationConfig = (ContentNegotiationConfig) obj;
                contentNegotiationConfig.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig, UuidKt.Json$default(new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 9)), null, 2, null);
                return unit;
            case 8:
                HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) obj;
                httpTimeoutConfig.getClass();
                httpTimeoutConfig.setRequestTimeoutMillis(15000L);
                httpTimeoutConfig.setConnectTimeoutMillis(10000L);
                httpTimeoutConfig.setSocketTimeoutMillis(15000L);
                return unit;
            case 9:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.isLenient = true;
                jsonBuilder.ignoreUnknownKeys = true;
                return unit;
            case 10:
                LyricsEntry lyricsEntry = (LyricsEntry) obj;
                lyricsEntry.getClass();
                return lyricsEntry.text;
            case 11:
                return ((LyricsEntry) ((Pair) obj).second).text;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                JsonBuilder jsonBuilder2 = (JsonBuilder) obj;
                jsonBuilder2.getClass();
                jsonBuilder2.ignoreUnknownKeys = true;
                jsonBuilder2.isLenient = true;
                jsonBuilder2.explicitNulls = false;
                return unit;
            case 13:
                HttpClientConfig httpClientConfig2 = (HttpClientConfig) obj;
                httpClientConfig2.getClass();
                httpClientConfig2.install(ContentNegotiationKt.getContentNegotiation(), new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 14));
                httpClientConfig2.install(HttpTimeoutKt.getHttpTimeout(), new LyricsPlusProvider$$ExternalSyntheticLambda6((byte) 15));
                httpClientConfig2.setExpectSuccess(false);
                return unit;
            case 14:
                ContentNegotiationConfig contentNegotiationConfig2 = (ContentNegotiationConfig) obj;
                contentNegotiationConfig2.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig2, ZemerLyricsProvider.json, null, 2, null);
                return unit;
            case 15:
                HttpTimeoutConfig httpTimeoutConfig2 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig2.getClass();
                httpTimeoutConfig2.setRequestTimeoutMillis(15000L);
                httpTimeoutConfig2.setConnectTimeoutMillis(10000L);
                httpTimeoutConfig2.setSocketTimeoutMillis(15000L);
                return unit;
            default:
                MatchResult matchResult = (MatchResult) obj;
                matchResult.getClass();
                return String.valueOf((char) Integer.parseInt((String) ((ReversedListReadOnly) ((MatcherMatchResult) matchResult).getGroupValues()).get(1)));
        }
    }
}
