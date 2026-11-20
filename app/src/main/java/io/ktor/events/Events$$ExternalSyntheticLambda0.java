package io.ktor.events;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.client.plugins.websocket.BuildersKt;
import io.ktor.client.request.BuildersJvmKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.forms.FormBuildersKt;
import io.ktor.client.utils.HeadersKt;
import io.ktor.http.CookieKt;
import io.ktor.http.CookieUtilsKt;
import io.ktor.http.FileContentTypeKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.URLBuilder;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Events$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Events$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Events.subscribe$lambda$0((EventDefinition) obj);
            case 1:
                return BuildersKt.webSocketSession$lambda$1((HttpRequestBuilder) obj);
            case 2:
                return BuildersJvmKt.get$lambda$0((HttpRequestBuilder) obj);
            case 3:
                return BuildersJvmKt.prepareOptions$lambda$0((HttpRequestBuilder) obj);
            case 4:
                return BuildersJvmKt.delete$lambda$0((HttpRequestBuilder) obj);
            case 5:
                return BuildersJvmKt.preparePost$lambda$0((HttpRequestBuilder) obj);
            case 6:
                return BuildersJvmKt.preparePut$lambda$0((HttpRequestBuilder) obj);
            case 7:
                return BuildersJvmKt.prepareDelete$lambda$0((HttpRequestBuilder) obj);
            case 8:
                return BuildersJvmKt.put$lambda$0((HttpRequestBuilder) obj);
            case 9:
                return BuildersJvmKt.prepareGet$lambda$0((HttpRequestBuilder) obj);
            case 10:
                return BuildersJvmKt.preparePatch$lambda$0((HttpRequestBuilder) obj);
            case 11:
                return BuildersJvmKt.request$lambda$0((HttpRequestBuilder) obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return BuildersJvmKt.options$lambda$0((HttpRequestBuilder) obj);
            case 13:
                return BuildersJvmKt.patch$lambda$0((HttpRequestBuilder) obj);
            case 14:
                return BuildersJvmKt.head$lambda$0((HttpRequestBuilder) obj);
            case 15:
                return BuildersJvmKt.prepareRequest$lambda$0((HttpRequestBuilder) obj);
            case 16:
                return BuildersJvmKt.post$lambda$0((HttpRequestBuilder) obj);
            case 17:
                return BuildersJvmKt.prepareHead$lambda$0((HttpRequestBuilder) obj);
            case 18:
                return HttpRequestKt.invoke$lambda$1((URLBuilder) obj);
            case 19:
                return HttpRequestKt.url$lambda$0((URLBuilder) obj);
            case 20:
                return FormBuildersKt.prepareForm$lambda$1((HttpRequestBuilder) obj);
            case 21:
                return FormBuildersKt.submitForm$lambda$1((HttpRequestBuilder) obj);
            case 22:
                return HeadersKt.buildHeaders$lambda$0((HeadersBuilder) obj);
            case 23:
                return Boolean.valueOf(CookieUtilsKt.isDelimiter(((Character) obj).charValue()));
            case 24:
                return Boolean.valueOf(CookieUtilsKt.isNonDelimiter(((Character) obj).charValue()));
            case 25:
                return Boolean.valueOf(CookieUtilsKt.isNonDelimiter(((Character) obj).charValue()));
            case 26:
                return Boolean.valueOf(CookieUtilsKt.isDelimiter(((Character) obj).charValue()));
            case 27:
                return CookieKt.clientCookies$lambda$0((MatchResult) obj);
            case 28:
                return CookieKt.clientCookies$lambda$2((Pair) obj);
            default:
                return FileContentTypeKt.extensionsByContentType_delegate$lambda$0$0((Pair) obj);
        }
    }
}
