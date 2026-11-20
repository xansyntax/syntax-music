package androidx.compose.ui.window;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.compose.ui.viewinterop.ViewFactoryHolder;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.sqlite.SQLite;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.json.internal.CharArrayPoolBase;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogLayout extends AbstractComposeView implements OnApplyWindowInsetsListener {
    public final ParcelableSnapshotMutableState content$delegate;
    public boolean decorFitsSystemWindows;
    public boolean hasCalledSetLayout;
    public boolean shouldCreateCompositionOnAttachedToWindow;
    public boolean usePlatformDefaultWidth;
    public final Window window;

    /* JADX INFO: renamed from: androidx.compose.ui.window.DialogLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends CharArrayPoolBase {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ ViewGroup this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(ViewGroup viewGroup, byte b) {
            super(1);
            this.$r8$classId = b;
            this.this$0 = viewGroup;
        }

        @Override // kotlinx.serialization.json.internal.CharArrayPoolBase
        public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
            byte b = this.$r8$classId;
            ViewGroup viewGroup = this.this$0;
            switch (b) {
                case 0:
                    DialogLayout dialogLayout = (DialogLayout) viewGroup;
                    if (dialogLayout.decorFitsSystemWindows) {
                        return windowInsetsCompat;
                    }
                    View childAt = dialogLayout.getChildAt(0);
                    int iMax = Math.max(0, childAt.getLeft());
                    int iMax2 = Math.max(0, childAt.getTop());
                    int iMax3 = Math.max(0, dialogLayout.getWidth() - childAt.getRight());
                    int iMax4 = Math.max(0, dialogLayout.getHeight() - childAt.getBottom());
                    return (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) ? windowInsetsCompat : windowInsetsCompat.mImpl.inset(iMax, iMax2, iMax3, iMax4);
                default:
                    return ((ViewFactoryHolder) viewGroup).insetToLayoutPosition(windowInsetsCompat);
            }
        }

        @Override // kotlinx.serialization.json.internal.CharArrayPoolBase
        public final WeakCache onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WeakCache weakCache) {
            byte b = this.$r8$classId;
            byte b2 = 14;
            ViewGroup viewGroup = this.this$0;
            switch (b) {
                case 0:
                    DialogLayout dialogLayout = (DialogLayout) viewGroup;
                    if (dialogLayout.decorFitsSystemWindows) {
                        return weakCache;
                    }
                    View childAt = dialogLayout.getChildAt(0);
                    int iMax = Math.max(0, childAt.getLeft());
                    int iMax2 = Math.max(0, childAt.getTop());
                    int iMax3 = Math.max(0, dialogLayout.getWidth() - childAt.getRight());
                    int iMax4 = Math.max(0, dialogLayout.getHeight() - childAt.getBottom());
                    if (iMax == 0 && iMax2 == 0 && iMax3 == 0 && iMax4 == 0) {
                        return weakCache;
                    }
                    Insets insetsOf = Insets.of(iMax, iMax2, iMax3, iMax4);
                    int i = insetsOf.left;
                    Insets insets = (Insets) weakCache.values;
                    int i2 = insetsOf.top;
                    int i3 = insetsOf.right;
                    int i4 = insetsOf.bottom;
                    return new WeakCache(WindowInsetsCompat.insetInsets(insets, i, i2, i3, i4), WindowInsetsCompat.insetInsets((Insets) weakCache.referenceQueue, i, i2, i3, i4), b2);
                default:
                    InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) ((ViewFactoryHolder) viewGroup).layoutNode.nodes.innerCoordinator;
                    if (!innerNodeCoordinator.tail.isAttached) {
                        return weakCache;
                    }
                    long jM847roundk4lQ0M = SQLite.m847roundk4lQ0M(innerNodeCoordinator.mo606localToRootMKHz9U(0L));
                    int i5 = (int) (jM847roundk4lQ0M >> 32);
                    if (i5 < 0) {
                        i5 = 0;
                    }
                    int i6 = (int) (jM847roundk4lQ0M & 4294967295L);
                    if (i6 < 0) {
                        i6 = 0;
                    }
                    long jMo603getSizeYbymL2g = RulerKt.findRootCoordinates(innerNodeCoordinator).mo603getSizeYbymL2g();
                    int i7 = (int) (jMo603getSizeYbymL2g >> 32);
                    int i8 = (int) (jMo603getSizeYbymL2g & 4294967295L);
                    long j = innerNodeCoordinator.measuredSize;
                    long jM847roundk4lQ0M2 = SQLite.m847roundk4lQ0M(innerNodeCoordinator.mo606localToRootMKHz9U((((long) Float.floatToRawIntBits((int) (j >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L)));
                    int i9 = i7 - ((int) (jM847roundk4lQ0M2 >> 32));
                    if (i9 < 0) {
                        i9 = 0;
                    }
                    int i10 = i8 - ((int) (jM847roundk4lQ0M2 & 4294967295L));
                    int i11 = i10 >= 0 ? i10 : 0;
                    return (i5 == 0 && i6 == 0 && i9 == 0 && i11 == 0) ? weakCache : new WeakCache(AndroidViewHolder.inset((Insets) weakCache.values, i5, i6, i9, i11), AndroidViewHolder.inset((Insets) weakCache.referenceQueue, i5, i6, i9, i11), b2);
            }
        }
    }

    public DialogLayout(Context context, Window window) {
        super(context);
        this.window = window;
        this.content$delegate = Stack.mutableStateOf$default(AndroidDialog_androidKt.lambda$210148896);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, this);
        WindowInsetsAnimationCompat.setCallback(this, new AnonymousClass1(this, (byte) 0));
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1735448596);
        int i2 = (gapComposer.changedInstance(this) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            ((Function2) this.content$delegate.getValue()).invoke(gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ComposerKt$$ExternalSyntheticLambda0(this, i, (byte) 29);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnLayout$ui(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int paddingLeft = (((i5 - measuredWidth) - paddingRight) / 2) + getPaddingLeft();
        int paddingTop = (((i6 - measuredHeight) - paddingBottom) / 2) + getPaddingTop();
        childAt.layout(paddingLeft, paddingTop, measuredWidth + paddingLeft, measuredHeight + paddingTop);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnMeasure$ui(int i, int i2) {
        int maxDialogHeightExcludingSystemBarInsets;
        int iMin;
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.internalOnMeasure$ui(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        Window window = this.window;
        if (mode != Integer.MIN_VALUE || this.usePlatformDefaultWidth || window.getAttributes().height != -2) {
            maxDialogHeightExcludingSystemBarInsets = size2;
        } else if (this.decorFitsSystemWindows) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 30) {
                maxDialogHeightExcludingSystemBarInsets = Api21Impl.INSTANCE.getMaxDialogHeightExcludingSystemBarInsets(window);
            } else if (i3 < 32) {
                maxDialogHeightExcludingSystemBarInsets = Api30Impl.INSTANCE.getMaxDialogHeightExcludingSystemBarInsets(window);
            } else {
                maxDialogHeightExcludingSystemBarInsets = size2;
            }
        } else {
            maxDialogHeightExcludingSystemBarInsets = size2 + 1;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i4 = size - paddingRight;
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = maxDialogHeightExcludingSystemBarInsets - paddingBottom;
        int i6 = i5 >= 0 ? i5 : 0;
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 != 0) {
            i = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        if (mode != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        }
        childAt.measure(i, i2);
        if (mode2 == Integer.MIN_VALUE) {
            size = Math.min(size, childAt.getMeasuredWidth() + paddingRight);
        } else if (mode2 != 1073741824) {
            size = childAt.getMeasuredWidth() + paddingRight;
        }
        if (mode != Integer.MIN_VALUE) {
            iMin = mode != 1073741824 ? childAt.getMeasuredHeight() + paddingBottom : size2;
        } else {
            iMin = Math.min(size2, childAt.getMeasuredHeight() + paddingBottom);
        }
        setMeasuredDimension(size, iMin);
        if (this.decorFitsSystemWindows || childAt.getMeasuredHeight() + paddingBottom <= size2 || window.getAttributes().height != -2) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        if (this.usePlatformDefaultWidth) {
            return;
        }
        window.setLayout(-1, -1);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (!this.decorFitsSystemWindows) {
            View childAt = getChildAt(0);
            int iMax = Math.max(0, childAt.getLeft());
            int iMax2 = Math.max(0, childAt.getTop());
            int iMax3 = Math.max(0, getWidth() - childAt.getRight());
            int iMax4 = Math.max(0, getHeight() - childAt.getBottom());
            if (iMax != 0 || iMax2 != 0 || iMax3 != 0 || iMax4 != 0) {
                return windowInsetsCompat.mImpl.inset(iMax, iMax2, iMax3, iMax4);
            }
        }
        return windowInsetsCompat;
    }
}
