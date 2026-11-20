package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.EmojiProcessor;
import coil3.size.SizeKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatCompoundButtonHelper {
    public ColorStateList mButtonTintList = null;
    public PorterDuff.Mode mButtonTintMode = null;
    public boolean mHasButtonTint = false;
    public boolean mHasButtonTintMode = false;
    public boolean mSkipNextApply;
    public final TextView mView;

    public /* synthetic */ AppCompatCompoundButtonHelper(TextView textView) {
        this.mView = textView;
    }

    public void applyButtonTint() {
        CompoundButton compoundButton = (CompoundButton) this.mView;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.mHasButtonTint) {
                    drawableMutate.setTintList(this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    drawableMutate.setTintMode(this.mButtonTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void applyCheckMarkTint() {
        AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) this.mView;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.mHasButtonTint) {
                    drawableMutate.setTintList(this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    drawableMutate.setTintMode(this.mButtonTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.mView;
        Context context = compoundButton.getContext();
        int[] iArr = R$styleable.CompoundButton;
        EmojiProcessor emojiProcessorObtainStyledAttributes = EmojiProcessor.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo;
        ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo, i);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(SizeKt.getDrawable(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(SizeKt.getDrawable(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(SizeKt.getDrawable(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(emojiProcessorObtainStyledAttributes.getColorStateList(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
            }
        } finally {
            emojiProcessorObtainStyledAttributes.recycle();
        }
    }
}
