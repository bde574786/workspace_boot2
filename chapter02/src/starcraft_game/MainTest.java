package starcraft_game;

import starcraft_game.protoss.GateWay;
import starcraft_game.protoss.Porge;
import starcraft_game.protoss.Protoss;
import starcraft_game.terran.Barrack;
import starcraft_game.terran.Terran;
import starcraft_game.zerg.Hatchery;
import starcraft_game.zerg.Zerg;

public class MainTest {

	public static void main(String[] args) {
		// 게이트 생성
		// 생산된 유닛 12마리를 배열에 담아주세요!!!
		GateWay gateway = new GateWay();
		Barrack barrack = new Barrack();
		Hatchery hatchery = new Hatchery();
		
		
		// for -- 배열에 담을 수 있다
		
		gateway.createProtossUnit();
		
		Porge porge = new Porge();
		porge.upgradeAttack();
//		barrack.createTerranUnit();
//		hatchery.createZergUnit();
		
		
		// 테란 (배럭)
		// fireBat, Marine
		
		//저그 ( Hatchery )
		// Hydra, Ultra, 저글링
		
		}
		
	}

