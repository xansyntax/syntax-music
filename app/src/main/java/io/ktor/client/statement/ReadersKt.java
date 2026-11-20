package io.ktor.client.statement;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "count", "", "readBytes", "(Lio/ktor/client/statement/HttpResponse;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRawBytes", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "discardRemaining", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReadersKt {

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readBytes$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {17}, m = "readBytes", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readBytes(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readBytes$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {51}, m = "readBytes", v = 1)
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readBytes(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readRawBytes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", l = {34}, m = "readRawBytes", v = 1)
    public static final class C02971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02971(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readRawBytes(null, this);
        }
    }

    public static final Object discardRemaining(HttpResponse httpResponse, Continuation continuation) {
        Object objDiscard$default = ByteReadChannelOperationsKt.discard$default(httpResponse.getRawContent(), 0L, continuation, 1, null);
        return objDiscard$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objDiscard$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object readBytes(HttpResponse httpResponse, int i, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        int i3 = anonymousClass2.label;
        if (i3 != 0) {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byte[] bArr = (byte[]) anonymousClass2.L$1;
            ResultKt.throwOnFailure(obj);
            return bArr;
        }
        ResultKt.throwOnFailure(obj);
        byte[] bArr2 = new byte[i];
        ByteReadChannel rawContent = httpResponse.getRawContent();
        anonymousClass2.L$0 = null;
        anonymousClass2.L$1 = bArr2;
        anonymousClass2.L$2 = null;
        anonymousClass2.I$0 = i;
        anonymousClass2.I$1 = 0;
        anonymousClass2.label = 1;
        Object fully$default = ByteReadChannelOperationsKt.readFully$default(rawContent, bArr2, 0, 0, anonymousClass2, 6, null);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return fully$default == coroutineSingletons ? coroutineSingletons : bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readRawBytes(HttpResponse httpResponse, Continuation continuation) {
        C02971 c02971;
        if (continuation instanceof C02971) {
            c02971 = (C02971) continuation;
            int i = c02971.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02971.label = i - Integer.MIN_VALUE;
            } else {
                c02971 = new C02971(continuation);
            }
        } else {
            c02971 = new C02971(continuation);
        }
        Object buffer = c02971.result;
        int i2 = c02971.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(buffer);
            ByteReadChannel rawContent = httpResponse.getRawContent();
            c02971.L$0 = null;
            c02971.label = 1;
            buffer = ByteReadChannelOperationsKt.readBuffer(rawContent, c02971);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (buffer == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(buffer);
        }
        return Utf8Kt.readByteArray((Source) buffer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Deprecated
    public static final Object readBytes(HttpResponse httpResponse, Continuation continuation) {
        AnonymousClass3 anonymousClass3;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object buffer = anonymousClass3.result;
        int i2 = anonymousClass3.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(buffer);
            ByteReadChannel rawContent = httpResponse.getRawContent();
            anonymousClass3.L$0 = null;
            anonymousClass3.label = 1;
            buffer = ByteReadChannelOperationsKt.readBuffer(rawContent, anonymousClass3);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (buffer == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(buffer);
        }
        return Utf8Kt.readByteArray((Source) buffer);
    }
}
