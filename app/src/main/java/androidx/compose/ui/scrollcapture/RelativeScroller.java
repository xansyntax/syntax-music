package androidx.compose.ui.scrollcapture;

import androidx.compose.material3.carousel.Keyline;
import androidx.compose.material3.carousel.KeylineListScopeImpl$TmpKeyline;
import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.android.TextLayout;
import com.metrolist.music.playback.MusicService;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.ranges.IntProgressionIterator;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeScroller {
    public float scrollAmount;
    public final Object scrollBy;
    public int viewportSize;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RelativeScroller.this.scrollBy(CropImageView.DEFAULT_ASPECT_RATIO, this);
        }
    }

    public RelativeScroller() {
        this.viewportSize = -1;
        this.scrollBy = new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:47:0x0113  */
    /* JADX WARN: Code duplicated, block: B:52:0x011e  */
    public static List createKeylinesWithPivot(int i, float f, int i2, int i3, float f2, float f3, float f4, ArrayList arrayList) {
        float f5;
        float f6;
        boolean z;
        float f7;
        float f8;
        IntProgressionIterator intProgressionIterator;
        float f9;
        float f10;
        Iterator it;
        float f11;
        int iNextInt;
        float f12;
        float f13;
        float f14;
        boolean z2;
        int iNextInt2;
        float f15;
        float f16;
        float fAbs;
        boolean z3;
        if (arrayList.isEmpty() || i < 0 || i >= arrayList.size()) {
            return EmptyList.INSTANCE;
        }
        KeylineListScopeImpl$TmpKeyline keylineListScopeImpl$TmpKeyline = (KeylineListScopeImpl$TmpKeyline) arrayList.get(i);
        ArrayList arrayList2 = new ArrayList();
        float f17 = keylineListScopeImpl$TmpKeyline.size;
        float f18 = f17 / 2.0f;
        if (f - f18 >= CropImageView.DEFAULT_ASPECT_RATIO || f + f18 <= CropImageView.DEFAULT_ASPECT_RATIO) {
            float f19 = f17 / 2.0f;
            if (f - f19 >= f3 || f + f19 <= f3) {
                f5 = 0.0f;
            } else {
                f6 = (f19 + f) - f3;
            }
            if (i2 <= i || i > i3) {
                z = false;
            } else {
                z = true;
            }
            arrayList2.add(new Keyline(f17, f, f, z, keylineListScopeImpl$TmpKeyline.isAnchor, true, f5));
            f7 = f2 / 2.0f;
            f8 = (f - f7) - f4;
            int i4 = i - 1;
            intProgressionIterator = new IntProgressionIterator(i4, UuidKt.getProgressionLastElement(i4, 0, -1), -1);
            f9 = f8;
            while (intProgressionIterator.hasNext) {
                iNextInt2 = intProgressionIterator.nextInt();
                KeylineListScopeImpl$TmpKeyline keylineListScopeImpl$TmpKeyline2 = (KeylineListScopeImpl$TmpKeyline) arrayList.get(iNextInt2);
                float f20 = keylineListScopeImpl$TmpKeyline2.size;
                f15 = f20 / 2.0f;
                f16 = f8 - f15;
                float f21 = f9 - f7;
                if (f16 - f15 < CropImageView.DEFAULT_ASPECT_RATIO || f16 + f15 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                    fAbs = 0.0f;
                } else {
                    fAbs = Math.abs(f16 - (f20 / 2.0f));
                }
                float f22 = keylineListScopeImpl$TmpKeyline2.size;
                if (i2 <= iNextInt2 || iNextInt2 > i3) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                arrayList2.add(0, new Keyline(f22, f16, f21, z3, keylineListScopeImpl$TmpKeyline2.isAnchor, false, fAbs));
                f8 -= f20 + f4;
                f9 -= f2 + f4;
            }
            f10 = f + f7 + f4;
            it = UuidKt.until(i + 1, arrayList.size()).iterator();
            f11 = f10;
            while (((IntProgressionIterator) it).hasNext) {
                iNextInt = ((IntIterator) it).nextInt();
                KeylineListScopeImpl$TmpKeyline keylineListScopeImpl$TmpKeyline3 = (KeylineListScopeImpl$TmpKeyline) arrayList.get(iNextInt);
                float f23 = keylineListScopeImpl$TmpKeyline3.size;
                f12 = f23 / 2.0f;
                f13 = f12 + f10;
                float f24 = f11 + f7;
                if (f13 - f12 < f3 || f13 + f12 <= f3) {
                    f14 = 0.0f;
                } else {
                    f14 = ((f23 / 2.0f) + f13) - f3;
                }
                if (i2 <= iNextInt || iNextInt > i3) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                arrayList2.add(new Keyline(f23, f13, f24, z2, keylineListScopeImpl$TmpKeyline3.isAnchor, false, f14));
                f10 += f23 + f4;
                f11 += f2 + f4;
            }
            return arrayList2;
        }
        f6 = f - (f17 / 2.0f);
        f5 = f6;
        if (i2 <= i) {
            z = false;
        } else {
            z = false;
        }
        arrayList2.add(new Keyline(f17, f, f, z, keylineListScopeImpl$TmpKeyline.isAnchor, true, f5));
        f7 = f2 / 2.0f;
        f8 = (f - f7) - f4;
        int i5 = i - 1;
        intProgressionIterator = new IntProgressionIterator(i5, UuidKt.getProgressionLastElement(i5, 0, -1), -1);
        f9 = f8;
        while (intProgressionIterator.hasNext) {
            iNextInt2 = intProgressionIterator.nextInt();
            KeylineListScopeImpl$TmpKeyline keylineListScopeImpl$TmpKeyline4 = (KeylineListScopeImpl$TmpKeyline) arrayList.get(iNextInt2);
            float f25 = keylineListScopeImpl$TmpKeyline4.size;
            f15 = f25 / 2.0f;
            f16 = f8 - f15;
            float f26 = f9 - f7;
            if (f16 - f15 < CropImageView.DEFAULT_ASPECT_RATIO) {
                fAbs = 0.0f;
            } else {
                fAbs = 0.0f;
            }
            float f27 = keylineListScopeImpl$TmpKeyline4.size;
            if (i2 <= iNextInt2) {
                z3 = false;
            } else {
                z3 = false;
            }
            arrayList2.add(0, new Keyline(f27, f16, f26, z3, keylineListScopeImpl$TmpKeyline4.isAnchor, false, fAbs));
            f8 -= f25 + f4;
            f9 -= f2 + f4;
        }
        f10 = f + f7 + f4;
        it = UuidKt.until(i + 1, arrayList.size()).iterator();
        f11 = f10;
        while (((IntProgressionIterator) it).hasNext) {
            iNextInt = ((IntIterator) it).nextInt();
            KeylineListScopeImpl$TmpKeyline keylineListScopeImpl$TmpKeyline5 = (KeylineListScopeImpl$TmpKeyline) arrayList.get(iNextInt);
            float f28 = keylineListScopeImpl$TmpKeyline5.size;
            f12 = f28 / 2.0f;
            f13 = f12 + f10;
            float f29 = f11 + f7;
            if (f13 - f12 < f3) {
                f14 = 0.0f;
            } else {
                f14 = 0.0f;
            }
            if (i2 <= iNextInt) {
                z2 = false;
            } else {
                z2 = false;
            }
            arrayList2.add(new Keyline(f28, f13, f29, z2, keylineListScopeImpl$TmpKeyline5.isAnchor, false, f14));
            f10 += f28 + f4;
            f11 += f2 + f4;
        }
        return arrayList2;
    }

    public void add(float f, boolean z) {
        ArrayList arrayList = (ArrayList) this.scrollBy;
        arrayList.add(new KeylineListScopeImpl$TmpKeyline(f, z));
        if (z || f <= this.scrollAmount) {
            return;
        }
        this.viewportSize = arrayList.size() - 1;
        this.scrollAmount = f;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    public float get(int i, boolean z, boolean z2, boolean z3) {
        boolean z4;
        TextLayout textLayout = (TextLayout) this.scrollBy;
        int i2 = 1;
        if (z) {
            int lineForOffset = StaticLayoutFactory.getLineForOffset(textLayout.layout, i, z);
            int lineStart = textLayout.layout.getLineStart(lineForOffset);
            int lineEnd = textLayout.getLineEnd(lineForOffset);
            if (i == lineStart || i == lineEnd) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        int i3 = i * 4;
        if (!z3) {
            i2 = z4 ? 2 : 3;
        } else if (z4) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if (this.viewportSize == i4) {
            return this.scrollAmount;
        }
        float primaryHorizontal = z3 ? textLayout.getPrimaryHorizontal(i, z) : textLayout.getSecondaryHorizontal(i, z);
        if (z2) {
            this.viewportSize = i4;
            this.scrollAmount = primaryHorizontal;
        }
        return primaryHorizontal;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object scrollBy(float f, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objInvoke = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            MusicService.AnonymousClass14 anonymousClass14 = (MusicService.AnonymousClass14) this.scrollBy;
            Float f2 = new Float(f);
            anonymousClass1.label = 1;
            objInvoke = anonymousClass14.invoke(f2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objInvoke);
        }
        this.scrollAmount += ((Number) objInvoke).floatValue();
        return Unit.INSTANCE;
    }

    public RelativeScroller(int i, MusicService.AnonymousClass14 anonymousClass14) {
        this.viewportSize = i;
        this.scrollBy = anonymousClass14;
    }

    public RelativeScroller(TextLayout textLayout) {
        this.scrollBy = textLayout;
        this.viewportSize = -1;
    }
}
