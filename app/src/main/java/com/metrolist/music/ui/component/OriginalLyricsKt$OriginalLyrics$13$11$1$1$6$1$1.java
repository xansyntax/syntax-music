package com.metrolist.music.ui.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Layout;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.Density;
import coil3.network.HttpException;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.utils.ComposeToImage$createLyricsImage$2;
import com.metrolist.music.utils.UtilsKt;
import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OriginalLyricsKt$OriginalLyrics$13$11$1$1$6$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $artists;
    public final /* synthetic */ WindowInfo $configuration;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $coverUrl;
    public final /* synthetic */ Density $density;
    public final /* synthetic */ String $failedToCreateImageTemplate;
    public final /* synthetic */ String $lyricsText;
    public final /* synthetic */ MutableState $lyricsTextPosition$delegate;
    public final /* synthetic */ MutableState $previewBackgroundColor$delegate;
    public final /* synthetic */ MutableState $previewBackgroundStyle$delegate;
    public final /* synthetic */ MutableState $previewSecondaryTextColor$delegate;
    public final /* synthetic */ MutableState $previewTextColor$delegate;
    public final /* synthetic */ String $shareLyricsStr;
    public final /* synthetic */ MutableState $showProgressDialog$delegate;
    public final /* synthetic */ String $songTitle;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalLyricsKt$OriginalLyrics$13$11$1$1$6$1$1(WindowInfo windowInfo, Context context, String str, String str2, String str3, String str4, Density density, String str5, String str6, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, Continuation continuation) {
        super(2, continuation);
        this.$configuration = windowInfo;
        this.$context = context;
        this.$coverUrl = str;
        this.$songTitle = str2;
        this.$artists = str3;
        this.$lyricsText = str4;
        this.$density = density;
        this.$shareLyricsStr = str5;
        this.$failedToCreateImageTemplate = str6;
        this.$previewBackgroundColor$delegate = mutableState;
        this.$previewBackgroundStyle$delegate = mutableState2;
        this.$previewTextColor$delegate = mutableState3;
        this.$previewSecondaryTextColor$delegate = mutableState4;
        this.$lyricsTextPosition$delegate = mutableState5;
        this.$showProgressDialog$delegate = mutableState6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OriginalLyricsKt$OriginalLyrics$13$11$1$1$6$1$1(this.$configuration, this.$context, this.$coverUrl, this.$songTitle, this.$artists, this.$lyricsText, this.$density, this.$shareLyricsStr, this.$failedToCreateImageTemplate, this.$previewBackgroundColor$delegate, this.$previewBackgroundStyle$delegate, this.$previewTextColor$delegate, this.$previewSecondaryTextColor$delegate, this.$lyricsTextPosition$delegate, this.$showProgressDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((OriginalLyricsKt$OriginalLyrics$13$11$1$1$6$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Layout.Alignment alignment;
        Object objWithContext;
        Density density = this.$density;
        WindowInfo windowInfo = this.$configuration;
        boolean z = this.label;
        MutableState mutableState = this.$showProgressDialog$delegate;
        Context context = this.$context;
        try {
            if (!z) {
                ResultKt.throwOnFailure(obj);
                ((LazyWindowInfo) windowInfo).m715getContainerSizeYbymL2g();
                ((LazyWindowInfo) windowInfo).m715getContainerSizeYbymL2g();
                Context context2 = this.$context;
                String str = this.$coverUrl;
                String str2 = this.$songTitle;
                String str3 = this.$artists;
                String str4 = this.$lyricsText;
                density.getDensity();
                density.getDensity();
                MutableState mutableState2 = this.$previewBackgroundColor$delegate;
                int i = OriginalLyricsKt.$r8$clinit;
                Integer num = new Integer(ColorKt.m498toArgb8_81llA(((Color) mutableState2.getValue()).value));
                LyricsBackgroundStyle lyricsBackgroundStyle = (LyricsBackgroundStyle) this.$previewBackgroundStyle$delegate.getValue();
                Integer num2 = new Integer(ColorKt.m498toArgb8_81llA(((Color) this.$previewTextColor$delegate.getValue()).value));
                Integer num3 = new Integer(ColorKt.m498toArgb8_81llA(((Color) this.$previewSecondaryTextColor$delegate.getValue()).value));
                int iOrdinal = ((LyricsPosition) this.$lyricsTextPosition$delegate.getValue()).ordinal();
                if (iOrdinal == 0) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else if (iOrdinal == 1) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else {
                    if (iOrdinal != 2) {
                        throw new HttpException();
                    }
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                }
                Layout.Alignment alignment2 = alignment;
                this.label = true;
                objWithContext = AwaitKt.withContext(Dispatchers.Default, new ComposeToImage$createLyricsImage$2(num, num2, num3, str, context2, lyricsBackgroundStyle, str2, str3, str4, alignment2, null), this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objWithContext = obj;
            }
            Uri uriSaveBitmapAsFile = UtilsKt.saveBitmapAsFile(context, (Bitmap) objWithContext, "lyrics_" + System.currentTimeMillis());
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.STREAM", uriSaveBitmapAsFile);
            intent.addFlags(1);
            context.startActivity(Intent.createChooser(intent, this.$shareLyricsStr));
        } catch (Exception e) {
            String str5 = this.$failedToCreateImageTemplate;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            Toast.makeText(context, String.format(str5, Arrays.copyOf(new Object[]{message}, 1)), 0).show();
        } finally {
            int i2 = OriginalLyricsKt.$r8$clinit;
            mutableState.setValue(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }
}
