package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.KSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/ktor/serialization/kotlinx/json/KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "index", "I", "kotlinx-coroutines-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 implements FlowCollector {
    final /* synthetic */ ByteWriteChannel $channel$inlined;
    final /* synthetic */ Charset $charset$inlined;
    final /* synthetic */ JsonArraySymbols $jsonArraySymbols$inlined;
    final /* synthetic */ KSerializer $serializer$inlined;
    private int index;
    final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1", f = "KotlinxSerializationJsonExtensions.kt", l = {138, 141, 142}, m = "emit", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.this.emit(null, this);
        }
    }

    public KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(ByteWriteChannel byteWriteChannel, JsonArraySymbols jsonArraySymbols, KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, KSerializer kSerializer, Charset charset) {
        this.$channel$inlined = byteWriteChannel;
        this.$jsonArraySymbols$inlined = jsonArraySymbols;
        this.this$0 = kotlinxSerializationJsonExtensions;
        this.$serializer$inlined = kSerializer;
        this.$charset$inlined = charset;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d3, code lost:
    
        if (r12.flush(r5) == r11) goto L32;
     */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        int i2;
        Object obj;
        int i3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i4 = anonymousClass1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i4 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        int i5 = anonymousClass2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj2);
            i = this.index;
            this.index = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            i2 = 0;
            if (i > 0) {
                ByteWriteChannel byteWriteChannel = this.$channel$inlined;
                byte[] objectSeparator = this.$jsonArraySymbols$inlined.getObjectSeparator();
                anonymousClass2.L$0 = null;
                anonymousClass2.L$1 = null;
                anonymousClass2.L$2 = t;
                anonymousClass2.I$0 = i;
                anonymousClass2.I$1 = 0;
                anonymousClass2.label = 1;
                if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel, objectSeparator, 0, 0, anonymousClass2, 6, null) != coroutineSingletons) {
                }
            }
            obj = t;
            obj = t;
            return coroutineSingletons;
        }
        if (i5 == 1) {
            int i6 = anonymousClass2.I$1;
            i = anonymousClass2.I$0;
            Object obj3 = anonymousClass2.L$2;
            ResultKt.throwOnFailure(obj2);
            i2 = i6;
            obj = obj3;
        } else if (i5 == 2) {
            i3 = anonymousClass2.I$1;
            i = anonymousClass2.I$0;
            ResultKt.throwOnFailure(obj2);
            ByteWriteChannel byteWriteChannel2 = this.$channel$inlined;
            anonymousClass2.L$0 = null;
            anonymousClass2.L$1 = null;
            anonymousClass2.L$2 = null;
            anonymousClass2.L$3 = null;
            anonymousClass2.I$0 = i;
            anonymousClass2.I$1 = i3;
            anonymousClass2.label = 3;
        } else {
            if (i5 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj2);
        }
        return Unit.INSTANCE;
        obj = t;
        obj = t;
        obj = t;
        String strEncodeToString = this.this$0.format.encodeToString(this.$serializer$inlined, obj);
        ByteWriteChannel byteWriteChannel3 = this.$channel$inlined;
        byte[] byteArray = StringsKt.toByteArray(strEncodeToString, this.$charset$inlined);
        anonymousClass2.L$0 = null;
        anonymousClass2.L$1 = null;
        anonymousClass2.L$2 = null;
        anonymousClass2.L$3 = null;
        anonymousClass2.I$0 = i;
        anonymousClass2.I$1 = i2;
        anonymousClass2.label = 2;
        if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel3, byteArray, 0, 0, anonymousClass2, 6, null) != coroutineSingletons) {
            i3 = i2;
            ByteWriteChannel byteWriteChannel4 = this.$channel$inlined;
            anonymousClass2.L$0 = null;
            anonymousClass2.L$1 = null;
            anonymousClass2.L$2 = null;
            anonymousClass2.L$3 = null;
            anonymousClass2.I$0 = i;
            anonymousClass2.I$1 = i3;
            anonymousClass2.label = 3;
        }
        obj = t;
        obj = t;
        return coroutineSingletons;
    }
}
