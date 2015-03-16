package example.chapter2;

public class SelectionSort extends AbstractSort{
	@Override
	public void sort(Comparable[] a) {
		int len=a.length;
		for(int i=0;i<len;i++){
			int min=i;
			for(int j=i;j<len;j++){
				if(less(a[j],a[min])){
					min=j;
				}
			}
			exchange(a, i, min);
		}
	}

}
