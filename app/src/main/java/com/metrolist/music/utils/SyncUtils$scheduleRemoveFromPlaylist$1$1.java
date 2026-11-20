package com.metrolist.music.utils;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$scheduleRemoveFromPlaylist$1$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ CoroutineScope $$this$launch;
    public final /* synthetic */ String $browseId;
    public final /* synthetic */ Function1 $getSetVideoId;
    public final /* synthetic */ String $songId;
    public int I$0;
    public String L$0;
    public String L$1;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncUtils$scheduleRemoveFromPlaylist$1$1(Function1 function1, CoroutineScope coroutineScope, String str, String str2, Continuation continuation) {
        super(1, continuation);
        this.$getSetVideoId = function1;
        this.$$this$launch = coroutineScope;
        this.$songId = str;
        this.$browseId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SyncUtils$scheduleRemoveFromPlaylist$1$1(this.$getSetVideoId, this.$$this$launch, this.$songId, this.$browseId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((SyncUtils$scheduleRemoveFromPlaylist$1$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007e A[Catch: all -> 0x0047, TRY_ENTER, TryCatch #0 {all -> 0x0047, blocks: (B:29:0x007e, B:33:0x0091, B:36:0x00a1, B:37:0x00b0, B:39:0x00b6, B:44:0x00c9, B:46:0x00cd, B:14:0x003d, B:19:0x004e), top: B:70:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x008e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x009f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1 A[Catch: all -> 0x0047, PHI: r0 r13 r14
      0x00a1: PHI (r0v11 java.lang.String) = (r0v14 java.lang.String), (r0v28 java.lang.String) binds: [B:34:0x009d, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x00a1: PHI (r13v3 int) = (r13v4 int), (r13v13 int) binds: [B:34:0x009d, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x00a1: PHI (r14v1 java.lang.Object) = (r14v6 java.lang.Object), (r14v14 java.lang.Object) binds: [B:34:0x009d, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0047, blocks: (B:29:0x007e, B:33:0x0091, B:36:0x00a1, B:37:0x00b0, B:39:0x00b6, B:44:0x00c9, B:46:0x00cd, B:14:0x003d, B:19:0x004e), top: B:70:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b6 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:29:0x007e, B:33:0x0091, B:36:0x00a1, B:37:0x00b0, B:39:0x00b6, B:44:0x00c9, B:46:0x00cd, B:14:0x003d, B:19:0x004e), top: B:70:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00cd A[Catch: all -> 0x0047, TRY_LEAVE, TryCatch #0 {all -> 0x0047, blocks: (B:29:0x007e, B:33:0x0091, B:36:0x00a1, B:37:0x00b0, B:39:0x00b6, B:44:0x00c9, B:46:0x00cd, B:14:0x003d, B:19:0x004e), top: B:70:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:62:0x0103 A[DONT_INVERT, PHI: r0
      0x0103: PHI (r0v3 java.lang.String) = (r0v8 java.lang.String), (r0v15 java.lang.String), (r0v25 java.lang.String) binds: [B:54:0x00e0, B:28:0x007c, B:26:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x0105  */
    /* JADX WARN: Code duplicated, block: B:65:0x0110  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00e2 -> B:61:0x00ff). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00f5 -> B:60:0x00fa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.SyncUtils$scheduleRemoveFromPlaylist$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
