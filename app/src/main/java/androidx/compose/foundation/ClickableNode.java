package androidx.compose.foundation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ClickableNode extends AbstractClickableNode {
    public PointerInputChange downEvent;
    public IndirectPointerInputChange indirectDownEvent;

    public final void cancelInput(boolean z) {
        if (z) {
            this.indirectDownEvent = null;
        } else {
            this.downEvent = null;
        }
        handlePressInteractionCancel(z);
        this.gestureState = "idle";
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onCancelIndirectPointerInput() {
        cancelInput(true);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        HoverInteraction$Enter hoverInteraction$Enter;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null && (hoverInteraction$Enter = this.hoverInteraction) != null) {
            mutableInteractionSourceImpl.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
        }
        this.hoverInteraction = null;
        cancelInput(false);
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
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass == PointerEventPass.Final) {
                if (this.indirectDownEvent != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) arrayList.get(i);
                        if (indirectPointerInputChange.isConsumed && indirectPointerInputChange != this.indirectDownEvent) {
                            cancelInput(true);
                            break;
                        }
                    }
                }
                if (Intrinsics.areEqual(this.gestureState, "recognized")) {
                    this.gestureState = "idle";
                    return;
                }
                return;
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
                        this.gestureState = "waiting";
                        handlePressInteractionStart(indirectPointerInputChange3);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        int size3 = arrayList.size();
        for (int i3 = 0; i3 < size3; i3++) {
            IndirectPointerInputChange indirectPointerInputChange4 = (IndirectPointerInputChange) arrayList.get(i3);
            if (indirectPointerInputChange4.isConsumed || !indirectPointerInputChange4.previousPressed || indirectPointerInputChange4.pressed) {
                float touchSlop = ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getTouchSlop();
                int size4 = arrayList.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    IndirectPointerInputChange indirectPointerInputChange5 = (IndirectPointerInputChange) arrayList.get(i4);
                    long j = indirectPointerInputChange5.position;
                    IndirectPointerInputChange indirectPointerInputChange6 = this.indirectDownEvent;
                    indirectPointerInputChange6.getClass();
                    boolean z = Math.abs(Offset.m435getDistanceimpl(Offset.m438minusMKHz9U(j, indirectPointerInputChange6.position))) > touchSlop;
                    if (indirectPointerInputChange5.isConsumed || z) {
                        cancelInput(true);
                        return;
                    }
                }
                return;
            }
        }
        ((IndirectPointerInputChange) arrayList.get(0)).isConsumed = true;
        if (this.enabled) {
            this.gestureState = "recognized";
            IndirectPointerInputChange indirectPointerInputChange7 = this.indirectDownEvent;
            indirectPointerInputChange7.getClass();
            m23handlePressInteractionRelease3MmeM6k(indirectPointerInputChange7.position, true);
            performClick();
        }
        this.indirectDownEvent = null;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        super.mo27onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass == PointerEventPass.Final) {
                if (this.downEvent != null) {
                    List list = pointerEvent.changes;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        PointerInputChange pointerInputChange = (PointerInputChange) list.get(i);
                        if (pointerInputChange.isConsumed() && pointerInputChange != this.downEvent) {
                            cancelInput(false);
                            break;
                        }
                    }
                }
                if (Intrinsics.areEqual(this.gestureState, "recognized")) {
                    this.gestureState = "idle";
                    return;
                }
                return;
            }
            return;
        }
        if (this.downEvent == null) {
            if (TapGestureDetectorKt.isChangedToDown$default(pointerEvent, true)) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) pointerEvent.changes.get(0);
                pointerInputChange2.consume();
                this.downEvent = pointerInputChange2;
                if (this.enabled) {
                    this.gestureState = "waiting";
                    handlePressInteractionStart(pointerInputChange2);
                    return;
                }
                return;
            }
            return;
        }
        List list2 = pointerEvent.changes;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (!PointerIconKt.changedToUp((PointerInputChange) list2.get(i2))) {
                long jM21getExtendedTouchPaddinghWWAJMo = m21getExtendedTouchPaddinghWWAJMo(j);
                int size3 = list2.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    PointerInputChange pointerInputChange3 = (PointerInputChange) list2.get(i3);
                    if (pointerInputChange3.isConsumed() || PointerIconKt.m588isOutOfBoundsjwHxaWs(pointerInputChange3, j, jM21getExtendedTouchPaddinghWWAJMo)) {
                        cancelInput(false);
                        return;
                    }
                }
                return;
            }
        }
        ((PointerInputChange) list2.get(0)).consume();
        if (this.enabled) {
            this.gestureState = "recognized";
            PointerInputChange pointerInputChange4 = this.downEvent;
            pointerInputChange4.getClass();
            m23handlePressInteractionRelease3MmeM6k(pointerInputChange4.position, false);
            performClick();
        }
        this.downEvent = null;
    }
}
