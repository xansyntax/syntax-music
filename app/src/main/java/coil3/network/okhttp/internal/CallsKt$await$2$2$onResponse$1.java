package coil3.network.okhttp.internal;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CallsKt$await$2$2$onResponse$1 implements Function3 {
    public static final CallsKt$await$2$2$onResponse$1 INSTANCE = new CallsKt$await$2$2$onResponse$1();

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        try {
            Format$$ExternalSyntheticOutline0.m((Response) obj2);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
