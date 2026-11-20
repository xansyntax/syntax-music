package androidx.navigation.internal;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.compose.ui.text.font.TypefaceCompatApi26;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.DisplayCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda2;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.MediaSessionImpl$1;
import coil3.size.SizeKt;
import com.materialkolor.quantize.QuantizerWu;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavContext implements EmojiCompat.MetadataRepoLoader, MediaCodecAdapter.Factory {
    public final Context context;

    public NavContext(Context context, byte b) {
        switch (b) {
            case 2:
                this.context = context.getApplicationContext();
                break;
            case 3:
                context.getClass();
                this.context = context;
                break;
            default:
                this.context = context.getApplicationContext();
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 34) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int supportsFormat(Format format) {
        String str = format.sampleMimeType;
        if (str == null || !MimeTypes.isImage(str)) {
            return BaseRenderer.create(0, 0, 0, 0);
        }
        String str2 = format.sampleMimeType;
        String str3 = Util.DEVICE_DEBUG_INFO;
        str2.getClass();
        switch (str2) {
            case "image/avif":
            case "image/heic":
            case "image/heif":
            case "image/jpeg":
            case "image/webp":
            case "image/bmp":
            case "image/png":
                return BaseRenderer.create(4, 0, 0, 0);
        }
        return BaseRenderer.create(1, 0, 0, 0);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
    public MediaCodecAdapter createAdapter(QuantizerWu quantizerWu) {
        Context context;
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && ((context = this.context) == null || i < 28 || !context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            return new CueDecoder((byte) 2).createAdapter(quantizerWu);
        }
        int trackType = MimeTypes.getTrackType(((Format) quantizerWu.momentsG).sampleMimeType);
        Log.i("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(Util.getTrackTypeString(trackType)));
        MediaSessionImpl$1 mediaSessionImpl$1 = new MediaSessionImpl$1(new AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0((byte) 0, trackType), new AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0((byte) 1, trackType));
        mediaSessionImpl$1.val$callOnPlayerInteractionFinished = true;
        return mediaSessionImpl$1.createAdapter(quantizerWu);
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
    public void load(SizeKt sizeKt) {
        Util$$ExternalSyntheticLambda2 util$$ExternalSyntheticLambda2 = new Util$$ExternalSyntheticLambda2("EmojiCompatInitializer", (byte) 1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), util$$ExternalSyntheticLambda2);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new Util$$ExternalSyntheticLambda1((Object) this, (Object) sizeKt, (Object) threadPoolExecutor, (byte) 2));
    }

    public Typeface loadBlocking(ResourceFont resourceFont) {
        if (!(resourceFont instanceof ResourceFont)) {
            return null;
        }
        int i = resourceFont.resId;
        Context context = this.context;
        Typeface font = ResourcesCompat.getFont(context, i);
        font.getClass();
        FontVariation.Settings settings = resourceFont.variationSettings;
        ThreadLocal threadLocal = TypefaceCompatApi26.threadLocalPaint;
        if (font == null) {
            return null;
        }
        if (settings.settings.isEmpty()) {
            return font;
        }
        ThreadLocal threadLocal2 = TypefaceCompatApi26.threadLocalPaint;
        Paint paint = (Paint) threadLocal2.get();
        if (paint == null) {
            paint = new Paint();
            threadLocal2.set(paint);
        }
        paint.setFontVariationSettings(null);
        paint.setTypeface(font);
        paint.setFontVariationSettings(DisplayCompat.toAndroidString(settings, context));
        return paint.getTypeface();
    }

    public /* synthetic */ NavContext(Context context, int i) {
        this.context = context;
    }
}
