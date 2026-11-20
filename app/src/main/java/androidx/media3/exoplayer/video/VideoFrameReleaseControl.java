package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Choreographer;
import android.view.Surface;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal.EocdRecord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoFrameReleaseControl {
    public final short allowedJoiningTimeMs;
    public boolean frameReadyWithoutSurface;
    public final VideoFrameReleaseHelper frameReleaseHelper;
    public final MediaCodecVideoRenderer frameTimingEvaluator;
    public boolean hasOutputSurface;
    public boolean joiningRenderNextFrameImmediately;
    public long lastReleaseRealtimeUs;
    public boolean started;
    public int firstFrameState = 0;
    public long initialPositionUs = -9223372036854775807L;
    public long lastPresentationTimeUs = -9223372036854775807L;
    public long joiningDeadlineMs = -9223372036854775807L;
    public float playbackSpeed = 1.0f;
    public SystemClock clock = SystemClock.DEFAULT;

    /* JADX WARN: Type inference failed for: r2v1, types: [int, short] */
    public VideoFrameReleaseControl(Context context, MediaCodecVideoRenderer mediaCodecVideoRenderer, long j) {
        this.frameTimingEvaluator = mediaCodecVideoRenderer;
        this.allowedJoiningTimeMs = (int) j;
        this.frameReleaseHelper = new VideoFrameReleaseHelper(context);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:101:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:103:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:106:0x01de  */
    /* JADX WARN: Code duplicated, block: B:109:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:110:0x0200  */
    /* JADX WARN: Code duplicated, block: B:111:0x0204  */
    /* JADX WARN: Code duplicated, block: B:114:0x0216  */
    /* JADX WARN: Code duplicated, block: B:115:0x021a  */
    /* JADX WARN: Code duplicated, block: B:147:0x029f  */
    /* JADX WARN: Code duplicated, block: B:150:0x02ac A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:152:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:161:0x02c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0082  */
    /* JADX WARN: Code duplicated, block: B:86:0x0178 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x0179  */
    /* JADX WARN: Code duplicated, block: B:94:0x019b  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:98:0x01af  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int getFrameReleaseAction(long j, long j2, long j3, long j4, boolean z, boolean z2, EocdRecord eocdRecord) {
        long j5;
        long j6;
        long j7;
        int i;
        int i2;
        boolean z3;
        long jNanoTime;
        VideoFrameReleaseHelper videoFrameReleaseHelper;
        long j8;
        int i3;
        int i4;
        VideoFrameReleaseHelper.VSyncSampler vSyncSampler;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        boolean z4;
        long j15;
        float f;
        float f2;
        long j16;
        FixedFrameRateEstimator fixedFrameRateEstimator;
        long j17;
        FixedFrameRateEstimator.Matcher matcher;
        long j18;
        eocdRecord.entryCount = -9223372036854775807L;
        eocdRecord.centralDirectoryOffset = -9223372036854775807L;
        if (this.started && this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j2;
        }
        if (this.lastPresentationTimeUs != j) {
            VideoFrameReleaseHelper videoFrameReleaseHelper2 = this.frameReleaseHelper;
            j5 = -9223372036854775807L;
            long j19 = videoFrameReleaseHelper2.pendingLastAdjustedFrameIndex;
            if (j19 != -1) {
                videoFrameReleaseHelper2.lastAdjustedFrameIndex = j19;
                videoFrameReleaseHelper2.lastAdjustedReleaseTimeNs = videoFrameReleaseHelper2.pendingLastAdjustedReleaseTimeNs;
                videoFrameReleaseHelper2.lastAdjustedPresentationTimeUs = videoFrameReleaseHelper2.pendingLastPresentationTimeUs;
                videoFrameReleaseHelper2.lastVsyncHysteresisOffsetNs = videoFrameReleaseHelper2.pendingVsyncHysteresisOffsetNs;
            }
            videoFrameReleaseHelper2.frameIndex++;
            FixedFrameRateEstimator fixedFrameRateEstimator2 = videoFrameReleaseHelper2.frameRateEstimator;
            j6 = 1000;
            long j20 = j * 1000;
            fixedFrameRateEstimator2.currentMatcher.onNextFrame(j20);
            if (fixedFrameRateEstimator2.currentMatcher.isSynced()) {
                fixedFrameRateEstimator2.candidateMatcherActive = false;
                j7 = 0;
            } else {
                j7 = 0;
                if (fixedFrameRateEstimator2.lastFramePresentationTimeNs != -9223372036854775807L) {
                    if (fixedFrameRateEstimator2.candidateMatcherActive) {
                        FixedFrameRateEstimator.Matcher matcher2 = fixedFrameRateEstimator2.candidateMatcher;
                        long j21 = matcher2.frameCount;
                        if (j21 == 0 ? false : matcher2.recentFrameOutlierFlags[(int) ((j21 - 1) % 15)]) {
                            fixedFrameRateEstimator2.candidateMatcher.reset();
                            fixedFrameRateEstimator2.candidateMatcher.onNextFrame(fixedFrameRateEstimator2.lastFramePresentationTimeNs);
                        }
                    } else {
                        fixedFrameRateEstimator2.candidateMatcher.reset();
                        fixedFrameRateEstimator2.candidateMatcher.onNextFrame(fixedFrameRateEstimator2.lastFramePresentationTimeNs);
                    }
                    fixedFrameRateEstimator2.candidateMatcherActive = true;
                    fixedFrameRateEstimator2.candidateMatcher.onNextFrame(j20);
                }
            }
            if (fixedFrameRateEstimator2.candidateMatcherActive && fixedFrameRateEstimator2.candidateMatcher.isSynced()) {
                FixedFrameRateEstimator.Matcher matcher3 = fixedFrameRateEstimator2.currentMatcher;
                fixedFrameRateEstimator2.currentMatcher = fixedFrameRateEstimator2.candidateMatcher;
                fixedFrameRateEstimator2.candidateMatcher = matcher3;
                fixedFrameRateEstimator2.candidateMatcherActive = false;
            }
            fixedFrameRateEstimator2.lastFramePresentationTimeNs = j20;
            fixedFrameRateEstimator2.framesWithoutSyncCount = fixedFrameRateEstimator2.currentMatcher.isSynced() ? 0 : fixedFrameRateEstimator2.framesWithoutSyncCount + 1;
            videoFrameReleaseHelper2.updateSurfaceMediaFrameRate();
            this.lastPresentationTimeUs = j;
        } else {
            j5 = -9223372036854775807L;
            j6 = 1000;
            j7 = 0;
        }
        long jMsToUs = (long) ((j - j2) / ((double) this.playbackSpeed));
        if (this.started) {
            this.clock.getClass();
            jMsToUs -= Util.msToUs(android.os.SystemClock.elapsedRealtime()) - j3;
        }
        eocdRecord.entryCount = jMsToUs;
        if (!z || z2) {
            if (this.hasOutputSurface) {
                long j22 = -30000;
                if (this.joiningDeadlineMs == j5 || this.joiningRenderNextFrameImmediately) {
                    int i5 = this.firstFrameState;
                    if (i5 != 0) {
                        if (i5 == 1) {
                            i = 3;
                            i2 = 5;
                        } else if (i5 == 2) {
                            i = 3;
                            i2 = 5;
                            if (j2 >= j4) {
                            }
                        } else {
                            if (i5 != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                return 0;
                            }
                            this.clock.getClass();
                            i = 3;
                            i2 = 5;
                            long jMsToUs2 = Util.msToUs(android.os.SystemClock.elapsedRealtime()) - this.lastReleaseRealtimeUs;
                            if (this.started) {
                                long j23 = this.initialPositionUs;
                                if (j23 == j5 || j23 == j2 || jMsToUs >= -30000 || jMsToUs2 <= 100000) {
                                }
                            }
                        }
                        z3 = true;
                    } else {
                        i = 3;
                        i2 = 5;
                        z3 = this.started;
                    }
                    if (z3) {
                        return 0;
                    }
                    if (this.started && j2 != this.initialPositionUs) {
                        this.clock.getClass();
                        jNanoTime = System.nanoTime();
                        videoFrameReleaseHelper = this.frameReleaseHelper;
                        j8 = (eocdRecord.entryCount * j6) + jNanoTime;
                        if (videoFrameReleaseHelper.lastAdjustedFrameIndex != -1) {
                            if (videoFrameReleaseHelper.frameRateEstimator.currentMatcher.isSynced()) {
                                fixedFrameRateEstimator = videoFrameReleaseHelper.frameRateEstimator;
                                if (fixedFrameRateEstimator.currentMatcher.isSynced()) {
                                    matcher = fixedFrameRateEstimator.currentMatcher;
                                    i4 = 2;
                                    j18 = matcher.matchingFrameCount;
                                    i3 = 1;
                                    if (j18 == j7) {
                                        j17 = j7;
                                    } else {
                                        j17 = matcher.matchingFrameDurationSumNs / j18;
                                    }
                                } else {
                                    i3 = 1;
                                    i4 = 2;
                                    j17 = j5;
                                }
                                f = (videoFrameReleaseHelper.frameIndex - videoFrameReleaseHelper.lastAdjustedFrameIndex) * j17;
                                f2 = videoFrameReleaseHelper.playbackSpeed;
                            } else {
                                i3 = 1;
                                i4 = 2;
                                f = (j - videoFrameReleaseHelper.lastAdjustedPresentationTimeUs) * j6;
                                f2 = videoFrameReleaseHelper.playbackSpeed;
                            }
                            j16 = videoFrameReleaseHelper.lastAdjustedReleaseTimeNs + ((long) (f / f2));
                            if (Math.abs(j8 - j16) <= 20000000) {
                                j8 = j16;
                            } else {
                                videoFrameReleaseHelper.resetAdjustment();
                            }
                        } else {
                            i3 = 1;
                            i4 = 2;
                            j22 = -30000;
                        }
                        videoFrameReleaseHelper.pendingLastAdjustedFrameIndex = videoFrameReleaseHelper.frameIndex;
                        videoFrameReleaseHelper.pendingLastAdjustedReleaseTimeNs = j8;
                        videoFrameReleaseHelper.pendingLastPresentationTimeUs = j;
                        vSyncSampler = videoFrameReleaseHelper.vsyncSampler;
                        if (vSyncSampler == null) {
                            j12 = jNanoTime;
                        } else {
                            j9 = vSyncSampler.sampledVsyncTimeNs;
                            long j24 = videoFrameReleaseHelper.vsyncSampler.vsyncDurationNs;
                            if (j9 != j5 || j24 == j5) {
                                j12 = jNanoTime;
                            } else {
                                long j25 = (((j8 - j9) / j24) * j24) + j9;
                                if (j8 <= j25) {
                                    j10 = j25 - j24;
                                } else {
                                    j25 += j24;
                                    j10 = j25;
                                }
                                long j26 = j25 - j8;
                                long j27 = j8 - j10;
                                long jAbs = Math.abs(j26 - j27);
                                if (jAbs < j24 / 2) {
                                    j11 = j10;
                                    j13 = j24 / 4;
                                    if (jAbs < j13) {
                                        j12 = jNanoTime;
                                        long j28 = videoFrameReleaseHelper.lastVsyncHysteresisOffsetNs;
                                        if (j28 != j7) {
                                            videoFrameReleaseHelper.pendingVsyncHysteresisOffsetNs = j28;
                                            j13 = j28;
                                        } else {
                                            if (j26 < j27) {
                                                j13 = -j13;
                                            }
                                            videoFrameReleaseHelper.pendingVsyncHysteresisOffsetNs = j13;
                                        }
                                    } else {
                                        j12 = jNanoTime;
                                        j13 = j7;
                                        videoFrameReleaseHelper.pendingVsyncHysteresisOffsetNs = j13;
                                    }
                                } else {
                                    j11 = j10;
                                    j12 = jNanoTime;
                                    j13 = videoFrameReleaseHelper.lastVsyncHysteresisOffsetNs;
                                    videoFrameReleaseHelper.pendingVsyncHysteresisOffsetNs = j13;
                                }
                                if (j26 + j13 >= j27) {
                                    j25 = j11;
                                }
                                j8 = j25 - ((j24 * 80) / 100);
                            }
                        }
                        eocdRecord.centralDirectoryOffset = j8;
                        j14 = (j8 - j12) / j6;
                        eocdRecord.entryCount = j14;
                        if (this.joiningDeadlineMs != j5 || this.joiningRenderNextFrameImmediately) {
                            z4 = 0;
                        } else {
                            z4 = i3;
                        }
                        if (this.frameTimingEvaluator.shouldIgnoreFrame(j14, j2, z2, z4)) {
                            return 4;
                        }
                        j15 = eocdRecord.entryCount;
                        if (j15 >= j22 && !z2) {
                            return z4 != 0 ? i : i4;
                        }
                        if (j15 > 50000) {
                            return i3;
                        }
                    }
                    return i2;
                }
                i = 3;
                i2 = 5;
                z3 = false;
                if (z3) {
                    return 0;
                }
                if (this.started) {
                    this.clock.getClass();
                    jNanoTime = System.nanoTime();
                    videoFrameReleaseHelper = this.frameReleaseHelper;
                    j8 = (eocdRecord.entryCount * j6) + jNanoTime;
                    if (videoFrameReleaseHelper.lastAdjustedFrameIndex != -1) {
                        if (videoFrameReleaseHelper.frameRateEstimator.currentMatcher.isSynced()) {
                            fixedFrameRateEstimator = videoFrameReleaseHelper.frameRateEstimator;
                            if (fixedFrameRateEstimator.currentMatcher.isSynced()) {
                                matcher = fixedFrameRateEstimator.currentMatcher;
                                i4 = 2;
                                j18 = matcher.matchingFrameCount;
                                i3 = 1;
                                if (j18 == j7) {
                                    j17 = j7;
                                } else {
                                    j17 = matcher.matchingFrameDurationSumNs / j18;
                                }
                            } else {
                                i3 = 1;
                                i4 = 2;
                                j17 = j5;
                            }
                            f = (videoFrameReleaseHelper.frameIndex - videoFrameReleaseHelper.lastAdjustedFrameIndex) * j17;
                            f2 = videoFrameReleaseHelper.playbackSpeed;
                        } else {
                            i3 = 1;
                            i4 = 2;
                            f = (j - videoFrameReleaseHelper.lastAdjustedPresentationTimeUs) * j6;
                            f2 = videoFrameReleaseHelper.playbackSpeed;
                        }
                        j16 = videoFrameReleaseHelper.lastAdjustedReleaseTimeNs + ((long) (f / f2));
                        if (Math.abs(j8 - j16) <= 20000000) {
                            j8 = j16;
                        } else {
                            videoFrameReleaseHelper.resetAdjustment();
                        }
                    } else {
                        i3 = 1;
                        i4 = 2;
                        j22 = -30000;
                    }
                    videoFrameReleaseHelper.pendingLastAdjustedFrameIndex = videoFrameReleaseHelper.frameIndex;
                    videoFrameReleaseHelper.pendingLastAdjustedReleaseTimeNs = j8;
                    videoFrameReleaseHelper.pendingLastPresentationTimeUs = j;
                    vSyncSampler = videoFrameReleaseHelper.vsyncSampler;
                    if (vSyncSampler == null) {
                        j12 = jNanoTime;
                    } else {
                        j9 = vSyncSampler.sampledVsyncTimeNs;
                        long j29 = videoFrameReleaseHelper.vsyncSampler.vsyncDurationNs;
                        if (j9 != j5) {
                            j12 = jNanoTime;
                        } else {
                            j12 = jNanoTime;
                        }
                    }
                    eocdRecord.centralDirectoryOffset = j8;
                    j14 = (j8 - j12) / j6;
                    eocdRecord.entryCount = j14;
                    if (this.joiningDeadlineMs != j5) {
                        z4 = 0;
                    } else {
                        z4 = 0;
                    }
                    if (this.frameTimingEvaluator.shouldIgnoreFrame(j14, j2, z2, z4)) {
                        return 4;
                    }
                    j15 = eocdRecord.entryCount;
                    if (j15 >= j22) {
                    }
                    if (j15 > 50000) {
                        return i3;
                    }
                }
                return i2;
            }
            if (this.frameTimingEvaluator.shouldIgnoreFrame(jMsToUs, j2, z2, true)) {
                return 4;
            }
            if (!this.started || eocdRecord.entryCount >= 30000) {
                this.frameReadyWithoutSurface = true;
                return 5;
            }
        }
        return 3;
    }

    public final boolean isReady(boolean z) {
        if (z && (this.firstFrameState == 3 || (this.frameReadyWithoutSurface && !this.hasOutputSurface))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        this.clock.getClass();
        if (android.os.SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    public final void join(boolean z) {
        long jElapsedRealtime;
        this.joiningRenderNextFrameImmediately = z;
        long j = this.allowedJoiningTimeMs;
        if (j > 0) {
            this.clock.getClass();
            jElapsedRealtime = android.os.SystemClock.elapsedRealtime() + j;
        } else {
            jElapsedRealtime = -9223372036854775807L;
        }
        this.joiningDeadlineMs = jElapsedRealtime;
    }

    public final void onStarted() {
        this.started = true;
        this.clock.getClass();
        this.lastReleaseRealtimeUs = Util.msToUs(android.os.SystemClock.elapsedRealtime());
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.frameReleaseHelper;
        videoFrameReleaseHelper.started = true;
        videoFrameReleaseHelper.resetAdjustment();
        DisplayManager displayManager = (DisplayManager) videoFrameReleaseHelper.context.getSystemService("display");
        VideoFrameReleaseHelper.VSyncSampler vSyncSamplerV33 = null;
        if (displayManager != null) {
            try {
                Choreographer choreographer = Choreographer.getInstance();
                vSyncSamplerV33 = Build.VERSION.SDK_INT >= 33 ? new VideoFrameReleaseHelper.VSyncSamplerV33(choreographer, displayManager) : new VideoFrameReleaseHelper.VSyncSamplerBase(choreographer, displayManager);
            } catch (RuntimeException e) {
                Log.w("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
            }
        }
        videoFrameReleaseHelper.vsyncSampler = vSyncSamplerV33;
        if (vSyncSamplerV33 != null) {
            vSyncSamplerV33.register();
        }
        videoFrameReleaseHelper.updateSurfacePlaybackFrameRate(false);
    }

    public final void onStreamChanged(int i) {
        if (i == 0) {
            this.firstFrameState = 1;
        } else if (i == 1) {
            this.firstFrameState = 0;
        } else {
            if (i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return;
            }
            this.firstFrameState = Math.min(this.firstFrameState, 2);
        }
        this.frameReleaseHelper.resetAdjustment();
    }

    public final void setFrameRate(float f) {
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.frameReleaseHelper;
        videoFrameReleaseHelper.formatFrameRate = f;
        FixedFrameRateEstimator fixedFrameRateEstimator = videoFrameReleaseHelper.frameRateEstimator;
        fixedFrameRateEstimator.currentMatcher.reset();
        fixedFrameRateEstimator.candidateMatcher.reset();
        fixedFrameRateEstimator.candidateMatcherActive = false;
        fixedFrameRateEstimator.lastFramePresentationTimeNs = -9223372036854775807L;
        fixedFrameRateEstimator.framesWithoutSyncCount = 0;
        videoFrameReleaseHelper.updateSurfaceMediaFrameRate();
    }

    public final void setOutputSurface(Surface surface) {
        this.hasOutputSurface = surface != null;
        this.frameReadyWithoutSurface = false;
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.frameReleaseHelper;
        if (videoFrameReleaseHelper.surface != surface) {
            videoFrameReleaseHelper.clearSurfaceFrameRate();
            videoFrameReleaseHelper.surface = surface;
            videoFrameReleaseHelper.updateSurfacePlaybackFrameRate(true);
        }
        this.firstFrameState = Math.min(this.firstFrameState, 1);
    }

    public final void setPlaybackSpeed(float f) {
        UtilsKt.checkArgument(f > CropImageView.DEFAULT_ASPECT_RATIO);
        if (f == this.playbackSpeed) {
            return;
        }
        this.playbackSpeed = f;
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.frameReleaseHelper;
        videoFrameReleaseHelper.playbackSpeed = f;
        videoFrameReleaseHelper.updateSurfacePlaybackFrameRate(false);
    }
}
