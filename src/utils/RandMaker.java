package utils;

public class RandMaker {
	public static Integer[] makeInts(int length){
		Integer[] array=new Integer[length];
		for(int i=0;i<array.length;i++){
			int nextInt=(int)(Math.random()*1000);
			array[i]=new Integer(nextInt);
		}
		return array;
	}
	
	public static Double[] makeDoubles(int length){
		Double[] array=new Double[length];
		for(int i=0;i<array.length;i++){
			Double nextDouble=Math.random()*1000;
			array[i]=new Double(nextDouble);
		}
		return array;
	}
	
	public static Integer nextInt(int max){
		return (int)(Math.random()*max);
	}
	
	public static Double nextDouble(int max){
		return Math.random()*max;
	}
	
	public static Integer nextInt(){
		return (int)(Math.random()*1000);
	}
	
	public static Double nextDouble(){
		return Math.random()*1000;
	}
}
