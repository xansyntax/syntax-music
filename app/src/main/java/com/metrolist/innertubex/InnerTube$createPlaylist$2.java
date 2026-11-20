package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.CreatePlaylistBody;
import com.metrolist.innertubex.models.body.DeletePrivatelyOwnedEntityBody;
import com.metrolist.innertubex.models.body.EditPlaylistBody;
import com.metrolist.innertubex.models.body.PlaylistDeleteBody;
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
public final class InnerTube$createPlaylist$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String $title;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$createPlaylist$2(InnerTube innerTube, YouTubeClient youTubeClient, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$title = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                InnerTube$createPlaylist$2 innerTube$createPlaylist$2 = new InnerTube$createPlaylist$2(this.this$0, this.$client, this.$title, continuation, (byte) 0);
                innerTube$createPlaylist$2.L$0 = obj;
                return innerTube$createPlaylist$2;
            case 1:
                InnerTube$createPlaylist$2 innerTube$createPlaylist$3 = new InnerTube$createPlaylist$2(this.this$0, this.$client, this.$title, continuation, (byte) 1);
                innerTube$createPlaylist$3.L$0 = obj;
                return innerTube$createPlaylist$3;
            case 2:
                InnerTube$createPlaylist$2 innerTube$createPlaylist$4 = new InnerTube$createPlaylist$2(this.this$0, this.$client, this.$title, continuation, (byte) 2);
                innerTube$createPlaylist$4.L$0 = obj;
                return innerTube$createPlaylist$4;
            default:
                InnerTube$createPlaylist$2 innerTube$createPlaylist$5 = new InnerTube$createPlaylist$2(this.this$0, this.$client, this.$title, continuation, (byte) 3);
                innerTube$createPlaylist$5.L$0 = obj;
                return innerTube$createPlaylist$5;
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
        }
        return ((InnerTube$createPlaylist$2) create(sessionSnapshot, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TypeReference typeReferenceTypeOf;
        TypeReference typeReferenceTypeOf2;
        TypeReference typeReferenceTypeOf3;
        TypeReference typeReferenceTypeOf4;
        byte b = this.$r8$classId;
        String str = this.$title;
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
                HttpRequestKt.url(httpRequestBuilder, "playlist/create");
                YouTubeClient youTubeClient = this.$client;
                InnerTube.ytClient$default(innerTube, httpRequestBuilder, youTubeClient, sessionSnapshot, true, null, false, 24);
                httpRequestBuilder.setBody(new CreatePlaylistBody(youTubeClient.toContext(sessionSnapshot.locale, sessionSnapshot.visitorData, sessionSnapshot.dataSyncId), str));
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CreatePlaylistBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(CreatePlaylistBody.class);
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
                HttpRequestKt.url(httpRequestBuilder2, "playlist/delete");
                YouTubeClient youTubeClient2 = this.$client;
                InnerTube.ytClient$default(innerTube2, httpRequestBuilder2, youTubeClient2, sessionSnapshot2, true, null, false, 24);
                httpRequestBuilder2.setBody(new PlaylistDeleteBody(youTubeClient2.toContext(sessionSnapshot2.locale, sessionSnapshot2.visitorData, sessionSnapshot2.dataSyncId), StringsKt.removePrefix(str, "VL")));
                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(PlaylistDeleteBody.class);
                try {
                    typeReferenceTypeOf2 = Reflection.typeOf(PlaylistDeleteBody.class);
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
                HttpRequestKt.url(httpRequestBuilder3, "music/delete_privately_owned_entity");
                YouTubeClient youTubeClient3 = this.$client;
                InnerTube.ytClient$default(innerTube3, httpRequestBuilder3, youTubeClient3, sessionSnapshot3, true, null, false, 24);
                httpRequestBuilder3.setBody(new DeletePrivatelyOwnedEntityBody(youTubeClient3.toContext(sessionSnapshot3.locale, sessionSnapshot3.visitorData, sessionSnapshot3.dataSyncId), str));
                ClassReference orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(DeletePrivatelyOwnedEntityBody.class);
                try {
                    typeReferenceTypeOf3 = Reflection.typeOf(DeletePrivatelyOwnedEntityBody.class);
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
            default:
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
                HttpRequestKt.url(httpRequestBuilder4, "browse/edit_playlist");
                YouTubeClient youTubeClient4 = this.$client;
                InnerTube.ytClient$default(innerTube4, httpRequestBuilder4, youTubeClient4, sessionSnapshot4, true, null, false, 24);
                Context context = youTubeClient4.toContext(sessionSnapshot4.locale, sessionSnapshot4.visitorData, sessionSnapshot4.dataSyncId);
                String strRemovePrefix = StringsKt.removePrefix(str, "VL");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                httpRequestBuilder4.setBody(new EditPlaylistBody(context, strRemovePrefix, CollectionsKt__IterablesKt.listOf(new JsonObject(linkedHashMap))));
                ClassReference orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(EditPlaylistBody.class);
                try {
                    typeReferenceTypeOf4 = Reflection.typeOf(EditPlaylistBody.class);
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
        }
    }
}
