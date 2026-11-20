package io.ktor.client.plugins;

import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import coil3.util.LifecyclesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpRequestRetryConfig$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function2 f$1;

    public /* synthetic */ HttpRequestRetryConfig$$ExternalSyntheticLambda5(boolean z, Function2 function2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = z;
        this.f$1 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function2 function2 = this.f$1;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                return Long.valueOf(HttpRequestRetryConfig.delayMillis$lambda$0(z, function2, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            case 1:
                ((Integer) obj2).getClass();
                Icons$Filled.PredictiveBackHandler(z, function2, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            default:
                ((Integer) obj2).getClass();
                LifecyclesKt.PredictiveBackHandler(z, function2, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
        }
    }

    public /* synthetic */ HttpRequestRetryConfig$$ExternalSyntheticLambda5(boolean z, Function2 function2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function2;
    }
}
