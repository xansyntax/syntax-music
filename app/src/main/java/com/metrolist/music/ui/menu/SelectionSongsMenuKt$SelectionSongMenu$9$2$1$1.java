package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionSongsMenuKt$SelectionSongMenu$9$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function0 $clearAction;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $deleteProgress$delegate;
    public final /* synthetic */ String $deletedNSongsTemplate;
    public final /* synthetic */ MutableState $isDeleting$delegate;
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ MutableState $showDeleteUploadedDialog$delegate;
    public final /* synthetic */ List $songsToDelete;
    public int I$0;
    public Ref$IntRef L$0;
    public ParcelableSnapshotMutableIntState L$2;
    public MusicDatabase L$3;
    public Iterator L$4;
    public Song L$6;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionSongsMenuKt$SelectionSongMenu$9$2$1$1(List list, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MusicDatabase musicDatabase, Context context, String str, Function0 function0, Function0 function1, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$songsToDelete = list;
        this.$deleteProgress$delegate = parcelableSnapshotMutableIntState;
        this.$database = musicDatabase;
        this.$context = context;
        this.$deletedNSongsTemplate = str;
        this.$onDismiss = function0;
        this.$clearAction = function1;
        this.$isDeleting$delegate = mutableState;
        this.$showDeleteUploadedDialog$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SelectionSongsMenuKt$SelectionSongMenu$9$2$1$1(this.$songsToDelete, this.$deleteProgress$delegate, this.$database, this.$context, this.$deletedNSongsTemplate, this.$onDismiss, this.$clearAction, this.$isDeleting$delegate, this.$showDeleteUploadedDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SelectionSongsMenuKt$SelectionSongMenu$9$2$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004c  */
    /* JADX WARN: Code duplicated, block: B:15:0x0054  */
    /* JADX WARN: Code duplicated, block: B:19:0x0075  */
    /* JADX WARN: Code duplicated, block: B:20:0x0077 A[EDGE_INSN: B:20:0x0077->B:21:0x007c BREAK  A[LOOP:0: B:11:0x0044->B:25:0x0098]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0098 A[LOOP:0: B:11:0x0044->B:25:0x0098, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x005f A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0077 -> B:21:0x007c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.menu.SelectionSongsMenuKt$SelectionSongMenu$9$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
