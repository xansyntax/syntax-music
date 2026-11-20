package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableElement;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.UnionInsets;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.provider.CallbackWrapper;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda17;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.http.ContentType;
import io.ktor.http.parsing.ParserDslKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ScrimKt {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void FadeInFadeOutWithScale(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, Modifier modifier, Composer composer, int i) {
        Object obj;
        ComposableLambdaImpl composableLambdaImpl = CardKt.f4lambda$1548712596;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-977568115);
        int i2 = (i & 6) == 0 ? (gapComposer.changed(snackbarDataImpl) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        byte b = 1;
        byte b2 = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            String strM373getString2EP1pXo = Icons$Filled.m373getString2EP1pXo(R.string.m3c_snackbar_pane_title, gapComposer);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                obj = objRememberedValue;
                FadeInFadeOutState fadeInFadeOutState = new FadeInFadeOutState();
                fadeInFadeOutState.current = new Object();
                fadeInFadeOutState.items = new ArrayList();
                gapComposer.updateRememberedValue(fadeInFadeOutState);
                obj = fadeInFadeOutState;
            }
            obj = objRememberedValue;
            FadeInFadeOutState fadeInFadeOutState2 = (FadeInFadeOutState) obj;
            Object obj2 = fadeInFadeOutState2.current;
            ArrayList arrayList = fadeInFadeOutState2.items;
            if (Intrinsics.areEqual(snackbarDataImpl, obj2)) {
                gapComposer.startReplaceGroup(1443889109);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1441886385);
                fadeInFadeOutState2.current = snackbarDataImpl;
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList2.add((SnackbarHostState.SnackbarDataImpl) ((FadeInFadeOutAnimationItem) arrayList.get(i3)).key);
                }
                ArrayList arrayList3 = new ArrayList(arrayList2);
                if (!arrayList3.contains(snackbarDataImpl)) {
                    arrayList3.add(snackbarDataImpl);
                }
                arrayList.clear();
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj3 = arrayList3.get(i4);
                    if (obj3 != null) {
                        arrayList4.add(obj3);
                    }
                }
                int size3 = arrayList4.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    SnackbarHostState.SnackbarDataImpl snackbarDataImpl2 = (SnackbarHostState.SnackbarDataImpl) arrayList4.get(i5);
                    arrayList.add(new FadeInFadeOutAnimationItem(snackbarDataImpl2, Expect_jvmKt.rememberComposableLambda(-1952400805, new SongMenuKt$$ExternalSyntheticLambda34(snackbarDataImpl2, snackbarDataImpl, fadeInFadeOutState2, strM373getString2EP1pXo, (byte) 4), gapComposer)));
                }
                gapComposer.end(false);
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
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
            RecomposeScopeImpl currentRecomposeScope$runtime = gapComposer.getCurrentRecomposeScope$runtime();
            if (currentRecomposeScope$runtime == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("no recompose scope found");
                return;
            }
            currentRecomposeScope$runtime.setUsed();
            fadeInFadeOutState2.scope = currentRecomposeScope$runtime;
            gapComposer.startReplaceGroup(-1888182177);
            int size4 = arrayList.size();
            for (int i6 = 0; i6 < size4; i6++) {
                FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) arrayList.get(i6);
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl3 = (SnackbarHostState.SnackbarDataImpl) fadeInFadeOutAnimationItem.key;
                ComposableLambdaImpl composableLambdaImpl2 = fadeInFadeOutAnimationItem.transition;
                gapComposer.startMovableGroup(1325010085, snackbarDataImpl3);
                composableLambdaImpl2.invoke((Object) Expect_jvmKt.rememberComposableLambda(-1893791890, new SnackbarKt$$ExternalSyntheticLambda1(snackbarDataImpl3, b), gapComposer), (Object) gapComposer, (Object) 6);
                gapComposer.end(false);
            }
            gapComposer.end(false);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(snackbarDataImpl, modifier, i, b2);
        }
    }

    /* JADX INFO: renamed from: LegacyOneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m315LegacyOneRowSnackbarkKq0p4A(ComposableLambdaImpl composableLambdaImpl, Function2 function2, Function2 function3, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        Function2 function4;
        TextStyle textStyle2;
        long j3;
        int i2;
        boolean z;
        boolean z2;
        long j4 = j2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-321841045);
        int i3 = i | (gapComposer.changedInstance(composableLambdaImpl) ? 4 : 2) | (gapComposer.changedInstance(function2) ? 32 : 16) | (gapComposer.changedInstance(function3) ? 256 : 128) | (gapComposer.changed(textStyle) ? 2048 : 1024) | (gapComposer.changed(j) ? 16384 : 8192) | (gapComposer.changed(j4) ? 131072 : 65536);
        byte b = 1;
        if (gapComposer.shouldExecute(i3 & 1, (74899 & i3) != 74898)) {
            float f = function3 == null ? 8.0f : CropImageView.DEFAULT_ASPECT_RATIO;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new BadgeKt$BadgedBox$1$1(b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z3 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z3) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, measurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(RulerKt.layoutId(companion, ContentType.Text.TYPE), CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, 1);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Fragment$5$$ExternalSyntheticOutline0.m(i3 & 14, composableLambdaImpl, gapComposer, true);
            if (function2 != null) {
                gapComposer.startReplaceGroup(989211000);
                Modifier modifierLayoutId = RulerKt.layoutId(companion, "action");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                i2 = 8;
                int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierLayoutId);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                j3 = j;
                textStyle2 = textStyle;
                Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(j3, ContentColorKt.LocalContentColor), TextKt.LocalTextStyle.defaultProvidedValue$runtime(textStyle2)}, function2, gapComposer, (i3 & 112) | 8);
                gapComposer.end(true);
                z = false;
                gapComposer.end(false);
            } else {
                textStyle2 = textStyle;
                j3 = j;
                i2 = 8;
                z = false;
                gapComposer.startReplaceGroup(989526208);
                gapComposer.end(false);
            }
            if (function3 != null) {
                gapComposer.startReplaceGroup(989574568);
                Modifier modifierLayoutId2 = RulerKt.layoutId(companion, "dismissAction");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z);
                int i4 = i2;
                int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierLayoutId2);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                j4 = j2;
                int i5 = i4 | ((i3 >> 3) & 112);
                function4 = function3;
                Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(j4, ContentColorKt.LocalContentColor), function4, gapComposer, i5);
                z2 = true;
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                function4 = function3;
                z2 = true;
                j4 = j2;
                gapComposer.startReplaceGroup(989843648);
                gapComposer.end(z);
            }
            gapComposer.end(z2);
        } else {
            function4 = function3;
            textStyle2 = textStyle;
            j3 = j;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarKt$$ExternalSyntheticLambda7(composableLambdaImpl, function2, function4, textStyle2, j3, j4, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0140  */
    /* JADX WARN: Code duplicated, block: B:102:0x0148  */
    /* JADX WARN: Code duplicated, block: B:106:0x0157  */
    /* JADX WARN: Code duplicated, block: B:107:0x015c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0162  */
    /* JADX WARN: Code duplicated, block: B:111:0x0168  */
    /* JADX WARN: Code duplicated, block: B:112:0x016b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0173  */
    /* JADX WARN: Code duplicated, block: B:117:0x0178  */
    /* JADX WARN: Code duplicated, block: B:119:0x0180  */
    /* JADX WARN: Code duplicated, block: B:123:0x0188  */
    /* JADX WARN: Code duplicated, block: B:124:0x018d  */
    /* JADX WARN: Code duplicated, block: B:126:0x0193  */
    /* JADX WARN: Code duplicated, block: B:129:0x019a  */
    /* JADX WARN: Code duplicated, block: B:133:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01be  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:154:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:156:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:160:0x0223 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x0225  */
    /* JADX WARN: Code duplicated, block: B:163:0x022a  */
    /* JADX WARN: Code duplicated, block: B:165:0x022e  */
    /* JADX WARN: Code duplicated, block: B:168:0x023a  */
    /* JADX WARN: Code duplicated, block: B:169:0x023c  */
    /* JADX WARN: Code duplicated, block: B:171:0x0240  */
    /* JADX WARN: Code duplicated, block: B:173:0x0243  */
    /* JADX WARN: Code duplicated, block: B:175:0x0246  */
    /* JADX WARN: Code duplicated, block: B:176:0x0248  */
    /* JADX WARN: Code duplicated, block: B:179:0x024d  */
    /* JADX WARN: Code duplicated, block: B:181:0x0251  */
    /* JADX WARN: Code duplicated, block: B:182:0x0254  */
    /* JADX WARN: Code duplicated, block: B:184:0x0258  */
    /* JADX WARN: Code duplicated, block: B:185:0x025b  */
    /* JADX WARN: Code duplicated, block: B:187:0x025f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0262  */
    /* JADX WARN: Code duplicated, block: B:190:0x0266  */
    /* JADX WARN: Code duplicated, block: B:191:0x0269  */
    /* JADX WARN: Code duplicated, block: B:193:0x026d  */
    /* JADX WARN: Code duplicated, block: B:194:0x0270  */
    /* JADX WARN: Code duplicated, block: B:197:0x0277  */
    /* JADX WARN: Code duplicated, block: B:198:0x027d  */
    /* JADX WARN: Code duplicated, block: B:201:0x0285  */
    /* JADX WARN: Code duplicated, block: B:203:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:206:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:210:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:212:0x0359  */
    /* JADX WARN: Code duplicated, block: B:215:0x037e  */
    /* JADX WARN: Code duplicated, block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x009a  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00be  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:82:0x0104  */
    /* JADX WARN: Code duplicated, block: B:83:0x0107  */
    /* JADX WARN: Code duplicated, block: B:87:0x0111  */
    /* JADX WARN: Code duplicated, block: B:88:0x0116  */
    /* JADX WARN: Code duplicated, block: B:90:0x011c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0124  */
    /* JADX WARN: Code duplicated, block: B:93:0x0127  */
    /* JADX WARN: Code duplicated, block: B:96:0x012e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0139  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20 */
    public static final void OutlinedTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function3, Function2 function4, Function2 function5, Function2 function6, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        final Modifier modifier2;
        int i6;
        final boolean z4;
        int i7;
        int i8;
        int i9;
        boolean z5;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final Function2 function7;
        int i15;
        int i16;
        final Function2 function8;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        char c;
        int i32;
        final int i33;
        boolean z6;
        final TextStyle textStyle2;
        final Function2 function9;
        final VisualTransformation visualTransformation2;
        final KeyboardOptions keyboardOptions2;
        final boolean z7;
        final int i34;
        final Shape value;
        final TextFieldColors textFieldColors2;
        final Function2 function10;
        final boolean z8;
        final Function2 function11;
        final boolean z9;
        final Function2 function12;
        final Function2 function13;
        final KeyboardActions keyboardActions2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        TextStyle textStyle3;
        Function2 function14;
        final Function2 function15;
        final Function2 function16;
        final VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions3;
        boolean z10;
        final TextFieldColors textFieldColorsColors;
        final boolean z11;
        ?? r1;
        Object objRememberedValue;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl;
        long jM752getColor0d7_KjU;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1901501544);
        int i35 = (gapComposer.changed(str) ? 4 : 2) | i3;
        if ((i3 & 48) == 0) {
            i35 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        int i36 = i5 & 4;
        if (i36 == 0) {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i35 |= gapComposer.changed(modifier2) ? 256 : 128;
            }
            i6 = i5 & 8;
            if (i6 != 0) {
                i8 = i35 | 3072;
                z4 = z;
            } else {
                z4 = z;
                if (gapComposer.changed(z4)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i8 = i35 | i7;
            }
            i9 = i5 & 16;
            if (i9 != 0) {
                if ((i3 & 24576) == 0) {
                    z5 = z2;
                    if (gapComposer.changed(z5)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i8 |= i10;
                }
                i11 = i8 | 65536;
                i12 = i5 & 64;
                if (i12 != 0) {
                    if ((i3 & 1572864) == 0) {
                        if (gapComposer.changedInstance(function2)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i11 |= i13;
                    }
                    i14 = i5 & 128;
                    if (i14 != 0) {
                        i11 |= 12582912;
                        function7 = function3;
                    } else {
                        function7 = function3;
                        if ((i3 & 12582912) == 0) {
                            if (gapComposer.changedInstance(function7)) {
                                i15 = 8388608;
                            } else {
                                i15 = 4194304;
                            }
                            i11 |= i15;
                        }
                    }
                    i16 = i5 & 256;
                    if (i16 != 0) {
                        i11 |= 100663296;
                        function8 = function4;
                    } else {
                        function8 = function4;
                        if ((i3 & 100663296) == 0) {
                            if (gapComposer.changedInstance(function8)) {
                                i17 = 67108864;
                            } else {
                                i17 = 33554432;
                            }
                            i11 |= i17;
                        }
                    }
                    i18 = i5 & 512;
                    if (i18 != 0) {
                        if ((i3 & 805306368) == 0) {
                            if (gapComposer.changedInstance(function5)) {
                                i19 = 536870912;
                            } else {
                                i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                            }
                            i11 |= i19;
                        }
                        i20 = i4 | 54;
                        i21 = i5 & 4096;
                        if (i21 != 0) {
                            i22 = i4 | 438;
                        } else {
                            if ((i4 & 384) != 0) {
                                if (gapComposer.changedInstance(function6)) {
                                    i23 = 256;
                                } else {
                                    i23 = 128;
                                }
                                i20 |= i23;
                            }
                            i22 = i20;
                        }
                        i24 = i22 | 3072;
                        i25 = i5 & 16384;
                        if (i25 != 0) {
                            i26 = i22 | 27648;
                        } else {
                            i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                        }
                        i27 = i5 & 32768;
                        if (i27 != 0) {
                            i26 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            if (gapComposer.changed(keyboardOptions)) {
                                i28 = 131072;
                            } else {
                                i28 = 65536;
                            }
                            i26 |= i28;
                        }
                        i29 = i5 & 65536;
                        if (i29 != 0) {
                            i30 = i26 | 1572864;
                        } else {
                            i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                        }
                        i31 = i5 & 131072;
                        if (i31 != 0) {
                            i30 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                        }
                        int i37 = i30 | 838860800;
                        if ((i5 & 2097152) == 0 || !gapComposer.changed(shape)) {
                            c = 16;
                        } else {
                            c = ' ';
                        }
                        int i38 = 6 | c;
                        if ((i5 & 4194304) == 0 || !gapComposer.changed(textFieldColors)) {
                            i32 = 128;
                        } else {
                            i32 = 256;
                        }
                        int i39 = i38 | i32;
                        i33 = 1;
                        if ((i11 & 306783379) != 306783378 && (i37 & 306783379) == 306783378 && (i39 & 147) == 146) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (gapComposer.shouldExecute(i11 & 1, z6)) {
                            gapComposer.startDefaults();
                            if ((i3 & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                                if (i36 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if (i9 != 0) {
                                    z5 = false;
                                }
                                textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                                if (i12 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function2;
                                }
                                if (i14 != 0) {
                                    function7 = null;
                                }
                                if (i16 != 0) {
                                    function8 = null;
                                }
                                if (i18 != 0) {
                                    function15 = null;
                                } else {
                                    function15 = function5;
                                }
                                function16 = i21 == 0 ? function6 : null;
                                if (i25 != 0) {
                                    visualTransformation3 = VisualTransformation.Companion.None;
                                } else {
                                    visualTransformation3 = visualTransformation;
                                }
                                if (i27 != 0) {
                                    keyboardOptions3 = KeyboardOptions.Default;
                                } else {
                                    keyboardOptions3 = keyboardOptions;
                                }
                                if (i29 != 0) {
                                    keyboardActions2 = KeyboardActions.Default;
                                } else {
                                    keyboardActions2 = keyboardActions;
                                }
                                if (i31 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z3;
                                }
                                if (z7) {
                                    i34 = 1;
                                } else {
                                    i34 = Integer.MAX_VALUE;
                                }
                                if ((i5 & 2097152) != 0) {
                                    value = ShapesKt.getValue(4, gapComposer);
                                } else {
                                    value = shape;
                                }
                                if ((i5 & 4194304) != 0) {
                                    z10 = false;
                                    textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                    textStyle3 = textStyle3;
                                } else {
                                    z10 = false;
                                    textFieldColorsColors = textFieldColors;
                                }
                                keyboardOptions2 = keyboardOptions3;
                                z11 = z5;
                                function12 = function14;
                                r1 = z10;
                            } else {
                                gapComposer.skipToGroupEnd();
                                textStyle3 = textStyle;
                                function15 = function5;
                                function16 = function6;
                                visualTransformation3 = visualTransformation;
                                keyboardOptions2 = keyboardOptions;
                                z7 = z3;
                                i34 = i;
                                i33 = i2;
                                value = shape;
                                textFieldColorsColors = textFieldColors;
                                function8 = function8;
                                z11 = z5;
                                function7 = function7;
                                modifier2 = modifier2;
                                z4 = z4;
                                r1 = 0;
                                function12 = function2;
                                keyboardActions2 = keyboardActions;
                            }
                            gapComposer.endDefaults();
                            gapComposer.startReplaceGroup(1310000147);
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                            gapComposer.end(r1);
                            gapComposer.startReplaceGroup(1981926178);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU == 16) {
                                jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                            }
                            gapComposer.end(r1);
                            final TextStyle textStyleMerge = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                            Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Composer composer2 = (Composer) obj;
                                    int iIntValue = ((Integer) obj2).intValue();
                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                        Function2 function17 = function12;
                                        Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                        if (function17 != null) {
                                            gapComposer2.startReplaceGroup(-2119688641);
                                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                                            if (objRememberedValue2 == Composer.Companion.Empty) {
                                                objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                                gapComposer2.updateRememberedValue(objRememberedValue2);
                                            }
                                            modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                            gapComposer2.end(false);
                                        } else {
                                            gapComposer2.startReplaceGroup(-2119398202);
                                            gapComposer2.end(false);
                                        }
                                        Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                        Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                        Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                        TextFieldColors textFieldColors3 = textFieldColorsColors;
                                        SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                        String str2 = str;
                                        boolean z12 = z4;
                                        boolean z13 = z7;
                                        VisualTransformation visualTransformation4 = visualTransformation3;
                                        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                        BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z12, z11, textStyleMerge, keyboardOptions2, keyboardActions2, z13, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z12, z13, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                                    } else {
                                        gapComposer2.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer), gapComposer, 56);
                            modifier2 = modifier2;
                            z9 = z4;
                            z8 = z11;
                            visualTransformation2 = visualTransformation3;
                            function10 = function8;
                            function9 = function15;
                            function13 = function16;
                            textStyle2 = textStyle3;
                            textFieldColors2 = textFieldColorsColors;
                            function11 = function7;
                        } else {
                            gapComposer.skipToGroupEnd();
                            textStyle2 = textStyle;
                            function9 = function5;
                            visualTransformation2 = visualTransformation;
                            keyboardOptions2 = keyboardOptions;
                            z7 = z3;
                            i34 = i;
                            i33 = i2;
                            value = shape;
                            textFieldColors2 = textFieldColors;
                            function10 = function8;
                            z8 = z5;
                            function11 = function7;
                            z9 = z4;
                            function12 = function2;
                            function13 = function6;
                            keyboardActions2 = keyboardActions;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final KeyboardOptions keyboardOptions4 = keyboardOptions2;
                            final KeyboardActions keyboardActions3 = keyboardActions2;
                            final boolean z12 = z7;
                            final int i40 = i34;
                            final int i41 = i33;
                            final Shape shape2 = value;
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                                    String str2 = str;
                                    Function1 function17 = function1;
                                    Modifier modifier4 = modifier3;
                                    boolean z13 = z9;
                                    boolean z14 = z8;
                                    TextStyle textStyle4 = textStyle2;
                                    Function2 function18 = function12;
                                    Function2 function19 = function11;
                                    Function2 function20 = function10;
                                    Function2 function21 = function9;
                                    Function2 function22 = function13;
                                    VisualTransformation visualTransformation4 = visualTransformation2;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions4;
                                    KeyboardActions keyboardActions4 = keyboardActions3;
                                    boolean z15 = z12;
                                    int i42 = i40;
                                    boolean z16 = i41;
                                    Shape shape3 = shape2;
                                    TextFieldColors textFieldColors3 = textFieldColors2;
                                    int i43 = i5;
                                    ScrimKt.OutlinedTextField(str2, function17, modifier4, z13, z14, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions5, keyboardActions4, z15, i42, z16 ? 1 : 0, shape3, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i43);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i11 |= 805306368;
                    i20 = i4 | 54;
                    i21 = i5 & 4096;
                    if (i21 != 0) {
                        i22 = i4 | 438;
                    } else {
                        if ((i4 & 384) != 0) {
                            if (gapComposer.changedInstance(function6)) {
                                i23 = 256;
                            } else {
                                i23 = 128;
                            }
                            i20 |= i23;
                        }
                        i22 = i20;
                    }
                    i24 = i22 | 3072;
                    i25 = i5 & 16384;
                    if (i25 != 0) {
                        i26 = i22 | 27648;
                    } else {
                        i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                    }
                    i27 = i5 & 32768;
                    if (i27 != 0) {
                        i26 |= 196608;
                    } else if ((i4 & 196608) == 0) {
                        if (gapComposer.changed(keyboardOptions)) {
                            i28 = 131072;
                        } else {
                            i28 = 65536;
                        }
                        i26 |= i28;
                    }
                    i29 = i5 & 65536;
                    if (i29 != 0) {
                        i30 = i26 | 1572864;
                    } else {
                        i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                    }
                    i31 = i5 & 131072;
                    if (i31 != 0) {
                        i30 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                    }
                    int i310 = i30 | 838860800;
                    if ((i5 & 2097152) == 0) {
                        c = 16;
                    } else {
                        c = 16;
                    }
                    int i311 = 6 | c;
                    if ((i5 & 4194304) == 0) {
                        i32 = 128;
                    } else {
                        i32 = 128;
                    }
                    int i312 = i311 | i32;
                    i33 = 1;
                    if ((i11 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z6)) {
                        gapComposer.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        } else {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        }
                        gapComposer.endDefaults();
                        gapComposer.startReplaceGroup(1310000147);
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                        gapComposer.end(r1);
                        gapComposer.startReplaceGroup(1981926178);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU == 16) {
                            jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                        }
                        gapComposer.end(r1);
                        final TextStyle textStyleMerge2 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                        Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Composer composer2 = (Composer) obj;
                                int iIntValue = ((Integer) obj2).intValue();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    Function2 function17 = function12;
                                    Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                    if (function17 != null) {
                                        gapComposer2.startReplaceGroup(-2119688641);
                                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                                        if (objRememberedValue2 == Composer.Companion.Empty) {
                                            objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                            gapComposer2.updateRememberedValue(objRememberedValue2);
                                        }
                                        modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                        gapComposer2.end(false);
                                    } else {
                                        gapComposer2.startReplaceGroup(-2119398202);
                                        gapComposer2.end(false);
                                    }
                                    Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                    Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                    Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                    TextFieldColors textFieldColors3 = textFieldColorsColors;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                    String str2 = str;
                                    boolean z13 = z4;
                                    boolean z14 = z7;
                                    VisualTransformation visualTransformation4 = visualTransformation3;
                                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                    BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z13, z11, textStyleMerge2, keyboardOptions2, keyboardActions2, z14, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z13, z14, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer), gapComposer, 56);
                        modifier2 = modifier2;
                        z9 = z4;
                        z8 = z11;
                        visualTransformation2 = visualTransformation3;
                        function10 = function8;
                        function9 = function15;
                        function13 = function16;
                        textStyle2 = textStyle3;
                        textFieldColors2 = textFieldColorsColors;
                        function11 = function7;
                    } else {
                        gapComposer.skipToGroupEnd();
                        textStyle2 = textStyle;
                        function9 = function5;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        z7 = z3;
                        i34 = i;
                        i33 = i2;
                        value = shape;
                        textFieldColors2 = textFieldColors;
                        function10 = function8;
                        z8 = z5;
                        function11 = function7;
                        z9 = z4;
                        function12 = function2;
                        function13 = function6;
                        keyboardActions2 = keyboardActions;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final Modifier modifier4 = modifier2;
                        final KeyboardOptions keyboardOptions5 = keyboardOptions2;
                        final KeyboardActions keyboardActions4 = keyboardActions2;
                        final boolean z13 = z7;
                        final int i42 = i34;
                        final int i43 = i33;
                        final Shape shape3 = value;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                                String str2 = str;
                                Function1 function17 = function1;
                                Modifier modifier5 = modifier4;
                                boolean z14 = z9;
                                boolean z15 = z8;
                                TextStyle textStyle4 = textStyle2;
                                Function2 function18 = function12;
                                Function2 function19 = function11;
                                Function2 function20 = function10;
                                Function2 function21 = function9;
                                Function2 function22 = function13;
                                VisualTransformation visualTransformation4 = visualTransformation2;
                                KeyboardOptions keyboardOptions6 = keyboardOptions5;
                                KeyboardActions keyboardActions5 = keyboardActions4;
                                boolean z16 = z13;
                                int i44 = i42;
                                boolean z17 = i43;
                                Shape shape4 = shape3;
                                TextFieldColors textFieldColors3 = textFieldColors2;
                                int i45 = i5;
                                ScrimKt.OutlinedTextField(str2, function17, modifier5, z14, z15, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions6, keyboardActions5, z16, i44, z17 ? 1 : 0, shape4, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i45);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i11 = i8 | 1638400;
                i14 = i5 & 128;
                if (i14 != 0) {
                    i11 |= 12582912;
                    function7 = function3;
                } else {
                    function7 = function3;
                    if ((i3 & 12582912) == 0) {
                        if (gapComposer.changedInstance(function7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i11 |= i15;
                    }
                }
                i16 = i5 & 256;
                if (i16 != 0) {
                    i11 |= 100663296;
                    function8 = function4;
                } else {
                    function8 = function4;
                    if ((i3 & 100663296) == 0) {
                        if (gapComposer.changedInstance(function8)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                        i11 |= i17;
                    }
                }
                i18 = i5 & 512;
                if (i18 != 0) {
                    if ((i3 & 805306368) == 0) {
                        if (gapComposer.changedInstance(function5)) {
                            i19 = 536870912;
                        } else {
                            i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i11 |= i19;
                    }
                    i20 = i4 | 54;
                    i21 = i5 & 4096;
                    if (i21 != 0) {
                        i22 = i4 | 438;
                    } else {
                        if ((i4 & 384) != 0) {
                            if (gapComposer.changedInstance(function6)) {
                                i23 = 256;
                            } else {
                                i23 = 128;
                            }
                            i20 |= i23;
                        }
                        i22 = i20;
                    }
                    i24 = i22 | 3072;
                    i25 = i5 & 16384;
                    if (i25 != 0) {
                        i26 = i22 | 27648;
                    } else {
                        i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                    }
                    i27 = i5 & 32768;
                    if (i27 != 0) {
                        i26 |= 196608;
                    } else if ((i4 & 196608) == 0) {
                        if (gapComposer.changed(keyboardOptions)) {
                            i28 = 131072;
                        } else {
                            i28 = 65536;
                        }
                        i26 |= i28;
                    }
                    i29 = i5 & 65536;
                    if (i29 != 0) {
                        i30 = i26 | 1572864;
                    } else {
                        i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                    }
                    i31 = i5 & 131072;
                    if (i31 != 0) {
                        i30 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                    }
                    int i313 = i30 | 838860800;
                    if ((i5 & 2097152) == 0) {
                        c = 16;
                    } else {
                        c = 16;
                    }
                    int i314 = 6 | c;
                    if ((i5 & 4194304) == 0) {
                        i32 = 128;
                    } else {
                        i32 = 128;
                    }
                    int i315 = i314 | i32;
                    i33 = 1;
                    if ((i11 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z6)) {
                        gapComposer.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        } else {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        }
                        gapComposer.endDefaults();
                        gapComposer.startReplaceGroup(1310000147);
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                        gapComposer.end(r1);
                        gapComposer.startReplaceGroup(1981926178);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU == 16) {
                            jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                        }
                        gapComposer.end(r1);
                        final TextStyle textStyleMerge3 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                        Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Composer composer2 = (Composer) obj;
                                int iIntValue = ((Integer) obj2).intValue();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    Function2 function17 = function12;
                                    Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                    if (function17 != null) {
                                        gapComposer2.startReplaceGroup(-2119688641);
                                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                                        if (objRememberedValue2 == Composer.Companion.Empty) {
                                            objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                            gapComposer2.updateRememberedValue(objRememberedValue2);
                                        }
                                        modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                        gapComposer2.end(false);
                                    } else {
                                        gapComposer2.startReplaceGroup(-2119398202);
                                        gapComposer2.end(false);
                                    }
                                    Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                    Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                    Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                    TextFieldColors textFieldColors3 = textFieldColorsColors;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                    String str2 = str;
                                    boolean z14 = z4;
                                    boolean z15 = z7;
                                    VisualTransformation visualTransformation4 = visualTransformation3;
                                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                    BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z14, z11, textStyleMerge3, keyboardOptions2, keyboardActions2, z15, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z14, z15, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer), gapComposer, 56);
                        modifier2 = modifier2;
                        z9 = z4;
                        z8 = z11;
                        visualTransformation2 = visualTransformation3;
                        function10 = function8;
                        function9 = function15;
                        function13 = function16;
                        textStyle2 = textStyle3;
                        textFieldColors2 = textFieldColorsColors;
                        function11 = function7;
                    } else {
                        gapComposer.skipToGroupEnd();
                        textStyle2 = textStyle;
                        function9 = function5;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        z7 = z3;
                        i34 = i;
                        i33 = i2;
                        value = shape;
                        textFieldColors2 = textFieldColors;
                        function10 = function8;
                        z8 = z5;
                        function11 = function7;
                        z9 = z4;
                        function12 = function2;
                        function13 = function6;
                        keyboardActions2 = keyboardActions;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final Modifier modifier5 = modifier2;
                        final KeyboardOptions keyboardOptions6 = keyboardOptions2;
                        final KeyboardActions keyboardActions5 = keyboardActions2;
                        final boolean z14 = z7;
                        final int i44 = i34;
                        final int i45 = i33;
                        final Shape shape4 = value;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                                String str2 = str;
                                Function1 function17 = function1;
                                Modifier modifier6 = modifier5;
                                boolean z15 = z9;
                                boolean z16 = z8;
                                TextStyle textStyle4 = textStyle2;
                                Function2 function18 = function12;
                                Function2 function19 = function11;
                                Function2 function20 = function10;
                                Function2 function21 = function9;
                                Function2 function22 = function13;
                                VisualTransformation visualTransformation4 = visualTransformation2;
                                KeyboardOptions keyboardOptions7 = keyboardOptions6;
                                KeyboardActions keyboardActions6 = keyboardActions5;
                                boolean z17 = z14;
                                int i46 = i44;
                                boolean z18 = i45;
                                Shape shape5 = shape4;
                                TextFieldColors textFieldColors3 = textFieldColors2;
                                int i47 = i5;
                                ScrimKt.OutlinedTextField(str2, function17, modifier6, z15, z16, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions7, keyboardActions6, z17, i46, z18 ? 1 : 0, shape5, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i47);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i11 |= 805306368;
                i20 = i4 | 54;
                i21 = i5 & 4096;
                if (i21 != 0) {
                    i22 = i4 | 438;
                } else {
                    if ((i4 & 384) != 0) {
                        if (gapComposer.changedInstance(function6)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i20 |= i23;
                    }
                    i22 = i20;
                }
                i24 = i22 | 3072;
                i25 = i5 & 16384;
                if (i25 != 0) {
                    i26 = i22 | 27648;
                } else {
                    i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                }
                i27 = i5 & 32768;
                if (i27 != 0) {
                    i26 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(keyboardOptions)) {
                        i28 = 131072;
                    } else {
                        i28 = 65536;
                    }
                    i26 |= i28;
                }
                i29 = i5 & 65536;
                if (i29 != 0) {
                    i30 = i26 | 1572864;
                } else {
                    i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                }
                i31 = i5 & 131072;
                if (i31 != 0) {
                    i30 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                }
                int i316 = i30 | 838860800;
                if ((i5 & 2097152) == 0) {
                    c = 16;
                } else {
                    c = 16;
                }
                int i317 = 6 | c;
                if ((i5 & 4194304) == 0) {
                    i32 = 128;
                } else {
                    i32 = 128;
                }
                int i318 = i317 | i32;
                i33 = 1;
                if ((i11 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z6)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    } else {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1310000147);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(r1);
                    gapComposer.startReplaceGroup(1981926178);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                    }
                    gapComposer.end(r1);
                    final TextStyle textStyleMerge4 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Function2 function17 = function12;
                                Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                if (function17 != null) {
                                    gapComposer2.startReplaceGroup(-2119688641);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (objRememberedValue2 == Composer.Companion.Empty) {
                                        objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.startReplaceGroup(-2119398202);
                                    gapComposer2.end(false);
                                }
                                Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                TextFieldColors textFieldColors3 = textFieldColorsColors;
                                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                String str2 = str;
                                boolean z15 = z4;
                                boolean z16 = z7;
                                VisualTransformation visualTransformation4 = visualTransformation3;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z15, z11, textStyleMerge4, keyboardOptions2, keyboardActions2, z16, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z15, z16, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    modifier2 = modifier2;
                    z9 = z4;
                    z8 = z11;
                    visualTransformation2 = visualTransformation3;
                    function10 = function8;
                    function9 = function15;
                    function13 = function16;
                    textStyle2 = textStyle3;
                    textFieldColors2 = textFieldColorsColors;
                    function11 = function7;
                } else {
                    gapComposer.skipToGroupEnd();
                    textStyle2 = textStyle;
                    function9 = function5;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    z7 = z3;
                    i34 = i;
                    i33 = i2;
                    value = shape;
                    textFieldColors2 = textFieldColors;
                    function10 = function8;
                    z8 = z5;
                    function11 = function7;
                    z9 = z4;
                    function12 = function2;
                    function13 = function6;
                    keyboardActions2 = keyboardActions;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final Modifier modifier6 = modifier2;
                    final KeyboardOptions keyboardOptions7 = keyboardOptions2;
                    final KeyboardActions keyboardActions6 = keyboardActions2;
                    final boolean z15 = z7;
                    final int i46 = i34;
                    final int i47 = i33;
                    final Shape shape5 = value;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            String str2 = str;
                            Function1 function17 = function1;
                            Modifier modifier7 = modifier6;
                            boolean z16 = z9;
                            boolean z17 = z8;
                            TextStyle textStyle4 = textStyle2;
                            Function2 function18 = function12;
                            Function2 function19 = function11;
                            Function2 function20 = function10;
                            Function2 function21 = function9;
                            Function2 function22 = function13;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions8 = keyboardOptions7;
                            KeyboardActions keyboardActions7 = keyboardActions6;
                            boolean z18 = z15;
                            int i48 = i46;
                            boolean z19 = i47;
                            Shape shape6 = shape5;
                            TextFieldColors textFieldColors3 = textFieldColors2;
                            int i49 = i5;
                            ScrimKt.OutlinedTextField(str2, function17, modifier7, z16, z17, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions8, keyboardActions7, z18, i48, z19 ? 1 : 0, shape6, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i49);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i8 |= 24576;
            z5 = z2;
            i11 = i8 | 65536;
            i12 = i5 & 64;
            if (i12 != 0) {
                if ((i3 & 1572864) == 0) {
                    if (gapComposer.changedInstance(function2)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i11 |= i13;
                }
                i14 = i5 & 128;
                if (i14 != 0) {
                    i11 |= 12582912;
                    function7 = function3;
                } else {
                    function7 = function3;
                    if ((i3 & 12582912) == 0) {
                        if (gapComposer.changedInstance(function7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i11 |= i15;
                    }
                }
                i16 = i5 & 256;
                if (i16 != 0) {
                    i11 |= 100663296;
                    function8 = function4;
                } else {
                    function8 = function4;
                    if ((i3 & 100663296) == 0) {
                        if (gapComposer.changedInstance(function8)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                        i11 |= i17;
                    }
                }
                i18 = i5 & 512;
                if (i18 != 0) {
                    if ((i3 & 805306368) == 0) {
                        if (gapComposer.changedInstance(function5)) {
                            i19 = 536870912;
                        } else {
                            i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i11 |= i19;
                    }
                    i20 = i4 | 54;
                    i21 = i5 & 4096;
                    if (i21 != 0) {
                        i22 = i4 | 438;
                    } else {
                        if ((i4 & 384) != 0) {
                            if (gapComposer.changedInstance(function6)) {
                                i23 = 256;
                            } else {
                                i23 = 128;
                            }
                            i20 |= i23;
                        }
                        i22 = i20;
                    }
                    i24 = i22 | 3072;
                    i25 = i5 & 16384;
                    if (i25 != 0) {
                        i26 = i22 | 27648;
                    } else {
                        i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                    }
                    i27 = i5 & 32768;
                    if (i27 != 0) {
                        i26 |= 196608;
                    } else if ((i4 & 196608) == 0) {
                        if (gapComposer.changed(keyboardOptions)) {
                            i28 = 131072;
                        } else {
                            i28 = 65536;
                        }
                        i26 |= i28;
                    }
                    i29 = i5 & 65536;
                    if (i29 != 0) {
                        i30 = i26 | 1572864;
                    } else {
                        i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                    }
                    i31 = i5 & 131072;
                    if (i31 != 0) {
                        i30 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                    }
                    int i319 = i30 | 838860800;
                    if ((i5 & 2097152) == 0) {
                        c = 16;
                    } else {
                        c = 16;
                    }
                    int i3110 = 6 | c;
                    if ((i5 & 4194304) == 0) {
                        i32 = 128;
                    } else {
                        i32 = 128;
                    }
                    int i3111 = i3110 | i32;
                    i33 = 1;
                    if ((i11 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z6)) {
                        gapComposer.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        } else {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        }
                        gapComposer.endDefaults();
                        gapComposer.startReplaceGroup(1310000147);
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                        gapComposer.end(r1);
                        gapComposer.startReplaceGroup(1981926178);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU == 16) {
                            jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                        }
                        gapComposer.end(r1);
                        final TextStyle textStyleMerge5 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                        Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Composer composer2 = (Composer) obj;
                                int iIntValue = ((Integer) obj2).intValue();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    Function2 function17 = function12;
                                    Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                    if (function17 != null) {
                                        gapComposer2.startReplaceGroup(-2119688641);
                                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                                        if (objRememberedValue2 == Composer.Companion.Empty) {
                                            objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                            gapComposer2.updateRememberedValue(objRememberedValue2);
                                        }
                                        modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                        gapComposer2.end(false);
                                    } else {
                                        gapComposer2.startReplaceGroup(-2119398202);
                                        gapComposer2.end(false);
                                    }
                                    Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                    Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                    Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                    TextFieldColors textFieldColors3 = textFieldColorsColors;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                    String str2 = str;
                                    boolean z16 = z4;
                                    boolean z17 = z7;
                                    VisualTransformation visualTransformation4 = visualTransformation3;
                                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                    BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z16, z11, textStyleMerge5, keyboardOptions2, keyboardActions2, z17, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z16, z17, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer), gapComposer, 56);
                        modifier2 = modifier2;
                        z9 = z4;
                        z8 = z11;
                        visualTransformation2 = visualTransformation3;
                        function10 = function8;
                        function9 = function15;
                        function13 = function16;
                        textStyle2 = textStyle3;
                        textFieldColors2 = textFieldColorsColors;
                        function11 = function7;
                    } else {
                        gapComposer.skipToGroupEnd();
                        textStyle2 = textStyle;
                        function9 = function5;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        z7 = z3;
                        i34 = i;
                        i33 = i2;
                        value = shape;
                        textFieldColors2 = textFieldColors;
                        function10 = function8;
                        z8 = z5;
                        function11 = function7;
                        z9 = z4;
                        function12 = function2;
                        function13 = function6;
                        keyboardActions2 = keyboardActions;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final Modifier modifier7 = modifier2;
                        final KeyboardOptions keyboardOptions8 = keyboardOptions2;
                        final KeyboardActions keyboardActions7 = keyboardActions2;
                        final boolean z16 = z7;
                        final int i48 = i34;
                        final int i49 = i33;
                        final Shape shape6 = value;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                                String str2 = str;
                                Function1 function17 = function1;
                                Modifier modifier8 = modifier7;
                                boolean z17 = z9;
                                boolean z18 = z8;
                                TextStyle textStyle4 = textStyle2;
                                Function2 function18 = function12;
                                Function2 function19 = function11;
                                Function2 function20 = function10;
                                Function2 function21 = function9;
                                Function2 function22 = function13;
                                VisualTransformation visualTransformation4 = visualTransformation2;
                                KeyboardOptions keyboardOptions9 = keyboardOptions8;
                                KeyboardActions keyboardActions8 = keyboardActions7;
                                boolean z19 = z16;
                                int i410 = i48;
                                boolean z110 = i49;
                                Shape shape7 = shape6;
                                TextFieldColors textFieldColors3 = textFieldColors2;
                                int i411 = i5;
                                ScrimKt.OutlinedTextField(str2, function17, modifier8, z17, z18, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions9, keyboardActions8, z19, i410, z110 ? 1 : 0, shape7, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i11 |= 805306368;
                i20 = i4 | 54;
                i21 = i5 & 4096;
                if (i21 != 0) {
                    i22 = i4 | 438;
                } else {
                    if ((i4 & 384) != 0) {
                        if (gapComposer.changedInstance(function6)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i20 |= i23;
                    }
                    i22 = i20;
                }
                i24 = i22 | 3072;
                i25 = i5 & 16384;
                if (i25 != 0) {
                    i26 = i22 | 27648;
                } else {
                    i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                }
                i27 = i5 & 32768;
                if (i27 != 0) {
                    i26 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(keyboardOptions)) {
                        i28 = 131072;
                    } else {
                        i28 = 65536;
                    }
                    i26 |= i28;
                }
                i29 = i5 & 65536;
                if (i29 != 0) {
                    i30 = i26 | 1572864;
                } else {
                    i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                }
                i31 = i5 & 131072;
                if (i31 != 0) {
                    i30 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                }
                int i3112 = i30 | 838860800;
                if ((i5 & 2097152) == 0) {
                    c = 16;
                } else {
                    c = 16;
                }
                int i3113 = 6 | c;
                if ((i5 & 4194304) == 0) {
                    i32 = 128;
                } else {
                    i32 = 128;
                }
                int i3114 = i3113 | i32;
                i33 = 1;
                if ((i11 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z6)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    } else {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1310000147);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(r1);
                    gapComposer.startReplaceGroup(1981926178);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                    }
                    gapComposer.end(r1);
                    final TextStyle textStyleMerge6 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Function2 function17 = function12;
                                Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                if (function17 != null) {
                                    gapComposer2.startReplaceGroup(-2119688641);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (objRememberedValue2 == Composer.Companion.Empty) {
                                        objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.startReplaceGroup(-2119398202);
                                    gapComposer2.end(false);
                                }
                                Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                TextFieldColors textFieldColors3 = textFieldColorsColors;
                                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                String str2 = str;
                                boolean z17 = z4;
                                boolean z18 = z7;
                                VisualTransformation visualTransformation4 = visualTransformation3;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z17, z11, textStyleMerge6, keyboardOptions2, keyboardActions2, z18, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z17, z18, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    modifier2 = modifier2;
                    z9 = z4;
                    z8 = z11;
                    visualTransformation2 = visualTransformation3;
                    function10 = function8;
                    function9 = function15;
                    function13 = function16;
                    textStyle2 = textStyle3;
                    textFieldColors2 = textFieldColorsColors;
                    function11 = function7;
                } else {
                    gapComposer.skipToGroupEnd();
                    textStyle2 = textStyle;
                    function9 = function5;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    z7 = z3;
                    i34 = i;
                    i33 = i2;
                    value = shape;
                    textFieldColors2 = textFieldColors;
                    function10 = function8;
                    z8 = z5;
                    function11 = function7;
                    z9 = z4;
                    function12 = function2;
                    function13 = function6;
                    keyboardActions2 = keyboardActions;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final Modifier modifier8 = modifier2;
                    final KeyboardOptions keyboardOptions9 = keyboardOptions2;
                    final KeyboardActions keyboardActions8 = keyboardActions2;
                    final boolean z17 = z7;
                    final int i410 = i34;
                    final int i411 = i33;
                    final Shape shape7 = value;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            String str2 = str;
                            Function1 function17 = function1;
                            Modifier modifier9 = modifier8;
                            boolean z18 = z9;
                            boolean z19 = z8;
                            TextStyle textStyle4 = textStyle2;
                            Function2 function18 = function12;
                            Function2 function19 = function11;
                            Function2 function20 = function10;
                            Function2 function21 = function9;
                            Function2 function22 = function13;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions10 = keyboardOptions9;
                            KeyboardActions keyboardActions9 = keyboardActions8;
                            boolean z110 = z17;
                            int i412 = i410;
                            boolean z111 = i411;
                            Shape shape8 = shape7;
                            TextFieldColors textFieldColors3 = textFieldColors2;
                            int i413 = i5;
                            ScrimKt.OutlinedTextField(str2, function17, modifier9, z18, z19, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions10, keyboardActions9, z110, i412, z111 ? 1 : 0, shape8, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i413);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i11 = i8 | 1638400;
            i14 = i5 & 128;
            if (i14 != 0) {
                i11 |= 12582912;
                function7 = function3;
            } else {
                function7 = function3;
                if ((i3 & 12582912) == 0) {
                    if (gapComposer.changedInstance(function7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i11 |= i15;
                }
            }
            i16 = i5 & 256;
            if (i16 != 0) {
                i11 |= 100663296;
                function8 = function4;
            } else {
                function8 = function4;
                if ((i3 & 100663296) == 0) {
                    if (gapComposer.changedInstance(function8)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i11 |= i17;
                }
            }
            i18 = i5 & 512;
            if (i18 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (gapComposer.changedInstance(function5)) {
                        i19 = 536870912;
                    } else {
                        i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i11 |= i19;
                }
                i20 = i4 | 54;
                i21 = i5 & 4096;
                if (i21 != 0) {
                    i22 = i4 | 438;
                } else {
                    if ((i4 & 384) != 0) {
                        if (gapComposer.changedInstance(function6)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i20 |= i23;
                    }
                    i22 = i20;
                }
                i24 = i22 | 3072;
                i25 = i5 & 16384;
                if (i25 != 0) {
                    i26 = i22 | 27648;
                } else {
                    i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                }
                i27 = i5 & 32768;
                if (i27 != 0) {
                    i26 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(keyboardOptions)) {
                        i28 = 131072;
                    } else {
                        i28 = 65536;
                    }
                    i26 |= i28;
                }
                i29 = i5 & 65536;
                if (i29 != 0) {
                    i30 = i26 | 1572864;
                } else {
                    i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                }
                i31 = i5 & 131072;
                if (i31 != 0) {
                    i30 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                }
                int i3115 = i30 | 838860800;
                if ((i5 & 2097152) == 0) {
                    c = 16;
                } else {
                    c = 16;
                }
                int i3116 = 6 | c;
                if ((i5 & 4194304) == 0) {
                    i32 = 128;
                } else {
                    i32 = 128;
                }
                int i3117 = i3116 | i32;
                i33 = 1;
                if ((i11 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z6)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    } else {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1310000147);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(r1);
                    gapComposer.startReplaceGroup(1981926178);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                    }
                    gapComposer.end(r1);
                    final TextStyle textStyleMerge7 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Function2 function17 = function12;
                                Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                if (function17 != null) {
                                    gapComposer2.startReplaceGroup(-2119688641);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (objRememberedValue2 == Composer.Companion.Empty) {
                                        objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.startReplaceGroup(-2119398202);
                                    gapComposer2.end(false);
                                }
                                Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                TextFieldColors textFieldColors3 = textFieldColorsColors;
                                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                String str2 = str;
                                boolean z18 = z4;
                                boolean z19 = z7;
                                VisualTransformation visualTransformation4 = visualTransformation3;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z18, z11, textStyleMerge7, keyboardOptions2, keyboardActions2, z19, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z18, z19, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    modifier2 = modifier2;
                    z9 = z4;
                    z8 = z11;
                    visualTransformation2 = visualTransformation3;
                    function10 = function8;
                    function9 = function15;
                    function13 = function16;
                    textStyle2 = textStyle3;
                    textFieldColors2 = textFieldColorsColors;
                    function11 = function7;
                } else {
                    gapComposer.skipToGroupEnd();
                    textStyle2 = textStyle;
                    function9 = function5;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    z7 = z3;
                    i34 = i;
                    i33 = i2;
                    value = shape;
                    textFieldColors2 = textFieldColors;
                    function10 = function8;
                    z8 = z5;
                    function11 = function7;
                    z9 = z4;
                    function12 = function2;
                    function13 = function6;
                    keyboardActions2 = keyboardActions;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final Modifier modifier9 = modifier2;
                    final KeyboardOptions keyboardOptions10 = keyboardOptions2;
                    final KeyboardActions keyboardActions9 = keyboardActions2;
                    final boolean z18 = z7;
                    final int i412 = i34;
                    final int i413 = i33;
                    final Shape shape8 = value;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            String str2 = str;
                            Function1 function17 = function1;
                            Modifier modifier10 = modifier9;
                            boolean z19 = z9;
                            boolean z110 = z8;
                            TextStyle textStyle4 = textStyle2;
                            Function2 function18 = function12;
                            Function2 function19 = function11;
                            Function2 function20 = function10;
                            Function2 function21 = function9;
                            Function2 function22 = function13;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions11 = keyboardOptions10;
                            KeyboardActions keyboardActions10 = keyboardActions9;
                            boolean z111 = z18;
                            int i414 = i412;
                            boolean z112 = i413;
                            Shape shape9 = shape8;
                            TextFieldColors textFieldColors3 = textFieldColors2;
                            int i415 = i5;
                            ScrimKt.OutlinedTextField(str2, function17, modifier10, z19, z110, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions11, keyboardActions10, z111, i414, z112 ? 1 : 0, shape9, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i415);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i11 |= 805306368;
            i20 = i4 | 54;
            i21 = i5 & 4096;
            if (i21 != 0) {
                i22 = i4 | 438;
            } else {
                if ((i4 & 384) != 0) {
                    if (gapComposer.changedInstance(function6)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i20 |= i23;
                }
                i22 = i20;
            }
            i24 = i22 | 3072;
            i25 = i5 & 16384;
            if (i25 != 0) {
                i26 = i22 | 27648;
            } else {
                i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
            }
            i27 = i5 & 32768;
            if (i27 != 0) {
                i26 |= 196608;
            } else if ((i4 & 196608) == 0) {
                if (gapComposer.changed(keyboardOptions)) {
                    i28 = 131072;
                } else {
                    i28 = 65536;
                }
                i26 |= i28;
            }
            i29 = i5 & 65536;
            if (i29 != 0) {
                i30 = i26 | 1572864;
            } else {
                i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
            }
            i31 = i5 & 131072;
            if (i31 != 0) {
                i30 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
            }
            int i3118 = i30 | 838860800;
            if ((i5 & 2097152) == 0) {
                c = 16;
            } else {
                c = 16;
            }
            int i3119 = 6 | c;
            if ((i5 & 4194304) == 0) {
                i32 = 128;
            } else {
                i32 = 128;
            }
            int i31110 = i3119 | i32;
            i33 = 1;
            if ((i11 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (gapComposer.shouldExecute(i11 & 1, z6)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                } else {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1310000147);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(r1);
                gapComposer.startReplaceGroup(1981926178);
                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                }
                gapComposer.end(r1);
                final TextStyle textStyleMerge8 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Function2 function17 = function12;
                            Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                            if (function17 != null) {
                                gapComposer2.startReplaceGroup(-2119688641);
                                Object objRememberedValue2 = gapComposer2.rememberedValue();
                                if (objRememberedValue2 == Composer.Companion.Empty) {
                                    objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                    gapComposer2.updateRememberedValue(objRememberedValue2);
                                }
                                modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-2119398202);
                                gapComposer2.end(false);
                            }
                            Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                            TextFieldColors textFieldColors3 = textFieldColorsColors;
                            SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                            String str2 = str;
                            boolean z19 = z4;
                            boolean z110 = z7;
                            VisualTransformation visualTransformation4 = visualTransformation3;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z19, z11, textStyleMerge8, keyboardOptions2, keyboardActions2, z110, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z19, z110, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                modifier2 = modifier2;
                z9 = z4;
                z8 = z11;
                visualTransformation2 = visualTransformation3;
                function10 = function8;
                function9 = function15;
                function13 = function16;
                textStyle2 = textStyle3;
                textFieldColors2 = textFieldColorsColors;
                function11 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                textStyle2 = textStyle;
                function9 = function5;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                z7 = z3;
                i34 = i;
                i33 = i2;
                value = shape;
                textFieldColors2 = textFieldColors;
                function10 = function8;
                z8 = z5;
                function11 = function7;
                z9 = z4;
                function12 = function2;
                function13 = function6;
                keyboardActions2 = keyboardActions;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final Modifier modifier10 = modifier2;
                final KeyboardOptions keyboardOptions11 = keyboardOptions2;
                final KeyboardActions keyboardActions10 = keyboardActions2;
                final boolean z19 = z7;
                final int i414 = i34;
                final int i415 = i33;
                final Shape shape9 = value;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        String str2 = str;
                        Function1 function17 = function1;
                        Modifier modifier11 = modifier10;
                        boolean z110 = z9;
                        boolean z111 = z8;
                        TextStyle textStyle4 = textStyle2;
                        Function2 function18 = function12;
                        Function2 function19 = function11;
                        Function2 function20 = function10;
                        Function2 function21 = function9;
                        Function2 function22 = function13;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions12 = keyboardOptions11;
                        KeyboardActions keyboardActions11 = keyboardActions10;
                        boolean z112 = z19;
                        int i416 = i414;
                        boolean z113 = i415;
                        Shape shape10 = shape9;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i417 = i5;
                        ScrimKt.OutlinedTextField(str2, function17, modifier11, z110, z111, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions12, keyboardActions11, z112, i416, z113 ? 1 : 0, shape10, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i417);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i35 |= 384;
        modifier2 = modifier;
        i6 = i5 & 8;
        if (i6 != 0) {
            i8 = i35 | 3072;
            z4 = z;
        } else {
            z4 = z;
            if (gapComposer.changed(z4)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i8 = i35 | i7;
        }
        i9 = i5 & 16;
        if (i9 != 0) {
            if ((i3 & 24576) == 0) {
                z5 = z2;
                if (gapComposer.changed(z5)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i8 |= i10;
            }
            i11 = i8 | 65536;
            i12 = i5 & 64;
            if (i12 != 0) {
                if ((i3 & 1572864) == 0) {
                    if (gapComposer.changedInstance(function2)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i11 |= i13;
                }
                i14 = i5 & 128;
                if (i14 != 0) {
                    i11 |= 12582912;
                    function7 = function3;
                } else {
                    function7 = function3;
                    if ((i3 & 12582912) == 0) {
                        if (gapComposer.changedInstance(function7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i11 |= i15;
                    }
                }
                i16 = i5 & 256;
                if (i16 != 0) {
                    i11 |= 100663296;
                    function8 = function4;
                } else {
                    function8 = function4;
                    if ((i3 & 100663296) == 0) {
                        if (gapComposer.changedInstance(function8)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                        i11 |= i17;
                    }
                }
                i18 = i5 & 512;
                if (i18 != 0) {
                    if ((i3 & 805306368) == 0) {
                        if (gapComposer.changedInstance(function5)) {
                            i19 = 536870912;
                        } else {
                            i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i11 |= i19;
                    }
                    i20 = i4 | 54;
                    i21 = i5 & 4096;
                    if (i21 != 0) {
                        i22 = i4 | 438;
                    } else {
                        if ((i4 & 384) != 0) {
                            if (gapComposer.changedInstance(function6)) {
                                i23 = 256;
                            } else {
                                i23 = 128;
                            }
                            i20 |= i23;
                        }
                        i22 = i20;
                    }
                    i24 = i22 | 3072;
                    i25 = i5 & 16384;
                    if (i25 != 0) {
                        i26 = i22 | 27648;
                    } else {
                        i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                    }
                    i27 = i5 & 32768;
                    if (i27 != 0) {
                        i26 |= 196608;
                    } else if ((i4 & 196608) == 0) {
                        if (gapComposer.changed(keyboardOptions)) {
                            i28 = 131072;
                        } else {
                            i28 = 65536;
                        }
                        i26 |= i28;
                    }
                    i29 = i5 & 65536;
                    if (i29 != 0) {
                        i30 = i26 | 1572864;
                    } else {
                        i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                    }
                    i31 = i5 & 131072;
                    if (i31 != 0) {
                        i30 |= 12582912;
                    } else if ((i4 & 12582912) == 0) {
                        i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                    }
                    int i31111 = i30 | 838860800;
                    if ((i5 & 2097152) == 0) {
                        c = 16;
                    } else {
                        c = 16;
                    }
                    int i31112 = 6 | c;
                    if ((i5 & 4194304) == 0) {
                        i32 = 128;
                    } else {
                        i32 = 128;
                    }
                    int i31113 = i31112 | i32;
                    i33 = 1;
                    if ((i11 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z6)) {
                        gapComposer.startDefaults();
                        if ((i3 & 1) != 0) {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        } else {
                            if (i36 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if (i9 != 0) {
                                z5 = false;
                            }
                            textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                            if (i12 != 0) {
                                function14 = null;
                            } else {
                                function14 = function2;
                            }
                            if (i14 != 0) {
                                function7 = null;
                            }
                            if (i16 != 0) {
                                function8 = null;
                            }
                            if (i18 != 0) {
                                function15 = null;
                            } else {
                                function15 = function5;
                            }
                            if (i21 == 0) {
                            }
                            if (i25 != 0) {
                                visualTransformation3 = VisualTransformation.Companion.None;
                            } else {
                                visualTransformation3 = visualTransformation;
                            }
                            if (i27 != 0) {
                                keyboardOptions3 = KeyboardOptions.Default;
                            } else {
                                keyboardOptions3 = keyboardOptions;
                            }
                            if (i29 != 0) {
                                keyboardActions2 = KeyboardActions.Default;
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i31 != 0) {
                                z7 = false;
                            } else {
                                z7 = z3;
                            }
                            if (z7) {
                                i34 = 1;
                            } else {
                                i34 = Integer.MAX_VALUE;
                            }
                            if ((i5 & 2097152) != 0) {
                                value = ShapesKt.getValue(4, gapComposer);
                            } else {
                                value = shape;
                            }
                            if ((i5 & 4194304) != 0) {
                                z10 = false;
                                textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                                textStyle3 = textStyle3;
                            } else {
                                z10 = false;
                                textFieldColorsColors = textFieldColors;
                            }
                            keyboardOptions2 = keyboardOptions3;
                            z11 = z5;
                            function12 = function14;
                            r1 = z10;
                        }
                        gapComposer.endDefaults();
                        gapComposer.startReplaceGroup(1310000147);
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                        gapComposer.end(r1);
                        gapComposer.startReplaceGroup(1981926178);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU == 16) {
                            jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                        }
                        gapComposer.end(r1);
                        final TextStyle textStyleMerge9 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                        Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Composer composer2 = (Composer) obj;
                                int iIntValue = ((Integer) obj2).intValue();
                                GapComposer gapComposer2 = (GapComposer) composer2;
                                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                    Function2 function17 = function12;
                                    Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                    if (function17 != null) {
                                        gapComposer2.startReplaceGroup(-2119688641);
                                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                                        if (objRememberedValue2 == Composer.Companion.Empty) {
                                            objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                            gapComposer2.updateRememberedValue(objRememberedValue2);
                                        }
                                        modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                        gapComposer2.end(false);
                                    } else {
                                        gapComposer2.startReplaceGroup(-2119398202);
                                        gapComposer2.end(false);
                                    }
                                    Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                    Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                    Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                    TextFieldColors textFieldColors3 = textFieldColorsColors;
                                    SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                    String str2 = str;
                                    boolean z110 = z4;
                                    boolean z111 = z7;
                                    VisualTransformation visualTransformation4 = visualTransformation3;
                                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                    BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z110, z11, textStyleMerge9, keyboardOptions2, keyboardActions2, z111, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z110, z111, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer), gapComposer, 56);
                        modifier2 = modifier2;
                        z9 = z4;
                        z8 = z11;
                        visualTransformation2 = visualTransformation3;
                        function10 = function8;
                        function9 = function15;
                        function13 = function16;
                        textStyle2 = textStyle3;
                        textFieldColors2 = textFieldColorsColors;
                        function11 = function7;
                    } else {
                        gapComposer.skipToGroupEnd();
                        textStyle2 = textStyle;
                        function9 = function5;
                        visualTransformation2 = visualTransformation;
                        keyboardOptions2 = keyboardOptions;
                        z7 = z3;
                        i34 = i;
                        i33 = i2;
                        value = shape;
                        textFieldColors2 = textFieldColors;
                        function10 = function8;
                        z8 = z5;
                        function11 = function7;
                        z9 = z4;
                        function12 = function2;
                        function13 = function6;
                        keyboardActions2 = keyboardActions;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final Modifier modifier11 = modifier2;
                        final KeyboardOptions keyboardOptions12 = keyboardOptions2;
                        final KeyboardActions keyboardActions11 = keyboardActions2;
                        final boolean z110 = z7;
                        final int i416 = i34;
                        final int i417 = i33;
                        final Shape shape10 = value;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                                String str2 = str;
                                Function1 function17 = function1;
                                Modifier modifier12 = modifier11;
                                boolean z111 = z9;
                                boolean z112 = z8;
                                TextStyle textStyle4 = textStyle2;
                                Function2 function18 = function12;
                                Function2 function19 = function11;
                                Function2 function20 = function10;
                                Function2 function21 = function9;
                                Function2 function22 = function13;
                                VisualTransformation visualTransformation4 = visualTransformation2;
                                KeyboardOptions keyboardOptions13 = keyboardOptions12;
                                KeyboardActions keyboardActions12 = keyboardActions11;
                                boolean z113 = z110;
                                int i418 = i416;
                                boolean z114 = i417;
                                Shape shape11 = shape10;
                                TextFieldColors textFieldColors3 = textFieldColors2;
                                int i419 = i5;
                                ScrimKt.OutlinedTextField(str2, function17, modifier12, z111, z112, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions13, keyboardActions12, z113, i418, z114 ? 1 : 0, shape11, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i419);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i11 |= 805306368;
                i20 = i4 | 54;
                i21 = i5 & 4096;
                if (i21 != 0) {
                    i22 = i4 | 438;
                } else {
                    if ((i4 & 384) != 0) {
                        if (gapComposer.changedInstance(function6)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i20 |= i23;
                    }
                    i22 = i20;
                }
                i24 = i22 | 3072;
                i25 = i5 & 16384;
                if (i25 != 0) {
                    i26 = i22 | 27648;
                } else {
                    i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                }
                i27 = i5 & 32768;
                if (i27 != 0) {
                    i26 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(keyboardOptions)) {
                        i28 = 131072;
                    } else {
                        i28 = 65536;
                    }
                    i26 |= i28;
                }
                i29 = i5 & 65536;
                if (i29 != 0) {
                    i30 = i26 | 1572864;
                } else {
                    i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                }
                i31 = i5 & 131072;
                if (i31 != 0) {
                    i30 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                }
                int i31114 = i30 | 838860800;
                if ((i5 & 2097152) == 0) {
                    c = 16;
                } else {
                    c = 16;
                }
                int i31115 = 6 | c;
                if ((i5 & 4194304) == 0) {
                    i32 = 128;
                } else {
                    i32 = 128;
                }
                int i31116 = i31115 | i32;
                i33 = 1;
                if ((i11 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z6)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    } else {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1310000147);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(r1);
                    gapComposer.startReplaceGroup(1981926178);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                    }
                    gapComposer.end(r1);
                    final TextStyle textStyleMerge10 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Function2 function17 = function12;
                                Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                if (function17 != null) {
                                    gapComposer2.startReplaceGroup(-2119688641);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (objRememberedValue2 == Composer.Companion.Empty) {
                                        objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.startReplaceGroup(-2119398202);
                                    gapComposer2.end(false);
                                }
                                Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                TextFieldColors textFieldColors3 = textFieldColorsColors;
                                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                String str2 = str;
                                boolean z111 = z4;
                                boolean z112 = z7;
                                VisualTransformation visualTransformation4 = visualTransformation3;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z111, z11, textStyleMerge10, keyboardOptions2, keyboardActions2, z112, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z111, z112, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    modifier2 = modifier2;
                    z9 = z4;
                    z8 = z11;
                    visualTransformation2 = visualTransformation3;
                    function10 = function8;
                    function9 = function15;
                    function13 = function16;
                    textStyle2 = textStyle3;
                    textFieldColors2 = textFieldColorsColors;
                    function11 = function7;
                } else {
                    gapComposer.skipToGroupEnd();
                    textStyle2 = textStyle;
                    function9 = function5;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    z7 = z3;
                    i34 = i;
                    i33 = i2;
                    value = shape;
                    textFieldColors2 = textFieldColors;
                    function10 = function8;
                    z8 = z5;
                    function11 = function7;
                    z9 = z4;
                    function12 = function2;
                    function13 = function6;
                    keyboardActions2 = keyboardActions;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final Modifier modifier12 = modifier2;
                    final KeyboardOptions keyboardOptions13 = keyboardOptions2;
                    final KeyboardActions keyboardActions12 = keyboardActions2;
                    final boolean z111 = z7;
                    final int i418 = i34;
                    final int i419 = i33;
                    final Shape shape11 = value;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            String str2 = str;
                            Function1 function17 = function1;
                            Modifier modifier13 = modifier12;
                            boolean z112 = z9;
                            boolean z113 = z8;
                            TextStyle textStyle4 = textStyle2;
                            Function2 function18 = function12;
                            Function2 function19 = function11;
                            Function2 function20 = function10;
                            Function2 function21 = function9;
                            Function2 function22 = function13;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions14 = keyboardOptions13;
                            KeyboardActions keyboardActions13 = keyboardActions12;
                            boolean z114 = z111;
                            int i4110 = i418;
                            boolean z115 = i419;
                            Shape shape12 = shape11;
                            TextFieldColors textFieldColors3 = textFieldColors2;
                            int i4111 = i5;
                            ScrimKt.OutlinedTextField(str2, function17, modifier13, z112, z113, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions14, keyboardActions13, z114, i4110, z115 ? 1 : 0, shape12, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i11 = i8 | 1638400;
            i14 = i5 & 128;
            if (i14 != 0) {
                i11 |= 12582912;
                function7 = function3;
            } else {
                function7 = function3;
                if ((i3 & 12582912) == 0) {
                    if (gapComposer.changedInstance(function7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i11 |= i15;
                }
            }
            i16 = i5 & 256;
            if (i16 != 0) {
                i11 |= 100663296;
                function8 = function4;
            } else {
                function8 = function4;
                if ((i3 & 100663296) == 0) {
                    if (gapComposer.changedInstance(function8)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i11 |= i17;
                }
            }
            i18 = i5 & 512;
            if (i18 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (gapComposer.changedInstance(function5)) {
                        i19 = 536870912;
                    } else {
                        i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i11 |= i19;
                }
                i20 = i4 | 54;
                i21 = i5 & 4096;
                if (i21 != 0) {
                    i22 = i4 | 438;
                } else {
                    if ((i4 & 384) != 0) {
                        if (gapComposer.changedInstance(function6)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i20 |= i23;
                    }
                    i22 = i20;
                }
                i24 = i22 | 3072;
                i25 = i5 & 16384;
                if (i25 != 0) {
                    i26 = i22 | 27648;
                } else {
                    i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                }
                i27 = i5 & 32768;
                if (i27 != 0) {
                    i26 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(keyboardOptions)) {
                        i28 = 131072;
                    } else {
                        i28 = 65536;
                    }
                    i26 |= i28;
                }
                i29 = i5 & 65536;
                if (i29 != 0) {
                    i30 = i26 | 1572864;
                } else {
                    i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                }
                i31 = i5 & 131072;
                if (i31 != 0) {
                    i30 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                }
                int i31117 = i30 | 838860800;
                if ((i5 & 2097152) == 0) {
                    c = 16;
                } else {
                    c = 16;
                }
                int i31118 = 6 | c;
                if ((i5 & 4194304) == 0) {
                    i32 = 128;
                } else {
                    i32 = 128;
                }
                int i31119 = i31118 | i32;
                i33 = 1;
                if ((i11 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z6)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    } else {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1310000147);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(r1);
                    gapComposer.startReplaceGroup(1981926178);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                    }
                    gapComposer.end(r1);
                    final TextStyle textStyleMerge11 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Function2 function17 = function12;
                                Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                if (function17 != null) {
                                    gapComposer2.startReplaceGroup(-2119688641);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (objRememberedValue2 == Composer.Companion.Empty) {
                                        objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.startReplaceGroup(-2119398202);
                                    gapComposer2.end(false);
                                }
                                Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                TextFieldColors textFieldColors3 = textFieldColorsColors;
                                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                String str2 = str;
                                boolean z112 = z4;
                                boolean z113 = z7;
                                VisualTransformation visualTransformation4 = visualTransformation3;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z112, z11, textStyleMerge11, keyboardOptions2, keyboardActions2, z113, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z112, z113, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    modifier2 = modifier2;
                    z9 = z4;
                    z8 = z11;
                    visualTransformation2 = visualTransformation3;
                    function10 = function8;
                    function9 = function15;
                    function13 = function16;
                    textStyle2 = textStyle3;
                    textFieldColors2 = textFieldColorsColors;
                    function11 = function7;
                } else {
                    gapComposer.skipToGroupEnd();
                    textStyle2 = textStyle;
                    function9 = function5;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    z7 = z3;
                    i34 = i;
                    i33 = i2;
                    value = shape;
                    textFieldColors2 = textFieldColors;
                    function10 = function8;
                    z8 = z5;
                    function11 = function7;
                    z9 = z4;
                    function12 = function2;
                    function13 = function6;
                    keyboardActions2 = keyboardActions;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final Modifier modifier13 = modifier2;
                    final KeyboardOptions keyboardOptions14 = keyboardOptions2;
                    final KeyboardActions keyboardActions13 = keyboardActions2;
                    final boolean z112 = z7;
                    final int i4110 = i34;
                    final int i4111 = i33;
                    final Shape shape12 = value;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            String str2 = str;
                            Function1 function17 = function1;
                            Modifier modifier14 = modifier13;
                            boolean z113 = z9;
                            boolean z114 = z8;
                            TextStyle textStyle4 = textStyle2;
                            Function2 function18 = function12;
                            Function2 function19 = function11;
                            Function2 function20 = function10;
                            Function2 function21 = function9;
                            Function2 function22 = function13;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions15 = keyboardOptions14;
                            KeyboardActions keyboardActions14 = keyboardActions13;
                            boolean z115 = z112;
                            int i4112 = i4110;
                            boolean z116 = i4111;
                            Shape shape13 = shape12;
                            TextFieldColors textFieldColors3 = textFieldColors2;
                            int i4113 = i5;
                            ScrimKt.OutlinedTextField(str2, function17, modifier14, z113, z114, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions15, keyboardActions14, z115, i4112, z116 ? 1 : 0, shape13, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4113);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i11 |= 805306368;
            i20 = i4 | 54;
            i21 = i5 & 4096;
            if (i21 != 0) {
                i22 = i4 | 438;
            } else {
                if ((i4 & 384) != 0) {
                    if (gapComposer.changedInstance(function6)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i20 |= i23;
                }
                i22 = i20;
            }
            i24 = i22 | 3072;
            i25 = i5 & 16384;
            if (i25 != 0) {
                i26 = i22 | 27648;
            } else {
                i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
            }
            i27 = i5 & 32768;
            if (i27 != 0) {
                i26 |= 196608;
            } else if ((i4 & 196608) == 0) {
                if (gapComposer.changed(keyboardOptions)) {
                    i28 = 131072;
                } else {
                    i28 = 65536;
                }
                i26 |= i28;
            }
            i29 = i5 & 65536;
            if (i29 != 0) {
                i30 = i26 | 1572864;
            } else {
                i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
            }
            i31 = i5 & 131072;
            if (i31 != 0) {
                i30 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
            }
            int i311110 = i30 | 838860800;
            if ((i5 & 2097152) == 0) {
                c = 16;
            } else {
                c = 16;
            }
            int i311111 = 6 | c;
            if ((i5 & 4194304) == 0) {
                i32 = 128;
            } else {
                i32 = 128;
            }
            int i311112 = i311111 | i32;
            i33 = 1;
            if ((i11 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (gapComposer.shouldExecute(i11 & 1, z6)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                } else {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1310000147);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(r1);
                gapComposer.startReplaceGroup(1981926178);
                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                }
                gapComposer.end(r1);
                final TextStyle textStyleMerge12 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Function2 function17 = function12;
                            Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                            if (function17 != null) {
                                gapComposer2.startReplaceGroup(-2119688641);
                                Object objRememberedValue2 = gapComposer2.rememberedValue();
                                if (objRememberedValue2 == Composer.Companion.Empty) {
                                    objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                    gapComposer2.updateRememberedValue(objRememberedValue2);
                                }
                                modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-2119398202);
                                gapComposer2.end(false);
                            }
                            Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                            TextFieldColors textFieldColors3 = textFieldColorsColors;
                            SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                            String str2 = str;
                            boolean z113 = z4;
                            boolean z114 = z7;
                            VisualTransformation visualTransformation4 = visualTransformation3;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z113, z11, textStyleMerge12, keyboardOptions2, keyboardActions2, z114, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z113, z114, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                modifier2 = modifier2;
                z9 = z4;
                z8 = z11;
                visualTransformation2 = visualTransformation3;
                function10 = function8;
                function9 = function15;
                function13 = function16;
                textStyle2 = textStyle3;
                textFieldColors2 = textFieldColorsColors;
                function11 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                textStyle2 = textStyle;
                function9 = function5;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                z7 = z3;
                i34 = i;
                i33 = i2;
                value = shape;
                textFieldColors2 = textFieldColors;
                function10 = function8;
                z8 = z5;
                function11 = function7;
                z9 = z4;
                function12 = function2;
                function13 = function6;
                keyboardActions2 = keyboardActions;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final Modifier modifier14 = modifier2;
                final KeyboardOptions keyboardOptions15 = keyboardOptions2;
                final KeyboardActions keyboardActions14 = keyboardActions2;
                final boolean z113 = z7;
                final int i4112 = i34;
                final int i4113 = i33;
                final Shape shape13 = value;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        String str2 = str;
                        Function1 function17 = function1;
                        Modifier modifier15 = modifier14;
                        boolean z114 = z9;
                        boolean z115 = z8;
                        TextStyle textStyle4 = textStyle2;
                        Function2 function18 = function12;
                        Function2 function19 = function11;
                        Function2 function20 = function10;
                        Function2 function21 = function9;
                        Function2 function22 = function13;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions16 = keyboardOptions15;
                        KeyboardActions keyboardActions15 = keyboardActions14;
                        boolean z116 = z113;
                        int i4114 = i4112;
                        boolean z117 = i4113;
                        Shape shape14 = shape13;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i4115 = i5;
                        ScrimKt.OutlinedTextField(str2, function17, modifier15, z114, z115, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions16, keyboardActions15, z116, i4114, z117 ? 1 : 0, shape14, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4115);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i8 |= 24576;
        z5 = z2;
        i11 = i8 | 65536;
        i12 = i5 & 64;
        if (i12 != 0) {
            if ((i3 & 1572864) == 0) {
                if (gapComposer.changedInstance(function2)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i11 |= i13;
            }
            i14 = i5 & 128;
            if (i14 != 0) {
                i11 |= 12582912;
                function7 = function3;
            } else {
                function7 = function3;
                if ((i3 & 12582912) == 0) {
                    if (gapComposer.changedInstance(function7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i11 |= i15;
                }
            }
            i16 = i5 & 256;
            if (i16 != 0) {
                i11 |= 100663296;
                function8 = function4;
            } else {
                function8 = function4;
                if ((i3 & 100663296) == 0) {
                    if (gapComposer.changedInstance(function8)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i11 |= i17;
                }
            }
            i18 = i5 & 512;
            if (i18 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (gapComposer.changedInstance(function5)) {
                        i19 = 536870912;
                    } else {
                        i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i11 |= i19;
                }
                i20 = i4 | 54;
                i21 = i5 & 4096;
                if (i21 != 0) {
                    i22 = i4 | 438;
                } else {
                    if ((i4 & 384) != 0) {
                        if (gapComposer.changedInstance(function6)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i20 |= i23;
                    }
                    i22 = i20;
                }
                i24 = i22 | 3072;
                i25 = i5 & 16384;
                if (i25 != 0) {
                    i26 = i22 | 27648;
                } else {
                    i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
                }
                i27 = i5 & 32768;
                if (i27 != 0) {
                    i26 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(keyboardOptions)) {
                        i28 = 131072;
                    } else {
                        i28 = 65536;
                    }
                    i26 |= i28;
                }
                i29 = i5 & 65536;
                if (i29 != 0) {
                    i30 = i26 | 1572864;
                } else {
                    i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
                }
                i31 = i5 & 131072;
                if (i31 != 0) {
                    i30 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
                }
                int i311113 = i30 | 838860800;
                if ((i5 & 2097152) == 0) {
                    c = 16;
                } else {
                    c = 16;
                }
                int i311114 = 6 | c;
                if ((i5 & 4194304) == 0) {
                    i32 = 128;
                } else {
                    i32 = 128;
                }
                int i311115 = i311114 | i32;
                i33 = 1;
                if ((i11 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (gapComposer.shouldExecute(i11 & 1, z6)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    } else {
                        if (i36 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i6 != 0) {
                            z4 = true;
                        }
                        if (i9 != 0) {
                            z5 = false;
                        }
                        textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i12 != 0) {
                            function14 = null;
                        } else {
                            function14 = function2;
                        }
                        if (i14 != 0) {
                            function7 = null;
                        }
                        if (i16 != 0) {
                            function8 = null;
                        }
                        if (i18 != 0) {
                            function15 = null;
                        } else {
                            function15 = function5;
                        }
                        if (i21 == 0) {
                        }
                        if (i25 != 0) {
                            visualTransformation3 = VisualTransformation.Companion.None;
                        } else {
                            visualTransformation3 = visualTransformation;
                        }
                        if (i27 != 0) {
                            keyboardOptions3 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions3 = keyboardOptions;
                        }
                        if (i29 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i31 != 0) {
                            z7 = false;
                        } else {
                            z7 = z3;
                        }
                        if (z7) {
                            i34 = 1;
                        } else {
                            i34 = Integer.MAX_VALUE;
                        }
                        if ((i5 & 2097152) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                        } else {
                            value = shape;
                        }
                        if ((i5 & 4194304) != 0) {
                            z10 = false;
                            textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                            textStyle3 = textStyle3;
                        } else {
                            z10 = false;
                            textFieldColorsColors = textFieldColors;
                        }
                        keyboardOptions2 = keyboardOptions3;
                        z11 = z5;
                        function12 = function14;
                        r1 = z10;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1310000147);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(r1);
                    gapComposer.startReplaceGroup(1981926178);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                    }
                    gapComposer.end(r1);
                    final TextStyle textStyleMerge13 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Function2 function17 = function12;
                                Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                                if (function17 != null) {
                                    gapComposer2.startReplaceGroup(-2119688641);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (objRememberedValue2 == Composer.Companion.Empty) {
                                        objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.startReplaceGroup(-2119398202);
                                    gapComposer2.end(false);
                                }
                                Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                                TextFieldColors textFieldColors3 = textFieldColorsColors;
                                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                String str2 = str;
                                boolean z114 = z4;
                                boolean z115 = z7;
                                VisualTransformation visualTransformation4 = visualTransformation3;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z114, z11, textStyleMerge13, keyboardOptions2, keyboardActions2, z115, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z114, z115, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    modifier2 = modifier2;
                    z9 = z4;
                    z8 = z11;
                    visualTransformation2 = visualTransformation3;
                    function10 = function8;
                    function9 = function15;
                    function13 = function16;
                    textStyle2 = textStyle3;
                    textFieldColors2 = textFieldColorsColors;
                    function11 = function7;
                } else {
                    gapComposer.skipToGroupEnd();
                    textStyle2 = textStyle;
                    function9 = function5;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    z7 = z3;
                    i34 = i;
                    i33 = i2;
                    value = shape;
                    textFieldColors2 = textFieldColors;
                    function10 = function8;
                    z8 = z5;
                    function11 = function7;
                    z9 = z4;
                    function12 = function2;
                    function13 = function6;
                    keyboardActions2 = keyboardActions;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final Modifier modifier15 = modifier2;
                    final KeyboardOptions keyboardOptions16 = keyboardOptions2;
                    final KeyboardActions keyboardActions15 = keyboardActions2;
                    final boolean z114 = z7;
                    final int i4114 = i34;
                    final int i4115 = i33;
                    final Shape shape14 = value;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            String str2 = str;
                            Function1 function17 = function1;
                            Modifier modifier16 = modifier15;
                            boolean z115 = z9;
                            boolean z116 = z8;
                            TextStyle textStyle4 = textStyle2;
                            Function2 function18 = function12;
                            Function2 function19 = function11;
                            Function2 function20 = function10;
                            Function2 function21 = function9;
                            Function2 function22 = function13;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions17 = keyboardOptions16;
                            KeyboardActions keyboardActions16 = keyboardActions15;
                            boolean z117 = z114;
                            int i4116 = i4114;
                            boolean z118 = i4115;
                            Shape shape15 = shape14;
                            TextFieldColors textFieldColors3 = textFieldColors2;
                            int i4117 = i5;
                            ScrimKt.OutlinedTextField(str2, function17, modifier16, z115, z116, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions17, keyboardActions16, z117, i4116, z118 ? 1 : 0, shape15, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4117);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i11 |= 805306368;
            i20 = i4 | 54;
            i21 = i5 & 4096;
            if (i21 != 0) {
                i22 = i4 | 438;
            } else {
                if ((i4 & 384) != 0) {
                    if (gapComposer.changedInstance(function6)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i20 |= i23;
                }
                i22 = i20;
            }
            i24 = i22 | 3072;
            i25 = i5 & 16384;
            if (i25 != 0) {
                i26 = i22 | 27648;
            } else {
                i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
            }
            i27 = i5 & 32768;
            if (i27 != 0) {
                i26 |= 196608;
            } else if ((i4 & 196608) == 0) {
                if (gapComposer.changed(keyboardOptions)) {
                    i28 = 131072;
                } else {
                    i28 = 65536;
                }
                i26 |= i28;
            }
            i29 = i5 & 65536;
            if (i29 != 0) {
                i30 = i26 | 1572864;
            } else {
                i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
            }
            i31 = i5 & 131072;
            if (i31 != 0) {
                i30 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
            }
            int i311116 = i30 | 838860800;
            if ((i5 & 2097152) == 0) {
                c = 16;
            } else {
                c = 16;
            }
            int i311117 = 6 | c;
            if ((i5 & 4194304) == 0) {
                i32 = 128;
            } else {
                i32 = 128;
            }
            int i311118 = i311117 | i32;
            i33 = 1;
            if ((i11 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (gapComposer.shouldExecute(i11 & 1, z6)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                } else {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1310000147);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(r1);
                gapComposer.startReplaceGroup(1981926178);
                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                }
                gapComposer.end(r1);
                final TextStyle textStyleMerge14 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Function2 function17 = function12;
                            Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                            if (function17 != null) {
                                gapComposer2.startReplaceGroup(-2119688641);
                                Object objRememberedValue2 = gapComposer2.rememberedValue();
                                if (objRememberedValue2 == Composer.Companion.Empty) {
                                    objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                    gapComposer2.updateRememberedValue(objRememberedValue2);
                                }
                                modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-2119398202);
                                gapComposer2.end(false);
                            }
                            Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                            TextFieldColors textFieldColors3 = textFieldColorsColors;
                            SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                            String str2 = str;
                            boolean z115 = z4;
                            boolean z116 = z7;
                            VisualTransformation visualTransformation4 = visualTransformation3;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z115, z11, textStyleMerge14, keyboardOptions2, keyboardActions2, z116, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z115, z116, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                modifier2 = modifier2;
                z9 = z4;
                z8 = z11;
                visualTransformation2 = visualTransformation3;
                function10 = function8;
                function9 = function15;
                function13 = function16;
                textStyle2 = textStyle3;
                textFieldColors2 = textFieldColorsColors;
                function11 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                textStyle2 = textStyle;
                function9 = function5;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                z7 = z3;
                i34 = i;
                i33 = i2;
                value = shape;
                textFieldColors2 = textFieldColors;
                function10 = function8;
                z8 = z5;
                function11 = function7;
                z9 = z4;
                function12 = function2;
                function13 = function6;
                keyboardActions2 = keyboardActions;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final Modifier modifier16 = modifier2;
                final KeyboardOptions keyboardOptions17 = keyboardOptions2;
                final KeyboardActions keyboardActions16 = keyboardActions2;
                final boolean z115 = z7;
                final int i4116 = i34;
                final int i4117 = i33;
                final Shape shape15 = value;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        String str2 = str;
                        Function1 function17 = function1;
                        Modifier modifier17 = modifier16;
                        boolean z116 = z9;
                        boolean z117 = z8;
                        TextStyle textStyle4 = textStyle2;
                        Function2 function18 = function12;
                        Function2 function19 = function11;
                        Function2 function20 = function10;
                        Function2 function21 = function9;
                        Function2 function22 = function13;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions18 = keyboardOptions17;
                        KeyboardActions keyboardActions17 = keyboardActions16;
                        boolean z118 = z115;
                        int i4118 = i4116;
                        boolean z119 = i4117;
                        Shape shape16 = shape15;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i4119 = i5;
                        ScrimKt.OutlinedTextField(str2, function17, modifier17, z116, z117, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions18, keyboardActions17, z118, i4118, z119 ? 1 : 0, shape16, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4119);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i11 = i8 | 1638400;
        i14 = i5 & 128;
        if (i14 != 0) {
            i11 |= 12582912;
            function7 = function3;
        } else {
            function7 = function3;
            if ((i3 & 12582912) == 0) {
                if (gapComposer.changedInstance(function7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i11 |= i15;
            }
        }
        i16 = i5 & 256;
        if (i16 != 0) {
            i11 |= 100663296;
            function8 = function4;
        } else {
            function8 = function4;
            if ((i3 & 100663296) == 0) {
                if (gapComposer.changedInstance(function8)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i11 |= i17;
            }
        }
        i18 = i5 & 512;
        if (i18 != 0) {
            if ((i3 & 805306368) == 0) {
                if (gapComposer.changedInstance(function5)) {
                    i19 = 536870912;
                } else {
                    i19 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i11 |= i19;
            }
            i20 = i4 | 54;
            i21 = i5 & 4096;
            if (i21 != 0) {
                i22 = i4 | 438;
            } else {
                if ((i4 & 384) != 0) {
                    if (gapComposer.changedInstance(function6)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i20 |= i23;
                }
                i22 = i20;
            }
            i24 = i22 | 3072;
            i25 = i5 & 16384;
            if (i25 != 0) {
                i26 = i22 | 27648;
            } else {
                i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
            }
            i27 = i5 & 32768;
            if (i27 != 0) {
                i26 |= 196608;
            } else if ((i4 & 196608) == 0) {
                if (gapComposer.changed(keyboardOptions)) {
                    i28 = 131072;
                } else {
                    i28 = 65536;
                }
                i26 |= i28;
            }
            i29 = i5 & 65536;
            if (i29 != 0) {
                i30 = i26 | 1572864;
            } else {
                i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
            }
            i31 = i5 & 131072;
            if (i31 != 0) {
                i30 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
            }
            int i311119 = i30 | 838860800;
            if ((i5 & 2097152) == 0) {
                c = 16;
            } else {
                c = 16;
            }
            int i3111110 = 6 | c;
            if ((i5 & 4194304) == 0) {
                i32 = 128;
            } else {
                i32 = 128;
            }
            int i3111111 = i3111110 | i32;
            i33 = 1;
            if ((i11 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (gapComposer.shouldExecute(i11 & 1, z6)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                } else {
                    if (i36 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i6 != 0) {
                        z4 = true;
                    }
                    if (i9 != 0) {
                        z5 = false;
                    }
                    textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i12 != 0) {
                        function14 = null;
                    } else {
                        function14 = function2;
                    }
                    if (i14 != 0) {
                        function7 = null;
                    }
                    if (i16 != 0) {
                        function8 = null;
                    }
                    if (i18 != 0) {
                        function15 = null;
                    } else {
                        function15 = function5;
                    }
                    if (i21 == 0) {
                    }
                    if (i25 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    if (i27 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i29 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i31 != 0) {
                        z7 = false;
                    } else {
                        z7 = z3;
                    }
                    if (z7) {
                        i34 = 1;
                    } else {
                        i34 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    if ((i5 & 4194304) != 0) {
                        z10 = false;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                        textStyle3 = textStyle3;
                    } else {
                        z10 = false;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions2 = keyboardOptions3;
                    z11 = z5;
                    function12 = function14;
                    r1 = z10;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1310000147);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(r1);
                gapComposer.startReplaceGroup(1981926178);
                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
                }
                gapComposer.end(r1);
                final TextStyle textStyleMerge15 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Function2 function17 = function12;
                            Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                            if (function17 != null) {
                                gapComposer2.startReplaceGroup(-2119688641);
                                Object objRememberedValue2 = gapComposer2.rememberedValue();
                                if (objRememberedValue2 == Composer.Companion.Empty) {
                                    objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                    gapComposer2.updateRememberedValue(objRememberedValue2);
                                }
                                modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-2119398202);
                                gapComposer2.end(false);
                            }
                            Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                            TextFieldColors textFieldColors3 = textFieldColorsColors;
                            SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                            String str2 = str;
                            boolean z116 = z4;
                            boolean z117 = z7;
                            VisualTransformation visualTransformation4 = visualTransformation3;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z116, z11, textStyleMerge15, keyboardOptions2, keyboardActions2, z117, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z116, z117, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                modifier2 = modifier2;
                z9 = z4;
                z8 = z11;
                visualTransformation2 = visualTransformation3;
                function10 = function8;
                function9 = function15;
                function13 = function16;
                textStyle2 = textStyle3;
                textFieldColors2 = textFieldColorsColors;
                function11 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                textStyle2 = textStyle;
                function9 = function5;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                z7 = z3;
                i34 = i;
                i33 = i2;
                value = shape;
                textFieldColors2 = textFieldColors;
                function10 = function8;
                z8 = z5;
                function11 = function7;
                z9 = z4;
                function12 = function2;
                function13 = function6;
                keyboardActions2 = keyboardActions;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final Modifier modifier17 = modifier2;
                final KeyboardOptions keyboardOptions18 = keyboardOptions2;
                final KeyboardActions keyboardActions17 = keyboardActions2;
                final boolean z116 = z7;
                final int i4118 = i34;
                final int i4119 = i33;
                final Shape shape16 = value;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        String str2 = str;
                        Function1 function17 = function1;
                        Modifier modifier18 = modifier17;
                        boolean z117 = z9;
                        boolean z118 = z8;
                        TextStyle textStyle4 = textStyle2;
                        Function2 function18 = function12;
                        Function2 function19 = function11;
                        Function2 function20 = function10;
                        Function2 function21 = function9;
                        Function2 function22 = function13;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions19 = keyboardOptions18;
                        KeyboardActions keyboardActions18 = keyboardActions17;
                        boolean z119 = z116;
                        int i41110 = i4118;
                        boolean z1110 = i4119;
                        Shape shape17 = shape16;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i41111 = i5;
                        ScrimKt.OutlinedTextField(str2, function17, modifier18, z117, z118, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions19, keyboardActions18, z119, i41110, z1110 ? 1 : 0, shape17, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i11 |= 805306368;
        i20 = i4 | 54;
        i21 = i5 & 4096;
        if (i21 != 0) {
            i22 = i4 | 438;
        } else {
            if ((i4 & 384) != 0) {
                if (gapComposer.changedInstance(function6)) {
                    i23 = 256;
                } else {
                    i23 = 128;
                }
                i20 |= i23;
            }
            i22 = i20;
        }
        i24 = i22 | 3072;
        i25 = i5 & 16384;
        if (i25 != 0) {
            i26 = i22 | 27648;
        } else {
            i26 = i24 | (gapComposer.changed(visualTransformation) ? 16384 : 8192);
        }
        i27 = i5 & 32768;
        if (i27 != 0) {
            i26 |= 196608;
        } else if ((i4 & 196608) == 0) {
            if (gapComposer.changed(keyboardOptions)) {
                i28 = 131072;
            } else {
                i28 = 65536;
            }
            i26 |= i28;
        }
        i29 = i5 & 65536;
        if (i29 != 0) {
            i30 = i26 | 1572864;
        } else {
            i30 = i26 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
        }
        i31 = i5 & 131072;
        if (i31 != 0) {
            i30 |= 12582912;
        } else if ((i4 & 12582912) == 0) {
            i30 |= gapComposer.changed(z3) ? 8388608 : 4194304;
        }
        int i3111112 = i30 | 838860800;
        if ((i5 & 2097152) == 0) {
            c = 16;
        } else {
            c = 16;
        }
        int i3111113 = 6 | c;
        if ((i5 & 4194304) == 0) {
            i32 = 128;
        } else {
            i32 = 128;
        }
        int i3111114 = i3111113 | i32;
        i33 = 1;
        if ((i11 & 306783379) != 306783378) {
            z6 = true;
        } else {
            z6 = true;
        }
        if (gapComposer.shouldExecute(i11 & 1, z6)) {
            gapComposer.startDefaults();
            if ((i3 & 1) != 0) {
                if (i36 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i6 != 0) {
                    z4 = true;
                }
                if (i9 != 0) {
                    z5 = false;
                }
                textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                if (i12 != 0) {
                    function14 = null;
                } else {
                    function14 = function2;
                }
                if (i14 != 0) {
                    function7 = null;
                }
                if (i16 != 0) {
                    function8 = null;
                }
                if (i18 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i21 == 0) {
                }
                if (i25 != 0) {
                    visualTransformation3 = VisualTransformation.Companion.None;
                } else {
                    visualTransformation3 = visualTransformation;
                }
                if (i27 != 0) {
                    keyboardOptions3 = KeyboardOptions.Default;
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if (i29 != 0) {
                    keyboardActions2 = KeyboardActions.Default;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i31 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (z7) {
                    i34 = 1;
                } else {
                    i34 = Integer.MAX_VALUE;
                }
                if ((i5 & 2097152) != 0) {
                    value = ShapesKt.getValue(4, gapComposer);
                } else {
                    value = shape;
                }
                if ((i5 & 4194304) != 0) {
                    z10 = false;
                    textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                    textStyle3 = textStyle3;
                } else {
                    z10 = false;
                    textFieldColorsColors = textFieldColors;
                }
                keyboardOptions2 = keyboardOptions3;
                z11 = z5;
                function12 = function14;
                r1 = z10;
            } else {
                if (i36 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i6 != 0) {
                    z4 = true;
                }
                if (i9 != 0) {
                    z5 = false;
                }
                textStyle3 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                if (i12 != 0) {
                    function14 = null;
                } else {
                    function14 = function2;
                }
                if (i14 != 0) {
                    function7 = null;
                }
                if (i16 != 0) {
                    function8 = null;
                }
                if (i18 != 0) {
                    function15 = null;
                } else {
                    function15 = function5;
                }
                if (i21 == 0) {
                }
                if (i25 != 0) {
                    visualTransformation3 = VisualTransformation.Companion.None;
                } else {
                    visualTransformation3 = visualTransformation;
                }
                if (i27 != 0) {
                    keyboardOptions3 = KeyboardOptions.Default;
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if (i29 != 0) {
                    keyboardActions2 = KeyboardActions.Default;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i31 != 0) {
                    z7 = false;
                } else {
                    z7 = z3;
                }
                if (z7) {
                    i34 = 1;
                } else {
                    i34 = Integer.MAX_VALUE;
                }
                if ((i5 & 2097152) != 0) {
                    value = ShapesKt.getValue(4, gapComposer);
                } else {
                    value = shape;
                }
                if ((i5 & 4194304) != 0) {
                    z10 = false;
                    textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                    textStyle3 = textStyle3;
                } else {
                    z10 = false;
                    textFieldColorsColors = textFieldColors;
                }
                keyboardOptions2 = keyboardOptions3;
                z11 = z5;
                function12 = function14;
                r1 = z10;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(1310000147);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(r1);
            gapComposer.startReplaceGroup(1981926178);
            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
            if (jM752getColor0d7_KjU == 16) {
                jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z4, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, r1).getValue()).booleanValue());
            }
            gapComposer.end(r1);
            final TextStyle textStyleMerge16 = textStyle3.merge(new TextStyle(jM752getColor0d7_KjU, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
            Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Function2 function17 = function12;
                        Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                        if (function17 != null) {
                            gapComposer2.startReplaceGroup(-2119688641);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.Empty) {
                                objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-2119398202);
                            gapComposer2.end(false);
                        }
                        Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                        Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                        Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                        TextFieldColors textFieldColors3 = textFieldColorsColors;
                        SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                        String str2 = str;
                        boolean z117 = z4;
                        boolean z118 = z7;
                        VisualTransformation visualTransformation4 = visualTransformation3;
                        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z117, z11, textStyleMerge16, keyboardOptions2, keyboardActions2, z118, i34, i33 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-1189274459, new MainActivity$$ExternalSyntheticLambda17(str2, z117, z118, visualTransformation4, mutableInteractionSourceImpl2, function17, function7, function8, function15, function16, textFieldColors3, value), gapComposer2), gapComposer2, 0);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
            modifier2 = modifier2;
            z9 = z4;
            z8 = z11;
            visualTransformation2 = visualTransformation3;
            function10 = function8;
            function9 = function15;
            function13 = function16;
            textStyle2 = textStyle3;
            textFieldColors2 = textFieldColorsColors;
            function11 = function7;
        } else {
            gapComposer.skipToGroupEnd();
            textStyle2 = textStyle;
            function9 = function5;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            z7 = z3;
            i34 = i;
            i33 = i2;
            value = shape;
            textFieldColors2 = textFieldColors;
            function10 = function8;
            z8 = z5;
            function11 = function7;
            z9 = z4;
            function12 = function2;
            function13 = function6;
            keyboardActions2 = keyboardActions;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Modifier modifier18 = modifier2;
            final KeyboardOptions keyboardOptions19 = keyboardOptions2;
            final KeyboardActions keyboardActions18 = keyboardActions2;
            final boolean z117 = z7;
            final int i41110 = i34;
            final int i41111 = i33;
            final Shape shape17 = value;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                    String str2 = str;
                    Function1 function17 = function1;
                    Modifier modifier19 = modifier18;
                    boolean z118 = z9;
                    boolean z119 = z8;
                    TextStyle textStyle4 = textStyle2;
                    Function2 function18 = function12;
                    Function2 function19 = function11;
                    Function2 function20 = function10;
                    Function2 function21 = function9;
                    Function2 function22 = function13;
                    VisualTransformation visualTransformation4 = visualTransformation2;
                    KeyboardOptions keyboardOptions110 = keyboardOptions19;
                    KeyboardActions keyboardActions19 = keyboardActions18;
                    boolean z1110 = z117;
                    int i41112 = i41110;
                    boolean z1111 = i41111;
                    Shape shape18 = shape17;
                    TextFieldColors textFieldColors3 = textFieldColors2;
                    int i41113 = i5;
                    ScrimKt.OutlinedTextField(str2, function17, modifier19, z118, z119, textStyle4, function18, function19, function20, function21, function22, visualTransformation4, keyboardOptions110, keyboardActions19, z1110, i41112, z1111 ? 1 : 0, shape18, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41113);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void RadioButton(boolean z, Function0 function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, Composer composer, int i) {
        Function0 function1;
        Modifier modifier2;
        boolean z3;
        RadioButtonColors radioButtonColors2;
        Modifier modifier3;
        int i2;
        RadioButtonColors radioButtonColors3;
        boolean z4;
        long j;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(408580840);
        int i3 = i | (gapComposer.changed(z) ? 4 : 2);
        if ((i & 48) == 0) {
            function1 = function0;
            i3 |= gapComposer.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i4 = i3 | 208256;
        if (gapComposer.shouldExecute(i4 & 1, (74899 & i4) != 74898)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
                RadioButtonColors radioButtonColors4 = colorScheme.defaultRadioButtonColorsCached;
                if (radioButtonColors4 == null) {
                    long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
                    long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
                    long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                    long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
                    long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                    RadioButtonColors radioButtonColors5 = new RadioButtonColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4)));
                    colorScheme.defaultRadioButtonColorsCached = radioButtonColors5;
                    radioButtonColors4 = radioButtonColors5;
                }
                modifier3 = Modifier.Companion.$$INSTANCE;
                i2 = i4 & (-57345);
                radioButtonColors3 = radioButtonColors4;
                z4 = true;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                radioButtonColors3 = radioButtonColors;
                i2 = i4 & (-57345);
                z4 = z2;
            }
            gapComposer.endDefaults();
            radioButtonColors3.getClass();
            if (z4 && z) {
                j = radioButtonColors3.selectedColor;
            } else if (!z4 || z) {
                j = (z4 || !z) ? radioButtonColors3.disabledUnselectedColor : radioButtonColors3.disabledSelectedColor;
            } else {
                j = radioButtonColors3.unselectedColor;
            }
            Modifier modifier4 = modifier3;
            boolean z5 = z4;
            m316RadioButtonImpljgcpOPg(z, function1, modifier4, z5, j, z ? 6.0f : CropImageView.DEFAULT_ASPECT_RATIO, gapComposer, (i2 & 8190) | 1572864);
            z3 = z5;
            radioButtonColors2 = radioButtonColors3;
            modifier2 = modifier4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z3 = z2;
            radioButtonColors2 = radioButtonColors;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda1(z, function0, modifier2, z3, radioButtonColors2, i, (byte) 1);
        }
    }

    /* JADX INFO: renamed from: RadioButtonImpl-jgcpOPg, reason: not valid java name */
    public static final void m316RadioButtonImpljgcpOPg(final boolean z, final Function0 function0, final Modifier modifier, final boolean z2, final long j, final float f, Composer composer, final int i) {
        int i2;
        float f2;
        int i3;
        State stateRememberUpdatedState;
        int i4;
        Modifier modifierM181selectableO2vRcR0;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1062082816);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            f2 = f;
            i2 |= gapComposer.changed(f2) ? 131072 : 65536;
        } else {
            f2 = f;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed((Object) null) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        boolean z3 = true;
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            AnimateAsState animateAsStateM18animateDpAsStateAjpBEmI = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f2, CardKt.m272valueyDoVZcs(1, gapComposer), null, gapComposer, (i2 >> 15) & 14, 12);
            if (z2) {
                gapComposer.startReplaceGroup(515408562);
                int i5 = (i2 >> 12) & 14;
                i3 = 0;
                stateRememberUpdatedState = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j, CardKt.m272valueyDoVZcs(3, gapComposer), null, gapComposer, i5, 12);
                gapComposer.end(false);
            } else {
                i3 = 0;
                gapComposer.startReplaceGroup(515589447);
                stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(j), gapComposer);
                gapComposer.end(false);
            }
            if (function0 != null) {
                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                i4 = i3;
                modifierM181selectableO2vRcR0 = SelectableKt.m181selectableO2vRcR0(MinimumInteractiveModifier.INSTANCE, z, null, RippleKt.m313rippleOu1YvPQ$default(false, 20.0f, 0L, RoundedCornerShapeKt.CircleShape, 244), z2, new Role(3), function0);
            } else {
                i4 = i3;
                modifierM181selectableO2vRcR0 = Modifier.Companion.$$INSTANCE;
            }
            Modifier modifierM148requiredSize3ABfNKs = SizeKt.m148requiredSize3ABfNKs(OffsetKt.m135padding3ABfNKs(SizeKt.wrapContentSize$default(modifier.then(modifierM181selectableO2vRcR0)), 2.0f));
            boolean zChanged = gapComposer.changed(stateRememberUpdatedState) | gapComposer.changed(animateAsStateM18animateDpAsStateAjpBEmI);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(stateRememberUpdatedState, animateAsStateM18animateDpAsStateAjpBEmI, z3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ImageKt.Canvas(i4, gapComposer, modifierM148requiredSize3ABfNKs, (Function1) objRememberedValue);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ScrimKt.m316RadioButtonImpljgcpOPg(z, function0, modifier, z2, j, f, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x012c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x012e  */
    /* JADX WARN: Code duplicated, block: B:87:0x014a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x014c  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:93:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    public static final void m317ScaffoldTvnljyQ(Modifier modifier, final ComposableLambdaImpl composableLambdaImpl, Function2 function2, Function2 function3, Function2 function4, int i, long j, long j2, WindowInsets windowInsets, final ComposableLambdaImpl composableLambdaImpl2, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        Function2 function5;
        int i5;
        Function2 function6;
        int i6;
        int i7;
        Function2 function7;
        int i8;
        int i9;
        long j3;
        int i10;
        boolean z;
        final int i11;
        final Modifier modifier3;
        final Function2 function8;
        final Function2 function9;
        final Function2 function10;
        final long j4;
        final long j5;
        final WindowInsets windowInsets2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i12;
        int i13;
        WindowInsets unionInsets;
        Modifier modifier4;
        long j6;
        long j7;
        boolean zChanged;
        Object objRememberedValue;
        MutableWindowInsets mutableWindowInsets;
        boolean zChanged2;
        Object objRememberedValue2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1211482744);
        int i14 = i3 & 1;
        int i15 = 2;
        if (i14 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            i4 = (gapComposer.changed(modifier2) ? 4 : 2) | i2;
        }
        int i16 = i3 & 4;
        if (i16 == 0) {
            if ((i2 & 384) == 0) {
                function5 = function2;
                i4 |= gapComposer.changedInstance(function5) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    function6 = function3;
                    if (gapComposer.changedInstance(function6)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i2 & 24576) == 0) {
                        function7 = function4;
                        if (gapComposer.changedInstance(function7)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    i9 = i4 | 65536;
                    if ((1572864 & i2) == 0) {
                        if ((i3 & 64) == 0) {
                            j3 = j;
                            int i17 = gapComposer.changed(j3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
                            i9 |= i17;
                        } else {
                            j3 = j;
                        }
                        i9 |= i17;
                    } else {
                        j3 = j;
                    }
                    i10 = i9 | 37748736;
                    if ((306783379 & i10) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i10 & 1, z)) {
                        gapComposer.startDefaults();
                        if ((i2 & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i16 != 0) {
                                function5 = CardKt.lambda$1582488484;
                            }
                            if (i5 != 0) {
                                function6 = CardKt.lambda$414328099;
                            }
                            if (i7 != 0) {
                                function7 = CardKt.f3lambda$1514016380;
                            }
                            i12 = i10 & (-458753);
                            if ((i3 & 64) != 0) {
                                j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                                i12 = i10 & (-4128769);
                            }
                            long jM282contentColorForek8zF_U = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                            i13 = i12 & (-264241153);
                            unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                            modifier4 = modifier2;
                            long j8 = j3;
                            j6 = jM282contentColorForek8zF_U;
                            j7 = j8;
                        } else {
                            gapComposer.skipToGroupEnd();
                            int i18 = i10 & (-458753);
                            if ((i3 & 64) != 0) {
                                i18 = i10 & (-4128769);
                            }
                            i13 = i18 & (-264241153);
                            i15 = i;
                            unionInsets = windowInsets;
                            modifier4 = modifier2;
                            j7 = j3;
                            j6 = j2;
                        }
                        gapComposer.endDefaults();
                        zChanged = gapComposer.changed(unionInsets);
                        objRememberedValue = gapComposer.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new MutableWindowInsets(unionInsets);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                        zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                        int i19 = i13;
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        int i20 = i15;
                        Function2 function11 = function5;
                        Function2 function12 = function6;
                        Function2 function13 = function7;
                        long j9 = j6;
                        SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j9, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i20, composableLambdaImpl, composableLambdaImpl2, function12, function13, mutableWindowInsets, function11), gapComposer), gapComposer, ((i19 >> 12) & 896) | 12582912, 114);
                        j4 = j7;
                        modifier3 = modifier4;
                        windowInsets2 = unionInsets;
                        function8 = function11;
                        i11 = i20;
                        j5 = j9;
                        function9 = function12;
                        function10 = function13;
                    } else {
                        gapComposer.skipToGroupEnd();
                        i11 = i;
                        modifier3 = modifier2;
                        function8 = function5;
                        function9 = function6;
                        function10 = function7;
                        j4 = j3;
                        j5 = j2;
                        windowInsets2 = windowInsets;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                                ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i4 |= 24576;
                function7 = function4;
                i9 = i4 | 65536;
                if ((1572864 & i2) == 0) {
                    if ((i3 & 64) == 0) {
                        j3 = j;
                        if (gapComposer.changed(j3)) {
                        }
                        i9 |= i17;
                    } else {
                        j3 = j;
                    }
                    i9 |= i17;
                } else {
                    j3 = j;
                }
                i10 = i9 | 37748736;
                if ((306783379 & i10) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i10 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i16 != 0) {
                            function5 = CardKt.lambda$1582488484;
                        }
                        if (i5 != 0) {
                            function6 = CardKt.lambda$414328099;
                        }
                        if (i7 != 0) {
                            function7 = CardKt.f3lambda$1514016380;
                        }
                        i12 = i10 & (-458753);
                        if ((i3 & 64) != 0) {
                            j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                            i12 = i10 & (-4128769);
                        }
                        long jM282contentColorForek8zF_U2 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                        WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
                        i13 = i12 & (-264241153);
                        unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                        modifier4 = modifier2;
                        long j10 = j3;
                        j6 = jM282contentColorForek8zF_U2;
                        j7 = j10;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i16 != 0) {
                            function5 = CardKt.lambda$1582488484;
                        }
                        if (i5 != 0) {
                            function6 = CardKt.lambda$414328099;
                        }
                        if (i7 != 0) {
                            function7 = CardKt.f3lambda$1514016380;
                        }
                        i12 = i10 & (-458753);
                        if ((i3 & 64) != 0) {
                            j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                            i12 = i10 & (-4128769);
                        }
                        long jM282contentColorForek8zF_U3 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                        WeakHashMap weakHashMap3 = WindowInsetsHolder.viewMap;
                        i13 = i12 & (-264241153);
                        unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                        modifier4 = modifier2;
                        long j11 = j3;
                        j6 = jM282contentColorForek8zF_U3;
                        j7 = j11;
                    }
                    gapComposer.endDefaults();
                    zChanged = gapComposer.changed(unionInsets);
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                    int i110 = i13;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    int i21 = i15;
                    Function2 function14 = function5;
                    Function2 function15 = function6;
                    Function2 function16 = function7;
                    long j12 = j6;
                    SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j12, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i21, composableLambdaImpl, composableLambdaImpl2, function15, function16, mutableWindowInsets, function14), gapComposer), gapComposer, ((i110 >> 12) & 896) | 12582912, 114);
                    j4 = j7;
                    modifier3 = modifier4;
                    windowInsets2 = unionInsets;
                    function8 = function14;
                    i11 = i21;
                    j5 = j12;
                    function9 = function15;
                    function10 = function16;
                } else {
                    gapComposer.skipToGroupEnd();
                    i11 = i;
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    j4 = j3;
                    j5 = j2;
                    windowInsets2 = windowInsets;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 3072;
            function6 = function3;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i2 & 24576) == 0) {
                    function7 = function4;
                    if (gapComposer.changedInstance(function7)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                i9 = i4 | 65536;
                if ((1572864 & i2) == 0) {
                    if ((i3 & 64) == 0) {
                        j3 = j;
                        if (gapComposer.changed(j3)) {
                        }
                        i9 |= i17;
                    } else {
                        j3 = j;
                    }
                    i9 |= i17;
                } else {
                    j3 = j;
                }
                i10 = i9 | 37748736;
                if ((306783379 & i10) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i10 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i16 != 0) {
                            function5 = CardKt.lambda$1582488484;
                        }
                        if (i5 != 0) {
                            function6 = CardKt.lambda$414328099;
                        }
                        if (i7 != 0) {
                            function7 = CardKt.f3lambda$1514016380;
                        }
                        i12 = i10 & (-458753);
                        if ((i3 & 64) != 0) {
                            j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                            i12 = i10 & (-4128769);
                        }
                        long jM282contentColorForek8zF_U4 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                        WeakHashMap weakHashMap4 = WindowInsetsHolder.viewMap;
                        i13 = i12 & (-264241153);
                        unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                        modifier4 = modifier2;
                        long j13 = j3;
                        j6 = jM282contentColorForek8zF_U4;
                        j7 = j13;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i16 != 0) {
                            function5 = CardKt.lambda$1582488484;
                        }
                        if (i5 != 0) {
                            function6 = CardKt.lambda$414328099;
                        }
                        if (i7 != 0) {
                            function7 = CardKt.f3lambda$1514016380;
                        }
                        i12 = i10 & (-458753);
                        if ((i3 & 64) != 0) {
                            j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                            i12 = i10 & (-4128769);
                        }
                        long jM282contentColorForek8zF_U5 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                        WeakHashMap weakHashMap5 = WindowInsetsHolder.viewMap;
                        i13 = i12 & (-264241153);
                        unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                        modifier4 = modifier2;
                        long j14 = j3;
                        j6 = jM282contentColorForek8zF_U5;
                        j7 = j14;
                    }
                    gapComposer.endDefaults();
                    zChanged = gapComposer.changed(unionInsets);
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                    int i111 = i13;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    int i22 = i15;
                    Function2 function17 = function5;
                    Function2 function18 = function6;
                    Function2 function19 = function7;
                    long j15 = j6;
                    SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j15, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i22, composableLambdaImpl, composableLambdaImpl2, function18, function19, mutableWindowInsets, function17), gapComposer), gapComposer, ((i111 >> 12) & 896) | 12582912, 114);
                    j4 = j7;
                    modifier3 = modifier4;
                    windowInsets2 = unionInsets;
                    function8 = function17;
                    i11 = i22;
                    j5 = j15;
                    function9 = function18;
                    function10 = function19;
                } else {
                    gapComposer.skipToGroupEnd();
                    i11 = i;
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    j4 = j3;
                    j5 = j2;
                    windowInsets2 = windowInsets;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 24576;
            function7 = function4;
            i9 = i4 | 65536;
            if ((1572864 & i2) == 0) {
                if ((i3 & 64) == 0) {
                    j3 = j;
                    if (gapComposer.changed(j3)) {
                    }
                    i9 |= i17;
                } else {
                    j3 = j;
                }
                i9 |= i17;
            } else {
                j3 = j;
            }
            i10 = i9 | 37748736;
            if ((306783379 & i10) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i10 & 1, z)) {
                gapComposer.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i16 != 0) {
                        function5 = CardKt.lambda$1582488484;
                    }
                    if (i5 != 0) {
                        function6 = CardKt.lambda$414328099;
                    }
                    if (i7 != 0) {
                        function7 = CardKt.f3lambda$1514016380;
                    }
                    i12 = i10 & (-458753);
                    if ((i3 & 64) != 0) {
                        j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        i12 = i10 & (-4128769);
                    }
                    long jM282contentColorForek8zF_U6 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                    WeakHashMap weakHashMap6 = WindowInsetsHolder.viewMap;
                    i13 = i12 & (-264241153);
                    unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                    modifier4 = modifier2;
                    long j16 = j3;
                    j6 = jM282contentColorForek8zF_U6;
                    j7 = j16;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i16 != 0) {
                        function5 = CardKt.lambda$1582488484;
                    }
                    if (i5 != 0) {
                        function6 = CardKt.lambda$414328099;
                    }
                    if (i7 != 0) {
                        function7 = CardKt.f3lambda$1514016380;
                    }
                    i12 = i10 & (-458753);
                    if ((i3 & 64) != 0) {
                        j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        i12 = i10 & (-4128769);
                    }
                    long jM282contentColorForek8zF_U7 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                    WeakHashMap weakHashMap7 = WindowInsetsHolder.viewMap;
                    i13 = i12 & (-264241153);
                    unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                    modifier4 = modifier2;
                    long j17 = j3;
                    j6 = jM282contentColorForek8zF_U7;
                    j7 = j17;
                }
                gapComposer.endDefaults();
                zChanged = gapComposer.changed(unionInsets);
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                int i112 = i13;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                int i23 = i15;
                Function2 function110 = function5;
                Function2 function111 = function6;
                Function2 function112 = function7;
                long j18 = j6;
                SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j18, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i23, composableLambdaImpl, composableLambdaImpl2, function111, function112, mutableWindowInsets, function110), gapComposer), gapComposer, ((i112 >> 12) & 896) | 12582912, 114);
                j4 = j7;
                modifier3 = modifier4;
                windowInsets2 = unionInsets;
                function8 = function110;
                i11 = i23;
                j5 = j18;
                function9 = function111;
                function10 = function112;
            } else {
                gapComposer.skipToGroupEnd();
                i11 = i;
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                j4 = j3;
                j5 = j2;
                windowInsets2 = windowInsets;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 384;
        function5 = function2;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 3072) == 0) {
                function6 = function3;
                if (gapComposer.changedInstance(function6)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i2 & 24576) == 0) {
                    function7 = function4;
                    if (gapComposer.changedInstance(function7)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                i9 = i4 | 65536;
                if ((1572864 & i2) == 0) {
                    if ((i3 & 64) == 0) {
                        j3 = j;
                        if (gapComposer.changed(j3)) {
                        }
                        i9 |= i17;
                    } else {
                        j3 = j;
                    }
                    i9 |= i17;
                } else {
                    j3 = j;
                }
                i10 = i9 | 37748736;
                if ((306783379 & i10) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i10 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i16 != 0) {
                            function5 = CardKt.lambda$1582488484;
                        }
                        if (i5 != 0) {
                            function6 = CardKt.lambda$414328099;
                        }
                        if (i7 != 0) {
                            function7 = CardKt.f3lambda$1514016380;
                        }
                        i12 = i10 & (-458753);
                        if ((i3 & 64) != 0) {
                            j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                            i12 = i10 & (-4128769);
                        }
                        long jM282contentColorForek8zF_U8 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                        WeakHashMap weakHashMap8 = WindowInsetsHolder.viewMap;
                        i13 = i12 & (-264241153);
                        unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                        modifier4 = modifier2;
                        long j19 = j3;
                        j6 = jM282contentColorForek8zF_U8;
                        j7 = j19;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i16 != 0) {
                            function5 = CardKt.lambda$1582488484;
                        }
                        if (i5 != 0) {
                            function6 = CardKt.lambda$414328099;
                        }
                        if (i7 != 0) {
                            function7 = CardKt.f3lambda$1514016380;
                        }
                        i12 = i10 & (-458753);
                        if ((i3 & 64) != 0) {
                            j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                            i12 = i10 & (-4128769);
                        }
                        long jM282contentColorForek8zF_U9 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                        WeakHashMap weakHashMap9 = WindowInsetsHolder.viewMap;
                        i13 = i12 & (-264241153);
                        unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                        modifier4 = modifier2;
                        long j110 = j3;
                        j6 = jM282contentColorForek8zF_U9;
                        j7 = j110;
                    }
                    gapComposer.endDefaults();
                    zChanged = gapComposer.changed(unionInsets);
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                    int i113 = i13;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    int i24 = i15;
                    Function2 function113 = function5;
                    Function2 function114 = function6;
                    Function2 function115 = function7;
                    long j111 = j6;
                    SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j111, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i24, composableLambdaImpl, composableLambdaImpl2, function114, function115, mutableWindowInsets, function113), gapComposer), gapComposer, ((i113 >> 12) & 896) | 12582912, 114);
                    j4 = j7;
                    modifier3 = modifier4;
                    windowInsets2 = unionInsets;
                    function8 = function113;
                    i11 = i24;
                    j5 = j111;
                    function9 = function114;
                    function10 = function115;
                } else {
                    gapComposer.skipToGroupEnd();
                    i11 = i;
                    modifier3 = modifier2;
                    function8 = function5;
                    function9 = function6;
                    function10 = function7;
                    j4 = j3;
                    j5 = j2;
                    windowInsets2 = windowInsets;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 24576;
            function7 = function4;
            i9 = i4 | 65536;
            if ((1572864 & i2) == 0) {
                if ((i3 & 64) == 0) {
                    j3 = j;
                    if (gapComposer.changed(j3)) {
                    }
                    i9 |= i17;
                } else {
                    j3 = j;
                }
                i9 |= i17;
            } else {
                j3 = j;
            }
            i10 = i9 | 37748736;
            if ((306783379 & i10) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i10 & 1, z)) {
                gapComposer.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i16 != 0) {
                        function5 = CardKt.lambda$1582488484;
                    }
                    if (i5 != 0) {
                        function6 = CardKt.lambda$414328099;
                    }
                    if (i7 != 0) {
                        function7 = CardKt.f3lambda$1514016380;
                    }
                    i12 = i10 & (-458753);
                    if ((i3 & 64) != 0) {
                        j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        i12 = i10 & (-4128769);
                    }
                    long jM282contentColorForek8zF_U10 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                    WeakHashMap weakHashMap10 = WindowInsetsHolder.viewMap;
                    i13 = i12 & (-264241153);
                    unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                    modifier4 = modifier2;
                    long j112 = j3;
                    j6 = jM282contentColorForek8zF_U10;
                    j7 = j112;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i16 != 0) {
                        function5 = CardKt.lambda$1582488484;
                    }
                    if (i5 != 0) {
                        function6 = CardKt.lambda$414328099;
                    }
                    if (i7 != 0) {
                        function7 = CardKt.f3lambda$1514016380;
                    }
                    i12 = i10 & (-458753);
                    if ((i3 & 64) != 0) {
                        j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        i12 = i10 & (-4128769);
                    }
                    long jM282contentColorForek8zF_U11 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                    WeakHashMap weakHashMap11 = WindowInsetsHolder.viewMap;
                    i13 = i12 & (-264241153);
                    unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                    modifier4 = modifier2;
                    long j113 = j3;
                    j6 = jM282contentColorForek8zF_U11;
                    j7 = j113;
                }
                gapComposer.endDefaults();
                zChanged = gapComposer.changed(unionInsets);
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy6 = Composer.Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                int i114 = i13;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                int i25 = i15;
                Function2 function116 = function5;
                Function2 function117 = function6;
                Function2 function118 = function7;
                long j114 = j6;
                SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j114, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i25, composableLambdaImpl, composableLambdaImpl2, function117, function118, mutableWindowInsets, function116), gapComposer), gapComposer, ((i114 >> 12) & 896) | 12582912, 114);
                j4 = j7;
                modifier3 = modifier4;
                windowInsets2 = unionInsets;
                function8 = function116;
                i11 = i25;
                j5 = j114;
                function9 = function117;
                function10 = function118;
            } else {
                gapComposer.skipToGroupEnd();
                i11 = i;
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                j4 = j3;
                j5 = j2;
                windowInsets2 = windowInsets;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 3072;
        function6 = function3;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i2 & 24576) == 0) {
                function7 = function4;
                if (gapComposer.changedInstance(function7)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            i9 = i4 | 65536;
            if ((1572864 & i2) == 0) {
                if ((i3 & 64) == 0) {
                    j3 = j;
                    if (gapComposer.changed(j3)) {
                    }
                    i9 |= i17;
                } else {
                    j3 = j;
                }
                i9 |= i17;
            } else {
                j3 = j;
            }
            i10 = i9 | 37748736;
            if ((306783379 & i10) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i10 & 1, z)) {
                gapComposer.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i16 != 0) {
                        function5 = CardKt.lambda$1582488484;
                    }
                    if (i5 != 0) {
                        function6 = CardKt.lambda$414328099;
                    }
                    if (i7 != 0) {
                        function7 = CardKt.f3lambda$1514016380;
                    }
                    i12 = i10 & (-458753);
                    if ((i3 & 64) != 0) {
                        j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        i12 = i10 & (-4128769);
                    }
                    long jM282contentColorForek8zF_U12 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                    WeakHashMap weakHashMap12 = WindowInsetsHolder.viewMap;
                    i13 = i12 & (-264241153);
                    unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                    modifier4 = modifier2;
                    long j115 = j3;
                    j6 = jM282contentColorForek8zF_U12;
                    j7 = j115;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i16 != 0) {
                        function5 = CardKt.lambda$1582488484;
                    }
                    if (i5 != 0) {
                        function6 = CardKt.lambda$414328099;
                    }
                    if (i7 != 0) {
                        function7 = CardKt.f3lambda$1514016380;
                    }
                    i12 = i10 & (-458753);
                    if ((i3 & 64) != 0) {
                        j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        i12 = i10 & (-4128769);
                    }
                    long jM282contentColorForek8zF_U13 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                    WeakHashMap weakHashMap13 = WindowInsetsHolder.viewMap;
                    i13 = i12 & (-264241153);
                    unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                    modifier4 = modifier2;
                    long j116 = j3;
                    j6 = jM282contentColorForek8zF_U13;
                    j7 = j116;
                }
                gapComposer.endDefaults();
                zChanged = gapComposer.changed(unionInsets);
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy7 = Composer.Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                int i115 = i13;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                int i26 = i15;
                Function2 function119 = function5;
                Function2 function1110 = function6;
                Function2 function1111 = function7;
                long j117 = j6;
                SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j117, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i26, composableLambdaImpl, composableLambdaImpl2, function1110, function1111, mutableWindowInsets, function119), gapComposer), gapComposer, ((i115 >> 12) & 896) | 12582912, 114);
                j4 = j7;
                modifier3 = modifier4;
                windowInsets2 = unionInsets;
                function8 = function119;
                i11 = i26;
                j5 = j117;
                function9 = function1110;
                function10 = function1111;
            } else {
                gapComposer.skipToGroupEnd();
                i11 = i;
                modifier3 = modifier2;
                function8 = function5;
                function9 = function6;
                function10 = function7;
                j4 = j3;
                j5 = j2;
                windowInsets2 = windowInsets;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 24576;
        function7 = function4;
        i9 = i4 | 65536;
        if ((1572864 & i2) == 0) {
            if ((i3 & 64) == 0) {
                j3 = j;
                if (gapComposer.changed(j3)) {
                }
                i9 |= i17;
            } else {
                j3 = j;
            }
            i9 |= i17;
        } else {
            j3 = j;
        }
        i10 = i9 | 37748736;
        if ((306783379 & i10) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i10 & 1, z)) {
            gapComposer.startDefaults();
            if ((i2 & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i16 != 0) {
                    function5 = CardKt.lambda$1582488484;
                }
                if (i5 != 0) {
                    function6 = CardKt.lambda$414328099;
                }
                if (i7 != 0) {
                    function7 = CardKt.f3lambda$1514016380;
                }
                i12 = i10 & (-458753);
                if ((i3 & 64) != 0) {
                    j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                    i12 = i10 & (-4128769);
                }
                long jM282contentColorForek8zF_U14 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                WeakHashMap weakHashMap14 = WindowInsetsHolder.viewMap;
                i13 = i12 & (-264241153);
                unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                modifier4 = modifier2;
                long j118 = j3;
                j6 = jM282contentColorForek8zF_U14;
                j7 = j118;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i16 != 0) {
                    function5 = CardKt.lambda$1582488484;
                }
                if (i5 != 0) {
                    function6 = CardKt.lambda$414328099;
                }
                if (i7 != 0) {
                    function7 = CardKt.f3lambda$1514016380;
                }
                i12 = i10 & (-458753);
                if ((i3 & 64) != 0) {
                    j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                    i12 = i10 & (-4128769);
                }
                long jM282contentColorForek8zF_U15 = ColorSchemeKt.m282contentColorForek8zF_U(j3, gapComposer);
                WeakHashMap weakHashMap15 = WindowInsetsHolder.viewMap;
                i13 = i12 & (-264241153);
                unionInsets = new UnionInsets(OffsetKt.current(gapComposer).systemBars, OffsetKt.current(gapComposer).displayCutout);
                modifier4 = modifier2;
                long j119 = j3;
                j6 = jM282contentColorForek8zF_U15;
                j7 = j119;
            }
            gapComposer.endDefaults();
            zChanged = gapComposer.changed(unionInsets);
            objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy8 = Composer.Companion.Empty;
            if (zChanged) {
                objRememberedValue = new MutableWindowInsets(unionInsets);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new MutableWindowInsets(unionInsets);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
            zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
            int i116 = i13;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) mutableWindowInsets, (Object) unionInsets, (byte) 14);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            int i27 = i15;
            Function2 function1112 = function5;
            Function2 function1113 = function6;
            Function2 function1114 = function7;
            long j1110 = j6;
            SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j7, j1110, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(848889571, new CardKt$$ExternalSyntheticLambda0(i27, composableLambdaImpl, composableLambdaImpl2, function1113, function1114, mutableWindowInsets, function1112), gapComposer), gapComposer, ((i116 >> 12) & 896) | 12582912, 114);
            j4 = j7;
            modifier3 = modifier4;
            windowInsets2 = unionInsets;
            function8 = function1112;
            i11 = i27;
            j5 = j1110;
            function9 = function1113;
            function10 = function1114;
        } else {
            gapComposer.skipToGroupEnd();
            i11 = i;
            modifier3 = modifier2;
            function8 = function5;
            function9 = function6;
            function10 = function7;
            j4 = j3;
            j5 = j2;
            windowInsets2 = windowInsets;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                    ScrimKt.m317ScaffoldTvnljyQ(modifier3, composableLambdaImpl, function8, function9, function10, i11, j4, j5, windowInsets2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m318ScaffoldLayoutFMILGgc(final int i, final ComposableLambdaImpl composableLambdaImpl, final ComposableLambdaImpl composableLambdaImpl2, final Function2 function2, final Function2 function3, final WindowInsets windowInsets, final Function2 function4, Composer composer, int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-280287501);
        int i4 = i2 | (gapComposer.changed(i) ? 4 : 2) | (gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16) | (gapComposer.changedInstance(composableLambdaImpl2) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024) | (gapComposer.changedInstance(function3) ? 16384 : 8192) | (gapComposer.changed(windowInsets) ? 131072 : 65536) | (gapComposer.changedInstance(function4) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer.shouldExecute(i4 & 1, (599187 & i4) != 599186)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new ScaffoldKt$ScaffoldLayout$contentPadding$1$1();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) objRememberedValue;
            boolean z = ((i4 & 896) == 256) | ((i4 & 458752) == 131072) | ((i4 & 112) == 32) | ((i4 & 7168) == 2048) | ((57344 & i4) == 16384) | ((i4 & 14) == 4) | ((3670016 & i4) == 1048576);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z || objRememberedValue2 == neverEqualPolicy) {
                i3 = 0;
                objRememberedValue2 = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Object obj3;
                        int i5;
                        Object obj4;
                        Object obj5;
                        FabPlacement fabPlacement;
                        Object obj6;
                        Integer numValueOf;
                        final int iIntValue;
                        int iMo75roundToPx0680j_4;
                        int bottom;
                        Object obj7;
                        Object obj8;
                        int iMo75roundToPx0680j_5;
                        int iMo75roundToPx0680j_6;
                        final SubcomposeMeasureScope subcomposeMeasureScope = (SubcomposeMeasureScope) obj;
                        Constraints constraints = (Constraints) obj2;
                        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(constraints.value);
                        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(constraints.value);
                        long jM777copyZbe2FdA$default = Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 10, constraints.value);
                        LayoutDirection layoutDirection = subcomposeMeasureScope.getLayoutDirection();
                        final WindowInsets windowInsets2 = windowInsets;
                        int left = windowInsets2.getLeft(subcomposeMeasureScope, layoutDirection);
                        int right = windowInsets2.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection());
                        int bottom2 = windowInsets2.getBottom(subcomposeMeasureScope);
                        List listSubcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, composableLambdaImpl);
                        ArrayList arrayList = new ArrayList(listSubcompose.size());
                        int size = listSubcompose.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            arrayList.add(((Measurable) listSubcompose.get(i6)).mo598measureBRTryo0(jM777copyZbe2FdA$default));
                        }
                        int i7 = 1;
                        if (!arrayList.isEmpty()) {
                            obj3 = arrayList.get(0);
                            int i8 = ((Placeable) obj3).height;
                            int size2 = arrayList.size() - 1;
                            i5 = 1;
                            if (1 <= size2) {
                                while (true) {
                                    Object obj9 = arrayList.get(i7);
                                    int i9 = ((Placeable) obj9).height;
                                    if (i8 < i9) {
                                        i8 = i9;
                                        obj3 = obj9;
                                    }
                                    if (i7 == size2) {
                                        break;
                                    }
                                    i7++;
                                }
                            }
                        } else {
                            i5 = 1;
                            obj3 = null;
                        }
                        Placeable placeable = (Placeable) obj3;
                        int i10 = placeable != null ? placeable.height : 0;
                        List listSubcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function2);
                        final ArrayList arrayList2 = new ArrayList(listSubcompose2.size());
                        int size3 = listSubcompose2.size();
                        int i11 = 0;
                        while (i11 < size3) {
                            int i12 = right;
                            arrayList2.add(((Measurable) listSubcompose2.get(i11)).mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU((-left) - i12, -bottom2, jM777copyZbe2FdA$default)));
                            i11++;
                            iM784getMaxWidthimpl = iM784getMaxWidthimpl;
                            right = i12;
                            iM783getMaxHeightimpl = iM783getMaxHeightimpl;
                            arrayList = arrayList;
                        }
                        int i13 = right;
                        final int i14 = iM784getMaxWidthimpl;
                        final int i15 = iM783getMaxHeightimpl;
                        final ArrayList arrayList3 = arrayList;
                        if (arrayList2.isEmpty()) {
                            obj4 = null;
                        } else {
                            obj4 = arrayList2.get(0);
                            int i16 = ((Placeable) obj4).height;
                            int size4 = arrayList2.size() - 1;
                            if (i5 <= size4) {
                                Object obj10 = obj4;
                                int i17 = i16;
                                int i18 = 1;
                                while (true) {
                                    Object obj11 = arrayList2.get(i18);
                                    int i19 = ((Placeable) obj11).height;
                                    if (i17 < i19) {
                                        obj10 = obj11;
                                        i17 = i19;
                                    }
                                    if (i18 == size4) {
                                        break;
                                    }
                                    i18++;
                                }
                                obj4 = obj10;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj4;
                        int i20 = placeable2 != null ? placeable2.height : 0;
                        if (arrayList2.isEmpty()) {
                            obj5 = null;
                        } else {
                            obj5 = arrayList2.get(0);
                            int i21 = ((Placeable) obj5).width;
                            int size5 = arrayList2.size() - 1;
                            if (1 <= size5) {
                                Object obj12 = obj5;
                                int i22 = i21;
                                int i23 = 1;
                                while (true) {
                                    Object obj13 = arrayList2.get(i23);
                                    int i24 = ((Placeable) obj13).width;
                                    if (i22 < i24) {
                                        obj12 = obj13;
                                        i22 = i24;
                                    }
                                    if (i23 == size5) {
                                        break;
                                    }
                                    i23++;
                                }
                                obj5 = obj12;
                            }
                        }
                        Placeable placeable3 = (Placeable) obj5;
                        int i25 = placeable3 != null ? placeable3.width : 0;
                        List listSubcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function3);
                        final ArrayList arrayList4 = new ArrayList(listSubcompose3.size());
                        int size6 = listSubcompose3.size();
                        int i26 = 0;
                        while (i26 < size6) {
                            int i27 = i20;
                            int i28 = left;
                            Placeable placeableMo598measureBRTryo0 = ((Measurable) listSubcompose3.get(i26)).mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU((-left) - i13, -bottom2, jM777copyZbe2FdA$default));
                            if (placeableMo598measureBRTryo0.height == 0 || placeableMo598measureBRTryo0.width == 0) {
                                placeableMo598measureBRTryo0 = null;
                            }
                            if (placeableMo598measureBRTryo0 != null) {
                                arrayList4.add(placeableMo598measureBRTryo0);
                            }
                            i26++;
                            i20 = i27;
                            left = i28;
                        }
                        int i29 = left;
                        int i30 = i20;
                        boolean zIsEmpty = arrayList4.isEmpty();
                        byte b = i;
                        if (zIsEmpty) {
                            fabPlacement = null;
                        } else {
                            if (arrayList4.isEmpty()) {
                                obj7 = null;
                            } else {
                                obj7 = arrayList4.get(0);
                                int i31 = ((Placeable) obj7).width;
                                int size7 = arrayList4.size() - 1;
                                if (1 <= size7) {
                                    Object obj14 = obj7;
                                    int i32 = i31;
                                    int i33 = 1;
                                    while (true) {
                                        Object obj15 = arrayList4.get(i33);
                                        int i34 = ((Placeable) obj15).width;
                                        if (i32 < i34) {
                                            i32 = i34;
                                            obj14 = obj15;
                                        }
                                        if (i33 == size7) {
                                            break;
                                        }
                                        i33++;
                                    }
                                    obj7 = obj14;
                                }
                            }
                            obj7.getClass();
                            int i35 = ((Placeable) obj7).width;
                            if (arrayList4.isEmpty()) {
                                obj8 = null;
                            } else {
                                obj8 = arrayList4.get(0);
                                int i36 = ((Placeable) obj8).height;
                                int size8 = arrayList4.size() - 1;
                                if (1 <= size8) {
                                    Object obj16 = obj8;
                                    int i37 = i36;
                                    int i38 = 1;
                                    while (true) {
                                        Object obj17 = arrayList4.get(i38);
                                        int i39 = ((Placeable) obj17).height;
                                        if (i37 < i39) {
                                            i37 = i39;
                                            obj16 = obj17;
                                        }
                                        if (i38 == size8) {
                                            break;
                                        }
                                        i38++;
                                    }
                                    obj8 = obj16;
                                }
                            }
                            obj8.getClass();
                            int i40 = ((Placeable) obj8).height;
                            LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                            if (b == 0) {
                                if (subcomposeMeasureScope.getLayoutDirection() == layoutDirection2) {
                                    iMo75roundToPx0680j_5 = subcomposeMeasureScope.mo75roundToPx0680j_4(16.0f);
                                    iMo75roundToPx0680j_6 = iMo75roundToPx0680j_5 + i29;
                                } else {
                                    iMo75roundToPx0680j_6 = ((i14 - subcomposeMeasureScope.mo75roundToPx0680j_4(16.0f)) - i35) - i13;
                                }
                            } else if (b != 2 && b != 3) {
                                iMo75roundToPx0680j_6 = (((i14 - i35) + i29) - i13) / 2;
                            } else if (subcomposeMeasureScope.getLayoutDirection() == layoutDirection2) {
                                iMo75roundToPx0680j_6 = ((i14 - subcomposeMeasureScope.mo75roundToPx0680j_4(16.0f)) - i35) - i13;
                            } else {
                                iMo75roundToPx0680j_5 = subcomposeMeasureScope.mo75roundToPx0680j_4(16.0f);
                                iMo75roundToPx0680j_6 = iMo75roundToPx0680j_5 + i29;
                            }
                            fabPlacement = new FabPlacement(iMo75roundToPx0680j_6, i40);
                        }
                        List listSubcompose4 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.BottomBar, function4);
                        final ArrayList arrayList5 = new ArrayList(listSubcompose4.size());
                        int size9 = listSubcompose4.size();
                        for (int i41 = 0; i41 < size9; i41++) {
                            arrayList5.add(((Measurable) listSubcompose4.get(i41)).mo598measureBRTryo0(jM777copyZbe2FdA$default));
                        }
                        if (arrayList5.isEmpty()) {
                            obj6 = null;
                        } else {
                            obj6 = arrayList5.get(0);
                            int i42 = ((Placeable) obj6).height;
                            int size10 = arrayList5.size() - 1;
                            if (1 <= size10) {
                                Object obj18 = obj6;
                                int i43 = 1;
                                while (true) {
                                    Object obj19 = arrayList5.get(i43);
                                    Object obj20 = obj18;
                                    int i44 = ((Placeable) obj19).height;
                                    if (i42 < i44) {
                                        i42 = i44;
                                        obj18 = obj19;
                                    } else {
                                        obj18 = obj20;
                                    }
                                    if (i43 == size10) {
                                        break;
                                    }
                                    i43++;
                                }
                                obj6 = obj18;
                            }
                        }
                        Placeable placeable4 = (Placeable) obj6;
                        final Integer numValueOf2 = placeable4 != null ? Integer.valueOf(placeable4.height) : null;
                        if (fabPlacement != null) {
                            int i45 = fabPlacement.height;
                            if (numValueOf2 == null || b == 3) {
                                iMo75roundToPx0680j_4 = subcomposeMeasureScope.mo75roundToPx0680j_4(16.0f) + i45;
                                bottom = windowInsets2.getBottom(subcomposeMeasureScope);
                            } else {
                                iMo75roundToPx0680j_4 = numValueOf2.intValue() + i45;
                                bottom = subcomposeMeasureScope.mo75roundToPx0680j_4(16.0f);
                            }
                            numValueOf = Integer.valueOf(bottom + iMo75roundToPx0680j_4);
                        } else {
                            numValueOf = null;
                        }
                        if (i30 != 0) {
                            iIntValue = i30 + (numValueOf != null ? numValueOf.intValue() : numValueOf2 != null ? numValueOf2.intValue() : windowInsets2.getBottom(subcomposeMeasureScope));
                        } else {
                            iIntValue = 0;
                        }
                        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues(windowInsets2, subcomposeMeasureScope);
                        final Integer num = numValueOf;
                        PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(OffsetKt.calculateStartPadding(insetsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), arrayList3.isEmpty() ? insetsPaddingValues.mo125calculateTopPaddingD9Ej5fM() : subcomposeMeasureScope.mo78toDpu2uoSUM(i10), OffsetKt.calculateEndPadding(insetsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), numValueOf2 != null ? subcomposeMeasureScope.mo78toDpu2uoSUM(numValueOf2.intValue()) : insetsPaddingValues.mo122calculateBottomPaddingD9Ej5fM());
                        ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$2 = scaffoldKt$ScaffoldLayout$contentPadding$1$1;
                        scaffoldKt$ScaffoldLayout$contentPadding$1$2.paddingHolder$delegate.setValue(paddingValuesImpl);
                        List listSubcompose5 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.MainContent, new ComposableLambdaImpl(true, -278021671, new ButtonKt$$ExternalSyntheticLambda1(composableLambdaImpl2, scaffoldKt$ScaffoldLayout$contentPadding$1$2, (byte) 22)));
                        final ArrayList arrayList6 = new ArrayList(listSubcompose5.size());
                        int size11 = listSubcompose5.size();
                        for (int i46 = 0; i46 < size11; i46++) {
                            arrayList6.add(((Measurable) listSubcompose5.get(i46)).mo598measureBRTryo0(jM777copyZbe2FdA$default));
                        }
                        final int i47 = i25;
                        final FabPlacement fabPlacement2 = fabPlacement;
                        return subcomposeMeasureScope.layout(i14, i15, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj21) {
                                int i48;
                                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj21;
                                ArrayList arrayList7 = arrayList3;
                                int size12 = arrayList7.size();
                                for (int i49 = 0; i49 < size12; i49++) {
                                    placementScope.place((Placeable) arrayList7.get(i49), 0, 0, 1.0f);
                                }
                                ArrayList arrayList8 = arrayList6;
                                int size13 = arrayList8.size();
                                for (int i50 = 0; i50 < size13; i50++) {
                                    placementScope.place((Placeable) arrayList8.get(i50), 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                }
                                ArrayList arrayList9 = arrayList2;
                                int size14 = arrayList9.size();
                                int i51 = 0;
                                while (true) {
                                    i48 = i15;
                                    if (i51 >= size14) {
                                        break;
                                    }
                                    Placeable placeable5 = (Placeable) arrayList9.get(i51);
                                    int i52 = i14 - i47;
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                    LayoutDirection layoutDirection3 = subcomposeMeasureScope2.getLayoutDirection();
                                    WindowInsets windowInsets3 = windowInsets2;
                                    placementScope.place(placeable5, ((windowInsets3.getLeft(subcomposeMeasureScope2, layoutDirection3) + i52) - windowInsets3.getRight(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection())) / 2, i48 - iIntValue, 2.0f);
                                    i51++;
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                if (fabPlacement3 != null) {
                                    ArrayList arrayList10 = arrayList4;
                                    int size15 = arrayList10.size();
                                    for (int i53 = 0; i53 < size15; i53++) {
                                        Placeable placeable6 = (Placeable) arrayList10.get(i53);
                                        int i54 = fabPlacement3.left;
                                        Integer num2 = num;
                                        num2.getClass();
                                        placementScope.place(placeable6, i54, i48 - num2.intValue(), 4.0f);
                                    }
                                }
                                ArrayList arrayList11 = arrayList5;
                                int size16 = arrayList11.size();
                                for (int i55 = 0; i55 < size16; i55++) {
                                    Placeable placeable7 = (Placeable) arrayList11.get(i55);
                                    Integer num3 = numValueOf2;
                                    placementScope.place(placeable7, 0, i48 - (num3 != null ? num3.intValue() : 0), 3.0f);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                i3 = 0;
            }
            RulerKt.SubcomposeLayout((Modifier) null, (Function2) objRememberedValue2, gapComposer, i3, 1);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CardKt$$ExternalSyntheticLambda0(i, composableLambdaImpl, composableLambdaImpl2, function2, function3, windowInsets, function4, i2);
        }
    }

    /* JADX INFO: renamed from: Scrim-yrwZFoE, reason: not valid java name */
    public static final void m319ScrimyrwZFoE(String str, Modifier modifier, Function0 function0, Function0 function1, long j, Composer composer, int i) {
        Modifier modifier2;
        Modifier modifier3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2078815310);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | 48 | (gapComposer.changedInstance(function0) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024) | (gapComposer.changed(j) ? 16384 : 8192);
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.startDefaults();
            int i3 = i & 1;
            Modifier modifierSemantics = Modifier.Companion.$$INSTANCE;
            if (i3 == 0 || gapComposer.getDefaultsInvalid()) {
                modifier3 = modifierSemantics;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
            }
            gapComposer.endDefaults();
            if (j != 16) {
                gapComposer.startReplaceGroup(-853219337);
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (function0 != null) {
                    gapComposer.startReplaceGroup(-853120974);
                    int i4 = i2 & 896;
                    boolean z = i4 == 256;
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (z || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(b, function0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, function0, (PointerInputEventHandler) objRememberedValue);
                    boolean z2 = ((i2 & 14) == 4) | (i4 == 256);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (z2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) str, (Object) function0, (byte) 15);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    modifierSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-852623672);
                    gapComposer.end(false);
                }
                Modifier modifierThen = modifier3.then(SizeKt.FillWholeMaxSize).then(modifierSemantics);
                boolean z3 = ((((57344 & i2) ^ 24576) > 16384 && gapComposer.changed(j)) || (i2 & 24576) == 16384) | ((i2 & 7168) == 2048);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (z3 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new ScrimKt$$ExternalSyntheticLambda1(j, function1, b);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                ImageKt.Canvas(0, gapComposer, modifierThen, (Function1) objRememberedValue3);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-852426512);
                gapComposer.end(false);
            }
            modifier2 = modifier3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipKt$$ExternalSyntheticLambda11(str, modifier2, function0, function1, j, i);
        }
    }

    public static final void SegmentedButton(SingleChoiceSegmentedButtonScopeWrapper singleChoiceSegmentedButtonScopeWrapper, boolean z, Function0 function0, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        boolean z3;
        SegmentedButtonColors segmentedButtonColors2;
        BorderStroke borderStroke2;
        PaddingValues paddingValues2;
        Function2 function3;
        SegmentedButtonColors segmentedButtonColors3;
        long j;
        PaddingValues paddingValues3;
        int i3;
        Modifier modifier3;
        Function2 function4;
        BorderStroke borderStroke3;
        boolean z4;
        boolean z5;
        long j2;
        long j3;
        long j4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1532041126);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(singleChoiceSegmentedButtonScopeWrapper) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(shape) ? 2048 : 1024;
        }
        int i4 = 221184 | i2;
        if ((1572864 & i) == 0) {
            i4 = 745472 | i2;
        }
        if ((12582912 & i) == 0) {
            i4 |= 4194304;
        }
        int i5 = 905969664 | i4;
        byte b = 1;
        if (gapComposer.shouldExecute(i5 & 1, (306783379 & i5) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
                ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
                SegmentedButtonColors segmentedButtonColors4 = colorScheme.defaultSegmentedButtonColorsCached;
                if (segmentedButtonColors4 == null) {
                    long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 31);
                    long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14);
                    long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 23);
                    long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                    long jM284fromToken_Htp75A5 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 23);
                    long jM284fromToken_Htp75A6 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 31);
                    long jM284fromToken_Htp75A7 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                    long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A7), Color.m484getGreenimpl(jM284fromToken_Htp75A7), Color.m482getBlueimpl(jM284fromToken_Htp75A7), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A7));
                    long jM284fromToken_Htp75A8 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 23);
                    long jColor2 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A8), Color.m484getGreenimpl(jM284fromToken_Htp75A8), Color.m482getBlueimpl(jM284fromToken_Htp75A8), 0.12f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A8));
                    long jM284fromToken_Htp75A9 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                    long jColor3 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A9), Color.m484getGreenimpl(jM284fromToken_Htp75A9), Color.m482getBlueimpl(jM284fromToken_Htp75A9), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A9));
                    long jM284fromToken_Htp75A10 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 23);
                    segmentedButtonColors3 = new SegmentedButtonColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jM284fromToken_Htp75A3, jM284fromToken_Htp75A4, jM284fromToken_Htp75A5, jM284fromToken_Htp75A6, jColor, jColor2, jColor3, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A10), Color.m484getGreenimpl(jM284fromToken_Htp75A10), Color.m482getBlueimpl(jM284fromToken_Htp75A10), 0.12f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A10)));
                    colorScheme.defaultSegmentedButtonColorsCached = segmentedButtonColors3;
                } else {
                    segmentedButtonColors3 = segmentedButtonColors4;
                }
                if (z) {
                    j = segmentedButtonColors3.activeBorderColor;
                } else {
                    j = !z ? segmentedButtonColors3.inactiveBorderColor : segmentedButtonColors3.disabledInactiveBorderColor;
                }
                BorderStroke borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(j, 1.0f);
                paddingValues3 = SegmentedButtonDefaults.ContentPadding;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-643804033, new SongMenuKt$$ExternalSyntheticLambda26(b, z), gapComposer);
                i3 = i5 & (-33030145);
                modifier3 = Modifier.Companion.$$INSTANCE;
                function4 = composableLambdaImplRememberComposableLambda;
                borderStroke3 = borderStrokeM38BorderStrokecXLIe8U;
                z4 = true;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z2;
                segmentedButtonColors3 = segmentedButtonColors;
                borderStroke3 = borderStroke;
                paddingValues3 = paddingValues;
                function4 = function2;
                i3 = i5 & (-33030145);
                modifier3 = modifier;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(-1579573323);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(false);
            segmentedButtonColors3.getClass();
            if (z4 && z) {
                z5 = z4;
                j2 = segmentedButtonColors3.activeContainerColor;
            } else {
                z5 = z4;
                j2 = 0;
                if ((!z5 || z) && !z5 && z) {
                    j2 = segmentedButtonColors3.disabledActiveContainerColor;
                }
            }
            if (z5 && z) {
                j3 = j2;
                j4 = segmentedButtonColors3.activeContentColor;
            } else {
                j3 = j2;
                if (!z5 || z) {
                    j4 = (z5 || !z) ? segmentedButtonColors3.disabledInactiveContentColor : segmentedButtonColors3.disabledActiveContentColor;
                } else {
                    j4 = segmentedButtonColors3.inactiveContentColor;
                }
            }
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Fragment$5$$ExternalSyntheticOutline0.m(0, gapComposer);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue2;
            boolean zChanged = gapComposer.changed(mutableInteractionSourceImpl);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new SliderState.AnonymousClass2(mutableInteractionSourceImpl, parcelableSnapshotMutableIntState, null, (byte) 17);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue3);
            Modifier modifierLayout = RulerKt.layout(singleChoiceSegmentedButtonScopeWrapper.weight(modifier3, 1.0f, true), new SliderKt$$ExternalSyntheticLambda1((Object) parcelableSnapshotMutableIntState, z, (byte) 1));
            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierLayout, ButtonDefaults.MinWidth, ButtonDefaults.m250getMinHeightD9Ej5fM());
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new TextKt$$ExternalSyntheticLambda0((byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            SegmentedButtonColors segmentedButtonColors5 = segmentedButtonColors3;
            boolean z6 = z5;
            SurfaceKt.m338Surfaced85dljk(z, function0, SemanticsModifierKt.semantics(modifierM143defaultMinSizeVpY3zN4, false, (Function1) objRememberedValue4), z6, shape, j3, j4, CropImageView.DEFAULT_ASPECT_RATIO, borderStroke3, mutableInteractionSourceImpl, Expect_jvmKt.rememberComposableLambda(-1208080836, new SegmentedButtonKt$$ExternalSyntheticLambda3(function4, composableLambdaImpl, paddingValues3), gapComposer), gapComposer, ((i3 >> 6) & 7168) | ((i3 >> 3) & 126) | (57344 & (i3 << 3)), 384);
            z3 = z6;
            borderStroke2 = borderStroke3;
            segmentedButtonColors2 = segmentedButtonColors5;
            function3 = function4;
            paddingValues2 = paddingValues3;
            modifier2 = modifier3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z3 = z2;
            segmentedButtonColors2 = segmentedButtonColors;
            borderStroke2 = borderStroke;
            paddingValues2 = paddingValues;
            function3 = function2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SegmentedButtonKt$$ExternalSyntheticLambda4(singleChoiceSegmentedButtonScopeWrapper, z, function0, shape, modifier2, z3, segmentedButtonColors2, borderStroke2, paddingValues2, function3, composableLambdaImpl, i);
        }
    }

    public static final void SegmentedButtonContent(Function2 function2, ComposableLambdaImpl composableLambdaImpl, PaddingValues paddingValues, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1069265073);
        int i2 = (gapComposer.changedInstance(function2) ? 4 : 2) | i | (gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16) | (gapComposer.changed(paddingValues) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            BiasAlignment biasAlignment = Alignment.Companion.Center;
            Modifier modifierPadding = OffsetKt.padding(Modifier.Companion.$$INSTANCE, paddingValues);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierPadding);
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
            TextKt.ProvideTextStyle(CardKt.getValue(9, gapComposer), Expect_jvmKt.rememberComposableLambda(-1372614088, new MainActivity$$ExternalSyntheticLambda9((Object) function2, (Object) composableLambdaImpl, (Object) CardKt.m272valueyDoVZcs(1, gapComposer), (byte) 8), gapComposer), gapComposer, 48);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SegmentedButtonKt$$ExternalSyntheticLambda3(function2, composableLambdaImpl, paddingValues, i);
        }
    }

    /* JADX INFO: renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m320SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2041406825);
        int i2 = i | 48;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
            Modifier modifierWidth = OffsetKt.width(SizeKt.m144defaultMinSizeVpY3zN4$default(SemanticsModifierKt.semantics(modifier, false, new OffsetKt$$ExternalSyntheticLambda0((byte) 22)), CropImageView.DEFAULT_ASPECT_RATIO, 40.0f, 1), IntrinsicSize.Min);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(-1.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierWidth);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SingleChoiceSegmentedButtonScopeWrapper();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            composableLambdaImpl.invoke(objRememberedValue, (Object) gapComposer, (Object) 54);
            gapComposer.end(true);
            f = 1.0f;
        } else {
            gapComposer.skipToGroupEnd();
        }
        float f2 = f;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda23(modifier, f2, composableLambdaImpl, i, (byte) 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0116  */
    /* JADX WARN: Code duplicated, block: B:104:0x0122  */
    /* JADX WARN: Code duplicated, block: B:105:0x0124  */
    /* JADX WARN: Code duplicated, block: B:108:0x012d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0143  */
    /* JADX WARN: Code duplicated, block: B:129:0x0174  */
    /* JADX WARN: Code duplicated, block: B:131:0x0177  */
    /* JADX WARN: Code duplicated, block: B:134:0x017b  */
    /* JADX WARN: Code duplicated, block: B:137:0x0180  */
    /* JADX WARN: Code duplicated, block: B:138:0x0188  */
    /* JADX WARN: Code duplicated, block: B:141:0x018d  */
    /* JADX WARN: Code duplicated, block: B:142:0x0195  */
    /* JADX WARN: Code duplicated, block: B:145:0x019b  */
    /* JADX WARN: Code duplicated, block: B:146:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:149:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:153:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:155:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:157:0x0210  */
    /* JADX WARN: Code duplicated, block: B:160:0x0223  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0074  */
    /* JADX WARN: Code duplicated, block: B:46:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    /* JADX WARN: Code duplicated, block: B:55:0x0090  */
    /* JADX WARN: Code duplicated, block: B:57:0x0096  */
    /* JADX WARN: Code duplicated, block: B:60:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00da  */
    /* JADX WARN: Code duplicated, block: B:83:0x00df  */
    /* JADX WARN: Code duplicated, block: B:86:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:93:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:96:0x0106  */
    /* JADX WARN: Code duplicated, block: B:98:0x010e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0111  */
    /* JADX WARN: Instruction removed from duplicated block: B:129:0x0174, please report this as an issue */
    /* JADX INFO: renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    public static final void m321SnackbareQBnUkQ(final Modifier modifier, Function2 function2, Function2 function3, Shape shape, long j, long j2, long j3, long j4, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i, final int i2) {
        int i3;
        Function2 function4;
        int i4;
        Function2 function5;
        int i5;
        int i6;
        Shape shape2;
        long j5;
        long j6;
        int i7;
        boolean z;
        final Function2 function6;
        final Function2 function7;
        final Shape shape3;
        final long j7;
        final long j8;
        final long j9;
        final long j10;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function8;
        Shape value;
        long value2;
        long value3;
        long value4;
        long value5;
        Shape shape4;
        long j11;
        int i8;
        int i9;
        int i10;
        int i11;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1218779924);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                function4 = function2;
                i3 |= gapComposer.changedInstance(function4) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function5 = function3;
                    if (gapComposer.changedInstance(function5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    if (gapComposer.changed(false)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i13 = gapComposer.changed(shape2) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    j5 = j;
                    if ((i2 & 32) == 0 || !gapComposer.changed(j5)) {
                        i11 = 65536;
                    } else {
                        i11 = 131072;
                    }
                    i3 |= i11;
                } else {
                    j5 = j;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j6 = j2;
                        int i14 = gapComposer.changed(j6) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
                        i3 |= i14;
                    } else {
                        j6 = j2;
                    }
                    i3 |= i14;
                } else {
                    j6 = j2;
                }
                if ((i & 12582912) == 0) {
                    int i15 = i3;
                    if ((i2 & 128) == 0 || !gapComposer.changed(j3)) {
                        i10 = 4194304;
                    } else {
                        i10 = 8388608;
                    }
                    i7 = i15 | i10;
                } else {
                    i7 = i3;
                }
                if ((i & 100663296) != 0) {
                    if ((i2 & 256) == 0 || !gapComposer.changed(j4)) {
                        i9 = 33554432;
                    } else {
                        i9 = 67108864;
                    }
                    i7 |= i9;
                }
                if ((805306368 & i) != 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i8 = 536870912;
                    } else {
                        i8 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i7 |= i8;
                }
                if ((i7 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i7 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            function4 = null;
                        }
                        function8 = i4 == 0 ? function5 : null;
                        if ((i2 & 16) != 0) {
                            value = ShapesKt.getValue(4, gapComposer);
                            i7 &= -57345;
                        } else {
                            value = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            value2 = ColorSchemeKt.getValue(5, gapComposer);
                            i7 &= -458753;
                        } else {
                            value2 = j5;
                        }
                        if ((i2 & 64) != 0) {
                            value3 = ColorSchemeKt.getValue(3, gapComposer);
                            i7 &= -3670017;
                        } else {
                            value3 = j6;
                        }
                        if ((i2 & 128) != 0) {
                            value4 = ColorSchemeKt.getValue(4, gapComposer);
                            i7 &= -29360129;
                        } else {
                            value4 = j3;
                        }
                        if ((i2 & 256) != 0) {
                            value5 = ColorSchemeKt.getValue(3, gapComposer);
                            i7 &= -234881025;
                        } else {
                            value5 = j4;
                        }
                        shape4 = value;
                        j11 = value2;
                    } else {
                        gapComposer.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i7 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i7 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i7 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i7 &= -234881025;
                        }
                        value5 = j4;
                        function8 = function5;
                        shape4 = shape2;
                        value3 = j6;
                        j11 = j5;
                        value4 = j3;
                    }
                    gapComposer.endDefaults();
                    final Function2 function9 = function8;
                    final Function2 function10 = function4;
                    final long j12 = value4;
                    final long j13 = value5;
                    int i16 = i7 >> 9;
                    int i17 = (i7 & 14) | 12582912 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                    long j14 = value3;
                    SurfaceKt.m337SurfaceT9BRK9s(modifier, shape4, j11, j14, CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, null, Expect_jvmKt.rememberComposableLambda(-1343524879, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Stack.CompositionLocalProvider(TextKt.LocalTextStyle.defaultProvidedValue$runtime(CardKt.getValue(1, gapComposer2)), Expect_jvmKt.rememberComposableLambda(969655473, new SnackbarKt$$ExternalSyntheticLambda7(function10, composableLambdaImpl, function9, CardKt.getValue(9, gapComposer2), j12, j13), gapComposer2), gapComposer2, 56);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, i17, 80);
                    j7 = j14;
                    j9 = j12;
                    j10 = j13;
                    shape3 = shape4;
                    j8 = j11;
                    function6 = function10;
                    function7 = function9;
                } else {
                    gapComposer.skipToGroupEnd();
                    function6 = function4;
                    function7 = function5;
                    shape3 = shape2;
                    j7 = j6;
                    j8 = j5;
                    j9 = j3;
                    j10 = j4;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            ScrimKt.m321SnackbareQBnUkQ(modifier, function6, function7, shape3, j8, j7, j9, j10, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i3 |= 384;
            function5 = function3;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (gapComposer.changed(false)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (gapComposer.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) == 0) {
                j5 = j;
                if ((i2 & 32) == 0) {
                    i11 = 65536;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            } else {
                j5 = j;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j6 = j2;
                    if (gapComposer.changed(j6)) {
                    }
                    i3 |= i14;
                } else {
                    j6 = j2;
                }
                i3 |= i14;
            } else {
                j6 = j2;
            }
            if ((i & 12582912) == 0) {
                int i18 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i7 = i18 | i10;
            } else {
                i7 = i3;
            }
            if ((i & 100663296) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i7 |= i9;
            }
            if ((805306368 & i) != 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i8 = 536870912;
                } else {
                    i8 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i7 |= i8;
            }
            if ((i7 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i7 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        function4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                        i7 &= -57345;
                    } else {
                        value = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        value2 = ColorSchemeKt.getValue(5, gapComposer);
                        i7 &= -458753;
                    } else {
                        value2 = j5;
                    }
                    if ((i2 & 64) != 0) {
                        value3 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -3670017;
                    } else {
                        value3 = j6;
                    }
                    if ((i2 & 128) != 0) {
                        value4 = ColorSchemeKt.getValue(4, gapComposer);
                        i7 &= -29360129;
                    } else {
                        value4 = j3;
                    }
                    if ((i2 & 256) != 0) {
                        value5 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -234881025;
                    } else {
                        value5 = j4;
                    }
                    shape4 = value;
                    j11 = value2;
                } else {
                    if (i12 != 0) {
                        function4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                        i7 &= -57345;
                    } else {
                        value = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        value2 = ColorSchemeKt.getValue(5, gapComposer);
                        i7 &= -458753;
                    } else {
                        value2 = j5;
                    }
                    if ((i2 & 64) != 0) {
                        value3 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -3670017;
                    } else {
                        value3 = j6;
                    }
                    if ((i2 & 128) != 0) {
                        value4 = ColorSchemeKt.getValue(4, gapComposer);
                        i7 &= -29360129;
                    } else {
                        value4 = j3;
                    }
                    if ((i2 & 256) != 0) {
                        value5 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -234881025;
                    } else {
                        value5 = j4;
                    }
                    shape4 = value;
                    j11 = value2;
                }
                gapComposer.endDefaults();
                final Function2 function11 = function8;
                final Function2 function12 = function4;
                final long j15 = value4;
                final long j16 = value5;
                int i19 = i7 >> 9;
                int i110 = (i7 & 14) | 12582912 | (i19 & 112) | (i19 & 896) | (i19 & 7168);
                long j17 = value3;
                SurfaceKt.m337SurfaceT9BRK9s(modifier, shape4, j11, j17, CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, null, Expect_jvmKt.rememberComposableLambda(-1343524879, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Stack.CompositionLocalProvider(TextKt.LocalTextStyle.defaultProvidedValue$runtime(CardKt.getValue(1, gapComposer2)), Expect_jvmKt.rememberComposableLambda(969655473, new SnackbarKt$$ExternalSyntheticLambda7(function12, composableLambdaImpl, function11, CardKt.getValue(9, gapComposer2), j15, j16), gapComposer2), gapComposer2, 56);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, i110, 80);
                j7 = j17;
                j9 = j15;
                j10 = j16;
                shape3 = shape4;
                j8 = j11;
                function6 = function12;
                function7 = function11;
            } else {
                gapComposer.skipToGroupEnd();
                function6 = function4;
                function7 = function5;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
                j9 = j3;
                j10 = j4;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        ScrimKt.m321SnackbareQBnUkQ(modifier, function6, function7, shape3, j8, j7, j9, j10, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 48;
        function4 = function2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function5 = function3;
                if (gapComposer.changedInstance(function5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (gapComposer.changed(false)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (gapComposer.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) == 0) {
                j5 = j;
                if ((i2 & 32) == 0) {
                    i11 = 65536;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            } else {
                j5 = j;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j6 = j2;
                    if (gapComposer.changed(j6)) {
                    }
                    i3 |= i14;
                } else {
                    j6 = j2;
                }
                i3 |= i14;
            } else {
                j6 = j2;
            }
            if ((i & 12582912) == 0) {
                int i111 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i7 = i111 | i10;
            } else {
                i7 = i3;
            }
            if ((i & 100663296) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i7 |= i9;
            }
            if ((805306368 & i) != 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i8 = 536870912;
                } else {
                    i8 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i7 |= i8;
            }
            if ((i7 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i7 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        function4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                        i7 &= -57345;
                    } else {
                        value = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        value2 = ColorSchemeKt.getValue(5, gapComposer);
                        i7 &= -458753;
                    } else {
                        value2 = j5;
                    }
                    if ((i2 & 64) != 0) {
                        value3 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -3670017;
                    } else {
                        value3 = j6;
                    }
                    if ((i2 & 128) != 0) {
                        value4 = ColorSchemeKt.getValue(4, gapComposer);
                        i7 &= -29360129;
                    } else {
                        value4 = j3;
                    }
                    if ((i2 & 256) != 0) {
                        value5 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -234881025;
                    } else {
                        value5 = j4;
                    }
                    shape4 = value;
                    j11 = value2;
                } else {
                    if (i12 != 0) {
                        function4 = null;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                        i7 &= -57345;
                    } else {
                        value = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        value2 = ColorSchemeKt.getValue(5, gapComposer);
                        i7 &= -458753;
                    } else {
                        value2 = j5;
                    }
                    if ((i2 & 64) != 0) {
                        value3 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -3670017;
                    } else {
                        value3 = j6;
                    }
                    if ((i2 & 128) != 0) {
                        value4 = ColorSchemeKt.getValue(4, gapComposer);
                        i7 &= -29360129;
                    } else {
                        value4 = j3;
                    }
                    if ((i2 & 256) != 0) {
                        value5 = ColorSchemeKt.getValue(3, gapComposer);
                        i7 &= -234881025;
                    } else {
                        value5 = j4;
                    }
                    shape4 = value;
                    j11 = value2;
                }
                gapComposer.endDefaults();
                final Function2 function13 = function8;
                final Function2 function14 = function4;
                final long j18 = value4;
                final long j19 = value5;
                int i112 = i7 >> 9;
                int i113 = (i7 & 14) | 12582912 | (i112 & 112) | (i112 & 896) | (i112 & 7168);
                long j110 = value3;
                SurfaceKt.m337SurfaceT9BRK9s(modifier, shape4, j11, j110, CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, null, Expect_jvmKt.rememberComposableLambda(-1343524879, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Stack.CompositionLocalProvider(TextKt.LocalTextStyle.defaultProvidedValue$runtime(CardKt.getValue(1, gapComposer2)), Expect_jvmKt.rememberComposableLambda(969655473, new SnackbarKt$$ExternalSyntheticLambda7(function14, composableLambdaImpl, function13, CardKt.getValue(9, gapComposer2), j18, j19), gapComposer2), gapComposer2, 56);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, i113, 80);
                j7 = j110;
                j9 = j18;
                j10 = j19;
                shape3 = shape4;
                j8 = j11;
                function6 = function14;
                function7 = function13;
            } else {
                gapComposer.skipToGroupEnd();
                function6 = function4;
                function7 = function5;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
                j9 = j3;
                j10 = j4;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        ScrimKt.m321SnackbareQBnUkQ(modifier, function6, function7, shape3, j8, j7, j9, j10, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 384;
        function5 = function3;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (gapComposer.changed(false)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (gapComposer.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            j5 = j;
            if ((i2 & 32) == 0) {
                i11 = 65536;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        } else {
            j5 = j;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                j6 = j2;
                if (gapComposer.changed(j6)) {
                }
                i3 |= i14;
            } else {
                j6 = j2;
            }
            i3 |= i14;
        } else {
            j6 = j2;
        }
        if ((i & 12582912) == 0) {
            int i114 = i3;
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i7 = i114 | i10;
        } else {
            i7 = i3;
        }
        if ((i & 100663296) != 0) {
            if ((i2 & 256) == 0) {
                i9 = 33554432;
            } else {
                i9 = 33554432;
            }
            i7 |= i9;
        }
        if ((805306368 & i) != 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i8 = 536870912;
            } else {
                i8 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            i7 |= i8;
        }
        if ((i7 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i7 & 1, z)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    function4 = null;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    value = ShapesKt.getValue(4, gapComposer);
                    i7 &= -57345;
                } else {
                    value = shape2;
                }
                if ((i2 & 32) != 0) {
                    value2 = ColorSchemeKt.getValue(5, gapComposer);
                    i7 &= -458753;
                } else {
                    value2 = j5;
                }
                if ((i2 & 64) != 0) {
                    value3 = ColorSchemeKt.getValue(3, gapComposer);
                    i7 &= -3670017;
                } else {
                    value3 = j6;
                }
                if ((i2 & 128) != 0) {
                    value4 = ColorSchemeKt.getValue(4, gapComposer);
                    i7 &= -29360129;
                } else {
                    value4 = j3;
                }
                if ((i2 & 256) != 0) {
                    value5 = ColorSchemeKt.getValue(3, gapComposer);
                    i7 &= -234881025;
                } else {
                    value5 = j4;
                }
                shape4 = value;
                j11 = value2;
            } else {
                if (i12 != 0) {
                    function4 = null;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    value = ShapesKt.getValue(4, gapComposer);
                    i7 &= -57345;
                } else {
                    value = shape2;
                }
                if ((i2 & 32) != 0) {
                    value2 = ColorSchemeKt.getValue(5, gapComposer);
                    i7 &= -458753;
                } else {
                    value2 = j5;
                }
                if ((i2 & 64) != 0) {
                    value3 = ColorSchemeKt.getValue(3, gapComposer);
                    i7 &= -3670017;
                } else {
                    value3 = j6;
                }
                if ((i2 & 128) != 0) {
                    value4 = ColorSchemeKt.getValue(4, gapComposer);
                    i7 &= -29360129;
                } else {
                    value4 = j3;
                }
                if ((i2 & 256) != 0) {
                    value5 = ColorSchemeKt.getValue(3, gapComposer);
                    i7 &= -234881025;
                } else {
                    value5 = j4;
                }
                shape4 = value;
                j11 = value2;
            }
            gapComposer.endDefaults();
            final Function2 function15 = function8;
            final Function2 function16 = function4;
            final long j111 = value4;
            final long j112 = value5;
            int i115 = i7 >> 9;
            int i116 = (i7 & 14) | 12582912 | (i115 & 112) | (i115 & 896) | (i115 & 7168);
            long j113 = value3;
            SurfaceKt.m337SurfaceT9BRK9s(modifier, shape4, j11, j113, CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, null, Expect_jvmKt.rememberComposableLambda(-1343524879, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Stack.CompositionLocalProvider(TextKt.LocalTextStyle.defaultProvidedValue$runtime(CardKt.getValue(1, gapComposer2)), Expect_jvmKt.rememberComposableLambda(969655473, new SnackbarKt$$ExternalSyntheticLambda7(function16, composableLambdaImpl, function15, CardKt.getValue(9, gapComposer2), j111, j112), gapComposer2), gapComposer2, 56);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, i116, 80);
            j7 = j113;
            j9 = j111;
            j10 = j112;
            shape3 = shape4;
            j8 = j11;
            function6 = function16;
            function7 = function15;
        } else {
            gapComposer.skipToGroupEnd();
            function6 = function4;
            function7 = function5;
            shape3 = shape2;
            j7 = j6;
            j8 = j5;
            j9 = j3;
            j10 = j4;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    ScrimKt.m321SnackbareQBnUkQ(modifier, function6, function7, shape3, j8, j7, j9, j10, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: Snackbar-sDKtq54, reason: not valid java name */
    public static final void m322SnackbarsDKtq54(final SnackbarHostState.SnackbarDataImpl snackbarDataImpl, Modifier modifier, Shape shape, long j, long j2, long j3, long j4, long j5, Composer composer, final int i) {
        int i2;
        GapComposer gapComposer;
        final Modifier modifier2;
        final Shape shape2;
        final long j6;
        final long j7;
        final long j8;
        final long j9;
        final long j10;
        long value;
        Modifier modifier3;
        long j11;
        long j12;
        long j13;
        long j14;
        Shape shape3;
        int i3;
        ComposableLambdaImpl composableLambdaImpl;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(274621471);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(snackbarDataImpl) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i4 = i2 | 432;
        if ((i & 3072) == 0) {
            i4 = i2 | 1456;
        }
        if ((i & 24576) == 0) {
            i4 |= 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= 524288;
        }
        if ((12582912 & i) == 0) {
            i4 |= 4194304;
        }
        if ((100663296 & i) == 0) {
            i4 |= 33554432;
        }
        byte b = 0;
        if (gapComposer2.shouldExecute(i4 & 1, (38347923 & i4) != 38347922)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                Shape value2 = ShapesKt.getValue(4, gapComposer2);
                long value3 = ColorSchemeKt.getValue(5, gapComposer2);
                long value4 = ColorSchemeKt.getValue(3, gapComposer2);
                value = ColorSchemeKt.getValue(4, gapComposer2);
                long value5 = ColorSchemeKt.getValue(4, gapComposer2);
                long value6 = ColorSchemeKt.getValue(3, gapComposer2);
                int i5 = i4 & (-268434433);
                modifier3 = Modifier.Companion.$$INSTANCE;
                j11 = value3;
                j12 = value4;
                j13 = value5;
                j14 = value6;
                shape3 = value2;
                i3 = i5;
            } else {
                gapComposer2.skipToGroupEnd();
                i3 = i4 & (-268434433);
                modifier3 = modifier;
                shape3 = shape;
                j11 = j;
                j12 = j2;
                value = j3;
                j13 = j4;
                j14 = j5;
            }
            gapComposer2.endDefaults();
            String str = snackbarDataImpl.visuals.actionLabel;
            if (str != null) {
                gapComposer2.startReplaceGroup(-663827885);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1378313599, new ButtonKt$$ExternalSyntheticLambda4(value, snackbarDataImpl, str, (byte) 4), gapComposer2);
                gapComposer2.end(false);
                composableLambdaImpl = composableLambdaImplRememberComposableLambda;
            } else {
                gapComposer2.startReplaceGroup(-663528921);
                gapComposer2.end(false);
                composableLambdaImpl = null;
            }
            snackbarDataImpl.visuals.getClass();
            gapComposer2.startReplaceGroup(-662527001);
            gapComposer2.end(false);
            gapComposer = gapComposer2;
            m321SnackbareQBnUkQ(OffsetKt.m135padding3ABfNKs(modifier3, 12.0f), composableLambdaImpl, null, shape3, j11, j12, j13, j14, Expect_jvmKt.rememberComposableLambda(-1266389126, new SnackbarKt$$ExternalSyntheticLambda1(snackbarDataImpl, b), gapComposer2), gapComposer, ((i3 << 3) & 7168) | 805306368, 0);
            modifier2 = modifier3;
            j8 = value;
            shape2 = shape3;
            j6 = j11;
            j7 = j12;
            j9 = j13;
            j10 = j14;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            j6 = j;
            j7 = j2;
            j8 = j3;
            j9 = j4;
            j10 = j5;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    ScrimKt.m322SnackbarsDKtq54(snackbarDataImpl, modifier2, shape2, j6, j7, j8, j9, j10, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SnackbarHost(SnackbarHostState snackbarHostState, Modifier modifier, Function3 function3, Composer composer, int i, int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1077081618);
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 = i | 48;
        } else {
            i3 = (gapComposer.changed(modifier) ? 32 : 16) | i;
        }
        int i5 = i3 | 384;
        if (gapComposer.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
            if (i4 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            function3 = CardKt.f4lambda$1548712596;
            SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) snackbarHostState.currentSnackbarData$delegate.getValue();
            AccessibilityManager accessibilityManager = (AccessibilityManager) gapComposer.consume(CompositionLocalsKt.LocalAccessibilityManager);
            boolean zChanged = gapComposer.changed(snackbarDataImpl) | gapComposer.changedInstance(accessibilityManager);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SliderState.AnonymousClass2(snackbarDataImpl, accessibilityManager, null, (byte) 19);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer, snackbarDataImpl, (Function2) objRememberedValue);
            FadeInFadeOutWithScale((SnackbarHostState.SnackbarDataImpl) snackbarHostState.currentSnackbarData$delegate.getValue(), modifier, gapComposer, i5 & 1008);
        } else {
            gapComposer.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        Function3 function4 = function3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda4(snackbarHostState, modifier2, function4, i, i2);
        }
    }

    public static final void SwipeToDismissBox(final SwipeToDismissBoxState swipeToDismissBoxState, final ComposableLambdaImpl composableLambdaImpl, Modifier modifier, boolean z, boolean z2, boolean z3, Function1 function1, ComposableLambdaImpl composableLambdaImpl2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final ComposableLambdaImpl composableLambdaImpl3;
        final boolean z4;
        final Function1 function2;
        final Modifier modifier3;
        final boolean z5;
        final boolean z6;
        SnapFlingBehavior snapFlingBehaviorFlingBehavior;
        Function1 function3;
        NodeChain nodeChain = swipeToDismissBoxState.anchoredDraggableState;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-741495334);
        int i4 = i | (gapComposer.changedInstance(swipeToDismissBoxState) ? 4 : 2);
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 = i4 | 384;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            i3 = i4 | (gapComposer.changed(modifier2) ? 256 : 128);
        }
        int i6 = i3 | 1797120;
        if (gapComposer.shouldExecute(i6 & 1, (4793491 & i6) != 4793490)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifier4 = i5 != 0 ? companion : modifier2;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function1 function4 = (Function1) objRememberedValue;
            boolean z7 = ((SwipeToDismissBoxValue) ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).getValue()) == SwipeToDismissBoxValue.Settled;
            if (swipeToDismissBoxState.positionalThreshold != null) {
                gapComposer.startReplaceGroup(387580721);
                TweenSpec tweenSpec = AnchoredDraggableDefaults.SnapAnimationSpec;
                Function1 function5 = swipeToDismissBoxState.positionalThreshold;
                if (function5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
                    throw null;
                }
                snapFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.flingBehavior(nodeChain, function5, null, gapComposer, AnchoredDraggableDefaults.$stable << 9, 4);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-869697757);
                gapComposer.end(false);
                snapFlingBehaviorFlingBehavior = null;
            }
            Orientation orientation = Orientation.Horizontal;
            Modifier modifierThen = modifier4.then(new AnchoredDraggableElement(nodeChain, orientation, z7, snapFlingBehaviorFlingBehavior));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
            Modifier modifier5 = modifier4;
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z8 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z8) {
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
            Modifier modifierMatchParentSize = BoxScopeInstance.INSTANCE.matchParentSize();
            Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
            BiasAlignment.Vertical vertical = Alignment.Companion.Top;
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 0);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierMatchParentSize);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Object obj = RowScopeInstance.INSTANCE;
            composableLambdaImpl.invoke(obj, (Object) gapComposer, (Object) 54);
            gapComposer.end(true);
            boolean zChangedInstance = gapComposer.changedInstance(swipeToDismissBoxState);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ComposerKt$$ExternalSyntheticLambda0((byte) 18, swipeToDismissBoxState);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierDraggableAnchors = Icons$Filled.draggableAnchors(companion, nodeChain, orientation, (Function2) objRememberedValue2);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 0);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierDraggableAnchors);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            composableLambdaImpl3 = composableLambdaImpl2;
            composableLambdaImpl3.invoke(obj, (Object) gapComposer, (Object) 54);
            gapComposer.end(true);
            gapComposer.end(true);
            SwipeToDismissBoxValue swipeToDismissBoxValue = (SwipeToDismissBoxValue) ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).getValue();
            boolean zChangedInstance2 = gapComposer.changedInstance(swipeToDismissBoxState);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                function3 = function4;
                objRememberedValue3 = new DownloadUtil.AnonymousClass2(swipeToDismissBoxState, function3, null, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                function3 = function4;
            }
            Stack.LaunchedEffect(swipeToDismissBoxValue, function3, (Function2) objRememberedValue3, gapComposer);
            modifier3 = modifier5;
            z4 = true;
            function2 = function3;
            z6 = true;
            z5 = true;
        } else {
            composableLambdaImpl3 = composableLambdaImpl2;
            gapComposer.skipToGroupEnd();
            z4 = z;
            function2 = function1;
            modifier3 = modifier2;
            z5 = z2;
            z6 = z3;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(composableLambdaImpl, modifier3, z4, z5, z6, function2, composableLambdaImpl3, i, i2) { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                public final /* synthetic */ ComposableLambdaImpl f$1;
                public final /* synthetic */ Modifier f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ boolean f$4;
                public final /* synthetic */ boolean f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ ComposableLambdaImpl f$7;
                public final /* synthetic */ byte f$9;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f$9 = i2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(12582969);
                    ScrimKt.SwipeToDismissBox(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Composer) obj2, iUpdateChangedFlags, this.f$9);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0140  */
    /* JADX WARN: Code duplicated, block: B:103:0x014a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0151  */
    /* JADX WARN: Code duplicated, block: B:109:0x0172  */
    /* JADX WARN: Code duplicated, block: B:111:0x0176  */
    /* JADX WARN: Code duplicated, block: B:112:0x017f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0183  */
    /* JADX WARN: Code duplicated, block: B:118:0x0187  */
    /* JADX WARN: Code duplicated, block: B:120:0x018a  */
    /* JADX WARN: Code duplicated, block: B:122:0x018f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0194  */
    /* JADX WARN: Code duplicated, block: B:125:0x0196  */
    /* JADX WARN: Code duplicated, block: B:127:0x019a  */
    /* JADX WARN: Code duplicated, block: B:128:0x019d  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:135:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:139:0x0200  */
    /* JADX WARN: Code duplicated, block: B:141:0x0265  */
    /* JADX WARN: Code duplicated, block: B:144:0x0280  */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00df  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:81:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0107  */
    /* JADX WARN: Code duplicated, block: B:88:0x0115  */
    /* JADX WARN: Code duplicated, block: B:91:0x011e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0133  */
    public static final void TextField(final String str, final Function1 function1, final Modifier modifier, boolean z, TextStyle textStyle, Function2 function2, Function2 function3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z2, int i, int i2, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        TextStyle textStyle2;
        final Function2 function4;
        Function2 function5;
        int i7;
        int i8;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        int i11;
        int i12;
        KeyboardActions keyboardActions2;
        int i13;
        int i14;
        char c;
        boolean z3;
        final boolean z4;
        final VisualTransformation visualTransformation2;
        final int i15;
        final Shape shape2;
        final Function2 function6;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z5;
        final int i16;
        final TextFieldColors textFieldColors2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        TextStyle textStyle4;
        Function2 function7;
        boolean z6;
        int i17;
        Shape value;
        int i18;
        ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
        final Function2 function8;
        final boolean z7;
        final Function2 function9;
        final Shape shape3;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions4;
        final boolean z8;
        final int i19;
        final int i20;
        final TextFieldColors textFieldColorsColors;
        Object objRememberedValue;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl;
        long jM752getColor0d7_KjU;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-154966360);
        if ((i3 & 6) == 0) {
            i6 = (gapComposer.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        int i21 = i6 | 27648;
        if ((i3 & 196608) == 0) {
            if ((i5 & 32) == 0) {
                textStyle2 = textStyle;
                int i22 = gapComposer.changed(textStyle2) ? 131072 : 65536;
                i21 |= i22;
            } else {
                textStyle2 = textStyle;
            }
            i21 |= i22;
        } else {
            textStyle2 = textStyle;
        }
        int i23 = i5 & 64;
        int i24 = ByteChannelKt.CHANNEL_MAX_SIZE;
        if (i23 != 0) {
            i21 |= 1572864;
            function4 = function2;
        } else {
            function4 = function2;
            if ((i3 & 1572864) == 0) {
                i21 |= gapComposer.changedInstance(function4) ? 1048576 : 524288;
            }
        }
        int i25 = i5 & 128;
        if (i25 == 0) {
            if ((i3 & 12582912) == 0) {
                function5 = function3;
                i21 |= gapComposer.changedInstance(function5) ? 8388608 : 4194304;
            }
            i7 = i21 | 905969664;
            i8 = i4 | 28086;
            i9 = i5 & 32768;
            if (i9 != 0) {
                keyboardOptions2 = keyboardOptions;
                if ((i4 & 196608) == 0) {
                    i10 = 131072;
                    if (gapComposer.changed(keyboardOptions2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i8 |= i11;
                }
                i12 = i5 & 65536;
                if (i12 != 0) {
                    i13 = i8 | 1572864;
                    keyboardActions2 = keyboardActions;
                } else {
                    keyboardActions2 = keyboardActions;
                    if (!gapComposer.changed(keyboardActions2)) {
                        i24 = 524288;
                    }
                    i13 = i8 | i24;
                }
                i14 = i5 & i10;
                if (i14 != 0) {
                    i13 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i13 |= gapComposer.changed(z2) ? 8388608 : 4194304;
                }
                int i26 = i13 | 838860800;
                if ((i5 & 4194304) == 0 || !gapComposer.changed(textFieldColors)) {
                    c = 128;
                } else {
                    c = 256;
                }
                int i27 = 22 | c;
                if ((i7 & 306783379) != 306783378 && (i26 & 306783379) == 306783378 && (i27 & 147) == 146) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (gapComposer.shouldExecute(i7 & 1, z3)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if ((i5 & 32) != 0) {
                            textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        } else {
                            textStyle4 = textStyle2;
                        }
                        if (i23 != 0) {
                            function4 = null;
                        }
                        function7 = i25 == 0 ? function5 : null;
                        if (i9 != 0) {
                            keyboardOptions2 = KeyboardOptions.Default;
                        }
                        if (i12 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        }
                        if (i14 != 0) {
                            z6 = false;
                        } else {
                            z6 = z2;
                        }
                        if (z6) {
                            i17 = 1;
                        } else {
                            i17 = Integer.MAX_VALUE;
                        }
                        value = ShapesKt.getValue(5, gapComposer);
                        i18 = i5 & 4194304;
                        viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = VisualTransformation.Companion.None;
                        if (i18 != 0) {
                            function8 = function7;
                            z7 = z6;
                            function9 = function4;
                            shape3 = value;
                            visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                            keyboardOptions4 = keyboardOptions2;
                            keyboardActions4 = keyboardActions2;
                            z8 = true;
                            i19 = 1;
                            i20 = i17;
                            textFieldColorsColors = TextFieldDefaults.colors(gapComposer);
                        } else {
                            function8 = function7;
                            z7 = z6;
                            function9 = function4;
                            shape3 = value;
                            visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                            keyboardOptions4 = keyboardOptions2;
                            keyboardActions4 = keyboardActions2;
                            z8 = true;
                            i19 = 1;
                            i20 = i17;
                            textFieldColorsColors = textFieldColors;
                        }
                    } else {
                        gapComposer.skipToGroupEnd();
                        visualTransformation3 = visualTransformation;
                        z7 = z2;
                        i19 = i2;
                        shape3 = shape;
                        textFieldColorsColors = textFieldColors;
                        function9 = function4;
                        function8 = function5;
                        textStyle4 = textStyle2;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = z;
                        i20 = i;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(488158419);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1401225826);
                    jM752getColor0d7_KjU = textStyle4.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z8, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue());
                    }
                    long j = jM752getColor0d7_KjU;
                    gapComposer.end(false);
                    final TextStyle textStyleMerge = textStyle4.merge(new TextStyle(j, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1459735400, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                                final TextFieldColors textFieldColors3 = textFieldColorsColors;
                                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                                final String str2 = str;
                                final boolean z9 = z8;
                                final boolean z10 = z7;
                                final VisualTransformation visualTransformation4 = visualTransformation3;
                                final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                final Function2 function10 = function9;
                                final Function2 function11 = function8;
                                final Shape shape4 = shape3;
                                BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z9, false, textStyleMerge, keyboardOptions4, keyboardActions4, z10, i20, i19 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(1451491557, new Function3() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                        Function2 function12 = (Function2) obj3;
                                        Composer composer3 = (Composer) obj4;
                                        int iIntValue2 = ((Integer) obj5).intValue();
                                        if ((iIntValue2 & 6) == 0) {
                                            iIntValue2 |= ((GapComposer) composer3).changedInstance(function12) ? 4 : 2;
                                        }
                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                        if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                            TextFieldDefaults.INSTANCE.DecorationBox(str2, function12, z9, z10, visualTransformation4, mutableInteractionSourceImpl2, function10, function11, shape4, textFieldColors3, null, null, gapComposer3, (iIntValue2 << 3) & 112);
                                        } else {
                                            gapComposer3.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer2), (Composer) gapComposer2, 0);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    textStyle3 = textStyle4;
                    z4 = z8;
                    keyboardOptions3 = keyboardOptions4;
                    keyboardActions3 = keyboardActions4;
                    z5 = z7;
                    i15 = i20;
                    i16 = i19;
                    visualTransformation2 = visualTransformation3;
                    function4 = function9;
                    shape2 = shape3;
                    textFieldColors2 = textFieldColorsColors;
                    function6 = function8;
                } else {
                    gapComposer.skipToGroupEnd();
                    z4 = z;
                    visualTransformation2 = visualTransformation;
                    i15 = i;
                    shape2 = shape;
                    function6 = function5;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions3 = keyboardActions2;
                    z5 = z2;
                    i16 = i2;
                    textFieldColors2 = textFieldColors;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            String str2 = str;
                            Function1 function10 = function1;
                            Modifier modifier2 = modifier;
                            boolean z9 = z4;
                            TextStyle textStyle5 = textStyle3;
                            Function2 function11 = function4;
                            Function2 function12 = function6;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions5 = keyboardOptions3;
                            KeyboardActions keyboardActions5 = keyboardActions3;
                            boolean z10 = z5;
                            int i28 = i15;
                            boolean z11 = i16;
                            Shape shape4 = shape2;
                            TextFieldColors textFieldColors3 = textFieldColors2;
                            int i29 = i5;
                            ScrimKt.TextField(str2, function10, modifier2, z9, textStyle5, function11, function12, visualTransformation4, keyboardOptions5, keyboardActions5, z10, i28, z11 ? 1 : 0, shape4, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i29);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i8 = 224694 | i4;
            keyboardOptions2 = keyboardOptions;
            i10 = 131072;
            i12 = i5 & 65536;
            if (i12 != 0) {
                i13 = i8 | 1572864;
                keyboardActions2 = keyboardActions;
            } else {
                keyboardActions2 = keyboardActions;
                if (!gapComposer.changed(keyboardActions2)) {
                    i24 = 524288;
                }
                i13 = i8 | i24;
            }
            i14 = i5 & i10;
            if (i14 != 0) {
                i13 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                i13 |= gapComposer.changed(z2) ? 8388608 : 4194304;
            }
            int i28 = i13 | 838860800;
            if ((i5 & 4194304) == 0) {
                c = 128;
            } else {
                c = 128;
            }
            int i29 = 22 | c;
            if ((i7 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer.shouldExecute(i7 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i23 != 0) {
                        function4 = null;
                    }
                    if (i25 == 0) {
                    }
                    if (i9 != 0) {
                        keyboardOptions2 = KeyboardOptions.Default;
                    }
                    if (i12 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if (i14 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if (z6) {
                        i17 = 1;
                    } else {
                        i17 = Integer.MAX_VALUE;
                    }
                    value = ShapesKt.getValue(5, gapComposer);
                    i18 = i5 & 4194304;
                    viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = VisualTransformation.Companion.None;
                    if (i18 != 0) {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = TextFieldDefaults.colors(gapComposer);
                    } else {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = textFieldColors;
                    }
                } else {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i23 != 0) {
                        function4 = null;
                    }
                    if (i25 == 0) {
                    }
                    if (i9 != 0) {
                        keyboardOptions2 = KeyboardOptions.Default;
                    }
                    if (i12 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if (i14 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if (z6) {
                        i17 = 1;
                    } else {
                        i17 = Integer.MAX_VALUE;
                    }
                    value = ShapesKt.getValue(5, gapComposer);
                    i18 = i5 & 4194304;
                    viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = VisualTransformation.Companion.None;
                    if (i18 != 0) {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = TextFieldDefaults.colors(gapComposer);
                    } else {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = textFieldColors;
                    }
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(488158419);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(false);
                gapComposer.startReplaceGroup(1401225826);
                jM752getColor0d7_KjU = textStyle4.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z8, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue());
                }
                long j2 = jM752getColor0d7_KjU;
                gapComposer.end(false);
                final TextStyle textStyleMerge2 = textStyle4.merge(new TextStyle(j2, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1459735400, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                            final TextFieldColors textFieldColors3 = textFieldColorsColors;
                            SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                            final String str2 = str;
                            final boolean z9 = z8;
                            final boolean z10 = z7;
                            final VisualTransformation visualTransformation4 = visualTransformation3;
                            final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            final Function2 function10 = function9;
                            final Function2 function11 = function8;
                            final Shape shape4 = shape3;
                            BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z9, false, textStyleMerge2, keyboardOptions4, keyboardActions4, z10, i20, i19 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(1451491557, new Function3() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                    Function2 function12 = (Function2) obj3;
                                    Composer composer3 = (Composer) obj4;
                                    int iIntValue2 = ((Integer) obj5).intValue();
                                    if ((iIntValue2 & 6) == 0) {
                                        iIntValue2 |= ((GapComposer) composer3).changedInstance(function12) ? 4 : 2;
                                    }
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                        TextFieldDefaults.INSTANCE.DecorationBox(str2, function12, z9, z10, visualTransformation4, mutableInteractionSourceImpl2, function10, function11, shape4, textFieldColors3, null, null, gapComposer3, (iIntValue2 << 3) & 112);
                                    } else {
                                        gapComposer3.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer2), (Composer) gapComposer2, 0);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                textStyle3 = textStyle4;
                z4 = z8;
                keyboardOptions3 = keyboardOptions4;
                keyboardActions3 = keyboardActions4;
                z5 = z7;
                i15 = i20;
                i16 = i19;
                visualTransformation2 = visualTransformation3;
                function4 = function9;
                shape2 = shape3;
                textFieldColors2 = textFieldColorsColors;
                function6 = function8;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z;
                visualTransformation2 = visualTransformation;
                i15 = i;
                shape2 = shape;
                function6 = function5;
                textStyle3 = textStyle2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions3 = keyboardActions2;
                z5 = z2;
                i16 = i2;
                textFieldColors2 = textFieldColors;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        String str2 = str;
                        Function1 function10 = function1;
                        Modifier modifier2 = modifier;
                        boolean z9 = z4;
                        TextStyle textStyle5 = textStyle3;
                        Function2 function11 = function4;
                        Function2 function12 = function6;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions5 = keyboardOptions3;
                        KeyboardActions keyboardActions5 = keyboardActions3;
                        boolean z10 = z5;
                        int i210 = i15;
                        boolean z11 = i16;
                        Shape shape4 = shape2;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i211 = i5;
                        ScrimKt.TextField(str2, function10, modifier2, z9, textStyle5, function11, function12, visualTransformation4, keyboardOptions5, keyboardActions5, z10, i210, z11 ? 1 : 0, shape4, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i211);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i21 |= 12582912;
        function5 = function3;
        i7 = i21 | 905969664;
        i8 = i4 | 28086;
        i9 = i5 & 32768;
        if (i9 != 0) {
            keyboardOptions2 = keyboardOptions;
            if ((i4 & 196608) == 0) {
                i10 = 131072;
                if (gapComposer.changed(keyboardOptions2)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i8 |= i11;
            }
            i12 = i5 & 65536;
            if (i12 != 0) {
                i13 = i8 | 1572864;
                keyboardActions2 = keyboardActions;
            } else {
                keyboardActions2 = keyboardActions;
                if (!gapComposer.changed(keyboardActions2)) {
                    i24 = 524288;
                }
                i13 = i8 | i24;
            }
            i14 = i5 & i10;
            if (i14 != 0) {
                i13 |= 12582912;
            } else if ((i4 & 12582912) == 0) {
                i13 |= gapComposer.changed(z2) ? 8388608 : 4194304;
            }
            int i210 = i13 | 838860800;
            if ((i5 & 4194304) == 0) {
                c = 128;
            } else {
                c = 128;
            }
            int i211 = 22 | c;
            if ((i7 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer.shouldExecute(i7 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i23 != 0) {
                        function4 = null;
                    }
                    if (i25 == 0) {
                    }
                    if (i9 != 0) {
                        keyboardOptions2 = KeyboardOptions.Default;
                    }
                    if (i12 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if (i14 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if (z6) {
                        i17 = 1;
                    } else {
                        i17 = Integer.MAX_VALUE;
                    }
                    value = ShapesKt.getValue(5, gapComposer);
                    i18 = i5 & 4194304;
                    viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = VisualTransformation.Companion.None;
                    if (i18 != 0) {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = TextFieldDefaults.colors(gapComposer);
                    } else {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = textFieldColors;
                    }
                } else {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i23 != 0) {
                        function4 = null;
                    }
                    if (i25 == 0) {
                    }
                    if (i9 != 0) {
                        keyboardOptions2 = KeyboardOptions.Default;
                    }
                    if (i12 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if (i14 != 0) {
                        z6 = false;
                    } else {
                        z6 = z2;
                    }
                    if (z6) {
                        i17 = 1;
                    } else {
                        i17 = Integer.MAX_VALUE;
                    }
                    value = ShapesKt.getValue(5, gapComposer);
                    i18 = i5 & 4194304;
                    viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = VisualTransformation.Companion.None;
                    if (i18 != 0) {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = TextFieldDefaults.colors(gapComposer);
                    } else {
                        function8 = function7;
                        z7 = z6;
                        function9 = function4;
                        shape3 = value;
                        visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        keyboardOptions4 = keyboardOptions2;
                        keyboardActions4 = keyboardActions2;
                        z8 = true;
                        i19 = 1;
                        i20 = i17;
                        textFieldColorsColors = textFieldColors;
                    }
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(488158419);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(false);
                gapComposer.startReplaceGroup(1401225826);
                jM752getColor0d7_KjU = textStyle4.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z8, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue());
                }
                long j3 = jM752getColor0d7_KjU;
                gapComposer.end(false);
                final TextStyle textStyleMerge3 = textStyle4.merge(new TextStyle(j3, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1459735400, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                            final TextFieldColors textFieldColors3 = textFieldColorsColors;
                            SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                            final String str2 = str;
                            final boolean z9 = z8;
                            final boolean z10 = z7;
                            final VisualTransformation visualTransformation4 = visualTransformation3;
                            final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            final Function2 function10 = function9;
                            final Function2 function11 = function8;
                            final Shape shape4 = shape3;
                            BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z9, false, textStyleMerge3, keyboardOptions4, keyboardActions4, z10, i20, i19 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(1451491557, new Function3() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                    Function2 function12 = (Function2) obj3;
                                    Composer composer3 = (Composer) obj4;
                                    int iIntValue2 = ((Integer) obj5).intValue();
                                    if ((iIntValue2 & 6) == 0) {
                                        iIntValue2 |= ((GapComposer) composer3).changedInstance(function12) ? 4 : 2;
                                    }
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                        TextFieldDefaults.INSTANCE.DecorationBox(str2, function12, z9, z10, visualTransformation4, mutableInteractionSourceImpl2, function10, function11, shape4, textFieldColors3, null, null, gapComposer3, (iIntValue2 << 3) & 112);
                                    } else {
                                        gapComposer3.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer2), (Composer) gapComposer2, 0);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                textStyle3 = textStyle4;
                z4 = z8;
                keyboardOptions3 = keyboardOptions4;
                keyboardActions3 = keyboardActions4;
                z5 = z7;
                i15 = i20;
                i16 = i19;
                visualTransformation2 = visualTransformation3;
                function4 = function9;
                shape2 = shape3;
                textFieldColors2 = textFieldColorsColors;
                function6 = function8;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z;
                visualTransformation2 = visualTransformation;
                i15 = i;
                shape2 = shape;
                function6 = function5;
                textStyle3 = textStyle2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions3 = keyboardActions2;
                z5 = z2;
                i16 = i2;
                textFieldColors2 = textFieldColors;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        String str2 = str;
                        Function1 function10 = function1;
                        Modifier modifier2 = modifier;
                        boolean z9 = z4;
                        TextStyle textStyle5 = textStyle3;
                        Function2 function11 = function4;
                        Function2 function12 = function6;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions5 = keyboardOptions3;
                        KeyboardActions keyboardActions5 = keyboardActions3;
                        boolean z10 = z5;
                        int i212 = i15;
                        boolean z11 = i16;
                        Shape shape4 = shape2;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i213 = i5;
                        ScrimKt.TextField(str2, function10, modifier2, z9, textStyle5, function11, function12, visualTransformation4, keyboardOptions5, keyboardActions5, z10, i212, z11 ? 1 : 0, shape4, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i213);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i8 = 224694 | i4;
        keyboardOptions2 = keyboardOptions;
        i10 = 131072;
        i12 = i5 & 65536;
        if (i12 != 0) {
            i13 = i8 | 1572864;
            keyboardActions2 = keyboardActions;
        } else {
            keyboardActions2 = keyboardActions;
            if (!gapComposer.changed(keyboardActions2)) {
                i24 = 524288;
            }
            i13 = i8 | i24;
        }
        i14 = i5 & i10;
        if (i14 != 0) {
            i13 |= 12582912;
        } else if ((i4 & 12582912) == 0) {
            i13 |= gapComposer.changed(z2) ? 8388608 : 4194304;
        }
        int i212 = i13 | 838860800;
        if ((i5 & 4194304) == 0) {
            c = 128;
        } else {
            c = 128;
        }
        int i213 = 22 | c;
        if ((i7 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer.shouldExecute(i7 & 1, z3)) {
            gapComposer.startDefaults();
            if ((i3 & 1) != 0) {
                if ((i5 & 32) != 0) {
                    textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                } else {
                    textStyle4 = textStyle2;
                }
                if (i23 != 0) {
                    function4 = null;
                }
                if (i25 == 0) {
                }
                if (i9 != 0) {
                    keyboardOptions2 = KeyboardOptions.Default;
                }
                if (i12 != 0) {
                    keyboardActions2 = KeyboardActions.Default;
                }
                if (i14 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if (z6) {
                    i17 = 1;
                } else {
                    i17 = Integer.MAX_VALUE;
                }
                value = ShapesKt.getValue(5, gapComposer);
                i18 = i5 & 4194304;
                viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = VisualTransformation.Companion.None;
                if (i18 != 0) {
                    function8 = function7;
                    z7 = z6;
                    function9 = function4;
                    shape3 = value;
                    visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                    keyboardOptions4 = keyboardOptions2;
                    keyboardActions4 = keyboardActions2;
                    z8 = true;
                    i19 = 1;
                    i20 = i17;
                    textFieldColorsColors = TextFieldDefaults.colors(gapComposer);
                } else {
                    function8 = function7;
                    z7 = z6;
                    function9 = function4;
                    shape3 = value;
                    visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                    keyboardOptions4 = keyboardOptions2;
                    keyboardActions4 = keyboardActions2;
                    z8 = true;
                    i19 = 1;
                    i20 = i17;
                    textFieldColorsColors = textFieldColors;
                }
            } else {
                if ((i5 & 32) != 0) {
                    textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                } else {
                    textStyle4 = textStyle2;
                }
                if (i23 != 0) {
                    function4 = null;
                }
                if (i25 == 0) {
                }
                if (i9 != 0) {
                    keyboardOptions2 = KeyboardOptions.Default;
                }
                if (i12 != 0) {
                    keyboardActions2 = KeyboardActions.Default;
                }
                if (i14 != 0) {
                    z6 = false;
                } else {
                    z6 = z2;
                }
                if (z6) {
                    i17 = 1;
                } else {
                    i17 = Integer.MAX_VALUE;
                }
                value = ShapesKt.getValue(5, gapComposer);
                i18 = i5 & 4194304;
                viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = VisualTransformation.Companion.None;
                if (i18 != 0) {
                    function8 = function7;
                    z7 = z6;
                    function9 = function4;
                    shape3 = value;
                    visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                    keyboardOptions4 = keyboardOptions2;
                    keyboardActions4 = keyboardActions2;
                    z8 = true;
                    i19 = 1;
                    i20 = i17;
                    textFieldColorsColors = TextFieldDefaults.colors(gapComposer);
                } else {
                    function8 = function7;
                    z7 = z6;
                    function9 = function4;
                    shape3 = value;
                    visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                    keyboardOptions4 = keyboardOptions2;
                    keyboardActions4 = keyboardActions2;
                    z8 = true;
                    i19 = 1;
                    i20 = i17;
                    textFieldColorsColors = textFieldColors;
                }
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(488158419);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(1401225826);
            jM752getColor0d7_KjU = textStyle4.m752getColor0d7_KjU();
            if (jM752getColor0d7_KjU == 16) {
                jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z8, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue());
            }
            long j4 = jM752getColor0d7_KjU;
            gapComposer.end(false);
            final TextStyle textStyleMerge4 = textStyle4.merge(new TextStyle(j4, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
            Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(1459735400, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                        Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                        final TextFieldColors textFieldColors3 = textFieldColorsColors;
                        SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                        final String str2 = str;
                        final boolean z9 = z8;
                        final boolean z10 = z7;
                        final VisualTransformation visualTransformation4 = visualTransformation3;
                        final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        final Function2 function10 = function9;
                        final Function2 function11 = function8;
                        final Shape shape4 = shape3;
                        BasicTextKt.BasicTextField(str2, function1, modifierM143defaultMinSizeVpY3zN4, z9, false, textStyleMerge4, keyboardOptions4, keyboardActions4, z10, i20, i19 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(1451491557, new Function3() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                Function2 function12 = (Function2) obj3;
                                Composer composer3 = (Composer) obj4;
                                int iIntValue2 = ((Integer) obj5).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    iIntValue2 |= ((GapComposer) composer3).changedInstance(function12) ? 4 : 2;
                                }
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                    TextFieldDefaults.INSTANCE.DecorationBox(str2, function12, z9, z10, visualTransformation4, mutableInteractionSourceImpl2, function10, function11, shape4, textFieldColors3, null, null, gapComposer3, (iIntValue2 << 3) & 112);
                                } else {
                                    gapComposer3.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer2), (Composer) gapComposer2, 0);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
            textStyle3 = textStyle4;
            z4 = z8;
            keyboardOptions3 = keyboardOptions4;
            keyboardActions3 = keyboardActions4;
            z5 = z7;
            i15 = i20;
            i16 = i19;
            visualTransformation2 = visualTransformation3;
            function4 = function9;
            shape2 = shape3;
            textFieldColors2 = textFieldColorsColors;
            function6 = function8;
        } else {
            gapComposer.skipToGroupEnd();
            z4 = z;
            visualTransformation2 = visualTransformation;
            i15 = i;
            shape2 = shape;
            function6 = function5;
            textStyle3 = textStyle2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            z5 = z2;
            i16 = i2;
            textFieldColors2 = textFieldColors;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                    String str2 = str;
                    Function1 function10 = function1;
                    Modifier modifier2 = modifier;
                    boolean z9 = z4;
                    TextStyle textStyle5 = textStyle3;
                    Function2 function11 = function4;
                    Function2 function12 = function6;
                    VisualTransformation visualTransformation4 = visualTransformation2;
                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                    KeyboardActions keyboardActions5 = keyboardActions3;
                    boolean z10 = z5;
                    int i214 = i15;
                    boolean z11 = i16;
                    Shape shape4 = shape2;
                    TextFieldColors textFieldColors3 = textFieldColors2;
                    int i215 = i5;
                    ScrimKt.TextField(str2, function10, modifier2, z9, textStyle5, function11, function12, visualTransformation4, keyboardOptions5, keyboardActions5, z10, i214, z11 ? 1 : 0, shape4, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i215);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:161:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:162:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:165:0x0310  */
    /* JADX WARN: Code duplicated, block: B:169:0x0347  */
    /* JADX WARN: Code duplicated, block: B:171:0x034c  */
    /* JADX WARN: Code duplicated, block: B:173:0x0352  */
    /* JADX WARN: Code duplicated, block: B:174:0x0355  */
    /* JADX WARN: Code duplicated, block: B:176:0x035b  */
    /* JADX WARN: Code duplicated, block: B:177:0x035e  */
    /* JADX WARN: Code duplicated, block: B:179:0x0364  */
    /* JADX WARN: Code duplicated, block: B:180:0x0367  */
    /* JADX WARN: Code duplicated, block: B:183:0x0374  */
    /* JADX WARN: Code duplicated, block: B:185:0x0379  */
    /* JADX WARN: Code duplicated, block: B:187:0x037f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0382  */
    /* JADX WARN: Code duplicated, block: B:190:0x0388  */
    /* JADX WARN: Code duplicated, block: B:191:0x038b  */
    /* JADX WARN: Code duplicated, block: B:193:0x0391  */
    /* JADX WARN: Code duplicated, block: B:194:0x0394  */
    /* JADX WARN: Code duplicated, block: B:197:0x039d  */
    /* JADX WARN: Code duplicated, block: B:199:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:201:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:202:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:204:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:205:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:208:0x040b  */
    /* JADX WARN: Code duplicated, block: B:211:0x0439  */
    /* JADX WARN: Code duplicated, block: B:213:0x0445  */
    /* JADX WARN: Code duplicated, block: B:215:0x0450  */
    /* JADX INFO: renamed from: ToggleButton-EwToSPQ, reason: not valid java name */
    public static final void m323ToggleButtonEwToSPQ(final boolean z, final Function1 function1, final Modifier modifier, float f, boolean z2, final ToggleButtonShapes toggleButtonShapes, final ToggleButtonColors toggleButtonColors, ToggleButtonElevation toggleButtonElevation, final PaddingValuesImpl paddingValuesImpl, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        GapComposer gapComposer;
        final float f2;
        final boolean z3;
        final ToggleButtonElevation toggleButtonElevation2;
        float f3;
        ToggleButtonElevation toggleButtonElevation3;
        int i5;
        boolean z4;
        long j;
        long j2;
        long j3;
        ToggleButtonElevation toggleButtonElevation4;
        AnimationState animationState;
        Shape shapeRememberAnimatedShape;
        boolean z5;
        AnimateAsState animateAsStateM18animateDpAsStateAjpBEmI;
        AnimateAsState animateAsStateM17animateColorAsStateeuL9pac;
        boolean zChanged;
        Object objRememberedValue;
        BorderStroke borderStroke;
        float fM250getMinHeightD9Ej5fM;
        float f4;
        float f5;
        float f6;
        final float f7;
        float f8;
        float f9;
        boolean z6;
        TextStyle textStyle;
        Object objRememberedValue2;
        MutableInteractionSourceImpl mutableInteractionSourceImpl;
        Object objRememberedValue3;
        Shape shape = toggleButtonShapes.shape;
        Shape shape2 = toggleButtonShapes.checkedShape;
        Shape shape3 = toggleButtonShapes.pressedShape;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(465053648);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer2.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changed(modifier) ? 256 : 128;
        }
        int i6 = i3 | 224256;
        if ((1572864 & i) == 0) {
            i6 |= gapComposer2.changed(toggleButtonShapes) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            i6 |= gapComposer2.changed(toggleButtonColors) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i6 |= 33554432;
        }
        int i7 = i6 | 805306368;
        if ((i2 & 6) == 0) {
            i4 = (gapComposer2.changed(paddingValuesImpl) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i4 | 48;
        if ((i2 & 384) == 0) {
            i8 |= gapComposer2.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        if (gapComposer2.shouldExecute(i7 & 1, ((i7 & 306783379) == 306783378 && (i8 & 147) == 146) ? false : true)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                f3 = ToggleButtonDefaults.size;
                toggleButtonElevation3 = new ToggleButtonElevation();
                i5 = i7 & (-234881025);
                z4 = true;
            } else {
                gapComposer2.skipToGroupEnd();
                z4 = z2;
                toggleButtonElevation3 = toggleButtonElevation;
                i5 = i7 & (-234881025);
                f3 = f;
            }
            gapComposer2.endDefaults();
            gapComposer2.startReplaceGroup(-1150462613);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            int i9 = i5;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue4;
            gapComposer2.end(false);
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(1, gapComposer2);
            MutableState mutableStateCollectIsPressedAsState = coil3.size.SizeKt.collectIsPressedAsState(mutableInteractionSourceImpl2, gapComposer2, 0);
            if (z4 && z) {
                j = toggleButtonColors.checkedContainerColor;
            } else {
                j = (!z4 || z) ? toggleButtonColors.disabledContainerColor : toggleButtonColors.containerColor;
            }
            if (z4 && z) {
                j2 = j;
                j3 = toggleButtonColors.checkedContentColor;
            } else {
                j2 = j;
                j3 = (!z4 || z) ? toggleButtonColors.disabledContentColor : toggleButtonColors.contentColor;
            }
            if (toggleButtonElevation3 == null) {
                gapComposer2.startReplaceGroup(-1150047834);
                gapComposer2.end(false);
                f3 = f3;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl2;
                mutableStateCollectIsPressedAsState = mutableStateCollectIsPressedAsState;
                j3 = j3;
                animationState = null;
                toggleButtonElevation4 = toggleButtonElevation3;
            } else {
                gapComposer2.startReplaceGroup(239996347);
                int i10 = i9 >> 12;
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2);
                }
                SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue5;
                boolean zChanged2 = gapComposer2.changed(mutableInteractionSourceImpl2);
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new CardElevation$animateElevation$1$1(mutableInteractionSourceImpl2, snapshotStateList, null, (byte) 4);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                Stack.LaunchedEffect(gapComposer2, mutableInteractionSourceImpl2, (Function2) objRememberedValue6);
                Interaction interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
                float f10 = CropImageView.DEFAULT_ASPECT_RATIO;
                if (z4 && !(interaction instanceof PressInteraction.Press) && (interaction instanceof HoverInteraction$Enter)) {
                    f10 = 1.0f;
                }
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new Animatable(new Dp(f10), ArcSplineKt.DpToVector, (Object) null, 12);
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                Animatable animatable = (Animatable) objRememberedValue7;
                Dp dp = new Dp(f10);
                boolean zChangedInstance = gapComposer2.changedInstance(animatable) | gapComposer2.changed(f10) | (((i10 & 14) ^ 6) > 4 && gapComposer2.changed(z4)) | gapComposer2.changed(toggleButtonElevation3) | gapComposer2.changedInstance(interaction);
                Object objRememberedValue8 = gapComposer2.rememberedValue();
                if (zChangedInstance || objRememberedValue8 == neverEqualPolicy) {
                    ToggleButtonElevation toggleButtonElevation5 = toggleButtonElevation3;
                    objRememberedValue8 = new CardElevation$animateElevation$2$1(animatable, f10, z4, toggleButtonElevation5, interaction, null, (byte) 2);
                    toggleButtonElevation4 = toggleButtonElevation5;
                    gapComposer2.updateRememberedValue(objRememberedValue8);
                } else {
                    toggleButtonElevation4 = toggleButtonElevation3;
                }
                Stack.LaunchedEffect(gapComposer2, dp, (Function2) objRememberedValue8);
                animationState = animatable.internalState;
                gapComposer2.end(false);
            }
            float f11 = animationState != null ? ((Dp) animationState.value$delegate.getValue()).value : 0.0f;
            boolean zBooleanValue = ((Boolean) mutableStateCollectIsPressedAsState.getValue()).booleanValue();
            gapComposer2.startReplaceGroup(-585100128);
            if (zBooleanValue) {
                shapeRememberAnimatedShape = shape3;
            } else {
                shapeRememberAnimatedShape = z ? shape2 : shape;
            }
            if ((shape instanceof RoundedCornerShape) && (shape3 instanceof RoundedCornerShape) && (shape2 instanceof RoundedCornerShape)) {
                gapComposer2.startReplaceGroup(-1740235478);
                gapComposer2.startMovableGroup(359505585, toggleButtonShapes);
                shapeRememberAnimatedShape.getClass();
                z5 = false;
                shapeRememberAnimatedShape = Icons$Filled.rememberAnimatedShape((RoundedCornerShape) shapeRememberAnimatedShape, finiteAnimationSpecM272valueyDoVZcs, gapComposer2, 0);
            } else {
                if ((shape instanceof RoundedCornerShape) && (shape3 instanceof RoundedCornerShape) && (shape2 instanceof RoundedCornerShape)) {
                    gapComposer2.startReplaceGroup(-1740097652);
                    gapComposer2.startMovableGroup(359510031, toggleButtonShapes);
                    shapeRememberAnimatedShape.getClass();
                    z5 = false;
                    shapeRememberAnimatedShape = Icons$Filled.rememberAnimatedShape((RoundedCornerShape) shapeRememberAnimatedShape, finiteAnimationSpecM272valueyDoVZcs, gapComposer2, 0);
                } else {
                    gapComposer2.startReplaceGroup(-1740015006);
                    gapComposer2.end(false);
                    gapComposer2.end(false);
                }
                Shape shape4 = shapeRememberAnimatedShape;
                gapComposer2.startReplaceGroup(909402813);
                animateAsStateM18animateDpAsStateAjpBEmI = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(CropImageView.DEFAULT_ASPECT_RATIO, CardKt.m272valueyDoVZcs(1, gapComposer2), null, gapComposer2, 0, 12);
                animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(0L, CardKt.m272valueyDoVZcs(3, gapComposer2), null, gapComposer2, 0, 12);
                if (Dp.m795compareTo0680j_4(((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value, CropImageView.DEFAULT_ASPECT_RATIO) <= 0) {
                    gapComposer2.end(false);
                    borderStroke = null;
                } else {
                    zChanged = gapComposer2.changed(((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value) | gapComposer2.changed(((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value) | gapComposer2.changed((Object) null);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new BorderStroke(((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value, new SolidColor(((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value));
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    borderStroke = (BorderStroke) objRememberedValue;
                    gapComposer2.end(false);
                }
                PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
                fM250getMinHeightD9Ej5fM = ButtonDefaults.m250getMinHeightD9Ej5fM();
                f4 = ButtonDefaults.MediumContainerHeight;
                f5 = ButtonDefaults.LargeContainerHeight;
                f6 = ButtonDefaults.ExtraLargeContainerHeight;
                f7 = f3;
                if (Dp.m795compareTo0680j_4(f7, fM250getMinHeightD9Ej5fM) < 0) {
                    f8 = ButtonDefaults.ExtraSmallIconSize;
                } else if (Dp.m795compareTo0680j_4(f7, f4) < 0) {
                    f8 = ButtonDefaults.SmallIconSize;
                } else if (Dp.m795compareTo0680j_4(f7, f5) < 0) {
                    f8 = ButtonDefaults.MediumIconSize;
                } else if (Dp.m795compareTo0680j_4(f7, f6) < 0) {
                    f8 = ButtonDefaults.LargeIconSize;
                } else {
                    f8 = ButtonDefaults.ExtraLargeIconSize;
                }
                final float f12 = f8;
                if (Dp.m795compareTo0680j_4(f7, ButtonDefaults.m250getMinHeightD9Ej5fM()) < 0) {
                    f9 = ButtonDefaults.ExtraSmallIconSpacing;
                } else if (Dp.m795compareTo0680j_4(f7, f4) < 0) {
                    f9 = ButtonDefaults.IconSpacing;
                } else if (Dp.m795compareTo0680j_4(f7, f5) < 0) {
                    f9 = ButtonDefaults.MediumIconSpacing;
                } else if (Dp.m795compareTo0680j_4(f7, f6) < 0) {
                    f9 = ButtonDefaults.LargeIconSpacing;
                } else {
                    f9 = ButtonDefaults.ExtraLargeIconSpacing;
                }
                final float f13 = f9;
                if (Dp.m795compareTo0680j_4(f7, f4) < 0) {
                    gapComposer2.startReplaceGroup(-623485538);
                    textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge;
                    z6 = false;
                    gapComposer2.end(false);
                } else {
                    z6 = false;
                    if (Dp.m795compareTo0680j_4(f7, f5) < 0) {
                        gapComposer2.startReplaceGroup(-623483041);
                        textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
                        gapComposer2.end(false);
                    } else if (Dp.m795compareTo0680j_4(f7, f6) < 0) {
                        gapComposer2.startReplaceGroup(-623480479);
                        textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall;
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-623478591);
                        textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineLarge;
                        gapComposer2.end(false);
                    }
                }
                final TextStyle textStyle2 = textStyle;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 12);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, z6, (Function1) objRememberedValue2);
                final long j4 = j3;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1060133766, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer3 = (GapComposer) composer2;
                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j4, textStyle2, Expect_jvmKt.rememberComposableLambda(2064547490, new AlertDialogKt$$ExternalSyntheticLambda11(f7, paddingValuesImpl, f12, f13, composableLambdaImpl), gapComposer3), gapComposer3, 384);
                        } else {
                            gapComposer3.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer2);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = SurfaceKt.LocalAbsoluteTonalElevation;
                if (mutableInteractionSourceImpl2 == null) {
                    gapComposer2.startReplaceGroup(643383721);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue3;
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(-533435666);
                    gapComposer2.end(false);
                    mutableInteractionSourceImpl = mutableInteractionSourceImpl2;
                }
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = SurfaceKt.LocalAbsoluteTonalElevation;
                float f14 = ((Dp) gapComposer2.consume(staticProvidableCompositionLocal2)).value + CropImageView.DEFAULT_ASPECT_RATIO + CropImageView.DEFAULT_ASPECT_RATIO;
                ToggleButtonElevation toggleButtonElevation6 = toggleButtonElevation4;
                gapComposer = gapComposer2;
                Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(j4, ContentColorKt.LocalContentColor), staticProvidableCompositionLocal2.defaultProvidedValue$runtime(new Dp(f14))}, Expect_jvmKt.rememberComposableLambda(-1839065134, new SurfaceKt$$ExternalSyntheticLambda0(modifierSemantics, mutableInteractionSourceImpl, shape4, j2, f14, borderStroke, z, z4, function1, f11, composableLambdaImplRememberComposableLambda, (byte) 1), gapComposer), gapComposer, 56);
                toggleButtonElevation2 = toggleButtonElevation6;
                z3 = z4;
                f2 = f7;
            }
            Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z5, z5, z5);
            Shape shape5 = shapeRememberAnimatedShape;
            gapComposer2.startReplaceGroup(909402813);
            animateAsStateM18animateDpAsStateAjpBEmI = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(CropImageView.DEFAULT_ASPECT_RATIO, CardKt.m272valueyDoVZcs(1, gapComposer2), null, gapComposer2, 0, 12);
            animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(0L, CardKt.m272valueyDoVZcs(3, gapComposer2), null, gapComposer2, 0, 12);
            if (Dp.m795compareTo0680j_4(((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value, CropImageView.DEFAULT_ASPECT_RATIO) <= 0) {
                gapComposer2.end(false);
                borderStroke = null;
            } else {
                zChanged = gapComposer2.changed(((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value) | gapComposer2.changed(((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value) | gapComposer2.changed((Object) null);
                objRememberedValue = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BorderStroke(((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value, new SolidColor(((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value));
                    gapComposer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BorderStroke(((Dp) animateAsStateM18animateDpAsStateAjpBEmI.getValue()).value, new SolidColor(((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value));
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                borderStroke = (BorderStroke) objRememberedValue;
                gapComposer2.end(false);
            }
            PaddingValuesImpl paddingValuesImpl3 = ButtonDefaults.ContentPadding;
            fM250getMinHeightD9Ej5fM = ButtonDefaults.m250getMinHeightD9Ej5fM();
            f4 = ButtonDefaults.MediumContainerHeight;
            f5 = ButtonDefaults.LargeContainerHeight;
            f6 = ButtonDefaults.ExtraLargeContainerHeight;
            f7 = f3;
            if (Dp.m795compareTo0680j_4(f7, fM250getMinHeightD9Ej5fM) < 0) {
                f8 = ButtonDefaults.ExtraSmallIconSize;
            } else if (Dp.m795compareTo0680j_4(f7, f4) < 0) {
                f8 = ButtonDefaults.SmallIconSize;
            } else if (Dp.m795compareTo0680j_4(f7, f5) < 0) {
                f8 = ButtonDefaults.MediumIconSize;
            } else if (Dp.m795compareTo0680j_4(f7, f6) < 0) {
                f8 = ButtonDefaults.LargeIconSize;
            } else {
                f8 = ButtonDefaults.ExtraLargeIconSize;
            }
            final float f15 = f8;
            if (Dp.m795compareTo0680j_4(f7, ButtonDefaults.m250getMinHeightD9Ej5fM()) < 0) {
                f9 = ButtonDefaults.ExtraSmallIconSpacing;
            } else if (Dp.m795compareTo0680j_4(f7, f4) < 0) {
                f9 = ButtonDefaults.IconSpacing;
            } else if (Dp.m795compareTo0680j_4(f7, f5) < 0) {
                f9 = ButtonDefaults.MediumIconSpacing;
            } else if (Dp.m795compareTo0680j_4(f7, f6) < 0) {
                f9 = ButtonDefaults.LargeIconSpacing;
            } else {
                f9 = ButtonDefaults.ExtraLargeIconSpacing;
            }
            final float f16 = f9;
            if (Dp.m795compareTo0680j_4(f7, f4) < 0) {
                gapComposer2.startReplaceGroup(-623485538);
                textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge;
                z6 = false;
                gapComposer2.end(false);
            } else {
                z6 = false;
                if (Dp.m795compareTo0680j_4(f7, f5) < 0) {
                    gapComposer2.startReplaceGroup(-623483041);
                    textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
                    gapComposer2.end(false);
                } else if (Dp.m795compareTo0680j_4(f7, f6) < 0) {
                    gapComposer2.startReplaceGroup(-623480479);
                    textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall;
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(-623478591);
                    textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineLarge;
                    gapComposer2.end(false);
                }
            }
            final TextStyle textStyle3 = textStyle;
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 12);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifier, z6, (Function1) objRememberedValue2);
            final long j5 = j3;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-1060133766, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer3 = (GapComposer) composer2;
                    if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j5, textStyle3, Expect_jvmKt.rememberComposableLambda(2064547490, new AlertDialogKt$$ExternalSyntheticLambda11(f7, paddingValuesImpl, f15, f16, composableLambdaImpl), gapComposer3), gapComposer3, 384);
                    } else {
                        gapComposer3.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer2);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = SurfaceKt.LocalAbsoluteTonalElevation;
            if (mutableInteractionSourceImpl2 == null) {
                gapComposer2.startReplaceGroup(643383721);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue3;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-533435666);
                gapComposer2.end(false);
                mutableInteractionSourceImpl = mutableInteractionSourceImpl2;
            }
            StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = SurfaceKt.LocalAbsoluteTonalElevation;
            float f17 = ((Dp) gapComposer2.consume(staticProvidableCompositionLocal4)).value + CropImageView.DEFAULT_ASPECT_RATIO + CropImageView.DEFAULT_ASPECT_RATIO;
            ToggleButtonElevation toggleButtonElevation7 = toggleButtonElevation4;
            gapComposer = gapComposer2;
            Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(j5, ContentColorKt.LocalContentColor), staticProvidableCompositionLocal4.defaultProvidedValue$runtime(new Dp(f17))}, Expect_jvmKt.rememberComposableLambda(-1839065134, new SurfaceKt$$ExternalSyntheticLambda0(modifierSemantics2, mutableInteractionSourceImpl, shape5, j2, f17, borderStroke, z, z4, function1, f11, composableLambdaImplRememberComposableLambda2, (byte) 1), gapComposer), gapComposer, 56);
            toggleButtonElevation2 = toggleButtonElevation7;
            z3 = z4;
            f2 = f7;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            f2 = f;
            z3 = z2;
            toggleButtonElevation2 = toggleButtonElevation;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ScrimKt.m323ToggleButtonEwToSPQ(z, function1, modifier, f2, z3, toggleButtonShapes, toggleButtonColors, toggleButtonElevation2, paddingValuesImpl, composableLambdaImpl, (Composer) obj, Stack.updateChangedFlags(i | 1), Stack.updateChangedFlags(i2));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: colors-V1nXRL4, reason: not valid java name */
    public static SwitchColors m324colorsV1nXRL4(long j, long j2, long j3, GapComposer gapComposer) {
        long value = ColorSchemeKt.getValue(10, gapComposer);
        long value2 = ColorSchemeKt.getValue(38, gapComposer);
        long value3 = ColorSchemeKt.getValue(23, gapComposer);
        long value4 = ColorSchemeKt.getValue(38, gapComposer);
        long value5 = ColorSchemeKt.getValue(34, gapComposer);
        long jColor = ColorKt.Color(Color.m485getRedimpl(value5), Color.m484getGreenimpl(value5), Color.m482getBlueimpl(value5), 1.0f, Color.m483getColorSpaceimpl(value5));
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
        long jM489compositeOverOWjLjI = ColorKt.m489compositeOverOWjLjI(jColor, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface);
        long value6 = ColorSchemeKt.getValue(17, gapComposer);
        long jM489compositeOverOWjLjI2 = ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(value6), Color.m484getGreenimpl(value6), Color.m482getBlueimpl(value6), 0.12f, Color.m483getColorSpaceimpl(value6)), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface);
        long value7 = ColorSchemeKt.getValue(17, gapComposer);
        long jM489compositeOverOWjLjI3 = ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(value7), Color.m484getGreenimpl(value7), Color.m482getBlueimpl(value7), 0.38f, Color.m483getColorSpaceimpl(value7)), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface);
        long value8 = ColorSchemeKt.getValue(17, gapComposer);
        long jM489compositeOverOWjLjI4 = ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(value8), Color.m484getGreenimpl(value8), Color.m482getBlueimpl(value8), 0.38f, Color.m483getColorSpaceimpl(value8)), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface);
        long value9 = ColorSchemeKt.getValue(38, gapComposer);
        long jM489compositeOverOWjLjI5 = ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(value9), Color.m484getGreenimpl(value9), Color.m482getBlueimpl(value9), 0.12f, Color.m483getColorSpaceimpl(value9)), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface);
        long value10 = ColorSchemeKt.getValue(17, gapComposer);
        long jM489compositeOverOWjLjI6 = ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(value10), Color.m484getGreenimpl(value10), Color.m482getBlueimpl(value10), 0.12f, Color.m483getColorSpaceimpl(value10)), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface);
        long value11 = ColorSchemeKt.getValue(38, gapComposer);
        return new SwitchColors(j, j2, value, j3, value2, value3, value4, jM489compositeOverOWjLjI, jM489compositeOverOWjLjI2, jM489compositeOverOWjLjI3, jM489compositeOverOWjLjI4, jM489compositeOverOWjLjI5, jM489compositeOverOWjLjI6, ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(value11), Color.m484getGreenimpl(value11), Color.m482getBlueimpl(value11), 0.38f, Color.m483getColorSpaceimpl(value11)), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surface));
    }

    public static final int defaultTimePickerLayoutType(Composer composer) {
        Configuration configuration = (Configuration) ((GapComposer) composer).consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
        return configuration.screenHeightDp < configuration.screenWidthDp ? 0 : 1;
    }

    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(Function1 function1, GapComposer gapComposer) {
        Object[] objArr = new Object[0];
        CallbackWrapper callbackWrapper = new CallbackWrapper(new ScrollState$$ExternalSyntheticLambda3((byte) 19), new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 9), (byte) 7);
        boolean zChanged = gapComposer.changed(SwipeToDismissBoxValue.Settled.ordinal());
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new ParserDslKt$$ExternalSyntheticLambda0(function1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (SwipeToDismissBoxState) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue, (Composer) gapComposer, 0);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0165  */
    /* JADX WARN: Code duplicated, block: B:104:0x0182  */
    /* JADX WARN: Code duplicated, block: B:106:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:109:0x0203  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x006e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0071  */
    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:46:0x009f  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:78:0x0106  */
    /* JADX WARN: Code duplicated, block: B:80:0x010d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0123  */
    /* JADX WARN: Code duplicated, block: B:86:0x0127  */
    /* JADX WARN: Code duplicated, block: B:87:0x0130  */
    /* JADX WARN: Code duplicated, block: B:89:0x0133  */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Code duplicated, block: B:93:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x013d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0140  */
    /* JADX WARN: Code duplicated, block: B:96:0x0144  */
    public static final void TextField(final TextFieldValue textFieldValue, final Function1 function1, final Modifier modifier, boolean z, TextStyle textStyle, final Function2 function2, VisualTransformation visualTransformation, final KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, final boolean z2, int i, int i2, Shape shape, final TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        final Function1 function3;
        TextStyle textStyle2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        KeyboardActions keyboardActions2;
        int i11;
        int i12;
        int i13;
        char c;
        boolean z3;
        GapComposer gapComposer;
        final boolean z4;
        final VisualTransformation visualTransformation2;
        final int i14;
        final TextStyle textStyle3;
        final KeyboardActions keyboardActions3;
        final int i15;
        final Shape shape2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        TextStyle textStyle4;
        KeyboardActions keyboardActions4;
        int i16;
        final KeyboardActions keyboardActions5;
        final Shape value;
        final VisualTransformation visualTransformation3;
        final int i17;
        TextStyle textStyle5;
        final int i18;
        boolean z5;
        Object objRememberedValue;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl;
        long jM752getColor0d7_KjU;
        int i19;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1126989771);
        int i20 = i3 | (gapComposer2.changed(textFieldValue) ? 4 : 2);
        if ((i3 & 48) == 0) {
            function3 = function1;
            i20 |= gapComposer2.changedInstance(function3) ? 32 : 16;
        } else {
            function3 = function1;
        }
        int i21 = i20 | (gapComposer2.changed(modifier) ? 256 : 128) | 27648;
        if ((i5 & 32) == 0) {
            textStyle2 = textStyle;
            if (gapComposer2.changed(textStyle2)) {
                i6 = 131072;
            }
            i7 = i21 | i6 | 1572864;
            if ((i3 & 12582912) != 0) {
                if (gapComposer2.changedInstance(function2)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i7 |= i19;
            }
            i8 = i7 | 905969664;
            i9 = i4 | 28086;
            if ((i4 & 196608) == 0) {
                i9 |= gapComposer2.changed(keyboardOptions) ? 131072 : 65536;
            }
            i10 = i5 & 65536;
            if (i10 != 0) {
                i12 = i9 | 1572864;
                keyboardActions2 = keyboardActions;
            } else {
                keyboardActions2 = keyboardActions;
                if (gapComposer2.changed(keyboardActions2)) {
                    i11 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i11 = 524288;
                }
                i12 = i9 | i11;
            }
            if ((i4 & 12582912) == 0) {
                i12 |= gapComposer2.changed(z2) ? 8388608 : 4194304;
            }
            if ((i5 & 262144) == 0) {
                i13 = i;
                int i22 = gapComposer2.changed(i13) ? 67108864 : 33554432;
                int i23 = i12 | i22 | 805306368;
                if (gapComposer2.changed(textFieldColors)) {
                    c = 256;
                } else {
                    c = 128;
                }
                int i24 = 22 | c;
                if ((i8 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i24 & 147) == 146) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (gapComposer2.shouldExecute(i8 & 1, z3)) {
                    gapComposer2.startDefaults();
                    if ((i3 & 1) == 0 && !gapComposer2.getDefaultsInvalid()) {
                        gapComposer2.skipToGroupEnd();
                        z5 = z;
                        visualTransformation3 = visualTransformation;
                        value = shape;
                        textStyle5 = textStyle2;
                        keyboardActions5 = keyboardActions2;
                        i18 = i13;
                        i17 = i2;
                    } else {
                        if ((i5 & 32) != 0) {
                            textStyle4 = (TextStyle) gapComposer2.consume(TextKt.LocalTextStyle);
                        } else {
                            textStyle4 = textStyle2;
                        }
                        if (i10 != 0) {
                            keyboardActions4 = KeyboardActions.Default;
                        } else {
                            keyboardActions4 = keyboardActions2;
                        }
                        if ((i5 & 262144) == 0) {
                            i16 = i13;
                        } else if (z2) {
                            i16 = 1;
                        } else {
                            i16 = Integer.MAX_VALUE;
                        }
                        keyboardActions5 = keyboardActions4;
                        value = ShapesKt.getValue(5, gapComposer2);
                        visualTransformation3 = VisualTransformation.Companion.None;
                        i17 = 1;
                        textStyle5 = textStyle4;
                        i18 = i16;
                        z5 = true;
                    }
                    gapComposer2.endDefaults();
                    gapComposer2.startReplaceGroup(-391753178);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer2.end(false);
                    gapComposer2.startReplaceGroup(-705368401);
                    jM752getColor0d7_KjU = textStyle5.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU == 16) {
                        jM752getColor0d7_KjU = textFieldColors.m346textColorXeAY9LY(z5, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer2, 0).getValue()).booleanValue());
                    }
                    long j = jM752getColor0d7_KjU;
                    gapComposer2.end(false);
                    final TextStyle textStyleMerge = textStyle5.merge(new TextStyle(j, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                    final boolean z6 = z5;
                    TextStyle textStyle6 = textStyle5;
                    gapComposer = gapComposer2;
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(-306109195, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            GapComposer gapComposer3 = (GapComposer) composer2;
                            if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer3);
                                Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                                TextFieldColors textFieldColors2 = textFieldColors;
                                SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor);
                                TextFieldValue textFieldValue2 = textFieldValue;
                                boolean z7 = z6;
                                boolean z8 = z2;
                                VisualTransformation visualTransformation4 = visualTransformation3;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                BasicTextKt.BasicTextField(textFieldValue2, function3, modifierM143defaultMinSizeVpY3zN4, z7, textStyleMerge, keyboardOptions, keyboardActions5, z8, i18, i17 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-609710734, new TextFieldKt$$ExternalSyntheticLambda2(textFieldValue2, z7, z8, visualTransformation4, mutableInteractionSourceImpl2, function2, value, textFieldColors2), gapComposer3), gapComposer3, 0, 4096);
                            } else {
                                gapComposer3.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    z4 = z6;
                    keyboardActions3 = keyboardActions5;
                    visualTransformation2 = visualTransformation3;
                    shape2 = value;
                    textStyle3 = textStyle6;
                    i14 = i17;
                    i15 = i18;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z4 = z;
                    visualTransformation2 = visualTransformation;
                    i14 = i2;
                    textStyle3 = textStyle2;
                    keyboardActions3 = keyboardActions2;
                    i15 = i13;
                    shape2 = shape;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                            TextFieldValue textFieldValue2 = textFieldValue;
                            Function1 function4 = function1;
                            Modifier modifier2 = modifier;
                            boolean z7 = z4;
                            TextStyle textStyle7 = textStyle3;
                            Function2 function5 = function2;
                            VisualTransformation visualTransformation4 = visualTransformation2;
                            KeyboardOptions keyboardOptions2 = keyboardOptions;
                            KeyboardActions keyboardActions6 = keyboardActions3;
                            boolean z8 = z2;
                            int i25 = i15;
                            boolean z9 = i14;
                            Shape shape3 = shape2;
                            TextFieldColors textFieldColors2 = textFieldColors;
                            int i26 = i5;
                            ScrimKt.TextField(textFieldValue2, function4, modifier2, z7, textStyle7, function5, visualTransformation4, keyboardOptions2, keyboardActions6, z8, i25, z9 ? 1 : 0, shape3, textFieldColors2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i26);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i13 = i;
            int i25 = i12 | i22 | 805306368;
            if (gapComposer2.changed(textFieldColors)) {
                c = 256;
            } else {
                c = 128;
            }
            int i26 = 22 | c;
            if ((i8 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer2.shouldExecute(i8 & 1, z3)) {
                gapComposer2.startDefaults();
                if ((i3 & 1) == 0) {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer2.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i10 != 0) {
                        keyboardActions4 = KeyboardActions.Default;
                    } else {
                        keyboardActions4 = keyboardActions2;
                    }
                    if ((i5 & 262144) == 0) {
                        i16 = i13;
                    } else if (z2) {
                        i16 = 1;
                    } else {
                        i16 = Integer.MAX_VALUE;
                    }
                    keyboardActions5 = keyboardActions4;
                    value = ShapesKt.getValue(5, gapComposer2);
                    visualTransformation3 = VisualTransformation.Companion.None;
                    i17 = 1;
                    textStyle5 = textStyle4;
                    i18 = i16;
                    z5 = true;
                } else {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer2.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i10 != 0) {
                        keyboardActions4 = KeyboardActions.Default;
                    } else {
                        keyboardActions4 = keyboardActions2;
                    }
                    if ((i5 & 262144) == 0) {
                        i16 = i13;
                    } else if (z2) {
                        i16 = 1;
                    } else {
                        i16 = Integer.MAX_VALUE;
                    }
                    keyboardActions5 = keyboardActions4;
                    value = ShapesKt.getValue(5, gapComposer2);
                    visualTransformation3 = VisualTransformation.Companion.None;
                    i17 = 1;
                    textStyle5 = textStyle4;
                    i18 = i16;
                    z5 = true;
                }
                gapComposer2.endDefaults();
                gapComposer2.startReplaceGroup(-391753178);
                objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(-705368401);
                jM752getColor0d7_KjU = textStyle5.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColors.m346textColorXeAY9LY(z5, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer2, 0).getValue()).booleanValue());
                }
                long j2 = jM752getColor0d7_KjU;
                gapComposer2.end(false);
                final TextStyle textStyleMerge2 = textStyle5.merge(new TextStyle(j2, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                final boolean z7 = z5;
                TextStyle textStyle7 = textStyle5;
                gapComposer = gapComposer2;
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(-306109195, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer3 = (GapComposer) composer2;
                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer3);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                            TextFieldColors textFieldColors2 = textFieldColors;
                            SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor);
                            TextFieldValue textFieldValue2 = textFieldValue;
                            boolean z8 = z7;
                            boolean z9 = z2;
                            VisualTransformation visualTransformation4 = visualTransformation3;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            BasicTextKt.BasicTextField(textFieldValue2, function3, modifierM143defaultMinSizeVpY3zN4, z8, textStyleMerge2, keyboardOptions, keyboardActions5, z9, i18, i17 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-609710734, new TextFieldKt$$ExternalSyntheticLambda2(textFieldValue2, z8, z9, visualTransformation4, mutableInteractionSourceImpl2, function2, value, textFieldColors2), gapComposer3), gapComposer3, 0, 4096);
                        } else {
                            gapComposer3.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                z4 = z7;
                keyboardActions3 = keyboardActions5;
                visualTransformation2 = visualTransformation3;
                shape2 = value;
                textStyle3 = textStyle7;
                i14 = i17;
                i15 = i18;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z4 = z;
                visualTransformation2 = visualTransformation;
                i14 = i2;
                textStyle3 = textStyle2;
                keyboardActions3 = keyboardActions2;
                i15 = i13;
                shape2 = shape;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        TextFieldValue textFieldValue2 = textFieldValue;
                        Function1 function4 = function1;
                        Modifier modifier2 = modifier;
                        boolean z8 = z4;
                        TextStyle textStyle8 = textStyle3;
                        Function2 function5 = function2;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions2 = keyboardOptions;
                        KeyboardActions keyboardActions6 = keyboardActions3;
                        boolean z9 = z2;
                        int i27 = i15;
                        boolean z10 = i14;
                        Shape shape3 = shape2;
                        TextFieldColors textFieldColors2 = textFieldColors;
                        int i28 = i5;
                        ScrimKt.TextField(textFieldValue2, function4, modifier2, z8, textStyle8, function5, visualTransformation4, keyboardOptions2, keyboardActions6, z9, i27, z10 ? 1 : 0, shape3, textFieldColors2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i28);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        textStyle2 = textStyle;
        i6 = 65536;
        i7 = i21 | i6 | 1572864;
        if ((i3 & 12582912) != 0) {
            if (gapComposer2.changedInstance(function2)) {
                i19 = 8388608;
            } else {
                i19 = 4194304;
            }
            i7 |= i19;
        }
        i8 = i7 | 905969664;
        i9 = i4 | 28086;
        if ((i4 & 196608) == 0) {
            i9 |= gapComposer2.changed(keyboardOptions) ? 131072 : 65536;
        }
        i10 = i5 & 65536;
        if (i10 != 0) {
            i12 = i9 | 1572864;
            keyboardActions2 = keyboardActions;
        } else {
            keyboardActions2 = keyboardActions;
            if (gapComposer2.changed(keyboardActions2)) {
                i11 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i11 = 524288;
            }
            i12 = i9 | i11;
        }
        if ((i4 & 12582912) == 0) {
            i12 |= gapComposer2.changed(z2) ? 8388608 : 4194304;
        }
        if ((i5 & 262144) == 0) {
            i13 = i;
            if (gapComposer2.changed(i13)) {
            }
            int i27 = i12 | i22 | 805306368;
            if (gapComposer2.changed(textFieldColors)) {
                c = 256;
            } else {
                c = 128;
            }
            int i28 = 22 | c;
            if ((i8 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer2.shouldExecute(i8 & 1, z3)) {
                gapComposer2.startDefaults();
                if ((i3 & 1) == 0) {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer2.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i10 != 0) {
                        keyboardActions4 = KeyboardActions.Default;
                    } else {
                        keyboardActions4 = keyboardActions2;
                    }
                    if ((i5 & 262144) == 0) {
                        i16 = i13;
                    } else if (z2) {
                        i16 = 1;
                    } else {
                        i16 = Integer.MAX_VALUE;
                    }
                    keyboardActions5 = keyboardActions4;
                    value = ShapesKt.getValue(5, gapComposer2);
                    visualTransformation3 = VisualTransformation.Companion.None;
                    i17 = 1;
                    textStyle5 = textStyle4;
                    i18 = i16;
                    z5 = true;
                } else {
                    if ((i5 & 32) != 0) {
                        textStyle4 = (TextStyle) gapComposer2.consume(TextKt.LocalTextStyle);
                    } else {
                        textStyle4 = textStyle2;
                    }
                    if (i10 != 0) {
                        keyboardActions4 = KeyboardActions.Default;
                    } else {
                        keyboardActions4 = keyboardActions2;
                    }
                    if ((i5 & 262144) == 0) {
                        i16 = i13;
                    } else if (z2) {
                        i16 = 1;
                    } else {
                        i16 = Integer.MAX_VALUE;
                    }
                    keyboardActions5 = keyboardActions4;
                    value = ShapesKt.getValue(5, gapComposer2);
                    visualTransformation3 = VisualTransformation.Companion.None;
                    i17 = 1;
                    textStyle5 = textStyle4;
                    i18 = i16;
                    z5 = true;
                }
                gapComposer2.endDefaults();
                gapComposer2.startReplaceGroup(-391753178);
                objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(-705368401);
                jM752getColor0d7_KjU = textStyle5.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColors.m346textColorXeAY9LY(z5, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer2, 0).getValue()).booleanValue());
                }
                long j3 = jM752getColor0d7_KjU;
                gapComposer2.end(false);
                final TextStyle textStyleMerge3 = textStyle5.merge(new TextStyle(j3, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                final boolean z8 = z5;
                TextStyle textStyle8 = textStyle5;
                gapComposer = gapComposer2;
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(-306109195, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer3 = (GapComposer) composer2;
                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer3);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                            TextFieldColors textFieldColors2 = textFieldColors;
                            SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor);
                            TextFieldValue textFieldValue2 = textFieldValue;
                            boolean z9 = z8;
                            boolean z10 = z2;
                            VisualTransformation visualTransformation4 = visualTransformation3;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            BasicTextKt.BasicTextField(textFieldValue2, function3, modifierM143defaultMinSizeVpY3zN4, z9, textStyleMerge3, keyboardOptions, keyboardActions5, z10, i18, i17 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-609710734, new TextFieldKt$$ExternalSyntheticLambda2(textFieldValue2, z9, z10, visualTransformation4, mutableInteractionSourceImpl2, function2, value, textFieldColors2), gapComposer3), gapComposer3, 0, 4096);
                        } else {
                            gapComposer3.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                z4 = z8;
                keyboardActions3 = keyboardActions5;
                visualTransformation2 = visualTransformation3;
                shape2 = value;
                textStyle3 = textStyle8;
                i14 = i17;
                i15 = i18;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z4 = z;
                visualTransformation2 = visualTransformation;
                i14 = i2;
                textStyle3 = textStyle2;
                keyboardActions3 = keyboardActions2;
                i15 = i13;
                shape2 = shape;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        TextFieldValue textFieldValue2 = textFieldValue;
                        Function1 function4 = function1;
                        Modifier modifier2 = modifier;
                        boolean z9 = z4;
                        TextStyle textStyle9 = textStyle3;
                        Function2 function5 = function2;
                        VisualTransformation visualTransformation4 = visualTransformation2;
                        KeyboardOptions keyboardOptions2 = keyboardOptions;
                        KeyboardActions keyboardActions6 = keyboardActions3;
                        boolean z10 = z2;
                        int i29 = i15;
                        boolean z11 = i14;
                        Shape shape3 = shape2;
                        TextFieldColors textFieldColors2 = textFieldColors;
                        int i210 = i5;
                        ScrimKt.TextField(textFieldValue2, function4, modifier2, z9, textStyle9, function5, visualTransformation4, keyboardOptions2, keyboardActions6, z10, i29, z11 ? 1 : 0, shape3, textFieldColors2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i210);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i13 = i;
        int i29 = i12 | i22 | 805306368;
        if (gapComposer2.changed(textFieldColors)) {
            c = 256;
        } else {
            c = 128;
        }
        int i210 = 22 | c;
        if ((i8 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer2.shouldExecute(i8 & 1, z3)) {
            gapComposer2.startDefaults();
            if ((i3 & 1) == 0) {
                if ((i5 & 32) != 0) {
                    textStyle4 = (TextStyle) gapComposer2.consume(TextKt.LocalTextStyle);
                } else {
                    textStyle4 = textStyle2;
                }
                if (i10 != 0) {
                    keyboardActions4 = KeyboardActions.Default;
                } else {
                    keyboardActions4 = keyboardActions2;
                }
                if ((i5 & 262144) == 0) {
                    i16 = i13;
                } else if (z2) {
                    i16 = 1;
                } else {
                    i16 = Integer.MAX_VALUE;
                }
                keyboardActions5 = keyboardActions4;
                value = ShapesKt.getValue(5, gapComposer2);
                visualTransformation3 = VisualTransformation.Companion.None;
                i17 = 1;
                textStyle5 = textStyle4;
                i18 = i16;
                z5 = true;
            } else {
                if ((i5 & 32) != 0) {
                    textStyle4 = (TextStyle) gapComposer2.consume(TextKt.LocalTextStyle);
                } else {
                    textStyle4 = textStyle2;
                }
                if (i10 != 0) {
                    keyboardActions4 = KeyboardActions.Default;
                } else {
                    keyboardActions4 = keyboardActions2;
                }
                if ((i5 & 262144) == 0) {
                    i16 = i13;
                } else if (z2) {
                    i16 = 1;
                } else {
                    i16 = Integer.MAX_VALUE;
                }
                keyboardActions5 = keyboardActions4;
                value = ShapesKt.getValue(5, gapComposer2);
                visualTransformation3 = VisualTransformation.Companion.None;
                i17 = 1;
                textStyle5 = textStyle4;
                i18 = i16;
                z5 = true;
            }
            gapComposer2.endDefaults();
            gapComposer2.startReplaceGroup(-391753178);
            objRememberedValue = gapComposer2.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
            }
            mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(-705368401);
            jM752getColor0d7_KjU = textStyle5.m752getColor0d7_KjU();
            if (jM752getColor0d7_KjU == 16) {
                jM752getColor0d7_KjU = textFieldColors.m346textColorXeAY9LY(z5, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer2, 0).getValue()).booleanValue());
            }
            long j4 = jM752getColor0d7_KjU;
            gapComposer2.end(false);
            final TextStyle textStyleMerge4 = textStyle5.merge(new TextStyle(j4, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
            final boolean z9 = z5;
            TextStyle textStyle9 = textStyle5;
            gapComposer = gapComposer2;
            Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(-306109195, new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer3 = (GapComposer) composer2;
                    if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer3);
                        Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifier, 280.0f, 56.0f);
                        TextFieldColors textFieldColors2 = textFieldColors;
                        SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor);
                        TextFieldValue textFieldValue2 = textFieldValue;
                        boolean z10 = z9;
                        boolean z11 = z2;
                        VisualTransformation visualTransformation4 = visualTransformation3;
                        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        BasicTextKt.BasicTextField(textFieldValue2, function3, modifierM143defaultMinSizeVpY3zN4, z10, textStyleMerge4, keyboardOptions, keyboardActions5, z11, i18, i17 ? 1 : 0, visualTransformation4, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(-609710734, new TextFieldKt$$ExternalSyntheticLambda2(textFieldValue2, z10, z11, visualTransformation4, mutableInteractionSourceImpl2, function2, value, textFieldColors2), gapComposer3), gapComposer3, 0, 4096);
                    } else {
                        gapComposer3.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
            z4 = z9;
            keyboardActions3 = keyboardActions5;
            visualTransformation2 = visualTransformation3;
            shape2 = value;
            textStyle3 = textStyle9;
            i14 = i17;
            i15 = i18;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            z4 = z;
            visualTransformation2 = visualTransformation;
            i14 = i2;
            textStyle3 = textStyle2;
            keyboardActions3 = keyboardActions2;
            i15 = i13;
            shape2 = shape;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                    TextFieldValue textFieldValue2 = textFieldValue;
                    Function1 function4 = function1;
                    Modifier modifier2 = modifier;
                    boolean z10 = z4;
                    TextStyle textStyle10 = textStyle3;
                    Function2 function5 = function2;
                    VisualTransformation visualTransformation4 = visualTransformation2;
                    KeyboardOptions keyboardOptions2 = keyboardOptions;
                    KeyboardActions keyboardActions6 = keyboardActions3;
                    boolean z11 = z2;
                    int i211 = i15;
                    boolean z12 = i14;
                    Shape shape3 = shape2;
                    TextFieldColors textFieldColors2 = textFieldColors;
                    int i212 = i5;
                    ScrimKt.TextField(textFieldValue2, function4, modifier2, z10, textStyle10, function5, visualTransformation4, keyboardOptions2, keyboardActions6, z11, i211, z12 ? 1 : 0, shape3, textFieldColors2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i212);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x015b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0165  */
    /* JADX WARN: Code duplicated, block: B:111:0x0190 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x0192  */
    /* JADX WARN: Code duplicated, block: B:115:0x0199  */
    /* JADX WARN: Code duplicated, block: B:118:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:122:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:125:0x01af  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:131:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:133:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:137:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:143:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:146:0x0219  */
    /* JADX WARN: Code duplicated, block: B:150:0x0235  */
    /* JADX WARN: Code duplicated, block: B:152:0x029d  */
    /* JADX WARN: Code duplicated, block: B:155:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x006c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0072  */
    /* JADX WARN: Code duplicated, block: B:33:0x0075  */
    /* JADX WARN: Code duplicated, block: B:37:0x0081  */
    /* JADX WARN: Code duplicated, block: B:38:0x0086  */
    /* JADX WARN: Code duplicated, block: B:40:0x008c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0092  */
    /* JADX WARN: Code duplicated, block: B:43:0x0095  */
    /* JADX WARN: Code duplicated, block: B:47:0x009f  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:78:0x0104  */
    /* JADX WARN: Code duplicated, block: B:80:0x010c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0125  */
    /* JADX WARN: Code duplicated, block: B:93:0x0139  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void OutlinedTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, TextStyle textStyle, Function2 function2, Function2 function3, Function2 function4, Function2 function5, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, final boolean z2, int i, int i2, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        final Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        int i8;
        final Function2 function6;
        int i9;
        int i10;
        final Function2 function7;
        int i11;
        int i12;
        final Function2 function8;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        char c;
        int i21;
        int i22;
        boolean z3;
        final boolean z4;
        final Function2 function9;
        final KeyboardOptions keyboardOptions2;
        final int i23;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final Function2 function10;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function2 function11;
        final VisualTransformation visualTransformation2;
        final KeyboardActions keyboardActions2;
        final int i24;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        final Function2 function12;
        KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final int i25;
        final Shape value;
        int i26;
        final boolean z5;
        final int i27;
        final TextFieldColors textFieldColorsColors;
        final KeyboardOptions keyboardOptions4;
        final ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
        Object objRememberedValue;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl;
        long jM752getColor0d7_KjU;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2057288437);
        int i28 = i3 | (gapComposer.changed(textFieldValue) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16);
        int i29 = i5 & 4;
        if (i29 != 0) {
            i6 = i28 | 384;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            i6 = i28 | (gapComposer.changed(modifier2) ? 256 : 128);
        }
        int i30 = i6 | 27648;
        if ((i5 & 32) == 0) {
            textStyle2 = textStyle;
            int i31 = gapComposer.changed(textStyle2) ? 131072 : 65536;
            i7 = i30 | i31;
            i8 = i5 & 64;
            if (i8 != 0) {
                i7 |= 1572864;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i3 & 1572864) == 0) {
                    if (gapComposer.changedInstance(function6)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i7 |= i9;
                }
            }
            i10 = i5 & 128;
            if (i10 != 0) {
                i7 |= 12582912;
                function7 = function3;
            } else {
                function7 = function3;
                if ((i3 & 12582912) == 0) {
                    if (gapComposer.changedInstance(function7)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i7 |= i11;
                }
            }
            i12 = i5 & 256;
            if (i12 != 0) {
                i7 |= 100663296;
                function8 = function4;
            } else {
                function8 = function4;
                if ((i3 & 100663296) == 0) {
                    if (gapComposer.changedInstance(function8)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i7 |= i13;
                }
            }
            i14 = i5 & 512;
            if (i14 != 0) {
                i7 |= 805306368;
            } else if ((i3 & 805306368) == 0) {
                if (gapComposer.changedInstance(function5)) {
                    i15 = 536870912;
                } else {
                    i15 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i7 |= i15;
            }
            i16 = i4 | 28086;
            i17 = i5 & 32768;
            if (i17 != 0) {
                i16 = 12807606;
            } else if ((i4 & 196608) == 0) {
                if (gapComposer.changed(keyboardOptions)) {
                    i18 = 131072;
                } else {
                    i18 = 65536;
                }
                i16 |= i18;
            }
            i19 = i5 & 65536;
            if (i19 != 0) {
                i20 = i16 | 1572864;
            } else {
                i20 = i16 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
            }
            int i32 = i20 | 838860800;
            if ((i5 & 2097152) == 0 || !gapComposer.changed(shape)) {
                c = 16;
            } else {
                c = ' ';
            }
            int i33 = 6 | c;
            if ((i5 & 4194304) == 0 || !gapComposer.changed(textFieldColors)) {
                i21 = 128;
            } else {
                i21 = 256;
            }
            int i34 = i33 | i21;
            i22 = i7;
            if ((i7 & 306783379) != 306783378 && (i32 & 306783379) == 306783378 && (i34 & 147) == 146) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (gapComposer.shouldExecute(i22 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i3 & 1) == 0 && !gapComposer.getDefaultsInvalid()) {
                    gapComposer.skipToGroupEnd();
                    function12 = function5;
                    viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = visualTransformation;
                    i25 = i;
                    i27 = i2;
                    value = shape;
                    textFieldColorsColors = textFieldColors;
                    function7 = function7;
                    modifier2 = modifier2;
                    textStyle2 = textStyle2;
                    function8 = function8;
                    z5 = z;
                    keyboardOptions4 = keyboardOptions;
                    keyboardActions3 = keyboardActions;
                } else {
                    if (i29 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if ((i5 & 32) != 0) {
                        textStyle2 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    }
                    if (i8 != 0) {
                        function6 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    }
                    if (i12 != 0) {
                        function8 = null;
                    }
                    function12 = i14 == 0 ? function5 : null;
                    if (i17 != 0) {
                        keyboardOptions3 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i19 != 0) {
                        keyboardActions3 = KeyboardActions.Default;
                    } else {
                        keyboardActions3 = keyboardActions;
                    }
                    if (z2) {
                        i25 = 1;
                    } else {
                        i25 = Integer.MAX_VALUE;
                    }
                    if ((i5 & 2097152) != 0) {
                        value = ShapesKt.getValue(4, gapComposer);
                    } else {
                        value = shape;
                    }
                    i26 = i5 & 4194304;
                    ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda1 = VisualTransformation.Companion.None;
                    if (i26 != 0) {
                        z5 = true;
                        i27 = 1;
                        textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                    } else {
                        z5 = true;
                        i27 = 1;
                        textFieldColorsColors = textFieldColors;
                    }
                    keyboardOptions4 = keyboardOptions3;
                    viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda1;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(-502301594);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(false);
                gapComposer.startReplaceGroup(1369275503);
                jM752getColor0d7_KjU = textStyle2.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z5, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue());
                }
                long j = jM752getColor0d7_KjU;
                gapComposer.end(false);
                final TextStyle textStyleMerge = textStyle2.merge(new TextStyle(j, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(-2094276683, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Composer composer2 = (Composer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            final Function2 function13 = function6;
                            Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                            if (function13 != null) {
                                gapComposer2.startReplaceGroup(-2119688641);
                                Object objRememberedValue2 = gapComposer2.rememberedValue();
                                if (objRememberedValue2 == Composer.Companion.Empty) {
                                    objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                    gapComposer2.updateRememberedValue(objRememberedValue2);
                                }
                                modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-2119398202);
                                gapComposer2.end(false);
                            }
                            Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                            Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                            Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                            final TextFieldColors textFieldColors3 = textFieldColorsColors;
                            SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                            final TextFieldValue textFieldValue2 = textFieldValue;
                            final boolean z6 = z5;
                            final boolean z7 = z2;
                            final VisualTransformation visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                            final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            final Function2 function14 = function7;
                            final Function2 function15 = function8;
                            final Function2 function16 = function12;
                            final Shape shape3 = value;
                            BasicTextKt.BasicTextField(textFieldValue2, function1, modifierM143defaultMinSizeVpY3zN4, z6, textStyleMerge, keyboardOptions4, keyboardActions3, z7, i25, i27 ? 1 : 0, visualTransformation3, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(674541106, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                 */
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                    Function2 function17 = (Function2) obj3;
                                    Composer composer3 = (Composer) obj4;
                                    int iIntValue2 = ((Integer) obj5).intValue();
                                    if ((iIntValue2 & 6) == 0) {
                                        iIntValue2 |= ((GapComposer) composer3).changedInstance(function17) ? 4 : 2;
                                    }
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE$3;
                                        String str = textFieldValue2.annotatedString.text;
                                        boolean z8 = z6;
                                        MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                                        TextFieldColors textFieldColors4 = textFieldColors3;
                                        textFieldDefaults.DecorationBox(str, function17, z8, z7, visualTransformation3, mutableInteractionSourceImpl3, function13, function14, function15, function16, null, textFieldColors4, null, Expect_jvmKt.rememberComposableLambda(1409265477, new OutlinedTextFieldKt$$ExternalSyntheticLambda6(z8, mutableInteractionSourceImpl3, textFieldColors4, shape3, (byte) 0), gapComposer3), gapComposer3, (iIntValue2 << 3) & 112);
                                    } else {
                                        gapComposer3.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer2), gapComposer2, 0, 4096);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                modifier3 = modifier2;
                z4 = z5;
                keyboardOptions2 = keyboardOptions4;
                keyboardActions2 = keyboardActions3;
                i24 = i25;
                i23 = i27;
                visualTransformation2 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                function11 = function8;
                function9 = function12;
                shape2 = value;
                textStyle3 = textStyle2;
                textFieldColors2 = textFieldColorsColors;
                function10 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z;
                function9 = function5;
                keyboardOptions2 = keyboardOptions;
                i23 = i2;
                shape2 = shape;
                textFieldColors2 = textFieldColors;
                function10 = function7;
                modifier3 = modifier2;
                textStyle3 = textStyle2;
                function11 = function8;
                visualTransformation2 = visualTransformation;
                keyboardActions2 = keyboardActions;
                i24 = i;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                        TextFieldValue textFieldValue2 = textFieldValue;
                        Function1 function13 = function1;
                        Modifier modifier4 = modifier3;
                        boolean z6 = z4;
                        TextStyle textStyle4 = textStyle3;
                        Function2 function14 = function6;
                        Function2 function15 = function10;
                        Function2 function16 = function11;
                        Function2 function17 = function9;
                        VisualTransformation visualTransformation3 = visualTransformation2;
                        KeyboardOptions keyboardOptions5 = keyboardOptions2;
                        KeyboardActions keyboardActions4 = keyboardActions2;
                        boolean z7 = z2;
                        int i35 = i24;
                        boolean z8 = i23;
                        Shape shape3 = shape2;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        int i36 = i5;
                        ScrimKt.OutlinedTextField(textFieldValue2, function13, modifier4, z6, textStyle4, function14, function15, function16, function17, visualTransformation3, keyboardOptions5, keyboardActions4, z7, i35, z8 ? 1 : 0, shape3, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i36);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        textStyle2 = textStyle;
        i7 = i30 | i31;
        i8 = i5 & 64;
        if (i8 != 0) {
            i7 |= 1572864;
            function6 = function2;
        } else {
            function6 = function2;
            if ((i3 & 1572864) == 0) {
                if (gapComposer.changedInstance(function6)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i7 |= i9;
            }
        }
        i10 = i5 & 128;
        if (i10 != 0) {
            i7 |= 12582912;
            function7 = function3;
        } else {
            function7 = function3;
            if ((i3 & 12582912) == 0) {
                if (gapComposer.changedInstance(function7)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i7 |= i11;
            }
        }
        i12 = i5 & 256;
        if (i12 != 0) {
            i7 |= 100663296;
            function8 = function4;
        } else {
            function8 = function4;
            if ((i3 & 100663296) == 0) {
                if (gapComposer.changedInstance(function8)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i7 |= i13;
            }
        }
        i14 = i5 & 512;
        if (i14 != 0) {
            i7 |= 805306368;
        } else if ((i3 & 805306368) == 0) {
            if (gapComposer.changedInstance(function5)) {
                i15 = 536870912;
            } else {
                i15 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            i7 |= i15;
        }
        i16 = i4 | 28086;
        i17 = i5 & 32768;
        if (i17 != 0) {
            i16 = 12807606;
        } else if ((i4 & 196608) == 0) {
            if (gapComposer.changed(keyboardOptions)) {
                i18 = 131072;
            } else {
                i18 = 65536;
            }
            i16 |= i18;
        }
        i19 = i5 & 65536;
        if (i19 != 0) {
            i20 = i16 | 1572864;
        } else {
            i20 = i16 | (gapComposer.changed(keyboardActions) ? 1048576 : 524288);
        }
        int i35 = i20 | 838860800;
        if ((i5 & 2097152) == 0) {
            c = 16;
        } else {
            c = 16;
        }
        int i36 = 6 | c;
        if ((i5 & 4194304) == 0) {
            i21 = 128;
        } else {
            i21 = 128;
        }
        int i37 = i36 | i21;
        i22 = i7;
        if ((i7 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer.shouldExecute(i22 & 1, z3)) {
            gapComposer.startDefaults();
            if ((i3 & 1) == 0) {
                if (i29 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if ((i5 & 32) != 0) {
                    textStyle2 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                }
                if (i8 != 0) {
                    function6 = null;
                }
                if (i10 != 0) {
                    function7 = null;
                }
                if (i12 != 0) {
                    function8 = null;
                }
                if (i14 == 0) {
                }
                if (i17 != 0) {
                    keyboardOptions3 = KeyboardOptions.Default;
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if (i19 != 0) {
                    keyboardActions3 = KeyboardActions.Default;
                } else {
                    keyboardActions3 = keyboardActions;
                }
                if (z2) {
                    i25 = 1;
                } else {
                    i25 = Integer.MAX_VALUE;
                }
                if ((i5 & 2097152) != 0) {
                    value = ShapesKt.getValue(4, gapComposer);
                } else {
                    value = shape;
                }
                i26 = i5 & 4194304;
                ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda2 = VisualTransformation.Companion.None;
                if (i26 != 0) {
                    z5 = true;
                    i27 = 1;
                    textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                } else {
                    z5 = true;
                    i27 = 1;
                    textFieldColorsColors = textFieldColors;
                }
                keyboardOptions4 = keyboardOptions3;
                viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda2;
            } else {
                if (i29 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if ((i5 & 32) != 0) {
                    textStyle2 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                }
                if (i8 != 0) {
                    function6 = null;
                }
                if (i10 != 0) {
                    function7 = null;
                }
                if (i12 != 0) {
                    function8 = null;
                }
                if (i14 == 0) {
                }
                if (i17 != 0) {
                    keyboardOptions3 = KeyboardOptions.Default;
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if (i19 != 0) {
                    keyboardActions3 = KeyboardActions.Default;
                } else {
                    keyboardActions3 = keyboardActions;
                }
                if (z2) {
                    i25 = 1;
                } else {
                    i25 = Integer.MAX_VALUE;
                }
                if ((i5 & 2097152) != 0) {
                    value = ShapesKt.getValue(4, gapComposer);
                } else {
                    value = shape;
                }
                i26 = i5 & 4194304;
                ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda3 = VisualTransformation.Companion.None;
                if (i26 != 0) {
                    z5 = true;
                    i27 = 1;
                    textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
                } else {
                    z5 = true;
                    i27 = 1;
                    textFieldColorsColors = textFieldColors;
                }
                keyboardOptions4 = keyboardOptions3;
                viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda3;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(-502301594);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(1369275503);
            jM752getColor0d7_KjU = textStyle2.m752getColor0d7_KjU();
            if (jM752getColor0d7_KjU == 16) {
                jM752getColor0d7_KjU = textFieldColorsColors.m346textColorXeAY9LY(z5, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue());
            }
            long j2 = jM752getColor0d7_KjU;
            gapComposer.end(false);
            final TextStyle textStyleMerge2 = textStyle2.merge(new TextStyle(j2, 0L, null, null, null, 0L, 0, 0L, null, null, 16777214));
            Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColorsColors.textSelectionColors), Expect_jvmKt.rememberComposableLambda(-2094276683, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        final Function2 function13 = function6;
                        Modifier modifierM139paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                        if (function13 != null) {
                            gapComposer2.startReplaceGroup(-2119688641);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (objRememberedValue2 == Composer.Companion.Empty) {
                                objRememberedValue2 = new TextKt$$ExternalSyntheticLambda0((byte) 23);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifierM139paddingqDBjuR0$default, true, (Function1) objRememberedValue2), CropImageView.DEFAULT_ASPECT_RATIO, Icons$Filled.minimizedLabelHalfHeight(gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-2119398202);
                            gapComposer2.end(false);
                        }
                        Modifier modifierThen = modifier2.then(modifierM139paddingqDBjuR0$default);
                        Icons$Filled.m373getString2EP1pXo(R.string.default_error_message, gapComposer2);
                        Modifier modifierM143defaultMinSizeVpY3zN4 = SizeKt.m143defaultMinSizeVpY3zN4(modifierThen, 280.0f, 56.0f);
                        final TextFieldColors textFieldColors3 = textFieldColorsColors;
                        SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor);
                        final TextFieldValue textFieldValue2 = textFieldValue;
                        final boolean z6 = z5;
                        final boolean z7 = z2;
                        final VisualTransformation visualTransformation3 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
                        final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        final Function2 function14 = function7;
                        final Function2 function15 = function8;
                        final Function2 function16 = function12;
                        final Shape shape3 = value;
                        BasicTextKt.BasicTextField(textFieldValue2, function1, modifierM143defaultMinSizeVpY3zN4, z6, textStyleMerge2, keyboardOptions4, keyboardActions3, z7, i25, i27 ? 1 : 0, visualTransformation3, (Function1) null, mutableInteractionSourceImpl2, solidColor, Expect_jvmKt.rememberComposableLambda(674541106, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                            /* JADX WARN: Type inference fix 'apply assigned field type' failed
                            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                             */
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                Function2 function17 = (Function2) obj3;
                                Composer composer3 = (Composer) obj4;
                                int iIntValue2 = ((Integer) obj5).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    iIntValue2 |= ((GapComposer) composer3).changedInstance(function17) ? 4 : 2;
                                }
                                GapComposer gapComposer3 = (GapComposer) composer3;
                                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE$3;
                                    String str = textFieldValue2.annotatedString.text;
                                    boolean z8 = z6;
                                    MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                                    TextFieldColors textFieldColors4 = textFieldColors3;
                                    textFieldDefaults.DecorationBox(str, function17, z8, z7, visualTransformation3, mutableInteractionSourceImpl3, function13, function14, function15, function16, null, textFieldColors4, null, Expect_jvmKt.rememberComposableLambda(1409265477, new OutlinedTextFieldKt$$ExternalSyntheticLambda6(z8, mutableInteractionSourceImpl3, textFieldColors4, shape3, (byte) 0), gapComposer3), gapComposer3, (iIntValue2 << 3) & 112);
                                } else {
                                    gapComposer3.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer2), gapComposer2, 0, 4096);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
            modifier3 = modifier2;
            z4 = z5;
            keyboardOptions2 = keyboardOptions4;
            keyboardActions2 = keyboardActions3;
            i24 = i25;
            i23 = i27;
            visualTransformation2 = viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
            function11 = function8;
            function9 = function12;
            shape2 = value;
            textStyle3 = textStyle2;
            textFieldColors2 = textFieldColorsColors;
            function10 = function7;
        } else {
            gapComposer.skipToGroupEnd();
            z4 = z;
            function9 = function5;
            keyboardOptions2 = keyboardOptions;
            i23 = i2;
            shape2 = shape;
            textFieldColors2 = textFieldColors;
            function10 = function7;
            modifier3 = modifier2;
            textStyle3 = textStyle2;
            function11 = function8;
            visualTransformation2 = visualTransformation;
            keyboardActions2 = keyboardActions;
            i24 = i;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4);
                    TextFieldValue textFieldValue2 = textFieldValue;
                    Function1 function13 = function1;
                    Modifier modifier4 = modifier3;
                    boolean z6 = z4;
                    TextStyle textStyle4 = textStyle3;
                    Function2 function14 = function6;
                    Function2 function15 = function10;
                    Function2 function16 = function11;
                    Function2 function17 = function9;
                    VisualTransformation visualTransformation3 = visualTransformation2;
                    KeyboardOptions keyboardOptions5 = keyboardOptions2;
                    KeyboardActions keyboardActions4 = keyboardActions2;
                    boolean z7 = z2;
                    int i38 = i24;
                    boolean z8 = i23;
                    Shape shape3 = shape2;
                    TextFieldColors textFieldColors3 = textFieldColors2;
                    int i39 = i5;
                    ScrimKt.OutlinedTextField(textFieldValue2, function13, modifier4, z6, textStyle4, function14, function15, function16, function17, visualTransformation3, keyboardOptions5, keyboardActions4, z7, i38, z8 ? 1 : 0, shape3, textFieldColors3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i39);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
