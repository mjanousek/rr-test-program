package cz.janousek;

/**
 * Created by martin on 9.2.17.
 */
public class TestProgram extends Thread{

	public volatile Dummy d;

	public TestProgram() {
		this.d = new Dummy(0);
	}

	@Override
	public void run(){
		ChildThread c1 = new ChildThread(d);
		ChildThread c2 = new ChildThread(d);

		c1.start();
		c2.start();
		try {
			c1.join();
			c2.join();
		}catch (Exception e){

		}
	}

	/**
	 * Dummy class
	 */
	public class Dummy{
		public int d;

		public Dummy(int d){
			this.d = d;
		}

		public void dummyMethod(){
			System.out.println("Dummy: " + this.toString());
		}
	}

	/**
	 * Child Thread
	 */
	public class ChildThread extends Thread{
		//        static final int ITERS = 3;
//        static int y = 0;
//
//        private int id;
		private Dummy d;

		public ChildThread(Dummy d){
			this.d = d;
		}
//
//        public void testingType(){
//            y--;
//        }
//
//        public void inc() {
//            y++;
//        }

		@Override
		public void run() {
			System.out.println("My: Thread " + this.toString());
			d.dummyMethod();
		}
	}
}
