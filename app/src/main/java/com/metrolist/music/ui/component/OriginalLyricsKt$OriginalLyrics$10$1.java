package com.metrolist.music.ui.component;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.CsvImportState;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OriginalLyricsKt$OriginalLyrics$10$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ParcelableSnapshotMutableIntState $currentLineIndex$delegate;
    public final /* synthetic */ Object $currentPlaybackPosition$delegate;
    public final /* synthetic */ State $currentSong$delegate;
    public final /* synthetic */ MutableState $isSeeking$delegate;
    public final /* synthetic */ List $lines;
    public final /* synthetic */ Object $lyrics;
    public final /* synthetic */ Object $playerConnection;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object $sliderPositionProvider;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalLyricsKt$OriginalLyrics$10$1(BackupRestoreViewModel backupRestoreViewModel, Context context, Uri uri, CsvImportState csvImportState, SnapshotStateList snapshotStateList, SnapshotStateList snapshotStateList2, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.L$0 = backupRestoreViewModel;
        this.$lyrics = context;
        this.$sliderPositionProvider = uri;
        this.$playerConnection = csvImportState;
        this.$lines = snapshotStateList;
        this.$currentPlaybackPosition$delegate = snapshotStateList2;
        this.$currentLineIndex$delegate = parcelableSnapshotMutableIntState;
        this.$isSeeking$delegate = mutableState;
        this.$currentSong$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$currentPlaybackPosition$delegate;
        Object obj3 = this.$playerConnection;
        Object obj4 = this.$sliderPositionProvider;
        Object obj5 = this.$lyrics;
        switch (b) {
            case 0:
                State state = this.$currentSong$delegate;
                OriginalLyricsKt$OriginalLyrics$10$1 originalLyricsKt$OriginalLyrics$10$1 = new OriginalLyricsKt$OriginalLyrics$10$1((String) obj5, (Function0) obj4, (PlayerConnection) obj3, this.$lines, this.$currentLineIndex$delegate, this.$isSeeking$delegate, (ParcelableSnapshotMutableLongState) obj2, state, continuation);
                originalLyricsKt$OriginalLyrics$10$1.L$0 = obj;
                return originalLyricsKt$OriginalLyrics$10$1;
            default:
                return new OriginalLyricsKt$OriginalLyrics$10$1((BackupRestoreViewModel) this.L$0, (Context) obj5, (Uri) obj4, (CsvImportState) obj3, (SnapshotStateList) this.$lines, (SnapshotStateList) obj2, this.$currentLineIndex$delegate, this.$isSeeking$delegate, (MutableState) this.$currentSong$delegate, continuation);
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
        }
        return ((OriginalLyricsKt$OriginalLyrics$10$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0121  */
    /* JADX WARN: Code duplicated, block: B:53:0x0136 A[LOOP:0: B:49:0x011f->B:53:0x0136, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d0 -> B:34:0x00d5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$10$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalLyricsKt$OriginalLyrics$10$1(String str, Function0 function0, PlayerConnection playerConnection, List list, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, State state, Continuation continuation) {
        super(2, continuation);
        this.$lyrics = str;
        this.$sliderPositionProvider = function0;
        this.$playerConnection = playerConnection;
        this.$lines = list;
        this.$currentLineIndex$delegate = parcelableSnapshotMutableIntState;
        this.$isSeeking$delegate = mutableState;
        this.$currentPlaybackPosition$delegate = parcelableSnapshotMutableLongState;
        this.$currentSong$delegate = state;
    }
}
