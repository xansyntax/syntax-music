package com.metrolist.music.widget;

import com.metrolist.music.utils.SyncUtils;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistWidgetManager$buildQuickPicks$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public Object L$0;
    public Object L$10;
    public Object L$11;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public List L$6;
    public Set L$7;
    public List L$8;
    public Object L$9;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaylistWidgetManager$buildQuickPicks$2(Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    public static final void invokeSuspend$add(Set set, List list, PlaylistWidgetManager.QuickPick quickPick) {
        if (set.add(quickPick.key)) {
            list.add(quickPick);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                PlaylistWidgetManager$buildQuickPicks$2 playlistWidgetManager$buildQuickPicks$2 = new PlaylistWidgetManager$buildQuickPicks$2((PlaylistWidgetManager) obj2, continuation, (byte) 0);
                playlistWidgetManager$buildQuickPicks$2.L$0 = obj;
                return playlistWidgetManager$buildQuickPicks$2;
            default:
                return new PlaylistWidgetManager$buildQuickPicks$2((SyncUtils) obj2, continuation, (byte) 1);
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
        return ((PlaylistWidgetManager$buildQuickPicks$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:213:0x0777  */
    /* JADX WARN: Code duplicated, block: B:217:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:221:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:225:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:232:0x080e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0820  */
    /* JADX WARN: Code duplicated, block: B:235:0x0842  */
    /* JADX WARN: Code duplicated, block: B:238:0x084c  */
    /* JADX WARN: Code duplicated, block: B:240:0x085e  */
    /* JADX WARN: Code duplicated, block: B:247:0x0872  */
    /* JADX WARN: Code duplicated, block: B:248:0x087a  */
    /* JADX WARN: Code duplicated, block: B:253:0x08ae  */
    /* JADX WARN: Code duplicated, block: B:260:0x08ca A[LOOP:9: B:259:0x08c8->B:260:0x08ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:264:0x08e9  */
    /* JADX WARN: Code duplicated, block: B:271:0x0905 A[LOOP:11: B:270:0x0903->B:271:0x0905, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:274:0x091b  */
    /* JADX WARN: Code duplicated, block: B:276:0x092f  */
    /* JADX WARN: Code duplicated, block: B:277:0x0934  */
    /* JADX WARN: Code duplicated, block: B:281:0x094a  */
    /* JADX WARN: Code duplicated, block: B:283:0x095e  */
    /* JADX WARN: Code duplicated, block: B:284:0x0963  */
    /* JADX WARN: Code duplicated, block: B:288:0x0979  */
    /* JADX WARN: Code duplicated, block: B:290:0x098d  */
    /* JADX WARN: Code duplicated, block: B:291:0x0993  */
    /* JADX WARN: Code duplicated, block: B:365:0x086c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:366:0x086e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:389:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:390:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x02a2 A[Catch: Exception -> 0x0362, TRY_LEAVE, TryCatch #18 {Exception -> 0x0362, blocks: (B:68:0x029c, B:70:0x02a2), top: B:336:0x029c }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0315  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v110 */
    /* JADX WARN: Type inference failed for: r1v111 */
    /* JADX WARN: Type inference failed for: r1v112 */
    /* JADX WARN: Type inference failed for: r1v113 */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v115 */
    /* JADX WARN: Type inference failed for: r1v116 */
    /* JADX WARN: Type inference failed for: r1v117 */
    /* JADX WARN: Type inference failed for: r1v118 */
    /* JADX WARN: Type inference failed for: r1v119 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121 */
    /* JADX WARN: Type inference failed for: r1v27, types: [byte] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v34, types: [com.metrolist.innertube.models.PodcastItem] */
    /* JADX WARN: Type inference failed for: r1v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v39, types: [com.metrolist.innertube.models.PodcastItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v44, types: [com.metrolist.innertube.models.PodcastItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v57, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v58, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v100 */
    /* JADX WARN: Type inference failed for: r2v101 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.Object, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46, types: [com.metrolist.innertube.models.PodcastItem] */
    /* JADX WARN: Type inference failed for: r2v48, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v51, types: [com.metrolist.innertube.models.PodcastItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v57, types: [com.metrolist.innertube.models.PodcastItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r6v40, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v52 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v85 */
    /* JADX WARN: Type inference failed for: r6v86 */
    /* JADX WARN: Type inference failed for: r6v87 */
    /* JADX WARN: Type inference failed for: r6v88 */
    /* JADX WARN: Type inference failed for: r6v89 */
    /* JADX WARN: Type inference failed for: r6v90 */
    /* JADX WARN: Type inference failed for: r6v91 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r9v0, types: [byte] */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v38, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v39, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v40 */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Type inference failed for: r9v57 */
    /* JADX WARN: Type inference failed for: r9v58 */
    /* JADX WARN: Type inference failed for: r9v59, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v60, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v61, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v63 */
    /* JADX WARN: Type inference failed for: r9v80 */
    /* JADX WARN: Type inference failed for: r9v81 */
    /* JADX WARN: Type inference failed for: r9v82 */
    /* JADX WARN: Type inference failed for: r9v83 */
    /* JADX WARN: Type inference failed for: r9v84 */
    /* JADX WARN: Type inference failed for: r9v85 */
    /* JADX WARN: Type inference failed for: r9v86 */
    /* JADX WARN: Type inference failed for: r9v87 */
    /* JADX WARN: Type inference failed for: r9v88 */
    /* JADX WARN: Type inference failed for: r9v89 */
    /* JADX WARN: Type inference failed for: r9v90 */
    /* JADX WARN: Type inference failed for: r9v91 */
    /* JADX WARN: Type inference failed for: r9v92 */
    /* JADX WARN: Type inference failed for: r9v93 */
    /* JADX WARN: Type inference failed for: r9v94 */
    /* JADX WARN: Type inference failed for: r9v95 */
    /* JADX WARN: Type inference failed for: r9v96 */
    /* JADX WARN: Type inference failed for: r9v97 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x04ec -> B:145:0x050a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x04fc -> B:145:0x050a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:176:0x05eb -> B:326:0x05ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0338 -> B:89:0x0353). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0346 -> B:89:0x0353). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r33) {
        /*
            Method dump skipped, instruction units count: 2504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.widget.PlaylistWidgetManager$buildQuickPicks$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
