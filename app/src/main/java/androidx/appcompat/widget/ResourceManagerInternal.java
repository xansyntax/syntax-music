package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import com.materialkolor.quantize.QuantizerWu;
import com.yalantis.ucrop.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.WeakHashMap;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceManagerInternal {
    public static ResourceManagerInternal INSTANCE;
    public final WeakHashMap mDrawableCaches = new WeakHashMap(0);
    public boolean mHasCheckedVectorDrawableSetup;
    public QuantizerWu mHooks;
    public WeakHashMap mTintLists;
    public TypedValue mTypedValue;
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ColorFilterLruCache extends LruCache {
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        resourceManagerInternal = INSTANCE;
        if (resourceManagerInternal == null) {
            resourceManagerInternal = new ResourceManagerInternal();
            INSTANCE = resourceManagerInternal;
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
        colorFilterLruCache.getClass();
        int i2 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) colorFilterLruCache.get(Integer.valueOf(mode.hashCode() + i2));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public final void addTintListToCache(Context context, int i, ColorStateList colorStateList) {
        WeakHashMap weakHashMap = this.mTintLists;
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            this.mTintLists = weakHashMap;
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat(0);
            this.mTintLists.put(context, sparseArrayCompat);
        }
        int i2 = sparseArrayCompat.size;
        if (i2 != 0 && i <= sparseArrayCompat.keys[i2 - 1]) {
            sparseArrayCompat.put(i, colorStateList);
            return;
        }
        if (sparseArrayCompat.garbage && i2 >= sparseArrayCompat.keys.length) {
            ArraySetKt.gc(sparseArrayCompat);
        }
        int i3 = sparseArrayCompat.size;
        if (i3 >= sparseArrayCompat.keys.length) {
            int i4 = (i3 + 1) * 4;
            for (int i5 = 4; i5 < 32; i5++) {
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
            }
            int i7 = i4 / 4;
            sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, i7);
            sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, i7);
        }
        sparseArrayCompat.keys[i3] = i;
        sparseArrayCompat.values[i3] = colorStateList;
        sparseArrayCompat.size = i3 + 1;
    }

    public final Drawable createDrawableIfNeeded(Context context, int i) {
        LayerDrawable ratingBarLayerDrawable;
        WeakReference weakReference;
        Drawable drawableNewDrawable;
        TypedValue typedValue = this.mTypedValue;
        if (typedValue == null) {
            typedValue = new TypedValue();
            this.mTypedValue = typedValue;
        }
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
            ratingBarLayerDrawable = null;
            if (longSparseArray != null && (weakReference = (WeakReference) longSparseArray.get(j)) != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    longSparseArray.remove(j);
                }
            }
            drawableNewDrawable = null;
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        if (this.mHooks != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                ratingBarLayerDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, R.drawable.abc_cab_background_internal_bg), getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == R.drawable.abc_ratingbar_material) {
                ratingBarLayerDrawable = QuantizerWu.getRatingBarLayerDrawable(this, context, R.dimen.abc_star_big);
            } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                ratingBarLayerDrawable = QuantizerWu.getRatingBarLayerDrawable(this, context, R.dimen.abc_star_medium);
            } else if (i == R.drawable.abc_ratingbar_small_material) {
                ratingBarLayerDrawable = QuantizerWu.getRatingBarLayerDrawable(this, context, R.dimen.abc_star_small);
            }
        }
        if (ratingBarLayerDrawable == null) {
            return ratingBarLayerDrawable;
        }
        ratingBarLayerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = ratingBarLayerDrawable.getConstantState();
                if (constantState2 == null) {
                    return ratingBarLayerDrawable;
                }
                LongSparseArray longSparseArray2 = (LongSparseArray) this.mDrawableCaches.get(context);
                if (longSparseArray2 == null) {
                    longSparseArray2 = new LongSparseArray();
                    this.mDrawableCaches.put(context, longSparseArray2);
                }
                longSparseArray2.put(j, new WeakReference(constantState2));
                return ratingBarLayerDrawable;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized Drawable getDrawable(Context context, int i, boolean z) {
        Drawable drawableCreateDrawableIfNeeded;
        try {
            if (!this.mHasCheckedVectorDrawableSetup) {
                this.mHasCheckedVectorDrawableSetup = true;
                Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
                if (drawable == null || !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                    this.mHasCheckedVectorDrawableSetup = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableCreateDrawableIfNeeded = createDrawableIfNeeded(context, i);
            if (drawableCreateDrawableIfNeeded == null) {
                drawableCreateDrawableIfNeeded = context.getDrawable(i);
            }
            if (drawableCreateDrawableIfNeeded != null) {
                drawableCreateDrawableIfNeeded = tintDrawable(context, i, z, drawableCreateDrawableIfNeeded);
            }
            if (drawableCreateDrawableIfNeeded != null) {
                DrawableUtils.fixDrawable(drawableCreateDrawableIfNeeded);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableCreateDrawableIfNeeded;
    }

    public final synchronized ColorStateList getTintList(Context context, int i) {
        ColorStateList colorStateList;
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.mTintLists;
        ColorStateList tintListForDrawableRes = null;
        colorStateList = (weakHashMap == null || (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) == null) ? null : (ColorStateList) ArraySetKt.commonGet(sparseArrayCompat, i);
        if (colorStateList == null) {
            QuantizerWu quantizerWu = this.mHooks;
            if (quantizerWu != null) {
                tintListForDrawableRes = quantizerWu.getTintListForDrawableRes(context, i);
            }
            if (tintListForDrawableRes != null) {
                addTintListToCache(context, i, tintListForDrawableRes);
            }
            colorStateList = tintListForDrawableRes;
        }
        return colorStateList;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00fb A[RETURN] */
    public final Drawable tintDrawable(Context context, int i, boolean z, Drawable drawable) {
        int iRound;
        PorterDuffColorFilter porterDuffColorFilter;
        ColorStateList tintList = getTintList(context, i);
        PorterDuff.Mode mode = null;
        if (tintList != null) {
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setTintList(tintList);
            if (this.mHooks != null && i == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode != null) {
                drawableMutate.setTintMode(mode);
            }
            return drawableMutate;
        }
        QuantizerWu quantizerWu = this.mHooks;
        int i2 = R.attr.colorControlNormal;
        if (quantizerWu != null) {
            if (i == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
                QuantizerWu.setPorterDuffColorFilter(drawableFindDrawableByLayerId, themeAttrColor, mode2);
                QuantizerWu.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), mode2);
                QuantizerWu.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = AppCompatDrawableManager.DEFAULT_MODE;
                QuantizerWu.setPorterDuffColorFilter(drawableFindDrawableByLayerId2, disabledThemeAttrColor, mode3);
                QuantizerWu.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode3);
                QuantizerWu.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        if (quantizerWu != null) {
            PorterDuff.Mode mode4 = AppCompatDrawableManager.DEFAULT_MODE;
            boolean z2 = true;
            if (QuantizerWu.arrayContains(i, (int[]) quantizerWu.weights)) {
                iRound = -1;
            } else {
                if (QuantizerWu.arrayContains(i, (int[]) quantizerWu.momentsG)) {
                    i2 = R.attr.colorControlActivated;
                } else {
                    boolean zArrayContains = QuantizerWu.arrayContains(i, (int[]) quantizerWu.momentsB);
                    i2 = android.R.attr.colorBackground;
                    if (zArrayContains) {
                        mode4 = PorterDuff.Mode.MULTIPLY;
                    } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                        iRound = Math.round(40.8f);
                        i2 = android.R.attr.colorForeground;
                    } else if (i != R.drawable.abc_dialog_material_background) {
                        i2 = 0;
                        z2 = false;
                    }
                }
                iRound = -1;
            }
            if (z2) {
                Drawable drawableMutate2 = drawable.mutate();
                int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, i2);
                synchronized (AppCompatDrawableManager.class) {
                    porterDuffColorFilter = getPorterDuffColorFilter(themeAttrColor2, mode4);
                }
                drawableMutate2.setColorFilter(porterDuffColorFilter);
                if (iRound != -1) {
                    drawableMutate2.setAlpha(iRound);
                    return drawable;
                }
            } else if (z) {
                return null;
            }
        } else if (z) {
            return null;
        }
        return drawable;
    }

    public final synchronized Drawable getDrawable(Context context, int i) {
        return getDrawable(context, i, false);
    }

    public static void tintDrawable(Drawable drawable, ConnectionSpec.Builder builder, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = builder.supportsTlsExtensions;
            if (!z && !builder.tls) {
                drawable.clearColorFilter();
                return;
            }
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z ? (ColorStateList) builder.cipherSuites : null;
            PorterDuff.Mode mode = builder.tls ? (PorterDuff.Mode) builder.tlsVersions : DEFAULT_MODE;
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        }
    }
}
