package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.util.Size;
import androidx.tracing.TraceApi29Impl;
import coil3.BitmapImage;
import coil3.Extras;
import coil3.UriKt;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.SizeKt;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.sync.SemaphoreImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StaticImageDecoder implements Decoder {
    public final AutoCloseable closeable;
    public final Options options;
    public final SemaphoreImpl parallelismLock;
    public final ImageDecoder.Source source;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements Decoder.Factory {
        public final SemaphoreImpl parallelismLock;

        public Factory(SemaphoreImpl semaphoreImpl) {
            this.parallelismLock = semaphoreImpl;
        }

        @Override // coil3.decode.Decoder.Factory
        public final Decoder create(SourceFetchResult sourceFetchResult, Options options) {
            ImageDecoder.Source imageDecoderSourceOrNull;
            Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(options);
            if ((bitmapConfig == Bitmap.Config.ARGB_8888 || bitmapConfig == Bitmap.Config.HARDWARE) && (imageDecoderSourceOrNull = TraceApi29Impl.toImageDecoderSourceOrNull(sourceFetchResult.source, options)) != null) {
                return new StaticImageDecoder(imageDecoderSourceOrNull, sourceFetchResult.source, options, this.parallelismLock);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: coil3.decode.StaticImageDecoder$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public SemaphoreImpl L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StaticImageDecoder.this.decode(this);
        }
    }

    public StaticImageDecoder(ImageDecoder.Source source, AutoCloseable autoCloseable, Options options, SemaphoreImpl semaphoreImpl) {
        this.source = source;
        this.closeable = autoCloseable;
        this.options = options;
        this.parallelismLock = semaphoreImpl;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // coil3.decode.Decoder
    public final Object decode(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        SemaphoreImpl semaphoreImpl;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SemaphoreImpl semaphoreImpl2 = this.parallelismLock;
            anonymousClass1.L$0 = semaphoreImpl2;
            anonymousClass1.label = 1;
            Object objAcquire = semaphoreImpl2.acquire(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAcquire == coroutineSingletons) {
                return coroutineSingletons;
            }
            semaphoreImpl = semaphoreImpl2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            semaphoreImpl = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            AutoCloseable autoCloseable = this.closeable;
            try {
                final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                DecodeResult decodeResult = new DecodeResult(new BitmapImage(ImageDecoder.decodeBitmap(this.source, new ImageDecoder$OnHeaderDecodedListener() { // from class: coil3.decode.StaticImageDecoder$decode$lambda$0$0$$inlined$decodeBitmap$1
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        Size size = imageInfo.getSize();
                        int width = size.getWidth();
                        int height = size.getHeight();
                        final StaticImageDecoder staticImageDecoder = this.this$0;
                        Options options = staticImageDecoder.options;
                        coil3.size.Size size2 = options.size;
                        Scale scale = options.scale;
                        Extras.Key key = ImageRequestsKt.maxBitmapSizeKey;
                        long jM863computeDstSizesEdh43o = SizeKt.m863computeDstSizesEdh43o(width, height, size2, scale, (coil3.size.Size) UriKt.getExtra(options, key));
                        int i3 = (int) (jM863computeDstSizesEdh43o >> 32);
                        int i4 = (int) (jM863computeDstSizesEdh43o & 4294967295L);
                        if (width > 0 && height > 0 && (width != i3 || height != i4)) {
                            Options options2 = staticImageDecoder.options;
                            double dComputeSizeMultiplier = SizeKt.computeSizeMultiplier(width, height, i3, i4, options2.scale, (coil3.size.Size) UriKt.getExtra(options2, key));
                            boolean z = dComputeSizeMultiplier < 1.0d;
                            ref$BooleanRef.element = z;
                            if (z || staticImageDecoder.options.precision == Precision.EXACT) {
                                imageDecoder.setTargetSize(MathKt.roundToInt(((double) width) * dComputeSizeMultiplier), MathKt.roundToInt(dComputeSizeMultiplier * ((double) height)));
                            }
                        }
                        imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: coil3.decode.StaticImageDecoder$$ExternalSyntheticLambda0
                            @Override // android.graphics.ImageDecoder.OnPartialImageListener
                            public final boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                                return ((Boolean) UriKt.getExtra(staticImageDecoder.options, ImageRequests_androidKt.allowPartialImageKey)).booleanValue();
                            }
                        });
                        Options options3 = staticImageDecoder.options;
                        imageDecoder.setAllocator(ImageRequests_androidKt.getBitmapConfig(options3) == Bitmap.Config.HARDWARE ? 3 : 1);
                        imageDecoder.setMemorySizePolicy(!((Boolean) UriKt.getExtra(options3, ImageRequests_androidKt.allowRgb565Key)).booleanValue() ? 1 : 0);
                        Extras.Key key2 = ImageRequests_androidKt.colorSpaceKey;
                        if (((ColorSpace) UriKt.getExtra(options3, key2)) != null) {
                            imageDecoder.setTargetColorSpace((ColorSpace) UriKt.getExtra(options3, key2));
                        }
                        imageDecoder.setUnpremultipliedRequired(!((Boolean) UriKt.getExtra(options3, ImageRequests_androidKt.premultipliedAlphaKey)).booleanValue());
                    }
                })), ref$BooleanRef.element);
                StringsKt__IndentKt.closeFinally(autoCloseable, null);
                semaphoreImpl.release();
                return decodeResult;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    StringsKt__IndentKt.closeFinally(autoCloseable, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            semaphoreImpl.release();
            throw th3;
        }
    }
}
