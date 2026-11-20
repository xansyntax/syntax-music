package androidx.compose.ui.graphics.vector;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.emoji2.text.EmojiProcessor;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GroupComponent extends VNode {
    public AndroidPath clipPath;
    public float[] groupMatrix;
    public Function1 invalidateListener;
    public float pivotX;
    public float pivotY;
    public float rotation;
    public float translationX;
    public float translationY;
    public final ArrayList children = new ArrayList();
    public boolean isTintable = true;
    public long tintColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
    public List clipPathData = EmptyList.INSTANCE;
    public boolean isClipPathDirty = true;
    public final TextKt$$ExternalSyntheticLambda2 wrappedListener = new TextKt$$ExternalSyntheticLambda2(22, this);
    public String name = "";
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public boolean isMatrixDirty = true;

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        if (this.isMatrixDirty) {
            float[] fArrM507constructorimpl$default = this.groupMatrix;
            if (fArrM507constructorimpl$default == null) {
                fArrM507constructorimpl$default = Matrix.m507constructorimpl$default();
                this.groupMatrix = fArrM507constructorimpl$default;
            } else {
                Matrix.m510resetimpl(fArrM507constructorimpl$default);
            }
            Matrix.m514translateimpl(fArrM507constructorimpl$default, this.translationX + this.pivotX, this.translationY + this.pivotY);
            Matrix.m511rotateZimpl(fArrM507constructorimpl$default, this.rotation);
            Matrix.m512scaleimpl(fArrM507constructorimpl$default, this.scaleX, this.scaleY);
            Matrix.m514translateimpl(fArrM507constructorimpl$default, -this.pivotX, -this.pivotY);
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            if (!this.clipPathData.isEmpty()) {
                AndroidPath androidPathPath = this.clipPath;
                if (androidPathPath == null) {
                    androidPathPath = AndroidPath_androidKt.Path();
                    this.clipPath = androidPathPath;
                }
                PathParserKt.toPath(this.clipPathData, androidPathPath);
            }
            this.isClipPathDirty = false;
        }
        EmojiProcessor drawContext = drawScope.getDrawContext();
        long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            EmojiProcessor emojiProcessor = (EmojiProcessor) ((DrawResult) drawContext.mSpanFactory).block;
            float[] fArr = this.groupMatrix;
            if (fArr != null) {
                emojiProcessor.getCanvas().mo454concat58bKbWc(fArr);
            }
            AndroidPath androidPath = this.clipPath;
            if (!this.clipPathData.isEmpty() && androidPath != null) {
                emojiProcessor.getCanvas().mo452clipPathmtrdDE(androidPath);
            }
            ArrayList arrayList = this.children;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((VNode) arrayList.get(i)).draw(drawScope);
            }
        } finally {
            IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final Function1 getInvalidateListener$ui() {
        return this.invalidateListener;
    }

    public final void insertAt(int i, VNode vNode) {
        ArrayList arrayList = this.children;
        if (i < arrayList.size()) {
            arrayList.set(i, vNode);
        } else {
            arrayList.add(vNode);
        }
        markTintForVNode(vNode);
        vNode.setInvalidateListener$ui(this.wrappedListener);
        invalidate();
    }

    /* JADX INFO: renamed from: markTintForColor-8_81llA, reason: not valid java name */
    public final void m576markTintForColor8_81llA(long j) {
        if (this.isTintable && j != 16) {
            long j2 = this.tintColor;
            if (j2 == 16) {
                this.tintColor = j;
            } else {
                if (Color.m485getRedimpl(j2) == Color.m485getRedimpl(j) && Color.m484getGreenimpl(j2) == Color.m484getGreenimpl(j) && Color.m482getBlueimpl(j2) == Color.m482getBlueimpl(j)) {
                    return;
                }
                this.isTintable = false;
                this.tintColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
            }
        }
    }

    public final void markTintForVNode(VNode vNode) {
        if (!(vNode instanceof PathComponent)) {
            if (vNode instanceof GroupComponent) {
                GroupComponent groupComponent = (GroupComponent) vNode;
                if (groupComponent.isTintable && this.isTintable) {
                    m576markTintForColor8_81llA(groupComponent.tintColor);
                    return;
                } else {
                    this.isTintable = false;
                    this.tintColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    return;
                }
            }
            return;
        }
        PathComponent pathComponent = (PathComponent) vNode;
        Brush brush = pathComponent.fill;
        if (this.isTintable && brush != null) {
            if (brush instanceof SolidColor) {
                m576markTintForColor8_81llA(((SolidColor) brush).value);
            } else {
                this.isTintable = false;
                this.tintColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
            }
        }
        Brush brush2 = pathComponent.stroke;
        if (this.isTintable && brush2 != null) {
            if (brush2 instanceof SolidColor) {
                m576markTintForColor8_81llA(((SolidColor) brush2).value);
            } else {
                this.isTintable = false;
                this.tintColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
            }
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setInvalidateListener$ui(TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2) {
        this.invalidateListener = textKt$$ExternalSyntheticLambda2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VGroup: ");
        sb.append(this.name);
        ArrayList arrayList = this.children;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            VNode vNode = (VNode) arrayList.get(i);
            sb.append("\t");
            sb.append(vNode.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
