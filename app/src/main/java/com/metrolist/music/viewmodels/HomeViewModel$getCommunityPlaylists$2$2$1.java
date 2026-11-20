package com.metrolist.music.viewmodels;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.innertube.pages.RelatedPage;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel$getCommunityPlaylists$2$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ List $candidatePlaylists;
    public final /* synthetic */ Song $seed;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeViewModel$getCommunityPlaylists$2$2$1(Song song, List list, Continuation continuation) {
        super(2, continuation);
        this.$seed = song;
        this.$candidatePlaylists = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HomeViewModel$getCommunityPlaylists$2$2$1(this.$seed, this.$candidatePlaylists, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HomeViewModel$getCommunityPlaylists$2$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        if (r10 == r4) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objM1024next0E7RQCE;
        Object objM1031relatedgIAlus;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            WatchEndpoint watchEndpoint = new WatchEndpoint(62, this.$seed.song.id, null, null);
            this.label = (byte) 1;
            objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, null, this);
            if (objM1024next0E7RQCE != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (b == 1) {
            ResultKt.throwOnFailure(obj);
            objM1024next0E7RQCE = ((Result) obj).value;
        } else {
            if (b != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM1031relatedgIAlus = ((Result) obj).value;
        }
        if (!(objM1031relatedgIAlus instanceof Result.Failure)) {
            ArrayList arrayList = ((RelatedPage) objM1031relatedgIAlus).playlists;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                PlaylistItem playlistItem = (PlaylistItem) obj2;
                Artist artist = playlistItem.author;
                String str = playlistItem.id;
                if (!Intrinsics.areEqual(artist != null ? artist.name : null, "YouTube Music")) {
                    if (!Intrinsics.areEqual(artist != null ? artist.name : null, "YouTube")) {
                        if (!Intrinsics.areEqual(artist != null ? artist.name : null, "Playlist") && !StringsKt__StringsJVMKt.startsWith(str, "RD", false) && !StringsKt__StringsJVMKt.startsWith(str, "OLAK", false)) {
                            this.$candidatePlaylists.add(playlistItem);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
        if (objM1024next0E7RQCE instanceof Result.Failure) {
            objM1024next0E7RQCE = null;
        }
        NextResult nextResult = (NextResult) objM1024next0E7RQCE;
        BrowseEndpoint browseEndpoint = nextResult != null ? nextResult.relatedEndpoint : null;
        if (browseEndpoint != null) {
            YouTube youTube2 = YouTube.INSTANCE;
            this.label = (byte) 2;
            objM1031relatedgIAlus = youTube2.m1031relatedgIAlus(browseEndpoint, this);
        }
        return Unit.INSTANCE;
    }
}
