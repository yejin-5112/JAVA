package OpenChallenge4;

abstract class Box{
	
	protected int size; //현재 박스에 들어 있는 재료의 양
	public Box(int size) { //생성자
		this.size = size;
	}
	public boolean isEmpty() {return size == 0;} //박스가 빈 경우 true 리턴
	public abstract boolean consume(); //박스에 들어 있는 재료를 일정량 소비
	public abstract void print(); //박스에 들어 있는 량을 "*"문자로 출
}
