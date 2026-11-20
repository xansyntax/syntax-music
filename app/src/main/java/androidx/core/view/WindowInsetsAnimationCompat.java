package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.graphics.Insets;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlinx.serialization.json.internal.CharArrayPoolBase;
import okhttp3.internal.platform.Android10Platform$$ExternalSyntheticApiModelOutline3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    public Impl mImpl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Impl {
        public final long mDurationMillis;
        public float mFraction;
        public final Interpolator mInterpolator;
        public final int mTypeMask;

        public Impl(int i, Interpolator interpolator, long j) {
            this.mTypeMask = i;
            this.mInterpolator = interpolator;
            this.mDurationMillis = j;
        }

        public float getAlpha() {
            return 1.0f;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getInterpolatedFraction() {
            float f = this.mFraction;
            Interpolator interpolator = this.mInterpolator;
            return interpolator != null ? interpolator.getInterpolation(f) : f;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Impl21 extends Impl {
        public static final PathInterpolator SHOW_IME_INTERPOLATOR = new PathInterpolator(CropImageView.DEFAULT_ASPECT_RATIO, 1.1f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        public static final FastOutLinearInInterpolator HIDE_IME_INTERPOLATOR = new FastOutLinearInInterpolator();
        public static final DecelerateInterpolator SHOW_SYSTEM_BAR_INTERPOLATOR = new DecelerateInterpolator(1.5f);
        public static final AccelerateInterpolator HIDE_SYSTEM_BAR_INTERPOLATOR = new AccelerateInterpolator(1.5f);

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            public final CharArrayPoolBase mCallback;
            public WindowInsetsCompat mLastInsets;

            public Impl21OnApplyWindowInsetsListener(View view, CharArrayPoolBase charArrayPoolBase) {
                WindowInsetsCompat windowInsetsCompatBuild;
                this.mCallback = charArrayPoolBase;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(view);
                if (rootWindowInsets != null) {
                    int i = Build.VERSION.SDK_INT;
                    windowInsetsCompatBuild = (i >= 36 ? new WindowInsetsCompat.BuilderImpl36(rootWindowInsets) : i >= 35 ? new WindowInsetsCompat.BuilderImpl35(rootWindowInsets) : i >= 34 ? new WindowInsetsCompat.BuilderImpl34(rootWindowInsets) : i >= 31 ? new WindowInsetsCompat.BuilderImpl31(rootWindowInsets) : i >= 30 ? new WindowInsetsCompat.BuilderImpl30(rootWindowInsets) : i >= 29 ? new WindowInsetsCompat.BuilderImpl29(rootWindowInsets) : new WindowInsetsCompat.BuilderImpl20(rootWindowInsets)).build();
                } else {
                    windowInsetsCompatBuild = null;
                }
                this.mLastInsets = windowInsetsCompatBuild;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                Interpolator interpolator;
                if (!view.isLaidOut()) {
                    this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                    return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
                WindowInsetsCompat rootWindowInsets = this.mLastInsets;
                if (rootWindowInsets == null) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(view);
                    this.mLastInsets = rootWindowInsets;
                }
                if (rootWindowInsets == null) {
                    this.mLastInsets = windowInsetsCompat;
                    if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                        return view.onApplyWindowInsets(windowInsets);
                    }
                } else {
                    CharArrayPoolBase callback = Impl21.getCallback(view);
                    if (callback == null || !Objects.equals((WindowInsetsCompat) callback.arrays, windowInsetsCompat)) {
                        int[] iArr = new int[1];
                        int[] iArr2 = new int[1];
                        WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
                        int i = 1;
                        while (i <= 512) {
                            Insets insets = impl.getInsets(i);
                            Insets insets2 = windowInsetsCompat2.mImpl.getInsets(i);
                            int i2 = insets.left;
                            int i3 = insets.bottom;
                            int i4 = insets.right;
                            int i5 = insets.top;
                            int i6 = insets2.left;
                            int i7 = insets2.bottom;
                            int[] iArr3 = iArr;
                            int i8 = insets2.right;
                            int i9 = insets2.top;
                            boolean z = i2 > i6 || i5 > i9 || i4 > i8 || i3 > i7;
                            if (z != (i2 < i6 || i5 < i9 || i4 < i8 || i3 < i7)) {
                                if (z) {
                                    iArr3[0] = iArr3[0] | i;
                                } else {
                                    iArr2[0] = iArr2[0] | i;
                                }
                            }
                            i <<= 1;
                            iArr = iArr3;
                            iArr2 = iArr2;
                        }
                        int i10 = iArr[0];
                        int i11 = iArr2[0];
                        final int i12 = i10 | i11;
                        if (i12 == 0) {
                            this.mLastInsets = windowInsetsCompat;
                            if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                                return view.onApplyWindowInsets(windowInsets);
                            }
                        } else {
                            final WindowInsetsCompat windowInsetsCompat3 = this.mLastInsets;
                            if ((i10 & 8) != 0) {
                                interpolator = Impl21.SHOW_IME_INTERPOLATOR;
                            } else if ((i11 & 8) != 0) {
                                interpolator = Impl21.HIDE_IME_INTERPOLATOR;
                            } else if ((i10 & 519) != 0) {
                                interpolator = Impl21.SHOW_SYSTEM_BAR_INTERPOLATOR;
                            } else {
                                interpolator = (i11 & 519) != 0 ? Impl21.HIDE_SYSTEM_BAR_INTERPOLATOR : null;
                            }
                            final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i12, interpolator, (i12 & 8) != 0 ? 160L : 250L);
                            windowInsetsAnimationCompat.mImpl.setFraction(CropImageView.DEFAULT_ASPECT_RATIO);
                            ValueAnimator duration = ValueAnimator.ofFloat(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f).setDuration(windowInsetsAnimationCompat.mImpl.getDurationMillis());
                            Insets insets3 = impl.getInsets(i12);
                            Insets insets4 = windowInsetsCompat3.mImpl.getInsets(i12);
                            int iMin = Math.min(insets3.left, insets4.left);
                            int i13 = insets3.top;
                            int i14 = insets4.top;
                            int iMin2 = Math.min(i13, i14);
                            int i15 = insets3.right;
                            int i16 = insets4.right;
                            int iMin3 = Math.min(i15, i16);
                            int i17 = insets3.bottom;
                            int i18 = insets4.bottom;
                            WeakCache weakCache = new WeakCache((Object) Insets.of(iMin, iMin2, iMin3, Math.min(i17, i18)), (Object) Insets.of(Math.max(insets3.left, insets4.left), Math.max(i13, i14), Math.max(i15, i16), Math.max(i17, i18)), (byte) 14);
                            Impl21.dispatchOnPrepare(view, windowInsetsAnimationCompat, windowInsetsCompat, false);
                            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    WindowInsetsCompat.BuilderImpl builderImpl29;
                                    float animatedFraction = valueAnimator.getAnimatedFraction();
                                    WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                                    Impl impl2 = windowInsetsAnimationCompat2.mImpl;
                                    impl2.setFraction(animatedFraction);
                                    float interpolatedFraction = impl2.getInterpolatedFraction();
                                    PathInterpolator pathInterpolator = Impl21.SHOW_IME_INTERPOLATOR;
                                    int i19 = Build.VERSION.SDK_INT;
                                    WindowInsetsCompat windowInsetsCompat4 = windowInsetsCompat;
                                    if (i19 >= 36) {
                                        builderImpl29 = new WindowInsetsCompat.BuilderImpl36(windowInsetsCompat4);
                                    } else if (i19 >= 35) {
                                        builderImpl29 = new WindowInsetsCompat.BuilderImpl35(windowInsetsCompat4);
                                    } else if (i19 >= 34) {
                                        builderImpl29 = new WindowInsetsCompat.BuilderImpl34(windowInsetsCompat4);
                                    } else if (i19 >= 31) {
                                        builderImpl29 = new WindowInsetsCompat.BuilderImpl31(windowInsetsCompat4);
                                    } else if (i19 >= 30) {
                                        builderImpl29 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat4);
                                    } else {
                                        builderImpl29 = i19 >= 29 ? new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat4) : new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat4);
                                    }
                                    for (int i20 = 1; i20 <= 512; i20 <<= 1) {
                                        int i21 = i12 & i20;
                                        WindowInsetsCompat.Impl impl3 = windowInsetsCompat4.mImpl;
                                        if (i21 == 0) {
                                            builderImpl29.setInsets(i20, impl3.getInsets(i20));
                                        } else {
                                            Insets insets5 = impl3.getInsets(i20);
                                            Insets insets6 = windowInsetsCompat3.mImpl.getInsets(i20);
                                            float f = 1.0f - interpolatedFraction;
                                            builderImpl29.setInsets(i20, WindowInsetsCompat.insetInsets(insets5, (int) (((double) ((insets5.left - insets6.left) * f)) + 0.5d), (int) (((double) ((insets5.top - insets6.top) * f)) + 0.5d), (int) (((double) ((insets5.right - insets6.right) * f)) + 0.5d), (int) (((double) ((insets5.bottom - insets6.bottom) * f)) + 0.5d)));
                                        }
                                    }
                                    Impl21.dispatchOnProgress(view, builderImpl29.build(), Collections.singletonList(windowInsetsAnimationCompat2));
                                }
                            });
                            duration.addListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                                    windowInsetsAnimationCompat2.mImpl.setFraction(1.0f);
                                    Impl21.dispatchOnEnd(view, windowInsetsAnimationCompat2);
                                }
                            });
                            OneShotPreDrawListener.add(view, new CascadingMenuPopup$3$1(view, windowInsetsAnimationCompat, weakCache, duration));
                            this.mLastInsets = windowInsetsCompat;
                            if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                                return view.onApplyWindowInsets(windowInsets);
                            }
                        }
                    } else if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                        return view.onApplyWindowInsets(windowInsets);
                    }
                }
                return windowInsets;
            }
        }

        public static void dispatchOnEnd(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            CharArrayPoolBase callback = getCallback(view);
            if (callback != null) {
                callback.onEnd(windowInsetsAnimationCompat);
                if (callback.charsTotal == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnEnd(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
                }
            }
        }

        public static void dispatchOnPrepare(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, boolean z) {
            CharArrayPoolBase callback = getCallback(view);
            if (callback != null) {
                callback.arrays = windowInsetsCompat;
                if (!z) {
                    callback.onPrepare(windowInsetsAnimationCompat);
                    z = callback.charsTotal == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnPrepare(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsetsCompat, z);
                }
            }
        }

        public static void dispatchOnProgress(View view, WindowInsetsCompat windowInsetsCompat, List list) {
            CharArrayPoolBase callback = getCallback(view);
            if (callback != null) {
                windowInsetsCompat = callback.onProgress(windowInsetsCompat, list);
                if (callback.charsTotal == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnProgress(viewGroup.getChildAt(i), windowInsetsCompat, list);
                }
            }
        }

        public static void dispatchOnStart(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WeakCache weakCache) {
            CharArrayPoolBase callback = getCallback(view);
            if (callback != null) {
                callback.onStart(windowInsetsAnimationCompat, weakCache);
                if (callback.charsTotal == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnStart(viewGroup.getChildAt(i), windowInsetsAnimationCompat, weakCache);
                }
            }
        }

        public static CharArrayPoolBase getCallback(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).mCallback;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Impl30 extends Impl {
        public final WindowInsetsAnimation mWrapped;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class ProxyCallback extends WindowInsetsAnimation$Callback {
            public final HashMap mAnimations;
            public final CharArrayPoolBase mCompat;
            public List mRORunningAnimations;
            public ArrayList mTmpRunningAnimations;

            public ProxyCallback(CharArrayPoolBase charArrayPoolBase) {
                super(charArrayPoolBase.charsTotal);
                this.mAnimations = new HashMap();
                this.mCompat = charArrayPoolBase;
            }

            public final WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
                HashMap map = this.mAnimations;
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) map.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = new WindowInsetsAnimationCompat(0, null, 0L);
                windowInsetsAnimationCompat2.mImpl = new Impl30(windowInsetsAnimation);
                map.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                return windowInsetsAnimationCompat2;
            }

            public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(windowInsetsAnimation));
                this.mAnimations.remove(windowInsetsAnimation);
            }

            public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(windowInsetsAnimation));
            }

            public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.mTmpRunningAnimations;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.mTmpRunningAnimations = arrayList2;
                    this.mRORunningAnimations = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = getWindowInsetsAnimationCompat(windowInsetsAnimation);
                    windowInsetsAnimationCompat.mImpl.setFraction(windowInsetsAnimation.getFraction());
                    this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
                }
                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets, null), this.mRORunningAnimations).toWindowInsets();
            }

            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                WeakCache weakCacheOnStart = this.mCompat.onStart(getWindowInsetsAnimationCompat(windowInsetsAnimation), new WeakCache(bounds));
                weakCacheOnStart.getClass();
                Android10Platform$$ExternalSyntheticApiModelOutline3.m();
                return Android10Platform$$ExternalSyntheticApiModelOutline3.m(((Insets) weakCacheOnStart.values).toPlatformInsets(), ((Insets) weakCacheOnStart.referenceQueue).toPlatformInsets());
            }
        }

        public Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.mWrapped = windowInsetsAnimation;
        }

        public static Insets getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getUpperBound());
        }

        public static Insets getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getLowerBound());
        }

        public static void setCallback(View view, CharArrayPoolBase charArrayPoolBase) {
            view.setWindowInsetsAnimationCallback(charArrayPoolBase != null ? new ProxyCallback(charArrayPoolBase) : null);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final float getAlpha() {
            return this.mWrapped.getAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final void setFraction(float f) {
            this.mWrapped.setFraction(f);
        }
    }

    public WindowInsetsAnimationCompat(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(Android10Platform$$ExternalSyntheticApiModelOutline3.m(i, interpolator, j));
        } else {
            this.mImpl = new Impl21(i, interpolator, j);
        }
    }

    public static void setCallback(View view, CharArrayPoolBase charArrayPoolBase) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setCallback(view, charArrayPoolBase);
            return;
        }
        PathInterpolator pathInterpolator = Impl21.SHOW_IME_INTERPOLATOR;
        View.OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener = charArrayPoolBase != null ? new Impl21.Impl21OnApplyWindowInsetsListener(view, charArrayPoolBase) : null;
        view.setTag(R.id.tag_window_insets_animation_callback, impl21OnApplyWindowInsetsListener);
        if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(impl21OnApplyWindowInsetsListener);
        }
    }
}
