package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda3(MutableState mutableState, Transition.TransitionAnimationState transitionAnimationState, Transition.TransitionAnimationState transitionAnimationState2, State state, ComposableLambdaImpl composableLambdaImpl, TooltipScopeImpl tooltipScopeImpl) {
        this.$r8$classId = (byte) 0;
        this.f$0 = mutableState;
        this.f$1 = transitionAnimationState;
        this.f$2 = transitionAnimationState2;
        this.f$3 = state;
        this.f$4 = composableLambdaImpl;
        this.f$5 = tooltipScopeImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$5;
        Object obj4 = this.f$4;
        Object obj5 = this.f$3;
        Object obj6 = this.f$2;
        Object obj7 = this.f$1;
        Object obj8 = this.f$0;
        switch (b) {
            case 0:
                MutableState mutableState = (MutableState) obj8;
                State state = (State) obj7;
                State state2 = (State) obj6;
                State state3 = (State) obj5;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 9);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(companion, (Function1) objRememberedValue);
                    BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    boolean z2 = gapComposer.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z2) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    gapComposer.startMovableGroup(-1350495383, Integer.valueOf(((Number) state3.getValue()).intValue()));
                    boolean zChanged = gapComposer.changed(state) | gapComposer.changed(state2);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        z = false;
                        objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(state, state2, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        z = false;
                    }
                    Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(companion, (Function1) objRememberedValue2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierGraphicsLayer);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    composableLambdaImpl.invoke((Object) tooltipScopeImpl, (Object) gapComposer, (Object) 6);
                    gapComposer.end(true);
                    gapComposer.end(false);
                    gapComposer.end(true);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                com.metrolist.music.ui.component.MenuKt.LyricsShareDialog((String) obj8, (String) obj7, (String) obj6, (String) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(221185));
                break;
            case 2:
                ((Integer) obj2).getClass();
                AlbumMenuKt.LyricsMenu((Function0) obj8, (Function0) obj7, (Function0) obj6, (Function0) obj5, (Function0) obj4, (LyricsMenuViewModel) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                AlbumMenuKt.PlaylistMenu((Playlist) obj8, (CoroutineScope) obj7, (Function0) obj6, (Boolean) obj5, (Boolean) obj4, (List) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$5 = obj6;
    }
}
