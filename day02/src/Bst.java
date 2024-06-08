import java.util.Arrays;

public class Bst {
    public Integer[] bstArray;
    public int data;
    int nowIndex;

    public void insert() {
        nowIndex = 1;
        //bst에 데이터를 넣는다

            //현재 트리를 돌며 대소관계 비교를 한다
            for (int i = 0; i < bstArray.length; i++) {
                if (bstArray[nowIndex] == null){
                    bstArray[nowIndex] = data;

                }else if (bstArray[nowIndex] != null && bstArray[nowIndex] > data ){
                    nowIndex *= 2;
                }else if(bstArray[nowIndex] < data && bstArray[nowIndex] != null){
                    nowIndex = nowIndex*2+1;
                }

        }
    }

    public void bstPrint(){
        System.out.println(Arrays.stream(bstArray).toList());
    }
}
