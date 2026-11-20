package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.CryptoKt__CryptoJvmKt", f = "CryptoJvm.kt", l = {129}, m = "generateNonceLong$CryptoKt__CryptoJvmKt", v = 1)
public final class CryptoKt__CryptoJvmKt$generateNonceLong$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public CryptoKt__CryptoJvmKt$generateNonceLong$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CryptoKt__CryptoJvmKt.generateNonceLong$CryptoKt__CryptoJvmKt(null, 0, this);
    }
}
