package androidx.compose.ui.focus;

import android.os.Trace;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ScatterMapKt;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.RawWebSocketCommonKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public FocusTargetNode activeFocusTargetNode;
    public final FocusInvalidationManager focusInvalidationManager;
    public MutableLongSet keysCurrentlyDown;
    public final AndroidComposeView owner;
    public final AndroidComposeView platformFocusOwner;
    public final FocusTargetNode rootFocusNode = new FocusTargetNode(2, null, 14);
    public final FocusOwnerImpl$modifier$1 modifier = new ModifierNodeElement() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final Modifier.Node create() {
            return this.this$0.rootFocusNode;
        }

        public final boolean equals(Object obj) {
            return obj == this;
        }

        public final int hashCode() {
            return this.this$0.rootFocusNode.hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(Modifier.Node node) {
        }
    };
    public final MutableObjectList listeners = new MutableObjectList(1);

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.ui.focus.FocusOwnerImpl$modifier$1] */
    public FocusOwnerImpl(AndroidComposeView androidComposeView, AndroidComposeView androidComposeView2) {
        this.platformFocusOwner = androidComposeView;
        this.owner = androidComposeView2;
        this.focusInvalidationManager = new FocusInvalidationManager(this, androidComposeView2);
    }

    public final boolean clearFocus(boolean z) {
        NodeChain nodeChain;
        if (getActiveFocusTargetNode() != null) {
            FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
            setActiveFocusTargetNode(null);
            if (activeFocusTargetNode != null) {
                FocusStateImpl focusStateImpl = FocusStateImpl.Active;
                FocusStateImpl focusStateImpl2 = FocusStateImpl.Inactive;
                activeFocusTargetNode.dispatchFocusCallbacks$ui(focusStateImpl, focusStateImpl2);
                if (!activeFocusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node = activeFocusTargetNode.node.parent;
                LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
                while (layoutNodeRequireLayoutNode != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 1024) != 0) {
                                Modifier.Node nodePop = node;
                                MutableVector mutableVector = null;
                                while (nodePop != null) {
                                    if (nodePop instanceof FocusTargetNode) {
                                        ((FocusTargetNode) nodePop).dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, focusStateImpl2);
                                    } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                        int i = 0;
                                        for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                            if ((node2.kindSet & 1024) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    nodePop = node2;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodePop != null) {
                                                        mutableVector.add(nodePop);
                                                        nodePop = null;
                                                    }
                                                    mutableVector.add(node2);
                                                }
                                            }
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    nodePop = HitTestResultKt.pop(mutableVector);
                                }
                            }
                            node = node.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: clearFocus-I7lrPNg, reason: not valid java name */
    public final boolean m409clearFocusI7lrPNg(int i, boolean z, boolean z2) {
        int iOrdinal;
        boolean z3 = true;
        if (z || (iOrdinal = FocusTraversalKt.m425performCustomClearFocusMxy_nc0(this.rootFocusNode, i).ordinal()) == 0) {
            clearFocus(z);
        } else {
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return false;
            }
            z3 = false;
        }
        if (z3 && z2) {
            clearOwnerFocus();
        }
        return z3;
    }

    public final void clearOwnerFocus() {
        AndroidComposeView androidComposeView = this.platformFocusOwner;
        if (androidComposeView.isFocused() || androidComposeView.hasFocus()) {
            androidComposeView.clearFocus();
        } else if (androidComposeView.hasFocus()) {
            View viewFindFocus = androidComposeView.findFocus();
            if (viewFindFocus != null) {
                viewFindFocus.clearFocus();
            }
            androidComposeView.clearFocus();
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0159 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0169 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x016e  */
    /* JADX WARN: Code duplicated, block: B:316:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:0x008a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:323:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x005d A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:336:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:337:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:338:0x0162 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:345:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:349:0x014b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0063 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x006e A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x007a A[ADDED_TO_REGION, LOOP:12: B:39:0x007a->B:67:0x00c6, LOOP_START, PHI: r6
      0x007a: PHI (r6v29 androidx.compose.ui.Modifier$Node) = (r6v23 androidx.compose.ui.Modifier$Node), (r6v30 androidx.compose.ui.Modifier$Node) binds: [B:38:0x0078, B:67:0x00c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x007c A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:44:0x0086 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x008b A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00df A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0104 A[ADDED_TO_REGION, LOOP:16: B:85:0x0104->B:113:0x0150, LOOP_START, PHI: r12
      0x0104: PHI (r12v14 androidx.compose.ui.Modifier$Node) = (r12v8 androidx.compose.ui.Modifier$Node), (r12v15 androidx.compose.ui.Modifier$Node) binds: [B:84:0x0102, B:113:0x0150] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x0106 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x010c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0110 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0115 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x011b A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x0030, B:17:0x0036, B:18:0x003c, B:20:0x0044, B:22:0x0049, B:24:0x004f, B:28:0x0055, B:126:0x0171, B:128:0x0177, B:129:0x017a, B:131:0x0185, B:134:0x0193, B:138:0x019d, B:141:0x01a3, B:142:0x01a8, B:145:0x01b0, B:147:0x01b6, B:149:0x01ba, B:151:0x01c2, B:153:0x01c8, B:157:0x01d0, B:159:0x01d9, B:160:0x01dd, B:161:0x01e0, B:164:0x01e6, B:165:0x01eb, B:166:0x01ee, B:168:0x01f4, B:170:0x01f8, B:173:0x0201, B:175:0x0209, B:182:0x0220, B:184:0x0225, B:186:0x0229, B:209:0x026b, B:190:0x0235, B:192:0x023b, B:194:0x023f, B:196:0x0247, B:198:0x024d, B:202:0x0255, B:204:0x025e, B:205:0x0262, B:206:0x0265, B:210:0x0270, B:214:0x0280, B:216:0x0285, B:218:0x0289, B:241:0x02cb, B:222:0x0295, B:224:0x029b, B:226:0x029f, B:228:0x02a7, B:230:0x02ad, B:234:0x02b5, B:236:0x02be, B:237:0x02c2, B:238:0x02c5, B:243:0x02d2, B:245:0x02d9, B:32:0x005d, B:34:0x0063, B:35:0x0066, B:37:0x006e, B:40:0x007c, B:44:0x0086, B:75:0x00db, B:77:0x00df, B:47:0x008b, B:49:0x0091, B:51:0x0095, B:53:0x009d, B:55:0x00a3, B:59:0x00ab, B:61:0x00b4, B:62:0x00b8, B:63:0x00bb, B:66:0x00c1, B:67:0x00c6, B:68:0x00c9, B:70:0x00cf, B:72:0x00d3, B:78:0x00e5, B:80:0x00eb, B:81:0x00ee, B:83:0x00f8, B:86:0x0106, B:90:0x0110, B:121:0x0165, B:123:0x0169, B:93:0x0115, B:95:0x011b, B:97:0x011f, B:99:0x0127, B:101:0x012d, B:105:0x0135, B:107:0x013e, B:108:0x0142, B:109:0x0145, B:112:0x014b, B:113:0x0150, B:114:0x0153, B:116:0x0159, B:118:0x015d), top: B:255:0x0007 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r12v24, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v25, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v29, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v30, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v34, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v43, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v49 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v65 */
    /* JADX WARN: Type inference failed for: r12v66 */
    /* JADX WARN: Type inference failed for: r12v67 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w, reason: not valid java name */
    public final boolean m410dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0 function0) {
        Modifier.Node node;
        LayoutNode layoutNodeRequireLayoutNode;
        Object obj;
        Object obj2;
        Modifier.Node node2;
        NodeChain nodeChain;
        Modifier.Node nodePop;
        MutableVector mutableVector;
        Modifier.Node node3;
        LayoutNode layoutNodeRequireLayoutNode2;
        Object obj3;
        Object obj4;
        NodeChain nodeChain2;
        MutableVector mutableVector2;
        Modifier.Node nodePop2;
        int size;
        NodeChain nodeChain3;
        boolean z;
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if (this.focusInvalidationManager.isInvalidationScheduled) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                Trace.endSection();
                return false;
            }
            if (!m414validateKeyEventZmokQxo(keyEvent)) {
                Trace.endSection();
                return false;
            }
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
            if (focusTargetNodeFindActiveFocusNode != null) {
                if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
                }
                Modifier.Node node4 = focusTargetNodeFindActiveFocusNode.node;
                if ((node4.aggregateChildKindSet & 9216) != 0) {
                    node2 = null;
                    for (Modifier.Node node5 = node4.child; node5 != null; node5 = node5.child) {
                        int i = node5.kindSet;
                        if ((i & 9216) != 0) {
                            if ((i & 1024) != 0) {
                                break;
                            }
                            node2 = node5;
                        }
                    }
                } else {
                    node2 = null;
                }
                if (node2 == null) {
                    if (focusTargetNodeFindActiveFocusNode == null) {
                        if (!focusTargetNode.node.isAttached) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        node = focusTargetNode.node.parent;
                        layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                        loop15: while (true) {
                            if (layoutNodeRequireLayoutNode != null) {
                                obj = null;
                                break;
                            }
                            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                                while (node != null) {
                                    if ((node.kindSet & 8192) != 0) {
                                        nodePop = node;
                                        mutableVector = null;
                                        while (nodePop != null) {
                                            if (nodePop instanceof KeyInputModifierNode) {
                                                obj = nodePop;
                                                break loop15;
                                            }
                                            if ((nodePop.kindSet & 8192) == 0) {
                                            }
                                            nodePop = HitTestResultKt.pop(mutableVector);
                                        }
                                    }
                                    node = node.parent;
                                }
                            }
                            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                            if (layoutNodeRequireLayoutNode != null) {
                            }
                        }
                        obj2 = (KeyInputModifierNode) obj;
                        if (obj2 != null) {
                            node2 = ((Modifier.Node) obj2).node;
                        } else {
                            node2 = null;
                        }
                    } else {
                        if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        node3 = focusTargetNodeFindActiveFocusNode.node;
                        layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                        loop11: while (true) {
                            if (layoutNodeRequireLayoutNode2 != null) {
                                obj3 = null;
                                break;
                            }
                            if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 8192) != 0) {
                                while (node3 != null) {
                                    if ((node3.kindSet & 8192) != 0) {
                                        mutableVector2 = null;
                                        nodePop2 = node3;
                                        while (nodePop2 != null) {
                                            if (nodePop2 instanceof KeyInputModifierNode) {
                                                obj3 = nodePop2;
                                                break loop11;
                                            }
                                            if ((nodePop2.kindSet & 8192) == 0) {
                                            }
                                            nodePop2 = HitTestResultKt.pop(mutableVector2);
                                        }
                                    }
                                    node3 = node3.parent;
                                }
                            }
                            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                            if (layoutNodeRequireLayoutNode2 != null) {
                            }
                        }
                        obj4 = (KeyInputModifierNode) obj3;
                        if (obj4 != null) {
                            node2 = ((Modifier.Node) obj4).node;
                        } else {
                            if (!focusTargetNode.node.isAttached) {
                                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                            }
                            node = focusTargetNode.node.parent;
                            layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                            loop15: while (true) {
                                if (layoutNodeRequireLayoutNode != null) {
                                    obj = null;
                                    break;
                                }
                                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                                    while (node != null) {
                                        if ((node.kindSet & 8192) != 0) {
                                            nodePop = node;
                                            mutableVector = null;
                                            while (nodePop != null) {
                                                if (nodePop instanceof KeyInputModifierNode) {
                                                    obj = nodePop;
                                                    break loop15;
                                                }
                                                if ((nodePop.kindSet & 8192) == 0) {
                                                }
                                                nodePop = HitTestResultKt.pop(mutableVector);
                                            }
                                        }
                                        node = node.parent;
                                    }
                                }
                                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                                if (layoutNodeRequireLayoutNode != null) {
                                }
                            }
                            obj2 = (KeyInputModifierNode) obj;
                            if (obj2 != null) {
                                node2 = ((Modifier.Node) obj2).node;
                            } else {
                                node2 = null;
                            }
                        }
                    }
                }
            } else if (focusTargetNodeFindActiveFocusNode == null) {
                if (!focusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                node = focusTargetNode.node.parent;
                layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                loop15: while (true) {
                    if (layoutNodeRequireLayoutNode != null) {
                        obj = null;
                        break;
                    }
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 8192) != 0) {
                                nodePop = node;
                                mutableVector = null;
                                while (nodePop != null) {
                                    if (nodePop instanceof KeyInputModifierNode) {
                                        obj = nodePop;
                                        break loop15;
                                    }
                                    if ((nodePop.kindSet & 8192) == 0 && (nodePop instanceof DelegatingNode)) {
                                        Modifier.Node node6 = ((DelegatingNode) nodePop).delegate;
                                        int i2 = 0;
                                        while (node6 != null) {
                                            if ((node6.kindSet & 8192) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    nodePop = nodePop;
                                                    mutableVector = mutableVector;
                                                    mutableVector = mutableVector;
                                                    nodePop = node6;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodePop != null) {
                                                        mutableVector.add(nodePop);
                                                        nodePop = null;
                                                    }
                                                    mutableVector.add(node6);
                                                }
                                            } else {
                                                nodePop = nodePop;
                                                mutableVector = mutableVector;
                                            }
                                            node6 = node6.child;
                                            nodePop = nodePop;
                                            mutableVector = mutableVector;
                                        }
                                        if (i2 == 1) {
                                            nodePop = nodePop;
                                            mutableVector = mutableVector;
                                        } else {
                                            nodePop = nodePop;
                                            mutableVector = mutableVector;
                                        }
                                    }
                                    nodePop = HitTestResultKt.pop(mutableVector);
                                }
                            }
                            node = node.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    node = (layoutNodeRequireLayoutNode != null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
                obj2 = (KeyInputModifierNode) obj;
                if (obj2 != null) {
                    node2 = ((Modifier.Node) obj2).node;
                } else {
                    node2 = null;
                }
            } else {
                if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                node3 = focusTargetNodeFindActiveFocusNode.node;
                layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                loop11: while (true) {
                    if (layoutNodeRequireLayoutNode2 != null) {
                        obj3 = null;
                        break;
                    }
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 8192) != 0) {
                        while (node3 != null) {
                            if ((node3.kindSet & 8192) != 0) {
                                mutableVector2 = null;
                                nodePop2 = node3;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof KeyInputModifierNode) {
                                        obj3 = nodePop2;
                                        break loop11;
                                    }
                                    if ((nodePop2.kindSet & 8192) == 0 && (nodePop2 instanceof DelegatingNode)) {
                                        Modifier.Node node7 = ((DelegatingNode) nodePop2).delegate;
                                        int i3 = 0;
                                        while (node7 != null) {
                                            if ((node7.kindSet & 8192) != 0) {
                                                i3++;
                                                if (i3 == 1) {
                                                    nodePop2 = nodePop2;
                                                    mutableVector2 = mutableVector2;
                                                    mutableVector2 = mutableVector2;
                                                    nodePop2 = node7;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodePop2 != null) {
                                                        mutableVector2.add(nodePop2);
                                                        nodePop2 = null;
                                                    }
                                                    mutableVector2.add(node7);
                                                }
                                            } else {
                                                nodePop2 = nodePop2;
                                                mutableVector2 = mutableVector2;
                                            }
                                            node7 = node7.child;
                                            nodePop2 = nodePop2;
                                            mutableVector2 = mutableVector2;
                                        }
                                        if (i3 == 1) {
                                            nodePop2 = nodePop2;
                                            mutableVector2 = mutableVector2;
                                        } else {
                                            nodePop2 = nodePop2;
                                            mutableVector2 = mutableVector2;
                                        }
                                    }
                                    nodePop2 = HitTestResultKt.pop(mutableVector2);
                                }
                            }
                            node3 = node3.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                    node3 = (layoutNodeRequireLayoutNode2 != null || (nodeChain2 = layoutNodeRequireLayoutNode2.nodes) == null) ? null : (TailModifierNode) nodeChain2.tail;
                }
                obj4 = (KeyInputModifierNode) obj3;
                if (obj4 != null) {
                    node2 = ((Modifier.Node) obj4).node;
                } else {
                    if (!focusTargetNode.node.isAttached) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    node = focusTargetNode.node.parent;
                    layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                    loop15: while (true) {
                        if (layoutNodeRequireLayoutNode != null) {
                            obj = null;
                            break;
                        }
                        if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                            while (node != null) {
                                if ((node.kindSet & 8192) != 0) {
                                    nodePop = node;
                                    mutableVector = null;
                                    while (nodePop != null) {
                                        if (nodePop instanceof KeyInputModifierNode) {
                                            obj = nodePop;
                                            break loop15;
                                        }
                                        if ((nodePop.kindSet & 8192) == 0) {
                                        }
                                        nodePop = HitTestResultKt.pop(mutableVector);
                                    }
                                }
                                node = node.parent;
                            }
                        }
                        layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                        if (layoutNodeRequireLayoutNode != null) {
                        }
                    }
                    obj2 = (KeyInputModifierNode) obj;
                    if (obj2 != null) {
                        node2 = ((Modifier.Node) obj2).node;
                    } else {
                        node2 = null;
                    }
                }
            }
            if (node2 != null) {
                if (!node2.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node8 = node2.node.parent;
                LayoutNode layoutNodeRequireLayoutNode3 = HitTestResultKt.requireLayoutNode(node2);
                ArrayList arrayList = null;
                while (layoutNodeRequireLayoutNode3 != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode3.nodes.head).aggregateChildKindSet & 8192) != 0) {
                        while (node8 != null) {
                            if ((node8.kindSet & 8192) != 0) {
                                Modifier.Node nodePop3 = node8;
                                MutableVector mutableVector3 = null;
                                while (nodePop3 != null) {
                                    if (nodePop3 instanceof KeyInputModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(nodePop3);
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z && (nodePop3.kindSet & 8192) != 0 && (nodePop3 instanceof DelegatingNode)) {
                                        int i4 = 0;
                                        for (Modifier.Node node9 = ((DelegatingNode) nodePop3).delegate; node9 != null; node9 = node9.child) {
                                            if ((node9.kindSet & 8192) != 0) {
                                                i4++;
                                                if (i4 == 1) {
                                                    nodePop3 = node9;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodePop3 != null) {
                                                        mutableVector3.add(nodePop3);
                                                        nodePop3 = null;
                                                    }
                                                    mutableVector3.add(node9);
                                                }
                                            }
                                        }
                                        if (i4 == 1) {
                                        }
                                    }
                                    nodePop3 = HitTestResultKt.pop(mutableVector3);
                                }
                            }
                            node8 = node8.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode3 = layoutNodeRequireLayoutNode3.getParent$ui();
                    node8 = (layoutNodeRequireLayoutNode3 == null || (nodeChain3 = layoutNodeRequireLayoutNode3.nodes) == null) ? null : (TailModifierNode) nodeChain3.tail;
                }
                if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
                    while (true) {
                        int i5 = size - 1;
                        if (((KeyInputModifierNode) arrayList.get(size)).mo28onPreKeyEventZmokQxo(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                        if (i5 < 0) {
                            break;
                        }
                        size = i5;
                    }
                }
                ?? Pop = node2.node;
                ?? mutableVector4 = 0;
                while (Pop != 0) {
                    if (Pop instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) Pop).mo28onPreKeyEventZmokQxo(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    } else if ((Pop.kindSet & 8192) != 0 && (Pop instanceof DelegatingNode)) {
                        Modifier.Node node10 = ((DelegatingNode) Pop).delegate;
                        int i6 = 0;
                        while (node10 != null) {
                            if ((node10.kindSet & 8192) != 0) {
                                i6++;
                                if (i6 == 1) {
                                    mutableVector4 = mutableVector4;
                                    Pop = Pop;
                                    mutableVector4 = mutableVector4;
                                    Pop = node10;
                                } else {
                                    if (mutableVector4 == 0) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Pop != 0) {
                                        mutableVector4.add(Pop);
                                        Pop = 0;
                                    }
                                    mutableVector4.add(node10);
                                }
                            } else {
                                mutableVector4 = mutableVector4;
                                Pop = Pop;
                            }
                            node10 = node10.child;
                            mutableVector4 = mutableVector4;
                            Pop = Pop;
                        }
                        if (i6 == 1) {
                            mutableVector4 = mutableVector4;
                            Pop = Pop;
                        } else {
                            mutableVector4 = mutableVector4;
                            Pop = Pop;
                        }
                    }
                    Pop = HitTestResultKt.pop(mutableVector4);
                }
                if (((Boolean) function0.invoke()).booleanValue()) {
                    Trace.endSection();
                    return true;
                }
                ?? Pop2 = node2.node;
                ?? mutableVector5 = 0;
                while (Pop2 != 0) {
                    if (Pop2 instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) Pop2).mo26onKeyEventZmokQxo(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    } else if ((Pop2.kindSet & 8192) != 0 && (Pop2 instanceof DelegatingNode)) {
                        Modifier.Node node11 = ((DelegatingNode) Pop2).delegate;
                        int i7 = 0;
                        while (node11 != null) {
                            if ((node11.kindSet & 8192) != 0) {
                                i7++;
                                if (i7 == 1) {
                                    Pop2 = Pop2;
                                    mutableVector5 = mutableVector5;
                                    mutableVector5 = mutableVector5;
                                    Pop2 = node11;
                                } else {
                                    if (mutableVector5 == 0) {
                                        mutableVector5 = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Pop2 != 0) {
                                        mutableVector5.add(Pop2);
                                        Pop2 = 0;
                                    }
                                    mutableVector5.add(node11);
                                }
                            } else {
                                Pop2 = Pop2;
                                mutableVector5 = mutableVector5;
                            }
                            node11 = node11.child;
                            Pop2 = Pop2;
                            mutableVector5 = mutableVector5;
                        }
                        if (i7 == 1) {
                            Pop2 = Pop2;
                            mutableVector5 = mutableVector5;
                        } else {
                            Pop2 = Pop2;
                            mutableVector5 = mutableVector5;
                        }
                    }
                    Pop2 = HitTestResultKt.pop(mutableVector5);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        if (((KeyInputModifierNode) arrayList.get(i8)).mo26onKeyEventZmokQxo(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    }
                }
            }
            Trace.endSection();
            return false;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX INFO: renamed from: focusSearch-ULY8qGw, reason: not valid java name */
    public final Boolean m411focusSearchULY8qGw(int i, Rect rect, Function1 function1) {
        boolean zBackwardFocusSearch;
        FocusTargetNode focusTargetNode;
        NodeChain nodeChain;
        FocusTargetNode focusTargetNode2 = this.rootFocusNode;
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
        int i2 = 4;
        AndroidComposeView androidComposeView = this.owner;
        boolean zBooleanValue = false;
        if (focusTargetNodeFindActiveFocusNode != null) {
            LayoutDirection layoutDirection = androidComposeView.getLayoutDirection();
            FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNodeFindActiveFocusNode.fetchFocusProperties$ui();
            FocusRequester focusRequester = focusPropertiesImplFetchFocusProperties$ui.start;
            FocusRequester focusRequester2 = focusPropertiesImplFetchFocusProperties$ui.end;
            if (i == 1) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.next;
            } else if (i == 2) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.previous;
            } else if (i == 5) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.up;
            } else if (i == 6) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.down;
            } else if (i == 3) {
                int iOrdinal = layoutDirection.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    focusRequester = focusRequester2;
                }
                if (focusRequester == FocusRequester.Default) {
                    focusRequester = null;
                }
                if (focusRequester == null) {
                    focusRequester = focusPropertiesImplFetchFocusProperties$ui.left;
                }
            } else if (i == 4) {
                int iOrdinal2 = layoutDirection.ordinal();
                if (iOrdinal2 == 0) {
                    focusRequester = focusRequester2;
                } else if (iOrdinal2 != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                if (focusRequester == FocusRequester.Default) {
                    focusRequester = null;
                }
                if (focusRequester == null) {
                    focusRequester = focusPropertiesImplFetchFocusProperties$ui.right;
                }
            } else {
                if (i != 7 && i != 8) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("invalid FocusDirection");
                    return null;
                }
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i);
                FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNodeFindActiveFocusNode)).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                if (i == 7) {
                    focusPropertiesImplFetchFocusProperties$ui.onEnter.invoke(cancelIndicatingFocusBoundaryScope);
                } else {
                    focusPropertiesImplFetchFocusProperties$ui.onExit.invoke(cancelIndicatingFocusBoundaryScope);
                }
                focusRequester = cancelIndicatingFocusBoundaryScope.isCanceled ? FocusRequester.Cancel : activeFocusTargetNode != focusOwnerImpl.getActiveFocusTargetNode() ? FocusRequester.Redirect : FocusRequester.Default;
            }
            FocusRequester focusRequester3 = FocusRequester.Cancel;
            if (!Intrinsics.areEqual(focusRequester, focusRequester3)) {
                if (Intrinsics.areEqual(focusRequester, FocusRequester.Redirect)) {
                    FocusTargetNode focusTargetNodeFindActiveFocusNode2 = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
                    if (focusTargetNodeFindActiveFocusNode2 != null) {
                        return (Boolean) function1.invoke(focusTargetNodeFindActiveFocusNode2);
                    }
                } else {
                    FocusRequester focusRequester4 = FocusRequester.Default;
                    if (!Intrinsics.areEqual(focusRequester, focusRequester4)) {
                        if (focusRequester == focusRequester4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
                            return null;
                        }
                        if (focusRequester == focusRequester3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
                            return null;
                        }
                        MutableVector mutableVector = focusRequester.focusRequesterNodes;
                        int i3 = mutableVector.size;
                        if (i3 == 0) {
                            System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                        } else {
                            Object[] objArr = mutableVector.content;
                            boolean z = false;
                            for (int i4 = 0; i4 < i3; i4++) {
                                Object obj = (FocusRequesterModifierNode) objArr[i4];
                                if (!((Modifier.Node) obj).node.isAttached) {
                                    InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                Modifier.Node node = ((Modifier.Node) obj).node;
                                Modifier.Node node2 = node.child;
                                if (node2 == null) {
                                    HitTestResultKt.addLayoutNodeChildren(mutableVector2, node);
                                } else {
                                    mutableVector2.add(node2);
                                }
                                while (true) {
                                    int i5 = mutableVector2.size;
                                    if (i5 == 0) {
                                        break;
                                    }
                                    Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(i5 - 1);
                                    if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                                        HitTestResultKt.addLayoutNodeChildren(mutableVector2, nodePop);
                                    } else {
                                        while (nodePop != null) {
                                            if ((nodePop.kindSet & 1024) != 0) {
                                                MutableVector mutableVector3 = null;
                                                while (nodePop != null) {
                                                    if (nodePop instanceof FocusTargetNode) {
                                                        if (((Boolean) function1.invoke((FocusTargetNode) nodePop)).booleanValue()) {
                                                            z = true;
                                                            break;
                                                        }
                                                    } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                                        int i6 = 0;
                                                        for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                                            if ((node3.kindSet & 1024) != 0) {
                                                                i6++;
                                                                if (i6 == 1) {
                                                                    nodePop = node3;
                                                                } else {
                                                                    if (mutableVector3 == null) {
                                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                                    }
                                                                    if (nodePop != null) {
                                                                        mutableVector3.add(nodePop);
                                                                        nodePop = null;
                                                                    }
                                                                    mutableVector3.add(node3);
                                                                }
                                                            }
                                                        }
                                                        if (i6 == 1) {
                                                        }
                                                    }
                                                    nodePop = HitTestResultKt.pop(mutableVector3);
                                                }
                                                break;
                                            }
                                            nodePop = nodePop.child;
                                        }
                                    }
                                }
                            }
                            zBooleanValue = z;
                        }
                        return Boolean.valueOf(zBooleanValue);
                    }
                }
            }
            return null;
        }
        focusTargetNodeFindActiveFocusNode = null;
        LayoutDirection layoutDirection2 = androidComposeView.getLayoutDirection();
        UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((Object) focusTargetNodeFindActiveFocusNode, (Object) this, (Object) function1, (byte) 22);
        if (i == 1 || i == 2) {
            if (i == 1) {
                zBackwardFocusSearch = FocusTraversalKt.forwardFocusSearch(focusTargetNode2, utilsKt$$ExternalSyntheticLambda0);
            } else {
                if (i != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 1-D focus search");
                    return null;
                }
                zBackwardFocusSearch = FocusTraversalKt.backwardFocusSearch(focusTargetNode2, utilsKt$$ExternalSyntheticLambda0);
            }
            return Boolean.valueOf(zBackwardFocusSearch);
        }
        if (i == 3 || i == 4 || i == 5 || i == 6) {
            return FocusTraversalKt.m431twoDimensionalFocusSearchsMXa3k8(i, focusTargetNode2, rect, utilsKt$$ExternalSyntheticLambda0);
        }
        if (i == 7) {
            int iOrdinal3 = layoutDirection2.ordinal();
            if (iOrdinal3 != 0) {
                if (iOrdinal3 != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                i2 = 3;
            }
            FocusTargetNode focusTargetNodeFindActiveFocusNode3 = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
            if (focusTargetNodeFindActiveFocusNode3 != null) {
                return FocusTraversalKt.m431twoDimensionalFocusSearchsMXa3k8(i2, focusTargetNodeFindActiveFocusNode3, rect, utilsKt$$ExternalSyntheticLambda0);
            }
            return null;
        }
        if (i != 8) {
            throw new IllegalStateException("Focus search invoked with invalid FocusDirection ".concat(FocusDirection.m407toStringimpl(i)).toString());
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode4 = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
        if (focusTargetNodeFindActiveFocusNode4 == null) {
            focusTargetNode = null;
            break;
        }
        if (!focusTargetNodeFindActiveFocusNode4.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node4 = focusTargetNodeFindActiveFocusNode4.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode4);
        loop5: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                focusTargetNode = null;
                break;
            }
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                while (node4 != null) {
                    if ((node4.kindSet & 1024) != 0) {
                        Modifier.Node nodePop2 = node4;
                        MutableVector mutableVector4 = null;
                        while (nodePop2 != null) {
                            if (nodePop2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop2;
                                if (focusTargetNode3.fetchFocusProperties$ui().canFocus) {
                                    focusTargetNode = focusTargetNode3;
                                    break loop5;
                                }
                            } else if ((nodePop2.kindSet & 1024) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                int i7 = 0;
                                for (Modifier.Node node5 = ((DelegatingNode) nodePop2).delegate; node5 != null; node5 = node5.child) {
                                    if ((node5.kindSet & 1024) != 0) {
                                        i7++;
                                        if (i7 == 1) {
                                            nodePop2 = node5;
                                        } else {
                                            if (mutableVector4 == null) {
                                                mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodePop2 != null) {
                                                mutableVector4.add(nodePop2);
                                                nodePop2 = null;
                                            }
                                            mutableVector4.add(node5);
                                        }
                                    }
                                }
                                if (i7 != 1) {
                                    nodePop2 = HitTestResultKt.pop(mutableVector4);
                                }
                            }
                            nodePop2 = HitTestResultKt.pop(mutableVector4);
                        }
                    }
                    node4 = node4.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node4 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        if (focusTargetNode != null && focusTargetNode != focusTargetNode2) {
            zBooleanValue = ((Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(focusTargetNode)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public final FocusTargetNode getActiveFocusTargetNode() {
        FocusTargetNode focusTargetNode = this.activeFocusTargetNode;
        if (focusTargetNode == null || !focusTargetNode.isAttached) {
            return null;
        }
        return focusTargetNode;
    }

    /* JADX INFO: renamed from: moveFocus-aToIllA, reason: not valid java name */
    public final boolean m412moveFocusaToIllA(int i, boolean z) {
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        AndroidComposeView androidComposeView = this.platformFocusOwner;
        if (activeFocusTargetNode == null || !activeFocusTargetNode.isInteropViewHost || !androidComposeView.m688moveFocusInChildren3ESFkO8(i)) {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Boolean.FALSE;
            FocusTargetNode activeFocusTargetNode2 = getActiveFocusTargetNode();
            Boolean boolM411focusSearchULY8qGw = m411focusSearchULY8qGw(i, androidComposeView.getEmbeddedViewFocusRect(), new RawWebSocketCommonKt$$ExternalSyntheticLambda0((Object) ref$ObjectRef, i, (byte) 2));
            if (!Intrinsics.areEqual(boolM411focusSearchULY8qGw, Boolean.TRUE) || activeFocusTargetNode2 == getActiveFocusTargetNode()) {
                if (boolM411focusSearchULY8qGw != null && ref$ObjectRef.element != null) {
                    if (!boolM411focusSearchULY8qGw.booleanValue() || !((Boolean) ref$ObjectRef.element).booleanValue()) {
                        if ((i == 1 || i == 2) && z && m409clearFocusI7lrPNg(i, false, false)) {
                            Boolean boolM411focusSearchULY8qGw2 = m411focusSearchULY8qGw(i, null, new TimePickerKt$$ExternalSyntheticLambda36((byte) 4, i));
                            if (boolM411focusSearchULY8qGw2 != null ? boolM411focusSearchULY8qGw2.booleanValue() : false) {
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: resetFocus-3ESFkO8, reason: not valid java name */
    public final boolean m413resetFocus3ESFkO8(int i) {
        if (!m409clearFocusI7lrPNg(i, false, false)) {
            return false;
        }
        Boolean boolM411focusSearchULY8qGw = m411focusSearchULY8qGw(i, null, new TimePickerKt$$ExternalSyntheticLambda36((byte) 3, i));
        boolean zBooleanValue = boolM411focusSearchULY8qGw != null ? boolM411focusSearchULY8qGw.booleanValue() : false;
        if (!zBooleanValue) {
            clearOwnerFocus();
        }
        return zBooleanValue;
    }

    public final void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        MutableObjectList mutableObjectList = this.listeners;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r21v3, types: [int] */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m414validateKeyEventZmokQxo(KeyEvent keyEvent) {
        int iNumberOfTrailingZeros;
        boolean z;
        long j;
        int iNumberOfTrailingZeros2;
        long[] jArr;
        int i;
        long jM580getKeyZmokQxo = Key.m580getKeyZmokQxo(keyEvent);
        int iM581getTypeZmokQxo = Key.m581getTypeZmokQxo(keyEvent);
        int i2 = -862048943;
        long j2 = 0;
        char c = '\b';
        int i3 = 0;
        boolean z2 = true;
        if (iM581getTypeZmokQxo != 2) {
            if (iM581getTypeZmokQxo != 1) {
                return true;
            }
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null || !mutableLongSet.contains(jM580getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 != null) {
                int iHashCode = Long.hashCode(jM580getKeyZmokQxo) * (-862048943);
                int i4 = iHashCode ^ (iHashCode << 16);
                int i5 = i4 & 127;
                int i6 = mutableLongSet2._capacity;
                int i7 = i4 >>> 7;
                loop5: while (true) {
                    int i8 = i7 & i6;
                    long[] jArr2 = mutableLongSet2.metadata;
                    int i9 = i8 >> 3;
                    int i10 = (i8 & 7) << 3;
                    long j3 = ((jArr2[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr2[i9] >>> i10);
                    long j4 = (((long) i5) * 72340172838076673L) ^ j3;
                    for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                        iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i8) & i6;
                        if (mutableLongSet2.elements[iNumberOfTrailingZeros] == jM580getKeyZmokQxo) {
                            break loop5;
                        }
                    }
                    if ((j3 & ((~j3) << 6) & (-9187201950435737472L)) != 0) {
                        iNumberOfTrailingZeros = -1;
                        break;
                    }
                    i3 += 8;
                    i7 = i8 + i3;
                }
                if (iNumberOfTrailingZeros >= 0) {
                    mutableLongSet2._size--;
                    long[] jArr3 = mutableLongSet2.metadata;
                    int i11 = mutableLongSet2._capacity;
                    int i12 = iNumberOfTrailingZeros >> 3;
                    int i13 = (iNumberOfTrailingZeros & 7) << 3;
                    long j6 = (jArr3[i12] & (~(255 << i13))) | (254 << i13);
                    jArr3[i12] = j6;
                    jArr3[(((iNumberOfTrailingZeros - 7) & i11) + (i11 & 7)) >> 3] = j6;
                    return true;
                }
            }
            return true;
        }
        MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
        if (mutableLongSet3 == null) {
            mutableLongSet3 = new MutableLongSet(3);
            this.keysCurrentlyDown = mutableLongSet3;
        }
        MutableLongSet mutableLongSet4 = mutableLongSet3;
        int iHashCode2 = Long.hashCode(jM580getKeyZmokQxo) * (-862048943);
        int i14 = iHashCode2 ^ (iHashCode2 << 16);
        int i15 = i14 >>> 7;
        int i16 = i14 & 127;
        int i17 = mutableLongSet4._capacity;
        int i18 = i15 & i17;
        int i19 = 0;
        loop0: while (true) {
            long[] jArr4 = mutableLongSet4.metadata;
            int i20 = i18 >> 3;
            int i21 = (i18 & 7) << 3;
            long j7 = (jArr4[i20] >>> i21) | ((jArr4[i20 + 1] << (64 - i21)) & ((-i21) >> 63));
            int i22 = i2;
            long j8 = i16;
            long j9 = j7 ^ (j8 * 72340172838076673L);
            long j10 = (j9 - 72340172838076673L) & (~j9) & (-9187201950435737472L);
            while (j10 != j2) {
                iNumberOfTrailingZeros2 = (i18 + (Long.numberOfTrailingZeros(j10) >> 3)) & i17;
                long j11 = j2;
                if (mutableLongSet4.elements[iNumberOfTrailingZeros2] == jM580getKeyZmokQxo) {
                    z = true;
                    break loop0;
                }
                j10 &= j10 - 1;
                j2 = j11;
            }
            long j12 = j2;
            if ((j7 & ((~j7) << 6) & (-9187201950435737472L)) != j12) {
                int iFindFirstAvailableSlot = mutableLongSet4.findFirstAvailableSlot(i15);
                if (mutableLongSet4.growthLimit != 0 || ((mutableLongSet4.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) == 254) {
                    z = true;
                    j = 128;
                } else {
                    int i23 = mutableLongSet4._capacity;
                    if (i23 <= 8 || Long.compareUnsigned(((long) mutableLongSet4._size) * 32, ((long) i23) * 25) > 0) {
                        z = true;
                        j = 128;
                        int iNextCapacity = ScatterMapKt.nextCapacity(mutableLongSet4._capacity);
                        long[] jArr5 = mutableLongSet4.metadata;
                        long[] jArr6 = mutableLongSet4.elements;
                        int i24 = mutableLongSet4._capacity;
                        mutableLongSet4.initializeStorage(iNextCapacity);
                        long[] jArr7 = mutableLongSet4.metadata;
                        long[] jArr8 = mutableLongSet4.elements;
                        int i25 = mutableLongSet4._capacity;
                        int i26 = 0;
                        while (i26 < i24) {
                            if (((jArr5[i26 >> 3] >> ((i26 & 7) << 3)) & 255) < 128) {
                                long j13 = jArr6[i26];
                                int iHashCode3 = Long.hashCode(j13) * i22;
                                int i27 = iHashCode3 ^ (iHashCode3 << 16);
                                jArr = jArr7;
                                int iFindFirstAvailableSlot2 = mutableLongSet4.findFirstAvailableSlot(i27 >>> 7);
                                long j14 = i27 & 127;
                                int i28 = iFindFirstAvailableSlot2 >> 3;
                                int i29 = (iFindFirstAvailableSlot2 & 7) << 3;
                                long j15 = (jArr[i28] & (~(255 << i29))) | (j14 << i29);
                                jArr[i28] = j15;
                                jArr[(((iFindFirstAvailableSlot2 - 7) & i25) + (i25 & 7)) >> 3] = j15;
                                jArr8[iFindFirstAvailableSlot2] = j13;
                            } else {
                                jArr = jArr7;
                            }
                            i26++;
                            jArr7 = jArr;
                            jArr5 = jArr5;
                            jArr6 = jArr6;
                        }
                    } else {
                        long[] jArr9 = mutableLongSet4.metadata;
                        int i30 = mutableLongSet4._capacity;
                        long[] jArr10 = mutableLongSet4.elements;
                        int i31 = (i30 + 7) >> 3;
                        int i32 = 0;
                        while (i32 < i31) {
                            long j16 = jArr9[i32] & (-9187201950435737472L);
                            jArr9[i32] = ((~j16) + (j16 >>> 7)) & (-72340172838076674L);
                            i32++;
                            c = c;
                            i30 = i30;
                        }
                        char c2 = c;
                        int i33 = i30;
                        j = 128;
                        int lastIndex = ArraysKt.getLastIndex(jArr9);
                        int i34 = lastIndex - 1;
                        long j17 = 72057594037927935L;
                        jArr9[i34] = (jArr9[i34] & 72057594037927935L) | (-72057594037927936L);
                        jArr9[lastIndex] = jArr9[0];
                        int i35 = i33;
                        int i36 = 0;
                        while (i36 != i35) {
                            int i37 = i36 >> 3;
                            int i38 = (i36 & 7) << 3;
                            long j18 = (jArr9[i37] >> i38) & 255;
                            if (j18 != 128 && j18 == 254) {
                                int iHashCode4 = Long.hashCode(jArr10[i36]) * i22;
                                int i39 = iHashCode4 ^ (iHashCode4 << 16);
                                long j19 = j17;
                                int i40 = i39 >>> 7;
                                int iFindFirstAvailableSlot3 = mutableLongSet4.findFirstAvailableSlot(i40);
                                int i41 = i40 & i35;
                                char c3 = c2;
                                if (((iFindFirstAvailableSlot3 - i41) & i35) / 8 == ((i36 - i41) & i35) / 8) {
                                    jArr9[i37] = ((~(255 << i38)) & jArr9[i37]) | (((long) (i39 & 127)) << i38);
                                    jArr9[jArr9.length - 1] = (jArr9[0] & j19) | Long.MIN_VALUE;
                                    i36++;
                                } else {
                                    int i42 = iFindFirstAvailableSlot3 >> 3;
                                    long j20 = jArr9[i42];
                                    int i43 = (iFindFirstAvailableSlot3 & 7) << 3;
                                    if (((j20 >> i43) & 255) == 128) {
                                        int i44 = i36;
                                        jArr9[i42] = (j20 & (~(255 << i43))) | (((long) (i39 & 127)) << i43);
                                        jArr9[i37] = (jArr9[i37] & (~(255 << i38))) | (128 << i38);
                                        jArr10[iFindFirstAvailableSlot3] = jArr10[i44];
                                        jArr10[i44] = j12;
                                        i = i44;
                                    } else {
                                        int i45 = i36;
                                        jArr9[i42] = (j20 & (~(255 << i43))) | (((long) (i39 & 127)) << i43);
                                        long j21 = jArr10[iFindFirstAvailableSlot3];
                                        jArr10[iFindFirstAvailableSlot3] = jArr10[i45];
                                        jArr10[i45] = j21;
                                        i = i45 - 1;
                                    }
                                    jArr9[jArr9.length - 1] = (jArr9[0] & j19) | Long.MIN_VALUE;
                                    i36 = i + 1;
                                    i35 = i35;
                                }
                                j17 = j19;
                                c2 = c3;
                                z2 = z2;
                            } else {
                                i36++;
                            }
                        }
                        z = z2;
                        mutableLongSet4.growthLimit = ScatterMapKt.loadedCapacity(mutableLongSet4._capacity) - mutableLongSet4._size;
                    }
                    iFindFirstAvailableSlot = mutableLongSet4.findFirstAvailableSlot(i15);
                }
                iNumberOfTrailingZeros2 = iFindFirstAvailableSlot;
                mutableLongSet4._size++;
                int i46 = mutableLongSet4.growthLimit;
                long[] jArr11 = mutableLongSet4.metadata;
                int i47 = iNumberOfTrailingZeros2 >> 3;
                long j22 = jArr11[i47];
                int i48 = (iNumberOfTrailingZeros2 & 7) << 3;
                mutableLongSet4.growthLimit = i46 - (((j22 >> i48) & 255) == j ? z : 0);
                int i49 = mutableLongSet4._capacity;
                long j23 = (j22 & (~(255 << i48))) | (j8 << i48);
                jArr11[i47] = j23;
                jArr11[(((iNumberOfTrailingZeros2 - 7) & i49) + (i49 & 7)) >> 3] = j23;
                break;
            }
            i19 += 8;
            i18 = (i18 + i19) & i17;
            i2 = i22;
            j2 = j12;
        }
        mutableLongSet4.elements[iNumberOfTrailingZeros2] = jM580getKeyZmokQxo;
        return z;
    }
}
