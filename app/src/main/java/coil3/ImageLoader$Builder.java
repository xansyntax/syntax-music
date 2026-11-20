package coil3;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import android.util.Pair;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda5;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.ui.text.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.ParagraphIntrinsicInfo;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutHelper$BidiRun;
import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.core.app.TaskStackBuilder;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.ExoPlayer$Builder$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.source.MediaSource$Factory;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.ttml.DeleteTextSpan;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.text.ttml.TtmlRegion;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import androidx.navigation.NavDeepLinkBuilder$DeepLinkDestination;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavGraphImpl$iterator$1;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.ImageLoader$Builder;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.map.FileMapper;
import coil3.request.ImageRequest;
import coil3.util.FileSystemsKt;
import com.google.common.base.Supplier;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.lyrics.LyricsHelper$getLyrics$1;
import com.metrolist.music.lyrics.LyricsHelper$special$$inlined$map$1;
import com.metrolist.music.lyrics.LyricsProvider;
import com.metrolist.music.lyrics.LyricsProviderRegistry;
import com.metrolist.music.lyrics.LyricsResult;
import com.metrolist.music.lyrics.LyricsWithProvider;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$7$1$1$1;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.GenericDeclaration;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.InitializedLazyImpl;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ImageLoader$Builder implements ParagraphIntrinsics, Subtitle {
    public final Object application;
    public Object defaults;
    public Object diskCacheLazy;
    public Object extras;
    public Object memoryCacheLazy;

    public ImageLoader$Builder(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Density density, List list, boolean z) {
        int i;
        AnnotatedString annotatedString2 = annotatedString;
        TextStyle textStyle2 = textStyle;
        this.application = annotatedString2;
        this.defaults = list;
        final byte b = 0;
        Function0 function0 = new Function0(this) { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$$ExternalSyntheticLambda0
            public final /* synthetic */ ImageLoader$Builder f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                float minIntrinsicWidth = CropImageView.DEFAULT_ASPECT_RATIO;
                Object obj = null;
                int i2 = 1;
                ImageLoader$Builder imageLoader$Builder = this.f$0;
                switch (b2) {
                    case 0:
                        ArrayList arrayList = (ArrayList) imageLoader$Builder.extras;
                        if (!arrayList.isEmpty()) {
                            Object obj2 = arrayList.get(0);
                            float minIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj2).intrinsics.getMinIntrinsicWidth();
                            int size = arrayList.size() - 1;
                            if (1 <= size) {
                                while (true) {
                                    Object obj3 = arrayList.get(i2);
                                    float minIntrinsicWidth3 = ((ParagraphIntrinsicInfo) obj3).intrinsics.getMinIntrinsicWidth();
                                    if (Float.compare(minIntrinsicWidth2, minIntrinsicWidth3) < 0) {
                                        obj2 = obj3;
                                        minIntrinsicWidth2 = minIntrinsicWidth3;
                                    }
                                    if (i2 != size) {
                                        i2++;
                                    }
                                }
                            }
                            obj = obj2;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                        if (paragraphIntrinsicInfo != null) {
                            minIntrinsicWidth = paragraphIntrinsicInfo.intrinsics.getMinIntrinsicWidth();
                        }
                        return Float.valueOf(minIntrinsicWidth);
                    default:
                        ArrayList arrayList2 = (ArrayList) imageLoader$Builder.extras;
                        if (!arrayList2.isEmpty()) {
                            Object obj4 = arrayList2.get(0);
                            float maxIntrinsicWidth = ((ParagraphIntrinsicInfo) obj4).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                            int size2 = arrayList2.size() - 1;
                            if (1 <= size2) {
                                while (true) {
                                    Object obj5 = arrayList2.get(i2);
                                    float maxIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj5).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                                    if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                                        obj4 = obj5;
                                        maxIntrinsicWidth = maxIntrinsicWidth2;
                                    }
                                    if (i2 != size2) {
                                        i2++;
                                    }
                                }
                            }
                            obj = obj4;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo2 = (ParagraphIntrinsicInfo) obj;
                        if (paragraphIntrinsicInfo2 != null) {
                            minIntrinsicWidth = paragraphIntrinsicInfo2.intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                        }
                        return Float.valueOf(minIntrinsicWidth);
                }
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.memoryCacheLazy = ResultKt.lazy(lazyThreadSafetyMode, function0);
        final byte b2 = 1;
        this.diskCacheLazy = ResultKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$$ExternalSyntheticLambda0
            public final /* synthetic */ ImageLoader$Builder f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                float minIntrinsicWidth = CropImageView.DEFAULT_ASPECT_RATIO;
                Object obj = null;
                int i2 = 1;
                ImageLoader$Builder imageLoader$Builder = this.f$0;
                switch (b3) {
                    case 0:
                        ArrayList arrayList = (ArrayList) imageLoader$Builder.extras;
                        if (!arrayList.isEmpty()) {
                            Object obj2 = arrayList.get(0);
                            float minIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj2).intrinsics.getMinIntrinsicWidth();
                            int size = arrayList.size() - 1;
                            if (1 <= size) {
                                while (true) {
                                    Object obj3 = arrayList.get(i2);
                                    float minIntrinsicWidth3 = ((ParagraphIntrinsicInfo) obj3).intrinsics.getMinIntrinsicWidth();
                                    if (Float.compare(minIntrinsicWidth2, minIntrinsicWidth3) < 0) {
                                        obj2 = obj3;
                                        minIntrinsicWidth2 = minIntrinsicWidth3;
                                    }
                                    if (i2 != size) {
                                        i2++;
                                    }
                                }
                            }
                            obj = obj2;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                        if (paragraphIntrinsicInfo != null) {
                            minIntrinsicWidth = paragraphIntrinsicInfo.intrinsics.getMinIntrinsicWidth();
                        }
                        return Float.valueOf(minIntrinsicWidth);
                    default:
                        ArrayList arrayList2 = (ArrayList) imageLoader$Builder.extras;
                        if (!arrayList2.isEmpty()) {
                            Object obj4 = arrayList2.get(0);
                            float maxIntrinsicWidth = ((ParagraphIntrinsicInfo) obj4).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                            int size2 = arrayList2.size() - 1;
                            if (1 <= size2) {
                                while (true) {
                                    Object obj5 = arrayList2.get(i2);
                                    float maxIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj5).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                                    if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                                        obj4 = obj5;
                                        maxIntrinsicWidth = maxIntrinsicWidth2;
                                    }
                                    if (i2 != size2) {
                                        i2++;
                                    }
                                }
                            }
                            obj = obj4;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo2 = (ParagraphIntrinsicInfo) obj;
                        if (paragraphIntrinsicInfo2 != null) {
                            minIntrinsicWidth = paragraphIntrinsicInfo2.intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                        }
                        return Float.valueOf(minIntrinsicWidth);
                }
            }
        });
        ParagraphStyle paragraphStyle = textStyle2.paragraphStyle;
        AnnotatedString annotatedString3 = AnnotatedStringKt.EmptyAnnotatedString;
        ArrayList arrayList = annotatedString2.paragraphStylesOrNull;
        String str = annotatedString2.text;
        EmptyList emptyList = EmptyList.INSTANCE;
        List listSortedWith = arrayList != null ? CollectionsKt.sortedWith(arrayList, new AnnotatedString$special$$inlined$sortedBy$1((byte) 1)) : emptyList;
        ArrayList arrayList2 = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        int size = listSortedWith.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            AnnotatedString.Range range = (AnnotatedString.Range) listSortedWith.get(i2);
            AnnotatedString.Range rangeCopy$default = AnnotatedString.Range.copy$default(range, paragraphStyle.merge((ParagraphStyle) range.item), b, 14);
            Object obj = rangeCopy$default.item;
            int i4 = rangeCopy$default.end;
            int i5 = rangeCopy$default.start;
            while (i3 < i5 && !arrayDeque.isEmpty()) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayDeque.last();
                listSortedWith = listSortedWith;
                int i6 = range2.end;
                emptyList = emptyList;
                Object obj2 = range2.item;
                if (i5 < i6) {
                    arrayList2.add(new AnnotatedString.Range(i3, i5, obj2));
                    i3 = i5;
                } else {
                    int i7 = size;
                    arrayList2.add(new AnnotatedString.Range(i3, i6, obj2));
                    i3 = range2.end;
                    while (!arrayDeque.isEmpty() && i3 == ((AnnotatedString.Range) arrayDeque.last()).end) {
                        arrayDeque.removeLast();
                    }
                    size = i7;
                }
            }
            List list2 = listSortedWith;
            EmptyList emptyList2 = emptyList;
            int i8 = size;
            if (i3 < i5) {
                arrayList2.add(new AnnotatedString.Range(i3, i5, paragraphStyle));
                i3 = i5;
            }
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayDeque.lastOrNull();
            if (range3 != null) {
                int i9 = range3.end;
                Object obj3 = range3.item;
                int i10 = range3.start;
                if (i10 == i5 && i9 == i4) {
                    arrayDeque.removeLast();
                    arrayDeque.addLast(new AnnotatedString.Range(i5, i4, ((ParagraphStyle) obj3).merge((ParagraphStyle) obj)));
                } else if (i10 == i9) {
                    arrayList2.add(new AnnotatedString.Range(i10, i9, obj3));
                    arrayDeque.removeLast();
                    arrayDeque.addLast(new AnnotatedString.Range(i5, i4, obj));
                } else {
                    if (i9 < i4) {
                        Path$$ExternalSyntheticBUOutline0.m();
                        throw null;
                    }
                    arrayDeque.addLast(new AnnotatedString.Range(i5, i4, ((ParagraphStyle) obj3).merge((ParagraphStyle) obj)));
                }
            } else {
                arrayDeque.addLast(new AnnotatedString.Range(i5, i4, obj));
            }
            i2++;
            listSortedWith = list2;
            emptyList = emptyList2;
            size = i8;
            b = 0;
        }
        EmptyList emptyList3 = emptyList;
        while (i3 <= str.length() && !arrayDeque.isEmpty()) {
            AnnotatedString.Range range4 = (AnnotatedString.Range) arrayDeque.last();
            Object obj4 = range4.item;
            int i11 = range4.end;
            arrayList2.add(new AnnotatedString.Range(i3, i11, obj4));
            while (!arrayDeque.isEmpty() && i11 == ((AnnotatedString.Range) arrayDeque.last()).end) {
                arrayDeque.removeLast();
            }
            i3 = i11;
        }
        if (i3 < str.length()) {
            arrayList2.add(new AnnotatedString.Range(i3, str.length(), paragraphStyle));
        }
        if (arrayList2.isEmpty()) {
            i = 0;
            arrayList2.add(new AnnotatedString.Range(0, 0, paragraphStyle));
        } else {
            i = 0;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size2 = arrayList2.size();
        int i12 = i;
        while (i12 < size2) {
            AnnotatedString.Range range5 = (AnnotatedString.Range) arrayList2.get(i12);
            int i13 = range5.start;
            int i14 = range5.end;
            String strSubstring = i13 != i14 ? str.substring(i13, i14) : "";
            List localAnnotations = AnnotatedStringKt.getLocalAnnotations(annotatedString2, i13, i14, new SaversKt$$ExternalSyntheticLambda2((byte) 6));
            AnnotatedString annotatedString4 = new AnnotatedString(strSubstring, localAnnotations == null ? emptyList3 : localAnnotations);
            ParagraphStyle paragraphStyle2 = (ParagraphStyle) range5.item;
            if (paragraphStyle2.textDirection == 0) {
                paragraphStyle2 = new ParagraphStyle(paragraphStyle2.textAlign, paragraphStyle.textDirection, paragraphStyle2.lineHeight, paragraphStyle2.textIndent, paragraphStyle2.platformStyle, paragraphStyle2.lineHeightStyle, paragraphStyle2.lineBreak, paragraphStyle2.hyphens, paragraphStyle2.textMotion);
            }
            TextStyle textStyle3 = new TextStyle(textStyle2.spanStyle, paragraphStyle.merge(paragraphStyle2));
            List list3 = annotatedString4.annotations;
            List list4 = list3 == null ? emptyList3 : list3;
            List list5 = (List) this.defaults;
            ArrayList arrayList4 = new ArrayList(list5.size());
            int size3 = list5.size();
            int i15 = 0;
            while (i15 < size3) {
                AnnotatedString.Range range6 = (AnnotatedString.Range) list5.get(i15);
                int i16 = range6.start;
                ParagraphStyle paragraphStyle3 = paragraphStyle;
                int i17 = range6.end;
                if (AnnotatedStringKt.intersect(i13, i14, i16, i17)) {
                    if (i13 > i16 || i17 > i14) {
                        InlineClassHelperKt.throwIllegalArgumentException("placeholder can not overlap with paragraph.");
                    }
                    arrayList4.add(new AnnotatedString.Range(i16 - i13, i17 - i13, range6.item));
                }
                i15++;
                list5 = list5;
                paragraphStyle = paragraphStyle3;
            }
            arrayList3.add(new ParagraphIntrinsicInfo(new AndroidParagraphIntrinsics(strSubstring, textStyle3, list4, arrayList4, resolver, density, z), i13, i14));
            i12++;
            annotatedString2 = annotatedString;
            textStyle2 = textStyle;
            str = str;
            arrayList2 = arrayList2;
        }
        this.extras = arrayList3;
    }

    public static ArrayList resolveLyricsProviders(MutablePreferences mutablePreferences) {
        String str = (String) mutablePreferences.get(PreferenceKeysKt.LyricsProviderOrderKey);
        if (str == null) {
            str = "";
        }
        if (StringsKt.isBlank(str)) {
            List<String> defaultProviderOrder = LyricsProviderRegistry.getDefaultProviderOrder();
            ArrayList arrayList = new ArrayList();
            for (String str2 : defaultProviderOrder) {
                Map map = LyricsProviderRegistry.providerMap;
                str2.getClass();
                LyricsProvider lyricsProvider = (LyricsProvider) LyricsProviderRegistry.providerMap.get(str2);
                if (lyricsProvider != null) {
                    arrayList.add(lyricsProvider);
                }
            }
            return arrayList;
        }
        List<String> listDeserializeProviderOrder = LyricsProviderRegistry.deserializeProviderOrder(str);
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : listDeserializeProviderOrder) {
            Map map2 = LyricsProviderRegistry.providerMap;
            str3.getClass();
            LyricsProvider lyricsProvider2 = (LyricsProvider) LyricsProviderRegistry.providerMap.get(str3);
            if (lyricsProvider2 != null) {
                arrayList2.add(lyricsProvider2);
            }
        }
        return arrayList2;
    }

    public void add(Fetcher.Factory factory, ClassReference classReference) {
        ((ArrayList) this.diskCacheLazy).add(new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) factory, (Object) classReference, (byte) 0));
    }

    public CancellationHandle addAwaiter(AwaiterQueue$Awaiter awaiterQueue$Awaiter, Function0 function0) {
        int i;
        int i2;
        int i3;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        synchronized (this.application) {
            Throwable th = (Throwable) this.defaults;
            if (th != null) {
                awaiterQueue$Awaiter.resumeWithException(th);
                return NeverEqualPolicy.Empty;
            }
            AtomicInt atomicInt = (AtomicInt) this.memoryCacheLazy;
            do {
                i = atomicInt.get();
                i2 = i + 1;
            } while (!atomicInt.compareAndSet(i, i2));
            boolean z = (134217727 & i2) == 1;
            ref$IntRef.element = (i2 >>> 27) & 15;
            ((MutableObjectList) this.diskCacheLazy).add(awaiterQueue$Awaiter);
            if (z) {
                try {
                    function0.invoke();
                } catch (Throwable th2) {
                    synchronized (this.application) {
                        try {
                            if (((Throwable) this.defaults) == null) {
                                this.defaults = th2;
                                MutableObjectList mutableObjectList = (MutableObjectList) this.diskCacheLazy;
                                Object[] objArr = mutableObjectList.content;
                                int i4 = mutableObjectList._size;
                                for (int i5 = 0; i5 < i4; i5++) {
                                    ((AwaiterQueue$Awaiter) objArr[i5]).resumeWithException(th2);
                                }
                                ((MutableObjectList) this.diskCacheLazy).clear();
                                AtomicInt atomicInt2 = (AtomicInt) this.memoryCacheLazy;
                                do {
                                    i3 = atomicInt2.get();
                                } while (!atomicInt2.compareAndSet(i3, ((((i3 >>> 27) & 15) + 1) & 15) << 27));
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }
            return new CallbackWrapper(new GapComposer$$ExternalSyntheticLambda0(awaiterQueue$Awaiter, this, ref$IntRef, (byte) 9));
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    public Bidi analyzeBidi(int i) {
        Bidi bidi;
        Layout layout = (Layout) this.application;
        ArrayList arrayList = (ArrayList) this.defaults;
        ArrayList arrayList2 = (ArrayList) this.memoryCacheLazy;
        boolean[] zArr = (boolean[]) this.diskCacheLazy;
        if (zArr[i]) {
            return (Bidi) arrayList2.get(i);
        }
        int iIntValue = i == 0 ? 0 : ((Number) arrayList.get(i - 1)).intValue();
        int iIntValue2 = ((Number) arrayList.get(i)).intValue();
        int i2 = iIntValue2 - iIntValue;
        char[] cArr = (char[]) this.extras;
        if (cArr == null || cArr.length < i2) {
            cArr = new char[i2];
        }
        char[] cArr2 = cArr;
        TextUtils.getChars(layout.getText(), iIntValue, iIntValue2, cArr2, 0);
        if (Bidi.requiresBidi(cArr2, 0, i2)) {
            bidi = new Bidi(cArr2, 0, null, 0, i2, layout.getParagraphDirection(layout.getLineForOffset(getParagraphStart(i))) == -1 ? 1 : 0);
            if (bidi.getRunCount() == 1) {
                bidi = null;
            }
        } else {
            bidi = null;
        }
        arrayList2.set(i, bidi);
        zArr[i] = true;
        if (bidi != null) {
            char[] cArr3 = (char[]) this.extras;
            cArr2 = cArr2 == cArr3 ? null : cArr3;
        }
        this.extras = cArr2;
        return bidi;
    }

    public RealImageLoader build() {
        Context context = (Context) this.application;
        ImageRequest.Defaults defaultsCopy$default = ImageRequest.Defaults.copy$default((ImageRequest.Defaults) this.defaults, new Extras(IntMath.toImmutableMap(((Extras.Builder) this.extras).data)), 8191);
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(new RealImageLoaderKt$$ExternalSyntheticLambda0((byte) 1));
        SynchronizedLazyImpl synchronizedLazyImpl2 = (SynchronizedLazyImpl) this.memoryCacheLazy;
        if (synchronizedLazyImpl2 == null) {
            synchronizedLazyImpl2 = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 0, this));
        }
        InitializedLazyImpl initializedLazyImpl = (InitializedLazyImpl) this.diskCacheLazy;
        Lazy synchronizedLazyImpl3 = initializedLazyImpl == null ? new SynchronizedLazyImpl(new RealImageLoaderKt$$ExternalSyntheticLambda0((byte) 2)) : initializedLazyImpl;
        EmptyList emptyList = EmptyList.INSTANCE;
        return new RealImageLoader(new RealImageLoader.Options(context, defaultsCopy$default, synchronizedLazyImpl, synchronizedLazyImpl2, synchronizedLazyImpl3, new ComponentRegistry(emptyList, emptyList, emptyList, emptyList, emptyList)));
    }

    public TaskStackBuilder createTaskStackBuilder() {
        ArrayList arrayList = (ArrayList) this.extras;
        Intent intent = (Intent) this.memoryCacheLazy;
        NavGraph navGraph = (NavGraph) this.diskCacheLazy;
        if (arrayList.isEmpty()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You must call setDestination() or addDestination() before constructing the deep link");
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
        int size = arrayList.size();
        NavDestination navDestination = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NavDeepLinkBuilder$DeepLinkDestination navDeepLinkBuilder$DeepLinkDestination = (NavDeepLinkBuilder$DeepLinkDestination) obj;
            int i2 = navDeepLinkBuilder$DeepLinkDestination.destinationId;
            Bundle bundle = navDeepLinkBuilder$DeepLinkDestination.arguments;
            NavDestination navDestinationFindDestination = findDestination(i2);
            if (navDestinationFindDestination == null) {
                int i3 = NavDestination.$r8$clinit;
                DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Navigation destination ", FileSystemsKt.getDisplayName((NavContext) this.defaults, i2), " cannot be found in the navigation graph ", navGraph);
                return null;
            }
            for (int i4 : navDestinationFindDestination.buildDeepLinkIds(navDestination)) {
                arrayList2.add(Integer.valueOf(i4));
                arrayList3.add(bundle);
            }
            navDestination = navDestinationFindDestination;
        }
        intent.putExtra("android-support-nav:controller:deepLinkIds", CollectionsKt.toIntArray(arrayList2));
        intent.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", arrayList3);
        TaskStackBuilder taskStackBuilder = new TaskStackBuilder((Context) this.application);
        Intent intent2 = new Intent(intent);
        ComponentName component = intent2.getComponent();
        if (component == null) {
            component = intent2.resolveActivity(taskStackBuilder.mSourceContext.getPackageManager());
        }
        if (component != null) {
            taskStackBuilder.addParentStack(component);
        }
        ArrayList arrayList4 = taskStackBuilder.mIntents;
        arrayList4.add(intent2);
        int size2 = arrayList4.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Intent intent3 = (Intent) arrayList4.get(i5);
            if (intent3 != null) {
                intent3.putExtra("android-support-nav:controller:deepLinkIntent", intent);
            }
        }
        return taskStackBuilder;
    }

    public NavDestination findDestination(int i) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast((NavGraph) this.diskCacheLazy);
        while (!arrayDeque.isEmpty()) {
            NavDestination navDestination = (NavDestination) arrayDeque.removeFirst();
            if (navDestination.impl.size == i) {
                return navDestination;
            }
            if (navDestination instanceof NavGraph) {
                Iterator it = ((NavGraph) navDestination).iterator();
                while (true) {
                    NavGraphImpl$iterator$1 navGraphImpl$iterator$1 = (NavGraphImpl$iterator$1) it;
                    if (navGraphImpl$iterator$1.hasNext()) {
                        arrayDeque.addLast((NavDestination) navGraphImpl$iterator$1.next());
                    }
                }
            }
        }
        return null;
    }

    public void flushAndDispatchAwaiters(Function1 function1) {
        int i;
        synchronized (this.application) {
            try {
                MutableObjectList mutableObjectList = (MutableObjectList) this.diskCacheLazy;
                this.diskCacheLazy = (MutableObjectList) this.extras;
                this.extras = mutableObjectList;
                AtomicInt atomicInt = (AtomicInt) this.memoryCacheLazy;
                do {
                    i = atomicInt.get();
                } while (!atomicInt.compareAndSet(i, ((((i >>> 27) & 15) + 1) & 15) << 27));
                int i2 = mutableObjectList._size;
                for (int i3 = 0; i3 < i2; i3++) {
                    function1.invoke(mutableObjectList.get(i3));
                }
                mutableObjectList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List getCues(long j) {
        TtmlNode ttmlNode = (TtmlNode) this.application;
        Map map = (Map) this.memoryCacheLazy;
        HashMap map2 = (HashMap) this.diskCacheLazy;
        HashMap map3 = (HashMap) this.extras;
        ArrayList arrayList = new ArrayList();
        ttmlNode.traverseForImage(j, ttmlNode.regionId, arrayList);
        TreeMap treeMap = new TreeMap();
        ttmlNode.traverseForText(j, false, ttmlNode.regionId, treeMap);
        ttmlNode.traverseForStyle(j, map, map2, ttmlNode.regionId, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Pair pair = (Pair) obj;
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) map2.get(pair.first);
                ttmlRegion.getClass();
                arrayList2.add(new Cue(null, null, null, bitmapDecodeByteArray, ttmlRegion.line, 0, ttmlRegion.lineAnchor, ttmlRegion.position, 0, Integer.MIN_VALUE, -3.4028235E38f, ttmlRegion.width, ttmlRegion.height, false, -16777216, ttmlRegion.verticalType, CropImageView.DEFAULT_ASPECT_RATIO, 0));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) map2.get(entry.getKey());
            ttmlRegion2.getClass();
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            CharSequence charSequence = builder.text;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), (CharSequence) "");
            }
            for (int i2 = 0; i2 < spannableStringBuilder.length(); i2++) {
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i3 = i2 + 1;
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
                if (spannableStringBuilder.charAt(i6) == '\n') {
                    int i7 = i6 + 1;
                    if (spannableStringBuilder.charAt(i7) == ' ') {
                        spannableStringBuilder.delete(i7, i6 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i8 = 0; i8 < spannableStringBuilder.length() - 1; i8++) {
                if (spannableStringBuilder.charAt(i8) == ' ') {
                    int i9 = i8 + 1;
                    if (spannableStringBuilder.charAt(i9) == '\n') {
                        spannableStringBuilder.delete(i8, i9);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            float f = ttmlRegion2.line;
            int i10 = ttmlRegion2.lineType;
            builder.line = f;
            builder.lineType = i10;
            builder.lineAnchor = ttmlRegion2.lineAnchor;
            builder.position = ttmlRegion2.position;
            builder.size = ttmlRegion2.width;
            float f2 = ttmlRegion2.textSize;
            int i11 = ttmlRegion2.textSizeType;
            builder.textSize = f2;
            builder.textSizeType = i11;
            builder.verticalType = ttmlRegion2.verticalType;
            arrayList2.add(builder.build());
        }
        return arrayList2;
    }

    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = ((MediaLibraryServiceLegacyStub) this.diskCacheLazy).curConnection;
        if (mediaBrowserServiceCompat$ConnectionRecord != null) {
            return mediaBrowserServiceCompat$ConnectionRecord.browserInfo;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        return null;
    }

    public float getDownstreamHorizontal(int i, boolean z) {
        Layout layout = (Layout) this.application;
        int lineEnd = layout.getLineEnd(layout.getLineForOffset(i));
        if (i > lineEnd) {
            i = lineEnd;
        }
        return z ? layout.getPrimaryHorizontal(i) : layout.getSecondaryHorizontal(i);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long getEventTime(int i) {
        return ((long[]) this.defaults)[i];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return ((long[]) this.defaults).length;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        ArrayList arrayList = (ArrayList) this.extras;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((ParagraphIntrinsicInfo) arrayList.get(i)).intrinsics.getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    public float getHorizontalPosition(int i, boolean z, boolean z2) {
        int i2;
        int i3;
        Layout layout = (Layout) this.application;
        if (!z2) {
            return getDownstreamHorizontal(i, z);
        }
        int lineForOffset = StaticLayoutFactory.getLineForOffset(layout, i, z2);
        int lineStart = layout.getLineStart(lineForOffset);
        int lineEnd = layout.getLineEnd(lineForOffset);
        if (i != lineStart && i != lineEnd) {
            return getDownstreamHorizontal(i, z);
        }
        if (i == 0 || i == layout.getText().length()) {
            return getDownstreamHorizontal(i, z);
        }
        int paragraphForOffset = getParagraphForOffset(i, z2);
        boolean z3 = layout.getParagraphDirection(layout.getLineForOffset(getParagraphStart(paragraphForOffset))) == -1;
        int iLineEndToVisibleEnd = lineEndToVisibleEnd(lineEnd, lineStart);
        int paragraphStart = getParagraphStart(paragraphForOffset);
        int i4 = lineStart - paragraphStart;
        int i5 = iLineEndToVisibleEnd - paragraphStart;
        Bidi bidiAnalyzeBidi = analyzeBidi(paragraphForOffset);
        Bidi bidiCreateLineBidi = bidiAnalyzeBidi != null ? bidiAnalyzeBidi.createLineBidi(i4, i5) : null;
        if (bidiCreateLineBidi == null || bidiCreateLineBidi.getRunCount() == 1) {
            boolean zIsRtlCharAt = layout.isRtlCharAt(lineStart);
            if (z || z3 == zIsRtlCharAt) {
                z3 = !z3;
            }
            return i == lineStart ? z3 : !z3 ? layout.getLineLeft(lineForOffset) : layout.getLineRight(lineForOffset);
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        LayoutHelper$BidiRun[] layoutHelper$BidiRunArr = new LayoutHelper$BidiRun[runCount];
        for (int i6 = 0; i6 < runCount; i6++) {
            layoutHelper$BidiRunArr[i6] = new LayoutHelper$BidiRun(bidiCreateLineBidi.getRunStart(i6) + lineStart, bidiCreateLineBidi.getRunLevel(i6) % 2 == 1, bidiCreateLineBidi.getRunLimit(i6) + lineStart);
        }
        int runCount2 = bidiCreateLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i7 = 0; i7 < runCount2; i7++) {
            bArr[i7] = (byte) bidiCreateLineBidi.getRunLevel(i7);
        }
        Bidi.reorderVisually(bArr, 0, layoutHelper$BidiRunArr, 0, runCount);
        if (i == lineStart) {
            int i8 = 0;
            while (true) {
                if (i8 >= runCount) {
                    i3 = -1;
                    break;
                }
                if (layoutHelper$BidiRunArr[i8].start == i) {
                    i3 = i8;
                    break;
                }
                i8++;
            }
            boolean z4 = (z || z3 == layoutHelper$BidiRunArr[i3].isRtl) ? !z3 : z3;
            if (i3 == 0 && z4) {
                return layout.getLineLeft(lineForOffset);
            }
            if (i3 != runCount - 1 || z4) {
                return z4 ? layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i3 - 1].start) : layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i3 + 1].start);
            }
            return layout.getLineRight(lineForOffset);
        }
        int iLineEndToVisibleEnd2 = i > iLineEndToVisibleEnd ? lineEndToVisibleEnd(i, lineStart) : i;
        int i9 = 0;
        while (true) {
            if (i9 >= runCount) {
                i2 = -1;
                break;
            }
            if (layoutHelper$BidiRunArr[i9].end == iLineEndToVisibleEnd2) {
                i2 = i9;
                break;
            }
            i9++;
        }
        boolean z5 = (z || z3 == layoutHelper$BidiRunArr[i2].isRtl) ? z3 : !z3;
        if (i2 == 0 && z5) {
            return layout.getLineLeft(lineForOffset);
        }
        if (i2 != runCount - 1 || z5) {
            return z5 ? layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i2 - 1].end) : layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i2 + 1].end);
        }
        return layout.getLineRight(lineForOffset);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a7, code lost:
    
        if (r10 == r7) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getLyrics(MediaMetadata mediaMetadata, ContinuationImpl continuationImpl) {
        LyricsHelper$getLyrics$1 lyricsHelper$getLyrics$1;
        if (continuationImpl instanceof LyricsHelper$getLyrics$1) {
            lyricsHelper$getLyrics$1 = (LyricsHelper$getLyrics$1) continuationImpl;
            int i = lyricsHelper$getLyrics$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                lyricsHelper$getLyrics$1.label = i - Integer.MIN_VALUE;
            } else {
                lyricsHelper$getLyrics$1 = new LyricsHelper$getLyrics$1(this, continuationImpl);
            }
        } else {
            lyricsHelper$getLyrics$1 = new LyricsHelper$getLyrics$1(this, continuationImpl);
        }
        Object objFirst = lyricsHelper$getLyrics$1.result;
        int i2 = lyricsHelper$getLyrics$1.label;
        byte b = 2;
        boolean zIsCurrentlyConnected = true;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    mediaMetadata = lyricsHelper$getLyrics$1.L$0;
                    ResultKt.throwOnFailure(objFirst);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objFirst);
                }
                LyricsWithProvider lyricsWithProvider = (LyricsWithProvider) objFirst;
                return lyricsWithProvider == null ? new LyricsWithProvider("LYRICS_NOT_FOUND", "") : lyricsWithProvider;
            }
            ResultKt.throwOnFailure(objFirst);
            StandaloneCoroutine standaloneCoroutine = (StandaloneCoroutine) this.extras;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            List list = (List) ((LruCache) this.diskCacheLazy).get(mediaMetadata.id);
            LyricsResult lyricsResult = list != null ? (LyricsResult) CollectionsKt.firstOrNull(list) : null;
            if (lyricsResult != null) {
                return new LyricsWithProvider(lyricsResult.lyrics, lyricsResult.providerName);
            }
            LyricsHelper$special$$inlined$map$1 lyricsHelper$special$$inlined$map$1 = new LyricsHelper$special$$inlined$map$1(UtilsKt.getDataStore((Context) this.application).getData(), this, b);
            lyricsHelper$getLyrics$1.L$0 = mediaMetadata;
            lyricsHelper$getLyrics$1.label = 1;
            objFirst = StateFlowKt.first(lyricsHelper$special$$inlined$map$1, lyricsHelper$getLyrics$1);
            if (objFirst != coroutineSingletons) {
            }
            return coroutineSingletons;
            zIsCurrentlyConnected = ((NetworkConnectivityObserver) this.defaults).isCurrentlyConnected();
        } catch (Exception unused) {
        }
        List list2 = (List) objFirst;
        if (!zIsCurrentlyConnected) {
            return new LyricsWithProvider("LYRICS_NOT_FOUND", "");
        }
        QueueMenuKt$QueueMenu$7$1$1$1 queueMenuKt$QueueMenu$7$1$1$1 = new QueueMenuKt$QueueMenu$7$1$1$1(mediaMetadata, list2, this, (Continuation) null);
        lyricsHelper$getLyrics$1.L$0 = null;
        lyricsHelper$getLyrics$1.label = 2;
        objFirst = AwaitKt.withTimeoutOrNull(25000L, queueMenuKt$QueueMenu$7$1$1$1, lyricsHelper$getLyrics$1);
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return ((Number) ((Lazy) this.diskCacheLazy).getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return ((Number) ((Lazy) this.memoryCacheLazy).getValue()).floatValue();
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        long[] jArr = (long[]) this.defaults;
        int iBinarySearchCeil = Util.binarySearchCeil(jArr, j, false);
        if (iBinarySearchCeil < jArr.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    public int getParagraphForOffset(int i, boolean z) {
        ArrayList arrayList = (ArrayList) this.defaults;
        int iBinarySearch$default = CollectionsKt__IterablesKt.binarySearch$default(arrayList, Integer.valueOf(i));
        int i2 = iBinarySearch$default < 0 ? -(iBinarySearch$default + 1) : iBinarySearch$default + 1;
        if (z && i2 > 0) {
            int i3 = i2 - 1;
            if (i == ((Number) arrayList.get(i3)).intValue()) {
                return i3;
            }
        }
        return i2;
    }

    public int getParagraphStart(int i) {
        if (i == 0) {
            return 0;
        }
        return ((Number) ((ArrayList) this.defaults).get(i - 1)).intValue();
    }

    public int lineEndToVisibleEnd(int i, int i2) {
        while (i > i2) {
            char cCharAt = ((Layout) this.application).getText().charAt(i - 1);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != 5760 && ((Intrinsics.compare((int) cCharAt, 8192) < 0 || Intrinsics.compare((int) cCharAt, 8202) > 0 || cCharAt == 8199) && cCharAt != 8287 && cCharAt != 12288)) {
                return i;
            }
            i--;
        }
        return i;
    }

    public Supplier loadSupplier(int i) {
        Supplier exoPlayer$Builder$$ExternalSyntheticLambda0;
        HashMap map = (HashMap) this.defaults;
        Supplier supplier = (Supplier) map.get(Integer.valueOf(i));
        if (supplier != null) {
            return supplier;
        }
        final DataSource.Factory factory = (DataSource.Factory) this.diskCacheLazy;
        factory.getClass();
        if (i != 0) {
            final byte b = 1;
            if (i != 1) {
                final byte b2 = 2;
                if (i != 2) {
                    final byte b3 = 3;
                    if (i == 3) {
                        exoPlayer$Builder$$ExternalSyntheticLambda0 = new ExoPlayer$Builder$$ExternalSyntheticLambda0(b3, Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(MediaSource$Factory.class));
                    } else {
                        if (i != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unrecognized contentType: "));
                            return null;
                        }
                        exoPlayer$Builder$$ExternalSyntheticLambda0 = new Supplier() { // from class: androidx.media3.exoplayer.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda0
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                byte b4 = b3;
                                DataSource.Factory factory2 = factory;
                                Object obj = this;
                                switch (b4) {
                                    case 0:
                                        return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                                    case 1:
                                        return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                                    case 2:
                                        return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                                    default:
                                        return new ProgressiveMediaSource.Factory(factory2, (ExtractorsFactory) ((ImageLoader$Builder) obj).application);
                                }
                            }
                        };
                    }
                } else {
                    final GenericDeclaration genericDeclarationAsSubclass = Class.forName("androidx.media3.exoplayer.hls.HlsMediaSource$Factory").asSubclass(MediaSource$Factory.class);
                    exoPlayer$Builder$$ExternalSyntheticLambda0 = new Supplier() { // from class: androidx.media3.exoplayer.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda0
                        @Override // com.google.common.base.Supplier
                        public final Object get() {
                            byte b4 = b2;
                            DataSource.Factory factory2 = factory;
                            Object obj = genericDeclarationAsSubclass;
                            switch (b4) {
                                case 0:
                                    return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                                case 1:
                                    return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                                case 2:
                                    return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                                default:
                                    return new ProgressiveMediaSource.Factory(factory2, (ExtractorsFactory) ((ImageLoader$Builder) obj).application);
                            }
                        }
                    };
                }
            } else {
                final GenericDeclaration genericDeclarationAsSubclass2 = Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSource$Factory.class);
                exoPlayer$Builder$$ExternalSyntheticLambda0 = new Supplier() { // from class: androidx.media3.exoplayer.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda0
                    @Override // com.google.common.base.Supplier
                    public final Object get() {
                        byte b4 = b;
                        DataSource.Factory factory2 = factory;
                        Object obj = genericDeclarationAsSubclass2;
                        switch (b4) {
                            case 0:
                                return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                            case 1:
                                return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                            case 2:
                                return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                            default:
                                return new ProgressiveMediaSource.Factory(factory2, (ExtractorsFactory) ((ImageLoader$Builder) obj).application);
                        }
                    }
                };
            }
        } else {
            final GenericDeclaration genericDeclarationAsSubclass3 = Class.forName("androidx.media3.exoplayer.dash.DashMediaSource$Factory").asSubclass(MediaSource$Factory.class);
            final byte b4 = 0;
            exoPlayer$Builder$$ExternalSyntheticLambda0 = new Supplier() { // from class: androidx.media3.exoplayer.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    byte b5 = b4;
                    DataSource.Factory factory2 = factory;
                    Object obj = genericDeclarationAsSubclass3;
                    switch (b5) {
                        case 0:
                            return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                        case 1:
                            return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                        case 2:
                            return DefaultMediaSourceFactory.newInstance((Class) obj, factory2);
                        default:
                            return new ProgressiveMediaSource.Factory(factory2, (ExtractorsFactory) ((ImageLoader$Builder) obj).application);
                    }
                }
            };
        }
        map.put(Integer.valueOf(i), exoPlayer$Builder$$ExternalSyntheticLambda0);
        return exoPlayer$Builder$$ExternalSyntheticLambda0;
    }

    public void set(Object obj, String str) {
        str.getClass();
        ((LinkedHashMap) this.application).put(str, obj);
        MutableStateFlow mutableStateFlow = (MutableStateFlow) ((LinkedHashMap) this.memoryCacheLazy).get(str);
        if (mutableStateFlow != null) {
            ((StateFlowImpl) mutableStateFlow).setValue(obj);
        }
        MutableStateFlow mutableStateFlow2 = (MutableStateFlow) ((LinkedHashMap) this.diskCacheLazy).get(str);
        if (mutableStateFlow2 != null) {
            ((StateFlowImpl) mutableStateFlow2).setValue(obj);
        }
    }

    public void verifyAllDestinations() {
        ArrayList arrayList = (ArrayList) this.extras;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            int i2 = ((NavDeepLinkBuilder$DeepLinkDestination) obj).destinationId;
            if (findDestination(i2) == null) {
                int i3 = NavDestination.$r8$clinit;
                StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Navigation destination ", FileSystemsKt.getDisplayName((NavContext) this.defaults, i2), " cannot be found in the navigation graph ");
                sbM4m.append((NavGraph) this.diskCacheLazy);
                throw new IllegalArgumentException(sbM4m.toString());
            }
        }
    }

    public void add(FileMapper fileMapper, ClassReference classReference) {
        ((ArrayList) this.defaults).add(new kotlin.Pair(fileMapper, classReference));
    }

    public ImageLoader$Builder(Map map) {
        map.getClass();
        this.application = new LinkedHashMap(map);
        this.defaults = new LinkedHashMap();
        this.memoryCacheLazy = new LinkedHashMap();
        this.diskCacheLazy = new LinkedHashMap();
        this.extras = new ComponentActivity$$ExternalSyntheticLambda5((byte) 2, this);
    }

    public ImageLoader$Builder() {
        this.application = new Object();
        this.memoryCacheLazy = new AtomicInt(0);
        this.diskCacheLazy = new MutableObjectList();
        this.extras = new MutableObjectList();
    }

    public ImageLoader$Builder(Context context, NetworkConnectivityObserver networkConnectivityObserver) {
        networkConnectivityObserver.getClass();
        this.application = context;
        this.defaults = networkConnectivityObserver;
        this.memoryCacheLazy = StateFlowKt.distinctUntilChanged(new LyricsHelper$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), this, (byte) 0));
        this.diskCacheLazy = new LruCache(3);
    }

    public ImageLoader$Builder(Layout layout) {
        this.application = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iIndexOf$default = StringsKt.indexOf$default(((Layout) this.application).getText(), '\n', length, 4);
            length = iIndexOf$default < 0 ? ((Layout) this.application).getText().length() : iIndexOf$default + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < ((Layout) this.application).getText().length());
        this.defaults = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        this.memoryCacheLazy = arrayList2;
        this.diskCacheLazy = new boolean[((ArrayList) this.defaults).size()];
        ((ArrayList) this.defaults).size();
    }

    public ImageLoader$Builder(TtmlNode ttmlNode, HashMap map, HashMap map2, HashMap map3) {
        this.application = ttmlNode;
        this.diskCacheLazy = map2;
        this.extras = map3;
        this.memoryCacheLazy = Collections.unmodifiableMap(map);
        TreeSet treeSet = new TreeSet();
        int i = 0;
        ttmlNode.getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        this.defaults = jArr;
    }

    public ImageLoader$Builder(RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0) {
        this.application = null;
        this.defaults = null;
        this.memoryCacheLazy = null;
        this.diskCacheLazy = null;
        this.extras = null;
    }

    public ImageLoader$Builder(NavHostController navHostController) {
        Intent launchIntentForPackage;
        navHostController.getClass();
        Context context = navHostController.context;
        context.getClass();
        this.application = context;
        this.defaults = new NavContext(context, 0);
        Activity activity = (Activity) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(context, new RoomDatabase$$ExternalSyntheticLambda2((byte) 7)), new RoomDatabase$$ExternalSyntheticLambda2((byte) 8)));
        if (activity != null) {
            launchIntentForPackage = new Intent(context, activity.getClass());
        } else {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent();
            }
        }
        launchIntentForPackage.addFlags(268468224);
        this.memoryCacheLazy = launchIntentForPackage;
        this.extras = new ArrayList();
        this.diskCacheLazy = navHostController.impl.getGraph$navigation_runtime_release();
    }

    public ImageLoader$Builder(Context context) {
        this.application = context.getApplicationContext();
        this.defaults = ImageRequest.Defaults.DEFAULT;
        this.memoryCacheLazy = null;
        this.diskCacheLazy = null;
        this.extras = new Extras.Builder();
    }

    public ImageLoader$Builder(ComponentRegistry componentRegistry) {
        this.application = CollectionsKt.toMutableList((Collection) componentRegistry.interceptors);
        this.defaults = CollectionsKt.toMutableList((Collection) componentRegistry.mappers);
        this.memoryCacheLazy = CollectionsKt.toMutableList((Collection) componentRegistry.keyers);
        List list = (List) componentRegistry.fetcherFactories$delegate.getValue();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new RoomDatabase$$ExternalSyntheticLambda0((byte) 29, (kotlin.Pair) it.next()));
        }
        this.diskCacheLazy = arrayList;
        List list2 = (List) componentRegistry.decoderFactories$delegate.getValue();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new ComponentRegistry$Builder$$ExternalSyntheticLambda1((Decoder.Factory) it2.next(), (byte) 0));
        }
        this.extras = arrayList2;
    }

    public ImageLoader$Builder(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub) {
        this.extras = mediaLibraryServiceLegacyStub;
        this.diskCacheLazy = mediaLibraryServiceLegacyStub;
        this.application = new ArrayList();
    }

    public ImageLoader$Builder(ExtractorsFactory extractorsFactory, CueDecoder cueDecoder) {
        this.application = extractorsFactory;
        this.extras = cueDecoder;
        this.defaults = new HashMap();
        this.memoryCacheLazy = new HashMap();
    }
}
