package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.offline.Download;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$2$1$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumMenuKt$AlbumMenu$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ParcelableSnapshotMutableIntState $downloadState$delegate;
    public final /* synthetic */ DownloadUtil $downloadUtil;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $songs$delegate;
    public boolean label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.menu.AlbumMenuKt$AlbumMenu$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements FlowCollector {
        public final /* synthetic */ ParcelableSnapshotMutableIntState $downloadState$delegate;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ MutableState $songs$delegate;

        public /* synthetic */ AnonymousClass1(byte b, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState) {
            this.$r8$classId = b;
            this.$songs$delegate = mutableState;
            this.$downloadState$delegate = parcelableSnapshotMutableIntState;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x015b  */
        /* JADX WARN: Code duplicated, block: B:103:0x0162  */
        /* JADX WARN: Code duplicated, block: B:106:0x016c  */
        /* JADX WARN: Code duplicated, block: B:121:0x019f  */
        /* JADX WARN: Code duplicated, block: B:20:0x004a  */
        /* JADX WARN: Code duplicated, block: B:23:0x0051  */
        /* JADX WARN: Code duplicated, block: B:26:0x005b  */
        /* JADX WARN: Code duplicated, block: B:41:0x008e  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            List list;
            Iterator it;
            Download download;
            Download download2;
            Download download3;
            List list2;
            Iterator it2;
            Download download4;
            Download download5;
            Download download6;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            int i = 1;
            MutableState mutableState = this.$songs$delegate;
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$downloadState$delegate;
            switch (b) {
                case 0:
                    Map map = (Map) obj;
                    List list3 = (List) mutableState.getValue();
                    if (list3 == null || !list3.isEmpty()) {
                        Iterator it3 = list3.iterator();
                        while (it3.hasNext()) {
                            Download download7 = (Download) map.get(((Song) it3.next()).song.id);
                            if (download7 == null || download7.state != 3) {
                                List list4 = (List) mutableState.getValue();
                                if (list4 == null || !list4.isEmpty()) {
                                    Iterator it4 = list4.iterator();
                                    while (it4.hasNext()) {
                                        SongEntity songEntity = ((Song) it4.next()).song;
                                        String str = songEntity.id;
                                        String str2 = songEntity.id;
                                        Download download8 = (Download) map.get(str);
                                        if (download8 == null || download8.state != 0) {
                                            Download download9 = (Download) map.get(str2);
                                            if (download9 == null || download9.state != 2) {
                                                Download download10 = (Download) map.get(str2);
                                                if (download10 == null || download10.state != 3) {
                                                }
                                            }
                                        }
                                    }
                                    i = 2;
                                } else {
                                    i = 2;
                                }
                            }
                        }
                        i = 3;
                    } else {
                        i = 3;
                    }
                    parcelableSnapshotMutableIntState.setIntValue(i);
                    break;
                case 1:
                    Map map2 = (Map) obj;
                    List list5 = (List) mutableState.getValue();
                    if (list5 == null || !list5.isEmpty()) {
                        Iterator it5 = list5.iterator();
                        while (it5.hasNext()) {
                            Download download11 = (Download) map2.get(((Song) it5.next()).song.id);
                            if (download11 == null || download11.state != 3) {
                                List list6 = (List) mutableState.getValue();
                                if (list6 == null || !list6.isEmpty()) {
                                    Iterator it6 = list6.iterator();
                                    while (it6.hasNext()) {
                                        SongEntity songEntity2 = ((Song) it6.next()).song;
                                        String str3 = songEntity2.id;
                                        String str4 = songEntity2.id;
                                        Download download12 = (Download) map2.get(str3);
                                        if (download12 == null || download12.state != 0) {
                                            Download download13 = (Download) map2.get(str4);
                                            if (download13 == null || download13.state != 2) {
                                                Download download14 = (Download) map2.get(str4);
                                                if (download14 == null || download14.state != 3) {
                                                }
                                            }
                                        }
                                    }
                                    i = 2;
                                } else {
                                    i = 2;
                                }
                            }
                        }
                        i = 3;
                    } else {
                        i = 3;
                    }
                    parcelableSnapshotMutableIntState.setIntValue(i);
                    break;
                case 2:
                    Map map3 = (Map) obj;
                    List list7 = (List) mutableState.getValue();
                    if (list7 == null) {
                        list = (List) mutableState.getValue();
                        if (list != null) {
                            if (list.isEmpty()) {
                                i = 2;
                            } else {
                                it = list.iterator();
                                while (it.hasNext()) {
                                    SongEntity songEntity3 = ((Song) it.next()).song;
                                    String str5 = songEntity3.id;
                                    String str6 = songEntity3.id;
                                    download = (Download) map3.get(str5);
                                    if (download != null || download.state != 0) {
                                        download2 = (Download) map3.get(str6);
                                        if (download2 != null || download2.state != 2) {
                                            download3 = (Download) map3.get(str6);
                                            if (download3 != null || download3.state != 3) {
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    } else {
                        if (!list7.isEmpty()) {
                            Iterator it7 = list7.iterator();
                            while (true) {
                                if (it7.hasNext()) {
                                    Download download15 = (Download) map3.get(((Song) it7.next()).song.id);
                                    if (download15 == null || download15.state != 3) {
                                        list = (List) mutableState.getValue();
                                        if (list != null) {
                                            if (list.isEmpty()) {
                                                i = 2;
                                            } else {
                                                it = list.iterator();
                                                while (it.hasNext()) {
                                                    SongEntity songEntity4 = ((Song) it.next()).song;
                                                    String str7 = songEntity4.id;
                                                    String str8 = songEntity4.id;
                                                    download = (Download) map3.get(str7);
                                                    if (download != null) {
                                                    }
                                                    download2 = (Download) map3.get(str8);
                                                    if (download2 != null) {
                                                    }
                                                    download3 = (Download) map3.get(str8);
                                                    if (download3 != null) {
                                                    }
                                                }
                                                i = 2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i = 3;
                    }
                    parcelableSnapshotMutableIntState.setIntValue(i);
                    break;
                case 3:
                    Map map4 = (Map) obj;
                    List list8 = (List) mutableState.getValue();
                    if (list8 == null || !list8.isEmpty()) {
                        Iterator it8 = list8.iterator();
                        while (it8.hasNext()) {
                            Download download16 = (Download) map4.get(((PlaylistSong) it8.next()).song.song.id);
                            if (download16 == null || download16.state != 3) {
                                List list9 = (List) mutableState.getValue();
                                if (list9 == null || !list9.isEmpty()) {
                                    Iterator it9 = list9.iterator();
                                    while (it9.hasNext()) {
                                        SongEntity songEntity5 = ((PlaylistSong) it9.next()).song.song;
                                        Download download17 = (Download) map4.get(songEntity5.id);
                                        if (download17 == null || download17.state != 0) {
                                            Download download18 = (Download) map4.get(songEntity5.id);
                                            if (download18 == null || download18.state != 2) {
                                                Download download19 = (Download) map4.get(songEntity5.id);
                                                if (download19 == null || download19.state != 3) {
                                                }
                                            }
                                        }
                                    }
                                    i = 2;
                                } else {
                                    i = 2;
                                }
                            }
                        }
                        i = 3;
                    } else {
                        i = 3;
                    }
                    parcelableSnapshotMutableIntState.setIntValue(i);
                    break;
                default:
                    Map map5 = (Map) obj;
                    List list10 = (List) mutableState.getValue();
                    if (list10 == null) {
                        list2 = (List) mutableState.getValue();
                        if (list2 != null) {
                            if (list2.isEmpty()) {
                                i = 2;
                            } else {
                                it2 = list2.iterator();
                                while (it2.hasNext()) {
                                    SongEntity songEntity6 = ((Song) it2.next()).song;
                                    String str9 = songEntity6.id;
                                    String str10 = songEntity6.id;
                                    download4 = (Download) map5.get(str9);
                                    if (download4 != null || download4.state != 0) {
                                        download5 = (Download) map5.get(str10);
                                        if (download5 != null || download5.state != 2) {
                                            download6 = (Download) map5.get(str10);
                                            if (download6 != null || download6.state != 3) {
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    } else {
                        if (!list10.isEmpty()) {
                            Iterator it10 = list10.iterator();
                            while (true) {
                                if (it10.hasNext()) {
                                    Download download20 = (Download) map5.get(((Song) it10.next()).song.id);
                                    if (download20 == null || download20.state != 3) {
                                        list2 = (List) mutableState.getValue();
                                        if (list2 != null) {
                                            if (list2.isEmpty()) {
                                                i = 2;
                                            } else {
                                                it2 = list2.iterator();
                                                while (it2.hasNext()) {
                                                    SongEntity songEntity7 = ((Song) it2.next()).song;
                                                    String str11 = songEntity7.id;
                                                    String str12 = songEntity7.id;
                                                    download4 = (Download) map5.get(str11);
                                                    if (download4 != null) {
                                                    }
                                                    download5 = (Download) map5.get(str12);
                                                    if (download5 != null) {
                                                    }
                                                    download6 = (Download) map5.get(str12);
                                                    if (download6 != null) {
                                                    }
                                                }
                                                i = 2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i = 3;
                    }
                    parcelableSnapshotMutableIntState.setIntValue(i);
                    break;
            }
            return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlbumMenuKt$AlbumMenu$2$1(DownloadUtil downloadUtil, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$downloadUtil = downloadUtil;
        this.$songs$delegate = mutableState;
        this.$downloadState$delegate = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AlbumMenuKt$AlbumMenu$2$1(this.$downloadUtil, this.$songs$delegate, this.$downloadState$delegate, continuation, (byte) 0);
            case 1:
                return new AlbumMenuKt$AlbumMenu$2$1(this.$downloadUtil, this.$songs$delegate, this.$downloadState$delegate, continuation, (byte) 1);
            case 2:
                return new AlbumMenuKt$AlbumMenu$2$1(this.$downloadUtil, this.$songs$delegate, this.$downloadState$delegate, continuation, (byte) 2);
            default:
                return new AlbumMenuKt$AlbumMenu$2$1(this.$downloadUtil, this.$songs$delegate, this.$downloadState$delegate, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((AlbumMenuKt$AlbumMenu$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 0;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$downloadState$delegate;
        DownloadUtil downloadUtil = this.$downloadUtil;
        MutableState mutableState = this.$songs$delegate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b3 = 1;
        ArrayList arrayList = null;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (((List) mutableState.getValue()).isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl = downloadUtil.downloads;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(b2, mutableState, parcelableSnapshotMutableIntState);
                this.label = true;
                stateFlowImpl.collect(anonymousClass1, this);
                return coroutineSingletons;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (((List) mutableState.getValue()).isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl2 = downloadUtil.downloads;
                AnonymousClass1 anonymousClass2 = new AnonymousClass1(b3, mutableState, parcelableSnapshotMutableIntState);
                this.label = true;
                stateFlowImpl2.collect(anonymousClass2, this);
                return coroutineSingletons;
            case 2:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs == null) {
                    return unit;
                }
                List list = albumWithSongs.songs;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Song) it.next()).song.id);
                }
                StateFlowImpl stateFlowImpl3 = downloadUtil.downloads;
                YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1 youTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1 = new YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1(arrayList2, parcelableSnapshotMutableIntState, (byte) 0);
                this.label = true;
                stateFlowImpl3.collect(youTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1, this);
                return coroutineSingletons;
            default:
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs2 != null) {
                    List list2 = albumWithSongs2.songs;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(((Song) it2.next()).song.id);
                    }
                }
                if (arrayList == null || arrayList.isEmpty()) {
                    return unit;
                }
                StateFlowImpl stateFlowImpl4 = downloadUtil.downloads;
                AlbumScreenKt$AlbumScreen$2$1$1 albumScreenKt$AlbumScreen$2$1$1 = new AlbumScreenKt$AlbumScreen$2$1$1(arrayList, parcelableSnapshotMutableIntState, (byte) 0);
                this.label = true;
                stateFlowImpl4.collect(albumScreenKt$AlbumScreen$2$1$1, this);
                return coroutineSingletons;
        }
    }
}
