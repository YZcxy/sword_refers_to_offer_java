//二叉搜索树的后序遍历
public class No24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)return false;
        return verifyOfBST(sequence,0,sequence.length-1);
    }

    public boolean verifyOfBST(int[] sequence,int begin,int end){
        if(begin == end)return true;

        int newBegin=begin;
        while (newBegin<end && sequence[newBegin] < sequence[end]){
            newBegin++;
        }

        for(int i=newBegin;i<end;i++){
            if(sequence[i] < sequence[end])
                return false;
        }

        if(newBegin == begin){
            return verifyOfBST(sequence,newBegin,end-1);
        }else if(newBegin == end){
            return verifyOfBST(sequence,begin,end-1);
        }else {
            return verifyOfBST(sequence,begin,newBegin-1)&&verifyOfBST(sequence,newBegin,end-1);
        }
    }
}
