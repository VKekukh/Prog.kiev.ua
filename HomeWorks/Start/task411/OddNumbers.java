package net.ukr.p454.task411;

/* ��� ������ {0,5,2,4,7,1,3,19} � �������� ��������� ��� �������� �������� ���� � ���. */
public class OddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array  ={0,5,2,4,7,1,3,19};
		
		int counter = 0;
		
		System.out.println("Odd numbers: " );
		for (int j : array) {
			if (j%2 != 0) {
				System.out.print(j + " ");
				counter++;
			}
		}
		System.out.println("");
		System.out.println("Amount of odd numbres:" + counter);
	}
	
}
