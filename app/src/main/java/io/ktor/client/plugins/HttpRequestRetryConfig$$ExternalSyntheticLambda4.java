package io.ktor.client.plugins;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.ui.component.MenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HttpRequestRetryConfig$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ HttpRequestRetryConfig$$ExternalSyntheticLambda4(long j, long j2, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = j;
        this.f$2 = j2;
        this.f$1 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Object obj3 = this.f$1;
        switch (b) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return Long.valueOf(HttpRequestRetryConfig.constantDelay$lambda$0(this.f$0, (HttpRequestRetryConfig) obj3, this.f$2, (HttpRetryDelayContext) obj, iIntValue));
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(385);
                MenuKt.m1494TranslationCarddgg9oW8(this.f$0, this.f$2, (ComposableLambdaImpl) obj3, (Composer) obj, iUpdateChangedFlags);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ HttpRequestRetryConfig$$ExternalSyntheticLambda4(long j, HttpRequestRetryConfig httpRequestRetryConfig, long j2) {
        this.f$0 = j;
        this.f$1 = httpRequestRetryConfig;
        this.f$2 = j2;
    }
}
