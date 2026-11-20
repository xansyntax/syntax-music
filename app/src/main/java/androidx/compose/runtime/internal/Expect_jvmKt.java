package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import java.util.ArrayList;
import kotlin.Function;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Expect_jvmKt {
    public static final StackTraceElement[] EmptyStackTraceElements = new StackTraceElement[0];
    public static final ThreadMap emptyThreadMap = new ThreadMap(0, new long[0], new Object[0]);

    public static final int bitsForSlot(int i, int i2) {
        return i << (((i2 % 10) * 3) + 1);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static final void invokeComposable(GapComposer gapComposer, Function2 function2) {
        function2.getClass();
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
        function2.invoke(gapComposer, 1);
    }

    public static final ComposableLambdaImpl rememberComposableLambda(int i, Function function, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new ComposableLambdaImpl(true, i, function);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) objRememberedValue;
        if (!composableLambdaImpl._block.equals(function)) {
            composableLambdaImpl._block = function;
            if (composableLambdaImpl.tracked) {
                RecomposeScopeImpl recomposeScopeImpl = composableLambdaImpl.scope;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                    composableLambdaImpl.scope = null;
                }
                ArrayList arrayList = composableLambdaImpl.scopes;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RecomposeScopeImpl) arrayList.get(i2)).invalidate();
                    }
                    arrayList.clear();
                }
            }
        }
        return composableLambdaImpl;
    }
}
