package androidx.compose.runtime;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NeverEqualPolicy implements CoroutineContext.Key {
    public final /* synthetic */ byte $r8$classId;
    public static final MarqueeSpacing$Companion$$ExternalSyntheticLambda0 Empty = new MarqueeSpacing$Companion$$ExternalSyntheticLambda0(11);
    public static final /* synthetic */ NeverEqualPolicy $$INSTANCE = new NeverEqualPolicy(2);
    public static final NeverEqualPolicy INSTANCE = new NeverEqualPolicy(0);
    public static final NeverEqualPolicy INSTANCE$1 = new NeverEqualPolicy(3);
    public static final NeverEqualPolicy INSTANCE$2 = new NeverEqualPolicy(4);
    public static final NeverEqualPolicy INSTANCE$3 = new NeverEqualPolicy(5);

    public /* synthetic */ NeverEqualPolicy(byte b) {
        this.$r8$classId = b;
    }

    public boolean equivalent(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return false;
            case 3:
                return obj == obj2;
            default:
                return Intrinsics.areEqual(obj, obj2);
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "NeverEqualPolicy";
            case 3:
                return "ReferentialEqualityPolicy";
            case 5:
                return "StructuralEqualityPolicy";
            case 7:
                return "Empty";
            default:
                return super.toString();
        }
    }
}
