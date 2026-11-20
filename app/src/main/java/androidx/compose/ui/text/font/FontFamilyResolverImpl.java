package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.collection.internal.Lock;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.platform.WeakCache;
import androidx.navigation.internal.NavContext;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import io.ktor.client.utils.CIOKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    public final DiskLruCache$$ExternalSyntheticLambda0 createDefaultTypeface;
    public final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    public final DrawResult platformFamilyTypefaceAdapter;
    public final NavContext platformFontLoader;
    public final AndroidFontResolveInterceptor platformResolveInterceptor;
    public final WeakCache typefaceRequestCache;

    public FontFamilyResolverImpl(NavContext navContext, AndroidFontResolveInterceptor androidFontResolveInterceptor) {
        WeakCache weakCache = FontFamilyResolverKt.GlobalTypefaceRequestCache;
        FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.GlobalAsyncTypefaceCache);
        DrawResult drawResult = new DrawResult((byte) 29);
        this.platformFontLoader = navContext;
        this.platformResolveInterceptor = androidFontResolveInterceptor;
        this.typefaceRequestCache = weakCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = drawResult;
        this.createDefaultTypeface = new DiskLruCache$$ExternalSyntheticLambda0((byte) 7, this);
    }

    public final TypefaceResult resolve(TypefaceRequest typefaceRequest) {
        WeakCache weakCache = this.typefaceRequestCache;
        QuickJs$$ExternalSyntheticLambda1 quickJs$$ExternalSyntheticLambda1 = new QuickJs$$ExternalSyntheticLambda1(this, typefaceRequest, (byte) 1);
        synchronized (((Lock) weakCache.values)) {
            TypefaceResult typefaceResult = (TypefaceResult) ((LruCache) weakCache.referenceQueue).get(typefaceRequest);
            if (typefaceResult != null) {
                if (typefaceResult.getCacheable()) {
                    return typefaceResult;
                }
            }
            try {
                TypefaceResult typefaceResult2 = (TypefaceResult) quickJs$$ExternalSyntheticLambda1.invoke(new QuickJs$$ExternalSyntheticLambda1(weakCache, typefaceRequest, (byte) 2));
                synchronized (((Lock) weakCache.values)) {
                    if (((LruCache) weakCache.referenceQueue).get(typefaceRequest) == null && typefaceResult2.getCacheable()) {
                        ((LruCache) weakCache.referenceQueue).put(typefaceRequest, typefaceResult2);
                    }
                }
                return typefaceResult2;
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
    }

    /* JADX INFO: renamed from: resolve-DPcqOEQ, reason: not valid java name */
    public final TypefaceResult m753resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
        int i3 = this.platformResolveInterceptor.fontWeightAdjustment;
        return resolve(new TypefaceRequest(fontFamily, (i3 == 0 || i3 == Integer.MAX_VALUE) ? fontWeight : new FontWeight(UuidKt.coerceIn(fontWeight.weight + i3, 1, CIOKt.DEFAULT_HTTP_POOL_SIZE)), i, i2, null));
    }
}
