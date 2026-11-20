package com.metrolist.music.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.content.res.ResourcesCompat;
import androidx.palette.graphics.Palette;
import androidx.palette.graphics.Target;
import coil3.Image;
import coil3.ImageLoader$Builder;
import coil3.RealImageLoader;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.size.RealSizeResolver;
import coil3.size.SizeKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongShareCard$create$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $artist;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $coverUrl;
    public final /* synthetic */ String $title;
    public /* synthetic */ Object L$0;
    public Bitmap L$1;
    public Canvas L$2;
    public Ref$ObjectRef L$3;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SongShareCard$create$2(String str, Context context, String str2, String str3, Continuation continuation) {
        super(2, continuation);
        this.$coverUrl = str;
        this.$context = context;
        this.$title = str2;
        this.$artist = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SongShareCard$create$2 songShareCard$create$2 = new SongShareCard$create$2(this.$coverUrl, this.$context, this.$title, this.$artist, continuation);
        songShareCard$create$2.L$0 = obj;
        return songShareCard$create$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SongShareCard$create$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a8 A[Catch: all -> 0x00b8, TryCatch #3 {all -> 0x00b8, blocks: (B:26:0x0097, B:28:0x00a8, B:30:0x00ac), top: B:85:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:45:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:51:0x025c  */
    /* JADX WARN: Code duplicated, block: B:57:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:69:0x0359  */
    /* JADX WARN: Code duplicated, block: B:85:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmapCreateBitmap;
        Canvas canvas;
        Ref$ObjectRef ref$ObjectRef;
        Object objExecute;
        Ref$ObjectRef ref$ObjectRef2;
        Bitmap bitmap;
        int iIntValue;
        Object failure;
        Integer num;
        Palette.Swatch swatch;
        int i;
        RectF rectF;
        Paint paint;
        Object obj2;
        RectF rectF2;
        float f;
        Typeface font;
        Typeface typefaceCreate;
        Typeface typefaceCreate2;
        int iSave;
        int iSave2;
        Drawable drawable;
        int iSave3;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        boolean z = this.label;
        Context context = this.$context;
        try {
            try {
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    bitmapCreateBitmap = Bitmap.createBitmap(1620, 2025, Bitmap.Config.ARGB_8888);
                    canvas = new Canvas(bitmapCreateBitmap);
                    canvas.scale(1.5f, 1.5f);
                    ref$ObjectRef = new Ref$ObjectRef();
                    String str = this.$coverUrl;
                    if (str != null) {
                        try {
                            RealImageLoader realImageLoaderBuild = new ImageLoader$Builder(context).build();
                            ImageRequest.Builder builder = new ImageRequest.Builder(context);
                            builder.data = str;
                            builder.sizeResolver = new RealSizeResolver(SizeKt.Size(1024, 1024));
                            ImageRequests_androidKt.allowHardware(builder);
                            ImageRequest imageRequestBuild = builder.build();
                            this.L$0 = coroutineScope;
                            this.L$1 = bitmapCreateBitmap;
                            this.L$2 = canvas;
                            this.L$3 = ref$ObjectRef;
                            this.label = true;
                            objExecute = realImageLoaderBuild.execute(imageRequestBuild, this);
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objExecute == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } catch (Exception unused) {
                            ref$ObjectRef2 = ref$ObjectRef;
                            ref$ObjectRef = ref$ObjectRef2;
                        }
                    }
                    bitmap = (Bitmap) ref$ObjectRef.element;
                    iIntValue = -1144221;
                    if (bitmap != null) {
                        try {
                            Palette.Builder builder2 = new Palette.Builder(bitmap);
                            builder2.mMaxColors = (byte) 12;
                            Palette paletteGenerate = builder2.generate();
                            swatch = paletteGenerate.mDominantSwatch;
                            if (swatch != null) {
                                i = swatch.mRgb;
                            } else {
                                i = -1144221;
                            }
                            failure = new Integer(paletteGenerate.getColorForTarget(Target.VIBRANT, i));
                        } catch (Throwable th) {
                            failure = new Result.Failure(th);
                        }
                        if (failure instanceof Result.Failure) {
                            failure = null;
                        }
                        num = (Integer) failure;
                        if (num != null) {
                            iIntValue = num.intValue();
                        }
                    }
                    rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1080.0f, 1350.0f);
                    paint = new Paint(3);
                    paint.setColor(-15987954);
                    canvas.drawRect(rectF, paint);
                    obj2 = ref$ObjectRef.element;
                    if (obj2 != null) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap((Bitmap) obj2, 24, 24, true);
                        bitmapCreateScaledBitmap.getClass();
                        canvas.drawBitmap(bitmapCreateScaledBitmap, (Rect) null, rectF, paint);
                        paint.setColor(-1728053248);
                        canvas.drawRect(rectF, paint);
                    }
                    int iArgb = Color.argb(150, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    paint.setShader(new RadialGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1188.0f, iArgb, 0, tileMode));
                    canvas.drawRect(rectF, paint);
                    paint.setShader(new RadialGradient(1080.0f, 1282.5f, 1080.0f, Color.argb(90, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)), 0, tileMode));
                    canvas.drawRect(rectF, paint);
                    paint.setShader(null);
                    RectF rectF3 = new RectF(80.0f, 110.0f, 1000.0f, 1200.0f);
                    Paint.Style style = Paint.Style.FILL;
                    paint.setStyle(style);
                    paint.setColor(452984831);
                    canvas.drawRoundRect(rectF3, 84.0f, 84.0f, paint);
                    paint.setShader(new LinearGradient(rectF3.left, rectF3.top, rectF3.right, rectF3.bottom, new int[]{-1711276033, 234881023, 1509949439}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.55f, 1.0f}, tileMode));
                    Paint.Style style2 = Paint.Style.STROKE;
                    paint.setStyle(style2);
                    paint.setStrokeWidth(2.5f);
                    canvas.drawRoundRect(rectF3, 84.0f, 84.0f, paint);
                    paint.setShader(null);
                    paint.setStyle(style);
                    float fWidth = rectF3.width() - 200.0f;
                    float f2 = rectF3.left + 100.0f;
                    float f3 = rectF3.top + 60.0f;
                    rectF2 = new RectF(f2, f3, f2 + fWidth, fWidth + f3);
                    Paint paint2 = new Paint(1);
                    paint2.setColor(-16777216);
                    paint2.setShadowLayer(60.0f, CropImageView.DEFAULT_ASPECT_RATIO, 30.0f, -1728053248);
                    canvas.drawRoundRect(rectF2, 56.0f, 56.0f, paint2);
                    if (ref$ObjectRef.element != null) {
                        Path path = new Path();
                        path.addRoundRect(rectF2, 56.0f, 56.0f, Path.Direction.CW);
                        iSave3 = canvas.save();
                        canvas.clipPath(path);
                        try {
                            int iMin = Math.min(((Bitmap) ref$ObjectRef.element).getWidth(), ((Bitmap) ref$ObjectRef.element).getHeight());
                            canvas.drawBitmap((Bitmap) ref$ObjectRef.element, new Rect((((Bitmap) ref$ObjectRef.element).getWidth() - iMin) / 2, (((Bitmap) ref$ObjectRef.element).getHeight() - iMin) / 2, (((Bitmap) ref$ObjectRef.element).getWidth() + iMin) / 2, (((Bitmap) ref$ObjectRef.element).getHeight() + iMin) / 2), rectF2, paint);
                            canvas.restoreToCount(iSave3);
                            f = 56.0f;
                        } catch (Throwable th2) {
                            canvas.restoreToCount(iSave3);
                            throw th2;
                        }
                    } else {
                        paint.setColor(Color.argb(200, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
                        f = 56.0f;
                        canvas.drawRoundRect(rectF2, 56.0f, 56.0f, paint);
                    }
                    paint.setColor(1090519039);
                    paint.setStyle(style2);
                    paint.setStrokeWidth(2.0f);
                    canvas.drawRoundRect(rectF2, f, f, paint);
                    paint.setStyle(style);
                    font = ResourcesCompat.getFont(context, R.font.dm_sans);
                    if (font != null || Build.VERSION.SDK_INT < 28) {
                        typefaceCreate = Typeface.DEFAULT_BOLD;
                    } else {
                        typefaceCreate = Typeface.create(font, 700, false);
                    }
                    if (font != null || Build.VERSION.SDK_INT < 28) {
                        typefaceCreate2 = Typeface.DEFAULT;
                    } else {
                        typefaceCreate2 = Typeface.create(font, 450, false);
                    }
                    float f4 = rectF3.left + 100.0f;
                    int iWidth = (int) (rectF3.width() - 200.0f);
                    TextPaint textPaint = new TextPaint(1);
                    textPaint.setColor(-1);
                    textPaint.setTextSize(58.0f);
                    textPaint.setTypeface(typefaceCreate);
                    String str2 = this.$title;
                    StaticLayout.Builder maxLines = StaticLayout.Builder.obtain(str2, 0, str2.length(), textPaint, iWidth).setMaxLines(2);
                    TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                    StaticLayout staticLayoutBuild = maxLines.setEllipsize(truncateAt).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
                    staticLayoutBuild.getClass();
                    float f5 = rectF2.bottom + 56.0f;
                    iSave = canvas.save();
                    canvas.translate(f4, f5);
                    staticLayoutBuild.draw(canvas);
                    canvas.restoreToCount(iSave);
                    TextPaint textPaint2 = new TextPaint(1);
                    textPaint2.setColor(-855638017);
                    textPaint2.setTextSize(40.0f);
                    textPaint2.setTypeface(typefaceCreate2);
                    String str3 = this.$artist;
                    StaticLayout staticLayoutBuild2 = StaticLayout.Builder.obtain(str3, 0, str3.length(), textPaint2, iWidth).setMaxLines(1).setEllipsize(truncateAt).build();
                    staticLayoutBuild2.getClass();
                    float height = rectF2.bottom + 56.0f + staticLayoutBuild.getHeight() + 12.0f;
                    iSave2 = canvas.save();
                    canvas.translate(f4, height);
                    staticLayoutBuild2.draw(canvas);
                    canvas.restoreToCount(iSave2);
                    drawable = context.getDrawable(R.drawable.app_logo);
                    if (drawable != null) {
                        canvas.drawBitmap(MathKt.toBitmap$default(drawable, 4), (Rect) null, new RectF(80.0f, 1236.0f, 164.0f, 1320.0f), paint);
                    }
                    TextPaint textPaint3 = new TextPaint(1);
                    textPaint3.setColor(-1);
                    textPaint3.setTextSize(50.0f);
                    textPaint3.setTypeface(typefaceCreate);
                    canvas.drawText("Auralys", 186.0f, 1295.0f, textPaint3);
                    return bitmapCreateBitmap;
                }
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ref$ObjectRef2 = this.L$3;
                canvas = this.L$2;
                bitmapCreateBitmap = this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    ref$ObjectRef = ref$ObjectRef2;
                    objExecute = obj;
                } catch (Exception unused2) {
                    ref$ObjectRef = ref$ObjectRef2;
                }
                staticLayoutBuild2.draw(canvas);
                canvas.restoreToCount(iSave2);
                drawable = context.getDrawable(R.drawable.app_logo);
                if (drawable != null) {
                    canvas.drawBitmap(MathKt.toBitmap$default(drawable, 4), (Rect) null, new RectF(80.0f, 1236.0f, 164.0f, 1320.0f), paint);
                }
                TextPaint textPaint4 = new TextPaint(1);
                textPaint4.setColor(-1);
                textPaint4.setTextSize(50.0f);
                textPaint4.setTypeface(typefaceCreate);
                canvas.drawText("Auralys", 186.0f, 1295.0f, textPaint4);
                return bitmapCreateBitmap;
            } catch (Throwable th3) {
                canvas.restoreToCount(iSave2);
                throw th3;
            }
            staticLayoutBuild.draw(canvas);
            canvas.restoreToCount(iSave);
            TextPaint textPaint5 = new TextPaint(1);
            textPaint5.setColor(-855638017);
            textPaint5.setTextSize(40.0f);
            textPaint5.setTypeface(typefaceCreate2);
            String str4 = this.$artist;
            StaticLayout staticLayoutBuild3 = StaticLayout.Builder.obtain(str4, 0, str4.length(), textPaint5, iWidth).setMaxLines(1).setEllipsize(truncateAt).build();
            staticLayoutBuild3.getClass();
            float height2 = rectF2.bottom + 56.0f + staticLayoutBuild.getHeight() + 12.0f;
            iSave2 = canvas.save();
            canvas.translate(f4, height2);
        } catch (Throwable th4) {
            canvas.restoreToCount(iSave);
            throw th4;
        }
        Image image = ((ImageResult) objExecute).getImage();
        ref$ObjectRef.element = image != null ? UriKt.toBitmap$default(image) : null;
        bitmap = (Bitmap) ref$ObjectRef.element;
        iIntValue = -1144221;
        if (bitmap != null) {
            Palette.Builder builder3 = new Palette.Builder(bitmap);
            builder3.mMaxColors = (byte) 12;
            Palette paletteGenerate2 = builder3.generate();
            swatch = paletteGenerate2.mDominantSwatch;
            if (swatch != null) {
                i = swatch.mRgb;
            } else {
                i = -1144221;
            }
            failure = new Integer(paletteGenerate2.getColorForTarget(Target.VIBRANT, i));
            if (failure instanceof Result.Failure) {
                failure = null;
            }
            num = (Integer) failure;
            if (num != null) {
                iIntValue = num.intValue();
            }
        }
        rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1080.0f, 1350.0f);
        paint = new Paint(3);
        paint.setColor(-15987954);
        canvas.drawRect(rectF, paint);
        obj2 = ref$ObjectRef.element;
        if (obj2 != null) {
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap((Bitmap) obj2, 24, 24, true);
            bitmapCreateScaledBitmap2.getClass();
            canvas.drawBitmap(bitmapCreateScaledBitmap2, (Rect) null, rectF, paint);
            paint.setColor(-1728053248);
            canvas.drawRect(rectF, paint);
        }
        int iArgb2 = Color.argb(150, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
        Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1188.0f, iArgb2, 0, tileMode2));
        canvas.drawRect(rectF, paint);
        paint.setShader(new RadialGradient(1080.0f, 1282.5f, 1080.0f, Color.argb(90, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)), 0, tileMode2));
        canvas.drawRect(rectF, paint);
        paint.setShader(null);
        RectF rectF4 = new RectF(80.0f, 110.0f, 1000.0f, 1200.0f);
        Paint.Style style3 = Paint.Style.FILL;
        paint.setStyle(style3);
        paint.setColor(452984831);
        canvas.drawRoundRect(rectF4, 84.0f, 84.0f, paint);
        paint.setShader(new LinearGradient(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, new int[]{-1711276033, 234881023, 1509949439}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.55f, 1.0f}, tileMode2));
        Paint.Style style4 = Paint.Style.STROKE;
        paint.setStyle(style4);
        paint.setStrokeWidth(2.5f);
        canvas.drawRoundRect(rectF4, 84.0f, 84.0f, paint);
        paint.setShader(null);
        paint.setStyle(style3);
        float fWidth2 = rectF4.width() - 200.0f;
        float f6 = rectF4.left + 100.0f;
        float f7 = rectF4.top + 60.0f;
        rectF2 = new RectF(f6, f7, f6 + fWidth2, fWidth2 + f7);
        Paint paint3 = new Paint(1);
        paint3.setColor(-16777216);
        paint3.setShadowLayer(60.0f, CropImageView.DEFAULT_ASPECT_RATIO, 30.0f, -1728053248);
        canvas.drawRoundRect(rectF2, 56.0f, 56.0f, paint3);
        if (ref$ObjectRef.element != null) {
            Path path2 = new Path();
            path2.addRoundRect(rectF2, 56.0f, 56.0f, Path.Direction.CW);
            iSave3 = canvas.save();
            canvas.clipPath(path2);
            int iMin2 = Math.min(((Bitmap) ref$ObjectRef.element).getWidth(), ((Bitmap) ref$ObjectRef.element).getHeight());
            canvas.drawBitmap((Bitmap) ref$ObjectRef.element, new Rect((((Bitmap) ref$ObjectRef.element).getWidth() - iMin2) / 2, (((Bitmap) ref$ObjectRef.element).getHeight() - iMin2) / 2, (((Bitmap) ref$ObjectRef.element).getWidth() + iMin2) / 2, (((Bitmap) ref$ObjectRef.element).getHeight() + iMin2) / 2), rectF2, paint);
            canvas.restoreToCount(iSave3);
            f = 56.0f;
        } else {
            paint.setColor(Color.argb(200, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
            f = 56.0f;
            canvas.drawRoundRect(rectF2, 56.0f, 56.0f, paint);
        }
        paint.setColor(1090519039);
        paint.setStyle(style4);
        paint.setStrokeWidth(2.0f);
        canvas.drawRoundRect(rectF2, f, f, paint);
        paint.setStyle(style3);
        font = ResourcesCompat.getFont(context, R.font.dm_sans);
        if (font != null) {
            typefaceCreate = Typeface.DEFAULT_BOLD;
        } else {
            typefaceCreate = Typeface.DEFAULT_BOLD;
        }
        if (font != null) {
            typefaceCreate2 = Typeface.DEFAULT;
        } else {
            typefaceCreate2 = Typeface.DEFAULT;
        }
        float f8 = rectF4.left + 100.0f;
        int iWidth2 = (int) (rectF4.width() - 200.0f);
        TextPaint textPaint6 = new TextPaint(1);
        textPaint6.setColor(-1);
        textPaint6.setTextSize(58.0f);
        textPaint6.setTypeface(typefaceCreate);
        String str5 = this.$title;
        StaticLayout.Builder maxLines2 = StaticLayout.Builder.obtain(str5, 0, str5.length(), textPaint6, iWidth2).setMaxLines(2);
        TextUtils.TruncateAt truncateAt2 = TextUtils.TruncateAt.END;
        StaticLayout staticLayoutBuild4 = maxLines2.setEllipsize(truncateAt2).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
        staticLayoutBuild4.getClass();
        float f9 = rectF2.bottom + 56.0f;
        iSave = canvas.save();
        canvas.translate(f8, f9);
    }
}
