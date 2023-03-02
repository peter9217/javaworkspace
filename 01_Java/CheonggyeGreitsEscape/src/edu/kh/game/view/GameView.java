package edu.kh.game.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.game.dto.Building;
import edu.kh.game.dto.Player;
import edu.kh.game.service.Service;

public class GameView extends Building {
   Scanner sc = new Scanner(System.in);
   Service sv = new Service();
   Building bb = new Building();
   String name = "홍길동";
   int room = 1;
   int Floor =7;
   int input = 0;
   List<Player> list = sv.playerSelect(name);
   public void displayMenu() {
      while (true) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            Player s  = null;
            for (Player p : list) {
                  System.out.printf("┃체력 :%d 스태미나 : %d 현재 위치 -%dF- ┃\n", p.getHp(), p.getStamina(), p.getFloor());
                  s = p;
               System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
               System.out.println("┃                                    ┃");
               if(room > -1)
               System.out.printf ("┃      %4s에 들어왔습니다.      ┃\n", bb.getList().get(s.getFloor()-1).get(room-1));
               System.out.println("┃                                    ┃");
               System.out.println("┃       [선택지를 골라주세요.]       ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.printf ("┃        0. 아래 층(%dF)              ┃\n",s.getFloor()-1);
               System.out.println("┃                                    ┃");
               System.out.println("┃        9. 아이템 사용하기          ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
   
               System.out.println();
               System.out.print("행동 선택 -> ");
   
               input = sc.nextInt();
               sc.nextLine();
               room = input;
               System.out.println();
               switch (input) {
               case 0:
                  Floor6();
                  p.setFloor(1);
                  break;
               case 2:
                  Washroom();
                  break;
               case 3:
                  break;
               case 4:
                  break;
               case 5:
                  break;
               case 9:
                  break;
               default:
                  System.out.println("[잘못 입력하셨습니다. 행동을 선택해 주세요]");
               }
            System.out.println();
         }
      }
   }
   public void Floor6() {
      Player s  = null;
      for (Player p : list2) {
         s=p;
            while (true) {
               System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
               System.out.printf("┃체력 :%d 스태미나 : %d 현재 위치 -%dF- ┃\n", p.getHp(), p.getStamina(), p.getFloor());
               System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
               System.out.println("┃                                    ┃");
//               if(room > -1)
//                  System.out.printf ("┃         %s에 들어왔습니다.         ┃", bb.getList().get(s.getFloor()-1).get(room-1));
               System.out.printf ("┃        %d층에 입장하였습니다.       ┃\n", s.getFloor());
               System.out.println("┃                                    ┃");
               System.out.println("┃        1. 탕비실(휴개실)           ┃");
               System.out.println("┃        2. 화장실(20%)              ┃");
               System.out.println("┃        3. 사무실(80%)              ┃");
               System.out.println("┃        4. 휴게실(40%)              ┃");
               System.out.println("┃        5. 아래 층(50%)             ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃        9. 아이템 사용하기          ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
               System.out.println();
               System.out.print("행동 선택 -> ");
               input = sc.nextInt();
               sc.nextLine();
               
               room = input;
               System.out.println();
               switch (input) {
               case 1:
                  displayMenu();
                  break;
               default:
                  System.out.println("[잘못 입력하셨습니다. 행동을 선택해 주세요]");
               }
            }
      }
   }
   
   
   
   
   
   
   
   
   public void teaRoom() {
      List<Player> list2 = sv.playerSelect(name);
      for (Player s : list2) {
         if (s.getHp() == 5 && s.getStamina() == 3) {
            while (true) {
               System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
               System.out.printf("┃체력 :%d 스태미나 : %d 현재 위치 -%dF- ┃\n", s.getHp(), s.getStamina(), s.getFloor());
               System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
               System.out.println("┃                                    ┃");
               if(room > -1)
                  System.out.printf ("┃         %s에 들어왔습니다.         ┃", bb.getList().get(s.getFloor()-1).get(room-1));
               
               System.out.println("┃                                    ┃");
               System.out.println("┃        1. 탕비실(휴개실)           ┃");
               System.out.println("┃        2. 화장실(20%)              ┃");
               System.out.println("┃        3. 사무실(80%)              ┃");
               System.out.println("┃        4. 휴게실(40%)              ┃");
               System.out.println("┃        5. 아래 층(50%)             ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃        9. 아이템 사용하기          ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┃                                    ┃");
               System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
               System.out.println();
               System.out.print("행동 선택 -> ");
               input = sc.nextInt();
               sc.nextLine();
               
               room = input;
               System.out.println();
               switch (input) {
               case 1:
                  displayMenu();
                  break;
               default:
                  System.out.println("[잘못 입력하셨습니다. 행동을 선택해 주세요]");
               }
            }
         } else {
            while (true) {
               System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
               System.out.printf("┃체력 :%d 스태미나 : %d 현재 위치 -%dF- ┃\n", s.getHp(), s.getStamina(), s.getFloor());
               System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━┫");
               System.out.println("┃                      ┃-보유 아이템-┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃탕비실에 들어왔습니다.┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃(체력과 스태미나가    ┃             ┃");
               System.out.println("┃    회복 되었습니다.) ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃1. 돌아가기           ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┃                      ┃             ┃");
               System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━┛");
               System.out.println();
               System.out.print("행동 선택 -> ");
               input = sc.nextInt();
               sc.nextLine();
               System.out.println();
               switch (input) {
               case 1:
                  displayMenu();
                  break;
               default:
                  System.out.println("[잘못 입력하셨습니다. 행동을 선택해 주세요]");
               }
            }
         }
      }
   }

//   public void Washroom() {
//      List<Player> list2 = sv.playerSelect(name);
//      for (Player s : list2) {
//         if ((int)(Math.random() * 100)< 20) {
//            while (true) {
//               System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//               System.out.printf("┃체력 :%d 스태미나 : %d 현재 위치 -%dF- ┃\n", s.getHp(), s.getStamina(), s.getFloor());
//               System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━┫");
//               System.out.println("┃                      ┃-보유 아이템-┃");
//               System.out.println("┃화장실에 들어왔습니다.┃             ┃");
//               System.out.println("┃                      ┃             ┃");
//               System.out.println("┃ (화장실에 숨어 있던  ┃             ┃");
//               System.out.println("┃  평범한 좀비를       ┃             ┃");
//               System.out.println("┃  만났습니다. )       ┃             ┃");
//               System.out.println("┃                      ┃             ┃");
//               System.out.println("┃                      ┃             ┃");
//               System.out.println("┃      <선택지>        ┃             ┃");
//               System.out.println("┃                      ┃             ┃");
//               System.out.println("┃1. 공격한다.          ┃             ┃");
//               System.out.println("┃2. 도망간다.          ┃             ┃");
//               System.out.println("┃3. 아이템 사용        ┃             ┃");
//               System.out.println("┃                      ┃             ┃");
//               System.out.println("┃                      ┃             ┃");
//               System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━┛");
//               System.out.println();
//               System.out.print("행동 선택 -> ");
//               input = sc.nextInt();
//               sc.nextLine();
//               System.out.println();
//               switch (input) {
//               case 1:
//                  break;
//               case 2:
//                  displayMenu();
//                  break;
//               case 3:
//                  displayMenu();
//                  break;
//               default:
//                  System.out.println("[잘못 입력하셨습니다. 행동을 선택해 주세요]");
//               }
//            }
//         }else {
//               while (true) {
//                  System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//                  System.out.printf("┃체력 :%d 스태미나 : %d 현재 위치 -%dF- ┃\n", s.getHp(), s.getStamina(), s.getFloor());
//                  System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━┫");
//                  System.out.println("┃                      ┃-보유 아이템-┃");
//                  System.out.println("┃화장실에 들어왔습니다.┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┃ (화장실에서  붕대를  ┃             ┃");
//                  System.out.println("┃  획득 하였습니다. )  ┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┃      <선택지>        ┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┃1. 돌아간다.          ┃             ┃");
//                  System.out.println("┃2. 아이템 사용        ┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┃                      ┃             ┃");
//                  System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━┛");
//                  System.out.println();
//                  System.out.print("행동 선택 -> ");
//                  input = sc.nextInt();
//                  sc.nextLine();
//                  System.out.println();
//                  switch (input) {
//                  case 1:
//                     displayMenu();
//                     break;
//                  case 2:
//                     break;
//                  default:
//                     System.out.println("[잘못 입력하셨습니다. 행동을 선택해 주세요]");
//               }
//            }
//         }
//      }
//   }
	
	public void zom() {
		service.attack();
		service.run();
	}
	
	
	
}




