package com.metrolist.music.widget;

import android.content.Context;
import coil3.Extras;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.SingletonImageLoader;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.size.RealSizeResolver;
import coil3.size.SizeKt;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistWidgetManager$loadBitmap$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ short $size;
    public final /* synthetic */ String $uri;
    public boolean label;
    public final /* synthetic */ PlaylistWidgetManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PlaylistWidgetManager$loadBitmap$2(PlaylistWidgetManager playlistWidgetManager, String str, int i, Continuation continuation) {
        super(2, continuation);
        this.this$0 = playlistWidgetManager;
        this.$uri = str;
        this.$size = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PlaylistWidgetManager$loadBitmap$2(this.this$0, this.$uri, this.$size, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PlaylistWidgetManager$loadBitmap$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context = this.this$0.context;
        boolean z = this.label;
        try {
            if (!z) {
                ResultKt.throwOnFailure(obj);
                ImageRequest.Builder builder = new ImageRequest.Builder(context);
                builder.data = this.$uri;
                short s = this.$size;
                builder.sizeResolver = new RealSizeResolver(SizeKt.Size(s, s));
                ImageRequests_androidKt.allowHardware(builder);
                Extras.Key key = ImageRequestsKt.transformationsKey;
                ImageRequests_androidKt.crossfade(builder, 0);
                ImageRequest imageRequestBuild = builder.build();
                RealImageLoader realImageLoader = SingletonImageLoader.get(context);
                this.label = true;
                obj = realImageLoader.execute(imageRequestBuild, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            Image image = ((ImageResult) obj).getImage();
            if (image != null) {
                return UriKt.toBitmap$default(image);
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
        }
        return null;
    }
}
