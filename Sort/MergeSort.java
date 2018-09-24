import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] st=new int[]{-1,5,2,3,0};
        MergeSort(st,0,st.length-1);
        for (int i=0;i<st.length;i++) {
            System.out.print(st[i]+ " ");
        }
    }

    public static void MergeSort(int[] s,int p, int r) {
        if(p<r) {
            int q=(int)Math.floor((p+r)/2);
            MergeSort(s,p,q);
            MergeSort(s,q+1,r);
            Merge(s,p,q,r);
        }
    }

    public static void Merge(int[] s, int p,int q, int r){
        ArrayList left=new ArrayList();
        ArrayList right=new ArrayList();
        int i=0;
        int j=0;
        for(i=p;i<=q;i++){
            left.add(s[i]);
        }
        for(j=q+1;j<=r;j++){
            right.add(s[j]);
        }
        left.add(2^31);
        right.add(2^31);
        int k=0;
        i=0;
        j=0;
        for(k=p;k<=r;k++){
            int le= (int) left.get(i);
            int ri=(int)right.get(j);
            if (le<=ri){
                s[k]=le;
                i+=1;
            }else{
                s[k]=ri;
                j+=1;
            }
        }
    }
}
