package com.metrolist.music.viewmodels;

import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SpeedDialItem;
import com.metrolist.music.widget.PlaylistWidgetManager;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$special$$inlined$map$3$2 implements FlowCollector {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ FlowCollector $this_unsafeFlow;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.StatsViewModel$special$$inlined$map$3$2$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatsViewModel$special$$inlined$map$3$2.this.emit(null, this);
        }
    }

    public /* synthetic */ StatsViewModel$special$$inlined$map$3$2(FlowCollector flowCollector, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x021f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0269  */
    /* JADX WARN: Code duplicated, block: B:145:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:66:0x0149  */
    /* JADX WARN: Code duplicated, block: B:85:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        StatsViewModel$special$$inlined$map$4$2$1 statsViewModel$special$$inlined$map$4$2$1;
        TopPlaylistViewModel$special$$inlined$map$1$2$1 topPlaylistViewModel$special$$inlined$map$1$2$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        FlowCollector flowCollector = this.$this_unsafeFlow;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i = anonymousClass1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object obj2 = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj2);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
                Boolean bool = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideVideoSongsKey);
                Boolean boolValueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : false);
                anonymousClass1.label = 1;
                return flowCollector.emit(boolValueOf, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                if (continuation instanceof StatsViewModel$special$$inlined$map$4$2$1) {
                    statsViewModel$special$$inlined$map$4$2$1 = (StatsViewModel$special$$inlined$map$4$2$1) continuation;
                    int i3 = statsViewModel$special$$inlined$map$4$2$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        statsViewModel$special$$inlined$map$4$2$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        statsViewModel$special$$inlined$map$4$2$1 = new StatsViewModel$special$$inlined$map$4$2$1(this, continuation);
                    }
                } else {
                    statsViewModel$special$$inlined$map$4$2$1 = new StatsViewModel$special$$inlined$map$4$2$1(this, continuation);
                }
                Object obj3 = statsViewModel$special$$inlined$map$4$2$1.result;
                int i4 = statsViewModel$special$$inlined$map$4$2$1.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj3);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj3);
                ArrayList arrayList = new ArrayList();
                for (Object obj4 : (List) obj) {
                    PlaylistEntity playlistEntity = ((Playlist) obj4).playlist;
                    if (playlistEntity.browseId != null && StringsKt.contains(playlistEntity.name, "recap", true)) {
                        arrayList.add(obj4);
                    }
                }
                statsViewModel$special$$inlined$map$4$2$1.label = 1;
                return flowCollector.emit(arrayList, statsViewModel$special$$inlined$map$4$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
                if (continuation instanceof TopPlaylistViewModel$special$$inlined$map$1$2$1) {
                    topPlaylistViewModel$special$$inlined$map$1$2$1 = (TopPlaylistViewModel$special$$inlined$map$1$2$1) continuation;
                    int i5 = topPlaylistViewModel$special$$inlined$map$1$2$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        topPlaylistViewModel$special$$inlined$map$1$2$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        topPlaylistViewModel$special$$inlined$map$1$2$1 = new TopPlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                    }
                } else {
                    topPlaylistViewModel$special$$inlined$map$1$2$1 = new TopPlaylistViewModel$special$$inlined$map$1$2$1(this, continuation);
                }
                Object obj5 = topPlaylistViewModel$special$$inlined$map$1$2$1.result;
                int i6 = topPlaylistViewModel$special$$inlined$map$1$2$1.label;
                if (i6 != 0) {
                    if (i6 == 1) {
                        ResultKt.throwOnFailure(obj5);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj5);
                Boolean bool2 = (Boolean) ((MutablePreferences) obj).get(PreferenceKeysKt.HideVideoSongsKey);
                Boolean boolValueOf2 = Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
                topPlaylistViewModel$special$$inlined$map$1$2$1.label = 1;
                return flowCollector.emit(boolValueOf2, topPlaylistViewModel$special$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            case 3:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1) continuation;
                    int i7 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1(this, continuation);
                }
                Object obj6 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1.result;
                int i8 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1.label;
                if (i8 != 0) {
                    if (i8 == 1) {
                        ResultKt.throwOnFailure(obj6);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj6);
                List<SpeedDialItem> list = (List) obj;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (SpeedDialItem speedDialItem : list) {
                    arrayList2.add(new PlaylistWidgetManager.SpeedDialSnapshot(speedDialItem.type, speedDialItem.id, speedDialItem.title, speedDialItem.thumbnailUrl));
                }
                playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1.label = 1;
                return flowCollector.emit(arrayList2, playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            case 4:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1) continuation;
                    int i9 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1(this, continuation);
                }
                Object obj7 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1.result;
                int i10 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        ResultKt.throwOnFailure(obj7);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj7);
                List<Playlist> list2 = (List) obj;
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                for (Playlist playlist : list2) {
                    PlaylistEntity playlistEntity2 = playlist.playlist;
                    arrayList3.add(new PlaylistWidgetManager.PlaylistSnapshot(playlistEntity2.id, playlistEntity2.browseId, playlistEntity2.name, (String) CollectionsKt.firstOrNull(playlist.getThumbnails()), playlist.playlist.isLocal));
                }
                playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1.label = 1;
                return flowCollector.emit(arrayList3, playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            case 5:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1) continuation;
                    int i11 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1(this, continuation);
                }
                Object obj8 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1.result;
                int i12 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1.label;
                if (i12 != 0) {
                    if (i12 == 1) {
                        ResultKt.throwOnFailure(obj8);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj8);
                List list3 = (List) obj;
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    SongEntity songEntity = ((Song) it.next()).song;
                    arrayList4.add(new PlaylistWidgetManager.SongSnapshot(songEntity.id, songEntity.thumbnailUrl));
                }
                playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1.label = 1;
                return flowCollector.emit(arrayList4, playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            case 6:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1) continuation;
                    int i13 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1(this, continuation);
                }
                Object obj9 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1.result;
                int i14 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1.label;
                if (i14 != 0) {
                    if (i14 == 1) {
                        ResultKt.throwOnFailure(obj9);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj9);
                List list4 = (List) obj;
                ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                Iterator it2 = list4.iterator();
                while (it2.hasNext()) {
                    SongEntity songEntity2 = ((Song) it2.next()).song;
                    arrayList5.add(new PlaylistWidgetManager.SongSnapshot(songEntity2.id, songEntity2.thumbnailUrl));
                }
                playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1.label = 1;
                return flowCollector.emit(arrayList5, playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$2$1) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1) continuation;
                    int i15 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1.label;
                    if ((i15 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1.label = i15 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1(this, continuation);
                }
                Object obj10 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1.result;
                int i16 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1.label;
                if (i16 != 0) {
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj10);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj10);
                List list5 = (List) obj;
                ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                Iterator it3 = list5.iterator();
                while (it3.hasNext()) {
                    SongEntity songEntity3 = ((Song) it3.next()).song;
                    arrayList6.add(new PlaylistWidgetManager.SongSnapshot(songEntity3.id, songEntity3.thumbnailUrl));
                }
                playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1.label = 1;
                return flowCollector.emit(arrayList6, playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$2$1) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
