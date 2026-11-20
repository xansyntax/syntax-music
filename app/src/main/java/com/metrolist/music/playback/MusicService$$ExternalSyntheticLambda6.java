package com.metrolist.music.playback;

import android.media.AudioManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.audio.AudioFocusManager;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicService$$ExternalSyntheticLambda6 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MusicService$$ExternalSyntheticLambda6(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        AudioAttributes audioAttributes;
        byte b = this.$r8$classId;
        byte b2 = 1;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                MusicService musicService = (MusicService) obj;
                boolean z = MusicService.isRunning;
                Float fValueOf = Float.valueOf(1.0f);
                StateFlowImpl stateFlowImpl = musicService.audioFocusVolumeMultiplier;
                Continuation continuation = null;
                if (i != -3) {
                    if (i != -2) {
                        if (i != -1) {
                            if (i == 1 || i == 2) {
                                musicService.hasAudioFocus = true;
                                stateFlowImpl.getClass();
                                stateFlowImpl.updateState(null, fValueOf);
                                if (musicService.wasPlayingBeforeAudioFocusLoss && !musicService.player.isPlaying() && !musicService.reentrantFocusGain) {
                                    musicService.reentrantFocusGain = true;
                                    AwaitKt.launch$default(musicService.scope, null, null, new MusicService.AnonymousClass2(b2, musicService, continuation), 3);
                                }
                                musicService.applyEffectiveVolume();
                                break;
                            } else if (i == 3) {
                                musicService.hasAudioFocus = true;
                                stateFlowImpl.getClass();
                                stateFlowImpl.updateState(null, fValueOf);
                                musicService.applyEffectiveVolume();
                                break;
                            }
                        } else {
                            musicService.hasAudioFocus = false;
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(null, fValueOf);
                            musicService.wasPlayingBeforeAudioFocusLoss = musicService.player.isPlaying();
                            if (musicService.player.isPlaying()) {
                                musicService.player.setPlayWhenReady(false);
                            }
                            musicService.abandonAudioFocus();
                            break;
                        }
                    } else {
                        musicService.hasAudioFocus = false;
                        stateFlowImpl.getClass();
                        stateFlowImpl.updateState(null, fValueOf);
                        musicService.wasPlayingBeforeAudioFocusLoss = musicService.player.isPlaying();
                        if (musicService.player.isPlaying()) {
                            musicService.player.setPlayWhenReady(false);
                        }
                        break;
                    }
                } else {
                    musicService.hasAudioFocus = false;
                    Float fValueOf2 = Float.valueOf(0.2f);
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, fValueOf2);
                    musicService.wasPlayingBeforeAudioFocusLoss = musicService.player.isPlaying();
                    if (musicService.player.isPlaying()) {
                        musicService.applyEffectiveVolume();
                    }
                    break;
                }
                break;
            default:
                AudioFocusManager audioFocusManager = (AudioFocusManager) obj;
                audioFocusManager.getClass();
                if (i == -3 || i == -2) {
                    if (i != -2 && ((audioAttributes = audioFocusManager.audioAttributes) == null || audioAttributes.contentType != 1)) {
                        audioFocusManager.setAudioFocusState(4);
                    } else {
                        ExoPlayerImplInternal exoPlayerImplInternal = audioFocusManager.playerControl;
                        if (exoPlayerImplInternal != null) {
                            SystemHandlerWrapper systemHandlerWrapper = exoPlayerImplInternal.handler;
                            systemHandlerWrapper.getClass();
                            SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
                            systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(33, 0, 0);
                            systemMessageObtainSystemMessage.sendToTarget();
                        }
                        audioFocusManager.setAudioFocusState(3);
                    }
                } else if (i == -1) {
                    ExoPlayerImplInternal exoPlayerImplInternal2 = audioFocusManager.playerControl;
                    if (exoPlayerImplInternal2 != null) {
                        SystemHandlerWrapper systemHandlerWrapper2 = exoPlayerImplInternal2.handler;
                        systemHandlerWrapper2.getClass();
                        SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage2 = SystemHandlerWrapper.obtainSystemMessage();
                        systemMessageObtainSystemMessage2.message = systemHandlerWrapper2.handler.obtainMessage(33, -1, 0);
                        systemMessageObtainSystemMessage2.sendToTarget();
                    }
                    audioFocusManager.abandonAudioFocusIfHeld();
                    audioFocusManager.setAudioFocusState(1);
                } else if (i == 1) {
                    audioFocusManager.setAudioFocusState(2);
                    ExoPlayerImplInternal exoPlayerImplInternal3 = audioFocusManager.playerControl;
                    if (exoPlayerImplInternal3 != null) {
                        SystemHandlerWrapper systemHandlerWrapper3 = exoPlayerImplInternal3.handler;
                        systemHandlerWrapper3.getClass();
                        SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage3 = SystemHandlerWrapper.obtainSystemMessage();
                        systemMessageObtainSystemMessage3.message = systemHandlerWrapper3.handler.obtainMessage(33, 1, 0);
                        systemMessageObtainSystemMessage3.sendToTarget();
                    }
                } else {
                    Format$$ExternalSyntheticOutline0.m(i, "Unknown focus change type: ", "AudioFocusManager");
                }
                break;
        }
    }
}
