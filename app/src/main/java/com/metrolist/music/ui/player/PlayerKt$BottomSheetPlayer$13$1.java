package com.metrolist.music.ui.player;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$14$1$3$1$11$1$1$2$1;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.ConvertedSongLog;
import com.metrolist.music.viewmodels.CsvImportState;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerKt$BottomSheetPlayer$13$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $castDuration$delegate;
    public final /* synthetic */ Object $castPosition$delegate;
    public final /* synthetic */ Object $duration$delegate;
    public /* synthetic */ Object $isCasting$delegate;
    public final /* synthetic */ Object $lastManualSeekTime$delegate;
    public final /* synthetic */ Object $position$delegate;
    public final /* synthetic */ byte $r8$classId = 4;
    public final /* synthetic */ Object $sliderPosition$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerKt$BottomSheetPlayer$13$1(SwipeToDismissBoxState swipeToDismissBoxState, MutableState mutableState, MutableState mutableState2, MusicDatabase musicDatabase, SyncUtils syncUtils, MutableState mutableState3, MutableState mutableState4, Continuation continuation) {
        super(2, continuation);
        this.$lastManualSeekTime$delegate = swipeToDismissBoxState;
        this.$isCasting$delegate = mutableState;
        this.$sliderPosition$delegate = mutableState2;
        this.$position$delegate = musicDatabase;
        this.$duration$delegate = syncUtils;
        this.$castPosition$delegate = mutableState3;
        this.$castDuration$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$duration$delegate;
        Object obj3 = this.$position$delegate;
        Object obj4 = this.$lastManualSeekTime$delegate;
        Object obj5 = this.$castDuration$delegate;
        Object obj6 = this.$castPosition$delegate;
        Object obj7 = this.$sliderPosition$delegate;
        switch (b) {
            case 0:
                return new PlayerKt$BottomSheetPlayer$13$1((MutableState) this.$isCasting$delegate, (MutableState) obj7, (ParcelableSnapshotMutableLongState) obj4, (MutableState) obj6, (ParcelableSnapshotMutableLongState) obj3, (MutableState) obj5, (ParcelableSnapshotMutableLongState) obj2, continuation);
            case 1:
                return new PlayerKt$BottomSheetPlayer$13$1((SnapshotStateList) obj5, (MutableState) this.$isCasting$delegate, (ParcelableSnapshotMutableFloatState) obj4, (ParcelableSnapshotMutableIntState) obj3, (ParcelableSnapshotMutableIntState) obj2, (MutableState) obj7, (MutableState) obj6, continuation);
            case 2:
                return new PlayerKt$BottomSheetPlayer$13$1((Context) obj6, (String) obj5, (Ref$IntRef) obj4, (Function0) obj3, (Function0) obj2, (MutableState) this.$isCasting$delegate, (MutableState) obj7, continuation);
            case 3:
                return new PlayerKt$BottomSheetPlayer$13$1((SwipeToDismissBoxState) obj4, (MutableState) this.$isCasting$delegate, (MutableState) obj7, (MusicDatabase) obj3, (SyncUtils) obj2, (MutableState) obj6, (MutableState) obj5, continuation);
            default:
                PlayerKt$BottomSheetPlayer$13$1 playerKt$BottomSheetPlayer$13$1 = new PlayerKt$BottomSheetPlayer$13$1((Context) obj7, (Uri) obj6, (CsvImportState) obj5, (BackupRestoreViewModel) obj4, (StatsScreenKt$$ExternalSyntheticLambda0) obj3, (BottomSheetKt$$ExternalSyntheticLambda9) obj2, continuation);
                playerKt$BottomSheetPlayer$13$1.$isCasting$delegate = obj;
                return playerKt$BottomSheetPlayer$13$1;
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
                ((PlayerKt$BottomSheetPlayer$13$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 1:
                ((PlayerKt$BottomSheetPlayer$13$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 2:
                ((PlayerKt$BottomSheetPlayer$13$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 3:
                ((PlayerKt$BottomSheetPlayer$13$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            default:
                return ((PlayerKt$BottomSheetPlayer$13$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x01ad  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object failure;
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$duration$delegate;
        Object obj3 = this.$position$delegate;
        Object obj4 = this.$lastManualSeekTime$delegate;
        Object obj5 = this.$castDuration$delegate;
        Object obj6 = this.$castPosition$delegate;
        Object obj7 = this.$sliderPosition$delegate;
        switch (b) {
            case 0:
                MutableState mutableState = (MutableState) obj5;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) ((MutableState) this.$isCasting$delegate).getValue()).booleanValue() && ((Long) ((MutableState) obj7).getValue()) == null && System.currentTimeMillis() - ((ParcelableSnapshotMutableLongState) obj4).getLongValue() > 1500) {
                    ((ParcelableSnapshotMutableLongState) obj3).setLongValue(((Number) ((MutableState) obj6).getValue()).longValue());
                    if (((Number) mutableState.getValue()).longValue() > 0) {
                        ((ParcelableSnapshotMutableLongState) obj2).setLongValue(((Number) mutableState.getValue()).longValue());
                    }
                }
                return unit;
            case 1:
                ResultKt.throwOnFailure(obj);
                ((MutableState) this.$isCasting$delegate).setValue(Boolean.TRUE);
                ((ParcelableSnapshotMutableFloatState) obj4).setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                ((ParcelableSnapshotMutableIntState) obj3).setIntValue(-1);
                ((ParcelableSnapshotMutableIntState) obj2).setIntValue(0);
                ((MutableState) obj7).setValue(Boolean.FALSE);
                ((SnapshotStateList) obj5).clear();
                ((MutableState) obj6).setValue(EmptySet.INSTANCE);
                return unit;
            case 2:
                ResultKt.throwOnFailure(obj);
                Toast.makeText((Context) obj6, String.format((String) obj5, Arrays.copyOf(new Object[]{new Integer(((Ref$IntRef) obj4).element)}, 1)), 0).show();
                MutableState mutableState2 = (MutableState) this.$isCasting$delegate;
                Boolean bool = Boolean.FALSE;
                mutableState2.setValue(bool);
                ((MutableState) obj7).setValue(bool);
                ((Function0) obj3).invoke();
                ((Function0) obj2).invoke();
                return unit;
            case 3:
                byte b2 = 1;
                MutableState mutableState3 = (MutableState) obj7;
                ResultKt.throwOnFailure(obj);
                SwipeToDismissBoxValue currentValue = ((SwipeToDismissBoxState) obj4).getCurrentValue();
                if (((Boolean) ((MutableState) this.$isCasting$delegate).getValue()).booleanValue() && !((Boolean) mutableState3.getValue()).booleanValue() && (currentValue == SwipeToDismissBoxValue.StartToEnd || currentValue == SwipeToDismissBoxValue.EndToStart)) {
                    mutableState3.setValue(Boolean.TRUE);
                    MusicDatabase musicDatabase = (MusicDatabase) obj3;
                    SyncUtils syncUtils = (SyncUtils) obj2;
                    MutableState mutableState4 = (MutableState) obj5;
                    Playlist playlist = (Playlist) ((MutableState) obj6).getValue();
                    String str = playlist != null ? playlist.playlist.browseId : null;
                    String str2 = ((PlaylistSong) mutableState4.getValue()).map.setVideoId;
                    String str3 = ((PlaylistSong) mutableState4.getValue()).map.songId;
                    String str4 = ((PlaylistSong) mutableState4.getValue()).map.playlistId;
                    musicDatabase.transaction(new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(str4, mutableState4, b2));
                    if (str != null) {
                        syncUtils.scheduleRemoveFromPlaylist(str, str3, str4, new SongMenuKt$SongMenu$14$1$3$1$11$1$1$2$1(str2, null, (byte) 1));
                    }
                }
                if (currentValue == SwipeToDismissBoxValue.Settled) {
                    mutableState3.setValue(Boolean.FALSE);
                }
                return unit;
            default:
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                CsvImportState csvImportState = (CsvImportState) obj5;
                BackupRestoreViewModel backupRestoreViewModel = (BackupRestoreViewModel) obj4;
                StatsScreenKt$$ExternalSyntheticLambda0 statsScreenKt$$ExternalSyntheticLambda0 = (StatsScreenKt$$ExternalSyntheticLambda0) obj3;
                BottomSheetKt$$ExternalSyntheticLambda9 bottomSheetKt$$ExternalSyntheticLambda9 = (BottomSheetKt$$ExternalSyntheticLambda9) obj2;
                try {
                    InputStream inputStreamOpenInputStream = ((Context) obj7).getContentResolver().openInputStream((Uri) obj6);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            ArrayList lines = RegexKt.readLines(new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, Charsets.UTF_8), 8192));
                            boolean z = csvImportState.hasHeader;
                            int i2 = csvImportState.titleColumnIndex;
                            int i3 = csvImportState.artistColumnIndex;
                            int size = lines.size() - (z ? 1 : 0);
                            int i4 = 0;
                            for (Object obj8 : CollectionsKt.drop(lines, z ? 1 : 0)) {
                                int i5 = i4 + 1;
                                if (i4 < 0) {
                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                    throw null;
                                }
                                backupRestoreViewModel.getClass();
                                ArrayList csvLine = BackupRestoreViewModel.parseCsvLine((String) obj8);
                                if (!csvLine.isEmpty() && i3 < csvLine.size() && i2 < csvLine.size()) {
                                    String string = StringsKt.trim((String) csvLine.get(i2)).toString();
                                    String string2 = StringsKt.trim((String) csvLine.get(i3)).toString();
                                    if (string.length() > 0 && string2.length() > 0) {
                                        List listSplit$default = StringsKt.split$default(string2, new String[]{";", ","}, i, 6);
                                        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                                        Iterator it = listSplit$default.iterator();
                                        while (it.hasNext()) {
                                            arrayList3.add(StringsKt.trim((String) it.next()).toString());
                                        }
                                        ArrayList arrayList4 = new ArrayList();
                                        int size2 = arrayList3.size();
                                        int i6 = 0;
                                        while (i6 < size2) {
                                            Object obj9 = arrayList3.get(i6);
                                            i6++;
                                            if (((String) obj9).length() > 0) {
                                                arrayList4.add(obj9);
                                            }
                                        }
                                        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10));
                                        int size3 = arrayList4.size();
                                        int i7 = 0;
                                        while (i7 < size3) {
                                            Object obj10 = arrayList4.get(i7);
                                            i7++;
                                            arrayList5.add(new ArtistEntity("", (String) obj10, null, null, null, false, null, 508));
                                        }
                                        arrayList.add(new Song(new SongEntity("", string, 0, null, null, null, false, false, null, null, false, false, null, 134217724), arrayList5, null, 28));
                                        arrayList2.add(0, new ConvertedSongLog(string, CollectionsKt.joinToString$default(arrayList5, ", ", null, null, new HttpClient$$ExternalSyntheticLambda1((byte) 2), 30)));
                                        if (arrayList2.size() > 3) {
                                            arrayList2.remove(arrayList2.size() - 1);
                                        }
                                        statsScreenKt$$ExternalSyntheticLambda0.invoke(CollectionsKt.toList(arrayList2));
                                    }
                                }
                                bottomSheetKt$$ExternalSyntheticLambda9.invoke(new Integer((i5 * 100) / size));
                                i4 = i5;
                                unit = unit;
                                i = 0;
                                failure = new Result.Failure(th);
                            }
                            Unit unit2 = unit;
                            inputStreamOpenInputStream.close();
                            failure = unit2;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CharsKt.closeFinally(inputStreamOpenInputStream, th);
                                throw th2;
                            }
                        }
                    } else {
                        failure = null;
                    }
                } catch (Throwable th3) {
                    failure = new Result.Failure(th3);
                }
                Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
                if (thM1866exceptionOrNullimpl != null) {
                    thM1866exceptionOrNullimpl.printStackTrace();
                }
                return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerKt$BottomSheetPlayer$13$1(Context context, String str, Ref$IntRef ref$IntRef, Function0 function0, Function0 function1, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$castPosition$delegate = context;
        this.$castDuration$delegate = str;
        this.$lastManualSeekTime$delegate = ref$IntRef;
        this.$position$delegate = function0;
        this.$duration$delegate = function1;
        this.$isCasting$delegate = mutableState;
        this.$sliderPosition$delegate = mutableState2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerKt$BottomSheetPlayer$13$1(Context context, Uri uri, CsvImportState csvImportState, BackupRestoreViewModel backupRestoreViewModel, StatsScreenKt$$ExternalSyntheticLambda0 statsScreenKt$$ExternalSyntheticLambda0, BottomSheetKt$$ExternalSyntheticLambda9 bottomSheetKt$$ExternalSyntheticLambda9, Continuation continuation) {
        super(2, continuation);
        this.$sliderPosition$delegate = context;
        this.$castPosition$delegate = uri;
        this.$castDuration$delegate = csvImportState;
        this.$lastManualSeekTime$delegate = backupRestoreViewModel;
        this.$position$delegate = statsScreenKt$$ExternalSyntheticLambda0;
        this.$duration$delegate = bottomSheetKt$$ExternalSyntheticLambda9;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerKt$BottomSheetPlayer$13$1(MutableState mutableState, MutableState mutableState2, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, MutableState mutableState3, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, MutableState mutableState4, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3, Continuation continuation) {
        super(2, continuation);
        this.$isCasting$delegate = mutableState;
        this.$sliderPosition$delegate = mutableState2;
        this.$lastManualSeekTime$delegate = parcelableSnapshotMutableLongState;
        this.$castPosition$delegate = mutableState3;
        this.$position$delegate = parcelableSnapshotMutableLongState2;
        this.$castDuration$delegate = mutableState4;
        this.$duration$delegate = parcelableSnapshotMutableLongState3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerKt$BottomSheetPlayer$13$1(SnapshotStateList snapshotStateList, MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, MutableState mutableState2, MutableState mutableState3, Continuation continuation) {
        super(2, continuation);
        this.$castDuration$delegate = snapshotStateList;
        this.$isCasting$delegate = mutableState;
        this.$lastManualSeekTime$delegate = parcelableSnapshotMutableFloatState;
        this.$position$delegate = parcelableSnapshotMutableIntState;
        this.$duration$delegate = parcelableSnapshotMutableIntState2;
        this.$sliderPosition$delegate = mutableState2;
        this.$castPosition$delegate = mutableState3;
    }
}
