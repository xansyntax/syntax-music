package androidx.compose.ui.platform;

import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaCodec;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsetsAnimation;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridMeasureResult;
import androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridState$prefetchScope$2$1;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.CachedItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillApi27Helper;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DepthSortedSetKt$DepthComparator$1;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.core.graphics.Insets;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.UnprecomputeTextOnModificationSpannable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.AtomicFile$AtomicFileOutputStream;
import androidx.media3.common.util.ColorParser;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.ResolvingDataSource;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.scheduler.PlatformScheduler$PlatformSchedulerService;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.video.DefaultVideoSink;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.webvtt.WebvttCssParser;
import androidx.media3.extractor.text.webvtt.WebvttCssStyle;
import androidx.media3.extractor.text.webvtt.WebvttCueInfo;
import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import androidx.media3.extractor.text.webvtt.WebvttParserUtil;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.ExoDownloadService;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WeakCache implements ActionMode.Callback, CacheWindowScope, OperationErrorContext, SubcomposeLayoutState.PausedPrecomposition, EmojiProcessor.EmojiProcessCallback, DataSource.Factory, SubtitleParser {
    public final /* synthetic */ byte $r8$classId;
    public Object referenceQueue;
    public Object values;

    public WeakCache(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 4:
                TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
                Float fValueOf = Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO);
                this.referenceQueue = new AnimationState(twoWayConverterImpl, fValueOf, (AnimationVector) twoWayConverterImpl.convertToVector.invoke(fValueOf), Long.MIN_VALUE, Long.MIN_VALUE, false);
                break;
            case 6:
                this.values = new MutableScatterMap();
                this.referenceQueue = new MutableScatterMap();
                break;
            case 11:
                this.values = new MutableVector(new LayoutNode[16]);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                this.values = new Lock((byte) 9);
                this.referenceQueue = new LruCache(16);
                break;
            case 24:
                this.values = new HashSet();
                break;
            case 28:
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                this.values = byteArrayOutputStream;
                this.referenceQueue = new DataOutputStream(byteArrayOutputStream);
                break;
            case 29:
                this.values = new ParsableByteArray();
                this.referenceQueue = new WebvttCssParser();
                break;
            default:
                this.values = new MutableVector(new Reference[16]);
                this.referenceQueue = new ReferenceQueue();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static void dispatchHierarchy(LayoutNode layoutNode) {
        if (layoutNode.globallyPositionedObservers > 0) {
            if (layoutNode.layoutDelegate.layoutState == LayoutNode.LayoutState.Idle && !layoutNode.getLayoutPending$ui() && !layoutNode.getMeasurePending$ui() && !layoutNode.isDeactivated && layoutNode.isPlaced()) {
                Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
                if ((node.aggregateChildKindSet & 256) != 0) {
                    while (node != null) {
                        if ((node.kindSet & 256) != 0) {
                            ?? Pop = node;
                            ?? mutableVector = 0;
                            while (Pop != 0) {
                                if (Pop instanceof GlobalPositionAwareModifierNode) {
                                    GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) Pop;
                                    globalPositionAwareModifierNode.onGloballyPositioned(HitTestResultKt.m646requireCoordinator64DMado(globalPositionAwareModifierNode, 256));
                                } else if ((Pop.kindSet & 256) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                                    int i = 0;
                                    Pop = Pop;
                                    mutableVector = mutableVector;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 256) != 0) {
                                            i++;
                                            if (i == 1) {
                                                mutableVector = mutableVector;
                                                Pop = node2;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(node2);
                                            }
                                        }
                                        node2 = node2.child;
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Pop = HitTestResultKt.pop(mutableVector);
                            }
                        }
                        if ((node.aggregateChildKindSet & 256) == 0) {
                            break;
                        } else {
                            node = node.child;
                        }
                    }
                }
            }
            layoutNode.needsOnGloballyPositionedDispatch = false;
            MutableVector mutableVector2 = layoutNode.get_children$ui();
            Object[] objArr = mutableVector2.content;
            int i2 = mutableVector2.size;
            for (int i3 = 0; i3 < i2; i3++) {
                dispatchHierarchy((LayoutNode) objArr[i3]);
            }
        }
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
        return ((LayoutNodeSubcompositionsState) this.values).createPrecomposedSlotHandle(this.referenceQueue);
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public List buildStackTrace(Integer num) {
        List listBuildStackTrace = ((OperationErrorContext) this.values).buildStackTrace(null);
        SlotWriter slotWriter = (SlotWriter) this.referenceQueue;
        int i = slotWriter.parent;
        return i < 0 ? listBuildStackTrace : CollectionsKt.plus((Iterable) listBuildStackTrace, (Collection) UtilsKt.buildTrace(slotWriter, num, i, Integer.valueOf(slotWriter.parent(i, slotWriter.groups))));
    }

    public void clear() {
        this.values = null;
        this.referenceQueue = null;
    }

    @Override // androidx.media3.datasource.DataSource.Factory
    public DataSource createDataSource() {
        switch (this.$r8$classId) {
            case 19:
                return new DefaultDataSource((Context) this.values, ((DataSource.Factory) this.referenceQueue).createDataSource());
            default:
                return new ResolvingDataSource(((CacheDataSource.Factory) this.values).createDataSource(), (ResolvingDataSource.Resolver) this.referenceQueue);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatch() {
        Object[] objArr;
        MutableVector mutableVector = (MutableVector) this.values;
        Arrays.sort(mutableVector.content, 0, mutableVector.size, DepthSortedSetKt$DepthComparator$1.INSTANCE);
        int i = mutableVector.size;
        LayoutNode[] layoutNodeArr = (LayoutNode[]) this.referenceQueue;
        if (layoutNodeArr == null || layoutNodeArr.length < i) {
            objArr = layoutNodeArr;
            objArr = new LayoutNode[Math.max(16, i)];
        }
        objArr = layoutNodeArr;
        this.referenceQueue = null;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = mutableVector.content[i2];
        }
        mutableVector.clear();
        while (true) {
            i--;
            if (-1 >= i) {
                this.referenceQueue = objArr;
                return;
            }
            LayoutNode layoutNode = objArr[i];
            layoutNode.getClass();
            if (layoutNode.needsOnGloballyPositionedDispatch) {
                dispatchHierarchy(layoutNode);
            }
            objArr[i] = 0;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public Density getDensity() {
        return getLayoutInfo().density;
    }

    public Extractor getExtractor(Object... objArr) {
        Constructor constructor;
        synchronized (((AtomicBoolean) this.referenceQueue)) {
            if (!((AtomicBoolean) this.referenceQueue).get()) {
                try {
                    constructor = ((FrameworkMediaDrm$$ExternalSyntheticLambda0) this.values).getConstructor();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.referenceQueue).set(true);
                    constructor = null;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (Extractor) constructor.newInstance(objArr);
        } catch (Exception e2) {
            throw new IllegalStateException("Unexpected error creating extractor", e2);
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getFirstVisibleItemIndex() {
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.first(getLayoutInfo().visibleItemsInfo);
        return getLayoutInfo().orientation == Orientation.Vertical ? lazyGridMeasuredItem.row : lazyGridMeasuredItem.column;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public boolean getHasVisibleItems() {
        return !getLayoutInfo().visibleItemsInfo.isEmpty();
    }

    public InputMethodManager getImm() {
        return (InputMethodManager) ((Lazy) this.referenceQueue).getValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastItemIndex() {
        LazyGridMeasureResult layoutInfo = getLayoutInfo();
        if (getLayoutInfo().totalItemsCount == 0) {
            return -1;
        }
        return ((Number) layoutInfo.lineIndexProvider.invoke(Integer.valueOf(getLayoutInfo().totalItemsCount - 1))).intValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastVisibleItemIndex() {
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.last(getLayoutInfo().visibleItemsInfo);
        return getLayoutInfo().orientation == Orientation.Vertical ? lazyGridMeasuredItem.row : lazyGridMeasuredItem.column;
    }

    public LazyGridMeasureResult getLayoutInfo() {
        LazyGridMeasureResult lazyGridMeasureResult = (LazyGridMeasureResult) this.values;
        if (lazyGridMeasureResult != null) {
            return lazyGridMeasureResult;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        throw null;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisViewportSize() {
        LazyGridMeasureResult layoutInfo = getLayoutInfo();
        return (int) (layoutInfo.orientation == Orientation.Vertical ? layoutInfo.m168getViewportSizeYbymL2g() & 4294967295L : layoutInfo.m168getViewportSizeYbymL2g() >> 32);
    }

    public MeasurePolicy getMeasurePolicyState() {
        return (MeasurePolicy) ((ParcelableSnapshotMutableState) this.referenceQueue).getValue();
    }

    public AutofillManager getPlatformAndroidManager() {
        AutofillManager autofillManager = (AutofillManager) this.referenceQueue;
        if (autofillManager != null) {
            return autofillManager;
        }
        AutofillManager autofillManager2 = (AutofillManager) ((Context) this.values).getSystemService(AutofillManager.class);
        if (autofillManager2 != null) {
            this.referenceQueue = autofillManager2;
            return autofillManager2;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Could not locate AutofillManager from context");
        return null;
    }

    @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
    public Object getResult() {
        return (UnprecomputeTextOnModificationSpannable) this.values;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public boolean getSourceInformationEnabled() {
        return ((OperationErrorContext) this.values).getSourceInformationEnabled();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getTotalItemsCount() {
        return getLayoutInfo().totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemIndex(int i) {
        return getFirstVisibleItemIndex() + i;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public Object getVisibleItemKey(int i) {
        int firstVisibleItemIndex = getFirstVisibleItemIndex() + i;
        List list = getLayoutInfo().visibleItemsInfo;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) obj;
            if ((getLayoutInfo().orientation == Orientation.Vertical ? lazyGridMeasuredItem.row : lazyGridMeasuredItem.column) == firstVisibleItemIndex) {
                arrayList.add(obj);
            }
        }
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) CollectionsKt.firstOrNull((List) arrayList);
        return lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.key : CachedItem.NoKey;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemSize(int i) {
        int firstVisibleItemIndex = getFirstVisibleItemIndex() + i;
        List list = getLayoutInfo().visibleItemsInfo;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) obj;
            if ((getLayoutInfo().orientation == Orientation.Vertical ? lazyGridMeasuredItem.row : lazyGridMeasuredItem.column) == firstVisibleItemIndex) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size2; i3++) {
            iMax = Math.max(LifecyclesKt.sizeOnMainAxis((LazyGridMeasuredItem) arrayList.get(i3), getLayoutInfo().orientation), iMax);
        }
        return iMax;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemsCount() {
        return (getLastVisibleItemIndex() - getFirstVisibleItemIndex()) + 1;
    }

    @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 4) > 0) {
            return true;
        }
        if (((UnprecomputeTextOnModificationSpannable) this.values) == null) {
            this.values = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((Lock) this.referenceQueue).getClass();
        ((UnprecomputeTextOnModificationSpannable) this.values).setSpan(new TypefaceEmojiSpan(typefaceEmojiRasterizer), i, i2, 33);
        return true;
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean isComplete() {
        return true;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int lastItemIndexInLine(int i) {
        List list = (List) getLayoutInfo().prefetchInfoRetriever.invoke(Integer.valueOf(i));
        if (list.isEmpty()) {
            return -1;
        }
        return (list.size() + ((Number) ((Pair) CollectionsKt.first(list)).first).intValue()) - 1;
    }

    public void notifyViewVisibilityChanged(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 27) {
            AutofillApi27Helper.notifyViewVisibilityChanged(view, getPlatformAndroidManager(), i, z);
        }
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return ((ActionMode.Callback) this.values).onActionItemClicked(actionMode, menuItem);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
        return ((ActionMode.Callback) this.values).onCreateActionMode(actionMode, menuBuilder);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        ((ActionMode.Callback) this.values).onDestroyActionMode(actionMode);
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) this.referenceQueue;
        if (appCompatDelegateImpl.mActionModePopup != null) {
            appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(appCompatDelegateImpl.mShowActionModePopup);
        }
        if (appCompatDelegateImpl.mActionModeView != null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
            viewPropertyAnimatorCompatAnimate.alpha(CropImageView.DEFAULT_ASPECT_RATIO);
            appCompatDelegateImpl.mFadeAnim = viewPropertyAnimatorCompatAnimate;
            viewPropertyAnimatorCompatAnimate.setListener(new AppCompatDelegateImpl.AnonymousClass5((byte) 2, this));
        }
        appCompatDelegateImpl.mAppCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl.mActionMode);
        appCompatDelegateImpl.mActionMode = null;
        ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        viewGroup.requestApplyInsets();
        appCompatDelegateImpl.updateBackInvokedCallbackState();
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        ViewGroup viewGroup = ((AppCompatDelegateImpl) this.referenceQueue).mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        viewGroup.requestApplyInsets();
        return ((ActionMode.Callback) this.values).onPrepareActionMode(actionMode, menu);
    }

    public void onProvisionError(Exception exc, boolean z) {
        this.referenceQueue = null;
        HashSet hashSet = (HashSet) this.values;
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) hashSet);
        hashSet.clear();
        ImmutableList.Itr itrListIterator = immutableListCopyOf.listIterator(0);
        while (itrListIterator.hasNext()) {
            DefaultDrmSession defaultDrmSession = (DefaultDrmSession) itrListIterator.next();
            defaultDrmSession.getClass();
            defaultDrmSession.onError(exc, z ? 1 : 3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x022f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0250  */
    /* JADX WARN: Code duplicated, block: B:131:0x025b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0264  */
    /* JADX WARN: Code duplicated, block: B:134:0x026e  */
    /* JADX WARN: Code duplicated, block: B:136:0x0276  */
    /* JADX WARN: Code duplicated, block: B:138:0x027e  */
    /* JADX WARN: Code duplicated, block: B:139:0x0282  */
    /* JADX WARN: Code duplicated, block: B:141:0x028b  */
    /* JADX WARN: Code duplicated, block: B:142:0x0292  */
    /* JADX WARN: Code duplicated, block: B:144:0x029b  */
    /* JADX WARN: Code duplicated, block: B:150:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:152:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:154:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:156:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:157:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:159:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:160:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:162:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:164:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:165:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:167:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:169:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:171:0x0303  */
    /* JADX WARN: Code duplicated, block: B:173:0x030b  */
    /* JADX WARN: Code duplicated, block: B:175:0x031b  */
    /* JADX WARN: Code duplicated, block: B:176:0x0335  */
    /* JADX WARN: Code duplicated, block: B:179:0x0346  */
    /* JADX WARN: Code duplicated, block: B:182:0x034f  */
    /* JADX WARN: Code duplicated, block: B:183:0x0351  */
    /* JADX WARN: Code duplicated, block: B:186:0x035a  */
    /* JADX WARN: Code duplicated, block: B:187:0x035c  */
    /* JADX WARN: Code duplicated, block: B:190:0x0365  */
    /* JADX WARN: Code duplicated, block: B:194:0x036d  */
    /* JADX WARN: Code duplicated, block: B:195:0x0372  */
    /* JADX WARN: Code duplicated, block: B:196:0x0377  */
    /* JADX WARN: Code duplicated, block: B:198:0x038a  */
    /* JADX WARN: Code duplicated, block: B:239:0x0369 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00af  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:175:0x031b, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v25 */
    @Override // androidx.media3.extractor.text.SubtitleParser
    public void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        WebvttCueInfo cue;
        String strTrim;
        int i3;
        String string;
        int i4;
        Matcher matcher;
        String strGroup;
        byte b;
        boolean z;
        WeakCache weakCache = this;
        ParsableByteArray parsableByteArray = (ParsableByteArray) weakCache.values;
        parsableByteArray.reset(bArr, i + i2);
        parsableByteArray.setPosition(i);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
            while (!TextUtils.isEmpty(parsableByteArray.readLine(StandardCharsets.UTF_8))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                boolean z2 = false;
                int i5 = -1;
                int i6 = 0;
                byte b2 = -1;
                while (true) {
                    int i7 = 1;
                    if (b2 == -1) {
                        i6 = parsableByteArray.position;
                        String line = parsableByteArray.readLine(StandardCharsets.UTF_8);
                        if (line == null) {
                            b2 = 0;
                        } else if ("STYLE".equals(line)) {
                            b2 = 2;
                        } else {
                            b2 = line.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                        }
                    } else {
                        parsableByteArray.setPosition(i6);
                        if (b2 == 0) {
                            DatabaseDao_Impl.AnonymousClass17.toCuesWithTiming(new EmojiProcessor(arrayList2), outputOptions, consumer);
                            return;
                        }
                        if (b2 == 1) {
                            while (!TextUtils.isEmpty(parsableByteArray.readLine(StandardCharsets.UTF_8))) {
                            }
                        } else {
                            String str = null;
                            if (b2 == 2) {
                                if (!arrayList2.isEmpty()) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("A style block was found after the first cue.");
                                    return;
                                }
                                parsableByteArray.readLine(StandardCharsets.UTF_8);
                                WebvttCssParser webvttCssParser = (WebvttCssParser) weakCache.referenceQueue;
                                ParsableByteArray parsableByteArray2 = webvttCssParser.styleInput;
                                StringBuilder sb = webvttCssParser.stringBuilder;
                                sb.setLength(0);
                                int i8 = parsableByteArray.position;
                                while (!TextUtils.isEmpty(parsableByteArray.readLine(StandardCharsets.UTF_8))) {
                                }
                                parsableByteArray2.reset(parsableByteArray.data, parsableByteArray.position);
                                parsableByteArray2.setPosition(i8);
                                ArrayList arrayList3 = new ArrayList();
                                while (true) {
                                    WebvttCssParser.skipWhitespaceAndComments(parsableByteArray2);
                                    if (parsableByteArray2.bytesLeft() >= 5 && "::cue".equals(parsableByteArray2.readString(5, StandardCharsets.UTF_8))) {
                                        int i9 = parsableByteArray2.position;
                                        String nextToken = WebvttCssParser.parseNextToken(parsableByteArray2, sb);
                                        if (nextToken == null) {
                                            strTrim = str;
                                        } else if ("{".equals(nextToken)) {
                                            parsableByteArray2.setPosition(i9);
                                            strTrim = "";
                                        } else {
                                            if ("(".equals(nextToken)) {
                                                int i10 = parsableByteArray2.position;
                                                int i11 = parsableByteArray2.limit;
                                                int i12 = z2 ? 1 : 0;
                                                while (i10 < i11 && i12 == 0) {
                                                    int i13 = i10 + 1;
                                                    i12 = ((char) parsableByteArray2.data[i10]) == ')' ? i7 : z2 ? 1 : 0;
                                                    i10 = i13;
                                                }
                                                strTrim = parsableByteArray2.readString((i10 - 1) - parsableByteArray2.position, StandardCharsets.UTF_8).trim();
                                            } else {
                                                strTrim = str;
                                            }
                                            if (!")".equals(WebvttCssParser.parseNextToken(parsableByteArray2, sb))) {
                                                strTrim = str;
                                            }
                                        }
                                    } else {
                                        strTrim = str;
                                    }
                                    if (strTrim != null && "{".equals(WebvttCssParser.parseNextToken(parsableByteArray2, sb))) {
                                        WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
                                        webvttCssStyle.targetId = "";
                                        webvttCssStyle.targetTag = "";
                                        webvttCssStyle.targetClasses = Collections.EMPTY_SET;
                                        webvttCssStyle.targetVoice = "";
                                        webvttCssStyle.fontFamily = str;
                                        webvttCssStyle.hasFontColor = z2;
                                        webvttCssStyle.hasBackgroundColor = z2;
                                        webvttCssStyle.linethrough = i5;
                                        webvttCssStyle.underline = i5;
                                        webvttCssStyle.bold = i5;
                                        webvttCssStyle.italic = i5;
                                        webvttCssStyle.fontSizeUnit = i5;
                                        webvttCssStyle.rubyPosition = i5;
                                        webvttCssStyle.combineUpright = z2;
                                        if (!strTrim.isEmpty()) {
                                            int iIndexOf = strTrim.indexOf(91);
                                            if (iIndexOf != i5) {
                                                Matcher matcher2 = WebvttCssParser.VOICE_NAME_PATTERN.matcher(strTrim.substring(iIndexOf));
                                                if (matcher2.matches()) {
                                                    String strGroup2 = matcher2.group(i7);
                                                    strGroup2.getClass();
                                                    webvttCssStyle.targetVoice = strGroup2;
                                                }
                                                strTrim = strTrim.substring(z2 ? 1 : 0, iIndexOf);
                                            }
                                            String str2 = Util.DEVICE_DEBUG_INFO;
                                            String[] strArrSplit = strTrim.split("\\.", i5);
                                            String str3 = strArrSplit[z2 ? 1 : 0];
                                            int iIndexOf2 = str3.indexOf(35);
                                            if (iIndexOf2 != i5) {
                                                webvttCssStyle.targetTag = str3.substring(z2 ? 1 : 0, iIndexOf2);
                                                webvttCssStyle.targetId = str3.substring(iIndexOf2 + 1);
                                            } else {
                                                webvttCssStyle.targetTag = str3;
                                            }
                                            if (strArrSplit.length > i7) {
                                                int length = strArrSplit.length;
                                                UtilsKt.checkArgument(length <= strArrSplit.length ? i7 : z2 ? 1 : 0);
                                                webvttCssStyle.targetClasses = new HashSet(Arrays.asList((String[]) Arrays.copyOfRange(strArrSplit, i7, length)));
                                            }
                                        }
                                        ?? r8 = z2 ? 1 : 0;
                                        String nextToken2 = str;
                                        while (r8 == 0) {
                                            int i14 = parsableByteArray2.position;
                                            nextToken2 = WebvttCssParser.parseNextToken(parsableByteArray2, sb);
                                            ?? r15 = (nextToken2 == null || "}".equals(nextToken2)) ? i7 : z2;
                                            if (r15 == 0) {
                                                parsableByteArray2.setPosition(i14);
                                                WebvttCssParser.skipWhitespaceAndComments(parsableByteArray2);
                                                String identifier = WebvttCssParser.parseIdentifier(parsableByteArray2, sb);
                                                if (!identifier.isEmpty() && ServerSentEventKt.COLON.equals(WebvttCssParser.parseNextToken(parsableByteArray2, sb))) {
                                                    WebvttCssParser.skipWhitespaceAndComments(parsableByteArray2);
                                                    StringBuilder sb2 = new StringBuilder();
                                                    boolean z3 = false;
                                                    while (true) {
                                                        if (z3) {
                                                            string = sb2.toString();
                                                        } else {
                                                            int i15 = parsableByteArray2.position;
                                                            String nextToken3 = WebvttCssParser.parseNextToken(parsableByteArray2, sb);
                                                            if (nextToken3 == null) {
                                                                string = null;
                                                            } else if ("}".equals(nextToken3) || ";".equals(nextToken3)) {
                                                                parsableByteArray2.setPosition(i15);
                                                                z3 = true;
                                                            } else {
                                                                sb2.append(nextToken3);
                                                            }
                                                        }
                                                    }
                                                    if (string == null || string.isEmpty()) {
                                                        i3 = 1;
                                                    } else {
                                                        int i16 = parsableByteArray2.position;
                                                        String nextToken4 = WebvttCssParser.parseNextToken(parsableByteArray2, sb);
                                                        if (";".equals(nextToken4)) {
                                                            if ("color".equals(identifier)) {
                                                                i4 = 1;
                                                                webvttCssStyle.fontColor = ColorParser.parseColorInternal(string, true);
                                                                webvttCssStyle.hasFontColor = true;
                                                            } else {
                                                                i4 = 1;
                                                                if ("background-color".equals(identifier)) {
                                                                    webvttCssStyle.backgroundColor = ColorParser.parseColorInternal(string, true);
                                                                    webvttCssStyle.hasBackgroundColor = true;
                                                                } else if ("ruby-position".equals(identifier)) {
                                                                    if ("text-combine-upright".equals(identifier)) {
                                                                        if ("all".equals(string)) {
                                                                            z = true;
                                                                        } else {
                                                                            z = true;
                                                                        }
                                                                        webvttCssStyle.combineUpright = z;
                                                                    } else if ("text-decoration".equals(identifier)) {
                                                                        if ("underline".equals(string)) {
                                                                            i4 = 1;
                                                                            webvttCssStyle.underline = 1;
                                                                        }
                                                                    } else if ("font-family".equals(identifier)) {
                                                                        webvttCssStyle.fontFamily = LifecyclesKt.toLowerCase(string);
                                                                    } else if ("font-weight".equals(identifier)) {
                                                                        i4 = 1;
                                                                        if ("font-style".equals(identifier)) {
                                                                            if ("italic".equals(string)) {
                                                                                webvttCssStyle.italic = 1;
                                                                            }
                                                                        } else if ("font-size".equals(identifier)) {
                                                                            matcher = WebvttCssParser.FONT_SIZE_PATTERN.matcher(LifecyclesKt.toLowerCase(string));
                                                                            if (matcher.matches()) {
                                                                                strGroup = matcher.group(2);
                                                                                strGroup.getClass();
                                                                                switch (strGroup.hashCode()) {
                                                                                    case 37:
                                                                                        if (!strGroup.equals("%")) {
                                                                                            b = 0;
                                                                                        }
                                                                                        switch (b) {
                                                                                            case 0:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 3;
                                                                                                break;
                                                                                            case 1:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 2;
                                                                                                break;
                                                                                            case 2:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 1;
                                                                                                break;
                                                                                            default:
                                                                                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                                return;
                                                                                        }
                                                                                        String strGroup3 = matcher.group(i3);
                                                                                        strGroup3.getClass();
                                                                                        webvttCssStyle.fontSize = Float.parseFloat(strGroup3);
                                                                                        break;
                                                                                    case 3240:
                                                                                        if (!strGroup.equals("em")) {
                                                                                            b = 1;
                                                                                        }
                                                                                        switch (b) {
                                                                                            case 0:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 3;
                                                                                                break;
                                                                                            case 1:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 2;
                                                                                                break;
                                                                                            case 2:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 1;
                                                                                                break;
                                                                                            default:
                                                                                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                                return;
                                                                                        }
                                                                                        String strGroup4 = matcher.group(i3);
                                                                                        strGroup4.getClass();
                                                                                        webvttCssStyle.fontSize = Float.parseFloat(strGroup4);
                                                                                        break;
                                                                                    case 3592:
                                                                                        if (!strGroup.equals("px")) {
                                                                                            b = 2;
                                                                                        }
                                                                                        switch (b) {
                                                                                            case 0:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 3;
                                                                                                break;
                                                                                            case 1:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 2;
                                                                                                break;
                                                                                            case 2:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 1;
                                                                                                break;
                                                                                            default:
                                                                                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                                return;
                                                                                        }
                                                                                        String strGroup5 = matcher.group(i3);
                                                                                        strGroup5.getClass();
                                                                                        webvttCssStyle.fontSize = Float.parseFloat(strGroup5);
                                                                                        break;
                                                                                }
                                                                                b = -1;
                                                                                switch (b) {
                                                                                    case 0:
                                                                                        i3 = 1;
                                                                                        webvttCssStyle.fontSizeUnit = 3;
                                                                                        break;
                                                                                    case 1:
                                                                                        i3 = 1;
                                                                                        webvttCssStyle.fontSizeUnit = 2;
                                                                                        break;
                                                                                    case 2:
                                                                                        i3 = 1;
                                                                                        webvttCssStyle.fontSizeUnit = 1;
                                                                                        break;
                                                                                    default:
                                                                                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                        return;
                                                                                }
                                                                                String strGroup6 = matcher.group(i3);
                                                                                strGroup6.getClass();
                                                                                webvttCssStyle.fontSize = Float.parseFloat(strGroup6);
                                                                            } else {
                                                                                Log.w("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                                                            }
                                                                        }
                                                                    } else if ("bold".equals(string)) {
                                                                        i4 = 1;
                                                                        webvttCssStyle.bold = 1;
                                                                    }
                                                                    i3 = 1;
                                                                } else if ("over".equals(string)) {
                                                                    webvttCssStyle.rubyPosition = 1;
                                                                } else if ("under".equals(string)) {
                                                                    webvttCssStyle.rubyPosition = 2;
                                                                    i3 = 1;
                                                                } else {
                                                                    i3 = 1;
                                                                }
                                                            }
                                                            i3 = i4;
                                                        } else if ("}".equals(nextToken4)) {
                                                            parsableByteArray2.setPosition(i16);
                                                            if ("color".equals(identifier)) {
                                                                i4 = 1;
                                                                webvttCssStyle.fontColor = ColorParser.parseColorInternal(string, true);
                                                                webvttCssStyle.hasFontColor = true;
                                                            } else {
                                                                i4 = 1;
                                                                if ("background-color".equals(identifier)) {
                                                                    webvttCssStyle.backgroundColor = ColorParser.parseColorInternal(string, true);
                                                                    webvttCssStyle.hasBackgroundColor = true;
                                                                } else if ("ruby-position".equals(identifier)) {
                                                                    if ("text-combine-upright".equals(identifier)) {
                                                                        if ("all".equals(string) || string.startsWith("digits")) {
                                                                            z = true;
                                                                        } else {
                                                                            z = false;
                                                                        }
                                                                        webvttCssStyle.combineUpright = z;
                                                                    } else if ("text-decoration".equals(identifier)) {
                                                                        if ("underline".equals(string)) {
                                                                            i4 = 1;
                                                                            webvttCssStyle.underline = 1;
                                                                        }
                                                                    } else if ("font-family".equals(identifier)) {
                                                                        webvttCssStyle.fontFamily = LifecyclesKt.toLowerCase(string);
                                                                    } else if ("font-weight".equals(identifier)) {
                                                                        i4 = 1;
                                                                        if ("font-style".equals(identifier)) {
                                                                            if ("italic".equals(string)) {
                                                                                webvttCssStyle.italic = 1;
                                                                            }
                                                                        } else if ("font-size".equals(identifier)) {
                                                                            matcher = WebvttCssParser.FONT_SIZE_PATTERN.matcher(LifecyclesKt.toLowerCase(string));
                                                                            if (matcher.matches()) {
                                                                                Log.w("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                                                            } else {
                                                                                strGroup = matcher.group(2);
                                                                                strGroup.getClass();
                                                                                switch (strGroup.hashCode()) {
                                                                                    case 37:
                                                                                        if (!strGroup.equals("%")) {
                                                                                            b = 0;
                                                                                        }
                                                                                        switch (b) {
                                                                                            case 0:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 3;
                                                                                                break;
                                                                                            case 1:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 2;
                                                                                                break;
                                                                                            case 2:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 1;
                                                                                                break;
                                                                                            default:
                                                                                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                                return;
                                                                                        }
                                                                                        String strGroup7 = matcher.group(i3);
                                                                                        strGroup7.getClass();
                                                                                        webvttCssStyle.fontSize = Float.parseFloat(strGroup7);
                                                                                        break;
                                                                                    case 3240:
                                                                                        if (!strGroup.equals("em")) {
                                                                                            b = 1;
                                                                                        }
                                                                                        switch (b) {
                                                                                            case 0:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 3;
                                                                                                break;
                                                                                            case 1:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 2;
                                                                                                break;
                                                                                            case 2:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 1;
                                                                                                break;
                                                                                            default:
                                                                                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                                return;
                                                                                        }
                                                                                        String strGroup8 = matcher.group(i3);
                                                                                        strGroup8.getClass();
                                                                                        webvttCssStyle.fontSize = Float.parseFloat(strGroup8);
                                                                                        break;
                                                                                    case 3592:
                                                                                        if (!strGroup.equals("px")) {
                                                                                            b = 2;
                                                                                        }
                                                                                        switch (b) {
                                                                                            case 0:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 3;
                                                                                                break;
                                                                                            case 1:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 2;
                                                                                                break;
                                                                                            case 2:
                                                                                                i3 = 1;
                                                                                                webvttCssStyle.fontSizeUnit = 1;
                                                                                                break;
                                                                                            default:
                                                                                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                                return;
                                                                                        }
                                                                                        String strGroup9 = matcher.group(i3);
                                                                                        strGroup9.getClass();
                                                                                        webvttCssStyle.fontSize = Float.parseFloat(strGroup9);
                                                                                        break;
                                                                                }
                                                                                b = -1;
                                                                                switch (b) {
                                                                                    case 0:
                                                                                        i3 = 1;
                                                                                        webvttCssStyle.fontSizeUnit = 3;
                                                                                        break;
                                                                                    case 1:
                                                                                        i3 = 1;
                                                                                        webvttCssStyle.fontSizeUnit = 2;
                                                                                        break;
                                                                                    case 2:
                                                                                        i3 = 1;
                                                                                        webvttCssStyle.fontSizeUnit = 1;
                                                                                        break;
                                                                                    default:
                                                                                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                                                        return;
                                                                                }
                                                                                String strGroup10 = matcher.group(i3);
                                                                                strGroup10.getClass();
                                                                                webvttCssStyle.fontSize = Float.parseFloat(strGroup10);
                                                                            }
                                                                        }
                                                                    } else if ("bold".equals(string)) {
                                                                        i4 = 1;
                                                                        webvttCssStyle.bold = 1;
                                                                    }
                                                                    i3 = 1;
                                                                } else if ("over".equals(string)) {
                                                                    webvttCssStyle.rubyPosition = 1;
                                                                } else if ("under".equals(string)) {
                                                                    webvttCssStyle.rubyPosition = 2;
                                                                    i3 = 1;
                                                                } else {
                                                                    i3 = 1;
                                                                }
                                                            }
                                                            i3 = i4;
                                                        } else {
                                                            i3 = 1;
                                                        }
                                                    }
                                                } else {
                                                    i3 = i7;
                                                }
                                            } else {
                                                i3 = i7;
                                            }
                                            i7 = i3;
                                            r8 = r15;
                                            z2 = false;
                                        }
                                        int i17 = i7;
                                        if ("}".equals(nextToken2)) {
                                            arrayList3.add(webvttCssStyle);
                                        }
                                        i7 = i17;
                                        z2 = false;
                                        i5 = -1;
                                        str = null;
                                    }
                                }
                                arrayList.addAll(arrayList3);
                            } else if (b2 == 3) {
                                Pattern pattern = WebvttCueParser.CUE_HEADER_PATTERN;
                                Charset charset = StandardCharsets.UTF_8;
                                String line2 = parsableByteArray.readLine(charset);
                                if (line2 == null) {
                                    cue = null;
                                } else {
                                    Pattern pattern2 = WebvttCueParser.CUE_HEADER_PATTERN;
                                    Matcher matcher3 = pattern2.matcher(line2);
                                    if (matcher3.matches()) {
                                        cue = WebvttCueParser.parseCue(null, matcher3, parsableByteArray, arrayList);
                                    } else {
                                        cue = null;
                                        String line3 = parsableByteArray.readLine(charset);
                                        if (line3 != null) {
                                            Matcher matcher4 = pattern2.matcher(line3);
                                            if (matcher4.matches()) {
                                                cue = WebvttCueParser.parseCue(line2.trim(), matcher4, parsableByteArray, arrayList);
                                            }
                                        }
                                    }
                                }
                                if (cue != null) {
                                    arrayList2.add(cue);
                                }
                            }
                            weakCache = this;
                        }
                    }
                }
            }
        } catch (ParserException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void provisionRequired(DefaultDrmSession defaultDrmSession) {
        ((HashSet) this.values).add(defaultDrmSession);
        if (((DefaultDrmSession) this.referenceQueue) != null) {
            return;
        }
        this.referenceQueue = defaultDrmSession;
        ExoMediaDrm.ProvisionRequest provisionRequest = defaultDrmSession.mediaDrm.getProvisionRequest();
        defaultDrmSession.currentProvisionRequest = provisionRequest;
        DefaultDrmSession.RequestHandler requestHandler = defaultDrmSession.requestHandler;
        String str = Util.DEVICE_DEBUG_INFO;
        provisionRequest.getClass();
        requestHandler.getClass();
        requestHandler.obtainMessage(1, new DefaultDrmSession.RequestTask(LoadEventInfo.idSource.getAndIncrement(), true, SystemClock.elapsedRealtime(), provisionRequest)).sendToTarget();
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean resume(TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10) {
        return true;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public List schedulePrefetch(int i, Function1 function1) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandleM177schedulePrecompositionAndPremeasure_EkL_Y$foundation;
        LazyGridState$prefetchScope$2$1 lazyGridState$prefetchScope$2$1 = (LazyGridState$prefetchScope$2$1) this.referenceQueue;
        if (lazyGridState$prefetchScope$2$1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefetchScope");
            throw null;
        }
        CodecsKt$$ExternalSyntheticLambda0 codecsKt$$ExternalSyntheticLambda0 = new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 8);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LazyGridState lazyGridState = lazyGridState$prefetchScope$2$1.this$0;
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            boolean z = lazyGridState.hasLookaheadOccurred;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyGridState.layoutInfoState;
            LazyGridMeasureResult lazyGridMeasureResult = z ? lazyGridState.approachLayoutInfo : (LazyGridMeasureResult) parcelableSnapshotMutableState.getValue();
            if (lazyGridMeasureResult != null) {
                Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = 1;
                List list = (List) lazyGridMeasureResult.prefetchInfoRetriever.invoke(Integer.valueOf(i));
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    Pair pair = (Pair) list.get(i2);
                    Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        int i3 = size;
                        LazyLayoutPrefetchState lazyLayoutPrefetchState = ((LazyGridMeasureResult) parcelableSnapshotMutableState.getValue()).prefetchState;
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState == null ? null : lazyLayoutPrefetchState;
                        if (lazyLayoutPrefetchState2 != null) {
                            int iIntValue = ((Number) pair.first).intValue();
                            long j = ((Constraints) pair.second).value;
                            CallbackWrapper callbackWrapper = LazyGridState.Saver;
                            prefetchHandleM177schedulePrecompositionAndPremeasure_EkL_Y$foundation = lazyLayoutPrefetchState2.m177schedulePrecompositionAndPremeasure_EkL_Y$foundation(iIntValue, j, false, new AlbumMenuKt$$ExternalSyntheticLambda40(arrayList2, ref$IntRef, list, codecsKt$$ExternalSyntheticLambda0, i, lazyGridMeasureResult));
                        } else {
                            prefetchHandleM177schedulePrecompositionAndPremeasure_EkL_Y$foundation = null;
                        }
                        if (prefetchHandleM177schedulePrecompositionAndPremeasure_EkL_Y$foundation != null) {
                            arrayList.add(prefetchHandleM177schedulePrecompositionAndPremeasure_EkL_Y$foundation);
                        }
                        i2++;
                        size = i3;
                    } catch (Throwable th) {
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th;
                    }
                }
            }
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            return arrayList;
        } catch (Throwable th2) {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.media3.common.util.AtomicFile$AtomicFileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.media3.common.util.AtomicFile$AtomicFileOutputStream] */
    public AtomicFile$AtomicFileOutputStream startWrite() throws IOException {
        File file = (File) this.referenceQueue;
        final File file2 = (File) this.values;
        if (file2.exists()) {
            if (file.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file)) {
                Log.w("AtomicFile", "Couldn't rename file " + file2 + " to backup file " + file);
            }
        }
        try {
            return new OutputStream(file2) { // from class: androidx.media3.common.util.AtomicFile$AtomicFileOutputStream
                public boolean closed = false;
                public final FileOutputStream fileOutputStream;

                {
                    this.fileOutputStream = new FileOutputStream(file2);
                }

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() throws IOException {
                    FileOutputStream fileOutputStream = this.fileOutputStream;
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    flush();
                    try {
                        fileOutputStream.getFD().sync();
                    } catch (IOException e) {
                        Log.w("AtomicFile", "Failed to sync file descriptor:", e);
                    }
                    fileOutputStream.close();
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public final void flush() throws IOException {
                    this.fileOutputStream.flush();
                }

                @Override // java.io.OutputStream
                public final void write(int i) throws IOException {
                    this.fileOutputStream.write(i);
                }

                @Override // java.io.OutputStream
                public final void write(byte[] bArr) throws IOException {
                    this.fileOutputStream.write(bArr);
                }

                @Override // java.io.OutputStream
                public final void write(byte[] bArr, int i, int i2) throws IOException {
                    this.fileOutputStream.write(bArr, i, i2);
                }
            };
        } catch (FileNotFoundException e) {
            File parentFile = file2.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + file2, e);
            }
            try {
                return new OutputStream(file2) { // from class: androidx.media3.common.util.AtomicFile$AtomicFileOutputStream
                    public boolean closed = false;
                    public final FileOutputStream fileOutputStream;

                    {
                        this.fileOutputStream = new FileOutputStream(file2);
                    }

                    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                    public final void close() throws IOException {
                        FileOutputStream fileOutputStream = this.fileOutputStream;
                        if (this.closed) {
                            return;
                        }
                        this.closed = true;
                        flush();
                        try {
                            fileOutputStream.getFD().sync();
                        } catch (IOException e2) {
                            Log.w("AtomicFile", "Failed to sync file descriptor:", e2);
                        }
                        fileOutputStream.close();
                    }

                    @Override // java.io.OutputStream, java.io.Flushable
                    public final void flush() throws IOException {
                        this.fileOutputStream.flush();
                    }

                    @Override // java.io.OutputStream
                    public final void write(int i) throws IOException {
                        this.fileOutputStream.write(i);
                    }

                    @Override // java.io.OutputStream
                    public final void write(byte[] bArr) throws IOException {
                        this.fileOutputStream.write(bArr);
                    }

                    @Override // java.io.OutputStream
                    public final void write(byte[] bArr, int i, int i2) throws IOException {
                        this.fileOutputStream.write(bArr, i, i2);
                    }
                };
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + file2, e2);
            }
        }
    }

    public void stop$foundation() {
        StandaloneCoroutine standaloneCoroutine = (StandaloneCoroutine) this.values;
        AnimationVector animationVector = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.referenceQueue = new AnimationState(ArcSplineKt.FloatToVector, Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO), animationVector, 60);
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 14:
                return "Bounds{lower=" + ((Insets) this.values) + " upper=" + ((Insets) this.referenceQueue) + "}";
            default:
                return super.toString();
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneFirstVisibleItemIndex(int[] iArr) {
        iArr[0] = getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneLastVisibleItemIndexes(int[] iArr) {
        iArr[0] = getLastVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneMainAxisExtraEndSpace(int[] iArr) {
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.last(getLayoutInfo().visibleItemsInfo);
        iArr[0] = Math.abs(((LifecyclesKt.sizeOnMainAxis(lazyGridMeasuredItem, getLayoutInfo().orientation) + LifecyclesKt.offsetOnMainAxis(lazyGridMeasuredItem, getLayoutInfo().orientation)) + getLayoutInfo().mainAxisItemSpacing) - getLayoutInfo().viewportEndOffset);
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public void updatePerLaneMainAxisExtraStartSpace(int[] iArr) {
        int iOffsetOnMainAxis = LifecyclesKt.offsetOnMainAxis((LazyGridMeasuredItem) CollectionsKt.first(getLayoutInfo().visibleItemsInfo), getLayoutInfo().orientation) + (-getLayoutInfo().viewportStartOffset);
        if (iOffsetOnMainAxis > 0) {
            iOffsetOnMainAxis = 0;
        }
        iArr[0] = Math.abs(iOffsetOnMainAxis);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateScrollDeltaForApproach$foundation(float f, Density density, CoroutineScope coroutineScope) {
        if (f <= density.mo81toPx0680j_4(1.0f)) {
            return;
        }
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Continuation continuation = null;
        Object[] objArr = 0;
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            float fFloatValue = ((Number) ((AnimationState) this.referenceQueue).value$delegate.getValue()).floatValue();
            StandaloneCoroutine standaloneCoroutine = (StandaloneCoroutine) this.values;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            AnimationState animationState = (AnimationState) this.referenceQueue;
            if (animationState.isRunning) {
                this.referenceQueue = ArcSplineKt.copy$default(animationState, fFloatValue - f, CropImageView.DEFAULT_ASPECT_RATIO, 30);
            } else {
                this.referenceQueue = new AnimationState(ArcSplineKt.FloatToVector, Float.valueOf(-f), objArr == true ? 1 : 0, 60);
            }
            this.values = AwaitKt.launch$default(coroutineScope, null, null, new SyncUtils.AnonymousClass2(this, continuation, (byte) 6), 3);
        } finally {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public void updateWifiLock(boolean z, boolean z2) {
        Context context = (Context) this.values;
        boolean z3 = false;
        if (z && ((WifiManager.WifiLock) this.referenceQueue) == null) {
            if (context.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                Log.w("WifiLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                return;
            }
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                Log.w("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.referenceQueue = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        WifiManager.WifiLock wifiLock = (WifiManager.WifiLock) this.referenceQueue;
        if (wifiLock == null) {
            return;
        }
        if (z && z2) {
            z3 = true;
        }
        if (z3) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public void cancel() {
    }

    public /* synthetic */ WeakCache(Context context, byte b) {
        this.$r8$classId = b;
        this.values = context;
    }

    public /* synthetic */ WeakCache(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.values = obj;
        this.referenceQueue = obj2;
    }

    public /* synthetic */ WeakCache(byte b, boolean z) {
        this.$r8$classId = b;
    }

    public WeakCache(LayoutNode layoutNode, MeasurePolicy measurePolicy) {
        this.$r8$classId = (byte) 10;
        this.values = layoutNode;
        this.referenceQueue = Stack.mutableStateOf$default(measurePolicy);
    }

    public WeakCache(File file) {
        this.$r8$classId = (byte) 16;
        this.values = file;
        this.referenceQueue = new File(file.getPath() + ".bak");
    }

    public WeakCache(View view) {
        this.$r8$classId = (byte) 1;
        this.values = view;
        this.referenceQueue = ResultKt.lazy(LazyThreadSafetyMode.NONE, new SliderState$$ExternalSyntheticLambda0((byte) 21, this));
    }

    public WeakCache(ExoDownloadService exoDownloadService) {
        this.$r8$classId = (byte) 25;
        Context applicationContext = exoDownloadService.getApplicationContext();
        this.values = new ComponentName(applicationContext, (Class<?>) PlatformScheduler$PlatformSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) applicationContext.getSystemService("jobscheduler");
        jobScheduler.getClass();
        this.referenceQueue = jobScheduler;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WeakCache(Context context) {
        this(context, new AtomicInt((byte) 17));
        this.$r8$classId = (byte) 19;
    }

    public WeakCache(Context context, DataSource.Factory factory) {
        this.$r8$classId = (byte) 19;
        this.values = context.getApplicationContext();
        this.referenceQueue = factory;
    }

    public WeakCache(MediaCodec.CryptoInfo cryptoInfo) {
        this.$r8$classId = (byte) 21;
        this.values = cryptoInfo;
        this.referenceQueue = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public WeakCache(ArrayList arrayList, ArrayList arrayList2) {
        this.$r8$classId = (byte) 13;
        int size = arrayList.size();
        this.values = new int[size];
        this.referenceQueue = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.values)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.referenceQueue)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public WeakCache(WindowInsetsAnimation.Bounds bounds) {
        this.$r8$classId = (byte) 14;
        this.values = WindowInsetsAnimationCompat.Impl30.getLowerBounds(bounds);
        this.referenceQueue = WindowInsetsAnimationCompat.Impl30.getHigherBounds(bounds);
    }

    public WeakCache(int i, int i2) {
        this.$r8$classId = (byte) 13;
        this.values = new int[]{i, i2};
        this.referenceQueue = new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f};
    }

    public WeakCache(int i, int i2, int i3) {
        this.$r8$classId = (byte) 13;
        this.values = new int[]{i, i2, i3};
        this.referenceQueue = new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, 1.0f};
    }

    public WeakCache(DefaultVideoSink defaultVideoSink) {
        this.$r8$classId = (byte) 26;
        this.referenceQueue = defaultVideoSink;
    }

    public WeakCache(RegularImmutableList regularImmutableList, int[] iArr) {
        this.$r8$classId = (byte) 18;
        this.values = ImmutableList.copyOf((Collection) regularImmutableList);
        this.referenceQueue = iArr;
    }

    public WeakCache(FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0) {
        this.$r8$classId = (byte) 27;
        this.values = frameworkMediaDrm$$ExternalSyntheticLambda0;
        this.referenceQueue = new AtomicBoolean(false);
    }

    public WeakCache(AppCompatDelegateImpl appCompatDelegateImpl, ActionMode.Callback callback) {
        this.$r8$classId = (byte) 2;
        this.referenceQueue = appCompatDelegateImpl;
        this.values = callback;
    }
}
