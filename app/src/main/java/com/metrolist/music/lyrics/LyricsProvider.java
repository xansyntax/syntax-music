package com.metrolist.music.lyrics;

import android.content.Context;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LyricsProvider {

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsProvider$getAllLyrics$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Function1 L$6;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsProvider.getAllLyrics$suspendImpl(LyricsProvider.this, null, null, null, null, 0, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    static Object getAllLyrics$suspendImpl(LyricsProvider lyricsProvider, Context context, String str, String str2, String str3, int i, String str4, Function1 function1, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object objMo1450getLyricsbMdYcbs;
        Function1 function2;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = lyricsProvider.new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = lyricsProvider.new AnonymousClass1(continuationImpl);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        int i3 = anonymousClass2.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass2.L$6 = function1;
            anonymousClass2.label = 1;
            objMo1450getLyricsbMdYcbs = lyricsProvider.mo1450getLyricsbMdYcbs(context, str, str2, str3, i, str4, anonymousClass2);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objMo1450getLyricsbMdYcbs == obj2) {
                return obj2;
            }
            function2 = function1;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            function2 = anonymousClass2.L$6;
            ResultKt.throwOnFailure(obj);
            objMo1450getLyricsbMdYcbs = ((Result) obj).value;
        }
        if (!(objMo1450getLyricsbMdYcbs instanceof Result.Failure)) {
            function2.invoke(objMo1450getLyricsbMdYcbs);
        }
        return Unit.INSTANCE;
    }

    default Object getAllLyrics(Context context, String str, String str2, String str3, int i, String str4, Function1 function1, Continuation continuation) {
        return getAllLyrics$suspendImpl(this, context, str, str2, str3, i, str4, function1, (ContinuationImpl) continuation);
    }

    /* JADX INFO: renamed from: getLyrics-bMdYcbs */
    Object mo1450getLyricsbMdYcbs(Context context, String str, String str2, String str3, int i, String str4, ContinuationImpl continuationImpl);

    String getName();

    boolean isEnabled(Context context);
}
