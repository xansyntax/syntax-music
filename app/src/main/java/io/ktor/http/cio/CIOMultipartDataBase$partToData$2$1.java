package io.ktor.http.cio;

import com.yalantis.ucrop.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class CIOMultipartDataBase$partToData$2$1 extends FunctionReferenceImpl implements Function0 {
    public CIOMultipartDataBase$partToData$2$1(Object obj) {
        super(0, obj, MultipartEvent.MultipartPart.class, BuildConfig.BUILD_TYPE, "release()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1699invoke() {
        ((MultipartEvent.MultipartPart) this.receiver).release();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m1699invoke();
        return Unit.INSTANCE;
    }
}
