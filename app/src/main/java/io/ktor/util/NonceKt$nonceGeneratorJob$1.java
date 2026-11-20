package io.ktor.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", l = {113}, m = "invokeSuspend", v = 1)
public final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2 {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;

    public NonceKt$nonceGeneratorJob$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NonceKt$nonceGeneratorJob$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NonceKt$nonceGeneratorJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0092 A[Catch: all -> 0x003b, LOOP:0: B:14:0x0090->B:15:0x0092, LOOP_END, TryCatch #1 {all -> 0x003b, blocks: (B:6:0x0036, B:28:0x010f, B:31:0x0114, B:33:0x011a, B:13:0x0088, B:15:0x0092, B:16:0x009e, B:18:0x00af, B:20:0x00c5, B:22:0x00d2, B:23:0x00e3, B:25:0x00f0, B:26:0x0101, B:19:0x00c2), top: B:49:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x00af A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:6:0x0036, B:28:0x010f, B:31:0x0114, B:33:0x011a, B:13:0x0088, B:15:0x0092, B:16:0x009e, B:18:0x00af, B:20:0x00c5, B:22:0x00d2, B:23:0x00e3, B:25:0x00f0, B:26:0x0101, B:19:0x00c2), top: B:49:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x00c2 A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:6:0x0036, B:28:0x010f, B:31:0x0114, B:33:0x011a, B:13:0x0088, B:15:0x0092, B:16:0x009e, B:18:0x00af, B:20:0x00c5, B:22:0x00d2, B:23:0x00e3, B:25:0x00f0, B:26:0x0101, B:19:0x00c2), top: B:49:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x00d2 A[Catch: all -> 0x003b, LOOP:1: B:21:0x00d0->B:22:0x00d2, LOOP_END, TryCatch #1 {all -> 0x003b, blocks: (B:6:0x0036, B:28:0x010f, B:31:0x0114, B:33:0x011a, B:13:0x0088, B:15:0x0092, B:16:0x009e, B:18:0x00af, B:20:0x00c5, B:22:0x00d2, B:23:0x00e3, B:25:0x00f0, B:26:0x0101, B:19:0x00c2), top: B:49:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00f0 A[Catch: all -> 0x003b, LOOP:2: B:24:0x00ee->B:25:0x00f0, LOOP_END, TryCatch #1 {all -> 0x003b, blocks: (B:6:0x0036, B:28:0x010f, B:31:0x0114, B:33:0x011a, B:13:0x0088, B:15:0x0092, B:16:0x009e, B:18:0x00af, B:20:0x00c5, B:22:0x00d2, B:23:0x00e3, B:25:0x00f0, B:26:0x0101, B:19:0x00c2), top: B:49:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x015d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0101 -> B:27:0x010d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0113 -> B:39:0x0157). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0118 -> B:39:0x0157). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0141 -> B:38:0x014c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.NonceKt$nonceGeneratorJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
