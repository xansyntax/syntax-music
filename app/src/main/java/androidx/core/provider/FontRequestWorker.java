package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import androidx.media3.common.FlagSet;
import coil3.size.SizeKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FontRequestWorker {
    public static final ThreadPoolExecutor DEFAULT_EXECUTOR_SERVICE;
    public static final Object LOCK;
    public static final SimpleArrayMap PENDING_REPLIES;
    public static final LruCache sTypefaceCache = new LruCache(16);

    /* JADX INFO: renamed from: androidx.core.provider.FontRequestWorker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Callable {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$id;
        public final /* synthetic */ Object val$request;
        public final /* synthetic */ int val$style;

        public /* synthetic */ AnonymousClass1(String str, Context context, Object obj, int i, byte b) {
            this.$r8$classId = b;
            this.val$id = str;
            this.val$context = context;
            this.val$request = obj;
            this.val$style = i;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            byte b = this.$r8$classId;
            int i = this.val$style;
            Object obj = this.val$request;
            Context context = this.val$context;
            String str = this.val$id;
            switch (b) {
                case 0:
                    Object[] objArr = {(FontRequest) obj};
                    ArrayList arrayList = new ArrayList(1);
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    arrayList.add(obj2);
                    return FontRequestWorker.getFontSync(i, context, str, Collections.unmodifiableList(arrayList));
                default:
                    try {
                        return FontRequestWorker.getFontSync(i, context, str, (ArrayList) obj);
                    } catch (Throwable unused) {
                        return new TypefaceResult(-3);
                    }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.core.provider.FontRequestWorker$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements Consumer {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object val$callback;

        public /* synthetic */ AnonymousClass2(byte b, Object obj) {
            this.$r8$classId = b;
            this.val$callback = obj;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    TypefaceResult typefaceResult = (TypefaceResult) obj;
                    if (typefaceResult == null) {
                        typefaceResult = new TypefaceResult(-3);
                    }
                    ((CallbackWrapper) this.val$callback).onTypefaceResult(typefaceResult);
                    return;
                default:
                    TypefaceResult typefaceResult2 = (TypefaceResult) obj;
                    synchronized (FontRequestWorker.LOCK) {
                        try {
                            SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                            ArrayList arrayList = (ArrayList) simpleArrayMap.get((String) this.val$callback);
                            if (arrayList == null) {
                                return;
                            }
                            simpleArrayMap.remove((String) this.val$callback);
                            for (int i = 0; i < arrayList.size(); i++) {
                                ((Consumer) arrayList.get(i)).accept(typefaceResult2);
                            }
                            return;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new RequestExecutor$DefaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DEFAULT_EXECUTOR_SERVICE = threadPoolExecutor;
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap(0);
    }

    public static String createCacheId(int i, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((FontRequest) list.get(i2)).mIdentifier);
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static TypefaceResult getFontSync(int i, Context context, String str, List list) {
        int i2;
        Typeface typefaceCreateFromFontInfo;
        LruCache lruCache = sTypefaceCache;
        Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("getFontSync"));
        try {
            Typeface typeface = (Typeface) lruCache.get(str);
            if (typeface != null) {
                TypefaceResult typefaceResult = new TypefaceResult(typeface);
                Trace.endSection();
                return typefaceResult;
            }
            try {
                FlagSet.Builder fontFamilyResult = FontProvider.getFontFamilyResult(context, list);
                List list2 = (List) fontFamilyResult.flags;
                boolean z = fontFamilyResult.buildCalled;
                if (!z) {
                    FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = (FontsContractCompat$FontInfo[]) list2.get(0);
                    if (fontsContractCompat$FontInfoArr == null || fontsContractCompat$FontInfoArr.length == 0) {
                        i2 = 1;
                    } else {
                        int length = fontsContractCompat$FontInfoArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                i2 = 0;
                                break;
                            }
                            int i4 = fontsContractCompat$FontInfoArr[i3].mResultCode;
                            if (i4 != 0) {
                                if (i4 >= 0) {
                                    i2 = i4;
                                    break;
                                }
                                i2 = -3;
                                break;
                            }
                            i3++;
                        }
                    }
                } else {
                    if (!z) {
                        i2 = -3;
                        break;
                    }
                    i2 = -2;
                }
                if (i2 != 0) {
                    TypefaceResult typefaceResult2 = new TypefaceResult(i2);
                    Trace.endSection();
                    return typefaceResult2;
                }
                if (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                    FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr2 = (FontsContractCompat$FontInfo[]) list2.get(0);
                    SizeKt sizeKt = TypefaceCompat.sTypefaceCompatImpl;
                    Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("TypefaceCompat.createFromFontInfo"));
                    try {
                        typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr2, i);
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    SizeKt sizeKt2 = TypefaceCompat.sTypefaceCompatImpl;
                    Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("TypefaceCompat.createFromFontInfoWithFallback"));
                    try {
                        typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfoWithFallback(context, list2, i);
                        Trace.endSection();
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                if (typefaceCreateFromFontInfo == null) {
                    TypefaceResult typefaceResult3 = new TypefaceResult(-3);
                    Trace.endSection();
                    return typefaceResult3;
                }
                lruCache.put(str, typefaceCreateFromFontInfo);
                TypefaceResult typefaceResult4 = new TypefaceResult(typefaceCreateFromFontInfo);
                Trace.endSection();
                return typefaceResult4;
            } catch (PackageManager.NameNotFoundException unused) {
                TypefaceResult typefaceResult5 = new TypefaceResult(-1);
                Trace.endSection();
                return typefaceResult5;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        public TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}
