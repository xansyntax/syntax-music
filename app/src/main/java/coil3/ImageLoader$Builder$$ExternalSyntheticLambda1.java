package coil3;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import coil3.decode.BitmapFactoryDecoder;
import coil3.decode.DecodeResult;
import coil3.decode.ExifData;
import coil3.decode.ExifInterfaceInputStream;
import coil3.decode.ExifUtils;
import coil3.disk.RealDiskCache;
import coil3.memory.RealMemoryCache;
import coil3.memory.RealStrongMemoryCache;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.transition.Transition;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.accompanist.drawablepainter.DrawablePainter;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda3;
import com.metrolist.music.MainActivity;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.recognition.RecognitionForegroundService;
import com.metrolist.music.ui.component.LensController;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.Material3SettingsItem;
import com.metrolist.music.ui.screens.CrashActivity;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.potoken.PoTokenGenerator;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel$syncAllLibrary$1$1;
import com.metrolist.music.viewmodels.OnlinePlaylistViewModel;
import com.metrolist.music.widget.MetrolistWidgetManager;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeEffectNode$areaPreDrawListener$2$1;
import dev.chrisbanes.haze.HazeSourceNode;
import io.ktor.client.engine.okhttp.OkHttpEngineKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.http.ContentType;
import io.ktor.http.cio.CIOHeaders;
import io.ktor.http.cio.MultipartEvent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.openapi.GenericElementEncoder;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.StatelessHmacNonceManager;
import io.ktor.util.collections.ConcurrentSetKt;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.PeekSource;
import okio.PriorityQueue;
import okio.RealBufferedSource;
import okio.RealBufferedSource.AnonymousClass1;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ImageLoader$Builder$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ImageLoader$Builder$$ExternalSyntheticLambda1(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        int largeMemoryClass;
        double d;
        ExifData exifData;
        boolean z;
        RealBufferedSource realBufferedSource;
        Bitmap bitmapCreateBitmap;
        int i;
        int iMin;
        double dMax;
        int intValue;
        int intValue2;
        int i2;
        StandaloneCoroutine standaloneCoroutine;
        byte b = this.$r8$classId;
        Object[] objArr = 0;
        byte b2 = 1;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = null;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                Context context = (Context) ((ImageLoader$Builder) obj).application;
                double d2 = 0.2d;
                try {
                    Object systemService = context.getSystemService((Class<Object>) ActivityManager.class);
                    systemService.getClass();
                    if (((ActivityManager) systemService).isLowRamDevice()) {
                        d2 = 0.15d;
                    }
                } catch (Exception unused) {
                }
                if (0.0d > d2 || d2 > 1.0d) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("percent must be in the range [0.0, 1.0].");
                    return null;
                }
                PriorityQueue priorityQueue = new PriorityQueue((byte) 10);
                try {
                    Object systemService2 = context.getSystemService((Class<Object>) ActivityManager.class);
                    systemService2.getClass();
                    ActivityManager activityManager = (ActivityManager) systemService2;
                    largeMemoryClass = (context.getApplicationInfo().flags & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                    break;
                } catch (Exception unused2) {
                    largeMemoryClass = 256;
                }
                return new RealMemoryCache(new RealStrongMemoryCache((long) (d2 * ((long) largeMemoryClass) * 1048576), priorityQueue), priorityQueue);
            case 1:
                BitmapFactoryDecoder bitmapFactoryDecoder = (BitmapFactoryDecoder) obj;
                BitmapFactory.Options options = new BitmapFactory.Options();
                Options options2 = bitmapFactoryDecoder.options;
                Cache.CacheResponseBody.AnonymousClass1 anonymousClass1 = new Cache.CacheResponseBody.AnonymousClass1(bitmapFactoryDecoder.source.source());
                RealBufferedSource realBufferedSource2 = new RealBufferedSource(anonymousClass1);
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(new RealBufferedSource(new PeekSource(realBufferedSource2)).new AnonymousClass1(), null, options);
                Exception exc = (Exception) anonymousClass1.this$0;
                if (exc != null) {
                    throw exc;
                }
                options.inJustDecodeBounds = false;
                Paint paint = ExifUtils.paint;
                String str = options.outMimeType;
                bitmapFactoryDecoder.exifOrientationStrategy.getClass();
                if ((str != null && (str.equals("image/jpeg") || str.equals("image/webp") || str.equals("image/heic") || str.equals("image/heif"))) == true) {
                    d = 1.0d;
                    ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(new RealBufferedSource(new PeekSource(realBufferedSource2)).new AnonymousClass1()));
                    ExifInterface.ExifAttribute exifAttribute = exifInterface.getExifAttribute("Orientation");
                    if (exifAttribute == null) {
                        intValue = 1;
                    } else {
                        try {
                            intValue = exifAttribute.getIntValue(exifInterface.mExifByteOrder);
                        } catch (NumberFormatException unused3) {
                            intValue = 1;
                        }
                    }
                    boolean z2 = intValue == 2 || intValue == 7 || intValue == 4 || intValue == 5;
                    ExifInterface.ExifAttribute exifAttribute2 = exifInterface.getExifAttribute("Orientation");
                    if (exifAttribute2 == null) {
                        intValue2 = 1;
                    } else {
                        try {
                            intValue2 = exifAttribute2.getIntValue(exifInterface.mExifByteOrder);
                        } catch (NumberFormatException unused4) {
                            intValue2 = 1;
                        }
                    }
                    switch (intValue2) {
                        case 3:
                        case 4:
                            i2 = 180;
                            break;
                        case 5:
                        case 8:
                            i2 = 270;
                            break;
                        case 6:
                        case 7:
                            i2 = 90;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    exifData = new ExifData(z2, i2);
                } else {
                    d = 1.0d;
                    exifData = ExifData.NONE;
                }
                int i3 = exifData.rotationDegrees;
                boolean z3 = exifData.isFlipped;
                Exception exc2 = (Exception) anonymousClass1.this$0;
                if (exc2 != null) {
                    throw exc2;
                }
                options.inMutable = false;
                Extras.Key key = ImageRequests_androidKt.colorSpaceKey;
                ColorSpace colorSpace = (ColorSpace) UriKt.getExtra(options2, key);
                Context context2 = options2.context;
                if (colorSpace != null) {
                    options.inPreferredColorSpace = (ColorSpace) UriKt.getExtra(options2, key);
                }
                options.inPremultiplied = ((Boolean) UriKt.getExtra(options2, ImageRequests_androidKt.premultipliedAlphaKey)).booleanValue();
                Bitmap.Config config = (Bitmap.Config) UriKt.getExtra(options2, ImageRequests_androidKt.bitmapConfigKey);
                if ((z3 || i3 > 0) && (config == null || config == Bitmap.Config.HARDWARE)) {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (((Boolean) UriKt.getExtra(options2, ImageRequests_androidKt.allowRgb565Key)).booleanValue() && config == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, "image/jpeg")) {
                    config = Bitmap.Config.RGB_565;
                }
                Bitmap.Config config2 = options.outConfig;
                Bitmap.Config config3 = Bitmap.Config.RGBA_F16;
                if (config2 == config3 && config != Bitmap.Config.HARDWARE) {
                    config = config3;
                }
                options.inPreferredConfig = config;
                int i4 = options.outWidth;
                if (i4 <= 0 || (i = options.outHeight) <= 0) {
                    options.inSampleSize = 1;
                    z = false;
                    options.inScaled = false;
                } else {
                    int i5 = (i3 == 90 || i3 == 270) ? i : i4;
                    if (i3 != 90 && i3 != 270) {
                        i4 = i;
                    }
                    Size size = options2.size;
                    Scale scale = options2.scale;
                    Extras.Key key2 = ImageRequestsKt.maxBitmapSizeKey;
                    long jM863computeDstSizesEdh43o = SizeKt.m863computeDstSizesEdh43o(i5, i4, size, scale, (Size) UriKt.getExtra(options2, key2));
                    int i6 = (int) (jM863computeDstSizesEdh43o >> 32);
                    int i7 = (int) (jM863computeDstSizesEdh43o & 4294967295L);
                    int iHighestOneBit = Integer.highestOneBit(i5 / i6);
                    int iHighestOneBit2 = Integer.highestOneBit(i4 / i7);
                    int iOrdinal = scale.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
                        } else {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                        }
                        return null;
                    }
                    iMin = Math.min(iHighestOneBit, iHighestOneBit2);
                    if (iMin < 1) {
                        iMin = 1;
                    }
                    options.inSampleSize = iMin;
                    double d3 = iMin;
                    double d4 = ((double) i5) / d3;
                    double d5 = ((double) i4) / d3;
                    Size size2 = (Size) UriKt.getExtra(options2, key2);
                    double d6 = ((double) i6) / d4;
                    double d7 = ((double) i7) / d5;
                    int iOrdinal2 = scale.ordinal();
                    if (iOrdinal2 == 0) {
                        dMax = Math.max(d6, d7);
                    } else {
                        if (iOrdinal2 != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        dMax = Math.min(d6, d7);
                    }
                    Dimension dimension = size2.width;
                    if (dimension instanceof Dimension.Pixels) {
                        double d8 = ((double) ((Dimension.Pixels) dimension).px) / d4;
                        if (dMax > d8) {
                            dMax = d8;
                        }
                    }
                    Dimension dimension2 = size2.height;
                    if (dimension2 instanceof Dimension.Pixels) {
                        double d9 = ((double) ((Dimension.Pixels) dimension2).px) / d5;
                        if (dMax > d9) {
                            dMax = d9;
                        }
                    }
                    if (options2.precision == Precision.INEXACT && dMax > d) {
                        dMax = d;
                    }
                    boolean z4 = dMax == d;
                    options.inScaled = !z4;
                    if (!z4) {
                        if (dMax > d) {
                            options.inDensity = MathKt.roundToInt(2.147483647E9d / dMax);
                            options.inTargetDensity = Integer.MAX_VALUE;
                        } else {
                            options.inDensity = Integer.MAX_VALUE;
                            options.inTargetDensity = MathKt.roundToInt(2.147483647E9d * dMax);
                        }
                    }
                    z = false;
                }
                try {
                    realBufferedSource = realBufferedSource2;
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(realBufferedSource.new AnonymousClass1(), null, options);
                        realBufferedSource.close();
                        Exception exc3 = (Exception) anonymousClass1.this$0;
                        if (exc3 != null) {
                            throw exc3;
                        }
                        if (bitmapDecodeStream == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the image source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                            return null;
                        }
                        bitmapDecodeStream.setDensity(context2.getResources().getDisplayMetrics().densityDpi);
                        if (z3 || i3 > 0) {
                            Matrix matrix = new Matrix();
                            float width = bitmapDecodeStream.getWidth() / 2.0f;
                            float height = bitmapDecodeStream.getHeight() / 2.0f;
                            if (z3) {
                                matrix.postScale(-1.0f, 1.0f, width, height);
                            }
                            if (i3 > 0) {
                                matrix.postRotate(i3, width, height);
                            }
                            RectF rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                            matrix.mapRect(rectF);
                            float f = rectF.left;
                            if (f != CropImageView.DEFAULT_ASPECT_RATIO || rectF.top != CropImageView.DEFAULT_ASPECT_RATIO) {
                                matrix.postTranslate(-f, -rectF.top);
                            }
                            if (i3 == 90 || i3 == 270) {
                                int height2 = bitmapDecodeStream.getHeight();
                                int width2 = bitmapDecodeStream.getWidth();
                                Bitmap.Config config4 = bitmapDecodeStream.getConfig();
                                if (config4 == null) {
                                    config4 = Bitmap.Config.ARGB_8888;
                                }
                                bitmapCreateBitmap = Bitmap.createBitmap(height2, width2, config4);
                            } else {
                                int width3 = bitmapDecodeStream.getWidth();
                                int height3 = bitmapDecodeStream.getHeight();
                                Bitmap.Config config5 = bitmapDecodeStream.getConfig();
                                if (config5 == null) {
                                    config5 = Bitmap.Config.ARGB_8888;
                                }
                                bitmapCreateBitmap = Bitmap.createBitmap(width3, height3, config5);
                            }
                            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, ExifUtils.paint);
                            bitmapDecodeStream.recycle();
                            bitmapDecodeStream = bitmapCreateBitmap;
                        }
                        return new DecodeResult(UriKt.asImage(new BitmapDrawable(context2.getResources(), bitmapDecodeStream)), (options.inSampleSize > 1 || options.inScaled) ? true : z);
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            CharsKt.closeFinally(realBufferedSource, th2);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    realBufferedSource = realBufferedSource2;
                }
                break;
                break;
            case 2:
                return (RealDiskCache) ((RealImageLoader) obj).options.diskCacheLazy.getValue();
            case 3:
                final DrawablePainter drawablePainter = (DrawablePainter) obj;
                return new Drawable.Callback() { // from class: com.google.accompanist.drawablepainter.DrawablePainter$callback$2$1
                    @Override // android.graphics.drawable.Drawable.Callback
                    public final void invalidateDrawable(Drawable drawable) {
                        drawable.getClass();
                        DrawablePainter drawablePainter2 = drawablePainter;
                        ParcelableSnapshotMutableState parcelableSnapshotMutableState = drawablePainter2.drawInvalidateTick$delegate;
                        parcelableSnapshotMutableState.setValue(Integer.valueOf(((Number) parcelableSnapshotMutableState.getValue()).intValue() + 1));
                        drawablePainter2.drawableIntrinsicSize$delegate.setValue(new androidx.compose.ui.geometry.Size(DrawablePainterKt.getIntrinsicSize(drawablePainter2.drawable)));
                    }

                    @Override // android.graphics.drawable.Drawable.Callback
                    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                        drawable.getClass();
                        runnable.getClass();
                        ((Handler) DrawablePainterKt.MAIN_HANDLER$delegate.getValue()).postAtTime(runnable, j);
                    }

                    @Override // android.graphics.drawable.Drawable.Callback
                    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                        drawable.getClass();
                        runnable.getClass();
                        ((Handler) DrawablePainterKt.MAIN_HANDLER$delegate.getValue()).removeCallbacks(runnable);
                    }
                };
            case 4:
                InputStream inputStream = (InputStream) ((YouTube$$ExternalSyntheticLambda3) obj).invoke();
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                return ReadingKt.toByteReadChannelWithArrayPool$default(inputStream, DefaultIoScheduler.INSTANCE, null, 2, null);
            case 5:
                ((MainActivity) obj).appReady$delegate.setValue(Boolean.TRUE);
                return unit;
            case 6:
                try {
                    return new NetworkConnectivityObserver(((ListenTogetherClient) obj).context);
                } catch (Exception unused5) {
                    Timber.Forest.tag("ListenTogether");
                    ConnectionPool.e$1(new Object[0]);
                    return null;
                }
            case 7:
                MusicService musicService = (MusicService) obj;
                if (((Boolean) musicService.instantSilenceSkipEnabled.getValue()).booleanValue() && ((standaloneCoroutine = musicService.silenceSkipJob) == null || !standaloneCoroutine.isActive())) {
                    musicService.silenceSkipJob = AwaitKt.launch$default(musicService.scope, null, null, new MusicService.C01761(b2, musicService, continuation), 3);
                }
                return unit;
            case 8:
                int i8 = RecognitionForegroundService.$r8$clinit;
                return new ImageLoader$Builder((RecognitionForegroundService) obj).build();
            case 9:
                LensController lensController = (LensController) obj;
                return Integer.valueOf(UuidKt.coerceIn(MathKt.roundToInt(((Number) lensController.pos.getValue()).floatValue()), 0, lensController.n - 1));
            case 10:
                Function0 function0 = ((Material3SettingsItem) obj).onClick;
                if (function0 != null) {
                    function0.invoke();
                }
                return unit;
            case 11:
                Function0 function1 = ((Material3MenuItemData) obj).onClick;
                if (function1 != null) {
                    function1.invoke();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return (MediaMetadata) obj;
            case 13:
                int i9 = CrashActivity.$r8$clinit;
                ((CrashActivity) obj).finishAffinity();
                return unit;
            case 14:
                ((SnapshotStateList) obj).clear();
                return unit;
            case 15:
                OnlinePlaylistViewModel onlinePlaylistViewModel = (OnlinePlaylistViewModel) obj;
                StandaloneCoroutine standaloneCoroutine2 = onlinePlaylistViewModel.proactiveLoadJob;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel(null);
                }
                CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(onlinePlaylistViewModel);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new ArtistViewModel.AnonymousClass1(onlinePlaylistViewModel, continuation, (byte) 9), 2);
                return unit;
            case 16:
                ((DataStoreKt$rememberPreference$1$1) obj).setValue(Boolean.TRUE);
                return unit;
            case 17:
                SongEntity songEntity = (SongEntity) obj;
                return new ParcelableSnapshotMutableIntState(songEntity != null ? songEntity.lyricsOffset : 0);
            case 18:
                return Boolean.valueOf(PoTokenGenerator.webViewSupported_delegate$lambda$0((PoTokenGenerator) obj));
            case 19:
                LibraryMixViewModel libraryMixViewModel = (LibraryMixViewModel) obj;
                CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(libraryMixViewModel);
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                return AwaitKt.launch$default(viewModelScope2, DefaultIoScheduler.INSTANCE, null, new LibraryMixViewModel$syncAllLibrary$1$1(libraryMixViewModel, continuation, objArr == true ? 1 : 0), 2);
            case 20:
                ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(((MetrolistWidgetManager) obj).context);
                Extras.Key key3 = ImageRequestsKt.transformationsKey;
                Extras.Key key4 = ImageRequests_androidKt.transitionFactoryKey;
                ((Extras.Builder) imageLoader$Builder.extras).set(ImageRequests_androidKt.transitionFactoryKey, Transition.Factory.NONE);
                return imageLoader$Builder.build();
            case 21:
                return new HazeEffectNode$areaPreDrawListener$2$1((HazeEffectNode) obj);
            case 22:
                HazeSourceNode hazeSourceNode = (HazeSourceNode) obj;
                boolean zIsEmpty = hazeSourceNode.area.preDrawListeners.isEmpty();
                StandaloneCoroutine standaloneCoroutine3 = hazeSourceNode.preDrawJob;
                if (zIsEmpty) {
                    if (standaloneCoroutine3 != null) {
                        standaloneCoroutine3.cancel(null);
                    }
                    hazeSourceNode.preDrawJob = null;
                } else if (standaloneCoroutine3 == null || !standaloneCoroutine3.isActive()) {
                    hazeSourceNode.preDrawJob = hazeSourceNode.launchPreDraw();
                }
                return unit;
            case 23:
                return OkHttpEngineKt.convertToOkHttpBody$lambda$1((OutgoingContent) obj);
            case 24:
                return ContentNegotiationConfig.AnonymousClass1.subtypeSuffix_delegate$lambda$0((ContentType) obj);
            case 25:
                return CIOHeaders.names_delegate$lambda$0((CIOHeaders) obj);
            case 26:
                return ((MultipartEvent.MultipartPart) obj).getBody();
            case 27:
                return GenericElementEncoder.beginStructure$lambda$0((GenericElementEncoder) obj);
            case 28:
                return StatelessHmacNonceManager.nonceGenerator$lambda$0((StatelessHmacNonceManager) obj);
            default:
                return ConcurrentSetKt.AnonymousClass1.add$lambda$0((Ref$BooleanRef) obj);
        }
    }
}
