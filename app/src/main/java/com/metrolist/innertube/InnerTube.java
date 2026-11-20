package com.metrolist.innertube;

import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.MediaInfo;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.ReturnYouTubeDislikeResponse;
import com.metrolist.innertube.models.Thumbnail;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults;
import com.metrolist.innertube.models.response.NextResponse;
import com.metrolist.innertubex.InnerTube$accountMenu$2;
import com.metrolist.innertubex.InnerTube$addToPlaylist$2;
import com.metrolist.innertubex.InnerTube$browse$2;
import com.metrolist.innertubex.InnerTube$createPlaylist$2;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.innertubex.InnerTube$likePlaylist$2;
import com.metrolist.innertubex.InnerTube$likeVideo$3;
import com.metrolist.innertubex.InnerTube$movePlaylistSong$2;
import com.metrolist.innertubex.InnerTube$next$2;
import com.metrolist.innertubex.InnerTube$registerStatsWithSession$2;
import com.metrolist.innertubex.InnerTube$unlikePlaylist$3;
import com.metrolist.innertubex.InnerTube$unlikeVideo$3;
import com.metrolist.innertubex.InnerTubeHttpException;
import com.metrolist.innertubex.models.YouTubeClient;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.LinkHeader;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.io.IOException;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube {
    public Proxy configuredProxy;
    public String configuredProxyAuth;
    public HttpClient httpClient;
    public com.metrolist.innertubex.InnerTube innerTubeX;
    public long transportGeneration;

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$accountMenu$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public InnerTube L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.accountMenu(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$accountsList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00611 extends ContinuationImpl {
        public InnerTube L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00611(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.accountsList(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$addToPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00621 extends ContinuationImpl {
        public InnerTube L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00621(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.addToPlaylist(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$createPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00631 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00631(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.createPlaylist(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$deletePlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00641 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00641(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.deletePlaylist(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$deletePrivatelyOwnedEntity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00651 extends ContinuationImpl {
        public InnerTube L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00651(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.deletePrivatelyOwnedEntity(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$feedback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00661 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00661(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.feedback(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$likePlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00671 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00671(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.likePlaylist(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$likeVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00681 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00681(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.likeVideo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$moveSongPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00691 extends ContinuationImpl {
        public InnerTube L$4;
        public int label;
        public /* synthetic */ Object result;

        public C00691(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.moveSongPlaylist(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$registerPlayback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00701 extends ContinuationImpl {
        public InnerTube L$4;
        public int label;
        public /* synthetic */ Object result;

        public C00701(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.registerPlayback(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$removeFromPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00711 extends ContinuationImpl {
        public InnerTube L$4;
        public int label;
        public /* synthetic */ Object result;

        public C00711(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.removeFromPlaylist(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$removePlaylistThumbnail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00721 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00721(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.removePlaylistThumbnail(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$renamePlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00731 extends ContinuationImpl {
        public InnerTube L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00731(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.renamePlaylist(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$requireSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00741 extends ContinuationImpl {
        public HttpResponse L$0;
        public String L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00741(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.requireSuccess(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$setPlaylistThumbnail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00751 extends ContinuationImpl {
        public InnerTube L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00751(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.setPlaylistThumbnail(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$subscribeChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00761 extends ContinuationImpl {
        public InnerTube L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00761(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.subscribeChannel(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$unlikePlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00771 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00771(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.unlikePlaylist(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$unlikeVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00781 extends ContinuationImpl {
        public InnerTube L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00781(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.unlikeVideo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$unsubscribeChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00791 extends ContinuationImpl {
        public InnerTube L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00791(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.unsubscribeChannel(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.InnerTube$withRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00801 extends ContinuationImpl {
        public double D$0;
        public byte I$0;
        public int I$1;
        public short J$0;
        public long J$1;
        public Function1 L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00801(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InnerTube.this.withRetry(0, 0L, 0.0d, null, this);
        }
    }

    public static Object browse$default(InnerTube innerTube, YouTubeClient youTubeClient, String str, String str2, String str3, boolean z, ContinuationImpl continuationImpl, int i) {
        String str4 = (i & 2) != 0 ? null : str;
        String str5 = (i & 4) != 0 ? null : str2;
        String str6 = (i & 8) != 0 ? null : str3;
        boolean z2 = (i & 16) != 0 ? false : z;
        com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot = innerTube2.sessionSnapshot();
        return com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube2, "browse", new InnerTube$browse$2(innerTube2, youTubeClient, sessionSnapshot, z2 || sessionSnapshot.useLoginForBrowse, !sessionSnapshot.regionOverrideActive ? sessionSnapshot.visitorData : null, str4, str5, str6, null, (byte) 0), continuationImpl, 62);
    }

    public static Object search$default(InnerTube innerTube, YouTubeClient youTubeClient, String str, String str2, String str3, boolean z, ContinuationImpl continuationImpl, int i) {
        String str4 = (i & 2) != 0 ? null : str;
        String str5 = (i & 4) != 0 ? null : str2;
        String str6 = (i & 8) != 0 ? null : str3;
        com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot = innerTube2.sessionSnapshot();
        return com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube2, "search", new InnerTube$browse$2(innerTube2, youTubeClient, sessionSnapshot, z, !sessionSnapshot.regionOverrideActive ? sessionSnapshot.visitorData : null, str4, str5, str6, null, (byte) 1), continuationImpl, 62);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object accountMenu(YouTubeClient youTubeClient, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
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
        Object objExecuteRequest$default = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteRequest$default);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            anonymousClass1.L$1 = this;
            anonymousClass1.label = 1;
            objExecuteRequest$default = com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube, "accountMenu", new InnerTube$accountMenu$2(innerTube, youTubeClient, innerTube.sessionSnapshot(), continuation, (byte) 0), anonymousClass1, 58);
            if (objExecuteRequest$default != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteRequest$default);
                return objExecuteRequest$default;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = anonymousClass1.L$1;
        ResultKt.throwOnFailure(objExecuteRequest$default);
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteRequest$default, "accountMenu", anonymousClass1);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object accountsList(ContinuationImpl continuationImpl) {
        C00611 c00611;
        if (continuationImpl instanceof C00611) {
            c00611 = (C00611) continuationImpl;
            int i = c00611.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00611.label = i - Integer.MIN_VALUE;
            } else {
                c00611 = new C00611(continuationImpl);
            }
        } else {
            c00611 = new C00611(continuationImpl);
        }
        Object objExecuteRequest$default = c00611.result;
        int i2 = c00611.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteRequest$default);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            YouTubeClient.INSTANCE.getClass();
            YouTubeClient youTubeClient = YouTubeClient.WEB;
            c00611.L$0 = this;
            c00611.label = 1;
            objExecuteRequest$default = com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube, "accountsList", new InnerTube$accountMenu$2(innerTube, youTubeClient, innerTube.sessionSnapshot(), continuation, (byte) 1), c00611, 58);
            if (objExecuteRequest$default != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteRequest$default);
                return objExecuteRequest$default;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00611.L$0;
        ResultKt.throwOnFailure(objExecuteRequest$default);
        c00611.L$0 = null;
        c00611.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteRequest$default, "accountsList", c00611);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object addToPlaylist(YouTubeClient youTubeClient, String str, String str2, ContinuationImpl continuationImpl) {
        C00621 c00621;
        InnerTube innerTube = this;
        if (continuationImpl instanceof C00621) {
            c00621 = (C00621) continuationImpl;
            int i = c00621.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00621.label = i - Integer.MIN_VALUE;
            } else {
                c00621 = innerTube.new C00621(continuationImpl);
            }
        } else {
            c00621 = innerTube.new C00621(continuationImpl);
        }
        Object objExecuteMutation = c00621.result;
        int i2 = c00621.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            c00621.L$3 = innerTube;
            c00621.label = 1;
            innerTube2.getClass();
            objExecuteMutation = innerTube2.executeMutation("addToPlaylist", innerTube2.sessionSnapshot(), new InnerTube$addToPlaylist$2(innerTube2, youTubeClient, str, str2, null, (byte) 0), c00621);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = c00621.L$3;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00621.L$3 = null;
        c00621.label = 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) objExecuteMutation, "addToPlaylist", c00621);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object createPlaylist(YouTubeClient youTubeClient, String str, ContinuationImpl continuationImpl) {
        C00631 c00631;
        if (continuationImpl instanceof C00631) {
            c00631 = (C00631) continuationImpl;
            int i = c00631.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00631.label = i - Integer.MIN_VALUE;
            } else {
                c00631 = new C00631(continuationImpl);
            }
        } else {
            c00631 = new C00631(continuationImpl);
        }
        Object objExecuteMutation = c00631.result;
        int i2 = c00631.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00631.L$2 = this;
            c00631.label = 1;
            innerTube.getClass();
            objExecuteMutation = innerTube.executeMutation("createPlaylist", innerTube.sessionSnapshot(), new InnerTube$createPlaylist$2(innerTube, youTubeClient, str, continuation, (byte) 0), c00631);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00631.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00631.L$2 = null;
        c00631.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "createPlaylist", c00631);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object deletePlaylist(YouTubeClient youTubeClient, String str, ContinuationImpl continuationImpl) {
        C00641 c00641;
        if (continuationImpl instanceof C00641) {
            c00641 = (C00641) continuationImpl;
            int i = c00641.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00641.label = i - Integer.MIN_VALUE;
            } else {
                c00641 = new C00641(continuationImpl);
            }
        } else {
            c00641 = new C00641(continuationImpl);
        }
        Object objExecuteMutation = c00641.result;
        int i2 = c00641.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00641.L$2 = this;
            c00641.label = 1;
            objExecuteMutation = innerTube.executeMutation("deletePlaylist", innerTube.sessionSnapshot(), new InnerTube$createPlaylist$2(innerTube, youTubeClient, str, continuation, (byte) 1), c00641);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00641.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00641.L$2 = null;
        c00641.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "deletePlaylist", c00641);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object deletePrivatelyOwnedEntity(String str, ContinuationImpl continuationImpl) {
        C00651 c00651;
        if (continuationImpl instanceof C00651) {
            c00651 = (C00651) continuationImpl;
            int i = c00651.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00651.label = i - Integer.MIN_VALUE;
            } else {
                c00651 = new C00651(continuationImpl);
            }
        } else {
            c00651 = new C00651(continuationImpl);
        }
        Object objExecuteMutation = c00651.result;
        int i2 = c00651.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            YouTubeClient.INSTANCE.getClass();
            YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
            c00651.L$1 = this;
            c00651.label = 1;
            innerTube.getClass();
            objExecuteMutation = innerTube.executeMutation("deletePrivatelyOwnedEntity", innerTube.sessionSnapshot(), new InnerTube$createPlaylist$2(innerTube, youTubeClient, str, continuation, (byte) 2), c00651);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00651.L$1;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00651.L$1 = null;
        c00651.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "deletePrivatelyOwnedEntity", c00651);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object feedback(YouTubeClient youTubeClient, List list, ContinuationImpl continuationImpl) {
        C00661 c00661;
        if (continuationImpl instanceof C00661) {
            c00661 = (C00661) continuationImpl;
            int i = c00661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00661.label = i - Integer.MIN_VALUE;
            } else {
                c00661 = new C00661(continuationImpl);
            }
        } else {
            c00661 = new C00661(continuationImpl);
        }
        Object objExecuteMutation = c00661.result;
        int i2 = c00661.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00661.L$2 = this;
            c00661.label = 1;
            objExecuteMutation = innerTube.executeMutation("feedback", innerTube.sessionSnapshot(), new InnerTube$feedback$2((Object) innerTube, (Object) youTubeClient, (Object) list, continuation, (byte) 0), c00661);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00661.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00661.L$2 = null;
        c00661.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "feedback", c00661);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:156:0x020c  */
    /* JADX WARN: Code duplicated, block: B:180:0x0267 A[Catch: all -> 0x026f, TryCatch #2 {all -> 0x026f, blocks: (B:16:0x003a, B:98:0x0172, B:100:0x0176, B:102:0x017a, B:104:0x017e, B:106:0x0186, B:109:0x018f, B:111:0x0193, B:113:0x0197, B:115:0x019b, B:117:0x019f, B:119:0x01a7, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:128:0x01bc, B:130:0x01c0, B:133:0x01c9, B:135:0x01cd, B:137:0x01d1, B:139:0x01d5, B:141:0x01d9, B:142:0x01dd, B:144:0x01e3, B:147:0x01ef, B:151:0x01f9, B:153:0x01fd, B:155:0x0201, B:158:0x0210, B:160:0x0214, B:163:0x021d, B:165:0x0221, B:167:0x0225, B:169:0x0229, B:171:0x022d, B:174:0x0245, B:176:0x0249, B:177:0x024b, B:178:0x025f, B:179:0x0266, B:21:0x004c, B:90:0x0148, B:94:0x015a, B:24:0x005d, B:42:0x00b8, B:44:0x00c0, B:46:0x00c4, B:48:0x00c8, B:50:0x00cc, B:51:0x00d0, B:53:0x00d6, B:55:0x00df, B:60:0x00e7, B:62:0x00eb, B:64:0x00ef, B:66:0x00f3, B:68:0x00f7, B:70:0x00fb, B:72:0x00ff, B:73:0x0103, B:75:0x0109, B:77:0x0112, B:82:0x011a, B:84:0x011e, B:86:0x0122, B:180:0x0267, B:181:0x026e, B:27:0x0066, B:34:0x008d, B:38:0x009f, B:30:0x006d), top: B:189:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b8 A[Catch: all -> 0x026f, TryCatch #2 {all -> 0x026f, blocks: (B:16:0x003a, B:98:0x0172, B:100:0x0176, B:102:0x017a, B:104:0x017e, B:106:0x0186, B:109:0x018f, B:111:0x0193, B:113:0x0197, B:115:0x019b, B:117:0x019f, B:119:0x01a7, B:122:0x01b0, B:124:0x01b4, B:126:0x01b8, B:128:0x01bc, B:130:0x01c0, B:133:0x01c9, B:135:0x01cd, B:137:0x01d1, B:139:0x01d5, B:141:0x01d9, B:142:0x01dd, B:144:0x01e3, B:147:0x01ef, B:151:0x01f9, B:153:0x01fd, B:155:0x0201, B:158:0x0210, B:160:0x0214, B:163:0x021d, B:165:0x0221, B:167:0x0225, B:169:0x0229, B:171:0x022d, B:174:0x0245, B:176:0x0249, B:177:0x024b, B:178:0x025f, B:179:0x0266, B:21:0x004c, B:90:0x0148, B:94:0x015a, B:24:0x005d, B:42:0x00b8, B:44:0x00c0, B:46:0x00c4, B:48:0x00c8, B:50:0x00cc, B:51:0x00d0, B:53:0x00d6, B:55:0x00df, B:60:0x00e7, B:62:0x00eb, B:64:0x00ef, B:66:0x00f3, B:68:0x00f7, B:70:0x00fb, B:72:0x00ff, B:73:0x0103, B:75:0x0109, B:77:0x0112, B:82:0x011a, B:84:0x011e, B:86:0x0122, B:180:0x0267, B:181:0x026e, B:27:0x0066, B:34:0x008d, B:38:0x009f, B:30:0x006d), top: B:189:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x0121  */
    /* JADX WARN: Code duplicated, block: B:88:0x0141  */
    /* JADX WARN: Code duplicated, block: B:89:0x0142  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x016d, code lost:
    
        if (r1 == r14) goto L96;
     */
    /* JADX INFO: renamed from: getMediaInfo-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m985getMediaInfogIAlus(String str, ContinuationImpl continuationImpl) {
        InnerTube$getMediaInfo$1 innerTube$getMediaInfo$1;
        InnerTube innerTube;
        String str2;
        TypeReference typeReferenceTypeOf;
        InnerTube innerTube2;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults youTubeDataPage$Contents$TwoColumnWatchNextResults;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer videoSecondaryInfoRenderer;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults youTubeDataPage$Contents$TwoColumnWatchNextResults2;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer videoPrimaryInfoRenderer;
        Object objWithRetry;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer videoSecondaryInfoRenderer2;
        String str3;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results results;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results c0002Results;
        List list;
        Object next;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content content;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results results2;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results c0002Results2;
        List list2;
        Object next2;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content content2;
        TypeReference typeReferenceTypeOf2;
        String strReplace;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.DateText dateText;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner owner;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer videoOwnerRenderer;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.SubscriberCountText subscriberCountText;
        String str4;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.AttributedDescription attributedDescription;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner owner2;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer videoOwnerRenderer2;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail thumbnail;
        List list3;
        Object next3;
        String str5;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner owner3;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer videoOwnerRenderer3;
        NavigationEndpoint navigationEndpoint;
        BrowseEndpoint browseEndpoint;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner owner4;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer videoOwnerRenderer4;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title title;
        List list4;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title.Run run;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title title2;
        List list5;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title.Run run2;
        if (continuationImpl instanceof InnerTube$getMediaInfo$1) {
            innerTube$getMediaInfo$1 = (InnerTube$getMediaInfo$1) continuationImpl;
            int i = innerTube$getMediaInfo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                innerTube$getMediaInfo$1.label = i - Integer.MIN_VALUE;
            } else {
                innerTube$getMediaInfo$1 = new InnerTube$getMediaInfo$1(this, continuationImpl);
            }
        } else {
            innerTube$getMediaInfo$1 = new InnerTube$getMediaInfo$1(this, continuationImpl);
        }
        InnerTube$getMediaInfo$1 innerTube$getMediaInfo$2 = innerTube$getMediaInfo$1;
        Object next4 = innerTube$getMediaInfo$2.result;
        int i2 = innerTube$getMediaInfo$2.label;
        String str6 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(next4);
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB;
                    innerTube$getMediaInfo$2.L$0 = str;
                    innerTube$getMediaInfo$2.L$1 = this;
                    innerTube$getMediaInfo$2.label = 1;
                    next4 = next(youTubeClient, str, null, null, null, null, null, innerTube$getMediaInfo$2);
                    if (next4 != coroutineSingletons) {
                        innerTube = this;
                        str2 = str;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    innerTube = innerTube$getMediaInfo$2.L$1;
                    str2 = innerTube$getMediaInfo$2.L$0;
                    ResultKt.throwOnFailure(next4);
                } else {
                    if (i2 == 2) {
                        innerTube = innerTube$getMediaInfo$2.L$1;
                        str2 = innerTube$getMediaInfo$2.L$0;
                        ResultKt.throwOnFailure(next4);
                        innerTube2 = innerTube;
                        if (next4 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.NextResponse");
                        }
                        NextResponse.Contents contents = ((NextResponse) next4).contents;
                        youTubeDataPage$Contents$TwoColumnWatchNextResults = contents.twoColumnWatchNextResults;
                        if (youTubeDataPage$Contents$TwoColumnWatchNextResults != null || (results2 = youTubeDataPage$Contents$TwoColumnWatchNextResults.results) == null || (c0002Results2 = results2.results) == null || (list2 = c0002Results2.content) == null) {
                            videoSecondaryInfoRenderer = null;
                        } else {
                            Iterator it = list2.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it.next();
                                content2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content) next2;
                            } while ((content2 != null ? content2.videoSecondaryInfoRenderer : null) == null);
                            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content content3 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content) next2;
                            if (content3 != null) {
                                videoSecondaryInfoRenderer = content3.videoSecondaryInfoRenderer;
                            } else {
                                videoSecondaryInfoRenderer = null;
                            }
                        }
                        youTubeDataPage$Contents$TwoColumnWatchNextResults2 = contents.twoColumnWatchNextResults;
                        if (youTubeDataPage$Contents$TwoColumnWatchNextResults2 != null || (results = youTubeDataPage$Contents$TwoColumnWatchNextResults2.results) == null || (c0002Results = results.results) == null || (list = c0002Results.content) == null) {
                            videoPrimaryInfoRenderer = null;
                        } else {
                            Iterator it2 = list.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                                content = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content) next;
                            } while ((content != null ? content.videoPrimaryInfoRenderer : null) == null);
                            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content content4 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content) next;
                            if (content4 != null) {
                                videoPrimaryInfoRenderer = content4.videoPrimaryInfoRenderer;
                            } else {
                                videoPrimaryInfoRenderer = null;
                            }
                        }
                        innerTube$getMediaInfo$2.L$0 = str2;
                        innerTube$getMediaInfo$2.L$1 = null;
                        innerTube$getMediaInfo$2.L$2 = videoSecondaryInfoRenderer;
                        innerTube$getMediaInfo$2.L$3 = videoPrimaryInfoRenderer;
                        innerTube$getMediaInfo$2.label = 3;
                        innerTube2.getClass();
                        objWithRetry = innerTube2.withRetry(3, 500L, 2.0d, new InnerTube$returnYouTubeDislike$2(innerTube2, str2, null), innerTube$getMediaInfo$2);
                        innerTube$getMediaInfo$2 = innerTube$getMediaInfo$2;
                        if (objWithRetry == coroutineSingletons) {
                            String str7 = str2;
                            videoSecondaryInfoRenderer2 = videoSecondaryInfoRenderer;
                            next4 = objWithRetry;
                            str3 = str7;
                            HttpClientCall call = ((HttpResponse) next4).getCall();
                            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ReturnYouTubeDislikeResponse.class);
                            typeReferenceTypeOf2 = Reflection.typeOf(ReturnYouTubeDislikeResponse.class);
                            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf2);
                            innerTube$getMediaInfo$2.L$0 = str3;
                            innerTube$getMediaInfo$2.L$1 = null;
                            innerTube$getMediaInfo$2.L$2 = videoSecondaryInfoRenderer2;
                            innerTube$getMediaInfo$2.L$3 = videoPrimaryInfoRenderer;
                            innerTube$getMediaInfo$2.label = 4;
                            next4 = call.bodyNullable(typeInfo, innerTube$getMediaInfo$2);
                        }
                        return coroutineSingletons;
                    }
                    if (i2 == 3) {
                        videoPrimaryInfoRenderer = innerTube$getMediaInfo$2.L$3;
                        videoSecondaryInfoRenderer2 = innerTube$getMediaInfo$2.L$2;
                        str3 = innerTube$getMediaInfo$2.L$0;
                        ResultKt.throwOnFailure(next4);
                        HttpClientCall call2 = ((HttpResponse) next4).getCall();
                        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ReturnYouTubeDislikeResponse.class);
                        try {
                            typeReferenceTypeOf2 = Reflection.typeOf(ReturnYouTubeDislikeResponse.class);
                        } catch (Throwable unused) {
                            typeReferenceTypeOf2 = null;
                        }
                        TypeInfo typeInfo2 = new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf2);
                        innerTube$getMediaInfo$2.L$0 = str3;
                        innerTube$getMediaInfo$2.L$1 = null;
                        innerTube$getMediaInfo$2.L$2 = videoSecondaryInfoRenderer2;
                        innerTube$getMediaInfo$2.L$3 = videoPrimaryInfoRenderer;
                        innerTube$getMediaInfo$2.label = 4;
                        next4 = call2.bodyNullable(typeInfo2, innerTube$getMediaInfo$2);
                    } else {
                        if (i2 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        videoPrimaryInfoRenderer = innerTube$getMediaInfo$2.L$3;
                        videoSecondaryInfoRenderer2 = innerTube$getMediaInfo$2.L$2;
                        str3 = innerTube$getMediaInfo$2.L$0;
                        ResultKt.throwOnFailure(next4);
                    }
                }
                String str8 = str3;
                if (next4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.ReturnYouTubeDislikeResponse");
                }
                ReturnYouTubeDislikeResponse returnYouTubeDislikeResponse = (ReturnYouTubeDislikeResponse) next4;
                String str9 = (videoPrimaryInfoRenderer == null || (title2 = videoPrimaryInfoRenderer.title) == null || (list5 = title2.runs) == null || (run2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title.Run) CollectionsKt.firstOrNull(list5)) == null) ? null : run2.text;
                String str10 = (videoSecondaryInfoRenderer2 == null || (owner4 = videoSecondaryInfoRenderer2.owner) == null || (videoOwnerRenderer4 = owner4.videoOwnerRenderer) == null || (title = videoOwnerRenderer4.title) == null || (list4 = title.runs) == null || (run = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title.Run) CollectionsKt.firstOrNull(list4)) == null) ? null : run.text;
                String str11 = (videoSecondaryInfoRenderer2 == null || (owner3 = videoSecondaryInfoRenderer2.owner) == null || (videoOwnerRenderer3 = owner3.videoOwnerRenderer) == null || (navigationEndpoint = videoOwnerRenderer3.navigationEndpoint) == null || (browseEndpoint = navigationEndpoint.browseEndpoint) == null) ? null : browseEndpoint.browseId;
                if (videoSecondaryInfoRenderer2 == null || (owner2 = videoSecondaryInfoRenderer2.owner) == null || (videoOwnerRenderer2 = owner2.videoOwnerRenderer) == null || (thumbnail = videoOwnerRenderer2.thumbnail) == null || (list3 = thumbnail.thumbnails) == null) {
                    strReplace = null;
                } else {
                    Iterator it3 = list3.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it3.next();
                        Integer num = ((Thumbnail) next3).height;
                        if (num != null && num.intValue() == 48) {
                            break;
                        }
                    }
                    Thumbnail thumbnail2 = (Thumbnail) next3;
                    if (thumbnail2 == null || (str5 = thumbnail2.url) == null) {
                        strReplace = null;
                    } else {
                        strReplace = StringsKt__StringsJVMKt.replace(str5, "s48", "s960", false);
                    }
                }
                String str12 = (videoSecondaryInfoRenderer2 == null || (attributedDescription = videoSecondaryInfoRenderer2.attributedDescription) == null) ? null : attributedDescription.content;
                String str13 = (videoSecondaryInfoRenderer2 == null || (owner = videoSecondaryInfoRenderer2.owner) == null || (videoOwnerRenderer = owner.videoOwnerRenderer) == null || (subscriberCountText = videoOwnerRenderer.subscriberCountText) == null || (str4 = subscriberCountText.simpleText) == null) ? null : (String) CollectionsKt.firstOrNull(StringsKt.split$default(str4, new String[]{ServerSentEventKt.SPACE}, 0, 6));
                if (videoPrimaryInfoRenderer != null && (dateText = videoPrimaryInfoRenderer.dateText) != null) {
                    str6 = dateText.simpleText;
                }
                return new MediaInfo(str8, str9, str10, str11, strReplace, str12, str6, str13, returnYouTubeDislikeResponse.viewCount, returnYouTubeDislikeResponse.likes, returnYouTubeDislikeResponse.dislikes);
                typeReferenceTypeOf = Reflection.typeOf(NextResponse.class);
            } catch (Throwable unused2) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call3 = ((HttpResponse) next4).getCall();
            ClassReference orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(NextResponse.class);
            TypeInfo typeInfo3 = new TypeInfo((KClass<?>) orCreateKotlinClass3, false, (KType) typeReferenceTypeOf);
            innerTube$getMediaInfo$2.L$0 = str2;
            innerTube$getMediaInfo$2.L$1 = innerTube;
            innerTube$getMediaInfo$2.L$2 = null;
            innerTube$getMediaInfo$2.L$3 = null;
            innerTube$getMediaInfo$2.label = 2;
            next4 = call3.bodyNullable(typeInfo3, innerTube$getMediaInfo$2);
            if (next4 != coroutineSingletons) {
                innerTube2 = innerTube;
                if (next4 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.NextResponse");
                }
                NextResponse.Contents contents2 = ((NextResponse) next4).contents;
                youTubeDataPage$Contents$TwoColumnWatchNextResults = contents2.twoColumnWatchNextResults;
                if (youTubeDataPage$Contents$TwoColumnWatchNextResults != null) {
                    videoSecondaryInfoRenderer = null;
                } else {
                    videoSecondaryInfoRenderer = null;
                }
                youTubeDataPage$Contents$TwoColumnWatchNextResults2 = contents2.twoColumnWatchNextResults;
                if (youTubeDataPage$Contents$TwoColumnWatchNextResults2 != null) {
                    videoPrimaryInfoRenderer = null;
                } else {
                    videoPrimaryInfoRenderer = null;
                }
                innerTube$getMediaInfo$2.L$0 = str2;
                innerTube$getMediaInfo$2.L$1 = null;
                innerTube$getMediaInfo$2.L$2 = videoSecondaryInfoRenderer;
                innerTube$getMediaInfo$2.L$3 = videoPrimaryInfoRenderer;
                innerTube$getMediaInfo$2.label = 3;
                innerTube2.getClass();
                objWithRetry = innerTube2.withRetry(3, 500L, 2.0d, new InnerTube$returnYouTubeDislike$2(innerTube2, str2, null), innerTube$getMediaInfo$2);
                innerTube$getMediaInfo$2 = innerTube$getMediaInfo$2;
                if (objWithRetry == coroutineSingletons) {
                    String str14 = str2;
                    videoSecondaryInfoRenderer2 = videoSecondaryInfoRenderer;
                    next4 = objWithRetry;
                    str3 = str14;
                    HttpClientCall call4 = ((HttpResponse) next4).getCall();
                    ClassReference orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(ReturnYouTubeDislikeResponse.class);
                    typeReferenceTypeOf2 = Reflection.typeOf(ReturnYouTubeDislikeResponse.class);
                    TypeInfo typeInfo4 = new TypeInfo((KClass<?>) orCreateKotlinClass4, false, (KType) typeReferenceTypeOf2);
                    innerTube$getMediaInfo$2.L$0 = str3;
                    innerTube$getMediaInfo$2.L$1 = null;
                    innerTube$getMediaInfo$2.L$2 = videoSecondaryInfoRenderer2;
                    innerTube$getMediaInfo$2.L$3 = videoPrimaryInfoRenderer;
                    innerTube$getMediaInfo$2.label = 4;
                    next4 = call4.bodyNullable(typeInfo4, innerTube$getMediaInfo$2);
                }
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object likePlaylist(YouTubeClient youTubeClient, String str, ContinuationImpl continuationImpl) {
        C00671 c00671;
        if (continuationImpl instanceof C00671) {
            c00671 = (C00671) continuationImpl;
            int i = c00671.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00671.label = i - Integer.MIN_VALUE;
            } else {
                c00671 = new C00671(continuationImpl);
            }
        } else {
            c00671 = new C00671(continuationImpl);
        }
        Object objExecuteMutation = c00671.result;
        int i2 = c00671.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00671.L$2 = this;
            c00671.label = 1;
            innerTube.getClass();
            objExecuteMutation = innerTube.executeMutation("likePlaylist", innerTube.sessionSnapshot(), new InnerTube$likePlaylist$2(innerTube, youTubeClient, str, null), c00671);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00671.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00671.L$2 = null;
        c00671.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "likePlaylist", c00671);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object likeVideo(YouTubeClient youTubeClient, String str, ContinuationImpl continuationImpl) {
        C00681 c00681;
        if (continuationImpl instanceof C00681) {
            c00681 = (C00681) continuationImpl;
            int i = c00681.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00681.label = i - Integer.MIN_VALUE;
            } else {
                c00681 = new C00681(continuationImpl);
            }
        } else {
            c00681 = new C00681(continuationImpl);
        }
        Object objExecuteMutation = c00681.result;
        int i2 = c00681.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00681.L$2 = this;
            c00681.label = 1;
            objExecuteMutation = innerTube.executeMutation("likeVideo", innerTube.sessionSnapshot(), new InnerTube$likeVideo$3(innerTube, youTubeClient, str, null), c00681);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00681.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00681.L$2 = null;
        c00681.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "likeVideo", c00681);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object moveSongPlaylist(YouTubeClient youTubeClient, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        C00691 c00691;
        InnerTube innerTube = this;
        if (continuationImpl instanceof C00691) {
            c00691 = (C00691) continuationImpl;
            int i = c00691.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00691.label = i - Integer.MIN_VALUE;
            } else {
                c00691 = innerTube.new C00691(continuationImpl);
            }
        } else {
            c00691 = innerTube.new C00691(continuationImpl);
        }
        Object objExecuteMutation = c00691.result;
        int i2 = c00691.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            c00691.L$4 = innerTube;
            c00691.label = 1;
            innerTube2.getClass();
            objExecuteMutation = innerTube2.executeMutation("movePlaylistSong", innerTube2.sessionSnapshot(), new InnerTube$movePlaylistSong$2(innerTube2, youTubeClient, str, str2, str3, null, (byte) 0), c00691);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = c00691.L$4;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00691.L$4 = null;
        c00691.label = 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) objExecuteMutation, "moveSongPlaylist", c00691);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    public final Object next(YouTubeClient youTubeClient, String str, String str2, String str3, Integer num, String str4, String str5, ContinuationImpl continuationImpl) {
        com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot = innerTube.sessionSnapshot();
        return com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube, LinkHeader.Rel.Next, new InnerTube$next$2(innerTube, youTubeClient, sessionSnapshot, sessionSnapshot.useLoginForBrowse, str, str2, str3, num, str4, str5, null), continuationImpl, 62);
    }

    public final synchronized void recreateTransport() {
        List list;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshotCopy$default;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot2 = this.innerTubeX.sessionSnapshot();
        com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
        AtomicReference atomicReference = innerTube.sessionBoundRequests;
        AwaitKt.cancel(innerTube.visitorDataScope, (CancellationException) null);
        loop0: while (true) {
            list = (List) atomicReference.get();
            EmptyList emptyList = EmptyList.INSTANCE;
            do {
                if (atomicReference.compareAndSet(list, emptyList)) {
                    break loop0;
                }
            } while (atomicReference.get() == list);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.metrolist.innertubex.InnerTube.SessionBoundRequest) it.next()).job.cancel(null);
        }
        this.httpClient.close();
        this.httpClient = HttpClientKt.HttpClient(OkHttp.INSTANCE, new InnerTube$$ExternalSyntheticLambda0(this, (byte) 0));
        com.metrolist.innertubex.InnerTube innerTube2 = new com.metrolist.innertubex.InnerTube(this.httpClient);
        innerTube2.setLocale(sessionSnapshot2.locale);
        String str = sessionSnapshot2.cookie;
        String str2 = sessionSnapshot2.visitorData;
        String str3 = sessionSnapshot2.dataSyncId;
        String str4 = sessionSnapshot2.authUser;
        boolean z = sessionSnapshot2.useLoginForBrowse;
        String strSanitizeCookieString = str != null ? HexFormatKt.sanitizeCookieString(str) : null;
        while (true) {
            com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot3 = (com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube2.session.get();
            String str5 = str4;
            com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshotCopy$default2 = com.metrolist.innertubex.InnerTube.SessionSnapshot.copy$default(sessionSnapshot3, null, HexFormatKt.sanitizeVisitorData(str2), str3, com.metrolist.innertubex.InnerTube.sanitizeAuthUser(str4), strSanitizeCookieString, com.metrolist.innertubex.InnerTube.resolveSapisidValue(strSanitizeCookieString), z, false, 0L, 385);
            if (sessionSnapshotCopy$default2.equals(sessionSnapshot3) || innerTube2.publishSession(sessionSnapshot3, sessionSnapshotCopy$default2)) {
                break;
                break;
            }
            str4 = str5;
        }
        boolean z2 = sessionSnapshot2.regionOverrideActive;
        do {
            sessionSnapshot = (com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube2.session.get();
            sessionSnapshotCopy$default = com.metrolist.innertubex.InnerTube.SessionSnapshot.copy$default(sessionSnapshot, null, null, null, null, null, null, false, z2, 0L, 383);
            if (sessionSnapshotCopy$default.equals(sessionSnapshot)) {
                break;
            }
        } while (!innerTube2.publishSession(sessionSnapshot, sessionSnapshotCopy$default));
        this.innerTubeX = innerTube2;
        this.transportGeneration++;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object registerPlayback(YouTubeClient youTubeClient, String str, String str2, ContinuationImpl continuationImpl) throws Throwable {
        C00701 c00701;
        InnerTube innerTube = this;
        if (continuationImpl instanceof C00701) {
            c00701 = (C00701) continuationImpl;
            int i = c00701.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00701.label = i - Integer.MIN_VALUE;
            } else {
                c00701 = innerTube.new C00701(continuationImpl);
            }
        } else {
            c00701 = innerTube.new C00701(continuationImpl);
        }
        Object objWithSessionBoundRequest = c00701.result;
        int i2 = c00701.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithSessionBoundRequest);
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            c00701.L$4 = innerTube;
            c00701.label = 1;
            Set set = com.metrolist.innertubex.InnerTube.TRANSIENT_STATUS_CODES;
            com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot = innerTube2.sessionSnapshot();
            String str3 = Intrinsics.areEqual(youTubeClient.clientName, "WEB_REMIX") ? "https://music.youtube.com" : "https://www.youtube.com";
            Url Url = URLUtilsKt.Url(str);
            if (Intrinsics.areEqual(Url.getProtocol().getName(), "https") && Url.getPort() == 443 && com.metrolist.innertubex.InnerTube.STATS_HOSTS.contains(Url.getHost()) && com.metrolist.innertubex.InnerTube.STATS_PATHS.contains(Url.getEncodedPath()) && Url.getUser() == null && Url.getPassword() == null) {
                objWithSessionBoundRequest = innerTube2.withSessionBoundRequest(sessionSnapshot, new InnerTube$registerStatsWithSession$2(innerTube2, Url, youTubeClient, str3, sessionSnapshot, str2, null, (byte) 0), c00701);
                if (objWithSessionBoundRequest != coroutineSingletons) {
                }
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Playback statistics URL must use an approved YouTube HTTPS endpoint");
            return null;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objWithSessionBoundRequest);
                return objWithSessionBoundRequest;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = c00701.L$4;
        ResultKt.throwOnFailure(objWithSessionBoundRequest);
        c00701.L$4 = null;
        c00701.label = 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) objWithSessionBoundRequest, "registerPlayback", c00701);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object removeFromPlaylist(YouTubeClient youTubeClient, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        C00711 c00711;
        InnerTube innerTube = this;
        if (continuationImpl instanceof C00711) {
            c00711 = (C00711) continuationImpl;
            int i = c00711.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00711.label = i - Integer.MIN_VALUE;
            } else {
                c00711 = innerTube.new C00711(continuationImpl);
            }
        } else {
            c00711 = innerTube.new C00711(continuationImpl);
        }
        Object objExecuteMutation = c00711.result;
        int i2 = c00711.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            c00711.L$4 = innerTube;
            c00711.label = 1;
            innerTube2.getClass();
            objExecuteMutation = innerTube2.executeMutation("removePlaylistSong", innerTube2.sessionSnapshot(), new InnerTube$movePlaylistSong$2(innerTube2, youTubeClient, str, str3, str2, null, (byte) 1), c00711);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = c00711.L$4;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00711.L$4 = null;
        c00711.label = 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) objExecuteMutation, "removeFromPlaylist", c00711);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object removePlaylistThumbnail(YouTubeClient youTubeClient, String str, ContinuationImpl continuationImpl) {
        C00721 c00721;
        if (continuationImpl instanceof C00721) {
            c00721 = (C00721) continuationImpl;
            int i = c00721.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00721.label = i - Integer.MIN_VALUE;
            } else {
                c00721 = new C00721(continuationImpl);
            }
        } else {
            c00721 = new C00721(continuationImpl);
        }
        Object objExecuteMutation = c00721.result;
        int i2 = c00721.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00721.L$2 = this;
            c00721.label = 1;
            innerTube.getClass();
            objExecuteMutation = innerTube.executeMutation("removePlaylistThumbnail", innerTube.sessionSnapshot(), new InnerTube$createPlaylist$2(innerTube, youTubeClient, str, continuation, (byte) 3), c00721);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00721.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00721.L$2 = null;
        c00721.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "removePlaylistThumbnail", c00721);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object renamePlaylist(YouTubeClient youTubeClient, String str, String str2, ContinuationImpl continuationImpl) {
        C00731 c00731;
        InnerTube innerTube = this;
        if (continuationImpl instanceof C00731) {
            c00731 = (C00731) continuationImpl;
            int i = c00731.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00731.label = i - Integer.MIN_VALUE;
            } else {
                c00731 = innerTube.new C00731(continuationImpl);
            }
        } else {
            c00731 = innerTube.new C00731(continuationImpl);
        }
        Object objExecuteMutation = c00731.result;
        int i2 = c00731.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            c00731.L$3 = innerTube;
            c00731.label = 1;
            innerTube2.getClass();
            objExecuteMutation = innerTube2.executeMutation("renamePlaylist", innerTube2.sessionSnapshot(), new InnerTube$addToPlaylist$2(innerTube2, youTubeClient, str, str2, null, (byte) 1), c00731);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = c00731.L$3;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00731.L$3 = null;
        c00731.label = 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) objExecuteMutation, "renamePlaylist", c00731);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object requireSuccess(HttpResponse httpResponse, String str, ContinuationImpl continuationImpl) {
        C00741 c00741;
        if (continuationImpl instanceof C00741) {
            c00741 = (C00741) continuationImpl;
            int i = c00741.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00741.label = i - Integer.MIN_VALUE;
            } else {
                c00741 = new C00741(continuationImpl);
            }
        } else {
            c00741 = new C00741(continuationImpl);
        }
        Object objBodyAsChannel = c00741.result;
        int i2 = c00741.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBodyAsChannel);
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                return httpResponse;
            }
            c00741.L$0 = httpResponse;
            c00741.L$1 = str;
            c00741.label = 1;
            objBodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse, c00741);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objBodyAsChannel == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = c00741.L$1;
            httpResponse = c00741.L$0;
            ResultKt.throwOnFailure(objBodyAsChannel);
        }
        ((ByteReadChannel) objBodyAsChannel).cancel(null);
        throw new InnerTubeHttpException(str, httpResponse.getStatus());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object setPlaylistThumbnail(YouTubeClient youTubeClient, String str, byte[] bArr, ContinuationImpl continuationImpl) throws Throwable {
        C00751 c00751;
        if (continuationImpl instanceof C00751) {
            c00751 = (C00751) continuationImpl;
            int i = c00751.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00751.label = i - Integer.MIN_VALUE;
            } else {
                c00751 = new C00751(continuationImpl);
            }
        } else {
            c00751 = new C00751(continuationImpl);
        }
        Object playlistThumbnail = c00751.result;
        int i2 = c00751.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(playlistThumbnail);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00751.L$3 = this;
            c00751.label = 1;
            playlistThumbnail = innerTube.setPlaylistThumbnail(youTubeClient, str, bArr, c00751);
            if (playlistThumbnail != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(playlistThumbnail);
                return playlistThumbnail;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00751.L$3;
        ResultKt.throwOnFailure(playlistThumbnail);
        c00751.L$3 = null;
        c00751.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) playlistThumbnail, "setPlaylistThumbnail", c00751);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object subscribeChannel(YouTubeClient youTubeClient, String str, String str2, ContinuationImpl continuationImpl) {
        C00761 c00761;
        InnerTube innerTube = this;
        if (continuationImpl instanceof C00761) {
            c00761 = (C00761) continuationImpl;
            int i = c00761.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00761.label = i - Integer.MIN_VALUE;
            } else {
                c00761 = innerTube.new C00761(continuationImpl);
            }
        } else {
            c00761 = innerTube.new C00761(continuationImpl);
        }
        Object objExecuteMutation = c00761.result;
        int i2 = c00761.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            c00761.L$3 = innerTube;
            c00761.label = 1;
            innerTube2.getClass();
            objExecuteMutation = innerTube2.executeMutation("subscribeChannel", innerTube2.sessionSnapshot(), new InnerTube$addToPlaylist$2(innerTube2, youTubeClient, str, str2, null, (byte) 3), c00761);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = c00761.L$3;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00761.L$3 = null;
        c00761.label = 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) objExecuteMutation, "subscribeChannel", c00761);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object unlikePlaylist(YouTubeClient youTubeClient, String str, ContinuationImpl continuationImpl) {
        C00771 c00771;
        if (continuationImpl instanceof C00771) {
            c00771 = (C00771) continuationImpl;
            int i = c00771.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00771.label = i - Integer.MIN_VALUE;
            } else {
                c00771 = new C00771(continuationImpl);
            }
        } else {
            c00771 = new C00771(continuationImpl);
        }
        Object objExecuteMutation = c00771.result;
        int i2 = c00771.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00771.L$2 = this;
            c00771.label = 1;
            objExecuteMutation = innerTube.executeMutation("unlikePlaylist", innerTube.sessionSnapshot(), new InnerTube$unlikePlaylist$3(innerTube, youTubeClient, str, null), c00771);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00771.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00771.L$2 = null;
        c00771.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "unlikePlaylist", c00771);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object unlikeVideo(YouTubeClient youTubeClient, String str, ContinuationImpl continuationImpl) {
        C00781 c00781;
        if (continuationImpl instanceof C00781) {
            c00781 = (C00781) continuationImpl;
            int i = c00781.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00781.label = i - Integer.MIN_VALUE;
            } else {
                c00781 = new C00781(continuationImpl);
            }
        } else {
            c00781 = new C00781(continuationImpl);
        }
        Object objExecuteMutation = c00781.result;
        int i2 = c00781.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube = this.innerTubeX;
            c00781.L$2 = this;
            c00781.label = 1;
            objExecuteMutation = innerTube.executeMutation("unlikeVideo", innerTube.sessionSnapshot(), new InnerTube$unlikeVideo$3(innerTube, youTubeClient, str, null), c00781);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = c00781.L$2;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00781.L$2 = null;
        c00781.label = 2;
        Object objRequireSuccess = this.requireSuccess((HttpResponse) objExecuteMutation, "unlikeVideo", c00781);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object unsubscribeChannel(YouTubeClient youTubeClient, String str, String str2, ContinuationImpl continuationImpl) {
        C00791 c00791;
        InnerTube innerTube = this;
        if (continuationImpl instanceof C00791) {
            c00791 = (C00791) continuationImpl;
            int i = c00791.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00791.label = i - Integer.MIN_VALUE;
            } else {
                c00791 = innerTube.new C00791(continuationImpl);
            }
        } else {
            c00791 = innerTube.new C00791(continuationImpl);
        }
        Object objExecuteMutation = c00791.result;
        int i2 = c00791.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteMutation);
            com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
            c00791.L$3 = innerTube;
            c00791.label = 1;
            innerTube2.getClass();
            objExecuteMutation = innerTube2.executeMutation("unsubscribeChannel", innerTube2.sessionSnapshot(), new InnerTube$addToPlaylist$2(innerTube2, youTubeClient, str, str2, null, (byte) 4), c00791);
            if (objExecuteMutation != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objExecuteMutation);
                return objExecuteMutation;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        innerTube = c00791.L$3;
        ResultKt.throwOnFailure(objExecuteMutation);
        c00791.L$3 = null;
        c00791.label = 2;
        Object objRequireSuccess = innerTube.requireSuccess((HttpResponse) objExecuteMutation, "unsubscribeChannel", c00791);
        return objRequireSuccess == coroutineSingletons ? coroutineSingletons : objRequireSuccess;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:4|(1:6)(1:7))(1:7)|8|(3:(1:(3:12|13|33)(2:14|15))(4:16|37|17|18)|28|(1:30)(1:34))(1:21)|35|22|(1:32)(1:25)) */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
    
        r6 = r9;
        r9 = r8;
        r8 = r5;
        r5 = r0;
        r0 = r4;
        r4 = r6 == true ? 1 : 0;
        r6 = r14;
        r14 = r10;
        r10 = r12;
        r12 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(r10, r0) == r3) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [int, short] */
    /* JADX WARN: Type inference failed for: r8v4, types: [int, short] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0096 -> B:13:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object withRetry(int i, long j, double d, InnerTube$returnYouTubeDislike$2 innerTube$returnYouTubeDislike$2, ContinuationImpl continuationImpl) throws IOException {
        C00801 c00801;
        int i2;
        C00801 c00802;
        Function1 function1;
        double d2;
        long j2;
        long j3;
        double d3;
        long j4;
        int i3;
        IOException e;
        Function1 function2;
        byte b;
        int i4;
        byte b2;
        if (continuationImpl instanceof C00801) {
            c00801 = (C00801) continuationImpl;
            int i5 = c00801.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c00801.label = i5 - Integer.MIN_VALUE;
            } else {
                c00801 = new C00801(continuationImpl);
            }
        } else {
            c00801 = new C00801(continuationImpl);
        }
        Object obj = c00801.result;
        int i6 = c00801.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i6 != 0) {
            if (i6 == 1) {
                i3 = c00801.I$1;
                j4 = c00801.J$1;
                d3 = c00801.D$0;
                j3 = c00801.J$0;
                b = c00801.I$0;
                function2 = c00801.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                } catch (IOException e2) {
                    e = e2;
                }
            } else {
                if (i6 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i4 = c00801.I$1;
                j4 = c00801.J$1;
                d3 = c00801.D$0;
                j3 = c00801.J$0;
                b = c00801.I$0;
                function2 = c00801.L$0;
                ResultKt.throwOnFailure(obj);
                i2 = i4;
                b2 = b;
                c00802 = c00801;
                function1 = function2;
                double d4 = d3;
                j2 = (long) (j4 * d3);
                j = j3;
                d2 = d4;
            }
            i4 = i3 + 1;
            if (i4 >= b) {
                throw e;
            }
            c00801.L$0 = function2;
            c00801.I$0 = b;
            c00801.J$0 = (int) j3;
            c00801.D$0 = d3;
            c00801.J$1 = j4;
            c00801.I$1 = i4;
            c00801.label = 2;
        } else {
            ResultKt.throwOnFailure(obj);
            i2 = 0;
            c00802 = c00801;
            function1 = innerTube$returnYouTubeDislike$2;
            d2 = d;
            j2 = j;
            b2 = i;
        }
        c00802.L$0 = function1;
        c00802.I$0 = b2;
        c00802.J$0 = (int) j;
        c00802.D$0 = d2;
        c00802.J$1 = j2;
        c00802.I$1 = i2;
        c00802.label = 1;
        Object objInvoke = function1.invoke(c00802);
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }
}
