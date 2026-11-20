package coil3.decode;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.sync.SemaphoreImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapFactoryDecoder implements Decoder {
    public final ExifOrientationStrategy$$ExternalSyntheticLambda0 exifOrientationStrategy;
    public final Options options;
    public final SemaphoreImpl parallelismLock;
    public final ImageSource source;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements Decoder.Factory {
        public final ExifOrientationStrategy$$ExternalSyntheticLambda0 exifOrientationStrategy;
        public final SemaphoreImpl parallelismLock;

        public Factory(SemaphoreImpl semaphoreImpl, ExifOrientationStrategy$$ExternalSyntheticLambda0 exifOrientationStrategy$$ExternalSyntheticLambda0) {
            this.parallelismLock = semaphoreImpl;
            this.exifOrientationStrategy = exifOrientationStrategy$$ExternalSyntheticLambda0;
        }

        @Override // coil3.decode.Decoder.Factory
        public final Decoder create(SourceFetchResult sourceFetchResult, Options options) {
            return new BitmapFactoryDecoder(sourceFetchResult.source, options, this.parallelismLock, this.exifOrientationStrategy);
        }
    }

    /* JADX INFO: renamed from: coil3.decode.BitmapFactoryDecoder$decode$1, reason: invalid class name */
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
            return BitmapFactoryDecoder.this.decode(this);
        }
    }

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, SemaphoreImpl semaphoreImpl, ExifOrientationStrategy$$ExternalSyntheticLambda0 exifOrientationStrategy$$ExternalSyntheticLambda0) {
        this.source = imageSource;
        this.options = options;
        this.parallelismLock = semaphoreImpl;
        this.exifOrientationStrategy = exifOrientationStrategy$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // coil3.decode.Decoder
    public final Object decode(ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        SemaphoreImpl semaphoreImpl;
        Throwable th;
        SemaphoreImpl semaphoreImpl2;
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
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                semaphoreImpl = this.parallelismLock;
                anonymousClass1.L$0 = semaphoreImpl;
                anonymousClass1.label = 1;
                if (semaphoreImpl.acquire(anonymousClass1) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                semaphoreImpl2 = anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    DecodeResult decodeResult = (DecodeResult) obj;
                    semaphoreImpl2.release();
                    return decodeResult;
                } catch (Throwable th2) {
                    th = th2;
                    semaphoreImpl2.release();
                    throw th;
                }
            }
            SemaphoreImpl semaphoreImpl3 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            semaphoreImpl = semaphoreImpl3;
            ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1 = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 1, this);
            anonymousClass1.L$0 = semaphoreImpl;
            anonymousClass1.label = 2;
            Object objWithContext = AwaitKt.withContext(EmptyCoroutineContext.INSTANCE, new InterruptibleKt$runInterruptible$2(imageLoader$Builder$$ExternalSyntheticLambda1, continuation, (byte) 0), anonymousClass1);
            if (objWithContext != coroutineSingletons) {
                SemaphoreImpl semaphoreImpl4 = semaphoreImpl;
                obj = objWithContext;
                semaphoreImpl2 = semaphoreImpl4;
                DecodeResult decodeResult2 = (DecodeResult) obj;
                semaphoreImpl2.release();
                return decodeResult2;
            }
            return coroutineSingletons;
        } catch (Throwable th3) {
            SemaphoreImpl semaphoreImpl5 = semaphoreImpl;
            th = th3;
            semaphoreImpl2 = semaphoreImpl5;
            semaphoreImpl2.release();
            throw th;
        }
    }
}
