package com.metrolist.music.ui.player;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.PlayerConnection;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueKt$Queue$5$4$1$1$4$1$1$1 extends SuspendLambda implements Function2 {
    public Object $coroutineScope;
    public final /* synthetic */ MutableState $currentItem$delegate;
    public Object $dismissBoxState;
    public final /* synthetic */ MutableState $dismissJob$delegate;
    public boolean $isListenTogetherGuest;
    public final /* synthetic */ List $mutableQueueWindows;
    public Object $playerConnection;
    public MutableState $processedDismiss$delegate;
    public final /* synthetic */ byte $r8$classId = 0;
    public Object $removedSongMsg;
    public Object $snackbarHostState;
    public final /* synthetic */ Object $undoStr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueKt$Queue$5$4$1$1$4$1$1$1(SwipeToDismissBoxState swipeToDismissBoxState, boolean z, PlayerConnection playerConnection, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, SnackbarHostState snackbarHostState, String str, String str2, SnapshotStateList snapshotStateList, Continuation continuation) {
        super(2, continuation);
        this.$dismissBoxState = swipeToDismissBoxState;
        this.$isListenTogetherGuest = z;
        this.$playerConnection = playerConnection;
        this.$coroutineScope = coroutineScope;
        this.$processedDismiss$delegate = mutableState;
        this.$currentItem$delegate = mutableState2;
        this.$dismissJob$delegate = mutableState3;
        this.$snackbarHostState = snackbarHostState;
        this.$removedSongMsg = str;
        this.$undoStr = str2;
        this.$mutableQueueWindows = snapshotStateList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        List list = this.$mutableQueueWindows;
        Object obj2 = this.$undoStr;
        switch (b) {
            case 0:
                return new QueueKt$Queue$5$4$1$1$4$1$1$1((SwipeToDismissBoxState) this.$dismissBoxState, this.$isListenTogetherGuest, (PlayerConnection) this.$playerConnection, (CoroutineScope) this.$coroutineScope, this.$processedDismiss$delegate, this.$currentItem$delegate, this.$dismissJob$delegate, (SnackbarHostState) this.$snackbarHostState, (String) this.$removedSongMsg, (String) obj2, (SnapshotStateList) list, continuation);
            case 1:
                List list2 = this.$mutableQueueWindows;
                MutableState mutableState = this.$dismissJob$delegate;
                return new QueueKt$Queue$5$4$1$1$4$1$1$1(this.$currentItem$delegate, (MusicDatabase) obj2, list2, mutableState, continuation);
            default:
                MutableState mutableState2 = this.$dismissJob$delegate;
                return new QueueKt$Queue$5$4$1$1$4$1$1$1((SnapshotStateList) list, this.$currentItem$delegate, (MusicDatabase) obj2, mutableState2, continuation);
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
                ((QueueKt$Queue$5$4$1$1$4$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 1:
                return ((QueueKt$Queue$5$4$1$1$4$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((QueueKt$Queue$5$4$1$1$4$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x012d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0158  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00a9 -> B:19:0x00ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x014d -> B:39:0x0150). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$4$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueKt$Queue$5$4$1$1$4$1$1$1(MutableState mutableState, MusicDatabase musicDatabase, List list, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$currentItem$delegate = mutableState;
        this.$undoStr = musicDatabase;
        this.$mutableQueueWindows = list;
        this.$dismissJob$delegate = mutableState2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueueKt$Queue$5$4$1$1$4$1$1$1(SnapshotStateList snapshotStateList, MutableState mutableState, MusicDatabase musicDatabase, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$mutableQueueWindows = snapshotStateList;
        this.$currentItem$delegate = mutableState;
        this.$undoStr = musicDatabase;
        this.$dismissJob$delegate = mutableState2;
    }
}
