package androidx.core.view.insets;

import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.graphics.Insets;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import kotlinx.serialization.json.internal.CharArrayPoolBase;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStateMonitor {
    public final ArrayList mCallbacks = new ArrayList();
    public int mColorHint;
    public final AnonymousClass1 mDetector;
    public Insets mInsets;
    public Insets mInsetsIgnoringVisibility;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View, androidx.core.view.insets.SystemBarStateMonitor$1, java.lang.Object] */
    public SystemBarStateMonitor(final ViewGroup viewGroup) {
        View childAt;
        Insets insets = Insets.NONE;
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets;
        Drawable background = viewGroup.getBackground();
        byte b = 0;
        this.mColorHint = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        ?? r0 = new View(viewGroup.getContext()) { // from class: androidx.core.view.insets.SystemBarStateMonitor.1
            @Override // android.view.View
            public final void onConfigurationChanged(Configuration configuration) {
                SystemBarStateMonitor systemBarStateMonitor = SystemBarStateMonitor.this;
                ArrayList arrayList = systemBarStateMonitor.mCallbacks;
                Drawable background2 = viewGroup.getBackground();
                int color = background2 instanceof ColorDrawable ? ((ColorDrawable) background2).getColor() : 0;
                if (systemBarStateMonitor.mColorHint != color) {
                    systemBarStateMonitor.mColorHint = color;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ((ProtectionGroup) arrayList.get(size)).onColorHintChanged(color);
                    }
                }
            }
        };
        this.mDetector = r0;
        r0.setVisibility(8);
        r0.setWillNotDraw(true);
        OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 5, this);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(r0, onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0);
        WindowInsetsAnimationCompat.setCallback(r0, new CharArrayPoolBase() { // from class: androidx.core.view.insets.SystemBarStateMonitor.2
            public final HashMap mAnimationSidesMap = new HashMap();

            @Override // kotlinx.serialization.json.internal.CharArrayPoolBase
            public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                ArrayList arrayList = SystemBarStateMonitor.this.mCallbacks;
                if ((windowInsetsAnimationCompat.mImpl.getTypeMask() & 519) != 0) {
                    this.mAnimationSidesMap.remove(windowInsetsAnimationCompat);
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ProtectionGroup protectionGroup = (ProtectionGroup) arrayList.get(size);
                        int i = protectionGroup.mAnimationCount;
                        boolean z = i > 0;
                        int i2 = i - 1;
                        protectionGroup.mAnimationCount = i2;
                        if (z && i2 == 0) {
                            protectionGroup.updateInsets();
                        }
                    }
                }
            }

            @Override // kotlinx.serialization.json.internal.CharArrayPoolBase
            public final void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                ArrayList arrayList = SystemBarStateMonitor.this.mCallbacks;
                if ((windowInsetsAnimationCompat.mImpl.getTypeMask() & 519) != 0) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ((ProtectionGroup) arrayList.get(size)).mAnimationCount++;
                    }
                }
            }

            @Override // kotlinx.serialization.json.internal.CharArrayPoolBase
            public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
                ArrayList arrayList = SystemBarStateMonitor.this.mCallbacks;
                RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
                int i = 0;
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) list.get(size);
                    Integer num = (Integer) this.mAnimationSidesMap.get(windowInsetsAnimationCompat);
                    if (num != null) {
                        int iIntValue = num.intValue();
                        float alpha = windowInsetsAnimationCompat.mImpl.getAlpha();
                        if ((iIntValue & 1) != 0) {
                            rectF.left = alpha;
                        }
                        if ((iIntValue & 2) != 0) {
                            rectF.top = alpha;
                        }
                        if ((iIntValue & 4) != 0) {
                            rectF.right = alpha;
                        }
                        if ((iIntValue & 8) != 0) {
                            rectF.bottom = alpha;
                        }
                        i |= iIntValue;
                    }
                }
                Insets insetsMin = Insets.min(windowInsetsCompat.mImpl.getInsets(519), windowInsetsCompat.mImpl.getInsets(64));
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ProtectionGroup protectionGroup = (ProtectionGroup) arrayList.get(size2);
                    Insets insets2 = protectionGroup.mInsetsIgnoringVisibility;
                    ArrayList arrayList2 = protectionGroup.mProtections;
                    for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
                        ColorProtection colorProtection = (ColorProtection) arrayList2.get(size3);
                        byte b2 = colorProtection.mSide;
                        if ((b2 & i) != 0) {
                            Protection$Attributes protection$Attributes = colorProtection.mAttributes;
                            if (!protection$Attributes.mVisible) {
                                protection$Attributes.mVisible = true;
                                CallbackWrapper callbackWrapper = protection$Attributes.mCallback;
                                if (callbackWrapper != null) {
                                    ((View) callbackWrapper.mExecutor).setVisibility(0);
                                }
                            }
                            if (b2 == 1) {
                                int i2 = insets2.left;
                                if (i2 > 0) {
                                    colorProtection.setSystemInsetAmount(insetsMin.left / i2);
                                }
                                colorProtection.setSystemAlpha(rectF.left);
                            } else if (b2 == 2) {
                                int i3 = insets2.top;
                                if (i3 > 0) {
                                    colorProtection.setSystemInsetAmount(insetsMin.top / i3);
                                }
                                colorProtection.setSystemAlpha(rectF.top);
                            } else if (b2 == 4) {
                                int i4 = insets2.right;
                                if (i4 > 0) {
                                    colorProtection.setSystemInsetAmount(insetsMin.right / i4);
                                }
                                colorProtection.setSystemAlpha(rectF.right);
                            } else if (b2 == 8) {
                                int i5 = insets2.bottom;
                                if (i5 > 0) {
                                    colorProtection.setSystemInsetAmount(insetsMin.bottom / i5);
                                }
                                colorProtection.setSystemAlpha(rectF.bottom);
                            }
                        }
                    }
                }
                return windowInsetsCompat;
            }

            @Override // kotlinx.serialization.json.internal.CharArrayPoolBase
            public final WeakCache onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WeakCache weakCache) {
                if ((windowInsetsAnimationCompat.mImpl.getTypeMask() & 519) != 0) {
                    Insets insets2 = (Insets) weakCache.referenceQueue;
                    Insets insets3 = (Insets) weakCache.values;
                    int i = insets2.left != insets3.left ? 1 : 0;
                    if (insets2.top != insets3.top) {
                        i |= 2;
                    }
                    if (insets2.right != insets3.right) {
                        i |= 4;
                    }
                    if (insets2.bottom != insets3.bottom) {
                        i |= 8;
                    }
                    this.mAnimationSidesMap.put(windowInsetsAnimationCompat, Integer.valueOf(i));
                }
                return weakCache;
            }
        });
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                childAt = null;
                break;
            }
            childAt = viewGroup.getChildAt(childCount);
            if (childAt.isAttachedToWindow() != viewGroup.isAttachedToWindow()) {
                break;
            } else {
                childCount--;
            }
        }
        if (childAt == null) {
            viewGroup.addView((View) r0, 0);
        } else {
            childAt.addOnAttachStateChangeListener(new AnonymousClass3(viewGroup, r0, b));
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.insets.SystemBarStateMonitor$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 implements View.OnAttachStateChangeListener {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object val$child;
        public final /* synthetic */ View val$group;

        public /* synthetic */ AnonymousClass3(View view, Object obj, byte b) {
            this.$r8$classId = b;
            this.val$group = view;
            this.val$child = obj;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            switch (this.$r8$classId) {
                case 0:
                    ((ViewGroup) this.val$group).addView((AnonymousClass1) this.val$child, 0);
                    view.removeOnAttachStateChangeListener(this);
                    break;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            byte b = this.$r8$classId;
            Object obj = this.val$child;
            View view2 = this.val$group;
            switch (b) {
                case 0:
                    ((ViewGroup) view2).addView((AnonymousClass1) obj, 0);
                    view.removeOnAttachStateChangeListener(this);
                    break;
                default:
                    view2.removeOnAttachStateChangeListener(this);
                    ((Recomposer) obj).cancel();
                    break;
            }
        }

        private final void onViewAttachedToWindow$androidx$compose$ui$platform$WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1(View view) {
        }
    }
}
