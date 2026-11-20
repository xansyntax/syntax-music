package io.ktor.client.engine.okhttp;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1", f = "OkHttpEngine.kt", l = {249}, m = "invokeSuspend", v = 1)
public final class OkHttpEngineKt$convertToOkHttpBody$3$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ OutgoingContent $this_convertToOkHttpBody;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngineKt$convertToOkHttpBody$3$1(OutgoingContent outgoingContent, Continuation continuation) {
        super(2, continuation);
        this.$this_convertToOkHttpBody = outgoingContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OkHttpEngineKt$convertToOkHttpBody$3$1 okHttpEngineKt$convertToOkHttpBody$3$1 = new OkHttpEngineKt$convertToOkHttpBody$3$1(this.$this_convertToOkHttpBody, continuation);
        okHttpEngineKt$convertToOkHttpBody$3$1.L$0 = obj;
        return okHttpEngineKt$convertToOkHttpBody$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation continuation) {
        return ((OkHttpEngineKt$convertToOkHttpBody$3$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WriterScope writerScope = (WriterScope) this.L$0;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OutgoingContent.WriteChannelContent writeChannelContent = (OutgoingContent.WriteChannelContent) this.$this_convertToOkHttpBody;
            ByteWriteChannel channel = writerScope.getChannel();
            this.L$0 = null;
            this.label = 1;
            Object objWriteTo = writeChannelContent.writeTo(channel, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWriteTo == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
