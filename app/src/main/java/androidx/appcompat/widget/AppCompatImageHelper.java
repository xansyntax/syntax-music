package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.EmojiProcessor;
import coil3.size.SizeKt;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatImageHelper {
    public ConnectionSpec.Builder mImageTint;
    public int mLevel = 0;
    public final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    public final void applySupportImageTint() {
        ConnectionSpec.Builder builder;
        ImageView imageView = this.mView;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable == null || (builder = this.mImageTint) == null) {
            return;
        }
        int[] drawableState = imageView.getDrawableState();
        PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
        ResourceManagerInternal.tintDrawable(drawable, builder, drawableState);
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = this.mView;
        Context context = imageView.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        EmojiProcessor emojiProcessorObtainStyledAttributes = EmojiProcessor.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = SizeKt.getDrawable(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(emojiProcessorObtainStyledAttributes.getColorStateList(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
            }
        } finally {
            emojiProcessorObtainStyledAttributes.recycle();
        }
    }
}
