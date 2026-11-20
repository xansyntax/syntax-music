package io.ktor.websocket;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.MemoryKt;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.random.Random;
import kotlinx.io.Buffer;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a$\u0010\u000b\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0087@¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\u0011\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\u0087@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/io/Source;", "", "maskKey", "mask", "(Lkotlinx/io/Source;I)Lkotlinx/io/Source;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/websocket/Frame;", "frame", "", "masking", "", "writeFrame", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "", "maxFrameSize", "lastOpcode", "readFrame", "(Lio/ktor/utils/io/ByteReadChannel;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RawWebSocketCommonKt {

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommonKt$readFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", l = {231, 232, 251, 252, 260, 268}, m = "readFrame", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        byte B$0;
        byte B$1;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.readFrame(null, 0L, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", l = {189, 199, 202, 203, 211, 217}, m = "writeFrame", v = 1)
    public static final class C03751 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C03751(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.writeFrame(null, null, false, this);
        }
    }

    private static final Source mask(Source source, int i) {
        return (Source) MemoryKt.withMemory(4, new RawWebSocketCommonKt$$ExternalSyntheticLambda0(i, (Object) source, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source mask$lambda$0(int i, Source source, byte[] bArr) {
        bArr.getClass();
        MemoryKt.storeIntAt(bArr, 0, i);
        Buffer buffer = new Buffer();
        int remaining = (int) ByteReadPacketKt.getRemaining(source);
        for (int i2 = 0; i2 < remaining; i2++) {
            buffer.writeByte((byte) (source.readByte() ^ bArr[i2 % 4]));
        }
        return buffer;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x023b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0244  */
    /* JADX WARN: Code duplicated, block: B:104:0x0246  */
    /* JADX WARN: Code duplicated, block: B:107:0x024b  */
    /* JADX WARN: Code duplicated, block: B:108:0x024d  */
    /* JADX WARN: Code duplicated, block: B:111:0x0252  */
    /* JADX WARN: Code duplicated, block: B:112:0x0254  */
    /* JADX WARN: Code duplicated, block: B:117:0x0268  */
    /* JADX WARN: Code duplicated, block: B:119:0x026e  */
    /* JADX WARN: Code duplicated, block: B:24:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x0104  */
    /* JADX WARN: Code duplicated, block: B:33:0x0106  */
    /* JADX WARN: Code duplicated, block: B:36:0x010f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0111 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x0126  */
    /* JADX WARN: Code duplicated, block: B:46:0x0128  */
    /* JADX WARN: Code duplicated, block: B:49:0x012f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:55:0x0140  */
    /* JADX WARN: Code duplicated, block: B:57:0x0144  */
    /* JADX WARN: Code duplicated, block: B:59:0x0157  */
    /* JADX WARN: Code duplicated, block: B:63:0x017d  */
    /* JADX WARN: Code duplicated, block: B:69:0x01af  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:96:0x0231  */
    /* JADX WARN: Code duplicated, block: B:99:0x0239  */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0172, code lost:
    
        if (r1 == r8) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0198, code lost:
    
        if (r1 == r8) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e2, code lost:
    
        if (r1 == r8) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readFrame(ByteReadChannel byteReadChannel, long j, int i, Continuation continuation) throws FrameTooBigException, ProtocolViolationException, EOFException {
        AnonymousClass1 anonymousClass1;
        long j2;
        int i2;
        Object obj;
        byte bByteValue;
        Object obj2;
        ByteReadChannel byteReadChannel2;
        int i3;
        long j3;
        byte b;
        byte bByteValue2;
        int i4;
        int i5;
        FrameType frameType;
        int i6;
        int i7;
        long jShortValue;
        int i8;
        ByteReadChannel byteReadChannel3;
        byte b2;
        byte b3;
        long j4;
        int i9;
        FrameType frameType2;
        long j5;
        boolean z;
        int i10;
        int i11;
        int i12;
        byte b4;
        FrameType frameType3;
        Source sourceMask;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ByteReadChannel byteReadChannel4 = byteReadChannel;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i13 = anonymousClass1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i13 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj3 = anonymousClass1.result;
        int i14 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i14) {
            case 0:
                ResultKt.throwOnFailure(obj3);
                anonymousClass1.L$0 = byteReadChannel4;
                j2 = j;
                anonymousClass1.J$0 = j2;
                i2 = i;
                anonymousClass1.I$0 = i2;
                anonymousClass1.label = 1;
                obj = ByteReadChannelOperationsKt.readByte(byteReadChannel4, anonymousClass1);
                if (obj != coroutineSingletons) {
                    bByteValue = ((Number) obj).byteValue();
                    anonymousClass1.L$0 = byteReadChannel4;
                    anonymousClass1.J$0 = j2;
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.B$0 = bByteValue;
                    anonymousClass1.label = 2;
                    obj2 = ByteReadChannelOperationsKt.readByte(byteReadChannel4, anonymousClass1);
                    if (obj2 != coroutineSingletons) {
                        byteReadChannel2 = byteReadChannel4;
                        i3 = i2;
                        j3 = j2;
                        obj3 = obj2;
                        b = bByteValue;
                        bByteValue2 = ((Number) obj3).byteValue();
                        i4 = b & 15;
                        if (i4 != 0 && i3 == 0) {
                            throw new ProtocolViolationException("Can't continue finished frames");
                        }
                        if (i4 == 0) {
                            i5 = i3;
                        } else {
                            i5 = i4;
                        }
                        frameType = FrameType.INSTANCE.get(i5);
                        if (frameType == null) {
                            throw new ProtocolViolationException(IntIntPair$$ExternalSyntheticOutline0.m(i5, "Unsupported opcode: "));
                        }
                        if (i4 == 0 && i3 != 0 && !frameType.getControlFrame()) {
                            throw new ProtocolViolationException("Can't start new data frame before finishing previous one");
                        }
                        if ((b & 128) != 0) {
                            i6 = 1;
                        } else {
                            i6 = 0;
                        }
                        if (!frameType.getControlFrame() && i6 == 0) {
                            throw new ProtocolViolationException("control frames can't be fragmented");
                        }
                        i7 = bByteValue2 & 127;
                        if (i7 != 126) {
                            anonymousClass1.L$0 = byteReadChannel2;
                            anonymousClass1.L$1 = frameType;
                            anonymousClass1.J$0 = j3;
                            anonymousClass1.I$0 = i3;
                            anonymousClass1.B$0 = b;
                            anonymousClass1.B$1 = bByteValue2;
                            anonymousClass1.I$1 = i4;
                            anonymousClass1.I$2 = i5;
                            anonymousClass1.I$3 = i6;
                            anonymousClass1.I$4 = i7;
                            anonymousClass1.label = 3;
                            obj3 = ByteReadChannelOperationsKt.readShort(byteReadChannel2, anonymousClass1);
                        } else {
                            if (i7 != 127) {
                                jShortValue = i7;
                                i8 = i4;
                                byteReadChannel3 = byteReadChannel2;
                                b2 = b;
                                FrameType frameType4 = frameType;
                                b3 = bByteValue2;
                                j4 = j3;
                                long j6 = jShortValue;
                                i9 = i3;
                                frameType2 = frameType4;
                                j5 = j6;
                                if (!frameType2.getControlFrame() && j5 > 125) {
                                    throw new ProtocolViolationException("control frames can't be larger than 125 bytes");
                                }
                                if ((b3 & 128) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    anonymousClass1.L$0 = byteReadChannel3;
                                    anonymousClass1.L$1 = frameType2;
                                    anonymousClass1.J$0 = j4;
                                    anonymousClass1.I$0 = i9;
                                    anonymousClass1.B$0 = b2;
                                    anonymousClass1.B$1 = b3;
                                    anonymousClass1.I$1 = i8;
                                    anonymousClass1.I$2 = i5;
                                    anonymousClass1.I$3 = i6;
                                    anonymousClass1.J$1 = j5;
                                    anonymousClass1.label = 5;
                                    obj3 = ByteReadChannelOperationsKt.readInt(byteReadChannel3, anonymousClass1);
                                    break;
                                } else {
                                    if (z) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                        return null;
                                    }
                                    i10 = i6;
                                    i11 = -1;
                                }
                                if (j5 <= 2147483647L || j5 > j4) {
                                    throw new FrameTooBigException(j5, null, 2, null);
                                }
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = frameType2;
                                anonymousClass1.J$0 = j4;
                                anonymousClass1.I$0 = i9;
                                anonymousClass1.B$0 = b2;
                                anonymousClass1.B$1 = b3;
                                anonymousClass1.I$1 = i8;
                                anonymousClass1.I$2 = i5;
                                anonymousClass1.I$3 = i10;
                                anonymousClass1.J$1 = j5;
                                anonymousClass1.I$4 = i11;
                                anonymousClass1.label = 6;
                                Object packet = ByteReadChannelOperationsKt.readPacket(byteReadChannel3, (int) j5, anonymousClass1);
                                if (packet == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                i12 = i10;
                                obj3 = packet;
                                b4 = b2;
                                frameType3 = frameType2;
                                sourceMask = (Source) obj3;
                                if (i11 != -1) {
                                    sourceMask = mask(sourceMask, i11);
                                }
                                Frame.Companion companion = Frame.INSTANCE;
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                byte[] byteArray = Utf8Kt.readByteArray(sourceMask);
                                if ((b4 & 64) != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if ((b4 & 32) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if ((b4 & 16) != 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                return companion.byType(z2, frameType3, byteArray, z3, z4, z5);
                            }
                            anonymousClass1.L$0 = byteReadChannel2;
                            anonymousClass1.L$1 = frameType;
                            anonymousClass1.J$0 = j3;
                            anonymousClass1.I$0 = i3;
                            anonymousClass1.B$0 = b;
                            anonymousClass1.B$1 = bByteValue2;
                            anonymousClass1.I$1 = i4;
                            anonymousClass1.I$2 = i5;
                            anonymousClass1.I$3 = i6;
                            anonymousClass1.I$4 = i7;
                            anonymousClass1.label = 4;
                            obj3 = ByteReadChannelOperationsKt.readLong(byteReadChannel2, anonymousClass1);
                        }
                    }
                    break;
                }
                return coroutineSingletons;
            case 1:
                int i15 = anonymousClass1.I$0;
                j2 = anonymousClass1.J$0;
                ByteReadChannel byteReadChannel5 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj3);
                i2 = i15;
                byteReadChannel4 = byteReadChannel5;
                obj = obj3;
                bByteValue = ((Number) obj).byteValue();
                anonymousClass1.L$0 = byteReadChannel4;
                anonymousClass1.J$0 = j2;
                anonymousClass1.I$0 = i2;
                anonymousClass1.B$0 = bByteValue;
                anonymousClass1.label = 2;
                obj2 = ByteReadChannelOperationsKt.readByte(byteReadChannel4, anonymousClass1);
                if (obj2 != coroutineSingletons) {
                    byteReadChannel2 = byteReadChannel4;
                    i3 = i2;
                    j3 = j2;
                    obj3 = obj2;
                    b = bByteValue;
                    bByteValue2 = ((Number) obj3).byteValue();
                    i4 = b & 15;
                    if (i4 != 0) {
                    }
                    if (i4 == 0) {
                        i5 = i3;
                    } else {
                        i5 = i4;
                    }
                    frameType = FrameType.INSTANCE.get(i5);
                    if (frameType == null) {
                        throw new ProtocolViolationException(IntIntPair$$ExternalSyntheticOutline0.m(i5, "Unsupported opcode: "));
                    }
                    if (i4 == 0) {
                    }
                    if ((b & 128) != 0) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    if (!frameType.getControlFrame()) {
                    }
                    i7 = bByteValue2 & 127;
                    if (i7 != 126) {
                        anonymousClass1.L$0 = byteReadChannel2;
                        anonymousClass1.L$1 = frameType;
                        anonymousClass1.J$0 = j3;
                        anonymousClass1.I$0 = i3;
                        anonymousClass1.B$0 = b;
                        anonymousClass1.B$1 = bByteValue2;
                        anonymousClass1.I$1 = i4;
                        anonymousClass1.I$2 = i5;
                        anonymousClass1.I$3 = i6;
                        anonymousClass1.I$4 = i7;
                        anonymousClass1.label = 3;
                        obj3 = ByteReadChannelOperationsKt.readShort(byteReadChannel2, anonymousClass1);
                    } else {
                        if (i7 != 127) {
                            jShortValue = i7;
                            i8 = i4;
                            byteReadChannel3 = byteReadChannel2;
                            b2 = b;
                            FrameType frameType5 = frameType;
                            b3 = bByteValue2;
                            j4 = j3;
                            long j7 = jShortValue;
                            i9 = i3;
                            frameType2 = frameType5;
                            j5 = j7;
                            if (!frameType2.getControlFrame()) {
                                break;
                            }
                            if ((b3 & 128) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                anonymousClass1.L$0 = byteReadChannel3;
                                anonymousClass1.L$1 = frameType2;
                                anonymousClass1.J$0 = j4;
                                anonymousClass1.I$0 = i9;
                                anonymousClass1.B$0 = b2;
                                anonymousClass1.B$1 = b3;
                                anonymousClass1.I$1 = i8;
                                anonymousClass1.I$2 = i5;
                                anonymousClass1.I$3 = i6;
                                anonymousClass1.J$1 = j5;
                                anonymousClass1.label = 5;
                                obj3 = ByteReadChannelOperationsKt.readInt(byteReadChannel3, anonymousClass1);
                                break;
                            } else {
                                if (z) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                i10 = i6;
                                i11 = -1;
                            }
                            if (j5 <= 2147483647L) {
                                break;
                            }
                            throw new FrameTooBigException(j5, null, 2, null);
                        }
                        anonymousClass1.L$0 = byteReadChannel2;
                        anonymousClass1.L$1 = frameType;
                        anonymousClass1.J$0 = j3;
                        anonymousClass1.I$0 = i3;
                        anonymousClass1.B$0 = b;
                        anonymousClass1.B$1 = bByteValue2;
                        anonymousClass1.I$1 = i4;
                        anonymousClass1.I$2 = i5;
                        anonymousClass1.I$3 = i6;
                        anonymousClass1.I$4 = i7;
                        anonymousClass1.label = 4;
                        obj3 = ByteReadChannelOperationsKt.readLong(byteReadChannel2, anonymousClass1);
                    }
                    break;
                }
                return coroutineSingletons;
            case 2:
                byte b5 = anonymousClass1.B$0;
                int i16 = anonymousClass1.I$0;
                long j8 = anonymousClass1.J$0;
                ByteReadChannel byteReadChannel6 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj3);
                i3 = i16;
                j3 = j8;
                byteReadChannel2 = byteReadChannel6;
                b = b5;
                bByteValue2 = ((Number) obj3).byteValue();
                i4 = b & 15;
                if (i4 != 0) {
                }
                if (i4 == 0) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                frameType = FrameType.INSTANCE.get(i5);
                if (frameType == null) {
                    throw new ProtocolViolationException(IntIntPair$$ExternalSyntheticOutline0.m(i5, "Unsupported opcode: "));
                }
                if (i4 == 0) {
                }
                if ((b & 128) != 0) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                if (!frameType.getControlFrame()) {
                }
                i7 = bByteValue2 & 127;
                if (i7 != 126) {
                    if (i7 != 127) {
                        jShortValue = i7;
                        i8 = i4;
                        byteReadChannel3 = byteReadChannel2;
                        b2 = b;
                        FrameType frameType6 = frameType;
                        b3 = bByteValue2;
                        j4 = j3;
                        long j9 = jShortValue;
                        i9 = i3;
                        frameType2 = frameType6;
                        j5 = j9;
                        if (!frameType2.getControlFrame()) {
                            break;
                        }
                        if ((b3 & 128) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            anonymousClass1.L$0 = byteReadChannel3;
                            anonymousClass1.L$1 = frameType2;
                            anonymousClass1.J$0 = j4;
                            anonymousClass1.I$0 = i9;
                            anonymousClass1.B$0 = b2;
                            anonymousClass1.B$1 = b3;
                            anonymousClass1.I$1 = i8;
                            anonymousClass1.I$2 = i5;
                            anonymousClass1.I$3 = i6;
                            anonymousClass1.J$1 = j5;
                            anonymousClass1.label = 5;
                            obj3 = ByteReadChannelOperationsKt.readInt(byteReadChannel3, anonymousClass1);
                            break;
                        } else {
                            if (z) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            i10 = i6;
                            i11 = -1;
                        }
                        if (j5 <= 2147483647L) {
                            break;
                        }
                        throw new FrameTooBigException(j5, null, 2, null);
                    }
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.I$0 = i3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$1 = i4;
                    anonymousClass1.I$2 = i5;
                    anonymousClass1.I$3 = i6;
                    anonymousClass1.I$4 = i7;
                    anonymousClass1.label = 4;
                    obj3 = ByteReadChannelOperationsKt.readLong(byteReadChannel2, anonymousClass1);
                    break;
                } else {
                    anonymousClass1.L$0 = byteReadChannel2;
                    anonymousClass1.L$1 = frameType;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.I$0 = i3;
                    anonymousClass1.B$0 = b;
                    anonymousClass1.B$1 = bByteValue2;
                    anonymousClass1.I$1 = i4;
                    anonymousClass1.I$2 = i5;
                    anonymousClass1.I$3 = i6;
                    anonymousClass1.I$4 = i7;
                    anonymousClass1.label = 3;
                    obj3 = ByteReadChannelOperationsKt.readShort(byteReadChannel2, anonymousClass1);
                    break;
                }
                return coroutineSingletons;
            case 3:
                i6 = anonymousClass1.I$3;
                i5 = anonymousClass1.I$2;
                i4 = anonymousClass1.I$1;
                bByteValue2 = anonymousClass1.B$1;
                b = anonymousClass1.B$0;
                i3 = anonymousClass1.I$0;
                j3 = anonymousClass1.J$0;
                frameType = (FrameType) anonymousClass1.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj3);
                jShortValue = ((long) ((Number) obj3).shortValue()) & 65535;
                i8 = i4;
                byteReadChannel3 = byteReadChannel2;
                b2 = b;
                FrameType frameType7 = frameType;
                b3 = bByteValue2;
                j4 = j3;
                long j10 = jShortValue;
                i9 = i3;
                frameType2 = frameType7;
                j5 = j10;
                if (!frameType2.getControlFrame()) {
                    break;
                }
                if ((b3 & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    anonymousClass1.L$0 = byteReadChannel3;
                    anonymousClass1.L$1 = frameType2;
                    anonymousClass1.J$0 = j4;
                    anonymousClass1.I$0 = i9;
                    anonymousClass1.B$0 = b2;
                    anonymousClass1.B$1 = b3;
                    anonymousClass1.I$1 = i8;
                    anonymousClass1.I$2 = i5;
                    anonymousClass1.I$3 = i6;
                    anonymousClass1.J$1 = j5;
                    anonymousClass1.label = 5;
                    obj3 = ByteReadChannelOperationsKt.readInt(byteReadChannel3, anonymousClass1);
                    break;
                } else {
                    if (z) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    i10 = i6;
                    i11 = -1;
                }
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5, null, 2, null);
            case 4:
                i6 = anonymousClass1.I$3;
                i5 = anonymousClass1.I$2;
                i4 = anonymousClass1.I$1;
                bByteValue2 = anonymousClass1.B$1;
                b = anonymousClass1.B$0;
                i3 = anonymousClass1.I$0;
                j3 = anonymousClass1.J$0;
                frameType = (FrameType) anonymousClass1.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj3);
                jShortValue = ((Number) obj3).longValue();
                i8 = i4;
                byteReadChannel3 = byteReadChannel2;
                b2 = b;
                FrameType frameType8 = frameType;
                b3 = bByteValue2;
                j4 = j3;
                long j11 = jShortValue;
                i9 = i3;
                frameType2 = frameType8;
                j5 = j11;
                if (!frameType2.getControlFrame()) {
                    break;
                }
                if ((b3 & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    anonymousClass1.L$0 = byteReadChannel3;
                    anonymousClass1.L$1 = frameType2;
                    anonymousClass1.J$0 = j4;
                    anonymousClass1.I$0 = i9;
                    anonymousClass1.B$0 = b2;
                    anonymousClass1.B$1 = b3;
                    anonymousClass1.I$1 = i8;
                    anonymousClass1.I$2 = i5;
                    anonymousClass1.I$3 = i6;
                    anonymousClass1.J$1 = j5;
                    anonymousClass1.label = 5;
                    obj3 = ByteReadChannelOperationsKt.readInt(byteReadChannel3, anonymousClass1);
                    break;
                } else {
                    if (z) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    i10 = i6;
                    i11 = -1;
                }
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5, null, 2, null);
            case 5:
                j5 = anonymousClass1.J$1;
                i6 = anonymousClass1.I$3;
                i5 = anonymousClass1.I$2;
                i8 = anonymousClass1.I$1;
                b3 = anonymousClass1.B$1;
                b2 = anonymousClass1.B$0;
                i9 = anonymousClass1.I$0;
                j4 = anonymousClass1.J$0;
                frameType2 = (FrameType) anonymousClass1.L$1;
                byteReadChannel3 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj3);
                int iIntValue = ((Number) obj3).intValue();
                i10 = i6;
                i11 = iIntValue;
                if (j5 <= 2147483647L) {
                    break;
                }
                throw new FrameTooBigException(j5, null, 2, null);
            case 6:
                i11 = anonymousClass1.I$4;
                i12 = anonymousClass1.I$3;
                b4 = anonymousClass1.B$0;
                FrameType frameType9 = (FrameType) anonymousClass1.L$1;
                ResultKt.throwOnFailure(obj3);
                frameType3 = frameType9;
                sourceMask = (Source) obj3;
                if (i11 != -1) {
                    sourceMask = mask(sourceMask, i11);
                }
                Frame.Companion companion2 = Frame.INSTANCE;
                if (i12 != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                byte[] byteArray2 = Utf8Kt.readByteArray(sourceMask);
                if ((b4 & 64) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((b4 & 32) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((b4 & 16) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                return companion2.byType(z2, frameType3, byteArray2, z3, z4, z5);
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0100  */
    /* JADX WARN: Code duplicated, block: B:39:0x0102  */
    /* JADX WARN: Code duplicated, block: B:41:0x0107  */
    /* JADX WARN: Code duplicated, block: B:42:0x0109  */
    /* JADX WARN: Code duplicated, block: B:45:0x010d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0129  */
    /* JADX WARN: Code duplicated, block: B:51:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0135  */
    /* JADX WARN: Code duplicated, block: B:54:0x013c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0160  */
    /* JADX WARN: Code duplicated, block: B:64:0x0184  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0152, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeLong(r15, r12, r2) == r11) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0156, code lost:
    
        r5 = r7;
        r7 = r12;
        r8 = r13;
        r12 = r14;
        r13 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0176, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeShort(r15, (short) r12, r2) == r11) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a3, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r12, r0, r2) == r11) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c5, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(r12, r10, r2) == r11) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeFrame(ByteWriteChannel byteWriteChannel, Frame frame, boolean z, Continuation continuation) {
        C03751 c03751;
        int length;
        Frame frame2;
        boolean z2;
        ByteWriteChannel byteWriteChannel2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ByteWriteChannel byteWriteChannel3;
        Frame frame3;
        boolean z3;
        int i6;
        int i7;
        int i8;
        boolean z4;
        int i9;
        int i10;
        ByteWriteChannel byteWriteChannel4;
        int i11;
        Source sourceByteReadPacket$default;
        int iNextInt;
        if (continuation instanceof C03751) {
            c03751 = (C03751) continuation;
            int i12 = c03751.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c03751.label = i12 - Integer.MIN_VALUE;
            } else {
                c03751 = new C03751(continuation);
            }
        } else {
            c03751 = new C03751(continuation);
        }
        Object obj = c03751.result;
        int i13 = c03751.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i13) {
            case 0:
                ResultKt.throwOnFailure(obj);
                length = frame.getData().length;
                int opcode = (frame.getFin() ? 128 : 0) | (frame.getRsv1() ? 64 : 0) | (frame.getRsv2() ? 32 : 0) | (frame.getRsv3() ? 16 : 0) | frame.getFrameType().getOpcode();
                c03751.L$0 = byteWriteChannel;
                frame2 = frame;
                c03751.L$1 = frame2;
                c03751.Z$0 = z;
                c03751.I$0 = length;
                c03751.I$1 = opcode;
                c03751.label = 1;
                if (ByteWriteChannelOperationsKt.writeByte(byteWriteChannel, (byte) opcode, c03751) != coroutineSingletons) {
                    z2 = z;
                    byteWriteChannel2 = byteWriteChannel;
                    i = opcode;
                    if (length < 126) {
                        i2 = length;
                    } else if (length <= 65535) {
                        i2 = 126;
                    } else {
                        i2 = 127;
                    }
                    i3 = (z2 ? 128 : 0) | i2;
                    c03751.L$0 = byteWriteChannel2;
                    c03751.L$1 = frame2;
                    c03751.Z$0 = z2;
                    c03751.I$0 = length;
                    c03751.I$1 = i;
                    c03751.I$2 = i2;
                    c03751.I$3 = i3;
                    c03751.label = 2;
                    if (ByteWriteChannelOperationsKt.writeByte(byteWriteChannel2, (byte) i3, c03751) != coroutineSingletons) {
                        i4 = i;
                        i5 = i3;
                        byteWriteChannel3 = byteWriteChannel2;
                        frame3 = frame2;
                        z3 = z2;
                        i6 = length;
                        i7 = i2;
                        if (i7 != 126) {
                            c03751.L$0 = byteWriteChannel3;
                            c03751.L$1 = frame3;
                            c03751.Z$0 = z3;
                            c03751.I$0 = i6;
                            c03751.I$1 = i4;
                            c03751.I$2 = i7;
                            c03751.I$3 = i5;
                            c03751.label = 3;
                        } else if (i7 == 127) {
                            c03751.L$0 = byteWriteChannel3;
                            c03751.L$1 = frame3;
                            c03751.Z$0 = z3;
                            c03751.I$0 = i6;
                            c03751.I$1 = i4;
                            c03751.I$2 = i7;
                            c03751.I$3 = i5;
                            c03751.label = 4;
                        } else {
                            i9 = i7;
                            i10 = i4;
                            i8 = i6;
                            z4 = z3;
                            byteWriteChannel4 = byteWriteChannel3;
                            i11 = i5;
                            sourceByteReadPacket$default = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, null);
                            if (!z4) {
                                if (z4) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                c03751.L$0 = null;
                                c03751.L$1 = null;
                                c03751.L$2 = null;
                                c03751.L$3 = null;
                                c03751.Z$0 = z4;
                                c03751.I$0 = i8;
                                c03751.I$1 = i10;
                                c03751.I$2 = i9;
                                c03751.I$3 = i11;
                                c03751.label = 6;
                            } else {
                                iNextInt = Random.defaultRandom.nextInt();
                                c03751.L$0 = byteWriteChannel4;
                                c03751.L$1 = null;
                                c03751.L$2 = sourceByteReadPacket$default;
                                c03751.Z$0 = z4;
                                c03751.I$0 = i8;
                                c03751.I$1 = i10;
                                c03751.I$2 = i9;
                                c03751.I$3 = i11;
                                c03751.I$4 = iNextInt;
                                c03751.label = 5;
                            }
                        }
                    }
                    break;
                }
                return coroutineSingletons;
            case 1:
                i = c03751.I$1;
                length = c03751.I$0;
                z2 = c03751.Z$0;
                frame2 = (Frame) c03751.L$1;
                byteWriteChannel2 = (ByteWriteChannel) c03751.L$0;
                ResultKt.throwOnFailure(obj);
                if (length < 126) {
                    i2 = length;
                } else if (length <= 65535) {
                    i2 = 126;
                } else {
                    i2 = 127;
                }
                i3 = (z2 ? 128 : 0) | i2;
                c03751.L$0 = byteWriteChannel2;
                c03751.L$1 = frame2;
                c03751.Z$0 = z2;
                c03751.I$0 = length;
                c03751.I$1 = i;
                c03751.I$2 = i2;
                c03751.I$3 = i3;
                c03751.label = 2;
                if (ByteWriteChannelOperationsKt.writeByte(byteWriteChannel2, (byte) i3, c03751) != coroutineSingletons) {
                    i4 = i;
                    i5 = i3;
                    byteWriteChannel3 = byteWriteChannel2;
                    frame3 = frame2;
                    z3 = z2;
                    i6 = length;
                    i7 = i2;
                    if (i7 != 126) {
                        c03751.L$0 = byteWriteChannel3;
                        c03751.L$1 = frame3;
                        c03751.Z$0 = z3;
                        c03751.I$0 = i6;
                        c03751.I$1 = i4;
                        c03751.I$2 = i7;
                        c03751.I$3 = i5;
                        c03751.label = 3;
                    } else if (i7 == 127) {
                        c03751.L$0 = byteWriteChannel3;
                        c03751.L$1 = frame3;
                        c03751.Z$0 = z3;
                        c03751.I$0 = i6;
                        c03751.I$1 = i4;
                        c03751.I$2 = i7;
                        c03751.I$3 = i5;
                        c03751.label = 4;
                    } else {
                        i9 = i7;
                        i10 = i4;
                        i8 = i6;
                        z4 = z3;
                        byteWriteChannel4 = byteWriteChannel3;
                        i11 = i5;
                        sourceByteReadPacket$default = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, null);
                        if (!z4) {
                            if (z4) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            c03751.L$0 = null;
                            c03751.L$1 = null;
                            c03751.L$2 = null;
                            c03751.L$3 = null;
                            c03751.Z$0 = z4;
                            c03751.I$0 = i8;
                            c03751.I$1 = i10;
                            c03751.I$2 = i9;
                            c03751.I$3 = i11;
                            c03751.label = 6;
                        } else {
                            iNextInt = Random.defaultRandom.nextInt();
                            c03751.L$0 = byteWriteChannel4;
                            c03751.L$1 = null;
                            c03751.L$2 = sourceByteReadPacket$default;
                            c03751.Z$0 = z4;
                            c03751.I$0 = i8;
                            c03751.I$1 = i10;
                            c03751.I$2 = i9;
                            c03751.I$3 = i11;
                            c03751.I$4 = iNextInt;
                            c03751.label = 5;
                        }
                    }
                    break;
                }
                return coroutineSingletons;
            case 2:
                i5 = c03751.I$3;
                i7 = c03751.I$2;
                i4 = c03751.I$1;
                i6 = c03751.I$0;
                z3 = c03751.Z$0;
                frame3 = (Frame) c03751.L$1;
                byteWriteChannel3 = (ByteWriteChannel) c03751.L$0;
                ResultKt.throwOnFailure(obj);
                if (i7 != 126) {
                    if (i7 == 127) {
                        c03751.L$0 = byteWriteChannel3;
                        c03751.L$1 = frame3;
                        c03751.Z$0 = z3;
                        c03751.I$0 = i6;
                        c03751.I$1 = i4;
                        c03751.I$2 = i7;
                        c03751.I$3 = i5;
                        c03751.label = 4;
                    } else {
                        i9 = i7;
                        i10 = i4;
                        i8 = i6;
                        z4 = z3;
                        byteWriteChannel4 = byteWriteChannel3;
                        i11 = i5;
                        sourceByteReadPacket$default = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, null);
                        if (!z4) {
                            if (z4) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            c03751.L$0 = null;
                            c03751.L$1 = null;
                            c03751.L$2 = null;
                            c03751.L$3 = null;
                            c03751.Z$0 = z4;
                            c03751.I$0 = i8;
                            c03751.I$1 = i10;
                            c03751.I$2 = i9;
                            c03751.I$3 = i11;
                            c03751.label = 6;
                        } else {
                            iNextInt = Random.defaultRandom.nextInt();
                            c03751.L$0 = byteWriteChannel4;
                            c03751.L$1 = null;
                            c03751.L$2 = sourceByteReadPacket$default;
                            c03751.Z$0 = z4;
                            c03751.I$0 = i8;
                            c03751.I$1 = i10;
                            c03751.I$2 = i9;
                            c03751.I$3 = i11;
                            c03751.I$4 = iNextInt;
                            c03751.label = 5;
                        }
                    }
                    break;
                } else {
                    c03751.L$0 = byteWriteChannel3;
                    c03751.L$1 = frame3;
                    c03751.Z$0 = z3;
                    c03751.I$0 = i6;
                    c03751.I$1 = i4;
                    c03751.I$2 = i7;
                    c03751.I$3 = i5;
                    c03751.label = 3;
                    break;
                }
                return coroutineSingletons;
            case 3:
            case 4:
                i5 = c03751.I$3;
                i7 = c03751.I$2;
                int i14 = c03751.I$1;
                i8 = c03751.I$0;
                z4 = c03751.Z$0;
                Frame frame4 = (Frame) c03751.L$1;
                ByteWriteChannel byteWriteChannel5 = (ByteWriteChannel) c03751.L$0;
                ResultKt.throwOnFailure(obj);
                i10 = i14;
                frame3 = frame4;
                byteWriteChannel4 = byteWriteChannel5;
                i9 = i7;
                i11 = i5;
                sourceByteReadPacket$default = ByteReadPacketKt.ByteReadPacket$default(frame3.getData(), 0, 0, 6, null);
                if (!z4) {
                    iNextInt = Random.defaultRandom.nextInt();
                    c03751.L$0 = byteWriteChannel4;
                    c03751.L$1 = null;
                    c03751.L$2 = sourceByteReadPacket$default;
                    c03751.Z$0 = z4;
                    c03751.I$0 = i8;
                    c03751.I$1 = i10;
                    c03751.I$2 = i9;
                    c03751.I$3 = i11;
                    c03751.I$4 = iNextInt;
                    c03751.label = 5;
                    break;
                } else {
                    if (z4) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    c03751.L$0 = null;
                    c03751.L$1 = null;
                    c03751.L$2 = null;
                    c03751.L$3 = null;
                    c03751.Z$0 = z4;
                    c03751.I$0 = i8;
                    c03751.I$1 = i10;
                    c03751.I$2 = i9;
                    c03751.I$3 = i11;
                    c03751.label = 6;
                    break;
                }
                return coroutineSingletons;
            case 5:
                iNextInt = c03751.I$4;
                i11 = c03751.I$3;
                i9 = c03751.I$2;
                i10 = c03751.I$1;
                i8 = c03751.I$0;
                z4 = c03751.Z$0;
                sourceByteReadPacket$default = (Source) c03751.L$2;
                byteWriteChannel4 = (ByteWriteChannel) c03751.L$0;
                ResultKt.throwOnFailure(obj);
                sourceByteReadPacket$default = mask(sourceByteReadPacket$default, iNextInt);
                c03751.L$0 = null;
                c03751.L$1 = null;
                c03751.L$2 = null;
                c03751.L$3 = null;
                c03751.Z$0 = z4;
                c03751.I$0 = i8;
                c03751.I$1 = i10;
                c03751.I$2 = i9;
                c03751.I$3 = i11;
                c03751.label = 6;
                break;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
