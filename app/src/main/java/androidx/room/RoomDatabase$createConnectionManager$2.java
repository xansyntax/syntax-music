package androidx.room;

import android.content.SharedPreferences;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.viewinterop.FocusTargetInteropNode;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.util.UtilsKt;
import com.metrolist.music.utils.SyncUtils;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.JsonElementMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RoomDatabase$createConnectionManager$2 extends FunctionReferenceImpl implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoomDatabase$createConnectionManager$2(int i, Object obj, Class cls, String str, String str2, int i2, byte b) {
        super(i, obj, cls, str, str2, i2);
        this.$r8$classId = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean zIsFocused;
        boolean zIsFocused2;
        byte b = this.$r8$classId;
        byte b2 = 3;
        LazyLayoutPinnableItem lazyLayoutPinnableItem = null;
        Object[] objArr = 0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return UtilsKt.compatTransactionCoroutineExecute((RoomDatabase) this.receiver, (Continuation) obj2, (Function1) obj);
            case 1:
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                FocusStateImpl focusStateImpl2 = (FocusStateImpl) obj2;
                FocusableNode focusableNode = (FocusableNode) this.receiver;
                if (focusableNode.isAttached && (zIsFocused = focusStateImpl2.isFocused()) != focusStateImpl.isFocused()) {
                    Function1 function1 = focusableNode.onFocusChange;
                    if (function1 != null) {
                        function1.invoke(Boolean.valueOf(zIsFocused));
                    }
                    if (zIsFocused) {
                        AwaitKt.launch$default(focusableNode.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SyncUtils.AnonymousClass2(focusableNode, objArr == true ? 1 : 0, b2), 1);
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        HitTestResultKt.observeReads(focusableNode, new Recomposer$$ExternalSyntheticLambda6((Object) ref$ObjectRef, (Object) focusableNode, (byte) 4));
                        LazyLayoutPinnableItem lazyLayoutPinnableItem2 = (LazyLayoutPinnableItem) ref$ObjectRef.element;
                        if (lazyLayoutPinnableItem2 != null) {
                            lazyLayoutPinnableItem2.pin();
                        } else {
                            lazyLayoutPinnableItem2 = null;
                        }
                        focusableNode.pinnedHandle = lazyLayoutPinnableItem2;
                    } else {
                        LazyLayoutPinnableItem lazyLayoutPinnableItem3 = focusableNode.pinnedHandle;
                        if (lazyLayoutPinnableItem3 != null) {
                            lazyLayoutPinnableItem3.release();
                        }
                        focusableNode.pinnedHandle = null;
                    }
                    HitTestResultKt.invalidateSemantics(focusableNode);
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = focusableNode.interactionSource;
                    if (mutableInteractionSourceImpl != null) {
                        FocusInteraction.Focus focus = focusableNode.focusedInteraction;
                        if (zIsFocused) {
                            if (focus != null) {
                                focusableNode.emitWithFallback(mutableInteractionSourceImpl, new FocusInteraction.Unfocus(focus));
                                focusableNode.focusedInteraction = null;
                            }
                            FocusInteraction.Focus focus2 = new FocusInteraction.Focus();
                            focusableNode.emitWithFallback(mutableInteractionSourceImpl, focus2);
                            focusableNode.focusedInteraction = focus2;
                        } else if (focus != null) {
                            focusableNode.emitWithFallback(mutableInteractionSourceImpl, new FocusInteraction.Unfocus(focus));
                            focusableNode.focusedInteraction = null;
                        }
                    }
                }
                return unit;
            case 2:
                FocusStateImpl focusStateImpl3 = (FocusStateImpl) obj;
                FocusStateImpl focusStateImpl4 = (FocusStateImpl) obj2;
                FocusTargetInteropNode focusTargetInteropNode = (FocusTargetInteropNode) this.receiver;
                if (focusTargetInteropNode.isAttached && (zIsFocused2 = focusStateImpl4.isFocused()) != focusStateImpl3.isFocused()) {
                    if (zIsFocused2) {
                        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                        HitTestResultKt.observeReads(focusTargetInteropNode, new ComponentRegistry$Builder$$ExternalSyntheticLambda2(ref$ObjectRef2, focusTargetInteropNode, b2));
                        LazyLayoutPinnableItem lazyLayoutPinnableItem4 = (LazyLayoutPinnableItem) ref$ObjectRef2.element;
                        if (lazyLayoutPinnableItem4 != null) {
                            lazyLayoutPinnableItem4.pin();
                            lazyLayoutPinnableItem = lazyLayoutPinnableItem4;
                        }
                        focusTargetInteropNode.pinnedHandle = lazyLayoutPinnableItem;
                    } else {
                        LazyLayoutPinnableItem lazyLayoutPinnableItem5 = focusTargetInteropNode.pinnedHandle;
                        if (lazyLayoutPinnableItem5 != null) {
                            lazyLayoutPinnableItem5.release();
                        }
                        focusTargetInteropNode.pinnedHandle = null;
                    }
                }
                return unit;
            case 3:
                return UtilsKt.compatTransactionCoroutineExecute((RoomDatabase) this.receiver, (Continuation) obj2, (Function1) obj);
            case 4:
                ((SharedPreferences.Editor) this.receiver).putString((String) obj, (String) obj2);
                return unit;
            default:
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                int iIntValue = ((Number) obj2).intValue();
                serialDescriptor.getClass();
                JsonElementMarker jsonElementMarker = (JsonElementMarker) this.receiver;
                jsonElementMarker.getClass();
                boolean z = !serialDescriptor.isElementOptional(iIntValue) && serialDescriptor.getElementDescriptor(iIntValue).isNullable();
                jsonElementMarker.isUnmarkedNull = z;
                return Boolean.valueOf(z);
        }
    }
}
