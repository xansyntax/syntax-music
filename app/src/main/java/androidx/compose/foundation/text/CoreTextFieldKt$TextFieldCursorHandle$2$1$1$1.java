package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ TextDragObserver $observer;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PointerInputScope $this_pointerInput;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_pointerInput = pointerInputScope;
        this.$observer = textDragObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1(this.$this_pointerInput, this.$observer, continuation, (byte) 0);
            case 1:
                return new CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1(this.$this_pointerInput, this.$observer, continuation, (byte) 1);
            default:
                return new CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1(this.$this_pointerInput, this.$observer, continuation, (byte) 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        PointerInputScope pointerInputScope = this.$this_pointerInput;
        final TextDragObserver textDragObserver = this.$observer;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = null;
        final byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objCoroutineScope = AwaitKt.coroutineScope(new SyncUtils$createPlaylist$1.AnonymousClass1(pointerInputScope, textDragObserver, continuation, b2), this);
                    if (objCoroutineScope != coroutineSingletons) {
                        objCoroutineScope = unit;
                    }
                    if (objCoroutineScope == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new ForEachGestureKt$awaitEachGesture$2(textDragObserver, null), this);
                    if (objAwaitEachGesture != coroutineSingletons) {
                        objAwaitEachGesture = unit;
                    }
                    if (objAwaitEachGesture == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    final byte b3 = 0;
                    Object objDetectDragGestures = ScrollableKt.detectDragGestures(this.$this_pointerInput, new LongPressTextDragObserverKt$$ExternalSyntheticLambda0(textDragObserver, (byte) 0), new Function0() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b4 = b3;
                            Unit unit2 = Unit.INSTANCE;
                            TextDragObserver textDragObserver2 = textDragObserver;
                            switch (b4) {
                                case 0:
                                    textDragObserver2.onStop();
                                    break;
                                default:
                                    textDragObserver2.onCancel();
                                    break;
                            }
                            return unit2;
                        }
                    }, new Function0() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b4 = b2;
                            Unit unit2 = Unit.INSTANCE;
                            TextDragObserver textDragObserver2 = textDragObserver;
                            switch (b4) {
                                case 0:
                                    textDragObserver2.onStop();
                                    break;
                                default:
                                    textDragObserver2.onCancel();
                                    break;
                            }
                            return unit2;
                        }
                    }, new ComposerKt$$ExternalSyntheticLambda0((byte) 8, textDragObserver), this);
                    if (objDetectDragGestures != coroutineSingletons) {
                        objDetectDragGestures = unit;
                    }
                    if (objDetectDragGestures == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
        }
    }
}
