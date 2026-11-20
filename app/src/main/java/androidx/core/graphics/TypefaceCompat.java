package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityRecreator;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.provider.CallbackWrapper;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.RequestExecutor$HandlerExecutor;
import androidx.core.provider.RequestExecutor$ReplyRunnable;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.TimedValueQueue;
import coil3.size.SizeKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypefaceCompat {
    public static Paint sCachedPaint;
    public static final LruCache sTypefaceCache;
    public static final SizeKt sTypefaceCompatImpl;

    static {
        Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("TypefaceCompat static init"));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            sTypefaceCompatImpl = new TypefaceCompatApi31Impl();
        } else if (i >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        }
        sTypefaceCache = new LruCache(16);
        sCachedPaint = null;
        Trace.endSection();
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry, Resources resources, int i, String str, int i2, int i3, TimedValueQueue timedValueQueue, boolean z) {
        Typeface typefaceCreateFromFontFamilyFilesResourceEntry;
        Typeface typefaceBuild;
        FontFamily fontFamilyBuild;
        byte b = 4;
        if (fontResourcesParserCompat$FamilyResourceEntry instanceof FontResourcesParserCompat$ProviderResourceEntry) {
            FontResourcesParserCompat$ProviderResourceEntry fontResourcesParserCompat$ProviderResourceEntry = (FontResourcesParserCompat$ProviderResourceEntry) fontResourcesParserCompat$FamilyResourceEntry;
            String str2 = fontResourcesParserCompat$ProviderResourceEntry.mSystemFontFamilyName;
            typefaceCreateFromFontFamilyFilesResourceEntry = null;
            byte b2 = 1;
            byte b3 = 0;
            if (TextUtils.isEmpty(str2) || (typefaceBuild = getSystemFontFamily(str2)) == null) {
                ArrayList arrayList = fontResourcesParserCompat$ProviderResourceEntry.mRequests;
                if (arrayList.size() != 1) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= arrayList.size()) {
                                Typeface.CustomFallbackBuilder customFallbackBuilder = null;
                                int i5 = 0;
                                while (true) {
                                    if (i5 < arrayList.size()) {
                                        FontRequest fontRequest = (FontRequest) arrayList.get(i5);
                                        if (i5 == arrayList.size() - 1 && TextUtils.isEmpty(fontRequest.mVariationSettings)) {
                                            customFallbackBuilder.setSystemFallback(fontRequest.mSystemFont);
                                        } else {
                                            String str3 = fontRequest.mSystemFont;
                                            String str4 = fontRequest.mVariationSettings;
                                            Font fontGuessPrimaryFont = guessPrimaryFont(getSystemFontFamily(str3));
                                            if (fontGuessPrimaryFont == null) {
                                                Log.w("TypefaceCompat", "Unable identify the primary font for " + fontRequest.mSystemFont + ". Falling back to provider font.");
                                            } else {
                                                if (TextUtils.isEmpty(str4)) {
                                                    fontFamilyBuild = new FontFamily.Builder(fontGuessPrimaryFont).build();
                                                } else {
                                                    try {
                                                        fontFamilyBuild = new FontFamily.Builder(TypefaceCompat$$ExternalSyntheticApiModelOutline0.m(fontGuessPrimaryFont).setFontVariationSettings(str4).build()).build();
                                                    } catch (IOException unused) {
                                                        Log.e("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                                    }
                                                }
                                                if (customFallbackBuilder == null) {
                                                    customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyBuild);
                                                } else {
                                                    customFallbackBuilder.addCustomFallback(fontFamilyBuild);
                                                }
                                                i5++;
                                            }
                                        }
                                    }
                                    typefaceBuild = customFallbackBuilder.build();
                                    break;
                                }
                            }
                            if (getSystemFontFamily(((FontRequest) arrayList.get(i4)).mSystemFont) != null) {
                                i4++;
                            }
                            typefaceBuild = null;
                            break;
                        }
                    }
                    typefaceBuild = null;
                    break;
                }
                typefaceBuild = getSystemFontFamily(((FontRequest) arrayList.get(0)).mSystemFont);
            }
            if (typefaceBuild != null) {
                if (timedValueQueue != null) {
                    new Handler(Looper.getMainLooper()).post(new ComponentActivity$$ExternalSyntheticLambda10(timedValueQueue, typefaceBuild, b));
                }
                sTypefaceCache.put(createResourceUid(resources, i, str, i2, i3), typefaceBuild);
                return typefaceBuild;
            }
            boolean z2 = !z ? timedValueQueue != null : fontResourcesParserCompat$ProviderResourceEntry.mStrategy != 0;
            int i6 = z ? fontResourcesParserCompat$ProviderResourceEntry.mTimeoutMs : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            AtomicInt atomicInt = new AtomicInt();
            atomicInt.delegate = timedValueQueue;
            ArrayList arrayList2 = fontResourcesParserCompat$ProviderResourceEntry.mRequests;
            RequestExecutor$HandlerExecutor requestExecutor$HandlerExecutor = new RequestExecutor$HandlerExecutor(handler);
            CallbackWrapper callbackWrapper = new CallbackWrapper(atomicInt, requestExecutor$HandlerExecutor, b3);
            if (!z2) {
                String strCreateCacheId = FontRequestWorker.createCacheId(i3, arrayList2);
                Typeface typeface = (Typeface) FontRequestWorker.sTypefaceCache.get(strCreateCacheId);
                if (typeface != null) {
                    requestExecutor$HandlerExecutor.execute(new ActivityRecreator.AnonymousClass1(atomicInt, typeface, b));
                    typefaceCreateFromFontFamilyFilesResourceEntry = typeface;
                } else {
                    FontRequestWorker.AnonymousClass2 anonymousClass2 = new FontRequestWorker.AnonymousClass2(b3, callbackWrapper);
                    synchronized (FontRequestWorker.LOCK) {
                        try {
                            SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                            ArrayList arrayList3 = (ArrayList) simpleArrayMap.get(strCreateCacheId);
                            if (arrayList3 != null) {
                                arrayList3.add(anonymousClass2);
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(anonymousClass2);
                                simpleArrayMap.put(strCreateCacheId, arrayList4);
                                FontRequestWorker.AnonymousClass1 anonymousClass1 = new FontRequestWorker.AnonymousClass1(strCreateCacheId, context, arrayList2, i3, (byte) 1);
                                ThreadPoolExecutor threadPoolExecutor = FontRequestWorker.DEFAULT_EXECUTOR_SERVICE;
                                FontRequestWorker.AnonymousClass2 anonymousClass3 = new FontRequestWorker.AnonymousClass2(b2, strCreateCacheId);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                RequestExecutor$ReplyRunnable requestExecutor$ReplyRunnable = new RequestExecutor$ReplyRunnable();
                                requestExecutor$ReplyRunnable.mCallable = anonymousClass1;
                                requestExecutor$ReplyRunnable.mConsumer = anonymousClass3;
                                requestExecutor$ReplyRunnable.mHandler = handler2;
                                threadPoolExecutor.execute(requestExecutor$ReplyRunnable);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } else {
                if (arrayList2.size() > 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Fallbacks with blocking fetches are not supported for performance reasons");
                    return null;
                }
                FontRequest fontRequest2 = (FontRequest) arrayList2.get(0);
                LruCache lruCache = FontRequestWorker.sTypefaceCache;
                ArrayList arrayList5 = new ArrayList(1);
                Object obj = new Object[]{fontRequest2}[0];
                Objects.requireNonNull(obj);
                arrayList5.add(obj);
                String strCreateCacheId2 = FontRequestWorker.createCacheId(i3, Collections.unmodifiableList(arrayList5));
                Typeface typeface2 = (Typeface) FontRequestWorker.sTypefaceCache.get(strCreateCacheId2);
                if (typeface2 != null) {
                    requestExecutor$HandlerExecutor.execute(new ActivityRecreator.AnonymousClass1(atomicInt, typeface2, b));
                    typefaceCreateFromFontFamilyFilesResourceEntry = typeface2;
                } else if (i6 == -1) {
                    Object[] objArr = {fontRequest2};
                    ArrayList arrayList6 = new ArrayList(1);
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    arrayList6.add(obj2);
                    FontRequestWorker.TypefaceResult fontSync = FontRequestWorker.getFontSync(i3, context, strCreateCacheId2, Collections.unmodifiableList(arrayList6));
                    callbackWrapper.onTypefaceResult(fontSync);
                    typefaceCreateFromFontFamilyFilesResourceEntry = fontSync.mTypeface;
                } else {
                    try {
                        try {
                            try {
                                FontRequestWorker.TypefaceResult typefaceResult = (FontRequestWorker.TypefaceResult) FontRequestWorker.DEFAULT_EXECUTOR_SERVICE.submit(new FontRequestWorker.AnonymousClass1(strCreateCacheId2, context, fontRequest2, i3, (byte) 0)).get(i6, TimeUnit.MILLISECONDS);
                                callbackWrapper.onTypefaceResult(typefaceResult);
                                typefaceCreateFromFontFamilyFilesResourceEntry = typefaceResult.mTypeface;
                            } catch (InterruptedException e) {
                                throw e;
                            }
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        } catch (TimeoutException unused2) {
                            throw new InterruptedException("timeout");
                        }
                    } catch (InterruptedException unused3) {
                        ((RequestExecutor$HandlerExecutor) callbackWrapper.mExecutor).execute(new CallbackWrapper.AnonymousClass2((AtomicInt) callbackWrapper.mCallback, -3));
                    }
                }
            }
        } else {
            typefaceCreateFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry) fontResourcesParserCompat$FamilyResourceEntry, resources, i3);
            if (timedValueQueue != null) {
                if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
                    new Handler(Looper.getMainLooper()).post(new ComponentActivity$$ExternalSyntheticLambda10(timedValueQueue, typefaceCreateFromFontFamilyFilesResourceEntry, b));
                } else {
                    timedValueQueue.callbackFailAsync(-3);
                }
            }
        }
        if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
            sTypefaceCache.put(createResourceUid(resources, i, str, i2, i3), typefaceCreateFromFontFamilyFilesResourceEntry);
        }
        return typefaceCreateFromFontFamilyFilesResourceEntry;
    }

    public static String createResourceUid(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface getSystemFontFamily(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font guessPrimaryFont(Typeface typeface) {
        Paint paint = sCachedPaint;
        if (paint == null) {
            paint = new Paint();
            sCachedPaint = paint;
        }
        paint.setTextSize(10.0f);
        sCachedPaint.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) ServerSentEventKt.SPACE, 0, 1, 0, 1, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, false, sCachedPaint);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
