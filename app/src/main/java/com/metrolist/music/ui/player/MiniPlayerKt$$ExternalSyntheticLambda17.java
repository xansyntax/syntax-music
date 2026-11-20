package com.metrolist.music.ui.player;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.EditorialComponentsKt$popWhen$1$1$1;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MiniPlayerKt$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda17(byte b, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    long jColor = z ? -72057594037927936L : ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.6f, Color.m483getColorSpaceimpl(-72057594037927936L));
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, jColor, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.info, 0, gapComposer), (String) null, BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.Center), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, gapComposer, 56, 0);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Modifier modifier = (Modifier) obj;
                ((Integer) obj3).getClass();
                modifier.getClass();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                gapComposer2.startReplaceGroup(667667910);
                Object objRememberedValue = gapComposer2.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = ArcSplineKt.Animatable$default(1.0f);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Animatable animatable = (Animatable) objRememberedValue;
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                Object obj4 = objRememberedValue2;
                if (objRememberedValue2 == neverEqualPolicy) {
                    boolean[] zArr = {true};
                    gapComposer2.updateRememberedValue(zArr);
                    obj4 = zArr;
                }
                boolean[] zArr2 = (boolean[]) obj4;
                Boolean boolValueOf = Boolean.valueOf(z);
                boolean zChangedInstance = gapComposer2.changedInstance(zArr2) | gapComposer2.changed(z) | gapComposer2.changedInstance(animatable);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new EditorialComponentsKt$popWhen$1$1$1(zArr2, z, animatable, (Continuation) null);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                Stack.LaunchedEffect(gapComposer2, boolValueOf, (Function2) objRememberedValue3);
                boolean zChangedInstance2 = gapComposer2.changedInstance(animatable);
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new MiniPlayerKt$$ExternalSyntheticLambda2(animatable, (byte) 5);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifier, (Function1) objRememberedValue4);
                gapComposer2.end(false);
                return modifierGraphicsLayer;
            case 2:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    ListenTogetherScreenKt.HeaderSection(z, gapComposer3, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (!gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else if (z) {
                    gapComposer4.startReplaceGroup(474277039);
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(CropImageView.DEFAULT_ASPECT_RATIO, 0, 6, 28, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onPrimary, 0L, gapComposer4, SizeKt.m151size3ABfNKs(companion, 24.0f));
                    gapComposer4.end(false);
                } else {
                    gapComposer4.startReplaceGroup(474516700);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.wizard_save_profiles, gapComposer4), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer4, 1572864, 0, 131006);
                    gapComposer4.end(false);
                }
                return unit;
            default:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(z ? R.drawable.library_add_check : R.drawable.library_add, 0, gapComposer5), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer5, 440, 8);
                    OffsetKt.Spacer(gapComposer5, SizeKt.m151size3ABfNKs(companion, 8.0f));
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(z ? R.string.remove_from_library : R.string.add_to_library, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
        }
    }
}
