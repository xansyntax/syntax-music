package com.metrolist.music.ui.component;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.NavigationRailItemColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.db.entities.Album;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ boolean f$4;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda6(NavigationRailItemColors navigationRailItemColors, boolean z, boolean z2, FiniteAnimationSpec finiteAnimationSpec, boolean z3, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = navigationRailItemColors;
        this.f$3 = z;
        this.f$4 = z2;
        this.f$1 = finiteAnimationSpec;
        this.f$2 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                LibraryKt.LibraryAlbumListItem((Modifier) obj5, (MenuState) obj4, (Album) obj3, this.f$3, this.f$4, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                NavigationRailItemColors navigationRailItemColors = (NavigationRailItemColors) obj5;
                FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) obj4;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(this.f$4 ? this.f$3 ? navigationRailItemColors.selectedIconColor : navigationRailItemColors.unselectedIconColor : navigationRailItemColors.disabledIconColor, finiteAnimationSpec, null, gapComposer, 0, 12);
                    gapComposer.startReplaceGroup(453016797);
                    gapComposer.end(false);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
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
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = ContentColorKt.LocalContentColor;
                    Color color = (Color) animateAsStateM17animateColorAsStateeuL9pac.getValue();
                    long j = color.value;
                    Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(color), composableLambdaImpl, gapComposer, 8);
                    gapComposer.end(true);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda6(Modifier modifier, MenuState menuState, Album album, boolean z, boolean z2, int i) {
        this.f$0 = modifier;
        this.f$1 = menuState;
        this.f$2 = album;
        this.f$3 = z;
        this.f$4 = z2;
    }
}
