package com.metrolist.music.ui.screens;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ List $filteredSongs;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlbumScreenKt$AlbumScreen$1$1(List list, List list2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$selection = list;
        this.$filteredSongs = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AlbumScreenKt$AlbumScreen$1$1(this.$selection, this.$filteredSongs, continuation, (byte) 0);
            default:
                return new AlbumScreenKt$AlbumScreen$1$1(this.$selection, this.$filteredSongs, continuation, (byte) 1);
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
                ((AlbumScreenKt$AlbumScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((AlbumScreenKt$AlbumScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    /* JADX WARN: Code duplicated, block: B:17:0x004b A[LOOP:0: B:6:0x0017->B:17:0x004b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0080  */
    /* JADX WARN: Code duplicated, block: B:32:0x0086 A[LOOP:2: B:21:0x0059->B:32:0x0086, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x004d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0088 A[SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v3 java.lang.Object, still in use, count: 2, list:
          (r5v3 java.lang.Object) from 0x007e: PHI (r5 I:??) = (r5v1 java.lang.Object), (r5v3 java.lang.Object) binds: [B:27:0x007d, B:40:0x007e] A[DONT_GENERATE, DONT_INLINE]
          (r5v3 java.lang.Object) from 0x0070: CHECK_CAST (com.metrolist.music.db.entities.Song) (r5v3 java.lang.Object)
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
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            byte r0 = r9.$r8$classId
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r2 = 0
            java.util.List r3 = r9.$filteredSongs
            java.util.List r9 = r9.$selection
            switch(r0) {
                case 0: goto L4e;
                default: goto Lc;
            }
        Lc:
            kotlin.ResultKt.throwOnFailure(r10)
            int r10 = r9.size()
            int r10 = r10 + (-1)
            if (r10 < 0) goto L4d
        L17:
            int r0 = r10 + (-1)
            java.lang.Object r10 = r9.get(r10)
            java.lang.Number r10 = (java.lang.Number) r10
            long r4 = r10.longValue()
            java.util.Iterator r10 = r3.iterator()
        L27:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto L3d
            java.lang.Object r6 = r10.next()
            r7 = r6
            com.metrolist.music.db.entities.EventWithSong r7 = (com.metrolist.music.db.entities.EventWithSong) r7
            com.metrolist.music.db.entities.Event r7 = r7.event
            long r7 = r7.id
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 != 0) goto L27
            goto L3e
        L3d:
            r6 = r2
        L3e:
            if (r6 != 0) goto L48
            java.lang.Long r10 = new java.lang.Long
            r10.<init>(r4)
            r9.remove(r10)
        L48:
            if (r0 >= 0) goto L4b
            goto L4d
        L4b:
            r10 = r0
            goto L17
        L4d:
            return r1
        L4e:
            kotlin.ResultKt.throwOnFailure(r10)
            int r10 = r9.size()
            int r10 = r10 + (-1)
            if (r10 < 0) goto L88
        L59:
            int r0 = r10 + (-1)
            java.lang.Object r10 = r9.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            java.util.Iterator r4 = r3.iterator()
        L65:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L7d
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.metrolist.music.db.entities.Song r6 = (com.metrolist.music.db.entities.Song) r6
            com.metrolist.music.db.entities.SongEntity r6 = r6.song
            java.lang.String r6 = r6.id
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r10)
            if (r6 == 0) goto L65
            goto L7e
        L7d:
            r5 = r2
        L7e:
            if (r5 != 0) goto L83
            r9.remove(r10)
        L83:
            if (r0 >= 0) goto L86
            goto L88
        L86:
            r10 = r0
            goto L59
        L88:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
