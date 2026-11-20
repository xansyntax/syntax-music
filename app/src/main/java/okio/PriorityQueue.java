package okio;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuDialogHelper;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.tooling.ParseException;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.R$styleable;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.SniffFailure;
import coil3.Image;
import coil3.memory.MemoryCache$Key;
import coil3.memory.RealWeakMemoryCache$InternalValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.Maps$$ExternalSyntheticLambda1;
import com.google.common.primitives.ImmutableIntArray;
import com.google.common.util.concurrent.AbstractTransformFuture$TransformFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.metrolist.innertubex.sabr.ProtoTag;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.LinkHeader;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.json.internal.InternalJsonWriter;
import kotlinx.serialization.json.internal.StringOpsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PriorityQueue implements SniffFailure, BitmapLoader, InternalJsonWriter {
    public final /* synthetic */ byte $r8$classId;
    public Object array;
    public int size;

    public PriorityQueue(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 10:
                this.array = new LinkedHashMap();
                break;
            default:
                this.array = new ParsableByteArray(8);
                break;
        }
    }

    public static PriorityQueue createFromXml(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        float f;
        float f2;
        Shader.TileMode tileMode;
        Object radialGradient;
        Shader.TileMode tileMode2;
        int i2;
        TypedArray typedArrayObtainStyledAttributes;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        byte b = 4;
        Object obj = null;
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                return new PriorityQueue(obj, ColorStateListInflaterCompat.createFromXmlInner(resources, xml, attributeSetAsAttributeSet, theme).getDefaultColor(), b);
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        int[] iArr = R$styleable.GradientColor;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSetAsAttributeSet, iArr) : theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr, 0, 0);
        float f3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") != null ? typedArrayObtainAttributes.getFloat(8, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f;
        float f4 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") != null ? typedArrayObtainAttributes.getFloat(9, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f;
        float f5 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") != null ? typedArrayObtainAttributes.getFloat(10, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f;
        float f6 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") != null ? typedArrayObtainAttributes.getFloat(11, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f;
        float f7 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") != null ? typedArrayObtainAttributes.getFloat(3, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f;
        float f8 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") != null ? typedArrayObtainAttributes.getFloat(4, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f;
        int i3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", LinkHeader.Parameters.Type) != null ? typedArrayObtainAttributes.getInt(2, 0) : 0;
        int color = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") != null ? typedArrayObtainAttributes.getColor(0, 0) : 0;
        boolean z = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null;
        int color2 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null ? typedArrayObtainAttributes.getColor(7, 0) : 0;
        int color3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") != null ? typedArrayObtainAttributes.getColor(1, 0) : 0;
        int i4 = 1;
        int i5 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") != null ? typedArrayObtainAttributes.getInt(6, 0) : 0;
        float f9 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") != null ? typedArrayObtainAttributes.getFloat(5, CropImageView.DEFAULT_ASPECT_RATIO) : CropImageView.DEFAULT_ASPECT_RATIO;
        typedArrayObtainAttributes.recycle();
        int depth = xml.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        float f10 = f9;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            f = f3;
            if (next2 == i4) {
                f2 = f4;
                break;
            }
            int depth2 = xml.getDepth();
            f2 = f4;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                int[] iArr2 = R$styleable.GradientColorItem;
                if (theme == null) {
                    typedArrayObtainStyledAttributes = resources.obtainAttributes(attributeSetAsAttributeSet, iArr2);
                    i2 = 0;
                } else {
                    i2 = 0;
                    typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSetAsAttributeSet, iArr2, 0, 0);
                }
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
                boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color4 = typedArrayObtainStyledAttributes.getColor(0, 0);
                float f11 = typedArrayObtainStyledAttributes.getFloat(1, CropImageView.DEFAULT_ASPECT_RATIO);
                typedArrayObtainStyledAttributes.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f11));
            }
            f3 = f;
            f4 = f2;
            i4 = 1;
        }
        WeakCache weakCache = arrayList2.size() > 0 ? new WeakCache(arrayList2, arrayList) : null;
        if (weakCache == null) {
            weakCache = z ? new WeakCache(color, color2, color3) : new WeakCache(color, color3);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                int[] iArr3 = (int[]) weakCache.values;
                float[] fArr = (float[]) weakCache.referenceQueue;
                if (i5 != 1) {
                    tileMode2 = i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
                } else {
                    tileMode2 = Shader.TileMode.REPEAT;
                }
                radialGradient = new LinearGradient(f, f2, f5, f6, iArr3, fArr, tileMode2);
            } else {
                radialGradient = new SweepGradient(f7, f8, (int[]) weakCache.values, (float[]) weakCache.referenceQueue);
            }
        } else {
            if (f10 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
            int[] iArr4 = (int[]) weakCache.values;
            float[] fArr2 = (float[]) weakCache.referenceQueue;
            if (i5 != 1) {
                tileMode = i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
            } else {
                tileMode = Shader.TileMode.REPEAT;
            }
            radialGradient = new RadialGradient(f7, f8, f10, iArr4, fArr2, tileMode);
        }
        return new PriorityQueue(radialGradient, 0, (byte) 4);
    }

    public void advance(int i) {
        int i2 = this.size;
        int i3 = i + i2;
        if (i3 < i2 || i3 > ((byte[]) this.array).length) {
            throw new IllegalSeekPositionException("Truncated protobuf field");
        }
        this.size = i3;
    }

    public boolean atEnd() {
        return this.size >= ((String) this.array).length();
    }

    public byte[] bytes() {
        long jVarint = varint();
        if (jVarint < 0 || jVarint > 2147483647L) {
            throw new IllegalSeekPositionException(Format$$ExternalSyntheticOutline0.m(jVarint, "Invalid protobuf length "));
        }
        int i = this.size;
        int i2 = ((int) jVarint) + i;
        if (i2 >= i) {
            byte[] bArr = (byte[]) this.array;
            if (i2 <= bArr.length) {
                byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, i, i2);
                this.size = i2;
                return bArrCopyOfRange;
            }
        }
        throw new IllegalSeekPositionException("Truncated protobuf field");
    }

    public void cleanUpIfNecessary() {
        int i = this.size;
        this.size = i + 1;
        if (i >= 10) {
            this.size = 0;
            Iterator it = ((LinkedHashMap) this.array).values().iterator();
            while (it.hasNext()) {
                ArrayList arrayList = (ArrayList) it.next();
                if (arrayList.size() <= 1) {
                    RealWeakMemoryCache$InternalValue realWeakMemoryCache$InternalValue = (RealWeakMemoryCache$InternalValue) CollectionsKt.firstOrNull((List) arrayList);
                    if ((realWeakMemoryCache$InternalValue != null ? (Image) realWeakMemoryCache$InternalValue.image.get() : null) == null) {
                        it.remove();
                    }
                } else {
                    int size = arrayList.size();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size; i3++) {
                        int i4 = i3 - i2;
                        if (((RealWeakMemoryCache$InternalValue) arrayList.get(i4)).image.get() == null) {
                            arrayList.remove(i4);
                            i2++;
                        }
                    }
                    if (arrayList.isEmpty()) {
                        it.remove();
                    }
                }
            }
        }
    }

    public AlertDialog create() {
        final AlertController.AlertParams alertParams = (AlertController.AlertParams) this.array;
        ContextThemeWrapper contextThemeWrapper = alertParams.mContext;
        AlertDialog alertDialog = new AlertDialog(contextThemeWrapper, this.size);
        View view = alertParams.mCustomTitleView;
        final AlertController alertController = alertDialog.mAlert;
        if (view != null) {
            alertController.mCustomTitleView = view;
        } else {
            CharSequence charSequence = alertParams.mTitle;
            if (charSequence != null) {
                alertController.mTitle = charSequence;
                TextView textView = alertController.mTitleView;
                if (textView != null) {
                    textView.setText(charSequence);
                }
                alertController.mWindow.setTitle(charSequence);
            }
            Drawable drawable = alertParams.mIcon;
            if (drawable != null) {
                alertController.mIcon = drawable;
                ImageView imageView = alertController.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    alertController.mIconView.setImageDrawable(drawable);
                }
            }
        }
        if (alertParams.mAdapter != null) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            int i = alertParams.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
            ListAdapter checkedItemAdapter = alertParams.mAdapter;
            if (checkedItemAdapter == null) {
                checkedItemAdapter = new AlertController.CheckedItemAdapter(contextThemeWrapper, i, R.id.text1, null);
            }
            alertController.mAdapter = checkedItemAdapter;
            alertController.mCheckedItem = alertParams.mCheckedItem;
            if (alertParams.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                        AlertParams alertParams2 = AlertParams.this;
                        DialogInterface.OnClickListener onClickListener = alertParams2.mOnClickListener;
                        AlertController alertController2 = alertController;
                        onClickListener.onClick(alertController2.mDialog, i2);
                        if (alertParams2.mIsSingleChoice) {
                            return;
                        }
                        alertController2.mDialog.dismiss();
                    }
                });
            }
            if (alertParams.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            }
            alertController.mListView = recycleListView;
        }
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        MenuDialogHelper menuDialogHelper = alertParams.mOnKeyListener;
        if (menuDialogHelper != null) {
            alertDialog.setOnKeyListener(menuDialogHelper);
        }
        return alertDialog;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture decodeBitmap(byte[] bArr) {
        return AbstractTransformFuture$TransformFuture.create(((BitmapLoader) this.array).decodeBitmap(bArr), new Maps$$ExternalSyntheticLambda1((byte) 4, this));
    }

    public void ensureTotalCapacity(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = (char[]) this.array;
        if (cArr.length <= i3) {
            int i4 = i * 2;
            if (i3 < i4) {
                i3 = i4;
            }
            this.array = Arrays.copyOf(cArr, i3);
        }
    }

    public void expect() throws ParseException {
        if (matches(')')) {
            return;
        }
        throwParseError("expected )");
        throw null;
    }

    public void heapifyUp(int i, AsyncTimeout asyncTimeout) {
        while (true) {
            int i2 = i >> 1;
            if (i2 == 0) {
                break;
            }
            AsyncTimeout asyncTimeout2 = ((AsyncTimeout[]) this.array)[i2];
            asyncTimeout2.getClass();
            if (Intrinsics.compare(0L, asyncTimeout.timeoutAt - asyncTimeout2.timeoutAt) <= 0) {
                break;
            }
            asyncTimeout2.index = i;
            ((AsyncTimeout[]) this.array)[i] = asyncTimeout2;
            i = i2;
        }
        ((AsyncTimeout[]) this.array)[i] = asyncTimeout;
        asyncTimeout.index = i;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture loadBitmap(Uri uri) {
        return AbstractTransformFuture$TransformFuture.create(((BitmapLoader) this.array).loadBitmap(uri), new Maps$$ExternalSyntheticLambda1((byte) 4, this));
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        ListenableFuture listenableFutureLoadBitmapFromMetadata = ((BitmapLoader) this.array).loadBitmapFromMetadata(mediaMetadata);
        if (listenableFutureLoadBitmapFromMetadata == null) {
            return null;
        }
        return AbstractTransformFuture$TransformFuture.create(listenableFutureLoadBitmapFromMetadata, new Maps$$ExternalSyntheticLambda1((byte) 4, this));
    }

    public boolean matches(char c) {
        int i = this.size;
        String str = (String) this.array;
        return i < str.length() && str.charAt(this.size) == c;
    }

    public long readUint(DefaultExtractorInput defaultExtractorInput) {
        ParsableByteArray parsableByteArray = (ParsableByteArray) this.array;
        int i = 0;
        defaultExtractorInput.peekFully(parsableByteArray.data, 0, 1, false);
        int i2 = parsableByteArray.data[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        defaultExtractorInput.peekFully(parsableByteArray.data, 1, i4, false);
        while (i < i4) {
            i++;
            i5 = (parsableByteArray.data[i] & 255) + (i5 << 8);
        }
        this.size = i4 + 1 + this.size;
        return i5;
    }

    public void remove(AsyncTimeout asyncTimeout) {
        AsyncTimeout asyncTimeout2;
        int i = asyncTimeout.index;
        if (i == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return;
        }
        int i2 = this.size;
        AsyncTimeout asyncTimeout3 = ((AsyncTimeout[]) this.array)[i2];
        asyncTimeout3.getClass();
        asyncTimeout.index = -1;
        ((AsyncTimeout[]) this.array)[i2] = null;
        this.size = i2 - 1;
        if (asyncTimeout == asyncTimeout3) {
            return;
        }
        int iCompare = Intrinsics.compare(0L, asyncTimeout3.timeoutAt - asyncTimeout.timeoutAt);
        if (iCompare == 0) {
            ((AsyncTimeout[]) this.array)[i] = asyncTimeout3;
            asyncTimeout3.index = i;
            return;
        }
        if (iCompare >= 0) {
            heapifyUp(i, asyncTimeout3);
            return;
        }
        while (true) {
            int i3 = i << 1;
            int i4 = i3 + 1;
            int i5 = this.size;
            if (i4 > i5) {
                if (i3 > i5) {
                    break;
                }
                asyncTimeout2 = ((AsyncTimeout[]) this.array)[i3];
                asyncTimeout2.getClass();
            } else {
                asyncTimeout2 = ((AsyncTimeout[]) this.array)[i3];
                asyncTimeout2.getClass();
                AsyncTimeout asyncTimeout4 = ((AsyncTimeout[]) this.array)[i4];
                asyncTimeout4.getClass();
                if (Intrinsics.compare(0L, asyncTimeout4.timeoutAt - asyncTimeout2.timeoutAt) >= 0) {
                    asyncTimeout2 = asyncTimeout4;
                }
            }
            if (Intrinsics.compare(0L, asyncTimeout2.timeoutAt - asyncTimeout3.timeoutAt) <= 0) {
                break;
            }
            int i6 = asyncTimeout2.index;
            asyncTimeout2.index = i;
            ((AsyncTimeout[]) this.array)[i] = asyncTimeout2;
            i = i6;
        }
        ((AsyncTimeout[]) this.array)[i] = asyncTimeout3;
        asyncTimeout3.index = i;
    }

    public void set(MemoryCache$Key memoryCache$Key, Image image, Map map, long j) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.array;
        Object arrayList = linkedHashMap.get(memoryCache$Key);
        if (arrayList == null) {
            arrayList = new ArrayList();
            linkedHashMap.put(memoryCache$Key, arrayList);
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        RealWeakMemoryCache$InternalValue realWeakMemoryCache$InternalValue = new RealWeakMemoryCache$InternalValue(new WeakReference(image), map, j);
        if (arrayList2.isEmpty()) {
            arrayList2.add(realWeakMemoryCache$InternalValue);
        } else {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                RealWeakMemoryCache$InternalValue realWeakMemoryCache$InternalValue2 = (RealWeakMemoryCache$InternalValue) arrayList2.get(i);
                if (j >= realWeakMemoryCache$InternalValue2.size) {
                    if (realWeakMemoryCache$InternalValue2.image.get() == image) {
                        arrayList2.set(i, realWeakMemoryCache$InternalValue);
                        break;
                    } else {
                        arrayList2.add(i, realWeakMemoryCache$InternalValue);
                        break;
                    }
                }
            }
        }
        cleanUpIfNecessary();
    }

    public void skip(ProtoTag protoTag) {
        int i = protoTag.wireType;
        if (i == 0) {
            varint();
            return;
        }
        if (i == 1) {
            advance(8);
            return;
        }
        if (i != 2) {
            if (i != 5) {
                throw new IllegalSeekPositionException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unsupported protobuf wire type "));
            }
            advance(4);
        } else {
            long jVarint = varint();
            if (jVarint < 0 || jVarint > 2147483647L) {
                throw new IllegalSeekPositionException(Format$$ExternalSyntheticOutline0.m(jVarint, "Invalid protobuf length "));
            }
            advance((int) jVarint);
        }
    }

    public ProtoTag tag() {
        long jVarint = varint();
        long j = jVarint >>> 3;
        if (1 > j || j >= 536870912 || (19000 <= j && j < 20000)) {
            throw new IllegalSeekPositionException(Format$$ExternalSyntheticOutline0.m(j, "Invalid protobuf field number "));
        }
        return new ProtoTag((int) j, (int) (jVarint & 7));
    }

    public int takeIntUntil(String str) throws ParseException {
        Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, takeUntil(str));
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throwParseError("expected int");
        throw null;
    }

    public String takeUntil(String str) {
        int i = this.size;
        String str2 = (String) this.array;
        while (this.size < str2.length() && !StringsKt.contains$default(str, str2.charAt(this.size))) {
            this.size++;
        }
        int i2 = this.size;
        return i2 > i ? str2.substring(i, i2) : "";
    }

    public void throwParseError(String str) throws ParseException {
        int i = this.size;
        String str2 = (String) this.array;
        int iMin = Math.min(i, str2.length());
        String strSubstring = str2.substring(0, iMin);
        String strSubstring2 = str2.substring(iMin);
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Error while parsing source information: ", str, " at ", strSubstring, "|");
        sbM.append(strSubstring2);
        throw new ParseException(sbM.toString());
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 7:
                ImmutableIntArray immutableIntArray = (ImmutableIntArray) this.array;
                int i = immutableIntArray.end;
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(Util.toFourccString(immutableIntArray.get(i2)));
                }
                return "UnsupportedBrands{major=" + Util.toFourccString(this.size) + ", compatible=" + arrayList + "}";
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new String((char[]) this.array, 0, this.size);
            default:
                return super.toString();
        }
    }

    public long varint() {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            int i3 = this.size;
            byte[] bArr = (byte[]) this.array;
            if (i3 >= bArr.length) {
                throw new IllegalSeekPositionException("Truncated protobuf varint");
            }
            this.size = i3 + 1;
            byte b = bArr[i3];
            if (i == 63 && ((b & 127) > 1 || (b & 128) != 0)) {
                throw new IllegalSeekPositionException("Protobuf varint overflows 64 bits");
            }
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
            i += 7;
        }
        throw new IllegalSeekPositionException("Protobuf varint is too long");
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String str) {
        str.getClass();
        int length = str.length();
        if (length == 0) {
            return;
        }
        ensureTotalCapacity(this.size, length);
        str.getChars(0, str.length(), (char[]) this.array, this.size);
        this.size += length;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char c) {
        ensureTotalCapacity(this.size, 1);
        char[] cArr = (char[]) this.array;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long j) {
        write(String.valueOf(j));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String str) {
        byte b;
        str.getClass();
        ensureTotalCapacity(this.size, str.length() + 2);
        char[] cArr = (char[]) this.array;
        int i = this.size;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        int i4 = i2;
        while (i4 < i3) {
            char c = cArr[i4];
            byte[] bArr = StringOpsKt.ESCAPE_MARKERS;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = str.length();
                for (int i5 = i4 - i2; i5 < length2; i5++) {
                    ensureTotalCapacity(i4, 2);
                    char cCharAt = str.charAt(i5);
                    byte[] bArr2 = StringOpsKt.ESCAPE_MARKERS;
                    if (cCharAt >= bArr2.length || (b = bArr2[cCharAt]) == 0) {
                        int i6 = i4 + 1;
                        ((char[]) this.array)[i4] = cCharAt;
                        i4 = i6;
                    } else if (b == 1) {
                        String str2 = StringOpsKt.ESCAPE_STRINGS[cCharAt];
                        str2.getClass();
                        ensureTotalCapacity(i4, str2.length());
                        str2.getChars(0, str2.length(), (char[]) this.array, i4);
                        int length3 = str2.length() + i4;
                        this.size = length3;
                        i4 = length3;
                    } else {
                        char[] cArr2 = (char[]) this.array;
                        cArr2[i4] = '\\';
                        cArr2[i4 + 1] = (char) b;
                        i4 += 2;
                        this.size = i4;
                    }
                }
                ensureTotalCapacity(i4, 1);
                ((char[]) this.array)[i4] = '\"';
                this.size = i4 + 1;
                return;
            }
            i4++;
        }
        cArr[i3] = '\"';
        this.size = i3 + 1;
    }

    public /* synthetic */ PriorityQueue(Serializable serializable, byte b) {
        this.$r8$classId = b;
        this.array = serializable;
    }

    public /* synthetic */ PriorityQueue(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.array = obj;
        this.size = i;
    }

    public PriorityQueue(int i, List list) {
        this.$r8$classId = (byte) 2;
        this.size = i;
        this.array = list;
    }

    public /* synthetic */ PriorityQueue(byte b, boolean z) {
        this.$r8$classId = b;
    }

    public PriorityQueue(int i, int[] iArr) {
        ImmutableIntArray immutableIntArray;
        this.$r8$classId = (byte) 7;
        this.size = i;
        if (iArr != null) {
            ImmutableIntArray immutableIntArray2 = ImmutableIntArray.EMPTY;
            immutableIntArray = iArr.length == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
        } else {
            immutableIntArray = ImmutableIntArray.EMPTY;
        }
        this.array = immutableIntArray;
    }

    public PriorityQueue(int i, Notification notification) {
        this.$r8$classId = (byte) 8;
        this.size = i;
        notification.getClass();
        this.array = notification;
    }

    public PriorityQueue(Context context) {
        this.$r8$classId = (byte) 1;
        int iResolveDialogTheme = AlertDialog.resolveDialogTheme(context, 0);
        this.array = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, iResolveDialogTheme)));
        this.size = iResolveDialogTheme;
    }

    public PriorityQueue(boolean z, boolean z2, boolean z3) {
        this.$r8$classId = (byte) 5;
        this.size = (z || z2 || z3) ? 1 : 0;
    }
}
