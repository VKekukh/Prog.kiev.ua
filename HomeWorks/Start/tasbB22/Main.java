public class Main {
	public static void main(String[] args) {
		int days = 392;
		int year = (days + 359)/ 360;
		int month = (((days + 359)%360)+30)/30;
		int day = (((days + 359)%360)+30)%30+1;
		System.out.println("Year: " + year +  "; Month:" + month + "; Day:" + day);
	}
}