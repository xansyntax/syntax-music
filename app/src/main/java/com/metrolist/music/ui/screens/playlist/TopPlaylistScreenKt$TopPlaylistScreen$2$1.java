package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TopPlaylistScreenKt$TopPlaylistScreen$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ List $filteredSongs;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection;
    public final /* synthetic */ MutableState $selectionAnchorSongId$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopPlaylistScreenKt$TopPlaylistScreen$2$1(List list, List list2, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$selection = list;
        this.$filteredSongs = list2;
        this.$selectionAnchorSongId$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new TopPlaylistScreenKt$TopPlaylistScreen$2$1(this.$selection, this.$filteredSongs, this.$selectionAnchorSongId$delegate, continuation, (byte) 0);
            case 1:
                return new TopPlaylistScreenKt$TopPlaylistScreen$2$1(this.$selection, this.$filteredSongs, this.$selectionAnchorSongId$delegate, continuation, (byte) 1);
            default:
                return new TopPlaylistScreenKt$TopPlaylistScreen$2$1(this.$selection, this.$filteredSongs, this.$selectionAnchorSongId$delegate, continuation, (byte) 2);
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
                ((TopPlaylistScreenKt$TopPlaylistScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((TopPlaylistScreenKt$TopPlaylistScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((TopPlaylistScreenKt$TopPlaylistScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:115:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:118:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x012b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046 A[LOOP:0: B:6:0x0019->B:17:0x0046, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x0084  */
    /* JADX WARN: Code duplicated, block: B:39:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db A[LOOP:4: B:44:0x00ae->B:55:0x00db, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x0119  */
    /* JADX WARN: Code duplicated, block: B:77:0x0130  */
    /* JADX WARN: Code duplicated, block: B:90:0x016a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0170 A[LOOP:8: B:82:0x0143->B:93:0x0170, LOOP_END] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v3 java.lang.Object, still in use, count: 2, list:
          (r6v3 java.lang.Object) from 0x0168: PHI (r6 I:??) = (r6v1 java.lang.Object), (r6v3 java.lang.Object) binds: [B:88:0x0167, B:140:0x0168] A[DONT_GENERATE, DONT_INLINE]
          (r6v3 java.lang.Object) from 0x015a: CHECK_CAST (com.metrolist.music.db.entities.Song) (r6v3 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$TopPlaylistScreen$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
