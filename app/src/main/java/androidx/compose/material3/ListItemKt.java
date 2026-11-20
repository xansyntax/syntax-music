package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$1$1;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyImpl;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.extractor.flv.TagPayloadReader;
import coil3.RealImageLoader$execute$result$1;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CookieKt$$ExternalSyntheticLambda3;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListItemKt {
    public static final float InteractiveListVerticalAlignmentBreakpoint;

    static {
        PaddingValuesImpl paddingValuesImpl = ListItemDefaults.ContentPadding;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
        InteractiveListVerticalAlignmentBreakpoint = (((80.0f - (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 12.0f : 10.0f)) + CropImageView.DEFAULT_ASPECT_RATIO) - (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 12.0f : 10.0f)) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public static final void CollectInteractionsAsState(final InteractionSource interactionSource, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, Composer composer, final int i) {
        final InteractionSource interactionSource2;
        final MutableState mutableState5;
        MutableState mutableState6;
        MutableState mutableState7;
        MutableState mutableState8;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(844822063);
        int i2 = (gapComposer.changed(interactionSource) ? 4 : 2) | i;
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            interactionSource2 = interactionSource;
            mutableState5 = mutableState;
            mutableState6 = mutableState2;
            mutableState7 = mutableState3;
            mutableState8 = mutableState4;
            gapComposer.skipToGroupEnd();
        } else {
            if (interactionSource == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(interactionSource, mutableState, mutableState2, mutableState3, mutableState4, i, b) { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda5
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ InteractionSource f$0;
                        public final /* synthetic */ MutableState f$1;
                        public final /* synthetic */ MutableState f$2;
                        public final /* synthetic */ MutableState f$3;
                        public final /* synthetic */ MutableState f$4;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            switch (b2) {
                                case 0:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(28081);
                                    ListItemKt.CollectInteractionsAsState(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags);
                                    break;
                                default:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(28081);
                                    ListItemKt.CollectInteractionsAsState(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags2);
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            interactionSource2 = interactionSource;
            mutableState5 = mutableState;
            mutableState6 = mutableState2;
            boolean z = false;
            mutableState7 = mutableState3;
            if ((i2 & 14) == 4) {
                z = true;
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                mutableState8 = mutableState4;
                RealImageLoader$execute$result$1 realImageLoader$execute$result$1 = new RealImageLoader$execute$result$1((Object) mutableState5, (Object) mutableState6, (Object) mutableState7, (Object) mutableState8, (Object) interactionSource2, (Continuation) null, (byte) 6);
                mutableState5 = mutableState5;
                interactionSource2 = interactionSource2;
                gapComposer.updateRememberedValue(realImageLoader$execute$result$1);
                objRememberedValue = realImageLoader$execute$result$1;
            } else {
                mutableState8 = mutableState4;
            }
            Stack.LaunchedEffect(gapComposer, interactionSource2, (Function2) objRememberedValue);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            final MutableState mutableState9 = mutableState8;
            final MutableState mutableState10 = mutableState7;
            final MutableState mutableState11 = mutableState6;
            recomposeScopeImplEndRestartGroup2.block = new Function2(interactionSource2, mutableState5, mutableState11, mutableState10, mutableState9, i, b2) { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda5
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ InteractionSource f$0;
                public final /* synthetic */ MutableState f$1;
                public final /* synthetic */ MutableState f$2;
                public final /* synthetic */ MutableState f$3;
                public final /* synthetic */ MutableState f$4;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    switch (b3) {
                        case 0:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(28081);
                            ListItemKt.CollectInteractionsAsState(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags);
                            break;
                        default:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(28081);
                            ListItemKt.CollectInteractionsAsState(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags2);
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    /* JADX INFO: renamed from: ContentDecorator-rcwGITA, reason: not valid java name */
    public static final void m299ContentDecoratorrcwGITA(long j, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        long j2;
        ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(526602478);
        int i2 = (gapComposer.changed(j) ? 4 : 2) | i | (gapComposer.changed(0) ? 32 : 16) | (gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
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
            j2 = j;
            composableLambdaImpl2 = composableLambdaImpl;
            Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j2, CardKt.getValue(0, gapComposer), composableLambdaImpl2, gapComposer, i2 & 910);
            gapComposer.end(true);
        } else {
            j2 = j;
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListItemKt$$ExternalSyntheticLambda14(j2, composableLambdaImpl2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:193:0x0323  */
    /* JADX WARN: Code duplicated, block: B:196:0x033a  */
    /* JADX WARN: Code duplicated, block: B:201:0x034c  */
    /* JADX WARN: Code duplicated, block: B:203:0x0352  */
    /* JADX WARN: Code duplicated, block: B:204:0x0357  */
    /* JADX WARN: Code duplicated, block: B:212:0x0375  */
    /* JADX WARN: Code duplicated, block: B:216:0x039f  */
    /* JADX WARN: Code duplicated, block: B:220:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:224:0x0428  */
    /* JADX WARN: Code duplicated, block: B:227:0x043a  */
    /* JADX WARN: Code duplicated, block: B:232:0x044c  */
    /* JADX WARN: Code duplicated, block: B:234:0x0452  */
    /* JADX WARN: Code duplicated, block: B:235:0x0457  */
    /* JADX WARN: Code duplicated, block: B:243:0x0472  */
    /* JADX WARN: Code duplicated, block: B:247:0x0498  */
    /* JADX WARN: Code duplicated, block: B:251:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:255:0x051b  */
    /* JADX WARN: Code duplicated, block: B:258:0x052d  */
    /* JADX WARN: Code duplicated, block: B:263:0x0542  */
    /* JADX WARN: Code duplicated, block: B:265:0x0548  */
    /* JADX WARN: Code duplicated, block: B:266:0x054d  */
    /* JADX WARN: Code duplicated, block: B:274:0x0568  */
    /* JADX WARN: Code duplicated, block: B:278:0x0592  */
    /* JADX WARN: Code duplicated, block: B:282:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:286:0x0614  */
    /* JADX WARN: Code duplicated, block: B:289:0x0626  */
    /* JADX WARN: Code duplicated, block: B:294:0x063b  */
    /* JADX WARN: Code duplicated, block: B:296:0x0641  */
    /* JADX WARN: Code duplicated, block: B:297:0x0646  */
    /* JADX WARN: Code duplicated, block: B:305:0x0661  */
    /* JADX WARN: Code duplicated, block: B:309:0x068b  */
    /* JADX WARN: Code duplicated, block: B:313:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:317:0x070d  */
    /* JADX WARN: Code duplicated, block: B:320:0x071f  */
    /* JADX WARN: Code duplicated, block: B:325:0x0734  */
    /* JADX WARN: Code duplicated, block: B:327:0x073a  */
    /* JADX WARN: Code duplicated, block: B:328:0x073f  */
    /* JADX WARN: Code duplicated, block: B:336:0x075a  */
    /* JADX WARN: Code duplicated, block: B:340:0x0784  */
    /* JADX WARN: Code duplicated, block: B:344:0x07b9  */
    /* JADX WARN: Code duplicated, block: B:348:0x0805  */
    /* JADX WARN: Code duplicated, block: B:351:0x0817  */
    /* JADX WARN: Code duplicated, block: B:356:0x082c  */
    /* JADX WARN: Code duplicated, block: B:358:0x0832  */
    /* JADX WARN: Code duplicated, block: B:359:0x0837  */
    /* JADX WARN: Code duplicated, block: B:367:0x0857  */
    /* JADX WARN: Code duplicated, block: B:371:0x087c  */
    /* JADX WARN: Code duplicated, block: B:375:0x08ae  */
    /* JADX WARN: Code duplicated, block: B:378:0x08e0  */
    /* JADX WARN: Code duplicated, block: B:380:0x08e7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    public static final void InteractiveListItem(final Modifier modifier, final ComposableLambdaImpl composableLambdaImpl, final Function2 function2, final Function2 function3, final Function2 function4, final Alignment.Vertical vertical, final boolean z, final Function1 function1, final ListItemColors listItemColors, final ListItemShapes listItemShapes, final ListItemElevation listItemElevation, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        Function2 function5;
        int i4;
        GapComposer gapComposer;
        Shape shape;
        ?? r4;
        Shape shape2;
        boolean z2;
        AnimatedShapeKt$rememberAnimatedShape$1$1 animatedShapeKt$rememberAnimatedShape$1$1RememberAnimatedShape;
        TransitionInstance transitionInstanceUpdateTransition;
        TagPayloadReader tagPayloadReader;
        ColorSpace colorSpaceM483getColorSpaceimpl;
        boolean zChanged;
        Object objRememberedValue;
        ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1;
        ?? r1;
        Object objM;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        ColorSpace colorSpaceM483getColorSpaceimpl2;
        boolean zChanged4;
        Object objRememberedValue4;
        boolean z3;
        Object objM2;
        boolean zChanged5;
        Object objRememberedValue5;
        boolean zChanged6;
        Object objRememberedValue6;
        ColorSpace colorSpaceM483getColorSpaceimpl3;
        boolean zChanged7;
        Object objRememberedValue7;
        boolean z4;
        Object objM3;
        boolean zChanged8;
        Object objRememberedValue8;
        boolean zChanged9;
        Object objRememberedValue9;
        ColorSpace colorSpaceM483getColorSpaceimpl4;
        boolean zChanged10;
        Object objRememberedValue10;
        boolean z5;
        Object objM4;
        boolean zChanged11;
        Object objRememberedValue11;
        boolean zChanged12;
        Object objRememberedValue12;
        ColorSpace colorSpaceM483getColorSpaceimpl5;
        boolean zChanged13;
        Object objRememberedValue13;
        boolean z6;
        Object objM5;
        boolean zChanged14;
        Object objRememberedValue14;
        boolean zChanged15;
        Object objRememberedValue15;
        ColorSpace colorSpaceM483getColorSpaceimpl6;
        boolean zChanged16;
        Object objRememberedValue16;
        boolean z7;
        Object objM6;
        boolean zChanged17;
        Object objRememberedValue17;
        boolean zChanged18;
        Object objRememberedValue18;
        float f;
        boolean zChanged19;
        Object objRememberedValue19;
        Snapshot currentThreadSnapshot;
        Function1 readObserver;
        Snapshot snapshotMakeCurrentNonObservable;
        boolean zChanged20;
        Snapshot currentThreadSnapshot2;
        Function1 readObserver2;
        Snapshot snapshotMakeCurrentNonObservable2;
        boolean zChanged21;
        Snapshot currentThreadSnapshot3;
        Function1 readObserver3;
        Snapshot snapshotMakeCurrentNonObservable3;
        boolean zChanged22;
        Snapshot currentThreadSnapshot4;
        Function1 readObserver4;
        Snapshot snapshotMakeCurrentNonObservable4;
        boolean zChanged23;
        Snapshot currentThreadSnapshot5;
        Function1 readObserver5;
        Snapshot snapshotMakeCurrentNonObservable5;
        boolean zChanged24;
        Snapshot currentThreadSnapshot6;
        Function1 readObserver6;
        Snapshot snapshotMakeCurrentNonObservable6;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1408227475);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer2.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer2.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer2.changedInstance(null) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            function5 = function4;
            i3 |= gapComposer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function4;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer2.changed(vertical) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer2.changed(z) ? 8388608 : 4194304;
        }
        int i5 = i3;
        if ((i & 100663296) == 0) {
            i5 |= gapComposer2.changed(false) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i5 |= gapComposer2.changedInstance(function1) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer2.changedInstance(null) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer2.changedInstance(null) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer2.changed((Object) null) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer2.changed((Object) null) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer2.changed(listItemColors) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer2.changed(listItemShapes) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer2.changed(listItemElevation) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= gapComposer2.changed(paddingValues) ? 8388608 : 4194304;
        }
        if (gapComposer2.shouldExecute(i5 & 1, ((i5 & 306783379) == 306783378 && (i4 & 4793491) == 4793490) ? false : true)) {
            gapComposer2.startReplaceGroup(736618201);
            gapComposer2.end(false);
            Object objRememberedValue20 = gapComposer2.rememberedValue();
            Object obj = Composer.Companion.Empty;
            if (objRememberedValue20 == obj) {
                objRememberedValue20 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue20);
            }
            MutableState mutableState = (MutableState) objRememberedValue20;
            Object objRememberedValue21 = gapComposer2.rememberedValue();
            if (objRememberedValue21 == obj) {
                objRememberedValue21 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue21);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue21;
            Object objRememberedValue22 = gapComposer2.rememberedValue();
            if (objRememberedValue22 == obj) {
                objRememberedValue22 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue22);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue22;
            Object objRememberedValue23 = gapComposer2.rememberedValue();
            if (objRememberedValue23 == obj) {
                objRememberedValue23 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue23);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue23;
            final MutableInteractionSourceImpl mutableInteractionSourceImpl = null;
            CollectInteractionsAsState(null, mutableState, mutableState2, mutableState3, mutableState4, gapComposer2, 28080);
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(3, gapComposer2);
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(1, gapComposer2);
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs3 = CardKt.m272valueyDoVZcs(1, gapComposer2);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            boolean zBooleanValue2 = ((Boolean) mutableState2.getValue()).booleanValue();
            boolean zBooleanValue3 = ((Boolean) mutableState3.getValue()).booleanValue();
            boolean zBooleanValue4 = ((Boolean) mutableState4.getValue()).booleanValue();
            gapComposer2.startReplaceGroup(2080718032);
            if (zBooleanValue) {
                shape = listItemShapes.pressedShape;
            } else if (zBooleanValue4) {
                shape = listItemShapes.draggedShape;
            } else if (zBooleanValue2) {
                shape = listItemShapes.focusedShape;
            } else {
                shape = zBooleanValue3 ? listItemShapes.hoveredShape : listItemShapes.shape;
            }
            Shape shape3 = listItemShapes.shape;
            Shape shape4 = listItemShapes.draggedShape;
            Shape shape5 = listItemShapes.hoveredShape;
            Shape shape6 = listItemShapes.focusedShape;
            Shape shape7 = shape;
            Shape shape8 = listItemShapes.pressedShape;
            Shape shape9 = listItemShapes.selectedShape;
            if ((shape3 instanceof RoundedCornerShape) && (shape9 instanceof RoundedCornerShape) && (shape8 instanceof RoundedCornerShape) && (shape6 instanceof RoundedCornerShape) && (shape5 instanceof RoundedCornerShape) && (shape4 instanceof RoundedCornerShape)) {
                gapComposer2.startReplaceGroup(1703365676);
                gapComposer2.startMovableGroup(-1884714849, listItemShapes);
                shape7.getClass();
                z2 = false;
                animatedShapeKt$rememberAnimatedShape$1$1RememberAnimatedShape = Icons$Filled.rememberAnimatedShape((RoundedCornerShape) shape7, finiteAnimationSpecM272valueyDoVZcs2, gapComposer2, 0);
                Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, false, false);
            } else {
                if ((shape3 instanceof RoundedCornerShape) && (shape9 instanceof RoundedCornerShape) && (shape8 instanceof RoundedCornerShape) && (shape6 instanceof RoundedCornerShape) && (shape5 instanceof RoundedCornerShape) && (shape4 instanceof RoundedCornerShape)) {
                    gapComposer2.startReplaceGroup(1703498542);
                    gapComposer2.startMovableGroup(-1884710563, listItemShapes);
                    shape7.getClass();
                    z2 = false;
                    animatedShapeKt$rememberAnimatedShape$1$1RememberAnimatedShape = Icons$Filled.rememberAnimatedShape((RoundedCornerShape) shape7, finiteAnimationSpecM272valueyDoVZcs2, gapComposer2, 0);
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, false, false);
                } else {
                    r4 = 0;
                    gapComposer2.startReplaceGroup(1703594642);
                    gapComposer2.end(false);
                    gapComposer2.end(false);
                    shape2 = shape7;
                }
                transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(new InteractiveListColorState(z, ((Boolean) mutableState4.getValue()).booleanValue()), "ListColor", gapComposer2, 48, r4);
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionInstanceUpdateTransition.targetState$delegate;
                tagPayloadReader = transitionInstanceUpdateTransition.transitionState;
                InteractiveListColorState interactiveListColorState = (InteractiveListColorState) parcelableSnapshotMutableState.getValue();
                gapComposer2.startReplaceGroup(519559029);
                long jM293containerColorXeAY9LY = listItemColors.m293containerColorXeAY9LY(interactiveListColorState.enabled, interactiveListColorState.dragged);
                gapComposer2.end(r4);
                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(jM293containerColorXeAY9LY);
                zChanged = gapComposer2.changed(colorSpaceM483getColorSpaceimpl);
                objRememberedValue = gapComposer2.rememberedValue();
                colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
                if (zChanged || objRememberedValue == obj) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer2);
                }
                TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue;
                if (transitionInstanceUpdateTransition.isSeeking()) {
                    r1 = 0;
                    objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    zChanged24 = gapComposer2.changed(transitionInstanceUpdateTransition);
                    objM = gapComposer2.rememberedValue();
                    if (zChanged24 || objM == obj) {
                        currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot6 != null) {
                            readObserver6 = currentThreadSnapshot6.getReadObserver();
                        } else {
                            readObserver6 = null;
                        }
                        snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                        try {
                            Object currentState = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                            gapComposer2.updateRememberedValue(currentState);
                            objM = currentState;
                        } catch (Throwable th) {
                            Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                            throw th;
                        }
                    }
                    r1 = 0;
                    gapComposer2.end(false);
                }
                InteractiveListColorState interactiveListColorState2 = (InteractiveListColorState) objM;
                gapComposer2.startReplaceGroup(519559029);
                final Shape shape10 = shape2;
                Color colorM = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, (boolean) r1, listItemColors.m293containerColorXeAY9LY(interactiveListColorState2.enabled, interactiveListColorState2.dragged));
                zChanged2 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == obj) {
                    objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, r1));
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                InteractiveListColorState interactiveListColorState3 = (InteractiveListColorState) ((State) objRememberedValue2).getValue();
                gapComposer2.startReplaceGroup(519559029);
                Color colorM2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, (boolean) r1, listItemColors.m293containerColorXeAY9LY(interactiveListColorState3.enabled, interactiveListColorState3.dragged));
                zChanged3 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue3 == obj) {
                    objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 10));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                gapComposer2.startReplaceGroup(1215615335);
                gapComposer2.end(false);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM, colorM2, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl, gapComposer2, 0);
                InteractiveListColorState interactiveListColorState4 = (InteractiveListColorState) parcelableSnapshotMutableState.getValue();
                gapComposer2.startReplaceGroup(-154619267);
                long jM294contentColorXeAY9LY = listItemColors.m294contentColorXeAY9LY(interactiveListColorState4.enabled, interactiveListColorState4.dragged);
                gapComposer2.end(false);
                colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(jM294contentColorXeAY9LY);
                zChanged4 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl2);
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (zChanged4 || objRememberedValue4 == obj) {
                    objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer2);
                }
                TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue4;
                if (transitionInstanceUpdateTransition.isSeeking()) {
                    z3 = false;
                    objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    zChanged23 = gapComposer2.changed(transitionInstanceUpdateTransition);
                    objM2 = gapComposer2.rememberedValue();
                    if (zChanged23 || objM2 == obj) {
                        currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot5 != null) {
                            readObserver5 = currentThreadSnapshot5.getReadObserver();
                        } else {
                            readObserver5 = null;
                        }
                        snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                        try {
                            Object currentState2 = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                            gapComposer2.updateRememberedValue(currentState2);
                            objM2 = currentState2;
                        } catch (Throwable th2) {
                            Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                            throw th2;
                        }
                    }
                    z3 = false;
                    gapComposer2.end(false);
                }
                InteractiveListColorState interactiveListColorState5 = (InteractiveListColorState) objM2;
                gapComposer2.startReplaceGroup(-154619267);
                Color colorM3 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z3, listItemColors.m294contentColorXeAY9LY(interactiveListColorState5.enabled, interactiveListColorState5.dragged));
                zChanged5 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue5 = gapComposer2.rememberedValue();
                if (zChanged5 || objRememberedValue5 == obj) {
                    objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 11));
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                InteractiveListColorState interactiveListColorState6 = (InteractiveListColorState) ((State) objRememberedValue5).getValue();
                gapComposer2.startReplaceGroup(-154619267);
                Color colorM4 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m294contentColorXeAY9LY(interactiveListColorState6.enabled, interactiveListColorState6.dragged));
                zChanged6 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChanged6 || objRememberedValue6 == obj) {
                    objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 12));
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                gapComposer2.startReplaceGroup(1119846639);
                gapComposer2.end(false);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM3, colorM4, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl2, gapComposer2, 0);
                InteractiveListColorState interactiveListColorState7 = (InteractiveListColorState) parcelableSnapshotMutableState.getValue();
                gapComposer2.startReplaceGroup(-836285680);
                long jM295leadingContentColorXeAY9LY = listItemColors.m295leadingContentColorXeAY9LY(interactiveListColorState7.enabled, interactiveListColorState7.dragged);
                gapComposer2.end(false);
                colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(jM295leadingContentColorXeAY9LY);
                zChanged7 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl3);
                objRememberedValue7 = gapComposer2.rememberedValue();
                if (zChanged7 || objRememberedValue7 == obj) {
                    objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer2);
                }
                TwoWayConverterImpl twoWayConverterImpl3 = (TwoWayConverterImpl) objRememberedValue7;
                if (transitionInstanceUpdateTransition.isSeeking()) {
                    z4 = false;
                    objM3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    zChanged22 = gapComposer2.changed(transitionInstanceUpdateTransition);
                    objM3 = gapComposer2.rememberedValue();
                    if (zChanged22 || objM3 == obj) {
                        currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot4 != null) {
                            readObserver4 = currentThreadSnapshot4.getReadObserver();
                        } else {
                            readObserver4 = null;
                        }
                        snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                        try {
                            Object currentState3 = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                            gapComposer2.updateRememberedValue(currentState3);
                            objM3 = currentState3;
                        } catch (Throwable th3) {
                            Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                            throw th3;
                        }
                    }
                    z4 = false;
                    gapComposer2.end(false);
                }
                InteractiveListColorState interactiveListColorState8 = (InteractiveListColorState) objM3;
                gapComposer2.startReplaceGroup(-836285680);
                Color colorM5 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z4, listItemColors.m295leadingContentColorXeAY9LY(interactiveListColorState8.enabled, interactiveListColorState8.dragged));
                zChanged8 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue8 = gapComposer2.rememberedValue();
                if (zChanged8 || objRememberedValue8 == obj) {
                    objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 13));
                    gapComposer2.updateRememberedValue(objRememberedValue8);
                }
                InteractiveListColorState interactiveListColorState9 = (InteractiveListColorState) ((State) objRememberedValue8).getValue();
                gapComposer2.startReplaceGroup(-836285680);
                Color colorM6 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m295leadingContentColorXeAY9LY(interactiveListColorState9.enabled, interactiveListColorState9.dragged));
                zChanged9 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue9 = gapComposer2.rememberedValue();
                if (zChanged9 || objRememberedValue9 == obj) {
                    objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 14));
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                gapComposer2.startReplaceGroup(438180226);
                gapComposer2.end(false);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM5, colorM6, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl3, gapComposer2, 0);
                InteractiveListColorState interactiveListColorState10 = (InteractiveListColorState) parcelableSnapshotMutableState.getValue();
                gapComposer2.startReplaceGroup(-1629003078);
                long jM298trailingContentColorXeAY9LY = listItemColors.m298trailingContentColorXeAY9LY(interactiveListColorState10.enabled, interactiveListColorState10.dragged);
                gapComposer2.end(false);
                colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(jM298trailingContentColorXeAY9LY);
                zChanged10 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl4);
                objRememberedValue10 = gapComposer2.rememberedValue();
                if (zChanged10 || objRememberedValue10 == obj) {
                    objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer2);
                }
                TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objRememberedValue10;
                if (transitionInstanceUpdateTransition.isSeeking()) {
                    z5 = false;
                    objM4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    zChanged21 = gapComposer2.changed(transitionInstanceUpdateTransition);
                    objM4 = gapComposer2.rememberedValue();
                    if (zChanged21 || objM4 == obj) {
                        currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot3 != null) {
                            readObserver3 = currentThreadSnapshot3.getReadObserver();
                        } else {
                            readObserver3 = null;
                        }
                        snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                        try {
                            Object currentState4 = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                            gapComposer2.updateRememberedValue(currentState4);
                            objM4 = currentState4;
                        } catch (Throwable th4) {
                            Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                            throw th4;
                        }
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                InteractiveListColorState interactiveListColorState11 = (InteractiveListColorState) objM4;
                gapComposer2.startReplaceGroup(-1629003078);
                Color colorM7 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z5, listItemColors.m298trailingContentColorXeAY9LY(interactiveListColorState11.enabled, interactiveListColorState11.dragged));
                zChanged11 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue11 = gapComposer2.rememberedValue();
                if (zChanged11 || objRememberedValue11 == obj) {
                    objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 15));
                    gapComposer2.updateRememberedValue(objRememberedValue11);
                }
                InteractiveListColorState interactiveListColorState12 = (InteractiveListColorState) ((State) objRememberedValue11).getValue();
                gapComposer2.startReplaceGroup(-1629003078);
                Color colorM8 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m298trailingContentColorXeAY9LY(interactiveListColorState12.enabled, interactiveListColorState12.dragged));
                zChanged12 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue12 = gapComposer2.rememberedValue();
                if (zChanged12 || objRememberedValue12 == obj) {
                    objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 16));
                    gapComposer2.updateRememberedValue(objRememberedValue12);
                }
                gapComposer2.startReplaceGroup(-775265656);
                gapComposer2.end(false);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM7, colorM8, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl4, gapComposer2, 0);
                InteractiveListColorState interactiveListColorState13 = (InteractiveListColorState) parcelableSnapshotMutableState.getValue();
                gapComposer2.startReplaceGroup(984715150);
                long jM296overlineContentColorXeAY9LY = listItemColors.m296overlineContentColorXeAY9LY(interactiveListColorState13.enabled, interactiveListColorState13.dragged);
                gapComposer2.end(false);
                colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(jM296overlineContentColorXeAY9LY);
                zChanged13 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl5);
                objRememberedValue13 = gapComposer2.rememberedValue();
                if (zChanged13 || objRememberedValue13 == obj) {
                    objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer2);
                }
                TwoWayConverterImpl twoWayConverterImpl5 = (TwoWayConverterImpl) objRememberedValue13;
                if (transitionInstanceUpdateTransition.isSeeking()) {
                    z6 = false;
                    objM5 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    zChanged20 = gapComposer2.changed(transitionInstanceUpdateTransition);
                    objM5 = gapComposer2.rememberedValue();
                    if (zChanged20 || objM5 == obj) {
                        currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot2 != null) {
                            readObserver2 = currentThreadSnapshot2.getReadObserver();
                        } else {
                            readObserver2 = null;
                        }
                        snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                        try {
                            Object currentState5 = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            gapComposer2.updateRememberedValue(currentState5);
                            objM5 = currentState5;
                        } catch (Throwable th5) {
                            Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            throw th5;
                        }
                    }
                    z6 = false;
                    gapComposer2.end(false);
                }
                InteractiveListColorState interactiveListColorState14 = (InteractiveListColorState) objM5;
                gapComposer2.startReplaceGroup(984715150);
                Color colorM9 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z6, listItemColors.m296overlineContentColorXeAY9LY(interactiveListColorState14.enabled, interactiveListColorState14.dragged));
                zChanged14 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue14 = gapComposer2.rememberedValue();
                if (zChanged14 || objRememberedValue14 == obj) {
                    objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 17));
                    gapComposer2.updateRememberedValue(objRememberedValue14);
                }
                InteractiveListColorState interactiveListColorState15 = (InteractiveListColorState) ((State) objRememberedValue14).getValue();
                gapComposer2.startReplaceGroup(984715150);
                Color colorM10 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m296overlineContentColorXeAY9LY(interactiveListColorState15.enabled, interactiveListColorState15.dragged));
                zChanged15 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue15 = gapComposer2.rememberedValue();
                if (zChanged15 || objRememberedValue15 == obj) {
                    objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 7));
                    gapComposer2.updateRememberedValue(objRememberedValue15);
                }
                gapComposer2.startReplaceGroup(1838452572);
                gapComposer2.end(false);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation5 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM9, colorM10, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl5, gapComposer2, 0);
                InteractiveListColorState interactiveListColorState16 = (InteractiveListColorState) parcelableSnapshotMutableState.getValue();
                gapComposer2.startReplaceGroup(-1535703933);
                long jM297supportingContentColorXeAY9LY = listItemColors.m297supportingContentColorXeAY9LY(interactiveListColorState16.enabled, interactiveListColorState16.dragged);
                gapComposer2.end(false);
                colorSpaceM483getColorSpaceimpl6 = Color.m483getColorSpaceimpl(jM297supportingContentColorXeAY9LY);
                zChanged16 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl6);
                objRememberedValue16 = gapComposer2.rememberedValue();
                if (zChanged16 || objRememberedValue16 == obj) {
                    objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer2);
                }
                TwoWayConverterImpl twoWayConverterImpl6 = (TwoWayConverterImpl) objRememberedValue16;
                if (transitionInstanceUpdateTransition.isSeeking()) {
                    z7 = false;
                    objM6 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    zChanged19 = gapComposer2.changed(transitionInstanceUpdateTransition);
                    objRememberedValue19 = gapComposer2.rememberedValue();
                    if (zChanged19 || objRememberedValue19 == obj) {
                        currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot != null) {
                            readObserver = currentThreadSnapshot.getReadObserver();
                        } else {
                            readObserver = null;
                        }
                        snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            Object currentState6 = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            gapComposer2.updateRememberedValue(currentState6);
                            objRememberedValue19 = currentState6;
                        } catch (Throwable th6) {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th6;
                        }
                    }
                    gapComposer2.end(false);
                    Object obj2 = objRememberedValue19;
                    z7 = false;
                    objM6 = obj2;
                }
                InteractiveListColorState interactiveListColorState17 = (InteractiveListColorState) objM6;
                gapComposer2.startReplaceGroup(-1535703933);
                Color colorM11 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z7, listItemColors.m297supportingContentColorXeAY9LY(interactiveListColorState17.enabled, interactiveListColorState17.dragged));
                zChanged17 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue17 = gapComposer2.rememberedValue();
                if (zChanged17 || objRememberedValue17 == obj) {
                    objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 8));
                    gapComposer2.updateRememberedValue(objRememberedValue17);
                }
                InteractiveListColorState interactiveListColorState18 = (InteractiveListColorState) ((State) objRememberedValue17).getValue();
                gapComposer2.startReplaceGroup(-1535703933);
                Color colorM12 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m297supportingContentColorXeAY9LY(interactiveListColorState18.enabled, interactiveListColorState18.dragged));
                zChanged18 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue18 = gapComposer2.rememberedValue();
                if (zChanged18 || objRememberedValue18 == obj) {
                    objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 9));
                    gapComposer2.updateRememberedValue(objRememberedValue18);
                }
                gapComposer2.startReplaceGroup(-1432794927);
                gapComposer2.end(false);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation6 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM11, colorM12, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl6, gapComposer2, 0);
                if (((Boolean) mutableState4.getValue()).booleanValue()) {
                    listItemElevation.getClass();
                    f = 8.0f;
                } else {
                    listItemElevation.getClass();
                    f = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                final AnimateAsState animateAsStateM18animateDpAsStateAjpBEmI = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f, finiteAnimationSpecM272valueyDoVZcs3, null, gapComposer2, 0, 12);
                final Density density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                final LayoutDirection layoutDirection = (LayoutDirection) gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ContentColorKt.LocalContentColor;
                Color color = (Color) transitionAnimationStateCreateTransitionAnimation2.getValue();
                long j = color.value;
                final Function2 function6 = function5;
                GapComposer gapComposer3 = gapComposer2;
                Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(color), Expect_jvmKt.rememberComposableLambda(-1377981779, new Function2(function1, animateAsStateM18animateDpAsStateAjpBEmI, density, shape10, mutableInteractionSourceImpl, z, paddingValues, vertical, transitionAnimationStateCreateTransitionAnimation, layoutDirection, function2, transitionAnimationStateCreateTransitionAnimation3, function3, transitionAnimationStateCreateTransitionAnimation4, transitionAnimationStateCreateTransitionAnimation5, function6, transitionAnimationStateCreateTransitionAnimation6, composableLambdaImpl, transitionAnimationStateCreateTransitionAnimation2) { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda3
                    public final /* synthetic */ Function1 f$1;
                    public final /* synthetic */ PaddingValues f$10;
                    public final /* synthetic */ Alignment.Vertical f$11;
                    public final /* synthetic */ State f$12;
                    public final /* synthetic */ LayoutDirection f$13;
                    public final /* synthetic */ Function2 f$15;
                    public final /* synthetic */ State f$16;
                    public final /* synthetic */ Function2 f$18;
                    public final /* synthetic */ State f$19;
                    public final /* synthetic */ State f$22;
                    public final /* synthetic */ Function2 f$24;
                    public final /* synthetic */ State f$25;
                    public final /* synthetic */ ComposableLambdaImpl f$27;
                    public final /* synthetic */ Transition.TransitionAnimationState f$28;
                    public final /* synthetic */ State f$3;
                    public final /* synthetic */ Density f$4;
                    public final /* synthetic */ Shape f$5;

                    {
                        this.f$10 = paddingValues;
                        this.f$11 = vertical;
                        this.f$12 = transitionAnimationStateCreateTransitionAnimation;
                        this.f$13 = layoutDirection;
                        this.f$15 = function2;
                        this.f$16 = transitionAnimationStateCreateTransitionAnimation3;
                        this.f$18 = function3;
                        this.f$19 = transitionAnimationStateCreateTransitionAnimation4;
                        this.f$22 = transitionAnimationStateCreateTransitionAnimation5;
                        this.f$24 = function6;
                        this.f$25 = transitionAnimationStateCreateTransitionAnimation6;
                        this.f$27 = composableLambdaImpl;
                        this.f$28 = transitionAnimationStateCreateTransitionAnimation2;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        Composer composer2 = (Composer) obj3;
                        int iIntValue = ((Integer) obj4).intValue();
                        byte b = 0;
                        GapComposer gapComposer4 = (GapComposer) composer2;
                        if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Modifier modifierSemantics = SemanticsModifierKt.semantics(this.f$0, true, this.f$1);
                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                            Modifier modifierThen = modifierSemantics.then(companion);
                            State state = this.f$3;
                            boolean zChanged25 = gapComposer4.changed(state);
                            Object objRememberedValue24 = gapComposer4.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            if (zChanged25 || objRememberedValue24 == neverEqualPolicy) {
                                objRememberedValue24 = new AppBarKt$$ExternalSyntheticLambda5((byte) 1, state);
                                gapComposer4.updateRememberedValue(objRememberedValue24);
                            }
                            Modifier modifierLayout = RulerKt.layout(modifierThen, new ListItemKt$$ExternalSyntheticLambda17(b, (FloatProducer) objRememberedValue24));
                            Density density2 = this.f$4;
                            boolean zChanged26 = gapComposer4.changed(density2) | gapComposer4.changed(state);
                            Shape shape11 = this.f$5;
                            boolean zChanged27 = zChanged26 | gapComposer4.changed(shape11);
                            Object objRememberedValue25 = gapComposer4.rememberedValue();
                            if (zChanged27 || objRememberedValue25 == neverEqualPolicy) {
                                objRememberedValue25 = new UtilsKt$$ExternalSyntheticLambda0((Object) density2, (Object) shape11, (Object) state, (byte) 15);
                                gapComposer4.updateRememberedValue(objRememberedValue25);
                            }
                            Modifier modifierThen2 = ClipKt.clip(ImageKt.m39backgroundbw27NRU(ColorKt.graphicsLayer(modifierLayout, (Function1) objRememberedValue25), ((Color) this.f$12.getValue()).value, shape11), shape11).then(companion);
                            final PaddingValues paddingValues2 = this.f$10;
                            Modifier modifierPadding = OffsetKt.padding(modifierThen2, paddingValues2);
                            float fMo122calculateBottomPaddingD9Ej5fM = paddingValues2.mo122calculateBottomPaddingD9Ej5fM() + paddingValues2.mo125calculateTopPaddingD9Ej5fM() + CropImageView.DEFAULT_ASPECT_RATIO;
                            final byte b2 = 0;
                            final LayoutDirection layoutDirection2 = this.f$13;
                            final Function2 function7 = this.f$15;
                            final State state2 = this.f$16;
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1109808834, new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    byte b3 = b2;
                                    Unit unit = Unit.INSTANCE;
                                    State state3 = state2;
                                    LayoutDirection layoutDirection3 = layoutDirection2;
                                    PaddingValues paddingValues3 = paddingValues2;
                                    Composer composer3 = (Composer) obj5;
                                    switch (b3) {
                                        case 0:
                                            int iIntValue2 = ((Integer) obj6).intValue();
                                            GapComposer gapComposer5 = (GapComposer) composer3;
                                            if (!gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                                gapComposer5.skipToGroupEnd();
                                            } else {
                                                ListItemKt.m301LeadingDecoratorYv3_QuU(OffsetKt.calculateStartPadding(paddingValues3, layoutDirection3), ((Color) state3.getValue()).value, function7, gapComposer5, 0);
                                            }
                                            break;
                                        default:
                                            int iIntValue3 = ((Integer) obj6).intValue();
                                            GapComposer gapComposer6 = (GapComposer) composer3;
                                            if (!gapComposer6.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                                gapComposer6.skipToGroupEnd();
                                            } else {
                                                ListItemKt.m304TrailingDecoratorYv3_QuU(OffsetKt.calculateEndPadding(paddingValues3, layoutDirection3), ((Color) state3.getValue()).value, function7, gapComposer6, 0);
                                            }
                                            break;
                                    }
                                    return unit;
                                }
                            }, gapComposer4);
                            final byte b3 = 1;
                            final Function2 function8 = this.f$18;
                            final State state3 = this.f$19;
                            ListItemKt.m300InteractiveListItemLayoutAFY4PWA(modifierPadding, this.f$11, fMo122calculateBottomPaddingD9Ej5fM, composableLambdaImplRememberComposableLambda, Expect_jvmKt.rememberComposableLambda(-1884904385, new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    byte b4 = b3;
                                    Unit unit = Unit.INSTANCE;
                                    State state4 = state3;
                                    LayoutDirection layoutDirection3 = layoutDirection2;
                                    PaddingValues paddingValues3 = paddingValues2;
                                    Composer composer3 = (Composer) obj5;
                                    switch (b4) {
                                        case 0:
                                            int iIntValue2 = ((Integer) obj6).intValue();
                                            GapComposer gapComposer5 = (GapComposer) composer3;
                                            if (!gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                                gapComposer5.skipToGroupEnd();
                                            } else {
                                                ListItemKt.m301LeadingDecoratorYv3_QuU(OffsetKt.calculateStartPadding(paddingValues3, layoutDirection3), ((Color) state4.getValue()).value, function8, gapComposer5, 0);
                                            }
                                            break;
                                        default:
                                            int iIntValue3 = ((Integer) obj6).intValue();
                                            GapComposer gapComposer6 = (GapComposer) composer3;
                                            if (!gapComposer6.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                                gapComposer6.skipToGroupEnd();
                                            } else {
                                                ListItemKt.m304TrailingDecoratorYv3_QuU(OffsetKt.calculateEndPadding(paddingValues3, layoutDirection3), ((Color) state4.getValue()).value, function8, gapComposer6, 0);
                                            }
                                            break;
                                    }
                                    return unit;
                                }
                            }, gapComposer4), Expect_jvmKt.rememberComposableLambda(1634967360, new ListItemKt$$ExternalSyntheticLambda11(this.f$22, b), gapComposer4), Expect_jvmKt.rememberComposableLambda(859871809, new ButtonKt$$ExternalSyntheticLambda1(this.f$24, this.f$25, (byte) 18), gapComposer4), Expect_jvmKt.rememberComposableLambda(84776258, new ButtonKt$$ExternalSyntheticLambda1(this.f$27, this.f$28, (byte) 19), gapComposer4), gapComposer4, 14380032);
                        } else {
                            gapComposer4.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer3), gapComposer3, 56);
                gapComposer = gapComposer3;
            }
            shape2 = animatedShapeKt$rememberAnimatedShape$1$1RememberAnimatedShape;
            r4 = z2;
            transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(new InteractiveListColorState(z, ((Boolean) mutableState4.getValue()).booleanValue()), "ListColor", gapComposer2, 48, r4);
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = transitionInstanceUpdateTransition.targetState$delegate;
            tagPayloadReader = transitionInstanceUpdateTransition.transitionState;
            InteractiveListColorState interactiveListColorState19 = (InteractiveListColorState) parcelableSnapshotMutableState2.getValue();
            gapComposer2.startReplaceGroup(519559029);
            long jM293containerColorXeAY9LY2 = listItemColors.m293containerColorXeAY9LY(interactiveListColorState19.enabled, interactiveListColorState19.dragged);
            gapComposer2.end(r4);
            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(jM293containerColorXeAY9LY2);
            zChanged = gapComposer2.changed(colorSpaceM483getColorSpaceimpl);
            objRememberedValue = gapComposer2.rememberedValue();
            colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
            if (zChanged) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer2);
            } else {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer2);
            }
            TwoWayConverterImpl twoWayConverterImpl7 = (TwoWayConverterImpl) objRememberedValue;
            if (transitionInstanceUpdateTransition.isSeeking()) {
                gapComposer2.startReplaceGroup(1666573488);
                zChanged24 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objM = gapComposer2.rememberedValue();
                if (zChanged24) {
                    currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot6 != null) {
                        readObserver6 = currentThreadSnapshot6.getReadObserver();
                    } else {
                        readObserver6 = null;
                    }
                    snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                    Object currentState7 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    gapComposer2.updateRememberedValue(currentState7);
                    objM = currentState7;
                } else {
                    currentThreadSnapshot6 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot6 != null) {
                        readObserver6 = currentThreadSnapshot6.getReadObserver();
                    } else {
                        readObserver6 = null;
                    }
                    snapshotMakeCurrentNonObservable6 = Lock.makeCurrentNonObservable(currentThreadSnapshot6);
                    Object currentState8 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot6, snapshotMakeCurrentNonObservable6, readObserver6);
                    gapComposer2.updateRememberedValue(currentState8);
                    objM = currentState8;
                }
                r1 = 0;
                gapComposer2.end(false);
            } else {
                r1 = 0;
                objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
            }
            InteractiveListColorState interactiveListColorState20 = (InteractiveListColorState) objM;
            gapComposer2.startReplaceGroup(519559029);
            final Shape shape11 = shape2;
            Color colorM13 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, (boolean) r1, listItemColors.m293containerColorXeAY9LY(interactiveListColorState20.enabled, interactiveListColorState20.dragged));
            zChanged2 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, r1));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, r1));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            InteractiveListColorState interactiveListColorState21 = (InteractiveListColorState) ((State) objRememberedValue2).getValue();
            gapComposer2.startReplaceGroup(519559029);
            Color colorM14 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, (boolean) r1, listItemColors.m293containerColorXeAY9LY(interactiveListColorState21.enabled, interactiveListColorState21.dragged));
            zChanged3 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChanged3) {
                objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 10));
                gapComposer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 10));
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            gapComposer2.startReplaceGroup(1215615335);
            gapComposer2.end(false);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation7 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM13, colorM14, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl7, gapComposer2, 0);
            InteractiveListColorState interactiveListColorState22 = (InteractiveListColorState) parcelableSnapshotMutableState2.getValue();
            gapComposer2.startReplaceGroup(-154619267);
            long jM294contentColorXeAY9LY2 = listItemColors.m294contentColorXeAY9LY(interactiveListColorState22.enabled, interactiveListColorState22.dragged);
            gapComposer2.end(false);
            colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(jM294contentColorXeAY9LY2);
            zChanged4 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl2);
            objRememberedValue4 = gapComposer2.rememberedValue();
            if (zChanged4) {
                objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer2);
            } else {
                objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl2), gapComposer2);
            }
            TwoWayConverterImpl twoWayConverterImpl8 = (TwoWayConverterImpl) objRememberedValue4;
            if (transitionInstanceUpdateTransition.isSeeking()) {
                gapComposer2.startReplaceGroup(1666573488);
                zChanged23 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objM2 = gapComposer2.rememberedValue();
                if (zChanged23) {
                    currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot5 != null) {
                        readObserver5 = currentThreadSnapshot5.getReadObserver();
                    } else {
                        readObserver5 = null;
                    }
                    snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                    Object currentState9 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    gapComposer2.updateRememberedValue(currentState9);
                    objM2 = currentState9;
                } else {
                    currentThreadSnapshot5 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot5 != null) {
                        readObserver5 = currentThreadSnapshot5.getReadObserver();
                    } else {
                        readObserver5 = null;
                    }
                    snapshotMakeCurrentNonObservable5 = Lock.makeCurrentNonObservable(currentThreadSnapshot5);
                    Object currentState10 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot5, snapshotMakeCurrentNonObservable5, readObserver5);
                    gapComposer2.updateRememberedValue(currentState10);
                    objM2 = currentState10;
                }
                z3 = false;
                gapComposer2.end(false);
            } else {
                z3 = false;
                objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
            }
            InteractiveListColorState interactiveListColorState23 = (InteractiveListColorState) objM2;
            gapComposer2.startReplaceGroup(-154619267);
            Color colorM15 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z3, listItemColors.m294contentColorXeAY9LY(interactiveListColorState23.enabled, interactiveListColorState23.dragged));
            zChanged5 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChanged5) {
                objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 11));
                gapComposer2.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 11));
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            InteractiveListColorState interactiveListColorState24 = (InteractiveListColorState) ((State) objRememberedValue5).getValue();
            gapComposer2.startReplaceGroup(-154619267);
            Color colorM16 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m294contentColorXeAY9LY(interactiveListColorState24.enabled, interactiveListColorState24.dragged));
            zChanged6 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChanged6) {
                objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 12));
                gapComposer2.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 12));
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            gapComposer2.startReplaceGroup(1119846639);
            gapComposer2.end(false);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation8 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM15, colorM16, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl8, gapComposer2, 0);
            InteractiveListColorState interactiveListColorState25 = (InteractiveListColorState) parcelableSnapshotMutableState2.getValue();
            gapComposer2.startReplaceGroup(-836285680);
            long jM295leadingContentColorXeAY9LY2 = listItemColors.m295leadingContentColorXeAY9LY(interactiveListColorState25.enabled, interactiveListColorState25.dragged);
            gapComposer2.end(false);
            colorSpaceM483getColorSpaceimpl3 = Color.m483getColorSpaceimpl(jM295leadingContentColorXeAY9LY2);
            zChanged7 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl3);
            objRememberedValue7 = gapComposer2.rememberedValue();
            if (zChanged7) {
                objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer2);
            } else {
                objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl3), gapComposer2);
            }
            TwoWayConverterImpl twoWayConverterImpl9 = (TwoWayConverterImpl) objRememberedValue7;
            if (transitionInstanceUpdateTransition.isSeeking()) {
                gapComposer2.startReplaceGroup(1666573488);
                zChanged22 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objM3 = gapComposer2.rememberedValue();
                if (zChanged22) {
                    currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot4 != null) {
                        readObserver4 = currentThreadSnapshot4.getReadObserver();
                    } else {
                        readObserver4 = null;
                    }
                    snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                    Object currentState11 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    gapComposer2.updateRememberedValue(currentState11);
                    objM3 = currentState11;
                } else {
                    currentThreadSnapshot4 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot4 != null) {
                        readObserver4 = currentThreadSnapshot4.getReadObserver();
                    } else {
                        readObserver4 = null;
                    }
                    snapshotMakeCurrentNonObservable4 = Lock.makeCurrentNonObservable(currentThreadSnapshot4);
                    Object currentState12 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot4, snapshotMakeCurrentNonObservable4, readObserver4);
                    gapComposer2.updateRememberedValue(currentState12);
                    objM3 = currentState12;
                }
                z4 = false;
                gapComposer2.end(false);
            } else {
                z4 = false;
                objM3 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
            }
            InteractiveListColorState interactiveListColorState26 = (InteractiveListColorState) objM3;
            gapComposer2.startReplaceGroup(-836285680);
            Color colorM17 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z4, listItemColors.m295leadingContentColorXeAY9LY(interactiveListColorState26.enabled, interactiveListColorState26.dragged));
            zChanged8 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue8 = gapComposer2.rememberedValue();
            if (zChanged8) {
                objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 13));
                gapComposer2.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 13));
                gapComposer2.updateRememberedValue(objRememberedValue8);
            }
            InteractiveListColorState interactiveListColorState27 = (InteractiveListColorState) ((State) objRememberedValue8).getValue();
            gapComposer2.startReplaceGroup(-836285680);
            Color colorM18 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m295leadingContentColorXeAY9LY(interactiveListColorState27.enabled, interactiveListColorState27.dragged));
            zChanged9 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue9 = gapComposer2.rememberedValue();
            if (zChanged9) {
                objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 14));
                gapComposer2.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 14));
                gapComposer2.updateRememberedValue(objRememberedValue9);
            }
            gapComposer2.startReplaceGroup(438180226);
            gapComposer2.end(false);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation9 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM17, colorM18, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl9, gapComposer2, 0);
            InteractiveListColorState interactiveListColorState110 = (InteractiveListColorState) parcelableSnapshotMutableState2.getValue();
            gapComposer2.startReplaceGroup(-1629003078);
            long jM298trailingContentColorXeAY9LY2 = listItemColors.m298trailingContentColorXeAY9LY(interactiveListColorState110.enabled, interactiveListColorState110.dragged);
            gapComposer2.end(false);
            colorSpaceM483getColorSpaceimpl4 = Color.m483getColorSpaceimpl(jM298trailingContentColorXeAY9LY2);
            zChanged10 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl4);
            objRememberedValue10 = gapComposer2.rememberedValue();
            if (zChanged10) {
                objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer2);
            } else {
                objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl4), gapComposer2);
            }
            TwoWayConverterImpl twoWayConverterImpl10 = (TwoWayConverterImpl) objRememberedValue10;
            if (transitionInstanceUpdateTransition.isSeeking()) {
                gapComposer2.startReplaceGroup(1666573488);
                zChanged21 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objM4 = gapComposer2.rememberedValue();
                if (zChanged21) {
                    currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot3 != null) {
                        readObserver3 = currentThreadSnapshot3.getReadObserver();
                    } else {
                        readObserver3 = null;
                    }
                    snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                    Object currentState13 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    gapComposer2.updateRememberedValue(currentState13);
                    objM4 = currentState13;
                } else {
                    currentThreadSnapshot3 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot3 != null) {
                        readObserver3 = currentThreadSnapshot3.getReadObserver();
                    } else {
                        readObserver3 = null;
                    }
                    snapshotMakeCurrentNonObservable3 = Lock.makeCurrentNonObservable(currentThreadSnapshot3);
                    Object currentState14 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot3, snapshotMakeCurrentNonObservable3, readObserver3);
                    gapComposer2.updateRememberedValue(currentState14);
                    objM4 = currentState14;
                }
                z5 = false;
                gapComposer2.end(false);
            } else {
                z5 = false;
                objM4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
            }
            InteractiveListColorState interactiveListColorState111 = (InteractiveListColorState) objM4;
            gapComposer2.startReplaceGroup(-1629003078);
            Color colorM19 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z5, listItemColors.m298trailingContentColorXeAY9LY(interactiveListColorState111.enabled, interactiveListColorState111.dragged));
            zChanged11 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue11 = gapComposer2.rememberedValue();
            if (zChanged11) {
                objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 15));
                gapComposer2.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 15));
                gapComposer2.updateRememberedValue(objRememberedValue11);
            }
            InteractiveListColorState interactiveListColorState112 = (InteractiveListColorState) ((State) objRememberedValue11).getValue();
            gapComposer2.startReplaceGroup(-1629003078);
            Color colorM20 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m298trailingContentColorXeAY9LY(interactiveListColorState112.enabled, interactiveListColorState112.dragged));
            zChanged12 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue12 = gapComposer2.rememberedValue();
            if (zChanged12) {
                objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 16));
                gapComposer2.updateRememberedValue(objRememberedValue12);
            } else {
                objRememberedValue12 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 16));
                gapComposer2.updateRememberedValue(objRememberedValue12);
            }
            gapComposer2.startReplaceGroup(-775265656);
            gapComposer2.end(false);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation10 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM19, colorM20, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl10, gapComposer2, 0);
            InteractiveListColorState interactiveListColorState113 = (InteractiveListColorState) parcelableSnapshotMutableState2.getValue();
            gapComposer2.startReplaceGroup(984715150);
            long jM296overlineContentColorXeAY9LY2 = listItemColors.m296overlineContentColorXeAY9LY(interactiveListColorState113.enabled, interactiveListColorState113.dragged);
            gapComposer2.end(false);
            colorSpaceM483getColorSpaceimpl5 = Color.m483getColorSpaceimpl(jM296overlineContentColorXeAY9LY2);
            zChanged13 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl5);
            objRememberedValue13 = gapComposer2.rememberedValue();
            if (zChanged13) {
                objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer2);
            } else {
                objRememberedValue13 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl5), gapComposer2);
            }
            TwoWayConverterImpl twoWayConverterImpl11 = (TwoWayConverterImpl) objRememberedValue13;
            if (transitionInstanceUpdateTransition.isSeeking()) {
                gapComposer2.startReplaceGroup(1666573488);
                zChanged20 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objM5 = gapComposer2.rememberedValue();
                if (zChanged20) {
                    currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    Object currentState15 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer2.updateRememberedValue(currentState15);
                    objM5 = currentState15;
                } else {
                    currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    Object currentState16 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer2.updateRememberedValue(currentState16);
                    objM5 = currentState16;
                }
                z6 = false;
                gapComposer2.end(false);
            } else {
                z6 = false;
                objM5 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
            }
            InteractiveListColorState interactiveListColorState114 = (InteractiveListColorState) objM5;
            gapComposer2.startReplaceGroup(984715150);
            Color colorM21 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z6, listItemColors.m296overlineContentColorXeAY9LY(interactiveListColorState114.enabled, interactiveListColorState114.dragged));
            zChanged14 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue14 = gapComposer2.rememberedValue();
            if (zChanged14) {
                objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 17));
                gapComposer2.updateRememberedValue(objRememberedValue14);
            } else {
                objRememberedValue14 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 17));
                gapComposer2.updateRememberedValue(objRememberedValue14);
            }
            InteractiveListColorState interactiveListColorState115 = (InteractiveListColorState) ((State) objRememberedValue14).getValue();
            gapComposer2.startReplaceGroup(984715150);
            Color colorM110 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m296overlineContentColorXeAY9LY(interactiveListColorState115.enabled, interactiveListColorState115.dragged));
            zChanged15 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue15 = gapComposer2.rememberedValue();
            if (zChanged15) {
                objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 7));
                gapComposer2.updateRememberedValue(objRememberedValue15);
            } else {
                objRememberedValue15 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 7));
                gapComposer2.updateRememberedValue(objRememberedValue15);
            }
            gapComposer2.startReplaceGroup(1838452572);
            gapComposer2.end(false);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation11 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM21, colorM110, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl11, gapComposer2, 0);
            InteractiveListColorState interactiveListColorState116 = (InteractiveListColorState) parcelableSnapshotMutableState2.getValue();
            gapComposer2.startReplaceGroup(-1535703933);
            long jM297supportingContentColorXeAY9LY2 = listItemColors.m297supportingContentColorXeAY9LY(interactiveListColorState116.enabled, interactiveListColorState116.dragged);
            gapComposer2.end(false);
            colorSpaceM483getColorSpaceimpl6 = Color.m483getColorSpaceimpl(jM297supportingContentColorXeAY9LY2);
            zChanged16 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl6);
            objRememberedValue16 = gapComposer2.rememberedValue();
            if (zChanged16) {
                objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer2);
            } else {
                objRememberedValue16 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl6), gapComposer2);
            }
            TwoWayConverterImpl twoWayConverterImpl12 = (TwoWayConverterImpl) objRememberedValue16;
            if (transitionInstanceUpdateTransition.isSeeking()) {
                gapComposer2.startReplaceGroup(1666573488);
                zChanged19 = gapComposer2.changed(transitionInstanceUpdateTransition);
                objRememberedValue19 = gapComposer2.rememberedValue();
                if (zChanged19) {
                    currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot != null) {
                        readObserver = currentThreadSnapshot.getReadObserver();
                    } else {
                        readObserver = null;
                    }
                    snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                    Object currentState17 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer2.updateRememberedValue(currentState17);
                    objRememberedValue19 = currentState17;
                } else {
                    currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot != null) {
                        readObserver = currentThreadSnapshot.getReadObserver();
                    } else {
                        readObserver = null;
                    }
                    snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                    Object currentState18 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer2.updateRememberedValue(currentState18);
                    objRememberedValue19 = currentState18;
                }
                gapComposer2.end(false);
                Object obj3 = objRememberedValue19;
                z7 = false;
                objM6 = obj3;
            } else {
                z7 = false;
                objM6 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
            }
            InteractiveListColorState interactiveListColorState117 = (InteractiveListColorState) objM6;
            gapComposer2.startReplaceGroup(-1535703933);
            Color colorM111 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z7, listItemColors.m297supportingContentColorXeAY9LY(interactiveListColorState117.enabled, interactiveListColorState117.dragged));
            zChanged17 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue17 = gapComposer2.rememberedValue();
            if (zChanged17) {
                objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 8));
                gapComposer2.updateRememberedValue(objRememberedValue17);
            } else {
                objRememberedValue17 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 8));
                gapComposer2.updateRememberedValue(objRememberedValue17);
            }
            InteractiveListColorState interactiveListColorState118 = (InteractiveListColorState) ((State) objRememberedValue17).getValue();
            gapComposer2.startReplaceGroup(-1535703933);
            Color colorM112 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, listItemColors.m297supportingContentColorXeAY9LY(interactiveListColorState118.enabled, interactiveListColorState118.dragged));
            zChanged18 = gapComposer2.changed(transitionInstanceUpdateTransition);
            objRememberedValue18 = gapComposer2.rememberedValue();
            if (zChanged18) {
                objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 9));
                gapComposer2.updateRememberedValue(objRememberedValue18);
            } else {
                objRememberedValue18 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 9));
                gapComposer2.updateRememberedValue(objRememberedValue18);
            }
            gapComposer2.startReplaceGroup(-1432794927);
            gapComposer2.end(false);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation12 = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, colorM111, colorM112, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl12, gapComposer2, 0);
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                listItemElevation.getClass();
                f = 8.0f;
            } else {
                listItemElevation.getClass();
                f = CropImageView.DEFAULT_ASPECT_RATIO;
            }
            final AnimateAsState animateAsStateM18animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f, finiteAnimationSpecM272valueyDoVZcs3, null, gapComposer2, 0, 12);
            final Density density2 = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
            final LayoutDirection layoutDirection2 = (LayoutDirection) gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = ContentColorKt.LocalContentColor;
            Color color2 = (Color) transitionAnimationStateCreateTransitionAnimation8.getValue();
            long j2 = color2.value;
            final Function2 function7 = function5;
            GapComposer gapComposer4 = gapComposer2;
            Stack.CompositionLocalProvider(staticProvidableCompositionLocal2.defaultProvidedValue$runtime(color2), Expect_jvmKt.rememberComposableLambda(-1377981779, new Function2(function1, animateAsStateM18animateDpAsStateAjpBEmI2, density2, shape11, mutableInteractionSourceImpl, z, paddingValues, vertical, transitionAnimationStateCreateTransitionAnimation7, layoutDirection2, function2, transitionAnimationStateCreateTransitionAnimation9, function3, transitionAnimationStateCreateTransitionAnimation10, transitionAnimationStateCreateTransitionAnimation11, function7, transitionAnimationStateCreateTransitionAnimation12, composableLambdaImpl, transitionAnimationStateCreateTransitionAnimation8) { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda3
                public final /* synthetic */ Function1 f$1;
                public final /* synthetic */ PaddingValues f$10;
                public final /* synthetic */ Alignment.Vertical f$11;
                public final /* synthetic */ State f$12;
                public final /* synthetic */ LayoutDirection f$13;
                public final /* synthetic */ Function2 f$15;
                public final /* synthetic */ State f$16;
                public final /* synthetic */ Function2 f$18;
                public final /* synthetic */ State f$19;
                public final /* synthetic */ State f$22;
                public final /* synthetic */ Function2 f$24;
                public final /* synthetic */ State f$25;
                public final /* synthetic */ ComposableLambdaImpl f$27;
                public final /* synthetic */ Transition.TransitionAnimationState f$28;
                public final /* synthetic */ State f$3;
                public final /* synthetic */ Density f$4;
                public final /* synthetic */ Shape f$5;

                {
                    this.f$10 = paddingValues;
                    this.f$11 = vertical;
                    this.f$12 = transitionAnimationStateCreateTransitionAnimation7;
                    this.f$13 = layoutDirection2;
                    this.f$15 = function2;
                    this.f$16 = transitionAnimationStateCreateTransitionAnimation9;
                    this.f$18 = function3;
                    this.f$19 = transitionAnimationStateCreateTransitionAnimation10;
                    this.f$22 = transitionAnimationStateCreateTransitionAnimation11;
                    this.f$24 = function7;
                    this.f$25 = transitionAnimationStateCreateTransitionAnimation12;
                    this.f$27 = composableLambdaImpl;
                    this.f$28 = transitionAnimationStateCreateTransitionAnimation8;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    Composer composer2 = (Composer) obj4;
                    int iIntValue = ((Integer) obj5).intValue();
                    byte b = 0;
                    GapComposer gapComposer5 = (GapComposer) composer2;
                    if (gapComposer5.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Modifier modifierSemantics = SemanticsModifierKt.semantics(this.f$0, true, this.f$1);
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierThen = modifierSemantics.then(companion);
                        State state = this.f$3;
                        boolean zChanged25 = gapComposer5.changed(state);
                        Object objRememberedValue24 = gapComposer5.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        if (zChanged25 || objRememberedValue24 == neverEqualPolicy) {
                            objRememberedValue24 = new AppBarKt$$ExternalSyntheticLambda5((byte) 1, state);
                            gapComposer5.updateRememberedValue(objRememberedValue24);
                        }
                        Modifier modifierLayout = RulerKt.layout(modifierThen, new ListItemKt$$ExternalSyntheticLambda17(b, (FloatProducer) objRememberedValue24));
                        Density density3 = this.f$4;
                        boolean zChanged26 = gapComposer5.changed(density3) | gapComposer5.changed(state);
                        Shape shape12 = this.f$5;
                        boolean zChanged27 = zChanged26 | gapComposer5.changed(shape12);
                        Object objRememberedValue25 = gapComposer5.rememberedValue();
                        if (zChanged27 || objRememberedValue25 == neverEqualPolicy) {
                            objRememberedValue25 = new UtilsKt$$ExternalSyntheticLambda0((Object) density3, (Object) shape12, (Object) state, (byte) 15);
                            gapComposer5.updateRememberedValue(objRememberedValue25);
                        }
                        Modifier modifierThen2 = ClipKt.clip(ImageKt.m39backgroundbw27NRU(ColorKt.graphicsLayer(modifierLayout, (Function1) objRememberedValue25), ((Color) this.f$12.getValue()).value, shape12), shape12).then(companion);
                        final PaddingValues paddingValues2 = this.f$10;
                        Modifier modifierPadding = OffsetKt.padding(modifierThen2, paddingValues2);
                        float fMo122calculateBottomPaddingD9Ej5fM = paddingValues2.mo122calculateBottomPaddingD9Ej5fM() + paddingValues2.mo125calculateTopPaddingD9Ej5fM() + CropImageView.DEFAULT_ASPECT_RATIO;
                        final byte b2 = 0;
                        final LayoutDirection layoutDirection3 = this.f$13;
                        final Function2 function8 = this.f$15;
                        final State state2 = this.f$16;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1109808834, new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj6, Object obj7) {
                                byte b4 = b2;
                                Unit unit = Unit.INSTANCE;
                                State state4 = state2;
                                LayoutDirection layoutDirection4 = layoutDirection3;
                                PaddingValues paddingValues3 = paddingValues2;
                                Composer composer3 = (Composer) obj6;
                                switch (b4) {
                                    case 0:
                                        int iIntValue2 = ((Integer) obj7).intValue();
                                        GapComposer gapComposer6 = (GapComposer) composer3;
                                        if (!gapComposer6.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                            gapComposer6.skipToGroupEnd();
                                        } else {
                                            ListItemKt.m301LeadingDecoratorYv3_QuU(OffsetKt.calculateStartPadding(paddingValues3, layoutDirection4), ((Color) state4.getValue()).value, function8, gapComposer6, 0);
                                        }
                                        break;
                                    default:
                                        int iIntValue3 = ((Integer) obj7).intValue();
                                        GapComposer gapComposer7 = (GapComposer) composer3;
                                        if (!gapComposer7.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                            gapComposer7.skipToGroupEnd();
                                        } else {
                                            ListItemKt.m304TrailingDecoratorYv3_QuU(OffsetKt.calculateEndPadding(paddingValues3, layoutDirection4), ((Color) state4.getValue()).value, function8, gapComposer7, 0);
                                        }
                                        break;
                                }
                                return unit;
                            }
                        }, gapComposer5);
                        final byte b3 = 1;
                        final Function2 function9 = this.f$18;
                        final State state3 = this.f$19;
                        ListItemKt.m300InteractiveListItemLayoutAFY4PWA(modifierPadding, this.f$11, fMo122calculateBottomPaddingD9Ej5fM, composableLambdaImplRememberComposableLambda, Expect_jvmKt.rememberComposableLambda(-1884904385, new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj6, Object obj7) {
                                byte b4 = b3;
                                Unit unit = Unit.INSTANCE;
                                State state4 = state3;
                                LayoutDirection layoutDirection4 = layoutDirection3;
                                PaddingValues paddingValues3 = paddingValues2;
                                Composer composer3 = (Composer) obj6;
                                switch (b4) {
                                    case 0:
                                        int iIntValue2 = ((Integer) obj7).intValue();
                                        GapComposer gapComposer6 = (GapComposer) composer3;
                                        if (!gapComposer6.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                            gapComposer6.skipToGroupEnd();
                                        } else {
                                            ListItemKt.m301LeadingDecoratorYv3_QuU(OffsetKt.calculateStartPadding(paddingValues3, layoutDirection4), ((Color) state4.getValue()).value, function9, gapComposer6, 0);
                                        }
                                        break;
                                    default:
                                        int iIntValue3 = ((Integer) obj7).intValue();
                                        GapComposer gapComposer7 = (GapComposer) composer3;
                                        if (!gapComposer7.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                            gapComposer7.skipToGroupEnd();
                                        } else {
                                            ListItemKt.m304TrailingDecoratorYv3_QuU(OffsetKt.calculateEndPadding(paddingValues3, layoutDirection4), ((Color) state4.getValue()).value, function9, gapComposer7, 0);
                                        }
                                        break;
                                }
                                return unit;
                            }
                        }, gapComposer5), Expect_jvmKt.rememberComposableLambda(1634967360, new ListItemKt$$ExternalSyntheticLambda11(this.f$22, b), gapComposer5), Expect_jvmKt.rememberComposableLambda(859871809, new ButtonKt$$ExternalSyntheticLambda1(this.f$24, this.f$25, (byte) 18), gapComposer5), Expect_jvmKt.rememberComposableLambda(84776258, new ButtonKt$$ExternalSyntheticLambda1(this.f$27, this.f$28, (byte) 19), gapComposer5), gapComposer5, 14380032);
                    } else {
                        gapComposer5.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer4), gapComposer4, 56);
            gapComposer = gapComposer4;
        } else {
            gapComposer2.skipToGroupEnd();
            gapComposer = gapComposer2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    ((Integer) obj5).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    ListItemKt.InteractiveListItem(modifier, composableLambdaImpl, function2, function3, function4, vertical, z, function1, listItemColors, listItemShapes, listItemElevation, paddingValues, (Composer) obj4, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: InteractiveListItemLayout-AFY4PWA, reason: not valid java name */
    public static final void m300InteractiveListItemLayoutAFY4PWA(final Modifier modifier, final Alignment.Vertical vertical, final float f, final ComposableLambdaImpl composableLambdaImpl, final ComposableLambdaImpl composableLambdaImpl2, final ComposableLambdaImpl composableLambdaImpl3, final ComposableLambdaImpl composableLambdaImpl4, final ComposableLambdaImpl composableLambdaImpl5, Composer composer, final int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1749613557);
        int i2 = i | (gapComposer.changed(modifier) ? 4 : 2) | (gapComposer.changed(vertical) ? 32 : 16) | (gapComposer.changed(f) ? 256 : 128);
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (4793491 & i2) != 4793490)) {
            boolean z = ((i2 & 896) == 256) | ((i2 & 112) == 32);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new InteractiveListItemMeasurePolicy(vertical, f);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            InteractiveListItemMeasurePolicy interactiveListItemMeasurePolicy = (InteractiveListItemMeasurePolicy) objRememberedValue;
            ComposableLambdaImpl composableLambdaImpl6 = new ComposableLambdaImpl(true, 1271844412, new LayoutKt$$ExternalSyntheticLambda0(CollectionsKt__IterablesKt.listOf((Object[]) new Function2[]{composableLambdaImpl, composableLambdaImpl2, composableLambdaImpl3, composableLambdaImpl4, composableLambdaImpl5}), b));
            boolean zChanged = gapComposer.changed(interactiveListItemMeasurePolicy);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new MultiContentMeasurePolicyImpl(interactiveListItemMeasurePolicy);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue2;
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
            Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl6, gapComposer, true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(vertical, f, composableLambdaImpl, composableLambdaImpl2, composableLambdaImpl3, composableLambdaImpl4, composableLambdaImpl5, i) { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda16
                public final /* synthetic */ Alignment.Vertical f$1;
                public final /* synthetic */ float f$2;
                public final /* synthetic */ ComposableLambdaImpl f$3;
                public final /* synthetic */ ComposableLambdaImpl f$4;
                public final /* synthetic */ ComposableLambdaImpl f$5;
                public final /* synthetic */ ComposableLambdaImpl f$6;
                public final /* synthetic */ ComposableLambdaImpl f$7;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(14380033);
                    ListItemKt.m300InteractiveListItemLayoutAFY4PWA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: LeadingDecorator-Yv3_QuU, reason: not valid java name */
    public static final void m301LeadingDecoratorYv3_QuU(float f, long j, Function2 function2, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(724431569);
        int i2 = i | (gapComposer.changed(f) ? 4 : 2) | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(13) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024);
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.skipToGroupEnd();
        } else if (function2 != null) {
            gapComposer.startReplaceGroup(-669606954);
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
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
            float f2 = 12.0f + f + CropImageView.DEFAULT_ASPECT_RATIO;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize;
            float f3 = ((Dp) gapComposer.consume(staticProvidableCompositionLocal)).value;
            if (Float.isNaN(f3)) {
                f3 = 0.0f;
            }
            Icons$Filled.m371ProvideContentColorTextStyleKTwxG1Y(j, CardKt.getValue(13, gapComposer), new ProvidedValue[]{staticProvidableCompositionLocal.defaultProvidedValue$runtime((Dp) UuidKt.coerceAtLeast(new Dp((f3 - f2) + CropImageView.DEFAULT_ASPECT_RATIO), new Dp(CropImageView.DEFAULT_ASPECT_RATIO)))}, function2, gapComposer, ((i2 >> 3) & 14) | 512 | (i2 & 7168));
            gapComposer.end(true);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(-668935215);
            gapComposer.end(false);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda10(f, j, function2, i, (byte) 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x007e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:63:0x0112  */
    /* JADX WARN: Code duplicated, block: B:67:0x012e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0176  */
    /* JADX WARN: Code duplicated, block: B:72:0x018c  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    public static final void ListItem(Modifier modifier, boolean z, final Function2 function2, Function2 function3, Function2 function4, Alignment.Vertical vertical, ListItemShapes listItemShapes, final ListItemColors listItemColors, ListItemElevation listItemElevation, PaddingValues paddingValues, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Function2 function5;
        int i4;
        int i5;
        final Function2 function6;
        int i6;
        int i7;
        int i8;
        boolean z2;
        GapComposer gapComposer;
        final boolean z3;
        final Alignment.Vertical vertical2;
        final ListItemShapes listItemShapes2;
        final ListItemElevation listItemElevation2;
        final PaddingValues paddingValues2;
        final Modifier modifier3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i9;
        NeverEqualPolicy neverEqualPolicy;
        final Density density;
        boolean zChanged;
        Object objRememberedValue;
        Shapes shapes;
        ListItemShapes listItemShapes3;
        ListItemShapes listItemShapes4;
        int i10;
        Alignment.Vertical vertical3;
        ListItemShapes listItemShapes5;
        ListItemElevation listItemElevation3;
        PaddingValues paddingValues3;
        boolean z4;
        Object objRememberedValue2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1740297960);
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            i3 = (gapComposer2.changed(modifier2) ? 4 : 2) | i;
        }
        int i12 = i3 | 48;
        int i13 = i2 & 8;
        if (i13 == 0) {
            if ((i & 3072) == 0) {
                function5 = function3;
                i12 |= gapComposer2.changedInstance(function5) ? 2048 : 1024;
            }
            i4 = i12 | 24576;
            i5 = i2 & 32;
            if (i5 != 0) {
                if ((196608 & i) == 0) {
                    function6 = function4;
                    if (gapComposer2.changedInstance(function6)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                int i14 = i4 | 4718592;
                if (gapComposer2.changed(listItemColors)) {
                    i7 = 67108864;
                } else {
                    i7 = 33554432;
                }
                i8 = i14 | i7 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                if ((306783379 & i8) == 306783378) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i8 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i9 = i & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i9 != 0 || gapComposer2.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i13 != 0) {
                            function5 = null;
                        }
                        if (i5 != 0) {
                            function6 = null;
                        }
                        PaddingValuesImpl paddingValuesImpl = ListItemDefaults.ContentPadding;
                        density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                        zChanged = gapComposer2.changed(density);
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                                @Override // androidx.compose.ui.Alignment.Vertical
                                public final int align(int i15, int i16) {
                                    return (i16 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i15, i16);
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Alignment.Vertical vertical4 = (Alignment.Vertical) objRememberedValue;
                        shapes = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        listItemShapes3 = shapes.defaultListItemShapesCached;
                        if (listItemShapes3 == null) {
                            listItemShapes4 = new ListItemShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 4), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 12), ShapesKt.m325fromTokenCLvlw10(shapes, 7));
                            shapes.defaultListItemShapesCached = listItemShapes4;
                        } else {
                            listItemShapes4 = listItemShapes3;
                        }
                        i10 = i8 & (-1912078337);
                        vertical3 = vertical4;
                        listItemShapes5 = listItemShapes4;
                        listItemElevation3 = new ListItemElevation();
                        paddingValues3 = ListItemDefaults.ContentPadding;
                        z4 = true;
                    } else {
                        gapComposer2.skipToGroupEnd();
                        vertical3 = vertical;
                        listItemShapes5 = listItemShapes;
                        listItemElevation3 = listItemElevation;
                        paddingValues3 = paddingValues;
                        i10 = i8 & (-1912078337);
                        z4 = z;
                    }
                    Function2 function7 = function5;
                    Function2 function8 = function6;
                    gapComposer2.endDefaults();
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new CookieKt$$ExternalSyntheticLambda3((byte) 1, z4);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer = gapComposer2;
                    boolean z5 = z4;
                    Modifier modifier4 = modifier2;
                    InteractiveListItem(modifier4, composableLambdaImpl, function2, function7, function8, vertical3, z5, (Function1) objRememberedValue2, listItemColors, listItemShapes5, listItemElevation3, paddingValues3, gapComposer, (i10 & 14) | 100663728 | (i10 & 7168) | 24576 | (458752 & i10) | 12582912, (57344 & (i10 >> 12)) | 12586422);
                    modifier3 = modifier4;
                    function5 = function7;
                    function6 = function8;
                    vertical2 = vertical3;
                    z3 = z5;
                    listItemShapes2 = listItemShapes5;
                    listItemElevation2 = listItemElevation3;
                    paddingValues2 = paddingValues3;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z3 = z;
                    vertical2 = vertical;
                    listItemShapes2 = listItemShapes;
                    listItemElevation2 = listItemElevation;
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            ListItemKt.ListItem(modifier3, z3, function2, function5, function6, vertical2, listItemShapes2, listItemColors, listItemElevation2, paddingValues2, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 = 221184 | i12;
            function6 = function4;
            int i15 = i4 | 4718592;
            if (gapComposer2.changed(listItemColors)) {
                i7 = 67108864;
            } else {
                i7 = 33554432;
            }
            i8 = i15 | i7 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            if ((306783379 & i8) == 306783378) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i8 & 1, z2)) {
                gapComposer2.startDefaults();
                i9 = i & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i9 != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i5 != 0) {
                        function6 = null;
                    }
                    PaddingValuesImpl paddingValuesImpl2 = ListItemDefaults.ContentPadding;
                    density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                    zChanged = gapComposer2.changed(density);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i16, int i17) {
                                return (i17 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i16, i17);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i16, int i17) {
                                return (i17 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i16, i17);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Alignment.Vertical vertical5 = (Alignment.Vertical) objRememberedValue;
                    shapes = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    listItemShapes3 = shapes.defaultListItemShapesCached;
                    if (listItemShapes3 == null) {
                        listItemShapes4 = new ListItemShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 4), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 12), ShapesKt.m325fromTokenCLvlw10(shapes, 7));
                        shapes.defaultListItemShapesCached = listItemShapes4;
                    } else {
                        listItemShapes4 = listItemShapes3;
                    }
                    i10 = i8 & (-1912078337);
                    vertical3 = vertical5;
                    listItemShapes5 = listItemShapes4;
                    listItemElevation3 = new ListItemElevation();
                    paddingValues3 = ListItemDefaults.ContentPadding;
                    z4 = true;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i5 != 0) {
                        function6 = null;
                    }
                    PaddingValuesImpl paddingValuesImpl3 = ListItemDefaults.ContentPadding;
                    density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                    zChanged = gapComposer2.changed(density);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i16, int i17) {
                                return (i17 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i16, i17);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i16, int i17) {
                                return (i17 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i16, i17);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Alignment.Vertical vertical6 = (Alignment.Vertical) objRememberedValue;
                    shapes = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    listItemShapes3 = shapes.defaultListItemShapesCached;
                    if (listItemShapes3 == null) {
                        listItemShapes4 = new ListItemShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 4), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 12), ShapesKt.m325fromTokenCLvlw10(shapes, 7));
                        shapes.defaultListItemShapesCached = listItemShapes4;
                    } else {
                        listItemShapes4 = listItemShapes3;
                    }
                    i10 = i8 & (-1912078337);
                    vertical3 = vertical6;
                    listItemShapes5 = listItemShapes4;
                    listItemElevation3 = new ListItemElevation();
                    paddingValues3 = ListItemDefaults.ContentPadding;
                    z4 = true;
                }
                Function2 function9 = function5;
                Function2 function10 = function6;
                gapComposer2.endDefaults();
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new CookieKt$$ExternalSyntheticLambda3((byte) 1, z4);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                gapComposer = gapComposer2;
                boolean z6 = z4;
                Modifier modifier5 = modifier2;
                InteractiveListItem(modifier5, composableLambdaImpl, function2, function9, function10, vertical3, z6, (Function1) objRememberedValue2, listItemColors, listItemShapes5, listItemElevation3, paddingValues3, gapComposer, (i10 & 14) | 100663728 | (i10 & 7168) | 24576 | (458752 & i10) | 12582912, (57344 & (i10 >> 12)) | 12586422);
                modifier3 = modifier5;
                function5 = function9;
                function6 = function10;
                vertical2 = vertical3;
                z3 = z6;
                listItemShapes2 = listItemShapes5;
                listItemElevation2 = listItemElevation3;
                paddingValues2 = paddingValues3;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z3 = z;
                vertical2 = vertical;
                listItemShapes2 = listItemShapes;
                listItemElevation2 = listItemElevation;
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        ListItemKt.ListItem(modifier3, z3, function2, function5, function6, vertical2, listItemShapes2, listItemColors, listItemElevation2, paddingValues2, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i12 = i3 | 3120;
        function5 = function3;
        i4 = i12 | 24576;
        i5 = i2 & 32;
        if (i5 != 0) {
            if ((196608 & i) == 0) {
                function6 = function4;
                if (gapComposer2.changedInstance(function6)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            int i16 = i4 | 4718592;
            if (gapComposer2.changed(listItemColors)) {
                i7 = 67108864;
            } else {
                i7 = 33554432;
            }
            i8 = i16 | i7 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            if ((306783379 & i8) == 306783378) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i8 & 1, z2)) {
                gapComposer2.startDefaults();
                i9 = i & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i9 != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i5 != 0) {
                        function6 = null;
                    }
                    PaddingValuesImpl paddingValuesImpl4 = ListItemDefaults.ContentPadding;
                    density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                    zChanged = gapComposer2.changed(density);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i17, int i18) {
                                return (i18 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i17, i18);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i17, int i18) {
                                return (i18 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i17, i18);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Alignment.Vertical vertical7 = (Alignment.Vertical) objRememberedValue;
                    shapes = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    listItemShapes3 = shapes.defaultListItemShapesCached;
                    if (listItemShapes3 == null) {
                        listItemShapes4 = new ListItemShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 4), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 12), ShapesKt.m325fromTokenCLvlw10(shapes, 7));
                        shapes.defaultListItemShapesCached = listItemShapes4;
                    } else {
                        listItemShapes4 = listItemShapes3;
                    }
                    i10 = i8 & (-1912078337);
                    vertical3 = vertical7;
                    listItemShapes5 = listItemShapes4;
                    listItemElevation3 = new ListItemElevation();
                    paddingValues3 = ListItemDefaults.ContentPadding;
                    z4 = true;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i5 != 0) {
                        function6 = null;
                    }
                    PaddingValuesImpl paddingValuesImpl5 = ListItemDefaults.ContentPadding;
                    density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                    zChanged = gapComposer2.changed(density);
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i17, int i18) {
                                return (i18 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i17, i18);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                            @Override // androidx.compose.ui.Alignment.Vertical
                            public final int align(int i17, int i18) {
                                return (i18 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i17, i18);
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Alignment.Vertical vertical8 = (Alignment.Vertical) objRememberedValue;
                    shapes = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    listItemShapes3 = shapes.defaultListItemShapesCached;
                    if (listItemShapes3 == null) {
                        listItemShapes4 = new ListItemShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 4), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 12), ShapesKt.m325fromTokenCLvlw10(shapes, 7));
                        shapes.defaultListItemShapesCached = listItemShapes4;
                    } else {
                        listItemShapes4 = listItemShapes3;
                    }
                    i10 = i8 & (-1912078337);
                    vertical3 = vertical8;
                    listItemShapes5 = listItemShapes4;
                    listItemElevation3 = new ListItemElevation();
                    paddingValues3 = ListItemDefaults.ContentPadding;
                    z4 = true;
                }
                Function2 function11 = function5;
                Function2 function12 = function6;
                gapComposer2.endDefaults();
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new CookieKt$$ExternalSyntheticLambda3((byte) 1, z4);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                gapComposer = gapComposer2;
                boolean z7 = z4;
                Modifier modifier6 = modifier2;
                InteractiveListItem(modifier6, composableLambdaImpl, function2, function11, function12, vertical3, z7, (Function1) objRememberedValue2, listItemColors, listItemShapes5, listItemElevation3, paddingValues3, gapComposer, (i10 & 14) | 100663728 | (i10 & 7168) | 24576 | (458752 & i10) | 12582912, (57344 & (i10 >> 12)) | 12586422);
                modifier3 = modifier6;
                function5 = function11;
                function6 = function12;
                vertical2 = vertical3;
                z3 = z7;
                listItemShapes2 = listItemShapes5;
                listItemElevation2 = listItemElevation3;
                paddingValues2 = paddingValues3;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z3 = z;
                vertical2 = vertical;
                listItemShapes2 = listItemShapes;
                listItemElevation2 = listItemElevation;
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        ListItemKt.ListItem(modifier3, z3, function2, function5, function6, vertical2, listItemShapes2, listItemColors, listItemElevation2, paddingValues2, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 = 221184 | i12;
        function6 = function4;
        int i17 = i4 | 4718592;
        if (gapComposer2.changed(listItemColors)) {
            i7 = 67108864;
        } else {
            i7 = 33554432;
        }
        i8 = i17 | i7 | WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        if ((306783379 & i8) == 306783378) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (gapComposer2.shouldExecute(i8 & 1, z2)) {
            gapComposer2.startDefaults();
            i9 = i & 1;
            neverEqualPolicy = Composer.Companion.Empty;
            if (i9 != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i13 != 0) {
                    function5 = null;
                }
                if (i5 != 0) {
                    function6 = null;
                }
                PaddingValuesImpl paddingValuesImpl6 = ListItemDefaults.ContentPadding;
                density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                zChanged = gapComposer2.changed(density);
                objRememberedValue = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                        @Override // androidx.compose.ui.Alignment.Vertical
                        public final int align(int i18, int i19) {
                            return (i19 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i18, i19);
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                        @Override // androidx.compose.ui.Alignment.Vertical
                        public final int align(int i18, int i19) {
                            return (i19 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i18, i19);
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Alignment.Vertical vertical9 = (Alignment.Vertical) objRememberedValue;
                shapes = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                listItemShapes3 = shapes.defaultListItemShapesCached;
                if (listItemShapes3 == null) {
                    listItemShapes4 = new ListItemShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 4), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 12), ShapesKt.m325fromTokenCLvlw10(shapes, 7));
                    shapes.defaultListItemShapesCached = listItemShapes4;
                } else {
                    listItemShapes4 = listItemShapes3;
                }
                i10 = i8 & (-1912078337);
                vertical3 = vertical9;
                listItemShapes5 = listItemShapes4;
                listItemElevation3 = new ListItemElevation();
                paddingValues3 = ListItemDefaults.ContentPadding;
                z4 = true;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i13 != 0) {
                    function5 = null;
                }
                if (i5 != 0) {
                    function6 = null;
                }
                PaddingValuesImpl paddingValuesImpl7 = ListItemDefaults.ContentPadding;
                density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                zChanged = gapComposer2.changed(density);
                objRememberedValue = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                        @Override // androidx.compose.ui.Alignment.Vertical
                        public final int align(int i18, int i19) {
                            return (i19 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i18, i19);
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                        @Override // androidx.compose.ui.Alignment.Vertical
                        public final int align(int i18, int i19) {
                            return (i19 < density.mo75roundToPx0680j_4(ListItemKt.InteractiveListVerticalAlignmentBreakpoint) ? Alignment.Companion.CenterVertically : Alignment.Companion.Top).align(i18, i19);
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Alignment.Vertical vertical10 = (Alignment.Vertical) objRememberedValue;
                shapes = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                listItemShapes3 = shapes.defaultListItemShapesCached;
                if (listItemShapes3 == null) {
                    listItemShapes4 = new ListItemShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 4), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 7), ShapesKt.m325fromTokenCLvlw10(shapes, 12), ShapesKt.m325fromTokenCLvlw10(shapes, 7));
                    shapes.defaultListItemShapesCached = listItemShapes4;
                } else {
                    listItemShapes4 = listItemShapes3;
                }
                i10 = i8 & (-1912078337);
                vertical3 = vertical10;
                listItemShapes5 = listItemShapes4;
                listItemElevation3 = new ListItemElevation();
                paddingValues3 = ListItemDefaults.ContentPadding;
                z4 = true;
            }
            Function2 function13 = function5;
            Function2 function14 = function6;
            gapComposer2.endDefaults();
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new CookieKt$$ExternalSyntheticLambda3((byte) 1, z4);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            gapComposer = gapComposer2;
            boolean z8 = z4;
            Modifier modifier7 = modifier2;
            InteractiveListItem(modifier7, composableLambdaImpl, function2, function13, function14, vertical3, z8, (Function1) objRememberedValue2, listItemColors, listItemShapes5, listItemElevation3, paddingValues3, gapComposer, (i10 & 14) | 100663728 | (i10 & 7168) | 24576 | (458752 & i10) | 12582912, (57344 & (i10 >> 12)) | 12586422);
            modifier3 = modifier7;
            function5 = function13;
            function6 = function14;
            vertical2 = vertical3;
            z3 = z8;
            listItemShapes2 = listItemShapes5;
            listItemElevation2 = listItemElevation3;
            paddingValues2 = paddingValues3;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            z3 = z;
            vertical2 = vertical;
            listItemShapes2 = listItemShapes;
            listItemElevation2 = listItemElevation;
            paddingValues2 = paddingValues;
            modifier3 = modifier2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    ListItemKt.ListItem(modifier3, z3, function2, function5, function6, vertical2, listItemShapes2, listItemColors, listItemElevation2, paddingValues2, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags, i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: OverlineDecorator-rcwGITA, reason: not valid java name */
    public static final void m302OverlineDecoratorrcwGITA(long j, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(242327385);
        int i2 = (gapComposer.changed(j) ? 4 : 2) | i | (gapComposer.changed(11) ? 32 : 16) | (gapComposer.changedInstance(null) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            gapComposer.startReplaceGroup(-664553815);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListItemKt$$ExternalSyntheticLambda18(j, i);
        }
    }

    /* JADX INFO: renamed from: SupportingDecorator-rcwGITA, reason: not valid java name */
    public static final void m303SupportingDecoratorrcwGITA(long j, Function2 function2, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(430226372);
        int i2 = i | (gapComposer.changed(j) ? 4 : 2) | (gapComposer.changed(1) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128);
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            gapComposer.skipToGroupEnd();
        } else if (function2 != null) {
            gapComposer.startReplaceGroup(691586193);
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
            Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j, CardKt.getValue(1, gapComposer), function2, gapComposer, i2 & 910);
            gapComposer.end(true);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(691783198);
            gapComposer.end(false);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipKt$$ExternalSyntheticLambda13(j, function2, i, (byte) 2);
        }
    }

    /* JADX INFO: renamed from: TrailingDecorator-Yv3_QuU, reason: not valid java name */
    public static final void m304TrailingDecoratorYv3_QuU(float f, long j, Function2 function2, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1549722463);
        int i2 = i | (gapComposer.changed(f) ? 4 : 2) | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(11) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024);
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.skipToGroupEnd();
        } else if (function2 != null) {
            gapComposer.startReplaceGroup(1178612904);
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
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
            float f2 = 12.0f + f + CropImageView.DEFAULT_ASPECT_RATIO;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize;
            float f3 = ((Dp) gapComposer.consume(staticProvidableCompositionLocal)).value;
            if (Float.isNaN(f3)) {
                f3 = 0.0f;
            }
            Icons$Filled.m371ProvideContentColorTextStyleKTwxG1Y(j, CardKt.getValue(11, gapComposer), new ProvidedValue[]{staticProvidableCompositionLocal.defaultProvidedValue$runtime((Dp) UuidKt.coerceAtLeast(new Dp((f3 - f2) + CropImageView.DEFAULT_ASPECT_RATIO), new Dp(CropImageView.DEFAULT_ASPECT_RATIO)))}, function2, gapComposer, ((i2 >> 3) & 14) | 512 | (i2 & 7168));
            gapComposer.end(true);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(1179284643);
            gapComposer.end(false);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda10(f, j, function2, i, (byte) 1);
        }
    }
}
