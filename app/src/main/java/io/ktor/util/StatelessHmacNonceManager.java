package io.ktor.util;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import io.ktor.openapi.Xml$$ExternalSyntheticLambda0;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.HexExtensionsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014BK\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fBE\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001e\b\u0002\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0004\b\u000e\u0010\u0011BE\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001e\b\u0002\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0004\b\u000e\u0010\u0014B5\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0004\b\u000e\u0010\u0016B5\b\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0004\b\u000e\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010#\u0012\u0004\b&\u0010\"\u001a\u0004\b$\u0010%R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010'\u0012\u0004\b*\u0010\"\u001a\u0004\b(\u0010)R*\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010+R&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010,\u0012\u0004\b/\u0010\"\u001a\u0004\b-\u0010.R\u001a\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\f\n\u0004\b1\u00102\u0012\u0004\b3\u0010\"¨\u00065"}, d2 = {"Lio/ktor/util/StatelessHmacNonceManager;", "Lio/ktor/util/NonceManager;", "Ljavax/crypto/spec/SecretKeySpec;", "keySpec", "", "algorithm", "", "timeoutMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "suspendNonceGenerator", "", "dummy", "<init>", "(Ljavax/crypto/spec/SecretKeySpec;Ljava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/Unit;)V", "nonceGenerator", "(Ljavax/crypto/spec/SecretKeySpec;Ljava/lang/String;JLkotlin/jvm/functions/Function1;)V", "", "key", "([BLjava/lang/String;JLkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "(Ljavax/crypto/spec/SecretKeySpec;Ljava/lang/String;JLkotlin/jvm/functions/Function0;)V", "([BLjava/lang/String;JLkotlin/jvm/functions/Function0;)V", "newNonce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nonce", "", "verifyNonce", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljavax/crypto/spec/SecretKeySpec;", "getKeySpec", "()Ljavax/crypto/spec/SecretKeySpec;", "getKeySpec$annotations", "()V", "Ljava/lang/String;", "getAlgorithm", "()Ljava/lang/String;", "getAlgorithm$annotations", "J", "getTimeoutMillis", "()J", "getTimeoutMillis$annotations", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "getNonceGenerator", "()Lkotlin/jvm/functions/Function0;", "getNonceGenerator$annotations", "", "macLength", "I", "getMacLength$annotations", "Companion", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatelessHmacNonceManager implements NonceManager {
    private static final Companion Companion = new Companion(null);
    private static final Function0 DEFAULT_LEGACY_NONCE_GENERATOR = new Xml$$ExternalSyntheticLambda0(29);
    private final String algorithm;
    private final SecretKeySpec keySpec;
    private final int macLength;
    private final Function0 nonceGenerator;
    private final Function1 suspendNonceGenerator;
    private final long timeoutMillis;

    /* JADX INFO: renamed from: io.ktor.util.StatelessHmacNonceManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager$1", f = "StatelessHmacNonceManager.kt", l = {36}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function1 {
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objGenerateNonceSuspend$default = CryptoKt__CryptoJvmKt.generateNonceSuspend$default(0, this, 1, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objGenerateNonceSuspend$default == coroutineSingletons ? coroutineSingletons : objGenerateNonceSuspend$default;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.StatelessHmacNonceManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager$2", f = "StatelessHmacNonceManager.kt", l = {48}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function1 {
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objGenerateNonceSuspend$default = CryptoKt__CryptoJvmKt.generateNonceSuspend$default(0, this, 1, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objGenerateNonceSuspend$default == coroutineSingletons ? coroutineSingletons : objGenerateNonceSuspend$default;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.StatelessHmacNonceManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager$3", f = "StatelessHmacNonceManager.kt", l = {68}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass3 extends SuspendLambda implements Function1 {
        int label;

        public AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objGenerateNonceSuspend$default = CryptoKt__CryptoJvmKt.generateNonceSuspend$default(0, this, 1, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objGenerateNonceSuspend$default == coroutineSingletons ? coroutineSingletons : objGenerateNonceSuspend$default;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.StatelessHmacNonceManager$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager$4", f = "StatelessHmacNonceManager.kt", l = {}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass4 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function0 $nonceGenerator;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Function0 function0, Continuation continuation) {
            super(1, continuation);
            this.$nonceGenerator = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass4(this.$nonceGenerator, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return this.$nonceGenerator.invoke();
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.StatelessHmacNonceManager$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager$5", f = "StatelessHmacNonceManager.kt", l = {91}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass5 extends SuspendLambda implements Function1 {
        int label;

        public AnonymousClass5(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objGenerateNonceSuspend$default = CryptoKt__CryptoJvmKt.generateNonceSuspend$default(0, this, 1, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objGenerateNonceSuspend$default == coroutineSingletons ? coroutineSingletons : objGenerateNonceSuspend$default;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.StatelessHmacNonceManager$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager$6", f = "StatelessHmacNonceManager.kt", l = {}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass6 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function0 $nonceGenerator;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Function0 function0, Continuation continuation) {
            super(1, continuation);
            this.$nonceGenerator = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass6(this.$nonceGenerator, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return this.$nonceGenerator.invoke();
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.StatelessHmacNonceManager$newNonce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.StatelessHmacNonceManager", f = "StatelessHmacNonceManager.kt", l = {115}, m = "newNonce", v = 1)
    public static final class C03271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C03271(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatelessHmacNonceManager.this.newNonce(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public /* synthetic */ StatelessHmacNonceManager(byte[] bArr, String str, long j, Function0 function0) {
        this(new SecretKeySpec(bArr, str), str, j, function0 == DEFAULT_LEGACY_NONCE_GENERATOR ? new AnonymousClass5(null) : new AnonymousClass6(function0, null), Unit.INSTANCE);
        bArr.getClass();
        str.getClass();
        function0.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DEFAULT_LEGACY_NONCE_GENERATOR$lambda$0() {
        return CryptoKt__CryptoJvmKt.generateNonceBlocking$default(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String nonceGenerator$lambda$0(StatelessHmacNonceManager statelessHmacNonceManager) {
        return (String) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new StatelessHmacNonceManager$nonceGenerator$1$1(statelessHmacNonceManager, null));
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final SecretKeySpec getKeySpec() {
        return this.keySpec;
    }

    public final Function0 getNonceGenerator() {
        return this.nonceGenerator;
    }

    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.util.NonceManager
    public Object newNonce(Continuation continuation) throws NoSuchAlgorithmException, InvalidKeyException {
        C03271 c03271;
        if (continuation instanceof C03271) {
            c03271 = (C03271) continuation;
            int i = c03271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03271.label = i - Integer.MIN_VALUE;
            } else {
                c03271 = new C03271(continuation);
            }
        } else {
            c03271 = new C03271(continuation);
        }
        Object objInvoke = c03271.result;
        int i2 = c03271.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            Function1 function1 = this.suspendNonceGenerator;
            c03271.label = 1;
            objInvoke = function1.invoke(c03271);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objInvoke);
        }
        String str = (String) objInvoke;
        long jNanoTime = System.nanoTime();
        CharsKt.checkRadix(16);
        String string = Long.toString(jNanoTime, 16);
        string.getClass();
        String strPadStart = StringsKt.padStart(16, string);
        Mac mac = Mac.getInstance(this.algorithm);
        mac.init(this.keySpec);
        byte[] bytes = (str + ':' + strPadStart).getBytes(Charsets.ISO_8859_1);
        bytes.getClass();
        mac.update(bytes);
        byte[] bArrDoFinal = mac.doFinal();
        bArrDoFinal.getClass();
        return str + '+' + strPadStart + '+' + HexExtensionsKt.toHexString$default(bArrDoFinal);
    }

    @Override // io.ktor.util.NonceManager
    public Object verifyNonce(String str, Continuation continuation) throws NoSuchAlgorithmException, InvalidKeyException {
        List listSplit$default = StringsKt.split$default(str, new char[]{'+'});
        if (listSplit$default.size() != 3) {
            return Boolean.FALSE;
        }
        String str2 = (String) listSplit$default.get(0);
        String str3 = (String) listSplit$default.get(1);
        String str4 = (String) listSplit$default.get(2);
        if (str2.length() < 8) {
            return Boolean.FALSE;
        }
        if (str4.length() != this.macLength * 2) {
            return Boolean.FALSE;
        }
        if (str3.length() != 16) {
            return Boolean.FALSE;
        }
        CharsKt.checkRadix(16);
        if (TimeUnit.MILLISECONDS.toNanos(this.timeoutMillis) + Long.parseLong(str3, 16) < System.nanoTime()) {
            return Boolean.FALSE;
        }
        Mac mac = Mac.getInstance(this.algorithm);
        mac.init(this.keySpec);
        byte[] bytes = (str2 + ':' + str3).getBytes(Charsets.ISO_8859_1);
        bytes.getClass();
        mac.update(bytes);
        byte[] bArrDoFinal = mac.doFinal();
        bArrDoFinal.getClass();
        String hexString$default = HexExtensionsKt.toHexString$default(bArrDoFinal);
        int iMin = Math.min(hexString$default.length(), str4.length());
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            if (hexString$default.charAt(i2) == str4.charAt(i2)) {
                i++;
            }
        }
        return Boolean.valueOf(i == this.macLength * 2);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/util/StatelessHmacNonceManager$Companion;", "", "<init>", "()V", "Lkotlin/Function0;", "", "DEFAULT_LEGACY_NONCE_GENERATOR", "Lkotlin/jvm/functions/Function0;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Deprecated
    public static /* synthetic */ void getAlgorithm$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getKeySpec$annotations() {
    }

    private static /* synthetic */ void getMacLength$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getNonceGenerator$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getTimeoutMillis$annotations() {
    }

    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function1 function1, Unit unit, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(secretKeySpec, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 6000L : j, function1, unit);
    }

    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(secretKeySpec, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 6000L : j, (i & 8) != 0 ? new AnonymousClass1(null) : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function1 function1) {
        this(secretKeySpec, str, j, function1, Unit.INSTANCE);
        secretKeySpec.getClass();
        str.getClass();
        function1.getClass();
    }

    public /* synthetic */ StatelessHmacNonceManager(byte[] bArr, String str, long j, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000L : j, (i & 8) != 0 ? new AnonymousClass2(null) : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatelessHmacNonceManager(byte[] bArr, String str, long j, Function1 function1) {
        this(new SecretKeySpec(bArr, str), str, j, function1, Unit.INSTANCE);
        bArr.getClass();
        str.getClass();
        function1.getClass();
    }

    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(secretKeySpec, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000L : j, (i & 8) != 0 ? DEFAULT_LEGACY_NONCE_GENERATOR : function0);
    }

    @Deprecated
    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function0 function0) {
        Function1 anonymousClass4;
        secretKeySpec.getClass();
        str.getClass();
        function0.getClass();
        if (function0 == DEFAULT_LEGACY_NONCE_GENERATOR) {
            anonymousClass4 = new AnonymousClass3(null);
        } else {
            anonymousClass4 = new AnonymousClass4(function0, null);
        }
        this(secretKeySpec, str, j, anonymousClass4, Unit.INSTANCE);
    }

    public /* synthetic */ StatelessHmacNonceManager(byte[] bArr, String str, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000L : j, (i & 8) != 0 ? DEFAULT_LEGACY_NONCE_GENERATOR : function0);
    }

    private StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, Function1 function1, Unit unit) throws NoSuchAlgorithmException, InvalidKeyException {
        this.keySpec = secretKeySpec;
        this.algorithm = str;
        this.timeoutMillis = j;
        this.suspendNonceGenerator = function1;
        this.nonceGenerator = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 28, this);
        Mac mac = Mac.getInstance(str);
        mac.init(secretKeySpec);
        this.macLength = mac.getMacLength();
    }
}
