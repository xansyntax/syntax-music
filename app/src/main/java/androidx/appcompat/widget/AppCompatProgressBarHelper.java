package androidx.appcompat.widget;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.emoji2.viewsintegration.EmojiKeyListener;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatProgressBarHelper {
    public static final int[] TINT_ATTRS = {R.attr.indeterminateDrawable, R.attr.progressDrawable};
    public final /* synthetic */ byte $r8$classId = 0;
    public Object mSampleTile;
    public final View mView;

    public AppCompatProgressBarHelper(EditText editText) {
        this.mView = editText;
        AtomicInt atomicInt = new AtomicInt();
        atomicInt.delegate = new CallbackWrapper(editText);
        this.mSampleTile = atomicInt;
    }

    public KeyListener getKeyListener(KeyListener keyListener) {
        if ((keyListener instanceof NumberKeyListener) || (keyListener instanceof EmojiKeyListener)) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        byte b = this.$r8$classId;
        boolean z = true;
        View view = this.mView;
        switch (b) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) view;
                EmojiProcessor emojiProcessorObtainStyledAttributes = EmojiProcessor.obtainStyledAttributes(absSeekBar.getContext(), attributeSet, TINT_ATTRS, i);
                Drawable drawableIfKnown = emojiProcessorObtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    if (drawableIfKnown instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableIfKnown;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i2 = 0; i2 < numberOfFrames; i2++) {
                            Drawable drawableTileify = tileify(animationDrawable.getFrame(i2), true);
                            drawableTileify.setLevel(10000);
                            animationDrawable2.addFrame(drawableTileify, animationDrawable.getDuration(i2));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableIfKnown = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableIfKnown);
                }
                Drawable drawableIfKnown2 = emojiProcessorObtainStyledAttributes.getDrawableIfKnown(1);
                if (drawableIfKnown2 != null) {
                    absSeekBar.setProgressDrawable(tileify(drawableIfKnown2, false));
                }
                emojiProcessorObtainStyledAttributes.recycle();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) view).getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(14)) {
                        z = typedArrayObtainStyledAttributes.getBoolean(14, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    setEnabled(z);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public EmojiInputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        InputConnection inputConnection2;
        AtomicInt atomicInt = (AtomicInt) this.mSampleTile;
        if (inputConnection == null) {
            inputConnection2 = null;
        } else {
            CallbackWrapper callbackWrapper = (CallbackWrapper) atomicInt.delegate;
            if (!(inputConnection instanceof EmojiInputConnection)) {
                inputConnection = new EmojiInputConnection(editorInfo, inputConnection, (EditText) callbackWrapper.mCallback);
            }
            inputConnection2 = inputConnection;
        }
        return (EmojiInputConnection) inputConnection2;
    }

    public void setEnabled(boolean z) {
        EmojiTextWatcher emojiTextWatcher = (EmojiTextWatcher) ((CallbackWrapper) ((AtomicInt) this.mSampleTile).delegate).mExecutor;
        if (emojiTextWatcher.mEnabled != z) {
            if (emojiTextWatcher.mInitCallback != null) {
                EmojiCompat emojiCompat = EmojiCompat.get();
                EmojiTextWatcher.InitCallbackImpl initCallbackImpl = emojiTextWatcher.mInitCallback;
                emojiCompat.getClass();
                DatabaseDao_Impl.AnonymousClass17.checkNotNull(initCallbackImpl, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = emojiCompat.mInitLock;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    emojiCompat.mInitCallbacks.remove(initCallbackImpl);
                    reentrantReadWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    reentrantReadWriteLock.writeLock().unlock();
                    throw th;
                }
            }
            emojiTextWatcher.mEnabled = z;
            if (z) {
                EmojiTextWatcher.processTextOnEnablingEvent(emojiTextWatcher.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }

    public Drawable tileify(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.mSampleTile) == null) {
                this.mSampleTile = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = tileify(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
            layerDrawable2.setLayerGravity(i2, layerDrawable.getLayerGravity(i2));
            layerDrawable2.setLayerWidth(i2, layerDrawable.getLayerWidth(i2));
            layerDrawable2.setLayerHeight(i2, layerDrawable.getLayerHeight(i2));
            layerDrawable2.setLayerInsetLeft(i2, layerDrawable.getLayerInsetLeft(i2));
            layerDrawable2.setLayerInsetRight(i2, layerDrawable.getLayerInsetRight(i2));
            layerDrawable2.setLayerInsetTop(i2, layerDrawable.getLayerInsetTop(i2));
            layerDrawable2.setLayerInsetBottom(i2, layerDrawable.getLayerInsetBottom(i2));
            layerDrawable2.setLayerInsetStart(i2, layerDrawable.getLayerInsetStart(i2));
            layerDrawable2.setLayerInsetEnd(i2, layerDrawable.getLayerInsetEnd(i2));
        }
        return layerDrawable2;
    }

    public AppCompatProgressBarHelper(AbsSeekBar absSeekBar) {
        this.mView = absSeekBar;
    }
}
