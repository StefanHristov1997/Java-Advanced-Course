package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> armorDeque = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(armorDeque::offer);

        ArrayDeque<Integer> soldierImpactStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(soldierImpactStack::push);

        int killedMonsters = 0;

        while (!armorDeque.isEmpty() && !soldierImpactStack.isEmpty()) {
            int firstMonsterArmor = armorDeque.peek();
            int lastStrike = soldierImpactStack.peek();

            if(firstMonsterArmor== 0 && lastStrike == 0){
                armorDeque.poll();
                soldierImpactStack.pop();
            }

            if (lastStrike >= firstMonsterArmor) {
                killedMonsters++;
                armorDeque.poll();

                int strikeLeft = lastStrike - firstMonsterArmor;

                if(strikeLeft== 0){
                    soldierImpactStack.pop();
                }else{
                    int remainingAttack = soldierImpactStack.pop() - firstMonsterArmor;
                    if(!soldierImpactStack.isEmpty()){
                        int nextStrike = soldierImpactStack.pop() + remainingAttack;
                        soldierImpactStack.push(nextStrike);
                    }else{
                        soldierImpactStack.push(remainingAttack);
                    }
                }
            } else {
                soldierImpactStack.pop();
                firstMonsterArmor -= lastStrike;
                if(firstMonsterArmor == 0){
                    armorDeque.poll();
                }else{
                    armorDeque.poll();
                    armorDeque.offer(firstMonsterArmor);
                }
            }

        }

        if(soldierImpactStack.isEmpty() && armorDeque.isEmpty()){
            System.out.println("All monsters have been killed!");
            System.out.println("The soldier has been defeated.");
            System.out.println("Total monsters killed: " + killedMonsters);
            return;
        }

        if (armorDeque.isEmpty()) {
            System.out.println("All monsters have been killed!");
            System.out.println("Total monsters killed: " + killedMonsters);
        } else {
            System.out.println("The soldier has been defeated.");
            System.out.println("Total monsters killed: " + killedMonsters);
        }
    }
}

