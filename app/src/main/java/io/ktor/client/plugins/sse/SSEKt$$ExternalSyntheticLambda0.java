package io.ktor.client.plugins.sse;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.compression.ContentEncodingConfig;
import io.ktor.client.plugins.compression.ContentEncodingKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.client.plugins.contentnegotiation.ContentTypeMergeStrategy;
import io.ktor.client.plugins.observer.ResponseObserverKt;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SSEKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SSEKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return SSEKt.SSE$lambda$0((ClientPluginBuilder) obj);
            case 1:
                return ContentEncodingKt.ContentEncoding$lambda$0((ClientPluginBuilder) obj);
            case 2:
                return ContentEncodingKt.ContentEncoding$lambda$1((ContentEncodingConfig) obj);
            case 3:
                return ContentNegotiationKt.ContentNegotiation$lambda$0$convertRequest$12((ContentNegotiationConfig.ConverterRegistration) obj);
            case 4:
                return ContentNegotiationKt.ContentNegotiation$lambda$0((ClientPluginBuilder) obj);
            case 5:
                return ContentTypeMergeStrategy.Companion.Default$lambda$0$0((String) obj);
            case 6:
                return ResponseObserverKt.ResponseObserver$lambda$0((ClientPluginBuilder) obj);
            case 7:
                return BuildersKt.serverSentEvents_BqdlHlk$lambda$0((HttpRequestBuilder) obj);
            case 8:
                return BuildersKt.serverSentEventsSession_Mswn__c$lambda$0((HttpRequestBuilder) obj);
            case 9:
                return BuildersKt.serverSentEvents_3bFjkrY$lambda$0((HttpRequestBuilder) obj);
            case 10:
                return BuildersKt.serverSentEvents_1wIb_0I$lambda$0((HttpRequestBuilder) obj);
            case 11:
                return BuildersKt.sse_tL6_L_A$lambda$0((HttpRequestBuilder) obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return BuildersKt.serverSentEvents_pTj2aPc$lambda$0((HttpRequestBuilder) obj);
            case 13:
                return BuildersKt.sseSession_Mswn__c$lambda$0((HttpRequestBuilder) obj);
            case 14:
                return BuildersKt.serverSentEventsSession_tL6_L_A$lambda$0((HttpRequestBuilder) obj);
            case 15:
                return BuildersKt.sse_Q9yt8Vw$lambda$0((HttpRequestBuilder) obj);
            case 16:
                return BuildersKt.sse_BAHpl2s$lambda$0((HttpRequestBuilder) obj);
            case 17:
                return BuildersKt.serverSentEventsSession_xEWcMm4$lambda$0((HttpRequestBuilder) obj);
            case 18:
                return BuildersKt.sseSession_xEWcMm4$lambda$0((HttpRequestBuilder) obj);
            case 19:
                return BuildersKt.sseSession_tL6_L_A$lambda$0((HttpRequestBuilder) obj);
            case 20:
                return BuildersKt.sse_Mswn__c$lambda$0((HttpRequestBuilder) obj);
            case 21:
                return BuildersKt.sseSession_mY9Nd3A$lambda$0((HttpRequestBuilder) obj);
            case 22:
                return BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$0((HttpRequestBuilder) obj);
            case 23:
                return io.ktor.client.plugins.websocket.BuildersKt.webSocket$lambda$2((HttpRequestBuilder) obj);
            case 24:
                return io.ktor.client.plugins.websocket.BuildersKt.wss$lambda$1((HttpRequestBuilder) obj);
            case 25:
                return io.ktor.client.plugins.websocket.BuildersKt.wss$lambda$3((HttpRequestBuilder) obj);
            case 26:
                return io.ktor.client.plugins.websocket.BuildersKt.ws$lambda$0((HttpRequestBuilder) obj);
            case 27:
                return io.ktor.client.plugins.websocket.BuildersKt.webSocketSession$lambda$3((HttpRequestBuilder) obj);
            case 28:
                return io.ktor.client.plugins.websocket.BuildersKt.webSocket$lambda$4((HttpRequestBuilder) obj);
            default:
                return io.ktor.client.plugins.websocket.BuildersKt.ws$lambda$1((HttpRequestBuilder) obj);
        }
    }
}
