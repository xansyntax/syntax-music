package androidx.compose.material3;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda49;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuKt$expandable$1$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Object $onExpandedChange;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExposedDropdownMenuKt$expandable$1$1(Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$onExpandedChange = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$onExpandedChange;
        switch (b) {
            case 0:
                ExposedDropdownMenuKt$expandable$1$1 exposedDropdownMenuKt$expandable$1$1 = new ExposedDropdownMenuKt$expandable$1$1((PlayerKt$$ExternalSyntheticLambda49) obj2, continuation, (byte) 0);
                exposedDropdownMenuKt$expandable$1$1.L$0 = obj;
                return exposedDropdownMenuKt$expandable$1$1;
            case 1:
                ExposedDropdownMenuKt$expandable$1$1 exposedDropdownMenuKt$expandable$1$2 = new ExposedDropdownMenuKt$expandable$1$1((AndroidEdgeEffectOverscrollEffect) obj2, continuation, (byte) 1);
                exposedDropdownMenuKt$expandable$1$2.L$0 = obj;
                return exposedDropdownMenuKt$expandable$1$2;
            default:
                ExposedDropdownMenuKt$expandable$1$1 exposedDropdownMenuKt$expandable$1$3 = new ExposedDropdownMenuKt$expandable$1$1((Function1) obj2, continuation, (byte) 2);
                exposedDropdownMenuKt$expandable$1$3.L$0 = obj;
                return exposedDropdownMenuKt$expandable$1$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((ExposedDropdownMenuKt$expandable$1$1) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00eb A[LOOP:1: B:42:0x00d7->B:46:0x00eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a9 -> B:35:0x00ad). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
