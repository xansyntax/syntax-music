package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt$$ExternalSyntheticLambda6;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.RealImageLoader;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl$$ExternalSyntheticLambda0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TapGestureDetectorKt$detectTapAndPress$2$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Object $$this$coroutineScope;
    public final /* synthetic */ Function $onPress;
    public final /* synthetic */ Function $onTap;
    public final /* synthetic */ Object $pressScope;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$detectTapAndPress$2$1(ScrollKt$$ExternalSyntheticLambda0 scrollKt$$ExternalSyntheticLambda0, CancellableContinuationImpl$$ExternalSyntheticLambda0 cancellableContinuationImpl$$ExternalSyntheticLambda0, Function2 function2, Function0 function0, AppBarKt$$ExternalSyntheticLambda8 appBarKt$$ExternalSyntheticLambda8, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.L$1 = scrollKt$$ExternalSyntheticLambda0;
        this.$$this$coroutineScope = cancellableContinuationImpl$$ExternalSyntheticLambda0;
        this.$onPress = function2;
        this.$onTap = function0;
        this.$pressScope = appBarKt$$ExternalSyntheticLambda8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$pressScope;
        Function function = this.$onTap;
        Function function2 = this.$onPress;
        Object obj3 = this.$$this$coroutineScope;
        switch (b) {
            case 0:
                TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$1 = new TapGestureDetectorKt$detectTapAndPress$2$1(obj3, function2, function, obj2, continuation, (byte) 0);
                tapGestureDetectorKt$detectTapAndPress$2$1.L$0 = obj;
                return tapGestureDetectorKt$detectTapAndPress$2$1;
            case 1:
                TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$2 = new TapGestureDetectorKt$detectTapAndPress$2$1((ScrollKt$$ExternalSyntheticLambda0) this.L$1, (CancellableContinuationImpl$$ExternalSyntheticLambda0) obj3, (Function2) function2, (Function0) function, (AppBarKt$$ExternalSyntheticLambda8) obj2, continuation);
                tapGestureDetectorKt$detectTapAndPress$2$2.L$0 = obj;
                return tapGestureDetectorKt$detectTapAndPress$2$2;
            case 2:
                TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$3 = new TapGestureDetectorKt$detectTapAndPress$2$1(obj3, function2, function, obj2, continuation, (byte) 2);
                tapGestureDetectorKt$detectTapAndPress$2$3.L$0 = obj;
                return tapGestureDetectorKt$detectTapAndPress$2$3;
            default:
                TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$4 = new TapGestureDetectorKt$detectTapAndPress$2$1(obj3, function2, function, obj2, continuation, (byte) 3);
                tapGestureDetectorKt$detectTapAndPress$2$4.L$0 = obj;
                return tapGestureDetectorKt$detectTapAndPress$2$4;
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
            case 2:
                break;
        }
        return ((TapGestureDetectorKt$detectTapAndPress$2$1) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x0128  */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (r0 == r11) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0150, code lost:
    
        if (r0 == r11) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0235, code lost:
    
        if (r1 == r11) goto L86;
     */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r7v8, types: [androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine;
        Job jobLaunch$default;
        Object objAwaitFirstDown$default;
        Continuation continuation;
        Object objWaitForUpOrCancellation;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2;
        Object objAwaitFirstDown;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3;
        Object objAwaitFirstDown$default2;
        Object objM85awaitHorizontalPointerSlopOrCancellationgDDlDlE;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine4;
        Ref$FloatRef ref$FloatRef;
        PointerInputChange pointerInputChange;
        Object objM92horizontalDragjO51t88;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine5;
        Object objAwaitFirstDown$default3;
        Object objM89awaitVerticalPointerSlopOrCancellationgDDlDlE;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine6;
        Ref$FloatRef ref$FloatRef2;
        PointerInputChange pointerInputChange2;
        Object objM98verticalDragjO51t88;
        byte b = this.$r8$classId;
        final byte b2 = 0;
        Object obj2 = this.$$this$coroutineScope;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.$pressScope;
        Function function = this.$onTap;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Function function2 = this.$onPress;
        byte b3 = 2;
        final byte b4 = 1;
        switch (b) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) obj2;
                PressGestureScopeImpl pressGestureScopeImpl = (PressGestureScopeImpl) obj3;
                byte b5 = this.label;
                Continuation continuation2 = null;
                if (b5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    jobLaunch$default = AwaitKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl, null, (byte) 1), 1);
                    this.L$0 = pointerEventHandlerCoroutine;
                    this.L$1 = jobLaunch$default;
                    this.label = (byte) 1;
                    objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine, this, 3);
                    if (objAwaitFirstDown$default != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b5 == 1) {
                    jobLaunch$default = (StandaloneCoroutine) this.L$1;
                    pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitFirstDown$default = obj;
                } else {
                    if (b5 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    jobLaunch$default = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    continuation = null;
                    objWaitForUpOrCancellation = obj;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) objWaitForUpOrCancellation;
                if (pointerInputChange3 == null) {
                    TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, new TapGestureDetectorKt.AnonymousClass3(pressGestureScopeImpl, continuation, b4));
                    return unit;
                }
                pointerInputChange3.consume();
                TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, new TapGestureDetectorKt.AnonymousClass3(pressGestureScopeImpl, continuation, b3));
                ((TooltipKt$$ExternalSyntheticLambda5) function).invoke(new Offset(pointerInputChange3.position));
                return unit;
                PointerInputChange pointerInputChange4 = (PointerInputChange) objAwaitFirstDown$default;
                pointerInputChange4.consume();
                TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1 anonymousClass1 = (TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1) function2;
                if (anonymousClass1 != TapGestureDetectorKt.NoPressGesture) {
                    RealImageLoader.AnonymousClass2 anonymousClass2 = new RealImageLoader.AnonymousClass2(anonymousClass1, pressGestureScopeImpl, pointerInputChange4, continuation2, (byte) 14, false);
                    continuation = null;
                    TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, anonymousClass2);
                } else {
                    continuation = null;
                }
                this.L$0 = jobLaunch$default;
                this.L$1 = continuation;
                this.label = (byte) 2;
                objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation(pointerEventHandlerCoroutine, PointerEventPass.Main, this);
                break;
            case 1:
                byte b6 = this.label;
                if (b6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    this.L$0 = pointerEventHandlerCoroutine2;
                    this.label = (byte) 1;
                    objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown(pointerEventHandlerCoroutine2, false, PointerEventPass.Initial, this);
                    if (objAwaitFirstDown != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b6 != 1) {
                    if (b6 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitFirstDown = obj;
                this.L$0 = null;
                this.label = (byte) 2;
                if (ScrollableKt.processDragGesture(pointerEventHandlerCoroutine2, (PointerInputChange) objAwaitFirstDown, (ScrollKt$$ExternalSyntheticLambda0) this.L$1, (CancellableContinuationImpl$$ExternalSyntheticLambda0) obj2, (Function2) function2, (Function0) function, (AppBarKt$$ExternalSyntheticLambda8) obj3, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 2:
                Function2 function3 = (Function2) function2;
                byte b7 = this.label;
                if (b7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    pointerEventHandlerCoroutine3 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    this.L$0 = pointerEventHandlerCoroutine3;
                    this.label = (byte) 1;
                    objAwaitFirstDown$default2 = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine3, this, 2);
                    if (objAwaitFirstDown$default2 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b7 != 1) {
                    if (b7 == 2) {
                        ref$FloatRef = (Ref$FloatRef) this.L$1;
                        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine7 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine7;
                        objM85awaitHorizontalPointerSlopOrCancellationgDDlDlE = obj;
                        pointerInputChange = (PointerInputChange) objM85awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                        if (pointerInputChange != null) {
                            return unit;
                        }
                        ((Function1) obj2).invoke(new Offset(pointerInputChange.position));
                        function3.invoke(pointerInputChange, new Float(ref$FloatRef.element));
                        long j = pointerInputChange.id;
                        SuspendAnimationKt$$ExternalSyntheticLambda6 suspendAnimationKt$$ExternalSyntheticLambda6 = new SuspendAnimationKt$$ExternalSyntheticLambda6(function3, (byte) 2);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = (byte) 3;
                        objM92horizontalDragjO51t88 = ScrollableKt.m92horizontalDragjO51t88(pointerEventHandlerCoroutine4, j, suspendAnimationKt$$ExternalSyntheticLambda6, this);
                    } else {
                        if (b7 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM92horizontalDragjO51t88 = obj;
                    }
                    break;
                } else {
                    pointerEventHandlerCoroutine3 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitFirstDown$default2 = obj;
                }
                if (((Boolean) objM92horizontalDragjO51t88).booleanValue()) {
                    ((Function0) function).invoke();
                    return unit;
                }
                ((Function0) obj3).invoke();
                return unit;
                PointerInputChange pointerInputChange5 = (PointerInputChange) objAwaitFirstDown$default2;
                final Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
                long j2 = pointerInputChange5.id;
                int i = pointerInputChange5.type;
                ?? r7 = new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        byte b8 = b4;
                        Unit unit2 = Unit.INSTANCE;
                        Ref$FloatRef ref$FloatRef4 = ref$FloatRef3;
                        PointerInputChange pointerInputChange6 = (PointerInputChange) obj4;
                        float fFloatValue = ((Float) obj5).floatValue();
                        switch (b8) {
                            case 0:
                                pointerInputChange6.consume();
                                ref$FloatRef4.element = fFloatValue;
                                break;
                            default:
                                pointerInputChange6.consume();
                                ref$FloatRef4.element = fFloatValue;
                                break;
                        }
                        return unit2;
                    }
                };
                this.L$0 = pointerEventHandlerCoroutine3;
                this.L$1 = ref$FloatRef3;
                this.label = (byte) 2;
                objM85awaitHorizontalPointerSlopOrCancellationgDDlDlE = ScrollableKt.m85awaitHorizontalPointerSlopOrCancellationgDDlDlE(pointerEventHandlerCoroutine3, j2, i, r7, this);
                if (objM85awaitHorizontalPointerSlopOrCancellationgDDlDlE != coroutineSingletons) {
                    pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                    ref$FloatRef = ref$FloatRef3;
                    pointerInputChange = (PointerInputChange) objM85awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                    if (pointerInputChange != null) {
                        return unit;
                    }
                    ((Function1) obj2).invoke(new Offset(pointerInputChange.position));
                    function3.invoke(pointerInputChange, new Float(ref$FloatRef.element));
                    long j3 = pointerInputChange.id;
                    SuspendAnimationKt$$ExternalSyntheticLambda6 suspendAnimationKt$$ExternalSyntheticLambda7 = new SuspendAnimationKt$$ExternalSyntheticLambda6(function3, (byte) 2);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objM92horizontalDragjO51t88 = ScrollableKt.m92horizontalDragjO51t88(pointerEventHandlerCoroutine4, j3, suspendAnimationKt$$ExternalSyntheticLambda7, this);
                    break;
                }
                return coroutineSingletons;
            default:
                MainActivity$$ExternalSyntheticLambda1 mainActivity$$ExternalSyntheticLambda1 = (MainActivity$$ExternalSyntheticLambda1) function2;
                byte b8 = this.label;
                if (b8 == 0) {
                    ResultKt.throwOnFailure(obj);
                    pointerEventHandlerCoroutine5 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    this.L$0 = pointerEventHandlerCoroutine5;
                    this.label = (byte) 1;
                    objAwaitFirstDown$default3 = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine5, this, 2);
                    if (objAwaitFirstDown$default3 != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b8 != 1) {
                    if (b8 == 2) {
                        ref$FloatRef2 = (Ref$FloatRef) this.L$1;
                        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine8 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerEventHandlerCoroutine6 = pointerEventHandlerCoroutine8;
                        objM89awaitVerticalPointerSlopOrCancellationgDDlDlE = obj;
                        pointerInputChange2 = (PointerInputChange) objM89awaitVerticalPointerSlopOrCancellationgDDlDlE;
                        if (pointerInputChange2 != null) {
                            return unit;
                        }
                        mainActivity$$ExternalSyntheticLambda1.invoke(pointerInputChange2, new Float(ref$FloatRef2.element));
                        long j4 = pointerInputChange2.id;
                        ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0 = new ScrollState$$ExternalSyntheticLambda0((byte) 10, mainActivity$$ExternalSyntheticLambda1);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = (byte) 3;
                        objM98verticalDragjO51t88 = ScrollableKt.m98verticalDragjO51t88(pointerEventHandlerCoroutine6, j4, scrollState$$ExternalSyntheticLambda0, this);
                    } else {
                        if (b8 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM98verticalDragjO51t88 = obj;
                    }
                    break;
                } else {
                    pointerEventHandlerCoroutine5 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitFirstDown$default3 = obj;
                }
                if (((Boolean) objM98verticalDragjO51t88).booleanValue()) {
                    ((GapComposer$$ExternalSyntheticLambda0) function).invoke();
                    return unit;
                }
                ((ComponentRegistry$Builder$$ExternalSyntheticLambda2) obj3).invoke();
                return unit;
                PointerInputChange pointerInputChange6 = (PointerInputChange) objAwaitFirstDown$default3;
                final Ref$FloatRef ref$FloatRef4 = new Ref$FloatRef();
                long j5 = pointerInputChange6.id;
                int i2 = pointerInputChange6.type;
                ?? r4 = new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        byte b9 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        Ref$FloatRef ref$FloatRef5 = ref$FloatRef4;
                        PointerInputChange pointerInputChange7 = (PointerInputChange) obj4;
                        float fFloatValue = ((Float) obj5).floatValue();
                        switch (b9) {
                            case 0:
                                pointerInputChange7.consume();
                                ref$FloatRef5.element = fFloatValue;
                                break;
                            default:
                                pointerInputChange7.consume();
                                ref$FloatRef5.element = fFloatValue;
                                break;
                        }
                        return unit2;
                    }
                };
                this.L$0 = pointerEventHandlerCoroutine5;
                this.L$1 = ref$FloatRef4;
                this.label = (byte) 2;
                objM89awaitVerticalPointerSlopOrCancellationgDDlDlE = ScrollableKt.m89awaitVerticalPointerSlopOrCancellationgDDlDlE(pointerEventHandlerCoroutine5, j5, i2, r4, this);
                if (objM89awaitVerticalPointerSlopOrCancellationgDDlDlE != coroutineSingletons) {
                    pointerEventHandlerCoroutine6 = pointerEventHandlerCoroutine5;
                    ref$FloatRef2 = ref$FloatRef4;
                    pointerInputChange2 = (PointerInputChange) objM89awaitVerticalPointerSlopOrCancellationgDDlDlE;
                    if (pointerInputChange2 != null) {
                        return unit;
                    }
                    mainActivity$$ExternalSyntheticLambda1.invoke(pointerInputChange2, new Float(ref$FloatRef2.element));
                    long j6 = pointerInputChange2.id;
                    ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda1 = new ScrollState$$ExternalSyntheticLambda0((byte) 10, mainActivity$$ExternalSyntheticLambda1);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objM98verticalDragjO51t88 = ScrollableKt.m98verticalDragjO51t88(pointerEventHandlerCoroutine6, j6, scrollState$$ExternalSyntheticLambda1, this);
                    break;
                }
                return coroutineSingletons;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TapGestureDetectorKt$detectTapAndPress$2$1(Object obj, Function function, Function function2, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$$this$coroutineScope = obj;
        this.$onPress = function;
        this.$onTap = function2;
        this.$pressScope = obj2;
    }
}
