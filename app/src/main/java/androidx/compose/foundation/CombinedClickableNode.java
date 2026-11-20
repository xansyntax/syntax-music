package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CombinedClickableNode extends AbstractClickableNode {
    public final MutableLongObjectMap doubleKeyClickStates;
    public PointerInputChange downEvent;
    public long firstTapUpTime;
    public boolean hapticFeedbackEnabled;
    public boolean ignoreNextUp;
    public IndirectPointerInputChange indirectDownEvent;
    public long indirectFirstTapUpTime;
    public boolean indirectIgnoreNextUp;
    public boolean indirectIsSecondTap;
    public StandaloneCoroutine indirectLongPressJob;
    public boolean indirectLongPressTriggered;
    public StandaloneCoroutine indirectTapJob;
    public boolean isSecondTap;
    public final MutableLongObjectMap longKeyPressJobs;
    public StandaloneCoroutine longPressJob;
    public boolean longPressTriggered;
    public Function0 onLongClick;
    public String onLongClickLabel;
    public StandaloneCoroutine tapJob;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class DoubleKeyClickState {
    }

    public CombinedClickableNode(IndicationNodeFactory indicationNodeFactory, MutableInteractionSourceImpl mutableInteractionSourceImpl, Role role, String str, Function0 function0, Function0 function1, boolean z, boolean z2) {
        super(mutableInteractionSourceImpl, indicationNodeFactory, z, z2, null, role, function0);
        this.onLongClickLabel = str;
        this.onLongClick = function1;
        this.hapticFeedbackEnabled = true;
        int i = LongObjectMapKt.$r8$clinit;
        this.longKeyPressJobs = new MutableLongObjectMap(6);
        this.doubleKeyClickStates = new MutableLongObjectMap(6);
        this.firstTapUpTime = -1L;
        this.indirectFirstTapUpTime = -1L;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.onLongClick != null) {
            String str = this.onLongClickLabel;
            SliderState$$ExternalSyntheticLambda0 sliderState$$ExternalSyntheticLambda0 = new SliderState$$ExternalSyntheticLambda0((byte) 6, this);
            KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
            semanticsPropertyReceiver.set(SemanticsActions.OnLongClick, new AccessibilityAction(str, sliderState$$ExternalSyntheticLambda0));
        }
    }

    public final void cancelInput$1(boolean z) {
        if (z) {
            this.indirectDownEvent = null;
            StandaloneCoroutine standaloneCoroutine = this.indirectLongPressJob;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            this.indirectLongPressJob = null;
            StandaloneCoroutine standaloneCoroutine2 = this.indirectTapJob;
            if (standaloneCoroutine2 != null) {
                standaloneCoroutine2.cancel(null);
            }
            this.indirectTapJob = null;
            this.indirectIsSecondTap = false;
            this.indirectLongPressTriggered = false;
            this.indirectFirstTapUpTime = -1L;
            this.indirectIgnoreNextUp = false;
        } else {
            this.downEvent = null;
            StandaloneCoroutine standaloneCoroutine3 = this.longPressJob;
            if (standaloneCoroutine3 != null) {
                standaloneCoroutine3.cancel(null);
            }
            this.longPressJob = null;
            StandaloneCoroutine standaloneCoroutine4 = this.tapJob;
            if (standaloneCoroutine4 != null) {
                standaloneCoroutine4.cancel(null);
            }
            this.tapJob = null;
            this.isSecondTap = false;
            this.longPressTriggered = false;
            this.firstTapUpTime = -1L;
            this.ignoreNextUp = false;
        }
        handlePressInteractionCancel(z);
    }

    public final void handleUpEvent(long j, IndirectPointerInputChange indirectPointerInputChange) {
        if (this.enabled && !this.indirectIgnoreNextUp) {
            m23handlePressInteractionRelease3MmeM6k(indirectPointerInputChange.position, true);
            this.indirectFirstTapUpTime = j;
            if (!this.indirectLongPressTriggered && !this.indirectIsSecondTap) {
                performClick();
            }
        }
        this.indirectDownEvent = null;
        this.indirectIgnoreNextUp = false;
        this.indirectIsSecondTap = false;
        StandaloneCoroutine standaloneCoroutine = this.indirectLongPressJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.indirectLongPressJob = null;
        this.indirectLongPressTriggered = false;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onCancelIndirectPointerInput() {
        cancelInput$1(true);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void onCancelKeyInput() {
        resetKeyPressState();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        HoverInteraction$Enter hoverInteraction$Enter;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null && (hoverInteraction$Enter = this.hoverInteraction) != null) {
            mutableInteractionSourceImpl.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
        }
        this.hoverInteraction = null;
        cancelInput$1(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo */
    public final boolean mo24onClickKeyDownEventZmokQxo(KeyEvent keyEvent) {
        boolean z;
        long jM580getKeyZmokQxo = Key.m580getKeyZmokQxo(keyEvent);
        Continuation continuation = null;
        if (this.onLongClick != null) {
            MutableLongObjectMap mutableLongObjectMap = this.longKeyPressJobs;
            if (mutableLongObjectMap.get(jM580getKeyZmokQxo) == null) {
                mutableLongObjectMap.set(jM580getKeyZmokQxo, AwaitKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$handleDownEvent$1(this, continuation, (byte) 2), 3));
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo */
    public final void mo25onClickKeyUpEventZmokQxo(KeyEvent keyEvent) {
        long jM580getKeyZmokQxo = Key.m580getKeyZmokQxo(keyEvent);
        MutableLongObjectMap mutableLongObjectMap = this.longKeyPressJobs;
        boolean z = false;
        if (mutableLongObjectMap.get(jM580getKeyZmokQxo) != null) {
            Job job = (Job) mutableLongObjectMap.get(jM580getKeyZmokQxo);
            if (job != null) {
                if (job.isActive()) {
                    job.cancel(null);
                } else {
                    z = true;
                }
            }
            mutableLongObjectMap.remove(jM580getKeyZmokQxo);
        }
        if (z) {
            return;
        }
        performClick();
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onIndirectPointerEvent(StatusLine statusLine, PointerEventPass pointerEventPass) {
        ArrayList arrayList = (ArrayList) statusLine.protocol;
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled && this.gestureNode == null) {
            GestureNode gestureNode = new GestureNode(this);
            delegate(gestureNode);
            this.gestureNode = gestureNode;
        }
        byte b = 1;
        int i = 0;
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass != PointerEventPass.Final || this.indirectDownEvent == null || this.indirectLongPressTriggered) {
                return;
            }
            int size = arrayList.size();
            while (i < size) {
                IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) arrayList.get(i);
                if (indirectPointerInputChange.isConsumed && indirectPointerInputChange != this.indirectDownEvent) {
                    cancelInput$1(true);
                    return;
                }
                i++;
            }
            return;
        }
        if (this.indirectDownEvent == null) {
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                IndirectPointerInputChange indirectPointerInputChange2 = (IndirectPointerInputChange) arrayList.get(i2);
                if (!indirectPointerInputChange2.previousPressed && indirectPointerInputChange2.pressed) {
                    IndirectPointerInputChange indirectPointerInputChange3 = (IndirectPointerInputChange) arrayList.get(0);
                    indirectPointerInputChange3.isConsumed = true;
                    this.indirectDownEvent = indirectPointerInputChange3;
                    if (this.enabled) {
                        StandaloneCoroutine standaloneCoroutine = this.indirectTapJob;
                        Continuation continuation = null;
                        if (standaloneCoroutine != null && standaloneCoroutine.isActive()) {
                            if (indirectPointerInputChange3.uptimeMillis - this.indirectFirstTapUpTime < ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getDoubleTapMinTimeMillis()) {
                                this.indirectIgnoreNextUp = true;
                                return;
                            }
                            this.indirectIsSecondTap = true;
                            StandaloneCoroutine standaloneCoroutine2 = this.indirectTapJob;
                            if (standaloneCoroutine2 != null) {
                                standaloneCoroutine2.cancel(null);
                            }
                            this.indirectTapJob = null;
                        }
                        this.indirectLongPressTriggered = false;
                        handlePressInteractionStart(indirectPointerInputChange3);
                        if (this.onLongClick != null) {
                            this.indirectLongPressJob = AwaitKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$handleDownEvent$1(this, continuation, b), 3);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.indirectLongPressTriggered) {
            int size3 = arrayList.size();
            for (int i3 = 0; i3 < size3; i3++) {
                IndirectPointerInputChange indirectPointerInputChange4 = (IndirectPointerInputChange) arrayList.get(i3);
                if (!indirectPointerInputChange4.previousPressed || indirectPointerInputChange4.pressed) {
                    int size4 = arrayList.size();
                    while (i < size4) {
                        ((IndirectPointerInputChange) arrayList.get(i)).isConsumed = true;
                        i++;
                    }
                    return;
                }
            }
            IndirectPointerInputChange indirectPointerInputChange5 = (IndirectPointerInputChange) arrayList.get(0);
            indirectPointerInputChange5.isConsumed = true;
            long j = indirectPointerInputChange5.uptimeMillis;
            IndirectPointerInputChange indirectPointerInputChange6 = this.indirectDownEvent;
            indirectPointerInputChange6.getClass();
            handleUpEvent(j, indirectPointerInputChange6);
            return;
        }
        int size5 = arrayList.size();
        for (int i4 = 0; i4 < size5; i4++) {
            IndirectPointerInputChange indirectPointerInputChange7 = (IndirectPointerInputChange) arrayList.get(i4);
            if (indirectPointerInputChange7.isConsumed || !indirectPointerInputChange7.previousPressed || indirectPointerInputChange7.pressed) {
                float touchSlop = ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getTouchSlop();
                int size6 = arrayList.size();
                for (int i5 = 0; i5 < size6; i5++) {
                    IndirectPointerInputChange indirectPointerInputChange8 = (IndirectPointerInputChange) arrayList.get(i5);
                    long j2 = indirectPointerInputChange8.position;
                    IndirectPointerInputChange indirectPointerInputChange9 = this.indirectDownEvent;
                    indirectPointerInputChange9.getClass();
                    boolean z = Math.abs(Offset.m435getDistanceimpl(Offset.m438minusMKHz9U(j2, indirectPointerInputChange9.position))) > touchSlop;
                    if (indirectPointerInputChange8.isConsumed || z) {
                        cancelInput$1(true);
                        return;
                    }
                }
                return;
            }
        }
        IndirectPointerInputChange indirectPointerInputChange10 = (IndirectPointerInputChange) arrayList.get(0);
        indirectPointerInputChange10.isConsumed = true;
        long j3 = indirectPointerInputChange10.uptimeMillis;
        IndirectPointerInputChange indirectPointerInputChange11 = this.indirectDownEvent;
        indirectPointerInputChange11.getClass();
        handleUpEvent(j3, indirectPointerInputChange11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        super.mo27onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        Object[] objArr = 0;
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass != PointerEventPass.Final || this.downEvent == null || this.longPressTriggered) {
                return;
            }
            List list = pointerEvent.changes;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = (PointerInputChange) list.get(i);
                if (pointerInputChange.isConsumed() && pointerInputChange != this.downEvent) {
                    cancelInput$1(false);
                    return;
                }
            }
            return;
        }
        Continuation continuation = null;
        if (this.downEvent == null) {
            if (TapGestureDetectorKt.isChangedToDown$default(pointerEvent, true)) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) pointerEvent.changes.get(0);
                pointerInputChange2.consume();
                this.downEvent = pointerInputChange2;
                if (this.enabled) {
                    StandaloneCoroutine standaloneCoroutine = this.tapJob;
                    if (standaloneCoroutine != null && standaloneCoroutine.isActive()) {
                        if (pointerInputChange2.uptimeMillis - this.firstTapUpTime < ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getDoubleTapMinTimeMillis()) {
                            this.ignoreNextUp = true;
                            return;
                        }
                        this.isSecondTap = true;
                        StandaloneCoroutine standaloneCoroutine2 = this.tapJob;
                        if (standaloneCoroutine2 != null) {
                            standaloneCoroutine2.cancel(null);
                        }
                        this.tapJob = null;
                    }
                    this.longPressTriggered = false;
                    handlePressInteractionStart(pointerInputChange2);
                    if (this.onLongClick != null) {
                        this.longPressJob = AwaitKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$handleDownEvent$1(this, continuation, objArr == true ? 1 : 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        Object[] objArr2 = pointerEvent.classification == 2;
        List list2 = pointerEvent.changes;
        if (objArr2 != false && !this.longPressTriggered && this.enabled && this.onLongClick != null) {
            StandaloneCoroutine standaloneCoroutine3 = this.longPressJob;
            if (standaloneCoroutine3 != null) {
                standaloneCoroutine3.cancel(null);
            }
            this.longPressJob = null;
            Function0 function0 = this.onLongClick;
            if (function0 != null) {
                function0.invoke();
            }
            if (this.hapticFeedbackEnabled) {
                ((PlatformHapticFeedback) ((HapticFeedback) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalHapticFeedback))).m578performHapticFeedbackCdsT49E(0);
            }
            this.longPressTriggered = true;
        }
        if (this.longPressTriggered) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (!PointerIconKt.changedToUpIgnoreConsumed((PointerInputChange) list2.get(i2))) {
                    int size3 = list2.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        ((PointerInputChange) list2.get(i3)).consume();
                    }
                    return;
                }
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) list2.get(0);
            pointerInputChange3.consume();
            long j2 = pointerInputChange3.uptimeMillis;
            PointerInputChange pointerInputChange4 = this.downEvent;
            pointerInputChange4.getClass();
            handleUpEvent(j2, pointerInputChange4);
            return;
        }
        int size4 = list2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            if (!PointerIconKt.changedToUp((PointerInputChange) list2.get(i4))) {
                long jM21getExtendedTouchPaddinghWWAJMo = m21getExtendedTouchPaddinghWWAJMo(j);
                int size5 = list2.size();
                for (int i5 = 0; i5 < size5; i5++) {
                    PointerInputChange pointerInputChange5 = (PointerInputChange) list2.get(i5);
                    if (pointerInputChange5.isConsumed() || PointerIconKt.m588isOutOfBoundsjwHxaWs(pointerInputChange5, j, jM21getExtendedTouchPaddinghWWAJMo)) {
                        cancelInput$1(false);
                        return;
                    }
                }
                return;
            }
        }
        PointerInputChange pointerInputChange6 = (PointerInputChange) list2.get(0);
        pointerInputChange6.consume();
        long j3 = pointerInputChange6.uptimeMillis;
        PointerInputChange pointerInputChange7 = this.downEvent;
        pointerInputChange7.getClass();
        handleUpEvent(j3, pointerInputChange7);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        resetKeyPressState();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x009f A[LOOP:2: B:24:0x0071->B:35:0x009f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:36:0x00a2 BREAK  A[LOOP:2: B:24:0x0071->B:35:0x009f], SYNTHETIC] */
    public final void resetKeyPressState() {
        char c;
        long j;
        long j2;
        MutableLongObjectMap mutableLongObjectMap = this.longKeyPressJobs;
        Object[] objArr = mutableLongObjectMap.values;
        long[] jArr = mutableLongObjectMap.metadata;
        int length = jArr.length - 2;
        char c2 = 7;
        if (length >= 0) {
            int i = 0;
            j = 128;
            while (true) {
                long j3 = jArr[i];
                j2 = 255;
                if ((((~j3) << c2) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i3 = 0;
                    while (i3 < i2) {
                        if ((j3 & 255) < 128) {
                            ((Job) objArr[(i << 3) + i3]).cancel(null);
                        }
                        j3 >>= 8;
                        i3++;
                        c2 = c2;
                    }
                    c = c2;
                    if (i2 != 8) {
                        break;
                    }
                } else {
                    c = c2;
                }
                if (i == length) {
                    break;
                }
                i++;
                c2 = c;
            }
        } else {
            c = 7;
            j = 128;
            j2 = 255;
        }
        mutableLongObjectMap.clear();
        MutableLongObjectMap mutableLongObjectMap2 = this.doubleKeyClickStates;
        Object[] objArr2 = mutableLongObjectMap2.values;
        long[] jArr2 = mutableLongObjectMap2.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i4 = 0;
            while (true) {
                long j4 = jArr2[i4];
                if ((((~j4) << c) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i4 != length2) {
                        break;
                        break;
                    }
                    i4++;
                } else {
                    int i5 = 8 - ((~(i4 - length2)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((j4 & j2) < j) {
                            ((DoubleKeyClickState) objArr2[(i4 << 3) + i6]).getClass();
                            throw null;
                        }
                        j4 >>= 8;
                    }
                    if (i5 != 8) {
                        break;
                    } else if (i4 != length2) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        mutableLongObjectMap2.clear();
    }

    public final void handleUpEvent(long j, PointerInputChange pointerInputChange) {
        if (this.enabled && !this.ignoreNextUp) {
            m23handlePressInteractionRelease3MmeM6k(pointerInputChange.position, false);
            this.firstTapUpTime = j;
            if (!this.longPressTriggered && !this.isSecondTap) {
                performClick();
            }
        }
        this.downEvent = null;
        this.ignoreNextUp = false;
        this.isSecondTap = false;
        StandaloneCoroutine standaloneCoroutine = this.longPressJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.longPressJob = null;
        this.longPressTriggered = false;
    }
}
