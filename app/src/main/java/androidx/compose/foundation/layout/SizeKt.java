package androidx.compose.foundation.layout;

import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SizeKt {
    public static final FillElement FillWholeMaxHeight;
    public static final FillElement FillWholeMaxSize;
    public static final FillElement FillWholeMaxWidth;
    public static final WrapContentElement WrapContentHeightCenter;
    public static final WrapContentElement WrapContentHeightTop;
    public static final WrapContentElement WrapContentSizeCenter;
    public static final WrapContentElement WrapContentSizeTopStart;
    public static final WrapContentElement WrapContentWidthCenter;
    public static final WrapContentElement WrapContentWidthStart;

    static {
        Direction direction = Direction.Horizontal;
        FillWholeMaxWidth = new FillElement(direction, 1.0f);
        Direction direction2 = Direction.Vertical;
        FillWholeMaxHeight = new FillElement(direction2, 1.0f);
        Direction direction3 = Direction.Both;
        FillWholeMaxSize = new FillElement(direction3, 1.0f);
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        byte b = 4;
        WrapContentWidthCenter = new WrapContentElement(direction, new ComposerKt$$ExternalSyntheticLambda0(b, horizontal), horizontal);
        BiasAlignment.Horizontal horizontal2 = Alignment.Companion.Start;
        WrapContentWidthStart = new WrapContentElement(direction, new ComposerKt$$ExternalSyntheticLambda0(b, horizontal2), horizontal2);
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        byte b2 = 5;
        WrapContentHeightCenter = new WrapContentElement(direction2, new ComposerKt$$ExternalSyntheticLambda0(b2, vertical), vertical);
        BiasAlignment.Vertical vertical2 = Alignment.Companion.Top;
        WrapContentHeightTop = new WrapContentElement(direction2, new ComposerKt$$ExternalSyntheticLambda0(b2, vertical2), vertical2);
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        byte b3 = 6;
        WrapContentSizeCenter = new WrapContentElement(direction3, new ComposerKt$$ExternalSyntheticLambda0(b3, biasAlignment), biasAlignment);
        BiasAlignment biasAlignment2 = Alignment.Companion.TopStart;
        WrapContentSizeTopStart = new WrapContentElement(direction3, new ComposerKt$$ExternalSyntheticLambda0(b3, biasAlignment2), biasAlignment2);
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m143defaultMinSizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new UnspecifiedConstraintsElement(f, f2));
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m144defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = Float.NaN;
        }
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        return m143defaultMinSizeVpY3zN4(modifier, f, f2);
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxWidth : new FillElement(Direction.Horizontal, f));
    }

    /* JADX INFO: renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m145height3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO, f, 5));
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m146heightInVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO, f2, 5));
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m147heightInVpY3zN4$default(Modifier modifier, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = Float.NaN;
        }
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        return m146heightInVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m148requiredSize3ABfNKs(Modifier modifier) {
        return modifier.then(new SizeElement(20.0f, 20.0f, 20.0f, 20.0f, false));
    }

    /* JADX INFO: renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m149requiredSizeVpY3zN4(Modifier modifier) {
        return modifier.then(new SizeElement(52.0f, 32.0f, 52.0f, 32.0f, false));
    }

    /* JADX INFO: renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m151size3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, f, f, f, true));
    }

    /* JADX INFO: renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m152sizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, true));
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m153sizeInqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, true));
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m154sizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, int i) {
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        if ((i & 4) != 0) {
            f3 = Float.NaN;
        }
        return m153sizeInqDBjuR0(modifier, f, f2, f3, Float.NaN);
    }

    /* JADX INFO: renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m155width3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO, 10));
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m156widthInVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, CropImageView.DEFAULT_ASPECT_RATIO, f2, CropImageView.DEFAULT_ASPECT_RATIO, 10));
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m157widthInVpY3zN4$default(Modifier modifier, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = Float.NaN;
        }
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        return m156widthInVpY3zN4(modifier, f, f2);
    }

    public static Modifier wrapContentHeight$default(Modifier modifier) {
        WrapContentElement wrapContentElement;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        if (Intrinsics.areEqual(vertical, vertical)) {
            wrapContentElement = WrapContentHeightCenter;
        } else if (Intrinsics.areEqual(vertical, Alignment.Companion.Top)) {
            wrapContentElement = WrapContentHeightTop;
        } else {
            wrapContentElement = new WrapContentElement(Direction.Vertical, new ComposerKt$$ExternalSyntheticLambda0((byte) 5, vertical), vertical);
        }
        return modifier.then(wrapContentElement);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Modifier wrapContentSize$default(Modifier modifier) {
        WrapContentElement wrapContentElement;
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        if (biasAlignment.equals(biasAlignment)) {
            wrapContentElement = WrapContentSizeCenter;
        } else if (biasAlignment.equals(Alignment.Companion.TopStart)) {
            wrapContentElement = WrapContentSizeTopStart;
        } else {
            wrapContentElement = new WrapContentElement(Direction.Both, new ComposerKt$$ExternalSyntheticLambda0((byte) 6, biasAlignment), biasAlignment);
        }
        return modifier.then(wrapContentElement);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Modifier wrapContentWidth$default(Modifier modifier, int i) {
        WrapContentElement wrapContentElement;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        if (horizontal.equals(horizontal)) {
            wrapContentElement = WrapContentWidthCenter;
        } else if (horizontal.equals(Alignment.Companion.Start)) {
            wrapContentElement = WrapContentWidthStart;
        } else {
            wrapContentElement = new WrapContentElement(Direction.Horizontal, new ComposerKt$$ExternalSyntheticLambda0((byte) 4, horizontal), horizontal);
        }
        return modifier.then(wrapContentElement);
    }
}
