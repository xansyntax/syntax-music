package com.metrolist.lrclib;

import androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1;
import com.metrolist.innertubex.extraction.strategy.ClientSelectionRequest;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LrcLib$getAllLyrics$$inlined$sortedByDescending$1 implements Comparator {
    public final /* synthetic */ Object $cleanedArtist$inlined;
    public final /* synthetic */ Object $cleanedTitle$inlined;
    public final /* synthetic */ byte $r8$classId;

    public LrcLib$getAllLyrics$$inlined$sortedByDescending$1(SemanticsSortKt$special$$inlined$thenBy$1 semanticsSortKt$special$$inlined$thenBy$1, ClientSelectionRequest clientSelectionRequest, boolean z) {
        this.$r8$classId = (byte) 1;
        this.$cleanedTitle$inlined = semanticsSortKt$special$$inlined$thenBy$1;
        this.$cleanedArtist$inlined = clientSelectionRequest;
    }

    /* JADX WARN: Code duplicated, block: B:140:0x00df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:? A[LOOP:4: B:56:0x00e7->B:149:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:62:0x010b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0122  */
    /* JADX WARN: Code duplicated, block: B:69:0x0129  */
    /* JADX WARN: Code duplicated, block: B:70:0x012b  */
    /* JADX WARN: Code duplicated, block: B:73:0x013b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0152  */
    /* JADX WARN: Code duplicated, block: B:83:0x015d  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v19 java.lang.Object, still in use, count: 2, list:
          (r8v19 java.lang.Object) from 0x0071: PHI (r8 I:??) = (r8v16 java.lang.Object), (r8v19 java.lang.Object) binds: [B:23:0x0070, B:137:0x0071] A[DONT_GENERATE, DONT_INLINE]
          (r8v19 java.lang.Object) from 0x0063: CHECK_CAST (java.util.Map$Entry) (r8v19 java.lang.Object)
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
    @Override // java.util.Comparator
    public final int compare(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.lrclib.LrcLib$getAllLyrics$$inlined$sortedByDescending$1.compare(java.lang.Object, java.lang.Object):int");
    }

    public /* synthetic */ LrcLib$getAllLyrics$$inlined$sortedByDescending$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$cleanedTitle$inlined = obj;
        this.$cleanedArtist$inlined = obj2;
    }
}
