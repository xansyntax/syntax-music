package androidx.compose.ui;

import android.content.Context;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.HoverIconModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.PlaceableResult;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.intl.Locale;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposedModifierKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ComposedModifierKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        VerticalRuler verticalRuler;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return Boolean.valueOf(!(((Modifier.Element) obj) instanceof ComposedModifier));
            case 1:
                return unit;
            case 2:
                return Boolean.valueOf(SemanticsNodeKt.isAccessibilityIgnoredLink((SemanticsNode) obj));
            case 3:
                return unit;
            case 4:
                return unit;
            case 5:
                return unit;
            case 6:
                DrawScope.m550drawRectnJ9OG0$default((DrawScope) obj, 0L, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 126);
                return unit;
            case 7:
                ((HoverIconModifierNode) obj).getClass();
                return Boolean.TRUE;
            case 8:
                return unit;
            case 9:
                return unit;
            case 10:
                ComposeUiNode composeUiNode = (ComposeUiNode) obj;
                LayoutNode layoutNode = composeUiNode instanceof LayoutNode ? (LayoutNode) composeUiNode : null;
                if (layoutNode != null && layoutNode.isDeactivated) {
                    InlineClassHelperKt.throwIllegalStateException("Apply is called on deactivated node " + composeUiNode);
                }
                return unit;
            case 11:
                PlaceableResult placeableResult = (PlaceableResult) obj;
                if (placeableResult.isValidOwnerScope()) {
                    LookaheadCapablePlaceable lookaheadCapablePlaceable = placeableResult.placeable;
                    if (!lookaheadCapablePlaceable.isPlacingForAlignment) {
                        Function1 rulers = placeableResult.result.getRulers();
                        if (placeableResult.result.getRulerProvider() != null) {
                            lookaheadCapablePlaceable.resetProvidedRulers();
                        } else if (rulers == null) {
                            lookaheadCapablePlaceable.rulerProvider = null;
                            lookaheadCapablePlaceable.providedRulers = null;
                            lookaheadCapablePlaceable.rulersLambda = null;
                            lookaheadCapablePlaceable.resetProvidedRulers();
                        } else {
                            lookaheadCapablePlaceable.rulerProvider = null;
                            lookaheadCapablePlaceable.providedRulers = null;
                            lookaheadCapablePlaceable.m653captureRulersOSxE8f4(placeableResult, 9223372034707292159L, 0L);
                            lookaheadCapablePlaceable.rulersLambda = rulers;
                        }
                    }
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                PlaceableResult placeableResult2 = (PlaceableResult) obj;
                if (placeableResult2.isValidOwnerScope() && (verticalRuler = placeableResult2.ruler) != null) {
                    placeableResult2.placeable.resetSingleRulerRead(verticalRuler);
                }
                return unit;
            case 13:
                NodeCoordinator nodeCoordinator = (NodeCoordinator) obj;
                LayoutNode layoutNode2 = nodeCoordinator.layoutNode;
                try {
                    if (nodeCoordinator.isValidOwnerScope()) {
                        nodeCoordinator.updateLayerParameters(true);
                        break;
                    }
                    return unit;
                } catch (Throwable th) {
                    layoutNode2.rethrowWithComposeStackTrace(th);
                    throw null;
                }
            case 14:
                OwnedLayer ownedLayer = ((NodeCoordinator) obj).layer;
                if (ownedLayer != null) {
                    ((GraphicsLayerOwnerLayer) ownedLayer).invalidate();
                }
                return unit;
            case 15:
                ObserverNodeOwnerScope observerNodeOwnerScope = (ObserverNodeOwnerScope) obj;
                if (observerNodeOwnerScope.isValidOwnerScope()) {
                    observerNodeOwnerScope.observerNode.onObservedReadsChanged();
                }
                return unit;
            case 16:
                LayoutNode layoutNode3 = (LayoutNode) obj;
                if (layoutNode3.isAttached$1()) {
                    LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode3, false, 7);
                }
                return unit;
            case 17:
                LayoutNode layoutNode4 = (LayoutNode) obj;
                if (layoutNode4.isAttached$1()) {
                    LayoutNode.requestRemeasure$ui$default(layoutNode4, false, 7);
                }
                return unit;
            case 18:
                LayoutNode layoutNode5 = (LayoutNode) obj;
                if (layoutNode5.isAttached$1()) {
                    layoutNode5.invalidateSemantics$ui();
                }
                return unit;
            case 19:
                LayoutNode layoutNode6 = (LayoutNode) obj;
                if (layoutNode6.isAttached$1()) {
                    layoutNode6.requestRelayout$ui(false);
                }
                return unit;
            case 20:
                LayoutNode layoutNode7 = (LayoutNode) obj;
                if (layoutNode7.isAttached$1()) {
                    layoutNode7.requestRelayout$ui(false);
                }
                return unit;
            case 21:
                LayoutNode layoutNode8 = (LayoutNode) obj;
                if (layoutNode8.isAttached$1()) {
                    layoutNode8.requestLookaheadRelayout$ui(false);
                }
                return unit;
            case 22:
                LayoutNode layoutNode9 = (LayoutNode) obj;
                if (layoutNode9.isAttached$1()) {
                    layoutNode9.requestLookaheadRelayout$ui(false);
                }
                return unit;
            case 23:
                obj.getClass();
                return Boolean.valueOf(!((OwnerScope) obj).isValidOwnerScope());
            case 24:
                return Boolean.TRUE;
            case 25:
                return Boolean.FALSE;
            case 26:
                return Boolean.valueOf(SemanticsNodeKt.isAccessibilityIgnoredLink((SemanticsNode) obj));
            case 27:
                return (PlatformTextInputService) obj;
            case 28:
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) obj;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalConfiguration;
                persistentCompositionLocalHashMap.getClass();
                Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal);
                return ((Context) Stack.read(persistentCompositionLocalHashMap, AndroidCompositionLocals_androidKt.LocalContext)).getResources();
            default:
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap2 = (PersistentCompositionLocalHashMap) obj;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = CompositionLocalsKt.LocalProvidableLocaleList;
                persistentCompositionLocalHashMap2.getClass();
                return (Locale) CollectionsKt.first((Iterable) Stack.read(persistentCompositionLocalHashMap2, staticProvidableCompositionLocal2));
        }
    }

    public /* synthetic */ ComposedModifierKt$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
    }
}
