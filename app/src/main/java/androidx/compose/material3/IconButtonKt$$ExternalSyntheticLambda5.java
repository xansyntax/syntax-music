package androidx.compose.material3;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IconButtonKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda5(String str, List list, Set set, boolean z, Function1 function1, Function0 function0, boolean z2, int i) {
        this.f$2 = str;
        this.f$4 = list;
        this.f$6 = set;
        this.f$0 = z;
        this.f$1 = function1;
        this.f$7 = function0;
        this.f$3 = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$7;
        Object obj4 = this.f$1;
        Object obj5 = this.f$6;
        Object obj6 = this.f$4;
        Object obj7 = this.f$2;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                CardKt.IconToggleButton(this.f$0, (Function1) obj4, (Modifier) obj7, this.f$3, (IconToggleButtonColors) obj6, (Shape) obj5, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(12582913));
                break;
            case 1:
                CoroutineScope coroutineScope = (CoroutineScope) obj4;
                Context context = (Context) obj7;
                String str = (String) obj6;
                String str2 = (String) obj5;
                MutableState mutableState = (MutableState) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else if (!this.f$0) {
                    gapComposer.startReplaceGroup(-1814927787);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1816991054);
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    boolean z = gapComposer.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    String strStringResource = MathKt.stringResource(R.string.sync_playlist, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer, 0, 0, 131070);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.allows_for_sync_witch_youtube, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 0, 0, 131066);
                    gapComposer.end(true);
                    Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(companion, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(context);
                    boolean z2 = this.f$3;
                    boolean zChanged = zChangedInstance | gapComposer.changed(z2) | gapComposer.changed(str) | gapComposer.changed(str2);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new CoreTextFieldKt$$ExternalSyntheticLambda6((byte) 1, coroutineScope, context, str, str2, mutableState, z2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    com.metrolist.music.ui.component.MenuKt.Switch(zBooleanValue, (Function1) objRememberedValue, modifierM139paddingqDBjuR0$default2, null, false, null, gapComposer, 384, 120);
                    gapComposer.end(true);
                    gapComposer.end(false);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                WizardScreenKt.VariantSelectionStep((String) obj7, (List) obj6, (Set) obj5, this.f$0, (Function1) obj4, (Function0) obj3, this.f$3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda5(boolean z, Function1 function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, Shape shape, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = z;
        this.f$1 = function1;
        this.f$2 = modifier;
        this.f$3 = z2;
        this.f$4 = iconToggleButtonColors;
        this.f$6 = shape;
        this.f$7 = composableLambdaImpl;
    }

    public /* synthetic */ IconButtonKt$$ExternalSyntheticLambda5(boolean z, CoroutineScope coroutineScope, Context context, boolean z2, String str, String str2, MutableState mutableState) {
        this.f$0 = z;
        this.f$1 = coroutineScope;
        this.f$2 = context;
        this.f$3 = z2;
        this.f$4 = str;
        this.f$6 = str2;
        this.f$7 = mutableState;
    }
}
