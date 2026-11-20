package androidx.compose.foundation.gestures;

import com.metrolist.innertubex.extraction.YtConfigParserImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NonTouchScrollingLogicKt$untilNull$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Object $builderAction;
    public final /* synthetic */ byte $r8$classId = 1;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonTouchScrollingLogicKt$untilNull$1(YtConfigParserImpl ytConfigParserImpl, String str, Continuation continuation) {
        super(2, continuation);
        this.L$0 = ytConfigParserImpl;
        this.$builderAction = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$builderAction;
        switch (b) {
            case 0:
                NonTouchScrollingLogicKt$untilNull$1 nonTouchScrollingLogicKt$untilNull$1 = new NonTouchScrollingLogicKt$untilNull$1((Function0) obj2, continuation);
                nonTouchScrollingLogicKt$untilNull$1.L$0 = obj;
                return nonTouchScrollingLogicKt$untilNull$1;
            default:
                NonTouchScrollingLogicKt$untilNull$1 nonTouchScrollingLogicKt$untilNull$2 = new NonTouchScrollingLogicKt$untilNull$1((YtConfigParserImpl) this.L$0, (String) obj2, continuation);
                nonTouchScrollingLogicKt$untilNull$2.L$1 = obj;
                return nonTouchScrollingLogicKt$untilNull$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SequenceScope sequenceScope = (SequenceScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((NonTouchScrollingLogicKt$untilNull$1) create(sequenceScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0088  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0088 -> B:25:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            byte r0 = r9.$r8$classId
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            java.lang.Object r2 = r9.$builderAction
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r5 = 1
            r6 = 0
            switch(r0) {
                case 0: goto L57;
                default: goto Lf;
            }
        Lf:
            java.lang.Object r0 = r9.L$1
            kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
            boolean r7 = r9.label
            if (r7 == 0) goto L22
            if (r7 != r5) goto L1d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L56
        L1d:
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r3)
            r1 = r6
            goto L56
        L22:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.text.Regex r10 = com.metrolist.innertubex.extraction.YtConfigParserImpl.LOOSE_PLAYER_URL_PATTERN
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "\\/"
            java.lang.String r7 = "/"
            r8 = 0
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.replace(r2, r3, r7, r8)
            java.lang.String r3 = "\\u0026"
            java.lang.String r7 = "&"
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.replace(r2, r3, r7, r8)
            kotlin.text.MatcherMatchResult r10 = kotlin.text.Regex.find$default(r10, r2)
            if (r10 == 0) goto L56
            java.util.List r10 = r10.getGroupValues()
            kotlin.collections.ReversedListReadOnly r10 = (kotlin.collections.ReversedListReadOnly) r10
            java.lang.Object r10 = r10.get(r5)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L56
            r9.L$1 = r6
            r9.label = r5
            r0.yield(r10, r9)
            r1 = r4
        L56:
            return r1
        L57:
            boolean r0 = r9.label
            if (r0 == 0) goto L6c
            if (r0 != r5) goto L67
            java.lang.Object r0 = r9.L$1
            java.lang.Object r3 = r9.L$0
            kotlin.sequences.SequenceScope r3 = (kotlin.sequences.SequenceScope) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L89
        L67:
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r3)
            r1 = r6
            goto L8b
        L6c:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            r3 = r10
        L74:
            r10 = r2
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            java.lang.Object r10 = r10.invoke()
            if (r10 == 0) goto L88
            r9.L$0 = r3
            r9.L$1 = r10
            r9.label = r5
            r3.yield(r10, r9)
            r1 = r4
            goto L8b
        L88:
            r0 = r6
        L89:
            if (r0 != 0) goto L74
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.NonTouchScrollingLogicKt$untilNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonTouchScrollingLogicKt$untilNull$1(Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.$builderAction = function0;
    }
}
