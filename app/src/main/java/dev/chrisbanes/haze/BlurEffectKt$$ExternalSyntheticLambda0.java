package dev.chrisbanes.haze;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.emoji2.text.EmojiProcessor;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BlurEffectKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ BlurEffectKt$$ExternalSyntheticLambda0(long j, Animatable animatable, float f) {
        this.f$2 = j;
        this.f$0 = animatable;
        this.f$1 = f;
    }

    /* JADX WARN: Code duplicated, block: B:122:0x02af  */
    /* JADX WARN: Code duplicated, block: B:141:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01f5  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        float f = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                HazeEffectNode hazeEffectNode = (HazeEffectNode) obj2;
                long j = this.f$2;
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                Lazy lazy = HazeEffectNodeKt.renderEffectCache$delegate;
                long j2 = hazeEffectNode.backgroundColor;
                if (j2 == 16) {
                    j2 = hazeEffectNode.style.backgroundColor;
                }
                if (j2 == 16) {
                    j2 = hazeEffectNode.compositionLocalStyle.backgroundColor;
                }
                if (j2 != 16) {
                    DrawScope.m550drawRectnJ9OG0$default(drawScope, j2, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 126);
                }
                EmojiProcessor drawContext = drawScope.getDrawContext();
                long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    long j3 = 0;
                    ((DrawResult) drawContext.mSpanFactory).m403scale0AR0LA0(f, f, 0L);
                    char c = ' ';
                    long jM438minusMKHz9U = Offset.m438minusMKHz9U(j, hazeEffectNode.positionOnScreen);
                    if (((((jM438minusMKHz9U & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) != 0 || Offset.m434equalsimpl0(jM438minusMKHz9U, 0L)) {
                        for (HazeArea hazeArea : hazeEffectNode.areas) {
                            if (hazeArea.contentDrawing) {
                                throw new IllegalArgumentException("Modifier.haze nodes can not draw Modifier.hazeChild nodes. This should not happen if you are providing correct values for zIndex on Modifier.haze. Alternatively you can use can `canDrawArea` to to filter out parent areas.");
                            }
                            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                long jM1541getPositionOnScreenF1C5BW0 = hazeArea.m1541getPositionOnScreenF1C5BW0();
                                if ((jM1541getPositionOnScreenF1C5BW0 & 9223372034707292159L) == 9205357640488583168L) {
                                    jM1541getPositionOnScreenF1C5BW0 = 0;
                                }
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                if (((((jM1541getPositionOnScreenF1C5BW0 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) != 0 || Offset.m434equalsimpl0(jM1541getPositionOnScreenF1C5BW0, 0L)) {
                                    GraphicsLayer contentLayer = hazeArea.getContentLayer();
                                    if (contentLayer == null) {
                                        contentLayer = null;
                                    } else {
                                        if (contentLayer.isReleased) {
                                            contentLayer = null;
                                        }
                                        if (contentLayer != null) {
                                            long j4 = contentLayer.size;
                                            if (((int) (j4 >> 32)) <= 0 || ((int) (j4 & 4294967295L)) <= 0) {
                                                contentLayer = null;
                                            }
                                        } else {
                                            contentLayer = null;
                                        }
                                    }
                                    if (contentLayer != null) {
                                        LifecyclesKt.drawLayer(drawScope, contentLayer);
                                    }
                                } else {
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jM1541getPositionOnScreenF1C5BW0 >> 32));
                                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM1541getPositionOnScreenF1C5BW0 & 4294967295L));
                                    ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(fIntBitsToFloat, fIntBitsToFloat2);
                                    try {
                                        GraphicsLayer contentLayer2 = hazeArea.getContentLayer();
                                        if (contentLayer2 == null) {
                                            contentLayer2 = null;
                                        } else {
                                            if (contentLayer2.isReleased) {
                                                contentLayer2 = null;
                                            }
                                            if (contentLayer2 != null) {
                                                long j5 = contentLayer2.size;
                                                if (((int) (j5 >> 32)) <= 0 || ((int) (j5 & 4294967295L)) <= 0) {
                                                    contentLayer2 = null;
                                                }
                                            } else {
                                                contentLayer2 = null;
                                            }
                                        }
                                        if (contentLayer2 != null) {
                                            LifecyclesKt.drawLayer(drawScope, contentLayer2);
                                        }
                                        ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                    } catch (Throwable th) {
                                        ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                throw th2;
                            }
                        }
                    } else {
                        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jM438minusMKHz9U >> 32));
                        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jM438minusMKHz9U & 4294967295L));
                        ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(fIntBitsToFloat3, fIntBitsToFloat4);
                        try {
                            for (HazeArea hazeArea2 : hazeEffectNode.areas) {
                                if (hazeArea2.contentDrawing) {
                                    throw new IllegalArgumentException("Modifier.haze nodes can not draw Modifier.hazeChild nodes. This should not happen if you are providing correct values for zIndex on Modifier.haze. Alternatively you can use can `canDrawArea` to to filter out parent areas.");
                                }
                                Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                                Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                                char c2 = c;
                                Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                                try {
                                    long jM1541getPositionOnScreenF1C5BW1 = hazeArea2.m1541getPositionOnScreenF1C5BW0();
                                    if ((jM1541getPositionOnScreenF1C5BW1 & 9223372034707292159L) != 9205357640488583168L) {
                                        j3 = jM1541getPositionOnScreenF1C5BW1;
                                    }
                                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                                    if (((((j3 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) != j3 || Offset.m434equalsimpl0(j3, j3)) {
                                        GraphicsLayer contentLayer3 = hazeArea2.getContentLayer();
                                        if (contentLayer3 == null) {
                                            contentLayer3 = null;
                                        } else {
                                            if (contentLayer3.isReleased) {
                                                contentLayer3 = null;
                                            }
                                            if (contentLayer3 != null) {
                                                long j6 = contentLayer3.size;
                                                if (((int) (j6 >> c2)) <= 0 || ((int) (j6 & 4294967295L)) <= 0) {
                                                    contentLayer3 = null;
                                                }
                                            } else {
                                                contentLayer3 = null;
                                            }
                                        }
                                        if (contentLayer3 != null) {
                                            LifecyclesKt.drawLayer(drawScope, contentLayer3);
                                        }
                                    } else {
                                        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (j3 >> c2));
                                        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (j3 & 4294967295L));
                                        ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(fIntBitsToFloat5, fIntBitsToFloat6);
                                        try {
                                            GraphicsLayer contentLayer4 = hazeArea2.getContentLayer();
                                            if (contentLayer4 == null) {
                                                contentLayer4 = null;
                                            } else {
                                                if (contentLayer4.isReleased) {
                                                    contentLayer4 = null;
                                                }
                                                if (contentLayer4 != null) {
                                                    long j7 = contentLayer4.size;
                                                    if (((int) (j7 >> c2)) <= 0 || ((int) (j7 & 4294967295L)) <= 0) {
                                                        contentLayer4 = null;
                                                    }
                                                } else {
                                                    contentLayer4 = null;
                                                }
                                            }
                                            if (contentLayer4 != null) {
                                                LifecyclesKt.drawLayer(drawScope, contentLayer4);
                                            }
                                            ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat5, -fIntBitsToFloat6);
                                        } catch (Throwable th3) {
                                            ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat5, -fIntBitsToFloat6);
                                            throw th3;
                                        }
                                    }
                                    c = c2;
                                    j3 = 0;
                                } catch (Throwable th4) {
                                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                                    throw th4;
                                }
                            }
                            ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                        } catch (Throwable th5) {
                            ((DrawResult) drawScope.getDrawContext().mSpanFactory).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                            throw th5;
                        }
                    }
                    IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
                    return unit;
                } catch (Throwable th6) {
                    IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
                    throw th6;
                }
            default:
                Animatable animatable = (Animatable) obj2;
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits((1.0f - ((Number) animatable.getValue()).floatValue()) * Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() & 4294967295L)))) & 4294967295L);
                long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() & 4294967295L)) * ((Number) animatable.getValue()).floatValue())) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> 32)))) << 32);
                float fMo81toPx0680j_4 = drawScope2.mo81toPx0680j_4(f);
                DrawScope.m552drawRoundRectuAw5IA$default(drawScope2, this.f$2, jFloatToRawIntBits, jFloatToRawIntBits2, (((long) Float.floatToRawIntBits(fMo81toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo81toPx0680j_4)) & 4294967295L), null, 240);
                return unit;
        }
    }

    public /* synthetic */ BlurEffectKt$$ExternalSyntheticLambda0(HazeEffectNode hazeEffectNode, float f, long j) {
        this.f$0 = hazeEffectNode;
        this.f$1 = f;
        this.f$2 = j;
    }
}
