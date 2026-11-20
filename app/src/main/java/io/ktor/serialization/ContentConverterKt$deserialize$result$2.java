package io.ktor.serialization;

import io.ktor.utils.io.ByteReadChannel;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt$deserialize$result$2", f = "ContentConverter.kt", l = {}, m = "invokeSuspend", v = 1)
public final class ContentConverterKt$deserialize$result$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ ByteReadChannel $body;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentConverterKt$deserialize$result$2(ByteReadChannel byteReadChannel, Continuation continuation) {
        super(2, continuation);
        this.$body = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContentConverterKt$deserialize$result$2 contentConverterKt$deserialize$result$2 = new ContentConverterKt$deserialize$result$2(this.$body, continuation);
        contentConverterKt$deserialize$result$2.L$0 = obj;
        return contentConverterKt$deserialize$result$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation continuation) {
        return ((ContentConverterKt$deserialize$result$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = this.L$0;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boolean.valueOf(obj2 != null || this.$body.isClosedForRead());
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
