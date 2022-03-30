package ch03;

public class MainTest {

	public static void main(String[] args) {

		Television television = new Television();
		Refrigerator refrigerator = new Refrigerator();
		ToyRobot toyRobot = new ToyRobot();

//		television.turnOn();
//		refrigerator.turnOn();
//		toyRobot.turnOn();
//		System.out.println("----------");
//		television.turnOff();
//		refrigerator.turnOff();
//		toyRobot.turnOff();
		// 다형성

		RemoteController[] remoteControllers = new RemoteController[3];
		remoteControllers[0] = television;
		remoteControllers[1] = refrigerator;
		remoteControllers[2] = toyRobot;

		for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOn();
		}
		
		System.out.println("----------");

		for (int i = 0; i < remoteControllers.length; i++) {
			remoteControllers[i].turnOff();
		}

	}

}
