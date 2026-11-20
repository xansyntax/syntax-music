package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class HttpTimeoutKt$HttpTimeout$2 extends AdaptedFunctionReference implements Function0 {
    public static final HttpTimeoutKt$HttpTimeout$2 INSTANCE = new HttpTimeoutKt$HttpTimeout$2();

    public HttpTimeoutKt$HttpTimeout$2() {
        super(0, HttpTimeoutConfig.class, "<init>", "<init>(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final HttpTimeoutConfig invoke() {
        return new HttpTimeoutConfig(null, null, null, 7, null);
    }
}
