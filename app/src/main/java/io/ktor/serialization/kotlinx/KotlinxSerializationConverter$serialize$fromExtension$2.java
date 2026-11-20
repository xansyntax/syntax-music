package io.ktor.serialization.kotlinx;

import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/http/content/OutgoingContent;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$fromExtension$2", f = "KotlinxSerializationConverter.kt", l = {}, m = "invokeSuspend", v = 1)
public final class KotlinxSerializationConverter$serialize$fromExtension$2 extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;

    public KotlinxSerializationConverter$serialize$fromExtension$2(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        KotlinxSerializationConverter$serialize$fromExtension$2 kotlinxSerializationConverter$serialize$fromExtension$2 = new KotlinxSerializationConverter$serialize$fromExtension$2(continuation);
        kotlinxSerializationConverter$serialize$fromExtension$2.L$0 = obj;
        return kotlinxSerializationConverter$serialize$fromExtension$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(OutgoingContent outgoingContent, Continuation continuation) {
        return ((KotlinxSerializationConverter$serialize$fromExtension$2) create(outgoingContent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OutgoingContent outgoingContent = (OutgoingContent) this.L$0;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boolean.valueOf(outgoingContent != null);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
