package io.ktor.utils.io;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ByteChannel$$ExternalSyntheticLambda2 implements DisposableHandle {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ByteChannel$$ExternalSyntheticLambda2(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                ByteChannel.invokeOnClose$lambda$2((ByteChannel) obj2, (Function1) obj);
                break;
            default:
                ((HandlerContext) obj2).handler.removeCallbacks((Runnable) obj);
                break;
        }
    }
}
