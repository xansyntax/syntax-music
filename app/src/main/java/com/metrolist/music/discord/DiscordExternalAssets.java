package com.metrolist.music.discord;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.util.reflect.TypeInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordExternalAssets {
    public static final DiscordExternalAssets INSTANCE = new DiscordExternalAssets();
    public static final JsonImpl json = UuidKt.Json$default(new DiscordAuth$Companion$$ExternalSyntheticLambda0((byte) 2));
    public static final ConcurrentHashMap cache = new ConcurrentHashMap();
    public static final SynchronizedLazyImpl client$delegate = new SynchronizedLazyImpl(new DiscordExternalAssets$$ExternalSyntheticLambda1((byte) 0));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/discord/DiscordExternalAssets$ExternalAssetResponse", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class ExternalAssetResponse {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String externalAssetPath;
        public final String url;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/discord/DiscordExternalAssets$ExternalAssetResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/discord/DiscordExternalAssets$ExternalAssetResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return DiscordExternalAssets$ExternalAssetResponse$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ExternalAssetResponse(int i, String str, String str2) {
            if ((i & 1) == 0) {
                this.url = null;
            } else {
                this.url = str;
            }
            if ((i & 2) == 0) {
                this.externalAssetPath = null;
            } else {
                this.externalAssetPath = str2;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExternalAssetResponse)) {
                return false;
            }
            ExternalAssetResponse externalAssetResponse = (ExternalAssetResponse) obj;
            return Intrinsics.areEqual(this.url, externalAssetResponse.url) && Intrinsics.areEqual(this.externalAssetPath, externalAssetResponse.externalAssetPath);
        }

        public final int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.externalAssetPath;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("ExternalAssetResponse(url=", this.url, ", externalAssetPath=", this.externalAssetPath, ")");
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.discord.DiscordExternalAssets$resolve$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public String L$0;
        public HttpResponse L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscordExternalAssets.this.resolve(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0129, code lost:
    
        if (r2 == r12) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolve(String str, String str2, String str3, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        TypeReference typeReferenceTypeOf;
        HttpResponse httpResponse;
        Object objBodyAsText$default;
        String str4 = str;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objExecute = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        JsonImpl jsonImpl = json;
        ConcurrentHashMap concurrentHashMap = cache;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                if (!StringsKt.isBlank(str4)) {
                    if (StringsKt__StringsJVMKt.startsWith(str4, "mp:", false)) {
                        return str4;
                    }
                    String str5 = (String) concurrentHashMap.get(str4);
                    if (str5 != null) {
                        Timber.Forest.tag("DiscordSvc");
                        ConnectionPool.d(StringsKt.take(60, str4), str5);
                        return str5;
                    }
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.d(StringsKt.take(60, str4));
                    HttpClient httpClient = (HttpClient) client$delegate.getValue();
                    String str6 = String.format("https://discord.com/api/v9/applications/%s/external-assets", Arrays.copyOf(new Object[]{str2}, 1));
                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                    httpRequestBuilder.setMethod(HttpMethod.Post);
                    HttpRequestKt.url(httpRequestBuilder, str6);
                    UtilsKt.header(httpRequestBuilder, HttpHeaders.Authorization, str3);
                    UtilsKt.header(httpRequestBuilder, HttpHeaders.UserAgent, "Discord-Android/314013;RNA");
                    UtilsKt.header(httpRequestBuilder, "X-Super-Properties", HexFormatKt.getBase64());
                    UtilsKt.header(httpRequestBuilder, HttpHeaders.ContentType, "application/json");
                    ExternalAssetRequest externalAssetRequest = new ExternalAssetRequest(CollectionsKt__IterablesKt.listOf(str4));
                    jsonImpl.getClass();
                    httpRequestBuilder.setBody(jsonImpl.encodeToString(ExternalAssetRequest.INSTANCE.serializer(), externalAssetRequest));
                    ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    try {
                        typeReferenceTypeOf = Reflection.typeOf(String.class);
                    } catch (Throwable unused) {
                        typeReferenceTypeOf = null;
                    }
                    httpRequestBuilder.setBodyType(new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
                    httpRequestBuilder.setMethod(HttpMethod.Post);
                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                    anonymousClass1.L$0 = str4;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.label = 1;
                    objExecute = httpStatement.execute(anonymousClass1);
                    if (objExecute == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                return null;
            }
            if (i2 == 1) {
                str4 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(objExecute);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                HttpResponse httpResponse2 = anonymousClass1.L$3;
                String str7 = anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objExecute);
                    httpResponse = httpResponse2;
                    str4 = str7;
                    objBodyAsText$default = objExecute;
                } catch (Exception unused2) {
                    str4 = str7;
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.e$1(StringsKt.take(60, str4));
                }
            }
            String str8 = (String) objBodyAsText$default;
            int value = httpResponse.getStatus().getValue();
            if (200 > value || value >= 300 || StringsKt.isBlank(str8)) {
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.w(new Integer(value), StringsKt.take(60, str4), StringsKt.take(200, str8));
            } else {
                jsonImpl.getClass();
                ExternalAssetResponse externalAssetResponse = (ExternalAssetResponse) CollectionsKt.firstOrNull((List) jsonImpl.decodeFromString(new HashSetSerializer(ExternalAssetResponse.INSTANCE.serializer(), (byte) 1), str8));
                String str9 = externalAssetResponse != null ? externalAssetResponse.externalAssetPath : null;
                if (str9 != null) {
                    String strConcat = "mp:".concat(str9);
                    concurrentHashMap.put(str4, strConcat);
                    if (concurrentHashMap.size() > 128) {
                        int size = concurrentHashMap.size() - 128;
                        Set setKeySet = concurrentHashMap.keySet();
                        setKeySet.getClass();
                        Iterator it = CollectionsKt.take(setKeySet, size).iterator();
                        while (it.hasNext()) {
                            concurrentHashMap.remove((String) it.next());
                        }
                    }
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.i(StringsKt.take(60, str4), strConcat);
                    return strConcat;
                }
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.w(StringsKt.take(60, str4), StringsKt.take(200, str8));
            }
            return null;
            httpResponse = (HttpResponse) objExecute;
            anonymousClass1.L$0 = str4;
            anonymousClass1.L$3 = httpResponse;
            anonymousClass1.label = 2;
            objBodyAsText$default = HttpResponseKt.bodyAsText$default(httpResponse, null, anonymousClass1, 1, null);
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"com/metrolist/music/discord/DiscordExternalAssets$ExternalAssetRequest", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    final /* data */ class ExternalAssetRequest {
        public final List urls;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new DiscordExternalAssets$$ExternalSyntheticLambda1((byte) 1))};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/discord/DiscordExternalAssets$ExternalAssetRequest$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/discord/DiscordExternalAssets$ExternalAssetRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return DiscordExternalAssets$ExternalAssetRequest$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ExternalAssetRequest(int i, List list) {
            if (1 == (i & 1)) {
                this.urls = list;
            } else {
                EnumsKt.throwMissingFieldException(DiscordExternalAssets$ExternalAssetRequest$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ExternalAssetRequest) && Intrinsics.areEqual(this.urls, ((ExternalAssetRequest) obj).urls);
        }

        public final int hashCode() {
            return this.urls.hashCode();
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("ExternalAssetRequest(urls=", ")", this.urls);
        }

        public ExternalAssetRequest(List list) {
            this.urls = list;
        }
    }
}
