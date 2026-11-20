package com.metrolist.innertube;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.response.GetTranscriptResponse;
import com.metrolist.innertubex.extraction.YtConfigParserImpl;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.music.utils.potoken.PoTokenGenerator;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTube$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ YouTube$$ExternalSyntheticLambda2(YtConfigParserImpl ytConfigParserImpl) {
        this.$r8$classId = (byte) 23;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String str;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Run run = (Run) obj;
                run.getClass();
                return run.text;
            case 1:
                Run run2 = (Run) obj;
                run2.getClass();
                return run2.text;
            case 2:
                GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup cueGroup = (GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup) obj;
                cueGroup.getClass();
                GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer transcriptCueGroupRenderer = cueGroup.transcriptCueGroupRenderer;
                long j = ((GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue) transcriptCueGroupRenderer.cues.get(0)).transcriptCueRenderer.startOffsetMs;
                return String.format(Fragment$5$$ExternalSyntheticOutline0.m("[%02d:%02d.%03d]", StringsKt.trim(StringsKt.trim(((GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Cue) transcriptCueGroupRenderer.cues.get(0)).transcriptCueRenderer.cue.simpleText, 9834), ' ')), Arrays.copyOf(new Object[]{Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60), Long.valueOf(j % 1000)}, 3));
            case 3:
                Run run3 = (Run) obj;
                run3.getClass();
                return run3.text;
            case 4:
                Run run4 = (Run) obj;
                run4.getClass();
                return run4.text;
            case 5:
                Run run5 = (Run) obj;
                run5.getClass();
                return run5.text;
            case 6:
                Run run6 = (Run) obj;
                run6.getClass();
                return run6.text;
            case 7:
                Run run7 = (Run) obj;
                run7.getClass();
                return run7.text;
            case 8:
                Byte b2 = (Byte) obj;
                b2.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b2}, 1));
            case 9:
                ((HeadersBuilder) obj).append(HttpHeaders.ContentType, "application/json");
                return unit;
            case 10:
                HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) obj;
                httpTimeoutConfig.setRequestTimeoutMillis(600000L);
                httpTimeoutConfig.setSocketTimeoutMillis(600000L);
                return unit;
            case 11:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.encodeDefaults = false;
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) obj;
                httpRequestBuilder.getClass();
                UtilsKt.header(httpRequestBuilder, HttpHeaders.UserAgent, "okhttp/5.4.0");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.Accept, "application/json");
                HttpTimeoutKt.timeout(httpRequestBuilder, new YouTube$$ExternalSyntheticLambda2((byte) 13));
                return unit;
            case 13:
                HttpTimeoutConfig httpTimeoutConfig2 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig2.getClass();
                httpTimeoutConfig2.setRequestTimeoutMillis(2000L);
                httpTimeoutConfig2.setConnectTimeoutMillis(2000L);
                httpTimeoutConfig2.setSocketTimeoutMillis(2000L);
                return unit;
            case 14:
                JsonBuilder jsonBuilder2 = (JsonBuilder) obj;
                jsonBuilder2.getClass();
                jsonBuilder2.ignoreUnknownKeys = true;
                jsonBuilder2.encodeDefaults = false;
                return unit;
            case 15:
                HttpTimeoutConfig httpTimeoutConfig3 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig3.getClass();
                httpTimeoutConfig3.setRequestTimeoutMillis(5000L);
                httpTimeoutConfig3.setConnectTimeoutMillis(5000L);
                httpTimeoutConfig3.setSocketTimeoutMillis(5000L);
                return unit;
            case 16:
                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) obj;
                httpRequestBuilder2.getClass();
                UtilsKt.header(httpRequestBuilder2, HttpHeaders.UserAgent, "okhttp/5.4.0");
                UtilsKt.header(httpRequestBuilder2, HttpHeaders.Accept, "application/json");
                HttpTimeoutKt.timeout(httpRequestBuilder2, new YouTube$$ExternalSyntheticLambda2((byte) 17));
                return unit;
            case 17:
                HttpTimeoutConfig httpTimeoutConfig4 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig4.getClass();
                httpTimeoutConfig4.setRequestTimeoutMillis(5000L);
                httpTimeoutConfig4.setConnectTimeoutMillis(5000L);
                httpTimeoutConfig4.setSocketTimeoutMillis(5000L);
                return unit;
            case 18:
                HttpClientConfig httpClientConfig = (HttpClientConfig) obj;
                httpClientConfig.getClass();
                httpClientConfig.setExpectSuccess(false);
                httpClientConfig.setFollowRedirects(false);
                HttpClientConfig.install$default(httpClientConfig, HttpTimeoutKt.getHttpTimeout(), null, 2, null);
                return unit;
            case 19:
                HttpRequestBuilder httpRequestBuilder3 = (HttpRequestBuilder) obj;
                httpRequestBuilder3.getClass();
                UtilsKt.header(httpRequestBuilder3, HttpHeaders.UserAgent, "okhttp/5.4.0");
                UtilsKt.header(httpRequestBuilder3, HttpHeaders.Accept, "*/*");
                UtilsKt.header(httpRequestBuilder3, HttpHeaders.Referrer, "https://www.youtube.com/");
                return unit;
            case 20:
                PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) obj;
                format.getClass();
                return Boolean.valueOf((format.width != null || (str = format.url) == null || StringsKt.isBlank(str)) ? false : true);
            case 21:
                PlayerResponse.StreamingData.Format format2 = (PlayerResponse.StreamingData.Format) obj;
                format2.getClass();
                return Integer.valueOf(format2.itag);
            case 22:
                JsonBuilder jsonBuilder3 = (JsonBuilder) obj;
                jsonBuilder3.getClass();
                jsonBuilder3.ignoreUnknownKeys = true;
                return unit;
            case 23:
                String strConcat = (String) obj;
                strConcat.getClass();
                if (!StringsKt__StringsJVMKt.startsWith(strConcat, "http", false)) {
                    if (!StringsKt.startsWith$default(strConcat, '/')) {
                        strConcat = "/".concat(strConcat);
                    }
                    strConcat = "https://www.youtube.com".concat(strConcat);
                }
                return YtConfigParserImpl.validatePlayerUrl(strConcat);
            case 24:
                HttpRequestBuilder httpRequestBuilder4 = (HttpRequestBuilder) obj;
                httpRequestBuilder4.getClass();
                UtilsKt.header(httpRequestBuilder4, HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0");
                HttpTimeoutKt.timeout(httpRequestBuilder4, new YouTube$$ExternalSyntheticLambda2((byte) 26));
                return unit;
            case 25:
                HttpRequestBuilder httpRequestBuilder5 = (HttpRequestBuilder) obj;
                httpRequestBuilder5.getClass();
                UtilsKt.header(httpRequestBuilder5, HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0");
                HttpTimeoutKt.timeout(httpRequestBuilder5, new YouTube$$ExternalSyntheticLambda2((byte) 28));
                return unit;
            case 26:
                HttpTimeoutConfig httpTimeoutConfig5 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig5.getClass();
                Long lValueOf = Long.valueOf(PoTokenGenerator.POTOKEN_TIMEOUT_MS);
                httpTimeoutConfig5.setRequestTimeoutMillis(lValueOf);
                httpTimeoutConfig5.setConnectTimeoutMillis(lValueOf);
                httpTimeoutConfig5.setSocketTimeoutMillis(lValueOf);
                return unit;
            case 27:
                HttpTimeoutConfig httpTimeoutConfig6 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig6.getClass();
                httpTimeoutConfig6.setRequestTimeoutMillis(10000L);
                httpTimeoutConfig6.setConnectTimeoutMillis(10000L);
                httpTimeoutConfig6.setSocketTimeoutMillis(10000L);
                return unit;
            case 28:
                HttpTimeoutConfig httpTimeoutConfig7 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig7.getClass();
                Long lValueOf2 = Long.valueOf(PoTokenGenerator.POTOKEN_TIMEOUT_MS);
                httpTimeoutConfig7.setRequestTimeoutMillis(lValueOf2);
                httpTimeoutConfig7.setConnectTimeoutMillis(lValueOf2);
                httpTimeoutConfig7.setSocketTimeoutMillis(lValueOf2);
                return unit;
            default:
                PlayerResponse.StreamingData.Format format3 = (PlayerResponse.StreamingData.Format) obj;
                format3.getClass();
                return Boolean.valueOf(format3.height != null);
        }
    }

    public /* synthetic */ YouTube$$ExternalSyntheticLambda2(byte b) {
        this.$r8$classId = b;
    }
}
