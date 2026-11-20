package androidx.compose.ui.focus;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FocusTraversalKt {
    /* JADX WARN: Code duplicated, block: B:38:0x0076 A[RETURN] */
    public static final boolean backwardFocusSearch(FocusTargetNode focusTargetNode, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        int iOrdinal = focusTargetNode.getFocusState$1().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ActiveParent must have a focusedChild");
                    return false;
                }
                int iOrdinal2 = activeChild.getFocusState$1().ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        if (backwardFocusSearch(activeChild, utilsKt$$ExternalSyntheticLambda0) || m423generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 2, utilsKt$$ExternalSyntheticLambda0) || (activeChild.fetchFocusProperties$ui().canFocus && ((Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(activeChild)).booleanValue())) {
                            return true;
                        }
                        return false;
                    }
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return false;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ActiveParent must have a focusedChild");
                        return false;
                    }
                }
                return m423generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 2, utilsKt$$ExternalSyntheticLambda0);
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return false;
                }
                if (!pickChildForBackwardSearch(focusTargetNode, utilsKt$$ExternalSyntheticLambda0)) {
                    if (!(focusTargetNode.fetchFocusProperties$ui().canFocus ? ((Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(focusTargetNode)).booleanValue() : false)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return pickChildForBackwardSearch(focusTargetNode, utilsKt$$ExternalSyntheticLambda0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r11 >= r2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r10 <= r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r9 >= r6) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (r8 <= r5) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r21 != 3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        if (r21 != 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r21 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        r1 = r11 - r19.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r21 != 4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        r1 = r19.left - r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        if (r21 != 5) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        r1 = r9 - r19.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        if (r21 != 6) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
    
        r1 = r19.top - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        if (r1 >= com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
    
        r1 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        if (r21 != 3) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
    
        r11 = r11 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        if (r21 != 4) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r11 = r2 - r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
    
        if (r21 != 5) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
    
        r11 = r9 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:
    
        if (r21 != 6) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
    
        r11 = r6 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0087, code lost:
    
        if (r11 >= 1.0f) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
    
        r11 = 1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        if (r1 >= r11) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0090, code lost:
    
        okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
    
        okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
    
        return true;
     */
    /* JADX INFO: renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean m419beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        boolean zBeamBeats_I7lrPNg$inSourceBeam = beamBeats_I7lrPNg$inSourceBeam(i, rect3, rect);
        float f = rect3.top;
        float f2 = rect3.bottom;
        float f3 = rect3.left;
        float f4 = rect3.right;
        float f5 = rect.bottom;
        float f6 = rect.top;
        float f7 = rect.right;
        float f8 = rect.left;
        if (!zBeamBeats_I7lrPNg$inSourceBeam && beamBeats_I7lrPNg$inSourceBeam(i, rect2, rect)) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean beamBeats_I7lrPNg$inSourceBeam(int i, Rect rect, Rect rect2) {
        if (i == 3 || i == 4) {
            return rect.bottom > rect2.top && rect.top < rect2.bottom;
        }
        if (i == 5 || i == 6) {
            return rect.right > rect2.left && rect.left < rect2.right;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
        return false;
    }

    public static final void collectAccessibleChildren(FocusTargetNode focusTargetNode, MutableVector mutableVector) {
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.addLayoutNodeChildren(mutableVector2, node);
        } else {
            mutableVector2.add(node2);
        }
        while (true) {
            int i = mutableVector2.size;
            if (i == 0) {
                return;
            }
            Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(i - 1);
            if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.addLayoutNodeChildren(mutableVector2, nodePop);
            } else {
                while (nodePop != null) {
                    if ((nodePop.kindSet & 1024) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.isAttached && !HitTestResultKt.requireLayoutNode(focusTargetNode2).isDeactivated) {
                                    if (focusTargetNode2.fetchFocusProperties$ui().canFocus) {
                                        mutableVector.add(focusTargetNode2);
                                    } else {
                                        collectAccessibleChildren(focusTargetNode2, mutableVector);
                                    }
                                }
                            } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i2++;
                                        if (i2 == 1) {
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
                                if (i2 == 1) {
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

    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeFocusTargetNode = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode();
        if (activeFocusTargetNode == null || !activeFocusTargetNode.isAttached) {
            return null;
        }
        return activeFocusTargetNode;
    }

    /* JADX INFO: renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    public static final FocusTargetNode m420findBestCandidate4WY_MpI(MutableVector mutableVector, Rect rect, int i) {
        Rect rectTranslate;
        FocusTargetNode focusTargetNode = null;
        if (i == 3) {
            rectTranslate = rect.translate((rect.right - rect.left) + 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        } else if (i == 4) {
            rectTranslate = rect.translate(-((rect.right - rect.left) + 1.0f), CropImageView.DEFAULT_ASPECT_RATIO);
        } else if (i == 5) {
            rectTranslate = rect.translate(CropImageView.DEFAULT_ASPECT_RATIO, (rect.bottom - rect.top) + 1.0f);
        } else {
            if (i != 6) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
                return null;
            }
            rectTranslate = rect.translate(CropImageView.DEFAULT_ASPECT_RATIO, -((rect.bottom - rect.top) + 1.0f));
        }
        Object[] objArr = mutableVector.content;
        int i2 = mutableVector.size;
        for (int i3 = 0; i3 < i2; i3++) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[i3];
            if (isEligibleForFocusSearch(focusTargetNode2)) {
                Rect rectFocusRect = focusRect(focusTargetNode2);
                if (m424isBetterCandidateI7lrPNg(rectFocusRect, rectTranslate, rect, i)) {
                    focusTargetNode = focusTargetNode2;
                    rectTranslate = rectFocusRect;
                }
            }
        }
        return focusTargetNode;
    }

    /* JADX INFO: renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m421findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode focusTargetNode, int i, Function1 function1) {
        Rect rect;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16]);
        collectAccessibleChildren(focusTargetNode, mutableVector);
        int i2 = mutableVector.size;
        if (i2 <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (i2 == 0 ? null : mutableVector.content[0]);
            if (focusTargetNode2 != null) {
                return ((Boolean) function1.invoke(focusTargetNode2)).booleanValue();
            }
        } else {
            if (i == 7) {
                i = 4;
            }
            if (i == 4 || i == 6) {
                Rect rectFocusRect = focusRect(focusTargetNode);
                float f = rectFocusRect.left;
                float f2 = rectFocusRect.top;
                rect = new Rect(f, f2, f, f2);
            } else {
                if (i != 3 && i != 5) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
                    return false;
                }
                Rect rectFocusRect2 = focusRect(focusTargetNode);
                float f3 = rectFocusRect2.right;
                float f4 = rectFocusRect2.bottom;
                rect = new Rect(f3, f4, f3, f4);
            }
            FocusTargetNode focusTargetNodeM420findBestCandidate4WY_MpI = m420findBestCandidate4WY_MpI(mutableVector, rect, i);
            if (focusTargetNodeM420findBestCandidate4WY_MpI != null) {
                return ((Boolean) function1.invoke(focusTargetNodeM420findBestCandidate4WY_MpI)).booleanValue();
            }
        }
        return false;
    }

    public static final Modifier focusProperties(Modifier modifier, Function1 function1) {
        return modifier.then(new FocusPropertiesElement(new FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(function1)));
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        NodeCoordinator nodeCoordinator;
        if (focusTargetNode.isAttached && (nodeCoordinator = focusTargetNode.coordinator) != null) {
            LayoutCoordinates layoutCoordinatesFindRootCoordinates = RulerKt.findRootCoordinates(nodeCoordinator);
            if (!layoutCoordinatesFindRootCoordinates.isAttached$1()) {
                layoutCoordinatesFindRootCoordinates = null;
            }
            if (layoutCoordinatesFindRootCoordinates != null) {
                return focusTargetNode.fetchFocusRect$ui(layoutCoordinatesFindRootCoordinates);
            }
        }
        return Rect.Zero;
    }

    public static final Modifier focusRequester(Modifier modifier, FocusRequester focusRequester) {
        return modifier.then(new FocusRequesterElement(focusRequester));
    }

    public static final boolean forwardFocusSearch(FocusTargetNode focusTargetNode, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        int iOrdinal = focusTargetNode.getFocusState$1().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild != null) {
                    return forwardFocusSearch(activeChild, utilsKt$$ExternalSyntheticLambda0) || m423generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 1, utilsKt$$ExternalSyntheticLambda0);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ActiveParent must have a focusedChild");
                return false;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return focusTargetNode.fetchFocusProperties$ui().canFocus ? ((Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(focusTargetNode)).booleanValue() : pickChildForForwardSearch(focusTargetNode, utilsKt$$ExternalSyntheticLambda0);
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return false;
            }
        }
        return pickChildForForwardSearch(focusTargetNode, utilsKt$$ExternalSyntheticLambda0);
    }

    /* JADX INFO: renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m423generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i, final UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        if (m430searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i, utilsKt$$ExternalSyntheticLambda0)) {
            return true;
        }
        final FocusTargetNode activeFocusTargetNode = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode();
        Boolean bool = (Boolean) m428searchBeyondBoundsOMvw8(focusTargetNode, i, new Function1() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                BeyondBoundsLayout$BeyondBoundsScope beyondBoundsLayout$BeyondBoundsScope = (BeyondBoundsLayout$BeyondBoundsScope) obj;
                FocusTargetNode focusTargetNode3 = focusTargetNode;
                if (activeFocusTargetNode != ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode3)).getFocusOwner()).getActiveFocusTargetNode()) {
                    return Boolean.TRUE;
                }
                boolean zM430searchChildren4C6V_qg = FocusTraversalKt.m430searchChildren4C6V_qg(focusTargetNode3, focusTargetNode2, i, utilsKt$$ExternalSyntheticLambda0);
                Boolean boolValueOf = Boolean.valueOf(zM430searchChildren4C6V_qg);
                if (zM430searchChildren4C6V_qg || !beyondBoundsLayout$BeyondBoundsScope.getHasMoreContent()) {
                    return boolValueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final FocusTargetNode getActiveChild(FocusTargetNode focusTargetNode) {
        boolean z = focusTargetNode.node.isAttached;
        if (z) {
            if (!z) {
                InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node = focusTargetNode.node;
            Modifier.Node node2 = node.child;
            if (node2 == null) {
                HitTestResultKt.addLayoutNodeChildren(mutableVector, node);
            } else {
                mutableVector.add(node2);
            }
            while (true) {
                int i = mutableVector.size;
                if (i == 0) {
                    break;
                }
                Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(i - 1);
                if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                    HitTestResultKt.addLayoutNodeChildren(mutableVector, nodePop);
                } else {
                    while (nodePop != null) {
                        if ((nodePop.kindSet & 1024) != 0) {
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                    if (focusTargetNode2.node.isAttached) {
                                        int iOrdinal = focusTargetNode2.getFocusState$1().ordinal();
                                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
                                            return focusTargetNode2;
                                        }
                                        if (iOrdinal != 3) {
                                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                                            return null;
                                        }
                                    }
                                } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                        if ((node3.kindSet & 1024) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = node3;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector2.add(node3);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = HitTestResultKt.pop(mutableVector2);
                            }
                            break;
                        }
                        nodePop = nodePop.child;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    public static final boolean m424isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(i, rect, rect3)) {
            return false;
        }
        if (isBetterCandidate_I7lrPNg$isCandidate(i, rect2, rect3) && !m419beamBeatsI7lrPNg(rect3, rect, rect2, i)) {
            return !m419beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2);
        }
        return true;
    }

    public static final boolean isBetterCandidate_I7lrPNg$isCandidate(int i, Rect rect, Rect rect2) {
        if (i == 3) {
            float f = rect2.right;
            float f2 = rect2.left;
            float f3 = rect.right;
            return (f > f3 || f2 >= f3) && f2 > rect.left;
        }
        if (i == 4) {
            float f4 = rect2.left;
            float f5 = rect2.right;
            float f6 = rect.left;
            return (f4 < f6 || f5 <= f6) && f5 < rect.right;
        }
        if (i == 5) {
            float f7 = rect2.bottom;
            float f8 = rect2.top;
            float f9 = rect.bottom;
            return (f7 > f9 || f8 >= f9) && f8 > rect.top;
        }
        if (i != 6) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
            return false;
        }
        float f10 = rect2.top;
        float f11 = rect2.bottom;
        float f12 = rect.top;
        return (f10 < f12 || f11 <= f12) && f11 < rect.bottom;
    }

    public static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        if (i == 3) {
            f = rect.left;
            f2 = rect2.right;
        } else if (i == 4) {
            f = rect2.left;
            f2 = rect.right;
        } else if (i == 5) {
            f = rect.top;
            f2 = rect2.bottom;
        } else {
            if (i != 6) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
                return 0L;
            }
            f = rect2.top;
            f2 = rect.bottom;
        }
        float f6 = f - f2;
        if (f6 < CropImageView.DEFAULT_ASPECT_RATIO) {
            f6 = 0.0f;
        }
        long j = (long) f6;
        if (i == 3 || i == 4) {
            float f7 = rect.top;
            f3 = ((rect.bottom - f7) / 2.0f) + f7;
            f4 = rect2.top;
            f5 = rect2.bottom;
        } else {
            if (i != 5 && i != 6) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 2-D focus search");
                return 0L;
            }
            float f8 = rect.left;
            f3 = ((rect.right - f8) / 2.0f) + f8;
            f4 = rect2.left;
            f5 = rect2.right;
        }
        long j2 = (long) (f3 - (((f5 - f4) / 2.0f) + f4));
        return (j2 * j2) + (13 * j * j);
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator nodeCoordinator;
        LayoutNode layoutNode2;
        NodeCoordinator nodeCoordinator2 = focusTargetNode.coordinator;
        return (nodeCoordinator2 == null || (layoutNode = nodeCoordinator2.layoutNode) == null || !layoutNode.isPlaced() || (nodeCoordinator = focusTargetNode.coordinator) == null || (layoutNode2 = nodeCoordinator.layoutNode) == null || !layoutNode2.isAttached$1()) ? false : true;
    }

    public static final Modifier onFocusChanged(Modifier modifier, Function1 function1) {
        return modifier.then(new FocusChangedElement(function1));
    }

    /* JADX INFO: renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m425performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        int iOrdinal = focusTargetNode.getFocusState$1().ordinal();
        CustomDestinationResult customDestinationResult = CustomDestinationResult.None;
        if (iOrdinal != 0) {
            CustomDestinationResult customDestinationResult2 = CustomDestinationResult.Cancelled;
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("ActiveParent with no focused child");
                    return null;
                }
                CustomDestinationResult customDestinationResultM425performCustomClearFocusMxy_nc0 = m425performCustomClearFocusMxy_nc0(activeChild, i);
                CustomDestinationResult customDestinationResult3 = customDestinationResultM425performCustomClearFocusMxy_nc0 != customDestinationResult ? customDestinationResultM425performCustomClearFocusMxy_nc0 : null;
                if (customDestinationResult3 != null) {
                    return customDestinationResult3;
                }
                if (focusTargetNode.isProcessingCustomExit) {
                    return customDestinationResult;
                }
                focusTargetNode.isProcessingCustomExit = true;
                try {
                    FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                    CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i);
                    FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner();
                    FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                    focusPropertiesImplFetchFocusProperties$ui.onExit.invoke(cancelIndicatingFocusBoundaryScope);
                    FocusTargetNode activeFocusTargetNode2 = focusOwnerImpl.getActiveFocusTargetNode();
                    if (cancelIndicatingFocusBoundaryScope.isCanceled) {
                        FocusRequester focusRequester = FocusRequester.Default;
                        return customDestinationResult2;
                    }
                    if (activeFocusTargetNode == activeFocusTargetNode2 || activeFocusTargetNode2 == null) {
                        return customDestinationResult;
                    }
                    return FocusRequester.Redirect == FocusRequester.Cancel ? customDestinationResult2 : CustomDestinationResult.Redirected;
                } finally {
                    focusTargetNode.isProcessingCustomExit = false;
                }
            }
            if (iOrdinal == 2) {
                return customDestinationResult2;
            }
            if (iOrdinal != 3) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
        }
        return customDestinationResult;
    }

    /* JADX INFO: renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m426performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i);
                FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                focusPropertiesImplFetchFocusProperties$ui.onEnter.invoke(cancelIndicatingFocusBoundaryScope);
                FocusTargetNode activeFocusTargetNode2 = focusOwnerImpl.getActiveFocusTargetNode();
                boolean z = cancelIndicatingFocusBoundaryScope.isCanceled;
                CustomDestinationResult customDestinationResult = CustomDestinationResult.Cancelled;
                if (z) {
                    FocusRequester focusRequester = FocusRequester.Default;
                    return customDestinationResult;
                }
                if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                    return FocusRequester.Redirect == FocusRequester.Cancel ? customDestinationResult : CustomDestinationResult.Redirected;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* JADX INFO: renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m427performCustomRequestFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        Modifier.Node nodePop;
        NodeChain nodeChain;
        int iOrdinal = focusTargetNode.getFocusState$1().ordinal();
        CustomDestinationResult customDestinationResult = CustomDestinationResult.None;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild != null) {
                    return m425performCustomClearFocusMxy_nc0(activeChild, i);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("ActiveParent with no focused child");
                return null;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                if (!focusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node = focusTargetNode.node.parent;
                LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                loop0: while (true) {
                    if (layoutNodeRequireLayoutNode == null) {
                        nodePop = null;
                        break;
                    }
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 1024) != 0) {
                                nodePop = node;
                                MutableVector mutableVector = null;
                                while (nodePop != null) {
                                    if (nodePop instanceof FocusTargetNode) {
                                        break loop0;
                                    }
                                    if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                            if ((node2.kindSet & 1024) != 0) {
                                                i2++;
                                                if (i2 == 1) {
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
                                        if (i2 == 1) {
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
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                if (focusTargetNode2 == null) {
                    return customDestinationResult;
                }
                int iOrdinal2 = focusTargetNode2.getFocusState$1().ordinal();
                if (iOrdinal2 == 0) {
                    return m426performCustomEnterMxy_nc0(focusTargetNode2, i);
                }
                if (iOrdinal2 == 1) {
                    return m427performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
                }
                if (iOrdinal2 == 2) {
                    return CustomDestinationResult.Cancelled;
                }
                if (iOrdinal2 != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                CustomDestinationResult customDestinationResultM427performCustomRequestFocusMxy_nc0 = m427performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
                CustomDestinationResult customDestinationResult2 = customDestinationResultM427performCustomRequestFocusMxy_nc0 != customDestinationResult ? customDestinationResultM427performCustomRequestFocusMxy_nc0 : null;
                return customDestinationResult2 == null ? m426performCustomEnterMxy_nc0(focusTargetNode2, i) : customDestinationResult2;
            }
        }
        return customDestinationResult;
    }

    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        MutableVector mutableVector;
        NodeChain nodeChain;
        boolean z;
        NodeChain nodeChain2;
        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
        FocusStateImpl focusState$1 = focusTargetNode.getFocusState$1();
        if (activeFocusTargetNode == focusTargetNode) {
            focusTargetNode.dispatchFocusCallbacks$ui(focusState$1, focusState$1);
            return true;
        }
        if ((activeFocusTargetNode == null || activeFocusTargetNode.isInteropViewHost) && !focusTargetNode.isInteropViewHost && !((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).platformFocusOwner.m689requestOwnerFocus7o62pno()) {
            return false;
        }
        if (activeFocusTargetNode != null) {
            mutableVector = new MutableVector(new FocusTargetNode[16]);
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
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) nodePop);
                                } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                        if ((node2.kindSet & 1024) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = node2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector2.add(node2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = HitTestResultKt.pop(mutableVector2);
                            }
                        }
                        node = node.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodeChain2 = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain2.tail;
            }
        } else {
            mutableVector = null;
        }
        Object[] objArr = new FocusTargetNode[16];
        Object[] objArr2 = new FocusTargetNode[16];
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node3 = focusTargetNode.node.parent;
        LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNode);
        boolean z2 = true;
        int i2 = 0;
        int i3 = 0;
        while (layoutNodeRequireLayoutNode2 != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 1024) != 0) {
                while (node3 != null) {
                    if ((node3.kindSet & 1024) != 0) {
                        Modifier.Node nodePop2 = node3;
                        MutableVector mutableVector3 = null;
                        while (nodePop2 != null) {
                            if (nodePop2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop2;
                                if (Intrinsics.areEqual(mutableVector != null ? Boolean.valueOf(mutableVector.remove(focusTargetNode2)) : null, Boolean.TRUE)) {
                                    int i4 = i2 + 1;
                                    if (objArr.length < i4) {
                                        int length = objArr.length;
                                        Object[] objArr3 = new Object[Math.max(i4, length * 2)];
                                        System.arraycopy(objArr, 0, objArr3, 0, length);
                                        objArr = objArr3;
                                    }
                                    objArr[i2] = focusTargetNode2;
                                    i2 = i4;
                                } else {
                                    focusOwnerImpl = focusOwnerImpl;
                                    int i5 = i3 + 1;
                                    if (objArr2.length < i5) {
                                        int length2 = objArr2.length;
                                        Object[] objArr4 = new Object[Math.max(i5, length2 * 2)];
                                        System.arraycopy(objArr2, 0, objArr4, 0, length2);
                                        objArr2 = objArr4;
                                    }
                                    objArr2[i3] = focusTargetNode2;
                                    i3 = i5;
                                }
                                if (focusTargetNode2 == activeFocusTargetNode) {
                                    z2 = false;
                                }
                                z = false;
                            } else {
                                focusOwnerImpl = focusOwnerImpl;
                                z = true;
                            }
                            if (z && (nodePop2.kindSet & 1024) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node node4 = ((DelegatingNode) nodePop2).delegate; node4 != null; node4 = node4.child) {
                                    if ((node4.kindSet & 1024) != 0) {
                                        int i7 = i6 + 1;
                                        if (i7 == 1) {
                                            nodePop2 = node4;
                                            i7 = i7;
                                        } else {
                                            MutableVector mutableVector4 = mutableVector3 == null ? new MutableVector(new Modifier.Node[16]) : mutableVector3;
                                            if (nodePop2 != null) {
                                                mutableVector4.add(nodePop2);
                                                nodePop2 = null;
                                            }
                                            mutableVector4.add(node4);
                                            mutableVector3 = mutableVector4;
                                        }
                                        i6 = i7;
                                    }
                                }
                                if (i6 != 1) {
                                    nodePop2 = HitTestResultKt.pop(mutableVector3);
                                }
                            } else {
                                nodePop2 = HitTestResultKt.pop(mutableVector3);
                            }
                        }
                    }
                    node3 = node3.parent;
                    focusOwnerImpl = focusOwnerImpl;
                }
            }
            FocusOwnerImpl focusOwnerImpl2 = focusOwnerImpl;
            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
            node3 = (layoutNodeRequireLayoutNode2 == null || (nodeChain = layoutNodeRequireLayoutNode2.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
            focusOwnerImpl = focusOwnerImpl2;
        }
        FocusOwnerImpl focusOwnerImpl3 = focusOwnerImpl;
        if (z2 && activeFocusTargetNode != null && !prepareToClearFocus(activeFocusTargetNode, false)) {
            return false;
        }
        HitTestResultKt.observeReads(focusTargetNode, new RoomDatabase$$ExternalSyntheticLambda0((byte) 6, focusTargetNode));
        int iOrdinal = focusTargetNode.getFocusState$1().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).setActiveFocusTargetNode(focusTargetNode);
            } else if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return false;
                }
                ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).setActiveFocusTargetNode(focusTargetNode);
            }
        }
        FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;
        FocusStateImpl focusStateImpl2 = FocusStateImpl.Active;
        if (z2 && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(focusStateImpl2, focusStateImpl);
        }
        FocusStateImpl focusStateImpl3 = FocusStateImpl.ActiveParent;
        if (mutableVector != null) {
            int i8 = mutableVector.size - 1;
            Object[] objArr5 = mutableVector.content;
            if (i8 < objArr5.length) {
                while (i8 >= 0) {
                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr5[i8];
                    if (focusOwnerImpl3.getActiveFocusTargetNode() != focusTargetNode) {
                        return false;
                    }
                    focusTargetNode3.dispatchFocusCallbacks$ui(focusStateImpl3, focusStateImpl);
                    i8--;
                }
            }
        }
        int i9 = i3 - 1;
        if (i9 < objArr2.length) {
            while (i9 >= 0) {
                FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr2[i9];
                if (focusOwnerImpl3.getActiveFocusTargetNode() != focusTargetNode) {
                    return false;
                }
                focusTargetNode4.dispatchFocusCallbacks$ui(focusTargetNode4 == activeFocusTargetNode ? focusStateImpl2 : focusStateImpl, focusStateImpl3);
                i9--;
            }
        }
        if (focusOwnerImpl3.getActiveFocusTargetNode() != focusTargetNode) {
            return false;
        }
        focusTargetNode.dispatchFocusCallbacks$ui(focusState$1, focusStateImpl2);
        return focusOwnerImpl3.getActiveFocusTargetNode() == focusTargetNode;
    }

    public static final boolean pickChildForBackwardSearch(FocusTargetNode focusTargetNode, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        Object[] objArr = new FocusTargetNode[16];
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.addLayoutNodeChildren(mutableVector, node);
        } else {
            mutableVector.add(node2);
        }
        int i = 0;
        while (true) {
            int i2 = mutableVector.size;
            if (i2 == 0) {
                break;
            }
            Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(i2 - 1);
            if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (nodePop != null) {
                    if ((nodePop.kindSet & 1024) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                int i3 = i + 1;
                                if (objArr.length < i3) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i] = focusTargetNode2;
                                i = i3;
                            } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodePop = node3;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(node3);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodePop = HitTestResultKt.pop(mutableVector2);
                        }
                        break;
                    }
                    nodePop = nodePop.child;
                }
            }
        }
        Arrays.sort(objArr, 0, i, FocusableChildrenComparator.INSTANCE);
        int i5 = i - 1;
        if (i5 < objArr.length) {
            while (i5 >= 0) {
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[i5];
                if (isEligibleForFocusSearch(focusTargetNode3) && backwardFocusSearch(focusTargetNode3, utilsKt$$ExternalSyntheticLambda0)) {
                    return true;
                }
                i5--;
            }
        }
        return false;
    }

    public static final boolean pickChildForForwardSearch(FocusTargetNode focusTargetNode, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        Object[] objArr = new FocusTargetNode[16];
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.addLayoutNodeChildren(mutableVector, node);
        } else {
            mutableVector.add(node2);
        }
        int i = 0;
        while (true) {
            int i2 = mutableVector.size;
            if (i2 == 0) {
                break;
            }
            Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(i2 - 1);
            if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (nodePop != null) {
                    if ((nodePop.kindSet & 1024) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                int i3 = i + 1;
                                if (objArr.length < i3) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i] = focusTargetNode2;
                                i = i3;
                            } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodePop = node3;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(node3);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodePop = HitTestResultKt.pop(mutableVector2);
                        }
                        break;
                    }
                    nodePop = nodePop.child;
                }
            }
        }
        Arrays.sort(objArr, 0, i, FocusableChildrenComparator.INSTANCE);
        for (int i5 = 0; i5 < i; i5++) {
            FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[i5];
            if (isEligibleForFocusSearch(focusTargetNode3) && forwardFocusSearch(focusTargetNode3, utilsKt$$ExternalSyntheticLambda0)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean prepareToClearFocus(FocusTargetNode focusTargetNode, boolean z) {
        int iOrdinal = focusTargetNode.getFocusState$1().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (!(activeChild != null ? prepareToClearFocus(activeChild, z) : true)) {
                    return false;
                }
                focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                return true;
            }
            if (iOrdinal == 2) {
                return z;
            }
            if (iOrdinal != 3) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00a6 A[PHI: r0
      0x00a6: PHI (r0v11 int) = (r0v5 int), (r0v6 int), (r0v7 int), (r0v8 int) binds: [B:54:0x00a4, B:57:0x00a9, B:60:0x00ad, B:63:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final Object m428searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, Function1 function1) {
        int i2;
        final int i3;
        Object objInvoke;
        Modifier.Node nodePop;
        final LazyLayoutBeyondBoundsProviderModifierNode beyondBoundsLayoutParent;
        NodeChain nodeChain;
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = focusTargetNode.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            i2 = 0;
            i3 = 1;
            objInvoke = null;
            if (layoutNodeRequireLayoutNode == null) {
                nodePop = null;
                break;
            }
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                while (node != null) {
                    if ((node.kindSet & 1024) != 0) {
                        nodePop = node;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                    if ((node2.kindSet & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
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
                                if (i4 == 1) {
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
        if ((focusTargetNode2 == null || !Intrinsics.areEqual(focusTargetNode2.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) && (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) != null) {
            int i5 = 5;
            if (i == 5) {
                i3 = i5;
            } else {
                i5 = 6;
                if (i == 6) {
                    i3 = i5;
                } else {
                    i5 = 3;
                    if (i == 3) {
                        i3 = i5;
                    } else {
                        i5 = 4;
                        if (i == 4) {
                            i3 = i5;
                        } else if (i == 1) {
                            i3 = 2;
                        } else if (i != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unsupported direction for beyond bounds layout");
                        }
                    }
                }
            }
            if (beyondBoundsLayoutParent.state.getItemCount() <= 0 || !beyondBoundsLayoutParent.state.getHasVisibleItems() || !beyondBoundsLayoutParent.isAttached) {
                return function1.invoke(LazyLayoutBeyondBoundsProviderModifierNode.emptyBeyondBoundsScope);
            }
            boolean zM171isForward4vf7U8o = beyondBoundsLayoutParent.m171isForward4vf7U8o(i3);
            LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState = beyondBoundsLayoutParent.state;
            int lastPlacedIndex = zM171isForward4vf7U8o ? lazyLayoutBeyondBoundsState.getLastPlacedIndex() : lazyLayoutBeyondBoundsState.getFirstPlacedIndex();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = beyondBoundsLayoutParent.beyondBoundsInfo;
            lazyLayoutBeyondBoundsInfo.getClass();
            LazyLayoutBeyondBoundsInfo.Interval interval = new LazyLayoutBeyondBoundsInfo.Interval(lastPlacedIndex, lastPlacedIndex);
            lazyLayoutBeyondBoundsInfo.beyondBoundsItems.add(interval);
            ref$ObjectRef.element = interval;
            int iItemsPerViewport = beyondBoundsLayoutParent.state.itemsPerViewport() * 2;
            int itemCount = beyondBoundsLayoutParent.state.getItemCount();
            if (iItemsPerViewport > itemCount) {
                iItemsPerViewport = itemCount;
            }
            while (objInvoke == null && beyondBoundsLayoutParent.m170hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, i3) && i2 < iItemsPerViewport) {
                LazyLayoutBeyondBoundsInfo.Interval interval2 = (LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element;
                int i6 = interval2.start;
                int i7 = interval2.end;
                if (beyondBoundsLayoutParent.m171isForward4vf7U8o(i3)) {
                    i7++;
                } else {
                    i6--;
                }
                LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo2 = beyondBoundsLayoutParent.beyondBoundsInfo;
                lazyLayoutBeyondBoundsInfo2.getClass();
                LazyLayoutBeyondBoundsInfo.Interval interval3 = new LazyLayoutBeyondBoundsInfo.Interval(i6, i7);
                lazyLayoutBeyondBoundsInfo2.beyondBoundsItems.add(interval3);
                beyondBoundsLayoutParent.beyondBoundsInfo.beyondBoundsItems.remove((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element);
                ref$ObjectRef.element = interval3;
                i2++;
                HitTestResultKt.requireLayoutNode(beyondBoundsLayoutParent).forceRemeasure();
                objInvoke = function1.invoke(new BeyondBoundsLayout$BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode$layout$2
                    @Override // androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope
                    public final boolean getHasMoreContent() {
                        return beyondBoundsLayoutParent.m170hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, i3);
                    }
                });
            }
            beyondBoundsLayoutParent.beyondBoundsInfo.beyondBoundsItems.remove((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element);
            HitTestResultKt.requireLayoutNode(beyondBoundsLayoutParent).forceRemeasure();
            return objInvoke;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014e  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:158:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0120  */
    /* JADX WARN: Code duplicated, block: B:90:0x0130  */
    /* JADX WARN: Code duplicated, block: B:92:0x013c A[ADDED_TO_REGION, LOOP:6: B:92:0x013c->B:120:0x0189, LOOP_START, PHI: r13
      0x013c: PHI (r13v13 androidx.compose.ui.Modifier$Node) = (r13v7 androidx.compose.ui.Modifier$Node), (r13v14 androidx.compose.ui.Modifier$Node) binds: [B:91:0x013a, B:120:0x0189] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x013e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0144  */
    /* JADX WARN: Code duplicated, block: B:97:0x0148  */
    /* JADX INFO: renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m430searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        Modifier.Node node;
        Modifier.Node node2;
        LayoutNode layoutNodeRequireLayoutNode;
        NodeChain nodeChain;
        Modifier.Node nodePop;
        MutableVector mutableVector;
        if (focusTargetNode.getFocusState$1() != FocusStateImpl.ActiveParent) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used within a parent that has focus.");
            return false;
        }
        Object[] objArr = new FocusTargetNode[16];
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node3 = focusTargetNode.node;
        Modifier.Node node4 = node3.child;
        if (node4 == null) {
            HitTestResultKt.addLayoutNodeChildren(mutableVector2, node3);
        } else {
            mutableVector2.add(node4);
        }
        int i2 = 0;
        while (true) {
            int i3 = mutableVector2.size;
            node = null;
            if (i3 == 0) {
                break;
            }
            Modifier.Node nodePop2 = (Modifier.Node) mutableVector2.removeAt(i3 - 1);
            if ((nodePop2.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.addLayoutNodeChildren(mutableVector2, nodePop2);
            } else {
                while (nodePop2 != null) {
                    if ((nodePop2.kindSet & 1024) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop2 != null) {
                            if (nodePop2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop2;
                                int i4 = i2 + 1;
                                if (objArr.length < i4) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i4, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i2] = focusTargetNode3;
                                i2 = i4;
                            } else if ((nodePop2.kindSet & 1024) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node node5 = ((DelegatingNode) nodePop2).delegate; node5 != null; node5 = node5.child) {
                                    if ((node5.kindSet & 1024) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            nodePop2 = node5;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodePop2 != null) {
                                                mutableVector3.add(nodePop2);
                                                nodePop2 = null;
                                            }
                                            mutableVector3.add(node5);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            nodePop2 = HitTestResultKt.pop(mutableVector3);
                        }
                        break;
                    }
                    nodePop2 = nodePop2.child;
                }
            }
        }
        Arrays.sort(objArr, 0, i2, FocusableChildrenComparator.INSTANCE);
        if (i != 1) {
            if (i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This function should only be used for 1-D focus search");
                return false;
            }
            IntRange intRangeUntil = UuidKt.until(0, i2);
            int i6 = intRangeUntil.first;
            int i7 = intRangeUntil.last;
            if (i6 <= i7) {
                boolean z = false;
                while (true) {
                    if (z) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr[i7];
                        if (isEligibleForFocusSearch(focusTargetNode4) && backwardFocusSearch(focusTargetNode4, utilsKt$$ExternalSyntheticLambda0)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(objArr[i7], focusTargetNode2)) {
                        z = true;
                    }
                    if (i7 == i6) {
                        break;
                    }
                    i7--;
                }
            }
            if (i != 1) {
                if (!focusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                node2 = focusTargetNode.node.parent;
                layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                loop5: while (layoutNodeRequireLayoutNode != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                        while (node2 != null) {
                            if ((node2.kindSet & 1024) != 0) {
                                nodePop = node2;
                                mutableVector = null;
                                while (nodePop != null) {
                                    if (nodePop instanceof FocusTargetNode) {
                                        node = nodePop;
                                        break loop5;
                                    }
                                    if ((nodePop.kindSet & 1024) == 0) {
                                    }
                                    nodePop = HitTestResultKt.pop(mutableVector);
                                }
                            }
                            node2 = node2.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    if (layoutNodeRequireLayoutNode != null) {
                    }
                }
                if (node != null) {
                    return ((Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(focusTargetNode)).booleanValue();
                }
            }
            return false;
        }
        IntRange intRangeUntil2 = UuidKt.until(0, i2);
        int i8 = intRangeUntil2.first;
        int i9 = intRangeUntil2.last;
        if (i8 <= i9) {
            boolean z2 = false;
            while (true) {
                if (z2) {
                    FocusTargetNode focusTargetNode5 = (FocusTargetNode) objArr[i8];
                    if (isEligibleForFocusSearch(focusTargetNode5) && forwardFocusSearch(focusTargetNode5, utilsKt$$ExternalSyntheticLambda0)) {
                        return true;
                    }
                }
                if (Intrinsics.areEqual(objArr[i8], focusTargetNode2)) {
                    z2 = true;
                }
                if (i8 == i9) {
                    break;
                }
                i8++;
            }
        }
        if (i != 1 && focusTargetNode.fetchFocusProperties$ui().canFocus) {
            if (!focusTargetNode.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            node2 = focusTargetNode.node.parent;
            layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
            loop5: while (layoutNodeRequireLayoutNode != null) {
                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                    while (node2 != null) {
                        if ((node2.kindSet & 1024) != 0) {
                            nodePop = node2;
                            mutableVector = null;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    node = nodePop;
                                    break loop5;
                                }
                                if ((nodePop.kindSet & 1024) == 0 && (nodePop instanceof DelegatingNode)) {
                                    int i10 = 0;
                                    for (Modifier.Node node6 = ((DelegatingNode) nodePop).delegate; node6 != null; node6 = node6.child) {
                                        if ((node6.kindSet & 1024) != 0) {
                                            i10++;
                                            if (i10 == 1) {
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
                                        }
                                    }
                                    if (i10 == 1) {
                                    }
                                }
                                nodePop = HitTestResultKt.pop(mutableVector);
                            }
                        }
                        node2 = node2.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node2 = (layoutNodeRequireLayoutNode != null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
            }
            if (node != null) {
                return ((Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(focusTargetNode)).booleanValue();
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: twoDimensionalFocusSearch-sMXa3k8, reason: not valid java name */
    public static final Boolean m431twoDimensionalFocusSearchsMXa3k8(int i, FocusTargetNode focusTargetNode, Rect rect, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        int iOrdinal = focusTargetNode.getFocusState$1().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ActiveParent must have a focusedChild");
                    return null;
                }
                int iOrdinal2 = activeChild.getFocusState$1().ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        Boolean boolM431twoDimensionalFocusSearchsMXa3k8 = m431twoDimensionalFocusSearchsMXa3k8(i, activeChild, rect, utilsKt$$ExternalSyntheticLambda0);
                        if (!Intrinsics.areEqual(boolM431twoDimensionalFocusSearchsMXa3k8, Boolean.FALSE)) {
                            return boolM431twoDimensionalFocusSearchsMXa3k8;
                        }
                        if (rect == null) {
                            if (activeChild.getFocusState$1() != FocusStateImpl.ActiveParent) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Searching for active node in inactive hierarchy");
                                return null;
                            }
                            FocusTargetNode focusTargetNodeFindActiveFocusNode = findActiveFocusNode(activeChild);
                            if (focusTargetNodeFindActiveFocusNode == null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ActiveParent must have a focusedChild");
                                return null;
                            }
                            rect = focusRect(focusTargetNodeFindActiveFocusNode);
                        }
                        return Boolean.valueOf(m422generateAndSearchChildren4C6V_qg(i, focusTargetNode, rect, utilsKt$$ExternalSyntheticLambda0));
                    }
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ActiveParent must have a focusedChild");
                        return null;
                    }
                }
                if (rect == null) {
                    rect = focusRect(activeChild);
                }
                return Boolean.valueOf(m422generateAndSearchChildren4C6V_qg(i, focusTargetNode, rect, utilsKt$$ExternalSyntheticLambda0));
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                if (focusTargetNode.fetchFocusProperties$ui().canFocus) {
                    return (Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(focusTargetNode);
                }
                return rect == null ? Boolean.valueOf(m421findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, utilsKt$$ExternalSyntheticLambda0)) : Boolean.valueOf(m429searchChildren4C6V_qg(i, focusTargetNode, rect, utilsKt$$ExternalSyntheticLambda0));
            }
        }
        return Boolean.valueOf(m421findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, utilsKt$$ExternalSyntheticLambda0));
    }

    /* JADX INFO: renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m422generateAndSearchChildren4C6V_qg(int i, FocusTargetNode focusTargetNode, Rect rect, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        if (m429searchChildren4C6V_qg(i, focusTargetNode, rect, utilsKt$$ExternalSyntheticLambda0)) {
            return true;
        }
        Boolean bool = (Boolean) m428searchBeyondBoundsOMvw8(focusTargetNode, i, new ExposedDropdownMenuKt$$ExternalSyntheticLambda1(((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode(), focusTargetNode, rect, i, utilsKt$$ExternalSyntheticLambda0));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m429searchChildren4C6V_qg(int i, FocusTargetNode focusTargetNode, Rect rect, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        FocusTargetNode focusTargetNodeM420findBestCandidate4WY_MpI;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16]);
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.addLayoutNodeChildren(mutableVector2, node);
        } else {
            mutableVector2.add(node2);
        }
        while (true) {
            int i2 = mutableVector2.size;
            if (i2 == 0) {
                break;
            }
            Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(i2 - 1);
            if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.addLayoutNodeChildren(mutableVector2, nodePop);
            } else {
                while (nodePop != null) {
                    if ((nodePop.kindSet & 1024) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.isAttached) {
                                    mutableVector.add(focusTargetNode2);
                                }
                            } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i3++;
                                        if (i3 == 1) {
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
                                if (i3 == 1) {
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
        while (mutableVector.size != 0 && (focusTargetNodeM420findBestCandidate4WY_MpI = m420findBestCandidate4WY_MpI(mutableVector, rect, i)) != null) {
            if (focusTargetNodeM420findBestCandidate4WY_MpI.fetchFocusProperties$ui().canFocus) {
                return ((Boolean) utilsKt$$ExternalSyntheticLambda0.invoke(focusTargetNodeM420findBestCandidate4WY_MpI)).booleanValue();
            }
            if (m422generateAndSearchChildren4C6V_qg(i, focusTargetNodeM420findBestCandidate4WY_MpI, rect, utilsKt$$ExternalSyntheticLambda0)) {
                return true;
            }
            mutableVector.remove(focusTargetNodeM420findBestCandidate4WY_MpI);
        }
        return false;
    }
}
