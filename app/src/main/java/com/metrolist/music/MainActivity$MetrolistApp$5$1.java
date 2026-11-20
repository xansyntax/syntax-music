package com.metrolist.music;

import android.graphics.Bitmap;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import coil3.Extras;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.SingletonImageLoader;
import coil3.UriKt;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.request.CachePolicy;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.theme.ThemeKt;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity$MetrolistApp$5$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $enableDynamicTheme$delegate;
    public /* synthetic */ Object $playerConnection;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ long $selectedThemeColor;
    public final /* synthetic */ Object $themeColor$delegate;
    public final /* synthetic */ Object $themeColorCache;
    public boolean label;
    public final /* synthetic */ Object this$0;

    /* JADX INFO: renamed from: com.metrolist.music.MainActivity$MetrolistApp$5$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ long $selectedThemeColor;
        public final /* synthetic */ MutableState $themeColor$delegate;
        public final /* synthetic */ Map $themeColorCache;
        public /* synthetic */ Object L$0;
        public Color L$1;
        public byte label;
        public final /* synthetic */ MainActivity this$0;

        /* JADX INFO: renamed from: com.metrolist.music.MainActivity$MetrolistApp$5$1$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class C00062 extends SuspendLambda implements Function2 {
            public final /* synthetic */ long $selectedThemeColor;
            public final /* synthetic */ MediaMetadata $song;
            public final /* synthetic */ MutableState $themeColor$delegate;
            public final /* synthetic */ Map $themeColorCache;
            public long J$0;
            public byte label;
            public final /* synthetic */ MainActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00062(MainActivity mainActivity, MediaMetadata mediaMetadata, long j, Map map, MutableState mutableState, Continuation continuation) {
                super(2, continuation);
                this.this$0 = mainActivity;
                this.$song = mediaMetadata;
                this.$selectedThemeColor = j;
                this.$themeColorCache = map;
                this.$themeColor$delegate = mutableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00062(this.this$0, this.$song, this.$selectedThemeColor, this.$themeColorCache, this.$themeColor$delegate, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ((C00062) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
            
                if (androidx.compose.runtime.Stack.getMonotonicFrameClock(getContext()).withFrameNanos(r11, r10) == r9) goto L31;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                long jExtractThemeColor;
                Bitmap bitmap$default;
                MainActivity mainActivity = this.this$0;
                byte b = this.label;
                MutableState mutableState = this.$themeColor$delegate;
                long j = this.$selectedThemeColor;
                MediaMetadata mediaMetadata = this.$song;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                try {
                    if (b != 0) {
                        if (b == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b != 2) {
                                if (b != 3) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ResultKt.throwOnFailure(obj);
                                mutableState.setValue(new Color(j));
                                return Unit.INSTANCE;
                            }
                            jExtractThemeColor = this.J$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        mutableState.setValue(new Color(jExtractThemeColor));
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    RealImageLoader realImageLoader = SingletonImageLoader.get(mainActivity);
                    ImageRequest.Builder builder = new ImageRequest.Builder(mainActivity);
                    builder.data = mediaMetadata.thumbnailUrl;
                    ImageRequests_androidKt.allowHardware(builder);
                    CachePolicy cachePolicy = CachePolicy.ENABLED;
                    builder.memoryCachePolicy = cachePolicy;
                    builder.diskCachePolicy = cachePolicy;
                    builder.networkCachePolicy = cachePolicy;
                    Extras.Key key = ImageRequestsKt.transformationsKey;
                    ImageRequests_androidKt.crossfade(builder, 0);
                    ImageRequest imageRequestBuild = builder.build();
                    this.label = (byte) 1;
                    obj = realImageLoader.execute(imageRequestBuild, this);
                    if (obj == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                    Image image = ((ImageResult) obj).getImage();
                    jExtractThemeColor = (image == null || (bitmap$default = UriKt.toBitmap$default(image)) == null) ? j : ThemeKt.extractThemeColor(bitmap$default);
                    this.$themeColorCache.put(mediaMetadata.thumbnailUrl, new Color(jExtractThemeColor));
                    KuGouKt$$ExternalSyntheticLambda0 kuGouKt$$ExternalSyntheticLambda0 = new KuGouKt$$ExternalSyntheticLambda0((byte) 24);
                    this.J$0 = jExtractThemeColor;
                    this.label = (byte) 2;
                    if (Stack.getMonotonicFrameClock(getContext()).withFrameNanos(kuGouKt$$ExternalSyntheticLambda0, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    mutableState.setValue(new Color(jExtractThemeColor));
                } catch (Exception unused) {
                    KuGouKt$$ExternalSyntheticLambda0 kuGouKt$$ExternalSyntheticLambda1 = new KuGouKt$$ExternalSyntheticLambda0((byte) 25);
                    this.label = (byte) 3;
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map map, long j, MutableState mutableState, MainActivity mainActivity, Continuation continuation) {
            super(2, continuation);
            this.$themeColorCache = map;
            this.$selectedThemeColor = j;
            this.$themeColor$delegate = mutableState;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$themeColorCache, this.$selectedThemeColor, this.$themeColor$delegate, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((MediaMetadata) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Color color;
            MediaMetadata mediaMetadata = (MediaMetadata) this.L$0;
            byte b = this.label;
            Unit unit = Unit.INSTANCE;
            MutableState mutableState = this.$themeColor$delegate;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                if ((mediaMetadata != null ? mediaMetadata.thumbnailUrl : null) == null) {
                    mutableState.setValue(new Color(this.$selectedThemeColor));
                    return unit;
                }
                Color color2 = (Color) this.$themeColorCache.get(mediaMetadata.thumbnailUrl);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (color2 != null) {
                    KuGouKt$$ExternalSyntheticLambda0 kuGouKt$$ExternalSyntheticLambda0 = new KuGouKt$$ExternalSyntheticLambda0((byte) 23);
                    this.L$0 = null;
                    this.L$1 = color2;
                    this.label = (byte) 1;
                    if (Stack.getMonotonicFrameClock(getContext()).withFrameNanos(kuGouKt$$ExternalSyntheticLambda0, this) != coroutineSingletons) {
                        color = color2;
                    }
                } else {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    C00062 c00062 = new C00062(this.this$0, mediaMetadata, this.$selectedThemeColor, this.$themeColorCache, this.$themeColor$delegate, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = (byte) 2;
                    if (AwaitKt.withContext(defaultIoScheduler, c00062, this) != coroutineSingletons) {
                        return unit;
                    }
                }
                return coroutineSingletons;
            }
            if (b != 1) {
                if (b == 2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            color = this.L$1;
            ResultKt.throwOnFailure(obj);
            mutableState.setValue(new Color(color.value));
            return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$MetrolistApp$5$1(PlatformSelectionBehaviors platformSelectionBehaviors, String str, long j, TextRange textRange, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping, Continuation continuation) {
        super(2, continuation);
        this.$playerConnection = platformSelectionBehaviors;
        this.$enableDynamicTheme$delegate = str;
        this.$selectedThemeColor = j;
        this.$themeColor$delegate = textRange;
        this.$themeColorCache = textFieldSelectionManager;
        this.this$0 = offsetMapping;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.this$0;
        Object obj3 = this.$themeColorCache;
        Object obj4 = this.$themeColor$delegate;
        Object obj5 = this.$enableDynamicTheme$delegate;
        switch (b) {
            case 0:
                return new MainActivity$MetrolistApp$5$1((PlayerConnection) this.$playerConnection, this.$selectedThemeColor, (DataStoreKt$rememberPreference$1$1) obj5, (MutableState) obj4, (Map) obj3, (MainActivity) obj2, continuation);
            case 1:
                MainActivity$MetrolistApp$5$1 mainActivity$MetrolistApp$5$1 = new MainActivity$MetrolistApp$5$1((UpdatableAnimationState) obj5, (ContentInViewNode) obj4, (BringIntoViewSpec) obj3, this.$selectedThemeColor, (Job) obj2, continuation);
                mainActivity$MetrolistApp$5$1.$playerConnection = obj;
                return mainActivity$MetrolistApp$5$1;
            default:
                return new MainActivity$MetrolistApp$5$1((PlatformSelectionBehaviors) this.$playerConnection, (String) obj5, this.$selectedThemeColor, (TextRange) obj4, (TextFieldSelectionManager) obj3, (OffsetMapping) obj2, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((MainActivity$MetrolistApp$5$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((MainActivity$MetrolistApp$5$1) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((MainActivity$MetrolistApp$5$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objWithContext;
        byte b = this.$r8$classId;
        long j = this.$selectedThemeColor;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.$themeColorCache;
        Object obj3 = this.$enableDynamicTheme$delegate;
        Object obj4 = this.this$0;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.$themeColor$delegate;
        byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    PlayerConnection playerConnection = (PlayerConnection) this.$playerConnection;
                    int i = MainActivity.$r8$clinit;
                    if (!((Boolean) ((DataStoreKt$rememberPreference$1$1) obj3).getValue()).booleanValue() || playerConnection == null) {
                        ((MutableState) obj5).setValue(new Color(j));
                    } else {
                        StateFlowImpl stateFlowImpl = playerConnection.service.currentMediaMetadata;
                        MainActivity$$ExternalSyntheticLambda30 mainActivity$$ExternalSyntheticLambda30 = new MainActivity$$ExternalSyntheticLambda30((byte) 2);
                        InstantKt$$ExternalSyntheticLambda0 instantKt$$ExternalSyntheticLambda0 = StateFlowKt.defaultKeySelector;
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, mainActivity$$ExternalSyntheticLambda30);
                        DistinctFlowImpl distinctFlowImplDistinctUntilChangedBy$FlowKt__DistinctKt = StateFlowKt.distinctUntilChangedBy$FlowKt__DistinctKt(stateFlowImpl, instantKt$$ExternalSyntheticLambda0, mainActivity$$ExternalSyntheticLambda30);
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2((Map) obj2, this.$selectedThemeColor, (MutableState) obj5, (MainActivity) obj4, null);
                        this.label = true;
                        if (StateFlowKt.collectLatest(distinctFlowImplDistinctUntilChangedBy$FlowKt__DistinctKt, anonymousClass2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
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
                BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) obj2;
                ContentInViewNode contentInViewNode = (ContentInViewNode) obj5;
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) obj3;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) this.$playerConnection;
                    updatableAnimationState.value = contentInViewNode.m58calculateScrollDeltaI_oMVgE(bringIntoViewSpec, j);
                    UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0(contentInViewNode, updatableAnimationState, (Job) obj4, scrollingLogic$nestedScrollScope$1);
                    GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0 = new GapComposer$$ExternalSyntheticLambda0(contentInViewNode, updatableAnimationState, bringIntoViewSpec, b2);
                    this.label = true;
                    if (updatableAnimationState.animateToZero(utilsKt$$ExternalSyntheticLambda0, gapComposer$$ExternalSyntheticLambda0, this) == coroutineSingletons) {
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
                OffsetMapping offsetMapping = (OffsetMapping) obj4;
                String str = (String) obj3;
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj2;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    PlatformSelectionBehaviors platformSelectionBehaviors = (PlatformSelectionBehaviors) this.$playerConnection;
                    this.label = true;
                    PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) platformSelectionBehaviors;
                    platformSelectionBehaviorsImpl.getClass();
                    if (str.length() == 0) {
                        objWithContext = null;
                    } else {
                        long j2 = this.$selectedThemeColor;
                        if (TextRange.m741getCollapsedimpl(j2)) {
                            objWithContext = null;
                        } else {
                            objWithContext = AwaitKt.withContext(platformSelectionBehaviorsImpl.coroutineContext, new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2(platformSelectionBehaviorsImpl, new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(j2, platformSelectionBehaviorsImpl, str, null), null), this);
                        }
                    }
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objWithContext = obj;
                    str = str;
                }
                TextRange textRange = (TextRange) objWithContext;
                if (textRange != null) {
                    long j3 = textRange.packedValue;
                    long jTextRange = TextRangeKt.TextRange(offsetMapping.transformedToOriginal((int) (j3 >> 32)), offsetMapping.transformedToOriginal((int) (j3 & 4294967295L)));
                    if (!TextRange.m739equalsimpl(jTextRange, (TextRange) obj5) && Intrinsics.areEqual(textFieldSelectionManager.getValue$foundation().annotatedString.text, str) && offsetMapping == textFieldSelectionManager.offsetMapping) {
                        textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m230createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().annotatedString, jTextRange));
                        textFieldSelectionManager.latestSelection = new TextRange(jTextRange);
                    }
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$MetrolistApp$5$1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, long j, Job job, Continuation continuation) {
        super(2, continuation);
        this.$enableDynamicTheme$delegate = updatableAnimationState;
        this.$themeColor$delegate = contentInViewNode;
        this.$themeColorCache = bringIntoViewSpec;
        this.$selectedThemeColor = j;
        this.this$0 = job;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$MetrolistApp$5$1(PlayerConnection playerConnection, long j, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState, Map map, MainActivity mainActivity, Continuation continuation) {
        super(2, continuation);
        this.$playerConnection = playerConnection;
        this.$selectedThemeColor = j;
        this.$enableDynamicTheme$delegate = dataStoreKt$rememberPreference$1$1;
        this.$themeColor$delegate = mutableState;
        this.$themeColorCache = map;
        this.this$0 = mainActivity;
    }
}
