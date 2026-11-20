package com.metrolist.music.viewmodels;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.innertube.pages.RelatedPage;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel$getDailyDiscover$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $hideVideoSongs;
    public final /* synthetic */ List $items;
    public final /* synthetic */ Song $seed;
    public BrowseEndpoint L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeViewModel$getDailyDiscover$2$1$1(Song song, List list, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$seed = song;
        this.$items = list;
        this.$hideVideoSongs = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HomeViewModel$getDailyDiscover$2$1$1(this.$seed, this.$items, this.$hideVideoSongs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HomeViewModel$getDailyDiscover$2$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r11 == r5) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objM1024next0E7RQCE;
        BrowseEndpoint browseEndpoint;
        Object objM1031relatedgIAlus;
        byte b = this.label;
        Song song = this.$seed;
        Object obj2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            WatchEndpoint watchEndpoint = new WatchEndpoint(62, song.song.id, null, null);
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
            browseEndpoint = this.L$0;
            ResultKt.throwOnFailure(obj);
            objM1031relatedgIAlus = ((Result) obj).value;
        }
        if (!(objM1031relatedgIAlus instanceof Result.Failure)) {
            ArrayList arrayList = ((RelatedPage) objM1031relatedgIAlus).songs;
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj3 = arrayList.get(i2);
                i2++;
                SongItem songItem = (SongItem) obj3;
                if (!this.$hideVideoSongs || !songItem.isVideoSong()) {
                    if (!songItem.explicit) {
                        arrayList2.add(obj3);
                    }
                }
            }
            List mutableList = CollectionsKt.toMutableList((Iterable) arrayList2);
            Collections.shuffle(mutableList);
            ArrayList arrayList3 = (ArrayList) mutableList;
            int size2 = arrayList3.size();
            while (i < size2) {
                Object obj4 = arrayList3.get(i);
                i++;
                if (!Intrinsics.areEqual(((SongItem) obj4).id, song.song.id)) {
                    obj2 = obj4;
                    break;
                }
            }
            SongItem songItem2 = (SongItem) obj2;
            if (songItem2 != null) {
                this.$items.add(new DailyDiscoverItem(song, songItem2, browseEndpoint));
            }
        }
        return Unit.INSTANCE;
        if (objM1024next0E7RQCE instanceof Result.Failure) {
            objM1024next0E7RQCE = null;
        }
        NextResult nextResult = (NextResult) objM1024next0E7RQCE;
        browseEndpoint = nextResult != null ? nextResult.relatedEndpoint : null;
        if (browseEndpoint != null) {
            YouTube youTube2 = YouTube.INSTANCE;
            this.L$0 = browseEndpoint;
            this.label = (byte) 2;
            objM1031relatedgIAlus = youTube2.m1031relatedgIAlus(browseEndpoint, this);
        }
        return Unit.INSTANCE;
    }
}
