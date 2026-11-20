package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Album;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Artist;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Playlist;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Video;
import com.metrolist.music.db.MusicDatabase;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/OnlineSearchSuggestionViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class OnlineSearchSuggestionViewModel extends ViewModel {
    public final StateFlowImpl _viewState;
    public final Context context;
    public final StateFlowImpl query;
    public final ReadonlyStateFlow viewState;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel$fetchParsedUrlItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Okio__OkioKt L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnlineSearchSuggestionViewModel.this.fetchParsedUrlItem(null, this);
        }
    }

    public OnlineSearchSuggestionViewModel(Context context, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        this.context = context;
        this.query = StateFlowKt.MutableStateFlow("");
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(new SearchSuggestionViewState(null, null, null, 31));
        this._viewState = stateFlowImplMutableStateFlow;
        this.viewState = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ShimmerModifierKt$shimmer$1$1((Object) this, (Object) musicDatabase, (Continuation) null, (byte) 1), 3);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00de  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        if (r4 == r2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
    
        if (r4 == r2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f0, code lost:
    
        if (r4 == r2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011b, code lost:
    
        if (r4 == r2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0135, code lost:
    
        if (r4 == r2) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchParsedUrlItem(Okio__OkioKt okio__OkioKt, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object objM998artistgIAlus;
        Object objM998artistgIAlus2;
        Object objM996album0E7RQCE;
        Object objM1025playlistgIAlus;
        Object objM1024next0E7RQCE;
        boolean z;
        Object objM1025playlistgIAlus2;
        AlbumPage albumPage;
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
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i2) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (okio__OkioKt != null) {
                    if (okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Video) {
                        YouTube youTube = YouTube.INSTANCE;
                        WatchEndpoint watchEndpoint = new WatchEndpoint(62, ((YouTubeUrlParser$ParsedUrl$Video) okio__OkioKt).id, null, null);
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 1;
                        objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, null, anonymousClass1);
                        break;
                    } else {
                        if (okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Playlist) {
                            YouTube youTube2 = YouTube.INSTANCE;
                            String str = ((YouTubeUrlParser$ParsedUrl$Playlist) okio__OkioKt).id;
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 2;
                            objM1025playlistgIAlus = youTube2.m1025playlistgIAlus(str, anonymousClass1);
                        } else if (okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Album) {
                            YouTube youTube3 = YouTube.INSTANCE;
                            String strConcat = "MPREb_".concat(((YouTubeUrlParser$ParsedUrl$Album) okio__OkioKt).id);
                            anonymousClass1.L$0 = okio__OkioKt;
                            anonymousClass1.label = 3;
                            objM996album0E7RQCE = YouTube.INSTANCE.m996album0E7RQCE(strConcat, true, anonymousClass1);
                            if (objM996album0E7RQCE != coroutineSingletons) {
                                z = objM996album0E7RQCE instanceof Result.Failure;
                                if (!z) {
                                    YouTube youTube4 = YouTube.INSTANCE;
                                    String str2 = ((YouTubeUrlParser$ParsedUrl$Album) okio__OkioKt).id;
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.label = 4;
                                    objM1025playlistgIAlus2 = youTube4.m1025playlistgIAlus(str2, anonymousClass1);
                                    break;
                                } else {
                                    if (z) {
                                        objM996album0E7RQCE = null;
                                    }
                                    albumPage = (AlbumPage) objM996album0E7RQCE;
                                    if (albumPage != null) {
                                        return albumPage.album;
                                    }
                                }
                                return null;
                            }
                        } else if (okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Artist) {
                            String str3 = ((YouTubeUrlParser$ParsedUrl$Artist) okio__OkioKt).id;
                            if (!StringsKt__StringsJVMKt.startsWith(str3, "MPRE", false)) {
                                YouTube youTube5 = YouTube.INSTANCE;
                                anonymousClass1.L$0 = null;
                                anonymousClass1.label = 6;
                                objM998artistgIAlus = youTube5.m998artistgIAlus(str3, anonymousClass1);
                            } else {
                                YouTube youTube6 = YouTube.INSTANCE;
                                anonymousClass1.L$0 = null;
                                anonymousClass1.label = 5;
                                objM998artistgIAlus2 = youTube6.m998artistgIAlus(str3, anonymousClass1);
                            }
                        }
                        break;
                    }
                    return coroutineSingletons;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            case 1:
                ResultKt.throwOnFailure(obj);
                objM1024next0E7RQCE = ((Result) obj).value;
                if (objM1024next0E7RQCE instanceof Result.Failure) {
                    objM1024next0E7RQCE = null;
                }
                NextResult nextResult = (NextResult) objM1024next0E7RQCE;
                if (nextResult != null) {
                    return (SongItem) CollectionsKt.firstOrNull(nextResult.items);
                }
                return null;
            case 2:
                ResultKt.throwOnFailure(obj);
                objM1025playlistgIAlus = ((Result) obj).value;
                if (objM1025playlistgIAlus instanceof Result.Failure) {
                    objM1025playlistgIAlus = null;
                }
                PlaylistPage playlistPage = (PlaylistPage) objM1025playlistgIAlus;
                if (playlistPage != null) {
                    return playlistPage.playlist;
                }
                return null;
            case 3:
                okio__OkioKt = anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                objM996album0E7RQCE = ((Result) obj).value;
                z = objM996album0E7RQCE instanceof Result.Failure;
                if (!z) {
                    YouTube youTube7 = YouTube.INSTANCE;
                    String str4 = ((YouTubeUrlParser$ParsedUrl$Album) okio__OkioKt).id;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 4;
                    objM1025playlistgIAlus2 = youTube7.m1025playlistgIAlus(str4, anonymousClass1);
                    break;
                } else {
                    if (z) {
                        objM996album0E7RQCE = null;
                    }
                    albumPage = (AlbumPage) objM996album0E7RQCE;
                    if (albumPage != null) {
                        return albumPage.album;
                    }
                }
                return null;
            case 4:
                ResultKt.throwOnFailure(obj);
                objM1025playlistgIAlus2 = ((Result) obj).value;
                if (objM1025playlistgIAlus2 instanceof Result.Failure) {
                    objM1025playlistgIAlus2 = null;
                }
                PlaylistPage playlistPage2 = (PlaylistPage) objM1025playlistgIAlus2;
                if (playlistPage2 != null) {
                    return playlistPage2.playlist;
                }
                return null;
            case 5:
                ResultKt.throwOnFailure(obj);
                objM998artistgIAlus2 = ((Result) obj).value;
                if (objM998artistgIAlus2 instanceof Result.Failure) {
                    objM998artistgIAlus2 = null;
                }
                ArtistPage artistPage = (ArtistPage) objM998artistgIAlus2;
                if (artistPage != null) {
                    return artistPage.artist;
                }
                return null;
            case 6:
                ResultKt.throwOnFailure(obj);
                objM998artistgIAlus = ((Result) obj).value;
                if (objM998artistgIAlus instanceof Result.Failure) {
                    objM998artistgIAlus = null;
                }
                ArtistPage artistPage2 = (ArtistPage) objM998artistgIAlus;
                if (artistPage2 != null) {
                    return artistPage2.artist;
                }
                return null;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
