package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import com.metrolist.music.playback.PlayerConnection;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExperimentalLyricsKt$ExperimentalLyrics$9$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $activeLineIndices$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $currentPositionState$delegate;
    public final /* synthetic */ MutableState $currentSong$delegate;
    public final /* synthetic */ boolean $hasWordTimings;
    public final /* synthetic */ MutableState $isSeeking$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $lastMainMaxSeen$delegate;
    public final /* synthetic */ MutableState $lines$delegate;
    public final /* synthetic */ String $lyrics;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ MutableState $previousScrollActiveIndices$delegate;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $scrollTargetIndex$delegate;
    public final /* synthetic */ Function0 $sliderPositionProvider;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $smoothPositionForSync$delegate;
    public long J$0;
    public long J$1;
    public long J$2;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentalLyricsKt$ExperimentalLyrics$9$1(String str, PlayerConnection playerConnection, Function0 function0, boolean z, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, MutableState mutableState4, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState5, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, Continuation continuation) {
        super(2, continuation);
        this.$lyrics = str;
        this.$playerConnection = playerConnection;
        this.$sliderPositionProvider = function0;
        this.$hasWordTimings = z;
        this.$lines$delegate = mutableState;
        this.$activeLineIndices$delegate = mutableState2;
        this.$isSeeking$delegate = mutableState3;
        this.$currentPositionState$delegate = parcelableSnapshotMutableLongState;
        this.$smoothPositionForSync$delegate = parcelableSnapshotMutableLongState2;
        this.$currentSong$delegate = mutableState4;
        this.$scrollTargetIndex$delegate = parcelableSnapshotMutableIntState;
        this.$previousScrollActiveIndices$delegate = mutableState5;
        this.$lastMainMaxSeen$delegate = parcelableSnapshotMutableIntState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ExperimentalLyricsKt$ExperimentalLyrics$9$1 experimentalLyricsKt$ExperimentalLyrics$9$1 = new ExperimentalLyricsKt$ExperimentalLyrics$9$1(this.$lyrics, this.$playerConnection, this.$sliderPositionProvider, this.$hasWordTimings, this.$lines$delegate, this.$activeLineIndices$delegate, this.$isSeeking$delegate, this.$currentPositionState$delegate, this.$smoothPositionForSync$delegate, this.$currentSong$delegate, this.$scrollTargetIndex$delegate, this.$previousScrollActiveIndices$delegate, this.$lastMainMaxSeen$delegate, continuation);
        experimentalLyricsKt$ExperimentalLyrics$9$1.L$0 = obj;
        return experimentalLyricsKt$ExperimentalLyrics$9$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ExperimentalLyricsKt$ExperimentalLyrics$9$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x021c  */
    /* JADX WARN: Code duplicated, block: B:102:0x0221  */
    /* JADX WARN: Code duplicated, block: B:106:0x024a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:125:0x0286  */
    /* JADX WARN: Code duplicated, block: B:128:0x0295 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:138:0x02df  */
    /* JADX WARN: Code duplicated, block: B:145:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:147:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:150:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:158:0x0319  */
    /* JADX WARN: Code duplicated, block: B:166:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x013c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x01a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x018a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0203 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x02e4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x005c  */
    /* JADX WARN: Code duplicated, block: B:21:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x008e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0091  */
    /* JADX WARN: Code duplicated, block: B:28:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:46:0x0109  */
    /* JADX WARN: Code duplicated, block: B:49:0x0110  */
    /* JADX WARN: Code duplicated, block: B:52:0x012a  */
    /* JADX WARN: Code duplicated, block: B:53:0x012d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0142  */
    /* JADX WARN: Code duplicated, block: B:73:0x0190  */
    /* JADX WARN: Code duplicated, block: B:89:0x01df  */
    /* JADX WARN: Code duplicated, block: B:91:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:97:0x020e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0214  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007b -> B:22:0x007e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:91:0x01fc
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instruction units count: 825
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$9$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
