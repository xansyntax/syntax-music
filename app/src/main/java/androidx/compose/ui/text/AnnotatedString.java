package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.core.provider.CallbackWrapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnnotatedString implements CharSequence {
    public final List annotations;
    public final ArrayList paragraphStylesOrNull;
    public final ArrayList spanStylesOrNull;
    public final String text;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Annotation {
    }

    static {
        CallbackWrapper callbackWrapper = SaversKt.AnnotatedStringSaver;
    }

    public AnnotatedString(List list, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.annotations = list;
        this.text = str;
        if (list != null) {
            int size = list.size();
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < size; i++) {
                Range range = (Range) list.get(i);
                Object obj = range.item;
                if (obj instanceof SpanStyle) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(range);
                } else if (obj instanceof ParagraphStyle) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(range);
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        this.spanStylesOrNull = arrayList;
        this.paragraphStylesOrNull = arrayList2;
        List listSortedWith = arrayList2 != null ? CollectionsKt.sortedWith(arrayList2, new AnnotatedString$special$$inlined$sortedBy$1((byte) 0)) : null;
        if (listSortedWith == null || listSortedWith.isEmpty()) {
            return;
        }
        int i2 = ((Range) CollectionsKt.first(listSortedWith)).end;
        MutableIntList mutableIntList = IntListKt.EmptyIntList;
        MutableIntList mutableIntList2 = new MutableIntList(1);
        mutableIntList2.add(i2);
        int size2 = listSortedWith.size();
        for (int i3 = 1; i3 < size2; i3++) {
            Range range2 = (Range) listSortedWith.get(i3);
            while (mutableIntList2._size != 0) {
                int iLast = mutableIntList2.last();
                if (range2.start < iLast) {
                    int i4 = range2.end;
                    if (i4 > iLast) {
                        InlineClassHelperKt.throwIllegalArgumentException("Paragraph overlap not allowed, end " + i4 + " should be less than or equal to " + iLast);
                        break;
                    }
                    break;
                }
                mutableIntList2.removeAt(mutableIntList2._size - 1);
            }
            mutableIntList2.add(range2.end);
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.text.charAt(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        return Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.annotations, annotatedString.annotations);
    }

    public final List getLinkAnnotations(int i) {
        List list = this.annotations;
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            Range range = (Range) obj;
            if ((range.item instanceof LinkAnnotation) && AnnotatedStringKt.intersect(0, i, range.start, range.end)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List getStringAnnotations(int i, int i2, String str) {
        List list = this.annotations;
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Range range = (Range) list.get(i3);
            Object obj = range.item;
            int i4 = range.end;
            int i5 = range.start;
            String str2 = range.tag;
            if ((obj instanceof StringAnnotation) && str.equals(str2) && AnnotatedStringKt.intersect(i, i2, i5, i4)) {
                Object obj2 = range.item;
                obj2.getClass();
                arrayList.add(new Range(((StringAnnotation) obj2).value, i5, i4, str2));
            }
        }
        return arrayList;
    }

    public final int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        List list = this.annotations;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.text.length();
    }

    public final AnnotatedString mapAnnotations(Function1 function1) {
        Builder builder = new Builder(this);
        ArrayList arrayList = builder.annotations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Range range = (Range) function1.invoke(((Builder.MutableRange) arrayList.get(i)).toRange(Integer.MIN_VALUE));
            arrayList.set(i, new Builder.MutableRange(range.item, range.start, range.end, range.tag));
        }
        return builder.toAnnotatedString();
    }

    @Override // java.lang.CharSequence
    public final AnnotatedString subSequence(int i, int i2) {
        if (!(i <= i2)) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + i + ") should be less or equal to end (" + i2 + ")");
        }
        String str = this.text;
        if (i == 0 && i2 == str.length()) {
            return this;
        }
        String strSubstring = str.substring(i, i2);
        AnnotatedString annotatedString = AnnotatedStringKt.EmptyAnnotatedString;
        if (i > i2) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + i + ") should be less than or equal to end (" + i2 + ")");
        }
        List list = this.annotations;
        ArrayList arrayList = null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Range range = (Range) list.get(i3);
                int i4 = range.start;
                int i5 = range.end;
                if (AnnotatedStringKt.intersect(i, i2, i4, i5)) {
                    arrayList2.add(new Range(range.item, Math.max(i, range.start) - i, Math.min(i2, i5) - i, range.tag));
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            }
        }
        return new AnnotatedString(arrayList, strSubstring);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.text;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder implements Appendable {
        public final ArrayList annotations;
        public final ArrayList styleStack;
        public final StringBuilder text;

        public Builder() {
            this.text = new StringBuilder(16);
            this.styleStack = new ArrayList();
            this.annotations = new ArrayList();
            new ArrayList();
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i, int i2) {
            boolean z = charSequence instanceof AnnotatedString;
            StringBuilder sb = this.text;
            if (!z) {
                sb.append(charSequence, i, i2);
                return this;
            }
            AnnotatedString annotatedString = (AnnotatedString) charSequence;
            int length = sb.length();
            sb.append((CharSequence) annotatedString.text, i, i2);
            List localAnnotations = AnnotatedStringKt.getLocalAnnotations(annotatedString, i, i2, null);
            if (localAnnotations != null) {
                int size = localAnnotations.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Range range = (Range) localAnnotations.get(i3);
                    this.annotations.add(new MutableRange(range.item, range.start + length, range.end + length, range.tag));
                }
            }
            return this;
        }

        public final void pop(int i) {
            ArrayList arrayList = this.styleStack;
            if (i >= arrayList.size()) {
                InlineClassHelperKt.throwIllegalStateException(i + " should be less than " + arrayList.size());
            }
            while (arrayList.size() - 1 >= i) {
                pop();
            }
        }

        public final void pushStringAnnotation(String str, String str2) {
            MutableRange mutableRange = new MutableRange(new StringAnnotation(str2), this.text.length(), 0, str, 4);
            ArrayList arrayList = this.styleStack;
            arrayList.add(mutableRange);
            this.annotations.add(mutableRange);
            arrayList.size();
        }

        public final int pushStyle(SpanStyle spanStyle) {
            MutableRange mutableRange = new MutableRange(spanStyle, this.text.length(), 0, null, 12);
            ArrayList arrayList = this.styleStack;
            arrayList.add(mutableRange);
            this.annotations.add(mutableRange);
            return arrayList.size() - 1;
        }

        public final AnnotatedString toAnnotatedString() {
            StringBuilder sb = this.text;
            String string = sb.toString();
            ArrayList arrayList = this.annotations;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(((MutableRange) arrayList.get(i)).toRange(sb.length()));
            }
            return new AnnotatedString(string, arrayList2);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class MutableRange {
            public int end;
            public final Object item;
            public final int start;
            public final String tag;

            public /* synthetic */ MutableRange(Annotation annotation, int i, int i2, String str, int i3) {
                this(annotation, i, (i3 & 4) != 0 ? Integer.MIN_VALUE : i2, (i3 & 8) != 0 ? "" : str);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
            }

            public final int hashCode() {
                Object obj = this.item;
                return this.tag.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.end, IntIntPair$$ExternalSyntheticOutline0.m(this.start, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
            }

            public final Range toRange(int i) {
                int i2 = this.end;
                if (i2 != Integer.MIN_VALUE) {
                    i = i2;
                }
                if (!(i != Integer.MIN_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
                }
                return new Range(this.item, this.start, i, this.tag);
            }

            public final String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ")";
            }

            public MutableRange(Object obj, int i, int i2, String str) {
                this.item = obj;
                this.start = i;
                this.end = i2;
                this.tag = str;
            }
        }

        public Builder(AnnotatedString annotatedString) {
            this();
            append(annotatedString);
        }

        public final void pop() {
            ArrayList arrayList = this.styleStack;
            if (arrayList.isEmpty()) {
                InlineClassHelperKt.throwIllegalStateException("Nothing to pop.");
            }
            ((MutableRange) arrayList.remove(arrayList.size() - 1)).end = this.text.length();
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence);
                return this;
            }
            this.text.append(charSequence);
            return this;
        }

        public final void append(String str) {
            this.text.append(str);
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(AnnotatedString annotatedString) {
            StringBuilder sb = this.text;
            int length = sb.length();
            sb.append(annotatedString.text);
            List list = annotatedString.annotations;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Range range = (Range) list.get(i);
                    this.annotations.add(new MutableRange(range.item, range.start + length, range.end + length, range.tag));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Range {
        public final int end;
        public final Object item;
        public final int start;
        public final String tag;

        public Range(Object obj, int i, int i2, String str) {
            this.item = obj;
            this.start = i;
            this.end = i2;
            this.tag = str;
            if (i <= i2) {
                return;
            }
            InlineClassHelperKt.throwIllegalArgumentException("Reversed range is not supported");
        }

        public static Range copy$default(Range range, Annotation annotation, int i, int i2) {
            Object obj = annotation;
            if ((i2 & 1) != 0) {
                obj = range.item;
            }
            int i3 = range.start;
            if ((i2 & 4) != 0) {
                i = range.end;
            }
            return new Range(obj, i3, i, range.tag);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
        }

        public final int hashCode() {
            Object obj = this.item;
            return this.tag.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.end, IntIntPair$$ExternalSyntheticOutline0.m(this.start, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
        }

        public final String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ")";
        }

        public Range(int i, int i2, Object obj) {
            this(obj, i, i2, "");
        }
    }

    public /* synthetic */ AnnotatedString(String str) {
        this(str, EmptyList.INSTANCE);
    }

    public AnnotatedString(String str, List list) {
        this(list.isEmpty() ? null : list, str);
    }
}
