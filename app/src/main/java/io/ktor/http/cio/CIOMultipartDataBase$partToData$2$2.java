package io.ktor.http.cio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class CIOMultipartDataBase$partToData$2$2 extends FunctionReferenceImpl implements Function1 {
    public CIOMultipartDataBase$partToData$2$2(Object obj) {
        super(1, obj, MultipartEvent.MultipartPart.class, "releaseSuspend", "releaseSuspend(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((MultipartEvent.MultipartPart) this.receiver).releaseSuspend(continuation);
    }
}
