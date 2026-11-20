package com.metrolist.music.ui.screens;

import android.content.Context;
import android.content.Intent;
import android.text.format.Formatter;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda65;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$$ExternalSyntheticLambda106;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.viewmodels.DailyDiscoverItem;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumScreenKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda8(byte b, int i, Object obj, Object obj2, Object obj3) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws IOException {
        byte b = this.$r8$classId;
        byte b2 = 13;
        byte b3 = 7;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                List list = (List) obj5;
                MutableState mutableState = (MutableState) obj4;
                MutableState mutableState2 = (MutableState) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(-850547885);
                    AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState2.getValue();
                    String str = albumWithSongs != null ? albumWithSongs.album.title : null;
                    if (str == null) {
                        str = "";
                    }
                    TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 0, 24960, 110590);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-850686858);
                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_selected, list.size(), new Object[]{Integer.valueOf(list.size())}, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    gapComposer.end(false);
                }
                break;
            case 1:
                Context context = (Context) obj5;
                Function0 function0 = (Function0) obj4;
                ArtistItem artistItem = (ArtistItem) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/channel/" + artistItem.id);
                    context.startActivity(Intent.createChooser(intent, null));
                    function0.invoke();
                }
                break;
            case 2:
                PlayerConnection playerConnection = (PlayerConnection) obj5;
                SongItem songItem = (SongItem) obj4;
                Function0 function1 = (Function0) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    playerConnection.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(SongItem.copy$default(songItem, null, null, YouTubeUtilsKt.resize(songItem.thumbnail, 544, 544), 130815)))));
                    function1.invoke();
                }
                break;
            case 3:
                Context context2 = (Context) obj5;
                Function0 function2 = (Function0) obj4;
                SongItem songItem2 = (SongItem) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/watch?v=" + songItem2.id);
                    context2.startActivity(Intent.createChooser(intent2, null));
                    function2.invoke();
                }
                break;
            case 4:
                Function0 function3 = (Function0) obj5;
                NavHostController navHostController = (NavHostController) obj3;
                MutableState mutableState3 = (MutableState) obj4;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else if (!((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer5.startReplaceGroup(96624262);
                    boolean zChangedInstance = gapComposer5.changedInstance(navHostController);
                    Object objRememberedValue = gapComposer5.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 11);
                        gapComposer5.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function4 = (Function0) objRememberedValue;
                    boolean zChangedInstance2 = gapComposer5.changedInstance(navHostController);
                    Object objRememberedValue2 = gapComposer5.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 12);
                        gapComposer5.updateRememberedValue(objRememberedValue2);
                    }
                    MenuKt.IconButton(function4, (Function0) objRememberedValue2, null, false, null, null, AlbumScreenKt.f313lambda$1790183456, gapComposer5, 1572864);
                    gapComposer5.end(false);
                } else {
                    gapComposer5.startReplaceGroup(96355647);
                    CardKt.IconButton(function3, null, false, null, null, AlbumScreenKt.lambda$59562455, gapComposer5, 1572864, 62);
                    gapComposer5.end(false);
                }
                break;
            case 5:
                ((Integer) obj2).getClass();
                AlbumScreenKt.CrashScreen((String) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 6:
                ((Integer) obj2).getClass();
                HomeScreenKt.DailyDiscoverCard((DailyDiscoverItem) obj5, (Function0) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(9));
                break;
            case 7:
                ((Integer) obj2).getClass();
                LibraryScreenKt.LibraryArtistsScreen((NavHostController) obj5, (Function0) obj4, (LibraryArtistsViewModel) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 8:
                ((Integer) obj2).getClass();
                LibraryScreenKt.PodcastEpisodePlaylistMenu((PodcastEntity) obj5, (MusicDatabase) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(65));
                break;
            case 9:
                ((Integer) obj2).getClass();
                LibraryScreenKt.PodcastArtistChannelItem((String) obj5, (String) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 10:
                MutableState mutableState4 = (MutableState) obj4;
                MutableState mutableState5 = (MutableState) obj3;
                NavHostController navHostController2 = (NavHostController) obj5;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer6.changed(mutableState4) | gapComposer6.changed(mutableState5) | gapComposer6.changedInstance(navHostController2);
                    Object objRememberedValue3 = gapComposer6.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController2, mutableState4, mutableState5, b3);
                        gapComposer6.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function5 = (Function0) objRememberedValue3;
                    boolean zChanged2 = gapComposer6.changed(mutableState4) | gapComposer6.changedInstance(navHostController2);
                    Object objRememberedValue4 = gapComposer6.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController2, mutableState4, (byte) 6);
                        gapComposer6.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.IconButton(function5, (Function0) objRememberedValue4, null, false, null, null, OnlinePodcastScreenKt.f410lambda$246135284, gapComposer6, 1572864);
                }
                break;
            case 11:
                ((Integer) obj2).getClass();
                RecognitionHistoryScreenKt.RecognitionHistoryItem((RecognitionHistory) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(9));
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                NavHostController navHostController3 = (NavHostController) obj5;
                State state = (State) obj3;
                MutableState mutableState6 = (MutableState) obj4;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    MenuKt.m1493TopAppBarGHTll3U(RecognitionHistoryScreenKt.f415lambda$1542181960, null, Expect_jvmKt.rememberComposableLambda(-1790150154, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController3, b2), gapComposer7), Expect_jvmKt.rememberComposableLambda(155611757, new AlbumMenuKt$$ExternalSyntheticLambda11(state, mutableState6, (byte) 28), gapComposer7), CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer7, 3462, 242);
                }
                break;
            case 13:
                int iIntValue8 = ((Integer) obj).intValue();
                int iIntValue9 = ((Integer) obj2).intValue();
                ((ParcelableSnapshotMutableIntState) obj5).setIntValue(iIntValue8);
                ((ParcelableSnapshotMutableIntState) obj3).setIntValue(iIntValue9);
                ((MutableState) obj4).setValue(Boolean.FALSE);
                break;
            case 14:
                Function1 function6 = (Function1) obj5;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj3;
                MutableState mutableState7 = (MutableState) obj4;
                Composer composer8 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    boolean zChanged3 = gapComposer8.changed(function6) | gapComposer8.changed(parcelableSnapshotMutableFloatState) | gapComposer8.changed(mutableState7);
                    Object objRememberedValue5 = gapComposer8.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new ContentSettingsKt$$ExternalSyntheticLambda106(function6, parcelableSnapshotMutableFloatState, mutableState7, (byte) 0);
                        gapComposer8.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, AiSettingsKt.f496lambda$1712455143, gapComposer8, 805306368, 510);
                }
                break;
            case 15:
                ToggleableState toggleableState = (ToggleableState) obj5;
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj4;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj3;
                Composer composer9 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    boolean zChanged4 = gapComposer9.changed(toggleableState.ordinal()) | gapComposer9.changed(snapshotStateList) | gapComposer9.changed(mimesKt$$ExternalSyntheticLambda0);
                    Object objRememberedValue6 = gapComposer9.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new QueueKt$$ExternalSyntheticLambda24(toggleableState, snapshotStateList, mimesKt$$ExternalSyntheticLambda0, b2);
                        gapComposer9.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.TriStateCheckbox(0, null, gapComposer9, null, toggleableState, (Function0) objRememberedValue6, false);
                }
                break;
            case 16:
                Context context3 = (Context) obj5;
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) obj3;
                MutableState mutableState8 = (MutableState) obj4;
                Composer composer10 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    String shortFileSize = Formatter.formatShortFileSize(context3, parcelableSnapshotMutableLongState.getLongValue());
                    shortFileSize.getClass();
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cache_size_warning_message, new Object[]{shortFileSize, (String) mutableState8.getValue()}, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                }
                break;
            case 17:
                MutableState mutableState9 = (MutableState) obj4;
                MutableState mutableState10 = (MutableState) obj3;
                MutableState mutableState11 = (MutableState) obj5;
                Composer composer11 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    boolean zChanged5 = gapComposer11.changed(mutableState9) | gapComposer11.changed(mutableState10) | gapComposer11.changed(mutableState11);
                    Object objRememberedValue7 = gapComposer11.rememberedValue();
                    if (zChanged5 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new PlayerMenuKt$$ExternalSyntheticLambda65(mutableState9, mutableState10, mutableState11, (byte) 7);
                        gapComposer11.updateRememberedValue(objRememberedValue7);
                    }
                    CardKt.TextButton((Function0) objRememberedValue7, null, !((Boolean) mutableState9.getValue()).booleanValue(), null, null, null, LastFMSettingsKt.lambda$694004107, gapComposer11, 805306368, 506);
                }
                break;
            case 18:
                ((Integer) obj2).getClass();
                ListenTogetherSettingsKt.BlockedUsersDialog((Set) obj5, (Function1) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                ListenTogetherSettingsKt.LogsDialog((List) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda8(MutableState mutableState, MutableState mutableState2, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
        this.f$0 = obj;
    }

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda8(Object obj, Object obj2, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$1 = mutableState;
    }

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda8(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
