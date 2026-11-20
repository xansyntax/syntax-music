package androidx.compose.runtime.snapshots;

import androidx.collection.MutableLongList;
import androidx.compose.ui.draw.DrawResult;
import dagger.hilt.EntryPoints;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable, KMappedMarker {
    public static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    public final long[] belowBound;
    public final long lowerBound;
    public final long lowerSet;
    public final long upperSet;

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
        public int I$0;
        public int I$1;
        public /* synthetic */ Object L$0;
        public long[] L$1;
        public byte label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0078  */
        /* JADX WARN: Code duplicated, block: B:24:0x0080  */
        /* JADX WARN: Code duplicated, block: B:27:0x0095  */
        /* JADX WARN: Code duplicated, block: B:30:0x009a  */
        /* JADX WARN: Code duplicated, block: B:32:0x009e  */
        /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:36:0x00bc  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007e -> B:26:0x0093). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00bc -> B:37:0x00be). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:27:0x0095
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                r22 = this;
                r0 = r22
                androidx.compose.runtime.snapshots.SnapshotIdSet r1 = androidx.compose.runtime.snapshots.SnapshotIdSet.this
                long r2 = r1.upperSet
                long r4 = r1.lowerBound
                long r6 = r1.lowerSet
                byte r8 = r0.label
                r9 = 0
                r12 = 64
                r13 = 3
                r14 = 2
                r16 = 0
                r18 = 1
                r10 = 1
                kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                if (r8 == 0) goto L4b
                if (r8 == r10) goto L3c
                if (r8 == r14) goto L32
                if (r8 != r13) goto L2c
                int r1 = r0.I$0
                java.lang.Object r6 = r0.L$0
                kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
                kotlin.ResultKt.throwOnFailure(r23)
                r7 = r13
                goto Lbe
            L2c:
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r0)
                return r9
            L32:
                int r1 = r0.I$0
                java.lang.Object r8 = r0.L$0
                kotlin.sequences.SequenceScope r8 = (kotlin.sequences.SequenceScope) r8
                kotlin.ResultKt.throwOnFailure(r23)
                goto L93
            L3c:
                int r1 = r0.I$1
                int r8 = r0.I$0
                long[] r15 = r0.L$1
                java.lang.Object r13 = r0.L$0
                kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
                kotlin.ResultKt.throwOnFailure(r23)
                int r8 = r8 + r10
                goto L59
            L4b:
                kotlin.ResultKt.throwOnFailure(r23)
                java.lang.Object r8 = r0.L$0
                r13 = r8
                kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
                long[] r15 = r1.belowBound
                if (r15 == 0) goto L70
                int r1 = r15.length
                r8 = 0
            L59:
                if (r8 >= r1) goto L70
                r2 = r15[r8]
                java.lang.Long r4 = new java.lang.Long
                r4.<init>(r2)
                r0.L$0 = r13
                r0.L$1 = r15
                r0.I$0 = r8
                r0.I$1 = r1
                r0.label = r10
                r13.yield(r4, r0)
                return r11
            L70:
                int r1 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
                if (r1 == 0) goto L96
                r8 = r13
                r1 = 0
            L76:
                if (r1 >= r12) goto L95
                long r20 = r18 << r1
                long r20 = r6 & r20
                int r13 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
                if (r13 == 0) goto L93
                long r2 = (long) r1
                long r4 = r4 + r2
                java.lang.Long r2 = new java.lang.Long
                r2.<init>(r4)
                r0.L$0 = r8
                r0.L$1 = r9
                r0.I$0 = r1
                r0.label = r14
                r8.yield(r2, r0)
                return r11
            L93:
                int r1 = r1 + r10
                goto L76
            L95:
                r13 = r8
            L96:
                int r1 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
                if (r1 == 0) goto Lc1
                r6 = r13
                r15 = 0
            L9c:
                if (r15 >= r12) goto Lc1
                long r7 = r18 << r15
                long r7 = r7 & r2
                int r1 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
                if (r1 == 0) goto Lbc
                long r1 = (long) r15
                long r4 = r4 + r1
                r1 = 64
                long r4 = r4 + r1
                java.lang.Long r1 = new java.lang.Long
                r1.<init>(r4)
                r0.L$0 = r6
                r0.L$1 = r9
                r0.I$0 = r15
                r7 = 3
                r0.label = r7
                r6.yield(r1, r0)
                return r11
            Lbc:
                r7 = 3
                r1 = r15
            Lbe:
                int r15 = r1 + 1
                goto L9c
            Lc1:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SnapshotIdSet(long j, long j2, long j3, long[] jArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = j3;
        this.belowBound = jArr;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        SnapshotIdSet snapshotIdSetClear = this;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return snapshotIdSetClear;
        }
        if (snapshotIdSetClear == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        long j = snapshotIdSet.lowerBound;
        long j2 = snapshotIdSet.lowerBound;
        long[] jArr2 = snapshotIdSet.belowBound;
        long j3 = snapshotIdSet.lowerSet;
        long j4 = snapshotIdSet.upperSet;
        long j5 = snapshotIdSetClear.lowerBound;
        if (j == j5 && jArr2 == (jArr = snapshotIdSetClear.belowBound)) {
            return new SnapshotIdSet(snapshotIdSetClear.upperSet & (~j4), snapshotIdSetClear.lowerSet & (~j3), j5, jArr);
        }
        if (jArr2 != null) {
            for (long j6 : jArr2) {
                snapshotIdSetClear = snapshotIdSetClear.clear(j6);
            }
        }
        if (j3 != 0) {
            for (int i = 0; i < 64; i++) {
                if (((1 << i) & j3) != 0) {
                    snapshotIdSetClear = snapshotIdSetClear.clear(((long) i) + j2);
                }
            }
        }
        if (j4 != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if (((1 << i2) & j4) != 0) {
                    snapshotIdSetClear = snapshotIdSetClear.clear(((long) i2) + j2 + 64);
                }
            }
        }
        return snapshotIdSetClear;
    }

    public final SnapshotIdSet clear(long j) {
        long[] jArr;
        int iBinarySearch;
        long[] jArr2;
        long j2 = j - this.lowerBound;
        if (Intrinsics.compare(j2, 0L) >= 0 && Intrinsics.compare(j2, 64L) < 0) {
            long j3 = 1 << ((int) j2);
            long j4 = this.lowerSet;
            if ((j4 & j3) != 0) {
                return new SnapshotIdSet(this.upperSet, j4 & (~j3), this.lowerBound, this.belowBound);
            }
        } else if (Intrinsics.compare(j2, 64L) >= 0 && Intrinsics.compare(j2, 128L) < 0) {
            long j5 = 1 << (((int) j2) - 64);
            long j6 = this.upperSet;
            if ((j6 & j5) != 0) {
                return new SnapshotIdSet(j6 & (~j5), this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (Intrinsics.compare(j2, 0L) < 0 && (jArr = this.belowBound) != null && (iBinarySearch = SnapshotId_jvmKt.binarySearch(jArr, j)) >= 0) {
            int length = jArr.length;
            int i = length - 1;
            if (i == 0) {
                jArr2 = null;
            } else {
                long[] jArr3 = new long[i];
                if (iBinarySearch > 0) {
                    ArraysKt.copyInto(jArr, jArr3, 0, 0, iBinarySearch);
                }
                if (iBinarySearch < i) {
                    ArraysKt.copyInto(jArr, jArr3, iBinarySearch, iBinarySearch + 1, length);
                }
                jArr2 = jArr3;
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, jArr2);
        }
        return this;
    }

    public final boolean get(long j) {
        long[] jArr;
        long j2 = j - this.lowerBound;
        if (Intrinsics.compare(j2, 0L) >= 0 && Intrinsics.compare(j2, 64L) < 0) {
            return ((1 << ((int) j2)) & this.lowerSet) != 0;
        }
        if (Intrinsics.compare(j2, 64L) < 0 || Intrinsics.compare(j2, 128L) >= 0) {
            return Intrinsics.compare(j2, 0L) <= 0 && (jArr = this.belowBound) != null && SnapshotId_jvmKt.binarySearch(jArr, j) >= 0;
        }
        return ((1 << (((int) j2) + (-64))) & this.upperSet) != 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return EntryPoints.iterator(new AnonymousClass1(null));
    }

    public final SnapshotIdSet or(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        long[] jArr;
        SnapshotIdSet snapshotIdSet3 = this;
        SnapshotIdSet snapshotIdSet4 = EMPTY;
        if (snapshotIdSet == snapshotIdSet4) {
            return snapshotIdSet3;
        }
        if (snapshotIdSet3 == snapshotIdSet4) {
            return snapshotIdSet;
        }
        long j = snapshotIdSet.lowerBound;
        long j2 = snapshotIdSet.lowerBound;
        long[] jArr2 = snapshotIdSet.belowBound;
        long j3 = snapshotIdSet.lowerSet;
        long j4 = snapshotIdSet.upperSet;
        long j5 = snapshotIdSet3.lowerBound;
        long j6 = snapshotIdSet3.lowerSet;
        long j7 = snapshotIdSet3.upperSet;
        if (j == j5 && jArr2 == (jArr = snapshotIdSet3.belowBound)) {
            return new SnapshotIdSet(j7 | j4, j6 | j3, j5, jArr);
        }
        int i = 0;
        long[] jArr3 = snapshotIdSet3.belowBound;
        if (jArr3 != null) {
            if (jArr2 != null) {
                for (long j8 : jArr2) {
                    snapshotIdSet3 = snapshotIdSet3.set(j8);
                }
            }
            if (j3 != 0) {
                for (int i2 = 0; i2 < 64; i2++) {
                    if (((1 << i2) & j3) != 0) {
                        snapshotIdSet3 = snapshotIdSet3.set(((long) i2) + j2);
                    }
                }
            }
            if (j4 != 0) {
                while (i < 64) {
                    if (((1 << i) & j4) != 0) {
                        snapshotIdSet3 = snapshotIdSet3.set(((long) i) + j2 + 64);
                    }
                    i++;
                }
            }
            return snapshotIdSet3;
        }
        if (jArr3 != null) {
            snapshotIdSet2 = snapshotIdSet;
            for (long j9 : jArr3) {
                snapshotIdSet2 = snapshotIdSet2.set(j9);
            }
        } else {
            snapshotIdSet2 = snapshotIdSet;
        }
        long j10 = snapshotIdSet3.lowerBound;
        if (j6 != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if (((1 << i3) & j6) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.set(((long) i3) + j10);
                }
            }
        }
        if (j7 != 0) {
            while (i < 64) {
                if (((1 << i) & j7) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.set(((long) i) + j10 + 64);
                }
                i++;
            }
        }
        return snapshotIdSet2;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00fa  */
    public final SnapshotIdSet set(long j) {
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4 = this.lowerBound;
        long j5 = j - j4;
        long j6 = 0;
        int iCompare = Intrinsics.compare(j5, 0L);
        long j7 = this.lowerSet;
        if (iCompare < 0 || Intrinsics.compare(j5, 64L) >= 0) {
            int iCompare2 = Intrinsics.compare(j5, 64L);
            long j8 = this.upperSet;
            int i2 = 64;
            if (iCompare2 < 0 || Intrinsics.compare(j5, 128L) >= 0) {
                int iCompare3 = Intrinsics.compare(j5, 128L);
                long[] jArr3 = this.belowBound;
                if (iCompare3 < 0) {
                    if (jArr3 == null) {
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new long[]{j});
                    }
                    int iBinarySearch = SnapshotId_jvmKt.binarySearch(jArr3, j);
                    if (iBinarySearch < 0) {
                        int i3 = -(iBinarySearch + 1);
                        int length = jArr3.length;
                        long[] jArr4 = new long[length + 1];
                        ArraysKt.copyInto(jArr3, jArr4, 0, 0, i3);
                        ArraysKt.copyInto(jArr3, jArr4, i3 + 1, i3, length);
                        jArr4[i3] = j;
                        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, jArr4);
                    }
                } else if (!get(j)) {
                    long j9 = ((j + 1) / 64) * 64;
                    if (Intrinsics.compare(j9, 0L) < 0) {
                        j9 = 9223372036854775680L;
                    }
                    long j10 = j8;
                    DrawResult drawResult = null;
                    while (true) {
                        if (Intrinsics.compare(j4, j9) >= 0) {
                            j2 = j4;
                            j3 = j7;
                            break;
                        }
                        if (j7 != j6) {
                            if (drawResult == null) {
                                drawResult = new DrawResult(jArr3);
                            }
                            int i4 = 0;
                            i = i2;
                            while (i4 < i) {
                                if ((j7 & (1 << i4)) != j6) {
                                    ((MutableLongList) drawResult.block).add(((long) i4) + j4);
                                }
                                i4++;
                                j6 = j6;
                            }
                        } else {
                            i = i2;
                        }
                        long j11 = j6;
                        if (j10 == j11) {
                            j2 = j9;
                            j3 = j11;
                            break;
                        }
                        j4 += 64;
                        j6 = j11;
                        j7 = j10;
                        i2 = i;
                        j10 = j6;
                    }
                    if (drawResult == null) {
                        jArr = jArr3;
                    } else {
                        MutableLongList mutableLongList = (MutableLongList) drawResult.block;
                        int i5 = mutableLongList._size;
                        if (i5 == 0) {
                            jArr2 = null;
                        } else {
                            long[] jArr5 = new long[i5];
                            long[] jArr6 = mutableLongList.content;
                            for (int i6 = 0; i6 < i5; i6++) {
                                jArr5[i6] = jArr6[i6];
                            }
                            jArr2 = jArr5;
                        }
                        if (jArr2 == null) {
                            jArr = jArr3;
                        } else {
                            jArr = jArr2;
                        }
                    }
                    return new SnapshotIdSet(j10, j3, j2, jArr).set(j);
                }
            } else {
                long j12 = 1 << (((int) j5) - 64);
                if ((j8 & j12) == 0) {
                    return new SnapshotIdSet(j8 | j12, this.lowerSet, this.lowerBound, this.belowBound);
                }
            }
        } else {
            long j13 = 1 << ((int) j5);
            if ((j7 & j13) == 0) {
                return new SnapshotIdSet(this.upperSet, j7 | j13, this.lowerBound, this.belowBound);
            }
        }
        return this;
    }

    public final String toString() {
        String string = super.toString();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            i++;
            if (i > 1) {
                sb.append((CharSequence) ", ");
            }
            if (obj != null ? obj instanceof CharSequence : true) {
                sb.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb.append(((Character) obj).charValue());
            } else {
                sb.append((CharSequence) obj.toString());
            }
        }
        sb.append((CharSequence) "");
        return string + " [" + sb.toString() + "]";
    }
}
