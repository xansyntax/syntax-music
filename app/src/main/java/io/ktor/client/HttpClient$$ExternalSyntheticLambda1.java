package io.ktor.client;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.paxsenix.Paxsenix;
import com.metrolist.paxsenix.models.LyricText;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.client.engine.okhttp.OkHttpEngine;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.DefaultRequestKt;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.plugins.cache.HttpCache;
import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.client.plugins.cache.HttpCacheLegacyKt;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaders;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonBuilder;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpClient$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ HttpClient$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return HttpClient.lambda$1$0((HttpClient) obj);
            case 1:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.ignoreUnknownKeys = true;
                return unit;
            case 2:
                return ((ArtistEntity) obj).name;
            case 3:
                return Integer.valueOf(((PlaylistSong) obj).map.position);
            case 4:
                return Integer.valueOf(((PlaylistSong) obj).map.id);
            case 5:
                JsonBuilder jsonBuilder2 = (JsonBuilder) obj;
                jsonBuilder2.getClass();
                jsonBuilder2.ignoreUnknownKeys = true;
                return unit;
            case 6:
                HttpClientConfig httpClientConfig = (HttpClientConfig) obj;
                httpClientConfig.getClass();
                httpClientConfig.install(HttpTimeoutKt.getHttpTimeout(), new HttpClient$$ExternalSyntheticLambda1((byte) 7));
                httpClientConfig.install(ContentNegotiationKt.getContentNegotiation(), new HttpClient$$ExternalSyntheticLambda1((byte) 8));
                DefaultRequestKt.defaultRequest(httpClientConfig, new HttpClient$$ExternalSyntheticLambda1((byte) 9));
                httpClientConfig.setExpectSuccess(true);
                return unit;
            case 7:
                HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) obj;
                httpTimeoutConfig.getClass();
                httpTimeoutConfig.setRequestTimeoutMillis(15000L);
                httpTimeoutConfig.setConnectTimeoutMillis(10000L);
                return unit;
            case 8:
                ContentNegotiationConfig contentNegotiationConfig = (ContentNegotiationConfig) obj;
                contentNegotiationConfig.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig, UuidKt.Json$default(new HttpClient$$ExternalSyntheticLambda1((byte) 13)), null, 2, null);
                return unit;
            case 9:
                DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = (DefaultRequest.DefaultRequestBuilder) obj;
                defaultRequestBuilder.getClass();
                defaultRequestBuilder.url("https://lyrics.paxsenix.org");
                UtilsKt.header(defaultRequestBuilder, HttpHeaders.UserAgent, "Metrolist/".concat(Paxsenix.appVersion));
                return unit;
            case 10:
                LyricText lyricText = (LyricText) obj;
                lyricText.getClass();
                return lyricText.text;
            case 11:
                LyricText lyricText2 = (LyricText) obj;
                lyricText2.getClass();
                return lyricText2.text;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                LyricText lyricText3 = (LyricText) obj;
                lyricText3.getClass();
                return lyricText3.text + ServerSentEventKt.COLON + (lyricText3.timestamp / 1000.0d) + ServerSentEventKt.COLON + (lyricText3.endtime / 1000.0d);
            case 13:
                JsonBuilder jsonBuilder3 = (JsonBuilder) obj;
                jsonBuilder3.getClass();
                jsonBuilder3.isLenient = true;
                jsonBuilder3.ignoreUnknownKeys = true;
                return unit;
            case 14:
                HttpClientConfig httpClientConfig2 = (HttpClientConfig) obj;
                httpClientConfig2.getClass();
                httpClientConfig2.install(ContentNegotiationKt.getContentNegotiation(), new HttpClient$$ExternalSyntheticLambda1((byte) 15));
                httpClientConfig2.setExpectSuccess(false);
                httpClientConfig2.install(HttpTimeoutKt.getHttpTimeout(), new HttpClient$$ExternalSyntheticLambda1((byte) 16));
                return unit;
            case 15:
                ContentNegotiationConfig contentNegotiationConfig2 = (ContentNegotiationConfig) obj;
                contentNegotiationConfig2.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig2, UuidKt.Json$default(new HttpClient$$ExternalSyntheticLambda1((byte) 17)), null, 2, null);
                return unit;
            case 16:
                HttpTimeoutConfig httpTimeoutConfig2 = (HttpTimeoutConfig) obj;
                httpTimeoutConfig2.getClass();
                httpTimeoutConfig2.setRequestTimeoutMillis(30000L);
                return unit;
            case 17:
                JsonBuilder jsonBuilder4 = (JsonBuilder) obj;
                jsonBuilder4.getClass();
                jsonBuilder4.isLenient = true;
                jsonBuilder4.ignoreUnknownKeys = true;
                jsonBuilder4.encodeDefaults = true;
                return unit;
            case 18:
                return HttpClientConfig.install$lambda$0(obj);
            case 19:
                return HttpClientConfig.engineConfig$lambda$0((HttpClientEngineConfig) obj);
            case 20:
                return HttpClientConfig.installOrReplace$lambda$0(obj);
            case 21:
                return HttpClientEngineContainerKt.selectDefaultHttpClientEngine$lambda$2$0((HttpClientEngineContainer) obj);
            case 22:
                return HttpClientEngineContainerKt.selectDefaultHttpClientEngine$lambda$3$0((HttpClientEngineContainer) obj);
            case 23:
                return HttpClientJvmKt.HttpClient$lambda$0((HttpClientConfig) obj);
            case 24:
                return HttpClientKt.HttpClient$lambda$0((HttpClientConfig) obj);
            case 25:
                return HttpClientEngineFactory.create$lambda$0((HttpClientEngineConfig) obj);
            case 26:
                return OkHttpConfig.config$lambda$0((OkHttpClient.Builder) obj);
            case 27:
                return OkHttpEngine.clientCache$lambda$0((OkHttpClient) obj);
            case 28:
                return HttpCache.selectResponseToUpdate$lambda$6((CachedResponseData) obj);
            default:
                return HttpCacheLegacyKt.selectResponseToUpdate$lambda$6((HttpCacheEntry) obj);
        }
    }
}
