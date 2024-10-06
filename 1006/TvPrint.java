package OpenChallenge3;

public class TvPrint {
	static class TV {
	    // 필드 정의
	    private String brand;
	    private int size;
	    private int price;

	    // 생성자
	    public TV(String brand, int size, int price) {
	        this.brand = brand;
	        this.size = size;
	        this.price = price;
	    }

	    // 정보를 출력하는 메소드
	    public void show() {
	        System.out.println(brand + "에서 만든 " + price + "만원 짜리 " + size + "인치 tv");
	    }

	    // 메인 메소드
	    public static void main(String[] args) {
	        TV tv = new TV("Samsung", 50, 300);
	        tv.show();
	    }
	}

}
