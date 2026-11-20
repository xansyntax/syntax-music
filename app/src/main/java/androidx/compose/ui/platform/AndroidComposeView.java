package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.view.FocusFinder;
import android.view.GestureDetector;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda5;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.IntObjectMapKt;
import androidx.collection.LongSparseArray;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterSetKt;
import androidx.collection.internal.Lock;
import androidx.compose.foundation.text.input.internal.RecordingInputConnection;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda40;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.retain.ForgetfulRetainedValuesStore;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex$Session;
import androidx.compose.ui.adaptive.UiMediaScopeImpl;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusPropertiesImpl;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidGraphicsContext;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.indirect.LazyHistoricalChangeList;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.HitPathTracker;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerClassification;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.InsetsListener;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OuterPlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.WindowInsetsWatcher;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.Invalidation;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeCoordinator$$ExternalSyntheticLambda2;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.platform.AndroidComposeView.RootModifierNode;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.AdjustedSemanticsNode;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi25;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi34;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.ViewFactoryHolder;
import androidx.compose.ui.window.PopupLayout$$ExternalSyntheticLambda5;
import androidx.core.view.DisplayCompat;
import androidx.core.view.ViewCompat;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider$NewInstanceFactory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.extractor.mp4.BoxParser;
import androidx.media3.session.MediaControllerHolder$$ExternalSyntheticLambda1;
import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.room.RoomDatabase$closeBarrier$1;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.sqlite.SQLite;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.ImageLoader$Builder;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.metrolist.music.ui.screens.settings.AndroidAutoSection;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.cio.ByteBufferPoolKt;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.channels.BufferedChannel$bindCancellationFun$2;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okio.FileMetadata;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, RootForTest, MatrixPositionCalculator, DefaultLifecycleObserver, OutOfFrameExecutor, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnTouchModeChangeListener, FocusListener {
    public static Method addChangeCallbackMethod;
    public static final MutableObjectList composeViews = new MutableObjectList();
    public static Method dispatchOnScrollChangedMethod;
    public static Method getAccessibilityViewIdMethod;
    public static Method getBooleanMethod;
    public static AndroidComposeView$Companion$$ExternalSyntheticLambda0 systemPropertiesChangedRunnable;
    public static Class systemPropertiesClass;
    public AndroidViewsHandler _androidViewsHandler;
    public final ParcelableSnapshotMutableState _composeViewContext$delegate;
    public ViewTreeHostDefaultProvider _hostDefaultProvider;
    public InputModeManagerImpl _inputModeManager;
    public TextInputServiceAndroid _legacyTextInputServiceAndroid;
    public Function2 _playNavigationSoundEffect;
    public View _rootView;
    public DisposableSaveableStateRegistry _savedStateRegistry;
    public DelegatingSoftwareKeyboardController _softwareKeyboardController;
    public TextInputService _textInputService;
    public AndroidTextToolbar _textToolbar;
    public final AndroidAutofill autofill;
    public final AndroidAutofillManager autofillManager;
    public final AutofillTree autofillTree;
    public final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    public boolean composeViewContextIncrementedDuringInit;
    public final ParcelableSnapshotMutableState configuration$delegate;
    public AndroidContentCaptureManager contentCaptureManager;
    public CoroutineContext coroutineContext;
    public float currentFrameRate;
    public float currentFrameRateCategory;
    public final ParcelableSnapshotMutableState density$delegate;
    public final DerivedSnapshotState derivedIsAttached$delegate;
    public final MutableObjectList dirtyLayers;
    public final AndroidDragAndDropManager dragAndDropManager;
    public final MutableObjectList endApplyChangesListeners;
    public final FocusOwnerImpl focusOwner;
    public final MutableState fontFamilyResolver$delegate;
    public boolean forceUseMatrixCache;
    public LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler;
    public final View frameRateCategoryView;
    public long globalPosition;
    public final AndroidGraphicsContext graphicsContext;
    public boolean hoverExitReceived;
    public final BoxParser.StsdData indirectPointerNavigationGestureDetector;
    public final InsetsListener insetsListener;
    public final ParcelableSnapshotMutableState isAttached$delegate;
    public boolean isDispatchingAutofillStructure;
    public boolean isDrawingContent;
    public boolean isPendingInteropViewLayoutChangeDispatch;
    public boolean keyboardModifiersRequireUpdate;
    public long lastDownPointerPosition;
    public long lastMatrixRecalculationAnimationTime;
    public float lastSetFrameRate;
    public float lastSetFrameRateCategory;
    public final WeakCache layerCache;
    public final AndroidComposeView$$ExternalSyntheticLambda4 layoutChildViewsIfNeeded;
    public final ParcelableSnapshotMutableState layoutDirection$delegate;
    public final MutableIntObjectMap layoutNodes;
    public LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry lifecycleRetainedValuesStoreOwnerEntry;
    public final DerivedSnapshotState localeList$delegate;
    public final FileMetadata measureAndLayoutDelegate;
    public final ModifierLocalManager modifierLocalManager;
    public final MotionEventAdapter motionEventAdapter;
    public boolean observationClearRequested;
    public Constraints onMeasureConstraints;
    public Function1 onReadyForComposition;
    public final ArrayDeque outOfFrameQueue;
    public final AndroidComposeView$$ExternalSyntheticLambda3 outOfFrameRunnable;
    public final AndroidComposeView$pointerIconService$1 pointerIconService;
    public final Cache.RealCacheRequest pointerInputEventProcessor;
    public MutableObjectList postponedDirtyLayers;
    public MotionEvent previousMotionEvent;
    public IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxisOverride;
    public final RectManager rectManager;
    public long relayoutTime;
    public final AndroidComposeView$$ExternalSyntheticLambda4 resendMotionEventOnLayout;
    public final Toolbar.AnonymousClass2 resendMotionEventRunnable;
    public RetainedValuesStore retainedValuesStore;
    public final LayoutNode root;
    public final ScrollCapture scrollCapture;
    public final SemanticsOwner semanticsOwner;
    public final AndroidComposeView$$ExternalSyntheticLambda3 sendHoverExitEvent;
    public boolean showLayoutBounds;
    public final OwnerSnapshotObserver snapshotObserver;
    public final boolean superclassInitComplete;
    public final AtomicReference textInputSessionMutex;
    public final Matrix tmpAndroidMatrix;
    public final float[] tmpMatrix;
    public final int[] tmpPositionArray;
    public final float[] viewToWindowMatrix;
    public boolean wasMeasuredWithMultipleConstraints;
    public long windowPosition;
    public final float[] windowToViewMatrix;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AndroidComposeViewNavigationSoundEffect implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final Object view;

        public /* synthetic */ AndroidComposeViewNavigationSoundEffect(byte b, Object obj) {
            this.$r8$classId = b;
            this.view = obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            String strM;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Object obj3 = this.view;
            switch (b) {
                case 0:
                    int i = ((FocusDirection) obj).value;
                    boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                    Integer numM408toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m408toAndroidFocusDirection3ESFkO8(i);
                    if (numM408toAndroidFocusDirection3ESFkO8 != null) {
                        int iIntValue = numM408toAndroidFocusDirection3ESFkO8.intValue();
                        try {
                            ((AndroidComposeView) obj3).playSoundEffect(Build.VERSION.SDK_INT >= 31 ? Api31Impl.getConstantForFocusDirection(iIntValue, zBooleanValue) : SoundEffectConstants.getContantForFocusDirection(iIntValue));
                            break;
                        } catch (DeadObjectException unused) {
                        }
                    }
                    return unit;
                default:
                    Composer composer = (Composer) obj;
                    int iIntValue2 = ((Number) obj2).intValue();
                    GapComposer gapComposer = (GapComposer) composer;
                    if (gapComposer.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                        int iOrdinal = ((AndroidAutoSection) obj3).ordinal();
                        if (iOrdinal == 0) {
                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer, -1000968784, R.string.liked_songs, gapComposer, false);
                        } else if (iOrdinal == 1) {
                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer, -1000966582, R.string.songs, gapComposer, false);
                        } else if (iOrdinal == 2) {
                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer, -1000964500, R.string.artists, gapComposer, false);
                        } else if (iOrdinal == 3) {
                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer, -1000962389, R.string.albums, gapComposer, false);
                        } else {
                            if (iOrdinal != 4) {
                                throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1000969942, false);
                            }
                            strM = Format$$ExternalSyntheticOutline0.m(gapComposer, -1000960210, R.string.playlists, gapComposer, false);
                        }
                        TextKt.m352TextNvy7gAk(strM, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    } else {
                        gapComposer.skipToGroupEnd();
                    }
                    return unit;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeView$textInputSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            AndroidComposeView.this.textInputSession(null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    public AndroidComposeView(Context context, ComposeViewContext composeViewContext) {
        LayoutDirection layoutDirection;
        super(context);
        this._composeViewContext$delegate = Stack.mutableStateOf$default(composeViewContext);
        this.lastDownPointerPosition = 9205357640488583168L;
        byte b = 1;
        this.superclassInitComplete = true;
        this.retainedValuesStore = ForgetfulRetainedValuesStore.INSTANCE;
        this.outOfFrameQueue = new ArrayDeque();
        byte b2 = 0;
        this.outOfFrameRunnable = new AndroidComposeView$$ExternalSyntheticLambda3(this, b2);
        this.density$delegate = new ParcelableSnapshotMutableState(MathKt.Density(context), NeverEqualPolicy.INSTANCE$1);
        this.focusOwner = new FocusOwnerImpl(this, this);
        this.coroutineContext = composeViewContext.getCompositionContext$ui().getEffectCoroutineContext();
        this.dragAndDropManager = new AndroidDragAndDropManager(new BufferedChannel$bindCancellationFun$2(3, this, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0, (byte) 1));
        this.isAttached$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        this.derivedIsAttached$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new AndroidComposeView$$ExternalSyntheticLambda4(this, b2));
        this.insetsListener = new InsetsListener(this);
        LayoutNode layoutNode = new LayoutNode(3);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setViewConfiguration(getViewConfiguration());
        layoutNode.setModifier(new ModifierNodeElement() { // from class: androidx.compose.ui.platform.AndroidComposeView$root$1$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final Modifier.Node create() {
                return this.this$0.new RootModifierNode();
            }

            public final boolean equals(Object obj) {
                return obj == this;
            }

            public final int hashCode() {
                return this.this$0.hashCode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final void update(Modifier.Node node) {
            }
        }.then(((FocusOwnerImpl) getFocusOwner()).modifier).then(m695getDragAndDropManager().modifier));
        this.root = layoutNode;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        this.layoutNodes = new MutableIntObjectMap();
        this.rectManager = new RectManager(getLayoutNodes(), this);
        this.semanticsOwner = new SemanticsOwner(getRoot(), new EmptySemanticsModifier(), getLayoutNodes());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new RoomDatabase$closeBarrier$1(0, this, InvertMatrixKt.class, "getContentCaptureSessionCompat", "getContentCaptureSessionCompat(Landroid/view/View;)Landroidx/compose/ui/contentcapture/ContentCaptureSessionWrapper;", 1, (byte) 4));
        this.graphicsContext = new AndroidGraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new MutableObjectList();
        this.motionEventAdapter = new MotionEventAdapter();
        LayoutNode root = getRoot();
        Cache.RealCacheRequest realCacheRequest = new Cache.RealCacheRequest();
        realCacheRequest.editor = root;
        realCacheRequest.cacheOut = new HitPathTracker((InnerNodeCoordinator) root.nodes.innerCoordinator);
        realCacheRequest.body = new DrawResult((byte) 24);
        realCacheRequest.this$0 = new HitTestResult();
        this.pointerInputEventProcessor = realCacheRequest;
        this.configuration$delegate = Stack.mutableStateOf$default(new Configuration(context.getResources().getConfiguration()));
        this.localeList$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new AndroidComposeView$$ExternalSyntheticLambda4(this, (byte) 3));
        this.autofill = new AndroidAutofill(this, getAutofillTree());
        this.autofillManager = new AndroidAutofillManager(new WeakCache(context, (byte) 8), getSemanticsOwner(), this, getRectManager(), context.getPackageName());
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$$ExternalSyntheticLambda0(this, b));
        this.measureAndLayoutDelegate = new FileMetadata(getRoot());
        this.globalPosition = 9223372034707292159L;
        this.tmpPositionArray = new int[]{0, 0};
        this.tmpMatrix = androidx.compose.ui.graphics.Matrix.m507constructorimpl$default();
        this.tmpAndroidMatrix = new Matrix();
        this.viewToWindowMatrix = androidx.compose.ui.graphics.Matrix.m507constructorimpl$default();
        this.windowToViewMatrix = androidx.compose.ui.graphics.Matrix.m507constructorimpl$default();
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = 9187343241974906880L;
        this.textInputSessionMutex = new AtomicReference(null);
        this.fontFamilyResolver$delegate = composeViewContext.fontFamilyResolver;
        int layoutDirection2 = context.getResources().getConfiguration().getLayoutDirection();
        int[] iArr = FocusInteropUtils_androidKt.tempCoordinates;
        LayoutDirection layoutDirection3 = LayoutDirection.Ltr;
        if (layoutDirection2 != 0) {
            layoutDirection = layoutDirection2 != 1 ? null : LayoutDirection.Rtl;
        } else {
            layoutDirection = layoutDirection3;
        }
        this.layoutDirection$delegate = Stack.mutableStateOf$default(layoutDirection != null ? layoutDirection : layoutDirection3);
        this.modifierLocalManager = new ModifierLocalManager();
        this.layerCache = new WeakCache((byte) 0);
        this.endApplyChangesListeners = new MutableObjectList();
        this.currentFrameRate = Float.NaN;
        this.currentFrameRateCategory = Float.NaN;
        this.lastSetFrameRate = Float.NaN;
        this.lastSetFrameRateCategory = Float.NaN;
        byte b3 = 4;
        this.resendMotionEventRunnable = new Toolbar.AnonymousClass2(b3, this);
        this.sendHoverExitEvent = new AndroidComposeView$$ExternalSyntheticLambda3(this, b);
        this.indirectPointerNavigationGestureDetector = new BoxParser.StsdData(context, new AndroidComposeView$$ExternalSyntheticLambda0(this, (byte) 2));
        this.resendMotionEventOnLayout = new AndroidComposeView$$ExternalSyntheticLambda4(this, b3);
        this.layoutChildViewsIfNeeded = new AndroidComposeView$$ExternalSyntheticLambda4(this, b);
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        Api26Impl.focusable(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        setOnDragListener(m695getDragAndDropManager());
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Api29Impl.disallowForceDark(this);
        }
        if (isArrEnabled$ui()) {
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            view.setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
            this.frameRateCategoryView = view;
            addView(view, -1);
        }
        this.scrollCapture = i >= 31 ? new ScrollCapture((byte) 0) : null;
        this.pointerIconService = new AndroidComposeView$pointerIconService$1(this);
    }

    public static void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    public static long m681convertMeasureSpecI7RO_PI(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return size;
        }
        if (mode == 0) {
            return 2147483647L;
        }
        if (mode == 1073741824) {
            long j = size;
            return j | (j << 32);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
        return 0L;
    }

    private final CanvasHolder getCanvasHolder() {
        return getComposeViewContext().canvasHolder;
    }

    private final boolean getDerivedIsAttached() {
        return ((Boolean) this.derivedIsAttached$delegate.getValue()).booleanValue();
    }

    private final TextInputServiceAndroid getLegacyTextInputServiceAndroid() {
        TextInputServiceAndroid textInputServiceAndroid = this._legacyTextInputServiceAndroid;
        if (textInputServiceAndroid != null) {
            return textInputServiceAndroid;
        }
        TextInputServiceAndroid textInputServiceAndroid2 = new TextInputServiceAndroid(getView(), this, new MediaControllerHolder$$ExternalSyntheticLambda1((byte) 1, this));
        this._legacyTextInputServiceAndroid = textInputServiceAndroid2;
        return textInputServiceAndroid2;
    }

    private final ComposeViewContext get_composeViewContext() {
        return (ComposeViewContext) this._composeViewContext$delegate.getValue();
    }

    public static void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui();
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            invalidateLayers((LayoutNode) objArr[i2]);
        }
    }

    public static boolean isArrEnabled$ui() {
        return Build.VERSION.SDK_INT >= 35;
    }

    public static boolean isBadMotionEvent(MotionEvent motionEvent) {
        boolean z = (Float.floatToRawIntBits(motionEvent.getX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawY()) & Integer.MAX_VALUE) >= 2139095040;
        if (!z) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                z = (Float.floatToRawIntBits(motionEvent.getX(i)) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY(i)) & Integer.MAX_VALUE) >= 2139095040 || (Build.VERSION.SDK_INT >= 29 && !Api29Impl.isValidMotionEvent(motionEvent, i));
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    public static final void resendMotionEventOnLayout$lambda$0(AndroidComposeView androidComposeView) {
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        if (motionEvent != null) {
            boolean z = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{9, 7, 8}).contains(Integer.valueOf(motionEvent.getActionMasked())) || (motionEvent.getActionMasked() == 2 && Build.VERSION.SDK_INT >= 34 && motionEvent.getClassification() == 3);
            MotionEvent motionEvent2 = androidComposeView.previousMotionEvent;
            boolean z2 = motionEvent2 != null && motionEvent2.getButtonState() == 0;
            if (z && z2) {
                androidComposeView.relayoutTime = SystemClock.uptimeMillis();
                androidComposeView.post(androidComposeView.resendMotionEventRunnable);
            }
        }
        androidComposeView.layoutChildViewsIfNeeded.invoke();
    }

    private final void setAttached(boolean z) {
        this.isAttached$delegate.setValue(Boolean.valueOf(z));
    }

    private void setDensity(Density density) {
        this.density$delegate.setValue(density);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void set_composeViewContext(ComposeViewContext composeViewContext) {
        this._composeViewContext$delegate.setValue(composeViewContext);
    }

    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int orDefault;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
        if (Intrinsics.areEqual(str, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal)) {
            int orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i, -1);
            if (orDefault2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, orDefault2);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(str, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalAfterVal) || (orDefault = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i, -1)) == -1) {
            return;
        }
        accessibilityNodeInfo.getExtras().putInt(str, orDefault);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        FocusTargetNode focusTargetNode = ((FocusOwnerImpl) getFocusOwner()).rootFocusNode;
        if (!focusTargetNode.isAttached) {
            return;
        }
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.addLayoutNodeChildren(mutableVector, node);
        } else {
            mutableVector.add(node2);
        }
        while (true) {
            int i3 = mutableVector.size;
            if (i3 == 0) {
                return;
            }
            Modifier.Node node3 = (Modifier.Node) mutableVector.removeAt(i3 - 1);
            if ((node3.aggregateChildKindSet & 1024) != 0) {
                for (Modifier.Node node4 = node3; node4 != null && node4.isAttached; node4 = node4.child) {
                    if ((node4.kindSet & 1024) != 0) {
                        Modifier.Node nodePop = node4;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            int i4 = 0;
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.isAttached && focusTargetNode2.fetchFocusProperties$ui().canFocus) {
                                    super.addFocusables(arrayList, i, i2);
                                    FocusTargetNode focusTargetNode3 = ((FocusOwnerImpl) getFocusOwner()).rootFocusNode;
                                    if (focusTargetNode3.isAttached) {
                                        if (!focusTargetNode3.node.isAttached) {
                                            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
                                        }
                                        MutableVector mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                        Modifier.Node node5 = focusTargetNode3.node;
                                        Modifier.Node node6 = node5.child;
                                        if (node6 == null) {
                                            HitTestResultKt.addLayoutNodeChildren(mutableVector3, node5);
                                        } else {
                                            mutableVector3.add(node6);
                                        }
                                        while (true) {
                                            int i5 = mutableVector3.size;
                                            if (i5 == 0) {
                                                break;
                                            }
                                            Modifier.Node node7 = (Modifier.Node) mutableVector3.removeAt(i5 - 1);
                                            if ((node7.aggregateChildKindSet & 1024) != 0) {
                                                for (Modifier.Node node8 = node7; node8 != null && node8.isAttached; node8 = node8.child) {
                                                    if ((node8.kindSet & 1024) != 0) {
                                                        Modifier.Node nodePop2 = node8;
                                                        MutableVector mutableVector4 = null;
                                                        while (nodePop2 != null) {
                                                            if (nodePop2 instanceof FocusTargetNode) {
                                                                FocusTargetNode focusTargetNode4 = (FocusTargetNode) nodePop2;
                                                                if (focusTargetNode4.isAttached) {
                                                                    FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNode4.fetchFocusProperties$ui();
                                                                    if (focusTargetNode4.isAttached && !focusTargetNode4.isInteropViewHost && focusPropertiesImplFetchFocusProperties$ui.canFocus) {
                                                                        return;
                                                                    }
                                                                }
                                                            } else if ((nodePop2.kindSet & 1024) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                                                int i6 = 0;
                                                                for (Modifier.Node node9 = ((DelegatingNode) nodePop2).delegate; node9 != null; node9 = node9.child) {
                                                                    if ((node9.kindSet & 1024) != 0) {
                                                                        i6++;
                                                                        if (i6 == 1) {
                                                                            nodePop2 = node9;
                                                                        } else {
                                                                            if (mutableVector4 == null) {
                                                                                mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                                                            }
                                                                            if (nodePop2 != null) {
                                                                                mutableVector4.add(nodePop2);
                                                                                nodePop2 = null;
                                                                            }
                                                                            mutableVector4.add(node9);
                                                                        }
                                                                    }
                                                                }
                                                                if (i6 == 1) {
                                                                }
                                                            }
                                                            nodePop2 = HitTestResultKt.pop(mutableVector4);
                                                        }
                                                    }
                                                }
                                            }
                                            HitTestResultKt.addLayoutNodeChildren(mutableVector3, node7);
                                        }
                                    }
                                    if (arrayList != null) {
                                        arrayList.remove(this);
                                        return;
                                    }
                                    return;
                                }
                            } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                for (Modifier.Node node10 = ((DelegatingNode) nodePop).delegate; node10 != null; node10 = node10.child) {
                                    if ((node10.kindSet & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodePop = node10;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(node10);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodePop = HitTestResultKt.pop(mutableVector2);
                        }
                    }
                }
            }
            HitTestResultKt.addLayoutNodeChildren(mutableVector, node3);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        view.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, i, layoutParams, true);
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        SemanticsConfiguration semanticsConfiguration;
        Function1 function1;
        Function1 function2;
        AndroidAutofillManager androidAutofillManagerM694getAutofillManager = m694getAutofillManager();
        if (androidAutofillManagerM694getAutofillManager != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int iKeyAt = sparseArray.keyAt(i);
                AutofillValue autofillValue = (AutofillValue) sparseArray.get(iKeyAt);
                LayoutNode layoutNode = (LayoutNode) androidAutofillManagerM694getAutofillManager.semanticsOwner.nodes.get(iKeyAt);
                if (layoutNode != null && (semanticsConfiguration = layoutNode.getSemanticsConfiguration()) != null) {
                    MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
                    Object obj = mutableScatterMap.get(SemanticsActions.OnAutofillText);
                    if (obj == null) {
                        obj = null;
                    }
                    AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                    if (accessibilityAction != null && (function2 = (Function1) accessibilityAction.action) != null) {
                    }
                    Object obj2 = mutableScatterMap.get(SemanticsActions.OnFillData);
                    AccessibilityAction accessibilityAction2 = (AccessibilityAction) (obj2 != null ? obj2 : null);
                    if (accessibilityAction2 != null && (function1 = (Function1) accessibilityAction2.action) != null) {
                    }
                }
            }
        }
        AndroidAutofill androidAutofillM693getAutofill = m693getAutofill();
        if (androidAutofillM693getAutofill != null) {
            AutofillTree autofillTree = androidAutofillM693getAutofill.autofillTree;
            if (autofillTree.children.isEmpty()) {
                return;
            }
            int size2 = sparseArray.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iKeyAt2 = sparseArray.keyAt(i2);
                AutofillValue autofillValue2 = (AutofillValue) sparseArray.get(iKeyAt2);
                if (autofillValue2.isText()) {
                    autofillValue2.getTextValue().toString();
                    if (autofillTree.children.get(Integer.valueOf(iKeyAt2)) != null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                } else {
                    if (autofillValue2.isDate()) {
                        throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                    }
                    if (autofillValue2.isList()) {
                        throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                    }
                    if (autofillValue2.isToggle()) {
                        throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.composeAccessibilityDelegate.m700canScroll0AR0LA0$ui(i, this.lastDownPointerPosition, false);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.composeAccessibilityDelegate.m700canScroll0AR0LA0$ui(i, this.lastDownPointerPosition, true);
    }

    public final OwnedLayer createLayer(Function2 function2, NodeCoordinator$$ExternalSyntheticLambda2 nodeCoordinator$$ExternalSyntheticLambda2, GraphicsLayer graphicsLayer) {
        MutableVector mutableVector;
        Reference referencePoll;
        Object obj;
        if (graphicsLayer != null) {
            return new GraphicsLayerOwnerLayer(graphicsLayer, null, this, function2, nodeCoordinator$$ExternalSyntheticLambda2);
        }
        do {
            WeakCache weakCache = this.layerCache;
            ReferenceQueue referenceQueue = (ReferenceQueue) weakCache.referenceQueue;
            mutableVector = (MutableVector) weakCache.values;
            referencePoll = referenceQueue.poll();
            if (referencePoll != null) {
                mutableVector.remove(referencePoll);
            }
        } while (referencePoll != null);
        do {
            int i = mutableVector.size;
            if (i == 0) {
                obj = null;
                break;
            }
            obj = ((Reference) mutableVector.removeAt(i - 1)).get();
        } while (obj == null);
        OwnedLayer ownedLayer = (OwnedLayer) obj;
        if (ownedLayer == null) {
            return new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), this, function2, nodeCoordinator$$ExternalSyntheticLambda2);
        }
        GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
        GraphicsContext graphicsContext = graphicsLayerOwnerLayer.context;
        if (graphicsContext == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m$2("currently reuse is only supported when we manage the layer lifecycle");
        }
        if (!graphicsLayerOwnerLayer.graphicsLayer.isReleased) {
            InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
        }
        graphicsLayerOwnerLayer.graphicsLayer = graphicsContext.createGraphicsLayer();
        graphicsLayerOwnerLayer.isDestroyed = false;
        graphicsLayerOwnerLayer.drawBlock = function2;
        graphicsLayerOwnerLayer.invalidateParentLayer = nodeCoordinator$$ExternalSyntheticLambda2;
        graphicsLayerOwnerLayer.isMatrixDirty = false;
        graphicsLayerOwnerLayer.isInverseMatrixDirty = false;
        graphicsLayerOwnerLayer.isIdentity = true;
        androidx.compose.ui.graphics.Matrix.m510resetimpl(graphicsLayerOwnerLayer.matrixCache);
        float[] fArr = graphicsLayerOwnerLayer.inverseMatrixCache;
        if (fArr != null) {
            androidx.compose.ui.graphics.Matrix.m510resetimpl(fArr);
        }
        graphicsLayerOwnerLayer.transformOrigin = ColorKt.TransformOrigin(0.5f, 0.5f);
        graphicsLayerOwnerLayer.drawnWithEnabledZ = false;
        graphicsLayerOwnerLayer.size = 9223372034707292159L;
        graphicsLayerOwnerLayer.outline = null;
        graphicsLayerOwnerLayer.mutatedFields = 0;
        return ownedLayer;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        MutableObjectList mutableObjectList = this.dirtyLayers;
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        measureAndLayout(true);
        SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
        this.isDrawingContent = true;
        Trace.beginSection("AndroidOwner:draw");
        try {
            CanvasHolder canvasHolder = getCanvasHolder();
            AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
            Canvas canvas2 = androidCanvas.internalCanvas;
            androidCanvas.internalCanvas = canvas;
            getRoot().draw$ui(androidCanvas, null);
            canvasHolder.androidCanvas.internalCanvas = canvas2;
            if (mutableObjectList.isNotEmpty()) {
                int i = mutableObjectList._size;
                for (int i2 = 0; i2 < i; i2++) {
                    ((GraphicsLayerOwnerLayer) ((OwnedLayer) mutableObjectList.get(i2))).updateDisplayList();
                }
            }
            int i3 = ViewLayer.$r8$clinit;
            mutableObjectList.clear();
            this.isDrawingContent = false;
            Trace.endSection();
            MutableObjectList mutableObjectList2 = this.postponedDirtyLayers;
            if (mutableObjectList2 != null) {
                mutableObjectList.addAll(mutableObjectList2);
                mutableObjectList2.clear();
            }
            if (isArrEnabled$ui()) {
                if (Float.compare(this.currentFrameRate, this.lastSetFrameRate) != 0) {
                    float f = this.currentFrameRate;
                    this.lastSetFrameRate = f;
                    Api35Impl.setRequestedFrameRate(this, f);
                }
                View view = this.frameRateCategoryView;
                if (view != null) {
                    if (Float.compare(this.currentFrameRateCategory, this.lastSetFrameRateCategory) != 0) {
                        float f2 = this.currentFrameRateCategory;
                        this.lastSetFrameRateCategory = f2;
                        Api35Impl.setRequestedFrameRate(view, f2);
                    }
                    if (!Float.isNaN(this.currentFrameRateCategory)) {
                        view.invalidate();
                        drawChild(canvas, view, getDrawingTime());
                    }
                }
                this.currentFrameRate = Float.NaN;
                this.currentFrameRateCategory = Float.NaN;
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:219:0x0362  */
    /* JADX WARN: Code duplicated, block: B:220:0x0368  */
    /* JADX WARN: Code duplicated, block: B:222:0x036e  */
    /* JADX WARN: Code duplicated, block: B:223:0x038d  */
    /* JADX WARN: Code duplicated, block: B:225:0x0393  */
    /* JADX WARN: Code duplicated, block: B:227:0x039d  */
    /* JADX WARN: Code duplicated, block: B:228:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:230:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:233:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:234:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:246:0x0410  */
    /* JADX WARN: Code duplicated, block: B:322:0x04eb A[PHI: r5
      0x04eb: PHI (r5v52 ??) = (r5v73 ??), (r5v74 ??), (r5v75 ??) binds: [B:303:0x04ad, B:305:0x04b1, B:320:0x04e4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:412:0x0630  */
    /* JADX WARN: Code duplicated, block: B:419:0x063f  */
    /* JADX WARN: Code duplicated, block: B:459:0x06c9 A[PHI: r4
      0x06c9: PHI (r4v28 ??) = (r4v67 ??), (r4v68 ??), (r4v69 ??) binds: [B:440:0x068f, B:442:0x0693, B:457:0x06c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r38v2 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v48, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v87 */
    /* JADX WARN: Type inference failed for: r3v88 */
    /* JADX WARN: Type inference failed for: r3v89 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v51, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v63 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r4v66 */
    /* JADX WARN: Type inference failed for: r4v67 */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v52, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r5v56, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v70 */
    /* JADX WARN: Type inference failed for: r5v71 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v73 */
    /* JADX WARN: Type inference failed for: r5v74 */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r6v44 */
    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        String str;
        int i;
        StatusLine statusLine;
        long jValueAt;
        int i2;
        long j;
        long eventTime;
        float pressure;
        int i3;
        long eventTime2;
        long jFloatToRawIntBits;
        ?? r38;
        IndirectPointerInputChange indirectPointerInputChange;
        int i4;
        IndirectPointerInputModifierNode indirectPointerInputModifierNode;
        NodeChain nodeChain;
        boolean z;
        ?? r3;
        NodeChain nodeChain2;
        ?? mutableVector;
        ?? Pop;
        IndirectPointerInputModifierNode indirectPointerInputModifierNode2;
        boolean z2;
        int size;
        int size2;
        NodeChain nodeChain3;
        boolean z3;
        ?? r4;
        NodeChain nodeChain4;
        ?? mutableVector2;
        ?? Pop2;
        int action;
        boolean z4;
        RootModifierNode rootModifierNode;
        int size3;
        NodeChain nodeChain5;
        boolean z5;
        Modifier.Node nodePop;
        NodeChain nodeChain6;
        if (this.hoverExitReceived) {
            AndroidComposeView$$ExternalSyntheticLambda3 androidComposeView$$ExternalSyntheticLambda3 = this.sendHoverExitEvent;
            removeCallbacks(androidComposeView$$ExternalSyntheticLambda3);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                androidComposeView$$ExternalSyntheticLambda3.run();
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        String str2 = "visitAncestors called on an unattached node";
        int actionIndex = -1;
        int i5 = 16;
        int i6 = 1;
        if (motionEvent.getActionMasked() == 8) {
            if (!motionEvent.isFromSource(4194304)) {
                return (m684handleMotionEvent8iAsVTc(motionEvent) & 4) != 0;
            }
            android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
            motionEvent.getAxisValue(26);
            getContext();
            viewConfiguration.getScaledVerticalScrollFactor();
            getContext();
            viewConfiguration.getScaledHorizontalScrollFactor();
            motionEvent.getEventTime();
            motionEvent.getDeviceId();
            FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) getFocusOwner();
            if (focusOwnerImpl.focusInvalidationManager.isInvalidationScheduled) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
                return false;
            }
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusOwnerImpl.rootFocusNode);
            if (focusTargetNodeFindActiveFocusNode != null) {
                if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node = focusTargetNodeFindActiveFocusNode.node;
                LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                loop0: while (true) {
                    if (layoutNodeRequireLayoutNode == null) {
                        nodePop = null;
                        break;
                    }
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 16384) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 16384) != 0) {
                                nodePop = node;
                                MutableVector mutableVector3 = null;
                                while (nodePop != null) {
                                    if (nodePop instanceof RootModifierNode) {
                                        break loop0;
                                    }
                                    if ((nodePop.kindSet & 16384) != 0 && (nodePop instanceof DelegatingNode)) {
                                        int i7 = 0;
                                        for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                            if ((node2.kindSet & 16384) != 0) {
                                                i7++;
                                                if (i7 == 1) {
                                                    nodePop = node2;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodePop != null) {
                                                        mutableVector3.add(nodePop);
                                                        nodePop = null;
                                                    }
                                                    mutableVector3.add(node2);
                                                }
                                            }
                                        }
                                        if (i7 == 1) {
                                        }
                                    }
                                    nodePop = HitTestResultKt.pop(mutableVector3);
                                }
                            }
                            node = node.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    node = (layoutNodeRequireLayoutNode == null || (nodeChain6 = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain6.tail;
                }
                rootModifierNode = (RootModifierNode) nodePop;
            } else {
                rootModifierNode = null;
            }
            if (rootModifierNode != null) {
                if (!rootModifierNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node3 = rootModifierNode.node.parent;
                LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(rootModifierNode);
                ArrayList arrayList = null;
                while (layoutNodeRequireLayoutNode2 != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 16384) != 0) {
                        while (node3 != null) {
                            if ((node3.kindSet & 16384) != 0) {
                                Modifier.Node nodePop2 = node3;
                                MutableVector mutableVector4 = null;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof RootModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(nodePop2);
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5 && (nodePop2.kindSet & 16384) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                        int i8 = 0;
                                        for (Modifier.Node node4 = ((DelegatingNode) nodePop2).delegate; node4 != null; node4 = node4.child) {
                                            if ((node4.kindSet & 16384) != 0) {
                                                i8++;
                                                if (i8 == 1) {
                                                    nodePop2 = node4;
                                                } else {
                                                    if (mutableVector4 == null) {
                                                        mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodePop2 != null) {
                                                        mutableVector4.add(nodePop2);
                                                        nodePop2 = null;
                                                    }
                                                    mutableVector4.add(node4);
                                                }
                                            }
                                        }
                                        if (i8 == 1) {
                                        }
                                    }
                                    nodePop2 = HitTestResultKt.pop(mutableVector4);
                                }
                            }
                            node3 = node3.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                    node3 = (layoutNodeRequireLayoutNode2 == null || (nodeChain5 = layoutNodeRequireLayoutNode2.nodes) == null) ? null : (TailModifierNode) nodeChain5.tail;
                }
                if (arrayList != null && (size3 = arrayList.size() - 1) >= 0) {
                    while (true) {
                        int i9 = size3 - 1;
                        ((RootModifierNode) arrayList.get(size3)).getClass();
                        if (i9 < 0) {
                            break;
                        }
                        size3 = i9;
                    }
                }
                Modifier.Node nodePop3 = rootModifierNode.node;
                MutableVector mutableVector5 = null;
                while (nodePop3 != null) {
                    if (!(nodePop3 instanceof RootModifierNode) && (nodePop3.kindSet & 16384) != 0 && (nodePop3 instanceof DelegatingNode)) {
                        int i10 = 0;
                        for (Modifier.Node node5 = ((DelegatingNode) nodePop3).delegate; node5 != null; node5 = node5.child) {
                            if ((node5.kindSet & 16384) != 0) {
                                i10++;
                                if (i10 == 1) {
                                    nodePop3 = node5;
                                } else {
                                    if (mutableVector5 == null) {
                                        mutableVector5 = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (nodePop3 != null) {
                                        mutableVector5.add(nodePop3);
                                        nodePop3 = null;
                                    }
                                    mutableVector5.add(node5);
                                }
                            }
                        }
                        if (i10 == 1) {
                        }
                    }
                    nodePop3 = HitTestResultKt.pop(mutableVector5);
                }
                if (!super.dispatchGenericMotionEvent(motionEvent)) {
                    Modifier.Node nodePop4 = rootModifierNode.node;
                    MutableVector mutableVector6 = null;
                    while (nodePop4 != null) {
                        if (!(nodePop4 instanceof RootModifierNode) && (nodePop4.kindSet & 16384) != 0 && (nodePop4 instanceof DelegatingNode)) {
                            int i11 = 0;
                            for (Modifier.Node node6 = ((DelegatingNode) nodePop4).delegate; node6 != null; node6 = node6.child) {
                                if ((node6.kindSet & 16384) != 0) {
                                    i11++;
                                    if (i11 == 1) {
                                        nodePop4 = node6;
                                    } else {
                                        if (mutableVector6 == null) {
                                            mutableVector6 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (nodePop4 != null) {
                                            mutableVector6.add(nodePop4);
                                            nodePop4 = null;
                                        }
                                        mutableVector6.add(node6);
                                    }
                                }
                            }
                            if (i11 == 1) {
                            }
                        }
                        nodePop4 = HitTestResultKt.pop(mutableVector6);
                    }
                    if (arrayList != null) {
                        int size4 = arrayList.size();
                        for (int i12 = 0; i12 < size4; i12++) {
                            ((RootModifierNode) arrayList.get(i12)).getClass();
                        }
                    }
                }
            }
        }
        if (!motionEvent.isFromSource(2097152)) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis = this.primaryDirectionalMotionAxisOverride;
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        LongSparseArray longSparseArray = motionEventAdapter.previousIndirectPointerEventData;
        SparseLongArray sparseLongArray = motionEventAdapter.motionEventToComposePointerIdMap;
        int actionMasked = motionEvent.getActionMasked();
        motionEventAdapter.clearOnDeviceChange(motionEvent);
        if (actionMasked == 3) {
            sparseLongArray.clear();
            motionEventAdapter.activeHoverIds.clear();
            str = "visitAncestors called on an unattached node";
            statusLine = null;
        } else {
            motionEventAdapter.addFreshIds(motionEvent);
            if (actionMasked == 1) {
                actionIndex = 0;
            } else if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
            boolean z6 = actionMasked == 0 || actionMasked == 2 || actionMasked == 5;
            int pointerCount = motionEvent.getPointerCount();
            ArrayList arrayList2 = new ArrayList(pointerCount);
            int i13 = 0;
            while (i13 < pointerCount) {
                int pointerId = motionEvent.getPointerId(i13);
                int i14 = i6;
                int iIndexOfKey = sparseLongArray.indexOfKey(pointerId);
                if (iIndexOfKey >= 0) {
                    jValueAt = sparseLongArray.valueAt(iIndexOfKey);
                } else {
                    jValueAt = motionEventAdapter.nextId;
                    motionEventAdapter.nextId = jValueAt + 1;
                    sparseLongArray.put(pointerId, jValueAt);
                }
                MotionEventAdapter motionEventAdapter2 = motionEventAdapter;
                long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(motionEvent.getX(i13))) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getY(i13))) & 4294967295L);
                ?? r32 = i13 != actionIndex ? i14 : 0;
                MotionEventAdapter.IndirectPointerEventData indirectPointerEventData = (MotionEventAdapter.IndirectPointerEventData) longSparseArray.get(jValueAt);
                if (i13 == actionIndex) {
                    longSparseArray.remove(jValueAt);
                } else {
                    if (z6) {
                        long eventTime3 = 1 | ((motionEvent.getEventTime() & 2147483647L) << i14);
                        short sIntBitsToFloat = (short) Float.intBitsToFloat((int) (jFloatToRawIntBits2 >> 32));
                        i2 = DatagramKt.MAX_DATAGRAM_SIZE;
                        j = jValueAt;
                        longSparseArray.put(j, new MotionEventAdapter.IndirectPointerEventData(eventTime3 | (((long) ((((short) Float.intBitsToFloat((int) (jFloatToRawIntBits2 & 4294967295L))) & 65535) | (sIntBitsToFloat << 16))) << 32)));
                    }
                    eventTime = motionEvent.getEventTime();
                    pressure = motionEvent.getPressure(i13);
                    i3 = i2;
                    int i15 = actionIndex;
                    if (indirectPointerEventData != null) {
                        eventTime2 = (indirectPointerEventData.packedValue >> i14) & 2147483647L;
                    } else {
                        eventTime2 = motionEvent.getEventTime();
                    }
                    if (indirectPointerEventData != null) {
                        int i16 = (int) (indirectPointerEventData.packedValue >>> 32);
                        jFloatToRawIntBits = (((long) Float.floatToRawIntBits((short) (i16 >>> 16))) << 32) | (((long) Float.floatToRawIntBits((short) (i16 & i3))) & 4294967295L);
                    } else {
                        jFloatToRawIntBits = jFloatToRawIntBits2;
                    }
                    if (indirectPointerEventData != null) {
                        if ((indirectPointerEventData.packedValue & 1) != 0) {
                            i4 = i14;
                        } else {
                            i4 = 0;
                        }
                        r38 = i4;
                    } else {
                        r38 = 0;
                    }
                    if (motionEvent.getHistorySize() > 0) {
                        LazyHistoricalChangeList lazyHistoricalChangeList = new LazyHistoricalChangeList(motionEvent, i13);
                        indirectPointerInputChange = new IndirectPointerInputChange(j, eventTime, jFloatToRawIntBits2, r32, pressure, eventTime2, jFloatToRawIntBits, r38);
                        indirectPointerInputChange._historical = lazyHistoricalChangeList;
                    } else {
                        indirectPointerInputChange = new IndirectPointerInputChange(j, eventTime, jFloatToRawIntBits2, r32, pressure, eventTime2, jFloatToRawIntBits, r38);
                    }
                    arrayList2.add(indirectPointerInputChange);
                    i13++;
                    motionEventAdapter = motionEventAdapter2;
                    i6 = i14;
                    str2 = str2;
                    indirectPointerEventPrimaryDirectionalMotionAxis = indirectPointerEventPrimaryDirectionalMotionAxis;
                    actionIndex = i15;
                }
                j = jValueAt;
                i2 = DatagramKt.MAX_DATAGRAM_SIZE;
                eventTime = motionEvent.getEventTime();
                pressure = motionEvent.getPressure(i13);
                i3 = i2;
                int i17 = actionIndex;
                if (indirectPointerEventData != null) {
                    eventTime2 = (indirectPointerEventData.packedValue >> i14) & 2147483647L;
                } else {
                    eventTime2 = motionEvent.getEventTime();
                }
                if (indirectPointerEventData != null) {
                    int i18 = (int) (indirectPointerEventData.packedValue >>> 32);
                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits((short) (i18 >>> 16))) << 32) | (((long) Float.floatToRawIntBits((short) (i18 & i3))) & 4294967295L);
                } else {
                    jFloatToRawIntBits = jFloatToRawIntBits2;
                }
                if (indirectPointerEventData != null) {
                    if ((indirectPointerEventData.packedValue & 1) != 0) {
                        i4 = i14;
                    } else {
                        i4 = 0;
                    }
                    r38 = i4;
                } else {
                    r38 = 0;
                }
                if (motionEvent.getHistorySize() > 0) {
                    LazyHistoricalChangeList lazyHistoricalChangeList2 = new LazyHistoricalChangeList(motionEvent, i13);
                    indirectPointerInputChange = new IndirectPointerInputChange(j, eventTime, jFloatToRawIntBits2, r32, pressure, eventTime2, jFloatToRawIntBits, r38);
                    indirectPointerInputChange._historical = lazyHistoricalChangeList2;
                } else {
                    indirectPointerInputChange = new IndirectPointerInputChange(j, eventTime, jFloatToRawIntBits2, r32, pressure, eventTime2, jFloatToRawIntBits, r38);
                }
                arrayList2.add(indirectPointerInputChange);
                i13++;
                motionEventAdapter = motionEventAdapter2;
                i6 = i14;
                str2 = str2;
                indirectPointerEventPrimaryDirectionalMotionAxis = indirectPointerEventPrimaryDirectionalMotionAxis;
                actionIndex = i17;
            }
            IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis2 = indirectPointerEventPrimaryDirectionalMotionAxis;
            str = str2;
            int i19 = i6;
            motionEventAdapter.removeStaleIds(motionEvent);
            if (indirectPointerEventPrimaryDirectionalMotionAxis2 != null) {
                i = indirectPointerEventPrimaryDirectionalMotionAxis2.value;
            } else {
                if (!motionEvent.isFromSource(2097152)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("MotionEvent must be a touch navigation source");
                    return false;
                }
                InputDevice device = motionEvent.getDevice();
                if (device != null) {
                    InputDevice.MotionRange motionRange = device.getMotionRange(0);
                    InputDevice.MotionRange motionRange2 = device.getMotionRange(i19);
                    if (motionRange == null || motionRange2 != null) {
                        if (motionRange2 == null || motionRange != null) {
                            if (motionRange != null && motionRange2 != null) {
                                float range = motionRange.getRange();
                                float range2 = motionRange2.getRange();
                                if (range > range2 && (range2 == CropImageView.DEFAULT_ASPECT_RATIO || range / range2 >= 5.0f)) {
                                    i = 1;
                                } else if (range2 <= range || (range != CropImageView.DEFAULT_ASPECT_RATIO && range2 / range < 5.0f)) {
                                }
                            }
                            i = 0;
                        }
                        i = 2;
                    } else {
                        i = 1;
                    }
                } else {
                    i = 0;
                }
            }
            if (actionMasked == 0 || actionMasked == 1 || actionMasked == 2 || actionMasked != 5) {
            }
            statusLine = new StatusLine(arrayList2, i, motionEvent);
        }
        BoxParser.StsdData stsdData = this.indirectPointerNavigationGestureDetector;
        if (statusLine == null) {
            FocusTargetNode activeFocusTargetNode = ((FocusOwnerImpl) getFocusOwner()).getActiveFocusTargetNode();
            if (activeFocusTargetNode != null) {
                if (!activeFocusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException(str);
                }
                Modifier.Node node7 = activeFocusTargetNode.node;
                LayoutNode layoutNodeRequireLayoutNode3 = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
                loop26: while (true) {
                    if (layoutNodeRequireLayoutNode3 == null) {
                        r3 = 0;
                        break;
                    }
                    int i20 = 2097152;
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode3.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                        while (node7 != null) {
                            if ((node7.kindSet & i20) != 0) {
                                r3 = node7;
                                ?? r5 = 0;
                                while (r3 != 0) {
                                    if (r3 instanceof IndirectPointerInputModifierNode) {
                                        break loop26;
                                    }
                                    if ((r3.kindSet & i20) == 0 || !(r3 instanceof DelegatingNode)) {
                                        mutableVector = r5;
                                        mutableVector = r5;
                                        mutableVector = r5;
                                        Pop = HitTestResultKt.pop(mutableVector);
                                    } else {
                                        Modifier.Node node8 = ((DelegatingNode) r3).delegate;
                                        int i21 = 0;
                                        while (node8 != null) {
                                            if ((node8.kindSet & i20) != 0) {
                                                i21++;
                                                if (i21 == 1) {
                                                    mutableVector = r5;
                                                    mutableVector = r5;
                                                    Pop = r3;
                                                    mutableVector = r5;
                                                    mutableVector = mutableVector;
                                                    Pop = node8;
                                                } else {
                                                    if (mutableVector == 0) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (Pop != 0) {
                                                        mutableVector.add(Pop);
                                                        Pop = 0;
                                                    }
                                                    mutableVector.add(node8);
                                                }
                                            } else {
                                                mutableVector = r5;
                                                mutableVector = r5;
                                                Pop = r3;
                                                mutableVector = r5;
                                            }
                                            node8 = node8.child;
                                            i20 = 2097152;
                                            Pop = Pop;
                                            mutableVector = mutableVector;
                                        }
                                        mutableVector = r5;
                                        mutableVector = r5;
                                        Pop = r3;
                                        mutableVector = r5;
                                        mutableVector = mutableVector;
                                        if (i21 != 1) {
                                            mutableVector = r5;
                                            mutableVector = r5;
                                            mutableVector = r5;
                                            Pop = HitTestResultKt.pop(mutableVector);
                                        }
                                    }
                                    i20 = 2097152;
                                    r3 = Pop;
                                    r5 = mutableVector;
                                }
                            }
                            node7 = node7.parent;
                            i20 = 2097152;
                        }
                    }
                    layoutNodeRequireLayoutNode3 = layoutNodeRequireLayoutNode3.getParent$ui();
                    node7 = (layoutNodeRequireLayoutNode3 == null || (nodeChain2 = layoutNodeRequireLayoutNode3.nodes) == null) ? null : (TailModifierNode) nodeChain2.tail;
                }
                indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) r3;
            } else {
                indirectPointerInputModifierNode = null;
            }
            if (indirectPointerInputModifierNode != null) {
                Modifier.Node node9 = (Modifier.Node) indirectPointerInputModifierNode;
                if (!node9.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException(str);
                }
                Modifier.Node node10 = node9.node.parent;
                LayoutNode layoutNodeRequireLayoutNode4 = HitTestResultKt.requireLayoutNode(indirectPointerInputModifierNode);
                ArrayList arrayList3 = null;
                while (layoutNodeRequireLayoutNode4 != null) {
                    int i22 = 2097152;
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode4.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                        while (node10 != null) {
                            if ((node10.kindSet & i22) != 0) {
                                Modifier.Node nodePop5 = node10;
                                MutableVector mutableVector7 = null;
                                while (nodePop5 != null) {
                                    if (nodePop5 instanceof IndirectPointerInputModifierNode) {
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        arrayList3.add(nodePop5);
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        if ((nodePop5.kindSet & 2097152) != 0 && (nodePop5 instanceof DelegatingNode)) {
                                            int i23 = 0;
                                            for (Modifier.Node node11 = ((DelegatingNode) nodePop5).delegate; node11 != null; node11 = node11.child) {
                                                if ((node11.kindSet & 2097152) != 0) {
                                                    i23++;
                                                    if (i23 == 1) {
                                                        nodePop5 = node11;
                                                    } else {
                                                        if (mutableVector7 == null) {
                                                            mutableVector7 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (nodePop5 != null) {
                                                            mutableVector7.add(nodePop5);
                                                            nodePop5 = null;
                                                        }
                                                        mutableVector7.add(node11);
                                                    }
                                                }
                                            }
                                            if (i23 == 1) {
                                            }
                                        }
                                    }
                                    nodePop5 = HitTestResultKt.pop(mutableVector7);
                                }
                            }
                            i22 = 2097152;
                            node10 = node10.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode4 = layoutNodeRequireLayoutNode4.getParent$ui();
                    node10 = (layoutNodeRequireLayoutNode4 == null || (nodeChain = layoutNodeRequireLayoutNode4.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
                indirectPointerInputModifierNode.onCancelIndirectPointerInput();
                if (arrayList3 != null) {
                    int size5 = arrayList3.size();
                    for (int i24 = 0; i24 < size5; i24++) {
                        ((IndirectPointerInputModifierNode) arrayList3.get(i24)).onCancelIndirectPointerInput();
                    }
                }
            }
            stsdData.nalUnitLengthFieldLength = 0;
            stsdData.requiredSampleTransformation = true;
            return true;
        }
        FocusOwnerImpl focusOwnerImpl2 = (FocusOwnerImpl) getFocusOwner();
        if (!focusOwnerImpl2.focusInvalidationManager.isInvalidationScheduled) {
            FocusTargetNode activeFocusTargetNode2 = focusOwnerImpl2.getActiveFocusTargetNode();
            if (activeFocusTargetNode2 != null) {
                if (!activeFocusTargetNode2.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException(str);
                }
                Modifier.Node node12 = activeFocusTargetNode2.node;
                LayoutNode layoutNodeRequireLayoutNode5 = HitTestResultKt.requireLayoutNode(activeFocusTargetNode2);
                loop14: while (true) {
                    if (layoutNodeRequireLayoutNode5 == null) {
                        r4 = 0;
                        break;
                    }
                    int i25 = 2097152;
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode5.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                        while (node12 != null) {
                            if ((node12.kindSet & i25) != 0) {
                                r4 = node12;
                                ?? r6 = 0;
                                while (r4 != 0) {
                                    if (r4 instanceof IndirectPointerInputModifierNode) {
                                        break loop14;
                                    }
                                    if ((r4.kindSet & i25) == 0 || !(r4 instanceof DelegatingNode)) {
                                        mutableVector2 = r6;
                                        mutableVector2 = r6;
                                        mutableVector2 = r6;
                                        Pop2 = HitTestResultKt.pop(mutableVector2);
                                    } else {
                                        Modifier.Node node13 = ((DelegatingNode) r4).delegate;
                                        int i26 = 0;
                                        while (node13 != null) {
                                            if ((node13.kindSet & i25) != 0) {
                                                i26++;
                                                if (i26 == 1) {
                                                    mutableVector2 = r6;
                                                    mutableVector2 = r6;
                                                    Pop2 = r4;
                                                    mutableVector2 = r6;
                                                    mutableVector2 = mutableVector2;
                                                    Pop2 = node13;
                                                } else {
                                                    if (mutableVector2 == 0) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[i5]);
                                                    }
                                                    if (Pop2 != 0) {
                                                        mutableVector2.add(Pop2);
                                                        Pop2 = 0;
                                                    }
                                                    mutableVector2.add(node13);
                                                }
                                            } else {
                                                mutableVector2 = r6;
                                                mutableVector2 = r6;
                                                Pop2 = r4;
                                                mutableVector2 = r6;
                                            }
                                            node13 = node13.child;
                                            i5 = 16;
                                            i25 = 2097152;
                                            Pop2 = Pop2;
                                            mutableVector2 = mutableVector2;
                                        }
                                        mutableVector2 = r6;
                                        mutableVector2 = r6;
                                        Pop2 = r4;
                                        mutableVector2 = r6;
                                        mutableVector2 = mutableVector2;
                                        if (i26 != 1) {
                                            mutableVector2 = r6;
                                            mutableVector2 = r6;
                                            mutableVector2 = r6;
                                            Pop2 = HitTestResultKt.pop(mutableVector2);
                                        }
                                    }
                                    i5 = 16;
                                    i25 = 2097152;
                                    r4 = Pop2;
                                    r6 = mutableVector2;
                                }
                            }
                            node12 = node12.parent;
                            i5 = 16;
                            i25 = 2097152;
                        }
                    }
                    layoutNodeRequireLayoutNode5 = layoutNodeRequireLayoutNode5.getParent$ui();
                    node12 = (layoutNodeRequireLayoutNode5 == null || (nodeChain4 = layoutNodeRequireLayoutNode5.nodes) == null) ? null : (TailModifierNode) nodeChain4.tail;
                    i5 = 16;
                }
                indirectPointerInputModifierNode2 = (IndirectPointerInputModifierNode) r4;
            } else {
                indirectPointerInputModifierNode2 = null;
            }
            if (indirectPointerInputModifierNode2 != null) {
                Modifier.Node node14 = (Modifier.Node) indirectPointerInputModifierNode2;
                if (!node14.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException(str);
                }
                Modifier.Node node15 = node14.node.parent;
                LayoutNode layoutNodeRequireLayoutNode6 = HitTestResultKt.requireLayoutNode(indirectPointerInputModifierNode2);
                ArrayList arrayList4 = null;
                while (layoutNodeRequireLayoutNode6 != null) {
                    int i27 = 2097152;
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode6.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                        while (node15 != null) {
                            if ((node15.kindSet & i27) != 0) {
                                Modifier.Node nodePop6 = node15;
                                MutableVector mutableVector8 = null;
                                while (nodePop6 != null) {
                                    if (nodePop6 instanceof IndirectPointerInputModifierNode) {
                                        if (arrayList4 == null) {
                                            arrayList4 = new ArrayList();
                                        }
                                        arrayList4.add(nodePop6);
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        int i28 = 2097152;
                                        if ((nodePop6.kindSet & 2097152) != 0 && (nodePop6 instanceof DelegatingNode)) {
                                            Modifier.Node node16 = ((DelegatingNode) nodePop6).delegate;
                                            int i29 = 0;
                                            while (node16 != null) {
                                                if ((node16.kindSet & i28) != 0) {
                                                    i29++;
                                                    if (i29 == 1) {
                                                        nodePop6 = node16;
                                                    } else {
                                                        if (mutableVector8 == null) {
                                                            mutableVector8 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (nodePop6 != null) {
                                                            mutableVector8.add(nodePop6);
                                                            nodePop6 = null;
                                                        }
                                                        mutableVector8.add(node16);
                                                    }
                                                }
                                                node16 = node16.child;
                                                i28 = 2097152;
                                            }
                                            if (i29 == 1) {
                                            }
                                        }
                                    }
                                    nodePop6 = HitTestResultKt.pop(mutableVector8);
                                }
                            }
                            node15 = node15.parent;
                            i27 = 2097152;
                        }
                    }
                    layoutNodeRequireLayoutNode6 = layoutNodeRequireLayoutNode6.getParent$ui();
                    node15 = (layoutNodeRequireLayoutNode6 == null || (nodeChain3 = layoutNodeRequireLayoutNode6.nodes) == null) ? null : (TailModifierNode) nodeChain3.tail;
                }
                PointerEventPass pointerEventPass = PointerEventPass.Initial;
                if (arrayList4 != null && (size2 = arrayList4.size() - 1) >= 0) {
                    while (true) {
                        int i30 = size2 - 1;
                        ((IndirectPointerInputModifierNode) arrayList4.get(size2)).onIndirectPointerEvent(statusLine, pointerEventPass);
                        if (i30 < 0) {
                            break;
                        }
                        size2 = i30;
                    }
                }
                indirectPointerInputModifierNode2.onIndirectPointerEvent(statusLine, pointerEventPass);
                PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                indirectPointerInputModifierNode2.onIndirectPointerEvent(statusLine, pointerEventPass2);
                if (arrayList4 != null) {
                    int size6 = arrayList4.size();
                    for (int i31 = 0; i31 < size6; i31++) {
                        ((IndirectPointerInputModifierNode) arrayList4.get(i31)).onIndirectPointerEvent(statusLine, pointerEventPass2);
                    }
                }
                PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                if (arrayList4 != null && (size = arrayList4.size() - 1) >= 0) {
                    while (true) {
                        int i32 = size - 1;
                        ((IndirectPointerInputModifierNode) arrayList4.get(size)).onIndirectPointerEvent(statusLine, pointerEventPass3);
                        if (i32 < 0) {
                            break;
                        }
                        size = i32;
                    }
                }
                indirectPointerInputModifierNode2.onIndirectPointerEvent(statusLine, pointerEventPass3);
            }
            ArrayList arrayList5 = (ArrayList) statusLine.protocol;
            int size7 = arrayList5.size();
            int i33 = 0;
            while (true) {
                if (i33 < size7) {
                    if (((IndirectPointerInputChange) arrayList5.get(i33)).isConsumed) {
                        z2 = true;
                        break;
                    }
                    i33++;
                }
            }
            stsdData.getClass();
            MotionEvent motionEvent2 = (MotionEvent) statusLine.message;
            action = motionEvent2.getAction();
            if (action != 0) {
                z4 = true;
                if ((action != 1 || action == 2) && z2) {
                    stsdData.nalUnitLengthFieldLength = 0;
                    stsdData.requiredSampleTransformation = true;
                }
            } else {
                z4 = true;
                stsdData.nalUnitLengthFieldLength = statusLine.code;
                stsdData.requiredSampleTransformation = false;
            }
            ((GestureDetector) stsdData.format).onTouchEvent(motionEvent2);
            return z4;
        }
        System.out.println((Object) "FocusRelatedWarning: Dispatching indirect pointer event while the focus system is invalidated.");
        z2 = false;
        stsdData.getClass();
        MotionEvent motionEvent3 = (MotionEvent) statusLine.message;
        action = motionEvent3.getAction();
        if (action != 0) {
            z4 = true;
            if (action != 1) {
                stsdData.nalUnitLengthFieldLength = 0;
                stsdData.requiredSampleTransformation = true;
            } else {
                stsdData.nalUnitLengthFieldLength = 0;
                stsdData.requiredSampleTransformation = true;
            }
        } else {
            z4 = true;
            stsdData.nalUnitLengthFieldLength = statusLine.code;
            stsdData.requiredSampleTransformation = false;
        }
        ((GestureDetector) stsdData.format).onTouchEvent(motionEvent3);
        return z4;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0174, code lost:
    
        if (isPositionChanged(r24) == false) goto L81;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        int iSemanticsNodeIdToAccessibilityVirtualNodeId;
        AdjustedSemanticsNode adjustedSemanticsNode;
        boolean z = this.hoverExitReceived;
        AndroidComposeView$$ExternalSyntheticLambda3 androidComposeView$$ExternalSyntheticLambda3 = this.sendHoverExitEvent;
        if (z) {
            removeCallbacks(androidComposeView$$ExternalSyntheticLambda3);
            androidComposeView$$ExternalSyntheticLambda3.run();
        }
        if (!isBadMotionEvent(motionEvent) && isAttachedToWindow()) {
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
            AndroidComposeView androidComposeView = androidComposeViewAccessibilityDelegateCompat.view;
            if (androidComposeViewAccessibilityDelegateCompat.isAccessibilityEnabled() && androidComposeViewAccessibilityDelegateCompat.view.getComposeViewContext()._isTouchExplorationEnabled) {
                int action = motionEvent.getAction();
                if (action == 7 || action == 9) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    androidComposeView.measureAndLayout(true);
                    HitTestResult hitTestResult = new HitTestResult();
                    LayoutNode root = androidComposeView.getRoot();
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(y)) & 4294967295L) | (((long) Float.floatToRawIntBits(x)) << 32);
                    NodeChain nodeChain = root.nodes;
                    NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
                    ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = NodeCoordinator.onCommitAffectingLayerParams;
                    ((NodeCoordinator) nodeChain.outerCoordinator).m671hitTestqzLsGqo(NodeCoordinator.SemanticsSource, nodeCoordinator.m666fromParentPosition8S9VItk(jFloatToRawIntBits), hitTestResult, 1, true);
                    MutableObjectList mutableObjectList = hitTestResult.values;
                    int i = mutableObjectList._size - 1;
                    while (true) {
                        if (-1 < i) {
                            Object obj = mutableObjectList.get(i);
                            obj.getClass();
                            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode((Modifier.Node) obj);
                            AndroidViewsHandler androidViewsHandler$ui = androidComposeView.getAndroidViewsHandler$ui();
                            if ((androidViewsHandler$ui != null ? androidViewsHandler$ui.getLayoutNodeToHolder().get(layoutNodeRequireLayoutNode) : null) == null) {
                                if (layoutNodeRequireLayoutNode.nodes.m662hasH91voCI$ui(8)) {
                                    iSemanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(layoutNodeRequireLayoutNode.semanticsId);
                                    SemanticsNode SemanticsNode = SemanticsNodeKt.SemanticsNode(layoutNodeRequireLayoutNode, false);
                                    if (SemanticsNodeKt.isImportantForAccessibility(SemanticsNode) && (((adjustedSemanticsNode = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(iSemanticsNodeIdToAccessibilityVirtualNodeId)) == null || !adjustedSemanticsNode.isInMergingHiddenSubtree) && !SemanticsNodeKt.isAccessibilityIgnoredLink(SemanticsNode))) {
                                        break;
                                    }
                                }
                                i--;
                            }
                        }
                        iSemanticsNodeIdToAccessibilityVirtualNodeId = Integer.MIN_VALUE;
                        break;
                    }
                    AndroidViewsHandler androidViewsHandler$ui2 = androidComposeView.getAndroidViewsHandler$ui();
                    boolean zDispatchGenericMotionEvent2 = androidViewsHandler$ui2 != null ? androidViewsHandler$ui2.dispatchGenericMotionEvent(motionEvent) : false;
                    int i2 = androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId;
                    if (i2 != iSemanticsNodeIdToAccessibilityVirtualNodeId) {
                        androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId = iSemanticsNodeIdToAccessibilityVirtualNodeId;
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, iSemanticsNodeIdToAccessibilityVirtualNodeId, 128, null, 12);
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i2, 256, null, 12);
                    }
                    zDispatchGenericMotionEvent = iSemanticsNodeIdToAccessibilityVirtualNodeId == Integer.MIN_VALUE ? zDispatchGenericMotionEvent2 : true;
                } else if (action == 10) {
                    int i3 = androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId;
                    if (i3 != Integer.MIN_VALUE) {
                        if (i3 != Integer.MIN_VALUE) {
                            androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId = Integer.MIN_VALUE;
                            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, Integer.MIN_VALUE, 128, null, 12);
                            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i3, 256, null, 12);
                        }
                    } else {
                        AndroidViewsHandler androidViewsHandler$ui3 = androidComposeView.getAndroidViewsHandler$ui();
                        if (androidViewsHandler$ui3 != null) {
                            zDispatchGenericMotionEvent = androidViewsHandler$ui3.dispatchGenericMotionEvent(motionEvent);
                        } else {
                            zDispatchGenericMotionEvent = false;
                        }
                    }
                } else {
                    zDispatchGenericMotionEvent = false;
                }
            } else {
                zDispatchGenericMotionEvent = false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 7) {
                if (actionMasked == 10 && isInBounds(motionEvent, PointerClassification.None)) {
                    if (motionEvent.getToolType(0) != 3 || motionEvent.getButtonState() == 0) {
                        MotionEvent motionEvent2 = this.previousMotionEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                        this.hoverExitReceived = true;
                        postDelayed(androidComposeView$$ExternalSyntheticLambda3, 8L);
                        return zDispatchGenericMotionEvent;
                    }
                    return zDispatchGenericMotionEvent;
                }
                if ((m684handleMotionEvent8iAsVTc(motionEvent) & 1) != 0 || zDispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isFocused()) {
            return ((FocusOwnerImpl) getFocusOwner()).m410dispatchKeyEventYhN2O0w(keyEvent, new Recomposer$$ExternalSyntheticLambda6((Object) this, (Object) keyEvent, (byte) 29));
        }
        LazyWindowInfo lazyWindowInfo = getComposeViewContext().windowInfo;
        WindowInfoImpl.GlobalKeyboardModifiers.setValue(new PointerKeyboardModifiers(keyEvent.getMetaState()));
        return ((FocusOwnerImpl) getFocusOwner()).m410dispatchKeyEventYhN2O0w(keyEvent, new TextKt$$ExternalSyntheticLambda3((byte) 4)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        NodeChain nodeChain;
        if (isFocused()) {
            FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) getFocusOwner();
            if (focusOwnerImpl.focusInvalidationManager.isInvalidationScheduled) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            } else {
                FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusOwnerImpl.rootFocusNode);
                if (focusTargetNodeFindActiveFocusNode != null) {
                    if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node node = focusTargetNodeFindActiveFocusNode.node;
                    LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                    while (layoutNodeRequireLayoutNode != null) {
                        if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 131072) != 0) {
                            while (node != null) {
                                if ((node.kindSet & 131072) != 0) {
                                    Modifier.Node nodePop = node;
                                    MutableVector mutableVector = null;
                                    while (nodePop != null) {
                                        if ((nodePop.kindSet & 131072) != 0 && (nodePop instanceof DelegatingNode)) {
                                            int i = 0;
                                            for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                                if ((node2.kindSet & 131072) != 0) {
                                                    i++;
                                                    if (i == 1) {
                                                        nodePop = node2;
                                                    } else {
                                                        if (mutableVector == null) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (nodePop != null) {
                                                            mutableVector.add(nodePop);
                                                            nodePop = null;
                                                        }
                                                        mutableVector.add(node2);
                                                    }
                                                }
                                            }
                                            if (i == 1) {
                                            }
                                        }
                                        nodePop = HitTestResultKt.pop(mutableVector);
                                    }
                                }
                                node = node.parent;
                            }
                        }
                        layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                        node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                    }
                }
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        this.isDispatchingAutofillStructure = true;
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            this.isDispatchingAutofillStructure = false;
            populateAutofillVirtualStructure(viewStructure);
        } catch (Throwable th) {
            this.isDispatchingAutofillStructure = false;
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideStructure(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT < 28) {
            Api23Impl.setClassName(viewStructure, getView());
        } else {
            super.dispatchProvideStructure(viewStructure);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) throws Throwable {
        Object autoClearFocusBehavior;
        FocusTargetNode activeFocusTargetNode;
        if (this.hoverExitReceived) {
            AndroidComposeView$$ExternalSyntheticLambda3 androidComposeView$$ExternalSyntheticLambda3 = this.sendHoverExitEvent;
            removeCallbacks(androidComposeView$$ExternalSyntheticLambda3);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            motionEvent2.getClass();
            if (motionEvent.getActionMasked() == 0 && motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
                this.hoverExitReceived = false;
            } else {
                androidComposeView$$ExternalSyntheticLambda3.run();
            }
        }
        if (!isBadMotionEvent(motionEvent) && isAttachedToWindow() && (motionEvent.getActionMasked() != 2 || isPositionChanged(motionEvent))) {
            int iM684handleMotionEvent8iAsVTc = m684handleMotionEvent8iAsVTc(motionEvent);
            if ((iM684handleMotionEvent8iAsVTc & 2) != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            boolean z = motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5;
            boolean z2 = motionEvent.isFromSource(8194) || motionEvent.isFromSource(1048584);
            if (z && z2) {
                Object parent = getParent();
                View view = parent instanceof View ? (View) parent : null;
                if (view == null || (autoClearFocusBehavior = view.getTag(R.id.auto_clear_focus_behavior_tag)) == null) {
                    autoClearFocusBehavior = new AutoClearFocusBehavior(1);
                }
                if (autoClearFocusBehavior.equals(new AutoClearFocusBehavior(1)) && (activeFocusTargetNode = ((FocusOwnerImpl) getFocusOwner()).getActiveFocusTargetNode()) != null) {
                    NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(activeFocusTargetNode);
                    if (!RulerKt.findRootCoordinates(nodeCoordinatorRequireLayoutCoordinates).localBoundingBoxOf(nodeCoordinatorRequireLayoutCoordinates, true).m442containsk4lQ0M((((long) Float.floatToRawIntBits(motionEvent.getX())) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getY())) & 4294967295L))) {
                        ((FocusOwnerImpl) getFocusOwner()).m409clearFocusI7lrPNg(8, false, true);
                    }
                }
            }
            if ((iM684handleMotionEvent8iAsVTc & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    public final View findViewByAccessibilityIdTraversal(int i) throws IllegalAccessException, InvocationTargetException {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return InvertMatrixKt.findViewByAccessibilityIdRootedAtCurrentView(this, i);
            }
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i));
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        Rect rectCalculateFocusRectRelativeTo;
        if (view == null || this.measureAndLayoutDelegate.isRegularFile) {
            return super.focusSearch(view, i);
        }
        View rootView = getRootView();
        rootView.getClass();
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) rootView, view, i);
        if (viewFindNextFocus == null || !InvertMatrixKt.containsDescendant(this, viewFindNextFocus)) {
            viewFindNextFocus = null;
        }
        if (view == this) {
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(((FocusOwnerImpl) getFocusOwner()).rootFocusNode);
            rectCalculateFocusRectRelativeTo = focusTargetNodeFindActiveFocusNode != null ? FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode) : null;
            if (rectCalculateFocusRectRelativeTo == null) {
                rectCalculateFocusRectRelativeTo = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(view, this);
            }
        } else {
            rectCalculateFocusRectRelativeTo = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(view, this);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
        int i2 = focusDirection != null ? focusDirection.value : 6;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (((FocusOwnerImpl) getFocusOwner()).m411focusSearchULY8qGw(i2, rectCalculateFocusRectRelativeTo, new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, (byte) 5)) == null) {
            return view;
        }
        Object obj = ref$ObjectRef.element;
        if (obj == null) {
            if (viewFindNextFocus == null) {
                return super.focusSearch(view, i);
            }
        } else if (viewFindNextFocus == null || i2 == 1 || i2 == 2 || FocusTraversalKt.m424isBetterCandidateI7lrPNg(FocusTraversalKt.focusRect((FocusTargetNode) obj), FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(viewFindNextFocus, this), rectCalculateFocusRectRelativeTo, i2)) {
            return this;
        }
        return viewFindNextFocus;
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, z);
    }

    public AccessibilityManager getAccessibilityManager() {
        return getComposeViewContext().accessibilityManager;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui() {
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            return androidViewsHandler;
        }
        AndroidViewsHandler androidViewsHandler2 = new AndroidViewsHandler(getContext());
        addView(androidViewsHandler2, -1);
        requestLayout();
        this._androidViewsHandler = androidViewsHandler2;
        return androidViewsHandler2;
    }

    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public Clipboard getClipboard() {
        return getComposeViewContext().clipboard;
    }

    public ClipboardManager getClipboardManager() {
        return getComposeViewContext().clipboardManager;
    }

    public final ComposeViewContext getComposeViewContext() {
        return get_composeViewContext();
    }

    public final boolean getComposeViewContextIncrementedDuringInit$ui() {
        return this.composeViewContextIncrementedDuringInit;
    }

    public final Configuration getConfiguration() {
        return (Configuration) this.configuration$delegate.getValue();
    }

    public final AndroidContentCaptureManager getContentCaptureManager$ui() {
        return this.contentCaptureManager;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public Density getDensity() {
        return (Density) this.density$delegate.getValue();
    }

    public Rect getEmbeddedViewFocusRect() {
        if (isFocused()) {
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(((FocusOwnerImpl) getFocusOwner()).rootFocusNode);
            if (focusTargetNodeFindActiveFocusNode != null) {
                return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
            }
            return null;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(viewFindFocus, this);
        }
        return null;
    }

    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.View
    public final void getFocusedRect(android.graphics.Rect rect) {
        Rect embeddedViewFocusRect = getEmbeddedViewFocusRect();
        if (embeddedViewFocusRect != null) {
            rect.left = Math.round(embeddedViewFocusRect.left);
            rect.top = Math.round(embeddedViewFocusRect.top);
            rect.right = Math.round(embeddedViewFocusRect.right);
            rect.bottom = Math.round(embeddedViewFocusRect.bottom);
            return;
        }
        if (Intrinsics.areEqual(((FocusOwnerImpl) getFocusOwner()).m411focusSearchULY8qGw(6, null, new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 24)), Boolean.TRUE)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    public Font$ResourceLoader getFontLoader() {
        return getComposeViewContext().fontLoader;
    }

    public final LifecycleRetainedValuesStoreOwner.FrameEndScheduler getFrameEndScheduler$ui() {
        return this.frameEndScheduler;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public HapticFeedback getHapticFeedBack() {
        return getComposeViewContext().hapticFeedback;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return ((EmojiProcessor) this.measureAndLayoutDelegate.size).isNotEmpty() || !this.outOfFrameQueue.isEmpty();
    }

    public final ViewTreeHostDefaultProvider getHostDefaultProvider() {
        ViewTreeHostDefaultProvider viewTreeHostDefaultProvider = this._hostDefaultProvider;
        if (viewTreeHostDefaultProvider != null) {
            return viewTreeHostDefaultProvider;
        }
        ViewTreeHostDefaultProvider viewTreeHostDefaultProvider2 = new ViewTreeHostDefaultProvider(this);
        this._hostDefaultProvider = viewTreeHostDefaultProvider2;
        return viewTreeHostDefaultProvider2;
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    public InputModeManagerImpl getInputModeManager() {
        InputModeManagerImpl inputModeManagerImpl = this._inputModeManager;
        if (inputModeManagerImpl == null) {
            inputModeManagerImpl = new InputModeManagerImpl(isInTouchMode() ? 1 : 2);
            this._inputModeManager = inputModeManagerImpl;
        }
        return inputModeManagerImpl;
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    public final WindowInsetsWatcher getInsetsWatcher() {
        return null;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    @Override // android.view.View, android.view.ViewParent
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public LocaleList getLocaleList() {
        return (LocaleList) this.localeList$delegate.getValue();
    }

    public long getMeasureIteration() {
        if (this.measureAndLayoutDelegate.isRegularFile) {
            return 1L;
        }
        InlineClassHelperKt.throwIllegalArgumentException("measureIteration should be only used during the measure/layout pass");
        return 1L;
    }

    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    public AndroidComposeView getOutOfFrameExecutor() {
        if (isAttachedToWindow()) {
            return this;
        }
        return null;
    }

    public Placeable.PlacementScope getPlacementScope() {
        return new OuterPlacementScope((byte) 0, this);
    }

    public final Function2 getPlayNavigationSoundEffect$ui() {
        Function2 function2 = this._playNavigationSoundEffect;
        if (function2 != null) {
            return function2;
        }
        AndroidComposeViewNavigationSoundEffect androidComposeViewNavigationSoundEffect = new AndroidComposeViewNavigationSoundEffect((byte) 0, this);
        this._playNavigationSoundEffect = androidComposeViewNavigationSoundEffect;
        return androidComposeViewNavigationSoundEffect;
    }

    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    /* JADX INFO: renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui, reason: not valid java name */
    public final IndirectPointerEventPrimaryDirectionalMotionAxis m683getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui() {
        return this.primaryDirectionalMotionAxisOverride;
    }

    public RectManager getRectManager() {
        return this.rectManager;
    }

    public RetainedValuesStore getRetainedValuesStore() {
        return this.retainedValuesStore;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public final DisposableSaveableStateRegistry getSavedStateRegistry() {
        DisposableSaveableStateRegistry disposableSaveableStateRegistry = this._savedStateRegistry;
        if (disposableSaveableStateRegistry != null) {
            return disposableSaveableStateRegistry;
        }
        ComposeViewContext composeViewContext = getComposeViewContext();
        composeViewContext.resolveValuesIfNeeded();
        SavedStateRegistryOwner savedStateRegistryOwner = composeViewContext._savedStateRegistryOwner;
        savedStateRegistryOwner.getClass();
        Object parent = getParent();
        parent.getClass();
        View view = (View) parent;
        Object tag = view.getTag(R.id.compose_view_saveable_id_tag);
        Map map = null;
        String strValueOf = tag instanceof String ? (String) tag : null;
        if (strValueOf == null) {
            strValueOf = String.valueOf(view.getId());
        }
        String strM = Fragment$5$$ExternalSyntheticOutline0.m("SaveableStateRegistry:", strValueOf);
        SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(strM);
        if (bundleConsumeRestoredStateForKey != null) {
            ParcelableMapHolder parcelableMapHolder = (ParcelableMapHolder) ((Parcelable) LifecyclesKt.getParcelable(bundleConsumeRestoredStateForKey, "androidx.compose.ui.platform.DisposableSaveableStateRegistry", Okio__OkioKt.getJavaClass(Reflection.getOrCreateKotlinClass(ParcelableMapHolder.class))));
            map = parcelableMapHolder != null ? parcelableMapHolder.map : null;
            if (map == null) {
                map = EmptyMap.INSTANCE;
            }
        }
        SaversKt$$ExternalSyntheticLambda2 saversKt$$ExternalSyntheticLambda2 = new SaversKt$$ExternalSyntheticLambda2((byte) 2);
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
        SaveableStateRegistryImpl saveableStateRegistryImpl = new SaveableStateRegistryImpl(map, saversKt$$ExternalSyntheticLambda2);
        boolean z = false;
        if (savedStateRegistry.getSavedStateProvider(strM) == null) {
            try {
                savedStateRegistry.registerSavedStateProvider(strM, new ComponentActivity$$ExternalSyntheticLambda5((byte) 1, saveableStateRegistryImpl));
                z = true;
            } catch (IllegalArgumentException unused) {
            }
        }
        DisposableSaveableStateRegistry disposableSaveableStateRegistry2 = new DisposableSaveableStateRegistry(saveableStateRegistryImpl, new TimePickerKt$$ExternalSyntheticLambda40(z, savedStateRegistry, strM));
        this._savedStateRegistry = disposableSaveableStateRegistry2;
        return disposableSaveableStateRegistry2;
    }

    public final boolean getScrollCaptureInProgress() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT >= 31 && (scrollCapture = this.scrollCapture) != null && ((Boolean) ((ParcelableSnapshotMutableState) scrollCapture.scrollCaptureInProgress$delegate).getValue()).booleanValue()) {
            return true;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AndroidComposeView) {
                return ((AndroidComposeView) parent).getScrollCaptureInProgress();
            }
        }
        return false;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public LayoutNodeDrawScope getSharedDrawScope() {
        return getComposeViewContext().sharedDrawScope;
    }

    public boolean getShowLayoutBounds() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.isShowingLayoutBounds(this) : this.showLayoutBounds;
    }

    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    public SoftwareKeyboardController getSoftwareKeyboardController() {
        DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController = this._softwareKeyboardController;
        if (delegatingSoftwareKeyboardController != null) {
            return delegatingSoftwareKeyboardController;
        }
        DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController2 = new DelegatingSoftwareKeyboardController(getTextInputService());
        this._softwareKeyboardController = delegatingSoftwareKeyboardController2;
        return delegatingSoftwareKeyboardController2;
    }

    public SoundEffect getSoundEffect() {
        ComposeViewContext composeViewContext = getComposeViewContext();
        AndroidSoundEffect androidSoundEffect = composeViewContext._soundEffect;
        if (androidSoundEffect != null) {
            return androidSoundEffect;
        }
        AndroidSoundEffect androidSoundEffect2 = new AndroidSoundEffect(composeViewContext.view);
        composeViewContext._soundEffect = androidSoundEffect2;
        return androidSoundEffect2;
    }

    public TextInputService getTextInputService() {
        TextInputService textInputService = this._textInputService;
        if (textInputService != null) {
            return textInputService;
        }
        TextInputService textInputService2 = new TextInputService(getLegacyTextInputServiceAndroid());
        this._textInputService = textInputService2;
        return textInputService2;
    }

    public TextToolbar getTextToolbar() {
        AndroidTextToolbar androidTextToolbar = this._textToolbar;
        if (androidTextToolbar != null) {
            return androidTextToolbar;
        }
        AndroidTextToolbar androidTextToolbar2 = new AndroidTextToolbar();
        new ImageLoader$Builder(new RoomDatabase$$ExternalSyntheticLambda0((byte) 14, androidTextToolbar2));
        this._textToolbar = androidTextToolbar2;
        return androidTextToolbar2;
    }

    public final RootForTest.UncaughtExceptionHandler getUncaughtExceptionHandler$ui() {
        return null;
    }

    public UriHandler getUriHandler() {
        ComposeViewContext composeViewContext = getComposeViewContext();
        AndroidUriHandler androidUriHandler = composeViewContext._uriHandler;
        if (androidUriHandler != null) {
            return androidUriHandler;
        }
        AndroidUriHandler androidUriHandler2 = new AndroidUriHandler(composeViewContext.view.getContext());
        composeViewContext._uriHandler = androidUriHandler2;
        return androidUriHandler2;
    }

    public ViewConfiguration getViewConfiguration() {
        return getComposeViewContext().viewConfiguration;
    }

    public WindowInfo getWindowInfo() {
        return getComposeViewContext().windowInfo;
    }

    public final UiMediaScopeImpl get_uiMediaScope$ui() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0076  */
    /* JADX INFO: renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    public final int m684handleMotionEvent8iAsVTc(MotionEvent motionEvent) throws Throwable {
        MotionEvent motionEvent2;
        AndroidComposeView androidComposeView;
        int actionMasked;
        AndroidComposeView androidComposeView2 = this;
        androidComposeView2.removeCallbacks(androidComposeView2.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            androidComposeView2.forceUseMatrixCache = true;
            androidComposeView2.measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked2 = motionEvent.getActionMasked();
                MotionEvent motionEvent3 = androidComposeView2.previousMotionEvent;
                boolean z = motionEvent3 != null && motionEvent3.getToolType(0) == 3;
                Cache.RealCacheRequest realCacheRequest = androidComposeView2.pointerInputEventProcessor;
                if (motionEvent3 == null) {
                    motionEvent2 = motionEvent3;
                } else {
                    if (!((motionEvent3.getSource() == motionEvent.getSource() && motionEvent3.getToolType(0) == motionEvent.getToolType(0)) ? false : true)) {
                        motionEvent2 = motionEvent3;
                    } else if (motionEvent3.getButtonState() != 0 || (actionMasked = motionEvent3.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6) {
                        motionEvent2 = motionEvent3;
                        if (!realCacheRequest.done) {
                            ((LongSparseArray) ((DrawResult) realCacheRequest.body).block).clear();
                            ((HitPathTracker) realCacheRequest.cacheOut).processCancel();
                        }
                    } else if (motionEvent3.getActionMasked() == 10 || !z) {
                        motionEvent2 = motionEvent3;
                    } else {
                        androidComposeView2.sendSimulatedEvent(motionEvent3, 10, motionEvent3.getEventTime(), true);
                        motionEvent2 = motionEvent3;
                    }
                }
                boolean z2 = motionEvent.getToolType(0) == 3;
                if (!z && z2 && actionMasked2 != 3 && actionMasked2 != 9 && androidComposeView2.isInBounds(motionEvent, PointerClassification.None)) {
                    androidComposeView2.sendSimulatedEvent(motionEvent, 9, motionEvent.getEventTime(), true);
                }
                boolean z3 = (actionMasked2 != 8 || (motionEvent.getButtonState() != 0) || motionEvent2 == null || motionEvent2.isFromSource(ByteBufferPoolKt.DEFAULT_BUFFER_SIZE)) ? false : true;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                MotionEvent motionEvent4 = androidComposeView2.previousMotionEvent;
                if (motionEvent4 != null && motionEvent4.getAction() == 10) {
                    MotionEvent motionEvent5 = androidComposeView2.previousMotionEvent;
                    int pointerId = motionEvent5 != null ? motionEvent5.getPointerId(0) : -1;
                    int action = motionEvent.getAction();
                    MotionEventAdapter motionEventAdapter = androidComposeView2.motionEventAdapter;
                    if (action == 9 && motionEvent.getHistorySize() == 0) {
                        if (pointerId >= 0) {
                            motionEventAdapter.activeHoverIds.delete(pointerId);
                            motionEventAdapter.motionEventToComposePointerIdMap.delete(pointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent6 = androidComposeView2.previousMotionEvent;
                        float x = motionEvent6 != null ? motionEvent6.getX() : Float.NaN;
                        MotionEvent motionEvent7 = androidComposeView2.previousMotionEvent;
                        boolean z4 = (x == motionEvent.getX() && (motionEvent7 != null ? motionEvent7.getY() : Float.NaN) == motionEvent.getY()) ? false : true;
                        MotionEvent motionEvent8 = androidComposeView2.previousMotionEvent;
                        boolean z5 = (motionEvent8 != null ? motionEvent8.getEventTime() : -1L) != motionEvent.getEventTime();
                        if (z4 || z5) {
                            if (pointerId >= 0) {
                                motionEventAdapter.activeHoverIds.delete(pointerId);
                                motionEventAdapter.motionEventToComposePointerIdMap.delete(pointerId);
                            }
                            HitPathTracker hitPathTracker = (HitPathTracker) realCacheRequest.cacheOut;
                            if (hitPathTracker.clearNodeCacheAfterDispatchedEvent) {
                                hitPathTracker.clearNodeCacheAfterDispatchedEvent = true;
                            } else {
                                hitPathTracker.root.children.clear();
                            }
                        }
                    }
                }
                androidComposeView2.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                if (z3) {
                    try {
                        androidComposeView2.sendSimulatedEvent(motionEvent, 10, motionEvent.getEventTime(), true);
                    } catch (Throwable th) {
                        th = th;
                        Trace.endSection();
                        throw th;
                    }
                }
                int iM691sendMotionEvent8iAsVTc = m691sendMotionEvent8iAsVTc(motionEvent);
                try {
                    Trace.endSection();
                    if ((iM691sendMotionEvent8iAsVTc & 4) == 0 && z3) {
                        HitPathTracker hitPathTracker2 = (HitPathTracker) realCacheRequest.cacheOut;
                        if (hitPathTracker2.clearNodeCacheAfterDispatchedEvent) {
                            hitPathTracker2.clearNodeCacheAfterDispatchedEvent = true;
                        } else {
                            hitPathTracker2.root.children.clear();
                        }
                        androidComposeView = this;
                        androidComposeView.sendSimulatedEvent(motionEvent, 9, motionEvent.getEventTime(), true);
                    } else {
                        androidComposeView = this;
                    }
                    androidComposeView.forceUseMatrixCache = false;
                    return iM691sendMotionEvent8iAsVTc;
                } catch (Throwable th2) {
                    th = th2;
                    androidComposeView2 = this;
                    androidComposeView2.forceUseMatrixCache = false;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestRemeasure(layoutNode, false);
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            invalidateLayoutNodeMeasurement((LayoutNode) objArr[i2]);
        }
    }

    public final boolean isInBounds(MotionEvent motionEvent, PointerClassification pointerClassification) {
        if (pointerClassification == PointerClassification.Pan) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return CropImageView.DEFAULT_ASPECT_RATIO <= x && x <= ((float) getWidth()) && CropImageView.DEFAULT_ASPECT_RATIO <= y && y <= ((float) getHeight());
    }

    public final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.previousMotionEvent) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    /* JADX INFO: renamed from: localToScreen-58bKbWc, reason: not valid java name */
    public final void m685localToScreen58bKbWc(float[] fArr) {
        recalculateWindowPosition();
        androidx.compose.ui.graphics.Matrix.m513timesAssign58bKbWc(fArr, this.viewToWindowMatrix);
        InvertMatrixKt.m712preTranslatecG2Xzmc(fArr, Float.intBitsToFloat((int) (this.windowPosition >> 32)), Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)), this.tmpMatrix);
    }

    /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
    public final long m686localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long jM508mapMKHz9U = androidx.compose.ui.graphics.Matrix.m508mapMKHz9U(j, this.viewToWindowMatrix);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.windowPosition >> 32)) + Float.intBitsToFloat((int) (jM508mapMKHz9U >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)) + Float.intBitsToFloat((int) (jM508mapMKHz9U & 4294967295L));
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
    }

    public final void measureAndLayout(boolean z) {
        FileMetadata fileMetadata = this.measureAndLayoutDelegate;
        if (((EmojiProcessor) fileMetadata.size).isNotEmpty() || ((MutableVector) ((WeakCache) fileMetadata.createdAtMillis).values).size != 0) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            try {
                if (fileMetadata.measureAndLayout(z ? this.resendMotionEventOnLayout : this.layoutChildViewsIfNeeded)) {
                    requestLayout();
                }
                fileMetadata.dispatchOnPositionedCallbacks(false);
                getRectManager().dispatchCallbacks();
                if (this.isPendingInteropViewLayoutChangeDispatch) {
                    getViewTreeObserver().dispatchOnGlobalLayout();
                    this.isPendingInteropViewLayoutChangeDispatch = false;
                }
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public final void m687measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        FileMetadata fileMetadata = this.measureAndLayoutDelegate;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            fileMetadata.m1918measureAndLayout0kLqBqw(layoutNode, j);
            if (!((EmojiProcessor) fileMetadata.size).isNotEmpty()) {
                fileMetadata.dispatchOnPositionedCallbacks(false);
                getRectManager().dispatchCallbacks();
                this.layoutChildViewsIfNeeded.invoke();
                if (this.isPendingInteropViewLayoutChangeDispatch) {
                    getViewTreeObserver().dispatchOnGlobalLayout();
                    this.isPendingInteropViewLayoutChangeDispatch = false;
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: renamed from: moveFocusInChildren-3ESFkO8, reason: not valid java name */
    public final boolean m688moveFocusInChildren3ESFkO8(int i) {
        if (i != 7 && i != 8) {
            Integer numM408toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m408toAndroidFocusDirection3ESFkO8(i);
            if (numM408toAndroidFocusDirection3ESFkO8 == null) {
                throw Fragment$5$$ExternalSyntheticOutline0.m$2("Invalid focus direction");
            }
            int iIntValue = numM408toAndroidFocusDirection3ESFkO8.intValue();
            FocusTargetNode activeFocusTargetNode = ((FocusOwnerImpl) getFocusOwner()).getActiveFocusTargetNode();
            if (activeFocusTargetNode == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("findNextViewInEmbeddedView called when owner does not have anything focused.");
                return false;
            }
            Integer numM408toAndroidFocusDirection3ESFkO9 = FocusInteropUtils_androidKt.m408toAndroidFocusDirection3ESFkO8(i);
            if (numM408toAndroidFocusDirection3ESFkO9 == null) {
                throw Fragment$5$$ExternalSyntheticOutline0.m$2("Invalid focus direction");
            }
            int iIntValue2 = numM408toAndroidFocusDirection3ESFkO9.intValue();
            ViewFactoryHolder viewFactoryHolder = HitTestResultKt.requireLayoutNode(activeFocusTargetNode).interopViewFactoryHolder;
            View interopView = viewFactoryHolder != null ? viewFactoryHolder.getInteropView() : null;
            View viewFindFocus = findFocus();
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            rootView.getClass();
            View viewFindNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, viewFindFocus, iIntValue2);
            if (viewFindNextFocus == null || interopView == null || !InvertMatrixKt.containsDescendant(interopView, viewFindNextFocus)) {
                viewFindNextFocus = null;
            }
            if (viewFindNextFocus != null) {
                return FocusInteropUtils_androidKt.requestInteropFocus(viewFindNextFocus, Integer.valueOf(iIntValue), null);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        RetainedValuesStore retainedValuesStore;
        Object obj;
        super.onAttachedToWindow();
        if (!getRoot().isAttached$1()) {
            getRoot().attach$ui(this);
        }
        setAttached(true);
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(InvertMatrixKt.getIsShowingLayoutBounds());
        }
        InsetsListener insetsListener = this.insetsListener;
        if (insetsListener != null) {
            insetsListener.onViewAttachedToWindow(this);
        }
        if (!this.composeViewContextIncrementedDuringInit) {
            getComposeViewContext().incrementViewCount$ui();
        }
        int i = 0;
        this.composeViewContextIncrementedDuringInit = false;
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().observer.start();
        AndroidComposeView outOfFrameExecutor = getOutOfFrameExecutor();
        if (outOfFrameExecutor == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Expected the view to be attached to window.");
            return;
        }
        outOfFrameExecutor.schedule(new AndroidComposeView$$ExternalSyntheticLambda4(this, (byte) 2));
        getComposeViewContext().getLifecycleOwner$ui();
        ComposeViewContext composeViewContext = getComposeViewContext();
        composeViewContext.resolveValuesIfNeeded();
        ViewModelStoreOwner viewModelStoreOwner = composeViewContext._viewModelStoreOwner;
        LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler = this.frameEndScheduler;
        if (viewModelStoreOwner == null || frameEndScheduler == null) {
            retainedValuesStore = null;
        } else {
            ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
            ViewModelProvider$NewInstanceFactory viewModelProvider$NewInstanceFactory = new ViewModelProvider$NewInstanceFactory();
            CreationExtras.Empty empty = CreationExtras.Empty.INSTANCE;
            viewModelStore.getClass();
            empty.getClass();
            Dispatcher dispatcher = new Dispatcher(viewModelStore, viewModelProvider$NewInstanceFactory, empty);
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LifecycleRetainedValuesStoreOwner.class);
            String qualifiedName = orCreateKotlinClass.getQualifiedName();
            if (qualifiedName == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
                return;
            }
            LifecycleRetainedValuesStoreOwner lifecycleRetainedValuesStoreOwner = (LifecycleRetainedValuesStoreOwner) dispatcher.getViewModel$lifecycle_viewmodel(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName));
            Object parent = getParent();
            parent.getClass();
            int id = ((View) parent).getId();
            MutableIntObjectMap mutableIntObjectMap = lifecycleRetainedValuesStoreOwner.scopes;
            Object mutableObjectList = mutableIntObjectMap.get(id);
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList(1);
                mutableIntObjectMap.set(id, mutableObjectList);
            }
            MutableObjectList mutableObjectList2 = (MutableObjectList) mutableObjectList;
            Object[] objArr = mutableObjectList2.content;
            int i2 = mutableObjectList2._size;
            while (true) {
                if (i >= i2) {
                    obj = null;
                    break;
                }
                obj = objArr[i];
                if (!((LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry) obj).isInUse) {
                    break;
                } else {
                    i++;
                }
            }
            LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = (LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry) obj;
            if (retainedValuesStoreEntry == null) {
                retainedValuesStoreEntry = new LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry();
                mutableObjectList2.add(retainedValuesStoreEntry);
            }
            retainedValuesStoreEntry.isInUse = true;
            this.lifecycleRetainedValuesStoreOwnerEntry = retainedValuesStoreEntry;
            retainedValuesStore = retainedValuesStoreEntry.retainedValuesStore;
        }
        if (retainedValuesStore == null) {
            retainedValuesStore = ForgetfulRetainedValuesStore.INSTANCE;
        }
        this.retainedValuesStore = retainedValuesStore;
        Function1 function1 = this.onReadyForComposition;
        if (function1 != null) {
            function1.invoke(getComposeViewContext());
            this.onReadyForComposition = null;
        }
        Lifecycle lifecycle = getComposeViewContext().getLifecycleOwner$ui().getLifecycle();
        lifecycle.addObserver(this);
        lifecycle.addObserver(this.contentCaptureManager);
        getInputModeManager().inputMode$delegate.setValue(new InputMode(isInTouchMode() ? 1 : 2));
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        getViewTreeObserver().addOnScrollChangedListener(this);
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.setViewTranslationCallback(this);
        }
        AndroidAutofillManager androidAutofillManagerM694getAutofillManager = m694getAutofillManager();
        if (androidAutofillManagerM694getAutofillManager != null) {
            ((FocusOwnerImpl) getFocusOwner()).listeners.add(androidAutofillManagerM694getAutofillManager);
            getSemanticsOwner().listeners.add(androidAutofillManagerM694getAutofillManager);
        }
        ((FocusOwnerImpl) getFocusOwner()).listeners.add(this);
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        SessionMutex$Session sessionMutex$Session = (SessionMutex$Session) this.textInputSessionMutex.get();
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) (sessionMutex$Session != null ? sessionMutex$Session.value : null);
        if (androidPlatformTextInputSession == null) {
            return getLegacyTextInputServiceAndroid().editorHasFocus;
        }
        SessionMutex$Session sessionMutex$Session2 = (SessionMutex$Session) androidPlatformTextInputSession.methodSessionMutex.get();
        InputMethodSession inputMethodSession = (InputMethodSession) (sessionMutex$Session2 != null ? sessionMutex$Session2.value : null);
        return inputMethodSession != null && (inputMethodSession.disposed ^ true);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateConfiguration(configuration);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x013f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0148  */
    /* JADX WARN: Code duplicated, block: B:108:0x014c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0151 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0153  */
    /* JADX WARN: Code duplicated, block: B:111:0x0158 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x015a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0162  */
    /* JADX WARN: Code duplicated, block: B:119:0x0191  */
    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        int i2;
        SessionMutex$Session sessionMutex$Session = (SessionMutex$Session) this.textInputSessionMutex.get();
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) (sessionMutex$Session != null ? sessionMutex$Session.value : null);
        byte b = 3;
        if (androidPlatformTextInputSession != null) {
            SessionMutex$Session sessionMutex$Session2 = (SessionMutex$Session) androidPlatformTextInputSession.methodSessionMutex.get();
            InputMethodSession inputMethodSession = (InputMethodSession) (sessionMutex$Session2 != null ? sessionMutex$Session2.value : null);
            if (inputMethodSession == null) {
                return null;
            }
            synchronized (inputMethodSession.lock) {
                if (inputMethodSession.disposed) {
                    return null;
                }
                RecordingInputConnection recordingInputConnectionCreateInputConnection = inputMethodSession.request.createInputConnection(editorInfo);
                DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0(b, inputMethodSession);
                InputConnection nullableInputConnectionWrapperApi34 = Build.VERSION.SDK_INT >= 34 ? new NullableInputConnectionWrapperApi34(recordingInputConnectionCreateInputConnection, diskLruCache$$ExternalSyntheticLambda0) : new NullableInputConnectionWrapperApi25(recordingInputConnectionCreateInputConnection, diskLruCache$$ExternalSyntheticLambda0);
                inputMethodSession.connections.add(new WeakReference(nullableInputConnectionWrapperApi34));
                return nullableInputConnectionWrapperApi34;
            }
        }
        TextInputServiceAndroid legacyTextInputServiceAndroid = getLegacyTextInputServiceAndroid();
        if (!legacyTextInputServiceAndroid.editorHasFocus) {
            return null;
        }
        ImeOptions imeOptions = legacyTextInputServiceAndroid.imeOptions;
        TextFieldValue textFieldValue = legacyTextInputServiceAndroid.state;
        int i3 = imeOptions.imeAction;
        boolean z = imeOptions.singleLine;
        int i4 = 4;
        if (i3 == 1) {
            i = z ? 6 : 0;
        } else if (i3 == 0) {
            i = 1;
        } else if (i3 == 2) {
            i = 2;
        } else if (i3 == 6) {
            i = 5;
        } else if (i3 == 5) {
            i = 7;
        } else if (i3 == 3) {
            i = 3;
        } else if (i3 == 4) {
            i = 4;
        } else {
            if (i3 != 7) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("invalid ImeAction");
                return null;
            }
        }
        editorInfo.imeOptions = i;
        int i5 = imeOptions.keyboardType;
        if (i5 != 1) {
            if (i5 == 2) {
                editorInfo.inputType = 1;
                i |= Integer.MIN_VALUE;
                editorInfo.imeOptions = i;
            } else if (i5 == 3) {
                editorInfo.inputType = 2;
                i4 = 2;
            } else if (i5 == 4) {
                editorInfo.inputType = 3;
                i4 = 3;
            } else if (i5 == 5) {
                editorInfo.inputType = 17;
                i4 = 17;
            } else if (i5 == 6) {
                i4 = 33;
                editorInfo.inputType = 33;
            } else if (i5 == 7) {
                i4 = 129;
                editorInfo.inputType = 129;
            } else if (i5 == 8) {
                editorInfo.inputType = 18;
                i4 = 18;
            } else if (i5 == 9) {
                i4 = 8194;
                editorInfo.inputType = 8194;
            } else if (i5 == 10) {
                i4 = 145;
                editorInfo.inputType = 145;
            } else if (i5 == 11) {
                i4 = 113;
                editorInfo.inputType = 113;
            } else if (i5 == 12) {
                i4 = 97;
                editorInfo.inputType = 97;
            } else if (i5 == 13) {
                i4 = 49;
                editorInfo.inputType = 49;
            } else if (i5 == 14) {
                i4 = 65;
                editorInfo.inputType = 65;
            } else if (i5 == 15) {
                i4 = 81;
                editorInfo.inputType = 81;
            } else if (i5 == 16) {
                i4 = 177;
                editorInfo.inputType = 177;
            } else if (i5 == 17) {
                i4 = 193;
                editorInfo.inputType = 193;
            } else if (i5 == 18) {
                editorInfo.inputType = 4;
            } else {
                i4 = 20;
                if (i5 == 19) {
                    editorInfo.inputType = 20;
                } else if (i5 == 20) {
                    i4 = 36;
                    editorInfo.inputType = 36;
                } else if (i5 == 21) {
                    i4 = ByteBufferPoolKt.DEFAULT_BUFFER_SIZE;
                    editorInfo.inputType = ByteBufferPoolKt.DEFAULT_BUFFER_SIZE;
                } else if (i5 == 22) {
                    i4 = 12290;
                    editorInfo.inputType = 12290;
                } else if (i5 == 23) {
                    i4 = 8210;
                    editorInfo.inputType = 8210;
                } else if (i5 == 24) {
                    i4 = 4114;
                    editorInfo.inputType = 4114;
                } else {
                    if (i5 != 25) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Invalid Keyboard Type");
                        return null;
                    }
                    i4 = 12306;
                    editorInfo.inputType = 12306;
                }
            }
            if (!z && (i4 & 15) == 1) {
                i4 |= 131072;
                editorInfo.inputType = i4;
                if (i3 == 1) {
                    editorInfo.imeOptions = 1073741824 | i;
                }
            }
            if ((i4 & 15) == 1) {
                i2 = imeOptions.capitalization;
                if (i2 == 1) {
                    i4 |= 4096;
                    editorInfo.inputType = i4;
                } else if (i2 == 2) {
                    i4 |= 8192;
                    editorInfo.inputType = i4;
                } else if (i2 == 3) {
                    i4 |= 16384;
                    editorInfo.inputType = i4;
                }
                if (imeOptions.autoCorrect) {
                    editorInfo.inputType = 32768 | i4;
                }
            }
            long j = textFieldValue.selection;
            int i6 = TextRange.$r8$clinit;
            editorInfo.initialSelStart = (int) (j >> 32);
            editorInfo.initialSelEnd = (int) (j & 4294967295L);
            SQLite.setInitialSurroundingText(editorInfo, textFieldValue.annotatedString.text);
            editorInfo.imeOptions |= 33554432;
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(editorInfo);
            }
            androidx.compose.ui.text.input.RecordingInputConnection recordingInputConnection = new androidx.compose.ui.text.input.RecordingInputConnection(legacyTextInputServiceAndroid.state, new AtomicInt(legacyTextInputServiceAndroid), legacyTextInputServiceAndroid.imeOptions.autoCorrect);
            legacyTextInputServiceAndroid.ics.add(new java.lang.ref.WeakReference(recordingInputConnection));
            return recordingInputConnection;
        }
        editorInfo.inputType = 1;
        i4 = 1;
        if (!z) {
            i4 |= 131072;
            editorInfo.inputType = i4;
            if (i3 == 1) {
                editorInfo.imeOptions = 1073741824 | i;
            }
        }
        if ((i4 & 15) == 1) {
            i2 = imeOptions.capitalization;
            if (i2 == 1) {
                i4 |= 4096;
                editorInfo.inputType = i4;
            } else if (i2 == 2) {
                i4 |= 8192;
                editorInfo.inputType = i4;
            } else if (i2 == 3) {
                i4 |= 16384;
                editorInfo.inputType = i4;
            }
            if (imeOptions.autoCorrect) {
                editorInfo.inputType = 32768 | i4;
            }
        }
        long j2 = textFieldValue.selection;
        int i7 = TextRange.$r8$clinit;
        editorInfo.initialSelStart = (int) (j2 >> 32);
        editorInfo.initialSelEnd = (int) (j2 & 4294967295L);
        SQLite.setInitialSurroundingText(editorInfo, textFieldValue.annotatedString.text);
        editorInfo.imeOptions |= 33554432;
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
        androidx.compose.ui.text.input.RecordingInputConnection recordingInputConnection2 = new androidx.compose.ui.text.input.RecordingInputConnection(legacyTextInputServiceAndroid.state, new AtomicInt(legacyTextInputServiceAndroid), legacyTextInputServiceAndroid.imeOptions.autoCorrect);
        legacyTextInputServiceAndroid.ics.add(new java.lang.ref.WeakReference(recordingInputConnection2));
        return recordingInputConnection2;
    }

    @Override // android.view.View
    public final void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer consumer) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.getClass();
        DisplayCompat.onCreateVirtualViewTranslationRequests(androidContentCaptureManager, jArr, consumer);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setAttached(false);
        BoxParser.StsdData stsdData = this.indirectPointerNavigationGestureDetector;
        stsdData.nalUnitLengthFieldLength = 0;
        stsdData.requiredSampleTransformation = true;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
        ((GestureDetector) stsdData.format).onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        InsetsListener insetsListener = this.insetsListener;
        if (insetsListener != null) {
            insetsListener.onViewDetachedFromWindow(this);
        }
        View view = this.frameRateCategoryView;
        if (isArrEnabled$ui() && view != null) {
            removeView(view);
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 28) {
            MutableObjectList mutableObjectList = composeViews;
            synchronized (mutableObjectList) {
                mutableObjectList.remove(this);
            }
        }
        getComposeViewContext().decrementViewCount$ui();
        SnapshotStateObserver snapshotStateObserver = getSnapshotObserver().observer;
        OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = snapshotStateObserver.applyUnsubscribe;
        if (onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 != null) {
            onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
        }
        snapshotStateObserver.clear();
        Lifecycle lifecycle = getComposeViewContext().getLifecycleOwner$ui().getLifecycle();
        lifecycle.removeObserver(this.contentCaptureManager);
        lifecycle.removeObserver(this);
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        getViewTreeObserver().removeOnScrollChangedListener(this);
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            retainedValuesStoreEntry.isInUse = false;
        }
        this.lifecycleRetainedValuesStoreOwnerEntry = null;
        if (i >= 31) {
            Api31Impl.clearViewTranslationCallback(this);
        }
        AndroidAutofillManager androidAutofillManagerM694getAutofillManager = m694getAutofillManager();
        if (androidAutofillManagerM694getAutofillManager != null) {
            getSemanticsOwner().listeners.remove(androidAutofillManagerM694getAutofillManager);
            ((FocusOwnerImpl) getFocusOwner()).listeners.remove(androidAutofillManagerM694getAutofillManager);
        }
        RectManager rectManager = getRectManager();
        rectManager.isScreenOrWindowDirty = rectManager.throttledCallbacks.m722updateOffsetsLDcG7Xg(0L, 0L, null, 0, 0);
        getRectManager().dispatchCallbacks();
        RectManager rectManager2 = getRectManager();
        PopupLayout$$ExternalSyntheticLambda5 popupLayout$$ExternalSyntheticLambda5 = rectManager2.dispatchToken;
        if (popupLayout$$ExternalSyntheticLambda5 != null) {
            rectManager2.executeDelayed.removeCallbacks(popupLayout$$ExternalSyntheticLambda5);
            rectManager2.dispatchToken = null;
        }
        ((FocusOwnerImpl) getFocusOwner()).listeners.remove(this);
    }

    public final void onEndApplyChanges() {
        MutableObjectList mutableObjectList;
        Object[] objArr;
        if (this.observationClearRequested) {
            SnapshotStateObserver snapshotStateObserver = getSnapshotObserver().observer;
            ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 23);
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                try {
                    MutableVector mutableVector = snapshotStateObserver.observedScopeMaps;
                    int i = mutableVector.size;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        objArr = mutableVector.content;
                        if (i2 >= i) {
                            break;
                        }
                        SnapshotStateObserver.ObservedScopeMap observedScopeMap = (SnapshotStateObserver.ObservedScopeMap) objArr[i2];
                        observedScopeMap.removeScopeIf(composedModifierKt$$ExternalSyntheticLambda0);
                        if (!(observedScopeMap.getScopeToValues()._size != 0)) {
                            i3++;
                        } else if (i3 > 0) {
                            Object[] objArr2 = mutableVector.content;
                            objArr2[i2 - i3] = objArr2[i2];
                        }
                        i2++;
                    }
                    int i4 = i - i3;
                    Arrays.fill(objArr, i4, i, (Object) null);
                    mutableVector.size = i4;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        AndroidAutofillManager androidAutofillManagerM694getAutofillManager = m694getAutofillManager();
        if (androidAutofillManagerM694getAutofillManager != null) {
            MutableIntSet mutableIntSet = androidAutofillManagerM694getAutofillManager.currentlyDisplayedIDs;
            if (mutableIntSet._size == 0 && androidAutofillManagerM694getAutofillManager.pendingAutofillCommit) {
                androidAutofillManagerM694getAutofillManager.platformAutofillManager.getPlatformAndroidManager().commit();
                androidAutofillManagerM694getAutofillManager.pendingAutofillCommit = false;
            }
            if (mutableIntSet._size != 0) {
                androidAutofillManagerM694getAutofillManager.pendingAutofillCommit = true;
            }
        }
        while (this.endApplyChangesListeners.isNotEmpty() && this.endApplyChangesListeners.get(0) != null) {
            int i5 = this.endApplyChangesListeners._size;
            int i6 = 0;
            while (true) {
                mutableObjectList = this.endApplyChangesListeners;
                if (i6 < i5) {
                    Function0 function0 = (Function0) mutableObjectList.get(i6);
                    MutableObjectList mutableObjectList2 = this.endApplyChangesListeners;
                    if (i6 < 0 || i6 >= mutableObjectList2._size) {
                        mutableObjectList2.throwIndexOutOfBoundsExclusiveException$collection(i6);
                        throw null;
                    }
                    Object[] objArr3 = mutableObjectList2.content;
                    Object obj = objArr3[i6];
                    objArr3[i6] = null;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    i6++;
                }
            }
            mutableObjectList.removeRange(0, i5);
        }
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public final void onFocusChanged(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        NodeChain nodeChain;
        boolean z;
        NodeChain nodeChain2;
        boolean z2;
        if (focusTargetNode != null) {
            FocusTargetNode focusTargetNode3 = focusTargetNode;
            if (!focusTargetNode3.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode3.node;
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
            MutableScatterSet mutableScatterSet = null;
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode != null) {
                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                    while (node != null) {
                        if ((node.kindSet & 2097152) != 0) {
                            Modifier.Node nodePop = node;
                            MutableVector mutableVector = null;
                            while (nodePop != null) {
                                if (nodePop instanceof IndirectPointerInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2 && (nodePop.kindSet & 2097152) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                        if ((node2.kindSet & 2097152) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = node2;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector.add(node2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = HitTestResultKt.pop(mutableVector);
                            }
                        }
                        node = node.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodeChain2 = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain2.tail;
            }
            if (arrayList == null) {
                return;
            }
            if (focusTargetNode2 != null) {
                if (!focusTargetNode2.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node3 = focusTargetNode2.node;
                LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNode2);
                MutableScatterSet mutableScatterSet2 = null;
                while (layoutNodeRequireLayoutNode2 != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                        while (node3 != null) {
                            if ((node3.kindSet & 2097152) != 0) {
                                Modifier.Node nodePop2 = node3;
                                MutableVector mutableVector2 = null;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof IndirectPointerInputModifierNode) {
                                        if (mutableScatterSet2 == null) {
                                            MutableScatterSet mutableScatterSet3 = ScatterSetKt.EmptyScatterSet;
                                            mutableScatterSet2 = new MutableScatterSet();
                                        }
                                        mutableScatterSet2.add(nodePop2);
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z && (nodePop2.kindSet & 2097152) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node node4 = ((DelegatingNode) nodePop2).delegate; node4 != null; node4 = node4.child) {
                                            if ((node4.kindSet & 2097152) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    nodePop2 = node4;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodePop2 != null) {
                                                        mutableVector2.add(nodePop2);
                                                        nodePop2 = null;
                                                    }
                                                    mutableVector2.add(node4);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    nodePop2 = HitTestResultKt.pop(mutableVector2);
                                }
                            }
                            node3 = node3.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                    node3 = (layoutNodeRequireLayoutNode2 == null || (nodeChain = layoutNodeRequireLayoutNode2.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
                mutableScatterSet = mutableScatterSet2;
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                IndirectPointerInputModifierNode indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) arrayList.get(i3);
                if (!(mutableScatterSet != null ? mutableScatterSet.contains(indirectPointerInputModifierNode) : false)) {
                    indirectPointerInputModifierNode.onCancelIndirectPointerInput();
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.lastMatrixRecalculationAnimationTime = 0L;
        updatePositionCacheAndDispatch();
        int i = Build.VERSION.SDK_INT;
        if (32 > i || i >= 34) {
            return;
        }
        updateConfiguration(getResources().getConfiguration());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Trace.beginSection("AndroidOwner:onLayout");
        try {
            this.lastMatrixRecalculationAnimationTime = 0L;
            this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
            this.onMeasureConstraints = null;
            updatePositionCacheAndDispatch();
            AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
            if (androidViewsHandler != null) {
                Trace.beginSection("AndroidOwner:viewLayout");
                try {
                    androidViewsHandler.layout(0, 0, i3 - i, i4 - i2);
                    Trace.endSection();
                } finally {
                    Trace.endSection();
                }
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void onLayoutChange(LayoutNode layoutNode) {
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
        androidComposeViewAccessibilityDelegateCompat.currentSemanticsNodesInvalidated = true;
        if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui()) {
            androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.currentSemanticsNodesInvalidated = true;
        if (androidContentCaptureManager.isEnabled$ui()) {
            androidContentCaptureManager.boundsUpdateChannel.mo1712trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        FileMetadata fileMetadata = this.measureAndLayoutDelegate;
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!getRoot().isAttached$1()) {
                getRoot().attach$ui(this);
            }
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long jM681convertMeasureSpecI7RO_PI = m681convertMeasureSpecI7RO_PI(i);
            long jM681convertMeasureSpecI7RO_PI2 = m681convertMeasureSpecI7RO_PI(i2);
            long jM879fitPrioritizingHeightZbe2FdA = FileSystemsKt.m879fitPrioritizingHeightZbe2FdA((int) (jM681convertMeasureSpecI7RO_PI >>> 32), (int) (jM681convertMeasureSpecI7RO_PI & 4294967295L), (int) (jM681convertMeasureSpecI7RO_PI2 >>> 32), (int) (4294967295L & jM681convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            if (constraints == null) {
                this.onMeasureConstraints = new Constraints(jM879fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else if (!Constraints.m778equalsimpl0(constraints.value, jM879fitPrioritizingHeightZbe2FdA)) {
                this.wasMeasuredWithMultipleConstraints = true;
            }
            fileMetadata.m1919updateRootConstraintsBRTryo0(jM879fitPrioritizingHeightZbe2FdA);
            fileMetadata.measureOnly();
            setMeasuredDimension(getRoot().layoutDelegate.measurePassDelegate.width, getRoot().layoutDelegate.measurePassDelegate.height);
            AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
            if (androidViewsHandler != null) {
                Trace.beginSection("AndroidOwner:androidViewMeasure");
                try {
                    androidViewsHandler.measure(View.MeasureSpec.makeMeasureSpec(getRoot().layoutDelegate.measurePassDelegate.width, 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().layoutDelegate.measurePassDelegate.height, 1073741824));
                    Trace.endSection();
                } finally {
                    Trace.endSection();
                }
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        if (viewStructure == null || this.isDispatchingAutofillStructure) {
            return;
        }
        populateAutofillVirtualStructure(viewStructure);
    }

    public final void onRequestMeasure(LayoutNode layoutNode, boolean z, boolean z2, boolean z3) {
        LayoutNode parent$ui;
        LayoutNode parent$ui2;
        FileMetadata fileMetadata = this.measureAndLayoutDelegate;
        if (!z) {
            if (fileMetadata.requestRemeasure(layoutNode, z2) && z3) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        EmojiProcessor emojiProcessor = (EmojiProcessor) fileMetadata.size;
        LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (layoutNode2 == null) {
            InlineClassHelperKt.throwIllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int iOrdinal = layoutNodeLayoutDelegate.layoutState.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                if (!layoutNodeLayoutDelegate.lookaheadMeasurePending || z2) {
                    layoutNodeLayoutDelegate.lookaheadMeasurePending = true;
                    layoutNodeLayoutDelegate.measurePassDelegate.measurePending = true;
                    if (layoutNode.isDeactivated) {
                        return;
                    }
                    if ((Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || FileMetadata.getCanAffectParentInLookahead(layoutNode)) && ((parent$ui = layoutNode.getParent$ui()) == null || !parent$ui.layoutDelegate.lookaheadMeasurePending)) {
                        emojiProcessor.add(layoutNode, Invalidation.LookaheadMeasurement);
                    } else if ((layoutNode.isPlaced() || FileMetadata.getCanAffectPlacedParent(layoutNode)) && ((parent$ui2 = layoutNode.getParent$ui()) == null || !parent$ui2.getMeasurePending$ui())) {
                        emojiProcessor.add(layoutNode, Invalidation.Measurement);
                    }
                    if (fileMetadata.isDirectory || !z3) {
                        return;
                    }
                    scheduleMeasureAndLayout(layoutNode);
                    return;
                }
                return;
            }
        }
        ((MutableVector) fileMetadata.lastAccessedAtMillis).add(new MeasureAndLayoutDelegate$PostponedRequest(layoutNode, true, z2));
    }

    public final void onRequestRelayout(LayoutNode layoutNode, boolean z, boolean z2) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        Invalidation invalidation = Invalidation.Placement;
        FileMetadata fileMetadata = this.measureAndLayoutDelegate;
        if (!z) {
            fileMetadata.getClass();
            int iOrdinal = layoutNodeLayoutDelegate.layoutState.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                return;
            }
            if (iOrdinal != 4) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            LayoutNode parent$ui = layoutNode.getParent$ui();
            boolean z3 = parent$ui == null || parent$ui.isPlaced();
            if (!z2) {
                if (layoutNode.getMeasurePending$ui()) {
                    return;
                }
                if (layoutNode.getLayoutPending$ui() && layoutNode.isPlaced() == z3 && layoutNode.isPlaced() == layoutNodeLayoutDelegate.measurePassDelegate.isPlacedByParent) {
                    return;
                }
            }
            MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate.measurePassDelegate;
            measurePassDelegate.layoutPending = true;
            measurePassDelegate.layoutPendingForAlignment = true;
            if (!layoutNode.isDeactivated && measurePassDelegate.isPlacedByParent && z3) {
                if ((parent$ui == null || !parent$ui.getLayoutPending$ui()) && (parent$ui == null || !parent$ui.getMeasurePending$ui())) {
                    ((EmojiProcessor) fileMetadata.size).add(layoutNode, invalidation);
                }
                if (fileMetadata.isDirectory) {
                    return;
                }
                scheduleMeasureAndLayout(null);
                return;
            }
            return;
        }
        EmojiProcessor emojiProcessor = (EmojiProcessor) fileMetadata.size;
        int iOrdinal2 = layoutNodeLayoutDelegate.layoutState.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                return;
            }
            if (iOrdinal2 != 2) {
                if (iOrdinal2 == 3) {
                    return;
                }
                if (iOrdinal2 != 4) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
            }
        }
        if ((layoutNodeLayoutDelegate.lookaheadMeasurePending || layoutNodeLayoutDelegate.lookaheadLayoutPending) && !z2) {
            return;
        }
        layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
        layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
        MeasurePassDelegate measurePassDelegate2 = layoutNodeLayoutDelegate.measurePassDelegate;
        measurePassDelegate2.layoutPending = true;
        measurePassDelegate2.layoutPendingForAlignment = true;
        if (layoutNode.isDeactivated) {
            return;
        }
        LayoutNode parent$ui2 = layoutNode.getParent$ui();
        if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) && ((parent$ui2 == null || !parent$ui2.layoutDelegate.lookaheadMeasurePending) && (parent$ui2 == null || !parent$ui2.layoutDelegate.lookaheadLayoutPending))) {
            emojiProcessor.add(layoutNode, Invalidation.LookaheadPlacement);
        } else if (layoutNode.isPlaced() && ((parent$ui2 == null || !parent$ui2.getLayoutPending$ui()) && (parent$ui2 == null || !parent$ui2.getMeasurePending$ui()))) {
            emojiProcessor.add(layoutNode, invalidation);
        }
        if (fileMetadata.isDirectory) {
            return;
        }
        scheduleMeasureAndLayout(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        androidx.compose.ui.input.pointer.PointerIcon pointerIcon;
        int toolType = motionEvent.getToolType(i);
        return (motionEvent.isFromSource(8194) || !motionEvent.isFromSource(16386) || !(toolType == 2 || toolType == 4) || (pointerIcon = ((AndroidComposeView$pointerIconService$1) getPointerIconService()).currentStylusHoverIcon) == null) ? super.onResolvePointerIcon(motionEvent, i) : Api24Impl.toAndroidPointerIcon(getContext(), pointerIcon);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        CancellationHandle cancellationHandleScheduleFrameEndCallback;
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(InvertMatrixKt.getIsShowingLayoutBounds());
        }
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler = this.frameEndScheduler;
            frameEndScheduler.getClass();
            ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) retainedValuesStoreEntry._retainedValuesStore.block;
            if (!managedRetainedValuesStore.isEnabled || managedRetainedValuesStore.isContentComposed) {
                return;
            }
            try {
                cancellationHandleScheduleFrameEndCallback = ((Wrapper_androidKt.AnonymousClass1) frameEndScheduler).$tmp0.scheduleFrameEndCallback(new RoomDatabase$$ExternalSyntheticLambda0((byte) 16, retainedValuesStoreEntry));
            } catch (CancellationException unused) {
                if (!managedRetainedValuesStore.isDisposed) {
                    if (managedRetainedValuesStore.isContentComposed) {
                        PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                    }
                    managedRetainedValuesStore.purgeUnusedExitedValues();
                    managedRetainedValuesStore.isContentComposed = true;
                }
                cancellationHandleScheduleFrameEndCallback = null;
            }
            CancellationHandle cancellationHandle = retainedValuesStoreEntry.endRetainCancellationHandle;
            if (cancellationHandle != null) {
                cancellationHandle.cancel();
            }
            retainedValuesStoreEntry.endRetainCancellationHandle = cancellationHandleScheduleFrameEndCallback;
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        LayoutDirection layoutDirection;
        if (this.superclassInitComplete) {
            int[] iArr = FocusInteropUtils_androidKt.tempCoordinates;
            LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
            if (i != 0) {
                layoutDirection = i != 1 ? null : LayoutDirection.Rtl;
            } else {
                layoutDirection = layoutDirection2;
            }
            if (layoutDirection != null) {
                layoutDirection2 = layoutDirection;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    @Override // android.view.View
    public final void onScrollCaptureSearch(android.graphics.Rect rect, Point point, Consumer consumer) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), consumer);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        updatePositionCacheAndDispatch();
    }

    public final void onSemanticsChange() {
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
        androidComposeViewAccessibilityDelegateCompat.currentSemanticsNodesInvalidated = true;
        Handler handler = androidComposeViewAccessibilityDelegateCompat.view.getHandler();
        if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui() && !androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges && handler != null) {
            androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = true;
            handler.post(androidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker);
        }
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.currentSemanticsNodesInvalidated = true;
        Handler handler2 = androidContentCaptureManager.view.getHandler();
        if (!androidContentCaptureManager.isEnabled$ui() || androidContentCaptureManager.checkingForSemanticsChanges || handler2 == null) {
            return;
        }
        androidContentCaptureManager.checkingForSemanticsChanges = true;
        handler2.post(androidContentCaptureManager.contentCaptureChangeChecker);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) retainedValuesStoreEntry._retainedValuesStore.block;
            if (managedRetainedValuesStore.isEnabled && !managedRetainedValuesStore.isContentComposed) {
                CancellationHandle cancellationHandle = retainedValuesStoreEntry.endRetainCancellationHandle;
                if (cancellationHandle != null) {
                    cancellationHandle.cancel();
                }
                retainedValuesStoreEntry.endRetainCancellationHandle = null;
                return;
            }
            if (managedRetainedValuesStore.isDisposed) {
                return;
            }
            if (!managedRetainedValuesStore.isContentComposed) {
                PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to leave composition twice. Is the store installed in multiple places?");
            }
            if (!managedRetainedValuesStore.keptExitedValues.isEmpty()) {
                PreconditionsKt.throwIllegalStateException("Attempted to start retaining exited values with pending exited values");
            }
            managedRetainedValuesStore.isContentComposed = false;
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public final void onTouchModeChanged(boolean z) {
        getInputModeManager().inputMode$delegate.setValue(new InputMode(z ? 1 : 2));
    }

    @Override // android.view.View
    public final void onVirtualViewTranslationResponses(android.util.LongSparseArray longSparseArray) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.getClass();
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            DisplayCompat.doTranslation(androidContentCaptureManager, longSparseArray);
        } else {
            androidContentCaptureManager.view.post(new ComponentActivity$$ExternalSyntheticLambda10(androidContentCaptureManager, longSparseArray, (byte) 2));
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        boolean isShowingLayoutBounds;
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z);
        if (!z || Build.VERSION.SDK_INT >= 30 || getShowLayoutBounds() == (isShowingLayoutBounds = InvertMatrixKt.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateLayers(getRoot());
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ae  */
    public final void populateAutofillVirtualStructure(ViewStructure viewStructure) {
        AndroidAutofillManager androidAutofillManagerM694getAutofillManager = m694getAutofillManager();
        if (androidAutofillManagerM694getAutofillManager != null) {
            LayoutNode layoutNode = androidAutofillManagerM694getAutofillManager.semanticsOwner.rootNode;
            AutofillId autofillId = androidAutofillManagerM694getAutofillManager.rootAutofillId;
            String str = androidAutofillManagerM694getAutofillManager.packageName;
            RectManager rectManager = androidAutofillManagerM694getAutofillManager.rectManager;
            FileSystemsKt.populate(viewStructure, layoutNode, autofillId, str, rectManager);
            Object[] objArr = ObjectListKt.EmptyArray;
            MutableObjectList mutableObjectList = new MutableObjectList(2);
            mutableObjectList.add(layoutNode);
            mutableObjectList.add(viewStructure);
            while (mutableObjectList.isNotEmpty()) {
                Object objRemoveAt = mutableObjectList.removeAt(mutableObjectList._size - 1);
                objRemoveAt.getClass();
                ViewStructure viewStructure2 = (ViewStructure) objRemoveAt;
                Object objRemoveAt2 = mutableObjectList.removeAt(mutableObjectList._size - 1);
                objRemoveAt2.getClass();
                MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) ((LayoutNode) objRemoveAt2).getChildren$ui();
                int i = ((MutableVector) objectListMutableList.objectList).size;
                for (int i2 = 0; i2 < i; i2++) {
                    LayoutNode layoutNode2 = (LayoutNode) objectListMutableList.get(i2);
                    if (!layoutNode2.isDeactivated && layoutNode2.isAttached$1() && layoutNode2.isPlaced()) {
                        SemanticsConfiguration semanticsConfiguration = layoutNode2.getSemanticsConfiguration();
                        if (semanticsConfiguration != null) {
                            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
                            if (mutableScatterMap.contains(SemanticsActions.OnAutofillText) || mutableScatterMap.contains(SemanticsActions.OnFillData) || mutableScatterMap.contains(SemanticsProperties.ContentType) || mutableScatterMap.contains(SemanticsProperties.ContentDataType) || (Build.VERSION.SDK_INT >= 34 && mutableScatterMap.contains(SemanticsNodeKt.CredentialRequest))) {
                                ViewStructure viewStructureNewChild = viewStructure2.newChild(viewStructure2.addChildCount(1));
                                FileSystemsKt.populate(viewStructureNewChild, layoutNode2, autofillId, str, rectManager);
                                mutableObjectList.add(layoutNode2);
                                mutableObjectList.add(viewStructureNewChild);
                            } else {
                                mutableObjectList.add(layoutNode2);
                                mutableObjectList.add(viewStructure2);
                            }
                        } else {
                            mutableObjectList.add(layoutNode2);
                            mutableObjectList.add(viewStructure2);
                        }
                    }
                }
            }
        }
        AndroidAutofill androidAutofillM693getAutofill = m693getAutofill();
        if (androidAutofillM693getAutofill != null) {
            AutofillTree autofillTree = androidAutofillM693getAutofill.autofillTree;
            LinkedHashMap linkedHashMap = autofillTree.children;
            LinkedHashMap linkedHashMap2 = autofillTree.children;
            if (linkedHashMap.isEmpty()) {
                return;
            }
            int iAddChildCount = viewStructure.addChildCount(linkedHashMap2.size());
            Iterator it = linkedHashMap2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                int iIntValue = ((Number) entry.getKey()).intValue();
                if (entry.getValue() != null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                ViewStructure viewStructureNewChild2 = viewStructure.newChild(iAddChildCount);
                viewStructureNewChild2.setAutofillId(androidAutofillM693getAutofill.rootAutofillId, iIntValue);
                viewStructureNewChild2.setId(iIntValue, androidAutofillM693getAutofill.view.getContext().getPackageName(), null, null);
                viewStructureNewChild2.setAutofillType(1);
                throw null;
            }
        }
    }

    public final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = jCurrentAnimationTimeMillis;
            int i = Build.VERSION.SDK_INT;
            int[] iArr = this.tmpPositionArray;
            float[] fArr = this.viewToWindowMatrix;
            if (i >= 29) {
                Api29Impl.m703calculateMatrixToWindowV2T6pWw(this, fArr, this.tmpAndroidMatrix, iArr);
            } else {
                Api21Impl.m701calculateMatrixToWindowqGEkDyk(this, fArr, this.tmpMatrix, iArr);
            }
            InvertMatrixKt.m709invertToJiSxe2E(fArr, this.windowToViewMatrix);
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(iArr);
            float f = iArr[0];
            float f2 = iArr[1];
            view.getLocationInWindow(iArr);
            this.windowPosition = (((long) Float.floatToRawIntBits(f - iArr[0])) << 32) | (((long) Float.floatToRawIntBits(f2 - iArr[1])) & 4294967295L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, android.graphics.Rect rect) {
        if (!isFocused()) {
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
            byte b = 7;
            int i2 = focusDirection != null ? focusDirection.value : 7;
            Boolean boolM411focusSearchULY8qGw = ((FocusOwnerImpl) getFocusOwner()).m411focusSearchULY8qGw(i2, rect != null ? new Rect(rect.left, rect.top, rect.right, rect.bottom) : null, new TimePickerKt$$ExternalSyntheticLambda36((byte) 6, i2));
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(boolM411focusSearchULY8qGw, bool)) {
                if (!Intrinsics.areEqual(((FocusOwnerImpl) getFocusOwner()).m411focusSearchULY8qGw(i2, null, new TimePickerKt$$ExternalSyntheticLambda36(b, i2)), bool)) {
                    if (!hasFocus()) {
                        return false;
                    }
                    if (i2 == 1 || i2 == 2) {
                        return ((FocusOwnerImpl) getFocusOwner()).m413resetFocus3ESFkO8(i2);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: requestOwnerFocus-7o62pno, reason: not valid java name */
    public final boolean m689requestOwnerFocus7o62pno() {
        if (isFocused()) {
            return true;
        }
        return super.requestFocus(130, null);
    }

    public final void schedule(Function0 function0) {
        ArrayDeque arrayDeque = this.outOfFrameQueue;
        boolean zIsEmpty = arrayDeque.isEmpty();
        arrayDeque.addLast(function0);
        if (zIsEmpty) {
            Handler handler = getHandler();
            if (handler != null) {
                handler.postAtFrontOfQueue(this.outOfFrameRunnable);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("schedule is called when outOfFrameExecutor is not available (view is detached)");
            }
        }
    }

    public final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (layoutNode != null) {
            while (layoutNode != null && layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InMeasureBlock) {
                if (!this.wasMeasuredWithMultipleConstraints) {
                    LayoutNode parent$ui = layoutNode.getParent$ui();
                    if (parent$ui == null) {
                        break;
                    }
                    long j = ((InnerNodeCoordinator) parent$ui.nodes.innerCoordinator).measurementConstraints;
                    if (Constraints.m782getHasFixedWidthimpl(j) && Constraints.m781getHasFixedHeightimpl(j)) {
                        break;
                    }
                }
                layoutNode = layoutNode.getParent$ui();
            }
            if (layoutNode == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    public final long m690screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (this.windowPosition >> 32));
        return androidx.compose.ui.graphics.Matrix.m508mapMKHz9U((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32), this.windowToViewMatrix);
    }

    /* JADX INFO: renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    public final int m691sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        Object obj;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            LazyWindowInfo lazyWindowInfo = getComposeViewContext().windowInfo;
            WindowInfoImpl.GlobalKeyboardModifiers.setValue(new PointerKeyboardModifiers(motionEvent.getMetaState()));
        }
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        EmojiProcessor emojiProcessorConvertToPointerInputEvent$ui = motionEventAdapter.convertToPointerInputEvent$ui(motionEvent, this);
        int actionMasked = motionEvent.getActionMasked();
        Cache.RealCacheRequest realCacheRequest = this.pointerInputEventProcessor;
        if (emojiProcessorConvertToPointerInputEvent$ui == null) {
            if (!realCacheRequest.done) {
                ((LongSparseArray) ((DrawResult) realCacheRequest.body).block).clear();
                ((HitPathTracker) realCacheRequest.cacheOut).processCancel();
            }
            return 0;
        }
        ArrayList arrayList = (ArrayList) emojiProcessorConvertToPointerInputEvent$ui.mSpanFactory;
        int size = arrayList.size() - 1;
        if (size < 0) {
            obj = null;
            break;
        }
        while (true) {
            int i = size - 1;
            obj = arrayList.get(size);
            if (((PointerInputEventData) obj).down && (actionMasked == 0 || actionMasked == 5)) {
                break;
            }
            if (i < 0) {
                obj = null;
                break;
            }
            size = i;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            this.lastDownPointerPosition = pointerInputEventData.position;
        }
        int iM1908processBIzXfog = realCacheRequest.m1908processBIzXfog(emojiProcessorConvertToPointerInputEvent$ui, this, isInBounds(motionEvent, (PointerClassification) emojiProcessorConvertToPointerInputEvent$ui.mGlyphChecker));
        emojiProcessorConvertToPointerInputEvent$ui.mMetadataRepo = null;
        if ((actionMasked != 0 && actionMasked != 5) || (iM1908processBIzXfog & 1) != 0) {
            return iM1908processBIzXfog;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        motionEventAdapter.activeHoverIds.delete(pointerId);
        motionEventAdapter.motionEventToComposePointerIdMap.delete(pointerId);
        return iM1908processBIzXfog;
    }

    public final void sendSimulatedEvent(MotionEvent motionEvent, int i, long j, boolean z) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i != 9 && i != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        int i2 = 0;
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
        }
        int i4 = 1;
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i5 = 0; i5 < pointerCount; i5++) {
            pointerCoordsArr[i5] = new MotionEvent.PointerCoords();
        }
        int i6 = 0;
        while (i6 < pointerCount) {
            int i7 = ((actionIndex < 0 || actionIndex > i6) ? i2 : i4) + i6;
            motionEvent.getPointerProperties(i7, pointerPropertiesArr[i6]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i6];
            motionEvent.getPointerCoords(i7, pointerCoords);
            long jM686localToScreenMKHz9U = m686localToScreenMKHz9U((((long) Float.floatToRawIntBits(pointerCoords.y)) & 4294967295L) | (((long) Float.floatToRawIntBits(pointerCoords.x)) << 32));
            pointerCoords.x = Float.intBitsToFloat((int) (jM686localToScreenMKHz9U >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (jM686localToScreenMKHz9U & 4294967295L));
            i6++;
            i2 = 0;
            i4 = 1;
        }
        int buttonState = z ? 0 : motionEvent.getButtonState();
        long downTime = motionEvent.getDownTime() == motionEvent.getEventTime() ? j : motionEvent.getDownTime();
        MotionEvent motionEventObtainMotionEventWithClassification = Build.VERSION.SDK_INT >= 34 ? Api34Impl.obtainMotionEventWithClassification(downTime, j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), buttonState, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags(), (i == 9 || i == 7 || i == 10 || Build.VERSION.SDK_INT < 29) ? 0 : motionEvent.getClassification()) : MotionEvent.obtain(downTime, j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), buttonState, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        EmojiProcessor emojiProcessorConvertToPointerInputEvent$ui = this.motionEventAdapter.convertToPointerInputEvent$ui(motionEventObtainMotionEventWithClassification, this);
        emojiProcessorConvertToPointerInputEvent$ui.getClass();
        this.pointerInputEventProcessor.m1908processBIzXfog(emojiProcessorConvertToPointerInputEvent$ui, this, true);
        motionEventObtainMotionEventWithClassification.recycle();
    }

    public void setAccessibilityEventBatchIntervalMillis(long j) {
        this.composeAccessibilityDelegate.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    public final void setComposeViewContext(ComposeViewContext composeViewContext) {
        if (getCoroutineContext() != composeViewContext.getCompositionContext$ui().getEffectCoroutineContext() && !((MutableObjectList.ObjectListMutableList) getRoot().getChildren$ui()).isEmpty()) {
            InlineClassHelperKt.throwIllegalArgumentException("Changing ComposeViewContext cannot change the coroutine context without disposing of the composition first.");
        }
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            ComposeViewContext composeViewContext2 = get_composeViewContext();
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            if (composeViewContext != composeViewContext2) {
                if (isAttachedToWindow()) {
                    composeViewContext2.decrementViewCount$ui();
                    composeViewContext.incrementViewCount$ui();
                }
                set_composeViewContext(composeViewContext);
                setCoroutineContext(composeViewContext.getCompositionContext$ui().getEffectCoroutineContext());
            }
        } catch (Throwable th) {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final void setComposeViewContextIncrementedDuringInit$ui(boolean z) {
        this.composeViewContextIncrementedDuringInit = z;
    }

    public final void setConfiguration(Configuration configuration) {
        this.configuration$delegate.setValue(configuration);
    }

    public final void setContentCaptureManager$ui(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    public final void setFrameEndScheduler$ui(LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler) {
        this.frameEndScheduler = frameEndScheduler;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    public final void setOnReadyForComposition(Function1 function1) {
        getDerivedIsAttached();
        if (isAttachedToWindow() || this.composeViewContextIncrementedDuringInit) {
            function1.invoke(getComposeViewContext());
        } else {
            this.onReadyForComposition = function1;
        }
    }

    public final void setPlayNavigationSoundEffect$ui(Function2 function2) {
        this._playNavigationSoundEffect = function2;
    }

    /* JADX INFO: renamed from: setPrimaryDirectionalMotionAxisOverride-r2epLt8$ui, reason: not valid java name */
    public final void m692setPrimaryDirectionalMotionAxisOverrider2epLt8$ui(IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        this.primaryDirectionalMotionAxisOverride = indirectPointerEventPrimaryDirectionalMotionAxis;
    }

    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public void setUncaughtExceptionHandler(RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.measureAndLayoutDelegate.getClass();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final void textInputSession(Function2 function2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AndroidComposeView$$ExternalSyntheticLambda0 androidComposeView$$ExternalSyntheticLambda0 = new AndroidComposeView$$ExternalSyntheticLambda0(this, (byte) 0);
            anonymousClass1.label = 1;
            if (AwaitKt.coroutineScope(new NavHostKt$NavHost$29$1((Object) androidComposeView$$ExternalSyntheticLambda0, (Object) this.textInputSessionMutex, (Object) function2, (Continuation) null, (byte) 3), anonymousClass1) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return;
            }
            ResultKt.throwOnFailure(obj);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
    }

    public final void updateConfiguration(Configuration configuration) {
        Configuration configuration2 = getConfiguration();
        if (Intrinsics.areEqual(configuration2, configuration)) {
            return;
        }
        setConfiguration(new Configuration(configuration));
        if (configuration2.fontScale == configuration.fontScale && configuration2.densityDpi == configuration.densityDpi) {
            return;
        }
        setDensity(MathKt.Density(getContext().createConfigurationContext(configuration)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0056  */
    public final void updatePositionCacheAndDispatch() {
        boolean z;
        int i;
        int[] iArr = this.tmpPositionArray;
        getLocationOnScreen(iArr);
        long j = this.globalPosition;
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        int i4 = iArr[0];
        if (i2 == i4 && i3 == iArr[1] && this.lastMatrixRecalculationAnimationTime >= 0) {
            z = false;
        } else {
            this.globalPosition = (4294967295L & ((long) iArr[1])) | (((long) i4) << 32);
            if (i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE) {
                z = false;
            } else {
                MutableVector mutableVector = getRoot().get_children$ui();
                Object[] objArr = mutableVector.content;
                int i5 = mutableVector.size;
                for (int i6 = 0; i6 < i5; i6++) {
                    ((LayoutNode) objArr[i6]).layoutDelegate.measurePassDelegate.requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
                }
                z = true;
            }
        }
        recalculateWindowPosition();
        View rootView = this._rootView;
        if (rootView == null) {
            rootView = getRootView();
            this._rootView = rootView;
        }
        RectManager rectManager = getRectManager();
        long j2 = this.globalPosition;
        long jM847roundk4lQ0M = SQLite.m847roundk4lQ0M(this.windowPosition);
        int width = rootView.getWidth();
        int height = rootView.getHeight();
        rectManager.getClass();
        float[] fArr = this.viewToWindowMatrix;
        if (fArr.length < 16) {
            i = 0;
        } else {
            i = ((((((((((fArr[0] == 1.0f ? 1 : 0) & (fArr[1] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0)) & (fArr[2] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0)) & (fArr[4] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0)) & (fArr[5] == 1.0f ? 1 : 0)) & (fArr[6] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0)) & (fArr[8] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0)) & (fArr[9] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0)) & (fArr[10] == 1.0f ? 1 : 0)) << 1) | ((fArr[15] == 1.0f ? 1 : 0) & (fArr[12] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0) & (fArr[13] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0) & (fArr[14] == CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 0));
        }
        ThrottledCallbacks throttledCallbacks = rectManager.throttledCallbacks;
        if ((i & 2) != 0) {
            fArr = null;
        }
        rectManager.isScreenOrWindowDirty = throttledCallbacks.m722updateOffsetsLDcG7Xg(j2, jM847roundk4lQ0M, fArr, width, height) || rectManager.isScreenOrWindowDirty;
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
        getRectManager().dispatchCallbacks();
    }

    public final void voteFrameRate(float f) {
        if (isArrEnabled$ui()) {
            if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
                if (Float.isNaN(this.currentFrameRate) || f > this.currentFrameRate) {
                    this.currentFrameRate = f;
                    return;
                }
                return;
            }
            if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                if (Float.isNaN(this.currentFrameRateCategory) || f < this.currentFrameRateCategory) {
                    this.currentFrameRateCategory = f;
                }
            }
        }
    }

    /* JADX INFO: renamed from: getAutofill, reason: merged with bridge method [inline-methods] */
    public AndroidAutofill m693getAutofill() {
        return this.autofill;
    }

    /* JADX INFO: renamed from: getAutofillManager, reason: merged with bridge method [inline-methods] */
    public AndroidAutofillManager m694getAutofillManager() {
        return this.autofillManager;
    }

    /* JADX INFO: renamed from: getDragAndDropManager, reason: merged with bridge method [inline-methods] */
    public AndroidDragAndDropManager m695getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    public MutableIntObjectMap getLayoutNodes() {
        return this.layoutNodes;
    }

    public UiMediaScopeImpl getUiMediaScope() {
        return null;
    }

    public static /* synthetic */ void getAndroidViewsHandler$ui$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui$annotations() {
    }

    public static /* synthetic */ void getPlayNavigationSoundEffect$ui$annotations() {
    }

    /* JADX INFO: renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui$annotations, reason: not valid java name */
    public static /* synthetic */ void m682getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui$annotations() {
    }

    public static /* synthetic */ void getRoot$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    public static /* synthetic */ void getUiMediaScope$annotations() {
    }

    public static /* synthetic */ void getWindowInfo$annotations() {
    }

    public static /* synthetic */ void get_uiMediaScope$ui$annotations() {
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        addView(view, -1);
    }

    public RootForTest getRootForTest() {
        return this;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = i;
        layoutParamsGenerateDefaultLayoutParams.height = i2;
        addViewInLayout(view, -1, layoutParamsGenerateDefaultLayoutParams, true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i, layoutParams, true);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, -1, layoutParams, true);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RootModifierNode extends Modifier.Node implements BringIntoViewModifierNode, SemanticsModifierNode, KeyInputModifierNode, LayoutModifierNode, TraversableNode {
        public final TextKt$$ExternalSyntheticLambda2 rulerLambda;

        public RootModifierNode() {
            new Updater$$ExternalSyntheticLambda0(this);
            new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 25, this);
            this.rulerLambda = new TextKt$$ExternalSyntheticLambda2((byte) 27, this);
        }

        @Override // androidx.compose.ui.relocation.BringIntoViewModifierNode
        public final Object bringIntoView(NodeCoordinator nodeCoordinator, ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2, ContinuationImpl continuationImpl) {
            long jMo606localToRootMKHz9U = nodeCoordinator.mo606localToRootMKHz9U(0L);
            Rect rect = (Rect) componentRegistry$Builder$$ExternalSyntheticLambda2.invoke();
            Rect rectM446translatek4lQ0M = rect != null ? rect.m446translatek4lQ0M(jMo606localToRootMKHz9U) : null;
            if (rectM446translatek4lQ0M != null) {
                AndroidComposeView.this.requestRectangleOnScreen(new android.graphics.Rect((int) rectM446translatek4lQ0M.left, (int) rectM446translatek4lQ0M.top, (int) rectM446translatek4lQ0M.right, (int) rectM446translatek4lQ0M.bottom), false);
            }
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.ui.node.TraversableNode
        public final Object getTraverseKey() {
            return "androidx.compose.ui.layout.WindowInsetsRulers";
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
            return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, this.rulerLambda, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 22));
        }

        @Override // androidx.compose.ui.input.key.KeyInputModifierNode
        /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
        public final boolean mo26onKeyEventZmokQxo(KeyEvent keyEvent) {
            FocusDirection focusDirection;
            int[] iArr = FocusInteropUtils_androidKt.tempCoordinates;
            long jM580getKeyZmokQxo = Key.m580getKeyZmokQxo(keyEvent);
            if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 1116691496960L)) {
                focusDirection = new FocusDirection(2);
            } else if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 1120986464256L)) {
                focusDirection = new FocusDirection(1);
            } else if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 261993005056L)) {
                focusDirection = new FocusDirection(keyEvent.isShiftPressed() ? 2 : 1);
            } else if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 94489280512L)) {
                focusDirection = new FocusDirection(4);
            } else if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 90194313216L)) {
                focusDirection = new FocusDirection(3);
            } else if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 81604378624L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 395136991232L)) {
                focusDirection = new FocusDirection(5);
            } else if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 85899345920L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 399431958528L)) {
                focusDirection = new FocusDirection(6);
            } else if (Key.m579equalsimpl0(jM580getKeyZmokQxo, 98784247808L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 283467841536L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 687194767360L)) {
                focusDirection = new FocusDirection(7);
            } else {
                focusDirection = (Key.m579equalsimpl0(jM580getKeyZmokQxo, 17179869184L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 476741369856L)) ? new FocusDirection(8) : null;
            }
            if (focusDirection != null) {
                int i = focusDirection.value;
                if (Key.m581getTypeZmokQxo(keyEvent) == 2) {
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    FocusTargetNode activeFocusTargetNode = ((FocusOwnerImpl) androidComposeView.getFocusOwner()).getActiveFocusTargetNode();
                    if (activeFocusTargetNode != null && activeFocusTargetNode.isInteropViewHost && androidComposeView.m688moveFocusInChildren3ESFkO8(i)) {
                        androidComposeView.getPlayNavigationSoundEffect$ui().invoke(focusDirection, Boolean.valueOf(keyEvent.getRepeatCount() > 0));
                        return true;
                    }
                    Boolean boolM411focusSearchULY8qGw = ((FocusOwnerImpl) androidComposeView.getFocusOwner()).m411focusSearchULY8qGw(i, androidComposeView.getEmbeddedViewFocusRect(), new TextKt$$ExternalSyntheticLambda2((byte) 26, focusDirection));
                    if (boolM411focusSearchULY8qGw == null) {
                        return true;
                    }
                    if (boolM411focusSearchULY8qGw.booleanValue()) {
                        androidComposeView.getPlayNavigationSoundEffect$ui().invoke(focusDirection, Boolean.valueOf(keyEvent.getRepeatCount() > 0));
                        return true;
                    }
                    if (i != 1 && i != 2) {
                        return false;
                    }
                    Integer numM408toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m408toAndroidFocusDirection3ESFkO8(i);
                    int iIntValue = numM408toAndroidFocusDirection3ESFkO8 != null ? numM408toAndroidFocusDirection3ESFkO8.intValue() : 2;
                    FocusFinder focusFinder = FocusFinder.getInstance();
                    View rootView = androidComposeView.getRootView();
                    rootView.getClass();
                    View viewFindNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, androidComposeView.getView(), iIntValue);
                    if (viewFindNextFocus == null || viewFindNextFocus.equals(androidComposeView)) {
                        return ((FocusOwnerImpl) androidComposeView.getFocusOwner()).m413resetFocus3ESFkO8(i);
                    }
                }
            }
            return false;
        }

        @Override // androidx.compose.ui.input.key.KeyInputModifierNode
        /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
        public final boolean mo28onPreKeyEventZmokQxo(KeyEvent keyEvent) {
            return false;
        }

        @Override // androidx.compose.ui.node.SemanticsModifierNode
        public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    public final void setUncaughtExceptionHandler$ui(RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler) {
    }

    public final void set_uiMediaScope$ui(UiMediaScopeImpl uiMediaScopeImpl) {
    }

    public final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        int i = Build.VERSION.SDK_INT;
        float[] fArr = this.viewToWindowMatrix;
        int[] iArr = this.tmpPositionArray;
        if (i >= 29) {
            Api29Impl.m703calculateMatrixToWindowV2T6pWw(this, fArr, this.tmpAndroidMatrix, iArr);
        } else {
            Api21Impl.m701calculateMatrixToWindowqGEkDyk(this, fArr, this.tmpMatrix, iArr);
        }
        InvertMatrixKt.m709invertToJiSxe2E(fArr, this.windowToViewMatrix);
        float x = motionEvent.getX();
        long jM508mapMKHz9U = androidx.compose.ui.graphics.Matrix.m508mapMKHz9U((((long) Float.floatToRawIntBits(motionEvent.getY())) & 4294967295L) | (Float.floatToRawIntBits(x) << 32), fArr);
        this.windowPosition = (((long) Float.floatToRawIntBits(motionEvent.getRawX() - Float.intBitsToFloat((int) (jM508mapMKHz9U >> 32)))) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getRawY() - Float.intBitsToFloat((int) (jM508mapMKHz9U & 4294967295L)))) & 4294967295L);
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, android.graphics.Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z || hasFocus()) {
            return;
        }
        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) getFocusOwner();
        FocusTraversalKt.prepareToClearFocus(focusOwnerImpl.rootFocusNode, true);
        if (focusOwnerImpl.getActiveFocusTargetNode() != null) {
            FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
            focusOwnerImpl.setActiveFocusTargetNode(null);
            if (activeFocusTargetNode != null) {
                activeFocusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
            }
        }
    }
}
