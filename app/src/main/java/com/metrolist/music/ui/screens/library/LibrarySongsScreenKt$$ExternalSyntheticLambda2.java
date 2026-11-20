package com.metrolist.music.ui.screens.library;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibrarySongsScreenKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ State f$11;
    public final /* synthetic */ Object f$12;
    public final /* synthetic */ Object f$13;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ State f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ LibrarySongsScreenKt$$ExternalSyntheticLambda2(CoroutineScope coroutineScope, Context context, String str, ViewModel viewModel, MutableState mutableState, MutableState mutableState2, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, String str2, String str3, String str4, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState3, MutableState mutableState4, byte b) {
        this.$r8$classId = b;
        this.f$0 = coroutineScope;
        this.f$1 = context;
        this.f$2 = str;
        this.f$3 = viewModel;
        this.f$4 = mutableState;
        this.f$5 = mutableState2;
        this.f$6 = parcelableSnapshotMutableIntState;
        this.f$7 = str2;
        this.f$8 = str3;
        this.f$9 = str4;
        this.f$10 = parcelableSnapshotMutableIntState2;
        this.f$11 = parcelableSnapshotMutableFloatState;
        this.f$12 = mutableState3;
        this.f$13 = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        State state = this.f$11;
        State state2 = this.f$6;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$10;
        Object obj3 = this.f$13;
        Object obj4 = this.f$12;
        Object obj5 = this.f$3;
        Object obj6 = this.f$9;
        Object obj7 = this.f$8;
        Object obj8 = this.f$7;
        Object obj9 = this.f$2;
        Object obj10 = this.f$1;
        Object obj11 = this.f$0;
        switch (b) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) obj11;
                Context context = (Context) obj10;
                String str = (String) obj9;
                LibrarySongsViewModel librarySongsViewModel = (LibrarySongsViewModel) obj5;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) state2;
                String str2 = (String) obj8;
                String str3 = (String) obj7;
                String str4 = (String) obj6;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) obj2;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) state;
                MutableState mutableState = (MutableState) obj4;
                MutableState mutableState2 = (MutableState) obj3;
                List list = (List) obj;
                list.getClass();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            try {
                                context.getContentResolver().takePersistableUriPermission((Uri) it.next(), 1);
                            } catch (SecurityException unused) {
                                Timber.Forest.getClass();
                                ConnectionPool.w$1(new Object[0]);
                            }
                        } catch (SecurityException unused2) {
                        }
                    }
                    mutableState2.setValue(AwaitKt.launch$default(coroutineScope, null, null, new LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2(list, str, librarySongsViewModel, this.f$4, this.f$5, parcelableSnapshotMutableIntState, context, str2, str3, str4, parcelableSnapshotMutableIntState2, parcelableSnapshotMutableFloatState, mutableState, null, (byte) 0), 3));
                }
                break;
            case 1:
                CoroutineScope coroutineScope2 = (CoroutineScope) obj11;
                Context context2 = (Context) obj10;
                String str5 = (String) obj9;
                AutoPlaylistViewModel autoPlaylistViewModel = (AutoPlaylistViewModel) obj5;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3 = (ParcelableSnapshotMutableIntState) state2;
                String str6 = (String) obj8;
                String str7 = (String) obj7;
                String str8 = (String) obj6;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState4 = (ParcelableSnapshotMutableIntState) obj2;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = (ParcelableSnapshotMutableFloatState) state;
                MutableState mutableState3 = (MutableState) obj4;
                MutableState mutableState4 = (MutableState) obj3;
                List list2 = (List) obj;
                list2.getClass();
                if (!list2.isEmpty()) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        try {
                            context2.getContentResolver().takePersistableUriPermission((Uri) it2.next(), 1);
                        } catch (SecurityException unused3) {
                            Timber.Forest.getClass();
                            ConnectionPool.w$1(new Object[0]);
                        }
                    }
                    mutableState4.setValue(AwaitKt.launch$default(coroutineScope2, null, null, new LibrarySongsScreenKt$LibrarySongsScreen$filePickerLauncher$1$1$2(list2, str5, autoPlaylistViewModel, this.f$4, this.f$5, parcelableSnapshotMutableIntState3, context2, str6, str7, str8, parcelableSnapshotMutableIntState4, parcelableSnapshotMutableFloatState2, mutableState3, null, (byte) 1), 3));
                }
                break;
            default:
                State state3 = (State) obj11;
                State state4 = (State) obj10;
                State state5 = (State) obj9;
                OnlinePodcastViewModel onlinePodcastViewModel = (OnlinePodcastViewModel) obj8;
                List list3 = (List) obj7;
                NavHostController navHostController = (NavHostController) obj6;
                State state6 = (State) obj5;
                HapticFeedback hapticFeedback = (HapticFeedback) obj4;
                MenuState menuState = (MenuState) obj3;
                PlayerConnection playerConnection = (PlayerConnection) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                if (((PodcastItem) state3.getValue()) == null && ((Boolean) state4.getValue()).booleanValue()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent, "loading_placeholder", null, OnlinePodcastScreenKt.f408lambda$1886582408, 2);
                } else if (((String) state5.getValue()) == null) {
                    PodcastItem podcastItem = (PodcastItem) state3.getValue();
                    if (podcastItem != null) {
                        if (!((Boolean) this.f$4.getValue()).booleanValue()) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "podcast_header", null, new ComposableLambdaImpl(true, 534598146, new QueueMenuKt$$ExternalSyntheticLambda9((Object) podcastItem, (Object) onlinePodcastViewModel, (Object) navHostController, (Object) this.f$5, (Object) state6, (byte) 13)), 2);
                        }
                        TopPlaylistScreenKt$$ExternalSyntheticLambda8 topPlaylistScreenKt$$ExternalSyntheticLambda8 = new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 14);
                        lazyListIntervalContent.items(list3.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(topPlaylistScreenKt$$ExternalSyntheticLambda8, list3, (byte) 7), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list3, (byte) 10), new ComposableLambdaImpl(true, 2039820996, new YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(list3, hapticFeedback, menuState, this.f$6, playerConnection, list3, state3, this.f$11, (byte) 4)));
                    }
                } else {
                    LazyListIntervalContent.item$default(lazyListIntervalContent, "error", null, new ComposableLambdaImpl(true, -1944452625, new AlbumMenuKt$$ExternalSyntheticLambda11(onlinePodcastViewModel, state5, (byte) 27)), 2);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LibrarySongsScreenKt$$ExternalSyntheticLambda2(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, OnlinePodcastViewModel onlinePodcastViewModel, List list, MutableState mutableState4, NavHostController navHostController, MutableState mutableState5, MutableState mutableState6, HapticFeedback hapticFeedback, MenuState menuState, MutableState mutableState7, PlayerConnection playerConnection, MutableState mutableState8) {
        this.$r8$classId = (byte) 2;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = mutableState3;
        this.f$7 = onlinePodcastViewModel;
        this.f$8 = list;
        this.f$4 = mutableState4;
        this.f$9 = navHostController;
        this.f$5 = mutableState5;
        this.f$3 = mutableState6;
        this.f$12 = hapticFeedback;
        this.f$13 = menuState;
        this.f$6 = mutableState7;
        this.f$10 = playerConnection;
        this.f$11 = mutableState8;
    }
}
