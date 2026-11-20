package com.metrolist.music.ui.player;

import androidx.compose.ui.hapticfeedback.HapticFeedback;
import com.metrolist.music.ui.component.MenuState;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueKt$Queue$5$4$1$1$7$1$1$1 implements Function0 {
    public final /* synthetic */ Object $bottomSheetPageState;
    public final /* synthetic */ Object $item;
    public final /* synthetic */ MenuState $menuState;
    public final /* synthetic */ Object $playerBottomSheetState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ QueueKt$Queue$5$4$1$1$7$1$1$1(HapticFeedback hapticFeedback, MenuState menuState, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$item = hapticFeedback;
        this.$menuState = menuState;
        this.$playerBottomSheetState = obj;
        this.$bottomSheetPageState = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007a  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v9 java.lang.Object, still in use, count: 2, list:
          (r1v9 java.lang.Object) from 0x0076: PHI (r1 I:??) = (r1v5 java.lang.Object), (r1v9 java.lang.Object) binds: [B:14:0x0075, B:26:0x0076] A[DONT_GENERATE, DONT_INLINE]
          (r1v9 java.lang.Object) from 0x0066: CHECK_CAST (com.metrolist.music.db.entities.Song) (r1v9 java.lang.Object)
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
    @Override // kotlin.jvm.functions.Function0
    public final java.lang.Object invoke() {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$7$1$1$1.invoke():java.lang.Object");
    }

    public /* synthetic */ QueueKt$Queue$5$4$1$1$7$1$1$1(MenuState menuState, Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.$menuState = menuState;
        this.$item = obj;
        this.$playerBottomSheetState = obj2;
        this.$bottomSheetPageState = obj3;
    }
}
