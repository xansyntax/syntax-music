package com.atilika.kuromoji.viterbi;

import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.dict.CharacterDefinitions;
import com.atilika.kuromoji.dict.TokenInfoDictionary;
import com.atilika.kuromoji.dict.UnknownDictionary;
import com.atilika.kuromoji.dict.UserDictionary;
import com.atilika.kuromoji.trie.DoubleArrayTrie;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ViterbiBuilder {
    private final CharacterDefinitions characterDefinitions;
    private final TokenInfoDictionary dictionary;
    private boolean searchMode;
    private final DoubleArrayTrie trie;
    private final UnknownDictionary unknownDictionary;
    private final boolean useUserDictionary;
    private final UserDictionary userDictionary;

    public ViterbiBuilder(DoubleArrayTrie doubleArrayTrie, TokenInfoDictionary tokenInfoDictionary, UnknownDictionary unknownDictionary, UserDictionary userDictionary, TokenizerBase.Mode mode) {
        this.trie = doubleArrayTrie;
        this.dictionary = tokenInfoDictionary;
        this.unknownDictionary = unknownDictionary;
        this.userDictionary = userDictionary;
        this.useUserDictionary = userDictionary != null;
        if (mode == TokenizerBase.Mode.SEARCH || mode == TokenizerBase.Mode.EXTENDED) {
            this.searchMode = true;
        }
        this.characterDefinitions = unknownDictionary.getCharacterDefinition();
    }

    private ViterbiNode createGlueNode(int i, ViterbiNode viterbiNode, String str) {
        return new ViterbiNode(viterbiNode.getWordId(), str, viterbiNode.getLeftId(), viterbiNode.getRightId(), viterbiNode.getWordCost(), i, ViterbiNode.Type.INSERTED);
    }

    private ViterbiNode findGlueNodeCandidate(int i, ViterbiNode[] viterbiNodeArr, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (ViterbiNode viterbiNode : viterbiNodeArr) {
            if (viterbiNode != null) {
                arrayList.add(viterbiNode);
            }
        }
        if (!arrayList.isEmpty()) {
            int i4 = (i + 1) - i2;
            int size = arrayList.size();
            ViterbiNode viterbiNode2 = null;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ViterbiNode viterbiNode3 = (ViterbiNode) obj;
                if (isAcceptableCandidate(i4, viterbiNode2, viterbiNode3)) {
                    viterbiNode2 = viterbiNode3;
                }
            }
            if (viterbiNode2 != null) {
                return viterbiNode2;
            }
        }
        return null;
    }

    private boolean isAcceptableCandidate(int i, ViterbiNode viterbiNode, ViterbiNode viterbiNode2) {
        return (viterbiNode == null || viterbiNode2.getSurface().length() < viterbiNode.getSurface().length()) && viterbiNode2.getSurface().length() >= i;
    }

    private boolean isLatticeBrokenAfter(int i, ViterbiLattice viterbiLattice) {
        return viterbiLattice.getStartIndexArr()[i] == null;
    }

    private boolean isLatticeBrokenBefore(int i, ViterbiLattice viterbiLattice) {
        return viterbiLattice.getEndIndexArr()[i] == null;
    }

    private boolean processIndex(ViterbiLattice viterbiLattice, int i, String str) {
        int i2;
        boolean z = false;
        int i3 = 1;
        while (i3 < str.length() + 1) {
            String strSubstring = str.substring(0, i3);
            int iLookup = this.trie.lookup(strSubstring, 0, 0);
            if (iLookup > 0) {
                int[] iArrLookupWordIds = this.dictionary.lookupWordIds(iLookup);
                int length = iArrLookupWordIds.length;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i;
                    int i6 = i5 + 1;
                    viterbiLattice.addNode(new ViterbiNode(iArrLookupWordIds[i4], strSubstring, this.dictionary, i5, ViterbiNode.Type.KNOWN), i6, i6 + i3);
                    i4++;
                    i = i5;
                }
                i2 = i;
                z = true;
            } else {
                i2 = i;
                if (iLookup < 0) {
                    break;
                }
            }
            i3++;
            i = i2;
        }
        return z;
    }

    private int processUnknownWord(int i, int i2, ViterbiLattice viterbiLattice, int i3, int i4, String str, boolean z) {
        int[] iArrLookupDefinition = this.characterDefinitions.lookupDefinition(i);
        int i5 = 1;
        if (iArrLookupDefinition[0] != 1 && z) {
            i5 = 0;
        } else if (iArrLookupDefinition[1] != 0) {
            int i6 = 1;
            while (i5 < str.length()) {
                int[] iArrLookupCategories = this.characterDefinitions.lookupCategories(str.charAt(i5));
                if (iArrLookupCategories == null || i2 >= iArrLookupCategories.length || i != iArrLookupCategories[i2]) {
                    break;
                }
                i6++;
                i5++;
            }
            i5 = i6;
        }
        if (i5 <= 0) {
            return i3;
        }
        String strSubstring = str.substring(0, i5);
        for (int i7 : this.unknownDictionary.lookupWordIds(i)) {
            int i8 = i4 + 1;
            viterbiLattice.addNode(new ViterbiNode(i7, strSubstring, this.unknownDictionary, i4, ViterbiNode.Type.UNKNOWN), i8, i8 + i5);
        }
        return i4 + i5;
    }

    private void processUserDictionary(String str, ViterbiLattice viterbiLattice) {
        for (UserDictionary.UserDictionaryMatch userDictionaryMatch : this.userDictionary.findUserDictionaryMatches(str)) {
            int wordId = userDictionaryMatch.getWordId();
            int matchStartIndex = userDictionaryMatch.getMatchStartIndex();
            int matchLength = userDictionaryMatch.getMatchLength();
            ViterbiNode viterbiNode = new ViterbiNode(wordId, str.substring(matchStartIndex, matchStartIndex + matchLength), this.userDictionary, matchStartIndex, ViterbiNode.Type.USER);
            int i = matchStartIndex + 1;
            int i2 = matchLength + i;
            viterbiLattice.addNode(viterbiNode, i, i2);
            if (isLatticeBrokenBefore(i, viterbiLattice)) {
                repairBrokenLatticeBefore(viterbiLattice, matchStartIndex);
            }
            if (isLatticeBrokenAfter(i2, viterbiLattice)) {
                repairBrokenLatticeAfter(viterbiLattice, i2);
            }
        }
    }

    private void repairBrokenLatticeAfter(ViterbiLattice viterbiLattice, int i) {
        ViterbiNode viterbiNodeFindGlueNodeCandidate;
        ViterbiNode[][] endIndexArr = viterbiLattice.getEndIndexArr();
        for (int i2 = i + 1; i2 < endIndexArr.length; i2++) {
            ViterbiNode[] viterbiNodeArr = endIndexArr[i2];
            if (viterbiNodeArr != null && (viterbiNodeFindGlueNodeCandidate = findGlueNodeCandidate(i, viterbiNodeArr, i2)) != null) {
                String surface = viterbiNodeFindGlueNodeCandidate.getSurface();
                ViterbiNode viterbiNodeCreateGlueNode = createGlueNode(i, viterbiNodeFindGlueNodeCandidate, surface.substring(surface.length() - (i2 - i)));
                viterbiLattice.addNode(viterbiNodeCreateGlueNode, i, viterbiNodeCreateGlueNode.getSurface().length() + i);
                return;
            }
        }
    }

    private void repairBrokenLatticeBefore(ViterbiLattice viterbiLattice, int i) {
        ViterbiNode viterbiNodeFindGlueNodeCandidate;
        ViterbiNode[][] startIndexArr = viterbiLattice.getStartIndexArr();
        for (int i2 = i; i2 > 0; i2--) {
            ViterbiNode[] viterbiNodeArr = startIndexArr[i2];
            if (viterbiNodeArr != null && (viterbiNodeFindGlueNodeCandidate = findGlueNodeCandidate(i, viterbiNodeArr, i2)) != null) {
                ViterbiNode viterbiNodeCreateGlueNode = createGlueNode(i2, viterbiNodeFindGlueNodeCandidate, viterbiNodeFindGlueNodeCandidate.getSurface().substring(0, (i + 1) - i2));
                viterbiLattice.addNode(viterbiNodeCreateGlueNode, i2, viterbiNodeCreateGlueNode.getSurface().length() + i2);
                return;
            }
        }
    }

    public ViterbiLattice build(String str) {
        int length = str.length();
        ViterbiLattice viterbiLattice = new ViterbiLattice(length + 2);
        viterbiLattice.addBos();
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (viterbiLattice.tokenEndsWhereCurrentTokenStarts(i2)) {
                String strSubstring = str.substring(i2);
                boolean zProcessIndex = processIndex(viterbiLattice, i2, strSubstring);
                if (this.searchMode || i <= i2) {
                    int[] iArrLookupCategories = this.characterDefinitions.lookupCategories(strSubstring.charAt(0));
                    int iProcessUnknownWord = i;
                    for (int i3 = 0; i3 < iArrLookupCategories.length; i3++) {
                        iProcessUnknownWord = processUnknownWord(iArrLookupCategories[i3], i3, viterbiLattice, iProcessUnknownWord, i2, strSubstring, zProcessIndex);
                    }
                    i = iProcessUnknownWord;
                }
            }
        }
        if (this.useUserDictionary) {
            processUserDictionary(str, viterbiLattice);
        }
        viterbiLattice.addEos();
        return viterbiLattice;
    }
}
