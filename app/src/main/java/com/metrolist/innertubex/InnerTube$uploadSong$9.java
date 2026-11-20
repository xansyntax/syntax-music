package com.metrolist.innertubex;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.models.YouTubeClient;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.BodyProgressKt;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$uploadSong$9 extends SuspendLambda implements Function1 {
    public final /* synthetic */ ImageLoader$Builder$$ExternalSyntheticLambda1 $content;
    public final /* synthetic */ long $contentLength;
    public final /* synthetic */ String $fileName;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public HttpResponse L$0;
    public String L$1;
    public byte label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX INFO: renamed from: com.metrolist.innertubex.InnerTube$uploadSong$9$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ ImageLoader$Builder$$ExternalSyntheticLambda1 $content;
        public final /* synthetic */ long $contentLength;
        public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
        public final /* synthetic */ Url $validatedUploadUrl;
        public boolean label;
        public final /* synthetic */ InnerTube this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InnerTube innerTube, Url url, InnerTube.SessionSnapshot sessionSnapshot, long j, ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1, Continuation continuation) {
            super(1, continuation);
            this.this$0 = innerTube;
            this.$validatedUploadUrl = url;
            this.$requestSession = sessionSnapshot;
            this.$contentLength = j;
            this.$content = imageLoader$Builder$$ExternalSyntheticLambda1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(this.this$0, this.$validatedUploadUrl, this.$requestSession, this.$contentLength, this.$content, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ((AnonymousClass2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z = this.label;
            if (z) {
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            InnerTube innerTube = this.this$0;
            HttpClient httpClient = innerTube.httpClient;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpMethod httpMethod = HttpMethod.Post;
            httpRequestBuilder.setMethod(httpMethod);
            URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), this.$validatedUploadUrl);
            HttpTimeoutKt.timeout(httpRequestBuilder, new YouTube$$ExternalSyntheticLambda2((byte) 10));
            YouTubeClient.INSTANCE.getClass();
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, YouTubeClient.WEB_REMIX.userAgent);
            HttpRequestKt.headers(httpRequestBuilder, new DiskLruCache$$ExternalSyntheticLambda0(this.$requestSession, innerTube, (byte) 20));
            UtilsKt.header(httpRequestBuilder, "X-Goog-Upload-Command", "upload, finalize");
            UtilsKt.header(httpRequestBuilder, "X-Goog-Upload-Offset", "0");
            BodyProgressKt.onUpload(httpRequestBuilder, new InnerTube$uploadSong$9$2$1$2());
            final long j = this.$contentLength;
            final ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1 = this.$content;
            httpRequestBuilder.setBody(new OutgoingContent.ReadChannelContent(j, imageLoader$Builder$$ExternalSyntheticLambda1) { // from class: com.metrolist.innertubex.InnerTube$uploadSong$9$2$1$3
                public final /* synthetic */ ImageLoader$Builder$$ExternalSyntheticLambda1 $content;
                public final long contentLength;
                public final ContentType contentType = ContentType.Application.INSTANCE.getFormUrlEncoded();

                {
                    this.$content = imageLoader$Builder$$ExternalSyntheticLambda1;
                    this.contentLength = j;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public final Long getContentLength() {
                    return Long.valueOf(this.contentLength);
                }

                @Override // io.ktor.http.content.OutgoingContent
                public final ContentType getContentType() {
                    return this.contentType;
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                public final ByteReadChannel readFrom() {
                    return (ByteReadChannel) this.$content.invoke();
                }
            });
            httpRequestBuilder.setBodyType(null);
            httpRequestBuilder.setMethod(httpMethod);
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            this.label = true;
            Object objExecute = httpStatement.execute(this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$uploadSong$9(InnerTube innerTube, InnerTube.SessionSnapshot sessionSnapshot, long j, String str, ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1, Continuation continuation) {
        super(1, continuation);
        this.this$0 = innerTube;
        this.$requestSession = sessionSnapshot;
        this.$contentLength = j;
        this.$fileName = str;
        this.$content = imageLoader$Builder$$ExternalSyntheticLambda1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InnerTube$uploadSong$9(this.this$0, this.$requestSession, this.$contentLength, this.$fileName, this.$content, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((InnerTube$uploadSong$9) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objExecuteRequest$default;
        HttpResponse httpResponse;
        String str;
        Url Url;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.$fileName;
            InnerTube innerTube = this.this$0;
            InnerTube$uploadSong$9$startResponse$1 innerTube$uploadSong$9$startResponse$1 = new InnerTube$uploadSong$9$startResponse$1(innerTube, this.$requestSession, this.$contentLength, str2, null);
            this.label = (byte) 1;
            objExecuteRequest$default = InnerTube.executeRequest$default(innerTube, "uploadSong:start", innerTube$uploadSong$9$startResponse$1, this, 56);
            if (objExecuteRequest$default != coroutineSingletons) {
            }
        }
        if (b == 1) {
            ResultKt.throwOnFailure(obj);
            objExecuteRequest$default = obj;
        } else {
            if (b != 2) {
                if (b == 3) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = this.L$1;
            httpResponse = this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(httpResponse.getStatus().getValue(), "Upload session start failed with HTTP "));
            return null;
        }
        if (str != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Missing upload session URL");
            return null;
        }
        Set set = InnerTube.TRANSIENT_STATUS_CODES;
        this.this$0.getClass();
        Url = URLUtilsKt.Url(str);
        if (Intrinsics.areEqual(Url.getProtocol().getName(), "https") || Url.getPort() != 443 || !Intrinsics.areEqual(Url.getHost(), "upload.youtube.com") || ((!Intrinsics.areEqual(Url.getEncodedPath(), "/") && !StringsKt__StringsJVMKt.startsWith(Url.getEncodedPath(), "/upload/", false)) || Url.getUser() != null || Url.getPassword() != null)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Upload session URL must use the approved YouTube HTTPS endpoint");
            return null;
        }
        ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1 = this.$content;
        InnerTube innerTube2 = this.this$0;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(innerTube2, Url, this.$requestSession, this.$contentLength, imageLoader$Builder$$ExternalSyntheticLambda1, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = (byte) 3;
        Object objExecuteRequest$default2 = InnerTube.executeRequest$default(innerTube2, "uploadSong:finalize", anonymousClass2, this, 56);
        return objExecuteRequest$default2 == coroutineSingletons ? coroutineSingletons : objExecuteRequest$default2;
        httpResponse = (HttpResponse) objExecuteRequest$default;
        str = httpResponse.getHeaders().get("X-Goog-Upload-URL");
        this.L$0 = httpResponse;
        this.L$1 = str;
        this.label = (byte) 2;
        if (CollectionsKt__IterablesKt.bodyAsTextLimited(httpResponse, 65536, null, this) != coroutineSingletons) {
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(httpResponse.getStatus().getValue(), "Upload session start failed with HTTP "));
                return null;
            }
            if (str != null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Missing upload session URL");
                return null;
            }
            Set set2 = InnerTube.TRANSIENT_STATUS_CODES;
            this.this$0.getClass();
            Url = URLUtilsKt.Url(str);
            if (Intrinsics.areEqual(Url.getProtocol().getName(), "https")) {
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Upload session URL must use the approved YouTube HTTPS endpoint");
            return null;
        }
    }
}
