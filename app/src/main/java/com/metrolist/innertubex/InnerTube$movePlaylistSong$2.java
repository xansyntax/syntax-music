package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.EditPlaylistBody;
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
public final class InnerTube$movePlaylistSong$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $playlistId;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String $setVideoId;
    public final /* synthetic */ String $successorSetVideoId;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$movePlaylistSong$2(InnerTube innerTube, YouTubeClient youTubeClient, String str, String str2, String str3, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$playlistId = str;
        this.$setVideoId = str2;
        this.$successorSetVideoId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                InnerTube$movePlaylistSong$2 innerTube$movePlaylistSong$2 = new InnerTube$movePlaylistSong$2(this.this$0, this.$client, this.$playlistId, this.$setVideoId, this.$successorSetVideoId, continuation, (byte) 0);
                innerTube$movePlaylistSong$2.L$0 = obj;
                return innerTube$movePlaylistSong$2;
            default:
                InnerTube$movePlaylistSong$2 innerTube$movePlaylistSong$3 = new InnerTube$movePlaylistSong$2(this.this$0, this.$client, this.$playlistId, this.$setVideoId, this.$successorSetVideoId, continuation, (byte) 1);
                innerTube$movePlaylistSong$3.L$0 = obj;
                return innerTube$movePlaylistSong$3;
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
        }
        return ((InnerTube$movePlaylistSong$2) create(sessionSnapshot, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TypeReference typeReferenceTypeOf;
        TypeReference typeReferenceTypeOf2;
        byte b = this.$r8$classId;
        String str = this.$successorSetVideoId;
        String str2 = this.$setVideoId;
        String str3 = this.$playlistId;
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
                String strRemovePrefix = StringsKt.removePrefix(str3, "VL");
                str2.getClass();
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
            default:
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
                String strRemovePrefix2 = StringsKt.removePrefix(str3, "VL");
                str2.getClass();
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
        }
    }
}
