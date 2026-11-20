package com.metrolist.music.ui.component;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.palette.graphics.Palette;
import coil3.Image;
import coil3.ImageLoader$Builder;
import coil3.RealImageLoader;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OriginalLyricsKt$OriginalLyrics$13$9$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $coverUrl;
    public final /* synthetic */ SnapshotStateList $paletteColors;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OriginalLyricsKt$OriginalLyrics$13$9$1(Context context, String str, SnapshotStateList snapshotStateList, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$context = context;
        this.$coverUrl = str;
        this.$paletteColors = snapshotStateList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new OriginalLyricsKt$OriginalLyrics$13$9$1(this.$coverUrl, this.$context, this.$paletteColors, continuation, (byte) 0);
            case 1:
                return new OriginalLyricsKt$OriginalLyrics$13$9$1(this.$context, this.$coverUrl, this.$paletteColors, continuation, (byte) 1);
            case 2:
                return new OriginalLyricsKt$OriginalLyrics$13$9$1(this.$coverUrl, this.$context, this.$paletteColors, continuation, (byte) 2);
            default:
                return new OriginalLyricsKt$OriginalLyrics$13$9$1(this.$context, this.$coverUrl, this.$paletteColors, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((OriginalLyricsKt$OriginalLyrics$13$9$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objExecute;
        Bitmap bitmap$default;
        Object objExecute2;
        byte b = this.$r8$classId;
        String str = this.$coverUrl;
        Context context = this.$context;
        SnapshotStateList snapshotStateList = this.$paletteColors;
        int i = 0;
        Object[] objArr = 0;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        final byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                String str2 = this.$coverUrl;
                if (str2 == null) {
                    return unit;
                }
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                OriginalLyricsKt$OriginalLyrics$13$9$1 originalLyricsKt$OriginalLyrics$13$9$1 = new OriginalLyricsKt$OriginalLyrics$13$9$1(this.$context, str2, this.$paletteColors, (Continuation) null, (byte) 3);
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler, originalLyricsKt$OriginalLyrics$13$9$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                try {
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        RealImageLoader realImageLoaderBuild = new ImageLoader$Builder(context).build();
                        ImageRequest.Builder builder = new ImageRequest.Builder(context);
                        builder.data = str;
                        ImageRequests_androidKt.allowHardware(builder);
                        ImageRequest imageRequestBuild = builder.build();
                        this.label = true;
                        objExecute = realImageLoaderBuild.execute(imageRequestBuild, this);
                        if (objExecute == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objExecute = obj;
                    }
                    Image image = ((ImageResult) objExecute).getImage();
                    bitmap$default = image != null ? UriKt.toBitmap$default(image) : null;
                    if (bitmap$default == null) {
                        return unit;
                    }
                    List listUnmodifiableList = Collections.unmodifiableList(new Palette.Builder(bitmap$default).generate().mSwatches);
                    listUnmodifiableList.getClass();
                    List listSortedWith = CollectionsKt.sortedWith(listUnmodifiableList, new Comparator() { // from class: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$13$9$1$1$invokeSuspend$$inlined$sortedByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj2, Object obj3) {
                            switch (b2) {
                                case 0:
                                    break;
                            }
                            return Integer.valueOf(((Palette.Swatch) obj3).mPopulation).compareTo(Integer.valueOf(((Palette.Swatch) obj2).mPopulation));
                        }
                    });
                    snapshotStateList.clear();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSortedWith, 10));
                    Iterator it = listSortedWith.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Color(((long) ((Palette.Swatch) it.next()).mRgb) << 32));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj2 = arrayList.get(i2);
                        i2++;
                        float[] fArr = new float[3];
                        android.graphics.Color.colorToHSV(ColorKt.m498toArgb8_81llA(((Color) obj2).value), fArr);
                        if (fArr[1] > 0.2f) {
                            arrayList2.add(obj2);
                        }
                    }
                    snapshotStateList.addAll(CollectionsKt.take(arrayList2, 5));
                    return unit;
                } catch (Exception unused) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                    return unit;
                }
            case 2:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                String str3 = this.$coverUrl;
                if (str3 == null) {
                    return unit;
                }
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                OriginalLyricsKt$OriginalLyrics$13$9$1 originalLyricsKt$OriginalLyrics$13$9$2 = new OriginalLyricsKt$OriginalLyrics$13$9$1(this.$context, str3, this.$paletteColors, (Continuation) null, (byte) 1);
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler2, originalLyricsKt$OriginalLyrics$13$9$2, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z4 = this.label;
                try {
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        RealImageLoader realImageLoaderBuild2 = new ImageLoader$Builder(context).build();
                        ImageRequest.Builder builder2 = new ImageRequest.Builder(context);
                        builder2.data = str;
                        ImageRequests_androidKt.allowHardware(builder2);
                        ImageRequest imageRequestBuild2 = builder2.build();
                        this.label = true;
                        objExecute2 = realImageLoaderBuild2.execute(imageRequestBuild2, this);
                        if (objExecute2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objExecute2 = obj;
                    }
                    Image image2 = ((ImageResult) objExecute2).getImage();
                    bitmap$default = image2 != null ? UriKt.toBitmap$default(image2) : null;
                    if (bitmap$default == null) {
                        return unit;
                    }
                    List listUnmodifiableList2 = Collections.unmodifiableList(new Palette.Builder(bitmap$default).generate().mSwatches);
                    listUnmodifiableList2.getClass();
                    final Object[] objArr2 = objArr == true ? 1 : 0;
                    List listSortedWith2 = CollectionsKt.sortedWith(listUnmodifiableList2, new Comparator() { // from class: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$13$9$1$1$invokeSuspend$$inlined$sortedByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj3, Object obj4) {
                            switch (objArr2) {
                                case 0:
                                    break;
                            }
                            return Integer.valueOf(((Palette.Swatch) obj4).mPopulation).compareTo(Integer.valueOf(((Palette.Swatch) obj3).mPopulation));
                        }
                    });
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSortedWith2, 10));
                    Iterator it2 = listSortedWith2.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(new Color(((long) ((Palette.Swatch) it2.next()).mRgb) << 32));
                    }
                    ArrayList arrayList4 = new ArrayList();
                    int size2 = arrayList3.size();
                    while (i < size2) {
                        Object obj3 = arrayList3.get(i);
                        i++;
                        float[] fArr2 = new float[3];
                        android.graphics.Color.colorToHSV(ColorKt.m498toArgb8_81llA(((Color) obj3).value), fArr2);
                        if (fArr2[1] > 0.2f) {
                            arrayList4.add(obj3);
                        }
                    }
                    snapshotStateList.clear();
                    snapshotStateList.addAll(CollectionsKt.take(arrayList4, 5));
                    return unit;
                } catch (Exception unused2) {
                    return unit;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OriginalLyricsKt$OriginalLyrics$13$9$1(String str, Context context, SnapshotStateList snapshotStateList, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$coverUrl = str;
        this.$context = context;
        this.$paletteColors = snapshotStateList;
    }
}
