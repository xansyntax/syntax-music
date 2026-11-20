package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.EditPlaylistBody;
import com.metrolist.innertubex.models.body.SubscribeBody;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import java.util.LinkedHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonObject;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$addToPlaylist$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $playlistId;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String $videoId;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$addToPlaylist$2(InnerTube innerTube, YouTubeClient youTubeClient, String str, String str2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$playlistId = str;
        this.$videoId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                InnerTube$addToPlaylist$2 innerTube$addToPlaylist$2 = new InnerTube$addToPlaylist$2(this.this$0, this.$client, this.$playlistId, this.$videoId, continuation, (byte) 0);
                innerTube$addToPlaylist$2.L$0 = obj;
                return innerTube$addToPlaylist$2;
            case 1:
                InnerTube$addToPlaylist$2 innerTube$addToPlaylist$3 = new InnerTube$addToPlaylist$2(this.this$0, this.$client, this.$playlistId, this.$videoId, continuation, (byte) 1);
                innerTube$addToPlaylist$3.L$0 = obj;
                return innerTube$addToPlaylist$3;
            case 2:
                InnerTube$addToPlaylist$2 innerTube$addToPlaylist$4 = new InnerTube$addToPlaylist$2(this.this$0, this.$client, this.$playlistId, this.$videoId, continuation, (byte) 2);
                innerTube$addToPlaylist$4.L$0 = obj;
                return innerTube$addToPlaylist$4;
            case 3:
                InnerTube$addToPlaylist$2 innerTube$addToPlaylist$5 = new InnerTube$addToPlaylist$2(this.this$0, this.$client, this.$playlistId, this.$videoId, continuation, (byte) 3);
                innerTube$addToPlaylist$5.L$0 = obj;
                return innerTube$addToPlaylist$5;
            default:
                InnerTube$addToPlaylist$2 innerTube$addToPlaylist$6 = new InnerTube$addToPlaylist$2(this.this$0, this.$client, this.$playlistId, this.$videoId, continuation, (byte) 4);
                innerTube$addToPlaylist$6.L$0 = obj;
                return innerTube$addToPlaylist$6;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        InnerTube.SessionSnapshot sessionSnapshot = (InnerTube.SessionSnapshot) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return ((InnerTube$addToPlaylist$2) create(sessionSnapshot, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TypeReference typeReferenceTypeOf;
        TypeReference typeReferenceTypeOf2;
        TypeReference typeReferenceTypeOf3;
        TypeReference typeReferenceTypeOf4;
        TypeReference typeReferenceTypeOf5;
        byte b = this.$r8$classId;
        String str = this.$videoId;
        String str2 = this.$playlistId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                InnerTube.SessionSnapshot sessionSnapshot = (InnerTube.SessionSnapshot) this.L$0;
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
                httpRequestBuilder.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder, "browse/edit_playlist");
                YouTubeClient youTubeClient = this.$client;
                InnerTube.ytClient$default(innerTube, httpRequestBuilder, youTubeClient, sessionSnapshot, true, null, false, 24);
                Context context = youTubeClient.toContext(sessionSnapshot.locale, sessionSnapshot.visitorData, sessionSnapshot.dataSyncId);
                String strRemovePrefix = StringsKt.removePrefix(str2, "VL");
                str.getClass();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                httpRequestBuilder.setBody(new EditPlaylistBody(context, strRemovePrefix, CollectionsKt__IterablesKt.listOf(new JsonObject(linkedHashMap))));
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(EditPlaylistBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(EditPlaylistBody.class);
                    break;
                } catch (Throwable unused) {
                    typeReferenceTypeOf = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
                this.L$0 = null;
                this.label = true;
                Object objExecute = httpStatementM.execute(this);
                return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
            case 1:
                InnerTube.SessionSnapshot sessionSnapshot2 = (InnerTube.SessionSnapshot) this.L$0;
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                InnerTube innerTube2 = this.this$0;
                HttpClient httpClient2 = innerTube2.httpClient;
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                httpRequestBuilder2.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder2, "browse/edit_playlist");
                YouTubeClient youTubeClient2 = this.$client;
                InnerTube.ytClient$default(innerTube2, httpRequestBuilder2, youTubeClient2, sessionSnapshot2, true, null, false, 24);
                Context context2 = youTubeClient2.toContext(sessionSnapshot2.locale, sessionSnapshot2.visitorData, sessionSnapshot2.dataSyncId);
                String strRemovePrefix2 = StringsKt.removePrefix(str2, "VL");
                str.getClass();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                httpRequestBuilder2.setBody(new EditPlaylistBody(context2, strRemovePrefix2, CollectionsKt__IterablesKt.listOf(new JsonObject(linkedHashMap2))));
                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(EditPlaylistBody.class);
                try {
                    typeReferenceTypeOf2 = Reflection.typeOf(EditPlaylistBody.class);
                    break;
                } catch (Throwable unused2) {
                    typeReferenceTypeOf2 = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass2, false, typeReferenceTypeOf2, httpRequestBuilder2);
                HttpStatement httpStatementM2 = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder2, HttpMethod.Post, httpRequestBuilder2, httpClient2);
                this.L$0 = null;
                this.label = true;
                Object objExecute2 = httpStatementM2.execute(this);
                return objExecute2 == coroutineSingletons ? coroutineSingletons : objExecute2;
            case 2:
                InnerTube.SessionSnapshot sessionSnapshot3 = (InnerTube.SessionSnapshot) this.L$0;
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                InnerTube innerTube3 = this.this$0;
                HttpClient httpClient3 = innerTube3.httpClient;
                HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
                httpRequestBuilder3.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder3, "browse/edit_playlist");
                YouTubeClient youTubeClient3 = this.$client;
                InnerTube.ytClient$default(innerTube3, httpRequestBuilder3, youTubeClient3, sessionSnapshot3, true, null, false, 24);
                Context context3 = youTubeClient3.toContext(sessionSnapshot3.locale, sessionSnapshot3.visitorData, sessionSnapshot3.dataSyncId);
                String strRemovePrefix3 = StringsKt.removePrefix(str2, "VL");
                str.getClass();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                httpRequestBuilder3.setBody(new EditPlaylistBody(context3, strRemovePrefix3, CollectionsKt__IterablesKt.listOf(new JsonObject(linkedHashMap3))));
                ClassReference orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(EditPlaylistBody.class);
                try {
                    typeReferenceTypeOf3 = Reflection.typeOf(EditPlaylistBody.class);
                    break;
                } catch (Throwable unused3) {
                    typeReferenceTypeOf3 = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, false, typeReferenceTypeOf3, httpRequestBuilder3);
                HttpStatement httpStatementM3 = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder3, HttpMethod.Post, httpRequestBuilder3, httpClient3);
                this.L$0 = null;
                this.label = true;
                Object objExecute3 = httpStatementM3.execute(this);
                return objExecute3 == coroutineSingletons ? coroutineSingletons : objExecute3;
            case 3:
                InnerTube.SessionSnapshot sessionSnapshot4 = (InnerTube.SessionSnapshot) this.L$0;
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                InnerTube innerTube4 = this.this$0;
                HttpClient httpClient4 = innerTube4.httpClient;
                HttpRequestBuilder httpRequestBuilder4 = new HttpRequestBuilder();
                httpRequestBuilder4.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder4, "subscription/subscribe");
                YouTubeClient youTubeClient4 = this.$client;
                InnerTube.ytClient$default(innerTube4, httpRequestBuilder4, youTubeClient4, sessionSnapshot4, true, null, false, 24);
                httpRequestBuilder4.setBody(new SubscribeBody(youTubeClient4.toContext(sessionSnapshot4.locale, sessionSnapshot4.visitorData, sessionSnapshot4.dataSyncId), str, CollectionsKt__IterablesKt.listOf(str2)));
                ClassReference orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(SubscribeBody.class);
                try {
                    typeReferenceTypeOf4 = Reflection.typeOf(SubscribeBody.class);
                    break;
                } catch (Throwable unused4) {
                    typeReferenceTypeOf4 = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass4, false, typeReferenceTypeOf4, httpRequestBuilder4);
                HttpStatement httpStatementM4 = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder4, HttpMethod.Post, httpRequestBuilder4, httpClient4);
                this.L$0 = null;
                this.label = true;
                Object objExecute4 = httpStatementM4.execute(this);
                return objExecute4 == coroutineSingletons ? coroutineSingletons : objExecute4;
            default:
                InnerTube.SessionSnapshot sessionSnapshot5 = (InnerTube.SessionSnapshot) this.L$0;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                InnerTube innerTube5 = this.this$0;
                HttpClient httpClient5 = innerTube5.httpClient;
                HttpRequestBuilder httpRequestBuilder5 = new HttpRequestBuilder();
                httpRequestBuilder5.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder5, "subscription/unsubscribe");
                YouTubeClient youTubeClient5 = this.$client;
                InnerTube.ytClient$default(innerTube5, httpRequestBuilder5, youTubeClient5, sessionSnapshot5, true, null, false, 24);
                httpRequestBuilder5.setBody(new SubscribeBody(youTubeClient5.toContext(sessionSnapshot5.locale, sessionSnapshot5.visitorData, sessionSnapshot5.dataSyncId), str, CollectionsKt__IterablesKt.listOf(str2)));
                ClassReference orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(SubscribeBody.class);
                try {
                    typeReferenceTypeOf5 = Reflection.typeOf(SubscribeBody.class);
                    break;
                } catch (Throwable unused5) {
                    typeReferenceTypeOf5 = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, false, typeReferenceTypeOf5, httpRequestBuilder5);
                HttpStatement httpStatementM5 = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder5, HttpMethod.Post, httpRequestBuilder5, httpClient5);
                this.L$0 = null;
                this.label = true;
                Object objExecute5 = httpStatementM5.execute(this);
                return objExecute5 == coroutineSingletons ? coroutineSingletons : objExecute5;
        }
    }
}
