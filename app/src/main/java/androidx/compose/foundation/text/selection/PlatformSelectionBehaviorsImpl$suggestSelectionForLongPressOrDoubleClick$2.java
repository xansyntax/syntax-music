package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $selection;
    public final /* synthetic */ CharSequence $text;
    public long J$0;
    public /* synthetic */ Object L$0;
    public MutexImpl L$1;
    public PlatformSelectionBehaviorsImpl L$2;
    public byte label;
    public final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, CharSequence charSequence, Continuation continuation) {
        super(2, continuation);
        this.$text = charSequence;
        this.$selection = j;
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$selection, this.this$0, this.$text, continuation);
        platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2.L$0 = obj;
        return platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2) create((TextClassifier) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        MutexImpl mutexImpl;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        TextClassificationResult textClassificationResult;
        byte b = this.label;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifier = (TextClassifier) this.L$0;
            long j2 = this.$selection;
            int iM744getMinimpl = TextRange.m744getMinimpl(j2);
            int iM743getMaximpl = TextRange.m743getMaximpl(j2);
            CharSequence charSequence = this.$text;
            TextSelection.Request.Builder builder = new TextSelection.Request.Builder(charSequence, iM744getMinimpl, iM743getMaximpl);
            PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl2 = this.this$0;
            TextSelection.Request.Builder defaultLocales = builder.setDefaultLocales(platformSelectionBehaviorsImpl2.getAndroidLocalList());
            int i = Build.VERSION.SDK_INT;
            if (i >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection textSelectionSuggestSelection = textClassifier.suggestSelection(defaultLocales.build());
            long jTextRange = TextRangeKt.TextRange(textSelectionSuggestSelection.getSelectionStartIndex(), textSelectionSuggestSelection.getSelectionEndIndex());
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i < 31 || textSelectionSuggestSelection.getTextClassification() == null) {
                this.J$0 = jTextRange;
                this.label = (byte) 2;
                if (this.this$0.m227classifyTextM8tDOmk(this.$text, jTextRange, textClassifier, this) != coroutineSingletons) {
                    j = jTextRange;
                }
            } else {
                TextClassification textClassification = textSelectionSuggestSelection.getTextClassification();
                textClassification.getClass();
                TextClassificationResult textClassificationResultM228createTextClassificationResultSbBc2M = platformSelectionBehaviorsImpl2.m228createTextClassificationResultSbBc2M(charSequence, jTextRange, textClassification);
                mutexImpl = platformSelectionBehaviorsImpl2.mutex;
                this.L$0 = textClassificationResultM228createTextClassificationResultSbBc2M;
                this.L$1 = mutexImpl;
                this.L$2 = platformSelectionBehaviorsImpl2;
                this.J$0 = jTextRange;
                this.label = (byte) 1;
                if (mutexImpl.lock(this) != coroutineSingletons) {
                    platformSelectionBehaviorsImpl = platformSelectionBehaviorsImpl2;
                    textClassificationResult = textClassificationResultM228createTextClassificationResultSbBc2M;
                    j = jTextRange;
                    platformSelectionBehaviorsImpl.textClassificationResult$delegate.setValue(textClassificationResult);
                }
            }
            return coroutineSingletons;
        }
        if (b == 1) {
            j = this.J$0;
            platformSelectionBehaviorsImpl = this.L$2;
            mutexImpl = this.L$1;
            textClassificationResult = (TextClassificationResult) this.L$0;
            ResultKt.throwOnFailure(obj);
            try {
                platformSelectionBehaviorsImpl.textClassificationResult$delegate.setValue(textClassificationResult);
            } finally {
                mutexImpl.unlock(null);
            }
        } else {
            if (b != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return new TextRange(j);
    }
}
