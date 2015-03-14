package Chapter2;

public class MaxPQ<Key extends Comparable<Key>> {
	
	Key[] pq=null;
	private int N=0;
	public MaxPQ() {}
	
	public MaxPQ(int max){}
	
	public MaxPQ(Key[] a){}
	
	public void Insert(){}
	
	public Key delMax(){
		return null;
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	public int size(){
		return 0;
	}
	
	private boolean less(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	
	private void exchange(int i,int j){
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}
	
	private void swim(int k){
		while(k>1 && less(k/2,k)){
			exchange(k/2, k);
			k=k/2;
		}
	}
	
	private void sink(int k){
		while(k*2<=N){
			int j=k*2;
			if(j<N && less(j,j+1)) j++;
			if(!less(k,j)) break;
			exchange(k, j);
			k=j;
		}
	}
}
