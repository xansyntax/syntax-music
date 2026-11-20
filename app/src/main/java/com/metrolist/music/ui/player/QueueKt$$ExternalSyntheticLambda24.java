package com.metrolist.music.ui.player;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.state.ToggleableState;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.constants.DensityScale;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.ArtistViewModel$fetchArtistsFromYTM$1;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel;
import dagger.hilt.EntryPoints;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda24 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda24(LazyListState lazyListState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2) {
        this.$r8$classId = (byte) 16;
        this.f$1 = lazyListState;
        this.f$0 = parcelableSnapshotMutableIntState;
        this.f$2 = parcelableSnapshotMutableIntState2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        int i = 0;
        z = false;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                PlayerConnection playerConnection = (PlayerConnection) obj;
                AwaitKt.launch$default((CoroutineScope) obj3, null, null, new DataStoreKt$get$1(obj2, (Object) playerConnection, (Continuation) (objArr == true ? 1 : 0), (byte) 5), 3).invokeOnCompletion(new MimesKt$$ExternalSyntheticLambda0((byte) 5, playerConnection));
                return unit;
            case 1:
                return Long.valueOf(((Boolean) ((MutableState) obj3).getValue()).booleanValue() ? ((Number) ((State) obj2).getValue()).longValue() : ((ParcelableSnapshotMutableLongState) obj).getLongValue());
            case 2:
                SongItem songItem = (SongItem) obj2;
                MenuState menuState = (MenuState) obj;
                ((PlatformHapticFeedback) ((HapticFeedback) obj3)).m578performHapticFeedbackCdsT49E(0);
                if (songItem != null) {
                    menuState.show(new ComposableLambdaImpl(true, -834105116, new AlbumMenuKt$$ExternalSyntheticLambda11(songItem, menuState, (byte) 17)));
                }
                return unit;
            case 3:
                PlayerConnection playerConnection2 = (PlayerConnection) obj;
                ArrayList arrayList = (ArrayList) obj2;
                String str = ((HomePage.Section) obj3).title;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                while (i < size) {
                    Object obj4 = arrayList.get(i);
                    i++;
                    arrayList2.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata((SongItem) obj4)));
                }
                playerConnection2.playQueue(new ListQueue(str, arrayList2, 0, 0L, 12, null));
                return unit;
            case 4:
                BrowseEndpoint browseEndpoint = (BrowseEndpoint) obj;
                String str2 = ((ArtistViewModel) obj2).artistId;
                String str3 = browseEndpoint.browseId;
                String str4 = browseEndpoint.params;
                StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("artist/", str2, "/items?browseId=", str3, "?params=");
                sbM.append(str4);
                NavHostController.navigate$default((NavHostController) obj3, sbM.toString());
                return unit;
            case 5:
                ArtistPage artistPage = (ArtistPage) obj3;
                ArtistViewModel artistViewModel = (ArtistViewModel) obj2;
                MutableState mutableState = (MutableState) obj;
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                if (!((Boolean) mutableState.getValue()).booleanValue() && artistPage == null) {
                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(artistViewModel), null, null, new ArtistViewModel$fetchArtistsFromYTM$1(artistViewModel, null), 3);
                }
                return unit;
            case 6:
                PlayerConnection playerConnection3 = (PlayerConnection) obj;
                State state = (State) obj2;
                Artist artist = (Artist) ((State) obj3).getValue();
                String str5 = artist != null ? artist.artist.name : null;
                List listShuffled = CollectionsKt__IterablesKt.shuffled((List) state.getValue());
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listShuffled, 10));
                ArrayList arrayList4 = (ArrayList) listShuffled;
                int size2 = arrayList4.size();
                while (i4 < size2) {
                    Object obj5 = arrayList4.get(i4);
                    i4++;
                    arrayList3.add(UuidKt.toMediaItem((Song) obj5));
                }
                playerConnection3.playQueue(new ListQueue(str5, arrayList3, 0, 0L, 12, null));
                return unit;
            case 7:
                CoroutineScope coroutineScope = (CoroutineScope) obj3;
                MutableState mutableState2 = (MutableState) obj2;
                LibraryPodcastsViewModel libraryPodcastsViewModel = (LibraryPodcastsViewModel) obj;
                if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    mutableState2.setValue(Boolean.TRUE);
                    AwaitKt.launch$default(coroutineScope, null, null, new DataStoreKt$get$1((Object) libraryPodcastsViewModel, (Object) mutableState2, (Continuation) (objArr2 == true ? 1 : 0), (byte) 11), 3);
                }
                return unit;
            case 8:
                PlayerConnection playerConnection4 = (PlayerConnection) obj;
                String str6 = (String) obj3;
                List listShuffled2 = CollectionsKt__IterablesKt.shuffled((List) ((MutableState) obj2).getValue());
                ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listShuffled2, 10));
                ArrayList arrayList6 = (ArrayList) listShuffled2;
                int size3 = arrayList6.size();
                while (i3 < size3) {
                    Object obj6 = arrayList6.get(i3);
                    i3++;
                    arrayList5.add(UuidKt.toMediaItem((Song) obj6));
                }
                playerConnection4.playQueue(new ListQueue(str6, arrayList5, 0, 0L, 12, null));
                return unit;
            case 9:
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj3, DefaultIoScheduler.INSTANCE, null, new SyncUtils.AnonymousClass3((MusicDatabase) obj2, objArr3 == true ? 1 : 0, (byte) 12), 2);
                ((MutableState) obj).setValue(Boolean.FALSE);
                return unit;
            case 10:
                ((MutableState) obj2).setValue((MusicAlarmEntry) obj3);
                ((MutableState) obj).setValue(Boolean.TRUE);
                return unit;
            case 11:
                ((Function1) obj3).invoke(Float.valueOf(((DensityScale) obj2).value));
                ((MutableState) obj).setValue(Boolean.FALSE);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Function1) obj3).invoke((Proxy.Type) obj2);
                ((MutableState) obj).setValue(Boolean.FALSE);
                return unit;
            case 13:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj2;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj;
                boolean z2 = ((ToggleableState) obj3) != ToggleableState.On;
                ListIterator listIterator = snapshotStateList.listIterator();
                while (true) {
                    StateListIterator stateListIterator = (StateListIterator) listIterator;
                    if (!stateListIterator.hasNext()) {
                        mimesKt$$ExternalSyntheticLambda0.invoke(CollectionsKt.joinToString$default(snapshotStateList, ",", null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 15), 30));
                        return unit;
                    }
                    Object next = stateListIterator.next();
                    int i5 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    snapshotStateList.set(i2, new Pair((String) ((Pair) next).first, Boolean.valueOf(z2)));
                    i2 = i5;
                }
                break;
            case 14:
                ((Function1) obj3).invoke((String) ((MutableState) obj).getValue());
                ((Function0) obj2).invoke();
                return unit;
            case 15:
                ((MimesKt$$ExternalSyntheticLambda0) obj3).invoke(Float.valueOf(((ParcelableSnapshotMutableFloatState) obj2).getFloatValue()));
                ((MutableState) obj).setValue(Boolean.FALSE);
                return unit;
            case 16:
                LazyListState lazyListState = (LazyListState) obj2;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj3;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) obj;
                if (parcelableSnapshotMutableIntState.getIntValue() == lazyListState.getFirstVisibleItemIndex() ? parcelableSnapshotMutableIntState2.getIntValue() >= lazyListState.getFirstVisibleItemScrollOffset() : parcelableSnapshotMutableIntState.getIntValue() > lazyListState.getFirstVisibleItemIndex()) {
                    z = true;
                }
                parcelableSnapshotMutableIntState.setIntValue(lazyListState.getFirstVisibleItemIndex());
                parcelableSnapshotMutableIntState2.setIntValue(lazyListState.getFirstVisibleItemScrollOffset());
                return Boolean.valueOf(z);
            default:
                EntryPoints entryPoints = ((CertificatePinner) obj3).certificateChainCleaner;
                entryPoints.getClass();
                return entryPoints.clean(((Address) obj).url.host, ((Handshake) obj2).peerCertificates());
        }
    }

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda24(PlayerConnection playerConnection, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$2 = playerConnection;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda24(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
