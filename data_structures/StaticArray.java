package data_structures;
class StaticArray{
    public static void main(String args[]){
        int arr[] = {1,2,4,2,5,7,4,6,6,8,3,1};
        for (int a : arr) {
            System.out.printf("%d%c",a,'\t');
        }
        System.out.println();
        System.out.println(arr[3]);
    }
}