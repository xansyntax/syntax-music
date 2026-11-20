package com.metrolist.music.recognition;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.size.RealSizeResolver;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
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
public final class RecognitionForegroundService$loadBitmap$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String $url;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ RecognitionForegroundService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecognitionForegroundService$loadBitmap$2(RecognitionForegroundService recognitionForegroundService, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = recognitionForegroundService;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$url;
        RecognitionForegroundService recognitionForegroundService = this.this$0;
        switch (b) {
            case 0:
                RecognitionForegroundService$loadBitmap$2 recognitionForegroundService$loadBitmap$2 = new RecognitionForegroundService$loadBitmap$2(recognitionForegroundService, str, continuation, (byte) 0);
                recognitionForegroundService$loadBitmap$2.L$0 = obj;
                return recognitionForegroundService$loadBitmap$2;
            default:
                RecognitionForegroundService$loadBitmap$2 recognitionForegroundService$loadBitmap$3 = new RecognitionForegroundService$loadBitmap$2(recognitionForegroundService, str, continuation, (byte) 1);
                recognitionForegroundService$loadBitmap$3.L$0 = obj;
                return recognitionForegroundService$loadBitmap$3;
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
        }
        return ((RecognitionForegroundService$loadBitmap$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object failure;
        Object failure2;
        byte b = this.$r8$classId;
        String str = this.$url;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        RecognitionForegroundService recognitionForegroundService = this.this$0;
        Continuation continuation = null;
        switch (b) {
            case 0:
                boolean z = this.label;
                try {
                    if (z) {
                        if (z) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    int i = RecognitionForegroundService.$r8$clinit;
                    RealImageLoader realImageLoader = (RealImageLoader) recognitionForegroundService.imageLoader$delegate.getValue();
                    ImageRequest.Builder builder = new ImageRequest.Builder(recognitionForegroundService);
                    builder.data = str;
                    builder.sizeResolver = new RealSizeResolver(SizeKt.Size(200, 200));
                    ImageRequests_androidKt.allowHardware(builder);
                    ImageRequest imageRequestBuild = builder.build();
                    this.L$0 = null;
                    this.label = true;
                    obj = realImageLoader.execute(imageRequestBuild, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    Image image = ((ImageResult) obj).getImage();
                    failure = image != null ? UriKt.toBitmap$default(image) : null;
                    break;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (!(failure instanceof Result.Failure)) {
                    return failure;
                }
                return null;
            default:
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                boolean z2 = this.label;
                byte b2 = 0;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = true;
                int i2 = RecognitionForegroundService.$r8$clinit;
                recognitionForegroundService.getClass();
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                obj = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new RecognitionForegroundService$loadBitmap$2(recognitionForegroundService, str, continuation, b2), this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                Bitmap bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    try {
                        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
                        bitmapCreateBitmap.getClass();
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
                        bitmapCreateBitmap2.getClass();
                        Paint paint = new Paint(3);
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
                        float f = iMin;
                        new Canvas(bitmapCreateBitmap2).drawRoundRect(new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, f), 24.0f, 24.0f, paint);
                        if (!bitmapCreateBitmap.equals(bitmap)) {
                            bitmapCreateBitmap.recycle();
                        }
                        File file = new File(recognitionForegroundService.getCacheDir(), "recognizer_widget_art.png");
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            bitmapCreateBitmap2.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                            fileOutputStream.close();
                            failure2 = file;
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                CharsKt.closeFinally(fileOutputStream, th2);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        failure2 = new Result.Failure(th4);
                    }
                    if (Result.m1866exceptionOrNullimpl(failure2) != null) {
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                    }
                    if (!(failure2 instanceof Result.Failure)) {
                        return failure2;
                    }
                }
                return null;
        }
    }
}
