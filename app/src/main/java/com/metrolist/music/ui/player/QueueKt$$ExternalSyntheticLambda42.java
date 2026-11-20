package com.metrolist.music.ui.player;

import com.metrolist.music.ui.component.MenuState;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda42 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda42(MenuState menuState, List list, List list2, Function0 function0) {
        this.$r8$classId = (byte) 0;
        this.f$0 = menuState;
        this.f$1 = list;
        this.f$2 = list2;
        this.f$3 = function0;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x016a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:92:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00c1 A[SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v6 java.lang.Object, still in use, count: 2, list:
          (r8v6 java.lang.Object) from 0x0193: PHI (r8 I:??) = (r8v3 java.lang.Object), (r8v6 java.lang.Object) binds: [B:64:0x0192, B:106:0x0193] A[DONT_GENERATE, DONT_INLINE]
          (r8v6 java.lang.Object) from 0x0185: CHECK_CAST (com.metrolist.music.db.entities.Song) (r8v6 java.lang.Object)
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
    @Override // kotlin.jvm.functions.Function3
    public final java.lang.Object invoke(java.lang.Object r25, java.lang.Object r26, java.lang.Object r27) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda42.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda42(byte b, MenuState menuState, List list, List list2, Function0 function0) {
        this.$r8$classId = b;
        this.f$1 = list;
        this.f$0 = menuState;
        this.f$3 = function0;
        this.f$2 = list2;
    }
}
