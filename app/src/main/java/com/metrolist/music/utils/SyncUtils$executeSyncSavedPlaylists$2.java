package com.metrolist.music.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSyncSavedPlaylists$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public Object L$0;
    public SyncUtils L$1;
    public Object L$10;
    public List L$11;
    public Object L$3;
    public Set L$5;
    public List L$6;
    public Iterator L$7;
    public Object L$8;
    public byte label;
    public final /* synthetic */ SyncUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSyncSavedPlaylists$2(SyncUtils syncUtils, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = syncUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        SyncUtils syncUtils = this.this$0;
        switch (b) {
            case 0:
                return new SyncUtils$executeSyncSavedPlaylists$2(syncUtils, continuation, (byte) 0);
            default:
                return new SyncUtils$executeSyncSavedPlaylists$2(syncUtils, continuation, (byte) 1);
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
        return ((SyncUtils$executeSyncSavedPlaylists$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:233:0x0600 A[Catch: Exception -> 0x05f1, TRY_LEAVE, TryCatch #11 {Exception -> 0x05f1, blocks: (B:231:0x05fa, B:233:0x0600, B:305:0x076b, B:306:0x0779, B:220:0x05a9, B:222:0x05af, B:228:0x05e3, B:230:0x05f5), top: B:346:0x05a9 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0610 A[Catch: Exception -> 0x0622, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x062c A[Catch: Exception -> 0x0622, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:246:0x063c  */
    /* JADX WARN: Code duplicated, block: B:249:0x0655 A[Catch: Exception -> 0x0622, TRY_ENTER, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:250:0x0660  */
    /* JADX WARN: Code duplicated, block: B:253:0x0669  */
    /* JADX WARN: Code duplicated, block: B:256:0x0671 A[Catch: Exception -> 0x0622, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:257:0x0676  */
    /* JADX WARN: Code duplicated, block: B:260:0x067c A[Catch: Exception -> 0x0622, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:261:0x0681  */
    /* JADX WARN: Code duplicated, block: B:264:0x0687 A[Catch: Exception -> 0x0622, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:265:0x068c  */
    /* JADX WARN: Code duplicated, block: B:267:0x06ba A[Catch: Exception -> 0x0622, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x06e0 A[Catch: Exception -> 0x0622, TRY_LEAVE, TryCatch #23 {Exception -> 0x0622, blocks: (B:234:0x0606, B:235:0x060a, B:237:0x0610, B:242:0x0628, B:244:0x062c, B:249:0x0655, B:254:0x066d, B:256:0x0671, B:258:0x0678, B:260:0x067c, B:262:0x0683, B:264:0x0687, B:266:0x068e, B:268:0x06d2, B:270:0x06e0, B:267:0x06ba), top: B:368:0x0606 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:274:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:275:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:281:0x070d  */
    /* JADX WARN: Code duplicated, block: B:291:0x0736  */
    /* JADX WARN: Code duplicated, block: B:338:0x06ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:384:0x0627 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:433:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:434:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r0v71 */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v73 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r0v83 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v95 */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.metrolist.innertube.models.PlaylistItem] */
    /* JADX WARN: Type inference failed for: r1v103 */
    /* JADX WARN: Type inference failed for: r1v109 */
    /* JADX WARN: Type inference failed for: r1v110, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v119 */
    /* JADX WARN: Type inference failed for: r1v121 */
    /* JADX WARN: Type inference failed for: r1v124 */
    /* JADX WARN: Type inference failed for: r1v125 */
    /* JADX WARN: Type inference failed for: r1v126 */
    /* JADX WARN: Type inference failed for: r1v127 */
    /* JADX WARN: Type inference failed for: r1v128 */
    /* JADX WARN: Type inference failed for: r1v129 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v130 */
    /* JADX WARN: Type inference failed for: r1v131 */
    /* JADX WARN: Type inference failed for: r1v132 */
    /* JADX WARN: Type inference failed for: r1v133 */
    /* JADX WARN: Type inference failed for: r1v134 */
    /* JADX WARN: Type inference failed for: r1v135 */
    /* JADX WARN: Type inference failed for: r1v136 */
    /* JADX WARN: Type inference failed for: r1v137 */
    /* JADX WARN: Type inference failed for: r1v140 */
    /* JADX WARN: Type inference failed for: r1v141 */
    /* JADX WARN: Type inference failed for: r1v142 */
    /* JADX WARN: Type inference failed for: r1v143 */
    /* JADX WARN: Type inference failed for: r1v144 */
    /* JADX WARN: Type inference failed for: r1v145 */
    /* JADX WARN: Type inference failed for: r1v150 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r1v71, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v76, types: [com.metrolist.innertube.models.AlbumItem] */
    /* JADX WARN: Type inference failed for: r1v79, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r1v83 */
    /* JADX WARN: Type inference failed for: r1v84, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v85 */
    /* JADX WARN: Type inference failed for: r1v86, types: [com.metrolist.innertube.models.AlbumItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v91, types: [com.metrolist.innertube.models.AlbumItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v100 */
    /* JADX WARN: Type inference failed for: r2v101 */
    /* JADX WARN: Type inference failed for: r2v102 */
    /* JADX WARN: Type inference failed for: r2v103 */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v105 */
    /* JADX WARN: Type inference failed for: r2v106 */
    /* JADX WARN: Type inference failed for: r2v107 */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v109 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v110 */
    /* JADX WARN: Type inference failed for: r2v111 */
    /* JADX WARN: Type inference failed for: r2v112 */
    /* JADX WARN: Type inference failed for: r2v113 */
    /* JADX WARN: Type inference failed for: r2v114 */
    /* JADX WARN: Type inference failed for: r2v115 */
    /* JADX WARN: Type inference failed for: r2v116 */
    /* JADX WARN: Type inference failed for: r2v117 */
    /* JADX WARN: Type inference failed for: r2v118 */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v120 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [com.metrolist.innertube.models.AlbumItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v65, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v69, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v9 */
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
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v100 */
    /* JADX WARN: Type inference failed for: r3v101 */
    /* JADX WARN: Type inference failed for: r3v102 */
    /* JADX WARN: Type inference failed for: r3v103 */
    /* JADX WARN: Type inference failed for: r3v104 */
    /* JADX WARN: Type inference failed for: r3v105 */
    /* JADX WARN: Type inference failed for: r3v106 */
    /* JADX WARN: Type inference failed for: r3v107 */
    /* JADX WARN: Type inference failed for: r3v108 */
    /* JADX WARN: Type inference failed for: r3v109 */
    /* JADX WARN: Type inference failed for: r3v110 */
    /* JADX WARN: Type inference failed for: r3v111 */
    /* JADX WARN: Type inference failed for: r3v112 */
    /* JADX WARN: Type inference failed for: r3v113 */
    /* JADX WARN: Type inference failed for: r3v114 */
    /* JADX WARN: Type inference failed for: r3v115 */
    /* JADX WARN: Type inference failed for: r3v116 */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v36, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v72 */
    /* JADX WARN: Type inference failed for: r3v74 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v81 */
    /* JADX WARN: Type inference failed for: r3v83 */
    /* JADX WARN: Type inference failed for: r3v88 */
    /* JADX WARN: Type inference failed for: r3v89 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v90 */
    /* JADX WARN: Type inference failed for: r3v91 */
    /* JADX WARN: Type inference failed for: r3v92 */
    /* JADX WARN: Type inference failed for: r3v93 */
    /* JADX WARN: Type inference failed for: r3v94 */
    /* JADX WARN: Type inference failed for: r3v95 */
    /* JADX WARN: Type inference failed for: r3v96 */
    /* JADX WARN: Type inference failed for: r3v97 */
    /* JADX WARN: Type inference failed for: r3v98 */
    /* JADX WARN: Type inference failed for: r3v99 */
    /* JADX WARN: Type inference failed for: r4v0, types: [byte] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v100 */
    /* JADX WARN: Type inference failed for: r4v101 */
    /* JADX WARN: Type inference failed for: r4v102 */
    /* JADX WARN: Type inference failed for: r4v103 */
    /* JADX WARN: Type inference failed for: r4v104 */
    /* JADX WARN: Type inference failed for: r4v105 */
    /* JADX WARN: Type inference failed for: r4v106 */
    /* JADX WARN: Type inference failed for: r4v107 */
    /* JADX WARN: Type inference failed for: r4v108 */
    /* JADX WARN: Type inference failed for: r4v109 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v110 */
    /* JADX WARN: Type inference failed for: r4v111 */
    /* JADX WARN: Type inference failed for: r4v112 */
    /* JADX WARN: Type inference failed for: r4v113 */
    /* JADX WARN: Type inference failed for: r4v114 */
    /* JADX WARN: Type inference failed for: r4v115 */
    /* JADX WARN: Type inference failed for: r4v116 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v50, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v61, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v72 */
    /* JADX WARN: Type inference failed for: r4v74 */
    /* JADX WARN: Type inference failed for: r4v75 */
    /* JADX WARN: Type inference failed for: r4v76 */
    /* JADX WARN: Type inference failed for: r4v77 */
    /* JADX WARN: Type inference failed for: r4v78 */
    /* JADX WARN: Type inference failed for: r4v79 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v80 */
    /* JADX WARN: Type inference failed for: r4v81 */
    /* JADX WARN: Type inference failed for: r4v82 */
    /* JADX WARN: Type inference failed for: r4v83 */
    /* JADX WARN: Type inference failed for: r4v84 */
    /* JADX WARN: Type inference failed for: r4v85 */
    /* JADX WARN: Type inference failed for: r4v86 */
    /* JADX WARN: Type inference failed for: r4v87 */
    /* JADX WARN: Type inference failed for: r4v88 */
    /* JADX WARN: Type inference failed for: r4v89 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v90 */
    /* JADX WARN: Type inference failed for: r4v91 */
    /* JADX WARN: Type inference failed for: r4v92 */
    /* JADX WARN: Type inference failed for: r4v93 */
    /* JADX WARN: Type inference failed for: r4v94 */
    /* JADX WARN: Type inference failed for: r4v95 */
    /* JADX WARN: Type inference failed for: r4v96 */
    /* JADX WARN: Type inference failed for: r4v97 */
    /* JADX WARN: Type inference failed for: r4v98 */
    /* JADX WARN: Type inference failed for: r4v99 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Iterable, java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r6v32, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v58 */
    /* JADX WARN: Type inference failed for: r6v59 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r6v61 */
    /* JADX WARN: Type inference failed for: r6v62 */
    /* JADX WARN: Type inference failed for: r6v63 */
    /* JADX WARN: Type inference failed for: r6v64 */
    /* JADX WARN: Type inference failed for: r6v65 */
    /* JADX WARN: Type inference failed for: r6v66 */
    /* JADX WARN: Type inference failed for: r6v67 */
    /* JADX WARN: Type inference failed for: r6v68 */
    /* JADX WARN: Type inference failed for: r6v69 */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r6v70 */
    /* JADX WARN: Type inference failed for: r6v71 */
    /* JADX WARN: Type inference failed for: r6v72 */
    /* JADX WARN: Type inference failed for: r6v73 */
    /* JADX WARN: Type inference failed for: r6v74 */
    /* JADX WARN: Type inference failed for: r6v75 */
    /* JADX WARN: Type inference failed for: r6v76 */
    /* JADX WARN: Type inference failed for: r6v77 */
    /* JADX WARN: Type inference failed for: r6v78 */
    /* JADX WARN: Type inference failed for: r6v79 */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r6v80 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v40, types: [com.metrolist.music.utils.SyncUtils] */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v47 */
    /* JADX WARN: Type inference failed for: r9v48 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v50 */
    /* JADX WARN: Type inference failed for: r9v51 */
    /* JADX WARN: Type inference failed for: r9v52 */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v55 */
    /* JADX WARN: Type inference failed for: r9v56 */
    /* JADX WARN: Type inference failed for: r9v57 */
    /* JADX WARN: Type inference failed for: r9v58 */
    /* JADX WARN: Type inference failed for: r9v59 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v60 */
    /* JADX WARN: Type inference failed for: r9v61 */
    /* JADX WARN: Type inference failed for: r9v62 */
    /* JADX WARN: Type inference failed for: r9v63 */
    /* JADX WARN: Type inference failed for: r9v64 */
    /* JADX WARN: Type inference failed for: r9v65 */
    /* JADX WARN: Type inference failed for: r9v66 */
    /* JADX WARN: Type inference failed for: r9v67 */
    /* JADX WARN: Type inference failed for: r9v68 */
    /* JADX WARN: Type inference failed for: r9v69 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v70 */
    /* JADX WARN: Type inference failed for: r9v71 */
    /* JADX WARN: Type inference failed for: r9v72 */
    /* JADX WARN: Type inference failed for: r9v73 */
    /* JADX WARN: Type inference failed for: r9v74 */
    /* JADX WARN: Type inference failed for: r9v75 */
    /* JADX WARN: Type inference failed for: r9v76 */
    /* JADX WARN: Type inference failed for: r9v77 */
    /* JADX WARN: Type inference failed for: r9v78 */
    /* JADX WARN: Type inference failed for: r9v79 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v80 */
    /* JADX WARN: Type inference failed for: r9v81 */
    /* JADX WARN: Type inference failed for: r9v82 */
    /* JADX WARN: Type inference failed for: r9v83 */
    /* JADX WARN: Type inference failed for: r9v84 */
    /* JADX WARN: Type inference failed for: r9v85 */
    /* JADX WARN: Type inference failed for: r9v86 */
    /* JADX WARN: Type inference failed for: r9v87 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x02fd -> B:82:0x021f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x0300 -> B:82:0x021f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:300:0x075d -> B:302:0x0760). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:305:0x076b -> B:302:0x0760). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0210 -> B:336:0x01ca). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r33) {
        /*
            Method dump skipped, instruction units count: 2030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.SyncUtils$executeSyncSavedPlaylists$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
