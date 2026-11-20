package androidx.media3.exoplayer.audio;

import android.media.AudioDescriptor;
import android.media.AudioDeviceInfo;
import android.media.AudioProfile;
import android.os.Build;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.core.view.DisplayCompat;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.math.IntMath;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpeakerLayoutUtil {
    public static final RegularImmutableList DEFAULT_CHANNEL_MASK = ImmutableList.of((Object) 12);

    public static ImmutableList getChannelMasksFromPcmAudioProfiles(AudioDeviceInfo audioDeviceInfo) {
        List<AudioProfile> audioProfiles = audioDeviceInfo.getAudioProfiles();
        TreeSet treeSet = new TreeSet(Comparator.comparing(new AudioDescriptorUtil$$ExternalSyntheticLambda2()).reversed());
        for (AudioProfile audioProfile : audioProfiles) {
            if (audioProfile.getEncapsulationType() != 1 && Util.isEncodingLinearPcm(audioProfile.getFormat())) {
                for (int i : audioProfile.getChannelMasks()) {
                    treeSet.add(Integer.valueOf(i));
                }
            }
        }
        return ImmutableList.copyOf((Collection) treeSet);
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0183  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a0 A[RETURN] */
    public static ImmutableList getLoudspeakerLayoutChannelMasks(AudioDeviceInfo audioDeviceInfo) {
        int type;
        ImmutableList channelMasksFromPcmAudioProfiles;
        ImmutableList immutableListCopyOf;
        int speakerLayoutChannelMask;
        boolean zIsBluetoothDevice = IntMath.isBluetoothDevice(audioDeviceInfo.getType());
        RegularImmutableList regularImmutableList = DEFAULT_CHANNEL_MASK;
        if (!zIsBluetoothDevice) {
            if (audioDeviceInfo.getType() == 1) {
                return ImmutableList.of((Object) 4);
            }
            if (audioDeviceInfo.getType() == 2) {
                if (Build.VERSION.SDK_INT >= 36 && (speakerLayoutChannelMask = audioDeviceInfo.getSpeakerLayoutChannelMask()) != 0 && speakerLayoutChannelMask != 1) {
                    return ImmutableList.of((Object) Integer.valueOf(speakerLayoutChannelMask));
                }
                Log.w("SpeakerLayoutUtil", "Built-in speaker's getSpeakerLayoutChannelMask not usable, defaulting to stereo.");
                return regularImmutableList;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 31 && audioDeviceInfo.getType() == 10) {
                ImmutableList channelMasksFromPcmAudioProfiles2 = getChannelMasksFromPcmAudioProfiles(audioDeviceInfo);
                if (!channelMasksFromPcmAudioProfiles2.isEmpty()) {
                    return channelMasksFromPcmAudioProfiles2;
                }
                ImmutableList allLpcmChannelMasksFromPcmSads = DisplayCompat.getAllLpcmChannelMasksFromPcmSads(audioDeviceInfo.getAudioDescriptors());
                if (!allLpcmChannelMasksFromPcmSads.isEmpty()) {
                    return allLpcmChannelMasksFromPcmSads;
                }
            } else if (i >= 31) {
                int type2 = audioDeviceInfo.getType();
                if (i >= 31 && type2 == 29) {
                    ImmutableList channelMasksFromPcmAudioProfiles3 = getChannelMasksFromPcmAudioProfiles(audioDeviceInfo);
                    if (!channelMasksFromPcmAudioProfiles3.isEmpty()) {
                        return channelMasksFromPcmAudioProfiles3;
                    }
                    List<AudioDescriptor> audioDescriptors = audioDeviceInfo.getAudioDescriptors();
                    if (i >= 34) {
                        if (i < 34 || audioDescriptors == null) {
                            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                            immutableListCopyOf = RegularImmutableList.EMPTY;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            Iterator<AudioDescriptor> it = audioDescriptors.iterator();
                            while (it.hasNext()) {
                                AudioDescriptor audioDescriptorM = FrameworkMediaDrm$$ExternalSyntheticLambda0.m((Object) it.next());
                                if (audioDescriptorM.getStandard() == 2) {
                                    byte[] descriptor = audioDescriptorM.getDescriptor();
                                    if (descriptor.length != 3) {
                                        Log.w("AudioDescriptorUtil", "Invalid SADB length: " + descriptor.length);
                                    } else {
                                        int i2 = 0;
                                        if (Build.VERSION.SDK_INT >= 34 && descriptor.length == 3) {
                                            byte b = descriptor[0];
                                            i2 = (b & 1) != 0 ? 12 : 0;
                                            if ((b & 2) != 0) {
                                                i2 |= 32;
                                            }
                                            if ((b & 4) != 0) {
                                                i2 |= 16;
                                            }
                                            if ((b & 8) != 0) {
                                                i2 |= 192;
                                            }
                                            if ((b & 16) != 0) {
                                                i2 |= 1024;
                                            }
                                            if ((b & 32) != 0) {
                                                i2 |= 768;
                                            }
                                            if ((b & 128) != 0) {
                                                i2 |= 201326592;
                                            }
                                            byte b2 = descriptor[1];
                                            if ((b2 & 1) != 0) {
                                                i2 |= 81920;
                                            }
                                            if ((b2 & 2) != 0) {
                                                i2 |= 8192;
                                            }
                                            if ((b2 & 4) != 0) {
                                                i2 |= 32768;
                                            }
                                            if ((b2 & 8) != 0) {
                                                i2 |= 6144;
                                            }
                                            if ((b2 & 16) != 0) {
                                                i2 |= 33554432;
                                            }
                                            if ((b2 & 32) != 0) {
                                                i2 |= 262144;
                                            }
                                            if ((b2 & 64) != 0) {
                                                i2 |= 6144;
                                            }
                                            if ((b2 & 128) != 0) {
                                                i2 |= 3145728;
                                            }
                                            byte b3 = descriptor[2];
                                            if ((b3 & 1) != 0) {
                                                i2 |= 655360;
                                            }
                                            if ((b3 & 2) != 0) {
                                                i2 = 8388608 | i2;
                                            }
                                            if ((b3 & 4) != 0) {
                                                i2 |= 20971520;
                                            }
                                        }
                                        arrayList.add(Integer.valueOf(i2));
                                    }
                                }
                            }
                            arrayList.sort(new LayoutNode$$ExternalSyntheticLambda1((byte) 8));
                            immutableListCopyOf = ImmutableList.copyOf((Collection) arrayList);
                        }
                        if (!immutableListCopyOf.isEmpty()) {
                            return immutableListCopyOf;
                        }
                    }
                    ImmutableList allLpcmChannelMasksFromPcmSads2 = DisplayCompat.getAllLpcmChannelMasksFromPcmSads(audioDescriptors);
                    if (!allLpcmChannelMasksFromPcmSads2.isEmpty()) {
                        return allLpcmChannelMasksFromPcmSads2;
                    }
                } else if (i >= 31 && ((type = audioDeviceInfo.getType()) == 11 || type == 12 || (i >= 31 && type == 22))) {
                    channelMasksFromPcmAudioProfiles = getChannelMasksFromPcmAudioProfiles(audioDeviceInfo);
                    if (!channelMasksFromPcmAudioProfiles.isEmpty()) {
                        return channelMasksFromPcmAudioProfiles;
                    }
                }
            } else if (i >= 31) {
                channelMasksFromPcmAudioProfiles = getChannelMasksFromPcmAudioProfiles(audioDeviceInfo);
                if (!channelMasksFromPcmAudioProfiles.isEmpty()) {
                    return channelMasksFromPcmAudioProfiles;
                }
            }
        }
        return regularImmutableList;
    }
}
