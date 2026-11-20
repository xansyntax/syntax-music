package androidx.compose.foundation.text;

import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotatedStringResolveInlineContentKt {
    public static final Pair EmptyInlineContent;

    static {
        EmptyList emptyList = EmptyList.INSTANCE;
        EmptyInlineContent = new Pair(emptyList, emptyList);
    }

    public static final void InlineChildren(AnnotatedString annotatedString, List list, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1794596951);
        int i2 = (i & 6) == 0 ? (gapComposer.changed(annotatedString) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(list) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                AnnotatedString.Range range = (AnnotatedString.Range) list.get(i3);
                Function3 function3 = (Function3) range.item;
                int i4 = range.start;
                int i5 = range.end;
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = EmptyMeasurePolicy.INSTANCE$1;
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                function3.invoke(annotatedString.subSequence(i4, i5).text, gapComposer, 0);
                gapComposer.end(true);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(annotatedString, list, i, (byte) 6);
        }
    }
}
