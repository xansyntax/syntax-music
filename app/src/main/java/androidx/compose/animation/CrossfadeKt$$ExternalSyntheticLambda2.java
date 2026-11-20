package androidx.compose.animation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CrossfadeKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda2(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf(!Intrinsics.areEqual(obj, obj2));
            case 1:
                return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
            default:
                ((Integer) obj).getClass();
                return obj2;
        }
    }
}
