package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoundEffect;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import coil3.RealImageLoader;
import coil3.network.NetworkFetcher;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, SemanticsModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, IndirectPointerInputModifierNode, GestureConnection {
    public long centerOffset;
    public final MutableLongObjectMap currentKeyPressInteractions;
    public StandaloneCoroutine delayJob;
    public boolean enabled;
    public final FocusableNode focusableNode;
    public GestureNode gestureNode;
    public String gestureState = "idle";
    public HoverInteraction$Enter hoverInteraction;
    public DelegatableNode indicationNode;
    public IndicationNodeFactory indicationNodeFactory;
    public PressInteraction.Press indirectPointerPressInteraction;
    public MutableInteractionSourceImpl interactionSource;
    public boolean lazilyCreateIndication;
    public IndicationNodeFactory localIndicationNodeFactory;
    public Function0 onClick;
    public String onClickLabel;
    public PressInteraction.Press pressInteraction;
    public Role role;
    public boolean useLocalIndication;
    public MutableInteractionSourceImpl userProvidedInteractionSource;

    public AbstractClickableNode(MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.indicationNodeFactory = indicationNodeFactory;
        this.useLocalIndication = z;
        this.onClickLabel = str;
        this.role = role;
        this.enabled = z2;
        this.onClick = function0;
        this.focusableNode = new FocusableNode(mutableInteractionSourceImpl, 0, new NetworkFetcher.AnonymousClass2(1, this, AbstractClickableNode.class, "onFocusChange", "onFocusChange(Z)V", 0, (byte) 1));
        int i = LongObjectMapKt.$r8$clinit;
        this.currentKeyPressInteractions = new MutableLongObjectMap(6);
        this.centerOffset = 0L;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.interactionSource;
        this.userProvidedInteractionSource = mutableInteractionSourceImpl2;
        this.lazilyCreateIndication = mutableInteractionSourceImpl2 == null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.role;
        if (role != null) {
            SemanticsPropertiesKt.m718setRolekuIjeqM(semanticsPropertyReceiver, role.value);
        }
        String str = this.onClickLabel;
        AbstractClickableNode$$ExternalSyntheticLambda0 abstractClickableNode$$ExternalSyntheticLambda0 = new AbstractClickableNode$$ExternalSyntheticLambda0(this, (byte) 1);
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(str, abstractClickableNode$$ExternalSyntheticLambda0));
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        } else {
            semanticsPropertyReceiver.set(SemanticsProperties.Disabled, Unit.INSTANCE);
        }
        applyAdditionalSemantics(semanticsPropertyReceiver);
    }

    public final boolean delayPressInteraction() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.traverseAncestors(this, GestureNode.TraverseKey, new CodecsKt$$ExternalSyntheticLambda0(new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, (byte) 1), (byte) 6));
        if (ref$ObjectRef.element == null) {
            int i = Clickable_androidKt.$r8$clinit;
            ViewParent parent = HitTestResultKt.requireView(this).getParent();
            while (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (!viewGroup.shouldDelayChildPressedState()) {
                    parent = viewGroup.getParent();
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[LOOP:0: B:16:0x0037->B:26:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0076 A[EDGE_INSN: B:30:0x0076->B:27:0x0076 BREAK  A[LOOP:0: B:16:0x0037->B:26:0x0073], SYNTHETIC] */
    public final void disposeInteractions() {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        MutableLongObjectMap mutableLongObjectMap = this.currentKeyPressInteractions;
        if (mutableInteractionSourceImpl != null) {
            PressInteraction.Press press = this.pressInteraction;
            if (press != null) {
                mutableInteractionSourceImpl.tryEmit(new PressInteraction.Cancel(press));
            }
            PressInteraction.Press press2 = this.indirectPointerPressInteraction;
            if (press2 != null) {
                mutableInteractionSourceImpl.tryEmit(new PressInteraction.Cancel(press2));
            }
            HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
            if (hoverInteraction$Enter != null) {
                mutableInteractionSourceImpl.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
            }
            Object[] objArr = mutableLongObjectMap.values;
            long[] jArr = mutableLongObjectMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                mutableInteractionSourceImpl.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) objArr[(i << 3) + i3]));
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        this.pressInteraction = null;
        this.indirectPointerPressInteraction = null;
        this.hoverInteraction = null;
        mutableLongObjectMap.clear();
    }

    /* JADX INFO: renamed from: getExtendedTouchPadding-hWWAJMo, reason: not valid java name */
    public final long m21getExtendedTouchPaddinghWWAJMo(long j) {
        long jMo82toSizeXkaWNTQ = HitTestResultKt.requireLayoutNode(this).density.mo82toSizeXkaWNTQ(((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).mo649getMinimumTouchTargetSizeMYxV2XQ());
        float fMax = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Float.intBitsToFloat((int) (jMo82toSizeXkaWNTQ >> 32)) - ((int) (j >> 32))) / 2.0f;
        return (((long) Float.floatToRawIntBits(Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Float.intBitsToFloat((int) (jMo82toSizeXkaWNTQ & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32);
    }

    @Override // androidx.compose.foundation.GestureConnection
    /* JADX INFO: renamed from: getGestureState-7meUWtM, reason: not valid java name */
    public final String mo22getGestureState7meUWtM() {
        return this.gestureState;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    public final void handlePressInteractionCancel(boolean z) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            StandaloneCoroutine standaloneCoroutine = this.delayJob;
            Continuation continuation = null;
            if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
                PressInteraction.Press press = z ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    Job job = (Job) ((ContextScope) getCoroutineScope()).coroutineContext.get(Job.Key.$$INSTANCE);
                    AwaitKt.launch$default(getCoroutineScope(), null, null, new RealImageLoader.AnonymousClass2(mutableInteractionSourceImpl, cancel, job != null ? job.invokeOnCompletion(new BackHandlerKt$$ExternalSyntheticLambda2(mutableInteractionSourceImpl, cancel, (byte) 10)) : null, continuation, (byte) 4, false), 3);
                }
            } else {
                StandaloneCoroutine standaloneCoroutine2 = this.delayJob;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel(null);
                }
            }
            if (z) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    /* JADX INFO: renamed from: handlePressInteractionRelease-3MmeM6k, reason: not valid java name */
    public final void m23handlePressInteractionRelease3MmeM6k(long j, boolean z) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            StandaloneCoroutine standaloneCoroutine = this.delayJob;
            if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
                PressInteraction.Press press = z ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(press, mutableInteractionSourceImpl, null), 3);
                }
            } else {
                standaloneCoroutine.cancel(null);
                AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1((Object) standaloneCoroutine, j, mutableInteractionSourceImpl, (Continuation) null, (byte) 0), 3);
            }
            if (z) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    public final void handlePressInteractionStart(IndirectPointerInputChange indirectPointerInputChange) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            PressInteraction.Press press = new PressInteraction.Press(indirectPointerInputChange.position);
            Continuation continuation = null;
            if (delayPressInteraction()) {
                this.delayJob = AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$1(mutableInteractionSourceImpl, press, this, continuation, (byte) 0), 3);
            } else {
                this.indirectPointerPressInteraction = press;
                AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSourceImpl, press, null, (byte) 0), 3);
            }
        }
    }

    public final void initializeIndicationAndInteractionSourceIfNeeded() {
        if (this.indicationNode != null) {
            return;
        }
        IndicationNodeFactory indicationNodeFactory = this.useLocalIndication ? this.localIndicationNodeFactory : this.indicationNodeFactory;
        if (indicationNodeFactory != null) {
            MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
            if (mutableInteractionSourceImpl == null) {
                mutableInteractionSourceImpl = new MutableInteractionSourceImpl();
                this.interactionSource = mutableInteractionSourceImpl;
            }
            this.focusableNode.update(mutableInteractionSourceImpl);
            MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.interactionSource;
            mutableInteractionSourceImpl2.getClass();
            DelegatableNode delegatableNodeCreate = indicationNodeFactory.create(mutableInteractionSourceImpl2);
            delegate(delegatableNodeCreate);
            this.indicationNode = delegatableNodeCreate;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        onObservedReadsChanged();
        if (!this.lazilyCreateIndication) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            delegate(this.focusableNode);
        }
    }

    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo, reason: not valid java name */
    public boolean mo24onClickKeyDownEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo, reason: not valid java name */
    public void mo25onClickKeyUpEventZmokQxo(KeyEvent keyEvent) {
        performClick();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource == null) {
            this.interactionSource = null;
        }
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
        GestureNode gestureNode = this.gestureNode;
        if (gestureNode != null) {
            undelegate(gestureNode);
        }
        this.gestureNode = null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0077 A[RETURN] */
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
    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo26onKeyEventZmokQxo(KeyEvent keyEvent) {
        boolean z;
        initializeIndicationAndInteractionSourceIfNeeded();
        long jM580getKeyZmokQxo = Key.m580getKeyZmokQxo(keyEvent);
        boolean z2 = this.enabled;
        MutableLongObjectMap mutableLongObjectMap = this.currentKeyPressInteractions;
        if (z2 && Key.m581getTypeZmokQxo(keyEvent) == 2 && ImageKt.m49isEnterZmokQxo(keyEvent)) {
            if (mutableLongObjectMap.containsKey(jM580getKeyZmokQxo)) {
                z = false;
            } else {
                PressInteraction.Press press = new PressInteraction.Press(this.centerOffset);
                mutableLongObjectMap.set(jM580getKeyZmokQxo, press);
                if (this.interactionSource != null) {
                    AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, press, null, (byte) 0), 3);
                }
                z = true;
            }
            if (mo24onClickKeyDownEventZmokQxo(keyEvent) || z) {
                return true;
            }
            return false;
        }
        if (this.enabled && Key.m581getTypeZmokQxo(keyEvent) == 1 && ImageKt.m49isEnterZmokQxo(keyEvent)) {
            PressInteraction.Press press2 = (PressInteraction.Press) mutableLongObjectMap.remove(jM580getKeyZmokQxo);
            if (press2 != null) {
                if (this.interactionSource != null) {
                    AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, press2, null, (byte) 3), 3);
                }
                mo25onClickKeyUpEventZmokQxo(keyEvent);
            }
            if (press2 != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        if (this.useLocalIndication) {
            HitTestResultKt.observeReads(this, new AbstractClickableNode$$ExternalSyntheticLambda0(this, (byte) 0));
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        long jM866getCenterozmzZPI = SizeKt.m866getCenterozmzZPI(j);
        this.centerOffset = (((long) Float.floatToRawIntBits((int) (jM866getCenterozmzZPI & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (jM866getCenterozmzZPI >> 32)) << 32);
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled) {
            if (this.gestureNode == null) {
                GestureNode gestureNode = new GestureNode(this);
                delegate(gestureNode);
                this.gestureNode = gestureNode;
            }
            if (pointerEventPass == PointerEventPass.Main) {
                int i = pointerEvent.type;
                Continuation continuation = null;
                if (i == 4) {
                    AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, continuation, (byte) 0), 3);
                } else if (i == 5) {
                    AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, continuation, (byte) 1), 3);
                }
            }
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo28onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    public final void performClick() {
        SoundEffect soundEffect = (SoundEffect) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalSoundEffect);
        if (soundEffect != null) {
            soundEffect.playClickSound();
        }
        this.onClick.invoke();
    }

    /* JADX INFO: renamed from: updateCommon-O2vRcR0, reason: not valid java name */
    public final void m29updateCommonO2vRcR0(MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0) {
        boolean z3;
        boolean z4;
        DelegatableNode delegatableNode;
        boolean z5 = true;
        if (Intrinsics.areEqual(this.userProvidedInteractionSource, mutableInteractionSourceImpl)) {
            z3 = false;
        } else {
            disposeInteractions();
            this.userProvidedInteractionSource = mutableInteractionSourceImpl;
            this.interactionSource = mutableInteractionSourceImpl;
            z3 = true;
        }
        if (!Intrinsics.areEqual(this.indicationNodeFactory, indicationNodeFactory)) {
            this.indicationNodeFactory = indicationNodeFactory;
            z3 = true;
        }
        if (this.useLocalIndication != z) {
            this.useLocalIndication = z;
            if (z) {
                onObservedReadsChanged();
            }
            z3 = true;
        }
        boolean z6 = this.enabled;
        FocusableNode focusableNode = this.focusableNode;
        if (z6 != z2) {
            if (z2) {
                delegate(focusableNode);
            } else {
                undelegate(focusableNode);
                disposeInteractions();
            }
            HitTestResultKt.invalidateSemantics(this);
            if (!z2) {
                DelegatableNode delegatableNode2 = this.gestureNode;
                if (delegatableNode2 != null) {
                    undelegate(delegatableNode2);
                }
                this.gestureNode = null;
                this.gestureState = "idle";
            }
            this.enabled = z2;
        }
        if (!Intrinsics.areEqual(this.onClickLabel, str)) {
            this.onClickLabel = str;
            HitTestResultKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual(this.role, role)) {
            this.role = role;
            HitTestResultKt.invalidateSemantics(this);
        }
        this.onClick = function0;
        boolean z7 = this.lazilyCreateIndication;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.userProvidedInteractionSource;
        if (z7 == (mutableInteractionSourceImpl2 == null)) {
            z5 = z3;
            z4 = z7;
        } else {
            z4 = mutableInteractionSourceImpl2 == null;
            this.lazilyCreateIndication = z4;
            if (z4 || this.indicationNode != null) {
                z7 = z4;
                z5 = z3;
                z4 = z7;
            }
        }
        if (z5 && ((delegatableNode = this.indicationNode) != null || !z4)) {
            if (delegatableNode != null) {
                undelegate(delegatableNode);
            }
            this.indicationNode = null;
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        focusableNode.update(this.interactionSource);
    }

    public void onCancelKeyInput() {
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public final void handlePressInteractionStart(PointerInputChange pointerInputChange) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            PressInteraction.Press press = new PressInteraction.Press(pointerInputChange.position);
            Continuation continuation = null;
            if (delayPressInteraction()) {
                this.delayJob = AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$1(mutableInteractionSourceImpl, press, this, continuation, (byte) 1), 3);
            } else {
                this.pressInteraction = press;
                AwaitKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSourceImpl, press, null, (byte) 2), 3);
            }
        }
    }
}
