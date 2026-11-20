package com.metrolist.innertubex.cipher;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ZemerCipherSolver {
    public static final Path.Companion Companion = new Path.Companion((byte) 4);
    public static final Regex VALID_N_RESULT = new Regex("^[A-Za-z0-9_-]+$");
    public final QuickJsEngine engine;

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.ZemerCipherSolver$call$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZemerCipherSolver.this.call(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.ZemerCipherSolver$solveN$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01171 extends ContinuationImpl {
        public String L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01171(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZemerCipherSolver.this.solveN(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.ZemerCipherSolver$solveSignature$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01181 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01181(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZemerCipherSolver.this.solveSignature(null, this);
        }
    }

    public ZemerCipherSolver(QuickJsEngine quickJsEngine) {
        this.engine = quickJsEngine;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object call(String str, String str2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objCallFunction = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objCallFunction);
                QuickJsEngine quickJsEngine = this.engine;
                anonymousClass1.label = 1;
                objCallFunction = quickJsEngine.callFunction(str, str2, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCallFunction == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objCallFunction);
            }
            return (String) objCallFunction;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object solveN(String str, ContinuationImpl continuationImpl) {
        C01171 c01171;
        if (continuationImpl instanceof C01171) {
            c01171 = (C01171) continuationImpl;
            int i = c01171.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01171.label = i - Integer.MIN_VALUE;
            } else {
                c01171 = new C01171(continuationImpl);
            }
        } else {
            c01171 = new C01171(continuationImpl);
        }
        Object objCall = c01171.result;
        int i2 = c01171.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCall);
            c01171.L$0 = str;
            c01171.label = 1;
            objCall = call("_nTransformFunc", str, c01171);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCall == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = c01171.L$0;
            ResultKt.throwOnFailure(objCall);
        }
        String str2 = (String) objCall;
        if (str2 == null || StringsKt.isBlank(str2) || str2.equals(str)) {
            return null;
        }
        return str2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object solveSignature(String str, ContinuationImpl continuationImpl) {
        C01181 c01181;
        if (continuationImpl instanceof C01181) {
            c01181 = (C01181) continuationImpl;
            int i = c01181.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01181.label = i - Integer.MIN_VALUE;
            } else {
                c01181 = new C01181(continuationImpl);
            }
        } else {
            c01181 = new C01181(continuationImpl);
        }
        Object objCall = c01181.result;
        int i2 = c01181.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCall);
            c01181.label = 1;
            objCall = call("_cipherSigFunc", str, c01181);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCall == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objCall);
        }
        String str2 = (String) objCall;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        return str2;
    }
}
