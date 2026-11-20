package androidx.compose.ui.draw;

import android.graphics.Region;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.LongSparseArray;
import androidx.collection.MutableLongList;
import androidx.collection.MutableScatterSet;
import androidx.compose.animation.AndroidFlingSpline;
import androidx.compose.animation.FlingCalculator;
import androidx.compose.animation.FlingCalculatorKt;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.Animations;
import androidx.compose.animation.core.ArcSpline$Arc;
import androidx.compose.animation.core.DefaultSpringAnimations;
import androidx.compose.animation.core.FloatAnimationSpec;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.animation.core.FloatSpringSpec;
import androidx.compose.animation.core.VectorizedAnimationSpecKt;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.input.pointer.InternalPointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputChangeEventProducer$PointerInputData;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SortedSet;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.PlatformTypefacesApi28;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DrawResult implements MenuItemHoverListener, MenuPresenter.Callback, MenuBuilder.Callback, AppCompatTextView.SuperCaller, FloatDecayAnimationSpec, Animations, VectorizedFiniteAnimationSpec, LazyLayoutCacheWindow, RetainedValuesStore {
    public final /* synthetic */ byte $r8$classId;
    public Object block;

    /* JADX WARN: Code duplicated, block: B:14:0x002a A[PHI: r10
      0x002a: PHI (r10v1 int) = (r10v0 int), (r10v3 int), (r10v4 int) binds: [B:5:0x001a, B:10:0x0023, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    public DrawResult(int[] iArr, float[] fArr, float[][] fArr2) {
        int i;
        this.$r8$classId = (byte) 8;
        int i2 = 1;
        int length = fArr.length - 1;
        ArcSpline$Arc[][] arcSpline$ArcArr = new ArcSpline$Arc[length][];
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i5 < length) {
            int i6 = iArr[i5];
            int i7 = 3;
            if (i6 == 0) {
                i = i7;
            } else if (i6 == i2) {
                i3 = i2;
                i = i3;
            } else {
                if (i6 != 2) {
                    if (i6 != 3) {
                        i7 = 4;
                        if (i6 != 4) {
                            i7 = 5;
                            if (i6 != 5) {
                                i = i4;
                            } else {
                                i = i7;
                            }
                        } else {
                            i = i7;
                        }
                    } else {
                        if (i3 != i2) {
                            i3 = i2;
                        }
                        i = i3;
                    }
                }
                i3 = 2;
                i = i3;
            }
            float[] fArr3 = fArr2[i5];
            int i8 = i5 + 1;
            float[] fArr4 = fArr2[i8];
            float f = fArr[i5];
            float f2 = fArr[i8];
            int length2 = (fArr3.length % 2) + (fArr3.length / 2);
            ArcSpline$Arc[] arcSpline$ArcArr2 = new ArcSpline$Arc[length2];
            int i9 = 0;
            while (i9 < length2) {
                int i10 = i9 * 2;
                int i11 = i9;
                int i12 = i10 + 1;
                arcSpline$ArcArr2[i11] = new ArcSpline$Arc(i, f, f2, fArr3[i10], fArr3[i12], fArr4[i10], fArr4[i12]);
                i9 = i11 + 1;
            }
            arcSpline$ArcArr[i5] = arcSpline$ArcArr2;
            i5 = i8;
            i4 = i;
            i2 = 1;
        }
        this.block = arcSpline$ArcArr;
    }

    /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    public static void m400clipRectN_I0leg$default(DrawResult drawResult, float f, float f2, int i) {
        EmojiProcessor emojiProcessor = (EmojiProcessor) drawResult.block;
        if ((i & 4) != 0) {
            f = Float.intBitsToFloat((int) (emojiProcessor.m831getSizeNHjbRc() >> 32));
        }
        float f3 = f;
        if ((i & 8) != 0) {
            f2 = Float.intBitsToFloat((int) (emojiProcessor.m831getSizeNHjbRc() & 4294967295L));
        }
        drawResult.m401clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f3, f2, 1);
    }

    public void add(LayoutNode layoutNode) {
        if (!layoutNode.isAttached$1()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.add called on an unattached node");
        }
        ((SortedSet) this.block).add(layoutNode);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public int calculateAheadWindow(Density density, int i) {
        return ((PagerState) this.block).latestPageSizeWithSpacing;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public int calculateBehindWindow(Density density, int i) {
        return 0;
    }

    /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void m401clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        ((EmojiProcessor) this.block).getCanvas().mo453clipRectN_I0leg(f, f2, f3, f4, i);
    }

    public void current() {
        ((CompositionContext) this.block).getClass();
    }

    @Override // androidx.compose.animation.core.Animations
    public FloatAnimationSpec get(int i) {
        switch (this.$r8$classId) {
            case 9:
                return ((FloatSpringSpec[]) this.block)[i];
            case 10:
                return (FloatSpringSpec) this.block;
            default:
                return (FloatAnimationSpec) this.block;
        }
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float f) {
        return ((long) (Math.exp(((FlingCalculator) this.block).getSplineDeceleration(f) / (((double) FlingCalculatorKt.DecelerationRate) - 1.0d)) * 1000.0d)) * 1000000;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((Dispatcher) this.block).getEndVelocity(animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float f, float f2) {
        FlingCalculator flingCalculator = (FlingCalculator) this.block;
        double splineDeceleration = flingCalculator.getSplineDeceleration(f2);
        double d = FlingCalculatorKt.DecelerationRate;
        return (Math.signum(f2) * ((float) (Math.exp((d / (d - 1.0d)) * splineDeceleration) * ((double) (flingCalculator.friction * flingCalculator.magicPhysicalCoefficient))))) + f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(float f, float f2, long j) {
        long j2 = j / 1000000;
        FlingCalculator.FlingInfo flingInfo = ((FlingCalculator) this.block).flingInfo(f2);
        long j3 = flingInfo.duration;
        return (Math.signum(flingInfo.initialVelocity) * flingInfo.distance * AndroidFlingSpline.flingPosition(j3 > 0 ? j2 / j3 : 1.0f).distanceCoefficient) + f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long j, float f) {
        long j2 = j / 1000000;
        FlingCalculator.FlingInfo flingInfo = ((FlingCalculator) this.block).flingInfo(f);
        long j3 = flingInfo.duration;
        return (((Math.signum(flingInfo.initialVelocity) * AndroidFlingSpline.flingPosition(j3 > 0 ? j2 / j3 : 1.0f).velocityCoefficient) * flingInfo.distance) / j3) * 1000.0f;
    }

    public void inset(float f, float f2, float f3, float f4) {
        EmojiProcessor emojiProcessor = (EmojiProcessor) this.block;
        Canvas canvas = emojiProcessor.getCanvas();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (emojiProcessor.m831getSizeNHjbRc() >> 32)) - (f3 + f);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (emojiProcessor.m831getSizeNHjbRc() & 4294967295L)) - (f4 + f2))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        if (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) < CropImageView.DEFAULT_ASPECT_RATIO || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) < CropImageView.DEFAULT_ASPECT_RATIO) {
            androidx.compose.ui.graphics.InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
        }
        emojiProcessor.m832setSizeuvyYCjk(jFloatToRawIntBits);
        canvas.translate(f, f2);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return false;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public boolean isNonScrollCachingEnabled() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder instanceof SubMenuBuilder) {
            ((SubMenuBuilder) menuBuilder).mParentMenu.getRootMenu().close(false);
        }
        MenuPresenter.Callback callback = ((ActionMenuPresenter) this.block).mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.block;
        Handler handler = cascadingMenuPopup.mSubMenuHoverHandler;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i)).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        handler.postAtTime(new CascadingMenuPopup$3$1(this, i2 < arrayList.size() ? (CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i2) : null, menuItemImpl, menuBuilder, (byte) 0), menuBuilder, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        ((CascadingMenuPopup) this.block).mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        boolean zOnMenuItemSelected;
        ActionMenuView.OnMenuItemClickListener onMenuItemClickListener = ((ActionMenuView) this.block).mOnMenuItemClickListener;
        if (onMenuItemClickListener != null) {
            Toolbar toolbar = Toolbar.this;
            if (toolbar.mMenuHostHelper.onMenuItemSelected(menuItem)) {
                zOnMenuItemSelected = true;
            } else {
                Toolbar.OnMenuItemClickListener onMenuItemClickListener2 = toolbar.mOnMenuItemClickListener;
                zOnMenuItemSelected = onMenuItemClickListener2 != null ? ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, menuItem) : false;
            }
            if (zOnMenuItemSelected) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        MenuBuilder.Callback callback = ((ActionMenuView) this.block).mMenuBuilderCallback;
        if (callback != null) {
            callback.onMenuModeChange(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        ActionMenuPresenter actionMenuPresenter = (ActionMenuPresenter) this.block;
        if (menuBuilder == actionMenuPresenter.mMenu) {
            return false;
        }
        MenuItemImpl menuItemImpl = ((SubMenuBuilder) menuBuilder).mItem;
        MenuPresenter.Callback callback = actionMenuPresenter.mCallback;
        if (callback != null) {
            return callback.onOpenSubMenu(menuBuilder);
        }
        return false;
    }

    public InternalPointerEvent produce(AndroidComposeView androidComposeView, EmojiProcessor emojiProcessor) {
        long j;
        boolean z;
        long jM690screenToLocalMKHz9U;
        LongSparseArray longSparseArray = (LongSparseArray) this.block;
        ArrayList arrayList = (ArrayList) emojiProcessor.mSpanFactory;
        LongSparseArray longSparseArray2 = new LongSparseArray(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PointerInputEventData pointerInputEventData = (PointerInputEventData) arrayList.get(i);
            long j2 = pointerInputEventData.id;
            PointerInputChangeEventProducer$PointerInputData pointerInputChangeEventProducer$PointerInputData = (PointerInputChangeEventProducer$PointerInputData) longSparseArray.get(j2);
            if (pointerInputChangeEventProducer$PointerInputData == null) {
                j = pointerInputEventData.uptime;
                jM690screenToLocalMKHz9U = pointerInputEventData.position;
                z = false;
            } else {
                long j3 = pointerInputChangeEventProducer$PointerInputData.uptime;
                j = j3;
                z = pointerInputChangeEventProducer$PointerInputData.down;
                jM690screenToLocalMKHz9U = androidComposeView.m690screenToLocalMKHz9U(pointerInputChangeEventProducer$PointerInputData.positionOnScreen);
            }
            long j4 = pointerInputEventData.id;
            int i2 = i;
            ArrayList arrayList2 = arrayList;
            int i3 = size;
            longSparseArray2.put(j4, new PointerInputChange(j4, pointerInputEventData.uptime, pointerInputEventData.position, pointerInputEventData.down, pointerInputEventData.pressure, j, jM690screenToLocalMKHz9U, z, pointerInputEventData.type, pointerInputEventData.historical, pointerInputEventData.scrollDelta, pointerInputEventData.scaleGestureFactor, pointerInputEventData.panGestureOffset, pointerInputEventData.originalEventPosition));
            boolean z2 = pointerInputEventData.down;
            if (z2) {
                longSparseArray.put(j2, new PointerInputChangeEventProducer$PointerInputData(pointerInputEventData.uptime, pointerInputEventData.positionOnScreen, z2));
            } else {
                longSparseArray.remove(j2);
            }
            i = i2 + 1;
            arrayList = arrayList2;
            size = i3;
        }
        return new InternalPointerEvent(longSparseArray2, emojiProcessor);
    }

    public boolean remove(LayoutNode layoutNode) {
        if (!layoutNode.isAttached$1()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.remove called on an unattached node");
        }
        return ((SortedSet) this.block).remove(layoutNode);
    }

    /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
    public void m402rotateUv8p0NA(long j, float f) {
        Canvas canvas = ((EmojiProcessor) this.block).getCanvas();
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
        canvas.rotate(f);
        canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0096 A[LOOP:0: B:22:0x0051->B:34:0x0096, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x0099 A[EDGE_INSN: B:53:0x0099->B:35:0x0099 BREAK  A[LOOP:0: B:22:0x0051->B:34:0x0096], SYNTHETIC] */
    public Object runAndWatch$runtime(Channel channel, Function0 function0) {
        SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager;
        SendChannel sendChannel;
        if (((TagPayloadReader) this.block) == null) {
            PreconditionsKt.throwIllegalStateException("Called runAndWatch on a manager that has been disposed of");
        }
        TagPayloadReader tagPayloadReader = (TagPayloadReader) this.block;
        if ((tagPayloadReader instanceof SingleSubscriptionSnapshotFlowManager) && (sendChannel = (singleSubscriptionSnapshotFlowManager = (SingleSubscriptionSnapshotFlowManager) tagPayloadReader).subscribedChannel) != null && !sendChannel.equals(channel)) {
            MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager = new MultiSubscriptionSnapshotFlowManager();
            SendChannel sendChannel2 = singleSubscriptionSnapshotFlowManager.subscribedChannel;
            if (sendChannel2 == null) {
                PreconditionsKt.throwIllegalStateException("promote must only be called when a manager is managing subscriptions for one channel and needs to start managing them for a second");
            }
            MutableScatterSet mutableScatterSet = singleSubscriptionSnapshotFlowManager.watchSet;
            ArrayList arrayList = multiSubscriptionSnapshotFlowManager.pendingChanges;
            if (mutableScatterSet != null) {
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i != length) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i2 = 8;
                            int i3 = 8 - ((~(i - length)) >>> 31);
                            int i4 = 0;
                            while (i4 < i3) {
                                if ((j & 255) < 128) {
                                    arrayList.add(new MultiSubscriptionSnapshotFlowManager.Add(objArr[(i << 3) + i4], sendChannel2));
                                }
                                j >>= i2;
                                i4++;
                                i2 = i2;
                            }
                            if (i3 != i2) {
                                break;
                            }
                            if (i != length) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            } else {
                Object obj = singleSubscriptionSnapshotFlowManager.soleWatchedObject;
                obj.getClass();
                arrayList.add(new MultiSubscriptionSnapshotFlowManager.Add(obj, sendChannel2));
            }
            multiSubscriptionSnapshotFlowManager.commitSubscriptionChanges$runtime();
            singleSubscriptionSnapshotFlowManager.dispose$runtime();
            this.block = multiSubscriptionSnapshotFlowManager;
        }
        TagPayloadReader tagPayloadReader2 = (TagPayloadReader) this.block;
        tagPayloadReader2.getClass();
        Snapshot snapshotTakeNestedSnapshot = SnapshotKt.currentSnapshot().takeNestedSnapshot(tagPayloadReader2.readObserverFor$runtime(channel));
        tagPayloadReader2.clearWatchSet$runtime(channel);
        try {
            Snapshot snapshotMakeCurrent = snapshotTakeNestedSnapshot.makeCurrent();
            try {
                Object objInvoke = function0.invoke();
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                snapshotTakeNestedSnapshot.dispose();
                tagPayloadReader2.commitSubscriptionChanges$runtime();
                return objInvoke;
            } catch (Throwable th) {
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            snapshotTakeNestedSnapshot.dispose();
            throw th2;
        }
    }

    /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
    public void m403scale0AR0LA0(float f, float f2, long j) {
        Canvas canvas = ((EmojiProcessor) this.block).getCanvas();
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
        canvas.scale(f, f2);
        canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
    }

    public void set(IntRect intRect) {
        ((Region) this.block).set(intRect.left, intRect.top, intRect.right, intRect.bottom);
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 25:
                return ((SortedSet) this.block).toString();
            default:
                return super.toString();
        }
    }

    public void translate(float f, float f2) {
        ((EmojiProcessor) this.block).getCanvas().translate(f, f2);
    }

    public void setFirstBaselineToTopHeight(int i) {
    }

    public void setLastBaselineToBottomHeight(int i) {
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((Dispatcher) this.block).getDurationNanos(animationVector, animationVector2, animationVector3);
    }

    public void setLineHeight(int i, float f) {
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((Dispatcher) this.block).getValueFromNanos(j, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((Dispatcher) this.block).getVelocityFromNanos(j, animationVector, animationVector2, animationVector3);
    }

    public DrawResult(float f, float f2, AnimationVector animationVector) {
        Animations drawResult;
        this.$r8$classId = (byte) 12;
        int[] iArr = VectorizedAnimationSpecKt.EmptyIntArray;
        if (animationVector == null && f == 1.0f && f2 == 1500.0f) {
            drawResult = DefaultSpringAnimations.INSTANCE;
        } else if (animationVector != null) {
            drawResult = new DrawResult(animationVector, f, f2);
        } else {
            drawResult = new DrawResult(f, f2);
        }
        this.block = new Dispatcher(drawResult);
    }

    public DrawResult(Density density) {
        this.$r8$classId = (byte) 7;
        this.block = new FlingCalculator(SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction, density);
    }

    public /* synthetic */ DrawResult(byte b, Object obj) {
        this.$r8$classId = b;
        this.block = obj;
    }

    public DrawResult(long[] jArr) {
        MutableLongList mutableLongList;
        this.$r8$classId = (byte) 21;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            mutableLongList = new MutableLongList(jArrCopyOf.length);
            int i = mutableLongList._size;
            if (i >= 0) {
                if (jArrCopyOf.length != 0) {
                    int length = jArrCopyOf.length + i;
                    long[] jArrCopyOf2 = mutableLongList.content;
                    if (jArrCopyOf2.length < length) {
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, Math.max(length, (jArrCopyOf2.length * 3) / 2));
                        mutableLongList.content = jArrCopyOf2;
                    }
                    int i2 = mutableLongList._size;
                    if (i != i2) {
                        ArraysKt.copyInto(jArrCopyOf2, jArrCopyOf2, jArrCopyOf.length + i, i, i2);
                    }
                    ArraysKt.copyInto(jArrCopyOf, jArrCopyOf2, i, 0, jArrCopyOf.length);
                    mutableLongList._size += jArrCopyOf.length;
                }
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("");
                throw null;
            }
        } else {
            mutableLongList = new MutableLongList(16);
        }
        this.block = mutableLongList;
    }

    public DrawResult(byte b) {
        Object fontVariation;
        this.$r8$classId = b;
        switch (b) {
            case 25:
                this.block = new SortedSet(HitTestResultKt.DepthComparator);
                break;
            case 26:
                ManagedRetainedValuesStore managedRetainedValuesStore = new ManagedRetainedValuesStore();
                this.block = managedRetainedValuesStore;
                if (!managedRetainedValuesStore.isDisposed) {
                    if (managedRetainedValuesStore.isContentComposed) {
                        androidx.compose.runtime.retain.impl.PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                    }
                    managedRetainedValuesStore.purgeUnusedExitedValues();
                    managedRetainedValuesStore.isContentComposed = true;
                    break;
                }
                break;
            case 27:
            default:
                this.block = new LongSparseArray();
                break;
            case 28:
                this.block = new Region();
                break;
            case 29:
                if (Build.VERSION.SDK_INT >= 28) {
                    fontVariation = new PlatformTypefacesApi28();
                } else {
                    fontVariation = new FontVariation();
                }
                this.block = fontVariation;
                break;
        }
    }

    public DrawResult(AnimationVector animationVector, float f, float f2) {
        this.$r8$classId = (byte) 9;
        int size$animation_core = animationVector.getSize$animation_core();
        FloatSpringSpec[] floatSpringSpecArr = new FloatSpringSpec[size$animation_core];
        for (int i = 0; i < size$animation_core; i++) {
            floatSpringSpecArr[i] = new FloatSpringSpec(f, f2, animationVector.get$animation_core(i));
        }
        this.block = floatSpringSpecArr;
    }

    public DrawResult(float f, float f2) {
        this.$r8$classId = (byte) 10;
        this.block = new FloatSpringSpec(f, f2);
    }
}
