package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.lyrics.LyricsEntry;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NewMenuComponentsKt$NewActionButton$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $performAction$delegate;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewMenuComponentsKt$NewActionButton$1$1(MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$performAction$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.$performAction$delegate;
        switch (b) {
            case 0:
                return new NewMenuComponentsKt$NewActionButton$1$1(mutableState, continuation, (byte) 0);
            default:
                return new NewMenuComponentsKt$NewActionButton$1$1(mutableState, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((NewMenuComponentsKt$NewActionButton$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                break;
            default:
                ((NewMenuComponentsKt$NewActionButton$1$1) create((Unit) obj, (Continuation) obj2)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$performAction$delegate;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                mutableState.setValue(Boolean.FALSE);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                Iterator it = ((List) mutableState.getValue()).iterator();
                while (it.hasNext()) {
                    ((StateFlowImpl) ((LyricsEntry) it.next()).translatedTextFlow).setValue(null);
                }
                break;
        }
        return unit;
    }
}
