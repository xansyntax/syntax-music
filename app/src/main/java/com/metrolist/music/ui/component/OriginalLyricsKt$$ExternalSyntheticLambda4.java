package com.metrolist.music.ui.component;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.viewmodels.HomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OriginalLyricsKt$$ExternalSyntheticLambda4 implements Function0 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ MutableState f$6;

    public /* synthetic */ OriginalLyricsKt$$ExternalSyntheticLambda4(CoroutineScope coroutineScope, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, LazyListState lazyListState, MutableState mutableState, List list, boolean z, MutableState mutableState2) {
        this.f$0 = coroutineScope;
        this.f$1 = parcelableSnapshotMutableIntState;
        this.f$2 = lazyListState;
        this.f$3 = mutableState;
        this.f$4 = list;
        this.f$5 = z;
        this.f$6 = mutableState2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00af  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f6 A[LOOP:3: B:46:0x00f4->B:47:0x00f6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x010a  */
    /* JADX WARN: Code duplicated, block: B:52:0x011c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0120  */
    /* JADX WARN: Code duplicated, block: B:56:0x0124  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object next;
        ArtistSection artistSection;
        BrowseEndpoint browseEndpoint;
        int i;
        WatchEndpoint watchEndpoint;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        int i2;
        SongItem songItem;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MediaMetadata mediaMetadata = null;
        Object[] objArr = 0;
        MutableState mutableState = this.f$6;
        CoroutineScope coroutineScope = this.f$0;
        Object obj = this.f$4;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        switch (b) {
            case 0:
                AwaitKt.launch$default(coroutineScope, null, null, new HomeViewModel.AnonymousClass2((ParcelableSnapshotMutableIntState) obj3, (LazyListState) obj2, this.f$3, (List) obj, this.f$5, null), 3);
                mutableState.setValue(Boolean.TRUE);
                break;
            default:
                PlayerConnection playerConnection = (PlayerConnection) obj3;
                String str2 = (String) obj2;
                ArtistPage artistPage = (ArtistPage) obj;
                if (!this.f$5) {
                    if (((Boolean) this.f$3.getValue()).booleanValue()) {
                        if (!((List) mutableState.getValue()).isEmpty()) {
                            if (str2 == null) {
                                str2 = "Unknown Artist";
                            }
                            String str3 = str2;
                            List list = (List) mutableState.getValue();
                            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(UuidKt.toMediaItem((Song) it.next()));
                            }
                            playerConnection.playQueue(new ListQueue(str3, arrayList3, 0, 0L, 12, null));
                        }
                    } else if (artistPage != null) {
                        ArtistItem artistItem = artistPage.artist;
                        Iterator it2 = artistPage.sections.iterator();
                        do {
                            if (it2.hasNext()) {
                                next = it2.next();
                                Object objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) next).items);
                                songItem = objFirstOrNull instanceof SongItem ? (SongItem) objFirstOrNull : null;
                            } else {
                                next = null;
                            }
                            artistSection = (ArtistSection) next;
                            if (artistSection != null) {
                                browseEndpoint = artistSection.moreEndpoint;
                            } else {
                                browseEndpoint = null;
                            }
                            i = 2;
                            if (browseEndpoint != null) {
                                DefaultScheduler defaultScheduler = Dispatchers.Default;
                                AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new DiscordRpcManager.AnonymousClass4(browseEndpoint, playerConnection, str2, artistPage, artistSection, null, (byte) 8), 2);
                            } else if (artistSection != null) {
                                List list2 = artistSection.items;
                                arrayList = new ArrayList();
                                for (Object obj4 : list2) {
                                    if (obj4 instanceof SongItem) {
                                        arrayList.add(obj4);
                                    }
                                }
                                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                                size = arrayList.size();
                                i2 = 0;
                                while (i2 < size) {
                                    Object obj5 = arrayList.get(i2);
                                    i2++;
                                    arrayList2.add(UuidKt.toMediaItem((SongItem) obj5));
                                }
                                if (str2 == null) {
                                    str2 = artistItem.title;
                                }
                                playerConnection.playQueue(new ListQueue(str2, arrayList2, 0, 0L, 12, null));
                            } else {
                                watchEndpoint = artistItem.shuffleEndpoint;
                                if (watchEndpoint != null) {
                                    str = watchEndpoint.playlistId;
                                    if (str != null) {
                                        watchEndpoint = new WatchEndpoint(52, null, str, null);
                                    }
                                    playerConnection.playQueue(new YouTubeQueue(watchEndpoint, mediaMetadata, i, objArr == true ? 1 : 0));
                                }
                            }
                            break;
                        } while ((songItem != null ? songItem.album : null) == null);
                        artistSection = (ArtistSection) next;
                        if (artistSection != null) {
                            browseEndpoint = artistSection.moreEndpoint;
                        } else {
                            browseEndpoint = null;
                        }
                        i = 2;
                        if (browseEndpoint != null) {
                            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                            AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new DiscordRpcManager.AnonymousClass4(browseEndpoint, playerConnection, str2, artistPage, artistSection, null, (byte) 8), 2);
                        } else if (artistSection != null) {
                            List list3 = artistSection.items;
                            arrayList = new ArrayList();
                            while (r3.hasNext()) {
                                if (obj4 instanceof SongItem) {
                                    arrayList.add(obj4);
                                }
                            }
                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                            size = arrayList.size();
                            i2 = 0;
                            while (i2 < size) {
                                Object obj6 = arrayList.get(i2);
                                i2++;
                                arrayList2.add(UuidKt.toMediaItem((SongItem) obj6));
                            }
                            if (str2 == null) {
                                str2 = artistItem.title;
                            }
                            playerConnection.playQueue(new ListQueue(str2, arrayList2, 0, 0L, 12, null));
                        } else {
                            watchEndpoint = artistItem.shuffleEndpoint;
                            if (watchEndpoint != null) {
                                str = watchEndpoint.playlistId;
                                if (str != null) {
                                    watchEndpoint = new WatchEndpoint(52, null, str, null);
                                }
                                playerConnection.playQueue(new YouTubeQueue(watchEndpoint, mediaMetadata, i, objArr == true ? 1 : 0));
                            }
                        }
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ OriginalLyricsKt$$ExternalSyntheticLambda4(boolean z, PlayerConnection playerConnection, String str, ArtistPage artistPage, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2) {
        this.f$5 = z;
        this.f$1 = playerConnection;
        this.f$2 = str;
        this.f$4 = artistPage;
        this.f$0 = coroutineScope;
        this.f$3 = mutableState;
        this.f$6 = mutableState2;
    }
}
