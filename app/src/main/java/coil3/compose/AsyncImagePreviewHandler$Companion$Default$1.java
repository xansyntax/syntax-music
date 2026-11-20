package coil3.compose;

import coil3.Image;
import coil3.RealImageLoader;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncImagePreviewHandler$Companion$Default$1 {
    public static final AsyncImagePreviewHandler$Companion$Default$1 INSTANCE = new AsyncImagePreviewHandler$Companion$Default$1();

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handle(RealImageLoader realImageLoader, ImageRequest imageRequest, ContinuationImpl continuationImpl) {
        AsyncImagePreviewHandler$Companion$Default$1$handle$1 asyncImagePreviewHandler$Companion$Default$1$handle$1;
        if (continuationImpl instanceof AsyncImagePreviewHandler$Companion$Default$1$handle$1) {
            asyncImagePreviewHandler$Companion$Default$1$handle$1 = (AsyncImagePreviewHandler$Companion$Default$1$handle$1) continuationImpl;
            int i = asyncImagePreviewHandler$Companion$Default$1$handle$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                asyncImagePreviewHandler$Companion$Default$1$handle$1.label = i - Integer.MIN_VALUE;
            } else {
                asyncImagePreviewHandler$Companion$Default$1$handle$1 = new AsyncImagePreviewHandler$Companion$Default$1$handle$1(this, continuationImpl);
            }
        } else {
            asyncImagePreviewHandler$Companion$Default$1$handle$1 = new AsyncImagePreviewHandler$Companion$Default$1$handle$1(this, continuationImpl);
        }
        Object objExecute = asyncImagePreviewHandler$Companion$Default$1$handle$1.result;
        int i2 = asyncImagePreviewHandler$Companion$Default$1$handle$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            asyncImagePreviewHandler$Companion$Default$1$handle$1.L$1 = imageRequest;
            asyncImagePreviewHandler$Companion$Default$1$handle$1.label = 1;
            objExecute = realImageLoader.execute(imageRequest, asyncImagePreviewHandler$Companion$Default$1$handle$1);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objExecute == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            imageRequest = asyncImagePreviewHandler$Companion$Default$1$handle$1.L$1;
            ResultKt.throwOnFailure(objExecute);
        }
        ImageResult imageResult = (ImageResult) objExecute;
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new AsyncImagePainter.State.Success(AsyncImageKt.m852asPainter55t9rM(successResult.image, imageRequest.context), successResult);
        }
        if (!(imageResult instanceof ErrorResult)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        ErrorResult errorResult = (ErrorResult) imageResult;
        Image image = errorResult.image;
        return new AsyncImagePainter.State.Error(image != null ? AsyncImageKt.m852asPainter55t9rM(image, imageRequest.context) : null, errorResult);
    }
}
